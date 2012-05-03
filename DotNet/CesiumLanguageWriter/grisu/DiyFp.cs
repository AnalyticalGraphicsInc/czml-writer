using System.Diagnostics;

namespace grisu.net
{
    // This "Do It Yourself Floating Point" class implements a floating-point number
    // with a uint64 significand and an int exponent. Normalized DiyFp numbers will
    // have the most significant bit of the significand set.
    // Multiplication and Subtraction do not normalize their results.
    // DiyFp are not designed to contain special doubles (NaN and Infinity).
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
