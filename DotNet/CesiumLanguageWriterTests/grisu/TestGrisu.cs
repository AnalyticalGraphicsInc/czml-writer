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
using System.Threading;
using GrisuDotNet;
using NUnit.Framework;

namespace CesiumLanguageWriterTests.grisu
{
    [TestFixture]
    [CSToJavaExclude]
    public class TestGrisu
    {
        [Test]
        public void TestDoubleToString()
        {
            CheckDoubleToStringEquals("0", 0.0);
            CheckDoubleToStringEquals("12345", 12345.0);
            CheckDoubleToStringEquals("1.2345e27", 12345e23);
            CheckDoubleToStringEquals("1e21", 1e21);
            CheckDoubleToStringEquals("1e20", 1e20);
            CheckDoubleToStringEquals("1.1111111111111111e20", 111111111111111111111.0);
            CheckDoubleToStringEquals("1.1111111111111111e21", 1111111111111111111111.0);
            CheckDoubleToStringEquals("1.1111111111111111e22", 11111111111111111111111.0);
            CheckDoubleToStringEquals("-1e-5", -0.00001);
            CheckDoubleToStringEquals("-1e-6", -0.000001);
            CheckDoubleToStringEquals("-1e-7", -0.0000001);
            CheckDoubleToStringEquals("0", -0.0);
            CheckDoubleToStringEquals("0.1", 0.1);
            CheckDoubleToStringEquals("0.01", 0.01);
            CheckDoubleToStringEquals("1", 1.0);
            CheckDoubleToStringEquals("10", 10.0);
            CheckDoubleToStringEquals("1100", 1100.0);
            CheckDoubleToStringEquals("1122", 1122.0);
            CheckDoubleToStringEquals("1e4", 10000.0);
            CheckDoubleToStringEquals("11100", 11100.0);
            CheckDoubleToStringEquals("1e5", 100000.0);
            CheckDoubleToStringEquals("1e-6", 0.000001);
            CheckDoubleToStringEquals("1e-7", 0.0000001);
            CheckDoubleToStringEquals("1e20", 100000000000000000000.0);
            CheckDoubleToStringEquals("Infinity", double.PositiveInfinity);
            CheckDoubleToStringEquals("-Infinity", double.NegativeInfinity);
            CheckDoubleToStringEquals("NaN", double.NaN);
            CheckDoubleToStringEquals("NaN", -double.NaN);
            CheckDoubleToStringEquals("3.5844466002796428E+298", 3.5844466002796428e+298);
        }

        private void CheckDoubleToStringEquals(string expected, double value)
        {
            StringWriter writer = new StringWriter();
            Grisu.DoubleToString(value, writer);
            Assert.AreEqual(expected, writer.ToString());
        }

        [TestFixture]
        public class TestNonEnglishCulture : TestGrisu
        {
            private CultureInfo m_originalCulture;

            [OneTimeSetUp]
            public void TestFixtureSetUp()
            {
                m_originalCulture = Thread.CurrentThread.CurrentCulture;

                Thread.CurrentThread.CurrentCulture = new CultureInfo("de-DE");
            }

            [OneTimeTearDown]
            public void TestFixtureTearDown()
            {
                Thread.CurrentThread.CurrentCulture = m_originalCulture;
            }
        }
    }
}