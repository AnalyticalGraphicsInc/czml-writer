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
                new Rectangular(1.0, 1.0),
                new Rectangular(2.0, 2.0)
            };
            m_extent = new CartographicExtent(1.0, 1.0, 2.0, 2.0);
            m_parts = new int[] { 0 };
        }

        [Test]
        public void TestPolylineShapeType()
        {
            PolylineShape line = new PolylineShape(1, m_metadata, m_extent, m_parts, m_positions);
            Assert.That(line.ShapeType == ShapeType.Polyline);
        }

        [Test]
        public void TestPolylinePositions()
        {
            PolylineShape line = new PolylineShape(1, m_metadata, m_extent, m_parts, m_positions);
            Assert.That(line[0][0].Equals(new Cartesian(1.0, 1.0, 0.0)));
            Assert.That(line[0][1].Equals(new Cartesian(2.0, 2.0, 0.0)));
        }

        [Test]
        public void TestPolylineMShapeType()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolylineMShape line = new PolylineMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.That(line.ShapeType == ShapeType.PolylineM);
        }

        [Test]
        public void TestPolylineMMeasures()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolylineMShape line = new PolylineMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.That(line[0].GetMeasure(0) == 1.0);
            Assert.That(line[0].GetMeasure(1) == 2.0);
        }

        [Test]
        public void TestPolylineMPositions()
        {
            double[] measures = new double[] { 1.0, 2.0 };
            PolylineMShape line = new PolylineMShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, measures);
            Assert.That(line[0][0].Equals(new Cartesian(1.0, 1.0, 0.0)));
            Assert.That(line[0][1].Equals(new Cartesian(2.0, 2.0, 0.0)));
        }

        [Test]
        public void TestPolylineZShapeType()
        {
            double[] zValues = new double[] { 1.0, 2.0 };
            double[] measures = new double[] { 0.0, 0.0 };
            PolylineZShape line = new PolylineZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.That(line.ShapeType == ShapeType.PolylineZ);
        }

        [Test]
        public void TestPolylineZPositions()
        {
            double[] zValues = new double[] { 1.0, 2.0 };
            double[] measures = new double[] { 0.0, 0.0 };
            PolylineZShape line = new PolylineZShape(1, m_metadata, m_extent, m_parts, m_positions, 1.0, 2.0, zValues, 0.0, 0.0, measures);
            Assert.That(line[0][0].Equals(new Cartesian(1.0, 1.0, 1.0)));
            Assert.That(line[0][1].Equals(new Cartesian(2.0, 2.0, 2.0)));
        }
    }
}
