using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Linq;
using System.Text;
using Shapefile;
using NUnit.Framework;
using CesiumLanguageWriter;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestPolygonShapes
    {
        StringDictionary m_metadata;
        Rectangular[] m_positions;
        CartographicExtent m_extent;
        int[] m_parts;

        public TestPolygonShapes()
        {
            m_metadata = new StringDictionary();
            m_positions = new Rectangular[] {
                new Rectangular(1.0, 1.0),
                new Rectangular(2.0, 2.0)
            };
            m_extent = new CartographicExtent(1.0, 1.0, 2.0, 2.0);
            m_parts = new int[] { 0 };
        }

        [Test]
        public void TestPolygonShapeType()
        {
            PolygonShape polygon = new PolygonShape(1, m_metadata, m_extent, m_parts, m_positions);
            Assert.That(polygon.ShapeType == ShapeType.Polygon);
        }

        [Test]
        public void TestPolygonPositions()
        {
            PolygonShape polygon = new PolygonShape(1, m_metadata, m_extent, m_parts, m_positions);
            Assert.That(polygon[0][0].Equals(new Cartesian(1.0, 1.0, 0.0)));
            Assert.That(polygon[0][1].Equals(new Cartesian(2.0, 2.0, 0.0)));
        }

        [Test]
        public void TestPolygonMShapeType()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.That(polygon.ShapeType == ShapeType.PolygonM);
        }

        [Test]
        public void TestPolygonMMeasures()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.That(polygon.Measures[0] == 1.0);
            Assert.That(polygon.Measures[1] == 2.0);
        }

        [Test]
        public void TestPolygonMPositions()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.That(polygon[0][0].Equals(new Cartesian(1.0, 1.0, 0.0)));
            Assert.That(polygon[0][1].Equals(new Cartesian(2.0, 2.0, 0.0)));
        }

        [Test]
        public void TestPolygonZShapeType()
        {
            double[] zValues = new double[] { 1.0, 2.0 };
            PolygonZShape polygon = new PolygonZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, new double[] { });
            Assert.That(polygon.ShapeType == ShapeType.PolygonZ);
        }

        [Test]
        public void TestPolygonZPositions()
        {
            double[] zValues = new double[] { 1.0, 2.0 };
            PolygonZShape polygon = new PolygonZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, new double[] { });
            Assert.That(polygon[0][0].Equals(new Cartesian(1.0, 1.0, 1.0)));
            Assert.That(polygon[0][1].Equals(new Cartesian(2.0, 2.0, 2.0)));
        }
    }
}
