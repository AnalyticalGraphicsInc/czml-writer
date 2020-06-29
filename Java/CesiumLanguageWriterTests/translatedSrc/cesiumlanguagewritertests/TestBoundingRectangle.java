package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.IntHelper;
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
 * Tests the {@link BoundingRectangle} type.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBoundingRectangle {
    /**
    * Tests that initialization of and access to the type's values works correctly.
    */
    @Test
    public final void testHoldValue() {
        BoundingRectangle boundingRectangle0 = new BoundingRectangle();
        Assert.assertEquals(0, boundingRectangle0.getLeft(), 0d);
        Assert.assertEquals(0, boundingRectangle0.getBottom(), 0d);
        Assert.assertEquals(0, boundingRectangle0.getRight(), 0d);
        Assert.assertEquals(0, boundingRectangle0.getTop(), 0d);
        Assert.assertEquals(0, boundingRectangle0.getHeight(), 0d);
        Assert.assertEquals(0, boundingRectangle0.getWidth(), 0d);
        Assert.assertEquals(0, BoundingRectangle.getEmpty().getLeft(), 0d);
        Assert.assertEquals(0, BoundingRectangle.getEmpty().getBottom(), 0d);
        Assert.assertEquals(0, BoundingRectangle.getEmpty().getRight(), 0d);
        Assert.assertEquals(0, BoundingRectangle.getEmpty().getTop(), 0d);
        Assert.assertEquals(0, BoundingRectangle.getEmpty().getHeight(), 0d);
        Assert.assertEquals(0, BoundingRectangle.getEmpty().getWidth(), 0d);
        BoundingRectangle boundingRectangle1 = new BoundingRectangle(1D, 2D, 3D, 4D);
        Assert.assertEquals(1, boundingRectangle1.getLeft(), 0d);
        Assert.assertEquals(2, boundingRectangle1.getBottom(), 0d);
        Assert.assertEquals(3, boundingRectangle1.getRight(), 0d);
        Assert.assertEquals(4, boundingRectangle1.getTop(), 0d);
        Assert.assertEquals(2, boundingRectangle1.getHeight(), 0d);
        Assert.assertEquals(2, boundingRectangle1.getWidth(), 0d);
    }

    /**
    * Tests that construction resulting in a negative width throws the correct exception.
    */
    @Test
    public final void testInitializationFromBadElementsWidth() {
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, new Action() {
            public void invoke() {
                BoundingRectangle unused = new BoundingRectangle(2D, 2D, 1D, 3D);
            }
        });
    }

    /**
    * Tests that construction resulting in a negative height throws the correct exception.
    */
    @Test
    public final void testInitializationFromBadElementsHeight() {
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, new Action() {
            public void invoke() {
                BoundingRectangle unused = new BoundingRectangle(2D, 2D, 3D, 1D);
            }
        });
    }

    /**
    * Tests the equality and inequality methods and operators.
    */
    @Test
    public final void equalityTest() {
        BoundingRectangle boundingRectangle = new BoundingRectangle(1D, 2D, 3D, 4D);
        BoundingRectangle sameBoundingRectangle = new BoundingRectangle(1D, 2D, 3D, 4D);
        BoundingRectangle diffBoundingRectangle = new BoundingRectangle(2D, 3D, 4D, 5D);
        Assert.assertTrue(boundingRectangle.equalsType(sameBoundingRectangle));
        Assert.assertFalse(boundingRectangle.equalsType(diffBoundingRectangle));
        Assert.assertTrue(BoundingRectangle.equals(boundingRectangle, sameBoundingRectangle));
        Assert.assertTrue(BoundingRectangle.notEquals(boundingRectangle, diffBoundingRectangle));
        Object nonBoundingRectangleObject = new Object();
        Assert.assertFalse(boundingRectangle.equals(nonBoundingRectangleObject));
        Object boundingRectangleObject = boundingRectangle;
        Assert.assertTrue(boundingRectangle.equals(boundingRectangleObject));
    }

    /**
    * Tests the {@link BoundingRectangle#equalsEpsilon} method.
    */
    @Test
    public final void testEqualsEpsilon() {
        BoundingRectangle boundingRectangle = new BoundingRectangle(1000D, 2000D, 3000D, 4000D);
        BoundingRectangle similarBoundingRectangle = new BoundingRectangle(1010D, 2010D, 3010D, 4010D);
        Assert.assertTrue(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 1000D));
        Assert.assertTrue(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 100D));
        Assert.assertTrue(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 10D));
        Assert.assertFalse(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 1D));
    }

    /**
    * Tests that {@link BoundingRectangle#hashCode} returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        BoundingRectangle boundingRectangle1 = new BoundingRectangle(1D, 2D, 3D, 4D);
        BoundingRectangle boundingRectangle2 = new BoundingRectangle(1D, 2D, 3D, 4D);
        BoundingRectangle boundingRectangle3 = new BoundingRectangle(2D, 3D, 4D, 5D);
        Assert.assertEquals((int) boundingRectangle1.hashCode(), (int) boundingRectangle2.hashCode());
        AssertHelper.assertNotEqual(boundingRectangle1.hashCode(), boundingRectangle3.hashCode());
    }

    /**
    * Tests the {@link BoundingRectangle#toString} method.
    */
    @Test
    public final void testToString() {
        BoundingRectangle boundingRectangle = new BoundingRectangle(1D, 2D, 3D, 4D);
        final int val1 = 1;
        final int val2 = 2;
        final int val3 = 3;
        final int val4 = 4;
        final String sep = ", ";
        String expected = IntHelper.toString(val1, CultureInfoHelper.getCurrentCulture()) + sep + IntHelper.toString(val2, CultureInfoHelper.getCurrentCulture()) + sep
                + IntHelper.toString(val3, CultureInfoHelper.getCurrentCulture()) + sep + IntHelper.toString(val4, CultureInfoHelper.getCurrentCulture());
        Assert.assertEquals(expected, boundingRectangle.toString());
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