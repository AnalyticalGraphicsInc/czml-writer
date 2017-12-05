using System;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="UnitCartesian"/> type.
    /// </summary>
    [TestFixture]
    public class TestUnitCartesian
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            UnitCartesian test = new UnitCartesian(2.0, 3.0, 6.0);
            Assert.AreEqual(2.0 / 7.0, test.X);
            Assert.AreEqual(3.0 / 7.0, test.Y);
            Assert.AreEqual(6.0 / 7.0, test.Z);
        }

        /// <summary>
        /// Tests initialization from <see cref="Cartesian"/> coordinates.
        /// </summary>
        [Test]
        public void TestFromCartesian()
        {
            UnitCartesian test = new UnitCartesian(new Cartesian(2.0, 3.0, 6.0));
            Assert.AreEqual(2.0 / 7.0, test.X, Constants.Epsilon15);
            Assert.AreEqual(3.0 / 7.0, test.Y, Constants.Epsilon15);
            Assert.AreEqual(6.0 / 7.0, test.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests initialization from <see cref="Cartesian"/> coordinates.
        /// </summary>
        [Test]
        public void TestFromCartesianAndReturnMagnitude()
        {
            double magnitude;
            UnitCartesian test = new UnitCartesian(new Cartesian(2.0, 3.0, 6.0), out magnitude);
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
            UnitCartesian test = new UnitCartesian(2.0, 3.0, 6.0, out magnitude);
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

            UnitCartesian test = new UnitCartesian(thirtyDegrees, fortyFiveDegrees);
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
            UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
            UnitCartesian second = new UnitCartesian(1.0, 2.0, 3.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            second = new UnitCartesian(0.0, 2.0, 3.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new UnitCartesian(1.0, 0.0, 3.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new UnitCartesian(1.0, 2.0, 0.0);
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
        /// Tests the <see cref="UnitCartesian.EqualsEpsilon"/> method.
        /// </summary>
        [Test]
        public void TestEqualsEpsilon()
        {
            UnitCartesian first = new UnitCartesian(1.0, 1.0, 1.0);
            UnitCartesian second = new UnitCartesian(0.99, 1.0, 1.01);
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-1));
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-2));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-3));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-4));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-5));
        }

        /// <summary>
        /// Tests thats the <see cref="UnitCartesian.EqualsEpsilon"/> method returns true
        /// when the difference is exactly epsilon.
        /// </summary>
        [Test]
        public void TestEqualsEpsilonExact()
        {
            UnitCartesian first = new UnitCartesian(0.1, 0.1, 0.1);
            UnitCartesian second = new UnitCartesian(0.1, 0.1, 0.1);

            Assert.IsTrue(second.EqualsEpsilon(first, 0));
        }

        /// <summary>
        /// Tests to ensure the equality fails when comparing incorrect type.
        /// </summary>
        [Test]
        public void TestEqualityWithWrongType()
        {
            UnitCartesian first = new UnitCartesian(1.0, 2.0, 3.0);
            Cartographic second = new Cartographic(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian.IsUndefined"/> method.
        /// </summary>
        [Test]
        public void TestIsUndefined()
        {
            Assert.IsFalse(new UnitCartesian(1.0, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(UnitCartesian.Undefined.IsUndefined);
            Assert.IsTrue(new UnitCartesian(Double.NaN, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(new UnitCartesian(1.0, Double.NaN, 1.0).IsUndefined);
            Assert.IsTrue(new UnitCartesian(1.0, 1.0, Double.NaN).IsUndefined);
        }

        /// <summary>
        /// Tests that rotation by an invalid <see cref="ElementaryRotation"/> produces an
        /// <see cref="DivideByZeroException"/>.
        /// </summary>
        [Test]
        [ExpectedException(typeof(DivideByZeroException))]
        public void TestFromZero()
        {
            UnitCartesian first = new UnitCartesian(Cartesian.Zero);
        }

        /// <summary>
        /// Tests that rotation by an invalid <see cref="ElementaryRotation"/> produces an
        /// <see cref="NotFiniteNumberException"/>.
        /// </summary>
        [Test]
        [ExpectedException(typeof(NotFiniteNumberException))]
        public void TestFromInfinity()
        {
            UnitCartesian first = new UnitCartesian(Double.PositiveInfinity, 0.0, 0.0);
        }

        /// <summary>
        /// Tests the <see cref="UnitCartesian.Invert"/> method.
        /// </summary>
        [Test]
        public void TestInvert()
        {
            UnitCartesian cartesian = new UnitCartesian(2.0, 3.0, 6.0);
            UnitCartesian inverted = cartesian.Invert();
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
            UnitCartesian u = -new UnitCartesian(2.0, 3.0, 6.0);
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
            UnitCartesian original1 = UnitCartesian.UnitX;
            UnitCartesian toAdd1 = UnitCartesian.UnitY;
            Cartesian result = original1 + toAdd1;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(1.0, result.Y);
            Assert.AreEqual(0.0, result.Z);

            Cartesian toAdd2 = new Cartesian(0.0, 1.0, 1.0);
            result = original1 + toAdd2;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(1.0, result.Y);
            Assert.AreEqual(1.0, result.Z);

            Cartesian original2 = new Cartesian(0.0, 1.0, 1.0);
            UnitCartesian toAdd3 = UnitCartesian.UnitX;
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
            UnitCartesian original = UnitCartesian.UnitX;
            UnitCartesian toAdd1 = UnitCartesian.UnitY;
            Cartesian result = original - toAdd1;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(-1.0, result.Y);
            Assert.AreEqual(0.0, result.Z);

            Cartesian toAdd2 = new Cartesian(0.0, 1.0, 1.0);
            result = original - toAdd2;
            Assert.AreEqual(1.0, result.X);
            Assert.AreEqual(-1.0, result.Y);
            Assert.AreEqual(-1.0, result.Z);

            Cartesian original2 = new Cartesian(0.0, 1.0, 1.0);
            UnitCartesian toAdd3 = UnitCartesian.UnitX;
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
            UnitCartesian original = new UnitCartesian(2.0, 3.0, 6.0);
            Cartesian multiplied = original * 7.0;
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
            UnitCartesian original = new UnitCartesian(2.0, 3.0, 6.0);
            Cartesian result = original / 2.0;
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
            UnitCartesian first = new UnitCartesian(1.0, 3.0, -2.0);
            UnitCartesian second = new UnitCartesian(4.0, -2.0, -1.0);
            Assert.AreEqual(0, first.Dot(second), Constants.Epsilon15);
            Assert.AreEqual(0, second.Dot(first), Constants.Epsilon15);

            Cartesian result = new Cartesian(4.0, -2.0, -1.0);
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
            UnitCartesian first = new UnitCartesian(a, b, c);
            UnitCartesian second = new UnitCartesian(c, a, b);
            UnitCartesian third = new UnitCartesian(b, c, a);
            Cartesian result = first.Cross(second);

            Assert.AreEqual(third.X, result.X, Constants.Epsilon14);
            Assert.AreEqual(third.Y, result.Y, Constants.Epsilon14);
            Assert.AreEqual(third.Z, result.Z, Constants.Epsilon14);

            Cartesian cartesian = new Cartesian(c, a, b);
            result = first.Cross(cartesian);

            Assert.AreEqual(third.X, result.X, Constants.Epsilon14);
            Assert.AreEqual(third.Y, result.Y, Constants.Epsilon14);
            Assert.AreEqual(third.Z, result.Z, Constants.Epsilon14);
        }

        /// <summary>
        /// Tests that GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            UnitCartesian object1 = new UnitCartesian(1.0, 2.0, 3.0);
            UnitCartesian object2 = new UnitCartesian(1.0, 2.0, 3.0);
            UnitCartesian object3 = new UnitCartesian(1.0, 2.0, 3.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        /// <summary>
        /// Tests ToString method
        /// </summary>
        [Test]
        public void TestToString()
        {
            UnitCartesian test1 = new UnitCartesian(1.0, 0.0, 0.0);
            UnitCartesian test2 = new UnitCartesian(0.0, 1.0, 0.0);
            UnitCartesian test3 = new UnitCartesian(0.0, 0.0, 1.0);

            Assert.AreEqual("1, 0, 0", test1.ToString());
            Assert.AreEqual("0, 1, 0", test2.ToString());
            Assert.AreEqual("0, 0, 1", test3.ToString());
        }
    }
}