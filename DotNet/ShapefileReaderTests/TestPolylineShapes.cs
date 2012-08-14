using System.Collections.Specialized;
using CesiumLanguageWriter;
using NUnit.Framework;
using Shapefile;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestPolylineShapes
    {
        private StringDictionary m_metadata;
        private Rectangular[] m_positions;
        private CartographicExtent m_extent;
        private int[] m_parts;
        
        [SetUp]
        public void SetUp()
        {
            m_metadata = new StringDictionary();
            m_positions = new Rectangular[] {
                new Rectangular(0.0, 0.0),
                new Rectangular(1.0, 1.0)
            };
            m_extent = new CartographicExtent(0.0, 0.0, 1.0, 1.0);
            m_parts = new int[] { 0 };
        }

        [Test]
        public void TestPolylineShapeType()
        {
            PolylineShape line = new PolylineShape(1, m_metadata, m_extent, m_parts, m_positions);
            Assert.AreEqual(ShapeType.Polyline, line.ShapeType);
        }

        [Test]
        public void TestPolylinePositions()
        {
            PolylineShape line = new PolylineShape(1, m_metadata, m_extent, m_parts, m_positions);
            Assert.AreEqual(line[0][0], new Cartographic(0.0, 0.0, 0.0));
            Assert.AreEqual(line[0][1], new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 0.0));
        }

        [Test]
        public void TestPolylineMShapeType()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolylineMShape line = new PolylineMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.AreEqual(ShapeType.PolylineM, line.ShapeType);
        }

        [Test]
        public void TestPolylineMMeasures()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolylineMShape line = new PolylineMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.AreEqual(1.0, line[0].GetMeasure(0));
            Assert.AreEqual(2.0, line[0].GetMeasure(1));
        }

        [Test]
        public void TestPolylineMPositions()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolylineMShape line = new PolylineMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.AreEqual(line[0][0], new Cartographic(0.0, 0.0, 0.0));
            Assert.AreEqual(line[0][1], new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 0.0));
        }

        [Test]
        public void TestPolylineZShapeType()
        {
            double[] zValues = new double[] { 1.0, 2.0 };
            double[] measures = new double[] { 0.0, 0.0 };
            PolylineZShape line = new PolylineZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.AreEqual(ShapeType.PolylineZ, line.ShapeType);
        }

        [Test]
        public void TestPolylineZPositions()
        {
            double[] zValues = new double[] { 1.0, 2.0 };
            double[] measures = new double[] { 0.0, 0.0 };
            PolylineZShape line = new PolylineZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.AreEqual(line[0][0], new Cartographic(0.0, 0.0, 1.0));
            Assert.AreEqual(line[0][1], new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 2.0));
        }
    }
}
