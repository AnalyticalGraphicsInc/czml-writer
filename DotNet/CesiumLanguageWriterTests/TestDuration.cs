using System;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// A series of tests to exercise this type.
    /// </summary>
    [TestFixture]
    public class TestDuration
    {
        /// <summary>
        /// Tests that <see cref="Duration.MinValue"/>, <see cref="Duration.MaxValue"/>, and <see cref="Duration.Zero"/> can be constructed as claimed.
        /// </summary>
        [Test]
        public void TestMinValueMaxValueZeroValue()
        {
            Duration min = Duration.FromSeconds(Duration.MinValue.TotalSeconds);
            Assert.AreEqual(int.MinValue, min.Days);
            Assert.AreEqual(0.0, min.Seconds);

            Duration max = Duration.FromSeconds(Duration.MaxValue.TotalSeconds);
            Assert.AreEqual(int.MaxValue, max.Days);
            Assert.AreEqual(0.0, max.Seconds);

            Duration zero = Duration.FromSeconds(Duration.Zero.TotalSeconds);
            Assert.AreEqual(0.0, zero.Days);
            Assert.AreEqual(0.0, zero.Seconds);
        }

        /// <summary>
        /// Tests the Duration constructors that take days, minutes, hours, and seconds.
        /// </summary>
        [Test]
        public void TestDaysHoursMinutesSecondsConstructors()
        {
            Duration duration = new Duration(1, 1, 1, 1.0);
            Assert.AreEqual(1, duration.Days);
            Assert.AreEqual(3661, duration.Seconds);
        }

        /// <summary>
        /// Tests that initialization produces a <see cref="Duration"/> in canonical form
        /// with day and seconds elements being either both positive or both negative.
        /// </summary>
        [Test]
        public void TestNormalization()
        {
            // A duration's day and time should either be both negative or both positive
            Duration duration = new Duration(1, 100.0);
            Assert.AreEqual(1, duration.Days);
            Assert.AreEqual(100.0, duration.Seconds);

            duration = new Duration(-1, -100.0);
            Assert.AreEqual(-1, duration.Days);
            Assert.AreEqual(-100.0, duration.Seconds);

            duration = new Duration(-1, 100.0);
            Assert.AreEqual(0, duration.Days);
            Assert.AreEqual(-86300.0, duration.Seconds);

            duration = new Duration(1, -100.0);
            Assert.AreEqual(0, duration.Days);
            Assert.AreEqual(86300.0, duration.Seconds);
        }

        /// <summary>
        /// Tests that initialization produces a <see cref="Duration"/> which is normalized with the
        /// seconds element in the range -86400.0 &lt; seconds &lt; 86400.0.
        /// </summary>
        [Test]
        public void TestSecondsGreaterThanADay()
        {
            Duration duration = new Duration(0, 107000.0);
            Assert.AreEqual(1, duration.Days);
            Assert.AreEqual(20600.0, duration.Seconds);
        }

        /// <summary>
        /// Tests the check for EXACT equality and the check for equality within a specified tolerance.
        /// </summary>
        [Test]
        public void TestEquality()
        {
            Duration first = new Duration(5, 565.0);
            Duration second = new Duration(5, 565.0);
            Assert.AreEqual(first, second);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.AreEqual(0, first.CompareTo(second));
            Assert.AreEqual(0, second.CompareTo(first));

            first = new Duration(5, 0.00001);
            second = new Duration(4, 86399.99999);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));
            Assert.IsTrue(first.EqualsEpsilon(second, 1e-4));
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-4));

            // Make sure a Duration compared with a non-Duration returns false
            // ReSharper disable once SuspiciousTypeConversion.Global
            Assert.IsFalse(first.Equals(5));
        }

        /// <summary>
        /// Tests Duration.CompareTo
        /// </summary>
        [Test]
        public void TestCompareTo()
        {
            Duration duration1 = new Duration(1, 0.0);
            Duration duration2 = new Duration(1, 0.0);
            Assert.AreEqual(0, duration1.CompareTo(duration2));
            Assert.AreEqual(0, duration2.CompareTo(duration1));
            Assert.IsTrue(duration1 >= duration2);
            Assert.IsTrue(duration2 <= duration1);
            Assert.IsTrue(duration1 <= duration2);
            Assert.IsTrue(duration2 >= duration1);

            duration2 = new Duration(2, 0.0);
            Assert.Less(duration1.CompareTo(duration2), 0);
            Assert.Greater(duration2.CompareTo(duration1), 0);
            Assert.IsTrue(duration1 < duration2);
            Assert.IsTrue(duration2 > duration1);
            Assert.IsTrue(duration1 <= duration2);
            Assert.IsTrue(duration2 >= duration1);

            duration2 = new Duration(1, 1.0);
            Assert.Less(duration1.CompareTo(duration2), 0);
            Assert.Greater(duration2.CompareTo(duration1), 0);
            Assert.IsTrue(duration1 < duration2);
            Assert.IsTrue(duration2 > duration1);
            Assert.IsTrue(duration1 <= duration2);
            Assert.IsTrue(duration2 >= duration1);
        }

        /// <summary>
        /// Tests the addition operation between two <see cref="Duration"/> instances
        /// with unspecified time standards.
        /// </summary>
        [Test]
        public void TestAddition()
        {
            Duration original = new Duration(5, 1000.0);
            Duration add = Duration.FromSeconds(50.0);
            Duration result = original + add;
            Assert.AreEqual(5, result.Days);
            Assert.AreEqual(1050.0, result.Seconds);

            original = new Duration(5, 8382.1);
            add = new Duration(1, 10.0);
            result = original + add;
            Assert.AreEqual(6, result.Days);
            Assert.AreEqual(8392.1, result.Seconds);

            original = new Duration(5, 86000.0);
            add = Duration.FromSeconds(1000.0);
            result = original + add;
            Assert.AreEqual(6, result.Days);
            Assert.AreEqual(600.0, result.Seconds);
        }

        /// <summary>
        /// Tests the subtraction operation between two <see cref="Duration"/> instances
        /// with unspecified time standards.
        /// </summary>
        [Test]
        public void TestSubtraction()
        {
            Duration first = new Duration(5, 1000.0);
            Duration second = new Duration(5, 2000.0);
            Duration difference = second - first;
            Assert.AreEqual(1000.0, difference.TotalSeconds);
            difference = first - second;
            Assert.AreEqual(-1000.0, difference.TotalSeconds);

            first = new Duration(5, 1000.0);
            second = new Duration(6, 2000.0);
            difference = second - first;
            Assert.AreEqual(1, difference.Days);
            Assert.AreEqual(1000.0, difference.Seconds);
            difference = first - second;
            Assert.AreEqual(-1, difference.Days);
            Assert.AreEqual(-1000.0, difference.Seconds);

            first = new Duration(5, 86000.0);
            second = new Duration(6, 100.0);
            difference = second - first;
            Assert.AreEqual(0, difference.Days);
            Assert.AreEqual(500.0, difference.Seconds);
            difference = first - second;
            Assert.AreEqual(0, difference.Days);
            Assert.AreEqual(-500.0, difference.Seconds);
        }

        /// <summary>
        /// Tests multiplication of a <see cref="Duration"/> instance by a constant.
        /// </summary>
        [Test]
        public void TestMultiplication()
        {
            Duration duration = new Duration(5, 1.0);
            Duration result = duration.Multiply(100.0);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(500, 100.0), Constants.Epsilon10));
            result = duration * 100.0;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(500, 100.0), Constants.Epsilon10));

            duration = new Duration(0, 5000.1);
            result = duration.Multiply(100.0);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(5, 68010.0), Constants.Epsilon10));
            result = duration * 100.0;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(5, 68010.0), Constants.Epsilon10));

            duration = new Duration(1, 43200.0);
            result = duration.Multiply(0.5);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(0, 64800.0), Constants.Epsilon10));
            result = duration * 0.5;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(0, 64800.0), Constants.Epsilon10));

            duration = new Duration(5, 1.0);
            result = duration.Multiply(100.5);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(502, 43300.5), Constants.Epsilon10));
            result = duration * 100.5;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(502, 43300.5), Constants.Epsilon10));

            result = duration * -0.5;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(-2, -43200.5), Constants.Epsilon10));

            duration = new Duration(0, 18 * 3600);
            result = duration * -2;
            Assert.AreEqual(-12 * 3600, result.Seconds);
            Assert.AreEqual(-1, result.Days);

            duration = new Duration(1, 4 * 3600);
            result = duration * -0.5;
            Assert.AreEqual(-14 * 3600, result.Seconds);
            Assert.AreEqual(0, result.Days);
        }

        /// <summary>
        /// Tests division of a <see cref="Duration"/> by another.
        /// </summary>
        [Test]
        public void TestDivisionByDuration()
        {
            Duration one = new Duration(1, 0.0);
            Duration two = new Duration(0, 60.0);
            Assert.AreEqual(86400.0 / 60.0, one.Divide(two), Constants.Epsilon10);
            Assert.AreEqual(60 / 86400.0, two / one, Constants.Epsilon10);

            Duration three = new Duration(1, 43200.0);
            Assert.AreEqual((86400 + 43200) / 60.0, three / two, Constants.Epsilon10);
            Assert.AreEqual(60.0 / (86400.0 + 43200.0), two.Divide(three), Constants.Epsilon10);

            Duration four = new Duration(1, 0);
            Duration five = new Duration(0, -3600);
            Assert.AreEqual(-24, four / five, Constants.Epsilon10);
            Assert.AreEqual(-1.0 / 24.0, five / four, Constants.Epsilon10);

            Duration six = new Duration(-2, 0);
            Assert.AreEqual(-0.5, four / six);
            Assert.AreEqual(48, six / five);

            Duration seven = new Duration(0, -0.5);
            Assert.AreEqual(-48 * 3600, four / seven);
        }

        /// <sumary>
        /// Tests division of a <see cref="Duration"/> by a constant.
        /// </sumary>
        [Test]
        public void TestDivisionByConstant()
        {
            Duration duration = new Duration(500, 100.0);
            Duration result = duration.Divide(100.0);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));
            result = duration / 100.0;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));

            duration = new Duration(5, 68010.0);
            result = duration.Divide(100.0);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(0, 5000.1), Constants.Epsilon10));
            result = duration / 100.0;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(0, 5000.1), Constants.Epsilon10));

            duration = new Duration(0, 64800.0);
            result = duration.Divide(0.5);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(1, 43200.0), Constants.Epsilon10));
            result = duration / 0.5;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(1, 43200.0), Constants.Epsilon10));

            duration = new Duration(502, 43300.5);
            result = duration.Divide(100.5);
            Assert.IsTrue(result.EqualsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));
            result = duration / 100.5;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));

            duration = new Duration(5, 1.0);
            result = duration / -2.0;
            Assert.IsTrue(result.EqualsEpsilon(new Duration(-2, -43200.5), Constants.Epsilon10));

            duration = new Duration(0, 18 * 3600);
            result = duration / -0.5;
            Assert.AreEqual(-12 * 3600, result.Seconds);
            Assert.AreEqual(-1, result.Days);

            duration = new Duration(1, 4 * 3600);
            result = duration / -2;
            Assert.AreEqual(-14 * 3600, result.Seconds);
            Assert.AreEqual(0, result.Days);
        }

        /// <summary>
        /// Tests the Duration.AddSeconds method.
        /// </summary>
        [Test]
        public void TestAddSeconds()
        {
            Duration test = new Duration(5, 43200.0);
            Duration result = test.AddSeconds(45.123);
            Assert.AreEqual(5, result.Days);
            Assert.AreEqual(43245.123, result.Seconds);
        }

        /// <summary>
        /// Tests the Duration.AddDays method.
        /// </summary>
        [Test]
        public void TestAddDays()
        {
            Duration test = new Duration(5, 43200.0);
            Duration result = test.AddDays(45.5);
            Assert.AreEqual(51, result.Days);
            Assert.AreEqual(0.0, result.Seconds);
        }

        /// <summary>
        /// Tests the non-generic IComparable.CompareTo.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestObjectCompareTo()
        {
            Duration duration1 = new Duration(1, 1.0);
            Assert.Greater(duration1.CompareTo(null), 0);

            object duration2 = new Duration(1, 1.0);
            Assert.AreEqual(0, duration1.CompareTo(duration2));
        }

        /// <summary>
        /// Tests that Duration.CompareTo throws an appropriate exception if the object
        /// passed to the method is not a Duration.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestObjectCompareToNotDuration()
        {
            Duration duration = new Duration(1, 1.0);

            Assert.Throws<ArgumentException>(() =>
            {
                int unused = duration.CompareTo(5);
            });
        }

        /// <summary>
        /// Tests that Duration.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            Duration duration1 = new Duration(1, 0.0);
            Duration duration2 = new Duration(1, 1.0);
            Duration duration3 = new Duration(1, 0.0);
            Assert.AreNotEqual(duration1.GetHashCode(), duration2.GetHashCode());
            Assert.AreEqual(duration1.GetHashCode(), duration3.GetHashCode());
        }

        /// <summary>
        /// Tests the Duration.TotalDays property
        /// </summary>
        [Test]
        public void TestTotalDays()
        {
            Duration duration = new Duration(1, 43200.0);
            Assert.AreEqual(1.5, duration.TotalDays);
        }

        /// <summary>
        /// Test the <see cref="Duration.ToString"/> method.
        /// </summary>
        [Test]
        public void TestToString()
        {
            var duration = new Duration(1, 43200.0);
            Assert.AreEqual("1:43200", duration.ToString());
        }

        /// <summary>
        /// Tests construction of a <see cref="Duration"/> with a really small negative
        /// seconds.  Duration will attempt to eliminate the negative Seconds
        /// by rolling the Days back one day, but doing so results in setting the Seconds to
        /// 86400.0 seconds.  This is still not normalized, so Duration should bump the Days
        /// back up and round the Seconds to 0.0.
        /// </summary>
        [Test]
        public void TestReallySmallSeconds()
        {
            Duration duration = new Duration(10, -Constants.Epsilon13);
            Assert.AreEqual(10, duration.Days);
            Assert.AreEqual(0.0, duration.Seconds);

            duration = new Duration(-10, Constants.Epsilon13);
            Assert.AreEqual(-10, duration.Days);
            Assert.AreEqual(0.0, duration.Seconds);
        }
    }
}