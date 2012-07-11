using System.Collections.Specialized;
using CesiumLanguageWriter;
using NUnit.Framework;
using Shapefile;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestMultiPointShapes
    {
        int m_recordNumber;
        StringDictionary m_metadata;
        CartographicExtent m_extent;
        Cartesian[] m_positions;

        public TestMultiPointShapes()
        {
            m_recordNumber = 1;
            m_metadata = new StringDictionary();
            m_extent = new CartographicExtent(0.0, 0.0, 1.0, 1.0);
            m_positions = new Cartesian[] {
                new Cartesian(0.0, 0.0, 0.0),
                new Cartesian(1.0, 1.0, 1.0),
            };
        }

        [Test]
        public void TestMultiPointShapeType()
        {
            Cartesian position = new Cartesian(1.0, 2.0, 0.0);
            MultiPointShape points = new MultiPointShape(m_recordNumber, m_metadata, m_extent, m_positions);
            Assert.That(points.ShapeType == ShapeType.MultiPoint);
        }

        [Test]
        public void TestMultiPointShapePosition()
        {

            MultiPointShape points = new MultiPointShape(m_recordNumber, m_metadata, m_extent, m_positions);
            Assert.That(points[0].Equals(m_positions[0]));
            Assert.That(points[1].Equals(m_positions[1]));
        }

        [Test]
        public void TestMultiPointMShapeType()
        {
            double[] measures = new double[] { 0.0, 1.0};
            MultiPointMShape point = new MultiPointMShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, measures);
            Assert.That(point.ShapeType == ShapeType.MultiPointM);
        }

        [Test]
        public void TestMultiPointMShapePosition()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointMShape points = new MultiPointMShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, measures);
            Assert.That(points[0].Equals(m_positions[0]));
            Assert.That(points[1].Equals(m_positions[1]));
        }

        [Test]
        public void TestMultiPointMShapeMeasure()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointMShape points = new MultiPointMShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, measures);
            Assert.That(points.Measures[0].Equals(measures[0]));
            Assert.That(points.Measures[1].Equals(measures[1]));
        }

        [Test]
        public void TestMultiPointZShapeType()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointZShape points = new MultiPointZShape(m_recordNumber, m_metadata, m_extent, m_positions,0.0, 1.0, 0.0, 1.0, measures);
            Assert.That(points.ShapeType == ShapeType.MultiPointZ);
        }

        [Test]
        public void TestMultiPointZShapePosition()
        {
            double[] measures = new double[] { 0.0, 1.0 };
            MultiPointZShape points = new MultiPointZShape(m_recordNumber, m_metadata, m_extent, m_positions, 0.0, 1.0, 0.0, 1.0, measures);
            Assert.That(points[0].Equals(m_positions[0]));
            Assert.That(points[1].Equals(m_positions[1]));
        }
    }
}
