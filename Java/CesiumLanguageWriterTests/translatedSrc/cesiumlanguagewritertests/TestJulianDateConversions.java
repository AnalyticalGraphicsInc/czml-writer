package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
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
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 *  
 A series of tests to exercise the various date and time types.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJulianDateConversions {
    /**
    *  
    Tests conversion from a {@link JulianDate} to a {@link ZonedDateTime}.
    

    */
    @Test
    public final void julianToDateTime() {
        JulianDate julianDate = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        ZonedDateTime dateTime = julianDate.toDateTime();
        Assert.assertEquals((int) 2000, (int) dateTime.getYear());
        Assert.assertEquals((int) 1, (int) dateTime.getMonthValue());
        Assert.assertEquals((int) 1, (int) dateTime.getDayOfMonth());
        Assert.assertEquals((int) 12, (int) dateTime.getHour());
        Assert.assertEquals((int) 0, (int) dateTime.getMinute());
        Assert.assertEquals((int) 0, (int) dateTime.getSecond());
        Assert.assertEquals((int) 0, (int) DateTimeHelper.getMillisecond(dateTime));
        AssertHelper.assertEquals(ZoneOffset.UTC, dateTime.getZone());
        julianDate = new JulianDate(2453736.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        dateTime = julianDate.toDateTime();
        Assert.assertEquals((int) 2006, (int) dateTime.getYear());
        Assert.assertEquals((int) 1, (int) dateTime.getMonthValue());
        Assert.assertEquals((int) 1, (int) dateTime.getDayOfMonth());
        Assert.assertEquals((int) 0, (int) dateTime.getHour());
        Assert.assertEquals((int) 0, (int) dateTime.getMinute());
        Assert.assertEquals((int) 0, (int) dateTime.getSecond());
        Assert.assertEquals((int) 0, (int) DateTimeHelper.getMillisecond(dateTime));
        AssertHelper.assertEquals(ZoneOffset.UTC, dateTime.getZone());
        julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        dateTime = julianDate.toDateTime();
        Assert.assertEquals((int) 1973, (int) dateTime.getYear());
        Assert.assertEquals((int) 1, (int) dateTime.getMonthValue());
        Assert.assertEquals((int) 1, (int) dateTime.getDayOfMonth());
        Assert.assertEquals((int) 0, (int) dateTime.getHour());
        Assert.assertEquals((int) 0, (int) dateTime.getMinute());
        Assert.assertEquals((int) 0, (int) dateTime.getSecond());
        Assert.assertEquals((int) 0, (int) DateTimeHelper.getMillisecond(dateTime));
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
        Assert.assertEquals((int) 2000, (int) gregorianDate.getYear());
        Assert.assertEquals((int) 1, (int) gregorianDate.getMonth());
        Assert.assertEquals((int) 1, (int) gregorianDate.getDay());
        Assert.assertEquals((int) 12, (int) gregorianDate.getHour());
        Assert.assertEquals((int) 0, (int) gregorianDate.getMinute());
        Assert.assertEquals(0, gregorianDate.getSecond(), 0d);
        julianDate = new JulianDate(2453736.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        gregorianDate = julianDate.toGregorianDate();
        Assert.assertEquals((int) 2006, (int) gregorianDate.getYear());
        Assert.assertEquals((int) 1, (int) gregorianDate.getMonth());
        Assert.assertEquals((int) 1, (int) gregorianDate.getDay());
        Assert.assertEquals((int) 0, (int) gregorianDate.getHour());
        Assert.assertEquals((int) 0, (int) gregorianDate.getMinute());
        Assert.assertEquals(0, gregorianDate.getSecond(), 0d);
        julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        gregorianDate = julianDate.toGregorianDate();
        Assert.assertEquals((int) 1973, (int) gregorianDate.getYear());
        Assert.assertEquals((int) 1, (int) gregorianDate.getMonth());
        Assert.assertEquals((int) 1, (int) gregorianDate.getDay());
        Assert.assertEquals((int) 0, (int) gregorianDate.getHour());
        Assert.assertEquals((int) 0, (int) gregorianDate.getMinute());
        Assert.assertEquals(0, gregorianDate.getSecond(), 0d);
        julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        GregorianDate internationalTimeGregorianDate = julianDate.toGregorianDate(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertNotEqual(gregorianDate, internationalTimeGregorianDate);
    }

    /**
    *  
    Tests that an appropriate exception is thrown when attempting to construct a DateTime
    from a JulianDate prior to the earliest possible DateTime.
    

    */
    @Test
    public final void testJulianDateMinimumToDateTime() {
        final JulianDate date = JulianDate.getMinValue();
        AssertHelper.<ArgumentOutOfRangeException> assertThrows(new TypeLiteral<ArgumentOutOfRangeException>() {}, new Action() {
            public void invoke() {
                ZonedDateTime unused = date.toDateTime();
            }
        });
    }

    /**
    *  
    Tests conversion from a {@link ZonedDateTime} to a {@link JulianDate}.
    

    */
    @Test
    public final void dateTimeToJulian() {
        ZonedDateTime dateTime = DateTimeHelper.create(2000, 1, 1, 12, 0, 0);
        JulianDate julianDate = new JulianDate(dateTime);
        Assert.assertEquals(2451545.0, julianDate.getTotalDays(), 0d);
        dateTime = DateTimeHelper.create(2006, 1, 1, 0, 0, 0);
        julianDate = new JulianDate(dateTime);
        Assert.assertEquals(2453736.5, julianDate.getTotalDays(), 0d);
        dateTime = DateTimeHelper.create(1973, 1, 1, 0, 0, 0);
        julianDate = new JulianDate(dateTime);
        Assert.assertEquals(2441683.5, julianDate.getTotalDays(), 0d);
        ZonedDateTime localDateTime = DateTimeHelper.create(2000, 1, 1, 12, 0, 0, ZoneId.systemDefault());
        ZonedDateTime utc = DateTimeHelper.toUniversalTime(localDateTime);
        julianDate = new JulianDate(localDateTime);
        dateTime = julianDate.toDateTime();
        AssertHelper.assertEquals(utc, dateTime);
    }

    @Test
    public final void gregorianDateToJulian() {
        GregorianDate gregorianDate = new GregorianDate(2000, 1, 1, 12, 0, 0D);
        JulianDate julianDate = new JulianDate(gregorianDate);
        Assert.assertEquals(2451545.0, julianDate.getTotalDays(), 0d);
        gregorianDate = new GregorianDate(2006, 1, 1, 0, 0, 0D);
        julianDate = new JulianDate(gregorianDate);
        Assert.assertEquals(2453736.5, julianDate.getTotalDays(), 0d);
        gregorianDate = new GregorianDate(1973, 1, 1, 0, 0, 0D);
        julianDate = new JulianDate(gregorianDate);
        Assert.assertEquals(2441683.5, julianDate.getTotalDays(), 0d);
        ZonedDateTime localDateTime = DateTimeHelper.create(2000, 1, 1, 12, 0, 0, ZoneId.systemDefault());
        ZonedDateTime utc = DateTimeHelper.toUniversalTime(localDateTime);
        julianDate = new JulianDate(localDateTime);
        gregorianDate = julianDate.toGregorianDate();
        AssertHelper.assertEquals(new GregorianDate(utc), gregorianDate);
    }

    /**
    *  
    Tests conversion of a {@link ZonedDateTime} to a {@link JulianDate} when
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
    *  
    Tests the "round-trip" conversion between a {@link ZonedDateTime} and a {@link JulianDate}.
    

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
            Assert.assertEquals((int) dateTime.getYear(), (int) roundTrip.getYear());
            Assert.assertEquals((int) dateTime.getMonthValue(), (int) roundTrip.getMonthValue());
            Assert.assertEquals((int) dateTime.getDayOfMonth(), (int) roundTrip.getDayOfMonth());
            Assert.assertEquals((int) dateTime.getHour(), (int) roundTrip.getHour());
            Assert.assertEquals((int) dateTime.getMinute(), (int) roundTrip.getMinute());
            Assert.assertEquals((int) dateTime.getSecond(), (int) roundTrip.getSecond());
            Assert.assertEquals((int) DateTimeHelper.getMillisecond(dateTime), (int) DateTimeHelper.getMillisecond(roundTrip));
        }
    }

    @Test
    public final void julianDateGregorianDateRoundTrip() {
        GregorianDate gregorianDate = new GregorianDate(2008, 1, 1, 1, 1, 1.00000000008);
        JulianDate julianDate = new JulianDate(gregorianDate);
        GregorianDate roundTrip = julianDate.toGregorianDate();
        Assert.assertEquals((int) gregorianDate.getYear(), (int) roundTrip.getYear());
        Assert.assertEquals((int) gregorianDate.getMonth(), (int) roundTrip.getMonth());
        Assert.assertEquals((int) gregorianDate.getDay(), (int) roundTrip.getDay());
        Assert.assertEquals((int) gregorianDate.getHour(), (int) roundTrip.getHour());
        Assert.assertEquals((int) gregorianDate.getMinute(), (int) roundTrip.getMinute());
        Assert.assertEquals(gregorianDate.getSecond(), roundTrip.getSecond(), Constants.Epsilon13);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}