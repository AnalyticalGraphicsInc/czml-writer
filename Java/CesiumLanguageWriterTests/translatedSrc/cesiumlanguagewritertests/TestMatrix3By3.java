package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.AssertHelper;
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
 Tests the  {@link Matrix3By3} type.
 

 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMatrix3By3 {
	/**
	 *  
	Tests that initialization of and access to the type's values works correctly.
	

	 */
	@Test
	public final void testHoldValue() {
		Matrix3By3 test = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		Assert.assertEquals(1.0, test.getM11(), 0d);
		Assert.assertEquals(2.0, test.getM12(), 0d);
		Assert.assertEquals(3.0, test.getM13(), 0d);
		Assert.assertEquals(4.0, test.getM21(), 0d);
		Assert.assertEquals(5.0, test.getM22(), 0d);
		Assert.assertEquals(6.0, test.getM23(), 0d);
		Assert.assertEquals(7.0, test.getM31(), 0d);
		Assert.assertEquals(8.0, test.getM32(), 0d);
		Assert.assertEquals(9.0, test.getM33(), 0d);
	}

	/**
	 *  
	Tests construction from a  {@link Quaternion}.
	

	 */
	@Test
	public final void testFromQuaternion() {
		UnitQuaternion quaternion = UnitQuaternion.getIdentity();
		Matrix3By3 matrix = new Matrix3By3(quaternion);
		Assert.assertEquals(1.0, matrix.getM11(), 0d);
		Assert.assertEquals(0.0, matrix.getM12(), 0d);
		Assert.assertEquals(0.0, matrix.getM13(), 0d);
		Assert.assertEquals(0.0, matrix.getM21(), 0d);
		Assert.assertEquals(1.0, matrix.getM22(), 0d);
		Assert.assertEquals(0.0, matrix.getM23(), 0d);
		Assert.assertEquals(0.0, matrix.getM31(), 0d);
		Assert.assertEquals(0.0, matrix.getM32(), 0d);
		Assert.assertEquals(1.0, matrix.getM33(), 0d);
	}

	/**
	 *  
	Tests the equality and inequality methods and operators.
	

	 */
	@Test
	public final void testEquality() {
		Matrix3By3 first = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		Matrix3By3 second = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		AssertHelper.assertEquals(first, second);
		AssertHelper.assertEquals(second, first);
		Assert.assertTrue(Matrix3By3.equals(first, second));
		Assert.assertTrue(Matrix3By3.equals(second, first));
		Assert.assertFalse(Matrix3By3.notEquals(first, second));
		Assert.assertFalse(Matrix3By3.notEquals(second, first));
		Assert.assertTrue(first.equalsType(second));
		Assert.assertTrue(second.equalsType(first));
		for (int i = 0; i < 9; ++i) {
			double[] values = {
					1.0,
					2.0,
					3.0,
					4.0,
					5.0,
					6.0,
					7.0,
					8.0,
					9.0
			};
			values[i] = 0.0;
			second = new Matrix3By3(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
			AssertHelper.assertNotEqual(first, second);
			AssertHelper.assertNotEqual(second, first);
			Assert.assertFalse(Matrix3By3.equals(first, second));
			Assert.assertFalse(Matrix3By3.equals(second, first));
			Assert.assertTrue(Matrix3By3.notEquals(first, second));
			Assert.assertTrue(Matrix3By3.notEquals(second, first));
			Assert.assertFalse(first.equalsType(second));
			Assert.assertFalse(second.equalsType(first));
		}
	}

	/**
	 *  
	Tests to ensure the equality fails when comparing incorrect type.
	

	 */
	@Test
	public final void testEqualityWithWrongType() {
		Matrix3By3 first = Matrix3By3.getIdentity();
		Cartesian second = new Cartesian(1.0, 2.0, 3.0);
		Assert.assertFalse(first.equals(second));
	}

	/**
	 *  
	Tests the  {@link Matrix3By3#equalsEpsilon} method.
	

	 */
	@Test
	public final void testEqualsEpsilon() {
		Matrix3By3 first = new Matrix3By3(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		Matrix3By3 second = new Matrix3By3(1e-2, 1e-3, 1e-4, 1e-5, 1e-6, 1e-7, 1e-8, 1e-9, 1e-10);
		Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-2));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-3));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-4));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-5));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-6));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-7));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-8));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-9));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-10));
	}

	/**
	 *  
	Tests indexing.
	

	 */
	@Test
	public final void testIndex() {
		Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		Assert.assertEquals(1.0, original.get(0, 0), 0d);
		Assert.assertEquals(2.0, original.get(0, 1), 0d);
		Assert.assertEquals(3.0, original.get(0, 2), 0d);
		Assert.assertEquals(4.0, original.get(1, 0), 0d);
		Assert.assertEquals(5.0, original.get(1, 1), 0d);
		Assert.assertEquals(6.0, original.get(1, 2), 0d);
		Assert.assertEquals(7.0, original.get(2, 0), 0d);
		Assert.assertEquals(8.0, original.get(2, 1), 0d);
		Assert.assertEquals(9.0, original.get(2, 2), 0d);
	}

	/**
	 *  
	Tests the  {@link Matrix3By3#transpose} method.
	

	 */
	@Test
	public final void testTranspose() {
		Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		Matrix3By3 transposed = original.transpose();
		Assert.assertEquals(transposed.getM11(), original.getM11(), 0d);
		Assert.assertEquals(transposed.getM12(), original.getM21(), 0d);
		Assert.assertEquals(transposed.getM13(), original.getM31(), 0d);
		Assert.assertEquals(transposed.getM21(), original.getM12(), 0d);
		Assert.assertEquals(transposed.getM22(), original.getM22(), 0d);
		Assert.assertEquals(transposed.getM23(), original.getM32(), 0d);
		Assert.assertEquals(transposed.getM31(), original.getM13(), 0d);
		Assert.assertEquals(transposed.getM32(), original.getM23(), 0d);
		Assert.assertEquals(transposed.getM33(), original.getM33(), 0d);
	}

	/**
	 *  
	Tests <code>Identity</code> ({@link Matrix3By3#getIdentity get}).
	

	 */
	@Test
	public final void testIdentity() {
		Matrix3By3 identity = Matrix3By3.getIdentity();
		Assert.assertEquals(1.0, identity.getM11(), 0d);
		Assert.assertEquals(0.0, identity.getM12(), 0d);
		Assert.assertEquals(0.0, identity.getM13(), 0d);
		Assert.assertEquals(0.0, identity.getM21(), 0d);
		Assert.assertEquals(1.0, identity.getM22(), 0d);
		Assert.assertEquals(0.0, identity.getM23(), 0d);
		Assert.assertEquals(0.0, identity.getM31(), 0d);
		Assert.assertEquals(0.0, identity.getM32(), 0d);
		Assert.assertEquals(1.0, identity.getM33(), 0d);
	}

	/**
	 *  
	Tests the <code>IsUndefined</code> ({@link Matrix3By3#getIsUndefined get}) method.
	

	 */
	@Test
	public final void testIsUndefined() {
		Assert.assertFalse(Matrix3By3.getIdentity().getIsUndefined());
		Assert.assertTrue(Matrix3By3.getUndefined().getIsUndefined());
		//* Check what happens if any of the elements are NaN
		for (int i = 0; i < 9; i++) {
			double[] values = new double[9];
			for (int k = 0; k < 9; k++) {
				values[k] = 1.0;
			}
			values[i] = Double.NaN;
			Assert.assertTrue(new Matrix3By3(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]).getIsUndefined());
		}
	}

	/**
	 *  
	Tests multiplication by a scalar.
	

	 */
	@Test
	public final void testMultiplyByScalar() {
		Matrix3By3 test = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		Matrix3By3 result = test.multiply(-2.0);
		Assert.assertEquals(-2.0, result.getM11(), 0d);
		Assert.assertEquals(-4.0, result.getM12(), 0d);
		Assert.assertEquals(-6.0, result.getM13(), 0d);
		Assert.assertEquals(-8.0, result.getM21(), 0d);
		Assert.assertEquals(-10.0, result.getM22(), 0d);
		Assert.assertEquals(-12.0, result.getM23(), 0d);
		Assert.assertEquals(-14.0, result.getM31(), 0d);
		Assert.assertEquals(-16.0, result.getM32(), 0d);
		Assert.assertEquals(-18.0, result.getM33(), 0d);
		result = Matrix3By3.multiply(test, -2.0);
		Assert.assertEquals(-2.0, result.getM11(), 0d);
		Assert.assertEquals(-4.0, result.getM12(), 0d);
		Assert.assertEquals(-6.0, result.getM13(), 0d);
		Assert.assertEquals(-8.0, result.getM21(), 0d);
		Assert.assertEquals(-10.0, result.getM22(), 0d);
		Assert.assertEquals(-12.0, result.getM23(), 0d);
		Assert.assertEquals(-14.0, result.getM31(), 0d);
		Assert.assertEquals(-16.0, result.getM32(), 0d);
		Assert.assertEquals(-18.0, result.getM33(), 0d);
		result = Matrix3By3.multiply(-2.0, test);
		Assert.assertEquals(-2.0, result.getM11(), 0d);
		Assert.assertEquals(-4.0, result.getM12(), 0d);
		Assert.assertEquals(-6.0, result.getM13(), 0d);
		Assert.assertEquals(-8.0, result.getM21(), 0d);
		Assert.assertEquals(-10.0, result.getM22(), 0d);
		Assert.assertEquals(-12.0, result.getM23(), 0d);
		Assert.assertEquals(-14.0, result.getM31(), 0d);
		Assert.assertEquals(-16.0, result.getM32(), 0d);
		Assert.assertEquals(-18.0, result.getM33(), 0d);
	}

	/**
	 *  
	Tests multiplication by another  {@link Matrix3By3}.
	

	 */
	@Test
	public final void testMultiplyByMatrix() {
		double angle = Math.PI / 4.0;
		double cos = Math.cos(angle / 2.0);
		double sin = Math.sin(angle / 2.0);
		double a = cos * cos - sin * sin / 3.0;
		double b = 2.0 * (sin * sin + sin * cos * Math.sqrt(3.0)) / 3.0;
		double c = 2.0 * (sin * sin - sin * cos * Math.sqrt(3.0)) / 3.0;
		// The matrix here is formed from the orthonormal set obtained by rotating
		// the x-axis, y-axis, and z-axis through an angle of 45 degrees about
		// the (1,1,1) vector.
		Matrix3By3 test = new Matrix3By3(a, c, b, b, a, c, c, b, a);
		Matrix3By3 transpose = test.transpose();
		Matrix3By3 result = test.multiply(transpose);
		Assert.assertTrue(result.equalsEpsilon(Matrix3By3.getIdentity(), 1e-16));
		result = Matrix3By3.multiply(test, transpose);
		Assert.assertTrue(result.equalsEpsilon(Matrix3By3.getIdentity(), 1e-16));
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testFirstIndexTooHigh() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(3, 0);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testFirstIndexTooLow() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(-1, 0);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testSecondIndexTooHigh0() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(0, 3);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testSecondIndexTooLow0() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(0, -1);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testSecondIndexTooHigh1() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(1, -1);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testSecondIndexTooLow1() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(1, -1);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testSecondIndexTooHigh2() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(2, 3);
	}

	/**
	 *  
	Tests to ensure that an invalid index throws the anticipated exception.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testSecondIndexTooLow2() {
		Matrix3By3 diagonal = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
		double bad = diagonal.get(2, -1);
	}

	/**
	 *  
	Tests that Matrix3By3.GetHashCode returns something at least reasonably random.
	

	 */
	@Test
	public final void testGetHashCode() {
		Matrix3By3 object1 = Matrix3By3.getIdentity();
		Matrix3By3 object2 = Matrix3By3.getIdentity();
		Matrix3By3 object3 = new Matrix3By3();
		Assert.assertEquals((int) object1.hashCode(), (int) object2.hashCode());
		AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
	}

	/**
	 *  
	Tests the zero matrix
	

	 */
	@Test
	public final void testZeroMatrix() {
		Matrix3By3 zero = Matrix3By3.getZero();
		Assert.assertEquals(0.0, zero.getM11(), 0d);
		Assert.assertEquals(0.0, zero.getM12(), 0d);
		Assert.assertEquals(0.0, zero.getM13(), 0d);
		Assert.assertEquals(0.0, zero.getM21(), 0d);
		Assert.assertEquals(0.0, zero.getM22(), 0d);
		Assert.assertEquals(0.0, zero.getM23(), 0d);
		Assert.assertEquals(0.0, zero.getM31(), 0d);
		Assert.assertEquals(0.0, zero.getM32(), 0d);
		Assert.assertEquals(0.0, zero.getM33(), 0d);
	}

	/**
	 *  
	Tests the cross product equivilant matrix
	Diagonal Matrix
	

	 */
	@Test
	public final void testMatrixReturns() {
		double x = 1D;
		double y = 2D;
		double z = 3D;
		Matrix3By3 mat1 = Matrix3By3.crossProductEquivalentMatrix(new Cartesian(x, y, z));
		Assert.assertEquals(0.0, mat1.getM11(), 0d);
		Assert.assertEquals(-z, mat1.getM12(), 0d);
		Assert.assertEquals(y, mat1.getM13(), 0d);
		Assert.assertEquals(z, mat1.getM21(), 0d);
		Assert.assertEquals(0, mat1.getM22(), 0d);
		Assert.assertEquals(-x, mat1.getM23(), 0d);
		Assert.assertEquals(-y, mat1.getM31(), 0d);
		Assert.assertEquals(x, mat1.getM32(), 0d);
		Assert.assertEquals(0.0, mat1.getM33(), 0d);
		UnitCartesian u = new UnitCartesian(x, y, z);
		x = u.getX();
		y = u.getY();
		z = u.getZ();
		Matrix3By3 mat2 = Matrix3By3.crossProductEquivalentMatrix(Cartesian.toCartesian(u));
		Assert.assertEquals(0.0, mat2.getM11(), 0d);
		Assert.assertEquals(-z, mat2.getM12(), 0d);
		Assert.assertEquals(y, mat2.getM13(), 0d);
		Assert.assertEquals(z, mat2.getM21(), 0d);
		Assert.assertEquals(0, mat2.getM22(), 0d);
		Assert.assertEquals(-x, mat2.getM23(), 0d);
		Assert.assertEquals(-y, mat2.getM31(), 0d);
		Assert.assertEquals(x, mat2.getM32(), 0d);
		Assert.assertEquals(0.0, mat2.getM33(), 0d);
		Matrix3By3 mat3 = Matrix3By3.diagonalMatrix(new Cartesian(1D, 2D, 3D));
		Assert.assertEquals(mat3.getM11(), 1, 0d);
		Assert.assertEquals(mat3.getM22(), 2, 0d);
		Assert.assertEquals(mat3.getM33(), 3, 0d);
		Matrix3By3 mat4 = Matrix3By3.diagonalMatrix(Cartesian.toCartesian(new UnitCartesian(1D, 0D, 0D)));
		Assert.assertEquals(mat4.getM11(), 1, 0d);
		Assert.assertEquals(mat4.getM22(), 0, 0d);
		Assert.assertEquals(mat4.getM33(), 0, 0d);
	}

	/**
	 *  
	Tests math operators
	

	 */
	@Test
	public final void testMathOperators() {
		Matrix3By3 test1 = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		Matrix3By3 test2 = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		Assert.assertTrue(Matrix3By3.getZero().equalsType(test1.subtract(test2)));
		Assert.assertTrue(Matrix3By3.getZero().equalsType(Matrix3By3.subtract(test1, test2)));
		Assert.assertTrue((Matrix3By3.multiply(test2, 2.0)).equalsType(test1.add(test2)));
		Assert.assertTrue((Matrix3By3.multiply(test2, 2.0)).equalsType(Matrix3By3.add(test1, test2)));
		Assert.assertTrue((new Matrix3By3(30D, 36D, 42D, 66D, 81D, 96D, 102D, 126D, 150D).equalsType(test1.multiply(test2))));
		Assert.assertTrue((new Matrix3By3(30D, 36D, 42D, 66D, 81D, 96D, 102D, 126D, 150D).equalsType(Matrix3By3.multiply(test1, test2))));
	}

	/**
	 *  
	Tests math operators
	

	 */
	@Test
	public final void testMathOperatorsWithCartesian() {
		Matrix3By3 test = new Matrix3By3(1.0, 2.0, 4.0, 2.0, 3.0, 5.0, 4.0, 5.0, 6.0);
		Cartesian mult = new Cartesian(1D, 2D, 3D);
		Assert.assertTrue((new Cartesian(17D, 23D, 32D).equalsType(test.multiply(mult))));
		Assert.assertTrue((new Cartesian(17D, 23D, 32D).equalsType(Matrix3By3.multiply(test, mult))));
	}

	/**
	 *  
	Test invert and by doing so, determinant
	

	 */
	@Test
	public final void testInvert() {
		Matrix3By3 test = new Matrix3By3(1.0, 5.0, 2.0, 1.0, 1.0, 7.0, 0.0, -3.0, 4.0);
		Matrix3By3 inv = test.invert();
		Assert.assertEquals(-25.0, inv.getM11(), 0d);
		Assert.assertEquals(26.0, inv.getM12(), 0d);
		Assert.assertEquals(-33.0, inv.getM13(), 0d);
		Assert.assertEquals(4.0, inv.getM21(), 0d);
		Assert.assertEquals(-4.0, inv.getM22(), 0d);
		Assert.assertEquals(5.0, inv.getM23(), 0d);
		Assert.assertEquals(3.0, inv.getM31(), 0d);
		Assert.assertEquals(-3.0, inv.getM32(), 0d);
		Assert.assertEquals(4.0, inv.getM33(), 0d);
	}

	/**
	 *  
	Test zero invert exception
	

	 */
	@Test(expected = ArithmeticException.class)
	public final void testZeroInvertException() {
		Matrix3By3 mat = Matrix3By3.getZero().invert();
	}

	@Rule
	public TestContextRule rule$testContext = new TestContextRule();
}