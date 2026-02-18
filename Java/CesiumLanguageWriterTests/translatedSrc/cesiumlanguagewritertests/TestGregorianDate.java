package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.ThreadHelper;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import javax.annotation.Nonnull;
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
@CS2JWarning("Unhandled attribute removed: ItemNotNull")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGregorianDate {
    @Test
    public final void canConstructGregorianDate() {
        GregorianDate gregorianDate = new GregorianDate(2000, 1, 2, 6, 30, 15.0);
        AssertHelper.assertEquals(2000, gregorianDate.getYear());
        AssertHelper.assertEquals(1, gregorianDate.getMonth());
        AssertHelper.assertEquals(2, gregorianDate.getDay());
        AssertHelper.assertEquals(6, gregorianDate.getHour());
        AssertHelper.assertEquals(30, gregorianDate.getMinute());
        AssertHelper.assertEquals(15, gregorianDate.getSecond());
        gregorianDate = new GregorianDate(2000, 1, 2);
        AssertHelper.assertEquals(2000, gregorianDate.getYear());
        AssertHelper.assertEquals(1, gregorianDate.getMonth());
        AssertHelper.assertEquals(2, gregorianDate.getDay());
        AssertHelper.assertEquals(0, gregorianDate.getHour());
        AssertHelper.assertEquals(0, gregorianDate.getMinute());
        AssertHelper.assertEquals(0, gregorianDate.getSecond());
    }

    @Test
    public final void cannotConstructWithInvalidTime() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            GregorianDate unused = new GregorianDate(2000, 1, 2, 24, 0, 0.0);
        }));
        AssertHelper.assertStringContains("One or more of the hour, minute, and second arguments is outside of the acceptable range", exception.getMessage());
    }

    @Test
    public final void cannotConstructWithInvalidDate() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            GregorianDate unused = new GregorianDate(2006, 2, 29, 0, 0, 0.0);
        }));
        AssertHelper.assertStringContains("One or more of the hour, minute, and second arguments is outside of the acceptable range", exception.getMessage());
    }

    @Test
    public final void isValidValidatesProperly() {
        Assert.assertFalse(GregorianDate.isValid(2000, 0, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 2, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 3, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 4, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 5, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 6, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 7, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 8, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 9, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 10, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 11, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 12, 1, 0, 0, 0.0));
        Assert.assertFalse(GregorianDate.isValid(2000, 13, 1, 0, 0, 0.0));
        Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, -1, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 0, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 23, 0, 0.0));
        Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 24, 0, 0.0));
        Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, -1, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 59, 0.0));
        Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, 60, 0.0));
        Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, 0, -1.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 0.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 0.00001));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 59.0));
        Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 59.9));
        Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, 0, 60.0));
    }

    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEquality() {
        GregorianDate first = new GregorianDate(2000, 1, 1, 5, 1, 1.0);
        GregorianDate second = new GregorianDate(2000, 1, 1, 5, 1, 1.0);
        AssertHelper.assertEquals(first, second);
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        AssertHelper.assertEquals(0, first.compareTo(second));
        AssertHelper.assertEquals(0, second.compareTo(first));
        Assert.assertTrue(GregorianDate.equals(first, second));
        Assert.assertTrue(GregorianDate.equals(second, first));
        second = new GregorianDate(2000, 1, 1, 6, 1, 1.0);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        Assert.assertTrue(GregorianDate.notEquals(first, second));
        Assert.assertTrue(GregorianDate.notEquals(second, first));
        second = new GregorianDate(2000, 2, 1, 5, 1, 1.0);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        Object differentType = 5;
        AssertHelper.assertNotEqual(first, differentType);
        Object dateAsObject = new GregorianDate(2001, 1, 1, 6, 3, 15.0);
        AssertHelper.assertNotEqual(first, dateAsObject);
    }

    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEqualityInTimePortion() {
        GregorianDate first = new GregorianDate(1999, 10, 10, 5, 1, 1.0);
        GregorianDate second = new GregorianDate(1999, 10, 10, 5, 1, 1.0);
        AssertHelper.assertEquals(first, second);
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        AssertHelper.assertEquals(0, first.compareTo(second));
        AssertHelper.assertEquals(0, second.compareTo(first));
        Assert.assertTrue(GregorianDate.equals(first, second));
        Assert.assertTrue(GregorianDate.equals(second, first));
        second = new GregorianDate(1999, 10, 10, 6, 1, 1.0);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        second = new GregorianDate(1999, 10, 10, 5, 2, 1.0);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        Assert.assertTrue(GregorianDate.notEquals(first, second));
        Assert.assertTrue(GregorianDate.notEquals(second, first));
        second = new GregorianDate(1999, 10, 10, 5, 1, 2.0);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        Object differentType = 5;
        AssertHelper.assertNotEqual(first, differentType);
        Object dateAsObject = new GregorianDate(1999, 10, 10, 4, 2, 21.0);
        AssertHelper.assertNotEqual(first, dateAsObject);
    }

    @Test
    public final void testEqualityWithFractionalSeconds() {
        GregorianDate date = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
        GregorianDate differentDate = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901239);
        GregorianDate sameDate = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
        AssertHelper.assertNotEqual(date.getSecond(), differentDate.getSecond());
        AssertHelper.assertNotEqual(date, differentDate);
        AssertHelper.assertEquals(date, sameDate);
    }

    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testComparisons() {
        GregorianDate date = new GregorianDate(2001, 1, 1, 6, 3, 14.0);
        GregorianDate sameDate = new GregorianDate(2001, 1, 1, 6, 3, 14.0);
        GregorianDate laterTime = new GregorianDate(2001, 1, 1, 6, 5, 26.0);
        GregorianDate laterDay = new GregorianDate(2001, 2, 2, 6, 3, 14.0);
        Assert.assertTrue(GregorianDate.greaterThanOrEqual(date, sameDate));
        Assert.assertTrue(GregorianDate.lessThanOrEqual(date, sameDate));
        AssertHelper.assertEquals(0, date.compareTo(sameDate));
        AssertHelper.assertLess(date.compareTo(laterDay), 0);
        Assert.assertTrue(GregorianDate.lessThan(sameDate, laterTime));
        Assert.assertTrue(GregorianDate.lessThanOrEqual(sameDate, laterTime));
        Assert.assertTrue(GregorianDate.greaterThan(laterTime, sameDate));
        Assert.assertTrue(GregorianDate.greaterThanOrEqual(laterTime, sameDate));
    }

    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testComparisonsOfTimePortion() {
        GregorianDate gd1 = new GregorianDate(1999, 10, 10, 6, 3, 14.0);
        GregorianDate gd2 = new GregorianDate(1999, 10, 10, 6, 3, 14.0);
        GregorianDate gd3 = new GregorianDate(1999, 10, 10, 6, 5, 26.0);
        Assert.assertTrue(GregorianDate.greaterThanOrEqual(gd1, gd2));
        Assert.assertTrue(GregorianDate.lessThanOrEqual(gd1, gd2));
        Assert.assertTrue(GregorianDate.lessThan(gd2, gd3));
        Assert.assertTrue(GregorianDate.lessThanOrEqual(gd2, gd3));
        Assert.assertTrue(GregorianDate.greaterThan(gd3, gd2));
        Assert.assertTrue(GregorianDate.greaterThanOrEqual(gd3, gd2));
    }

    @Test
    public final void testGetHashCode() {
        GregorianDate date = new GregorianDate(2001, 1, 1, 6, 3, 14.0);
        GregorianDate sameDate = new GregorianDate(2001, 1, 1, 6, 3, 14.0);
        GregorianDate differentTime = new GregorianDate(2001, 1, 1, 6, 5, 26.0);
        GregorianDate differentDay = new GregorianDate(2001, 2, 3, 6, 3, 14.0);
        AssertHelper.assertEquals(date.hashCode(), sameDate.hashCode());
        AssertHelper.assertNotEqual(date.hashCode(), differentTime.hashCode());
        AssertHelper.assertNotEqual(date.hashCode(), differentDay.hashCode());
    }

    @Test
    public final void testToStringFormatProvider() {
        Locale cultureInfo = CultureInfoHelper.create("en-US");
        ZonedDateTime date = DateTimeHelper.create(2001, 1, 1, 6, 3, 14, ZoneOffset.UTC);
        GregorianDate gregorianDate = new GregorianDate(date);
        AssertHelper.assertEquals(DateTimeHelper.toString(date, cultureInfo), gregorianDate.toString(cultureInfo));
        date = DateTimeHelper.create(2003, 3, 4, 16, 43, 23, 234, ZoneOffset.UTC);
        gregorianDate = new GregorianDate(date);
        AssertHelper.assertEquals(DateTimeHelper.toString(date, cultureInfo), gregorianDate.toString(cultureInfo));
    }

    @Test
    public final void canConstructFromJulianDate() {
        JulianDate julianDate = new JulianDate(DateTimeHelper.create(2008, 10, 23, 12, 5, 30, 300));
        GregorianDate gregorianDate = new GregorianDate(julianDate);
        AssertHelper.assertEquals(2008, gregorianDate.getYear());
        AssertHelper.assertEquals(10, gregorianDate.getMonth());
        AssertHelper.assertEquals(23, gregorianDate.getDay());
        AssertHelper.assertEquals(12, gregorianDate.getHour());
        AssertHelper.assertEquals(5, gregorianDate.getMinute());
        AssertHelper.assertEquals(30.300, gregorianDate.getSecond(), Constants.Epsilon11);
        julianDate = new JulianDate(DateTimeHelper.create(2008, 10, 23, 0, 0, 0));
        gregorianDate = new GregorianDate(julianDate);
        AssertHelper.assertEquals(2008, gregorianDate.getYear());
        AssertHelper.assertEquals(10, gregorianDate.getMonth());
        AssertHelper.assertEquals(23, gregorianDate.getDay());
        AssertHelper.assertEquals(0, gregorianDate.getHour());
        AssertHelper.assertEquals(0, gregorianDate.getMinute());
        AssertHelper.assertEquals(0.0, gregorianDate.getSecond(), Constants.Epsilon11);
        julianDate = new JulianDate(DateTimeHelper.create(2008, 10, 23, 23, 59, 59, 999));
        gregorianDate = new GregorianDate(julianDate);
        AssertHelper.assertEquals(2008, gregorianDate.getYear());
        AssertHelper.assertEquals(10, gregorianDate.getMonth());
        AssertHelper.assertEquals(23, gregorianDate.getDay());
        AssertHelper.assertEquals(23, gregorianDate.getHour());
        AssertHelper.assertEquals(59, gregorianDate.getMinute());
        AssertHelper.assertEquals(59.999, gregorianDate.getSecond(), Constants.Epsilon11);
    }

    @Test
    public final void canConvertToJulianDate() {
        GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 23, 59, 59.999);
        JulianDate julianDate = gregorianDate.toJulianDate();
        GregorianDate newGregorianDate = new GregorianDate(julianDate);
        AssertHelper.assertEquals(gregorianDate.getYear(), newGregorianDate.getYear());
        AssertHelper.assertEquals(gregorianDate.getMonth(), newGregorianDate.getMonth());
        AssertHelper.assertEquals(gregorianDate.getDay(), newGregorianDate.getDay());
        AssertHelper.assertEquals(gregorianDate.getHour(), newGregorianDate.getHour());
        AssertHelper.assertEquals(gregorianDate.getMinute(), newGregorianDate.getMinute());
        AssertHelper.assertEquals(gregorianDate.getSecond(), newGregorianDate.getSecond(), Constants.Epsilon11);
        gregorianDate = new GregorianDate(2008, 10, 23, 1, 1, 1.0);
        julianDate = gregorianDate.toJulianDate();
        newGregorianDate = new GregorianDate(julianDate);
        AssertHelper.assertEquals(gregorianDate.getYear(), newGregorianDate.getYear());
        AssertHelper.assertEquals(gregorianDate.getMonth(), newGregorianDate.getMonth());
        AssertHelper.assertEquals(gregorianDate.getDay(), newGregorianDate.getDay());
        AssertHelper.assertEquals(gregorianDate.getHour(), newGregorianDate.getHour());
        AssertHelper.assertEquals(gregorianDate.getMinute(), newGregorianDate.getMinute());
        AssertHelper.assertEquals(gregorianDate.getSecond(), newGregorianDate.getSecond(), Constants.Epsilon11);
    }

    @Test
    public final void canConstructFromDateTime() {
        GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 23, 59, 59.999);
        GregorianDate constructedFromDateTime = new GregorianDate(DateTimeHelper.create(2008, 10, 23, 23, 59, 59, 999));
        AssertHelper.assertEquals(gregorianDate, constructedFromDateTime);
    }

    @Test
    public final void localDateTimesAreConvertedToUTC() {
        ZonedDateTime date = DateTimeHelper.create(2008, 10, 23, 23, 59, 59, 999, ZoneId.systemDefault());
        GregorianDate constructedFromLocalDateTime = new GregorianDate(date);
        GregorianDate constructedFromUTCDateTime = new GregorianDate(DateTimeHelper.toUniversalTime(date));
        AssertHelper.assertEquals(constructedFromLocalDateTime, constructedFromUTCDateTime);
    }

    @Test
    public final void testMinValue() {
        AssertHelper.assertLess(GregorianDate.MinValue, new GregorianDate(2009, 1, 1));
    }

    @Test
    public final void testMaxValue() {
        AssertHelper.assertGreater(GregorianDate.MaxValue, new GregorianDate(2009, 1, 1));
    }

    @Test
    public final void testJulianSecondsOfDay() {
        final double julianSecondsOfDay = 0.05486;
        GregorianDate gregorianDate = new GregorianDate(new JulianDate(2046050, julianSecondsOfDay, TimeStandard.COORDINATED_UNIVERSAL_TIME));
        AssertHelper.assertEquals(julianSecondsOfDay, gregorianDate.getJulianSecondsOfDay(), Constants.Epsilon11);
    }

    @Test
    public final void testYearDayConstructor() {
        ZonedDateTime dateTime = DateTimeHelper.create(2000, 2, 28, 1, 3, 4);
        AssertHelper.assertEquals(31 + 28, dateTime.getDayOfYear());
        // January has 31 days, so add 28 to that...
        GregorianDate gregorianDate = new GregorianDate(dateTime.getYear(), dateTime.getDayOfYear());
        AssertHelper.assertEquals(2000, gregorianDate.getYear());
        AssertHelper.assertEquals(59, gregorianDate.getDayOfYear());
        AssertHelper.assertEquals(2, gregorianDate.getMonth());
        AssertHelper.assertEquals(0, gregorianDate.getHour());
        AssertHelper.assertEquals(0, gregorianDate.getMinute());
        AssertHelper.assertEquals(0, gregorianDate.getSecond());
        gregorianDate = new GregorianDate(2000, 60.6);
        // 60 days and 14.4 hours, or 14 hours and 24 minutes (1/10 of a day is 2.4 hours, times that by 6)
        AssertHelper.assertEquals(2000, gregorianDate.getYear());
        AssertHelper.assertEquals(60, gregorianDate.getDayOfYear());
        AssertHelper.assertEquals(2, gregorianDate.getMonth());
        // leap year
        AssertHelper.assertEquals(14, gregorianDate.getHour());
        AssertHelper.assertEquals(24, gregorianDate.getMinute());
        AssertHelper.assertEquals(0.0, gregorianDate.getSecond(), Constants.Epsilon9);
        // Richard and Michael both said this is ok
    }

    @Test
    public final void testDayOfYear() {
        GregorianDate date = new GregorianDate(2000, 1, 1);
        AssertHelper.assertEquals(1, date.getDayOfYear());
        date = new GregorianDate(2000, 2, 1);
        AssertHelper.assertEquals(32, date.getDayOfYear());
        date = new GregorianDate(2003, 12, 31);
        AssertHelper.assertEquals(365, date.getDayOfYear());
        date = new GregorianDate(2004, 12, 31);
        AssertHelper.assertEquals(366, date.getDayOfYear());
        date = new GregorianDate(2000, 250.0);
        AssertHelper.assertEquals(250, date.getDayOfYear());
        date = new GregorianDate(2000, 250.5);
        AssertHelper.assertEquals(250, date.getDayOfYear());
    }

    @Test
    public final void testSixtySecondsAreValidIfTheInstantRepresentsALeapSecond() {
        Assert.assertTrue(GregorianDate.isValid(2008, 12, 31, 23, 59, 60.0));
        Assert.assertTrue(GregorianDate.isValid(2008, 12, 31, 23, 59, 60.999));
    }

    @Test
    public final void testSixtySecondsAreNotValidIfTheInstantDoesNotRepresentALeapSecond() {
        // 12/30/2008 was not the day of a leap second day.
        Assert.assertFalse(GregorianDate.isValid(2008, 12, 30, 23, 59, 60.0));
        // 23:58 is one minute before a valid leap second.
        Assert.assertFalse(GregorianDate.isValid(2008, 12, 31, 23, 58, 60.0));
    }

    @Test
    public final void canConstructGregorianDateRepresentingLeapSecond() {
        GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60.0);
        AssertHelper.assertEquals(60, date.getSecond());
    }

    @Test
    public final void cannotConstructGregorianDateRepresentingInvalidLeapSecond() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            GregorianDate unused = new GregorianDate(2008, 12, 30, 23, 59, 60.0);
        }));
        AssertHelper.assertStringContains("One or more of the hour, minute, and second arguments is outside of the acceptable range", exception.getMessage());
    }

    /**
    * A simple test of the {@code Now} ({@link GregorianDate#getNow get}) method.
    */
    @Test
    public final void testGregorianDateNow() {
        GregorianDate first = GregorianDate.getNow();
        ThreadHelper.sleep(100);
        GregorianDate second = GregorianDate.getNow();
        AssertHelper.assertGreater(second, first);
    }

    @Test
    public final void testConversionToJulianDate() {
        GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 0.0);
        JulianDate julianDate = date.toJulianDate();
        GregorianDate oneSecondLater = new GregorianDate(2008, 12, 31, 23, 59, 1.0);
        GregorianDate oneSecondBefore = new GregorianDate(2008, 12, 31, 23, 58, 59.0);
        AssertHelper.assertEquals(1, oneSecondLater.toJulianDate().subtract(julianDate).getSeconds());
        AssertHelper.assertEquals(1, julianDate.subtract(oneSecondBefore.toJulianDate()).getSeconds());
    }

    @Test
    public final void canConvertGregorianDateRepresentingLeapSecondToJulianDate() {
        GregorianDate leapSecondGregorianDate = new GregorianDate(2008, 12, 31, 23, 59, 60.0);
        JulianDate leapSecondJulianDate = leapSecondGregorianDate.toJulianDate();
        AssertHelper.assertEquals(leapSecondGregorianDate, leapSecondJulianDate.toGregorianDate());
        GregorianDate oneSecondLater = new GregorianDate(2009, 1, 1, 0, 0, 0.0);
        GregorianDate oneSecondBefore = new GregorianDate(2008, 12, 31, 23, 59, 59.0);
        AssertHelper.assertEquals(1, oneSecondLater.toJulianDate().subtract(leapSecondJulianDate).getSeconds());
        AssertHelper.assertEquals(1, leapSecondJulianDate.subtract(oneSecondBefore.toJulianDate()).getSeconds());
    }

    @Test
    public final void testNonStandardTimeStandard() {
        GregorianDate gregorianDate = new GregorianDate(2008, 12, 31, 23, 59, 40.0);
        JulianDate julianDate = gregorianDate.toJulianDate(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, julianDate.getStandard());
        GregorianDate roundTrip = julianDate.toGregorianDate(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(gregorianDate, roundTrip);
        roundTrip = new GregorianDate(julianDate);
        AssertHelper.assertNotEqual(gregorianDate, roundTrip);
        double expectedDifference = LeapSeconds.getInstance().getTaiMinusUtc(julianDate);
        AssertHelper.assertEquals(expectedDifference, gregorianDate.getSecond() - roundTrip.getSecond());
    }

    @Test
    public final void testRoundTripDefaultConstructed() {
        GregorianDate gregorianDate1 = new GregorianDate();
        GregorianDate gregorianDate2 = new GregorianDate(gregorianDate1.toJulianDate());
        AssertHelper.assertEquals(gregorianDate1, gregorianDate2);
    }

    @Test
    public final void roundSecondsShouldRoundFractionalSeconds() {
        GregorianDate gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.5152535);
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 55.5152535), gregorianDate.roundSeconds(7));
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 55.515254), gregorianDate.roundSeconds(6));
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 55.51525), gregorianDate.roundSeconds(5));
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 55.5153), gregorianDate.roundSeconds(4));
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 55.515), gregorianDate.roundSeconds(3));
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 55.52), gregorianDate.roundSeconds(2));
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 55.5), gregorianDate.roundSeconds(1));
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 59, 56.0), gregorianDate.roundSeconds(0));
    }

    public static final class RoundSecondsTestCase {
        public final double Seconds;
        public final int Digits;

        public RoundSecondsTestCase(int digits, double secondsToRoundTo, int digitsInSeconds) {
            Digits = digits;
            // For example, if digitsInSeconds is four, construct a value
            // for Seconds which is less than secondsToRoundTo and has four 9s: .9999
            Seconds = secondsToRoundTo - Math.pow(10.0, -digitsInSeconds);
        }

        @Override
        public String toString() {
            return StringHelper.format("{0} rounded to {1} digits", Seconds, Digits);
        }

        @CS2JWarning("Unhandled attribute removed: ItemNotNull")
        @Nonnull
        public static Iterable<RoundSecondsTestCase> getTestCases(int minDigitsInSeconds, int maxDigitsInSeconds, double secondsToRoundTo) {
            ArrayList<RoundSecondsTestCase> testCases = new ArrayList<RoundSecondsTestCase>();
            for (int digitsInSeconds = minDigitsInSeconds; digitsInSeconds < maxDigitsInSeconds; ++digitsInSeconds) {
                for (int digits = digitsInSeconds - 1; digits >= minDigitsInSeconds; --digits) {
                    testCases.add(new RoundSecondsTestCase(digits, secondsToRoundTo, digitsInSeconds));
                }
            }
            return testCases;
        }
    }

    @Nonnull
    public static Iterable<RoundSecondsTestCase> getRoundSecondsShouldRollOverValues() {
        return RoundSecondsTestCase.getTestCases(0, 14, 60.0);
    }

    public final void roundSecondsShouldRollOver(@Nonnull RoundSecondsTestCase testCase) {
        GregorianDate gregorianDate = new GregorianDate(2012, 8, 7, 13, 55, testCase.Seconds);
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 13, 56, 0.0), gregorianDate.roundSeconds(testCase.Digits));
        gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, testCase.Seconds);
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 7, 14, 0, 0.0), gregorianDate.roundSeconds(testCase.Digits));
        gregorianDate = new GregorianDate(2012, 8, 7, 23, 59, testCase.Seconds);
        AssertHelper.assertEquals(new GregorianDate(2012, 8, 8, 0, 0, 0.0), gregorianDate.roundSeconds(testCase.Digits));
        gregorianDate = new GregorianDate(2012, 8, 31, 23, 59, testCase.Seconds);
        AssertHelper.assertEquals(new GregorianDate(2012, 9, 1, 0, 0, 0.0), gregorianDate.roundSeconds(testCase.Digits));
        gregorianDate = new GregorianDate(2012, 12, 31, 23, 59, testCase.Seconds);
        AssertHelper.assertEquals(new GregorianDate(2013, 1, 1, 0, 0, 0.0), gregorianDate.roundSeconds(testCase.Digits));
    }

    @Test
    public final void roundSecondsShouldRollOver$TestCase1() {
        for (final RoundSecondsTestCase testCase : getRoundSecondsShouldRollOverValues()) {
            roundSecondsShouldRollOver(testCase);
        }
    }

    public final void roundSecondsShouldRoundToSixtyDuringLeapSecond(@Nonnull RoundSecondsTestCase testCase) {
        GregorianDate gregorianDate = new GregorianDate(2012, 6, 30, 23, 59, testCase.Seconds);
        AssertHelper.assertEquals(new GregorianDate(2012, 6, 30, 23, 59, 60.0), gregorianDate.roundSeconds(testCase.Digits));
    }

    @Test
    public final void roundSecondsShouldRoundToSixtyDuringLeapSecond$TestCase1() {
        for (final RoundSecondsTestCase testCase : getRoundSecondsShouldRollOverValues()) {
            roundSecondsShouldRoundToSixtyDuringLeapSecond(testCase);
        }
    }

    @Nonnull
    public static Iterable<RoundSecondsTestCase> getRoundSecondsShouldRollOverDuringLeapSecondValues() {
        return RoundSecondsTestCase.getTestCases(0, 14, 61.0);
    }

    public final void roundSecondsShouldRollOverDuringLeapSecond(@Nonnull RoundSecondsTestCase testCase) {
        GregorianDate gregorianDate = new GregorianDate(2012, 6, 30, 23, 59, testCase.Seconds);
        AssertHelper.assertEquals(new GregorianDate(2012, 7, 1, 0, 0, 0.0), gregorianDate.roundSeconds(testCase.Digits));
    }

    @Test
    public final void roundSecondsShouldRollOverDuringLeapSecond$TestCase1() {
        for (final RoundSecondsTestCase testCase : getRoundSecondsShouldRollOverDuringLeapSecondValues()) {
            roundSecondsShouldRollOverDuringLeapSecond(testCase);
        }
    }

    @Test
    public final void roundSecondsDoesNotAllow61SecondsDuringLeapSecondIfTimeStandardIsNotUtc() {
        GregorianDate gregorianDate = new GregorianDate(2012, 6, 30, 23, 59, 59.9999999);
        AssertHelper.assertEquals(new GregorianDate(2012, 7, 1, 0, 0, 0.0), gregorianDate.roundSeconds(6, TimeStandard.INTERNATIONAL_ATOMIC_TIME));
    }

    @Test
    public final void maxValueRoundTripsThroughJulianDate() {
        JulianDate max = GregorianDate.MaxValue.toJulianDate();
        GregorianDate date = max.toGregorianDate();
        String iso = date.toIso8601String(Iso8601Format.EXTENDED, 6);
        String expected = GregorianDate.MaxValue.toIso8601String(Iso8601Format.EXTENDED, 6);
        AssertHelper.assertEquals(expected, iso);
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