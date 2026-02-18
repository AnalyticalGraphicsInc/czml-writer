using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
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
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
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

        [Test]
        public void TestEqualsEpsilon()
        {
            Cartographic first = new Cartographic(1e-1, 1e-2, 1e-3);
            Cartographic second = new Cartographic(1.1e-1, 1.1e-2, 1.1e-3);

            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon1));
            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon2));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon3));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon4));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon5));
        }

        /// <summary>
        /// Tests that the <see cref="Cartographic.EqualsEpsilon"/> method returns true
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
        [SuppressMessage("ReSharper", "SuspiciousTypeConversion.Global")]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods")]
        public void TestEqualityWithWrongType()
        {
            Cartographic first = new Cartographic(1.0, 2.0, 3.0);
            Cartesian second = new Cartesian(1.0, 2.0, 3.0);

            Assert.IsFalse(first.Equals(second));
        }

        /// <summary>
        /// Tests that GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            var object1 = new Cartographic(1.0, 2.0, 3.0);
            var object2 = new Cartographic(1.0, 2.0, 3.0);
            var object3 = new Cartographic(1.0, 2.0, 3.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        [Test]
        public void TestToString()
        {
            const double longitude = Math.PI;
            const double latitude = Constants.HalfPi;
            const double height = 1.2;

            Cartographic test = new Cartographic(longitude, latitude, height);

            string expected = string.Format(CultureInfo.CurrentCulture, "{0}, {1}, {2}", longitude, latitude, height);
            Assert.AreEqual(expected, test.ToString());
        }
    }
}