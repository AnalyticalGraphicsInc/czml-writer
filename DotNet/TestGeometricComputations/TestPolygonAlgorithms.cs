using System.Collections.Generic;
using CesiumLanguageWriter;
using GeometricComputations;
using NUnit.Framework;

namespace TestGeometricComputations
{
    [TestFixture]
    public class TestPolygonAlgorithms
    {
        [Test]
        public void TestFindRightmostRing()
        {
            List<Cartesian> ring1 = new List<Cartesian> {
                new Cartesian(0.0, 0.0, 0.0),
                new Cartesian(0.0, 1.0, 0.0),
                new Cartesian(1.0, 1.0, 0.0),
                new Cartesian(1.0, 0.0, 0.0),
            };

            List<Cartesian> ring2 = new List<Cartesian> {
                new Cartesian(2.0, 0.0, 0.0),
                new Cartesian(2.0, 1.0, 0.0),
                new Cartesian(3.0, 1.0, 0.0),
                new Cartesian(3.0, 0.0, 0.0),
            };
            List<List<Cartesian>> rings = new List<List<Cartesian>>();
            rings.Add(ring1);
            rings.Add(ring2);
            int expectedResult = 1;
            int result = PolygonAlgorithms.GetRightmostRingIndex(rings);
            Assert.That(result.Equals(expectedResult));
        }
    }
}
