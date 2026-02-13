package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
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
 * Tests the {@link Matrix3By3} type.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMatrix3By3 {
    /**
    * Tests that initialization of and access to the type's values works correctly.
    */
    @Test
    public final void testHoldValue() {
        Matrix3By3 matrix = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        AssertHelper.assertEquals(1.0, matrix.getM11());
        AssertHelper.assertEquals(2.0, matrix.getM12());
        AssertHelper.assertEquals(3.0, matrix.getM13());
        AssertHelper.assertEquals(4.0, matrix.getM21());
        AssertHelper.assertEquals(5.0, matrix.getM22());
        AssertHelper.assertEquals(6.0, matrix.getM23());
        AssertHelper.assertEquals(7.0, matrix.getM31());
        AssertHelper.assertEquals(8.0, matrix.getM32());
        AssertHelper.assertEquals(9.0, matrix.getM33());
    }

    @Test
    public final void testFromQuaternion() {
        UnitQuaternion quaternion = UnitQuaternion.getIdentity();
        Matrix3By3 matrix = new Matrix3By3(quaternion);
        AssertHelper.assertEquals(1.0, matrix.getM11());
        AssertHelper.assertEquals(0.0, matrix.getM12());
        AssertHelper.assertEquals(0.0, matrix.getM13());
        AssertHelper.assertEquals(0.0, matrix.getM21());
        AssertHelper.assertEquals(1.0, matrix.getM22());
        AssertHelper.assertEquals(0.0, matrix.getM23());
        AssertHelper.assertEquals(0.0, matrix.getM31());
        AssertHelper.assertEquals(0.0, matrix.getM32());
        AssertHelper.assertEquals(1.0, matrix.getM33());
    }

    /**
    * Tests the equality and inequality methods and operators.
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
    * Tests to ensure the equality fails when comparing incorrect type.
    */
    @Test
    public final void testEqualityWithWrongType() {
        Matrix3By3 first = Matrix3By3.getIdentity();
        Cartesian second = new Cartesian(1.0, 2.0, 3.0);
        // ReSharper disable once SuspiciousTypeConversion.Global
        Assert.assertFalse(first.equals(second));
    }

    @Test
    public final void testEqualsEpsilon() {
        Matrix3By3 first = new Matrix3By3(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        Matrix3By3 second = new Matrix3By3(1e-2, 1e-3, 1e-4, 1e-5, 1e-6, 1e-7, 1e-8, 1e-9, 1e-10);
        Assert.assertTrue(second.equalsEpsilon(first, 1e-1));
        Assert.assertTrue(second.equalsEpsilon(first, 1e-2));
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
    * Tests indexing.
    */
    @Test
    public final void testIndex() {
        Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        AssertHelper.assertEquals(1.0, original.get(0, 0));
        AssertHelper.assertEquals(2.0, original.get(0, 1));
        AssertHelper.assertEquals(3.0, original.get(0, 2));
        AssertHelper.assertEquals(4.0, original.get(1, 0));
        AssertHelper.assertEquals(5.0, original.get(1, 1));
        AssertHelper.assertEquals(6.0, original.get(1, 2));
        AssertHelper.assertEquals(7.0, original.get(2, 0));
        AssertHelper.assertEquals(8.0, original.get(2, 1));
        AssertHelper.assertEquals(9.0, original.get(2, 2));
    }

    @Test
    public final void testTranspose() {
        Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        Matrix3By3 transposed = original.transpose();
        AssertHelper.assertEquals(transposed.getM11(), original.getM11());
        AssertHelper.assertEquals(transposed.getM12(), original.getM21());
        AssertHelper.assertEquals(transposed.getM13(), original.getM31());
        AssertHelper.assertEquals(transposed.getM21(), original.getM12());
        AssertHelper.assertEquals(transposed.getM22(), original.getM22());
        AssertHelper.assertEquals(transposed.getM23(), original.getM32());
        AssertHelper.assertEquals(transposed.getM31(), original.getM13());
        AssertHelper.assertEquals(transposed.getM32(), original.getM23());
        AssertHelper.assertEquals(transposed.getM33(), original.getM33());
    }

    @Test
    public final void testIdentity() {
        Matrix3By3 identity = Matrix3By3.getIdentity();
        AssertHelper.assertEquals(1.0, identity.getM11());
        AssertHelper.assertEquals(0.0, identity.getM12());
        AssertHelper.assertEquals(0.0, identity.getM13());
        AssertHelper.assertEquals(0.0, identity.getM21());
        AssertHelper.assertEquals(1.0, identity.getM22());
        AssertHelper.assertEquals(0.0, identity.getM23());
        AssertHelper.assertEquals(0.0, identity.getM31());
        AssertHelper.assertEquals(0.0, identity.getM32());
        AssertHelper.assertEquals(1.0, identity.getM33());
    }

    @Test
    public final void testIsUndefined() {
        Assert.assertFalse(Matrix3By3.getIdentity().getIsUndefined());
        Assert.assertTrue(Matrix3By3.getUndefined().getIsUndefined());
        // Check what happens if any of the elements are NaN
        for (int i = 0; i < 9; i++) {
            double[] values = {
                1.0,
                1.0,
                1.0,
                1.0,
                1.0,
                1.0,
                1.0,
                1.0,
                1.0
            };
            values[i] = Double.NaN;
            Matrix3By3 matrix = new Matrix3By3(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
            Assert.assertTrue(matrix.getIsUndefined());
        }
    }

    /**
    * Tests multiplication by a scalar.
    */
    @Test
    public final void testMultiplyByScalar() {
        Matrix3By3 matrix = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        Matrix3By3 result = matrix.multiply(-2.0);
        AssertHelper.assertEquals(-2.0, result.getM11());
        AssertHelper.assertEquals(-4.0, result.getM12());
        AssertHelper.assertEquals(-6.0, result.getM13());
        AssertHelper.assertEquals(-8.0, result.getM21());
        AssertHelper.assertEquals(-10.0, result.getM22());
        AssertHelper.assertEquals(-12.0, result.getM23());
        AssertHelper.assertEquals(-14.0, result.getM31());
        AssertHelper.assertEquals(-16.0, result.getM32());
        AssertHelper.assertEquals(-18.0, result.getM33());
        result = Matrix3By3.multiply(matrix, -2.0);
        AssertHelper.assertEquals(-2.0, result.getM11());
        AssertHelper.assertEquals(-4.0, result.getM12());
        AssertHelper.assertEquals(-6.0, result.getM13());
        AssertHelper.assertEquals(-8.0, result.getM21());
        AssertHelper.assertEquals(-10.0, result.getM22());
        AssertHelper.assertEquals(-12.0, result.getM23());
        AssertHelper.assertEquals(-14.0, result.getM31());
        AssertHelper.assertEquals(-16.0, result.getM32());
        AssertHelper.assertEquals(-18.0, result.getM33());
        result = Matrix3By3.multiply(-2.0, matrix);
        AssertHelper.assertEquals(-2.0, result.getM11());
        AssertHelper.assertEquals(-4.0, result.getM12());
        AssertHelper.assertEquals(-6.0, result.getM13());
        AssertHelper.assertEquals(-8.0, result.getM21());
        AssertHelper.assertEquals(-10.0, result.getM22());
        AssertHelper.assertEquals(-12.0, result.getM23());
        AssertHelper.assertEquals(-14.0, result.getM31());
        AssertHelper.assertEquals(-16.0, result.getM32());
        AssertHelper.assertEquals(-18.0, result.getM33());
    }

    /**
    * Tests multiplication by another {@link Matrix3By3}.
    */
    @Test
    public final void testMultiplyByMatrix() {
        final double angle = Math.PI / 4.0;
        double cos = Math.cos(angle / 2.0);
        double sin = Math.sin(angle / 2.0);
        double a = cos * cos - sin * sin / 3.0;
        double b = 2.0 * (sin * sin + sin * cos * Math.sqrt(3.0)) / 3.0;
        double c = 2.0 * (sin * sin - sin * cos * Math.sqrt(3.0)) / 3.0;
        // The matrix here is formed from the orthonormal set obtained by rotating
        // the x-axis, y-axis, and z-axis through an angle of 45 degrees about
        // the (1,1,1) vector.
        Matrix3By3 matrix = new Matrix3By3(a, c, b, b, a, c, c, b, a);
        Matrix3By3 transpose = matrix.transpose();
        Matrix3By3 result = matrix.multiply(transpose);
        Assert.assertTrue(result.equalsEpsilon(Matrix3By3.getIdentity(), Constants.Epsilon16));
        result = Matrix3By3.multiply(matrix, transpose);
        Assert.assertTrue(result.equalsEpsilon(Matrix3By3.getIdentity(), Constants.Epsilon16));
    }

    /**
    * Tests to ensure that an invalid index throws the anticipated exception.
    */
    public final void indexerThrowsWithRowOutOfRange(final int row, final int column) {
        final Matrix3By3 matrix = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
        ArgumentOutOfRangeException exception = AssertHelper.<ArgumentOutOfRangeException> assertThrows(new TypeLiteral<ArgumentOutOfRangeException>() {}, Action.of(() -> {
            double unused = matrix.get(row, column);
        }));
        AssertHelper.assertEquals("row", exception.getParamName());
    }

    @Test
    public final void indexerThrowsWithRowOutOfRange$Test() {
        for (final int row : new int[] {
            -1,
            3
        }) {
            for (int column = 0; column <= 2; column += 1) {
                indexerThrowsWithRowOutOfRange(row, column);
            }
        }
    }

    /**
    * Tests to ensure that an invalid index throws the anticipated exception.
    */
    public final void indexerThrowsWithColumnOutOfRange(final int row, final int column) {
        final Matrix3By3 matrix = Matrix3By3.diagonalMatrix(-3.0, 1.0, 5.0);
        ArgumentOutOfRangeException exception = AssertHelper.<ArgumentOutOfRangeException> assertThrows(new TypeLiteral<ArgumentOutOfRangeException>() {}, Action.of(() -> {
            double unused = matrix.get(row, column);
        }));
        AssertHelper.assertEquals("column", exception.getParamName());
    }

    @Test
    public final void indexerThrowsWithColumnOutOfRange$Test() {
        for (int row = 0; row <= 2; row += 1) {
            for (final int column : new int[] {
                -1,
                3
            }) {
                indexerThrowsWithColumnOutOfRange(row, column);
            }
        }
    }

    /**
    * Tests that GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        Matrix3By3 object1 = Matrix3By3.getIdentity();
        Matrix3By3 object2 = Matrix3By3.getIdentity();
        Matrix3By3 object3 = new Matrix3By3();
        AssertHelper.assertEquals(object1.hashCode(), object2.hashCode());
        AssertHelper.assertNotEqual(object1.hashCode(), object3.hashCode());
    }

    /**
    * Tests the zero matrix
    */
    @Test
    public final void testZeroMatrix() {
        Matrix3By3 zero = Matrix3By3.getZero();
        AssertHelper.assertEquals(0.0, zero.getM11());
        AssertHelper.assertEquals(0.0, zero.getM12());
        AssertHelper.assertEquals(0.0, zero.getM13());
        AssertHelper.assertEquals(0.0, zero.getM21());
        AssertHelper.assertEquals(0.0, zero.getM22());
        AssertHelper.assertEquals(0.0, zero.getM23());
        AssertHelper.assertEquals(0.0, zero.getM31());
        AssertHelper.assertEquals(0.0, zero.getM32());
        AssertHelper.assertEquals(0.0, zero.getM33());
    }

    /**
    * Tests math operators
    */
    @Test
    public final void testMathOperators() {
        Matrix3By3 matrix1 = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        Matrix3By3 matrix2 = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        AssertHelper.assertEquals(Matrix3By3.getZero(), matrix1.subtract(matrix2));
        AssertHelper.assertEquals(Matrix3By3.getZero(), Matrix3By3.subtract(matrix1, matrix2));
        AssertHelper.assertEquals(Matrix3By3.multiply(matrix2, 2.0), matrix1.add(matrix2));
        AssertHelper.assertEquals(Matrix3By3.multiply(matrix2, 2.0), Matrix3By3.add(matrix1, matrix2));
        Matrix3By3 expected = new Matrix3By3(30.0, 36.0, 42.0, 66.0, 81.0, 96.0, 102.0, 126.0, 150.0);
        AssertHelper.assertEquals(expected, matrix1.multiply(matrix2));
        AssertHelper.assertEquals(expected, Matrix3By3.multiply(matrix1, matrix2));
    }

    /**
    * Tests math operators
    */
    @Test
    public final void testMathOperatorsWithCartesian() {
        Matrix3By3 matrix = new Matrix3By3(1.0, 2.0, 4.0, 2.0, 3.0, 5.0, 4.0, 5.0, 6.0);
        Cartesian vector = new Cartesian(1.0, 2.0, 3.0);
        Cartesian expected = new Cartesian(17.0, 23.0, 32.0);
        AssertHelper.assertEquals(expected, matrix.multiply(vector));
        AssertHelper.assertEquals(expected, Matrix3By3.multiply(matrix, vector));
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