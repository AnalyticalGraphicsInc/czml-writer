using NUnit.Framework;
using Shapefile;
using ShapefileToCesiumLanguage;
using System.Drawing;

namespace ShapefileToCesiumLanguageTests
{
    [TestFixture]
    public class ShapefileToCesiumLanguageTests
    {
        CzmlDocument m_document;

        public ShapefileToCesiumLanguageTests()
        {
            m_document = new CzmlDocument();
        }

        [Test]
        public void TestPointConversion()
        {
            // Shapefile contains 37 points
            string shapefileName = ".\\..\\..\\SampleShapefiles\\110m_admin_0_tiny_countries.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("{\"id\":\"1\",\"position\":{\"cartographicDegrees\":[-71.95390431057388,21.912993441281643,0.0]},\"point\":{\"color\":{\"rgba\":[0,0,255,255]}}}"));
        }
    }
}
