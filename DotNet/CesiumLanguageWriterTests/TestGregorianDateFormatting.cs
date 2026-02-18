using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.Text.RegularExpressions;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestGregorianDateFormatting
    {
        private CultureInfo m_cultureInfo;

        [SetUp]
        public void SetUp()
        {
            m_cultureInfo = new CultureInfo("en-US");
        }

        [TestCase("d")]
        [TestCase("D")]
        [TestCase("f")]
        [TestCase("F")]
        [TestCase("g")]
        [TestCase("G")]
        [TestCase("m")]
        [TestCase("M")]
        [TestCase("r")]
        [TestCase("R")]
        [TestCase("s")]
        [TestCase("t")]
        [TestCase("T")]
        [TestCase("u")]
        [TestCase("y")]
        [TestCase("Y")]
        [TestCase("")]
        public void TestToStringStandardFormats(string format)
        {
            var dateTime = new DateTime(2002, 02, 25, 05, 25, 13);
            var gregorianDate = new GregorianDate(dateTime);

            // .NET Core on Linux uses different standard formats, so we compare against what DateTime does
            // rather than specific known strings.
            Assert.AreEqual(dateTime.ToString(format, m_cultureInfo), gregorianDate.ToString(format, m_cultureInfo));
        }

        [Test]
        public void TestToStringCustomFormats()
        {
            var dateTime = new DateTime(2002, 02, 25, 05, 25, 13);
            var gregorianDate = new GregorianDate(dateTime);

            Assert.AreEqual("25", gregorianDate.ToString("%d", m_cultureInfo));
            Assert.AreEqual("25", gregorianDate.ToString("dd", m_cultureInfo));
            Assert.AreEqual("Mon", gregorianDate.ToString("ddd", m_cultureInfo));
            Assert.AreEqual("Monday", gregorianDate.ToString("dddd", m_cultureInfo));
            Assert.AreEqual("2", gregorianDate.ToString("%M", m_cultureInfo));
            Assert.AreEqual("02", gregorianDate.ToString("MM", m_cultureInfo));
            Assert.AreEqual("Feb", gregorianDate.ToString("MMM", m_cultureInfo));
            Assert.AreEqual("February", gregorianDate.ToString("MMMM", m_cultureInfo));
            Assert.AreEqual("2", gregorianDate.ToString("%y", m_cultureInfo));
            Assert.AreEqual("02", gregorianDate.ToString("yy", m_cultureInfo));
            Assert.AreEqual("2002", gregorianDate.ToString("yyyy", m_cultureInfo));
            Assert.AreEqual("5", gregorianDate.ToString("%h", m_cultureInfo));
            Assert.AreEqual("05", gregorianDate.ToString("hh", m_cultureInfo));
            Assert.AreEqual("A", gregorianDate.ToString("%t", m_cultureInfo));
            Assert.AreEqual("AM", gregorianDate.ToString("tt", m_cultureInfo));

            dateTime = new DateTime(2009, 06, 10, 00, 30, 00);
            gregorianDate = new GregorianDate(dateTime);
            Assert.AreEqual("12", gregorianDate.ToString("%h", m_cultureInfo));
            Assert.AreEqual("0", gregorianDate.ToString("%H", m_cultureInfo));

            dateTime = new DateTime(2002, 02, 25, 15, 25, 13);
            gregorianDate = new GregorianDate(dateTime);
            Assert.AreEqual("3", gregorianDate.ToString("%h", m_cultureInfo));
            Assert.AreEqual("03", gregorianDate.ToString("hh", m_cultureInfo));
            Assert.AreEqual("15", gregorianDate.ToString("%H", m_cultureInfo));
            Assert.AreEqual("15", gregorianDate.ToString("HH", m_cultureInfo));
            Assert.AreEqual("25", gregorianDate.ToString("%m", m_cultureInfo));
            Assert.AreEqual("25", gregorianDate.ToString("mm", m_cultureInfo));
            Assert.AreEqual("13", gregorianDate.ToString("%s", m_cultureInfo));
            Assert.AreEqual("13", gregorianDate.ToString("ss", m_cultureInfo));
            Assert.AreEqual("P", gregorianDate.ToString("%t", m_cultureInfo));
            Assert.AreEqual("PM", gregorianDate.ToString("tt", m_cultureInfo));
#if !CSToJava
            Assert.AreEqual(dateTime.ToString("%g", m_cultureInfo), gregorianDate.ToString("%g", m_cultureInfo));
#endif
            Assert.AreEqual(" : ", gregorianDate.ToString(" : ", m_cultureInfo));
            Assert.AreEqual(" / ", gregorianDate.ToString(" / ", m_cultureInfo));
            Assert.AreEqual(" yyy ", gregorianDate.ToString(" 'yyy' ", m_cultureInfo));
            Assert.AreEqual(" d", gregorianDate.ToString(" \\d", m_cultureInfo));
            Assert.AreEqual("2002", gregorianDate.ToString("yyy", m_cultureInfo));
            Assert.AreEqual("0002002", gregorianDate.ToString("yyyyyyy", m_cultureInfo));

            gregorianDate = new GregorianDate(999, 1, 2, 3, 4, 5);
            Assert.AreEqual("999", gregorianDate.ToString("yyy", m_cultureInfo));
            Assert.AreEqual("0999", gregorianDate.ToString("yyyy", m_cultureInfo));

            // .NET's Double.ToString pads with zeros beyond 15 significant digits.
            // This is kind of obnoxious, but we get the guaranteed precision of
            // a GregorianDate (1e-10 seconds) even so, so it's not worth major
            // heroics to solve.
            gregorianDate = new GregorianDate(2009, 06, 10, 15, 0, 13.012345678912345);
            string s = gregorianDate.ToString("ss.fffffffffffffff", m_cultureInfo);
            Assert.AreEqual(18, s.Length);
            StringAssert.StartsWith("13.0123456789123", s);

            gregorianDate = new GregorianDate(2009, 06, 10, 15, 0, 13.012);
            Assert.AreEqual("13.012000000000000", gregorianDate.ToString("ss.fffffffffffffff", m_cultureInfo));
            Assert.AreEqual("13.012", gregorianDate.ToString("ss.FFFFFFFFFFFFFFF", m_cultureInfo));
        }

        [Test]
        public void ToStringThrowsOnInvalidFormatSpecifier()
        {
            var exception = Assert.Throws<FormatException>(() =>
            {
                string unused = new GregorianDate(2009, 06, 10).ToString("X");
            });
            StringAssert.Contains("not one of the format specifier characters", exception.Message);
        }

        [Test]
        public void CantFormatMoreThan15FractionalSeconds()
        {
            var exception = Assert.Throws<FormatException>(() =>
            {
                string unused = new GregorianDate(2009, 06, 10).ToString("ffffffffffffffff");
            });
            StringAssert.Contains("Invalid format string", exception.Message);
        }

        [Test]
        public void FormatSpecifierCantEndWithAPercent()
        {
            var exception = Assert.Throws<FormatException>(() =>
            {
                string unused = new GregorianDate(2009, 06, 10).ToString("f%");
            });
            StringAssert.Contains("Invalid character % at the end of the format specifier", exception.Message);
        }

        [Test]
        public void FormatSpecifierCantEndWithABackslash()
        {
            var exception = Assert.Throws<FormatException>(() =>
            {
                string unused = new GregorianDate(2009, 06, 10).ToString(@"f\");
            });
            StringAssert.Contains(@"Invalid character \ at the end of the format specifier", exception.Message);
        }

        [Test]
        public void FormatSpecifierCantHaveADoublePercent()
        {
            var exception = Assert.Throws<FormatException>(() =>
            {
                string unused = new GregorianDate(2009, 06, 10).ToString("%%");
            });
            StringAssert.Contains("Invalid character %% in format specifier", exception.Message);
        }

        [Test]
        public void TestFormattingLeapSecond()
        {
            GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
            Assert.AreEqual("31 Dec 2008 23:59:60.444", date.ToString("d MMM yyyy H:mm:ss.fff", m_cultureInfo));
        }

        [TestCase(2012, 4, 2, 1, 2, 3.12345, "2012-04-02T01:02:03.12345Z")]
        [TestCase(2012, 4, 2, 1, 2, 3, "2012-04-02T01:02:03Z")]
        [TestCase(2012, 4, 2, 1, 2, 0, "2012-04-02T01:02:00Z")]
        [TestCase(2012, 6, 30, 23, 59, 60.123, "2012-06-30T23:59:60.123Z")]
        [TestCase(2012, 4, 2, 1, 0, 0, "2012-04-02T01:00:00Z")]
        [TestCase(2017, 12, 7, 0, 0, 0, "2017-12-07T00:00:00Z")]
        [TestCase(2017, 12, 7, 0, 1, 0, "2017-12-07T00:01:00Z")]
        [TestCase(2017, 12, 7, 0, 0, 0.123, "2017-12-07T00:00:00.123Z")]
        [TestCase(2017, 12, 7, 2, 0, 32.299, "2017-12-07T02:00:32.299Z")]
        public void ToIso8601ExtendedStringProducesCorrectStrings(int year, int month, int day, int hour, int minute, double second, string expectedIsoString)
        {
            var gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
            string isoString = gregorianDate.ToIso8601String(Iso8601Format.Extended);
            Assert.AreEqual(expectedIsoString, isoString);
            Assert.AreEqual(gregorianDate, GregorianDate.Parse(isoString));
        }

        [TestCase(2012, 4, 2, 1, 2, 3.12345, "20120402T010203.12345Z")]
        [TestCase(2012, 4, 2, 1, 2, 3, "20120402T010203Z")]
        [TestCase(2012, 4, 2, 1, 2, 0, "20120402T010200Z")]
        [TestCase(2012, 6, 30, 23, 59, 60.123, "20120630T235960.123Z")]
        [TestCase(2012, 4, 2, 1, 0, 0, "20120402T010000Z")]
        [TestCase(2017, 12, 7, 0, 0, 0, "20171207T000000Z")]
        [TestCase(2017, 12, 7, 0, 1, 0, "20171207T000100Z")]
        [TestCase(2017, 12, 7, 0, 0, 0.123, "20171207T000000.123Z")]
        [TestCase(2017, 12, 7, 2, 0, 32.299, "20171207T020032.299Z")]
        public void ToIso8601BasicStringProducesCorrectStrings(int year, int month, int day, int hour, int minute, double second, string expectedIsoString)
        {
            var gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
            string isoString = gregorianDate.ToIso8601String(Iso8601Format.Basic);
            Assert.AreEqual(expectedIsoString, isoString);
            Assert.AreEqual(gregorianDate, GregorianDate.Parse(isoString));
        }

        [TestCase(2012, 4, 2, 1, 2, 3.12345, "20120402T010203.12345Z")]
        [TestCase(2012, 4, 2, 1, 2, 3, "20120402T010203Z")]
        [TestCase(2012, 4, 2, 1, 2, 0, "20120402T0102Z")]
        [TestCase(2012, 6, 30, 23, 59, 60.123, "20120630T235960.123Z")]
        [TestCase(2012, 4, 2, 1, 0, 0, "20120402T01Z")]
        [TestCase(2017, 12, 7, 0, 0, 0, "20171207T00Z")]
        [TestCase(2017, 12, 7, 0, 1, 0, "20171207T0001Z")]
        [TestCase(2017, 12, 7, 0, 0, 0.123, "20171207T000000.123Z")]
        [TestCase(2017, 12, 7, 2, 0, 32.299, "20171207T020032.299Z")]
        public void ToIso8601CompactStringProducesCorrectStrings(int year, int month, int day, int hour, int minute, double second, string expectedIsoString)
        {
            var gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
            string isoString = gregorianDate.ToIso8601String(Iso8601Format.Compact);
            Assert.AreEqual(expectedIsoString, isoString);
        }

        [TestCaseSource("ToIso8601ValidationValues")]
        public void ToIso8601Validation(GregorianDate date)
        {
            // found this regex online
            var regex = new Regex(@"^([\+-]?\d{4}(?!\d{2}\b))((-?)((0[1-9]|1[0-2])(\3([12]\d|0[1-9]|3[01]))?|W([0-4]\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\d|[12]\d{2}|3([0-5]\d|6[1-6])))([T\s]((([01]\d|2[0-3])((:?)[0-5]\d)?|24\:?00)([\.,]\d+(?!:))?)?(\17[0-5]\d([\.,]\d+)?)?([zZ]|([\+-])([01]\d|2[0-3]):?([0-5]\d)?)?)?)?$");

            string s = date.ToIso8601String();
            Assert.IsTrue(regex.IsMatch(s));

            s = date.ToIso8601String(Iso8601Format.Basic);
            Assert.IsTrue(regex.IsMatch(s));
            s = date.ToIso8601String(Iso8601Format.Compact);
            Assert.IsTrue(regex.IsMatch(s));
            s = date.ToIso8601String(Iso8601Format.Extended);
            Assert.IsTrue(regex.IsMatch(s));

            for (int numDigits = 0; numDigits <= 15; ++numDigits)
            {
                s = date.ToIso8601String(Iso8601Format.Basic, numDigits);
                Assert.IsTrue(regex.IsMatch(s));
                s = date.ToIso8601String(Iso8601Format.Compact, numDigits);
                Assert.IsTrue(regex.IsMatch(s));
                s = date.ToIso8601String(Iso8601Format.Extended, numDigits);
                Assert.IsTrue(regex.IsMatch(s));
            }
        }

        [NotNull]
        public static IEnumerable<GregorianDate> ToIso8601ValidationValues
        {
            get
            {
                return new List<GregorianDate>
                {
                    new GregorianDate(2012, 4, 2, 1, 2, 3.12345),
                    new GregorianDate(2012, 4, 2, 1, 2, 0.12345),
                    new GregorianDate(2012, 4, 2, 1, 0, 0.12345),
                    new GregorianDate(2012, 4, 2, 0, 0, 0.12345),
                    new GregorianDate(2012, 4, 2, 1, 2, 0),
                    new GregorianDate(2012, 4, 2, 1, 0, 0),
                    new GregorianDate(2012, 4, 2, 0, 0, 0),
                    new GregorianDate(2012, 4, 2, 0, 1, 0),
                    new GregorianDate(2012, 4, 2, 0, 0, 1),
                };
            }
        }

        [Test]
        public void SecondsAreCorrectlyFormattedToDifferentNumbersOfDigits()
        {
            GregorianDate first = new GregorianDate(2009, 2, 7, 5, 41, 44.408);
            Assert.AreEqual("44.408", first.ToString("ss.fff", m_cultureInfo));
            Assert.AreEqual("44.4080", first.ToString("ss.ffff", m_cultureInfo));
            Assert.AreEqual("44.40800", first.ToString("ss.fffff", m_cultureInfo));
        }

        [Test]
        [CSToJavaExclude]
        public void SecondsAreCorrectlyFormattedInTurkey()
        {
            var cultureInfo = new CultureInfo("tr-TR");
            GregorianDate first = new GregorianDate(2009, 2, 7, 5, 41, 44.408);
            Assert.AreEqual("44,408", first.ToString("ss.fff", cultureInfo));
            Assert.AreEqual("44,4080", first.ToString("ss.ffff", cultureInfo));
            Assert.AreEqual("44,40800", first.ToString("ss.fffff", cultureInfo));
        }

        [Test]
        public void ToStringTruncatesSeconds()
        {
            var gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 59.9999999);
            Assert.AreEqual("2012-08-07 13:59:59.999999", gregorianDate.ToString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));
        }

        [Test]
        public void WholeNumberSecondsIsFormattedCorrectly()
        {
            var gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
            Assert.AreEqual("2012-08-07 13:59:55.000000", gregorianDate.ToString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));

            gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
            Assert.AreEqual("2012-08-07 13:59:55", gregorianDate.ToString("yyyy-MM-dd HH:mm:ss", m_cultureInfo));

            gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
            Assert.AreEqual("2012-08-07 13:59:55", gregorianDate.ToString("yyyy-MM-dd HH:mm:ss.FFFFFF", m_cultureInfo));
        }

        [TestCase(2012, 8, 7, 13, 59, 59.9999999, "2012-08-07T13:59:59.999999Z")]
        [TestCase(2012, 6, 30, 23, 59, 59.999999, "2012-06-30T23:59:59.999999Z")]
        [TestCase(2012, 6, 30, 23, 59, 59.99999949999999, "2012-06-30T23:59:59.999999Z")]
        [TestCase(2012, 6, 30, 23, 59, 59.99999950000000, "2012-06-30T23:59:59.999999Z")]
        [TestCase(2012, 6, 30, 23, 59, 60.0, "2012-06-30T23:59:60.000000Z")]
        [TestCase(2012, 6, 30, 23, 59, 60.99999949999999, "2012-06-30T23:59:60.999999Z")]
        [TestCase(2012, 6, 30, 23, 59, 60.99999950000000, "2012-06-30T23:59:60.999999Z")]
        public void ToIso8601StringWithFractionalSeconds(int year, int month, int day, int hour, int minute, double second, string expectedIsoString)
        {
            var gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
            string isoString = gregorianDate.ToIso8601String(Iso8601Format.Extended, 6);
            Assert.AreEqual(expectedIsoString, isoString);
        }

        [Test]
        public void FractionalSecondsCloseToZeroAreFormattedCorrectly()
        {
            // Based on BUG71966: GregorianDate.ToString(format) produces incorrect value for fractional seconds
            var date = new GregorianDate(2012, 2, 25, 0, 15, 0.000000000014551915228366852);
            Assert.AreEqual("001500.0000000", date.ToString("HHmmss.fffffff", m_cultureInfo));
        }
    }
}
