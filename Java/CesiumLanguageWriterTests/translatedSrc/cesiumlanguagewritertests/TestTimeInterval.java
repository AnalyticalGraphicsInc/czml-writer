package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.TestContextRule;
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
public class TestTimeInterval {
    /**
    * Tests that initialization of and access to the type's values is performed correctly.
    */
    @Test
    public final void testRetainValue() {
        JulianDate start = JulianDate.getNow();
        JulianDate stop = JulianDate.add(start, Duration.fromDays(1.5));
        TimeInterval interval = new TimeInterval(start, stop);
        AssertHelper.assertEquals(start, interval.getStart());
        AssertHelper.assertEquals(stop, interval.getStop());
    }

    /**
    * Tests that the Duration of an Interval is calculated correctly.
    */
    @Test
    public final void testCalculateDuration() {
        JulianDate start = new JulianDate(2451545.0);
        JulianDate stop = JulianDate.add(start, Duration.fromDays(1.5));
        TimeInterval interval = new TimeInterval(start, stop);
        AssertHelper.assertEquals(Duration.fromDays(1.5), interval.toDuration());
    }

    /**
    * Tests the IsEmpty property.
    */
    @Test
    public final void testIsEmpty() {
        TimeInterval interval = new TimeInterval(new JulianDate(1.0), new JulianDate(1.0));
        Assert.assertTrue(interval.getIsEmpty());
        interval = new TimeInterval(new JulianDate(5.0), new JulianDate(4.0));
        Assert.assertTrue(interval.getIsEmpty());
    }

    /**
    * Tests equality between time intervals.
    */
    @Test
    public final void testEquality() {
        TimeInterval interval1 = new TimeInterval(new JulianDate(1.0), new JulianDate(2.0));
        TimeInterval interval2 = new TimeInterval(new JulianDate(1.0), new JulianDate(2.0));
        AssertHelper.assertEquals(interval1, interval2);
        AssertHelper.assertEquals(interval2, interval1);
        Assert.assertTrue(interval1.equalsType(interval2));
        Assert.assertTrue(interval2.equalsType(interval1));
        Assert.assertTrue(TimeInterval.equals(interval1, interval2));
        Assert.assertTrue(TimeInterval.equals(interval2, interval1));
        Assert.assertFalse(TimeInterval.notEquals(interval1, interval2));
        Assert.assertFalse(TimeInterval.notEquals(interval2, interval1));
        interval2 = new TimeInterval(new JulianDate(1.0), new JulianDate(3.0));
        AssertHelper.assertNotEqual(interval1, interval2);
        AssertHelper.assertNotEqual(interval2, interval1);
        Assert.assertFalse(interval1.equalsType(interval2));
        Assert.assertFalse(interval2.equalsType(interval1));
        Assert.assertFalse(TimeInterval.equals(interval1, interval2));
        Assert.assertFalse(TimeInterval.equals(interval2, interval1));
        Assert.assertTrue(TimeInterval.notEquals(interval1, interval2));
        Assert.assertTrue(TimeInterval.notEquals(interval2, interval1));
        AssertHelper.assertNotEqual(interval1, 5);
    }

    /**
    * Tests equality between nullable time intervals.
    */
    @Test
    public final void testNullableEquality() {
        TimeInterval interval1 = new TimeInterval(new JulianDate(1.0), new JulianDate(2.0));
        TimeInterval interval2 = null;
        Assert.assertFalse(TimeInterval.equals(interval1, interval2));
        Assert.assertFalse(TimeInterval.equals(interval2, interval1));
        interval1 = null;
        Assert.assertTrue(TimeInterval.equals(interval1, interval2));
        Assert.assertTrue(TimeInterval.equals(interval2, interval1));
    }

    /**
    * Tests that JulianDate.GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        TimeInterval interval1 = new TimeInterval(new JulianDate(1.0), new JulianDate(5.0));
        TimeInterval interval2 = new TimeInterval(new JulianDate(2.0), new JulianDate(5.0));
        TimeInterval interval3 = new TimeInterval(new JulianDate(1.0), new JulianDate(5.0));
        AssertHelper.assertNotEqual(interval1.hashCode(), interval2.hashCode());
        AssertHelper.assertEquals(interval1.hashCode(), interval3.hashCode());
        AssertHelper.assertEquals(interval1, interval3);
        AssertHelper.assertNotEqual(interval1, interval2);
    }

    /**
    * Tests the {@link TimeInterval#contains} method.
    */
    @Test
    public final void testContains() {
        Assert.assertFalse(TimeInterval.getEmpty().contains(new JulianDate(2451545.0)));
        TimeInterval interval1 = new TimeInterval(new JulianDate(2451545.0), new JulianDate(2451546.0));
        Assert.assertTrue(interval1.contains(new JulianDate(2451545.0)));
        Assert.assertTrue(interval1.contains(new JulianDate(2451545.5)));
        Assert.assertTrue(interval1.contains(new JulianDate(2451546.0)));
        Assert.assertFalse(interval1.contains(new JulianDate(2451546.5)));
    }

    /**
    * Tests the {@link TimeInterval#equalsEpsilon} method.
    */
    @Test
    public final void testEqualsEpsilon() {
        TimeInterval interval1 = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451546, 0.00));
        TimeInterval interval2 = new TimeInterval(new JulianDate(2451545, 0.05), new JulianDate(2451545, 86399.95));
        TimeInterval interval4 = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451546, 0.00));
        Assert.assertFalse(interval1.equalsEpsilon(null, Constants.Epsilon1));
        Assert.assertTrue(interval1.equalsEpsilon(interval2, Constants.Epsilon1));
        Assert.assertTrue(interval1.equalsEpsilon(interval4, Constants.Epsilon1));
    }

    /**
    * Tests that the {@link TimeInterval#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        TimeInterval first = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451545, 0.00));
        TimeInterval second = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451545, 0.00));
        Assert.assertTrue(second.equalsEpsilon(first, 0.00));
    }

    /**
    * Tests the {@link TimeInterval#toTimeStandard} method.
    */
    @Test
    public final void testToTimeStandard() {
        JulianDate start = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        JulianDate stop = new JulianDate(2451546.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        TimeInterval interval = new TimeInterval(start, stop);
        TimeInterval result = interval.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(result.getStart().getStandard(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(result.getStop().getStandard(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        AssertHelper.assertEquals(result.getStart().getTotalDays(), 2451545.0, Constants.Epsilon15);
        AssertHelper.assertEquals(result.getStop().getTotalDays(), 2451546.0, Constants.Epsilon15);
        result = interval.toTimeStandard(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(result.getStart().getStandard(), TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertEquals(result.getStop().getStandard(), TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        AssertHelper.assertNotEqual(result.getStart().getTotalDays(), 2451545.0);
        AssertHelper.assertNotEqual(result.getStop().getTotalDays(), 2451546.0);
        TimeInterval empty = new TimeInterval(new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME), new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME));
        Assert.assertTrue(empty.getIsEmpty());
        result = empty.toTimeStandard(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
        Assert.assertTrue(result.getIsEmpty());
    }

    /**
    * Tests the {@link TimeInterval#toString} method
    */
    @Test
    public final void testToString() {
        TimeInterval interval = new TimeInterval(new JulianDate(2451545, 0.00), new JulianDate(2451546, 0.00));
        AssertHelper.assertEquals("[2451545:0 TAI (" + interval.getStart().toGregorianDate() + "), 2451546:0 TAI (" + interval.getStop().toGregorianDate() + ")]", interval.toString());
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