using System;
using System.Globalization;
using System.Text;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="UnitSpherical"/> type.
    /// </summary>
    [TestFixture]
    public class TestUnitSpherical
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            UnitSpherical test = new UnitSpherical(1.0, 2.0);
            Assert.AreEqual(1.0, test.Clock);
            Assert.AreEqual(2.0, test.Cone);
        }

        /// <summary>
        /// Tests initialization from an array of 2 coordinates works correctly.
        /// </summary>
        [Test]
        public void TestFromArray()
        {
            double[] values = { 2.0, 3.0 };

            UnitSpherical test = new UnitSpherical(values);
            Assert.AreEqual(values.Length, test.Length);
            Assert.AreEqual(test.Clock, test[0]);
            Assert.AreEqual(test.Cone, test[1]);
        }

        /// <summary>
        /// Tests initialization from <see cref="UnitCartesian3"/> coordinates.
        /// </summary>
        [Test]
        public void TestFromUnitCartesian()
        {
            double fortyFiveDegrees = Math.PI / 4.0;
            double sixtyDegrees = Math.PI / 3.0;

            UnitSpherical test = new UnitSpherical(new UnitCartesian3(1.0, Math.Sqrt(3.0), -2.0));
            Assert.AreEqual(sixtyDegrees, test.Clock, Constants.Epsilon15);
            Assert.AreEqual(fortyFiveDegrees + Math.PI / 2.0, test.Cone, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        public void TestEquality()
        {
            UnitSpherical first = new UnitSpherical(1.0, 2.0);
            UnitSpherical second = new UnitSpherical(1.0, 2.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            second = new UnitSpherical(1.0, 2.1);
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
        /// Tests the <see cref="UnitSpherical.EqualsEpsilon"/> method.
        /// </summary>
        [Test]
        public void TestEqualsEpsilon()
        {
            UnitSpherical first = new UnitSpherical(1e-1, 1e-2);
            UnitSpherical second = new UnitSpherical(1.1e-1, 1.1e-2);
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
            UnitSpherical first = new UnitSpherical(1.0, 2.0);
            Cartographic second = new Cartographic(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests that UnitSpherical.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            UnitSpherical object1 = new UnitSpherical(1.0, 2.0);
            UnitSpherical object2 = new UnitSpherical(1.0, 2.0);
            UnitSpherical object3 = new UnitSpherical(1.0, 2.1);
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
            UnitSpherical first = new UnitSpherical(array, 0);
        }

        /// <summary>
        /// Tests that construction from an array of doubles with an incorrect length throws the correct exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestInitializationFromBadArray()
        {
            double[] array = new double[1];
            UnitSpherical first = new UnitSpherical(array, 0);
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooHigh()
        {
            UnitSpherical first = new UnitSpherical(1.0, 2.0);
            double bad = first[2];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooLow()
        {
            UnitSpherical first = new UnitSpherical(1.0, 2.0);
            double bad = first[-1];
        }

        /// <summary>
        /// Tests ToString method
        /// </summary>
        [Test]
        public void TestToString()
        {
            StringBuilder s = new StringBuilder(80);
            s.Append((-Math.PI).ToString(CultureInfo.CurrentCulture));
            s.Append(", ");
            s.Append(Math.PI.ToString(CultureInfo.CurrentCulture));
            UnitSpherical test = new UnitSpherical(-Math.PI, Math.PI);
            Assert.AreEqual(s.ToString(), test.ToString());
        }
    }
}