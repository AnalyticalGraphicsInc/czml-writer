package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
import cesiumlanguagewriter.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *  
 Tests the  {@link UnitCartesian} type.
 

 */
public class TestUnitCartesian3 {
	/**
	 *  
	Tests that initialization of and access to the type's values works correctly.
	

	 */
	@Test
	public final void testHoldValue() {
		UnitCartesian test = new UnitCartesian(2.0, 3.0, 6.0);
		Assert.assertEquals(2.0 / 7.0, test.getX(), 0d);
		Assert.assertEquals(3.0 / 7.0, test.getY(), 0d);
		Assert.assertEquals(6.0 / 7.0, test.getZ(), 0d);
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
		UnitCartesian test = new UnitCartesian(values);
		Assert.assertEquals((int) values.length, (int) test.getLength());
		Assert.assertEquals(test.getX(), test.get(0), 0d);
		Assert.assertEquals(test.getY(), test.get(1), 0d);
		Assert.assertEquals(test.getZ(), test.get(2), 0d);
	}

	/**
	 *  
	Tests initialization from  {@link Cartesian} coordinates.
	

	 */
	@Test
	public final void testFromCartesian() {
		UnitCartesian test = new UnitCartesian(new Cartesian(2.0, 3.0, 6.0));
		Assert.assertEquals(2.0 / 7.0, test.getX(), Constants.Epsilon15);
		Assert.assertEquals(3.0 / 7.0, test.getY(), Constants.Epsilon15);
		Assert.assertEquals(6.0 / 7.0, test.getZ(), Constants.Epsilon15);
	}

	/**
	 *  
	Tests initialization from  {@link Cartesian} coordinates.
	

	 */
	@Test
	public final void testFromCartesianAndReturnMagnitude() {
		double magnitude = 0D;
		double[] out$magnitude_0 = {
			0D
		};
		UnitCartesian test = new UnitCartesian(new Cartesian(2.0, 3.0, 6.0), out$magnitude_0);
		magnitude = out$magnitude_0[0];
		Assert.assertEquals(2.0 / 7.0, test.getX(), Constants.Epsilon15);
		Assert.assertEquals(3.0 / 7.0, test.getY(), Constants.Epsilon15);
		Assert.assertEquals(6.0 / 7.0, test.getZ(), Constants.Epsilon15);
		Assert.assertEquals(7.0, magnitude, Constants.Epsilon15);
	}

	/**
	 *  
	Tests initialization from coordinates.
	

	 */
	@Test
	public final void testInitializeAndReturnMagnitude() {
		double magnitude = 0D;
		double[] out$magnitude_1 = {
			0D
		};
		UnitCartesian test = new UnitCartesian(2.0, 3.0, 6.0, out$magnitude_1);
		magnitude = out$magnitude_1[0];
		Assert.assertEquals(2.0 / 7.0, test.getX(), Constants.Epsilon15);
		Assert.assertEquals(3.0 / 7.0, test.getY(), Constants.Epsilon15);
		Assert.assertEquals(6.0 / 7.0, test.getZ(), Constants.Epsilon15);
		Assert.assertEquals(7.0, magnitude, Constants.Epsilon15);
	}

	/**
	 *  
	Tests initialization from clock and cone angles.
	

	 */
	@Test
	public final void testFromClockAndCone() {
		double fortyFiveDegrees = Math.PI / 4.0;
		double thirtyDegrees = Math.PI / 6.0;
		UnitCartesian test = new UnitCartesian(thirtyDegrees, fortyFiveDegrees);
		Assert.assertEquals(Math.sqrt(3.0) / Math.sqrt(8.0), test.getX(), Constants.Epsilon15);
		Assert.assertEquals(1.0 / Math.sqrt(8.0), test.getY(), Constants.Epsilon15);
		Assert.assertEquals(1.0 / Math.sqrt(2.0), test.getZ(), Constants.Epsilon15);
	}

	/**
	 *  
	Tests the equality and inequality methods and operators.
	

	 */
	@Test
	public final void testEquality() {
		UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
		UnitCartesian second = new UnitCartesian(1.0, 2.0, 3.0);
		Assert.assertEquals(first, second);
		Assert.assertEquals(second, first);
		Assert.assertTrue(UnitCartesian.equals(first, second));
		Assert.assertTrue(UnitCartesian.equals(second, first));
		Assert.assertFalse(UnitCartesian.notEquals(first, second));
		Assert.assertFalse(UnitCartesian.notEquals(second, first));
		Assert.assertTrue(first.equalsType(second));
		Assert.assertTrue(second.equalsType(first));
		second = new UnitCartesian(0.0, 2.0, 3.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(UnitCartesian.equals(first, second));
		Assert.assertFalse(UnitCartesian.equals(second, first));
		Assert.assertTrue(UnitCartesian.notEquals(first, second));
		Assert.assertTrue(UnitCartesian.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		second = new UnitCartesian(1.0, 0.0, 3.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(UnitCartesian.equals(first, second));
		Assert.assertFalse(UnitCartesian.equals(second, first));
		Assert.assertTrue(UnitCartesian.notEquals(first, second));
		Assert.assertTrue(UnitCartesian.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		second = new UnitCartesian(1.0, 2.0, 0.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(UnitCartesian.equals(first, second));
		Assert.assertFalse(UnitCartesian.equals(second, first));
		Assert.assertTrue(UnitCartesian.notEquals(first, second));
		Assert.assertTrue(UnitCartesian.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
	}

	/**
	 *  
	Tests the  {@link UnitCartesian#equalsEpsilon} method.
	

	 */
	@Test
	public final void testEqualsEpsilon() {
		UnitCartesian first = new UnitCartesian(1.0, 1.0, 1.0);
		UnitCartesian second = new UnitCartesian(0.99, 1.0, 1.01);
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
		UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
		Cartographic second = new Cartographic(1.0, 2.0, 3.0);
		Assert.assertFalse(first.equals(second));
	}

	/**
	 *  
	Tests the <code>IsUndefined</code> ({@link UnitCartesian#getIsUndefined get}) method.
	

	 */
	@Test
	public final void testIsUndefined() {
		Assert.assertFalse(new UnitCartesian(1.0, 1.0, 1.0).getIsUndefined());
		Assert.assertTrue(UnitCartesian.getUndefined().getIsUndefined());
		Assert.assertTrue(new UnitCartesian(Double.NaN, 1.0, 1.0).getIsUndefined());
		Assert.assertTrue(new UnitCartesian(1.0, Double.NaN, 1.0).getIsUndefined());
		Assert.assertTrue(new UnitCartesian(1.0, 1.0, Double.NaN).getIsUndefined());
	}

	/**
	 *  
	Tests that rotation by an invalid  {@link ElementaryRotation} produces an
	{@link ArithmeticException}.
	

	 */
	@Test(expected = ArithmeticException.class)
	public final void testFromZero() {
		UnitCartesian first = new UnitCartesian(Cartesian.getZero());
	}

	/**
	 *  
	Tests that rotation by an invalid  {@link ElementaryRotation} produces an
	{@link ArithmeticException}.
	

	 */
	@Test(expected = ArithmeticException.class)
	public final void testFromInfinity() {
		UnitCartesian first = new UnitCartesian(Double.POSITIVE_INFINITY, 0.0, 0.0);
	}

	/**
	 *  
	Tests the  {@link UnitCartesian#angleBetween} method.
	

	 */
	@Test
	public final void testAngleBetween() {
		double fortyFiveDegrees = Math.PI / 4.0;
		UnitCartesian first = new UnitCartesian(1.0, 1.0, 0.0);
		UnitCartesian second = new UnitCartesian(1.0, 1.0, Math.sqrt(2.0));
		Assert.assertEquals(fortyFiveDegrees, second.angleBetween(first), Constants.Epsilon15);
	}

	/**
	 *  
	Tests the <code>MostOrthogonalAxis</code> ({@link UnitCartesian#getMostOrthogonalAxis get}) method.
	

	 */
	@Test
	public final void testMostOrthogonalAxis() {
		UnitCartesian Cartesian3 = new UnitCartesian(1.0, 2.0, 3.0);
		Assert.assertEquals(UnitCartesian.getUnitX(), Cartesian3.getMostOrthogonalAxis());
		Cartesian3 = new UnitCartesian(2.0, 3.0, 1.0);
		Assert.assertEquals(UnitCartesian.getUnitZ(), Cartesian3.getMostOrthogonalAxis());
		Cartesian3 = new UnitCartesian(3.0, 1.0, 2.0);
		Assert.assertEquals(UnitCartesian.getUnitY(), Cartesian3.getMostOrthogonalAxis());
	}

	/**
	 *  
	Tests the <code>MostParallelAxis</code> ({@link UnitCartesian#getMostParallelAxis get}) method.
	

	 */
	@Test
	public final void testMostParallelAxis() {
		UnitCartesian Cartesian3 = new UnitCartesian(1.0, 2.0, 3.0);
		Assert.assertEquals(UnitCartesian.getUnitZ(), Cartesian3.getMostParallelAxis());
		Cartesian3 = new UnitCartesian(2.0, 3.0, 1.0);
		Assert.assertEquals(UnitCartesian.getUnitY(), Cartesian3.getMostParallelAxis());
		Cartesian3 = new UnitCartesian(3.0, 1.0, 2.0);
		Assert.assertEquals(UnitCartesian.getUnitX(), Cartesian3.getMostParallelAxis());
	}

	/**
	 *  
	Tests the  {@link UnitCartesian#invert} method.
	

	 */
	@Test
	public final void testInvert() {
		UnitCartesian Cartesian3 = new UnitCartesian(2.0, 3.0, 6.0);
		UnitCartesian inverted = Cartesian3.invert();
		Assert.assertEquals(-2.0 / 7.0, inverted.getX(), 0d);
		Assert.assertEquals(-3.0 / 7.0, inverted.getY(), 0d);
		Assert.assertEquals(-6.0 / 7.0, inverted.getZ(), 0d);
	}

	/**
	 *  
	Tests negation of a set of coordinates.
	

	 */
	@Test
	public final void testNegation() {
		UnitCartesian u = UnitCartesian.negate(new UnitCartesian(2.0, 3.0, 6.0));
		Assert.assertEquals(-2.0 / 7.0, u.getX(), 0d);
		Assert.assertEquals(-3.0 / 7.0, u.getY(), 0d);
		Assert.assertEquals(-6.0 / 7.0, u.getZ(), 0d);
	}

	/**
	 *  
	Tests the addition methods and operators.
	

	 */
	@Test
	public final void testAdd() {
		UnitCartesian original1 = UnitCartesian.getUnitX();
		UnitCartesian toAdd1 = UnitCartesian.getUnitY();
		Cartesian result = UnitCartesian.add(original1, toAdd1);
		Assert.assertEquals(1.0, result.getX(), 0d);
		Assert.assertEquals(1.0, result.getY(), 0d);
		Assert.assertEquals(0.0, result.getZ(), 0d);
		Cartesian toAdd2 = new Cartesian(0.0, 1.0, 1.0);
		result = UnitCartesian.add(original1, toAdd2);
		Assert.assertEquals(1.0, result.getX(), 0d);
		Assert.assertEquals(1.0, result.getY(), 0d);
		Assert.assertEquals(1.0, result.getZ(), 0d);
		Cartesian original2 = new Cartesian(0.0, 1.0, 1.0);
		UnitCartesian toAdd3 = UnitCartesian.getUnitX();
		result = UnitCartesian.add(original2, toAdd3);
		Assert.assertEquals(1.0, result.getX(), 0d);
		Assert.assertEquals(1.0, result.getY(), 0d);
		Assert.assertEquals(1.0, result.getZ(), 0d);
	}

	/**
	 *  
	Tests the subtraction methods and operators.
	

	 */
	@Test
	public final void testSubtract() {
		UnitCartesian original = UnitCartesian.getUnitX();
		UnitCartesian toAdd1 = UnitCartesian.getUnitY();
		Cartesian result = UnitCartesian.subtract(original, toAdd1);
		Assert.assertEquals(1.0, result.getX(), 0d);
		Assert.assertEquals(-1.0, result.getY(), 0d);
		Assert.assertEquals(0.0, result.getZ(), 0d);
		Cartesian toAdd2 = new Cartesian(0.0, 1.0, 1.0);
		result = UnitCartesian.subtract(original, toAdd2);
		Assert.assertEquals(1.0, result.getX(), 0d);
		Assert.assertEquals(-1.0, result.getY(), 0d);
		Assert.assertEquals(-1.0, result.getZ(), 0d);
		Cartesian original2 = new Cartesian(0.0, 1.0, 1.0);
		UnitCartesian toAdd3 = UnitCartesian.getUnitX();
		result = UnitCartesian.subtract(original2, toAdd3);
		Assert.assertEquals(-1.0, result.getX(), 0d);
		Assert.assertEquals(1.0, result.getY(), 0d);
		Assert.assertEquals(1.0, result.getZ(), 0d);
	}

	/**
	 *  
	Tests the multiplication methods and operators.
	

	 */
	@Test
	public final void testMultiply() {
		UnitCartesian original = new UnitCartesian(2.0, 3.0, 6.0);
		Cartesian multiplied = UnitCartesian.multiply(original, 7.0);
		Assert.assertEquals(2.0, multiplied.getX(), 0d);
		Assert.assertEquals(3.0, multiplied.getY(), 0d);
		Assert.assertEquals(6.0, multiplied.getZ(), 0d);
		multiplied = UnitCartesian.multiply(7.0, original);
		Assert.assertEquals(2.0, multiplied.getX(), 0d);
		Assert.assertEquals(3.0, multiplied.getY(), 0d);
		Assert.assertEquals(6.0, multiplied.getZ(), 0d);
	}

	/**
	 *  
	Tests the multiplication methods and operators.
	

	 */
	@Test
	public final void testDivide() {
		UnitCartesian original = new UnitCartesian(2.0, 3.0, 6.0);
		Cartesian result = UnitCartesian.divide(original, 2.0);
		Assert.assertEquals(2.0 / 14.0, result.getX(), 0d);
		Assert.assertEquals(3.0 / 14.0, result.getY(), 0d);
		Assert.assertEquals(6.0 / 14.0, result.getZ(), 0d);
		result = original.divide(2.0);
		Assert.assertEquals(2.0 / 14.0, result.getX(), 0d);
		Assert.assertEquals(3.0 / 14.0, result.getY(), 0d);
		Assert.assertEquals(6.0 / 14.0, result.getZ(), 0d);
	}

	/**
	 *  
	Tests the Dot method.
	

	 */
	@Test
	public final void testDotProduct() {
		UnitCartesian first = new UnitCartesian(1.0, 3.0, -2.0);
		UnitCartesian second = new UnitCartesian(4.0, -2.0, -1.0);
		Assert.assertEquals(0D, first.dot(Cartesian.toCartesian(second)), Constants.Epsilon15);
		Assert.assertEquals(0D, second.dot(Cartesian.toCartesian(first)), Constants.Epsilon15);
		Cartesian result = new Cartesian(4.0, -2.0, -1.0);
		Assert.assertEquals(0, first.dot(result), 0d);
	}

	/**
	 *  
	Tests the Cross method.
	

	 */
	@Test
	public final void testCrossProduct() {
		double angle = Math.PI / 4.0;
		double cos = Math.cos(angle / 2.0);
		double sin = Math.sin(angle / 2.0);
		double a = cos * cos - sin * sin / 3.0;
		double b = 2.0 * (sin * sin + sin * cos * Math.sqrt(3.0)) / 3.0;
		double c = 2.0 * (sin * sin - sin * cos * Math.sqrt(3.0)) / 3.0;
		// The three vectors here are the orthonormal set obtained by rotating
		// the x-axis, y-axis, and z-axis through an angle of 45 degrees about
		// the (1,1,1) vector.
		UnitCartesian first = new UnitCartesian(a, b, c);
		UnitCartesian second = new UnitCartesian(c, a, b);
		UnitCartesian third = new UnitCartesian(b, c, a);
		Cartesian result = first.cross(Cartesian.toCartesian(second));
		Assert.assertEquals(third.getX(), result.getX(), Constants.Epsilon14);
		Assert.assertEquals(third.getY(), result.getY(), Constants.Epsilon14);
		Assert.assertEquals(third.getZ(), result.getZ(), Constants.Epsilon14);
		Cartesian Cartesian3 = new Cartesian(c, a, b);
		result = first.cross(Cartesian3);
		Assert.assertEquals(third.getX(), result.getX(), Constants.Epsilon14);
		Assert.assertEquals(third.getY(), result.getY(), Constants.Epsilon14);
		Assert.assertEquals(third.getZ(), result.getZ(), Constants.Epsilon14);
	}

	/**
	 *  
	Tests rotation by a  {@link UnitQuaternion}.
	

	 */
	@Test
	public final void testRotateByQuaternion() {
		double angle = Math.PI / 3.0;
		// half angle of 120 degree rotation
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		UnitCartesian axis = new UnitCartesian(1.0, 1.0, 1.0);
		// unit vector along [1,1,1]
		double w = cos;
		double x = sin * axis.getX();
		double y = sin * axis.getY();
		double z = sin * axis.getZ();
		// The original vector is along the x-axis.
		UnitCartesian original = UnitCartesian.getUnitX();
		// The rotated vector is along the z-axis.
		UnitCartesian rotated = original.rotate(new UnitQuaternion(w, x, y, z));
		Assert.assertEquals(0.0, rotated.getX(), Constants.Epsilon15);
		Assert.assertEquals(0.0, rotated.getY(), Constants.Epsilon15);
		Assert.assertEquals(1.0, rotated.getZ(), Constants.Epsilon15);
	}

	/**
	 *  
	Tests rotation by an  {@link Matrix3By3}.
	

	 */
	@Test
	public final void testRotateByMatrix3By3() {
		double angle = Math.PI / 3.0;
		// half angle of 120 degree rotation
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		UnitCartesian axis = new UnitCartesian(1.0, 1.0, 1.0);
		// unit vector along [1,1,1]
		double w = cos;
		double x = sin * axis.getX();
		double y = sin * axis.getY();
		double z = sin * axis.getZ();
		// The original vector is along the x-axis.
		UnitCartesian original = new UnitCartesian(1.0, 0.0, 0.0);
		// The rotated vector is along the z-axis.
		UnitCartesian rotated = original.rotate(new Matrix3By3(new UnitQuaternion(w, x, y, z)));
		Assert.assertEquals(0.0, rotated.getX(), Constants.Epsilon15);
		Assert.assertEquals(0.0, rotated.getY(), Constants.Epsilon15);
		Assert.assertEquals(1.0, rotated.getZ(), Constants.Epsilon15);
	}

	/**
	 *  
	Tests that Cartesian3.GetHashCode returns something at least reasonably random.
	

	 */
	@Test
	public final void testGetHashCode() {
		UnitCartesian object1 = new UnitCartesian(1.0, 2.0, 3.0);
		UnitCartesian object2 = new UnitCartesian(1.0, 2.0, 3.0);
		UnitCartesian object3 = new UnitCartesian(1.0, 2.0, 3.1);
		Assert.assertEquals((int) object1.hashCode(), (int) object2.hashCode());
		AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
	}

	/**
	 *  
	Tests that construction from a null array of doubles throws the correct exception.
	

	 */
	@Test(expected = ArgumentNullException.class)
	public final void testInitializationFromNull() {
		double[] array = null;
		UnitCartesian first = new UnitCartesian(array, 0);
	}

	/**
	 *  
	Tests that construction from an array of doubles with an incorrect length throws the correct exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testInitializationFromBadArray() {
		double[] array = new double[2];
		UnitCartesian first = new UnitCartesian(array, 0);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testIndexTooHigh() {
		UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
		double bad = first.get(3);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testIndexTooLow() {
		UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
		double bad = first.get(-1);
	}

	/**
	 *  
	Tests ToString method
	

	 */
	@Test
	public final void testToString() {
		UnitCartesian test1 = new UnitCartesian(1.0, 0.0, 0.0);
		UnitCartesian test2 = new UnitCartesian(0.0, 1.0, 0.0);
		UnitCartesian test3 = new UnitCartesian(0.0, 0.0, 1.0);
		Assert.assertEquals("1, 0, 0", test1.toString());
		Assert.assertEquals("0, 1, 0", test2.toString());
		Assert.assertEquals("0, 0, 1", test3.toString());
	}

	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}