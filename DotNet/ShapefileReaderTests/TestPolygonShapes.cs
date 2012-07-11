using System.Collections.Specialized;
using CesiumLanguageWriter;
using NUnit.Framework;
using Shapefile;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestPolygonShapes
    {
        StringDictionary m_metadata;
        Rectangular[] m_positions;
        CartographicExtent m_extent;
        int[] m_parts;

        [SetUp]
        public void SetUp()
        {
            m_metadata = new StringDictionary();
            m_positions = new Rectangular[] {
                new Rectangular(0.0, 0.0),
                new Rectangular(0.0, 1.0),
                new Rectangular(1.0, 1.0),
                new Rectangular(1.0, 0.0),
                new Rectangular(0.0, 0.0),
            };
            m_extent = new CartographicExtent(0.0, 0.0, 1.0, 1.0);
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
            Assert.That(polygon[0][0].Equals(new Cartesian(0.0, 0.0, 0.0)));
            Assert.That(polygon[0][1].Equals(new Cartesian(0.0, 1.0, 0.0)));
            Assert.That(polygon[0][2].Equals(new Cartesian(1.0, 1.0, 0.0)));
            Assert.That(polygon[0][3].Equals(new Cartesian(1.0, 0.0, 0.0)));
            Assert.That(polygon[0][4].Equals(new Cartesian(0.0, 0.0, 0.0)));
        }

        [Test]
        public void TestPolygonMShapeType()
        {
            double[] measures = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 4.0, measures);
            Assert.That(polygon.ShapeType == ShapeType.PolygonM);
        }

        [Test]
        public void TestPolygonMMeasures()
        {
            double[] measures = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 4.0, measures);
            Assert.That(polygon[0].GetMeasure(0) == 1.0);
            Assert.That(polygon[0].GetMeasure(1) == 2.0);
            Assert.That(polygon[0].GetMeasure(2) == 3.0);
            Assert.That(polygon[0].GetMeasure(3) == 4.0);
            Assert.That(polygon[0].GetMeasure(4) == 1.0);
        }

        [Test]
        public void TestPolygonMPositions()
        {
            double[] measures = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 4.0, measures);
            Assert.That(polygon[0][0].Equals(new Cartesian(0.0, 0.0, 0.0)));
            Assert.That(polygon[0][1].Equals(new Cartesian(0.0, 1.0, 0.0)));
            Assert.That(polygon[0][2].Equals(new Cartesian(1.0, 1.0, 0.0)));
            Assert.That(polygon[0][3].Equals(new Cartesian(1.0, 0.0, 0.0)));
            Assert.That(polygon[0][4].Equals(new Cartesian(0.0, 0.0, 0.0)));
        }

        [Test]
        public void TestPolygonZShapeType()
        {
            double[] zValues = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
            PolygonZShape polygon = new PolygonZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.That(polygon.ShapeType == ShapeType.PolygonZ);
        }

        [Test]
        public void TestPolygonZPositions()
        {
            double[] zValues = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
            PolygonZShape polygon = new PolygonZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.That(polygon[0][0].Equals(new Cartesian(0.0, 0.0, 1.0)));
            Assert.That(polygon[0][1].Equals(new Cartesian(0.0, 1.0, 2.0)));
            Assert.That(polygon[0][2].Equals(new Cartesian(1.0, 1.0, 3.0)));
            Assert.That(polygon[0][3].Equals(new Cartesian(1.0, 0.0, 4.0)));
            Assert.That(polygon[0][4].Equals(new Cartesian(0.0, 0.0, 1.0)));
        }
    }
}
