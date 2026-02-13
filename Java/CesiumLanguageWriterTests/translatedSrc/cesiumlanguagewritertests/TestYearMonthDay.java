package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 * A series of tests to exercise this type.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestYearMonthDay {
    /**
    * Tests that an appropriate exception is thrown when constructing a
    YearMonthDay with an invalid date.
    */
    @Test
    public final void testConstructWithInvalidDate() {
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            YearMonthDay unused = new YearMonthDay(2006, 2, 29);
        }));
    }

    /**
    * Tests that years divisible by 4, except for years which are both divisible
    by 100 and not divisible by 400, are leap years.
    */
    @Test
    public final void testIsLeapYear() {
        for (int i = 1; i < 10000; ++i) {
            if ((i % 4 == 0) && !((i % 100 == 0) && (i % 400 != 0))) {
                Assert.assertTrue(YearMonthDay.isLeapYear(i));
            }
        }
    }

    /**
    * Tests that years divisible by 4, except for years which are both divisible
    by 100 and not divisible by 400, have 366 days instead of 365.
    */
    @Test
    public final void testDaysInYear() {
        for (int i = 1; i < 10000; ++i) {
            if ((i % 4 == 0) && !((i % 100 == 0) && (i % 400 != 0))) {
                AssertHelper.assertEquals(366, YearMonthDay.daysInYear(i));
            } else {
                AssertHelper.assertEquals(365, YearMonthDay.daysInYear(i));
            }
        }
    }

    /**
    * Tests that the length of the month is reported correctly for common years and leap years.
    */
    @Test
    public final void testDaysInMonth() {
        for (int i = 1; i < 10000; ++i) {
            AssertHelper.assertEquals(31, YearMonthDay.daysInMonth(i, 1));
            // January
            if ((i % 4 == 0) && !((i % 100 == 0) && (i % 400 != 0))) {
                AssertHelper.assertEquals(29, YearMonthDay.daysInMonth(i, 2));
                // February of a leap year
            } else {
                AssertHelper.assertEquals(28, YearMonthDay.daysInMonth(i, 2));
                // February of a common year
            }
            AssertHelper.assertEquals(31, YearMonthDay.daysInMonth(i, 3));
            // March
            AssertHelper.assertEquals(30, YearMonthDay.daysInMonth(i, 4));
            // April
            AssertHelper.assertEquals(31, YearMonthDay.daysInMonth(i, 5));
            // May
            AssertHelper.assertEquals(30, YearMonthDay.daysInMonth(i, 6));
            // June
            AssertHelper.assertEquals(31, YearMonthDay.daysInMonth(i, 7));
            // July
            AssertHelper.assertEquals(31, YearMonthDay.daysInMonth(i, 8));
            // August
            AssertHelper.assertEquals(30, YearMonthDay.daysInMonth(i, 9));
            // September
            AssertHelper.assertEquals(31, YearMonthDay.daysInMonth(i, 10));
            // October
            AssertHelper.assertEquals(30, YearMonthDay.daysInMonth(i, 11));
            // November
            AssertHelper.assertEquals(31, YearMonthDay.daysInMonth(i, 12));
            // December
        }
    }

    /**
    * Tests that month of year and day of month ranges are validated correctly.
    There is no current limit on the year representation.
    */
    @Test
    public final void testIsValidDate() {
        Assert.assertFalse(YearMonthDay.isValidDate(2000, 0, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 1, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 2, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 3, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 4, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 5, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 6, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 7, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 8, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 9, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 10, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 11, 1));
        Assert.assertTrue(YearMonthDay.isValidDate(2000, 12, 1));
        Assert.assertFalse(YearMonthDay.isValidDate(2000, 13, 1));
        for (int month = 1; month < 13; ++month) {
            int daysInMonth = YearMonthDay.daysInMonth(2000, month);
            Assert.assertFalse(YearMonthDay.isValidDate(2000, month, 0));
            for (int day = 1; day < daysInMonth + 1; ++day) {
                Assert.assertTrue(YearMonthDay.isValidDate(2000, month, day));
            }
            Assert.assertFalse(YearMonthDay.isValidDate(2000, month, daysInMonth + 1));
        }
    }

    /**
    * Tests that initialization of and access to the structure elements is performed correctly.
    */
    @Test
    public final void testRetainValue() {
        YearMonthDay date = new YearMonthDay(2000, 1, 1);
        AssertHelper.assertEquals(2000, date.getYear());
        AssertHelper.assertEquals(1, date.getMonth());
        AssertHelper.assertEquals(1, date.getDay());
    }

    /**
    * Tests the check for EXACT equality.
    */
    @Test
    public final void testEquality() {
        YearMonthDay first = new YearMonthDay(2000, 1, 1);
        YearMonthDay second = new YearMonthDay(2000, 1, 1);
        AssertHelper.assertEquals(first, second);
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        AssertHelper.assertEquals(0, first.compareTo(second));
        AssertHelper.assertEquals(0, second.compareTo(first));
        second = new YearMonthDay(2001, 1, 1);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        second = new YearMonthDay(2000, 2, 1);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        second = new YearMonthDay(2000, 1, 2);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        AssertHelper.assertNotEqual(first, 5);
    }

    /**
    * Tests the {@code DayOfYear} ({@link YearMonthDay#getDayOfYear get}) property.
    */
    @Test
    public final void testDayOfYear() {
        YearMonthDay nonLeapBeforeEndOfFeb = new YearMonthDay(2006, 2, 15);
        AssertHelper.assertEquals(46, nonLeapBeforeEndOfFeb.getDayOfYear());
        YearMonthDay nonLeapAfterEndOfFeb = new YearMonthDay(2006, 3, 14);
        AssertHelper.assertEquals(73, nonLeapAfterEndOfFeb.getDayOfYear());
        YearMonthDay leapBeforeEndOfFeb = new YearMonthDay(2008, 2, 15);
        AssertHelper.assertEquals(46, leapBeforeEndOfFeb.getDayOfYear());
        YearMonthDay leapAfterEndOfFeb = new YearMonthDay(2008, 3, 14);
        AssertHelper.assertEquals(74, leapAfterEndOfFeb.getDayOfYear());
    }

    /**
    * Tests the CompareTo methods and the comparison operators.
    */
    @Test
    public final void testComparisons() {
        YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
        YearMonthDay ymd2 = new YearMonthDay(2006, 3, 14);
        YearMonthDay ymd3 = new YearMonthDay(2006, 5, 26);
        Object ymd4 = new YearMonthDay(2004, 2, 21);
        Assert.assertTrue(YearMonthDay.equals(ymd1, ymd2));
        Assert.assertTrue(YearMonthDay.equals(ymd2, ymd1));
        Assert.assertTrue(YearMonthDay.notEquals(ymd1, ymd3));
        Assert.assertTrue(YearMonthDay.greaterThanOrEqual(ymd1, ymd2));
        Assert.assertTrue(YearMonthDay.lessThanOrEqual(ymd1, ymd2));
        AssertHelper.assertEquals(0, ymd1.compareTo(ymd2));
        Assert.assertTrue(YearMonthDay.lessThan(ymd2, ymd3));
        Assert.assertTrue(YearMonthDay.lessThanOrEqual(ymd2, ymd3));
        Assert.assertTrue(YearMonthDay.greaterThan(ymd3, ymd2));
        Assert.assertTrue(YearMonthDay.greaterThanOrEqual(ymd3, ymd2));
        AssertHelper.assertNotEqual(ymd1, ymd4);
    }

    /**
    * Tests that YearMonthDay.GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
        YearMonthDay ymd2 = new YearMonthDay(2006, 3, 14);
        YearMonthDay ymd3 = new YearMonthDay(2006, 5, 26);
        AssertHelper.assertEquals(ymd1.hashCode(), ymd2.hashCode());
        AssertHelper.assertNotEqual(ymd1.hashCode(), ymd3.hashCode());
    }

    /**
    * Tests the {@link YearMonthDay#toString} method.
    */
    @Test
    public final void testToString() {
        YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
        AssertHelper.assertEquals(ymd1.toString(), "2006:3:14");
    }

    /**
    * Tests the constructor overload that takes a {@link JulianDate}.
    */
    @Test
    public final void testConstructFromJulianDate() {
        ZonedDateTime dt = DateTimeHelper.create(2008, 10, 23, 12, 0, 0);
        JulianDate jd = new JulianDate(dt);
        YearMonthDay ymd = new YearMonthDay(jd);
        AssertHelper.assertEquals(2008, ymd.getYear());
        AssertHelper.assertEquals(10, ymd.getMonth());
        AssertHelper.assertEquals(23, ymd.getDay());
        dt = DateTimeHelper.create(2008, 10, 23, 0, 0, 0);
        jd = new JulianDate(dt);
        ymd = new YearMonthDay(jd);
        AssertHelper.assertEquals(2008, ymd.getYear());
        AssertHelper.assertEquals(10, ymd.getMonth());
        AssertHelper.assertEquals(23, ymd.getDay());
        dt = DateTimeHelper.create(2008, 10, 23, 23, 59, 59);
        jd = new JulianDate(dt);
        ymd = new YearMonthDay(jd);
        AssertHelper.assertEquals(2008, ymd.getYear());
        AssertHelper.assertEquals(10, ymd.getMonth());
        AssertHelper.assertEquals(23, ymd.getDay());
    }

    /**
    * Tests the constructor overload that takes a year and the day of the year as parameters.
    */
    @Test
    public final void testConstructFromDayOfYear() {
        int[] years = {
            2000,
            2001
        };
        Assert.assertTrue(YearMonthDay.isLeapYear(years[0]));
        Assert.assertFalse(YearMonthDay.isLeapYear(years[1]));
        for (final int year : years) {
            int cumulativeDays = 0;
            for (int month = 1; month <= 12; ++month) {
                // Test first of the month.
                YearMonthDay ymd = new YearMonthDay(year, cumulativeDays + 1);
                AssertHelper.assertEquals(year, ymd.getYear());
                AssertHelper.assertEquals(month, ymd.getMonth());
                AssertHelper.assertEquals(1, ymd.getDay());
                int daysInMonth = YearMonthDay.daysInMonth(year, month);
                // Test last of the month.
                ymd = new YearMonthDay(year, cumulativeDays + daysInMonth);
                AssertHelper.assertEquals(year, ymd.getYear());
                AssertHelper.assertEquals(month, ymd.getMonth());
                AssertHelper.assertEquals(daysInMonth, ymd.getDay());
                cumulativeDays += daysInMonth;
            }
        }
    }

    @Test
    public final void testJulianDayNumber() {
        final int astronomicalJulianDayNumber = 2454959;
        YearMonthDay ymd = new YearMonthDay(astronomicalJulianDayNumber);
        AssertHelper.assertEquals(astronomicalJulianDayNumber, ymd.getJulianDayNumber());
    }

    @Test
    public final void testDayOfWeek() {
        YearMonthDay ymd = new YearMonthDay(2009, 6, 10);
        AssertHelper.assertEquals(DayOfWeek.WEDNESDAY, ymd.getDayOfWeek());
        ymd = new YearMonthDay(2009, 6, 11);
        AssertHelper.assertEquals(DayOfWeek.THURSDAY, ymd.getDayOfWeek());
    }

    @Test
    public final void testRoundTripDefaultConstructed() {
        YearMonthDay ymd = new YearMonthDay();
        YearMonthDay ymd2 = new YearMonthDay(ymd.getJulianDayNumber());
        AssertHelper.assertEquals(ymd, ymd2);
    }

    @Test
    public final void testDefaultConstructedIsValid() {
        YearMonthDay ymd = new YearMonthDay();
        YearMonthDay ymd2 = new YearMonthDay(ymd.getYear(), ymd.getMonth(), ymd.getDay());
        AssertHelper.assertEquals(ymd, ymd2);
        AssertHelper.assertEquals(ymd.getDayOfWeek(), ymd2.getDayOfWeek());
        AssertHelper.assertEquals(ymd.getDayOfYear(), ymd2.getDayOfYear());
    }

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}