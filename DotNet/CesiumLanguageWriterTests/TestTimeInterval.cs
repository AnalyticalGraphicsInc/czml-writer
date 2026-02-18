using System;
using System.Diagnostics.CodeAnalysis;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestTimeInterval
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values is performed correctly.
        /// </summary>
        [Test]
        public void TestRetainValue()
        {
            JulianDate start = JulianDate.Now;
            JulianDate stop = start.AddDays(1.5);
            TimeInterval interval = new TimeInterval(start, stop);
            Assert.AreEqual(start, interval.Start);
            Assert.AreEqual(stop, interval.Stop);
        }

        /// <summary>
        /// Tests that the Duration of an Interval is calculated correctly.
        /// </summary>
        [Test]
        public void TestCalculateDuration()
        {
            JulianDate start = new JulianDate(2451545.0);
            JulianDate stop = start.AddDays(1.5);
            TimeInterval interval = new TimeInterval(start, stop);

            Assert.AreEqual(Duration.FromDays(1.5), interval.ToDuration());
        }

        [Test]
        public void TestIsEmpty()
        {
            TimeInterval interval = new TimeInterval(new JulianDate(1.0), new JulianDate(1.0));
            Assert.IsTrue(interval.IsEmpty);

            interval = new TimeInterval(new JulianDate(5.0), new JulianDate(4.0));
            Assert.IsTrue(interval.IsEmpty);
        }

        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
        public void TestEquality()
        {
            var interval1 = new TimeInterval(new JulianDate(1.0), new JulianDate(2.0));
            var interval2 = new TimeInterval(new JulianDate(1.0), new JulianDate(2.0));
            Assert.AreEqual(interval1, interval2);
            Assert.AreEqual(interval2, interval1);
            Assert.IsTrue(interval1.Equals(interval2));
            Assert.IsTrue(interval2.Equals(interval1));
            Assert.IsTrue(interval1 == interval2);
            Assert.IsTrue(interval2 == interval1);
            Assert.IsFalse(interval1 != interval2);
            Assert.IsFalse(interval2 != interval1);

            interval2 = new TimeInterval(new JulianDate(1.0), new JulianDate(3.0));
            Assert.AreNotEqual(interval1, interval2);
            Assert.AreNotEqual(interval2, interval1);
            Assert.IsFalse(interval1.Equals(interval2));
            Assert.IsFalse(interval2.Equals(interval1));
            Assert.IsFalse(interval1 == interval2);
            Assert.IsFalse(interval2 == interval1);
            Assert.IsTrue(interval1 != interval2);
            Assert.IsTrue(interval2 != interval1);

            object differentType = 5;
            Assert.AreNotEqual(differentType, interval1);

            interval2 = null;

            Assert.IsFalse(interval1 == interval2);
            Assert.IsFalse(interval2 == interval1);

            interval1 = null;

            Assert.IsTrue(interval1 == interval2);
            Assert.IsTrue(interval2 == interval1);
        }

        /// <summary>
        /// Tests that JulianDate.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            TimeInterval interval1 = new TimeInterval(new JulianDate(1.0), new JulianDate(5.0));
            TimeInterval interval2 = new TimeInterval(new JulianDate(2.0), new JulianDate(5.0));
            TimeInterval interval3 = new TimeInterval(new JulianDate(1.0), new JulianDate(5.0));

            Assert.AreNotEqual(interval1.GetHashCode(), interval2.GetHashCode());
            Assert.AreEqual(interval1.GetHashCode(), interval3.GetHashCode());
            Assert.AreEqual(interval1, interval3);
            Assert.AreNotEqual(interval1, interval2);
        }

        /// <summary>
        /// Tests the <see cref="TimeInterval.Contains"/> method.
        /// </summary>
        [Test]
        public void TestContains()
        {
            Assert.IsFalse(TimeInterval.Empty.Contains(new JulianDate(2451545.0)));

            TimeInterval interval1 = new TimeInterval(new JulianDate(2451545.0), new JulianDate(2451546.0));
            Assert.IsTrue(interval1.Contains(new JulianDate(2451545.0)));
            Assert.IsTrue(interval1.Contains(new JulianDate(2451545.5)));
            Assert.IsTrue(interval1.Contains(new JulianDate(2451546.0)));
            Assert.IsFalse(interval1.Contains(new JulianDate(2451546.5)));
        }

        [Test]
        public void TestEqualsEpsilon()
        {
            TimeInterval interval1 = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451546, 0.00));
            TimeInterval interval2 = new TimeInterval(new JulianDate(2451545, 0.05), new JulianDate(2451545, 86399.95));
            TimeInterval interval4 = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451546, 0.00));
            Assert.IsFalse(interval1.EqualsEpsilon(null, Constants.Epsilon1));
            Assert.IsTrue(interval1.EqualsEpsilon(interval2, Constants.Epsilon1));
            Assert.IsTrue(interval1.EqualsEpsilon(interval4, Constants.Epsilon1));
        }

        /// <summary>
        /// Tests that the <see cref="TimeInterval.EqualsEpsilon"/> method returns true
        /// when the difference is exactly epsilon.
        /// </summary>
        [Test]
        public void TestEqualsEpsilonExact()
        {
            TimeInterval first = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451545, 0.00));
            TimeInterval second = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451545, 0.00));

            Assert.IsTrue(second.EqualsEpsilon(first, 0.00));
        }

        [Test]
        public void TestToTimeStandard()
        {
            JulianDate start = new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime);
            JulianDate stop = new JulianDate(2451546.0, TimeStandard.CoordinatedUniversalTime);
            TimeInterval interval = new TimeInterval(start, stop);

            TimeInterval result = interval.ToTimeStandard(TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(TimeStandard.CoordinatedUniversalTime, result.Start.Standard);
            Assert.AreEqual(TimeStandard.CoordinatedUniversalTime, result.Stop.Standard);
            Assert.AreEqual(2451545.0, result.Start.TotalDays, Constants.Epsilon15);
            Assert.AreEqual(2451546.0, result.Stop.TotalDays, Constants.Epsilon15);

            result = interval.ToTimeStandard(TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, result.Start.Standard);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, result.Stop.Standard);
            Assert.AreNotEqual(2451545.0, result.Start.TotalDays);
            Assert.AreNotEqual(2451546.0, result.Stop.TotalDays);

            TimeInterval empty = new TimeInterval(new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime),
                                                  new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime));
            Assert.IsTrue(empty.IsEmpty);
            result = empty.ToTimeStandard(TimeStandard.InternationalAtomicTime);
            Assert.IsTrue(result.IsEmpty);
        }

        [Test]
        public void TestToString()
        {
            TimeInterval interval = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451546, 0.00));
            Assert.AreEqual("[2451545:0 TAI (" + interval.Start.ToGregorianDate() + "), 2451546:0 TAI (" + interval.Stop.ToGregorianDate() + ")]", interval.ToString());
        }
    }
}
