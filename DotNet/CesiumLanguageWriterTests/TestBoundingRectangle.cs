using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBoundingRectangle
    {
        /// <summary>
        /// Tests that initialization of and access to the type's values works correctly.
        /// </summary>
        [Test]
        public void TestHoldValue()
        {
            BoundingRectangle boundingRectangle0 = new BoundingRectangle();
            Assert.AreEqual(0, boundingRectangle0.Left);
            Assert.AreEqual(0, boundingRectangle0.Bottom);
            Assert.AreEqual(0, boundingRectangle0.Right);
            Assert.AreEqual(0, boundingRectangle0.Top);
            Assert.AreEqual(0, boundingRectangle0.Height);
            Assert.AreEqual(0, boundingRectangle0.Width);

            Assert.AreEqual(0, BoundingRectangle.Empty.Left);
            Assert.AreEqual(0, BoundingRectangle.Empty.Bottom);
            Assert.AreEqual(0, BoundingRectangle.Empty.Right);
            Assert.AreEqual(0, BoundingRectangle.Empty.Top);
            Assert.AreEqual(0, BoundingRectangle.Empty.Height);
            Assert.AreEqual(0, BoundingRectangle.Empty.Width);

            BoundingRectangle boundingRectangle1 = new BoundingRectangle(1, 2, 3, 4);
            Assert.AreEqual(1, boundingRectangle1.Left);
            Assert.AreEqual(2, boundingRectangle1.Bottom);
            Assert.AreEqual(3, boundingRectangle1.Right);
            Assert.AreEqual(4, boundingRectangle1.Top);
            Assert.AreEqual(2, boundingRectangle1.Height);
            Assert.AreEqual(2, boundingRectangle1.Width);
        }

        /// <summary>
        /// Tests that construction resulting in a negative width throws the correct exception.
        /// </summary>
        [Test]
        public void TestInitializationFromBadElementsWidth()
        {
            Assert.Throws<ArgumentException>(() =>
            {
                var unused = new BoundingRectangle(2, 2, 1, 3);
            });
        }

        /// <summary>
        /// Tests that construction resulting in a negative height throws the correct exception.
        /// </summary>
        [Test]
        public void TestInitializationFromBadElementsHeight()
        {
            Assert.Throws<ArgumentException>(() =>
            {
                var unused = new BoundingRectangle(2, 2, 3, 1);
            });
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
        [SuppressMessage("Assertion", "NUnit2010", Justification = "This is specifically testing equality methods and operators")]
        public void EqualityTest()
        {
            BoundingRectangle boundingRectangle = new BoundingRectangle(1, 2, 3, 4);
            BoundingRectangle sameBoundingRectangle = new BoundingRectangle(1, 2, 3, 4);
            BoundingRectangle diffBoundingRectangle = new BoundingRectangle(2, 3, 4, 5);

            Assert.IsTrue(boundingRectangle.Equals(sameBoundingRectangle));
            Assert.IsFalse(boundingRectangle.Equals(diffBoundingRectangle));
            Assert.IsTrue(boundingRectangle == sameBoundingRectangle);
            Assert.IsTrue(boundingRectangle != diffBoundingRectangle);

            object nonBoundingRectangleObject = new object();
            Assert.IsFalse(boundingRectangle.Equals(nonBoundingRectangleObject));

            object boundingRectangleObject = boundingRectangle;
            Assert.IsTrue(boundingRectangle.Equals(boundingRectangleObject));
        }

        [Test]
        public void TestEqualsEpsilon()
        {
            BoundingRectangle boundingRectangle = new BoundingRectangle(1000, 2000, 3000, 4000);
            BoundingRectangle similarBoundingRectangle = new BoundingRectangle(1010, 2010, 3010, 4010);

            Assert.IsTrue(boundingRectangle.EqualsEpsilon(similarBoundingRectangle, 1000));
            Assert.IsTrue(boundingRectangle.EqualsEpsilon(similarBoundingRectangle, 100));
            Assert.IsTrue(boundingRectangle.EqualsEpsilon(similarBoundingRectangle, 10));
            Assert.IsFalse(boundingRectangle.EqualsEpsilon(similarBoundingRectangle, 1));
        }

        /// <summary>
        /// Tests that <see cref="BoundingRectangle.GetHashCode"/> returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            BoundingRectangle boundingRectangle1 = new BoundingRectangle(1, 2, 3, 4);
            BoundingRectangle boundingRectangle2 = new BoundingRectangle(1, 2, 3, 4);
            BoundingRectangle boundingRectangle3 = new BoundingRectangle(2, 3, 4, 5);

            Assert.AreEqual(boundingRectangle1.GetHashCode(), boundingRectangle2.GetHashCode());
            Assert.AreNotEqual(boundingRectangle1.GetHashCode(), boundingRectangle3.GetHashCode());
        }

        [Test]
        public void TestToString()
        {
            BoundingRectangle boundingRectangle = new BoundingRectangle(1, 2, 3, 4);

            const int val1 = 1;
            const int val2 = 2;
            const int val3 = 3;
            const int val4 = 4;
            const string sep = ", ";
            string expected = val1.ToString(CultureInfo.CurrentCulture) + sep +
                              val2.ToString(CultureInfo.CurrentCulture) + sep +
                              val3.ToString(CultureInfo.CurrentCulture) + sep +
                              val4.ToString(CultureInfo.CurrentCulture);

            Assert.AreEqual(expected, boundingRectangle.ToString());
        }
    }
}