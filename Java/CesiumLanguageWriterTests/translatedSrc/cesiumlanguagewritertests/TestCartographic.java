package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
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
public class TestCartographic {
    /**
    * Tests that initialization of and access to the type's values works correctly.
    */
    @Test
    public final void testHoldValue() {
        Cartographic test = new Cartographic(1.0, 2.0, 3.0);
        AssertHelper.assertEquals(1.0, test.getLongitude());
        AssertHelper.assertEquals(2.0, test.getLatitude());
        AssertHelper.assertEquals(3.0, test.getHeight());
    }

    /**
    * Tests the equality and inequality methods and operators.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEquality() {
        Cartographic first = new Cartographic(1.0, 2.0, 3.0);
        Cartographic second = new Cartographic(1.0, 2.0, 3.0);
        AssertHelper.assertEquals(first, second);
        AssertHelper.assertEquals(second, first);
        Assert.assertTrue(Cartographic.equals(first, second));
        Assert.assertTrue(Cartographic.equals(second, first));
        Assert.assertFalse(Cartographic.notEquals(first, second));
        Assert.assertFalse(Cartographic.notEquals(second, first));
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        second = new Cartographic(1.0, 2.1, 3.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(Cartographic.equals(first, second));
        Assert.assertFalse(Cartographic.equals(second, first));
        Assert.assertTrue(Cartographic.notEquals(first, second));
        Assert.assertTrue(Cartographic.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
    }

    @Test
    public final void testEqualsEpsilon() {
        Cartographic first = new Cartographic(1e-1, 1e-2, 1e-3);
        Cartographic second = new Cartographic(1.1e-1, 1.1e-2, 1.1e-3);
        Assert.assertTrue(second.equalsEpsilon(first, Constants.Epsilon1));
        Assert.assertTrue(second.equalsEpsilon(first, Constants.Epsilon2));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon3));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon4));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon5));
    }

    /**
    * Tests that the {@link Cartographic#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        Cartographic first = new Cartographic(0.1, 0.1, 0.1);
        Cartographic second = new Cartographic(0.1, 0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0.0));
    }

    /**
    * Tests to ensure the equality fails when comparing incorrect type.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEqualityWithWrongType() {
        Cartographic first = new Cartographic(1.0, 2.0, 3.0);
        Cartesian second = new Cartesian(1.0, 2.0, 3.0);
        Assert.assertFalse(first.equals(second));
    }

    /**
    * Tests that GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        Cartographic object1 = new Cartographic(1.0, 2.0, 3.0);
        Cartographic object2 = new Cartographic(1.0, 2.0, 3.0);
        Cartographic object3 = new Cartographic(1.0, 2.0, 3.1);
        AssertHelper.assertEquals(object1.hashCode(), object2.hashCode());
        AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
    }

    @Test
    public final void testToString() {
        final double longitude = Math.PI;
        final double latitude = Constants.HalfPi;
        final double height = 1.2;
        Cartographic test = new Cartographic(longitude, latitude, height);
        String expected = StringHelper.format(CultureInfoHelper.getCurrentCulture(), "{0}, {1}, {2}", longitude, latitude, height);
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