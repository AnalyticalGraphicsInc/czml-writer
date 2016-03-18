package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.ExpectedExceptionHelper;
import agi.foundation.compatibility.IEquatable;
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
 Tests the  {@link Cartographic} type.
 

 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCartographic {
	/**
	 *  
	Tests that initialization of and access to the type's values works correctly.
	

	 */
	@Test
	public final void testHoldValue() {
		Cartographic test = new Cartographic(1.0, 2.0, 3.0);
		Assert.assertEquals(1.0, test.getLongitude(), 0d);
		Assert.assertEquals(2.0, test.getLatitude(), 0d);
		Assert.assertEquals(3.0, test.getHeight(), 0d);
	}

	/**
	 *  
	Tests initialization from an array of 3 coordinates works correctly.
	

	 */
	@Test
	public final void testFromArray() {
		double[] values = {
				2.0,
				3.0,
				6.0
		};
		Cartographic test = new Cartographic(values);
		Assert.assertEquals((int) values.length, (int) test.getLength());
		Assert.assertEquals(test.getLongitude(), test.get(0), 0d);
		Assert.assertEquals(test.getLatitude(), test.get(1), 0d);
		Assert.assertEquals(test.getHeight(), test.get(2), 0d);
	}

	/**
	 *  
	Tests the equality and inequality methods and operators.
	

	 */
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

	/**
	 *  
	Tests the  {@link Cartesian#equalsEpsilon} method.
	

	 */
	@Test
	public final void testEqualsEpsilon() {
		Cartographic first = new Cartographic(1e-1, 1e-2, 1e-3);
		Cartographic second = new Cartographic(1.1e-1, 1.1e-2, 1.1e-3);
		Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
		Assert.assertTrue(second.equalsEpsilon(first, 1e-2));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-3));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-4));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-5));
	}

	/**
	 *  
	Tests to ensure the equality fails when comparing incorrect type.
	

	 */
	@Test
	public final void testEqualityWithWrongType() {
		Cartographic first = new Cartographic(1.0, 2.0, 3.0);
		Cartesian second = new Cartesian(1.0, 2.0, 3.0);
		Assert.assertFalse(first.equals(second));
	}

	/**
	 *  
	Tests that Cartographic.GetHashCode returns something at least reasonably random.
	

	 */
	@Test
	public final void testGetHashCode() {
		Cartographic object1 = new Cartographic(1.0, 2.0, 3.0);
		Cartographic object2 = new Cartographic(1.0, 2.0, 3.0);
		Cartographic object3 = new Cartographic(1.0, 2.0, 3.1);
		Assert.assertEquals((int) object1.hashCode(), (int) object2.hashCode());
		AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
	}

	/**
	 *  
	Tests that construction from a null array of doubles throws the correct exception.
	

	 */
	@Test
	public final void testInitializationFromNull() {
		ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentNullException.class);
		double[] array = null;
		Cartographic first = new Cartographic(array, 0);
	}

	/**
	 *  
	Tests that construction from an array of doubles with an incorrect length throws the correct exception.
	

	 */
	@Test
	public final void testInitializationFromBadArray() {
		ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentOutOfRangeException.class);
		double[] array = new double[2];
		Cartographic first = new Cartographic(array, 0);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test
	public final void testIndexTooHigh() {
		ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentOutOfRangeException.class);
		Cartographic first = new Cartographic(1.0, 2.0, 3.0);
		double bad = first.get(3);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test
	public final void testIndexTooLow() {
		ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentOutOfRangeException.class);
		Cartographic first = new Cartographic(1.0, 2.0, 3.0);
		double bad = first.get(-1);
	}

	/**
	 *  
	Tests ToString method
	

	 */
	@Test
	public final void testToString() {
		StringBuilder s = new StringBuilder(80);
		s.append(DoubleHelper.toString((Math.PI), CultureInfoHelper.getCurrentCulture()));
		s.append(", ");
		s.append(DoubleHelper.toString(Constants.HalfPi, CultureInfoHelper.getCurrentCulture()));
		s.append(", ");
		double val = 1.2;
		s.append(DoubleHelper.toString(val, CultureInfoHelper.getCurrentCulture()));
		Cartographic test = new Cartographic(Math.PI, Constants.HalfPi, val);
		Assert.assertEquals(s.toString(), test.toString());
	}

	private TestContextRule rule$testContext = new TestContextRule();

	@Rule
	public TestContextRule getRule$testContext() {
		return rule$testContext;
	}

	private ExpectedException rule$expectedException = ExpectedException.none();

	@Rule
	public ExpectedException getRule$expectedException() {
		return rule$expectedException;
	}
}