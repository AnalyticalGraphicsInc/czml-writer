using System;
using System.Collections.Generic;
using NUnit.Framework;
using CesiumLanguageWriter;
using GeometricComputations;

namespace GeometricComputationsTests
{
    [TestFixture]
    public class AxisAlignedBoundingBoxTests
    {
        [Test]
        [ExpectedException(typeof(ArgumentNullException))]
        public void Null()
        {
            new AxisAlignedBoundingBox(null);
        }

        [Test]
        public void Empty()
        {
            AxisAlignedBoundingBox box = new AxisAlignedBoundingBox(new List<Cartesian>());
            Assert.AreEqual(new Cartesian(double.MinValue, double.MinValue, double.MinValue), box.Minimum);
            Assert.AreEqual(new Cartesian(double.MaxValue, double.MaxValue, double.MaxValue), box.Maximum);
        }

        [Test]
        public void Simple()
        {
            Cartesian min = new Cartesian(-1, -1, -1);
            Cartesian max = new Cartesian(1, 1, 1);

            IList<Cartesian> positions = new List<Cartesian>();
            positions.Add(min);
            positions.Add(max);

            AxisAlignedBoundingBox box = new AxisAlignedBoundingBox(positions);
            Assert.AreEqual(min, box.Minimum);
            Assert.AreEqual(max, box.Maximum);
            Assert.AreEqual(Cartesian.Zero, box.Center);
        }
    }
}