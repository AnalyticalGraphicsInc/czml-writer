using System;
using System.Globalization;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="BoundingRectangle"/> type.
    /// </summary>
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
            Assert.AreEqual(boundingRectangle0.Left, 0);
            Assert.AreEqual(boundingRectangle0.Bottom, 0);
            Assert.AreEqual(boundingRectangle0.Right, 0);
            Assert.AreEqual(boundingRectangle0.Top, 0);
            Assert.AreEqual(boundingRectangle0.Height, 0);
            Assert.AreEqual(boundingRectangle0.Width, 0);

            Assert.AreEqual(BoundingRectangle.Empty.Left, 0);
            Assert.AreEqual(BoundingRectangle.Empty.Bottom, 0);
            Assert.AreEqual(BoundingRectangle.Empty.Right, 0);
            Assert.AreEqual(BoundingRectangle.Empty.Top, 0);
            Assert.AreEqual(BoundingRectangle.Empty.Height, 0);
            Assert.AreEqual(BoundingRectangle.Empty.Width, 0);

            BoundingRectangle boundingRectangle1 = new BoundingRectangle(1, 2, 3, 4);
            Assert.AreEqual(boundingRectangle1.Left, 1);
            Assert.AreEqual(boundingRectangle1.Bottom, 2);
            Assert.AreEqual(boundingRectangle1.Right, 3);
            Assert.AreEqual(boundingRectangle1.Top, 4);
            Assert.AreEqual(boundingRectangle1.Height, 2);
            Assert.AreEqual(boundingRectangle1.Width, 2);
        }

        /// <summary>
        /// Tests that construction resulting in a negative width throws the correct exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInitializationFromBadElementsWidth()
        {
            BoundingRectangle boundingRectangle = new BoundingRectangle(2, 2, 1, 3);
        }

        /// <summary>
        /// Tests that construction resulting in a negative height throws the correct exception.
        /// </summary>
        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInitializationFromBadElementsHeight()
        {
            BoundingRectangle boundingRectangle = new BoundingRectangle(2, 2, 3, 1);
        }

        /// <summary>
        /// Tests the equality and inequality methods and operators.
        /// </summary>
        [Test]
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

        /// <summary>
        /// Tests the <see cref="BoundingRectangle.EqualsEpsilon"/> method.
        /// </summary>
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

        /// <summary>
        /// Tests the <see cref="BoundingRectangle.ToString"/> method.
        /// </summary>
        [Test]
        public void TestToString()
        {
            BoundingRectangle boundingRectangle = new BoundingRectangle(1, 2, 3, 4);

            int val1 = 1;
            int val2 = 2;
            int val3 = 3;
            int val4 = 4;
            string sep = ", ";
            String result = val1.ToString(CultureInfo.CurrentCulture) + sep +
                            val2.ToString(CultureInfo.CurrentCulture) + sep +
                            val3.ToString(CultureInfo.CurrentCulture) + sep +
                            val4.ToString(CultureInfo.CurrentCulture);

            Assert.AreEqual(boundingRectangle.ToString(), result);
        }
    }
}