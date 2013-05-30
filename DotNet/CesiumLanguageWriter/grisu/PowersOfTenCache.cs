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

namespace GrisuDotNet
{
    [CSToJavaExclude]
    internal class PowersOfTenCache
    {
        // Not all powers of ten are cached. The decimal exponent of two neighboring
        // cached numbers will differ by kDecimalExponentDistance.
        private const int kDecimalExponentDistance = 8;

        private const int kMinDecimalExponent = -348;
        private const int kMaxDecimalExponent = 340;

        // Returns a cached power-of-ten with a binary exponent in the range
        // [min_exponent; max_exponent] (boundaries included).
        public static void GetCachedPowerForBinaryExponentRange(int min_exponent,
                                                         int max_exponent,
                                                         out DiyFp power,
                                                         out int decimal_exponent)
        {
            int kQ = DiyFp.kSignificandSize;
            double k = Math.Ceiling((min_exponent + kQ - 1) * kD_1_LOG2_10);
            int foo = kCachedPowersOffset;
            int index =
                (foo + (int)(k) - 1) / kDecimalExponentDistance + 1;
            Debug.Assert(0 <= index && index < kCachedPowers.Length);
            CachedPower cached_power = kCachedPowers[index];
            Debug.Assert(min_exponent <= cached_power.binary_exponent);
            Debug.Assert(cached_power.binary_exponent <= max_exponent);
            decimal_exponent = cached_power.decimal_exponent;
            power = new DiyFp(cached_power.significand, cached_power.binary_exponent);
        }

        // Returns a cached power of ten x ~= 10^k such that
        //   k <= decimal_exponent < k + kCachedPowersDecimalDistance.
        // The given decimal_exponent must satisfy
        //   kMinDecimalExponent <= requested_exponent, and
        //   requested_exponent < kMaxDecimalExponent + kDecimalExponentDistance.
        public static void GetCachedPowerForDecimalExponent(int requested_exponent,
                                                     out DiyFp power,
                                                     out int found_exponent)
        {
            Debug.Assert(kMinDecimalExponent <= requested_exponent);
            Debug.Assert(requested_exponent < kMaxDecimalExponent + kDecimalExponentDistance);
            int index =
                (requested_exponent + kCachedPowersOffset) / kDecimalExponentDistance;
            CachedPower cached_power = kCachedPowers[index];
            power = new DiyFp(cached_power.significand, cached_power.binary_exponent);
            found_exponent = cached_power.decimal_exponent;
            Debug.Assert(found_exponent <= requested_exponent);
            Debug.Assert(requested_exponent < found_exponent + kDecimalExponentDistance);
        }

        struct CachedPower
        {
            public ulong significand;
            public short binary_exponent;
            public short decimal_exponent;
        };

        static readonly CachedPower[] kCachedPowers = new CachedPower[]
        {
          new CachedPower() {significand = 0xfa8fd5a0081c0288, binary_exponent = -1220, decimal_exponent = -348},
          new CachedPower() {significand = 0xbaaee17fa23ebf76, binary_exponent = -1193, decimal_exponent = -340},
          new CachedPower() {significand = 0x8b16fb203055ac76, binary_exponent = -1166, decimal_exponent = -332},
          new CachedPower() {significand = 0xcf42894a5dce35ea, binary_exponent = -1140, decimal_exponent = -324},
          new CachedPower() {significand = 0x9a6bb0aa55653b2d, binary_exponent = -1113, decimal_exponent = -316},
          new CachedPower() {significand = 0xe61acf033d1a45df, binary_exponent = -1087, decimal_exponent = -308},
          new CachedPower() {significand = 0xab70fe17c79ac6ca, binary_exponent = -1060, decimal_exponent = -300},
          new CachedPower() {significand = 0xff77b1fcbebcdc4f, binary_exponent = -1034, decimal_exponent = -292},
          new CachedPower() {significand = 0xbe5691ef416bd60c, binary_exponent = -1007, decimal_exponent = -284},
          new CachedPower() {significand = 0x8dd01fad907ffc3c, binary_exponent = -980, decimal_exponent = -276},
          new CachedPower() {significand = 0xd3515c2831559a83, binary_exponent = -954, decimal_exponent = -268},
          new CachedPower() {significand = 0x9d71ac8fada6c9b5, binary_exponent = -927, decimal_exponent = -260},
          new CachedPower() {significand = 0xea9c227723ee8bcb, binary_exponent = -901, decimal_exponent = -252},
          new CachedPower() {significand = 0xaecc49914078536d, binary_exponent = -874, decimal_exponent = -244},
          new CachedPower() {significand = 0x823c12795db6ce57, binary_exponent = -847, decimal_exponent = -236},
          new CachedPower() {significand = 0xc21094364dfb5637, binary_exponent = -821, decimal_exponent = -228},
          new CachedPower() {significand = 0x9096ea6f3848984f, binary_exponent = -794, decimal_exponent = -220},
          new CachedPower() {significand = 0xd77485cb25823ac7, binary_exponent = -768, decimal_exponent = -212},
          new CachedPower() {significand = 0xa086cfcd97bf97f4, binary_exponent = -741, decimal_exponent = -204},
          new CachedPower() {significand = 0xef340a98172aace5, binary_exponent = -715, decimal_exponent = -196},
          new CachedPower() {significand = 0xb23867fb2a35b28e, binary_exponent = -688, decimal_exponent = -188},
          new CachedPower() {significand = 0x84c8d4dfd2c63f3b, binary_exponent = -661, decimal_exponent = -180},
          new CachedPower() {significand = 0xc5dd44271ad3cdba, binary_exponent = -635, decimal_exponent = -172},
          new CachedPower() {significand = 0x936b9fcebb25c996, binary_exponent = -608, decimal_exponent = -164},
          new CachedPower() {significand = 0xdbac6c247d62a584, binary_exponent = -582, decimal_exponent = -156},
          new CachedPower() {significand = 0xa3ab66580d5fdaf6, binary_exponent = -555, decimal_exponent = -148},
          new CachedPower() {significand = 0xf3e2f893dec3f126, binary_exponent = -529, decimal_exponent = -140},
          new CachedPower() {significand = 0xb5b5ada8aaff80b8, binary_exponent = -502, decimal_exponent = -132},
          new CachedPower() {significand = 0x87625f056c7c4a8b, binary_exponent = -475, decimal_exponent = -124},
          new CachedPower() {significand = 0xc9bcff6034c13053, binary_exponent = -449, decimal_exponent = -116},
          new CachedPower() {significand = 0x964e858c91ba2655, binary_exponent = -422, decimal_exponent = -108},
          new CachedPower() {significand = 0xdff9772470297ebd, binary_exponent = -396, decimal_exponent = -100},
          new CachedPower() {significand = 0xa6dfbd9fb8e5b88f, binary_exponent = -369, decimal_exponent = -92},
          new CachedPower() {significand = 0xf8a95fcf88747d94, binary_exponent = -343, decimal_exponent = -84},
          new CachedPower() {significand = 0xb94470938fa89bcf, binary_exponent = -316, decimal_exponent = -76},
          new CachedPower() {significand = 0x8a08f0f8bf0f156b, binary_exponent = -289, decimal_exponent = -68},
          new CachedPower() {significand = 0xcdb02555653131b6, binary_exponent = -263, decimal_exponent = -60},
          new CachedPower() {significand = 0x993fe2c6d07b7fac, binary_exponent = -236, decimal_exponent = -52},
          new CachedPower() {significand = 0xe45c10c42a2b3b06, binary_exponent = -210, decimal_exponent = -44},
          new CachedPower() {significand = 0xaa242499697392d3, binary_exponent = -183, decimal_exponent = -36},
          new CachedPower() {significand = 0xfd87b5f28300ca0e, binary_exponent = -157, decimal_exponent = -28},
          new CachedPower() {significand = 0xbce5086492111aeb, binary_exponent = -130, decimal_exponent = -20},
          new CachedPower() {significand = 0x8cbccc096f5088cc, binary_exponent = -103, decimal_exponent = -12},
          new CachedPower() {significand = 0xd1b71758e219652c, binary_exponent = -77, decimal_exponent = -4},
          new CachedPower() {significand = 0x9c40000000000000, binary_exponent = -50, decimal_exponent = 4},
          new CachedPower() {significand = 0xe8d4a51000000000, binary_exponent = -24, decimal_exponent = 12},
          new CachedPower() {significand = 0xad78ebc5ac620000, binary_exponent = 3, decimal_exponent = 20},
          new CachedPower() {significand = 0x813f3978f8940984, binary_exponent = 30, decimal_exponent = 28},
          new CachedPower() {significand = 0xc097ce7bc90715b3, binary_exponent = 56, decimal_exponent = 36},
          new CachedPower() {significand = 0x8f7e32ce7bea5c70, binary_exponent = 83, decimal_exponent = 44},
          new CachedPower() {significand = 0xd5d238a4abe98068, binary_exponent = 109, decimal_exponent = 52},
          new CachedPower() {significand = 0x9f4f2726179a2245, binary_exponent = 136, decimal_exponent = 60},
          new CachedPower() {significand = 0xed63a231d4c4fb27, binary_exponent = 162, decimal_exponent = 68},
          new CachedPower() {significand = 0xb0de65388cc8ada8, binary_exponent = 189, decimal_exponent = 76},
          new CachedPower() {significand = 0x83c7088e1aab65db, binary_exponent = 216, decimal_exponent = 84},
          new CachedPower() {significand = 0xc45d1df942711d9a, binary_exponent = 242, decimal_exponent = 92},
          new CachedPower() {significand = 0x924d692ca61be758, binary_exponent = 269, decimal_exponent = 100},
          new CachedPower() {significand = 0xda01ee641a708dea, binary_exponent = 295, decimal_exponent = 108},
          new CachedPower() {significand = 0xa26da3999aef774a, binary_exponent = 322, decimal_exponent = 116},
          new CachedPower() {significand = 0xf209787bb47d6b85, binary_exponent = 348, decimal_exponent = 124},
          new CachedPower() {significand = 0xb454e4a179dd1877, binary_exponent = 375, decimal_exponent = 132},
          new CachedPower() {significand = 0x865b86925b9bc5c2, binary_exponent = 402, decimal_exponent = 140},
          new CachedPower() {significand = 0xc83553c5c8965d3d, binary_exponent = 428, decimal_exponent = 148},
          new CachedPower() {significand = 0x952ab45cfa97a0b3, binary_exponent = 455, decimal_exponent = 156},
          new CachedPower() {significand = 0xde469fbd99a05fe3, binary_exponent = 481, decimal_exponent = 164},
          new CachedPower() {significand = 0xa59bc234db398c25, binary_exponent = 508, decimal_exponent = 172},
          new CachedPower() {significand = 0xf6c69a72a3989f5c, binary_exponent = 534, decimal_exponent = 180},
          new CachedPower() {significand = 0xb7dcbf5354e9bece, binary_exponent = 561, decimal_exponent = 188},
          new CachedPower() {significand = 0x88fcf317f22241e2, binary_exponent = 588, decimal_exponent = 196},
          new CachedPower() {significand = 0xcc20ce9bd35c78a5, binary_exponent = 614, decimal_exponent = 204},
          new CachedPower() {significand = 0x98165af37b2153df, binary_exponent = 641, decimal_exponent = 212},
          new CachedPower() {significand = 0xe2a0b5dc971f303a, binary_exponent = 667, decimal_exponent = 220},
          new CachedPower() {significand = 0xa8d9d1535ce3b396, binary_exponent = 694, decimal_exponent = 228},
          new CachedPower() {significand = 0xfb9b7cd9a4a7443c, binary_exponent = 720, decimal_exponent = 236},
          new CachedPower() {significand = 0xbb764c4ca7a44410, binary_exponent = 747, decimal_exponent = 244},
          new CachedPower() {significand = 0x8bab8eefb6409c1a, binary_exponent = 774, decimal_exponent = 252},
          new CachedPower() {significand = 0xd01fef10a657842c, binary_exponent = 800, decimal_exponent = 260},
          new CachedPower() {significand = 0x9b10a4e5e9913129, binary_exponent = 827, decimal_exponent = 268},
          new CachedPower() {significand = 0xe7109bfba19c0c9d, binary_exponent = 853, decimal_exponent = 276},
          new CachedPower() {significand = 0xac2820d9623bf429, binary_exponent = 880, decimal_exponent = 284},
          new CachedPower() {significand = 0x80444b5e7aa7cf85, binary_exponent = 907, decimal_exponent = 292},
          new CachedPower() {significand = 0xbf21e44003acdd2d, binary_exponent = 933, decimal_exponent = 300},
          new CachedPower() {significand = 0x8e679c2f5e44ff8f, binary_exponent = 960, decimal_exponent = 308},
          new CachedPower() {significand = 0xd433179d9c8cb841, binary_exponent = 986, decimal_exponent = 316},
          new CachedPower() {significand = 0x9e19db92b4e31ba9, binary_exponent = 1013, decimal_exponent = 324},
          new CachedPower() {significand = 0xeb96bf6ebadf77d9, binary_exponent = 1039, decimal_exponent = 332},
          new CachedPower() {significand = 0xaf87023b9bf0ee6b, binary_exponent = 1066, decimal_exponent = 340},
        };

        const int kCachedPowersOffset = 348;  // -1 * the first decimal_exponent.
        const double kD_1_LOG2_10 = 0.30102999566398114;  //  1 / lg(10)
    }
}