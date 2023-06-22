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
public class TestDuration {
    /**
    * Tests that {@code MinValue} ({@link Duration#getMinValue get}), {@code MaxValue} ({@link Duration#getMaxValue get}), and {@code Zero} ({@link Duration#getZero get}) can be constructed as claimed.
    */
    @Test
    public final void testMinValueMaxValueZeroValue() {
        Duration min = Duration.fromSeconds(Duration.getMinValue().getTotalSeconds());
        AssertHelper.assertEquals(Integer.MIN_VALUE, min.getDays());
        AssertHelper.assertEquals(0.0, min.getSeconds());
        Duration max = Duration.fromSeconds(Duration.getMaxValue().getTotalSeconds());
        AssertHelper.assertEquals(Integer.MAX_VALUE, max.getDays());
        AssertHelper.assertEquals(0.0, max.getSeconds());
        Duration zero = Duration.fromSeconds(Duration.getZero().getTotalSeconds());
        AssertHelper.assertEquals(0.0, zero.getDays());
        AssertHelper.assertEquals(0.0, zero.getSeconds());
    }

    /**
    * Tests the Duration constructors that take days, minutes, hours, and seconds.
    */
    @Test
    public final void testDaysHoursMinutesSecondsConstructors() {
        Duration duration = new Duration(1, 1, 1, 1.0);
        AssertHelper.assertEquals(1, duration.getDays());
        AssertHelper.assertEquals(3661, duration.getSeconds());
    }

    /**
    * Tests that initialization produces a {@link Duration} in canonical form
    with day and seconds elements being either both positive or both negative.
    */
    @Test
    public final void testNormalization() {
        // A duration's day and time should either be both negative or both positive
        Duration duration = new Duration(1, 100.0);
        AssertHelper.assertEquals(1, duration.getDays());
        AssertHelper.assertEquals(100.0, duration.getSeconds());
        duration = new Duration(-1, -100.0);
        AssertHelper.assertEquals(-1, duration.getDays());
        AssertHelper.assertEquals(-100.0, duration.getSeconds());
        duration = new Duration(-1, 100.0);
        AssertHelper.assertEquals(0, duration.getDays());
        AssertHelper.assertEquals(-86300.0, duration.getSeconds());
        duration = new Duration(1, -100.0);
        AssertHelper.assertEquals(0, duration.getDays());
        AssertHelper.assertEquals(86300.0, duration.getSeconds());
    }

    /**
    * Tests that initialization produces a {@link Duration} which is normalized with the
    seconds element in the range -86400.0 &lt; seconds &lt; 86400.0.
    */
    @Test
    public final void testSecondsGreaterThanADay() {
        Duration duration = new Duration(0, 107000.0);
        AssertHelper.assertEquals(1, duration.getDays());
        AssertHelper.assertEquals(20600.0, duration.getSeconds());
    }

    /**
    * Tests the check for EXACT equality and the check for equality within a specified tolerance.
    */
    @Test
    public final void testEquality() {
        Duration first = new Duration(5, 565.0);
        Duration second = new Duration(5, 565.0);
        AssertHelper.assertEquals(first, second);
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        Assert.assertTrue(Duration.equals(first, second));
        Assert.assertTrue(Duration.equals(second, first));
        Assert.assertFalse(Duration.notEquals(first, second));
        Assert.assertFalse(Duration.notEquals(second, first));
        AssertHelper.assertEquals(0, first.compareTo(second));
        AssertHelper.assertEquals(0, second.compareTo(first));
        first = new Duration(5, 0.00001);
        second = new Duration(4, 86399.99999);
        AssertHelper.assertNotEqual(first, second);
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        Assert.assertFalse(Duration.equals(first, second));
        Assert.assertFalse(Duration.equals(second, first));
        Assert.assertTrue(Duration.notEquals(first, second));
        Assert.assertTrue(Duration.notEquals(second, first));
        AssertHelper.assertNotEqual(0, first.compareTo(second));
        AssertHelper.assertNotEqual(0, second.compareTo(first));
        Assert.assertTrue(first.equalsEpsilon(second, 1e-4));
        Assert.assertTrue(second.equalsEpsilon(first, 1e-4));
        // Make sure a Duration compared with a non-Duration returns false
        // ReSharper disable once SuspiciousTypeConversion.Global
        Assert.assertFalse(first.equals(5));
    }

    /**
    * Tests Duration.CompareTo
    */
    @Test
    public final void testCompareTo() {
        Duration duration1 = new Duration(1, 0.0);
        Duration duration2 = new Duration(1, 0.0);
        AssertHelper.assertEquals(0, duration1.compareTo(duration2));
        AssertHelper.assertEquals(0, duration2.compareTo(duration1));
        Assert.assertTrue(Duration.greaterThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.lessThanOrEqual(duration2, duration1));
        Assert.assertTrue(Duration.lessThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.greaterThanOrEqual(duration2, duration1));
        duration2 = new Duration(2, 0.0);
        AssertHelper.assertLess(duration1.compareTo(duration2), 0);
        AssertHelper.assertGreater(duration2.compareTo(duration1), 0);
        Assert.assertTrue(Duration.lessThan(duration1, duration2));
        Assert.assertTrue(Duration.greaterThan(duration2, duration1));
        Assert.assertTrue(Duration.lessThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.greaterThanOrEqual(duration2, duration1));
        duration2 = new Duration(1, 1.0);
        AssertHelper.assertLess(duration1.compareTo(duration2), 0);
        AssertHelper.assertGreater(duration2.compareTo(duration1), 0);
        Assert.assertTrue(Duration.lessThan(duration1, duration2));
        Assert.assertTrue(Duration.greaterThan(duration2, duration1));
        Assert.assertTrue(Duration.lessThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.greaterThanOrEqual(duration2, duration1));
    }

    /**
    * Tests the addition operation between two {@link Duration} instances
    with unspecified time standards.
    */
    @Test
    public final void testAddition() {
        Duration original = new Duration(5, 1000.0);
        Duration add = Duration.fromSeconds(50.0);
        Duration result = Duration.add(original, add);
        AssertHelper.assertEquals(5, result.getDays());
        AssertHelper.assertEquals(1050.0, result.getSeconds());
        original = new Duration(5, 8382.1);
        add = new Duration(1, 10.0);
        result = Duration.add(original, add);
        AssertHelper.assertEquals(6, result.getDays());
        AssertHelper.assertEquals(8392.1, result.getSeconds());
        original = new Duration(5, 86000.0);
        add = Duration.fromSeconds(1000.0);
        result = Duration.add(original, add);
        AssertHelper.assertEquals(6, result.getDays());
        AssertHelper.assertEquals(600.0, result.getSeconds());
    }

    /**
    * Tests the subtraction operation between two {@link Duration} instances
    with unspecified time standards.
    */
    @Test
    public final void testSubtraction() {
        Duration first = new Duration(5, 1000.0);
        Duration second = new Duration(5, 2000.0);
        Duration difference = Duration.subtract(second, first);
        AssertHelper.assertEquals(1000.0, difference.getTotalSeconds());
        difference = Duration.subtract(first, second);
        AssertHelper.assertEquals(-1000.0, difference.getTotalSeconds());
        first = new Duration(5, 1000.0);
        second = new Duration(6, 2000.0);
        difference = Duration.subtract(second, first);
        AssertHelper.assertEquals(1, difference.getDays());
        AssertHelper.assertEquals(1000.0, difference.getSeconds());
        difference = Duration.subtract(first, second);
        AssertHelper.assertEquals(-1, difference.getDays());
        AssertHelper.assertEquals(-1000.0, difference.getSeconds());
        first = new Duration(5, 86000.0);
        second = new Duration(6, 100.0);
        difference = Duration.subtract(second, first);
        AssertHelper.assertEquals(0, difference.getDays());
        AssertHelper.assertEquals(500.0, difference.getSeconds());
        difference = Duration.subtract(first, second);
        AssertHelper.assertEquals(0, difference.getDays());
        AssertHelper.assertEquals(-500.0, difference.getSeconds());
    }

    /**
    * Tests multiplication of a {@link Duration} instance by a constant.
    */
    @Test
    public final void testMultiplication() {
        Duration duration = new Duration(5, 1.0);
        Duration result = duration.multiply(100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(500, 100.0), Constants.Epsilon10));
        result = Duration.multiply(duration, 100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(500, 100.0), Constants.Epsilon10));
        duration = new Duration(0, 5000.1);
        result = duration.multiply(100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(5, 68010.0), Constants.Epsilon10));
        result = Duration.multiply(duration, 100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(5, 68010.0), Constants.Epsilon10));
        duration = new Duration(1, 43200.0);
        result = duration.multiply(0.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(0, 64800.0), Constants.Epsilon10));
        result = Duration.multiply(duration, 0.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(0, 64800.0), Constants.Epsilon10));
        duration = new Duration(5, 1.0);
        result = duration.multiply(100.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(502, 43300.5), Constants.Epsilon10));
        result = Duration.multiply(duration, 100.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(502, 43300.5), Constants.Epsilon10));
        result = Duration.multiply(duration, -0.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(-2, -43200.5), Constants.Epsilon10));
        duration = new Duration(0, 18 * 3600);
        result = Duration.multiply(duration, -2.0);
        AssertHelper.assertEquals(-12 * 3600, result.getSeconds());
        AssertHelper.assertEquals(-1, result.getDays());
        duration = new Duration(1, 4 * 3600);
        result = Duration.multiply(duration, -0.5);
        AssertHelper.assertEquals(-14 * 3600, result.getSeconds());
        AssertHelper.assertEquals(0, result.getDays());
    }

    /**
    * Tests division of a {@link Duration} by another.
    */
    @Test
    public final void testDivisionByDuration() {
        Duration one = new Duration(1, 0.0);
        Duration two = new Duration(0, 60.0);
        AssertHelper.assertEquals(86400.0 / 60.0, one.divide(two), Constants.Epsilon10);
        AssertHelper.assertEquals(60 / 86400.0, Duration.divide(two, one), Constants.Epsilon10);
        Duration three = new Duration(1, 43200.0);
        AssertHelper.assertEquals((86400 + 43200) / 60.0, Duration.divide(three, two), Constants.Epsilon10);
        AssertHelper.assertEquals(60.0 / (86400.0 + 43200.0), two.divide(three), Constants.Epsilon10);
        Duration four = new Duration(1, 0.0);
        Duration five = new Duration(0, -3600.0);
        AssertHelper.assertEquals(-24.0, Duration.divide(four, five), Constants.Epsilon10);
        AssertHelper.assertEquals(-1.0 / 24.0, Duration.divide(five, four), Constants.Epsilon10);
        Duration six = new Duration(-2, 0.0);
        AssertHelper.assertEquals(-0.5, Duration.divide(four, six));
        AssertHelper.assertEquals(48, Duration.divide(six, five));
        Duration seven = new Duration(0, -0.5);
        AssertHelper.assertEquals(-48 * 3600, Duration.divide(four, seven));
    }

    /**
    * Tests division of a {@link Duration} by a constant.
    */
    @Test
    public final void testDivisionByConstant() {
        Duration duration = new Duration(500, 100.0);
        Duration result = duration.divide(100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));
        result = Duration.divide(duration, 100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));
        duration = new Duration(5, 68010.0);
        result = duration.divide(100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(0, 5000.1), Constants.Epsilon10));
        result = Duration.divide(duration, 100.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(0, 5000.1), Constants.Epsilon10));
        duration = new Duration(0, 64800.0);
        result = duration.divide(0.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(1, 43200.0), Constants.Epsilon10));
        result = Duration.divide(duration, 0.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(1, 43200.0), Constants.Epsilon10));
        duration = new Duration(502, 43300.5);
        result = duration.divide(100.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));
        result = Duration.divide(duration, 100.5);
        Assert.assertTrue(result.equalsEpsilon(new Duration(5, 1.0), Constants.Epsilon10));
        duration = new Duration(5, 1.0);
        result = Duration.divide(duration, -2.0);
        Assert.assertTrue(result.equalsEpsilon(new Duration(-2, -43200.5), Constants.Epsilon10));
        duration = new Duration(0, 18 * 3600);
        result = Duration.divide(duration, -0.5);
        AssertHelper.assertEquals(-12 * 3600, result.getSeconds());
        AssertHelper.assertEquals(-1, result.getDays());
        duration = new Duration(1, 4 * 3600);
        result = Duration.divide(duration, -2.0);
        AssertHelper.assertEquals(-14 * 3600, result.getSeconds());
        AssertHelper.assertEquals(0, result.getDays());
    }

    /**
    * Tests the Duration.AddSeconds method.
    */
    @Test
    public final void testAddSeconds() {
        Duration test = new Duration(5, 43200.0);
        Duration result = test.addSeconds(45.123);
        AssertHelper.assertEquals(5, result.getDays());
        AssertHelper.assertEquals(43245.123, result.getSeconds());
    }

    /**
    * Tests the Duration.AddDays method.
    */
    @Test
    public final void testAddDays() {
        Duration test = new Duration(5, 43200.0);
        Duration result = test.addDays(45.5);
        AssertHelper.assertEquals(51, result.getDays());
        AssertHelper.assertEquals(0.0, result.getSeconds());
    }

    /**
    * Tests that Duration.GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        Duration duration1 = new Duration(1, 0.0);
        Duration duration2 = new Duration(1, 1.0);
        Duration duration3 = new Duration(1, 0.0);
        AssertHelper.assertNotEqual(duration1.hashCode(), duration2.hashCode());
        AssertHelper.assertEquals(duration1.hashCode(), duration3.hashCode());
    }

    /**
    * Tests the Duration.TotalDays property
    */
    @Test
    public final void testTotalDays() {
        Duration duration = new Duration(1, 43200.0);
        AssertHelper.assertEquals(1.5, duration.getTotalDays());
    }

    /**
    * Test the {@link Duration#toString} method.
    */
    @Test
    public final void testToString() {
        Duration duration = new Duration(1, 43200.0);
        AssertHelper.assertEquals("1:43200", duration.toString());
    }

    /**
    * Tests construction of a {@link Duration} with a really small negative
    seconds.  Duration will attempt to eliminate the negative Seconds
    by rolling the Days back one day, but doing so results in setting the Seconds to
    86400.0 seconds.  This is still not normalized, so Duration should bump the Days
    back up and round the Seconds to 0.0.
    */
    @Test
    public final void testReallySmallSeconds() {
        Duration duration = new Duration(10, -Constants.Epsilon13);
        AssertHelper.assertEquals(10, duration.getDays());
        AssertHelper.assertEquals(0.0, duration.getSeconds());
        duration = new Duration(-10, Constants.Epsilon13);
        AssertHelper.assertEquals(-10, duration.getDays());
        AssertHelper.assertEquals(0.0, duration.getSeconds());
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