using System;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// A series of tests to exercise this type.
    /// </summary>
    [TestFixture]
    public class TestYearMonthDay
    {
        /// <summary>
        /// Tests that an appropriate exception is thrown when constructing a
        /// YearMonthDay with an invalid date.
        /// </summary>
        [Test]
        [ExpectedException(typeof (ArgumentException))]
        public void TestConstructWithInvalidDate()
        {
            YearMonthDay ymd = new YearMonthDay(2006, 2, 29);
        }

        /// <summary>
        /// Tests that years divisible by 4, except for years which are both divisible
        /// by 100 and not divisible by 400, are leap years.
        /// </summary>
        [Test]
        public void TestIsLeapYear()
        {
            for (int i = 1; i < 10000; ++i)
            {
                if ((i % 4 == 0) && !((i % 100 == 0) && (i % 400 != 0)))
                {
                    Assert.IsTrue(YearMonthDay.IsLeapYear(i));
                }
            }
        }

        /// <summary>
        /// Tests that years divisible by 4, except for years which are both divisible
        /// by 100 and not divisible by 400, have 366 days instead of 365.
        /// </summary>
        [Test]
        public void TestDaysInYear()
        {
            for (int i = 1; i < 10000; ++i)
            {
                if ((i % 4 == 0) && !((i % 100 == 0) && (i % 400 != 0)))
                {
                    Assert.AreEqual(366, YearMonthDay.DaysInYear(i));
                }
                else
                {
                    Assert.AreEqual(365, YearMonthDay.DaysInYear(i));
                }
            }
        }

        /// <summary>
        /// Tests that the length of the month is reported correctly for common years and leap years.
        /// </summary>
        [Test]
        public void TestDaysInMonth()
        {
            for (int i = 1; i < 10000; ++i)
            {
                Assert.AreEqual(31, YearMonthDay.DaysInMonth(i, 1)); // January
                if ((i % 4 == 0) && !((i % 100 == 0) && (i % 400 != 0)))
                {
                    Assert.AreEqual(29, YearMonthDay.DaysInMonth(i, 2)); // February of a leap year
                }
                else
                {
                    Assert.AreEqual(28, YearMonthDay.DaysInMonth(i, 2)); // February of a common year
                }
                Assert.AreEqual(31, YearMonthDay.DaysInMonth(i, 3)); // March
                Assert.AreEqual(30, YearMonthDay.DaysInMonth(i, 4)); // April
                Assert.AreEqual(31, YearMonthDay.DaysInMonth(i, 5)); // May
                Assert.AreEqual(30, YearMonthDay.DaysInMonth(i, 6)); // June
                Assert.AreEqual(31, YearMonthDay.DaysInMonth(i, 7)); // July
                Assert.AreEqual(31, YearMonthDay.DaysInMonth(i, 8)); // August
                Assert.AreEqual(30, YearMonthDay.DaysInMonth(i, 9)); // September
                Assert.AreEqual(31, YearMonthDay.DaysInMonth(i, 10)); // October
                Assert.AreEqual(30, YearMonthDay.DaysInMonth(i, 11)); // November
                Assert.AreEqual(31, YearMonthDay.DaysInMonth(i, 12)); // December
            }
        }

        /// <summary>
        /// Tests that month of year and day of month ranges are validated correctly.
        /// There is no current limit on the year representation.
        /// </summary>
        [Test]
        public void TestIsValidDate()
        {
            Assert.IsFalse(YearMonthDay.IsValidDate(2000, 0, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 1, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 2, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 3, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 4, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 5, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 6, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 7, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 8, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 9, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 10, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 11, 1));
            Assert.IsTrue(YearMonthDay.IsValidDate(2000, 12, 1));
            Assert.IsFalse(YearMonthDay.IsValidDate(2000, 13, 1));

            for (int month = 1; month < 13; ++month)
            {
                int daysInMonth = YearMonthDay.DaysInMonth(2000, month);

                Assert.IsFalse(YearMonthDay.IsValidDate(2000, month, 0));
                for (int day = 1; day < daysInMonth + 1; ++day)
                {
                    Assert.IsTrue(YearMonthDay.IsValidDate(2000, month, day));
                }
                Assert.IsFalse(YearMonthDay.IsValidDate(2000, month, daysInMonth + 1));
            }
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
        public void TestEquality()
        {
            YearMonthDay first = new YearMonthDay(2000, 1, 1);
            YearMonthDay second = new YearMonthDay(2000, 1, 1);
            Assert.AreEqual(first, second);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));
            Assert.AreEqual(0, first.CompareTo(second));
            Assert.AreEqual(0, second.CompareTo(first));

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

            Assert.AreNotEqual(first, 5);
        }

        /// <summary>
        /// Tests the <see cref="YearMonthDay.DayOfYear"/> property.
        /// </summary>
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
        public void TestComparisons()
        {
            YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
            YearMonthDay ymd2 = new YearMonthDay(2006, 3, 14);
            YearMonthDay ymd3 = new YearMonthDay(2006, 5, 26);
            object ymd4 = new YearMonthDay(2004, 2, 21);

            Assert.IsTrue(ymd1 == ymd2);
            Assert.IsTrue(ymd2 == ymd1);
            Assert.IsTrue(ymd1 != ymd3);
            Assert.IsTrue(ymd1 >= ymd2);
            Assert.IsTrue(ymd1 <= ymd2);
            Assert.IsTrue(ymd1.CompareTo(ymd2) == 0);
            Assert.IsTrue(ymd2 < ymd3);
            Assert.IsTrue(ymd2 <= ymd3);
            Assert.IsTrue(ymd3 > ymd2);
            Assert.IsTrue(ymd3 >= ymd2);
            Assert.AreNotEqual(ymd1, ymd4);
        }

        [Test]
        [CSToJavaExclude]
        public void TestCompareToObject()
        {
            YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
            object ymd4 = new YearMonthDay(2004, 2, 21);

            Assert.IsTrue(ymd1.CompareTo(null) > 0);
            Assert.IsTrue(ymd1.CompareTo(ymd4) > 0);
        }

        /// <summary>
        /// Tests that an appropriate exception is thrown when CompareTo is
        /// invoked on a type that is not a YearMonthDay.
        /// </summary>
        [Test]
        [ExpectedException(typeof (ArgumentException))]
        [CSToJavaExclude]
        public void TestCompareToWrongType()
        {
            YearMonthDay ymd = new YearMonthDay(2006, 3, 14);
            ymd.CompareTo(5);
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
            Assert.AreEqual(ymd1.ToString(), "2006:3:14");
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
        public void TestConstructFromDayOfYear()
        {
            int[] years = { 2000, 2001 };

            Assert.IsTrue(YearMonthDay.IsLeapYear(years[0]));
            Assert.IsFalse(YearMonthDay.IsLeapYear(years[1]));

            foreach (int year in years)
            {
                int cumulativeDays = 0;
                for (int month = 1; month <= 12; ++month)
                {
                    // Test first of the month.
                    YearMonthDay ymd = new YearMonthDay(year, cumulativeDays + 1);
                    Assert.AreEqual(year, ymd.Year);
                    Assert.AreEqual(month, ymd.Month);
                    Assert.AreEqual(1, ymd.Day);

                    int daysInMonth = YearMonthDay.DaysInMonth(year, month);

                    // Test last of the month.
                    ymd = new YearMonthDay(year, cumulativeDays + daysInMonth);
                    Assert.AreEqual(year, ymd.Year);
                    Assert.AreEqual(month, ymd.Month);
                    Assert.AreEqual(daysInMonth, ymd.Day);

                    cumulativeDays += daysInMonth;
                }
            }
        }

        [Test]
        public void TestJulianDayNumber()
        {
            const int astronomicalJulianDayNumber = 2454959;
            YearMonthDay ymd = new YearMonthDay(astronomicalJulianDayNumber);
            Assert.AreEqual(astronomicalJulianDayNumber, ymd.JulianDayNumber);
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