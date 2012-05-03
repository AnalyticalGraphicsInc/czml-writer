using System;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguagerWriterTests
{
    [TestFixture]
    public class TestGregorianDateFormatting
    {
        private CultureInfo m_cultureInfo;

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
            Assert.AreEqual("February, 2002", date.ToString("y", m_cultureInfo));
            Assert.AreEqual("February, 2002", date.ToString("Y", m_cultureInfo));
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

            date = new GregorianDate(2009, 06, 10, 15, 0, 13.012345678912345);
            Assert.AreEqual("13.012345678912345", date.ToString("ss.fffffffffffffff"));

            date = new GregorianDate(2009, 06, 10, 15, 0, 13.012);
            Assert.AreEqual("13.012000000000000", date.ToString("ss.fffffffffffffff"));
            Assert.AreEqual("13.012", date.ToString("ss.FFFFFFFFFFFFFFF"));
        }

        [Test]
        [ExpectedException(typeof (FormatException))]
        public void ToStringThrowsOnInvalidFormatSpecifier()
        {
            new GregorianDate(2009, 06, 10).ToString("X");
        }

        [Test]
        [ExpectedException(typeof (FormatException))]
        public void CantFormatMoreThan15FractionalSeconds()
        {
            new GregorianDate(2009, 06, 10).ToString("ffffffffffffffff");
        }

        [Test]
        [ExpectedException(typeof (FormatException))]
        public void CantEndWithAPercent()
        {
            new GregorianDate(2009, 06, 10).ToString("f%");
        }

        [Test]
        [ExpectedException(typeof (FormatException))]
        public void CantEndWithABackslash()
        {
            new GregorianDate(2009, 06, 10).ToString("f\\");
        }

        [Test]
        [ExpectedException(typeof (FormatException))]
        public void CantHaveADoublePercent()
        {
            new GregorianDate(2009, 06, 10).ToString("%%");
        }

        [Test]
        public void TestFormattingLeapSecond()
        {
            GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
            Assert.AreEqual("31 Dec 2008 23:59:60.444", date.ToString("d MMM yyyy H:mm:ss.fff", m_cultureInfo));
        }

        [Test]
        public void ToIso8601StringProducesCorrectStrings()
        {
            string iso = new GregorianDate(2012, 4, 2, 1, 2, 3.12345).ToIso8601String();
            Assert.AreEqual("2012-04-02T01:02:03.12345Z", iso);

            iso = new GregorianDate(2012, 4, 2, 1, 2, 3).ToIso8601String();
            Assert.AreEqual("2012-04-02T01:02:03Z", iso);

            iso = new GregorianDate(2012, 4, 2, 1, 2, 3).ToIso8601String();
            Assert.AreEqual("2012-04-02T01:02:03Z", iso);

            iso = new GregorianDate(2012, 4, 2, 1, 2, 0).ToIso8601String();
            Assert.AreEqual("2012-04-02T01:02:00Z", iso);

            iso = new GregorianDate(2012, 4, 2, 1, 2, 0).ToIso8601String();
            Assert.AreEqual("2012-04-02T01:02:00Z", iso);

            iso = new GregorianDate(2012, 6, 30, 23, 59, 60.123).ToIso8601String();
            Assert.AreEqual("2012-06-30T23:59:60.123Z", iso);
        }
    }
}