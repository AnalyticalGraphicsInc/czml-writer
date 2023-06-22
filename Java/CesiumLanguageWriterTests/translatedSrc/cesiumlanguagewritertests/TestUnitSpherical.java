package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
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
 * Tests the {@link UnitSpherical} type.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUnitSpherical {
    /**
    * Tests that initialization of and access to the type's values works correctly.
    */
    @Test
    public final void testHoldValue() {
        UnitSpherical test = new UnitSpherical(1.0, 2.0);
        AssertHelper.assertEquals(1.0, test.getClock());
        AssertHelper.assertEquals(2.0, test.getCone());
    }

    /**
    * Tests initialization from {@link UnitCartesian} coordinates.
    */
    @Test
    public final void testFromUnitCartesian() {
        final double fortyFiveDegrees = Math.PI / 4.0;
        final double sixtyDegrees = Math.PI / 3.0;
        UnitSpherical test = new UnitSpherical(new UnitCartesian(1.0, Math.sqrt(3.0), -2.0));
        AssertHelper.assertEquals(sixtyDegrees, test.getClock(), Constants.Epsilon15);
        AssertHelper.assertEquals(fortyFiveDegrees + Math.PI / 2.0, test.getCone(), Constants.Epsilon15);
    }

    /**
    * Tests the equality and inequality methods and operators.
    */
    @Test
    public final void testEquality() {
        UnitSpherical first = new UnitSpherical(1.0, 2.0);
        UnitSpherical second = new UnitSpherical(1.0, 2.0);
        AssertHelper.assertEquals(first, second);
        AssertHelper.assertEquals(second, first);
        Assert.assertTrue(UnitSpherical.equals(first, second));
        Assert.assertTrue(UnitSpherical.equals(second, first));
        Assert.assertFalse(UnitSpherical.notEquals(first, second));
        Assert.assertFalse(UnitSpherical.notEquals(second, first));
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        second = new UnitSpherical(1.0, 2.1);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(UnitSpherical.equals(first, second));
        Assert.assertFalse(UnitSpherical.equals(second, first));
        Assert.assertTrue(UnitSpherical.notEquals(first, second));
        Assert.assertTrue(UnitSpherical.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
    }

    /**
    * Tests the {@link UnitSpherical#equalsEpsilon} method.
    */
    @Test
    public final void testEqualsEpsilon() {
        UnitSpherical first = new UnitSpherical(1e-1, 1e-2);
        UnitSpherical second = new UnitSpherical(1.1e-1, 1.1e-2);
        Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
        Assert.assertTrue(second.equalsEpsilon(first, 1e-2));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-3));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-4));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-5));
    }

    /**
    * Tests that the {@link UnitSpherical#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        UnitSpherical first = new UnitSpherical(0.1, 0.1);
        UnitSpherical second = new UnitSpherical(0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0.0));
    }

    /**
    * Tests to ensure the equality fails when comparing incorrect type.
    */
    @Test
    public final void testEqualityWithWrongType() {
        UnitSpherical first = new UnitSpherical(1.0, 2.0);
        Cartographic second = new Cartographic(1.0, 2.0, 3.0);
        // ReSharper disable once SuspiciousTypeConversion.Global
        Assert.assertFalse(first.equals(second));
    }

    /**
    * Tests that UnitSpherical.GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        UnitSpherical object1 = new UnitSpherical(1.0, 2.0);
        UnitSpherical object2 = new UnitSpherical(1.0, 2.0);
        UnitSpherical object3 = new UnitSpherical(1.0, 2.1);
        AssertHelper.assertEquals(object1.hashCode(), object2.hashCode());
        AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
    }

    /**
    * Tests ToString method
    */
    @Test
    public final void testToString() {
        StringBuilder builder = new StringBuilder();
        builder.append(DoubleHelper.toString((-Math.PI), CultureInfoHelper.getCurrentCulture()));
        builder.append(", ");
        builder.append(DoubleHelper.toString(Math.PI, CultureInfoHelper.getCurrentCulture()));
        UnitSpherical test = new UnitSpherical(-Math.PI, Math.PI);
        AssertHelper.assertEquals(builder.toString(), test.toString());
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