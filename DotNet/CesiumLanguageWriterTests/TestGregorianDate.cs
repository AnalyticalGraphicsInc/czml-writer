using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.Threading;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestGregorianDate
    {
        [Test]
        public void CanConstructGregorianDate()
        {
            GregorianDate gregorianDate = new GregorianDate(2000, 1, 2, 6, 30, 15);
            Assert.AreEqual(2000, gregorianDate.Year);
            Assert.AreEqual(1, gregorianDate.Month);
            Assert.AreEqual(2, gregorianDate.Day);
            Assert.AreEqual(6, gregorianDate.Hour);
            Assert.AreEqual(30, gregorianDate.Minute);
            Assert.AreEqual(15, gregorianDate.Second);

            gregorianDate = new GregorianDate(2000, 1, 2);
            Assert.AreEqual(2000, gregorianDate.Year);
            Assert.AreEqual(1, gregorianDate.Month);
            Assert.AreEqual(2, gregorianDate.Day);
            Assert.AreEqual(0, gregorianDate.Hour);
            Assert.AreEqual(0, gregorianDate.Minute);
            Assert.AreEqual(0, gregorianDate.Second);
        }

        [Test]
        public void CannotConstructWithInvalidTime()
        {
            var exception = Assert.Throws<ArgumentException>(() =>
            {
                var unused = new GregorianDate(2000, 1, 2, 24, 0, 0);
            });
            StringAssert.Contains("One or more of the hour, minute, and second arguments is outside of the acceptable range", exception.Message);
        }

        [Test]
        public void CannotConstructWithInvalidDate()
        {
            var exception = Assert.Throws<ArgumentException>(() =>
            {
                var unused = new GregorianDate(2006, 2, 29, 0, 0, 0);
            });
            StringAssert.Contains("One or more of the hour, minute, and second arguments is outside of the acceptable range", exception.Message);
        }

        [Test]
        public void IsValidValidatesProperly()
        {
            Assert.IsFalse(GregorianDate.IsValid(2000, 0, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 2, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 3, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 4, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 5, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 6, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 7, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 8, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 9, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 10, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 11, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 12, 1, 0, 0, 0));
            Assert.IsFalse(GregorianDate.IsValid(2000, 13, 1, 0, 0, 0));

            Assert.IsFalse(GregorianDate.IsValid(2000, 1, 1, -1, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 0, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 23, 0, 0));
            Assert.IsFalse(GregorianDate.IsValid(2000, 1, 1, 24, 0, 0));

            Assert.IsFalse(GregorianDate.IsValid(2000, 1, 1, 6, -1, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 6, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 6, 59, 0));
            Assert.IsFalse(GregorianDate.IsValid(2000, 1, 1, 6, 60, 0));

            Assert.IsFalse(GregorianDate.IsValid(2000, 1, 1, 6, 0, -1));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 6, 0, 0));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 6, 0, 0.00001));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 6, 0, 59));
            Assert.IsTrue(GregorianDate.IsValid(2000, 1, 1, 6, 0, 59.9));
            Assert.IsFalse(GregorianDate.IsValid(2000, 1, 1, 6, 0, 60));
        }

        [Test]
        public void TestEquality()
        {
            GregorianDate first = new GregorianDate(2000, 1, 1, 5, 1, 1);
            GregorianDate second = new GregorianDate(2000, 1, 1, 5, 1, 1);
            Assert.AreEqual(first, second);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));
            Assert.AreEqual(0, first.CompareTo(second));
            Assert.AreEqual(0, second.CompareTo(first));

            second = new GregorianDate(2000, 1, 1, 6, 1, 1);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            second = new GregorianDate(2000, 2, 1, 5, 1, 1);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            Assert.AreNotEqual(first, 5);
        }

        [Test]
        public void TestEqualityInTimePortion()
        {
            GregorianDate first = new GregorianDate(1999, 10, 10, 5, 1, 1);
            GregorianDate second = new GregorianDate(1999, 10, 10, 5, 1, 1);
            Assert.AreEqual(first, second);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));
            Assert.AreEqual(0, first.CompareTo(second));
            Assert.AreEqual(0, second.CompareTo(first));

            second = new GregorianDate(1999, 10, 10, 6, 1, 1);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            second = new GregorianDate(1999, 10, 10, 5, 2, 1);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            second = new GregorianDate(1999, 10, 10, 5, 1, 2);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            Assert.AreNotEqual(first, 5);
        }

        [Test]
        public void TestEqualityWithFractionalSeconds()
        {
            GregorianDate first = new GregorianDate(2009, 06, 30, 05, 25, 13.12345678901234);
            GregorianDate second = new GregorianDate(2009, 06, 30, 05, 25, 13.12345678901239);
            GregorianDate equal = new GregorianDate(2009, 06, 30, 05, 25, 13.12345678901234);

            Assert.AreNotEqual(13.12345678901234, 13.12345678901239);
            Assert.AreNotEqual(first, second);
            Assert.AreEqual(first, equal);
        }

        [Test]
        public void TestComparisons()
        {
            GregorianDate date = new GregorianDate(2001, 1, 1, 6, 3, 14);
            GregorianDate sameDate = new GregorianDate(2001, 1, 1, 6, 3, 14);

            GregorianDate laterTime = new GregorianDate(2001, 1, 1, 6, 5, 26);
            GregorianDate laterDay = new GregorianDate(2001, 2, 2, 6, 3, 14);

            Assert.IsTrue(date == sameDate);
            Assert.IsTrue(sameDate == date);

            Assert.IsTrue(date != laterTime);

            Assert.IsTrue(date >= sameDate);
            Assert.IsTrue(date <= sameDate);

            Assert.AreEqual(0, date.CompareTo(sameDate));
            Assert.Less(date.CompareTo(laterDay), 0);

            Assert.IsTrue(sameDate < laterTime);
            Assert.IsTrue(sameDate <= laterTime);

            Assert.IsTrue(laterTime > sameDate);
            Assert.IsTrue(laterTime >= sameDate);

            object dateAsObject = new GregorianDate(2001, 1, 1, 6, 3, 15);
            Assert.AreNotEqual(date, dateAsObject);
        }

        [Test]
        [CSToJavaExclude]
        public void TestCompareToObject()
        {
            GregorianDate date = new GregorianDate(2001, 1, 1, 6, 3, 14);
            object dateAsObject = new GregorianDate(2001, 1, 1, 6, 3, 15);

            Assert.IsTrue(date.CompareTo(null) > 0);
            Assert.IsTrue(date.CompareTo(dateAsObject) < 0);
        }

        [Test]
        public void TestComparisonsOfTimePortion()
        {
            GregorianDate gd1 = new GregorianDate(1999, 10, 10, 6, 3, 14);
            GregorianDate gd2 = new GregorianDate(1999, 10, 10, 6, 3, 14);
            GregorianDate gd3 = new GregorianDate(1999, 10, 10, 6, 5, 26);
            object gd4 = new GregorianDate(1999, 10, 10, 4, 2, 21);

            Assert.IsTrue(gd1 == gd2);
            Assert.IsTrue(gd2 == gd1);
            Assert.IsTrue(gd1 != gd3);
            Assert.IsTrue(gd1 >= gd2);
            Assert.IsTrue(gd1 <= gd2);
            Assert.IsTrue(gd1.CompareTo(gd2) == 0);
            Assert.IsTrue(gd2 < gd3);
            Assert.IsTrue(gd2 <= gd3);
            Assert.IsTrue(gd3 > gd2);
            Assert.IsTrue(gd3 >= gd2);
            Assert.AreNotEqual(gd1, gd4);
        }

        [Test]
        [CSToJavaExclude]
        public void TestCompareTimePortionObject()
        {
            GregorianDate gd1 = new GregorianDate(1999, 10, 10, 6, 3, 14);
            object gd4 = new GregorianDate(1999, 10, 10, 4, 2, 21);

            Assert.IsTrue(gd1.CompareTo(null) > 0);
            Assert.IsTrue(gd1.CompareTo(gd4) > 0);
        }

        [Test]
        [CSToJavaExclude]
        public void CompareToWithWrongTypeThrows()
        {
            GregorianDate gd = new GregorianDate(2001, 1, 1, 6, 3, 14);

            Assert.Throws<ArgumentException>(() =>
            {
                int unused = gd.CompareTo(5);
            });
        }

        [Test]
        public void TestGetHashCode()
        {
            GregorianDate date = new GregorianDate(2001, 1, 1, 6, 3, 14);
            GregorianDate sameDate = new GregorianDate(2001, 1, 1, 6, 3, 14);
            GregorianDate differentTime = new GregorianDate(2001, 1, 1, 6, 5, 26);
            GregorianDate differentDay = new GregorianDate(2001, 2, 3, 6, 3, 14);

            Assert.AreEqual(date.GetHashCode(), sameDate.GetHashCode());
            Assert.AreNotEqual(date.GetHashCode(), differentTime.GetHashCode());
            Assert.AreNotEqual(date.GetHashCode(), differentDay.GetHashCode());
        }

        [Test]
        public void TestToStringFormatProvider()
        {
            var cultureInfo = new CultureInfo("en-US");

            var date = new DateTime(2001, 1, 1, 6, 3, 14, DateTimeKind.Utc);
            var gregorianDate = new GregorianDate(date);
            Assert.AreEqual(date.ToString(cultureInfo), gregorianDate.ToString(cultureInfo));

            date = new DateTime(2003, 3, 4, 16, 43, 23, 234, DateTimeKind.Utc);
            gregorianDate = new GregorianDate(date);
            Assert.AreEqual(date.ToString(cultureInfo), gregorianDate.ToString(cultureInfo));
        }

        [TestFixture]
        [CSToJavaExclude]
        public class TestNonEnglishCulture
        {
            private CultureInfo m_originalCulture;

            [SetUp]
            public void SetUp()
            {
                m_originalCulture = Thread.CurrentThread.CurrentCulture;
                Thread.CurrentThread.CurrentCulture = new CultureInfo("en-US");
            }

            [TearDown]
            public void TearDown()
            {
                Thread.CurrentThread.CurrentCulture = m_originalCulture;
            }

            [Test]
            [SuppressMessage("ReSharper", "SpecifyACultureInStringConversionExplicitly")]
            public void TestToStringThreadFormatProvider()
            {
                var date = new DateTime(2001, 1, 1, 6, 3, 14, DateTimeKind.Utc);
                var gregorianDate = new GregorianDate(date);
                Assert.AreEqual(date.ToString(), gregorianDate.ToString());
                Assert.AreEqual(date.ToLongDateString(), gregorianDate.ToLongDateString());
                Assert.AreEqual(date.ToLongTimeString(), gregorianDate.ToLongTimeString());
                Assert.AreEqual(date.ToShortDateString(), gregorianDate.ToShortDateString());
                Assert.AreEqual(date.ToShortTimeString(), gregorianDate.ToShortTimeString());

                date = new DateTime(2003, 3, 4, 16, 43, 23, 234, DateTimeKind.Utc);
                gregorianDate = new GregorianDate(date);
                Assert.AreEqual(date.ToString(), gregorianDate.ToString());
                Assert.AreEqual(date.ToLongDateString(), gregorianDate.ToLongDateString());
                Assert.AreEqual(date.ToLongTimeString(), gregorianDate.ToLongTimeString());
                Assert.AreEqual(date.ToShortDateString(), gregorianDate.ToShortDateString());
                Assert.AreEqual(date.ToShortTimeString(), gregorianDate.ToShortTimeString());
            }
        }

        [Test]
        public void CanConstructFromJulianDate()
        {
            JulianDate julianDate = new JulianDate(new DateTime(2008, 10, 23, 12, 5, 30, 300));

            GregorianDate gregorianDate = new GregorianDate(julianDate);
            Assert.AreEqual(2008, gregorianDate.Year);
            Assert.AreEqual(10, gregorianDate.Month);
            Assert.AreEqual(23, gregorianDate.Day);
            Assert.AreEqual(12, gregorianDate.Hour);
            Assert.AreEqual(5, gregorianDate.Minute);
            Assert.AreEqual(30.300, gregorianDate.Second, Constants.Epsilon11);

            julianDate = new JulianDate(new DateTime(2008, 10, 23, 0, 0, 0));

            gregorianDate = new GregorianDate(julianDate);
            Assert.AreEqual(2008, gregorianDate.Year);
            Assert.AreEqual(10, gregorianDate.Month);
            Assert.AreEqual(23, gregorianDate.Day);
            Assert.AreEqual(0, gregorianDate.Hour);
            Assert.AreEqual(0, gregorianDate.Minute);
            Assert.AreEqual(0.0, gregorianDate.Second, Constants.Epsilon11);

            julianDate = new JulianDate(new DateTime(2008, 10, 23, 23, 59, 59, 999));

            gregorianDate = new GregorianDate(julianDate);
            Assert.AreEqual(2008, gregorianDate.Year);
            Assert.AreEqual(10, gregorianDate.Month);
            Assert.AreEqual(23, gregorianDate.Day);
            Assert.AreEqual(23, gregorianDate.Hour);
            Assert.AreEqual(59, gregorianDate.Minute);
            Assert.AreEqual(59.999, gregorianDate.Second, Constants.Epsilon11);
        }

        [Test]
        public void CanConvertToJulianDate()
        {
            GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 23, 59, 59.999);
            JulianDate julianDate = gregorianDate.ToJulianDate();
            GregorianDate newGregorianDate = new GregorianDate(julianDate);

            Assert.AreEqual(gregorianDate.Year, newGregorianDate.Year);
            Assert.AreEqual(gregorianDate.Month, newGregorianDate.Month);
            Assert.AreEqual(gregorianDate.Day, newGregorianDate.Day);
            Assert.AreEqual(gregorianDate.Hour, newGregorianDate.Hour);
            Assert.AreEqual(gregorianDate.Minute, newGregorianDate.Minute);
            Assert.AreEqual(gregorianDate.Second, newGregorianDate.Second, Constants.Epsilon11);

            gregorianDate = new GregorianDate(2008, 10, 23, 01, 01, 01);
            julianDate = gregorianDate.ToJulianDate();
            newGregorianDate = new GregorianDate(julianDate);

            Assert.AreEqual(gregorianDate.Year, newGregorianDate.Year);
            Assert.AreEqual(gregorianDate.Month, newGregorianDate.Month);
            Assert.AreEqual(gregorianDate.Day, newGregorianDate.Day);
            Assert.AreEqual(gregorianDate.Hour, newGregorianDate.Hour);
            Assert.AreEqual(gregorianDate.Minute, newGregorianDate.Minute);
            Assert.AreEqual(gregorianDate.Second, newGregorianDate.Second, Constants.Epsilon11);
        }

        [Test]
        public void CanConstructFromDateTime()
        {
            GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 23, 59, 59.999);
            GregorianDate constructedFromDateTime = new GregorianDate(new DateTime(2008, 10, 23, 23, 59, 59, 999));
            Assert.AreEqual(gregorianDate, constructedFromDateTime);
        }

        [Test]
        public void LocalDateTimesAreConvertedToUTC()
        {
            DateTime date = new DateTime(2008, 10, 23, 23, 59, 59, 999, DateTimeKind.Local);
            GregorianDate constructedFromLocalDateTime = new GregorianDate(date);

            GregorianDate constructedFromUTCDateTime = new GregorianDate(date.ToUniversalTime());
            Assert.AreEqual(constructedFromLocalDateTime, constructedFromUTCDateTime);
        }

        [Test]
        public void TestMinValue()
        {
            Assert.Less(GregorianDate.MinValue, new GregorianDate(2009, 1, 1));
        }

        [Test]
        public void TestMaxValue()
        {
            Assert.Greater(GregorianDate.MaxValue, new GregorianDate(2009, 1, 1));
        }

        [Test]
        public void TestJulianSecondsOfDay()
        {
            const double julianSecondsOfDay = 0.05486;
            GregorianDate gregorianDate = new GregorianDate(new JulianDate(2046050, julianSecondsOfDay, TimeStandard.CoordinatedUniversalTime));
            Assert.AreEqual(julianSecondsOfDay, gregorianDate.JulianSecondsOfDay, Constants.Epsilon11);
        }

        [Test]
        public void TestYearDayConstructor()
        {
            DateTime dateTime = new DateTime(2000, 2, 28, 1, 3, 4);
            Assert.AreEqual(31 + 28, dateTime.DayOfYear); // January has 31 days, so add 28 to that...

            GregorianDate gregorianDate = new GregorianDate(dateTime.Year, dateTime.DayOfYear);
            Assert.AreEqual(2000, gregorianDate.Year);
            Assert.AreEqual(59, gregorianDate.DayOfYear);
            Assert.AreEqual(2, gregorianDate.Month);
            Assert.AreEqual(0, gregorianDate.Hour);
            Assert.AreEqual(0, gregorianDate.Minute);
            Assert.AreEqual(0, gregorianDate.Second);

            gregorianDate = new GregorianDate(2000, 60.6); // 60 days and 14.4 hours, or 14 hours and 24 minutes (1/10 of a day is 2.4 hours, times that by 6)
            Assert.AreEqual(2000, gregorianDate.Year);
            Assert.AreEqual(60, gregorianDate.DayOfYear);
            Assert.AreEqual(2, gregorianDate.Month); // leap year
            Assert.AreEqual(14, gregorianDate.Hour);
            Assert.AreEqual(24, gregorianDate.Minute);
            Assert.AreEqual(0, gregorianDate.Second, Constants.Epsilon9); // Richard and Michael both said this is ok
        }

        [Test]
        public void TestDayOfYear()
        {
            GregorianDate date = new GregorianDate(2000, 1, 1);
            Assert.AreEqual(1, date.DayOfYear);
            date = new GregorianDate(2000, 2, 1);
            Assert.AreEqual(32, date.DayOfYear);

            date = new GregorianDate(2003, 12, 31);
            Assert.AreEqual(365, date.DayOfYear);
            date = new GregorianDate(2004, 12, 31);
            Assert.AreEqual(366, date.DayOfYear);

            date = new GregorianDate(2000, 250);
            Assert.AreEqual(250, date.DayOfYear);
            date = new GregorianDate(2000, 250.5);
            Assert.AreEqual(250, date.DayOfYear);
        }

        [Test]
        public void TestSixtySecondsAreValidIfTheInstantRepresentsALeapSecond()
        {
            Assert.IsTrue(GregorianDate.IsValid(2008, 12, 31, 23, 59, 60));
            Assert.IsTrue(GregorianDate.IsValid(2008, 12, 31, 23, 59, 60.999));
        }

        [Test]
        public void TestSixtySecondsAreNotValidIfTheInstantDoesNotRepresentALeapSecond()
        {
            // 12/30/2008 was not the day of a leap second day.
            Assert.IsFalse(GregorianDate.IsValid(2008, 12, 30, 23, 59, 60));

            // 23:58 is one minute before a valid leap second.
            Assert.IsFalse(GregorianDate.IsValid(2008, 12, 31, 23, 58, 60));
        }

        [Test]
        public void CanConstructGregorianDateRepresentingLeapSecond()
        {
            GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60);
            Assert.AreEqual(60, date.Second, Constants.Epsilon14);
        }

        [Test]
        public void CannotConstructGregorianDateRepresentingInvalidLeapSecond()
        {
            var exception = Assert.Throws<ArgumentException>(() =>
            {
                var unused = new GregorianDate(2008, 12, 30, 23, 59, 60);
            });
            StringAssert.Contains("One or more of the hour, minute, and second arguments is outside of the acceptable range", exception.Message);
        }

        /// <summary>
        /// A simple test of the <see cref="GregorianDate.Now"/> method.
        /// </summary>
        [Test]
        public void TestGregorianDateNow()
        {
            GregorianDate first = GregorianDate.Now;
            Thread.Sleep(100);
            GregorianDate second = GregorianDate.Now;

            Assert.Greater(second, first);
        }

        [Test]
        public void TestConversionToJulianDate()
        {
            GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 0);

            JulianDate julianDate = date.ToJulianDate();

            GregorianDate oneSecondLater = new GregorianDate(2008, 12, 31, 23, 59, 1);
            GregorianDate oneSecondBefore = new GregorianDate(2008, 12, 31, 23, 58, 59);

            Assert.AreEqual(1, oneSecondLater.ToJulianDate().Subtract(julianDate).Seconds);
            Assert.AreEqual(1, julianDate.Subtract(oneSecondBefore.ToJulianDate()).Seconds);
        }

        [Test]
        public void CanConvertGregorianDateRepresentingLeapSecondToJulianDate()
        {
            GregorianDate leapSecondGregorianDate = new GregorianDate(2008, 12, 31, 23, 59, 60);
            JulianDate leapSecondJulianDate = leapSecondGregorianDate.ToJulianDate();

            Assert.AreEqual(leapSecondGregorianDate, leapSecondJulianDate.ToGregorianDate());

            GregorianDate oneSecondLater = new GregorianDate(2009, 1, 1, 0, 0, 0);
            GregorianDate oneSecondBefore = new GregorianDate(2008, 12, 31, 23, 59, 59);

            Assert.AreEqual(1, oneSecondLater.ToJulianDate().Subtract(leapSecondJulianDate).Seconds);
            Assert.AreEqual(1, leapSecondJulianDate.Subtract(oneSecondBefore.ToJulianDate()).Seconds);
        }

        [Test]
        public void TestNonStandardTimeStandard()
        {
            GregorianDate gregorianDate = new GregorianDate(2008, 12, 31, 23, 59, 40);

            JulianDate julianDate = gregorianDate.ToJulianDate(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, julianDate.Standard);

            GregorianDate roundTrip = julianDate.ToGregorianDate(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(gregorianDate, roundTrip);

            roundTrip = new GregorianDate(julianDate);
            Assert.AreNotEqual(gregorianDate, roundTrip);

            double expectedDifference = LeapSeconds.Instance.GetTaiMinusUtc(julianDate);
            Assert.AreEqual(expectedDifference, gregorianDate.Second - roundTrip.Second);
        }

        [Test]
        public void TestRoundTripDefaultConstructed()
        {
            GregorianDate gregorianDate1 = new GregorianDate();
            GregorianDate gregorianDate2 = new GregorianDate(gregorianDate1.ToJulianDate());

            Assert.AreEqual(gregorianDate1, gregorianDate2);
        }

        [Test]
        public void RoundSecondsRoundsFractionalSeconds()
        {
            GregorianDate gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.5152535);
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.5152535), gregorianDate.RoundSeconds(7));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.515254), gregorianDate.RoundSeconds(6));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.51525), gregorianDate.RoundSeconds(5));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.5153), gregorianDate.RoundSeconds(4));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.515), gregorianDate.RoundSeconds(3));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.52), gregorianDate.RoundSeconds(2));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.5), gregorianDate.RoundSeconds(1));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 56), gregorianDate.RoundSeconds(0));
        }

        [Test]
        public void RoundSecondsRollsOver()
        {
            GregorianDate gregorianDate = new GregorianDate(2012, 8, 7, 13, 55, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 56, 0.0), gregorianDate.RoundSeconds(6));

            gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 14, 0, 0.0), gregorianDate.RoundSeconds(6));

            gregorianDate = new GregorianDate(2012, 8, 7, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 8, 8, 0, 0, 0.0), gregorianDate.RoundSeconds(6));

            gregorianDate = new GregorianDate(2012, 8, 31, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 9, 1, 0, 0, 0.0), gregorianDate.RoundSeconds(6));

            gregorianDate = new GregorianDate(2012, 12, 31, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2013, 1, 1, 0, 0, 0.0), gregorianDate.RoundSeconds(6));
        }

        [Test]
        public void RoundSecondsAllows61SecondsDuringLeapSecond()
        {
            GregorianDate gregorianDate = new GregorianDate(2012, 6, 30, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 6, 30, 23, 59, 60.0), gregorianDate.RoundSeconds(6));

            gregorianDate = new GregorianDate(2012, 6, 30, 23, 59, 60.9999999);
            Assert.AreEqual(new GregorianDate(2012, 7, 1, 0, 0, 0.0), gregorianDate.RoundSeconds(6));
        }

        [Test]
        public void RoundSecondsDoesNotAllow61SecondsDuringLeapSecondIfTimeStandardIsNotUtc()
        {
            GregorianDate gregorianDate = new GregorianDate(2012, 6, 30, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 7, 1, 0, 0, 0.0), gregorianDate.RoundSeconds(6, TimeStandard.InternationalAtomicTime));
        }

        [Test]
        public void MaxValueRoundTripsThroughJulianDate()
        {
            JulianDate max = GregorianDate.MaxValue.ToJulianDate();
            GregorianDate date = max.ToGregorianDate();
            string iso = date.ToIso8601String(Iso8601Format.Extended, 6);
            string expected = GregorianDate.MaxValue.ToIso8601String(Iso8601Format.Extended, 6);

            Assert.AreEqual(expected, iso);
        }
    }
}