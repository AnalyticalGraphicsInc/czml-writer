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
        /// Tests thats the <see cref="Cartographic.EqualsEpsilon"/> method returns true
        /// when the difference is exactly epsilon.
        /// </summary>
        [Test]
        public void TestEqualsEpsilonExact()
        {
            Cartographic first = new Cartographic(0.1, 0.1, 0.1);
            Cartographic second = new Cartographic(0.1, 0.1, 0.1);
            Assert.IsTrue(second.EqualsEpsilon(first, 0));
        }

        /// <summary>
        /// Tests to ensure the equality fails when comparing incorrect type.
        /// </summary>
        [Test]
        public void TestEqualityWithWrongType()
        {
            Cartographic first = new Cartographic(1.0, 2.0, 3.0);
            Cartesian second = new Cartesian(1.0, 2.0, 3.0);

            // ReSharper disable once SuspiciousTypeConversion.Global
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
        /// Tests ToString method
        /// </summary>
        [Test]
        public void TestToString()
        {
            StringBuilder builder = new StringBuilder();
            builder.Append(Math.PI.ToString(CultureInfo.CurrentCulture));
            builder.Append(", ");
            builder.Append(Constants.HalfPi.ToString(CultureInfo.CurrentCulture));
            builder.Append(", ");
            const double val = 1.2;
            builder.Append(val.ToString(CultureInfo.CurrentCulture));
            Cartographic test = new Cartographic(Math.PI, Constants.HalfPi, val);
            Assert.AreEqual(builder.ToString(), test.ToString());
        }
    }
}