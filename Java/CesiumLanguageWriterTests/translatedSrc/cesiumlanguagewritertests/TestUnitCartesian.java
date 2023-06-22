package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.NotFiniteNumberException;
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

/**
 * Tests the {@link UnitCartesian} type.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUnitCartesian {
    /**
    * Tests that initialization of and access to the type's values works correctly.
    */
    @Test
    public final void testHoldValue() {
        UnitCartesian test = new UnitCartesian(2.0, 3.0, 6.0);
        AssertHelper.assertEquals(2.0 / 7.0, test.getX());
        AssertHelper.assertEquals(3.0 / 7.0, test.getY());
        AssertHelper.assertEquals(6.0 / 7.0, test.getZ());
    }

    /**
    * Tests initialization from {@link Cartesian} coordinates.
    */
    @Test
    public final void testFromCartesian() {
        UnitCartesian test = new UnitCartesian(new Cartesian(2.0, 3.0, 6.0));
        AssertHelper.assertEquals(2.0 / 7.0, test.getX(), Constants.Epsilon15);
        AssertHelper.assertEquals(3.0 / 7.0, test.getY(), Constants.Epsilon15);
        AssertHelper.assertEquals(6.0 / 7.0, test.getZ(), Constants.Epsilon15);
    }

    /**
    * Tests initialization from {@link Cartesian} coordinates.
    */
    @Test
    public final void testFromCartesianAndReturnMagnitude() {
        double magnitude = 0D;
        final double[] out$magnitude$0 = new double[1];
        UnitCartesian test = new UnitCartesian(new Cartesian(2.0, 3.0, 6.0), out$magnitude$0);
        magnitude = out$magnitude$0[0];
        AssertHelper.assertEquals(2.0 / 7.0, test.getX(), Constants.Epsilon15);
        AssertHelper.assertEquals(3.0 / 7.0, test.getY(), Constants.Epsilon15);
        AssertHelper.assertEquals(6.0 / 7.0, test.getZ(), Constants.Epsilon15);
        AssertHelper.assertEquals(7.0, magnitude, Constants.Epsilon15);
    }

    /**
    * Tests initialization from coordinates.
    */
    @Test
    public final void testInitializeAndReturnMagnitude() {
        double magnitude = 0D;
        final double[] out$magnitude$1 = new double[1];
        UnitCartesian test = new UnitCartesian(2.0, 3.0, 6.0, out$magnitude$1);
        magnitude = out$magnitude$1[0];
        AssertHelper.assertEquals(2.0 / 7.0, test.getX(), Constants.Epsilon15);
        AssertHelper.assertEquals(3.0 / 7.0, test.getY(), Constants.Epsilon15);
        AssertHelper.assertEquals(6.0 / 7.0, test.getZ(), Constants.Epsilon15);
        AssertHelper.assertEquals(7.0, magnitude, Constants.Epsilon15);
    }

    /**
    * Tests initialization from clock and cone angles.
    */
    @Test
    public final void testFromClockAndCone() {
        final double fortyFiveDegrees = Math.PI / 4.0;
        final double thirtyDegrees = Math.PI / 6.0;
        UnitCartesian test = new UnitCartesian(thirtyDegrees, fortyFiveDegrees);
        AssertHelper.assertEquals(Math.sqrt(3.0) / Math.sqrt(8.0), test.getX(), Constants.Epsilon15);
        AssertHelper.assertEquals(1.0 / Math.sqrt(8.0), test.getY(), Constants.Epsilon15);
        AssertHelper.assertEquals(1.0 / Math.sqrt(2.0), test.getZ(), Constants.Epsilon15);
    }

    /**
    * Tests the equality and inequality methods and operators.
    */
    @Test
    public final void testEquality() {
        UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
        UnitCartesian second = new UnitCartesian(1.0, 2.0, 3.0);
        AssertHelper.assertEquals(first, second);
        AssertHelper.assertEquals(second, first);
        Assert.assertTrue(UnitCartesian.equals(first, second));
        Assert.assertTrue(UnitCartesian.equals(second, first));
        Assert.assertFalse(UnitCartesian.notEquals(first, second));
        Assert.assertFalse(UnitCartesian.notEquals(second, first));
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        second = new UnitCartesian(0.0, 2.0, 3.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(UnitCartesian.equals(first, second));
        Assert.assertFalse(UnitCartesian.equals(second, first));
        Assert.assertTrue(UnitCartesian.notEquals(first, second));
        Assert.assertTrue(UnitCartesian.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        second = new UnitCartesian(1.0, 0.0, 3.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(UnitCartesian.equals(first, second));
        Assert.assertFalse(UnitCartesian.equals(second, first));
        Assert.assertTrue(UnitCartesian.notEquals(first, second));
        Assert.assertTrue(UnitCartesian.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        second = new UnitCartesian(1.0, 2.0, 0.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(UnitCartesian.equals(first, second));
        Assert.assertFalse(UnitCartesian.equals(second, first));
        Assert.assertTrue(UnitCartesian.notEquals(first, second));
        Assert.assertTrue(UnitCartesian.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
    }

    /**
    * Tests the {@link UnitCartesian#equalsEpsilon} method.
    */
    @Test
    public final void testEqualsEpsilon() {
        UnitCartesian first = new UnitCartesian(1.0, 1.0, 1.0);
        UnitCartesian second = new UnitCartesian(0.99, 1.0, 1.01);
        Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
        Assert.assertTrue(second.equalsEpsilon(first, 1e-2));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-3));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-4));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-5));
    }

    /**
    * Tests that the {@link UnitCartesian#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        UnitCartesian first = new UnitCartesian(0.1, 0.1, 0.1);
        UnitCartesian second = new UnitCartesian(0.1, 0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0.0));
    }

    /**
    * Tests to ensure the equality fails when comparing incorrect type.
    */
    @Test
    public final void testEqualityWithWrongType() {
        UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
        Cartographic second = new Cartographic(1.0, 2.0, 3.0);
        // ReSharper disable once SuspiciousTypeConversion.Global
        Assert.assertFalse(first.equals(second));
    }

    /**
    * Tests the {@code IsUndefined} ({@link UnitCartesian#getIsUndefined get}) method.
    */
    @Test
    public final void testIsUndefined() {
        Assert.assertFalse(new UnitCartesian(1.0, 1.0, 1.0).getIsUndefined());
        Assert.assertTrue(UnitCartesian.getUndefined().getIsUndefined());
        Assert.assertTrue(new UnitCartesian(Double.NaN, 1.0, 1.0).getIsUndefined());
        Assert.assertTrue(new UnitCartesian(1.0, Double.NaN, 1.0).getIsUndefined());
        Assert.assertTrue(new UnitCartesian(1.0, 1.0, Double.NaN).getIsUndefined());
    }

    /**
    * Tests that rotation by an invalid {@link ElementaryRotation} produces an
    {@link ArithmeticException}.
    */
    @Test
    public final void testFromZero() {
        AssertHelper.<ArithmeticException> assertThrows(new TypeLiteral<ArithmeticException>() {}, new Action() {
            public void invoke() {
                UnitCartesian unused = new UnitCartesian(Cartesian.getZero());
            }
        });
    }

    /**
    * Tests that rotation by an invalid {@link ElementaryRotation} produces an
    {@link NotFiniteNumberException}.
    */
    @Test
    public final void testFromInfinity() {
        AssertHelper.<NotFiniteNumberException> assertThrows(new TypeLiteral<NotFiniteNumberException>() {}, new Action() {
            public void invoke() {
                UnitCartesian unused = new UnitCartesian(Double.POSITIVE_INFINITY, 0.0, 0.0);
            }
        });
    }

    /**
    * Tests the {@link UnitCartesian#invert} method.
    */
    @Test
    public final void testInvert() {
        UnitCartesian cartesian = new UnitCartesian(2.0, 3.0, 6.0);
        UnitCartesian inverted = cartesian.invert();
        AssertHelper.assertEquals(-2.0 / 7.0, inverted.getX());
        AssertHelper.assertEquals(-3.0 / 7.0, inverted.getY());
        AssertHelper.assertEquals(-6.0 / 7.0, inverted.getZ());
    }

    /**
    * Tests negation of a set of coordinates.
    */
    @Test
    public final void testNegation() {
        UnitCartesian u = UnitCartesian.negate(new UnitCartesian(2.0, 3.0, 6.0));
        AssertHelper.assertEquals(-2.0 / 7.0, u.getX());
        AssertHelper.assertEquals(-3.0 / 7.0, u.getY());
        AssertHelper.assertEquals(-6.0 / 7.0, u.getZ());
    }

    /**
    * Tests the addition methods and operators.
    */
    @Test
    public final void testAdd() {
        UnitCartesian original1 = UnitCartesian.getUnitX();
        UnitCartesian toAdd1 = UnitCartesian.getUnitY();
        Cartesian result = UnitCartesian.add(original1, toAdd1);
        AssertHelper.assertEquals(1.0, result.getX());
        AssertHelper.assertEquals(1.0, result.getY());
        AssertHelper.assertEquals(0.0, result.getZ());
        Cartesian toAdd2 = new Cartesian(0.0, 1.0, 1.0);
        result = UnitCartesian.add(original1, toAdd2);
        AssertHelper.assertEquals(1.0, result.getX());
        AssertHelper.assertEquals(1.0, result.getY());
        AssertHelper.assertEquals(1.0, result.getZ());
        Cartesian original2 = new Cartesian(0.0, 1.0, 1.0);
        UnitCartesian toAdd3 = UnitCartesian.getUnitX();
        result = UnitCartesian.add(original2, toAdd3);
        AssertHelper.assertEquals(1.0, result.getX());
        AssertHelper.assertEquals(1.0, result.getY());
        AssertHelper.assertEquals(1.0, result.getZ());
    }

    /**
    * Tests the subtraction methods and operators.
    */
    @Test
    public final void testSubtract() {
        UnitCartesian original = UnitCartesian.getUnitX();
        UnitCartesian toAdd1 = UnitCartesian.getUnitY();
        Cartesian result = UnitCartesian.subtract(original, toAdd1);
        AssertHelper.assertEquals(1.0, result.getX());
        AssertHelper.assertEquals(-1.0, result.getY());
        AssertHelper.assertEquals(0.0, result.getZ());
        Cartesian toAdd2 = new Cartesian(0.0, 1.0, 1.0);
        result = UnitCartesian.subtract(original, toAdd2);
        AssertHelper.assertEquals(1.0, result.getX());
        AssertHelper.assertEquals(-1.0, result.getY());
        AssertHelper.assertEquals(-1.0, result.getZ());
        Cartesian original2 = new Cartesian(0.0, 1.0, 1.0);
        UnitCartesian toAdd3 = UnitCartesian.getUnitX();
        result = UnitCartesian.subtract(original2, toAdd3);
        AssertHelper.assertEquals(-1.0, result.getX());
        AssertHelper.assertEquals(1.0, result.getY());
        AssertHelper.assertEquals(1.0, result.getZ());
    }

    /**
    * Tests the multiplication methods and operators.
    */
    @Test
    public final void testMultiply() {
        UnitCartesian original = new UnitCartesian(2.0, 3.0, 6.0);
        Cartesian multiplied = UnitCartesian.multiply(original, 7.0);
        AssertHelper.assertEquals(2.0, multiplied.getX());
        AssertHelper.assertEquals(3.0, multiplied.getY());
        AssertHelper.assertEquals(6.0, multiplied.getZ());
        multiplied = UnitCartesian.multiply(7.0, original);
        AssertHelper.assertEquals(2.0, multiplied.getX());
        AssertHelper.assertEquals(3.0, multiplied.getY());
        AssertHelper.assertEquals(6.0, multiplied.getZ());
    }

    /**
    * Tests the multiplication methods and operators.
    */
    @Test
    public final void testDivide() {
        UnitCartesian original = new UnitCartesian(2.0, 3.0, 6.0);
        Cartesian result = UnitCartesian.divide(original, 2.0);
        AssertHelper.assertEquals(2.0 / 14.0, result.getX());
        AssertHelper.assertEquals(3.0 / 14.0, result.getY());
        AssertHelper.assertEquals(6.0 / 14.0, result.getZ());
        result = original.divide(2.0);
        AssertHelper.assertEquals(2.0 / 14.0, result.getX());
        AssertHelper.assertEquals(3.0 / 14.0, result.getY());
        AssertHelper.assertEquals(6.0 / 14.0, result.getZ());
    }

    /**
    * Tests the Dot method.
    */
    @Test
    public final void testDotProduct() {
        UnitCartesian first = new UnitCartesian(1.0, 3.0, -2.0);
        UnitCartesian second = new UnitCartesian(4.0, -2.0, -1.0);
        AssertHelper.assertEquals(0.0, first.dot(second), Constants.Epsilon15);
        AssertHelper.assertEquals(0.0, second.dot(first), Constants.Epsilon15);
        Cartesian result = new Cartesian(4.0, -2.0, -1.0);
        AssertHelper.assertEquals(0, first.dot(result));
    }

    /**
    * Tests the Cross method.
    */
    @Test
    public final void testCrossProduct() {
        final double angle = Math.PI / 4.0;
        double cos = Math.cos(angle / 2.0);
        double sin = Math.sin(angle / 2.0);
        double a = cos * cos - sin * sin / 3.0;
        double b = 2.0 * (sin * sin + sin * cos * Math.sqrt(3.0)) / 3.0;
        double c = 2.0 * (sin * sin - sin * cos * Math.sqrt(3.0)) / 3.0;
        // The three vectors here are the orthonormal set obtained by rotating
        // the x-axis, y-axis, and z-axis through an angle of 45 degrees about
        // the (1,1,1) vector.
        UnitCartesian first = new UnitCartesian(a, b, c);
        UnitCartesian second = new UnitCartesian(c, a, b);
        UnitCartesian third = new UnitCartesian(b, c, a);
        Cartesian result = first.cross(second);
        AssertHelper.assertEquals(third.getX(), result.getX(), Constants.Epsilon14);
        AssertHelper.assertEquals(third.getY(), result.getY(), Constants.Epsilon14);
        AssertHelper.assertEquals(third.getZ(), result.getZ(), Constants.Epsilon14);
        Cartesian cartesian = new Cartesian(c, a, b);
        result = first.cross(cartesian);
        AssertHelper.assertEquals(third.getX(), result.getX(), Constants.Epsilon14);
        AssertHelper.assertEquals(third.getY(), result.getY(), Constants.Epsilon14);
        AssertHelper.assertEquals(third.getZ(), result.getZ(), Constants.Epsilon14);
    }

    /**
    * Tests that GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        UnitCartesian object1 = new UnitCartesian(1.0, 2.0, 3.0);
        UnitCartesian object2 = new UnitCartesian(1.0, 2.0, 3.0);
        UnitCartesian object3 = new UnitCartesian(1.0, 2.0, 3.1);
        AssertHelper.assertEquals(object1.hashCode(), object2.hashCode());
        AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
    }

    /**
    * Tests ToString method
    */
    @Test
    public final void testToString() {
        UnitCartesian test1 = new UnitCartesian(1.0, 0.0, 0.0);
        UnitCartesian test2 = new UnitCartesian(0.0, 1.0, 0.0);
        UnitCartesian test3 = new UnitCartesian(0.0, 0.0, 1.0);
        AssertHelper.assertEquals("1, 0, 0", test1.toString());
        AssertHelper.assertEquals("0, 1, 0", test2.toString());
        AssertHelper.assertEquals("0, 0, 1", test3.toString());
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