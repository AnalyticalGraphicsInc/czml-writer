using System;
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
            GregorianDate gd = new GregorianDate(2000, 1, 2, 6, 30, 15);
            Assert.AreEqual(2000, gd.Year);
            Assert.AreEqual(1, gd.Month);
            Assert.AreEqual(2, gd.Day);
            Assert.AreEqual(6, gd.Hour);
            Assert.AreEqual(30, gd.Minute);
            Assert.AreEqual(15, gd.Second);

            gd = new GregorianDate(2000, 1, 2);
            Assert.AreEqual(2000, gd.Year);
            Assert.AreEqual(1, gd.Month);
            Assert.AreEqual(2, gd.Day);
            Assert.AreEqual(0, gd.Hour);
            Assert.AreEqual(0, gd.Minute);
            Assert.AreEqual(0, gd.Second);
        }

        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void CannotConstructWithInvalidTime()
        {
            new GregorianDate(2000, 1, 2, 24, 0, 0);
        }

        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void CannotConstructWithInvalidDate()
        {
            new GregorianDate(2006, 2, 29, 0, 0, 0);
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

            Assert.IsTrue(date.CompareTo(sameDate) == 0);
            Assert.IsTrue(date.CompareTo(laterDay) < 0);

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
        [ExpectedException(typeof(ArgumentException))]
        [CSToJavaExclude]
        public void CompareToWithWrongTypeThrows()
        {
            GregorianDate gd = new GregorianDate(2001, 1, 1, 6, 3, 14);
            gd.CompareTo(5);
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
            GregorianDate gd1 = new GregorianDate(2001, 1, 1, 6, 3, 14);
            Assert.AreEqual("1/1/2001 6:03:14 AM", gd1.ToString(new CultureInfo("en-US")));

            gd1 = new GregorianDate(2003, 3, 4, 16, 43, 23.23452);
            Assert.AreEqual("3/4/2003 4:43:23 PM", gd1.ToString(new CultureInfo("en-US")));
        }

        [Test]
        [CSToJavaExclude]
        public void TestToStringThreadFormatProvider()
        {
            CultureInfo originalCulture = Thread.CurrentThread.CurrentCulture;
            try
            {
                Thread.CurrentThread.CurrentCulture = new CultureInfo("en-US");
                GregorianDate gd1 = new GregorianDate(2001, 1, 1, 6, 3, 14);
                Assert.AreEqual("1/1/2001 6:03:14 AM", gd1.ToString());

                // Windows 8 changed to no longer use a two digit day.  Either is ok.
                Assert.IsTrue(gd1.ToLongDateString() == "Monday, January 01, 2001" || gd1.ToLongDateString() == "Monday, January 1, 2001");

                Assert.AreEqual("6:03:14 AM", gd1.ToLongTimeString());
                Assert.AreEqual("1/1/2001", gd1.ToShortDateString());
                Assert.AreEqual("6:03 AM", gd1.ToShortTimeString());

                gd1 = new GregorianDate(2003, 3, 4, 16, 43, 23.23452);
                Assert.AreEqual("3/4/2003 4:43:23 PM", gd1.ToString());
                Assert.IsTrue(gd1.ToLongDateString() == "Tuesday, March 04, 2003" || gd1.ToLongDateString() == "Tuesday, March 4, 2003");
                Assert.AreEqual("4:43:23 PM", gd1.ToLongTimeString());
                Assert.AreEqual("3/4/2003", gd1.ToShortDateString());
                Assert.AreEqual("4:43 PM", gd1.ToShortTimeString());
            }
            finally
            {
                Thread.CurrentThread.CurrentCulture = originalCulture;
            }
        }

        [Test]
        public void CanConstructFromJulianDate()
        {
            {
                JulianDate jd = new JulianDate(new DateTime(2008, 10, 23, 12, 5, 30, 300));

                GregorianDate gd = new GregorianDate(jd);
                Assert.AreEqual(2008, gd.Year);
                Assert.AreEqual(10, gd.Month);
                Assert.AreEqual(23, gd.Day);
                Assert.AreEqual(12, gd.Hour);
                Assert.AreEqual(5, gd.Minute);
                Assert.AreEqual(30.300, gd.Second, Constants.Epsilon11);
            }

            {
                JulianDate jd = new JulianDate(new DateTime(2008, 10, 23, 0, 0, 0));

                GregorianDate gd = new GregorianDate(jd);
                Assert.AreEqual(2008, gd.Year);
                Assert.AreEqual(10, gd.Month);
                Assert.AreEqual(23, gd.Day);
                Assert.AreEqual(0, gd.Hour);
                Assert.AreEqual(0, gd.Minute);
                Assert.AreEqual(0.0, gd.Second, Constants.Epsilon11);
            }

            {
                JulianDate jd = new JulianDate(new DateTime(2008, 10, 23, 23, 59, 59, 999));

                GregorianDate gd = new GregorianDate(jd);
                Assert.AreEqual(2008, gd.Year);
                Assert.AreEqual(10, gd.Month);
                Assert.AreEqual(23, gd.Day);
                Assert.AreEqual(23, gd.Hour);
                Assert.AreEqual(59, gd.Minute);
                Assert.AreEqual(59.999, gd.Second, Constants.Epsilon11);
            }
        }

        [Test]
        public void CanConvertToJulianDate()
        {
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
            }

            {
                GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 01, 01, 01);

                JulianDate julianDate = gregorianDate.ToJulianDate();

                GregorianDate newGregorianDate = new GregorianDate(julianDate);

                Assert.AreEqual(gregorianDate.Year, newGregorianDate.Year);
                Assert.AreEqual(gregorianDate.Month, newGregorianDate.Month);
                Assert.AreEqual(gregorianDate.Day, newGregorianDate.Day);
                Assert.AreEqual(gregorianDate.Hour, newGregorianDate.Hour);
                Assert.AreEqual(gregorianDate.Minute, newGregorianDate.Minute);
                Assert.AreEqual(gregorianDate.Second, newGregorianDate.Second, Constants.Epsilon11);
            }
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
            GregorianDate gd = new GregorianDate(new JulianDate(2046050, julianSecondsOfDay, TimeStandard.CoordinatedUniversalTime));
            Assert.AreEqual(julianSecondsOfDay, gd.JulianSecondsOfDay, Constants.Epsilon11);
        }

        [Test]
        public void TestYearDayConstructor()
        {
            DateTime aTime = new DateTime(2000, 2, 28, 1, 3, 4);
            Assert.AreEqual(31 + 28, aTime.DayOfYear); //* January has 31 days, so add 28 to that...
            GregorianDate sameDate = new GregorianDate(aTime.Year, aTime.DayOfYear);
            Assert.AreEqual(2000, sameDate.Year);
            Assert.AreEqual(59, sameDate.DayOfYear);
            Assert.AreEqual(2, sameDate.Month);
            Assert.AreEqual(0, sameDate.Hour);
            Assert.AreEqual(0, sameDate.Minute);
            Assert.AreEqual(0, sameDate.Second);

            sameDate = new GregorianDate(2000, 60.6); //* 60 days and 14.4 hours, or 14 hours and 24 minutes (1/10 of a day is 2.4 hours, times that by 6)
            Assert.AreEqual(2000, sameDate.Year);
            Assert.AreEqual(60, sameDate.DayOfYear);
            Assert.AreEqual(2, sameDate.Month); //* leap year
            Assert.AreEqual(14, sameDate.Hour);
            Assert.AreEqual(24, sameDate.Minute);
            Assert.AreEqual(0, sameDate.Second, Constants.Epsilon9); //* Richard and Michael both said this is ok
        }

        [Test]
        public void TestDayOfYear()
        {
            GregorianDate date = new GregorianDate(2000, 1, 1);
            Assert.AreEqual(date.DayOfYear, 1);
            date = new GregorianDate(2000, 2, 1);
            Assert.AreEqual(date.DayOfYear, 32);

            date = new GregorianDate(2003, 12, 31);
            Assert.AreEqual(date.DayOfYear, 365);
            date = new GregorianDate(2004, 12, 31);
            Assert.AreEqual(date.DayOfYear, 366);

            date = new GregorianDate(2000, 250);
            Assert.AreEqual(date.DayOfYear, 250);
            date = new GregorianDate(2000, 250.5);
            Assert.AreEqual(date.DayOfYear, 250);
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
            //12/30/2008 was not the day of a leap second day.
            Assert.IsFalse(GregorianDate.IsValid(2008, 12, 30, 23, 59, 60));

            //23:58 is one minute before a valid leap second.
            Assert.IsFalse(GregorianDate.IsValid(2008, 12, 31, 23, 58, 60));
        }

        [Test]
        public void CanConstructGregorianDateRepresentingLeapSecond()
        {
            GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60);
            Assert.AreEqual(60, date.Second, Constants.Epsilon14);
        }

        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void CannotConstructGregorianDateRepresentingInvalidLeapSecond()
        {
            new GregorianDate(2008, 12, 30, 23, 59, 60);
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

            JulianDate jd = gregorianDate.ToJulianDate(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, jd.Standard);

            GregorianDate roundTrip1 = jd.ToGregorianDate(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(gregorianDate, roundTrip1);

            GregorianDate roundTrip = new GregorianDate(jd);
            Assert.AreNotEqual(gregorianDate, roundTrip);

            double expectedDifference = LeapSeconds.Instance.GetTaiMinusUtc(jd);
            Assert.AreEqual(expectedDifference, gregorianDate.Second - roundTrip.Second);
        }

        [Test]
        public void TestRoundTripDefaultConstructed()
        {
            GregorianDate gd = new GregorianDate();
            GregorianDate gd2 = new GregorianDate(gd.ToJulianDate());

            Assert.AreEqual(gd, gd2);
        }

        [Test]
        public void RoundSecondsRoundsFractionalSeconds()
        {
            GregorianDate gd = new GregorianDate(2012, 8, 7, 13, 59, 55.5152535);
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.5152535), gd.RoundSeconds(7));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.515254), gd.RoundSeconds(6));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.51525), gd.RoundSeconds(5));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.5153), gd.RoundSeconds(4));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.515), gd.RoundSeconds(3));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.52), gd.RoundSeconds(2));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 55.5), gd.RoundSeconds(1));
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 59, 56), gd.RoundSeconds(0));
        }

        [Test]
        public void RoundSecondsRollsOver()
        {
            GregorianDate gd = new GregorianDate(2012, 8, 7, 13, 55, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 13, 56, 0.0), gd.RoundSeconds(6));

            gd = new GregorianDate(2012, 8, 7, 13, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 8, 7, 14, 0, 0.0), gd.RoundSeconds(6));

            gd = new GregorianDate(2012, 8, 7, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 8, 8, 0, 0, 0.0), gd.RoundSeconds(6));

            gd = new GregorianDate(2012, 8, 31, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 9, 1, 0, 0, 0.0), gd.RoundSeconds(6));

            gd = new GregorianDate(2012, 12, 31, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2013, 1, 1, 0, 0, 0.0), gd.RoundSeconds(6));
        }

        [Test]
        public void RoundSecondsAllows61SecondsDuringLeapSecond()
        {
            GregorianDate gd = new GregorianDate(2012, 6, 30, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 6, 30, 23, 59, 60.0), gd.RoundSeconds(6));

            gd = new GregorianDate(2012, 6, 30, 23, 59, 60.9999999);
            Assert.AreEqual(new GregorianDate(2012, 7, 1, 0, 0, 0.0), gd.RoundSeconds(6));
        }

        [Test]
        public void RoundSecondsDoesNotAllow61SecondsDuringLeapSecondIfTimeStandardIsNotUtc()
        {
            GregorianDate gd = new GregorianDate(2012, 6, 30, 23, 59, 59.9999999);
            Assert.AreEqual(new GregorianDate(2012, 7, 1, 0, 0, 0.0), gd.RoundSeconds(6, TimeStandard.InternationalAtomicTime));
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