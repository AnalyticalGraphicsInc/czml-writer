using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text.RegularExpressions;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestGregorianDateFormatting
    {
        [SetUp]
        public virtual void SetUp()
        {
            m_cultureInfo = new CultureInfo("en-US");
        }

        [Test]
        public void TestToString()
        {
            GregorianDate date = new GregorianDate(2002, 02, 25, 05, 25, 13);

            Assert.AreEqual("2/25/2002", date.ToString("d", m_cultureInfo));
            Assert.AreEqual("Monday, February 25, 2002", date.ToString("D", m_cultureInfo));
            Assert.AreEqual("Monday, February 25, 2002 5:25 AM", date.ToString("f", m_cultureInfo));
            Assert.AreEqual("Monday, February 25, 2002 5:25:13 AM", date.ToString("F", m_cultureInfo));
            Assert.AreEqual("2/25/2002 5:25 AM", date.ToString("g", m_cultureInfo));
            Assert.AreEqual("2/25/2002 5:25:13 AM", date.ToString("G", m_cultureInfo));
            Assert.AreEqual("February 25", date.ToString("m", m_cultureInfo));
            Assert.AreEqual("February 25", date.ToString("M", m_cultureInfo));
            Assert.AreEqual("Mon, 25 Feb 2002 05:25:13 GMT", date.ToString("r", m_cultureInfo));
            Assert.AreEqual("Mon, 25 Feb 2002 05:25:13 GMT", date.ToString("R", m_cultureInfo));
            Assert.AreEqual("2002-02-25T05:25:13", date.ToString("s", m_cultureInfo));
            Assert.AreEqual("5:25 AM", date.ToString("t", m_cultureInfo));
            Assert.AreEqual("5:25:13 AM", date.ToString("T", m_cultureInfo));
            Assert.AreEqual("2002-02-25 05:25:13Z", date.ToString("u", m_cultureInfo));

            // Windows 8 changed to no longer include a comma after the month.  Either is ok.
            string smallY = date.ToString("y", m_cultureInfo);
            Assert.IsTrue(smallY == "February, 2002" || smallY == "February 2002");
            string bigY = date.ToString("Y", m_cultureInfo);
            Assert.IsTrue(bigY == "February, 2002" || bigY == "February 2002");

            Assert.AreEqual("2/25/2002 5:25:13 AM", date.ToString("", m_cultureInfo));
            Assert.AreEqual("25", date.ToString("%d", m_cultureInfo));
            Assert.AreEqual("25", date.ToString("dd", m_cultureInfo));
            Assert.AreEqual("Mon", date.ToString("ddd", m_cultureInfo));
            Assert.AreEqual("Monday", date.ToString("dddd", m_cultureInfo));
            Assert.AreEqual("2", date.ToString("%M", m_cultureInfo));
            Assert.AreEqual("02", date.ToString("MM", m_cultureInfo));
            Assert.AreEqual("Feb", date.ToString("MMM", m_cultureInfo));
            Assert.AreEqual("February", date.ToString("MMMM", m_cultureInfo));
            Assert.AreEqual("2", date.ToString("%y", m_cultureInfo));
            Assert.AreEqual("02", date.ToString("yy", m_cultureInfo));
            Assert.AreEqual("2002", date.ToString("yyyy", m_cultureInfo));
            Assert.AreEqual("5", date.ToString("%h", m_cultureInfo));
            Assert.AreEqual("05", date.ToString("hh", m_cultureInfo));
            Assert.AreEqual("A", date.ToString("%t", m_cultureInfo));
            Assert.AreEqual("AM", date.ToString("tt", m_cultureInfo));

            date = new GregorianDate(2009, 06, 10, 00, 30, 00);
            Assert.AreEqual("12", date.ToString("%h", m_cultureInfo));
            Assert.AreEqual("0", date.ToString("%H", m_cultureInfo));

            date = new GregorianDate(2002, 02, 25, 15, 25, 13);
            Assert.AreEqual("3", date.ToString("%h", m_cultureInfo));
            Assert.AreEqual("03", date.ToString("hh", m_cultureInfo));
            Assert.AreEqual("15", date.ToString("%H", m_cultureInfo));
            Assert.AreEqual("15", date.ToString("HH", m_cultureInfo));
            Assert.AreEqual("25", date.ToString("%m", m_cultureInfo));
            Assert.AreEqual("25", date.ToString("mm", m_cultureInfo));
            Assert.AreEqual("13", date.ToString("%s", m_cultureInfo));
            Assert.AreEqual("13", date.ToString("ss", m_cultureInfo));
            Assert.AreEqual("P", date.ToString("%t", m_cultureInfo));
            Assert.AreEqual("PM", date.ToString("tt", m_cultureInfo));
            Assert.AreEqual("A.D.", date.ToString("%g", m_cultureInfo));

            Assert.AreEqual(" : ", date.ToString(" : ", m_cultureInfo));
            Assert.AreEqual(" / ", date.ToString(" / ", m_cultureInfo));
            Assert.AreEqual(" yyy ", date.ToString(" 'yyy' ", m_cultureInfo));
            Assert.AreEqual(" d", date.ToString(" \\d", m_cultureInfo));
            Assert.AreEqual("2002", date.ToString("yyy", m_cultureInfo));
            Assert.AreEqual("0002002", date.ToString("yyyyyyy", m_cultureInfo));

            date = new GregorianDate(999, 1, 2, 3, 4, 5);
            Assert.AreEqual("999", date.ToString("yyy", m_cultureInfo));
            Assert.AreEqual("0999", date.ToString("yyyy", m_cultureInfo));

            // .NET's Double.ToString pads with zeros beyond 15 significant digits.
            // This is kind of obnoxious, but we get the guaranteed precision of
            // a GregorianDate (1e-10 seconds) even so, so it's not worth major
            // heroics to solve.
            date = new GregorianDate(2009, 06, 10, 15, 0, 13.012345678912345);
            string s = date.ToString("ss.fffffffffffffff", m_cultureInfo);
            Assert.AreEqual(18, s.Length);
            Assert.IsTrue(s.StartsWith("13.0123456789123"));

            date = new GregorianDate(2009, 06, 10, 15, 0, 13.012);
            Assert.AreEqual("13.012000000000000", date.ToString("ss.fffffffffffffff", m_cultureInfo));
            Assert.AreEqual("13.012", date.ToString("ss.FFFFFFFFFFFFFFF", m_cultureInfo));
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void ToStringThrowsOnInvalidFormatSpecifier()
        {
            string unused = new GregorianDate(2009, 06, 10).ToString("X");
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void CantFormatMoreThan15FractionalSeconds()
        {
            string unused = new GregorianDate(2009, 06, 10).ToString("ffffffffffffffff");
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void CantEndWithAPercent()
        {
            string unused = new GregorianDate(2009, 06, 10).ToString("f%");
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void CantEndWithABackslash()
        {
            string unused = new GregorianDate(2009, 06, 10).ToString("f\\");
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void CantHaveADoublePercent()
        {
            string unused = new GregorianDate(2009, 06, 10).ToString("%%");
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

        public IEnumerable<GregorianDate> ToIso8601ValidationValues
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
            GregorianDate gd = new GregorianDate(2012, 8, 7, 13, 59, 59.9999999);
            Assert.AreEqual("2012-08-07 13:59:59.999999", gd.ToString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));
        }

        [Test]
        public void WholeNumberSecondsIsFormattedCorrectly()
        {
            GregorianDate gd = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
            Assert.AreEqual("2012-08-07 13:59:55.000000", gd.ToString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));

            gd = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
            Assert.AreEqual("2012-08-07 13:59:55", gd.ToString("yyyy-MM-dd HH:mm:ss", m_cultureInfo));

            gd = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
            Assert.AreEqual("2012-08-07 13:59:55", gd.ToString("yyyy-MM-dd HH:mm:ss.FFFFFF", m_cultureInfo));
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

        private CultureInfo m_cultureInfo;
    }
}