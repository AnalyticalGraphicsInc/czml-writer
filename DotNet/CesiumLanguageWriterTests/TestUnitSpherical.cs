using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
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

        [Test]
        public void TestFromUnitCartesian()
        {
            const double fortyFiveDegrees = Math.PI / 4.0;
            const double sixtyDegrees = Math.PI / 3.0;

            UnitSpherical test = new UnitSpherical(new UnitCartesian(1.0, Math.Sqrt(3.0), -2.0));
            Assert.AreEqual(sixtyDegrees, test.Clock, Constants.Epsilon15);
            Assert.AreEqual(fortyFiveDegrees + Math.PI / 2.0, test.Cone, Constants.Epsilon15);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
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

        [Test]
        public void TestEqualsEpsilon()
        {
            UnitSpherical first = new UnitSpherical(1e-1, 1e-2);
            UnitSpherical second = new UnitSpherical(1.1e-1, 1.1e-2);

            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon1));
            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon2));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon3));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon4));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon5));
        }

        /// <summary>
        /// Tests that the <see cref="UnitSpherical.EqualsEpsilon"/> method returns true
        /// when the difference is exactly epsilon.
        /// </summary>
        [Test]
        public void TestEqualsEpsilonExact()
        {
            UnitSpherical first = new UnitSpherical(0.1, 0.1);
            UnitSpherical second = new UnitSpherical(0.1, 0.1);

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
            var object1 = new UnitSpherical(1.0, 2.0);
            var object2 = new UnitSpherical(1.0, 2.0);
            var object3 = new UnitSpherical(1.0, 2.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        [Test]
        public void TestToString()
        {
            const double clock = -Math.PI;
            const double cone = Math.PI;

            UnitSpherical test = new UnitSpherical(clock, cone);

            string expected = string.Format(CultureInfo.CurrentCulture, "{0}, {1}", clock, cone);
            Assert.AreEqual(expected, test.ToString());
        }
    }
}