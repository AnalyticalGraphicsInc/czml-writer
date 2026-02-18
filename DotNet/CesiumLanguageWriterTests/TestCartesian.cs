using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCartesian
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            Cartesian test = new Cartesian(1.0, 2.0, 3.0);
            Assert.AreEqual(1.0, test.X);
            Assert.AreEqual(2.0, test.Y);
            Assert.AreEqual(3.0, test.Z);
        }

        /// <summary>
        /// Tests implicit conversion from <see cref="UnitCartesian"/> coordinates.
        /// </summary>
        [Test]
        public void TestConversionFromUnitCartesian()
        {
            UnitCartesian unit = new UnitCartesian(1.0, 1.0, 1.0);
            Cartesian test = unit;
            Assert.AreEqual(unit.X, test.X);
            Assert.AreEqual(unit.Y, test.Y);
            Assert.AreEqual(unit.Z, test.Z);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
        public void TestEquality()
        {
            Cartesian first = new Cartesian(1.0, 2.0, 3.0);
            Cartesian second = new Cartesian(1.0, 2.0, 3.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            second = new Cartesian(0.0, 2.0, 3.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new Cartesian(1.0, 0.0, 3.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new Cartesian(1.0, 2.0, 0.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
        }

        [Test]
        public void TestEqualsEpsilon()
        {
            Cartesian first = new Cartesian(1e-1, 1e-2, 1e-3);
            Cartesian second = new Cartesian(1.1e-1, 1.1e-2, 1.1e-3);

            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon1));
            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon2));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon3));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon4));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon5));
        }

        /// <summary>
        /// Tests that the <see cref="Cartesian.EqualsEpsilon"/> method returns true
        /// when the difference is exactly epsilon.
        /// </summary>
        [Test]
        public void TestEqualsEpsilonExact()
        {
            Cartesian first = new Cartesian(0.1, 0.1, 0.1);
            Cartesian second = new Cartesian(0.1, 0.1, 0.1);

            Assert.IsTrue(second.EqualsEpsilon(first, 0));
        }

        /// <summary>
        /// Tests to ensure the equality fails when comparing incorrect type.
        /// </summary>
        [Test]
        [SuppressMessage("ReSharper", "SuspiciousTypeConversion.Global")]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods")]
        public void TestEqualityWithWrongType()
        {
            Cartesian first = new Cartesian(1.0, 2.0, 3.0);
            Cartographic second = new Cartographic(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        [Test]
        public void TestMagnitude()
        {
            Cartesian test = new Cartesian(2.0, 3.0, 6.0);
            Assert.AreEqual(7.0, test.Magnitude);
        }

        [Test]
        public void TestNormalize()
        {
            Cartesian test = new Cartesian(2.0, 3.0, 6.0);
            UnitCartesian unit = test.Normalize();
            Assert.AreEqual(2.0 / 7.0, unit.X);
            Assert.AreEqual(3.0 / 7.0, unit.Y);
            Assert.AreEqual(6.0 / 7.0, unit.Z);
        }

        /// <summary>
        /// Tests that normalization of a <see cref="Cartesian"/> with zero magnitude
        /// produces an <see cref="UnsupportedCaseException"/>.
        /// </summary>
        [Test]
        public void TestNormalizeOfZeroMagnitude()
        {
            Cartesian test = Cartesian.Zero;
            Assert.Throws<DivideByZeroException>(() =>
            {
                var unused = test.Normalize();
            });
        }

        /// <summary>
        /// Tests that normalization of a <see cref="Cartesian"/> with infinite magnitude
        /// produces an <see cref="NotFiniteNumberException"/>.
        /// </summary>
        [Test]
        public void TestNormalizeOfInfiniteMagnitude()
        {
            Cartesian test = new Cartesian(double.PositiveInfinity, double.PositiveInfinity, double.PositiveInfinity);
            Assert.Throws<NotFiniteNumberException>(() =>
            {
                var unused = test.Normalize();
            });
        }

        [Test]
        public void TestIsUndefined()
        {
            Assert.IsFalse(new Cartesian(1.0, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(Cartesian.Undefined.IsUndefined);
            Assert.IsTrue(new Cartesian(double.NaN, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(new Cartesian(1.0, double.NaN, 1.0).IsUndefined);
            Assert.IsTrue(new Cartesian(1.0, 1.0, double.NaN).IsUndefined);
        }

        [Test]
        public void TestMostOrthogonalAxis()
        {
            Cartesian cartesian = new Cartesian(1.0, 2.0, 3.0);
            Assert.AreEqual(UnitCartesian.UnitX, cartesian.MostOrthogonalAxis);
            cartesian = new Cartesian(2.0, 3.0, 1.0);
            Assert.AreEqual(UnitCartesian.UnitZ, cartesian.MostOrthogonalAxis);
            cartesian = new Cartesian(3.0, 1.0, 2.0);
            Assert.AreEqual(UnitCartesian.UnitY, cartesian.MostOrthogonalAxis);
        }

        /// <summary>
        /// Tests negation of a set of coordinates.
        /// </summary>
        [Test]
        public void TestNegation()
        {
            Cartesian c = -new Cartesian(1.0, 2.0, 3.0);
            Assert.AreEqual(-1.0, c.X);
            Assert.AreEqual(-2.0, c.Y);
            Assert.AreEqual(-3.0, c.Z);
        }

        /// <summary>
        /// Tests the addition methods and operators.
        /// </summary>
        [Test]
        public void TestAdd()
        {
            Cartesian original = new Cartesian(10.0, 20.0, 30.0);
            Cartesian toAdd = new Cartesian(1.0, 2.0, 3.0);
            Cartesian result = original + toAdd;
            Assert.AreEqual(11.0, result.X);
            Assert.AreEqual(22.0, result.Y);
            Assert.AreEqual(33.0, result.Z);

            result = original.Add(toAdd);
            Assert.AreEqual(11.0, result.X);
            Assert.AreEqual(22.0, result.Y);
            Assert.AreEqual(33.0, result.Z);
        }

        /// <summary>
        /// Tests the subtraction methods and operators.
        /// </summary>
        [Test]
        public void TestSubtract()
        {
            Cartesian original = new Cartesian(10.0, 20.0, 30.0);
            Cartesian toSubtract = new Cartesian(1.0, 2.0, 3.0);
            Cartesian result = original - toSubtract;
            Assert.AreEqual(9.0, result.X);
            Assert.AreEqual(18.0, result.Y);
            Assert.AreEqual(27.0, result.Z);

            result = original.Subtract(toSubtract);
            Assert.AreEqual(9.0, result.X);
            Assert.AreEqual(18.0, result.Y);
            Assert.AreEqual(27.0, result.Z);
        }

        /// <summary>
        /// Tests the multiplication methods and operators.
        /// </summary>
        [Test]
        public void TestMultiply()
        {
            Cartesian original = new Cartesian(1.0, 2.0, 3.0);
            Cartesian multiplied = original * 5.0;
            Assert.AreEqual(5.0, multiplied.X);
            Assert.AreEqual(10.0, multiplied.Y);
            Assert.AreEqual(15.0, multiplied.Z);

            multiplied = 5.0 * original;
            Assert.AreEqual(5.0, multiplied.X);
            Assert.AreEqual(10.0, multiplied.Y);
            Assert.AreEqual(15.0, multiplied.Z);

            multiplied = original.Multiply(5.0);
            Assert.AreEqual(5.0, multiplied.X);
            Assert.AreEqual(10.0, multiplied.Y);
            Assert.AreEqual(15.0, multiplied.Z);
        }

        /// <summary>
        /// Tests the multiplication methods and operators.
        /// </summary>
        [Test]
        public void TestDivide()
        {
            Cartesian original = new Cartesian(2.0, 4.0, 6.0);
            Cartesian result = original / 2.0;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(2.0, result.Y);
            Assert.AreEqual(3.0, result.Z);

            result = original.Divide(2.0);
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(2.0, result.Y);
            Assert.AreEqual(3.0, result.Z);
        }

        [Test]
        public void TestDotProduct()
        {
            Cartesian first = new Cartesian(1.0, 3.0, -2.0);
            Cartesian second = new Cartesian(4.0, -2.0, -1.0);
            Assert.AreEqual(0, first.Dot(second));
            Assert.AreEqual(0, second.Dot(first));
        }

        [Test]
        public void TestCrossProduct()
        {
            const double angle = Math.PI / 4.0;
            double cos = Math.Cos(angle / 2.0);
            double sin = Math.Sin(angle / 2.0);

            double a = cos * cos - sin * sin / 3.0;
            double b = 2.0 * (sin * sin + sin * cos * Math.Sqrt(3.0)) / 3.0;
            double c = 2.0 * (sin * sin - sin * cos * Math.Sqrt(3.0)) / 3.0;

            // The three vectors here are the orthonormal set obtained by rotating
            // the x-axis, y-axis, and z-axis through an angle of 45 degrees about
            // the (1,1,1) vector.
            Cartesian first = new Cartesian(a, b, c);
            Cartesian second = new Cartesian(c, a, b);
            Cartesian third = new Cartesian(b, c, a);
            Cartesian result = first.Cross(second);

            Assert.AreEqual(third.X, result.X, Constants.Epsilon14);
            Assert.AreEqual(third.Y, result.Y, Constants.Epsilon14);
            Assert.AreEqual(third.Z, result.Z, Constants.Epsilon14);
        }

        /// <summary>
        /// Tests rotation by a <see cref="UnitQuaternion"/>.
        /// </summary>
        [Test]
        public void TestRotateByUnitQuaternion()
        {
            const double angle = Math.PI / 3.0; // half angle of 120 degree rotation
            double cos = Math.Cos(angle);
            double sin = Math.Sin(angle);

            UnitCartesian axis = new Cartesian(1.0, 1.0, 1.0).Normalize(); // unit vector along [1,1,1]

            double w = cos;
            double x = sin * axis.X;
            double y = sin * axis.Y;
            double z = sin * axis.Z;

            // The original vector is along the x-axis.
            Cartesian original = new Cartesian(1.0, 0.0, 0.0);

            // The rotated vector is along the z-axis.
            Cartesian rotated = original.Rotate(new UnitQuaternion(w, x, y, z));
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
            double angle = Math.PI / 3.0; // half angle of 120 degree rotation
            double cos = Math.Cos(angle);
            double sin = Math.Sin(angle);

            UnitCartesian axis = new Cartesian(1.0, 1.0, 1.0).Normalize(); // unit vector along [1,1,1]

            double w = cos;
            double x = sin * axis.X;
            double y = sin * axis.Y;
            double z = sin * axis.Z;

            // The original vector is along the x-axis.
            Cartesian original = new Cartesian(1.0, 0.0, 0.0);

            // The rotated vector is along the z-axis.
            Cartesian rotated = original.Rotate(new Matrix3By3(new UnitQuaternion(w, x, y, z)));
            Assert.AreEqual(0.0, rotated.X, Constants.Epsilon15);
            Assert.AreEqual(0.0, rotated.Y, Constants.Epsilon15);
            Assert.AreEqual(1.0, rotated.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests that GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            var object1 = new Cartesian(1.0, 2.0, 3.0);
            var object2 = new Cartesian(1.0, 2.0, 3.0);
            var object3 = new Cartesian(1.0, 2.0, 3.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        [Test]
        public void TestToString()
        {
            const double val1 = 1.1;
            const double val2 = 2.1;
            const double val3 = 3.1;
            const string sep = ", ";
            string expected = val1.ToString(CultureInfo.CurrentCulture) + sep +
                              val2.ToString(CultureInfo.CurrentCulture) + sep +
                              val3.ToString(CultureInfo.CurrentCulture);
            Cartesian test = new Cartesian(val1, val2, val3);
            Assert.AreEqual(expected, test.ToString());
        }
    }
}