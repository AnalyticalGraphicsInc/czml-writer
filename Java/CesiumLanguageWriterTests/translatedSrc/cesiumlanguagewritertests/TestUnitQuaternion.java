package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
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
 Tests the  {@link UnitQuaternion} type.
 

 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUnitQuaternion {
	/**
	 *  
	Tests that initialization of and access to the type's values works correctly.
	

	 */
	@Test
	public final void testHoldValue() {
		UnitQuaternion test = new UnitQuaternion(2.0, 4.0, 7.0, 10.0);
		Assert.assertEquals(2.0 / 13.0, test.getW(), 0d);
		Assert.assertEquals(4.0 / 13.0, test.getX(), 0d);
		Assert.assertEquals(7.0 / 13.0, test.getY(), 0d);
		Assert.assertEquals(10.0 / 13.0, test.getZ(), 0d);
	}

	/**
	 *  
	Tests initialization from coordinates.
	

	 */
	@Test
	public final void testInitializeAndReturnMagnitude() {
		double magnitude = 0D;
		double[] out$magnitude_0 = {
			0D
		};
		UnitQuaternion test = new UnitQuaternion(2.0, 4.0, 7.0, 10.0, out$magnitude_0);
		magnitude = out$magnitude_0[0];
		Assert.assertEquals(2.0 / 13.0, test.getW(), Constants.Epsilon15);
		Assert.assertEquals(4.0 / 13.0, test.getX(), Constants.Epsilon15);
		Assert.assertEquals(7.0 / 13.0, test.getY(), Constants.Epsilon15);
		Assert.assertEquals(10.0 / 13.0, test.getZ(), Constants.Epsilon15);
		Assert.assertEquals(13.0, magnitude, Constants.Epsilon15);
	}

	/**
	 *  
	Tests initialization from a  {@link Matrix3By3} rotation.
	

	 */
	@Test
	public final void testFromMatrix3By3() {
		double angle = Math.PI / 6;
		// 60 degrees.
		// Test "type == 0:"
		_TestFromMatrix3By3(angle, new Cartesian(2.0, 3.0, 6.0));
		//rotation about 2/7, 3/7, 6/7 vector.
		angle = 2 * Math.PI / 3;
		// 120 degrees.
		// Test "type == 1:"
		_TestFromMatrix3By3(angle, new Cartesian(6.0, -3.0, -2.0));
		// rotation about 6/7, -3/7, -2/7 vector.
		// Test "type == 2:"
		_TestFromMatrix3By3(angle, new Cartesian(-2.0, -3.0, 6.0));
		// rotation about -2/7, -3/7, 6/7 vector.
		// Test "type == 3:"
		_TestFromMatrix3By3(angle, new Cartesian(-2.0, 6.0, -3.0));
		// rotation about -2/7, 6/7, -3/7 vector.
	}

	/**
	 *  
	Tests the equality and inequality methods and operators.
	

	 */
	@Test
	public final void testEquality() {
		UnitQuaternion first = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
		UnitQuaternion second = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
		AssertHelper.assertEquals(first, second);
		AssertHelper.assertEquals(second, first);
		Assert.assertTrue(UnitQuaternion.equals(first, second));
		Assert.assertTrue(UnitQuaternion.equals(second, first));
		Assert.assertFalse(UnitQuaternion.notEquals(first, second));
		Assert.assertFalse(UnitQuaternion.notEquals(second, first));
		Assert.assertTrue(first.equalsType(second));
		Assert.assertTrue(second.equalsType(first));
		second = new UnitQuaternion(1.1, 2.0, 3.0, 4.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(UnitQuaternion.equals(first, second));
		Assert.assertFalse(UnitQuaternion.equals(second, first));
		Assert.assertTrue(UnitQuaternion.notEquals(first, second));
		Assert.assertTrue(UnitQuaternion.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		second = new UnitQuaternion(1.0, 2.2, 3.0, 4.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(UnitQuaternion.equals(first, second));
		Assert.assertFalse(UnitQuaternion.equals(second, first));
		Assert.assertTrue(UnitQuaternion.notEquals(first, second));
		Assert.assertTrue(UnitQuaternion.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		second = new UnitQuaternion(1.0, 2.0, 3.3, 4.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(UnitQuaternion.equals(first, second));
		Assert.assertFalse(UnitQuaternion.equals(second, first));
		Assert.assertTrue(UnitQuaternion.notEquals(first, second));
		Assert.assertTrue(UnitQuaternion.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		second = new UnitQuaternion(1.0, 2.0, 3.3, 4.4);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(UnitQuaternion.equals(first, second));
		Assert.assertFalse(UnitQuaternion.equals(second, first));
		Assert.assertTrue(UnitQuaternion.notEquals(first, second));
		Assert.assertTrue(UnitQuaternion.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
	}

	/**
	 *  
	Tests the  {@link UnitQuaternion#equalsEpsilon} method.
	

	 */
	@Test
	public final void testEqualsEpsilon() {
		UnitQuaternion first = new UnitQuaternion(1.0, 1.0, 1.0, 1.0);
		UnitQuaternion second = new UnitQuaternion(0.99, 1.0, 1.0, 1.01);
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
		UnitQuaternion first = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
		Cartographic second = new Cartographic(1.0, 2.0, 3.0);
		Assert.assertFalse(first.equals(second));
	}

	/**
	 *  
	Tests that rotation by an invalid value produces an
	{@link ArithmeticException}.
	

	 */
	@Test
	public final void testFromInfinity() {
		ExpectedExceptionHelper.expectException(getRule$expectedException(), ArithmeticException.class);
		UnitQuaternion first = new UnitQuaternion(Double.POSITIVE_INFINITY, 0.0, 0.0, 0.0);
	}

	/**
	 *  
	Tests the  {@link UnitQuaternion#conjugate} method.
	

	 */
	@Test
	public final void testConjugate() {
		UnitQuaternion original = new UnitQuaternion(2.0, 4.0, 7.0, 10.0);
		UnitQuaternion conjugate = original.conjugate();
		Assert.assertEquals(2.0 / 13.0, conjugate.getW(), 0d);
		Assert.assertEquals(-4.0 / 13.0, conjugate.getX(), 0d);
		Assert.assertEquals(-7.0 / 13.0, conjugate.getY(), 0d);
		Assert.assertEquals(-10.0 / 13.0, conjugate.getZ(), 0d);
	}

	/**
	 *  
	Tests <code>Identity</code> ({@link UnitQuaternion#getIdentity get}).
	

	 */
	@Test
	public final void testIdentity() {
		UnitQuaternion identity = UnitQuaternion.getIdentity();
		Assert.assertEquals(1.0, identity.getW(), 0d);
		Assert.assertEquals(0.0, identity.getX(), 0d);
		Assert.assertEquals(0.0, identity.getY(), 0d);
		Assert.assertEquals(0.0, identity.getZ(), 0d);
	}

	/**
	 *  
	Tests the <code>IsUndefined</code> ({@link UnitQuaternion#getIsUndefined get}) method.
	

	 */
	@Test
	public final void testIsUndefined() {
		Assert.assertFalse(new UnitQuaternion(1.0, 1.0, 1.0, 1.0).getIsUndefined());
		Assert.assertTrue(UnitQuaternion.getUndefined().getIsUndefined());
		Assert.assertTrue(new UnitQuaternion(Double.NaN, 1.0, 1.0, 1.0).getIsUndefined());
		Assert.assertTrue(new UnitQuaternion(1.0, Double.NaN, 1.0, 1.0).getIsUndefined());
		Assert.assertTrue(new UnitQuaternion(1.0, 1.0, Double.NaN, 1.0).getIsUndefined());
		Assert.assertTrue(new UnitQuaternion(1.0, 1.0, 1.0, Double.NaN).getIsUndefined());
	}

	final private void _TestFromMatrix3By3(double angle, Cartesian axis) {
		Cartesian unit = Cartesian.toCartesian(axis.normalize());
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		double w = c;
		double x = s * unit.getX();
		double y = s * unit.getY();
		double z = s * unit.getZ();
		UnitQuaternion quaternion = new UnitQuaternion(w, x, y, z);
		Matrix3By3 matrix = new Matrix3By3(quaternion);
		UnitQuaternion test = new UnitQuaternion(matrix);
		Assert.assertEquals(w, quaternion.getW(), Constants.Epsilon15);
		Assert.assertEquals(x, quaternion.getX(), Constants.Epsilon15);
		Assert.assertEquals(y, quaternion.getY(), Constants.Epsilon15);
		Assert.assertEquals(z, quaternion.getZ(), Constants.Epsilon15);
	}

	/**
	 *  
	Tests negation of a set of coordinates.
	

	 */
	@Test
	public final void testNegation() {
		UnitQuaternion u = UnitQuaternion.negate(new UnitQuaternion(2.0, 4.0, 7.0, 10.0));
		Assert.assertEquals(-2.0 / 13.0, u.getW(), 0d);
		Assert.assertEquals(-4.0 / 13.0, u.getX(), 0d);
		Assert.assertEquals(-7.0 / 13.0, u.getY(), 0d);
		Assert.assertEquals(-10.0 / 13.0, u.getZ(), 0d);
	}

	/**
	 *  
	Tests multiplication by another  {@link UnitQuaternion}.
	

	 */
	@Test
	public final void testMultiplicationByUnitQuaternion() {
		// Choose quaternions whose vector portions (x, y, z) do not produce zeros
		// when dotted or crossed.  They should also have non-zero scalar (w) portions as well.
		UnitQuaternion first = new UnitQuaternion(7.0, 2.0, 3.0, 6.0);
		UnitQuaternion second = new UnitQuaternion(7.0, 2.0, 3.0, 6.0);
		UnitQuaternion result = first.multiply(second);
		Assert.assertEquals(0.0 / 7.0, result.getW(), Constants.Epsilon15);
		Assert.assertEquals(2.0 / 7.0, result.getX(), Constants.Epsilon15);
		Assert.assertEquals(3.0 / 7.0, result.getY(), Constants.Epsilon15);
		Assert.assertEquals(6.0 / 7.0, result.getZ(), Constants.Epsilon15);
		result = UnitQuaternion.multiply(first, second);
		Assert.assertEquals(0.0 / 7.0, result.getW(), Constants.Epsilon15);
		Assert.assertEquals(2.0 / 7.0, result.getX(), Constants.Epsilon15);
		Assert.assertEquals(3.0 / 7.0, result.getY(), Constants.Epsilon15);
		Assert.assertEquals(6.0 / 7.0, result.getZ(), Constants.Epsilon15);
	}

	/**
	 *  
	Tests that Cartesian3.GetHashCode returns something at least reasonably random.
	

	 */
	@Test
	public final void testGetHashCode() {
		UnitQuaternion object1 = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
		UnitQuaternion object2 = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
		UnitQuaternion object3 = new UnitQuaternion(1.0, 2.0, 3.0, 4.1);
		Assert.assertEquals((int) object1.hashCode(), (int) object2.hashCode());
		AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
	}

	/**
	 *  
	Tests ToString method
	

	 */
	@Test
	public final void testToString() {
		UnitQuaternion test1 = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);
		UnitQuaternion test2 = new UnitQuaternion(0.0, 1.0, 0.0, 0.0);
		UnitQuaternion test3 = new UnitQuaternion(0.0, 0.0, 1.0, 0.0);
		UnitQuaternion test4 = new UnitQuaternion(0.0, 0.0, 0.0, 1.0);
		Assert.assertEquals("1, 0, 0, 0", test1.toString());
		Assert.assertEquals("0, 1, 0, 0", test2.toString());
		Assert.assertEquals("0, 0, 1, 0", test3.toString());
		Assert.assertEquals("0, 0, 0, 1", test4.toString());
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