package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 *  
 Tests the Bounds class.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBounds {
    @Test
    public final void testStaticInstances() {
        Bounds unbounded = Bounds.getUnbounded();
        Assert.assertEquals(Double.NEGATIVE_INFINITY, unbounded.getLowerBound(), 0d);
        Assert.assertEquals(Double.POSITIVE_INFINITY, unbounded.getUpperBound(), 0d);
    }

    @Test
    public final void testConstructorsAndChecks() {
        Bounds unbounded = new Bounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        AssertHelper.assertEquals(Bounds.getUnbounded(), unbounded);
        Assert.assertTrue(unbounded.getIsUnbounded());
        Assert.assertFalse(unbounded.getIsFinite());
        Bounds zero = new Bounds(0.0, 0.0);
        Assert.assertEquals(0.0, zero.getLowerBound(), 0d);
        Assert.assertEquals(0.0, zero.getUpperBound(), 0d);
        Assert.assertFalse(zero.getIsUnbounded());
        Assert.assertTrue(zero.getIsFinite());
        Bounds finite = new Bounds(-1.0, 1.0);
        Assert.assertEquals(-1.0, finite.getLowerBound(), 0d);
        Assert.assertEquals(1.0, finite.getUpperBound(), 0d);
        Assert.assertFalse(finite.getIsUnbounded());
        Assert.assertTrue(finite.getIsFinite());
        Bounds upperOnly = new Bounds(Double.NEGATIVE_INFINITY, 1.0);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, upperOnly.getLowerBound(), 0d);
        Assert.assertEquals(1.0, upperOnly.getUpperBound(), 0d);
        Assert.assertFalse(upperOnly.getIsUnbounded());
        Assert.assertFalse(upperOnly.getIsFinite());
        Bounds lowerOnly = new Bounds(-1.0, Double.POSITIVE_INFINITY);
        Assert.assertEquals(-1.0, lowerOnly.getLowerBound(), 0d);
        Assert.assertEquals(Double.POSITIVE_INFINITY, lowerOnly.getUpperBound(), 0d);
        Assert.assertFalse(lowerOnly.getIsUnbounded());
        Assert.assertFalse(lowerOnly.getIsFinite());
    }

    @Test
    public final void testConstructorThrowsWithUpperLessThanLower() {
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, new Action() {
            public void invoke() {
                cesiumlanguagewriter.Bounds unused = new Bounds(1.0, -1.0);
            }
        });
    }

    /**
    *  
    Tests that GetHashCode returns something at least reasonably random.
    

    */
    @Test
    public final void testGetHashCode() {
        Bounds object1 = new Bounds(-1.0, 1.0);
        Bounds object2 = new Bounds(-1.0, 1.0);
        Bounds object3 = new Bounds(-1.0, 1.1);
        Assert.assertEquals((int) object1.hashCode(), (int) object2.hashCode());
        AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
    }

    /**
    *  
    Tests the equality and inequality methods and operators.
    

    */
    @Test
    public final void testEquality() {
        Bounds first = new Bounds(-1.0, 1.0);
        Bounds second = new Bounds(-1.0, 1.0);
        AssertHelper.assertEquals(first, second);
        AssertHelper.assertEquals(second, first);
        Assert.assertTrue(Bounds.equals(first, second));
        Assert.assertTrue(Bounds.equals(second, first));
        Assert.assertFalse(Bounds.notEquals(first, second));
        Assert.assertFalse(Bounds.notEquals(second, first));
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        second = new Bounds(0.0, 1.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(Bounds.equals(first, second));
        Assert.assertFalse(Bounds.equals(second, first));
        Assert.assertTrue(Bounds.notEquals(first, second));
        Assert.assertTrue(Bounds.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        second = new Bounds(-1.0, 0.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(Bounds.equals(first, second));
        Assert.assertFalse(Bounds.equals(second, first));
        Assert.assertTrue(Bounds.notEquals(first, second));
        Assert.assertTrue(Bounds.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
    }

    /**
    *  
    Tests the {@link Bounds#equalsEpsilon} method.
    

    */
    @Test
    public final void testEqualsEpsilon() {
        Bounds first = new Bounds(1e-2, 1e-1);
        Bounds second = new Bounds(1.1e-2, 1.1e-1);
        Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
        Assert.assertTrue(second.equalsEpsilon(first, 1e-2));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-3));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-4));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-5));
    }

    /**
    *  
    Tests that the {@link Bounds#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    

    */
    @Test
    public final void testEqualsEpsilonExact() {
        Bounds first = new Bounds(0.1, 0.1);
        Bounds second = new Bounds(0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0D));
    }

    /**
    *  
    Tests to ensure the equality fails when comparing incorrect type.
    

    */
    @Test
    public final void testEqualityWithWrongType() {
        Bounds first = new Bounds(-1.0, 1.0);
        Cartesian second = Cartesian.getZero();
        // ReSharper disable once SuspiciousTypeConversion.Global
        Assert.assertFalse(first.equals(second));
    }

    /**
    *  
    Tests ToString method
    

    */
    @Test
    public final void testToString() {
        final double val1 = 1.1;
        final double val2 = 2.1;
        final String sep = ", ";
        String result = DoubleHelper.toString(val1, CultureInfoHelper.getCurrentCulture()) + sep + DoubleHelper.toString(val2, CultureInfoHelper.getCurrentCulture());
        Bounds test = new Bounds(val1, val2);
        Assert.assertEquals(result, test.toString());
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}