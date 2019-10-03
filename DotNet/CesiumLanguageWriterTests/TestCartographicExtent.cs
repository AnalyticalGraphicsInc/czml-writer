using System;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// A simple test making sure the CartographicExtent class works
    /// </summary>
    [TestFixture]
    public class TestCartographicExtent
    {
        /// <summary>
        /// Testing the class
        /// </summary>
        [Test]
        public void TestExtentClass()
        {
            CartographicExtent box = new CartographicExtent(-2, -1, 1, 2);
            Assert.AreEqual(-2, box.WestLongitude);
            Assert.AreEqual(-1, box.SouthLatitude);
            Assert.AreEqual(1, box.EastLongitude);
            Assert.AreEqual(2, box.NorthLatitude);
            Assert.IsTrue(box.IsInsideExtent(0.5, 0.5));
            Assert.IsFalse(box.IsInsideExtent(0.5, 3));
            Assert.IsFalse(box.IsInsideExtent(0.3, -3));
            Assert.IsFalse(box.IsInsideExtent(-3, 0.5));
            Assert.IsFalse(box.IsInsideExtent(3, 0.5));

            CartographicExtent anotherBox = new CartographicExtent(0, 0, 1, 1);
            CartographicExtent firstCombo = box.Union(anotherBox);
            Assert.AreEqual(-2, firstCombo.WestLongitude);
            Assert.AreEqual(-1, firstCombo.SouthLatitude);
            Assert.AreEqual(1, firstCombo.EastLongitude);
            Assert.AreEqual(2, firstCombo.NorthLatitude);

            CartographicExtent yetAnotherBox = new CartographicExtent(-2, -2, 1, 1);
            CartographicExtent secondCombo = box.Union(yetAnotherBox);
            Assert.AreEqual(-2, secondCombo.WestLongitude);
            Assert.AreEqual(-2, secondCombo.SouthLatitude);
            Assert.AreEqual(1, secondCombo.EastLongitude);
            Assert.AreEqual(2, secondCombo.NorthLatitude);
        }

        /// <summary>
        /// Tests the <see cref="CartographicExtent.EqualsEpsilon"/> method.
        /// </summary>
        [Test]
        public void TestEqualsEpsilon()
        {
            CartographicExtent first = new CartographicExtent(1e-1, 1e-2, 1e-3, 1e-4);
            CartographicExtent second = new CartographicExtent(1.1e-1, 1.1e-2, 1.1e-3, 1.1e-4);
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-1));
            Assert.IsTrue(second.EqualsEpsilon(first, 1e-2));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-3));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-4));
            Assert.IsFalse(second.EqualsEpsilon(first, 1e-5));
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
        public void TestToString()
        {
            var extent = new CartographicExtent(-2, -1, 1, 2);
            Assert.AreEqual("-2, -1, 1, 2", extent.ToString());
        }
    }
}
