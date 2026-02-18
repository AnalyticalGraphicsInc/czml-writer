using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBounds
    {
        [Test]
        public void TestStaticInstances()
        {
            Bounds unbounded = Bounds.Unbounded;
            Assert.AreEqual(double.NegativeInfinity, unbounded.LowerBound);
            Assert.AreEqual(double.PositiveInfinity, unbounded.UpperBound);
        }

        [Test]
        public void TestConstructorsAndChecks()
        {
            Bounds unbounded = new Bounds(double.NegativeInfinity, double.PositiveInfinity);
            Assert.AreEqual(Bounds.Unbounded, unbounded);
            Assert.IsTrue(unbounded.IsUnbounded);
            Assert.IsFalse(unbounded.IsFinite);

            Bounds zero = new Bounds(0.0, 0.0);
            Assert.AreEqual(0.0, zero.LowerBound);
            Assert.AreEqual(0.0, zero.UpperBound);
            Assert.IsFalse(zero.IsUnbounded);
            Assert.IsTrue(zero.IsFinite);

            Bounds finite = new Bounds(-1.0, 1.0);
            Assert.AreEqual(-1.0, finite.LowerBound);
            Assert.AreEqual(1.0, finite.UpperBound);
            Assert.IsFalse(finite.IsUnbounded);
            Assert.IsTrue(finite.IsFinite);

            Bounds upperOnly = new Bounds(double.NegativeInfinity, 1.0);
            Assert.AreEqual(double.NegativeInfinity, upperOnly.LowerBound);
            Assert.AreEqual(1.0, upperOnly.UpperBound);
            Assert.IsFalse(upperOnly.IsUnbounded);
            Assert.IsFalse(upperOnly.IsFinite);

            Bounds lowerOnly = new Bounds(-1.0, double.PositiveInfinity);
            Assert.AreEqual(-1.0, lowerOnly.LowerBound);
            Assert.AreEqual(double.PositiveInfinity, lowerOnly.UpperBound);
            Assert.IsFalse(lowerOnly.IsUnbounded);
            Assert.IsFalse(lowerOnly.IsFinite);
        }

        [Test]
        public void TestConstructorThrowsWithUpperLessThanLower()
        {
            Assert.Throws<ArgumentException>(() =>
            {
                var unused = new Bounds(1.0, -1.0);
            });
        }

        /// <summary>
        /// Tests that GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            Bounds object1 = new Bounds(-1.0, 1.0);
            Bounds object2 = new Bounds(-1.0, 1.0);
            Bounds object3 = new Bounds(-1.0, 1.1);
            Assert.AreEqual(object1.GetHashCode(), object2.GetHashCode());
            Assert.AreNotEqual(object1.GetHashCode(), object3.GetHashCode());
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods")]
        public void TestEquality()
        {
            Bounds first = new Bounds(-1.0, 1.0);
            Bounds second = new Bounds(-1.0, 1.0);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));

            second = new Bounds(0.0, 1.0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));

            second = new Bounds(-1.0, 0.0);
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
            Bounds first = new Bounds(1e-2, 1e-1);
            Bounds second = new Bounds(1.1e-2, 1.1e-1);

            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon1));
            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon2));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon3));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon4));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon5));
        }

        /// <summary>
        /// Tests that the <see cref="Bounds.EqualsEpsilon"/> method returns true
        /// when the difference is exactly epsilon.
        /// </summary>
        [Test]
        public void TestEqualsEpsilonExact()
        {
            Bounds first = new Bounds(0.1, 0.1);
            Bounds second = new Bounds(0.1, 0.1);

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
            Bounds first = new Bounds(-1.0, 1.0);
            Cartesian second = Cartesian.Zero;

            Assert.IsFalse(first.Equals(second));
        }

        [Test]
        public void TestToString()
        {
            const double lowerBound = 1.1;
            const double upperBound = 2.1;

            Bounds test = new Bounds(lowerBound, upperBound);

            string expected = string.Format(CultureInfo.CurrentCulture, "{0}, {1}", lowerBound, upperBound);
            Assert.AreEqual(expected, test.ToString());
        }
    }
}
