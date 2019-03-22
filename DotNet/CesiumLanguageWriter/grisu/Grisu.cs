// Copyright 2010 the V8 project authors. All rights reserved.
// Copyright 2011-2012, Kevin Ring. All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     * Redistributions of source code must retain the above copyright
//       notice, this list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above
//       copyright notice, this list of conditions and the following
//       disclaimer in the documentation and/or other materials provided
//       with the distribution.
//     * Neither the name of Google Inc. nor the names of its
//       contributors may be used to endorse or promote products derived
//       from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

using System;
using System.Diagnostics;
using System.Globalization;
using System.IO;
// ReSharper disable All

namespace GrisuDotNet
{
    [CSToJavaExclude]
    internal static class Grisu
    {
        [ThreadStatic]
        private static char[] ts_decimal_rep;

        public static void DoubleToString(double value, TextWriter writer)
        {
            if (value < 0.0)
            {
                writer.Write('-');
                value = -value;
            }

            GrisuDouble grisuDouble = new GrisuDouble(value);
            if (grisuDouble.IsSpecial)
            {
                HandleSpecialValues(ref grisuDouble, writer);
                return;
            }

            char[] decimal_rep = ts_decimal_rep;
            if (decimal_rep == null)
                decimal_rep = ts_decimal_rep = new char[kBase10MaximalLength + 1];

            int decimal_point;
            int decimal_rep_length;

            if (!DoubleToShortestAscii(ref grisuDouble, decimal_rep, out decimal_rep_length, out decimal_point))
            {
                writer.Write(string.Format(CultureInfo.InvariantCulture, "{0:R}", value));
                return;
            }

            int decimalRepLength = decimal_rep_length;
            if (decimal_point < 1)
            {
                decimalRepLength += -decimal_point + 1;
            }
            else if (decimal_point >= decimal_rep_length)
            {
                decimalRepLength += decimal_point - decimal_rep_length;
            }

            int exponent = decimal_point - 1;
            int absExponent = Math.Abs(exponent);
            int exponentRepLength = decimal_rep_length + 2; // one for 'e' and one for first exponent digit
            if (exponent < 0)
                ++exponentRepLength; // additional one for '-'
            if (absExponent >= 10)
            {
                ++exponentRepLength; // additional one for second exponent digit
                if (absExponent >= 100)
                    ++exponentRepLength; // additional one for third exponent digit
            }

            if (decimalRepLength <= exponentRepLength)
            {
                CreateDecimalRepresentation(decimal_rep, decimal_rep_length,
                                            decimal_point,
                                            Math.Max(0, decimal_rep_length - decimal_point),
                                            writer);
            }
            else
            {
                CreateExponentialRepresentation(decimal_rep, decimal_rep_length, exponent,
                                                writer);
            }
        }

        // The maximal number of digits that are needed to emit a double in base 10.
        // A higher precision can be achieved by using more digits, but the shortest
        // accurate representation of any double will never use more digits than
        // kBase10MaximalLength.
        // Note that DoubleToAscii null-terminates its input. So the given buffer
        // should be at least kBase10MaximalLength + 1 characters long.
        private const int kBase10MaximalLength = 17;

        private const string infinity_symbol_ = "Infinity";
        private const string nan_symbol_ = "NaN";
        private const char exponent_character_ = 'e';

        private static void HandleSpecialValues(
            ref GrisuDouble double_inspect,
            TextWriter writer)
        {
            if (double_inspect.IsInfinite)
            {
                if (double_inspect.Value < 0)
                {
                    writer.Write('-');
                }
                writer.Write(infinity_symbol_);
                return;
            }
            if (double_inspect.IsNaN)
            {
                writer.Write(nan_symbol_);
                return;
            }
        }

        private static bool DoubleToShortestAscii(ref GrisuDouble v, char[] buffer, out int length, out int point)
        {
            Debug.Assert(!v.IsSpecial);
            Debug.Assert(v.Value >= 0.0);

            double value = v.Value;

            if (value == 0.0)
            {
                buffer[0] = '0';
                buffer[1] = '\0';
                length = 1;
                point = 1;
                return true;
            }

            int decimal_exponent;
            bool result = Grisu3(ref v, buffer, out length, out decimal_exponent);
            if (result)
            {
                point = length + decimal_exponent;
            }
            else
            {
                point = 0;
            }
            return result;
        }

        // The minimal and maximal target exponent define the range of w's binary
        // exponent, where 'w' is the result of multiplying the input by a cached power
        // of ten.
        //
        // A different range might be chosen on a different platform, to optimize digit
        // generation, but a smaller range requires more powers of ten to be cached.
        private const int kMinimalTargetExponent = -60;
        private const int kMaximalTargetExponent = -32;

        // Provides a decimal representation of v.
        // Returns true if it succeeds, otherwise the result cannot be trusted.
        // There will be *length digits inside the buffer (not null-terminated).
        // If the function returns true then
        //        v == (double) (buffer * 10^decimal_exponent).
        // The digits in the buffer are the shortest representation possible: no
        // 0.09999999999999999 instead of 0.1. The shorter representation will even be
        // chosen even if the longer one would be closer to v.
        // The last digit will be closest to the actual v. That is, even if several
        // digits might correctly yield 'v' when read again, the closest will be
        // computed.
        private static bool Grisu3(ref GrisuDouble v,
                           char[] buffer,
                           out int length,
                           out int decimal_exponent)
        {
            DiyFp w = v.AsNormalizedDiyFp();
            // boundary_minus and boundary_plus are the boundaries between v and its
            // closest floating-point neighbors. Any number strictly between
            // boundary_minus and boundary_plus will round to v when convert to a double.
            // Grisu3 will never output representations that lie exactly on a boundary.
            DiyFp boundary_minus, boundary_plus;
            v.NormalizedBoundaries(out boundary_minus, out boundary_plus);
            Debug.Assert(boundary_plus.E == w.E);
            DiyFp ten_mk;  // Cached power of ten: 10^-k
            int mk;        // -k
            int ten_mk_minimal_binary_exponent =
               kMinimalTargetExponent - (w.E + DiyFp.kSignificandSize);
            int ten_mk_maximal_binary_exponent =
               kMaximalTargetExponent - (w.E + DiyFp.kSignificandSize);
            PowersOfTenCache.GetCachedPowerForBinaryExponentRange(
                ten_mk_minimal_binary_exponent,
                ten_mk_maximal_binary_exponent,
                out ten_mk, out mk);
            Debug.Assert((kMinimalTargetExponent <= w.E + ten_mk.E +
                    DiyFp.kSignificandSize) &&
                   (kMaximalTargetExponent >= w.E + ten_mk.E +
                    DiyFp.kSignificandSize));
            // Note that ten_mk is only an approximation of 10^-k. A DiyFp only contains a
            // 64 bit significand and ten_mk is thus only precise up to 64 bits.

            // The DiyFp.Times procedure rounds its result, and ten_mk is approximated
            // too. The variable scaled_w (as well as scaled_boundary_minus/plus) are now
            // off by a small amount.
            // In fact: scaled_w - w*10^k < 1ulp (unit in the last place) of scaled_w.
            // In other words: let f = scaled_w.f() and e = scaled_w.e(), then
            //           (f-1) * 2^e < w*10^k < (f+1) * 2^e
            //DiyFp scaled_w = DiyFp.Times(ref w, ref ten_mk);
            w.Multiply(ref ten_mk);
            Debug.Assert(w.E ==
                   boundary_plus.E + ten_mk.E + DiyFp.kSignificandSize);
            // In theory it would be possible to avoid some recomputations by computing
            // the difference between w and boundary_minus/plus (a power of 2) and to
            // compute scaled_boundary_minus/plus by subtracting/adding from
            // scaled_w. However the code becomes much less readable and the speed
            // enhancements are not terriffic.
            //DiyFp scaled_boundary_minus = DiyFp.Times(ref boundary_minus, ref ten_mk);
            boundary_minus.Multiply(ref ten_mk);
            //DiyFp scaled_boundary_plus = DiyFp.Times(ref boundary_plus, ref ten_mk);
            boundary_plus.Multiply(ref ten_mk);

            // DigitGen will generate the digits of scaled_w. Therefore we have
            // v == (double) (scaled_w * 10^-mk).
            // Set decimal_exponent == -mk and pass it to DigitGen. If scaled_w is not an
            // integer than it will be updated. For instance if scaled_w == 1.23 then
            // the buffer will be filled with "123" und the decimal_exponent will be
            // decreased by 2.
            int kappa;
            bool result = DigitGen(ref boundary_minus, ref w, ref boundary_plus,
                                   buffer, out length, out kappa);
            decimal_exponent = -mk + kappa;
            return result;
        }

        // Generates the digits of input number w.
        // w is a floating-point number (DiyFp), consisting of a significand and an
        // exponent. Its exponent is bounded by kMinimalTargetExponent and
        // kMaximalTargetExponent.
        //       Hence -60 <= w.e() <= -32.
        //
        // Returns false if it fails, in which case the generated digits in the buffer
        // should not be used.
        // Preconditions:
        //  * low, w and high are correct up to 1 ulp (unit in the last place). That
        //    is, their error must be less than a unit of their last digits.
        //  * low.e() == w.e() == high.e()
        //  * low < w < high, and taking into account their error: low~ <= high~
        //  * kMinimalTargetExponent <= w.e() <= kMaximalTargetExponent
        // Postconditions: returns false if procedure fails.
        //   otherwise:
        //     * buffer is not null-terminated, but len contains the number of digits.
        //     * buffer contains the shortest possible decimal digit-sequence
        //       such that LOW < buffer * 10^kappa < HIGH, where LOW and HIGH are the
        //       correct values of low and high (without their error).
        //     * if more than one decimal representation gives the minimal number of
        //       decimal digits then the one closest to W (where W is the correct value
        //       of w) is chosen.
        // Remark: this procedure takes into account the imprecision of its input
        //   numbers. If the precision is not enough to guarantee all the postconditions
        //   then false is returned. This usually happens rarely (~0.5%).
        //
        // Say, for the sake of example, that
        //   w.e() == -48, and w.f() == 0x1234567890abcdef
        // w's value can be computed by w.f() * 2^w.e()
        // We can obtain w's integral digits by simply shifting w.f() by -w.e().
        //  -> w's integral part is 0x1234
        //  w's fractional part is therefore 0x567890abcdef.
        // Printing w's integral part is easy (simply print 0x1234 in decimal).
        // In order to print its fraction we repeatedly multiply the fraction by 10 and
        // get each digit. Example the first digit after the point would be computed by
        //   (0x567890abcdef * 10) >> 48. -> 3
        // The whole thing becomes slightly more complicated because we want to stop
        // once we have enough digits. That is, once the digits inside the buffer
        // represent 'w' we can stop. Everything inside the interval low - high
        // represents w. However we have to pay attention to low, high and w's
        // imprecision.
        private static bool DigitGen(ref DiyFp low,
                             ref DiyFp w,
                             ref DiyFp high,
                             char[] buffer,
                             out int length,
                             out int kappa)
        {
            Debug.Assert(low.E == w.E && w.E == high.E);
            Debug.Assert(low.F + 1 <= high.F - 1);
            Debug.Assert(kMinimalTargetExponent <= w.E && w.E <= kMaximalTargetExponent);
            // low, w and high are imprecise, but by less than one ulp (unit in the last
            // place).
            // If we remove (resp. add) 1 ulp from low (resp. high) we are certain that
            // the new numbers are outside of the interval we want the final
            // representation to lie in.
            // Inversely adding (resp. removing) 1 ulp from low (resp. high) would yield
            // numbers that are certain to lie in the interval. We will use this fact
            // later on.
            // We will now start by generating the digits within the uncertain
            // interval. Later we will weed out representations that lie outside the safe
            // interval and thus _might_ lie outside the correct interval.
            ulong unit = 1;
            DiyFp too_low = new DiyFp(low.F - unit, low.E);
            DiyFp too_high = new DiyFp(high.F + unit, high.E);
            // too_low and too_high are guaranteed to lie outside the interval we want the
            // generated number in.
            DiyFp unsafe_interval = DiyFp.Minus(ref too_high, ref too_low);
            // We now cut the input number into two parts: the integral digits and the
            // fractionals. We will not write any decimal separator though, but adapt
            // kappa instead.
            // Reminder: we are currently computing the digits (stored inside the buffer)
            // such that:   too_low < buffer * 10^kappa < too_high
            // We use too_high for the digit_generation and stop as soon as possible.
            // If we stop early we effectively round down.
            DiyFp one = new DiyFp((ulong)(1) << -w.E, w.E);
            // Division by one is a shift.
            uint integrals = (uint)(too_high.F >> -one.E);
            // Modulo by one is an and.
            ulong fractionals = too_high.F & (one.F - 1);
            uint divisor;
            int divisor_exponent_plus_one;
            BiggestPowerTen(integrals, DiyFp.kSignificandSize - (-one.E),
                            out divisor, out divisor_exponent_plus_one);
            kappa = divisor_exponent_plus_one;
            length = 0;
            // Loop invariant: buffer = too_high / 10^kappa  (integer division)
            // The invariant holds for the first iteration: kappa has been initialized
            // with the divisor exponent + 1. And the divisor is the biggest power of ten
            // that is smaller than integrals.
            ulong unsafeIntervalF = unsafe_interval.F;
            while (kappa > 0)
            {
                int digit = (int)(integrals / divisor);
                buffer[length] = (char)('0' + digit);
                ++length;
                integrals %= divisor;
                kappa--;
                // Note that kappa now equals the exponent of the divisor and that the
                // invariant thus holds again.
                ulong rest =
                    ((ulong)(integrals) << -one.E) + fractionals;
                // Invariant: too_high = buffer * 10^kappa + DiyFp(rest, one.e())
                // Reminder: unsafe_interval.e() == one.e()
                if (rest < unsafeIntervalF)
                {
                    // Rounding down (by not emitting the remaining digits) yields a number
                    // that lies within the unsafe interval.
                    too_high.Subtract(ref w);
                    return RoundWeed(buffer, length, too_high.F,
                                     unsafeIntervalF, rest,
                                     (ulong)(divisor) << -one.E, unit);
                }
                divisor /= 10;
            }

            // The integrals have been generated. We are at the point of the decimal
            // separator. In the following loop we simply multiply the remaining digits by
            // 10 and divide by one. We just need to pay attention to multiply associated
            // data (like the interval or 'unit'), too.
            // Note that the multiplication by 10 does not overflow, because w.e >= -60
            // and thus one.e >= -60.
            Debug.Assert(one.E >= -60);
            Debug.Assert(fractionals < one.F);
            Debug.Assert(0xFFFFFFFFFFFFFFFF / 10 >= one.F);
            while (true)
            {
                fractionals *= 10;
                unit *= 10;
                unsafe_interval.F *= 10;
                // Integer division by one.
                int digit = (int)(fractionals >> -one.E);
                buffer[length] = (char)('0' + digit);
                ++length;
                fractionals &= one.F - 1;  // Modulo by one.
                kappa--;
                if (fractionals < unsafe_interval.F)
                {
                    too_high.Subtract(ref w);
                    return RoundWeed(buffer, length, too_high.F * unit,
                                     unsafe_interval.F, fractionals, one.F, unit);
                }
            }
        }

        // Returns the biggest power of ten that is less than or equal to the given
        // number. We furthermore receive the maximum number of bits 'number' has.
        //
        // Returns power == 10^(exponent_plus_one-1) such that
        //    power <= number < power * 10.
        // If number_bits == 0 then 0^(0-1) is returned.
        // The number of bits must be <= 32.
        // Precondition: number < (1 << (number_bits + 1)).

        // Inspired by the method for finding an integer log base 10 from here:
        // http://graphics.stanford.edu/~seander/bithacks.html#IntegerLog10
        private static readonly uint[] kSmallPowersOfTen = new uint[]
        {
            0, 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000
        };

        static void BiggestPowerTen(uint number,
                                    int number_bits,
                                    out uint power,
                                    out int exponent_plus_one)
        {
            Debug.Assert(number < ((uint)(1) << (number_bits + 1)));
            // 1233/4096 is approximately 1/lg(10).
            int exponent_plus_one_guess = ((number_bits + 1) * 1233 >> 12);
            // We increment to skip over the first entry in the kPowersOf10 table.
            // Note: kPowersOf10[i] == 10^(i-1).
            exponent_plus_one_guess++;
            // We don't have any guarantees that 2^number_bits <= number.
            // TODO(floitsch): can we change the 'while' into an 'if'? We definitely see
            // number < (2^number_bits - 1), but I haven't encountered
            // number < (2^number_bits - 2) yet.
            while (number < kSmallPowersOfTen[exponent_plus_one_guess])
            {
                exponent_plus_one_guess--;
            }
            power = kSmallPowersOfTen[exponent_plus_one_guess];
            exponent_plus_one = exponent_plus_one_guess;
        }

        // Adjusts the last digit of the generated number, and screens out generated
        // solutions that may be inaccurate. A solution may be inaccurate if it is
        // outside the safe interval, or if we cannot prove that it is closer to the
        // input than a neighboring representation of the same length.
        //
        // Input: * buffer containing the digits of too_high / 10^kappa
        //        * the buffer's length
        //        * distance_too_high_w == (too_high - w).f() * unit
        //        * unsafe_interval == (too_high - too_low).f() * unit
        //        * rest = (too_high - buffer * 10^kappa).f() * unit
        //        * ten_kappa = 10^kappa * unit
        //        * unit = the common multiplier
        // Output: returns true if the buffer is guaranteed to contain the closest
        //    representable number to the input.
        //  Modifies the generated digits in the buffer to approach (round towards) w.
        static bool RoundWeed(char[] buffer,
                              int length,
                              ulong distance_too_high_w,
                              ulong unsafe_interval,
                              ulong rest,
                              ulong ten_kappa,
                              ulong unit)
        {
            ulong small_distance = distance_too_high_w - unit;
            ulong big_distance = distance_too_high_w + unit;
            // Let w_low  = too_high - big_distance, and
            //     w_high = too_high - small_distance.
            // Note: w_low < w < w_high
            //
            // The real w (* unit) must lie somewhere inside the interval
            // ]w_low; w_high[ (often written as "(w_low; w_high)")

            // Basically the buffer currently contains a number in the unsafe interval
            // ]too_low; too_high[ with too_low < w < too_high
            //
            //  too_high - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            //                     ^v 1 unit            ^      ^                 ^      ^
            //  boundary_high ---------------------     .      .                 .      .
            //                     ^v 1 unit            .      .                 .      .
            //   - - - - - - - - - - - - - - - - - - -  +  - - + - - - - - -     .      .
            //                                          .      .         ^       .      .
            //                                          .  big_distance  .       .      .
            //                                          .      .         .       .    rest
            //                              small_distance     .         .       .      .
            //                                          v      .         .       .      .
            //  w_high - - - - - - - - - - - - - - - - - -     .         .       .      .
            //                     ^v 1 unit                   .         .       .      .
            //  w ----------------------------------------     .         .       .      .
            //                     ^v 1 unit                   v         .       .      .
            //  w_low  - - - - - - - - - - - - - - - - - - - - -         .       .      .
            //                                                           .       .      v
            //  buffer --------------------------------------------------+-------+--------
            //                                                           .       .
            //                                                  safe_interval    .
            //                                                           v       .
            //   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -     .
            //                     ^v 1 unit                                     .
            //  boundary_low -------------------------                     unsafe_interval
            //                     ^v 1 unit                                     v
            //  too_low  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            //
            //
            // Note that the value of buffer could lie anywhere inside the range too_low
            // to too_high.
            //
            // boundary_low, boundary_high and w are approximations of the real boundaries
            // and v (the input number). They are guaranteed to be precise up to one unit.
            // In fact the error is guaranteed to be strictly less than one unit.
            //
            // Anything that lies outside the unsafe interval is guaranteed not to round
            // to v when read again.
            // Anything that lies inside the safe interval is guaranteed to round to v
            // when read again.
            // If the number inside the buffer lies inside the unsafe interval but not
            // inside the safe interval then we simply do not know and bail out (returning
            // false).
            //
            // Similarly we have to take into account the imprecision of 'w' when finding
            // the closest representation of 'w'. If we have two potential
            // representations, and one is closer to both w_low and w_high, then we know
            // it is closer to the actual value v.
            //
            // By generating the digits of too_high we got the largest (closest to
            // too_high) buffer that is still in the unsafe interval. In the case where
            // w_high < buffer < too_high we try to decrement the buffer.
            // This way the buffer approaches (rounds towards) w.
            // There are 3 conditions that stop the decrementation process:
            //   1) the buffer is already below w_high
            //   2) decrementing the buffer would make it leave the unsafe interval
            //   3) decrementing the buffer would yield a number below w_high and farther
            //      away than the current number. In other words:
            //              (buffer{-1} < w_high) && w_high - buffer{-1} > buffer - w_high
            // Instead of using the buffer directly we use its distance to too_high.
            // Conceptually rest ~= too_high - buffer
            // We need to do the following tests in this order to avoid over- and
            // underflows.
            Debug.Assert(rest <= unsafe_interval);
            while (rest < small_distance &&  // Negated condition 1
                   unsafe_interval - rest >= ten_kappa &&  // Negated condition 2
                   (rest + ten_kappa < small_distance ||  // buffer{-1} > w_high
                    small_distance - rest >= rest + ten_kappa - small_distance))
            {
                buffer[length - 1]--;
                rest += ten_kappa;
            }

            // We have approached w+ as much as possible. We now test if approaching w-
            // would require changing the buffer. If yes, then we have two possible
            // representations close to w, but we cannot decide which one is closer.
            if (rest < big_distance &&
                unsafe_interval - rest >= ten_kappa &&
                (rest + ten_kappa < big_distance ||
                 big_distance - rest > rest + ten_kappa - big_distance))
            {
                return false;
            }

            // Weeding test.
            //   The safe interval is [too_low + 2 ulp; too_high - 2 ulp]
            //   Since too_low = too_high - unsafe_interval this is equivalent to
            //      [too_high - unsafe_interval + 4 ulp; too_high - 2 ulp]
            //   Conceptually we have: rest ~= too_high - buffer
            return (2 * unit <= rest) && (rest <= unsafe_interval - 4 * unit);
        }

        private static void CreateDecimalRepresentation(
            char[] decimal_digits,
            int length,
            int decimal_point,
            int digits_after_point,
            TextWriter writer)
        {
            // Create a representation that is padded with zeros if needed.
            if (decimal_point <= 0)
            {
                // "0.00000decimal_rep".
                writer.Write('0');
                if (digits_after_point > 0)
                {
                    writer.Write('.');
                    writer.Write(new string('0', -decimal_point));
                    Debug.Assert(length <= digits_after_point - (-decimal_point));
                    writer.Write(decimal_digits, 0, length);
                    int remaining_digits = digits_after_point - (-decimal_point) - length;
                    writer.Write(new string('0', remaining_digits));
                }
            }
            else if (decimal_point >= length)
            {
                // "decimal_rep0000.00000" or "decimal_rep.0000"
                writer.Write(decimal_digits, 0, length);
                writer.Write(new string('0', decimal_point - length));
                if (digits_after_point > 0)
                {
                    writer.Write('.');
                    writer.Write(new string('0', digits_after_point));
                }
            }
            else
            {
                // "decima.l_rep000"
                Debug.Assert(digits_after_point > 0);
                writer.Write(decimal_digits, 0, decimal_point);
                writer.Write('.');
                Debug.Assert(length - decimal_point <= digits_after_point);
                writer.Write(decimal_digits, decimal_point,
                                             length - decimal_point);
                int remaining_digits = digits_after_point - (length - decimal_point);
                writer.Write(new string('0', remaining_digits));
            }
        }

        private static void CreateExponentialRepresentation(
            char[] decimal_digits,
            int length,
            int exponent,
            TextWriter writer)
        {
            Debug.Assert(length != 0);
            writer.Write(decimal_digits[0]);
            if (length != 1)
            {
                writer.Write('.');
                writer.Write(decimal_digits, 1, length - 1);
            }
            writer.Write(exponent_character_);
            if (exponent < 0)
            {
                writer.Write('-');
                exponent = -exponent;
            }
            if (exponent == 0)
            {
                writer.Write('0');
                return;
            }
            Debug.Assert(exponent < 1e4);
            if (exponent >= 100)
            {
                writer.Write((char)('0' + exponent / 100));
                exponent %= 100;
                writer.Write((char)('0' + exponent / 10));
                exponent %= 10;
                writer.Write((char)('0' + exponent));
            }
            else if (exponent >= 10)
            {
                writer.Write((char)('0' + exponent / 10));
                exponent %= 10;
                writer.Write((char)('0' + exponent));
            }
            else
            {
                writer.Write(exponent);
            }
        }
    }
}
