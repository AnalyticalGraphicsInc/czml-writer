using System;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="Matrix3By3"/> type.
    /// </summary>
    [TestFixture]
    public class TestMatrix3By3
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            Matrix3By3 test = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Assert.AreEqual(1.0, test.M11);
            Assert.AreEqual(2.0, test.M12);
            Assert.AreEqual(3.0, test.M13);
            Assert.AreEqual(4.0, test.M21);
            Assert.AreEqual(5.0, test.M22);
            Assert.AreEqual(6.0, test.M23);
            Assert.AreEqual(7.0, test.M31);
            Assert.AreEqual(8.0, test.M32);
            Assert.AreEqual(9.0, test.M33);
        }

        /// <summary>
        /// Tests construction from a <see cref="Quaternion"/>.
        /// </summary>
        [Test]
        public void TestFromQuaternion()
        {
            UnitQuaternion quaternion = UnitQuaternion.Identity;

            Matrix3By3 matrix = new Matrix3By3(quaternion);
            Assert.AreEqual(1.0, matrix.M11);
            Assert.AreEqual(0.0, matrix.M12);
            Assert.AreEqual(0.0, matrix.M13);
            Assert.AreEqual(0.0, matrix.M21);
            Assert.AreEqual(1.0, matrix.M22);
            Assert.AreEqual(0.0, matrix.M23);
            Assert.AreEqual(0.0, matrix.M31);
            Assert.AreEqual(0.0, matrix.M32);
            Assert.AreEqual(1.0, matrix.M33);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        public void TestEquality()
        {
            Matrix3By3 first = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Matrix3By3 second = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            for (int i = 0; i < 9; ++i)
            {
                double[] values = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 };

                values[i] = 0.0;

                second = new Matrix3By3(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
                Assert.AreNotEqual(first, second);
                Assert.AreNotEqual(second, first);
                Assert.IsFalse(first == second);
                Assert.IsFalse(second == first);
                Assert.IsTrue(first != second);
                Assert.IsTrue(second != first);
                Assert.IsFalse(first.Equals(second));
                Assert.IsFalse(second.Equals(first));
            }
        }

        /// <summary>
        /// Tests to ensure the equality fails when comparing incorrect type.
        /// </summary>
        [Test]
        public void TestEqualityWithWrongType()
        {
            Matrix3By3 first = Matrix3By3.Identity;
            Cartesian second = new Cartesian(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests the <see cref="Matrix3By3.EqualsEpsilon"/> method.
        /// </summary>
        [Test]
        public void TestEqualsEpsilon()
        {
            Matrix3By3 first = new Matrix3By3(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            Matrix3By3 second = new Matrix3By3(1e-2, 1e-3, 1e-4, 1e-5, 1e-6, 1e-7, 1e-8, 1e-9, 1e-10);
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-1));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-2));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-3));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-4));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-5));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-6));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-7));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-8));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-9));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-10));
        }

        /// <summary>
        /// Tests indexing.
        /// </summary>
        [Test]
        public void TestIndex()
        {
            Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Assert.AreEqual(1.0, original[0, 0]);
            Assert.AreEqual(2.0, original[0, 1]);
            Assert.AreEqual(3.0, original[0, 2]);
            Assert.AreEqual(4.0, original[1, 0]);
            Assert.AreEqual(5.0, original[1, 1]);
            Assert.AreEqual(6.0, original[1, 2]);
            Assert.AreEqual(7.0, original[2, 0]);
            Assert.AreEqual(8.0, original[2, 1]);
            Assert.AreEqual(9.0, original[2, 2]);
        }

        /// <summary>
        /// Tests the <see cref="Matrix3By3.Transpose"/> method.
        /// </summary>
        [Test]
        public void TestTranspose()
        {
            Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Matrix3By3 transposed = original.Transpose();
            Assert.AreEqual(transposed.M11, original.M11);
            Assert.AreEqual(transposed.M12, original.M21);
            Assert.AreEqual(transposed.M13, original.M31);
            Assert.AreEqual(transposed.M21, original.M12);
            Assert.AreEqual(transposed.M22, original.M22);
            Assert.AreEqual(transposed.M23, original.M32);
            Assert.AreEqual(transposed.M31, original.M13);
            Assert.AreEqual(transposed.M32, original.M23);
            Assert.AreEqual(transposed.M33, original.M33);
        }

        /// <summary>
        /// Tests <see cref="Matrix3By3.Identity"/>.
        /// </summary>
        [Test]
        public void TestIdentity()
        {
            Matrix3By3 identity = Matrix3By3.Identity;
            Assert.AreEqual(1.0, identity.M11);
            Assert.AreEqual(0.0, identity.M12);
            Assert.AreEqual(0.0, identity.M13);
            Assert.AreEqual(0.0, identity.M21);
            Assert.AreEqual(1.0, identity.M22);
            Assert.AreEqual(0.0, identity.M23);
            Assert.AreEqual(0.0, identity.M31);
            Assert.AreEqual(0.0, identity.M32);
            Assert.AreEqual(1.0, identity.M33);
        }

        /// <summary>
        /// Tests the <see cref="Matrix3By3.IsUndefined"/> method.
        /// </summary>
        [Test]
        public void TestIsUndefined()
        {
            Assert.IsFalse(Matrix3By3.Identity.IsUndefined);
            Assert.IsTrue(Matrix3By3.Undefined.IsUndefined);
            //* Check what happens if any of the elements are NaN
            for (int i = 0; i < 9; i++)
            {
                double[] values = new double[9];
                for (int k = 0; k < 9; k++)
                {
                    values[k] = 1.0;
                }
                values[i] = double.NaN;
                Assert.IsTrue(new Matrix3By3(
                    values[0], values[1],values[2],
                    values[3],values[4],values[5],
                    values[6],values[7],values[8]).IsUndefined);
            }
        }

        /// <summary>
        /// Tests multiplication by a scalar.
        /// </summary>
        [Test]
        public void TestMultiplyByScalar()
        {
            Matrix3By3 test = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Matrix3By3 result = test.Multiply(-2.0);
            Assert.AreEqual(-2.0, result.M11);
            Assert.AreEqual(-4.0, result.M12);
            Assert.AreEqual(-6.0, result.M13);
            Assert.AreEqual(-8.0, result.M21);
            Assert.AreEqual(-10.0, result.M22);
            Assert.AreEqual(-12.0, result.M23);
            Assert.AreEqual(-14.0, result.M31);
            Assert.AreEqual(-16.0, result.M32);
            Assert.AreEqual(-18.0, result.M33);

            result = test * -2.0;
            Assert.AreEqual(-2.0, result.M11);
            Assert.AreEqual(-4.0, result.M12);
            Assert.AreEqual(-6.0, result.M13);
            Assert.AreEqual(-8.0, result.M21);
            Assert.AreEqual(-10.0, result.M22);
            Assert.AreEqual(-12.0, result.M23);
            Assert.AreEqual(-14.0, result.M31);
            Assert.AreEqual(-16.0, result.M32);
            Assert.AreEqual(-18.0, result.M33);

            result = -2.0 * test;
            Assert.AreEqual(-2.0, result.M11);
            Assert.AreEqual(-4.0, result.M12);
            Assert.AreEqual(-6.0, result.M13);
            Assert.AreEqual(-8.0, result.M21);
            Assert.AreEqual(-10.0, result.M22);
            Assert.AreEqual(-12.0, result.M23);
            Assert.AreEqual(-14.0, result.M31);
            Assert.AreEqual(-16.0, result.M32);
            Assert.AreEqual(-18.0, result.M33);
        }

        /// <summary>
        /// Tests multiplication by another <see cref="Matrix3By3"/>.
        /// </summary>
        [Test]
        public void TestMultiplyByMatrix()
        {
            double angle = Math.PI / 4.0;
            double cos = Math.Cos(angle / 2.0);
            double sin = Math.Sin(angle / 2.0);

            double a = cos * cos - sin * sin / 3.0;
            double b = 2.0 * (sin * sin + sin * cos * Math.Sqrt(3.0)) / 3.0;
            double c = 2.0 * (sin * sin - sin * cos * Math.Sqrt(3.0)) / 3.0;

            // The matrix here is formed from the orthonormal set obtained by rotating
            // the x-axis, y-axis, and z-axis through an angle of 45 degrees about
            // the (1,1,1) vector.
            Matrix3By3 test = new Matrix3By3(a, c, b, b, a, c, c, b, a);
            Matrix3By3 transpose = test.Transpose();

            Matrix3By3 result = test.Multiply(transpose);
            Assert.IsTrue(result.EqualsEpsilon(Matrix3By3.Identity, 1e-16));

            result = test * transpose;
            Assert.IsTrue(result.EqualsEpsilon(Matrix3By3.Identity, 1e-16));
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestFirstIndexTooHigh()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[3, 0];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestFirstIndexTooLow()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[-1, 0];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestSecondIndexTooHigh0()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[0, 3];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestSecondIndexTooLow0()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[0, -1];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestSecondIndexTooHigh1()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[1, -1];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestSecondIndexTooLow1()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[1, -1];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestSecondIndexTooHigh2()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[2, 3];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestSecondIndexTooLow2()
        {
            Matrix3By3 diagonal = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);
            double bad = diagonal[2, -1];
        }

        /// <summary>
        /// Tests that Matrix3By3.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            Matrix3By3 object1 = Matrix3By3.Identity;
            Matrix3By3 object2 = Matrix3By3.Identity;
            Matrix3By3 object3 = new Matrix3By3();
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        /// <summary>
        /// Tests the zero matrix
        /// </summary>
        [Test]
        public void TestZeroMatrix()
        {
            Matrix3By3 zero = Matrix3By3.Zero;
            Assert.AreEqual(0.0, zero.M11);
            Assert.AreEqual(0.0, zero.M12);
            Assert.AreEqual(0.0, zero.M13);
            Assert.AreEqual(0.0, zero.M21);
            Assert.AreEqual(0.0, zero.M22);
            Assert.AreEqual(0.0, zero.M23);
            Assert.AreEqual(0.0, zero.M31);
            Assert.AreEqual(0.0, zero.M32);
            Assert.AreEqual(0.0, zero.M33);
        }

        /// <summary>
        /// Tests the cross product equivilant matrix
        /// Diagonal Matrix
        /// </summary>
        [Test]
        public void TestMatrixReturns()
        {
            double x = 1;
            double y = 2;
            double z = 3;
            Matrix3By3 mat1 = Matrix3By3.CrossProductEquivalentMatrix(new Cartesian(x, y, z));
            Assert.AreEqual(0.0, mat1.M11);
            Assert.AreEqual(-z, mat1.M12);
            Assert.AreEqual(y, mat1.M13);
            Assert.AreEqual(z, mat1.M21);
            Assert.AreEqual(0, mat1.M22);
            Assert.AreEqual(-x, mat1.M23);
            Assert.AreEqual(-y, mat1.M31);
            Assert.AreEqual(x, mat1.M32);
            Assert.AreEqual(0.0, mat1.M33);

            UnitCartesian u = new UnitCartesian(x, y, z);
            x = u.X;
            y = u.Y;
            z = u.Z;
            Matrix3By3 mat2 = Matrix3By3.CrossProductEquivalentMatrix(u);
            Assert.AreEqual(0.0, mat2.M11);
            Assert.AreEqual(-z, mat2.M12);
            Assert.AreEqual(y, mat2.M13);
            Assert.AreEqual(z, mat2.M21);
            Assert.AreEqual(0, mat2.M22);
            Assert.AreEqual(-x, mat2.M23);
            Assert.AreEqual(-y, mat2.M31);
            Assert.AreEqual(x, mat2.M32);
            Assert.AreEqual(0.0, mat2.M33);

            Matrix3By3 mat3 = Matrix3By3.DiagonalMatrix(new Cartesian(1, 2, 3));
            Assert.AreEqual(mat3.M11, 1);
            Assert.AreEqual(mat3.M22, 2);
            Assert.AreEqual(mat3.M33, 3);
            Matrix3By3 mat4 = Matrix3By3.DiagonalMatrix(new UnitCartesian(1, 0, 0));
            Assert.AreEqual(mat4.M11, 1);
            Assert.AreEqual(mat4.M22, 0);
            Assert.AreEqual(mat4.M33, 0);

        }

        /// <summary>
        /// Tests math operators
        /// </summary>
        [Test]
        public void TestMathOperators()
        {
            Matrix3By3 test1 = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Matrix3By3 test2 = new Matrix3By3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
            Assert.IsTrue(Matrix3By3.Zero.Equals(test1.Subtract(test2)));
            Assert.IsTrue(Matrix3By3.Zero.Equals(test1 - test2));
            Assert.IsTrue((test2 * 2.0).Equals(test1.Add(test2)));
            Assert.IsTrue((test2 * 2.0).Equals(test1+test2));
            Assert.IsTrue((new Matrix3By3(30, 36, 42, 66, 81, 96, 102, 126, 150).Equals(test1.Multiply(test2))));
            Assert.IsTrue((new Matrix3By3(30, 36, 42, 66, 81, 96, 102, 126, 150).Equals(test1 * test2)));
        }

        /// <summary>
        /// Tests math operators
        /// </summary>
        [Test]
        public void TestMathOperatorsWithCartesian()
        {
            Matrix3By3 test = new Matrix3By3(1.0, 2.0, 4.0, 2.0, 3.0, 5.0, 4.0, 5.0, 6.0);
            Cartesian mult = new Cartesian(1, 2, 3);
            Assert.IsTrue((new Cartesian(17, 23, 32).Equals(test.Multiply(mult))));
            Assert.IsTrue((new Cartesian(17, 23, 32).Equals(test * mult)));
        }

        /// <summary>
        /// Test invert and by doing so, determinant
        /// </summary>
        [Test]
        public void TestInvert()
        {
            Matrix3By3 test = new Matrix3By3(1.0, 5.0, 2.0, 1.0, 1.0, 7.0, 0.0, -3.0, 4.0);
            Matrix3By3 inv = test.Invert();
            Assert.AreEqual(-25.0, inv.M11);
            Assert.AreEqual(26.0, inv.M12);
            Assert.AreEqual(-33.0, inv.M13);
            Assert.AreEqual(4.0, inv.M21);
            Assert.AreEqual(-4.0, inv.M22);
            Assert.AreEqual(5.0, inv.M23);
            Assert.AreEqual(3.0, inv.M31);
            Assert.AreEqual(-3.0, inv.M32);
            Assert.AreEqual(4.0, inv.M33);
        }

        /// <summary>
        /// Test zero invert exception
        /// </summary>
        [Test]
        [ExpectedException (typeof(ArithmeticException))]
        public void TestZeroInvertException()
        {
            Matrix3By3 mat = Matrix3By3.Zero.Invert();
        }
    }
}
