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
            Assert.AreEqual(ShapeType.Polygon, polygon.ShapeType);
        }

        [Test]
        public void TestPolygonPositions()
        {
            PolygonShape polygon = new PolygonShape(1, m_metadata, m_extent, m_parts, m_positions);
            Assert.AreEqual(polygon[0][0], new Cartographic(0.0, 0.0, 0.0));
            Assert.AreEqual(polygon[0][1], new Cartographic(0.0, Constants.RadiansPerDegree, 0.0));
            Assert.AreEqual(polygon[0][2], new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 0.0));
            Assert.AreEqual(polygon[0][3], new Cartographic(Constants.RadiansPerDegree, 0.0, 0.0));
            Assert.AreEqual(polygon[0][4], new Cartographic(0.0, 0.0, 0.0));
        }

        [Test]
        public void TestPolygonMShapeType()
        {
            double[] measures = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 4.0, measures);
            Assert.AreEqual(ShapeType.PolygonM, polygon.ShapeType);
        }

        [Test]
        public void TestPolygonMMeasures()
        {
            double[] measures = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 4.0, measures);
            Assert.AreEqual(1.0, polygon[0].GetMeasure(0));
            Assert.AreEqual(2.0, polygon[0].GetMeasure(1));
            Assert.AreEqual(3.0, polygon[0].GetMeasure(2));
            Assert.AreEqual(4.0, polygon[0].GetMeasure(3));
            Assert.AreEqual(1.0, polygon[0].GetMeasure(4));
        }

        [Test]
        public void TestPolygonMPositions()
        {
            double[] measures = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            PolygonMShape polygon = new PolygonMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 4.0, measures);
            Assert.AreEqual(polygon[0][0], new Cartographic(0.0, 0.0, 0.0));
            Assert.AreEqual(polygon[0][1], new Cartographic(0.0, Constants.RadiansPerDegree, 0.0));
            Assert.AreEqual(polygon[0][2], new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 0.0));
            Assert.AreEqual(polygon[0][3], new Cartographic(Constants.RadiansPerDegree, 0.0, 0.0));
            Assert.AreEqual(polygon[0][4], new Cartographic(0.0, 0.0, 0.0));
        }

        [Test]
        public void TestPolygonZShapeType()
        {
            double[] zValues = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
            PolygonZShape polygon = new PolygonZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.AreEqual(ShapeType.PolygonZ, polygon.ShapeType);
        }

        [Test]
        public void TestPolygonZPositions()
        {
            double[] zValues = new double[] { 1.0, 2.0, 3.0, 4.0, 1.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
            PolygonZShape polygon = new PolygonZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.AreEqual(polygon[0][0], new Cartographic(0.0, 0.0, 1.0));
            Assert.AreEqual(polygon[0][1], new Cartographic(0.0, Constants.RadiansPerDegree, 2.0));
            Assert.AreEqual(polygon[0][2], new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 3.0));
            Assert.AreEqual(polygon[0][3], new Cartographic(Constants.RadiansPerDegree, 0.0, 4.0));
            Assert.AreEqual(polygon[0][4], new Cartographic(0.0, 0.0, 1.0));
        }
    }
}
