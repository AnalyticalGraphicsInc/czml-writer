package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
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

@SuppressWarnings({
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
        AssertHelper.assertEquals(0, boundingRectangle0.getLeft());
        AssertHelper.assertEquals(0, boundingRectangle0.getBottom());
        AssertHelper.assertEquals(0, boundingRectangle0.getRight());
        AssertHelper.assertEquals(0, boundingRectangle0.getTop());
        AssertHelper.assertEquals(0, boundingRectangle0.getHeight());
        AssertHelper.assertEquals(0, boundingRectangle0.getWidth());
        AssertHelper.assertEquals(0, BoundingRectangle.getEmpty().getLeft());
        AssertHelper.assertEquals(0, BoundingRectangle.getEmpty().getBottom());
        AssertHelper.assertEquals(0, BoundingRectangle.getEmpty().getRight());
        AssertHelper.assertEquals(0, BoundingRectangle.getEmpty().getTop());
        AssertHelper.assertEquals(0, BoundingRectangle.getEmpty().getHeight());
        AssertHelper.assertEquals(0, BoundingRectangle.getEmpty().getWidth());
        BoundingRectangle boundingRectangle1 = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        AssertHelper.assertEquals(1, boundingRectangle1.getLeft());
        AssertHelper.assertEquals(2, boundingRectangle1.getBottom());
        AssertHelper.assertEquals(3, boundingRectangle1.getRight());
        AssertHelper.assertEquals(4, boundingRectangle1.getTop());
        AssertHelper.assertEquals(2, boundingRectangle1.getHeight());
        AssertHelper.assertEquals(2, boundingRectangle1.getWidth());
    }

    /**
    * Tests that construction resulting in a negative width throws the correct exception.
    */
    @Test
    public final void testInitializationFromBadElementsWidth() {
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            BoundingRectangle unused = new BoundingRectangle(2.0, 2.0, 1.0, 3.0);
        }));
    }

    /**
    * Tests that construction resulting in a negative height throws the correct exception.
    */
    @Test
    public final void testInitializationFromBadElementsHeight() {
        AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            BoundingRectangle unused = new BoundingRectangle(2.0, 2.0, 3.0, 1.0);
        }));
    }

    /**
    * Tests the equality and inequality methods and operators.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void equalityTest() {
        BoundingRectangle boundingRectangle = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        BoundingRectangle sameBoundingRectangle = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        BoundingRectangle diffBoundingRectangle = new BoundingRectangle(2.0, 3.0, 4.0, 5.0);
        Assert.assertTrue(boundingRectangle.equalsType(sameBoundingRectangle));
        Assert.assertFalse(boundingRectangle.equalsType(diffBoundingRectangle));
        Assert.assertTrue(BoundingRectangle.equals(boundingRectangle, sameBoundingRectangle));
        Assert.assertTrue(BoundingRectangle.notEquals(boundingRectangle, diffBoundingRectangle));
        Object nonBoundingRectangleObject = new Object();
        Assert.assertFalse(boundingRectangle.equals(nonBoundingRectangleObject));
        Object boundingRectangleObject = boundingRectangle;
        Assert.assertTrue(boundingRectangle.equals(boundingRectangleObject));
    }

    @Test
    public final void testEqualsEpsilon() {
        BoundingRectangle boundingRectangle = new BoundingRectangle(1000.0, 2000.0, 3000.0, 4000.0);
        BoundingRectangle similarBoundingRectangle = new BoundingRectangle(1010.0, 2010.0, 3010.0, 4010.0);
        Assert.assertTrue(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 1000.0));
        Assert.assertTrue(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 100.0));
        Assert.assertTrue(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 10.0));
        Assert.assertFalse(boundingRectangle.equalsEpsilon(similarBoundingRectangle, 1.0));
    }

    /**
    * Tests that {@link BoundingRectangle#hashCode} returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        BoundingRectangle boundingRectangle1 = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        BoundingRectangle boundingRectangle2 = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        BoundingRectangle boundingRectangle3 = new BoundingRectangle(2.0, 3.0, 4.0, 5.0);
        AssertHelper.assertEquals(boundingRectangle1.hashCode(), boundingRectangle2.hashCode());
        AssertHelper.assertNotEqual(boundingRectangle1.hashCode(), boundingRectangle3.hashCode());
    }

    @Test
    public final void testToString() {
        BoundingRectangle boundingRectangle = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        final int val1 = 1;
        final int val2 = 2;
        final int val3 = 3;
        final int val4 = 4;
        final String sep = ", ";
        String expected = IntHelper.toString(val1, CultureInfoHelper.getCurrentCulture()) + sep + IntHelper.toString(val2, CultureInfoHelper.getCurrentCulture()) + sep
                + IntHelper.toString(val3, CultureInfoHelper.getCurrentCulture()) + sep + IntHelper.toString(val4, CultureInfoHelper.getCurrentCulture());
        AssertHelper.assertEquals(expected, boundingRectangle.toString());
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