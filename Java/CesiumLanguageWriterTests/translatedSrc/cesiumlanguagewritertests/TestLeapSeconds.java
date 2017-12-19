package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.ExpectedExceptionHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 *  
 A series of tests to exercise this type.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeapSeconds {
    /**
    *  
    Tests that epochs outside the leap second table range are supported.
    

    */
    @Test
    public final void testExtremes() {
        LeapSeconds leapSeconds = new LeapSeconds();
        JulianDate epochBefore = new JulianDate(2440000.5, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        Assert.assertEquals(10, leapSeconds.getTaiMinusUtc(epochBefore), 0d);
        epochBefore = new JulianDate(epochBefore.getDay(), epochBefore.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        Assert.assertEquals(10, leapSeconds.getTaiMinusUtc(epochBefore), 0d);
        JulianDate epochAfter = new JulianDate(2453770.5, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        Assert.assertEquals(33, leapSeconds.getTaiMinusUtc(epochAfter), 0d);
        epochAfter = new JulianDate(epochAfter.getDay(), epochAfter.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        Assert.assertEquals(33, leapSeconds.getTaiMinusUtc(epochAfter), 0d);
    }

    /**
    *  
    Tests that the look-up operation produces the same result using either the
    {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} standard or the {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} standard.
    

    */
    @Test
    public final void testGetLeapSecondsForDateTaiUtc() {
        LeapSeconds leapSeconds = new LeapSeconds();
        JulianDate tai = new JulianDate(2447162.5, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate utc = tai.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        Assert.assertEquals(leapSeconds.getTaiMinusUtc(tai), leapSeconds.getTaiMinusUtc(utc), 0d);
        utc = new JulianDate(2445151.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        tai = utc.toTimeStandard(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        Assert.assertEquals(leapSeconds.getTaiMinusUtc(utc), leapSeconds.getTaiMinusUtc(tai), 0d);
    }

    /**
    *  
    Tests the method which reports whether the indicated Julian Day Number is a day
    which contains a leap second.
    

    */
    @Test
    public final void testDoesDayHaveLeapSecond() {
        LeapSeconds leapSeconds = new LeapSeconds();
        Assert.assertTrue(leapSeconds.doesDayHaveLeapSecond(2443509));
        Assert.assertFalse(leapSeconds.doesDayHaveLeapSecond(2443510));
    }

    /**
    *  
    Tests that the look-up operation produces the correct result for times within the range
    of the table.
    

    */
    @Test
    public final void testLeapSecondCount() {
        LeapSeconds leapSeconds = new LeapSeconds();
        JulianDate utc = new JulianDate(new GregorianDate(1998, 4, 1, 12, 0, 0D));
        JulianDate tai = utc.toTimeStandard(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        Assert.assertEquals(31, leapSeconds.getTaiMinusUtc(utc), 0d);
        Assert.assertEquals(31, leapSeconds.getTaiMinusUtc(tai), 0d);
    }

    /**
    *  
    Tests that negative leap seconds are supported.
    

    */
    @Test
    public final void testNegativeLeapSecond() {
        ArrayList<cesiumlanguagewriter.LeapSecond> newList = new ArrayList<cesiumlanguagewriter.LeapSecond>();
        newList.add(new LeapSecond(2451545.0, 11D));
        newList.add(new LeapSecond(2451555.0, 12D));
        newList.add(new LeapSecond(2451565.0, 11D));
        newList.add(new LeapSecond(2451575.0, 10D));
        LeapSeconds leapSeconds = new LeapSeconds(newList);
        Assert.assertEquals(11, leapSeconds.getTaiMinusUtc(new JulianDate(2451545.5, TimeStandard.COORDINATED_UNIVERSAL_TIME)), 0d);
        Assert.assertEquals(12, leapSeconds.getTaiMinusUtc(new JulianDate(2451555.5, TimeStandard.COORDINATED_UNIVERSAL_TIME)), 0d);
        Assert.assertEquals(11, leapSeconds.getTaiMinusUtc(new JulianDate(2451565.5, TimeStandard.COORDINATED_UNIVERSAL_TIME)), 0d);
        Assert.assertEquals(10, leapSeconds.getTaiMinusUtc(new JulianDate(2451575.5, TimeStandard.COORDINATED_UNIVERSAL_TIME)), 0d);
    }

    /**
    *  
    Tests that the look-up operation produces the correct result when using the
    {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} standard.
    

    */
    @Test
    public final void testGetOffsetTai() {
        JulianDate date = new JulianDate(2453736, 43222.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        LeapSeconds leapSeconds = new LeapSeconds();
        Assert.assertEquals(32, leapSeconds.getTaiMinusUtc(date), 0d);
    }

    /**
    *  
    Tests that a {@link JulianDate} in the 
    {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} standard cannot correctly
    represent a day containing a leap second.
    

    */
    @Test
    public final void testJulianDateCannotRepresentMomentOfLeapSecond() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentOutOfRangeException.class);
        JulianDate momentOfLeapSecond = new JulianDate(2453736, 43232.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        momentOfLeapSecond.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
    }

    /**
    *  
    Converts two Julian dates in TAI to UTC: one just before a leap second, and one
    after a leap second.  Verifies that they convert to different UTC Julian dates.
    

    */
    @Test
    public final void testTaiToUtcNearLeapSecond() {
        LeapSeconds leapSeconds = new LeapSeconds();
        LeapSeconds.setInstance(leapSeconds);
        JulianDate momentOfLeapSecond = new JulianDate(2453736, 43232.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate before = JulianDate.subtract(momentOfLeapSecond, Duration.fromSeconds(1.0));
        JulianDate after = JulianDate.add(momentOfLeapSecond, Duration.fromSeconds(1.0));
        JulianDate beforeUtc = before.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        JulianDate afterUtc = after.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertNotEqual(beforeUtc, afterUtc);
    }

    /**
    *  
    Tests that adding small values to a UTC Julian date does not result in getting
    stuck when crossing a leap second.
    

    */
    @Test
    public final void testUtcAddNotStuckAtLeapSecond() {
        LeapSeconds leapSeconds = new LeapSeconds();
        LeapSeconds.setInstance(leapSeconds);
        JulianDate date = new JulianDate(2453736, 43198.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        JulianDate after = new JulianDate(2453736, 43202.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        int i;
        for (i = 0; i < 100; ++i) {
            date = JulianDate.add(date, Duration.fromSeconds(0.1));
            if (JulianDate.greaterThan(date, after)) {
                break;
            }
        }
        //5 second difference, so 50 additions of a tenth of a second each
        Assert.assertEquals((int) 50, (int) i);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }

    @Nonnull
    private final ExpectedException rule$expectedException = ExpectedException.none();

    @Nonnull
    @Rule
    public ExpectedException getRule$expectedException() {
        return rule$expectedException;
    }
}