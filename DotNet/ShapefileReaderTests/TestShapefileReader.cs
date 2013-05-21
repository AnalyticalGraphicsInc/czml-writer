using System;
using System.IO;
using NUnit.Framework;
using Shapefile;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestShapefileReader
    {
        private ShapefileReader m_reader;
        private string shapefileName;

        [SetUp]
        public void SetUp()
        {
            shapefileName = "SampleShapefiles/ne_110m_admin_0_countries.shp";
            m_reader = new ShapefileReader(shapefileName);
        }

        [Test]
        public void TestGetMetadataFields()
        {
            Shape shape = m_reader[0];
            string[] keys = shape.GetMetadataFields();
            Array.Sort(keys);
            string[] expected = new string[] { "abbrev", "adm0_a3", "adm0_dif", "admin", "featurecla", "fips_10_",
                                               "gdp_md_est", "geou_dif", "geounit", "gu_a3", "iso_a2", "iso_a3", "iso_n3",
                                               "labelrank", "level", "map_color", "name", "name_forma",
                                               "name_sort", "pop_est", "postal", "scalerank", "sov_a3", "sovereignt",
                                               "su_a3", "su_dif", "subunit", "terr_", "type"
            };
            CollectionAssert.AreEqual(expected, keys);
        }

        [Test]
        public void TestGetMetadataValue()
        {
            Shape shape = m_reader[0];
            string value = shape.GetMetadataValue("abbrev");
            Assert.AreEqual("Afg.", value);

            value = shape.GetMetadataValue("pop_est");
            Assert.AreEqual("28400000.00", value, "Metadata does not equal expected value.");
        }

        [Test]
        public void TestGetRecordNumber()
        {
            Shape shape = m_reader[0];
            Assert.AreEqual(1, shape.RecordNumber);
        }

        [Test]
        public void ConvertsUnsupportedProjection()
        {
            shapefileName = "SampleShapefiles/test.shp";
            Assert.Throws(typeof(InvalidDataException), () => m_reader = new ShapefileReader(shapefileName));
        }

        [Test]
        public void ReadPointShapes()
        {
            shapefileName = "SampleShapefiles/Cities.shp";
            m_reader = new ShapefileReader(shapefileName);
            Assert.AreEqual(87, m_reader.Count);
        }
    }
}
