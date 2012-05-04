using System;
using System.Globalization;
using System.Text;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="Cartographic"/> type.
    /// </summary>
    [TestFixture]
    public class TestCartographic
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            Cartographic test = new Cartographic(1.0, 2.0, 3.0);
            Assert.AreEqual(1.0, test.Longitude);
            Assert.AreEqual(2.0, test.Latitude);
            Assert.AreEqual(3.0, test.Height);
        }

        /// <summary>
        /// Tests initialization from an array of 3 coordinates works correctly.
        /// </summary>
        [Test]
        public void TestFromArray()
        {
            double[] values = { 2.0, 3.0, 6.0 };

            Cartographic test = new Cartographic(values);
            Assert.AreEqual(values.Length, test.Length);
            Assert.AreEqual(test.Longitude, test[0]);
            Assert.AreEqual(test.Latitude, test[1]);
            Assert.AreEqual(test.Height, test[2]);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        public void TestEquality()
        {
            Cartographic first = new Cartographic(1.0, 2.0, 3.0);
            Cartographic second = new Cartographic(1.0, 2.0, 3.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            second = new Cartographic(1.0, 2.1, 3.0);
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
        /// Tests the <see cref="Cartesian.EqualsEpsilon"/> method.
        /// </summary>
        [Test]
        public void TestEqualsEpsilon()
        {
            Cartographic first = new Cartographic(1e-1, 1e-2, 1e-3);
            Cartographic second = new Cartographic(1.1e-1, 1.1e-2, 1.1e-3);
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
            Cartographic first = new Cartographic(1.0, 2.0, 3.0);
            Cartesian second = new Cartesian(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests that Cartographic.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            Cartographic object1 = new Cartographic(1.0, 2.0, 3.0);
            Cartographic object2 = new Cartographic(1.0, 2.0, 3.0);
            Cartographic object3 = new Cartographic(1.0, 2.0, 3.1);
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
            Cartographic first = new Cartographic(array, 0);
        }

        /// <summary>
        /// Tests that construction from an array of doubles with an incorrect length throws the correct exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestInitializationFromBadArray()
        {
            double[] array = new double[2];
            Cartographic first = new Cartographic(array, 0);
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooHigh()
        {
            Cartographic first = new Cartographic(1.0, 2.0, 3.0);
            double bad = first[3];
        }

        /// <summary>
        /// Tests to ensure that an invalid index throws the anticipated exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestIndexTooLow()
        {
            Cartographic first = new Cartographic(1.0, 2.0, 3.0);
            double bad = first[-1];
        }

        /// <summary>
        /// Tests ToString method
        /// </summary>
        [Test]
        public void TestToString()
        {
            StringBuilder s = new StringBuilder(80);
            s.Append((Math.PI).ToString(CultureInfo.CurrentCulture));
            s.Append(", ");
            s.Append(Constants.HalfPi.ToString(CultureInfo.CurrentCulture));
            s.Append(", ");
            double val = 1.2;
            s.Append(val.ToString(CultureInfo.CurrentCulture));
            Cartographic test = new Cartographic(Math.PI, Constants.HalfPi, val);
            Assert.AreEqual(s.ToString(), test.ToString());
        }
    }
}