using System;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="UnitQuaternion"/> type.
    /// </summary>
    [TestFixture]
    public class TestUnitQuaternion
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            UnitQuaternion test = new UnitQuaternion(2.0, 4.0, 7.0, 10.0);
            Assert.AreEqual(2.0 / 13.0, test.W);
            Assert.AreEqual(4.0 / 13.0, test.X);
            Assert.AreEqual(7.0 / 13.0, test.Y);
            Assert.AreEqual(10.0 / 13.0, test.Z);
        }

        /// <summary>
        /// Tests initialization from coordinates.
        /// </summary>
        [Test]
        public void TestInitializeAndReturnMagnitude()
        {
            double magnitude;
            UnitQuaternion test = new UnitQuaternion(2.0, 4.0, 7.0, 10.0, out magnitude);
            Assert.AreEqual(2.0 / 13.0, test.W, Constants.Epsilon15);
            Assert.AreEqual(4.0 / 13.0, test.X, Constants.Epsilon15);
            Assert.AreEqual(7.0 / 13.0, test.Y, Constants.Epsilon15);
            Assert.AreEqual(10.0 / 13.0, test.Z, Constants.Epsilon15);
            Assert.AreEqual(13.0, magnitude, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests initialization from a <see cref="Matrix3By3"/> rotation.
        /// </summary>
        [Test]
        public void TestFromMatrix3By3()
        {
            double angle = Math.PI / 6; // 60 degrees.

            // Test "type == 0:"
            _TestFromMatrix3By3(angle, new Cartesian(2.0, 3.0, 6.0)); //rotation about 2/7, 3/7, 6/7 vector.

            angle = 2 * Math.PI / 3; // 120 degrees.

            // Test "type == 1:"
            _TestFromMatrix3By3(angle, new Cartesian(6.0, -3.0, -2.0)); // rotation about 6/7, -3/7, -2/7 vector.

            // Test "type == 2:"
            _TestFromMatrix3By3(angle, new Cartesian(-2.0, -3.0, 6.0)); // rotation about -2/7, -3/7, 6/7 vector.

            // Test "type == 3:"
            _TestFromMatrix3By3(angle, new Cartesian(-2.0, 6.0, -3.0)); // rotation about -2/7, 6/7, -3/7 vector.
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
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

        /// <summary>
        /// Tests the <see cref="UnitQuaternion.EqualsEpsilon"/> method.
        /// </summary>
        [Test]
        public void TestEqualsEpsilon()
        {
            UnitQuaternion first = new UnitQuaternion(1.0, 1.0, 1.0, 1.0);
            UnitQuaternion second = new UnitQuaternion(0.99, 1.0, 1.0, 1.01);
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
            UnitQuaternion first = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            Cartographic second = new Cartographic(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests that rotation by an invalid value produces an
        /// <see cref="NotFiniteNumberException"/>.
        /// </summary>
        [Test]
        [ExpectedException(typeof(NotFiniteNumberException))]
        public void TestFromInfinity()
        {
            UnitQuaternion first = new UnitQuaternion(Double.PositiveInfinity, 0.0, 0.0, 0.0);
        }

        /// <summary>
        /// Tests the <see cref="UnitQuaternion.Conjugate"/> method.
        /// </summary>
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

        /// <summary>
        /// Tests <see cref="UnitQuaternion.Identity"/>.
        /// </summary>
        [Test]
        public void TestIdentity()
        {
            UnitQuaternion identity = UnitQuaternion.Identity;
            Assert.AreEqual(1.0, identity.W);
            Assert.AreEqual(0.0, identity.X);
            Assert.AreEqual(0.0, identity.Y);
            Assert.AreEqual(0.0, identity.Z);
        }

        /// <summary>
        /// Tests the <see cref="UnitQuaternion.IsUndefined"/> method.
        /// </summary>
        [Test]
        public void TestIsUndefined()
        {
            Assert.IsFalse(new UnitQuaternion(1.0, 1.0, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(UnitQuaternion.Undefined.IsUndefined);
            Assert.IsTrue(new UnitQuaternion(Double.NaN, 1.0, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(new UnitQuaternion(1.0, Double.NaN, 1.0, 1.0).IsUndefined);
            Assert.IsTrue(new UnitQuaternion(1.0, 1.0, Double.NaN, 1.0).IsUndefined);
            Assert.IsTrue(new UnitQuaternion(1.0, 1.0, 1.0, Double.NaN).IsUndefined);
        }

        private void _TestFromMatrix3By3(double angle, Cartesian axis)
        {
            Cartesian unit = axis.Normalize();

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
        /// Tests negation of a set of coordinates.
        /// </summary>
        [Test]
        public void TestNegation()
        {
            UnitQuaternion u = -new UnitQuaternion(2.0, 4.0, 7.0, 10.0);
            Assert.AreEqual(-2.0 / 13.0, u.W);
            Assert.AreEqual(-4.0 / 13.0, u.X);
            Assert.AreEqual(-7.0 / 13.0, u.Y);
            Assert.AreEqual(-10.0 / 13.0, u.Z);
        }

        /// <summary>
        /// Tests multiplication by another <see cref="UnitQuaternion"/>.
        /// </summary>
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
        /// Tests that Cartesian3.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            UnitQuaternion object1 = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            UnitQuaternion object2 = new UnitQuaternion(1.0, 2.0, 3.0, 4.0);
            UnitQuaternion object3 = new UnitQuaternion(1.0, 2.0, 3.0, 4.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooHigh()
        {
            UnitQuaternion first = new UnitQuaternion(7.0, 2.0, 3.0, 6.0);
            double bad = first[4];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooLow()
        {
            UnitQuaternion first = new UnitQuaternion(7.0, 2.0, 3.0, 6.0);
            double bad = first[-1];
        }

        /// <summary>
        /// Tests ToString method
        /// </summary>
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