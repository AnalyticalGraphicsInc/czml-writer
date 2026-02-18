using System;
using System.Diagnostics.CodeAnalysis;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestUnitQuaternion
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            UnitQuaternion quaternion = new UnitQuaternion(2.0, 4.0, 7.0, 10.0);
            Assert.AreEqual(2.0 / 13.0, quaternion.W);
            Assert.AreEqual(4.0 / 13.0, quaternion.X);
            Assert.AreEqual(7.0 / 13.0, quaternion.Y);
            Assert.AreEqual(10.0 / 13.0, quaternion.Z);
        }

        [Test]
        public void TestInitializeAndReturnMagnitude()
        {
            double magnitude;
            UnitQuaternion quaternion = new UnitQuaternion(2.0, 4.0, 7.0, 10.0, out magnitude);
            Assert.AreEqual(2.0 / 13.0, quaternion.W, Constants.Epsilon15);
            Assert.AreEqual(4.0 / 13.0, quaternion.X, Constants.Epsilon15);
            Assert.AreEqual(7.0 / 13.0, quaternion.Y, Constants.Epsilon15);
            Assert.AreEqual(10.0 / 13.0, quaternion.Z, Constants.Epsilon15);
            Assert.AreEqual(13.0, magnitude, Constants.Epsilon15);
        }

        [TestCase(60.0, 2.0, 3.0, 6.0, Description = "60 degrees, rotation about 2/7, 3/7, 6/7 vector.")]
        [TestCase(120.0, 6.0, -3.0, -2.0, Description = "120 degrees, rotation about 6/7, -3/7, -2/7 vector.")]
        [TestCase(120.0, -2.0, -3.0, 6.0, Description = "120 degrees, rotation about -2/7, -3/7, 6/7 vector.")]
        [TestCase(120.0, -2.0, 6.0, -3.0, Description = "120 degrees, rotation about -2/7, 6/7, -3/7 vector.")]
        public void TestFromMatrix3By3(double angleDegrees, double axisX, double axisY, double axisZ)
        {
            Cartesian axis = new Cartesian(axisX, axisY, axisZ);
            UnitCartesian unit = axis.Normalize();

            double angle = angleDegrees * Constants.RadiansPerDegree;
            double c = Math.Cos(angle);
            double s = Math.Sin(angle);

            double w = c;
            double x = s * unit.X;
            double y = s * unit.Y;
            double z = s * unit.Z;

            UnitQuaternion quaternion = new UnitQuaternion(w, x, y, z);
            Matrix3By3 matrix = new Matrix3By3(quaternion);

            UnitQuaternion test = new UnitQuaternion(matrix);

            Assert.AreEqual(w, quaternion.W, Constants.Epsilon15);
            Assert.AreEqual(x, quaternion.X, Constants.Epsilon15);
            Assert.AreEqual(y, quaternion.Y, Constants.Epsilon15);
            Assert.AreEqual(z, quaternion.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
        public void TestEquality()
        {
            UnitQuaternion first = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            UnitQuaternion second = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            second = new UnitQuaternion(1.1, 2.0, 3.0, 4.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new UnitQuaternion(1.0, 2.2, 3.0, 4.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new UnitQuaternion(1.0, 2.0, 3.3, 4.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new UnitQuaternion(1.0, 2.0, 3.3, 4.4);
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
            UnitQuaternion first = new UnitQuaternion(1.0, 1.0, 1.0, 1.0);
            UnitQuaternion second = new UnitQuaternion(0.99, 1.0, 1.0, 1.01);

            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon1));
            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon2));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon3));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon4));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon5));
        }

        /// <summary>
        /// Tests to ensure the equality fails when comparing incorrect type.
        /// </summary>
        [Test]
        [SuppressMessage("ReSharper", "SuspiciousTypeConversion.Global")]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods")]
        public void TestEqualityWithWrongType()
        {
            UnitQuaternion first = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            Cartographic second = new Cartographic(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests that rotation by an invalid value produces an
        /// <see cref="NotFiniteNumberException"/>.
        /// </summary>
        [Test]
        public void TestFromInfinity()
        {
            Assert.Throws<NotFiniteNumberException>(() =>
            {
                var unused = new UnitQuaternion(double.PositiveInfinity, 0.0, 0.0, 0.0);
            });
        }

        [Test]
        public void TestConjugate()
        {
            UnitQuaternion original = new UnitQuaternion(2.0, 4.0, 7.0, 10.0);
            UnitQuaternion conjugate = original.Conjugate();
            Assert.AreEqual(2.0 / 13.0, conjugate.W);
            Assert.AreEqual(-4.0 / 13.0, conjugate.X);
            Assert.AreEqual(-7.0 / 13.0, conjugate.Y);
            Assert.AreEqual(-10.0 / 13.0, conjugate.Z);
        }

        [Test]
        public void TestIdentity()
        {
            UnitQuaternion identity = UnitQuaternion.Identity;
            Assert.AreEqual(1.0, identity.W);
            Assert.AreEqual(0.0, identity.X);
            Assert.AreEqual(0.0, identity.Y);
            Assert.AreEqual(0.0, identity.Z);
        }

        [Test]
        public void TestIsUndefined()
        {
            Assert.IsFalse(new UnitQuaternion(1.0, 1.0, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(UnitQuaternion.Undefined.IsUndefined);
            Assert.IsTrue(new UnitQuaternion(double.NaN, 1.0, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(new UnitQuaternion(1.0, double.NaN, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(new UnitQuaternion(1.0, 1.0, double.NaN, 1.0).IsUndefined);
            Assert.IsTrue(new UnitQuaternion(1.0, 1.0, 1.0, double.NaN).IsUndefined);
        }

        [Test]
        public void TestNegation()
        {
            UnitQuaternion u = -new UnitQuaternion(2.0, 4.0, 7.0, 10.0);
            Assert.AreEqual(-2.0 / 13.0, u.W);
            Assert.AreEqual(-4.0 / 13.0, u.X);
            Assert.AreEqual(-7.0 / 13.0, u.Y);
            Assert.AreEqual(-10.0 / 13.0, u.Z);
        }

        [Test]
        public void TestMultiplicationByUnitQuaternion()
        {
            // Choose quaternions whose vector portions (x, y, z) do not produce zeros
            // when dotted or crossed.  They should also have non-zero scalar (w) portions as well.
            UnitQuaternion first = new UnitQuaternion(7.0, 2.0, 3.0, 6.0);
            UnitQuaternion second = new UnitQuaternion(7.0, 2.0, 3.0, 6.0);

            UnitQuaternion result = first.Multiply(second);
            Assert.AreEqual(0.0 / 7.0, result.W, Constants.Epsilon15);
            Assert.AreEqual(2.0 / 7.0, result.X, Constants.Epsilon15);
            Assert.AreEqual(3.0 / 7.0, result.Y, Constants.Epsilon15);
            Assert.AreEqual(6.0 / 7.0, result.Z, Constants.Epsilon15);

            result = first * second;
            Assert.AreEqual(0.0 / 7.0, result.W, Constants.Epsilon15);
            Assert.AreEqual(2.0 / 7.0, result.X, Constants.Epsilon15);
            Assert.AreEqual(3.0 / 7.0, result.Y, Constants.Epsilon15);
            Assert.AreEqual(6.0 / 7.0, result.Z, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests that GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            var object1 = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            var object2 = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            var object3 = new UnitQuaternion(1.0, 2.0, 3.0, 4.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        [Test]
        public void TestToString()
        {
            UnitQuaternion test1 = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);
            UnitQuaternion test2 = new UnitQuaternion(0.0, 1.0, 0.0, 0.0);
            UnitQuaternion test3 = new UnitQuaternion(0.0, 0.0, 1.0, 0.0);
            UnitQuaternion test4 = new UnitQuaternion(0.0, 0.0, 0.0, 1.0);

            Assert.AreEqual("1, 0, 0, 0", test1.ToString());
            Assert.AreEqual("0, 1, 0, 0", test2.ToString());
            Assert.AreEqual("0, 0, 1, 0", test3.ToString());
            Assert.AreEqual("0, 0, 0, 1", test4.ToString());
        }
    }
}