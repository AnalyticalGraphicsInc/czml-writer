package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 * A series of tests to exercise the various date and time types.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJulianDateConversions {
    /**
    * Tests conversion from a {@link JulianDate} to a {@link ZonedDateTime}.
    */
    @Test
    public final void julianToDateTime() {
        JulianDate julianDate = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        ZonedDateTime dateTime = julianDate.toDateTime();
        AssertHelper.assertEquals(2000, dateTime.getYear());
        AssertHelper.assertEquals(1, dateTime.getMonthValue());
        AssertHelper.assertEquals(1, dateTime.getDayOfMonth());
        AssertHelper.assertEquals(12, dateTime.getHour());
        AssertHelper.assertEquals(0, dateTime.getMinute());
        AssertHelper.assertEquals(0, dateTime.getSecond());
        AssertHelper.assertEquals(0, DateTimeHelper.getMillisecond(dateTime));
        AssertHelper.assertEquals(ZoneOffset.UTC, dateTime.getZone());
        julianDate = new JulianDate(2453736.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        dateTime = julianDate.toDateTime();
        AssertHelper.assertEquals(2006, dateTime.getYear());
        AssertHelper.assertEquals(1, dateTime.getMonthValue());
        AssertHelper.assertEquals(1, dateTime.getDayOfMonth());
        AssertHelper.assertEquals(0, dateTime.getHour());
        AssertHelper.assertEquals(0, dateTime.getMinute());
        AssertHelper.assertEquals(0, dateTime.getSecond());
        AssertHelper.assertEquals(0, DateTimeHelper.getMillisecond(dateTime));
        AssertHelper.assertEquals(ZoneOffset.UTC, dateTime.getZone());
        julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        dateTime = julianDate.toDateTime();
        AssertHelper.assertEquals(1973, dateTime.getYear());
        AssertHelper.assertEquals(1, dateTime.getMonthValue());
        AssertHelper.assertEquals(1, dateTime.getDayOfMonth());
        AssertHelper.assertEquals(0, dateTime.getHour());
        AssertHelper.assertEquals(0, dateTime.getMinute());
        AssertHelper.assertEquals(0, dateTime.getSecond());
        AssertHelper.assertEquals(0, DateTimeHelper.getMillisecond(dateTime));
        AssertHelper.assertEquals(ZoneOffset.UTC, dateTime.getZone());
        julianDate = new JulianDate(2441683.5, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        dateTime = julianDate.toDateTime(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(ZoneOffset.UTC, dateTime.getZone());
        julianDate = new JulianDate(2441683.5, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        dateTime = julianDate.toDateTime(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(ZoneOffset.UTC, dateTime.getZone());
    }

    @Test
    public final void julianToGregorianDate() {
        JulianDate julianDate = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        GregorianDate gregorianDate = julianDate.toGregorianDate();
        AssertHelper.assertEquals(2000, gregorianDate.getYear());
        AssertHelper.assertEquals(1, gregorianDate.getMonth());
        AssertHelper.assertEquals(1, gregorianDate.getDay());
        AssertHelper.assertEquals(12, gregorianDate.getHour());
        AssertHelper.assertEquals(0, gregorianDate.getMinute());
        AssertHelper.assertEquals(0, gregorianDate.getSecond());
        julianDate = new JulianDate(2453736.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        gregorianDate = julianDate.toGregorianDate();
        AssertHelper.assertEquals(2006, gregorianDate.getYear());
        AssertHelper.assertEquals(1, gregorianDate.getMonth());
        AssertHelper.assertEquals(1, gregorianDate.getDay());
        AssertHelper.assertEquals(0, gregorianDate.getHour());
        AssertHelper.assertEquals(0, gregorianDate.getMinute());
        AssertHelper.assertEquals(0, gregorianDate.getSecond());
        julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        gregorianDate = julianDate.toGregorianDate();
        AssertHelper.assertEquals(1973, gregorianDate.getYear());
        AssertHelper.assertEquals(1, gregorianDate.getMonth());
        AssertHelper.assertEquals(1, gregorianDate.getDay());
        AssertHelper.assertEquals(0, gregorianDate.getHour());
        AssertHelper.assertEquals(0, gregorianDate.getMinute());
        AssertHelper.assertEquals(0, gregorianDate.getSecond());
        julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        GregorianDate internationalTimeGregorianDate = julianDate.toGregorianDate(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertNotEqual(gregorianDate, internationalTimeGregorianDate);
    }

    /**
    * Tests that an appropriate exception is thrown when attempting to construct a DateTime
    from a JulianDate prior to the earliest possible DateTime.
    */
    @Test
    public final void testJulianDateMinimumToDateTime() {
        final JulianDate date = JulianDate.getMinValue();
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            ZonedDateTime unused = date.toDateTime();
        }));
    }

    /**
    * Tests conversion from a {@link ZonedDateTime} to a {@link JulianDate}.
    */
    @Test
    public final void dateTimeToJulian() {
        ZonedDateTime dateTime = DateTimeHelper.create(2000, 1, 1, 12, 0, 0);
        JulianDate julianDate = new JulianDate(dateTime);
        AssertHelper.assertEquals(2451545.0, julianDate.getTotalDays());
        dateTime = DateTimeHelper.create(2006, 1, 1, 0, 0, 0);
        julianDate = new JulianDate(dateTime);
        AssertHelper.assertEquals(2453736.5, julianDate.getTotalDays());
        dateTime = DateTimeHelper.create(1973, 1, 1, 0, 0, 0);
        julianDate = new JulianDate(dateTime);
        AssertHelper.assertEquals(2441683.5, julianDate.getTotalDays());
        ZonedDateTime localDateTime = DateTimeHelper.create(2000, 1, 1, 12, 0, 0, ZoneId.systemDefault());
        ZonedDateTime utc = DateTimeHelper.toUniversalTime(localDateTime);
        julianDate = new JulianDate(localDateTime);
        dateTime = julianDate.toDateTime();
        AssertHelper.assertEquals(utc, dateTime);
    }

    @Test
    public final void gregorianDateToJulian() {
        GregorianDate gregorianDate = new GregorianDate(2000, 1, 1, 12, 0, 0.0);
        JulianDate julianDate = new JulianDate(gregorianDate);
        AssertHelper.assertEquals(2451545.0, julianDate.getTotalDays());
        gregorianDate = new GregorianDate(2006, 1, 1, 0, 0, 0.0);
        julianDate = new JulianDate(gregorianDate);
        AssertHelper.assertEquals(2453736.5, julianDate.getTotalDays());
        gregorianDate = new GregorianDate(1973, 1, 1, 0, 0, 0.0);
        julianDate = new JulianDate(gregorianDate);
        AssertHelper.assertEquals(2441683.5, julianDate.getTotalDays());
        ZonedDateTime localDateTime = DateTimeHelper.create(2000, 1, 1, 12, 0, 0, ZoneId.systemDefault());
        ZonedDateTime utc = DateTimeHelper.toUniversalTime(localDateTime);
        julianDate = new JulianDate(localDateTime);
        gregorianDate = julianDate.toGregorianDate();
        AssertHelper.assertEquals(new GregorianDate(utc), gregorianDate);
    }

    /**
    * Tests conversion of a {@link ZonedDateTime} to a {@link JulianDate} when
    the {@link ZonedDateTime} is specified as a local time instead of as UTC.
    */
    @Test
    public final void testLocalDateTimeToJulian() {
        ZonedDateTime localNow = DateTimeHelper.now();
        ZonedDateTime utcNow = DateTimeHelper.toUniversalTime(localNow);
        JulianDate localJulianDate = new JulianDate(localNow);
        JulianDate utcJulianDate = new JulianDate(utcNow);
        Assert.assertTrue(localJulianDate.equalsEpsilon(utcJulianDate, Constants.Epsilon14));
        localNow = DateTimeHelper.now();
        utcNow = DateTimeHelper.toUniversalTime(localNow);
        localJulianDate = new JulianDate(localNow, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        utcJulianDate = new JulianDate(utcNow, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        Assert.assertTrue(localJulianDate.equalsEpsilon(utcJulianDate, Constants.Epsilon14));
    }

    /**
    * Tests the "round-trip" conversion between a {@link ZonedDateTime} and a {@link JulianDate}.
    */
    @Test
    public final void julianDateTimeRoundTrip() {
        final ArrayList<ZonedDateTime> tempCollection$0 = new ArrayList<ZonedDateTime>();
        tempCollection$0.add(DateTimeHelper.utcNow());
        tempCollection$0.add(DateTimeHelper.create(2017, 8, 31, 13, 53, 32, 44, ZoneOffset.UTC));
        ArrayList<ZonedDateTime> dateTimes = tempCollection$0;
        // add a test date with all possible millisecond values
        for (int millisecond = 0; millisecond < 999; millisecond++) {
            dateTimes.add(DateTimeHelper.create(2017, 8, 31, 13, 53, 32, millisecond, ZoneOffset.UTC));
        }
        for (final ZonedDateTime dateTime : dateTimes) {
            JulianDate julianDate = new JulianDate(dateTime);
            ZonedDateTime roundTrip = julianDate.toDateTime();
            AssertHelper.assertEquals(dateTime.getYear(), roundTrip.getYear());
            AssertHelper.assertEquals(dateTime.getMonthValue(), roundTrip.getMonthValue());
            AssertHelper.assertEquals(dateTime.getDayOfMonth(), roundTrip.getDayOfMonth());
            AssertHelper.assertEquals(dateTime.getHour(), roundTrip.getHour());
            AssertHelper.assertEquals(dateTime.getMinute(), roundTrip.getMinute());
            AssertHelper.assertEquals(dateTime.getSecond(), roundTrip.getSecond());
            AssertHelper.assertEquals(DateTimeHelper.getMillisecond(dateTime), DateTimeHelper.getMillisecond(roundTrip));
        }
    }

    @Test
    public final void julianDateGregorianDateRoundTrip() {
        GregorianDate gregorianDate = new GregorianDate(2008, 1, 1, 1, 1, 1.00000000008);
        JulianDate julianDate = new JulianDate(gregorianDate);
        GregorianDate roundTrip = julianDate.toGregorianDate();
        AssertHelper.assertEquals(gregorianDate.getYear(), roundTrip.getYear());
        AssertHelper.assertEquals(gregorianDate.getMonth(), roundTrip.getMonth());
        AssertHelper.assertEquals(gregorianDate.getDay(), roundTrip.getDay());
        AssertHelper.assertEquals(gregorianDate.getHour(), roundTrip.getHour());
        AssertHelper.assertEquals(gregorianDate.getMinute(), roundTrip.getMinute());
        AssertHelper.assertEquals(gregorianDate.getSecond(), roundTrip.getSecond(), Constants.Epsilon13);
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