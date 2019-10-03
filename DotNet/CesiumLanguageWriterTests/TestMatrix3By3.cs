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
            Matrix3By3 matrix = new Matrix3By3(1.0, 2.0, 3.0,
                                               4.0, 5.0, 6.0,
                                               7.0, 8.0, 9.0);
            Assert.AreEqual(1.0, matrix.M11);
            Assert.AreEqual(2.0, matrix.M12);
            Assert.AreEqual(3.0, matrix.M13);
            Assert.AreEqual(4.0, matrix.M21);
            Assert.AreEqual(5.0, matrix.M22);
            Assert.AreEqual(6.0, matrix.M23);
            Assert.AreEqual(7.0, matrix.M31);
            Assert.AreEqual(8.0, matrix.M32);
            Assert.AreEqual(9.0, matrix.M33);
        }

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
            Matrix3By3 first = new Matrix3By3(1.0, 2.0, 3.0,
                                              4.0, 5.0, 6.0,
                                              7.0, 8.0, 9.0);
            Matrix3By3 second = new Matrix3By3(1.0, 2.0, 3.0,
                                               4.0, 5.0, 6.0,
                                               7.0, 8.0, 9.0);
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
                double[] values =
                {
                    1.0, 2.0, 3.0,
                    4.0, 5.0, 6.0,
                    7.0, 8.0, 9.0,
                };
                values[i] = 0.0;

                second = new Matrix3By3(values[0], values[1], values[2],
                                        values[3], values[4], values[5],
                                        values[6], values[7], values[8]);
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

            // ReSharper disable once SuspiciousTypeConversion.Global
            Assert.IsFalse(first.Equals(second));
        }

        [Test]
        public void TestEqualsEpsilon()
        {
            Matrix3By3 first = new Matrix3By3(0.0, 0.0, 0.0,
                                              0.0, 0.0, 0.0,
                                              0.0, 0.0, 0.0);
            Matrix3By3 second = new Matrix3By3(1e-2, 1e-3, 1e-4,
                                               1e-5, 1e-6, 1e-7,
                                               1e-8, 1e-9, 1e-10);
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-1));
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-2));
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
            Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0,
                                                 4.0, 5.0, 6.0,
                                                 7.0, 8.0, 9.0);
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

        [Test]
        public void TestTranspose()
        {
            Matrix3By3 original = new Matrix3By3(1.0, 2.0, 3.0,
                                                 4.0, 5.0, 6.0,
                                                 7.0, 8.0, 9.0);
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

        [Test]
        public void TestIsUndefined()
        {
            Assert.IsFalse(Matrix3By3.Identity.IsUndefined);
            Assert.IsTrue(Matrix3By3.Undefined.IsUndefined);
            // Check what happens if any of the elements are NaN
            for (int i = 0; i < 9; i++)
            {
                double[] values =
                {
                    1.0, 1.0, 1.0,
                    1.0, 1.0, 1.0,
                    1.0, 1.0, 1.0,
                };
                values[i] = double.NaN;

                var matrix = new Matrix3By3(values[0], values[1], values[2],
                                            values[3], values[4], values[5],
                                            values[6], values[7], values[8]);
                Assert.IsTrue(matrix.IsUndefined);
            }
        }

        /// <summary>
        /// Tests multiplication by a scalar.
        /// </summary>
        [Test]
        public void TestMultiplyByScalar()
        {
            Matrix3By3 matrix = new Matrix3By3(1.0, 2.0, 3.0,
                                               4.0, 5.0, 6.0,
                                               7.0, 8.0, 9.0);
            Matrix3By3 result = matrix.Multiply(-2.0);
            Assert.AreEqual(-2.0, result.M11);
            Assert.AreEqual(-4.0, result.M12);
            Assert.AreEqual(-6.0, result.M13);
            Assert.AreEqual(-8.0, result.M21);
            Assert.AreEqual(-10.0, result.M22);
            Assert.AreEqual(-12.0, result.M23);
            Assert.AreEqual(-14.0, result.M31);
            Assert.AreEqual(-16.0, result.M32);
            Assert.AreEqual(-18.0, result.M33);

            result = matrix * -2.0;
            Assert.AreEqual(-2.0, result.M11);
            Assert.AreEqual(-4.0, result.M12);
            Assert.AreEqual(-6.0, result.M13);
            Assert.AreEqual(-8.0, result.M21);
            Assert.AreEqual(-10.0, result.M22);
            Assert.AreEqual(-12.0, result.M23);
            Assert.AreEqual(-14.0, result.M31);
            Assert.AreEqual(-16.0, result.M32);
            Assert.AreEqual(-18.0, result.M33);

            result = -2.0 * matrix;
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
            const double angle = Math.PI / 4.0;
            double cos = Math.Cos(angle / 2.0);
            double sin = Math.Sin(angle / 2.0);

            double a = cos * cos - sin * sin / 3.0;
            double b = 2.0 * (sin * sin + sin * cos * Math.Sqrt(3.0)) / 3.0;
            double c = 2.0 * (sin * sin - sin * cos * Math.Sqrt(3.0)) / 3.0;

            // The matrix here is formed from the orthonormal set obtained by rotating
            // the x-axis, y-axis, and z-axis through an angle of 45 degrees about
            // the (1,1,1) vector.
            Matrix3By3 matrix = new Matrix3By3(a, c, b,
                                               b, a, c,
                                               c, b, a);
            Matrix3By3 transpose = matrix.Transpose();

            Matrix3By3 result = matrix.Multiply(transpose);
            Assert.IsTrue(result.EqualsEpsilon(Matrix3By3.Identity, Constants.Epsilon16));

            result = matrix * transpose;
            Assert.IsTrue(result.EqualsEpsilon(Matrix3By3.Identity, Constants.Epsilon16));
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [Combinatorial]
        public void IndexerThrowsWithRowOutOfRange([Values(-1, 3)] int row,
                                                   [Range(0, 2)] int column)
        {
            Matrix3By3 matrix = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);

            var exception = Assert.Throws<ArgumentOutOfRangeException>(() =>
            {
                double unused = matrix[row, column];
            });
            Assert.AreEqual("row", exception.ParamName);
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [Combinatorial]
        public void IndexerThrowsWithColumnOutOfRange([Range(0, 2)] int row,
                                                      [Values(-1, 3)] int column)
        {
            Matrix3By3 matrix = Matrix3By3.DiagonalMatrix(-3.0, 1.0, 5.0);

            var exception = Assert.Throws<ArgumentOutOfRangeException>(() =>
            {
                double unused = matrix[row, column];
            });
            Assert.AreEqual("column", exception.ParamName);
        }

        /// <summary>
        /// Tests that GetHashCode returns something at least reasonably random.
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
        /// Tests math operators
        /// </summary>
        [Test]
        public void TestMathOperators()
        {
            var matrix1 = new Matrix3By3(1.0, 2.0, 3.0,
                                         4.0, 5.0, 6.0,
                                         7.0, 8.0, 9.0);
            var matrix2 = new Matrix3By3(1.0, 2.0, 3.0,
                                         4.0, 5.0, 6.0,
                                         7.0, 8.0, 9.0);

            Assert.AreEqual(Matrix3By3.Zero, matrix1.Subtract(matrix2));
            Assert.AreEqual(Matrix3By3.Zero, matrix1 - matrix2);
            Assert.AreEqual(matrix2 * 2.0, matrix1.Add(matrix2));
            Assert.AreEqual(matrix2 * 2.0, matrix1 + matrix2);

            var expected = new Matrix3By3(30, 36, 42,
                                          66, 81, 96,
                                          102, 126, 150);
            Assert.AreEqual(expected, matrix1.Multiply(matrix2));
            Assert.AreEqual(expected, matrix1 * matrix2);
        }
        /// <summary>
        /// Tests math operators
        /// </summary>
        [Test]
        public void TestMathOperatorsWithCartesian()
        {
            Matrix3By3 matrix = new Matrix3By3(1.0, 2.0, 4.0,
                                               2.0, 3.0, 5.0,
                                               4.0, 5.0, 6.0);
            Cartesian vector = new Cartesian(1, 2, 3);

            var expected = new Cartesian(17, 23, 32);
            Assert.AreEqual(expected, matrix.Multiply(vector));
            Assert.AreEqual(expected, matrix * vector);
        }
    }
}