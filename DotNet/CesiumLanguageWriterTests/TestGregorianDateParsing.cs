using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestGregorianDateParsing
    {
        [SetUp]
        public virtual void SetUp()
        {
            m_cultureInfo = new CultureInfo("en-US");
        }

        [Test]
        public void TestParseISO8601DayOfYear()
        {
            GregorianDate iso = new GregorianDate(1985, 2, 11, 2, 0, 5.2134);
            GregorianDate result = GregorianDate.Parse("1985-042T02:00:05.2134");
            Assert.AreEqual(iso, result);
            iso = new GregorianDate(1985, 2, 11, 2, 0, 5.21345);
            result = GregorianDate.Parse("1985-042T02:00:05.21345Z");
            Assert.AreEqual(iso, result);
            iso = new GregorianDate(1985, 2, 11, 2, 0, 5);
            result = GregorianDate.Parse("1985-042T02:00:05");
            Assert.AreEqual(iso, result);
            iso = new GregorianDate(1985, 2, 11);
            result = GregorianDate.Parse("1985-042");
            Assert.AreEqual(iso, result);

            // Make sure to check each month to ensure we have it right
            string first = "1986-";
            string last = "T02:01:04Z";
            JulianDate baseDate = new JulianDate(new GregorianDate(1986, 1, 12, 02, 01, 4));
            for (int i = 1; i < 12; i++)
            {
                string testString = string.Format(first + "{0:000}" + last, 12 + i * 30);
                GregorianDate expected = baseDate.AddDays(i * 30).ToGregorianDate();
                Assert.AreEqual(expected, GregorianDate.Parse(testString));
            }
        }

        [Test]
        public void TestTryParseISO8601DayOfYear()
        {
            GregorianDate iso = new GregorianDate(1985, 2, 11, 2, 0, 5.2134);
            GregorianDate result;
            if (!GregorianDate.TryParse("1985-042T02:00:05.2134", out result))
                Assert.Fail();
            Assert.AreEqual(iso, result);
            iso = new GregorianDate(1985, 2, 11, 2, 0, 5.21345);
            if (!GregorianDate.TryParse("1985-042T02:00:05.21345Z", out result))
                Assert.Fail();
            Assert.AreEqual(iso, result);
            iso = new GregorianDate(1985, 2, 11, 2, 0, 5);
            if (!GregorianDate.TryParse("1985-042T02:00:05", out result))
                Assert.Fail();
            Assert.AreEqual(iso, result);
            iso = new GregorianDate(1985, 2, 11);
            if (!GregorianDate.TryParse("1985-042", out result))
                Assert.Fail();
            Assert.AreEqual(iso, result);

            Assert.IsFalse(GregorianDate.TryParse("1985-367T02:00:05.2134", out result));
            Assert.IsFalse(GregorianDate.TryParse("1985-12#T02:00:05.2134", out result));
            Assert.IsFalse(GregorianDate.TryParse("21985-167T02:00:05.2134", out result));
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void TestParseISO8601DayOfYearOutOfRange()
        {
            GregorianDate unused = GregorianDate.Parse("1985-367T02:00:05.2134");
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void TestParseISO8601DayOfYearError()
        {
            GregorianDate unused = GregorianDate.Parse("1985-12#T02:00:05.2134");
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void TestParseISO8601YearOutOfRange()
        {
            GregorianDate unused = GregorianDate.Parse("21985-167T02:00:05.2134");
        }

        [Test]
        public void TestToISO8601String()
        {
            // Full format
            string isoString = "1985-04-12T10:15:30Z";
            GregorianDate iso = new GregorianDate(1985, 4, 12, 10, 15, 30);
            GregorianDate result = GregorianDate.Parse(isoString);
            Assert.AreEqual(iso, result);
            string resultString = result.ToIso8601String();
            Assert.AreEqual(isoString, resultString);
            Assert.AreEqual(isoString, iso.ToIso8601String());
        }

        [Test]
        public void TestParseExact()
        {
            GregorianDate expected = new GregorianDate(2002, 02, 25);
            Assert.AreEqual(expected, GregorianDate.ParseExact("02/25/2002", "d", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("Monday, February 25 2002", "D", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 05, 25, 00);
            Assert.AreEqual(expected, GregorianDate.ParseExact("Monday, February 25 2002 05:25 AM", "f", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("02/25/2002 05:25 AM", "g", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 05, 25, 13);
            Assert.AreEqual(expected, GregorianDate.ParseExact("Monday, February 25 2002 05:25:13 AM", "F", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("02/25/2002 05:25:13 AM", "G", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("2002-02-25T05:25:13", "s", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("Monday, 25 February 2002 05:25:13", "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 04, 25, 13);
            Assert.AreEqual(expected, GregorianDate.ParseExact("Monday, February 25 2002 04:25:13 AM", "U", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("2002-02-25 04:25:13Z", "u", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("Mon, 25 Feb 2002 04:25:13 GMT", "r", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("Mon, 25 Feb 2002 04:25:13 GMT", "R", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, 02, 25);
            Assert.AreEqual(expected, GregorianDate.ParseExact("February 25", "m", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("February 25", "M", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 05, 25, 00);
            Assert.AreEqual(expected, GregorianDate.ParseExact("05:25 AM", "t", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 05, 25, 13);
            Assert.AreEqual(expected, GregorianDate.ParseExact("05:25:13 AM", "T", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 1);
            Assert.AreEqual(expected, GregorianDate.ParseExact("February, 2002", "y", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("February, 2002", "Y", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, 1, 25);
            Assert.AreEqual(expected, GregorianDate.ParseExact("25", "%d", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("25", "dd", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, 2, 1);
            Assert.AreEqual(expected, GregorianDate.ParseExact("2", "%M", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("02", "MM", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("Feb", "MMM", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("February", "MMMM", m_cultureInfo));

            expected = new GregorianDate(2005, 1, 1);
            Assert.AreEqual(expected, GregorianDate.ParseExact("5", "%y", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("05", "yy", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("2005", "yyyy", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 5, 0, 0);
            Assert.AreEqual(expected, GregorianDate.ParseExact("5A", "ht", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("05A", "hht", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("5", "%H", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("05", "HH", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 15, 0, 0);
            Assert.AreEqual(expected, GregorianDate.ParseExact("3P", "ht", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("03P", "hht", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("15", "%H", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.ParseExact("15", "HH", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 05, 25, 13.444);
            Assert.AreEqual(expected, GregorianDate.ParseExact("Monday, 25 February 2002 05:25:13.444", "dddd, dd MMMM yyyy HH:mm:ss.fff", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 05, 25, 13.4444444);
            Assert.AreEqual(expected, GregorianDate.ParseExact("05:25:13.4444444", "HH:mm:ss.fffffff", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 05, 25, 13.1234567);
            Assert.AreEqual(expected, GregorianDate.ParseExact("05:25:13.1234567", "HH:mm:ss.fffffff", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.1234567890);
            Assert.AreEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:13.1234567890", "MM/dd/yyyy HH:mm:ss.ffffffffff", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.44444444444444);
            Assert.AreEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:13.44444444444444", "MM/dd/yyyy HH:mm:ss.ffffffffffffff", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.12345678901234);
            Assert.AreEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:13.12345678901234", "MM/dd/yyyy HH:mm:ss.ffffffffffffff", m_cultureInfo));
            Assert.AreNotEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:13.123456789012345", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.444444444444444);
            Assert.AreEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:13.444444444444444", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));
            Assert.AreNotEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:13.444444444444446", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 0.1234567890123456);
            Assert.AreEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:00.1234567890123456", "MM/dd/yyyy HH:mm:ss.ffffffffffffffff", m_cultureInfo));
            Assert.AreNotEqual(expected, GregorianDate.ParseExact("06/30/2009 05:25:00.1234567890123459", "MM/dd/yyyy HH:mm:ss.ffffffffffffffff", m_cultureInfo));
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void ParseExactThrowsOnInvalidFormat()
        {
            GregorianDate.ParseExact("1/1/2009", "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo);
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        [SuppressMessage("ReSharper", "AssignNullToNotNullAttribute")]
        public void ParseExactThrowsOnNullFormat()
        {
            string format = null;
            GregorianDate.ParseExact("1/1/2009", format, m_cultureInfo);
        }

        [Test]
        [ExpectedException(typeof(ArgumentNullException))]
        [SuppressMessage("ReSharper", "AssignNullToNotNullAttribute")]
        public void ParseExactThrowsOnNullInput()
        {
            GregorianDate.ParseExact(null, "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo);
        }

        [Test]
        public void TestParse()
        {
            GregorianDate expected = new GregorianDate(2002, 02, 25);
            Assert.AreEqual(expected, GregorianDate.Parse("02/25/2002", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2/25/2002", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2002-02-25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2002-2-25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("Monday, 25 February 2002", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("Mon,02/25/2002", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("Mon,2/25/2002", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 05, 25, 00);
            Assert.AreEqual(expected, GregorianDate.Parse("Monday, 25 February 2002 05:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02/25/2002 05:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2/25/2002 05:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2/25/2002 5:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2002-02-25T05:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2002-2-25T05:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 05:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2-2002-25 05:25", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2-2002-25 5:25", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 05, 25, 13);
            Assert.AreEqual(expected, GregorianDate.Parse("Monday, 25 February 2002 05:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02/25/2002 05:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02/25/2002 5:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2/25/2002 5:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2002-02-25T05:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25T05:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 05:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 5:25:13", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 05:25:13 Mon", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 5:25:13 Mon", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 05:25:13 Monday", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 5:25:13 Monday", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 04, 25, 13);
            Assert.AreEqual(expected, GregorianDate.Parse("2002-02-25 04:25:13Z", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("Mon, 25 Feb 2002 04:25:13 GMT", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 25, 05, 25, 13.008);
            Assert.AreEqual(expected, GregorianDate.Parse("02/25/2002 05:25:13.008", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02/25/2002 5:25:13.008", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("2002-02-25T05:25:13.008", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25T05:25:13.008", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 05:25:13.008", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("02-2002-25 5:25:13.008", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, 02, 25);
            Assert.AreEqual(expected, GregorianDate.Parse("February 25", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, 02, 8);
            Assert.AreEqual(expected, GregorianDate.Parse("February 08", m_cultureInfo));
            Assert.AreEqual(expected, GregorianDate.Parse("February 8", m_cultureInfo));

            expected = new GregorianDate(2002, 02, 1);
            Assert.AreEqual(expected, GregorianDate.Parse("2002 February", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 05, 25, 13.4444444);
            Assert.AreEqual(expected, GregorianDate.Parse("05:25:13.4444444", m_cultureInfo));

            expected = new GregorianDate(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, 05, 25, 13.1234567);
            Assert.AreEqual(expected, GregorianDate.Parse("05:25:13.1234567", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.1234567890);
            Assert.AreEqual(expected, GregorianDate.Parse("06/30/2009 05:25:13.1234567890", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.44444444444444);
            Assert.AreEqual(expected, GregorianDate.Parse("06/30/2009 05:25:13.44444444444444", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.12345678901234);
            Assert.AreEqual(expected, GregorianDate.Parse("06/30/2009 05:25:13.12345678901234", m_cultureInfo));
            Assert.AreNotEqual(expected, GregorianDate.Parse("06/30/2009 05:25:13.12345678901239", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 13.444444444444444);
            Assert.AreEqual(expected, GregorianDate.Parse("06/30/2009 05:25:13.444444444444444", m_cultureInfo));
            Assert.AreNotEqual(expected, GregorianDate.Parse("06/30/2009 05:25:13.444444444444446", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 0.1234567890123456);
            Assert.AreEqual(expected, GregorianDate.Parse("06/30/2009 05:25:00.1234567890123456", m_cultureInfo));
            Assert.AreNotEqual(expected, GregorianDate.Parse("06/30/2009 05:25:00.1234567890123459", m_cultureInfo));

            expected = new GregorianDate(2009, 06, 30, 05, 25, 0.1234567890123456);
            GregorianDate unusedDate = new GregorianDate();
            GregorianDate.TryParse("06/30/2009 05:25:00.1234567890123456", out unusedDate);
            Assert.AreEqual(expected, unusedDate);
        }

        [Test]
        [ExpectedException(typeof(ArgumentNullException))]
        [SuppressMessage("ReSharper", "AssignNullToNotNullAttribute")]
        public void ParseThrowsOnNullInput()
        {
            GregorianDate.Parse(null, m_cultureInfo);
        }

        [Test]
        [ExpectedException(typeof(ArgumentNullException))]
        [SuppressMessage("ReSharper", "AssignNullToNotNullAttribute")]
        public void ParseThrowsOnNullInputWithoutCultureInfo()
        {
            GregorianDate.Parse(null);
        }

        [Test]
        [ExpectedException(typeof(FormatException))]
        public void ParseThrowsFormatExceptionWhenNoMatch()
        {
            GregorianDate.Parse("February Q, 2009", m_cultureInfo);
        }

        [Test]
        public void TestTryParse()
        {
            GregorianDate expected = new GregorianDate(2002, 02, 25);
            GregorianDate result;
            Assert.AreEqual(true, GregorianDate.TryParse("02/25/2002", m_cultureInfo, out result));
            Assert.AreEqual(expected, result);

            Assert.AreEqual(false, GregorianDate.TryParse("02/q/2002", m_cultureInfo, out result));
            Assert.AreEqual(GregorianDate.MinValue, result);

            Assert.AreEqual(false, GregorianDate.TryParse(null, m_cultureInfo, out result));
            Assert.AreEqual(GregorianDate.MinValue, result);
        }

        [Test]
        public void TestParsingLeapSecond()
        {
            GregorianDate expected = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
            Assert.AreEqual(expected, GregorianDate.ParseExact("31 Dec 2008 23:59:60.444", "dd MMM yyyy HH:mm:ss.fff", m_cultureInfo));
        }

        [Test]
        public void CannotParseInvalidDates()
        {
            GregorianDate result;
            Assert.AreEqual(false, GregorianDate.TryParse("02/29/2002", m_cultureInfo, out result));
            Assert.AreEqual(GregorianDate.MinValue, result);

            Assert.AreEqual(false, GregorianDate.TryParse("13/01/2002", m_cultureInfo, out result));
        }

        [Test]
        public void TestParseIso8601FormatBasic()
        {
            GregorianDate g1 = new GregorianDate(1985, 4, 12, 10, 15, 30);
            string s1 = g1.ToIso8601String(Iso8601Format.Basic);
            GregorianDate gp1 = GregorianDate.Parse(s1);
            Assert.AreEqual(g1, gp1);
        }

        private CultureInfo m_cultureInfo;
    }
}