package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.ThreadHelper;
import cesiumlanguagewriter.*;
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
public class TestJulianDate {
    /**
    * Tests that initialization of and access to the structure day and time
    elements is performed correctly.
    */
    @Test
    public final void testRetainValue() {
        JulianDate date = new JulianDate(100, 123.456789012);
        AssertHelper.assertEquals(100, date.getDay());
        AssertHelper.assertEquals(123.456789012, date.getSecondsOfDay());
    }

    /**
    * Tests that initialization of and access to the structure time standard
    element is performed correctly.  Also tests that the default time standard
    is {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME}.
    */
    @Test
    public final void testTimeStandard() {
        JulianDate date = new JulianDate(0.0);
        AssertHelper.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, date.getStandard());
        date = new JulianDate(100, 123.456789012);
        AssertHelper.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, date.getStandard());
        date = new JulianDate(100, 123.456789012, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(TimeStandard.COORDINATED_UNIVERSAL_TIME, date.getStandard());
    }

    /**
    * Tests that initialization produces a {@link JulianDate} which is
    normalized with the time element in the range 0.0 &lt;= seconds &lt; 86400.0.
    */
    @Test
    public final void testTimeGreaterThanADay() {
        JulianDate date = new JulianDate(2451545, 107000.0);
        AssertHelper.assertEquals(2451546, date.getDay());
        AssertHelper.assertEquals(20600.0, date.getSecondsOfDay());
        date = new JulianDate(2451545, 107000.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(2451546, date.getDay());
        AssertHelper.assertEquals(20600.0, date.getSecondsOfDay());
    }

    /**
    * Tests that initialization produces a {@link JulianDate} which is
    normalized with the time element in the range 0.0 &lt;= seconds &lt; 86400.0.
    */
    @Test
    public final void testTimeNegative() {
        JulianDate date = new JulianDate(2451545, -45000.0);
        AssertHelper.assertEquals(2451544, date.getDay());
        AssertHelper.assertEquals(41400.0, date.getSecondsOfDay());
        date = new JulianDate(2451545, -45000.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(2451544, date.getDay());
        AssertHelper.assertEquals(41400.0, date.getSecondsOfDay());
    }

    /**
    * Tests that initialization produces a {@link JulianDate} which is
    normalized with the time element in the range 0.0 &lt;= seconds &lt; 86400.0.
    */
    @Test
    public final void testTimeExactlyOneDay() {
        JulianDate date = new JulianDate(2451545, TimeConstants.SecondsPerDay);
        AssertHelper.assertEquals(2451546, date.getDay());
        AssertHelper.assertEquals(0.0, date.getSecondsOfDay());
        date = new JulianDate(2451545, TimeConstants.SecondsPerDay, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(2451546, date.getDay());
        AssertHelper.assertEquals(0.0, date.getSecondsOfDay());
    }

    /**
    * Tests the check for EXACT equality and the check for equality within a specified tolerance.
    */
    @Test
    public final void testEquality() {
        JulianDate first = new JulianDate(2451545, 0.2);
        JulianDate second = new JulianDate(2451545, 0.2);
        AssertHelper.assertEquals(first, second);
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        AssertHelper.assertEquals(0, first.compareTo(second));
        AssertHelper.assertEquals(0, second.compareTo(first));
        AssertHelper.assertNotEqual(first, 5);
        first = new JulianDate(2451545, 0.00001);
        second = new JulianDate(2451544, 86399.99999);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        Assert.assertTrue(first.equalsEpsilon(second, 1e-4));
        Assert.assertTrue(second.equalsEpsilon(first, 1e-4));
    }

    /**
    * A simple test of the {@code Now} ({@link JulianDate#getNow get}) method.
    */
    @Test
    public final void testJulianDateNow() {
        JulianDate first = JulianDate.getNow();
        ThreadHelper.sleep(100);
        JulianDate second = JulianDate.getNow();
        AssertHelper.assertGreater(second, first);
    }

    /**
    * Tests that the {@link JulianDate#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        JulianDate first = new JulianDate(2451545, 0.2);
        JulianDate second = new JulianDate(2451545, 0.2);
        Assert.assertTrue(second.equalsEpsilon(first, 0.0));
    }

    /**
    * Tests the addition operation between a {@link Duration} with unspecified time standard
    and a {@link JulianDate}.
    */
    @Test
    public final void testAddition() {
        JulianDate original = new JulianDate(2460000, 1000.0);
        Duration toAdd = Duration.fromSeconds(50.0);
        JulianDate added = original.add(toAdd);
        AssertHelper.assertEquals(2460000, added.getDay());
        AssertHelper.assertEquals(1050.0, added.getSecondsOfDay());
        JulianDate subtracted = original.subtract(toAdd);
        AssertHelper.assertEquals(2460000, subtracted.getDay());
        AssertHelper.assertEquals(950.0, subtracted.getSecondsOfDay());
        original = new JulianDate(2460000, 8382.1);
        toAdd = new Duration(1, 10.0);
        added = JulianDate.add(original, toAdd);
        AssertHelper.assertEquals(2460001, added.getDay());
        AssertHelper.assertEquals(8392.1, added.getSecondsOfDay());
        subtracted = JulianDate.subtract(original, toAdd);
        AssertHelper.assertEquals(2459999, subtracted.getDay());
        AssertHelper.assertEquals(8372.1, subtracted.getSecondsOfDay());
        original = new JulianDate(2460000, 86000.0);
        toAdd = Duration.fromSeconds(1000.0);
        added = original.add(toAdd);
        AssertHelper.assertEquals(2460001, added.getDay());
        AssertHelper.assertEquals(600.0, added.getSecondsOfDay());
        subtracted = original.subtract(toAdd);
        AssertHelper.assertEquals(2460000, subtracted.getDay());
        AssertHelper.assertEquals(85000.0, subtracted.getSecondsOfDay());
    }

    /**
    * Tests the function that determines the number of seconds between two Julian Dates
    */
    @Test
    public final void testSecondsDifference() {
        // Test same standard - both safe
        JulianDate first = new JulianDate(2451545.0);
        JulianDate second = JulianDate.add(first, Duration.fromSeconds(120000.0));
        AssertHelper.assertEquals(120000, first.secondsDifference(second));
        AssertHelper.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds(), first.secondsDifference(second));
        //Test same standard - both unsafe
        first = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        second = JulianDate.add(first, Duration.fromSeconds(120000.0));
        second = new JulianDate(second.getDay(), second.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(120000, first.secondsDifference(second));
        AssertHelper.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds(), first.secondsDifference(second));
        // Test diff standard - one unsafe, one safe
        first = new JulianDate(2451545.0);
        second = JulianDate.add(first, Duration.fromSeconds(120000.0));
        JulianDate secondDiffStandard = second.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(120000, first.secondsDifference(secondDiffStandard));
        AssertHelper.assertEquals((JulianDate.subtract(secondDiffStandard, first)).getTotalSeconds(), first.secondsDifference(secondDiffStandard));
        first = JulianDate.getMinValue();
        second = JulianDate.getMaxValue();
        AssertHelper.assertEquals(((long) Integer.MAX_VALUE - Integer.MIN_VALUE) * TimeConstants.SecondsPerDay, first.secondsDifference(second));
    }

    /**
    * Tests the function that determines the number of seconds between two Julian Dates
    */
    @Test
    public final void testMinutesDifference() {
        final double totalElapsedTime = TimeConstants.SecondsPerDay * 2.5;
        final double totalElapsedTimeMinutes = totalElapsedTime / TimeConstants.SecondsPerMinute;
        //Test same time standard, both safe
        JulianDate first = new JulianDate(2451545.0);
        JulianDate second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
        AssertHelper.assertEquals(totalElapsedTimeMinutes, first.minutesDifference(second));
        AssertHelper.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds() / TimeConstants.SecondsPerMinute, first.minutesDifference(second));
        //Test same time standard, both unsafe
        first = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
        second = new JulianDate(second.getDay(), second.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(totalElapsedTimeMinutes, first.minutesDifference(second));
        AssertHelper.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds() / TimeConstants.SecondsPerMinute, first.minutesDifference(second));
        //Test diff time standard, one safe, one unsafe
        first = new JulianDate(2451545.0);
        second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
        JulianDate secondDiffStandard = second.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(totalElapsedTimeMinutes, first.minutesDifference(secondDiffStandard));
        AssertHelper.assertEquals((JulianDate.subtract(secondDiffStandard, first)).getTotalSeconds() / TimeConstants.SecondsPerMinute, first.minutesDifference(secondDiffStandard));
        first = JulianDate.getMinValue();
        second = JulianDate.getMaxValue();
        AssertHelper.assertEquals(((long) Integer.MAX_VALUE - Integer.MIN_VALUE) * TimeConstants.MinutesPerDay, first.minutesDifference(second));
    }

    @Test
    public final void testDaysDifference() {
        final double totalElapsedTime = TimeConstants.SecondsPerDay * 2.5;
        final double totalElapsedTimeDays = totalElapsedTime / TimeConstants.SecondsPerDay;
        //Test same time standard, both safe
        JulianDate first = new JulianDate(2451545.0);
        JulianDate second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
        AssertHelper.assertEquals(totalElapsedTimeDays, first.daysDifference(second));
        AssertHelper.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds() / TimeConstants.SecondsPerDay, first.daysDifference(second));
        //Test same time standard, both unsafe
        first = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
        second = new JulianDate(second.getDay(), second.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(totalElapsedTimeDays, first.daysDifference(second));
        AssertHelper.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds() / TimeConstants.SecondsPerDay, first.daysDifference(second));
        //Test diff time standard, one safe, one unsafe
        first = new JulianDate(2451545.0);
        second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
        JulianDate secondDiffStandard = second.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(totalElapsedTimeDays, first.daysDifference(secondDiffStandard));
        AssertHelper.assertEquals((JulianDate.subtract(secondDiffStandard, first)).getTotalSeconds() / TimeConstants.SecondsPerDay, first.daysDifference(secondDiffStandard));
        first = JulianDate.getMinValue();
        second = JulianDate.getMaxValue();
        AssertHelper.assertEquals((long) Integer.MAX_VALUE - Integer.MIN_VALUE, first.daysDifference(second));
    }

    /**
    * Tests the subtraction operation between Julian dates.
    */
    @Test
    public final void testSubtraction() {
        JulianDate first = new JulianDate(2469477, 1000.0);
        JulianDate second = new JulianDate(2469477, 2000.0);
        Duration difference = JulianDate.subtract(second, first);
        AssertHelper.assertEquals(1000.0, difference.getTotalSeconds());
        difference = JulianDate.subtract(first, second);
        AssertHelper.assertEquals(-1000.0, difference.getTotalSeconds());
        first = new JulianDate(2469477, 1000.0);
        second = new JulianDate(2469478, 2000.0);
        difference = JulianDate.subtract(second, first);
        AssertHelper.assertEquals(1, difference.getDays());
        AssertHelper.assertEquals(1000.0, difference.getSeconds());
        difference = JulianDate.subtract(first, second);
        AssertHelper.assertEquals(-1, difference.getDays());
        AssertHelper.assertEquals(-1000.0, difference.getSeconds());
        first = new JulianDate(2469477, 86000.0);
        second = new JulianDate(2469478, 100.0);
        difference = JulianDate.subtract(second, first);
        AssertHelper.assertEquals(0, difference.getDays());
        AssertHelper.assertEquals(500.0, difference.getSeconds());
        difference = JulianDate.subtract(first, second);
        AssertHelper.assertEquals(0, difference.getDays());
        AssertHelper.assertEquals(-500.0, difference.getSeconds());
    }

    /**
    * Tests the {@link JulianDate#addSeconds} method.
    */
    @Test
    public final void testAddSeconds() {
        // Make sure AddSeconds produces the correct answer in the correct time standard.
        JulianDate test = new JulianDate(2451912, 43200.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate result = test.addSeconds(45.123);
        AssertHelper.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, result.getStandard());
        AssertHelper.assertEquals(2451912, result.getDay());
        AssertHelper.assertEquals(43245.123, result.getSecondsOfDay());
    }

    /**
    * Tests the {@link JulianDate#subtractSeconds} method.
    */
    @Test
    public final void testSubtractSeconds() {
        // Make sure SubtractSeconds produces the correct answer in the correct time standard.
        JulianDate test = new JulianDate(2451912, 0.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate result = test.subtractSeconds(43200.25);
        AssertHelper.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, result.getStandard());
        AssertHelper.assertEquals(2451911, result.getDay());
        AssertHelper.assertEquals(43199.75, result.getSecondsOfDay());
    }

    /**
    * Tests the {@link JulianDate#addDays} method.
    */
    @Test
    public final void testAddDays() {
        // Make sure AddDays produces the correct answer in the correct time standard.
        JulianDate test = new JulianDate(2451912, 43200.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate result = test.addDays(45.5);
        AssertHelper.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, result.getStandard());
        AssertHelper.assertEquals(2451958, result.getDay());
        AssertHelper.assertEquals(0.0, result.getSecondsOfDay());
    }

    /**
    * Tests that JulianDate.GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        JulianDate date1 = new JulianDate(2451545, 0.0);
        JulianDate date2 = new JulianDate(2451545, 1.0);
        JulianDate date3 = new JulianDate(2451545, 0.0);
        AssertHelper.assertNotEqual(date1.hashCode(), date2.hashCode());
        AssertHelper.assertEquals(date1.hashCode(), date3.hashCode());
        date1 = new JulianDate(2451545, 0.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        date2 = new JulianDate(2451545, 0.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertNotEqual(date1.hashCode(), date2.hashCode());
    }

    /**
    * Tests the JulianDate override of the {@link Object#toString} method.
    */
    @Test
    public final void testToString() {
        JulianDate date = new JulianDate(2451545.5);
        String expected = StringHelper.format("2451545:43200 TAI ({0})", date.toGregorianDate());
        AssertHelper.assertEquals(expected, date.toString());
    }

    /**
    * Tests for consistency between the comparison operators.
    */
    @Test
    public final void testComparisonConsistency() {
        JulianDate one = new JulianDate(1, 0.0);
        JulianDate two = new JulianDate(1, 1e-11);
        Assert.assertTrue(JulianDate.greaterThan(two, one));
        Assert.assertTrue(JulianDate.greaterThanOrEqual(two, one));
        Assert.assertFalse(JulianDate.greaterThan(one, two));
        Assert.assertFalse(JulianDate.greaterThanOrEqual(one, two));
        Assert.assertFalse(JulianDate.lessThan(two, one));
        Assert.assertFalse(JulianDate.lessThanOrEqual(two, one));
        Assert.assertTrue(JulianDate.lessThan(one, two));
        Assert.assertTrue(JulianDate.lessThanOrEqual(one, two));
        Assert.assertFalse(JulianDate.equals(one, two));
        Assert.assertFalse(JulianDate.equals(two, one));
        Assert.assertTrue(JulianDate.notEquals(one, two));
        Assert.assertTrue(JulianDate.notEquals(two, one));
    }

    /**
    * Tests construction of a {@link JulianDate} with a really small negative
    secondsOfDay.  JulianDate will attempt to eliminate the negative SecondsOfDay
    by rolling the Day back one day, but doing so results in setting the SecondsOfDay to
    86400.0 seconds.  This is still not normalized, so JulianDate should bump the Day
    back up and round the SecondsOfDay to 0.0.
    */
    @Test
    public final void testReallySmallNegativeSecondsOfDay() {
        JulianDate date = new JulianDate(2451545, -Constants.Epsilon13);
        AssertHelper.assertEquals(2451545, date.getDay());
        AssertHelper.assertEquals(0.0, date.getSecondsOfDay());
    }

    @Test
    public final void testTryConvertTimeStandard() {
        JulianDate leapSecond = new JulianDate(2453736, 43232.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate afterLeapSecond = new JulianDate(2453736, 43233.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        @CS2JInfo("Initialization of C# struct variable 'outDate' added by translator.")
        JulianDate outDate = new JulianDate();
        final JulianDate[] out$outDate$0 = new JulianDate[1];
        Assert.assertFalse(leapSecond.tryConvertTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME, out$outDate$0));
        outDate = out$outDate$0[0];
        final JulianDate[] out$outDate$1 = new JulianDate[1];
        Assert.assertTrue(afterLeapSecond.tryConvertTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME, out$outDate$1));
        outDate = out$outDate$1[0];
        AssertHelper.assertEquals(outDate.getStandard(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(outDate, afterLeapSecond);
    }

    @Test
    public final void testEqualityOfLeapSeconds() {
        JulianDate leapSecond = new JulianDate(2453736, 43233.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate utcDate = new JulianDate(2453736, 43233.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        Assert.assertFalse(utcDate.equalsType(leapSecond));
        Assert.assertFalse(leapSecond.equalsType(utcDate));
    }

    @Test
    public final void testSecondsDifferenceAtLeapSecond() {
        JulianDate leapSecond = new JulianDate(2453736, 43232.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        JulianDate utcDate = new JulianDate(2453736, 43232.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(-33, utcDate.secondsDifference(leapSecond));
        AssertHelper.assertEquals(33, leapSecond.secondsDifference(utcDate));
        JulianDate secondBeforeLeapSecondUTC = leapSecond.subtractSeconds(1.0).toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        JulianDate secondAfterLeapSecondUTC = leapSecond.addSeconds(1.0).toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(2, secondBeforeLeapSecondUTC.secondsDifference(secondAfterLeapSecondUTC));
        AssertHelper.assertEquals(2, secondAfterLeapSecondUTC.subtract(secondBeforeLeapSecondUTC).getSeconds());
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