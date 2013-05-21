using System;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// A series of tests to exercise this type.
    /// </summary>
    [TestFixture]
    public class TestJulianDate
    {
        /// <summary>
        /// Tests that initialization of and access to the structure day and time
        /// elements is performed correctly.
        /// </summary>
        [Test]
        public void TestRetainValue()
        {
            JulianDate date = new JulianDate(100, 123.456789012);
            Assert.AreEqual(100, date.Day);
            Assert.AreEqual(123.456789012, date.SecondsOfDay);
        }

        /// <summary>
        /// Tests that initialization of and access to the structure time standard
        /// element is performed correctly.  Also tests that the default time standard
        /// is <see cref="TimeStandard.InternationalAtomicTime"/>.
        /// </summary>
        [Test]
        public void TestTimeStandard()
        {
            JulianDate date = new JulianDate(0);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, date.Standard);

            date = new JulianDate(100, 123.456789012);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, date.Standard);

            date = new JulianDate(100, 123.456789012, TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(TimeStandard.CoordinatedUniversalTime, date.Standard);
        }

        /// <summary>
        /// Tests that initialization produces a <see cref="JulianDate"/> which is
        /// normalized with the time element in the range 0.0 &lt;= seconds &lt; 86400.0.
        /// </summary>
        [Test]
        public void TestTimeGreaterThanADay()
        {
            JulianDate date = new JulianDate(2451545, 107000.0);
            Assert.AreEqual(2451546, date.Day);
            Assert.AreEqual(20600.0, date.SecondsOfDay);

            date = new JulianDate(2451545, 107000.0, TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(2451546, date.Day);
            Assert.AreEqual(20600.0, date.SecondsOfDay);
        }

        /// <summary>
        /// Tests that initialization produces a <see cref="JulianDate"/> which is
        /// normalized with the time element in the range 0.0 &lt;= seconds &lt; 86400.0.
        /// </summary>
        [Test]
        public void TestTimeNegative()
        {
            JulianDate date = new JulianDate(2451545, -45000.0);
            Assert.AreEqual(2451544, date.Day);
            Assert.AreEqual(41400.0, date.SecondsOfDay);

            date = new JulianDate(2451545, -45000.0, TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(2451544, date.Day);
            Assert.AreEqual(41400.0, date.SecondsOfDay);
        }

        /// <summary>
        /// Tests that initialization produces a <see cref="JulianDate"/> which is
        /// normalized with the time element in the range 0.0 &lt;= seconds &lt; 86400.0.
        /// </summary>
        [Test]
        public void TestTimeExactlyOneDay()
        {
            JulianDate date = new JulianDate(2451545, 86400.0);
            Assert.AreEqual(2451546, date.Day);
            Assert.AreEqual(0.0, date.SecondsOfDay);

            date = new JulianDate(2451545, 86400.0, TimeStandard.InternationalAtomicTime);
            Assert.AreEqual(2451546, date.Day);
            Assert.AreEqual(0.0, date.SecondsOfDay);
        }

        /// <summary>
        /// Tests the check for EXACT equality and the check for equality within a specified tolerance.
        /// </summary>
        [Test]
        public void TestEquality()
        {
            JulianDate first = new JulianDate(2451545, 0.2);
            JulianDate second = new JulianDate(2451545, 0.2);
            Assert.AreEqual(first, second);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));
            Assert.AreEqual(0, first.CompareTo(second));
            Assert.AreEqual(0, second.CompareTo(first));
            Assert.AreNotEqual(first, 5);

            first = new JulianDate(2451545, 0.00001);
            second = new JulianDate(2451544, 86399.99999);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));
            Assert.IsTrue(first.EqualsEpsilon(second, 1e-4));
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-4));
        }

        /// <summary>
        /// Tests the addition operation between a <see cref="Duration"/> with unspecified time standard
        /// and a <see cref="JulianDate"/>.
        /// </summary>
        [Test]
        public void TestAddition()
        {
            JulianDate original = new JulianDate(2460000, 1000.0);
            Duration toAdd = Duration.FromSeconds(50.0);
            JulianDate added = original.Add(toAdd);
            Assert.AreEqual(2460000, added.Day);
            Assert.AreEqual(1050.0, added.SecondsOfDay);
            JulianDate subtracted = original.Subtract(toAdd);
            Assert.AreEqual(2460000, subtracted.Day);
            Assert.AreEqual(950.0, subtracted.SecondsOfDay);

            original = new JulianDate(2460000, 8382.1);
            toAdd = new Duration(1, 10.0);
            added = original + toAdd;
            Assert.AreEqual(2460001, added.Day);
            Assert.AreEqual(8392.1, added.SecondsOfDay);
            subtracted = original - toAdd;
            Assert.AreEqual(2459999, subtracted.Day);
            Assert.AreEqual(8372.1, subtracted.SecondsOfDay);

            original = new JulianDate(2460000, 86000.0);
            toAdd = Duration.FromSeconds(1000.0);
            added = original.Add(toAdd);
            Assert.AreEqual(2460001, added.Day);
            Assert.AreEqual(600.0, added.SecondsOfDay);
            subtracted = original.Subtract(toAdd);
            Assert.AreEqual(2460000, subtracted.Day);
            Assert.AreEqual(85000.0, subtracted.SecondsOfDay);
        }

        /// <summary>
        /// Tests the function that determines the number of seconds between two Julian Dates
        /// </summary>
        [Test]
        public void TestSecondsDifference()
        {
            // Test same standard - both safe
            JulianDate first = new JulianDate(2451545.0);
            JulianDate second = first + Duration.FromSeconds(120000);
            Assert.AreEqual(120000, first.SecondsDifference(second));
            Assert.AreEqual((second - first).TotalSeconds, first.SecondsDifference(second));

            //Test same standard - both unsafe
            first = new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime);
            second = first + Duration.FromSeconds(120000);
            second = new JulianDate(second.Day, second.SecondsOfDay, TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(120000, first.SecondsDifference(second));
            Assert.AreEqual((second - first).TotalSeconds, first.SecondsDifference(second));

            // Test diff standard - one unsafe, one safe
            first = new JulianDate(2451545.0);
            second = first + Duration.FromSeconds(120000);
            JulianDate secondDiffStandard = second.ToTimeStandard(TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(120000, first.SecondsDifference(secondDiffStandard));
            Assert.AreEqual((secondDiffStandard - first).TotalSeconds, first.SecondsDifference(secondDiffStandard));
        }

        /// <summary>
        /// Tests the function that determines the number of seconds between two Julian Dates
        /// </summary>
        [Test]
        public void TestMinutesDifference()
        {
            double totalElapsedTime = TimeConstants.SecondsPerDay * 2.5;
            double totalElapsedTimeMinutes = totalElapsedTime / TimeConstants.SecondsPerMinute;

            //Test same time standard, both safe
            JulianDate first = new JulianDate(2451545.0);
            JulianDate second = first + Duration.FromSeconds(totalElapsedTime);
            Assert.AreEqual(totalElapsedTimeMinutes, first.MinutesDifference(second));
            Assert.AreEqual((second - first).TotalSeconds / TimeConstants.SecondsPerMinute, first.MinutesDifference(second));

            //Test same time standard, both unsafe
            first = new JulianDate(2451545.0, TimeStandard.CoordinatedUniversalTime);
            second = first + Duration.FromSeconds(totalElapsedTime);
            second = new JulianDate(second.Day, second.SecondsOfDay, TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(totalElapsedTimeMinutes, first.MinutesDifference(second));
            Assert.AreEqual((second - first).TotalSeconds / TimeConstants.SecondsPerMinute, first.MinutesDifference(second));

            //Test diff time standard, one safe, one unsafe
            first = new JulianDate(2451545.0);
            second = first + Duration.FromSeconds(totalElapsedTime);
            JulianDate secondDiffStandard = second.ToTimeStandard(TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(totalElapsedTimeMinutes, first.MinutesDifference(secondDiffStandard));
            Assert.AreEqual((secondDiffStandard - first).TotalSeconds / TimeConstants.SecondsPerMinute, first.MinutesDifference(secondDiffStandard));
        }

        /// <summary>
        /// Tests the subtraction operation between Julian dates.
        /// </summary>
        [Test]
        public void TestSubtraction()
        {
            JulianDate first = new JulianDate(2469477, 1000.0);
            JulianDate second = new JulianDate(2469477, 2000.0);
            Duration difference = second - first;
            Assert.AreEqual(1000.0, difference.TotalSeconds);
            difference = first - second;
            Assert.AreEqual(-1000.0, difference.TotalSeconds);

            first = new JulianDate(2469477, 1000.0);
            second = new JulianDate(2469478, 2000.0);
            difference = second - first;
            Assert.AreEqual(1, difference.Days);
            Assert.AreEqual(1000.0, difference.Seconds);
            difference = first - second;
            Assert.AreEqual(-1, difference.Days);
            Assert.AreEqual(-1000.0, difference.Seconds);

            first = new JulianDate(2469477, 86000.0);
            second = new JulianDate(2469478, 100.0);
            difference = second - first;
            Assert.AreEqual(0, difference.Days);
            Assert.AreEqual(500.0, difference.Seconds);
            difference = first - second;
            Assert.AreEqual(0, difference.Days);
            Assert.AreEqual(-500.0, difference.Seconds);
        }

        /// <summary>
        /// Tests the JulianDate.AddSeconds method.
        /// </summary>
        [Test]
        public void TestAddSeconds()
        {
            // Make sure AddSeconds produces the correct answer in the correct time standard.
            JulianDate test = new JulianDate(2451912, 43200.0, TimeStandard.InternationalAtomicTime);
            JulianDate result = test.AddSeconds(45.123);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, result.Standard);
            Assert.AreEqual(2451912, result.Day);
            Assert.AreEqual(43245.123, result.SecondsOfDay);
        }

        /// <summary>
        /// Tests the JulianDate.AddDays method.
        /// </summary>
        [Test]
        public void TestAddDays()
        {
            // Make sure AddDays produces the correct answer in the correct time standard.
            JulianDate test = new JulianDate(2451912, 43200.0, TimeStandard.InternationalAtomicTime);
            JulianDate result = test.AddDays(45.5);
            Assert.AreEqual(TimeStandard.InternationalAtomicTime, result.Standard);
            Assert.AreEqual(2451958, result.Day);
            Assert.AreEqual(0.0, result.SecondsOfDay);
        }

        /// <summary>
        /// Tests the overload of CompareTo that takes a <see cref="object"/>.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestCompareToObject()
        {
            JulianDate date1 = new JulianDate(2451545.0);
            object date2 = new JulianDate(2451545.0);
            Assert.IsTrue(date1.CompareTo(null) > 0);
            Assert.IsTrue(date1.CompareTo(date2) == 0);
        }

        /// <summary>
        /// Tests that an appropriate exception is thrown when attempting to compare a JulianDate
        /// to a type that is not a JulianDate.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentException))]
        [CSToJavaExclude]
        public void TestCompareToWrongType()
        {
            JulianDate date1 = new JulianDate(2451545.0);
            date1.CompareTo(2451545.0);
        }

        /// <summary>
        /// Tests that JulianDate.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            JulianDate date1 = new JulianDate(2451545, 0.0);
            JulianDate date2 = new JulianDate(2451545, 1.0);
            JulianDate date3 = new JulianDate(2451545, 0.0);
            Assert.AreNotEqual(date1.GetHashCode(), date2.GetHashCode());
            Assert.AreEqual(date1.GetHashCode(), date3.GetHashCode());

            date1 = new JulianDate(2451545, 0.0, TimeStandard.InternationalAtomicTime);
            date2 = new JulianDate(2451545, 0.0, TimeStandard.CoordinatedUniversalTime);
            Assert.AreNotEqual(date1.GetHashCode(), date2.GetHashCode());
        }

        /// <summary>
        /// Tests the JulianDate override of the <see cref="object.ToString"/> method.
        /// </summary>
        [Test]
        public void TestToString()
        {
            JulianDate date = new JulianDate(2451545.5);
            Assert.AreEqual("2451545:43200 (TAI)", date.ToString());
        }

        /// <summary>
        /// Tests the <see cref="IConvertible.ToDateTime"/> method.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestToDateTime()
        {
            DateTime expected = new DateTime(2007, 08, 20, 8, 45, 30, 700);
            JulianDate julianDate = new JulianDate(expected);

            Assert.AreEqual(expected, Convert.ToDateTime(julianDate));
        }

        /// <summary>
        /// Tests the <see cref="IConvertible.ToDouble"/>method.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestToDouble()
        {
            JulianDate julianDate = new JulianDate(200);
            Assert.AreEqual(200.0, Convert.ToDouble(julianDate));

            julianDate = new JulianDate(5345.2234);
            Assert.AreEqual(5345.2234, Convert.ToDouble(julianDate));

            julianDate = new JulianDate(800, 234);
            Assert.AreEqual(800 + 234 / TimeConstants.SecondsPerDay, Convert.ToDouble(julianDate));
        }

        /// <summary>
        /// Tests the <see cref="IConvertible.ToSByte(System.IFormatProvider)"/> method.
        /// </summary>
        [Test]
        [ExpectedException(typeof(InvalidCastException))]
        [CSToJavaExclude]
        public void TestToSByte()
        {
            JulianDate julianDate = new JulianDate(100);
            IConvertible convertible = julianDate;
            convertible.ToSByte(null);
        }

        /// <summary>
        /// Tests the <see cref="IConvertible.ToChar(System.IFormatProvider)"/> method.
        /// </summary>
        [Test]
        [ExpectedException(typeof(InvalidCastException))]
        [CSToJavaExclude]
        public void TestToChar()
        {
            JulianDate julianDate = new JulianDate(100);
            IConvertible convertible = julianDate;
            convertible.ToChar(null);
        }

        /// <summary>
        /// Tests the <see cref="IConvertible.ToUInt16(System.IFormatProvider)"/> method.
        /// </summary>
        [Test]
        [ExpectedException(typeof(InvalidCastException))]
        [CSToJavaExclude]
        public void TestToUInt16()
        {
            JulianDate julianDate = new JulianDate(100);
            IConvertible convertible = julianDate;
            convertible.ToUInt16(null);
        }

        /// <summary>
        /// Tests the <see cref="IConvertible.ToString"/> method.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestIConvertibleToString()
        {
            JulianDate julianDate = new JulianDate(500);

            Assert.AreEqual(julianDate.ToString(), Convert.ToString(julianDate));
        }

        /// <summary>
        /// Tests the <see cref="IConvertible.ToType"/> method.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestConvertToType()
        {
            JulianDate date = new JulianDate(2451545.0);
            IConvertible convertible = date as IConvertible;
            DateTimeFormatInfo info = new DateTimeFormatInfo();

            Assert.AreEqual(date.ToString(), convertible.ToType(typeof(string), info));
            Assert.AreEqual(date.ToDateTime(), convertible.ToType(typeof(DateTime), info));
            Assert.AreEqual(date.TotalDays, convertible.ToType(typeof(double), info));
        }

        /// <summary>
        /// Tests the <see cref=" IConvertible.ToType"/> method.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestGetTypeCode()
        {
            JulianDate date = new JulianDate(100);
            IConvertible convertible = date as IConvertible;
            Assert.AreEqual(TypeCode.Object, convertible.GetTypeCode());
        }

        /// <summary>
        /// Tests for consistency between the comparison operators.
        /// </summary>
        [Test]
        public void TestComparisonConsistency()
        {
            JulianDate one = new JulianDate(1, 0.0);
            JulianDate two = new JulianDate(1, 1e-11);

            Assert.IsTrue(two > one);
            Assert.IsTrue(two >= one);
            Assert.IsFalse(one > two);
            Assert.IsFalse(one >= two);
            Assert.IsFalse(two < one);
            Assert.IsFalse(two <= one);
            Assert.IsTrue(one < two);
            Assert.IsTrue(one <= two);
            Assert.IsFalse(one == two);
            Assert.IsFalse(two == one);
            Assert.IsTrue(one != two);
            Assert.IsTrue(two != one);
        }

        /// <summary>
        /// Tests construction of a <see cref="JulianDate"/> with a really small negative
        /// secondsOfDay.  JulianDate will attempt to eliminate the negative SecondsOfDay
        /// by rolling the Day back one day, but doing so results in setting the SecondsOfDay to
        /// 86400.0 seconds.  This is still not normalized, so JulianDate should bump the Day
        /// back up and round the SecondsOfDay to 0.0.
        /// </summary>
        [Test]
        public void TestReallySmallNegativeSecondsOfDay()
        {
            JulianDate date = new JulianDate(2451545, -Constants.Epsilon13);
            Assert.AreEqual(date.Day, 2451545);
            Assert.AreEqual(0.0, date.SecondsOfDay);
        }

        [Test]
        public void TestTryConvertTimeStandard()
        {
            JulianDate leapSecond = new JulianDate(2453736, 43232, TimeStandard.InternationalAtomicTime);
            JulianDate afterLeapSecond = new JulianDate(2453736, 43233, TimeStandard.InternationalAtomicTime);

            JulianDate outDate;

            Assert.IsFalse(leapSecond.TryConvertTimeStandard(TimeStandard.CoordinatedUniversalTime, out outDate));
            Assert.IsTrue(afterLeapSecond.TryConvertTimeStandard(TimeStandard.CoordinatedUniversalTime, out outDate));
            Assert.AreEqual(outDate.Standard, TimeStandard.CoordinatedUniversalTime);
            Assert.AreEqual(outDate, afterLeapSecond);
        }

        [Test]
        public void TestEqualityOfLeapSeconds()
        {
            JulianDate leapSecond = new JulianDate(2453736, 43233, TimeStandard.InternationalAtomicTime);
            JulianDate utcDate = new JulianDate(2453736, 43233, TimeStandard.CoordinatedUniversalTime);

            Assert.IsFalse(utcDate.Equals(leapSecond));
            Assert.IsFalse(leapSecond.Equals(utcDate));
        }

        [Test]
        public void TestSecondsDifferenceAtLeapSecond()
        {
            JulianDate leapSecond = new JulianDate(2453736, 43232, TimeStandard.InternationalAtomicTime);
            JulianDate utcDate = new JulianDate(2453736, 43232, TimeStandard.CoordinatedUniversalTime);

            Assert.AreEqual(-33, utcDate.SecondsDifference(leapSecond));
            Assert.AreEqual(33, leapSecond.SecondsDifference(utcDate));

            JulianDate secondBeforeLeapSecondUTC = leapSecond.SubtractSeconds(1).ToTimeStandard(TimeStandard.CoordinatedUniversalTime);
            JulianDate secondAfterLeapSecondUTC = leapSecond.AddSeconds(1).ToTimeStandard(TimeStandard.CoordinatedUniversalTime);

            Assert.AreEqual(2, secondBeforeLeapSecondUTC.SecondsDifference(secondAfterLeapSecondUTC));
            Assert.AreEqual(2, secondAfterLeapSecondUTC.Subtract(secondBeforeLeapSecondUTC).Seconds);
        }
    }
}