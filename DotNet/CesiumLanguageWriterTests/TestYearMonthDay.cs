using System;
using System.Diagnostics.CodeAnalysis;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestYearMonthDay
    {
        /// <summary>
        /// Leap years are divisible by 4, except for years which are divisible by 100, unless also divisible by 400.
        /// </summary>
        private static bool IsLeapYear(int year)
        {
            if (year % 400 == 0)
                return true;
            if (year % 100 == 0)
                return false;
            return year % 4 == 0;
        }

        public enum Month
        {
            January = 1,
            February = 2,
            March = 3,
            April = 4,
            May = 5,
            June = 6,
            July = 7,
            August = 8,
            September = 9,
            October = 10,
            November = 11,
            December = 12,
        }

        private static int DaysInMonth(int year, Month month)
        {
            switch (month)
            {
                case Month.February:
                    return IsLeapYear(year) ? 29 : 28;
                case Month.April:
                case Month.June:
                case Month.September:
                case Month.November:
                    return 30;
                default:
                    return 31;
            }
        }

        /// <summary>
        /// Tests that an appropriate exception is thrown when constructing a
        /// YearMonthDay with an invalid date.
        /// </summary>
        [Test]
        public void TestConstructWithInvalidDate()
        {
            Assert.Throws<ArgumentException>(() =>
            {
                var unused = new YearMonthDay(2006, 2, 29);
            });
        }

        /// <summary>
        /// Tests that leap years are detected correctly.
        /// </summary>
        [Test]
        public void TestIsLeapYear()
        {
            for (int year = 1; year <= 9999; ++year)
            {
                bool expected = IsLeapYear(year);
                Assert.AreEqual(expected, YearMonthDay.IsLeapYear(year));
            }
        }

        /// <summary>
        /// Tests that leap years have 366 days instead of 365.
        /// </summary>
        [Test]
        public void TestDaysInYear()
        {
            for (int year = 1; year <= 9999; ++year)
            {
                int expected = IsLeapYear(year) ? 366 : 365;
                Assert.AreEqual(expected, YearMonthDay.DaysInYear(year));
            }
        }

        /// <summary>
        /// Tests that the length of the month is reported correctly for common years and leap years.
        /// </summary>
        [Test]
        public void TestDaysInMonth([Values] Month m)
        {
            for (int year = 1; year <= 9999; ++year)
            {
                int month = (int)m;
                int expected = DaysInMonth(year, m);
                Assert.AreEqual(expected, YearMonthDay.DaysInMonth(year, month));
            }
        }

        /// <summary>
        /// Tests that month of year and day of month ranges are validated correctly.
        /// </summary>
        [Test]
        public void TestIsValidDate([Values] Month m)
        {
            const int year = 2000;
            int month = (int)m;
            int daysInMonth = YearMonthDay.DaysInMonth(year, month);

            for (int day = 1; day <= daysInMonth; ++day)
            {
                Assert.IsTrue(YearMonthDay.IsValidDate(year, month, day));
            }

            Assert.IsFalse(YearMonthDay.IsValidDate(year, month, 0));
            Assert.IsFalse(YearMonthDay.IsValidDate(year, month, daysInMonth + 1));
        }

        [Test]
        public void TestIsValidDateWithInvalidMonth()
        {
            Assert.IsFalse(YearMonthDay.IsValidDate(2000, 0, 1));
            Assert.IsFalse(YearMonthDay.IsValidDate(2000, 13, 1));
        }

        /// <summary>
        /// Tests that initialization of and access to the structure elements is performed correctly.
        /// </summary>
        [Test]
        public void TestRetainValue()
        {
            YearMonthDay date = new YearMonthDay(2000, 1, 1);
            Assert.AreEqual(2000, date.Year);
            Assert.AreEqual(1, date.Month);
            Assert.AreEqual(1, date.Day);
        }

        /// <summary>
        /// Tests the check for EXACT equality.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
        public void TestEquality()
        {
            var first = new YearMonthDay(2000, 1, 1);
            var second = new YearMonthDay(2000, 1, 1);
            Assert.AreEqual(first, second);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));
            Assert.AreEqual(0, first.CompareTo(second));
            Assert.AreEqual(0, second.CompareTo(first));

            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);

            second = new YearMonthDay(2001, 1, 1);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            second = new YearMonthDay(2000, 2, 1);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            second = new YearMonthDay(2000, 1, 2);
            Assert.AreNotEqual(first, second);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(0, first.CompareTo(second));
            Assert.AreNotEqual(0, second.CompareTo(first));

            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);

            object obj = new YearMonthDay(2004, 2, 21);
            Assert.AreNotEqual(first, obj);

            object differentType = 5;
            Assert.AreNotEqual(first, differentType);
        }

        [Test]
        public void TestDayOfYear()
        {
            YearMonthDay nonLeapBeforeEndOfFeb = new YearMonthDay(2006, 2, 15);
            Assert.AreEqual(46, nonLeapBeforeEndOfFeb.DayOfYear);

            YearMonthDay nonLeapAfterEndOfFeb = new YearMonthDay(2006, 3, 14);
            Assert.AreEqual(73, nonLeapAfterEndOfFeb.DayOfYear);

            YearMonthDay leapBeforeEndOfFeb = new YearMonthDay(2008, 2, 15);
            Assert.AreEqual(46, leapBeforeEndOfFeb.DayOfYear);

            YearMonthDay leapAfterEndOfFeb = new YearMonthDay(2008, 3, 14);
            Assert.AreEqual(74, leapAfterEndOfFeb.DayOfYear);
        }

        /// <summary>
        /// Tests the CompareTo methods and the comparison operators.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2043", Justification = "This is specifically testing operator overloads")]
        public void TestComparisons()
        {
            YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
            YearMonthDay ymd2 = new YearMonthDay(2006, 3, 14);
            YearMonthDay ymd3 = new YearMonthDay(2006, 5, 26);

            Assert.IsTrue(ymd1 >= ymd2);
            Assert.IsTrue(ymd1 <= ymd2);
            Assert.AreEqual(0, ymd1.CompareTo(ymd2));
            Assert.IsTrue(ymd2 < ymd3);
            Assert.IsTrue(ymd2 <= ymd3);
            Assert.IsTrue(ymd3 > ymd2);
            Assert.IsTrue(ymd3 >= ymd2);
        }

        [Test]
        [CSToJavaExclude]
        public void TestCompareToObject()
        {
            var ymd = new YearMonthDay(2006, 3, 14);
            object ymdAsObject = new YearMonthDay(2004, 2, 21);

            Assert.Greater(ymd.CompareTo(null), 0);
            Assert.Greater(ymd.CompareTo(ymdAsObject), 0);
        }

        /// <summary>
        /// Tests that an appropriate exception is thrown when CompareTo is
        /// invoked on a type that is not a YearMonthDay.
        /// </summary>
        [Test]
        [CSToJavaExclude]
        public void TestCompareToWrongType()
        {
            YearMonthDay ymd = new YearMonthDay(2006, 3, 14);
            Assert.Throws<ArgumentException>(() =>
            {
                int unused = ymd.CompareTo(5);
            });
        }

        /// <summary>
        /// Tests that YearMonthDay.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
            YearMonthDay ymd2 = new YearMonthDay(2006, 3, 14);
            YearMonthDay ymd3 = new YearMonthDay(2006, 5, 26);
            Assert.AreEqual(ymd1.GetHashCode(), ymd2.GetHashCode());
            Assert.AreNotEqual(ymd1.GetHashCode(), ymd3.GetHashCode());
        }

        /// <summary>
        /// Tests the <see cref="YearMonthDay.ToString"/> method.
        /// </summary>
        [Test]
        public void TestToString()
        {
            YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
            Assert.AreEqual("2006:3:14", ymd1.ToString());
        }

        /// <summary>
        /// Tests the constructor overload that takes a <see cref="JulianDate"/>.
        /// </summary>
        [Test]
        public void TestConstructFromJulianDate()
        {
            DateTime dt = new DateTime(2008, 10, 23, 12, 0, 0);
            JulianDate jd = new JulianDate(dt);

            YearMonthDay ymd = new YearMonthDay(jd);
            Assert.AreEqual(2008, ymd.Year);
            Assert.AreEqual(10, ymd.Month);
            Assert.AreEqual(23, ymd.Day);

            dt = new DateTime(2008, 10, 23, 0, 0, 0);
            jd = new JulianDate(dt);

            ymd = new YearMonthDay(jd);
            Assert.AreEqual(2008, ymd.Year);
            Assert.AreEqual(10, ymd.Month);
            Assert.AreEqual(23, ymd.Day);

            dt = new DateTime(2008, 10, 23, 23, 59, 59);
            jd = new JulianDate(dt);

            ymd = new YearMonthDay(jd);
            Assert.AreEqual(2008, ymd.Year);
            Assert.AreEqual(10, ymd.Month);
            Assert.AreEqual(23, ymd.Day);
        }

        /// <summary>
        /// Tests the constructor overload that takes a year and the day of the year as parameters.
        /// </summary>
        [Test]
        [Combinatorial]
        public void TestConstructFromDayOfYear([Values(2000, 2001)] int year, [Values] Month m)
        {
            int month = (int)m;
            // Test each day of the month.
            for (int day = 1; day <= YearMonthDay.DaysInMonth(year, month); ++day)
            {
                int dayOfYear = new DateTime(year, month, day).DayOfYear;

                var ymd = new YearMonthDay(year, dayOfYear);
                Assert.AreEqual(year, ymd.Year);
                Assert.AreEqual(month, ymd.Month);
                Assert.AreEqual(day, ymd.Day);
            }
        }

        [Test]
        public void ConstructorThrowsWithInvalidDayOfYear()
        {
            var exception = Assert.Throws<ArgumentException>(() =>
            {
                var unused = new YearMonthDay(2000, 0);
            });
            Assert.AreEqual("dayOfYear", exception.ParamName);

            exception = Assert.Throws<ArgumentException>(() =>
            {
                var unused = new YearMonthDay(2000, 367);
            });
            Assert.AreEqual("dayOfYear", exception.ParamName);
        }

        [Test]
        public void TestJulianDayNumber()
        {
            const int julianDayNumber = 2454959;
            YearMonthDay ymd = new YearMonthDay(julianDayNumber);
            Assert.AreEqual(julianDayNumber, ymd.JulianDayNumber);
        }

        [Test]
        public void TestDayOfWeek()
        {
            YearMonthDay ymd = new YearMonthDay(2009, 06, 10);
            Assert.AreEqual(DayOfWeek.Wednesday, ymd.DayOfWeek);

            ymd = new YearMonthDay(2009, 06, 11);
            Assert.AreEqual(DayOfWeek.Thursday, ymd.DayOfWeek);
        }

        [Test]
        public void TestRoundTripDefaultConstructed()
        {
            YearMonthDay ymd = new YearMonthDay();
            YearMonthDay ymd2 = new YearMonthDay(ymd.JulianDayNumber);

            Assert.AreEqual(ymd, ymd2);
        }

        [Test]
        public void TestDefaultConstructedIsValid()
        {
            YearMonthDay ymd = new YearMonthDay();
            YearMonthDay ymd2 = new YearMonthDay(ymd.Year, ymd.Month, ymd.Day);

            Assert.AreEqual(ymd, ymd2);
            Assert.AreEqual(ymd.DayOfWeek, ymd2.DayOfWeek);
            Assert.AreEqual(ymd.DayOfYear, ymd2.DayOfYear);
        }
    }
}