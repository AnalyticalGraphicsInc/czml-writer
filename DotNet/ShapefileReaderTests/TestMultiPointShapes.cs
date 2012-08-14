using System.Collections.Specialized;
using CesiumLanguageWriter;
using NUnit.Framework;
using Shapefile;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestMultiPointShapes
    {
        private int m_recordNumber;
        private StringDictionary m_metadata;
        private CartographicExtent m_extent;
        private Cartographic[] m_positions;

        [SetUp]
        public void SetUp()
        {
            m_recordNumber = 1;
            m_metadata = new StringDictionary();
            m_extent = new CartographicExtent(0.0, 0.0, 1.0, 1.0);
            m_positions = new Cartographic[] {
                new Cartographic(0.0, 0.0, 0.0),
                new Cartographic(1.0, 1.0, 1.0),
            };
        }

        [Test]
        public void TestMultiPointShapeType()
        {
            MultiPointShape points = new MultiPointShape(m_recordNumber, m_metadata, m_extent, m_positions);
            Assert.AreEqual(ShapeType.MultiPoint, points.ShapeType);
        }

        [Test]
        public void TestMultiPointShapePosition()
        {
            MultiPointShape points = new MultiPointShape(m_recordNumber, m_metadata, m_extent, m_positions);
            Assert.AreEqual(m_positions[0], points[0]);
            Assert.AreEqual(new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 1.0), points[1]);
        }

        [Test]
        public void TestMultiPointMShapeType()
        {
            double[] measures = new double[] { 0.0, 1.0};
            MultiPointMShape point = new MultiPointMShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, measures);
            Assert.AreEqual(ShapeType.MultiPointM, point.ShapeType);
        }

        [Test]
        public void TestMultiPointMShapePosition()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointMShape points = new MultiPointMShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, measures);
            Assert.AreEqual(m_positions[0], points[0]);
            Assert.AreEqual(new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 1.0), points[1]);
        }

        [Test]
        public void TestMultiPointMShapeMeasure()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointMShape points = new MultiPointMShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, measures);
            Assert.AreEqual(measures[0], points.GetMeasure(0));
            Assert.AreEqual(measures[1], points.GetMeasure(1));
        }

        [Test]
        public void TestMultiPointZShapeType()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointZShape points = new MultiPointZShape(m_recordNumber, m_metadata, m_extent, m_positions,0.0, 1.0, 0.0, 1.0, measures);
            Assert.AreEqual(ShapeType.MultiPointZ, points.ShapeType);
        }

        [Test]
        public void TestMultiPointZShapePosition()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointZShape points = new MultiPointZShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, 0.0, 1.0, measures);
            Assert.AreEqual(m_positions[0], points[0]);
            Assert.AreEqual(new Cartographic(Constants.RadiansPerDegree, Constants.RadiansPerDegree, 1.0), points[1]);
        }
    }
}
