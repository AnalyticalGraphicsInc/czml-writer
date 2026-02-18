package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
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
public class TestCartographicExtent {
    @Test
    public final void testConstructorsAndProperties() {
        CartographicExtent extent = new CartographicExtent(-2.0, -1.0, 2.0, 1.0);
        AssertHelper.assertEquals(-2, extent.getWestLongitude());
        AssertHelper.assertEquals(-1, extent.getSouthLatitude());
        AssertHelper.assertEquals(2, extent.getEastLongitude());
        AssertHelper.assertEquals(1, extent.getNorthLatitude());
    }

    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEqualityAndGetHashCode() {
        CartographicExtent first = new CartographicExtent(-2.0, -1.0, 1.0, 2.0);
        CartographicExtent second = new CartographicExtent(-2.0, -1.0, 1.0, 2.0);
        AssertHelper.assertEquals(first, second);
        AssertHelper.assertEquals(second, first);
        Assert.assertTrue(CartographicExtent.equals(first, second));
        Assert.assertTrue(CartographicExtent.equals(second, first));
        Assert.assertFalse(CartographicExtent.notEquals(first, second));
        Assert.assertFalse(CartographicExtent.notEquals(second, first));
        Assert.assertTrue(first.equalsType(second));
        Assert.assertTrue(second.equalsType(first));
        AssertHelper.assertEquals(first.hashCode(), second.hashCode());
        second = new CartographicExtent(0.0, -1.0, 1.0, 2.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(CartographicExtent.equals(first, second));
        Assert.assertFalse(CartographicExtent.equals(second, first));
        Assert.assertTrue(CartographicExtent.notEquals(first, second));
        Assert.assertTrue(CartographicExtent.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(first.hashCode(), second.hashCode());
        second = new CartographicExtent(-2.0, 0.0, 1.0, 2.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(CartographicExtent.equals(first, second));
        Assert.assertFalse(CartographicExtent.equals(second, first));
        Assert.assertTrue(CartographicExtent.notEquals(first, second));
        Assert.assertTrue(CartographicExtent.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(first.hashCode(), second.hashCode());
        second = new CartographicExtent(-2.0, -1.0, 0.0, 2.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(CartographicExtent.equals(first, second));
        Assert.assertFalse(CartographicExtent.equals(second, first));
        Assert.assertTrue(CartographicExtent.notEquals(first, second));
        Assert.assertTrue(CartographicExtent.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(first.hashCode(), second.hashCode());
        second = new CartographicExtent(-2.0, -1.0, 1.0, 0.0);
        AssertHelper.assertNotEqual(first, second);
        AssertHelper.assertNotEqual(second, first);
        Assert.assertFalse(CartographicExtent.equals(first, second));
        Assert.assertFalse(CartographicExtent.equals(second, first));
        Assert.assertTrue(CartographicExtent.notEquals(first, second));
        Assert.assertTrue(CartographicExtent.notEquals(second, first));
        Assert.assertFalse(first.equalsType(second));
        Assert.assertFalse(second.equalsType(first));
        AssertHelper.assertNotEqual(first.hashCode(), second.hashCode());
    }

    @Test
    public final void testEqualsEpsilon() {
        CartographicExtent first = new CartographicExtent(1e-1, 1e-2, 1e-3, 1e-4);
        CartographicExtent second = new CartographicExtent(1.1e-1, 1.1e-2, 1.1e-3, 1.1e-4);
        Assert.assertTrue(second.equalsEpsilon(first, Constants.Epsilon1));
        Assert.assertTrue(second.equalsEpsilon(first, Constants.Epsilon2));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon3));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon4));
        Assert.assertFalse(second.equalsEpsilon(first, Constants.Epsilon5));
    }

    /**
    * Tests that the {@link CartographicExtent#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        CartographicExtent first = new CartographicExtent(0.1, 0.1, 0.1, 0.1);
        CartographicExtent second = new CartographicExtent(0.1, 0.1, 0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0.0));
    }

    @Test
    public final void testIsInsideExtent() {
        CartographicExtent box = new CartographicExtent(-2.0, -1.0, 2.0, 1.0);
        AssertHelper.assertEquals(-2, box.getWestLongitude());
        AssertHelper.assertEquals(-1, box.getSouthLatitude());
        AssertHelper.assertEquals(2, box.getEastLongitude());
        AssertHelper.assertEquals(1, box.getNorthLatitude());
        // Check corners.
        Assert.assertTrue(box.isInsideExtent(-2.0, -1.0));
        Assert.assertTrue(box.isInsideExtent(-2.0, 1.0));
        Assert.assertTrue(box.isInsideExtent(2.0, -1.0));
        Assert.assertTrue(box.isInsideExtent(2.0, 1.0));
        // Check edge.
        Assert.assertTrue(box.isInsideExtent(-2.0, 0.0));
        Assert.assertTrue(box.isInsideExtent(0.0, -1.0));
        Assert.assertTrue(box.isInsideExtent(2.0, 0.0));
        Assert.assertTrue(box.isInsideExtent(0.0, 1.0));
        // Check inside.
        Assert.assertTrue(box.isInsideExtent(-1.5, 0.0));
        Assert.assertTrue(box.isInsideExtent(0.0, -0.5));
        Assert.assertTrue(box.isInsideExtent(1.5, 0.0));
        Assert.assertTrue(box.isInsideExtent(0.0, 0.5));
        // Check outside.
        Assert.assertFalse(box.isInsideExtent(-3.0, 0.0));
        Assert.assertFalse(box.isInsideExtent(0.0, -1.5));
        Assert.assertFalse(box.isInsideExtent(3.0, 0.0));
        Assert.assertFalse(box.isInsideExtent(0.0, 1.5));
    }

    /**
    * Tests the union operation where the other extent is null.
    */
    @Test
    public final void throwsWhenUnionWithNullExtent() {
        final CartographicExtent box = new CartographicExtent(-2.0, -1.0, 2.0, 1.0);
        ArgumentNullException exception = AssertHelper.<ArgumentNullException> assertThrows(new TypeLiteral<ArgumentNullException>() {}, Action.of(() -> {
            // ReSharper disable once AssignNullToNotNullAttribute
            CartographicExtent unused = box.union(null);
        }));
        AssertHelper.assertEquals("other", exception.getParamName());
    }

    @Test
    public final void testUnion() {
        CartographicExtent box = new CartographicExtent(-2.0, -1.0, 1.0, 1.3);
        AssertHelper.assertEquals(-2, box.getWestLongitude());
        AssertHelper.assertEquals(-1, box.getSouthLatitude());
        AssertHelper.assertEquals(1, box.getEastLongitude());
        AssertHelper.assertEquals(1.3, box.getNorthLatitude());
        CartographicExtent anotherBox = new CartographicExtent(0.0, 0.0, 1.0, 1.0);
        CartographicExtent firstCombo = box.union(anotherBox);
        AssertHelper.assertEquals(-2, firstCombo.getWestLongitude());
        AssertHelper.assertEquals(-1, firstCombo.getSouthLatitude());
        AssertHelper.assertEquals(1, firstCombo.getEastLongitude());
        AssertHelper.assertEquals(1.3, firstCombo.getNorthLatitude());
        CartographicExtent yetAnotherBox = new CartographicExtent(-2.0, -1.3, 1.0, 1.0);
        CartographicExtent secondCombo = box.union(yetAnotherBox);
        AssertHelper.assertEquals(-2, secondCombo.getWestLongitude());
        AssertHelper.assertEquals(-1.3, secondCombo.getSouthLatitude(), Constants.Epsilon8);
        AssertHelper.assertEquals(1, secondCombo.getEastLongitude());
        AssertHelper.assertEquals(1.3, secondCombo.getNorthLatitude());
    }

    /**
    * Testing the class IsInside family of functions.
    */
    @Test
    public final void tesIsInsideExtentEpsilon() {
        final double west = -2.0;
        final double south = -1.0;
        final double east = 1.0;
        final double north = 1.5;
        CartographicExtent extent = new CartographicExtent(west, south, east, north);
        Assert.assertTrue(extent.isInsideExtent(0.5, 0.5));
        Assert.assertFalse(extent.isInsideExtent(0.5, Constants.HalfPi));
        Assert.assertFalse(extent.isInsideExtent(0.3, -3.0));
        Assert.assertFalse(extent.isInsideExtent(-3.0, 0.5));
        Assert.assertFalse(extent.isInsideExtent(3.0, 0.5));
        // way out west
        Assert.assertTrue(extent.isInsideExtent(west, 0.0));
        // move it
        Assert.assertFalse(extent.isInsideExtent(west - Constants.Epsilon10, 0.0));
        // east
        Assert.assertTrue(extent.isInsideExtent(east, 0.0));
        // move it
        Assert.assertFalse(extent.isInsideExtent(east + Constants.Epsilon10, 0.0));
        // north
        Assert.assertTrue(extent.isInsideExtent(0.0, north));
        // move it
        Assert.assertFalse(extent.isInsideExtent(0.0, north + Constants.Epsilon10));
        // south
        Assert.assertTrue(extent.isInsideExtent(0.0, south));
        // move it
        Assert.assertFalse(extent.isInsideExtent(0.0, south - Constants.Epsilon10));
    }

    @Test
    public final void testToString() {
        CartographicExtent extent = new CartographicExtent(-2.0, -1.0, 1.0, 2.0);
        AssertHelper.assertEquals("-2, -1, 1, 2", extent.toString());
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