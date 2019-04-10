using System;
using System.Collections.Generic;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// A series of tests to exercise the various date and time types.
    /// </summary>
    [TestFixture]
    public class TestJulianDateConversions
    {
        /// <summary>
        /// Tests conversion from a <see cref="JulianDate"/> to a <see cref="DateTime"/>.
        /// </summary>
        [Test]
        public void JulianToDateTime()
        {
            JulianDate julianDate = new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime);
            DateTime dateTime = julianDate.ToDateTime();
            Assert.AreEqual(2000, dateTime.Year);
            Assert.AreEqual(1, dateTime.Month);
            Assert.AreEqual(1, dateTime.Day);
            Assert.AreEqual(12, dateTime.Hour);
            Assert.AreEqual(0, dateTime.Minute);
            Assert.AreEqual(0, dateTime.Second);
            Assert.AreEqual(0, dateTime.Millisecond);
            Assert.AreEqual(DateTimeKind.Utc, dateTime.Kind);

            julianDate = new JulianDate(2453736.5, TimeStandard.CoordinatedUniversalTime);
            dateTime = julianDate.ToDateTime();
            Assert.AreEqual(2006, dateTime.Year);
            Assert.AreEqual(1, dateTime.Month);
            Assert.AreEqual(1, dateTime.Day);
            Assert.AreEqual(0, dateTime.Hour);
            Assert.AreEqual(0, dateTime.Minute);
            Assert.AreEqual(0, dateTime.Second);
            Assert.AreEqual(0, dateTime.Millisecond);
            Assert.AreEqual(DateTimeKind.Utc, dateTime.Kind);

            julianDate = new JulianDate(2441683.5, TimeStandard.CoordinatedUniversalTime);
            dateTime = julianDate.ToDateTime();
            Assert.AreEqual(1973, dateTime.Year);
            Assert.AreEqual(1, dateTime.Month);
            Assert.AreEqual(1, dateTime.Day);
            Assert.AreEqual(0, dateTime.Hour);
            Assert.AreEqual(0, dateTime.Minute);
            Assert.AreEqual(0, dateTime.Second);
            Assert.AreEqual(0, dateTime.Millisecond);
            Assert.AreEqual(DateTimeKind.Utc, dateTime.Kind);

            julianDate = new JulianDate(2441683.5, TimeStandard.InternationalAtomicTime);
            dateTime = julianDate.ToDateTime(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(DateTimeKind.Utc, dateTime.Kind);

            julianDate = new JulianDate(2441683.5, TimeStandard.InternationalAtomicTime);
            dateTime = julianDate.ToDateTime(TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(DateTimeKind.Utc, dateTime.Kind);
        }

        [Test]
        public void JulianToGregorianDate()
        {
            JulianDate julianDate = new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime);
            GregorianDate gregorianDate = julianDate.ToGregorianDate();
            Assert.AreEqual(2000, gregorianDate.Year);
            Assert.AreEqual(1, gregorianDate.Month);
            Assert.AreEqual(1, gregorianDate.Day);
            Assert.AreEqual(12, gregorianDate.Hour);
            Assert.AreEqual(0, gregorianDate.Minute);
            Assert.AreEqual(0, gregorianDate.Second);

            julianDate = new JulianDate(2453736.5, TimeStandard.CoordinatedUniversalTime);
            gregorianDate = julianDate.ToGregorianDate();
            Assert.AreEqual(2006, gregorianDate.Year);
            Assert.AreEqual(1, gregorianDate.Month);
            Assert.AreEqual(1, gregorianDate.Day);
            Assert.AreEqual(0, gregorianDate.Hour);
            Assert.AreEqual(0, gregorianDate.Minute);
            Assert.AreEqual(0, gregorianDate.Second);

            julianDate = new JulianDate(2441683.5, TimeStandard.CoordinatedUniversalTime);
            gregorianDate = julianDate.ToGregorianDate();
            Assert.AreEqual(1973, gregorianDate.Year);
            Assert.AreEqual(1, gregorianDate.Month);
            Assert.AreEqual(1, gregorianDate.Day);
            Assert.AreEqual(0, gregorianDate.Hour);
            Assert.AreEqual(0, gregorianDate.Minute);
            Assert.AreEqual(0, gregorianDate.Second);

            julianDate = new JulianDate(2441683.5, TimeStandard.CoordinatedUniversalTime);
            GregorianDate internationalTimeGregorianDate = julianDate.ToGregorianDate(TimeStandard.InternationalAtomicTime);
            Assert.AreNotEqual(gregorianDate, internationalTimeGregorianDate);
        }

        /// <summary>
        /// Test BUG40644 - JulianDate.ToDateTime rounds to the nearest millisecond
        /// </summary>
        [Test]
        [CSToJavaExclude("Java DateTime only supports millisecond precision")]
        public void TestBug40644()
        {
            JulianDate jd1 = new JulianDate(2451545, 0.0, TimeStandard.CoordinatedUniversalTime);
            JulianDate jd2 = new JulianDate(2451545, -0.0001, TimeStandard.CoordinatedUniversalTime);
            JulianDate jd3 = new JulianDate(2451545, 0.0001, TimeStandard.CoordinatedUniversalTime);

            DateTime date1 = jd1.ToDateTime();
            DateTime date2 = jd2.ToDateTime();
            DateTime date3 = jd3.ToDateTime();

            Assert.AreNotEqual(date1, date2);
            Assert.AreNotEqual(date1, date3);
            Assert.AreNotEqual(date2, date3);
        }

        /// <summary>
        /// Testing that ticks are accurately accounted for
        /// </summary>
        [Test]
        [CSToJavaExclude("Java DateTime only supports millisecond precision")]
        public void TestTicks()
        {
            DateTime yesterday = new DateTime(2008, 3, 4, 12, 5, 12, 24, DateTimeKind.Utc);
            DateTime someTimeLater = new DateTime(yesterday.Ticks + 50, DateTimeKind.Utc);

            JulianDate jDateYesterday = new JulianDate(yesterday);
            JulianDate jDateSomeTimeLater = new JulianDate(someTimeLater);

            Assert.AreNotEqual(jDateYesterday, jDateSomeTimeLater);
            Assert.AreEqual(jDateYesterday.Day, jDateSomeTimeLater.Day);
            Assert.AreEqual(jDateYesterday.SecondsOfDay, jDateSomeTimeLater.SecondsOfDay - 0.000005000, Constants.Epsilon9);
        }

        /// <summary>
        /// Tests that an appropriate exception is thrown when attempting to construct a DateTime
        /// from a JulianDate prior to the earliest possible DateTime.
        /// </summary>
        [Test]
        public void TestJulianDateMinimumToDateTime()
        {
            JulianDate date = JulianDate.MinValue;

            Assert.Throws<ArgumentOutOfRangeException>(() =>
            {
                DateTime unused = date.ToDateTime();
            });
        }

        /// <summary>
        /// Tests conversion from a <see cref="DateTime"/> to a <see cref="JulianDate"/>.
        /// </summary>
        [Test]
        public void DateTimeToJulian()
        {
            DateTime dateTime = new DateTime(2000, 1, 1, 12, 0, 0);
            JulianDate julianDate = new JulianDate(dateTime);
            Assert.AreEqual(2451545.0, julianDate.TotalDays);

            dateTime = new DateTime(2006, 1, 1, 0, 0, 0);
            julianDate = new JulianDate(dateTime);
            Assert.AreEqual(2453736.5, julianDate.TotalDays);

            dateTime = new DateTime(1973, 1, 1, 0, 0, 0);
            julianDate = new JulianDate(dateTime);
            Assert.AreEqual(2441683.5, julianDate.TotalDays);

            DateTime localDateTime = new DateTime(2000, 1, 1, 12, 0, 0, DateTimeKind.Local);
            DateTime utc = localDateTime.ToUniversalTime();
            julianDate = new JulianDate(localDateTime);
            dateTime = julianDate.ToDateTime();
            Assert.AreEqual(utc, dateTime);
        }

        [Test]
        public void GregorianDateToJulian()
        {
            GregorianDate gregorianDate = new GregorianDate(2000, 1, 1, 12, 0, 0);
            JulianDate julianDate = new JulianDate(gregorianDate);
            Assert.AreEqual(2451545.0, julianDate.TotalDays);

            gregorianDate = new GregorianDate(2006, 1, 1, 0, 0, 0);
            julianDate = new JulianDate(gregorianDate);
            Assert.AreEqual(2453736.5, julianDate.TotalDays);

            gregorianDate = new GregorianDate(1973, 1, 1, 0, 0, 0);
            julianDate = new JulianDate(gregorianDate);
            Assert.AreEqual(2441683.5, julianDate.TotalDays);

            DateTime localDateTime = new DateTime(2000, 1, 1, 12, 0, 0, DateTimeKind.Local);
            DateTime utc = localDateTime.ToUniversalTime();
            julianDate = new JulianDate(localDateTime);
            gregorianDate = julianDate.ToGregorianDate();
            Assert.AreEqual(new GregorianDate(utc), gregorianDate);
        }

        /// <summary>
        /// Tests conversion of a <see cref="DateTime"/> to a <see cref="JulianDate"/> when
        /// the <see cref="DateTime"/> is specified as a local time instead of as UTC.
        /// </summary>
        [Test]
        public void TestLocalDateTimeToJulian()
        {
            DateTime localNow = DateTime.Now;
            DateTime utcNow = localNow.ToUniversalTime();

            JulianDate localJulianDate = new JulianDate(localNow);
            JulianDate utcJulianDate = new JulianDate(utcNow);

            Assert.IsTrue(localJulianDate.EqualsEpsilon(utcJulianDate, Constants.Epsilon14));

            localNow = DateTime.Now;
            utcNow = localNow.ToUniversalTime();

            localJulianDate = new JulianDate(localNow, TimeStandard.InternationalAtomicTime);
            utcJulianDate = new JulianDate(utcNow, TimeStandard.InternationalAtomicTime);

            Assert.IsTrue(localJulianDate.EqualsEpsilon(utcJulianDate, Constants.Epsilon14));
        }

        /// <summary>
        /// Tests the "round-trip" conversion between a <see cref="DateTime"/> and a <see cref="JulianDate"/>.
        /// </summary>
        [Test]
        public void JulianDateTimeRoundTrip()
        {
            var dateTimes = new List<DateTime>
            {
                DateTime.UtcNow,
                // a previous version of the code didn't round-trip for this particular date due to 
                // an error when values were rounded
                new DateTime(2017, 8, 31, 13, 53, 32, 44, DateTimeKind.Utc)
            };

            // add a test date with all possible millisecond values
            for (int millisecond = 0; millisecond < 999; millisecond++)
            {
                dateTimes.Add(new DateTime(2017, 8, 31, 13, 53, 32, millisecond, DateTimeKind.Utc));
            }

            foreach (DateTime dateTime in dateTimes)
            {
                JulianDate julianDate = new JulianDate(dateTime);
                DateTime roundTrip = julianDate.ToDateTime();
                Assert.AreEqual(dateTime.Year, roundTrip.Year);
                Assert.AreEqual(dateTime.Month, roundTrip.Month);
                Assert.AreEqual(dateTime.Day, roundTrip.Day);
                Assert.AreEqual(dateTime.Hour, roundTrip.Hour);
                Assert.AreEqual(dateTime.Minute, roundTrip.Minute);
                Assert.AreEqual(dateTime.Second, roundTrip.Second);
                Assert.AreEqual(dateTime.Millisecond, roundTrip.Millisecond);
            }
        }

        [Test]
        public void JulianDateGregorianDateRoundTrip()
        {
            GregorianDate gregorianDate = new GregorianDate(2008, 1, 1, 1, 1, 1.00000000008);
            JulianDate julianDate = new JulianDate(gregorianDate);
            GregorianDate roundTrip = julianDate.ToGregorianDate();
            Assert.AreEqual(gregorianDate.Year, roundTrip.Year);
            Assert.AreEqual(gregorianDate.Month, roundTrip.Month);
            Assert.AreEqual(gregorianDate.Day, roundTrip.Day);
            Assert.AreEqual(gregorianDate.Hour, roundTrip.Hour);
            Assert.AreEqual(gregorianDate.Minute, roundTrip.Minute);
            Assert.AreEqual(gregorianDate.Second, roundTrip.Second, Constants.Epsilon13);
        }
    }
}