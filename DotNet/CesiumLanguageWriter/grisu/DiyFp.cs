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

using System.Diagnostics;

namespace GrisuDotNet
{
    // This "Do It Yourself Floating Point" class implements a floating-point number
    // with a uint64 significand and an int exponent. Normalized DiyFp numbers will
    // have the most significant bit of the significand set.
    // Multiplication and Subtraction do not normalize their results.
    // DiyFp are not designed to contain special doubles (NaN and Infinity).
    [CSToJavaExclude]
    internal struct DiyFp
    {
        public const int kSignificandSize = 64;

        public DiyFp(ulong f, int e)
        {
            f_ = f;
            e_ = e;
        }

        // this = this - other.
        // The exponents of both numbers must be the same and the significand of this
        // must be bigger than the significand of other.
        // The result will not be normalized.
        public void Subtract(ref DiyFp other)
        {
            Debug.Assert(e_ == other.e_);
            Debug.Assert(f_ >= other.f_);
            f_ -= other.f_;
        }

        // Returns a - b.
        // The exponents of both numbers must be the same and this must be bigger
        // than other. The result will not be normalized.
        public static DiyFp Minus(ref DiyFp a, ref DiyFp b)
        {
            DiyFp result = a;
            result.Subtract(ref b);
            return result;
        }


        // this = this * other.
        public void Multiply(ref DiyFp other)
        {
            // Simply "emulates" a 128 bit multiplication.
            // However: the resulting number only contains 64 bits. The least
            // significant 64 bits are only used for rounding the most significant 64
            // bits.
            const ulong kM32 = 0xFFFFFFFFU;
            ulong a = f_ >> 32;
            ulong b = f_ & kM32;
            ulong c = other.f_ >> 32;
            ulong d = other.f_ & kM32;
            ulong ac = a * c;
            ulong bc = b * c;
            ulong ad = a * d;
            ulong bd = b * d;
            ulong tmp = (bd >> 32) + (ad & kM32) + (bc & kM32);
            // By adding 1U << 31 to tmp we round the final result.
            // Halfway cases will be round up.
            tmp += 1U << 31;
            ulong result_f = ac + (ad >> 32) + (bc >> 32) + (tmp >> 32);
            e_ += other.e_ + 64;
            f_ = result_f;
        }

        // returns a * b;
        public static DiyFp Times(ref DiyFp a, ref DiyFp b)
        {
            DiyFp result = a;
            result.Multiply(ref b);
            return result;
        }

        public void Normalize()
        {
            Debug.Assert(f_ != 0);
            ulong f = f_;
            int e = e_;

            // This method is mainly called for normalizing boundaries. In general
            // boundaries need to be shifted by 10 bits. We thus optimize for this case.
            const ulong k10MSBits = 0xFFC0000000000000;
            while ((f & k10MSBits) == 0)
            {
                f <<= 10;
                e -= 10;
            }
            while ((f & kUint64MSB) == 0)
            {
                f <<= 1;
                e--;
            }
            f_ = f;
            e_ = e;
        }

        public static DiyFp Normalize(ref DiyFp a)
        {
            DiyFp result = a;
            result.Normalize();
            return result;
        }

        public ulong F
        {
            get { return f_; }
            set { f_ = value; }
        }

        public int E
        {
            get { return e_; }
            set { e_ = value; }
        }

        private const ulong kUint64MSB = 0x8000000000000000;

        private ulong f_;
        private int e_;
    }
}
