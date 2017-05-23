package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 *  
 A series of tests to exercise this type.
 

 */
@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDuration {
    /**
    *  
    Tests the {@code MinValue} ({@link Duration#getMinValue get}) and {@code MaxValue} ({@link Duration#getMaxValue get}) can be constructed as claimed.
    

    */
    @Test
    public final void testMinValueMaxValue() {
        Duration min = Duration.fromSeconds(Duration.getMinValue().getTotalSeconds());
        Assert.assertEquals((int) Integer.MIN_VALUE, (int) min.getDays());
        Assert.assertEquals(0.0, min.getSeconds(), 0d);
        Duration max = Duration.fromSeconds(Duration.getMaxValue().getTotalSeconds());
        Assert.assertEquals((int) Integer.MAX_VALUE, (int) max.getDays());
        Assert.assertEquals(0.0, max.getSeconds(), 0d);
    }

    /**
    *  
    Tests the Duration constructors that take days, minutes, hours, and seconds.
    

    */
    @Test
    public final void testDaysHoursMinutesSecondsConstructors() {
        Duration duration = new Duration(1, 1, 1, 1.0);
        Assert.assertEquals((int) 1, (int) duration.getDays());
        Assert.assertEquals(3661, duration.getSeconds(), 0d);
    }

    /**
    *  
    Tests that initialization produces a {@link Duration} in canonical form
    with day and seconds elements being either both positive or both negative.
    

    */
    @Test
    public final void testNormalization() {
        // A duration's day and time should either be both negative or both positive
        Duration duration = new Duration(1, 100.0);
        Assert.assertEquals((int) 1, (int) duration.getDays());
        Assert.assertEquals(100.0, duration.getSeconds(), 0d);
        duration = new Duration(-1, -100.0);
        Assert.assertEquals((int) -1, (int) duration.getDays());
        Assert.assertEquals(-100.0, duration.getSeconds(), 0d);
        duration = new Duration(-1, 100.0);
        Assert.assertEquals((int) 0, (int) duration.getDays());
        Assert.assertEquals(-86300.0, duration.getSeconds(), 0d);
        duration = new Duration(1, -100.0);
        Assert.assertEquals((int) 0, (int) duration.getDays());
        Assert.assertEquals(86300.0, duration.getSeconds(), 0d);
    }

    /**
    *  
    Tests that initialization produces a {@link Duration} which is normalized with the
    seconds element in the range -86400.0 < seconds < 86400.0.
    

    */
    @Test
    public final void testSecondsGreaterThanADay() {
        Duration duration = new Duration(0, 107000.0);
        Assert.assertEquals((int) 1, (int) duration.getDays());
        Assert.assertEquals(20600.0, duration.getSeconds(), 0d);
    }

    /**
    *  
    Tests the check for EXACT equality and the check for equality within a specified tolerance.
    

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
        Assert.assertEquals((int) 0, (int) first.compareTo(second));
        Assert.assertEquals((int) 0, (int) second.compareTo(first));
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
        Assert.assertFalse(first.equals(5));
    }

    /**
    *  
    Tests Duration.CompareTo
    

    */
    @Test
    public final void testCompareTo() {
        Duration duration1 = new Duration(1, 0.0);
        Duration duration2 = new Duration(1, 0.0);
        Assert.assertTrue(duration1.compareTo(duration2) == 0);
        Assert.assertTrue(duration2.compareTo(duration1) == 0);
        Assert.assertTrue(Duration.greaterThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.lessThanOrEqual(duration2, duration1));
        Assert.assertTrue(Duration.lessThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.greaterThanOrEqual(duration2, duration1));
        duration2 = new Duration(2, 0.0);
        Assert.assertTrue(duration1.compareTo(duration2) < 0);
        Assert.assertTrue(duration2.compareTo(duration1) > 0);
        Assert.assertTrue(Duration.lessThan(duration1, duration2));
        Assert.assertTrue(Duration.greaterThan(duration2, duration1));
        Assert.assertTrue(Duration.lessThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.greaterThanOrEqual(duration2, duration1));
        duration2 = new Duration(1, 1.0);
        Assert.assertTrue(duration1.compareTo(duration2) < 0);
        Assert.assertTrue(duration2.compareTo(duration1) > 0);
        Assert.assertTrue(Duration.lessThan(duration1, duration2));
        Assert.assertTrue(Duration.greaterThan(duration2, duration1));
        Assert.assertTrue(Duration.lessThanOrEqual(duration1, duration2));
        Assert.assertTrue(Duration.greaterThanOrEqual(duration2, duration1));
    }

    /**
    *  
    Tests the addition operation between two {@link Duration} instances
    with unspecified time standards.
    

    */
    @Test
    public final void testAddition() {
        Duration original = new Duration(5, 1000.0);
        Duration add = Duration.fromSeconds(50.0);
        Duration result = Duration.add(original, add);
        Assert.assertEquals((int) 5, (int) result.getDays());
        Assert.assertEquals(1050.0, result.getSeconds(), 0d);
        original = new Duration(5, 8382.1);
        add = new Duration(1, 10.0);
        result = Duration.add(original, add);
        Assert.assertEquals((int) 6, (int) result.getDays());
        Assert.assertEquals(8392.1, result.getSeconds(), 0d);
        original = new Duration(5, 86000.0);
        add = Duration.fromSeconds(1000.0);
        result = Duration.add(original, add);
        Assert.assertEquals((int) 6, (int) result.getDays());
        Assert.assertEquals(600.0, result.getSeconds(), 0d);
    }

    /**
    *  
    Tests the subtraction operation between two {@link Duration} instances
    with unspecified time standards.
    

    */
    @Test
    public final void testSubtraction() {
        Duration first = new Duration(5, 1000.0);
        Duration second = new Duration(5, 2000.0);
        Duration difference = Duration.subtract(second, first);
        Assert.assertEquals(1000.0, difference.getTotalSeconds(), 0d);
        difference = Duration.subtract(first, second);
        Assert.assertEquals(-1000.0, difference.getTotalSeconds(), 0d);
        first = new Duration(5, 1000.0);
        second = new Duration(6, 2000.0);
        difference = Duration.subtract(second, first);
        Assert.assertEquals((int) 1, (int) difference.getDays());
        Assert.assertEquals(1000.0, difference.getSeconds(), 0d);
        difference = Duration.subtract(first, second);
        Assert.assertEquals((int) -1, (int) difference.getDays());
        Assert.assertEquals(-1000.0, difference.getSeconds(), 0d);
        first = new Duration(5, 86000.0);
        second = new Duration(6, 100.0);
        difference = Duration.subtract(second, first);
        Assert.assertEquals((int) 0, (int) difference.getDays());
        Assert.assertEquals(500.0, difference.getSeconds(), 0d);
        difference = Duration.subtract(first, second);
        Assert.assertEquals((int) 0, (int) difference.getDays());
        Assert.assertEquals(-500.0, difference.getSeconds(), 0d);
    }

    /**
    *  
    Tests multiplication of a {@link Duration} instance by a constant.
    

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
        result = Duration.multiply(duration, -2D);
        Assert.assertEquals(-12 * 3600, result.getSeconds(), 0d);
        Assert.assertEquals((int) -1, (int) result.getDays());
        duration = new Duration(1, 4 * 3600);
        result = Duration.multiply(duration, -0.5);
        Assert.assertEquals(-14 * 3600, result.getSeconds(), 0d);
        Assert.assertEquals((int) 0, (int) result.getDays());
    }

    /**
    *  
    Tests division of a {@link Duration} by another.
    

    */
    @Test
    public final void testDivisionByDuration() {
        Duration one = new Duration(1, 0.0);
        Duration two = new Duration(0, 60.0);
        Assert.assertEquals(86400.0 / 60.0, one.divide(two), Constants.Epsilon10);
        Assert.assertEquals(60 / 86400.0, Duration.divide(two, one), Constants.Epsilon10);
        Duration three = new Duration(1, 43200.0);
        Assert.assertEquals((86400 + 43200) / 60.0, Duration.divide(three, two), Constants.Epsilon10);
        Assert.assertEquals(60.0 / (86400.0 + 43200.0), two.divide(three), Constants.Epsilon10);
        Duration four = new Duration(1, 0D);
        Duration five = new Duration(0, -3600D);
        Assert.assertEquals(-24D, Duration.divide(four, five), Constants.Epsilon10);
        Assert.assertEquals((-1.0 / 24.0), Duration.divide(five, four), Constants.Epsilon10);
        Duration six = new Duration(-2, 0D);
        Assert.assertEquals(-0.5, Duration.divide(four, six), 0d);
        Assert.assertEquals(48, Duration.divide(six, five), 0d);
        Duration seven = new Duration(0, -0.5);
        Assert.assertEquals(-48 * 3600, Duration.divide(four, seven), 0d);
    }

    /**
    *  
    Tests division of a {@link Duration} by a constant.
    

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
        Assert.assertEquals(-12 * 3600, result.getSeconds(), 0d);
        Assert.assertEquals((int) -1, (int) result.getDays());
        duration = new Duration(1, 4 * 3600);
        result = Duration.divide(duration, -2D);
        Assert.assertEquals(-14 * 3600, result.getSeconds(), 0d);
        Assert.assertEquals((int) 0, (int) result.getDays());
    }

    /**
    *  
    Tests the Duration.AddSeconds method.
    

    */
    @Test
    public final void testAddSeconds() {
        Duration test = new Duration(5, 43200.0);
        Duration result = test.addSeconds(45.123);
        Assert.assertEquals((int) 5, (int) result.getDays());
        Assert.assertEquals(43245.123, result.getSeconds(), 0d);
    }

    /**
    *  
    Tests the Duration.AddDays method.
    

    */
    @Test
    public final void testAddDays() {
        Duration test = new Duration(5, 43200.0);
        Duration result = test.addDays(45.5);
        Assert.assertEquals((int) 51, (int) result.getDays());
        Assert.assertEquals(0.0, result.getSeconds(), 0d);
    }

    /**
    *  
    Tests that Duration.GetHashCode returns something at least reasonably random.
    

    */
    @Test
    public final void testGetHashCode() {
        Duration duration1 = new Duration(1, 0.0);
        Duration duration2 = new Duration(1, 1.0);
        Duration duration3 = new Duration(1, 0.0);
        AssertHelper.assertNotEqual(duration1.hashCode(), duration2.hashCode());
        Assert.assertEquals((int) duration1.hashCode(), (int) duration3.hashCode());
    }

    /**
    *  
    Tests the Duration.TotalDays property
    

    */
    @Test
    public final void testTotalDays() {
        Duration duration = new Duration(1, 43200.0);
        Assert.assertEquals(1.5, duration.getTotalDays(), 0d);
    }

    /**
    *  
    Test the {@link Duration#toString} method.
    

    */
    @Test
    public final void testToString() {
        Duration duration = new Duration(1, 43200.0);
        Assert.assertEquals(duration.toString(), "1:43200");
    }

    /**
    *  
    Tests construction of a {@link Duration} with a really small negative
    seconds.  Duration will attempt to eliminate the negative Seconds
    by rolling the Days back one day, but doing so results in setting the Seconds to
    86400.0 seconds.  This is still not normalized, so Duration should bump the Days
    back up and round the Seconds to 0.0.
    

    */
    @Test
    public final void testReallySmallSeconds() {
        Duration duration = new Duration(10, -Constants.Epsilon13);
        Assert.assertEquals((int) duration.getDays(), (int) 10);
        Assert.assertEquals(0.0, duration.getSeconds(), 0d);
        duration = new Duration(-10, Constants.Epsilon13);
        Assert.assertEquals((int) duration.getDays(), (int) -10);
        Assert.assertEquals(0.0, duration.getSeconds(), 0d);
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}