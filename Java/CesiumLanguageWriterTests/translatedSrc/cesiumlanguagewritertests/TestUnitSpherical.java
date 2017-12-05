package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 *  
 Tests the {@link UnitSpherical} type.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUnitSpherical {
    /**
    *  
    Tests that initialization of and access to the type's values works correctly.
    

    */
    @Test
    public final void testHoldValue() {
        UnitSpherical test = new UnitSpherical(1.0, 2.0);
        Assert.assertEquals(1.0, test.getClock(), 0d);
        Assert.assertEquals(2.0, test.getCone(), 0d);
    }

    /**
    *  
    Tests initialization from {@link UnitCartesian} coordinates.
    

    */
    @Test
    public final void testFromUnitCartesian() {
        double fortyFiveDegrees = Math.PI / 4.0;
        double sixtyDegrees = Math.PI / 3.0;
        UnitSpherical test = new UnitSpherical(new UnitCartesian(1.0, Math.sqrt(3.0), -2.0));
        Assert.assertEquals(sixtyDegrees, test.getClock(), Constants.Epsilon15);
        Assert.assertEquals(fortyFiveDegrees + Math.PI / 2.0, test.getCone(), Constants.Epsilon15);
    }

    /**
    *  
    Tests the equality and inequality methods and operators.
    

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
    *  
    Tests the {@link UnitSpherical#equalsEpsilon} method.
    

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
    *  
    Tests thats the {@link UnitSpherical#equalsEpsilon} method returns true
    when the difference is exactly epsilon.
    

    */
    @Test
    public final void testEqualsEpsilonExact() {
        UnitSpherical first = new UnitSpherical(0.1, 0.1);
        UnitSpherical second = new UnitSpherical(0.1, 0.1);
        Assert.assertTrue(second.equalsEpsilon(first, 0D));
    }

    /**
    *  
    Tests to ensure the equality fails when comparing incorrect type.
    

    */
    @Test
    public final void testEqualityWithWrongType() {
        UnitSpherical first = new UnitSpherical(1.0, 2.0);
        Cartographic second = new Cartographic(1.0, 2.0, 3.0);
        Assert.assertFalse(first.equals(second));
    }

    /**
    *  
    Tests that UnitSpherical.GetHashCode returns something at least reasonably random.
    

    */
    @Test
    public final void testGetHashCode() {
        UnitSpherical object1 = new UnitSpherical(1.0, 2.0);
        UnitSpherical object2 = new UnitSpherical(1.0, 2.0);
        UnitSpherical object3 = new UnitSpherical(1.0, 2.1);
        Assert.assertEquals((int) object1.hashCode(), (int) object2.hashCode());
        AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
    }

    /**
    *  
    Tests ToString method
    

    */
    @Test
    public final void testToString() {
        StringBuilder s = new StringBuilder(80);
        s.append(DoubleHelper.toString((-Math.PI), CultureInfoHelper.getCurrentCulture()));
        s.append(", ");
        s.append(DoubleHelper.toString(Math.PI, CultureInfoHelper.getCurrentCulture()));
        UnitSpherical test = new UnitSpherical(-Math.PI, Math.PI);
        Assert.assertEquals(s.toString(), test.toString());
    }

    private final TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}