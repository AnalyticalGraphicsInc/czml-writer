package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.Enumeration;
import agi.foundation.compatibility.EnumHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestYearMonthDay {
    /**
    * Leap years are divisible by 4, except for years which are divisible by 100, unless also divisible by 400.
    */
    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static enum Month implements Enumeration {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        private final int value;

        Month(int value) {
            this.value = value;
        }

        /**
        * Get the numeric value associated with this enum constant.
        * @return A numeric value.
        */
        @Override
        public int getValue() {
            return value;
        }

        /**
        * Get the enum constant that is associated with the given numeric value.
        * @return The enum constant associated with value.
        * @param value a numeric value.
        */
        @Nonnull
        public static Month getFromValue(int value) {
            switch (value) {
            case 1:
                return JANUARY;
            case 2:
                return FEBRUARY;
            case 3:
                return MARCH;
            case 4:
                return APRIL;
            case 5:
                return MAY;
            case 6:
                return JUNE;
            case 7:
                return JULY;
            case 8:
                return AUGUST;
            case 9:
                return SEPTEMBER;
            case 10:
                return OCTOBER;
            case 11:
                return NOVEMBER;
            case 12:
                return DECEMBER;
            default:
                throw new IllegalArgumentException("Undefined enum value.");
            }
        }

        /**
        * Get the enum constant that is considered to be the default.
        * @return The default enum constant.
        */
        @Nullable
        public static Month getDefault() {
            return null;
        }
    }

    private static int daysInMonth(int year, @Nonnull Month month) {
        switch (month) {
        case FEBRUARY: {
            return isLeapYear(year) ? 29 : 28;
        }
        case APRIL:
        case JUNE:
        case SEPTEMBER:
        case NOVEMBER: {
            return 30;
        }
        default: {
            return 31;
        }
        }
    }

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
    * Tests that leap years are detected correctly.
    */
    @Test
    public final void testIsLeapYear() {
        for (int year = 1; year <= 9999; ++year) {
            boolean expected = isLeapYear(year);
            AssertHelper.assertEquals(expected, YearMonthDay.isLeapYear(year));
        }
    }

    /**
    * Tests that leap years have 366 days instead of 365.
    */
    @Test
    public final void testDaysInYear() {
        for (int year = 1; year <= 9999; ++year) {
            int expected = isLeapYear(year) ? 366 : 365;
            AssertHelper.assertEquals(expected, YearMonthDay.daysInYear(year));
        }
    }

    /**
    * Tests that the length of the month is reported correctly for common years and leap years.
    */
    public final void testDaysInMonth(@Nonnull Month m) {
        for (int year = 1; year <= 9999; ++year) {
            int month = m.getValue();
            int expected = daysInMonth(year, m);
            AssertHelper.assertEquals(expected, YearMonthDay.daysInMonth(year, month));
        }
    }

    @Test
    public final void testDaysInMonth$Test() {
        for (final Month m : EnumHelper.getValues(Month.class)) {
            testDaysInMonth(m);
        }
    }

    /**
    * Tests that month of year and day of month ranges are validated correctly.
    */
    public final void testIsValidDate(@Nonnull Month m) {
        final int year = 2000;
        int month = m.getValue();
        int daysInMonth = YearMonthDay.daysInMonth(year, month);
        for (int day = 1; day <= daysInMonth; ++day) {
            Assert.assertTrue(YearMonthDay.isValidDate(year, month, day));
        }
        Assert.assertFalse(YearMonthDay.isValidDate(year, month, 0));
        Assert.assertFalse(YearMonthDay.isValidDate(year, month, daysInMonth + 1));
    }

    @Test
    public final void testIsValidDate$Test() {
        for (final Month m : EnumHelper.getValues(Month.class)) {
            testIsValidDate(m);
        }
    }

    @Test
    public final void testIsValidDateWithInvalidMonth() {
        Assert.assertFalse(YearMonthDay.isValidDate(2000, 0, 1));
        Assert.assertFalse(YearMonthDay.isValidDate(2000, 13, 1));
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
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEquality() {
        YearMonthDay first = new YearMonthDay(2000, 1, 1);
        YearMonthDay second = new YearMonthDay(2000, 1, 1);
        AssertHelper.assertEquals(first, second);
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        AssertHelper.assertEquals(0, first.compareTo(second));
        AssertHelper.assertEquals(0, second.compareTo(first));
        Assert.assertTrue(YearMonthDay.equals(first, second));
        Assert.assertTrue(YearMonthDay.equals(second, first));
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
        Assert.assertTrue(YearMonthDay.notEquals(first, second));
        Assert.assertTrue(YearMonthDay.notEquals(second, first));
        Object obj = new YearMonthDay(2004, 2, 21);
        AssertHelper.assertNotEqual(first, obj);
        Object differentType = 5;
        AssertHelper.assertNotEqual(first, differentType);
    }

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
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testComparisons() {
        YearMonthDay ymd1 = new YearMonthDay(2006, 3, 14);
        YearMonthDay ymd2 = new YearMonthDay(2006, 3, 14);
        YearMonthDay ymd3 = new YearMonthDay(2006, 5, 26);
        Assert.assertTrue(YearMonthDay.greaterThanOrEqual(ymd1, ymd2));
        Assert.assertTrue(YearMonthDay.lessThanOrEqual(ymd1, ymd2));
        AssertHelper.assertEquals(0, ymd1.compareTo(ymd2));
        Assert.assertTrue(YearMonthDay.lessThan(ymd2, ymd3));
        Assert.assertTrue(YearMonthDay.lessThanOrEqual(ymd2, ymd3));
        Assert.assertTrue(YearMonthDay.greaterThan(ymd3, ymd2));
        Assert.assertTrue(YearMonthDay.greaterThanOrEqual(ymd3, ymd2));
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
        AssertHelper.assertEquals("2006:3:14", ymd1.toString());
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
    public final void testConstructFromDayOfYear(int year, @Nonnull Month m) {
        int month = m.getValue();
        // Test each day of the month.
        for (int day = 1; day <= YearMonthDay.daysInMonth(year, month); ++day) {
            int dayOfYear = DateTimeHelper.create(year, month, day).getDayOfYear();
            YearMonthDay ymd = new YearMonthDay(year, dayOfYear);
            AssertHelper.assertEquals(year, ymd.getYear());
            AssertHelper.assertEquals(month, ymd.getMonth());
            AssertHelper.assertEquals(day, ymd.getDay());
        }
    }

    @Test
    public final void testConstructFromDayOfYear$Test() {
        for (final int year : new int[] {
            2000,
            2001
        }) {
            for (final Month m : EnumHelper.getValues(Month.class)) {
                testConstructFromDayOfYear(year, m);
            }
        }
    }

    @Test
    public final void constructorThrowsWithInvalidDayOfYear() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            YearMonthDay unused = new YearMonthDay(2000, 0);
        }));
        AssertHelper.assertEquals("dayOfYear", exception.getParamName());
        exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            YearMonthDay unused = new YearMonthDay(2000, 367);
        }));
        AssertHelper.assertEquals("dayOfYear", exception.getParamName());
    }

    @Test
    public final void testJulianDayNumber() {
        final int julianDayNumber = 2454959;
        YearMonthDay ymd = new YearMonthDay(julianDayNumber);
        AssertHelper.assertEquals(julianDayNumber, ymd.getJulianDayNumber());
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