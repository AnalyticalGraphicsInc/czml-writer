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
        public void TestIsPointInTriangle()
        {
            Cartesian a = new Cartesian(0, 0, 0);
            Cartesian b = new Cartesian(0, 1, 0);
            Cartesian c = new Cartesian(1, 0, 0);

            // p is on the boundary of the triangle
            Cartesian p = new Cartesian(0, 0, 0);
            Assert.That(PolygonAlgorithms.IsPointInTriangle(a, b, c, p));

            // p is inside the triangle
            p = new Cartesian(0.5, 0.25, 0);
            Assert.That(PolygonAlgorithms.IsPointInTriangle(a, b, c, p));

            // p is outside the triangle
            p = new Cartesian(1, 1, 0);
            Assert.That(PolygonAlgorithms.IsPointInTriangle(a, b, c, p) == false);
        }

        [Test]
        public void TestGetRightmostVertexIndex()
        {
            List<Cartesian> ring = new List<Cartesian> {
                new Cartesian(0.0, 1.0, 0.0),
                new Cartesian(1.0, 2.0, 0.0),
                new Cartesian(2.0, 2.0, 0.0),
                new Cartesian(3.0, 1.0, 0.0),
                new Cartesian(2.0, 0.0, 0.0),
                new Cartesian(1.0, 1.0, 0.0)
            };
            int expectedResult = 3;
            int result = PolygonAlgorithms.GetRightmostVertexIndex(ring);
            Assert.That(expectedResult == result);
        }

        [Test]
        public void TestGetRightmostRingIndex()
        {
            List<Cartesian> ring0 = new List<Cartesian> {
                new Cartesian(0.0, 1.0, 0.0),
                new Cartesian(1.0, 2.0, 0.0),
                new Cartesian(2.0, 2.0, 0.0),
                new Cartesian(3.0, 1.0, 0.0),
                new Cartesian(2.0, 0.0, 0.0),
                new Cartesian(1.0, 1.0, 0.0)
            };

            List<Cartesian> ring1 = new List<Cartesian> {
                new Cartesian(4.0, 1.0, 0.0),
                new Cartesian(5.0, 2.0, 0.0),
                new Cartesian(6.0, 2.0, 0.0),
                new Cartesian(7.0, 1.0, 0.0),
                new Cartesian(6.0, 0.0, 0.0),
                new Cartesian(5.0, 1.0, 0.0)
            };

            List<List<Cartesian>> rings = new List<List<Cartesian>>();
            rings.Add(ring0);
            rings.Add(ring1);

            int expectedResult = 1;
            int result = PolygonAlgorithms.GetRightmostRingIndex(rings);
            Assert.That(expectedResult == result);
        }

        [Test]
        public void TestGetReflexVertices()
        {
            List<Cartesian> polygon = new List<Cartesian> {
                new Cartesian(0.0, 2.0, 0.0),
                new Cartesian(1.6, 2.0, 0.0),   // reflex
                new Cartesian(2.0, 3.0, 0.0),
                new Cartesian(2.3, 2.0, 0.0),   // reflex
                new Cartesian(4.0, 2.0, 0.0),
                new Cartesian(2.6, 1.0, 0.0),   // reflex
                new Cartesian(3.0, 0.0, 0.0),
                new Cartesian(2.0, 1.0, 0.0),   // reflex
                new Cartesian(1.0, 0.0, 0.0),
                new Cartesian(1.3, 1.0, 0.0),   // reflex
            };

            List<Cartesian> reflexVertices = PolygonAlgorithms.GetReflexVertices(polygon);
            Assert.That(reflexVertices.Count == 5);
            Assert.That(reflexVertices.Contains(polygon[1]));
            Assert.That(reflexVertices.Contains(polygon[3]));
            Assert.That(reflexVertices.Contains(polygon[5]));
            Assert.That(reflexVertices.Contains(polygon[7]));
            Assert.That(reflexVertices.Contains(polygon[9]));
        }

        [Test]
        public void TestIsVertex()
        {
            List<Cartesian> ring = new List<Cartesian> {
                new Cartesian(0.0, 0.0, 0.0),
                new Cartesian(0.0, 1.0, 0.0),
                new Cartesian(1.0, 1.0, 0.0),
                new Cartesian(1.0, 0.0, 0.0),
            };
            Assert.That(PolygonAlgorithms.IsVertex(ring, ring[0]));
            Assert.That(!PolygonAlgorithms.IsVertex(ring, new Cartesian(1.0, 1.0, 1.0)));
        }

        [Test]
        public void TestIntersectPointWithRing()
        {
            List<Cartesian> ring = new List<Cartesian> {
                new Cartesian(0.0, 0.0, 0.0),
                new Cartesian(0.0, 1.0, 0.0),
                new Cartesian(1.0, 1.0, 0.0),
                new Cartesian(1.0, 0.0, 0.0),
            };
            Cartesian point = new Cartesian(0.5, 0.5, 0.0);
            Cartesian expectedResult = new Cartesian(1.0, 0.5, 0.0);
            Cartesian result = PolygonAlgorithms.IntersectPointWithRing(point, ring);
            Assert.That(result.Equals(expectedResult));
        }

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

        [Test]
        public void TestFindMutuallyVisibleVertex()
        {
            List<Cartesian> outerRing = new List<Cartesian> {
                new Cartesian(0.0, 5.0, 0.0),
                new Cartesian(5.0, 10.0, 0.0),
                new Cartesian(10.0, 5.0, 0.0),
                new Cartesian(5.0, 0.0, 0.0),
                new Cartesian(0.0, 5.0, 0.0)
            };

            List<Cartesian> innerRing = new List<Cartesian> {
                new Cartesian(3.0, 7.0, 0.0),
                new Cartesian(3.0, 3.0, 0.0),
                new Cartesian(7.0, 3.0, 0.0),
                new Cartesian(7.0, 7.0, 0.0),
                new Cartesian(3.0, 7.0, 0.0)
            };

            List<List<Cartesian>> innerRings = new List<List<Cartesian>>
            {
                innerRing
            };

            Cartesian expectedResult = outerRing[2];
            Cartesian result = PolygonAlgorithms.FindMutuallyVisibleVertex(outerRing, innerRings);
            Assert.That(result.Equals(expectedResult));
            
        }

        [Test]
        public void TestEliminateHole()
        {
            List<Cartesian> outerRing = new List<Cartesian> {
                new Cartesian(0.0, 5.0, 0.0),
                new Cartesian(5.0, 10.0, 0.0),
                new Cartesian(10.0, 5.0, 0.0),
                new Cartesian(5.0, 0.0, 0.0),
                new Cartesian(0.0, 5.0, 0.0)
            };

            List<Cartesian> innerRing = new List<Cartesian> {
                new Cartesian(3.0, 7.0, 0.0),
                new Cartesian(3.0, 3.0, 0.0),
                new Cartesian(7.0, 3.0, 0.0),
                new Cartesian(7.0, 7.0, 0.0),
                new Cartesian(3.0, 7.0, 0.0)
            };

            List<List<Cartesian>> innerRings = new List<List<Cartesian>>
            {
                innerRing
            };

            List<Cartesian> expectedResult = new List<Cartesian> {
                outerRing[0], outerRing[1], outerRing[2],
                innerRing[2], innerRing[3], innerRing [0], innerRing[1], innerRing[2],
                outerRing[2], outerRing[3], outerRing[0]

            };

            List<Cartesian> result = PolygonAlgorithms.EliminateHole(outerRing, ref innerRings);

            for (int i = 0; i < result.Count; i++)
            {
                Assert.That(result[i].Equals(expectedResult[i]));
            }            
        }
    }
}
