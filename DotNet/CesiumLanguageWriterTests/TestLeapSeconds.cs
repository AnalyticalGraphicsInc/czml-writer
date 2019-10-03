using System;
using System.Collections.Generic;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestLeapSeconds
    {
        /// <summary>
        /// Tests that epochs outside the leap second table range are supported.
        /// </summary>
        [Test]
        public void TestExtremes()
        {
            LeapSeconds leapSeconds = new LeapSeconds();

            JulianDate epochBefore = new JulianDate(2440000.5, TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(10, leapSeconds.GetTaiMinusUtc(epochBefore));
            epochBefore = new JulianDate(epochBefore.Day, epochBefore.SecondsOfDay, TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(10, leapSeconds.GetTaiMinusUtc(epochBefore));

            JulianDate epochAfter = new JulianDate(2453770.5, TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(33, leapSeconds.GetTaiMinusUtc(epochAfter));
            epochAfter = new JulianDate(epochAfter.Day, epochAfter.SecondsOfDay, TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(33, leapSeconds.GetTaiMinusUtc(epochAfter));
        }

        /// <summary>
        /// Tests that the look-up operation produces the same result using either the
        /// <see cref="TimeStandard.InternationalAtomicTime"/> standard or the <see cref="TimeStandard.CoordinatedUniversalTime"/> standard.
        /// </summary>
        [Test]
        public void TestGetLeapSecondsForDateTaiUtc()
        {
            LeapSeconds leapSeconds = new LeapSeconds();

            JulianDate tai = new JulianDate(2447162.5, TimeStandard.InternationalAtomicTime);
            JulianDate utc = tai.ToTimeStandard(TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(leapSeconds.GetTaiMinusUtc(tai), leapSeconds.GetTaiMinusUtc(utc));

            utc = new JulianDate(2445151.5, TimeStandard.CoordinatedUniversalTime);
            tai = utc.ToTimeStandard(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(leapSeconds.GetTaiMinusUtc(utc), leapSeconds.GetTaiMinusUtc(tai));
        }

        /// <summary>
        /// Tests the method which reports whether the indicated Julian Day Number is a day
        /// which contains a leap second.
        /// </summary>
        [Test]
        public void TestDoesDayHaveLeapSecond()
        {
            LeapSeconds leapSeconds = new LeapSeconds();

            Assert.IsTrue(leapSeconds.DoesDayHaveLeapSecond(2443509));
            Assert.IsFalse(leapSeconds.DoesDayHaveLeapSecond(2443510));
        }

        /// <summary>
        /// Tests that the look-up operation produces the correct result for times within the range
        /// of the table.
        /// </summary>
        [Test]
        public void TestLeapSecondCount()
        {
            LeapSeconds leapSeconds = new LeapSeconds();

            JulianDate utc = new JulianDate(new GregorianDate(1998, 4, 1, 12, 0, 0));
            JulianDate tai = utc.ToTimeStandard(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(31, leapSeconds.GetTaiMinusUtc(utc));
            Assert.AreEqual(31, leapSeconds.GetTaiMinusUtc(tai));
        }

        /// <summary>
        /// Tests that negative leap seconds are supported.
        /// </summary>
        [Test]
        public void TestNegativeLeapSecond()
        {
            List<LeapSecond> newList = new List<LeapSecond>
            {
                new LeapSecond(2451545.0, 11),
                new LeapSecond(2451555.0, 12),
                new LeapSecond(2451565.0, 11),
                new LeapSecond(2451575.0, 10)
            };

            LeapSeconds leapSeconds = new LeapSeconds(newList);

            Assert.AreEqual(11, leapSeconds.GetTaiMinusUtc(new JulianDate(2451545.5, TimeStandard.CoordinatedUniversalTime)));
            Assert.AreEqual(12, leapSeconds.GetTaiMinusUtc(new JulianDate(2451555.5, TimeStandard.CoordinatedUniversalTime)));
            Assert.AreEqual(11, leapSeconds.GetTaiMinusUtc(new JulianDate(2451565.5, TimeStandard.CoordinatedUniversalTime)));
            Assert.AreEqual(10, leapSeconds.GetTaiMinusUtc(new JulianDate(2451575.5, TimeStandard.CoordinatedUniversalTime)));
        }

        /// <summary>
        /// Tests that the look-up operation produces the correct result when using the
        /// <see cref="TimeStandard.InternationalAtomicTime"/> standard.
        /// </summary>
        [Test]
        public void TestGetOffsetTai()
        {
            JulianDate date = new JulianDate(2453736, 43222.0, TimeStandard.InternationalAtomicTime);
            LeapSeconds leapSeconds = new LeapSeconds();
            Assert.AreEqual(32, leapSeconds.GetTaiMinusUtc(date));
        }

        /// <summary>
        /// Tests that a <see cref="JulianDate"/> in the 
        /// <see cref="TimeStandard.CoordinatedUniversalTime"/> standard cannot correctly
        /// represent a day containing a leap second.
        /// </summary>
        [Test]
        public void TestJulianDateCannotRepresentMomentOfLeapSecond()
        {
            JulianDate momentOfLeapSecond = new JulianDate(2453736, 43232.0, TimeStandard.InternationalAtomicTime);

            Assert.Throws<ArgumentOutOfRangeException>(() =>
            {
                var unused = momentOfLeapSecond.ToTimeStandard(TimeStandard.CoordinatedUniversalTime);
            });
        }

        /// <summary>
        /// Converts two Julian dates in TAI to UTC: one just before a leap second, and one
        /// after a leap second.  Verifies that they convert to different UTC Julian dates.
        /// </summary>
        [Test]
        public void TestTaiToUtcNearLeapSecond()
        {
            LeapSeconds leapSeconds = new LeapSeconds();
            LeapSeconds.Instance = leapSeconds;

            JulianDate momentOfLeapSecond = new JulianDate(2453736, 43232.0, TimeStandard.InternationalAtomicTime);
            JulianDate before = momentOfLeapSecond - Duration.FromSeconds(1.0);
            JulianDate after = momentOfLeapSecond + Duration.FromSeconds(1.0);

            JulianDate beforeUtc = before.ToTimeStandard(TimeStandard.CoordinatedUniversalTime);
            JulianDate afterUtc = after.ToTimeStandard(TimeStandard.CoordinatedUniversalTime);

            Assert.AreNotEqual(beforeUtc, afterUtc);
        }

        /// <summary>
        /// Tests that adding small values to a UTC Julian date does not result in getting
        /// stuck when crossing a leap second.
        /// </summary>
        [Test]
        public void TestUtcAddNotStuckAtLeapSecond()
        {
            LeapSeconds leapSeconds = new LeapSeconds();
            LeapSeconds.Instance = leapSeconds;

            JulianDate date = new JulianDate(2453736, 43198.0, TimeStandard.CoordinatedUniversalTime);
            JulianDate after = new JulianDate(2453736, 43202.0, TimeStandard.CoordinatedUniversalTime);
            int i;
            for (i = 0; i < 100; ++i)
            {
                date += Duration.FromSeconds(0.1);
                if (date > after)
                {
                    break;
                }
            }

            // 5 second difference, so 50 additions of a tenth of a second each
            Assert.AreEqual(50, i);
        }
    }
}