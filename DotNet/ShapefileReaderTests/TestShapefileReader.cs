using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Linq;
using System.Text;
using Shapefile;
using NUnit.Framework;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestShapefileReader
    {
        ShapefileReader m_reader;
        private string shapefileName = ".\\ExampleShapefiles\\PhiladelphiaBuildings200712.shp";

        public TestShapefileReader()
        {
            m_reader = new ShapefileReader(shapefileName);
        }

        [Test]
        public void GetMetadataKeys()
        {
            Shape shape = m_reader[0];
            string[] keys = shape.GetMetadataFields();
            Array.Sort(keys);
            string[] expected = new string[] { "area", "area_1", "date_updat", "elev", "fcode", "len", "perimeter", "source"};
            CollectionAssert.AreEqual(keys, expected);
        }

        [Test]
        public void GetMetadataValue()
        {
            Shape shape = m_reader[0];
            string value = shape.GetMetadataValue("date_updat");
            Assert.That(value.Equals("2004"));

            shape = m_reader[390292];
            value = shape.GetMetadataValue("source");
            Assert.That(value.Equals("SANBORN"));
        }

        [Test]
        public void GetRecordNumber()
        {
            Shape shape = m_reader[0];
            Assert.That(shape.RecordNumber == 1);
        }
    }
}
