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

        [Test]
        public void TestPolylineConversion()
        {
            // Shapefile contains 8 polylines
            string shapefileName = ".\\..\\..\\SampleShapefiles\\ne_110m_geographic_lines.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_document.StringWriter.ToString();
            string polylinePattern = "\"id\":\"(\\d)+\",\"vertexPositions\":\\{\"cartographicDegrees\":\\[(-?(\\d)*\\.(\\d)*,-?(\\d)*\\.(\\d)*,-?(\\d)*\\.(\\d)*,?)+\\]\\},\"polyline\":\\{\"color\":\\{\"rgba\":\\[\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}\\]\\}\\}\\}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polylinePattern));

        }

        [Test]
        public void TestPolygonConversion()
        {
            // 2 Polygons
            string shapefileName = ".\\..\\..\\SampleShapefiles\\110m_ocean.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_document.StringWriter.ToString();
            string polygonPattern = "\"id\":\"(\\d)+\",\"vertexPositions\":\\{\"cartographicDegrees\":\\[(-?(\\d)*\\.(\\d)*,-?(\\d)*\\.(\\d)*,-?(\\d)*\\.(\\d)*,?)+\\]\\},\"polygon\":\\{\"material\":{\"solidColor\":\\{\"color\":\\{\"rgba\":\\[\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}\\]\\}\\}\\}\\}\\}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polygonPattern));
        }
    }
}
