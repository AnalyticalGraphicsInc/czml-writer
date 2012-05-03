using System;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="UnitCartesian3"/> type.
    /// </summary>
    [TestFixture]
    public class TestUnitCartesian3
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            UnitCartesian3 test = new UnitCartesian3(2.0, 3.0, 6.0);
            Assert.AreEqual(2.0 / 7.0, test.X);
            Assert.AreEqual(3.0 / 7.0, test.Y);
            Assert.AreEqual(6.0 / 7.0, test.Z);
        }

        /// <summary>
        /// Tests initialization from an array of 3 coordinates works correctly.
        /// </summary>
        [Test]
        public void TestFromArray()
        {
            double[] values = { 2.0, 3.0, 6.0 };

            UnitCartesian3 test = new UnitCartesian3(values);
            Assert.AreEqual(values.Length, test.Length);
            Assert.AreEqual(test.X, test[0]);
            Assert.AreEqual(test.Y, test[1]);
            Assert.AreEqual(test.Z, test[2]);
        }

        /// <summary>
        /// Tests initialization from <see cref="Cartesian3"/> coordinates.
        /// </summary>
        [Test]
        public void TestFromCartesian()
        {
            UnitCartesian3 test = new UnitCartesian3(new Cartesian3(2.0, 3.0, 6.0));
            Assert.AreEqual(2.0 / 7.0, test.X, Constants.Epsilon15);
            Assert.AreEqual(3.0 / 7.0, test.Y, Constants.Epsilon15);
            Assert.AreEqual(6.0 / 7.0, test.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests initialization from <see cref="Cartesian3"/> coordinates.
        /// </summary>
        [Test]
        public void TestFromCartesianAndReturnMagnitude()
        {
            double magnitude;
            UnitCartesian3 test = new UnitCartesian3(new Cartesian3(2.0, 3.0, 6.0), out magnitude);
            Assert.AreEqual(2.0 / 7.0, test.X, Constants.Epsilon15);
            Assert.AreEqual(3.0 / 7.0, test.Y, Constants.Epsilon15);
            Assert.AreEqual(6.0 / 7.0, test.Z, Constants.Epsilon15);
            Assert.AreEqual(7.0, magnitude, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests initialization from coordinates.
        /// </summary>
        [Test]
        public void TestInitializeAndReturnMagnitude()
        {
            double magnitude;
            UnitCartesian3 test = new UnitCartesian3(2.0, 3.0, 6.0, out magnitude);
            Assert.AreEqual(2.0 / 7.0, test.X, Constants.Epsilon15);
            Assert.AreEqual(3.0 / 7.0, test.Y, Constants.Epsilon15);
            Assert.AreEqual(6.0 / 7.0, test.Z, Constants.Epsilon15);
            Assert.AreEqual(7.0, magnitude, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests initialization from clock and cone angles.
        /// </summary>
        [Test]
        public void TestFromClockAndCone()
        {
            double fortyFiveDegrees = Math.PI / 4.0;
            double thirtyDegrees = Math.PI / 6.0;

            UnitCartesian3 test = new UnitCartesian3(thirtyDegrees, fortyFiveDegrees);
            Assert.AreEqual(Math.Sqrt(3.0) / Math.Sqrt(8.0), test.X, Constants.Epsilon15);
            Assert.AreEqual(1.0 / Math.Sqrt(8.0), test.Y, Constants.Epsilon15);
            Assert.AreEqual(1.0 / Math.Sqrt(2.0), test.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        public void TestEquality()
        {
            UnitCartesian3 first = new UnitCartesian3(1.0, 2.0, 3.0);
            UnitCartesian3 second = new UnitCartesian3(1.0, 2.0, 3.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            second = new UnitCartesian3(0.0, 2.0, 3.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new UnitCartesian3(1.0, 0.0, 3.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new UnitCartesian3(1.0, 2.0, 0.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian3.EqualsEpsilon"/> method.
        /// </summary>
        [Test]
        public void TestEqualsEpsilon()
        {
            UnitCartesian3 first = new UnitCartesian3(1.0, 1.0, 1.0);
            UnitCartesian3 second = new UnitCartesian3(0.99, 1.0, 1.01);
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-1));
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-2));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-3));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-4));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-5));
        }

        /// <summary>
        /// Tests to ensure the equality fails when comparing incorrect type.
        /// </summary>
        [Test]
        public void TestEqualityWithWrongType()
        {
            UnitCartesian3 first = new UnitCartesian3(1.0, 2.0, 3.0);
            Cartographic second = new Cartographic(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian3.IsUndefined"/> method.
        /// </summary>
        [Test]
        public void TestIsUndefined()
        {
            Assert.IsFalse(new UnitCartesian3(1.0, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(UnitCartesian3.Undefined.IsUndefined);
            Assert.IsTrue(new UnitCartesian3(Double.NaN, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(new UnitCartesian3(1.0, Double.NaN, 1.0).IsUndefined);
            Assert.IsTrue(new UnitCartesian3(1.0, 1.0, Double.NaN).IsUndefined);
        }

        /// <summary>
        /// Tests that rotation by an invalid <see cref="ElementaryRotation"/> produces an
        /// <see cref="DivideByZeroException"/>.
        /// </summary>
        [Test]
        [ExpectedException(typeof(DivideByZeroException))]
        public void TestFromZero()
        {
            UnitCartesian3 first = new UnitCartesian3(Cartesian3.Zero);
        }

        /// <summary>
        /// Tests that rotation by an invalid <see cref="ElementaryRotation"/> produces an
        /// <see cref="NotFiniteNumberException"/>.
        /// </summary>
        [Test]
        [ExpectedException(typeof(NotFiniteNumberException))]
        public void TestFromInfinity()
        {
            UnitCartesian3 first = new UnitCartesian3(Double.PositiveInfinity, 0.0, 0.0);
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian3.AngleBetween"/> method.
        /// </summary>
        [Test]
        public void TestAngleBetween()
        {
            double fortyFiveDegrees = Math.PI / 4.0;

            UnitCartesian3 first = new UnitCartesian3(1.0, 1.0, 0.0);
            UnitCartesian3 second = new UnitCartesian3(1.0, 1.0, Math.Sqrt(2.0));
            Assert.AreEqual(fortyFiveDegrees, second.AngleBetween(first), Constants.Epsilon15);
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian3.MostOrthogonalAxis"/> method.
        /// </summary>
        [Test]
        public void TestMostOrthogonalAxis()
        {
            UnitCartesian3 Cartesian3 = new UnitCartesian3(1.0, 2.0, 3.0);
            Assert.AreEqual(UnitCartesian3.UnitX, Cartesian3.MostOrthogonalAxis);
            Cartesian3 = new UnitCartesian3(2.0, 3.0, 1.0);
            Assert.AreEqual(UnitCartesian3.UnitZ, Cartesian3.MostOrthogonalAxis);
            Cartesian3 = new UnitCartesian3(3.0, 1.0, 2.0);
            Assert.AreEqual(UnitCartesian3.UnitY, Cartesian3.MostOrthogonalAxis);
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian3.MostParallelAxis"/> method.
        /// </summary>
        [Test]
        public void TestMostParallelAxis()
        {
            UnitCartesian3 Cartesian3 = new UnitCartesian3(1.0, 2.0, 3.0);
            Assert.AreEqual(UnitCartesian3.UnitZ, Cartesian3.MostParallelAxis);
            Cartesian3 = new UnitCartesian3(2.0, 3.0, 1.0);
            Assert.AreEqual(UnitCartesian3.UnitY, Cartesian3.MostParallelAxis);
            Cartesian3 = new UnitCartesian3(3.0, 1.0, 2.0);
            Assert.AreEqual(UnitCartesian3.UnitX, Cartesian3.MostParallelAxis);
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian3.Invert"/> method.
        /// </summary>
        [Test]
        public void TestInvert()
        {
            UnitCartesian3 Cartesian3 = new UnitCartesian3(2.0, 3.0, 6.0);
            UnitCartesian3 inverted = Cartesian3.Invert();
            Assert.AreEqual(-2.0 / 7.0, inverted.X);
            Assert.AreEqual(-3.0 / 7.0, inverted.Y);
            Assert.AreEqual(-6.0 / 7.0, inverted.Z);
        }

        /// <summary>
        /// Tests negation of a set of coordinates.
        /// </summary>
        [Test]
        public void TestNegation()
        {
            UnitCartesian3 u = -new UnitCartesian3(2.0, 3.0, 6.0);
            Assert.AreEqual(-2.0 / 7.0, u.X);
            Assert.AreEqual(-3.0 / 7.0, u.Y);
            Assert.AreEqual(-6.0 / 7.0, u.Z);
        }

        /// <summary>
        /// Tests the addition methods and operators.
        /// </summary>
        [Test]
        public void TestAdd()
        {
            UnitCartesian3 original1 = UnitCartesian3.UnitX;
            UnitCartesian3 toAdd1 = UnitCartesian3.UnitY;
            Cartesian3 result = original1 + toAdd1;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(1.0, result.Y);
            Assert.AreEqual(0.0, result.Z);

            Cartesian3 toAdd2 = new Cartesian3(0.0, 1.0, 1.0);
            result = original1 + toAdd2;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(1.0, result.Y);
            Assert.AreEqual(1.0, result.Z);

            Cartesian3 original2 = new Cartesian3(0.0, 1.0, 1.0);
            UnitCartesian3 toAdd3 = UnitCartesian3.UnitX;
            result = original2 + toAdd3;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(1.0, result.Y);
            Assert.AreEqual(1.0, result.Z);
        }

        /// <summary>
        /// Tests the subtraction methods and operators.
        /// </summary>
        [Test]
        public void TestSubtract()
        {
            UnitCartesian3 original = UnitCartesian3.UnitX;
            UnitCartesian3 toAdd1 = UnitCartesian3.UnitY;
            Cartesian3 result = original - toAdd1;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(-1.0, result.Y);
            Assert.AreEqual(0.0, result.Z);

            Cartesian3 toAdd2 = new Cartesian3(0.0, 1.0, 1.0);
            result = original - toAdd2;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(-1.0, result.Y);
            Assert.AreEqual(-1.0, result.Z);

            Cartesian3 original2 = new Cartesian3(0.0, 1.0, 1.0);
            UnitCartesian3 toAdd3 = UnitCartesian3.UnitX;
            result = original2 - toAdd3;
            Assert.AreEqual(-1.0, result.X);
            Assert.AreEqual(1.0, result.Y);
            Assert.AreEqual(1.0, result.Z);
        }

        /// <summary>
        /// Tests the multiplication methods and operators.
        /// </summary>
        [Test]
        public void TestMultiply()
        {
            UnitCartesian3 original = new UnitCartesian3(2.0, 3.0, 6.0);
            Cartesian3 multiplied = original * 7.0;
            Assert.AreEqual(2.0, multiplied.X);
            Assert.AreEqual(3.0, multiplied.Y);
            Assert.AreEqual(6.0, multiplied.Z);

            multiplied = 7.0 * original;
            Assert.AreEqual(2.0, multiplied.X);
            Assert.AreEqual(3.0, multiplied.Y);
            Assert.AreEqual(6.0, multiplied.Z);
        }

        /// <summary>
        /// Tests the multiplication methods and operators.
        /// </summary>
        [Test]
        public void TestDivide()
        {
            UnitCartesian3 original = new UnitCartesian3(2.0, 3.0, 6.0);
            Cartesian3 result = original / 2.0;
            Assert.AreEqual(2.0 / 14.0, result.X);
            Assert.AreEqual(3.0 / 14.0, result.Y);
            Assert.AreEqual(6.0 / 14.0, result.Z);

            result = original.Divide(2.0);
            Assert.AreEqual(2.0 / 14.0, result.X);
            Assert.AreEqual(3.0 / 14.0, result.Y);
            Assert.AreEqual(6.0 / 14.0, result.Z);
        }

        /// <summary>
        /// Tests the Dot method.
        /// </summary>
        [Test]
        public void TestDotProduct()
        {
            UnitCartesian3 first = new UnitCartesian3(1.0, 3.0, -2.0);
            UnitCartesian3 second = new UnitCartesian3(4.0, -2.0, -1.0);
            Assert.AreEqual(0, first.Dot(second), Constants.Epsilon15);
            Assert.AreEqual(0, second.Dot(first), Constants.Epsilon15);

            Cartesian3 result = new Cartesian3(4.0, -2.0, -1.0);
            Assert.AreEqual(0, first.Dot(result));
        }

        /// <summary>
        /// Tests the Cross method.
        /// </summary>
        [Test]
        public void TestCrossProduct()
        {
            double angle = Math.PI / 4.0;
            double cos = Math.Cos(angle / 2.0);
            double sin = Math.Sin(angle / 2.0);

            double a = cos * cos - sin * sin / 3.0;
            double b = 2.0 * (sin * sin + sin * cos * Math.Sqrt(3.0)) / 3.0;
            double c = 2.0 * (sin * sin - sin * cos * Math.Sqrt(3.0)) / 3.0;

            // The three vectors here are the orthonormal set obtained by rotating
            // the x-axis, y-axis, and z-axis through an angle of 45 degrees about
            // the (1,1,1) vector.
            UnitCartesian3 first = new UnitCartesian3(a, b, c);
            UnitCartesian3 second = new UnitCartesian3(c, a, b);
            UnitCartesian3 third = new UnitCartesian3(b, c, a);
            Cartesian3 result = first.Cross(second);

            Assert.AreEqual(third.X, result.X, Constants.Epsilon14);
            Assert.AreEqual(third.Y, result.Y, Constants.Epsilon14);
            Assert.AreEqual(third.Z, result.Z, Constants.Epsilon14);

            Cartesian3 Cartesian3 = new Cartesian3(c, a, b);
            result = first.Cross(Cartesian3);

            Assert.AreEqual(third.X, result.X, Constants.Epsilon14);
            Assert.AreEqual(third.Y, result.Y, Constants.Epsilon14);
            Assert.AreEqual(third.Z, result.Z, Constants.Epsilon14);
        }

        /// <summary>
        /// Tests rotation by a <see cref="UnitQuaternion"/>.
        /// </summary>
        [Test]
        public void TestRotateByQuaternion()
        {
            double angle = Math.PI / 3.0;  // half angle of 120 degree rotation
            double cos = Math.Cos(angle);
            double sin = Math.Sin(angle);

            UnitCartesian3 axis = new UnitCartesian3(1.0, 1.0, 1.0); // unit vector along [1,1,1]

            double w = cos;
            double x = sin * axis.X;
            double y = sin * axis.Y;
            double z = sin * axis.Z;

            // The original vector is along the x-axis.
            UnitCartesian3 original = UnitCartesian3.UnitX;

            // The rotated vector is along the z-axis.
            UnitCartesian3 rotated = original.Rotate(new UnitQuaternion(w, x, y, z));
            Assert.AreEqual(0.0, rotated.X, Constants.Epsilon15);
            Assert.AreEqual(0.0, rotated.Y, Constants.Epsilon15);
            Assert.AreEqual(1.0, rotated.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests rotation by an <see cref="Matrix3By3"/>.
        /// </summary>
        [Test]
        public void TestRotateByMatrix3By3()
        {
            double angle = Math.PI / 3.0;  // half angle of 120 degree rotation
            double cos = Math.Cos(angle);
            double sin = Math.Sin(angle);

            UnitCartesian3 axis = new UnitCartesian3(1.0, 1.0, 1.0); // unit vector along [1,1,1]

            double w = cos;
            double x = sin * axis.X;
            double y = sin * axis.Y;
            double z = sin * axis.Z;

            // The original vector is along the x-axis.
            UnitCartesian3 original = new UnitCartesian3(1.0, 0.0, 0.0);

            // The rotated vector is along the z-axis.
            UnitCartesian3 rotated = original.Rotate(new Matrix3By3(new UnitQuaternion(w, x, y, z)));
            Assert.AreEqual(0.0, rotated.X, Constants.Epsilon15);
            Assert.AreEqual(0.0, rotated.Y, Constants.Epsilon15);
            Assert.AreEqual(1.0, rotated.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests that Cartesian3.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            UnitCartesian3 object1 = new UnitCartesian3(1.0, 2.0, 3.0);
            UnitCartesian3 object2 = new UnitCartesian3(1.0, 2.0, 3.0);
            UnitCartesian3 object3 = new UnitCartesian3(1.0, 2.0, 3.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        /// <summary>
        /// Tests that construction from a null array of doubles throws the correct exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentNullException))]
        public void TestInitializationFromNull()
        {
            double[] array = null;
            UnitCartesian3 first = new UnitCartesian3(array, 0);
        }

        /// <summary>
        /// Tests that construction from an array of doubles with an incorrect length throws the correct exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestInitializationFromBadArray()
        {
            double[] array = new double[2];
            UnitCartesian3 first = new UnitCartesian3(array, 0);
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooHigh()
        {
            UnitCartesian3 first = new UnitCartesian3(1.0, 2.0, 3.0);
            double bad = first[3];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooLow()
        {
            UnitCartesian3 first = new UnitCartesian3(1.0, 2.0, 3.0);
            double bad = first[-1];
        }

        /// <summary>
        /// Tests ToString method
        /// </summary>
        [Test]
        public void TestToString()
        {
            UnitCartesian3 test1 = new UnitCartesian3(1.0, 0.0, 0.0);
            UnitCartesian3 test2 = new UnitCartesian3(0.0, 1.0, 0.0);
            UnitCartesian3 test3 = new UnitCartesian3(0.0, 0.0, 1.0);

            Assert.AreEqual("1, 0, 0", test1.ToString());
            Assert.AreEqual("0, 1, 0", test2.ToString());
            Assert.AreEqual("0, 0, 1", test3.ToString());
        }
    }
}