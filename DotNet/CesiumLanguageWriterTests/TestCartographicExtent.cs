using System;
using System.Diagnostics.CodeAnalysis;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCartographicExtent
    {
        [Test]
        public void TestConstructorsAndProperties()
        {
            CartographicExtent extent = new CartographicExtent(-2, -1, 2, 1);
            Assert.AreEqual(-2, extent.WestLongitude);
            Assert.AreEqual(-1, extent.SouthLatitude);
            Assert.AreEqual(2, extent.EastLongitude);
            Assert.AreEqual(1, extent.NorthLatitude);
        }

        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
        public void TestEqualityAndGetHashCode()
        {
            CartographicExtent first = new CartographicExtent(-2, -1, 1, 2);
            CartographicExtent second = new CartographicExtent(-2, -1, 1, 2);
            Assert.AreEqual(first, second);
            Assert.AreEqual(second, first);
            Assert.IsTrue(first == second);
            Assert.IsTrue(second == first);
            Assert.IsFalse(first != second);
            Assert.IsFalse(second != first);
            Assert.IsTrue(first.Equals(second));
            Assert.IsTrue(second.Equals(first));
            Assert.AreEqual(first.GetHashCode(), second.GetHashCode());

            second = new CartographicExtent(0, -1, 1, 2);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(first.GetHashCode(), second.GetHashCode());

            second = new CartographicExtent(-2, 0, 1, 2);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(first.GetHashCode(), second.GetHashCode());

            second = new CartographicExtent(-2, -1, 0, 2);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(first.GetHashCode(), second.GetHashCode());

            second = new CartographicExtent(-2, -1, 1, 0);
            Assert.AreNotEqual(first, second);
            Assert.AreNotEqual(second, first);
            Assert.IsFalse(first == second);
            Assert.IsFalse(second == first);
            Assert.IsTrue(first != second);
            Assert.IsTrue(second != first);
            Assert.IsFalse(first.Equals(second));
            Assert.IsFalse(second.Equals(first));
            Assert.AreNotEqual(first.GetHashCode(), second.GetHashCode());
        }

        [Test]
        public void TestEqualsEpsilon()
        {
            CartographicExtent first = new CartographicExtent(1e-1, 1e-2, 1e-3, 1e-4);
            CartographicExtent second = new CartographicExtent(1.1e-1, 1.1e-2, 1.1e-3, 1.1e-4);

            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon1));
            Assert.IsTrue(second.EqualsEpsilon(first, Constants.Epsilon2));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon3));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon4));
            Assert.IsFalse(second.EqualsEpsilon(first, Constants.Epsilon5));
        }

        /// <summary>
        /// Tests that the <see cref="CartographicExtent.EqualsEpsilon"/> method returns true
        /// when the difference is exactly epsilon.
        /// </summary>
        [Test]
        public void TestEqualsEpsilonExact()
        {
            CartographicExtent first = new CartographicExtent(0.1, 0.1, 0.1, 0.1);
            CartographicExtent second = new CartographicExtent(0.1, 0.1, 0.1, 0.1);

            Assert.IsTrue(second.EqualsEpsilon(first, 0));
        }

        [Test]
        public void TestIsInsideExtent()
        {
            CartographicExtent box = new CartographicExtent(-2, -1, 2, 1);
            Assert.AreEqual(-2, box.WestLongitude);
            Assert.AreEqual(-1, box.SouthLatitude);
            Assert.AreEqual(2, box.EastLongitude);
            Assert.AreEqual(1, box.NorthLatitude);

            // Check corners.
            Assert.IsTrue(box.IsInsideExtent(-2, -1));
            Assert.IsTrue(box.IsInsideExtent(-2, 1));
            Assert.IsTrue(box.IsInsideExtent(2, -1));
            Assert.IsTrue(box.IsInsideExtent(2, 1));

            // Check edge.
            Assert.IsTrue(box.IsInsideExtent(-2, 0));
            Assert.IsTrue(box.IsInsideExtent(0, -1));
            Assert.IsTrue(box.IsInsideExtent(2, 0));
            Assert.IsTrue(box.IsInsideExtent(0, 1));

            // Check inside.
            Assert.IsTrue(box.IsInsideExtent(-1.5, 0));
            Assert.IsTrue(box.IsInsideExtent(0, -0.5));
            Assert.IsTrue(box.IsInsideExtent(1.5, 0));
            Assert.IsTrue(box.IsInsideExtent(0, 0.5));

            // Check outside.
            Assert.IsFalse(box.IsInsideExtent(-3, 0));
            Assert.IsFalse(box.IsInsideExtent(0, -1.5));
            Assert.IsFalse(box.IsInsideExtent(3, 0));
            Assert.IsFalse(box.IsInsideExtent(0, 1.5));
        }

        /// <summary>
        /// Tests the union operation where the other extent is null.
        /// </summary>
        [Test]
        public void ThrowsWhenUnionWithNullExtent()
        {
            CartographicExtent box = new CartographicExtent(-2, -1, 2, 1);

            var exception = Assert.Throws<ArgumentNullException>(() =>
            {
                // ReSharper disable once AssignNullToNotNullAttribute
                var unused = box.Union(null);
            });
            Assert.AreEqual("other", exception.ParamName);
        }

        [Test]
        public void TestUnion()
        {
            CartographicExtent box = new CartographicExtent(-2, -1, 1, 1.3);
            Assert.AreEqual(-2, box.WestLongitude);
            Assert.AreEqual(-1, box.SouthLatitude);
            Assert.AreEqual(1, box.EastLongitude);
            Assert.AreEqual(1.3, box.NorthLatitude);

            CartographicExtent anotherBox = new CartographicExtent(0, 0, 1, 1);
            CartographicExtent firstCombo = box.Union(anotherBox);
            Assert.AreEqual(-2, firstCombo.WestLongitude);
            Assert.AreEqual(-1, firstCombo.SouthLatitude);
            Assert.AreEqual(1, firstCombo.EastLongitude);
            Assert.AreEqual(1.3, firstCombo.NorthLatitude);

            CartographicExtent yetAnotherBox = new CartographicExtent(-2, -1.3, 1, 1);
            CartographicExtent secondCombo = box.Union(yetAnotherBox);
            Assert.AreEqual(-2, secondCombo.WestLongitude);
            Assert.AreEqual(-1.3, secondCombo.SouthLatitude, Constants.Epsilon8);
            Assert.AreEqual(1, secondCombo.EastLongitude);
            Assert.AreEqual(1.3, secondCombo.NorthLatitude);
        }

        /// <summary>
        /// Testing the class IsInside family of functions.
        /// </summary>
        [Test]
        public void TesIsInsideExtentEpsilon()
        {
            const double west = -2;
            const double south = -1;
            const double east = 1;
            const double north = 1.5;

            var extent = new CartographicExtent(west, south, east, north);
            Assert.IsTrue(extent.IsInsideExtent(0.5, 0.5));
            Assert.IsFalse(extent.IsInsideExtent(0.5, Constants.HalfPi));
            Assert.IsFalse(extent.IsInsideExtent(0.3, -3));
            Assert.IsFalse(extent.IsInsideExtent(-3, 0.5));
            Assert.IsFalse(extent.IsInsideExtent(3, 0.5));

            // way out west
            Assert.IsTrue(extent.IsInsideExtent(west, 0.0));
            // move it
            Assert.IsFalse(extent.IsInsideExtent(west - Constants.Epsilon10, 0.0));

            // east
            Assert.IsTrue(extent.IsInsideExtent(east, 0.0));
            // move it
            Assert.IsFalse(extent.IsInsideExtent(east + Constants.Epsilon10, 0.0));

            // north
            Assert.IsTrue(extent.IsInsideExtent(0.0, north));
            // move it
            Assert.IsFalse(extent.IsInsideExtent(0.0, north + Constants.Epsilon10));

            // south
            Assert.IsTrue(extent.IsInsideExtent(0.0, south));
            // move it
            Assert.IsFalse(extent.IsInsideExtent(0.0, south - Constants.Epsilon10));
        }

        [Test]
        public void TestToString()
        {
            var extent = new CartographicExtent(-2, -1, 1, 2);
            Assert.AreEqual("-2, -1, 1, 2", extent.ToString());
        }
    }
}
