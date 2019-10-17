package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 * A simple test making sure the CartographicExtent class works
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCartographicExtent {
    /**
    * Testing the class
    */
    @Test
    public final void testExtentClass() {
        CartographicExtent box = new CartographicExtent(-2D, -1D, 1D, 2D);
        Assert.assertEquals(-2, box.getWestLongitude(), 0d);
        Assert.assertEquals(-1, box.getSouthLatitude(), 0d);
        Assert.assertEquals(1, box.getEastLongitude(), 0d);
        Assert.assertEquals(2, box.getNorthLatitude(), 0d);
        Assert.assertTrue(box.isInsideExtent(0.5, 0.5));
        Assert.assertFalse(box.isInsideExtent(0.5, 3D));
        Assert.assertFalse(box.isInsideExtent(0.3, -3D));
        Assert.assertFalse(box.isInsideExtent(-3D, 0.5));
        Assert.assertFalse(box.isInsideExtent(3D, 0.5));
        CartographicExtent anotherBox = new CartographicExtent(0D, 0D, 1D, 1D);
        CartographicExtent firstCombo = box.union(anotherBox);
        Assert.assertEquals(-2, firstCombo.getWestLongitude(), 0d);
        Assert.assertEquals(-1, firstCombo.getSouthLatitude(), 0d);
        Assert.assertEquals(1, firstCombo.getEastLongitude(), 0d);
        Assert.assertEquals(2, firstCombo.getNorthLatitude(), 0d);
        CartographicExtent yetAnotherBox = new CartographicExtent(-2D, -2D, 1D, 1D);
        CartographicExtent secondCombo = box.union(yetAnotherBox);
        Assert.assertEquals(-2, secondCombo.getWestLongitude(), 0d);
        Assert.assertEquals(-2, secondCombo.getSouthLatitude(), 0d);
        Assert.assertEquals(1, secondCombo.getEastLongitude(), 0d);
        Assert.assertEquals(2, secondCombo.getNorthLatitude(), 0d);
    }

    /**
    * Tests the {@link CartographicExtent#equalsEpsilon} method.
    */
    @Test
    public final void testEqualsEpsilon() {
        CartographicExtent first = new CartographicExtent(1e-1, 1e-2, 1e-3, 1e-4);
        CartographicExtent second = new CartographicExtent(1.1e-1, 1.1e-2, 1.1e-3, 1.1e-4);
        Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
        Assert.assertTrue(second.equalsEpsilon(first, 1e-2));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-3));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-4));
        Assert.assertFalse(second.equalsEpsilon(first, 1e-5));
    }

    /**
    * Tests that the {@link CartographicExtent#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    */
    @Test
    public final void testEqualsEpsilonExact() {
        CartographicExtent first = new CartographicExtent(0.1, 0.1, 0.1, 0.1);
        CartographicExtent second = new CartographicExtent(0.1, 0.1, 0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0D));
    }

    @Test
    public final void testToString() {
        CartographicExtent extent = new CartographicExtent(-2D, -1D, 1D, 2D);
        Assert.assertEquals("-2, -1, 1, 2", extent.toString());
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}