package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.ExpectedExceptionHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.IntHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 *  
 Tests the {@link BoundingRectangle} type.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBoundingRectangle {
    /**
    *  
    Tests that initialization of and access to the type's values works correctly.
    

    */
    @Test
    public final void testHoldValue() {
        BoundingRectangle boundingRectangle0 = new BoundingRectangle();
        Assert.assertEquals(boundingRectangle0.getLeft(), 0, 0d);
        Assert.assertEquals(boundingRectangle0.getBottom(), 0, 0d);
        Assert.assertEquals(boundingRectangle0.getRight(), 0, 0d);
        Assert.assertEquals(boundingRectangle0.getTop(), 0, 0d);
        Assert.assertEquals(boundingRectangle0.getHeight(), 0, 0d);
        Assert.assertEquals(boundingRectangle0.getWidth(), 0, 0d);
        Assert.assertEquals(BoundingRectangle.getEmpty().getLeft(), 0, 0d);
        Assert.assertEquals(BoundingRectangle.getEmpty().getBottom(), 0, 0d);
        Assert.assertEquals(BoundingRectangle.getEmpty().getRight(), 0, 0d);
        Assert.assertEquals(BoundingRectangle.getEmpty().getTop(), 0, 0d);
        Assert.assertEquals(BoundingRectangle.getEmpty().getHeight(), 0, 0d);
        Assert.assertEquals(BoundingRectangle.getEmpty().getWidth(), 0, 0d);
        BoundingRectangle boundingRectangle1 = new BoundingRectangle(1D, 2D, 3D, 4D);
        Assert.assertEquals(boundingRectangle1.getLeft(), 1, 0d);
        Assert.assertEquals(boundingRectangle1.getBottom(), 2, 0d);
        Assert.assertEquals(boundingRectangle1.getRight(), 3, 0d);
        Assert.assertEquals(boundingRectangle1.getTop(), 4, 0d);
        Assert.assertEquals(boundingRectangle1.getHeight(), 2, 0d);
        Assert.assertEquals(boundingRectangle1.getWidth(), 2, 0d);
    }

    /**
    *  
    Tests that construction resulting in a negative width throws the correct exception.
    

    */
    @Test
    public final void testInitializationFromBadElementsWidth() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentException.class);
        BoundingRectangle boundingRectangle = new BoundingRectangle(2D, 2D, 1D, 3D);
    }

    /**
    *  
    Tests that construction resulting in a negative height throws the correct exception.
    

    */
    @Test
    public final void testInitializationFromBadElementsHeight() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentException.class);
        BoundingRectangle boundingRectangle = new BoundingRectangle(2D, 2D, 3D, 1D);
    }

    /**
    *  
    Tests the equality and inequality methods and operators.
    

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
    *  
    Tests the {@link BoundingRectangle#equalsEpsilon} method.
    

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
    *  
    Tests that {@link BoundingRectangle#hashCode} returns something at least reasonably random.
    

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
    *  
    Tests the {@link BoundingRectangle#toString} method.
    

    */
    @Test
    public final void testToString() {
        BoundingRectangle boundingRectangle = new BoundingRectangle(1D, 2D, 3D, 4D);
        int val1 = 1;
        int val2 = 2;
        int val3 = 3;
        int val4 = 4;
        String sep = ", ";
        String result = IntHelper.toString(val1, CultureInfoHelper.getCurrentCulture()) + sep + IntHelper.toString(val2, CultureInfoHelper.getCurrentCulture()) + sep
                + IntHelper.toString(val3, CultureInfoHelper.getCurrentCulture()) + sep + IntHelper.toString(val4, CultureInfoHelper.getCurrentCulture());
        Assert.assertEquals(boundingRectangle.toString(), result);
    }

    private final TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }

    private final ExpectedException rule$expectedException = ExpectedException.none();

    @Rule
    public ExpectedException getRule$expectedException() {
        return rule$expectedException;
    }
}