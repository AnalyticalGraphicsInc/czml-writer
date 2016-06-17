package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
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
 Tests the  {@link Cartesian} type.
 

 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCartesian {
	/**
	 *  
	Tests that initialization of and access to the type's values works correctly.
	

	 */
	@Test
	public final void testHoldValue() {
		Cartesian test = new Cartesian(1.0, 2.0, 3.0);
		Assert.assertEquals(1.0, test.getX(), 0d);
		Assert.assertEquals(2.0, test.getY(), 0d);
		Assert.assertEquals(3.0, test.getZ(), 0d);
	}

	/**
	 *  
	Tests implicit conversion from  {@link UnitCartesian} coordinates.
	

	 */
	@Test
	public final void testConversionFromUnitCartesian() {
		UnitCartesian unit = new UnitCartesian(1.0, 1.0, 1.0);
		Cartesian test = Cartesian.toCartesian(unit);
		Assert.assertEquals(unit.getX(), test.getX(), 0d);
		Assert.assertEquals(unit.getY(), test.getY(), 0d);
		Assert.assertEquals(unit.getZ(), test.getZ(), 0d);
	}

	/**
	 *  
	Tests the equality and inequality methods and operators.
	

	 */
	@Test
	public final void testEquality() {
		Cartesian first = new Cartesian(1.0, 2.0, 3.0);
		Cartesian second = new Cartesian(1.0, 2.0, 3.0);
		AssertHelper.assertEquals(first, second);
		AssertHelper.assertEquals(second, first);
		Assert.assertTrue(Cartesian.equals(first, second));
		Assert.assertTrue(Cartesian.equals(second, first));
		Assert.assertFalse(Cartesian.notEquals(first, second));
		Assert.assertFalse(Cartesian.notEquals(second, first));
		Assert.assertTrue(first.equalsType(second));
		Assert.assertTrue(second.equalsType(first));
		second = new Cartesian(0.0, 2.0, 3.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(Cartesian.equals(first, second));
		Assert.assertFalse(Cartesian.equals(second, first));
		Assert.assertTrue(Cartesian.notEquals(first, second));
		Assert.assertTrue(Cartesian.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		second = new Cartesian(1.0, 0.0, 3.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(Cartesian.equals(first, second));
		Assert.assertFalse(Cartesian.equals(second, first));
		Assert.assertTrue(Cartesian.notEquals(first, second));
		Assert.assertTrue(Cartesian.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		second = new Cartesian(1.0, 2.0, 0.0);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertNotEqual(second, first);
		Assert.assertFalse(Cartesian.equals(first, second));
		Assert.assertFalse(Cartesian.equals(second, first));
		Assert.assertTrue(Cartesian.notEquals(first, second));
		Assert.assertTrue(Cartesian.notEquals(second, first));
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
	}

	/**
	 *  
	Tests the  {@link Cartesian#equalsEpsilon} method.
	

	 */
	@Test
	public final void testEqualsEpsilon() {
		Cartesian first = new Cartesian(1e-1, 1e-2, 1e-3);
		Cartesian second = new Cartesian(1.1e-1, 1.1e-2, 1.1e-3);
		Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
		Assert.assertTrue(second.equalsEpsilon(first, 1e-2));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-3));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-4));
		Assert.assertFalse(second.equalsEpsilon(first, 1e-5));
	}

	/**
	 *  
	Tests the <code>Magnitude</code> ({@link Cartesian#getMagnitude get}) property.
	

	 */
	@Test
	public final void testMagnitude() {
		Cartesian test = new Cartesian(2.0, 3.0, 6.0);
		Assert.assertEquals(7.0, test.getMagnitude(), 0d);
	}

	/**
	 *  
	Tests the  {@link Cartesian#normalize()} method.
	

	 */
	@Test
	public final void testNormalize() {
		Cartesian test = new Cartesian(2.0, 3.0, 6.0);
		UnitCartesian unit = test.normalize();
		Assert.assertEquals(2.0 / 7.0, unit.getX(), 0d);
		Assert.assertEquals(3.0 / 7.0, unit.getY(), 0d);
		Assert.assertEquals(6.0 / 7.0, unit.getZ(), 0d);
	}

	/**
	 *  
	Tests that normalization of a  {@link Cartesian} with zero magnitude
	produces an  {@link UnsupportedCaseException}.
	

	 */
	@Test
	public final void testNormalizeOfZeroMagnitude() {
		ExpectedExceptionHelper.expectException(getRule$expectedException(), ArithmeticException.class);
		Cartesian test = Cartesian.getZero();
		UnitCartesian unit = test.normalize();
	}

	/**
	 *  
	Tests that normalization of a  {@link Cartesian} with infinite magnitude
	produces an  {@link ArithmeticException}.
	

	 */
	@Test
	public final void testNormalizeOfInfiniteMagnitude() {
		ExpectedExceptionHelper.expectException(getRule$expectedException(), ArithmeticException.class);
		Cartesian test = new Cartesian(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		UnitCartesian unit = test.normalize();
	}

	/**
	 *  
	Tests the <code>IsUndefined</code> ({@link Cartesian#getIsUndefined get}) method.
	

	 */
	@Test
	public final void testIsUndefined() {
		Assert.assertFalse(new Cartesian(1.0, 1.0, 1.0).getIsUndefined());
		Assert.assertTrue(Cartesian.getUndefined().getIsUndefined());
		Assert.assertTrue(new Cartesian(Double.NaN, 1.0, 1.0).getIsUndefined());
		Assert.assertTrue(new Cartesian(1.0, Double.NaN, 1.0).getIsUndefined());
		Assert.assertTrue(new Cartesian(1.0, 1.0, Double.NaN).getIsUndefined());
	}

	/**
	 *  
	Tests the <code>MostOrthogonalAxis</code> ({@link Cartesian#getMostOrthogonalAxis get}) method.
	

	 */
	@Test
	public final void mostOrthogonalAxis() {
		Cartesian v = Cartesian.toCartesian(new UnitCartesian(1.0, 2.0, 3.0));
		AssertHelper.assertEquals(UnitCartesian.getUnitX(), v.getMostOrthogonalAxis());
		v = Cartesian.toCartesian(new UnitCartesian(2.0, 3.0, 1.0));
		AssertHelper.assertEquals(UnitCartesian.getUnitZ(), v.getMostOrthogonalAxis());
		v = Cartesian.toCartesian(new UnitCartesian(3.0, 1.0, 2.0));
		AssertHelper.assertEquals(UnitCartesian.getUnitY(), v.getMostOrthogonalAxis());
	}

	/**
	 *  
	Tests negation of a set of coordinates.
	

	 */
	@Test
	public final void testNegation() {
		Cartesian c = Cartesian.negate(new Cartesian(1.0, 2.0, 3.0));
		Assert.assertEquals(-1.0, c.getX(), 0d);
		Assert.assertEquals(-2.0, c.getY(), 0d);
		Assert.assertEquals(-3.0, c.getZ(), 0d);
	}

	/**
	 *  
	Tests the addition methods and operators.
	

	 */
	@Test
	public final void testAdd() {
		Cartesian original = new Cartesian(10.0, 20.0, 30.0);
		Cartesian toAdd = new Cartesian(1.0, 2.0, 3.0);
		Cartesian result = Cartesian.add(original, toAdd);
		Assert.assertEquals(11.0, result.getX(), 0d);
		Assert.assertEquals(22.0, result.getY(), 0d);
		Assert.assertEquals(33.0, result.getZ(), 0d);
		result = original.add(toAdd);
		Assert.assertEquals(11.0, result.getX(), 0d);
		Assert.assertEquals(22.0, result.getY(), 0d);
		Assert.assertEquals(33.0, result.getZ(), 0d);
	}

	/**
	 *  
	Tests the subtraction methods and operators.
	

	 */
	@Test
	public final void testSubtract() {
		Cartesian original = new Cartesian(10.0, 20.0, 30.0);
		Cartesian toSubtract = new Cartesian(1.0, 2.0, 3.0);
		Cartesian result = Cartesian.subtract(original, toSubtract);
		Assert.assertEquals(9.0, result.getX(), 0d);
		Assert.assertEquals(18.0, result.getY(), 0d);
		Assert.assertEquals(27.0, result.getZ(), 0d);
		result = original.subtract(toSubtract);
		Assert.assertEquals(9.0, result.getX(), 0d);
		Assert.assertEquals(18.0, result.getY(), 0d);
		Assert.assertEquals(27.0, result.getZ(), 0d);
	}

	/**
	 *  
	Tests the multiplication methods and operators.
	

	 */
	@Test
	public final void testMultiply() {
		Cartesian original = new Cartesian(1.0, 2.0, 3.0);
		Cartesian multiplied = Cartesian.multiply(original, 5.0);
		Assert.assertEquals(5.0, multiplied.getX(), 0d);
		Assert.assertEquals(10.0, multiplied.getY(), 0d);
		Assert.assertEquals(15.0, multiplied.getZ(), 0d);
		multiplied = Cartesian.multiply(5.0, original);
		Assert.assertEquals(5.0, multiplied.getX(), 0d);
		Assert.assertEquals(10.0, multiplied.getY(), 0d);
		Assert.assertEquals(15.0, multiplied.getZ(), 0d);
		multiplied = original.multiply(5.0);
		Assert.assertEquals(5.0, multiplied.getX(), 0d);
		Assert.assertEquals(10.0, multiplied.getY(), 0d);
		Assert.assertEquals(15.0, multiplied.getZ(), 0d);
	}

	/**
	 *  
	Tests the multiplication methods and operators.
	

	 */
	@Test
	public final void testDivide() {
		Cartesian original = new Cartesian(2.0, 4.0, 6.0);
		Cartesian result = Cartesian.divide(original, 2.0);
		Assert.assertEquals(1.0, result.getX(), 0d);
		Assert.assertEquals(2.0, result.getY(), 0d);
		Assert.assertEquals(3.0, result.getZ(), 0d);
		result = original.divide(2.0);
		Assert.assertEquals(1.0, result.getX(), 0d);
		Assert.assertEquals(2.0, result.getY(), 0d);
		Assert.assertEquals(3.0, result.getZ(), 0d);
	}

	/**
	 *  
	Tests the  {@link Cartesian#dot} method.
	

	 */
	@Test
	public final void testDotProduct() {
		Cartesian first = new Cartesian(1.0, 3.0, -2.0);
		Cartesian second = new Cartesian(4.0, -2.0, -1.0);
		Assert.assertEquals(0, first.dot(second), 0d);
		Assert.assertEquals(0, second.dot(first), 0d);
	}

	/**
	 *  
	Tests the  {@link Cartesian#cross} method.
	

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
		Cartesian first = new Cartesian(a, b, c);
		Cartesian second = new Cartesian(c, a, b);
		Cartesian third = new Cartesian(b, c, a);
		Cartesian result = first.cross(second);
		Assert.assertEquals(third.getX(), result.getX(), Constants.Epsilon14);
		Assert.assertEquals(third.getY(), result.getY(), Constants.Epsilon14);
		Assert.assertEquals(third.getZ(), result.getZ(), Constants.Epsilon14);
	}

	/**
	 *  
	Tests rotation by a  {@link UnitQuaternion}.
	

	 */
	@Test
	public final void testRotateByUnitQuaternion() {
		double angle = Math.PI / 3.0;
		// half angle of 120 degree rotation
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		Cartesian axis = Cartesian.toCartesian((new Cartesian(1.0, 1.0, 1.0)).normalize());
		// unit vector along [1,1,1]
		double w = cos;
		double x = sin * axis.getX();
		double y = sin * axis.getY();
		double z = sin * axis.getZ();
		// The original vector is along the x-axis.
		Cartesian original = new Cartesian(1.0, 0.0, 0.0);
		// The rotated vector is along the z-axis.
		Cartesian rotated = original.rotate(new UnitQuaternion(w, x, y, z));
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
		Cartesian axis = Cartesian.toCartesian((new Cartesian(1.0, 1.0, 1.0)).normalize());
		// unit vector along [1,1,1]
		double w = cos;
		double x = sin * axis.getX();
		double y = sin * axis.getY();
		double z = sin * axis.getZ();
		// The original vector is along the x-axis.
		Cartesian original = new Cartesian(1.0, 0.0, 0.0);
		// The rotated vector is along the z-axis.
		Cartesian rotated = original.rotate(new Matrix3By3(new UnitQuaternion(w, x, y, z)));
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
		Cartesian object1 = new Cartesian(1.0, 2.0, 3.0);
		Cartesian object2 = new Cartesian(1.0, 2.0, 3.0);
		Cartesian object3 = new Cartesian(1.0, 2.0, 3.1);
		Assert.assertEquals((int) object1.hashCode(), (int) object2.hashCode());
		AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
	}

	/**
	 *  
	Tests ToString method
	

	 */
	@Test
	public final void testToString() {
		double val1 = 1.1;
		double val2 = 2.1;
		double val3 = 3.1;
		String sep = ", ";
		String result = DoubleHelper.toString(val1, CultureInfoHelper.getCurrentCulture()) + sep + DoubleHelper.toString(val2, CultureInfoHelper.getCurrentCulture()) + sep
				+ DoubleHelper.toString(val3, CultureInfoHelper.getCurrentCulture());
		Cartesian test = new Cartesian(val1, val2, val3);
		Assert.assertEquals(result, test.toString());
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