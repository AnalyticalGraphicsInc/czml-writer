using System;
using System.Diagnostics.CodeAnalysis;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestLeapSecond
    {
        [Test]
        public void TestConstructor()
        {
            LeapSecond leapSecond = new LeapSecond(2451545.0, 100.0);

            Assert.AreEqual(2451545.0, leapSecond.Date.TotalDays);
            Assert.AreEqual(100.0, leapSecond.TotalTaiOffsetFromUtc);
            Assert.AreEqual(TimeStandard.CoordinatedUniversalTime, leapSecond.Date.Standard);
        }

        [Test]
        public void TestConstructorRequiresUTC()
        {
            var exception = Assert.Throws<ArgumentException>(() =>
            {
                var unused = new LeapSecond(new JulianDate(2451545.0, TimeStandard.InternationalAtomicTime), 100.0);
            });
            StringAssert.Contains("The given date must be in the UTC time standard", exception.Message);
        }

        /// <summary>
        /// Tests equality between leap second instances.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods")]
        public void TestEquality()
        {
            LeapSecond leapSecond1 = new LeapSecond(2451545.0, 100.0);
            LeapSecond leapSecond2 = new LeapSecond(2451545.0, 100.0);
            LeapSecond leapSecond3 = new LeapSecond(2451545.0, 101.0);
            LeapSecond leapSecond4 = new LeapSecond(2451546.0, 101.0);
            Assert.AreEqual(leapSecond1, leapSecond2);
            Assert.IsTrue(leapSecond1 == leapSecond2);
            Assert.AreNotEqual(leapSecond1, leapSecond3);
            Assert.IsTrue(leapSecond1 != leapSecond3);

            object differentType = 5;
            Assert.AreNotEqual(leapSecond1, differentType);
            Assert.AreNotEqual(leapSecond3, leapSecond4);
        }

        /// <summary>
        /// Tests that JulianDate.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            LeapSecond leapSecond1 = new LeapSecond(2451545.0, 100.0);
            LeapSecond leapSecond2 = new LeapSecond(2451545.0, 100.0);
            LeapSecond leapSecond3 = new LeapSecond(2451545.0, 101.0);

            Assert.AreEqual(leapSecond1.GetHashCode(), leapSecond2.GetHashCode());
            Assert.AreNotEqual(leapSecond1.GetHashCode(), leapSecond3.GetHashCode());
        }

        /// <summary>
        /// Tests the ToString of LeapSecond.
        /// </summary>
        [Test]
        public void TestToString()
        {
            LeapSecond leapSecond = new LeapSecond(2451545.0, 100.0);

            string expected = string.Format("2451545:0 UTC ({0}), 100", new GregorianDate(new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime)));
            Assert.AreEqual(expected, leapSecond.ToString());
        }
    }
}
