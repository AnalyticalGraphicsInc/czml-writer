package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBounds {
    @Test
    public final void testStaticInstances() {
        Bounds unbounded = Bounds.getUnbounded();
        AssertHelper.assertEquals(Double.NEGATIVE_INFINITY, unbounded.getLowerBound());
        AssertHelper.assertEquals(Double.POSITIVE_INFINITY, unbounded.getUpperBound());
    }

    @Test
    public final void testConstructorsAndChecks() {
        Bounds unbounded = new Bounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        AssertHelper.assertEquals(Bounds.getUnbounded(), unbounded);
        Assert.assertTrue(unbounded.getIsUnbounded());
        Assert.assertFalse(unbounded.getIsFinite());
        Bounds zero = new Bounds(0.0, 0.0);
        AssertHelper.assertEquals(0.0, zero.getLowerBound());
        AssertHelper.assertEquals(0.0, zero.getUpperBound());
        Assert.assertFalse(zero.getIsUnbounded());
        Assert.assertTrue(zero.getIsFinite());
        Bounds finite = new Bounds(-1.0, 1.0);
        AssertHelper.assertEquals(-1.0, finite.getLowerBound());
        AssertHelper.assertEquals(1.0, finite.getUpperBound());
        Assert.assertFalse(finite.getIsUnbounded());
        Assert.assertTrue(finite.getIsFinite());
        Bounds upperOnly = new Bounds(Double.NEGATIVE_INFINITY, 1.0);
        AssertHelper.assertEquals(Double.NEGATIVE_INFINITY, upperOnly.getLowerBound());
        AssertHelper.assertEquals(1.0, upperOnly.getUpperBound());
        Assert.assertFalse(upperOnly.getIsUnbounded());
        Assert.assertFalse(upperOnly.getIsFinite());
        Bounds lowerOnly = new Bounds(-1.0, Double.POSITIVE_INFINITY);
        AssertHelper.assertEquals(-1.0, lowerOnly.getLowerBound());
        AssertHelper.assertEquals(Double.POSITIVE_INFINITY, lowerOnly.getUpperBound());
        Assert.assertFalse(lowerOnly.getIsUnbounded());
        Assert.assertFalse(lowerOnly.getIsFinite());
    }

    @Test
    public final void testConstructorThrowsWithUpperLessThanLower() {
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            Bounds unused = new Bounds(1.0, -1.0);
        }));
    }

    /**
    * Tests that GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        Bounds object1 = new Bounds(-1.0, 1.0);
        Bounds object2 = new Bounds(-1.0, 1.0);
        Bounds object3 = new Bounds(-1.0, 1.1);
        AssertHelper.assertEquals(object1.hashCode(), object2.hashCode());
        AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
    }

    /**
    * Tests the equality and inequality methods and operators.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
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

    @Test
    public final void testEqualsEpsilon() {
        Bounds first = new Bounds(1e-2, 1e-1);
        Bounds second = new Bounds(1.1e-2, 1.1e-1);
        Assert.assertTrue(second.equalsEpsilon(first, Constants.Epsilon1));
        Assert.assertTrue(second.equalsEpsilon(first, Constants.Epsilon2));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon3));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon4));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon5));
    }

    /**
    * Tests that the {@link Bounds#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        Bounds first = new Bounds(0.1, 0.1);
        Bounds second = new Bounds(0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0.0));
    }

    /**
    * Tests to ensure the equality fails when comparing incorrect type.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEqualityWithWrongType() {
        Bounds first = new Bounds(-1.0, 1.0);
        Cartesian second = Cartesian.getZero();
        Assert.assertFalse(first.equals(second));
    }

    @Test
    public final void testToString() {
        final double lowerBound = 1.1;
        final double upperBound = 2.1;
        Bounds test = new Bounds(lowerBound, upperBound);
        String expected = StringHelper.format(CultureInfoHelper.getCurrentCulture(), "{0}, {1}", lowerBound, upperBound);
        AssertHelper.assertEquals(expected, test.toString());
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