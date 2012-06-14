using System.Collections.Specialized;
using System.Drawing;
using System.Text.RegularExpressions;
using CesiumLanguageWriter;
using NUnit.Framework;
using Shapefile;
using ShapefileToCesiumLanguage;

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
            Regex pointPattern = new Regex(@"{""id"":""[0-9a-zA-Z-]+"",""position"":{""cartographicDegrees"":\[-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*\]},""point"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}");
            Assert.That(pointPattern.Matches(result).Count == 37);
        }

        [Test]
        public void TestPointZConversion()
        {
            string shapefileName = ".\\..\\..\\SampleShapefiles\\zpoint_example.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_document.StringWriter.ToString();
            string pointPattern = @"{""id"":""[0-9a-zA-Z-]+"",""position"":{""cartographicDegrees"":\[-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*\]},""point"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, pointPattern));
        }

        [Test]
        public void TestPolylineConversion()
        {
            // Shapefile contains 8 polylines: 7 with 1 part, and 1 with 4 parts
            string shapefileName = ".\\..\\..\\SampleShapefiles\\ne_110m_geographic_lines.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_document.StringWriter.ToString();
            Regex polylinePattern = new Regex(@"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[(-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,?)+\]},""polyline"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}");
            Assert.That(polylinePattern.Matches(result).Count == 11);
        }

        [Test]
        public void TestPolylineZConversion()
        {
            string shapefileName = ".\\..\\..\\SampleShapefiles\\iran_road.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_document.StringWriter.ToString();
            string polylinePattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[(-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,?)+\]},""polyline"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polylinePattern));
        }

        [Test]
        public void TestPolylineZValues()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 0.0),
                new Rectangular(1.0, 1.0),
                new Rectangular(2.0, 2.0),
                new Rectangular(3.0, 3.0),
            };

            double[] zValues = new double[] { 0.0, 1.0, 2.0, 3.0 };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 3.0, 3.0);
            int[] parts = new int[] { 0 };

            PolylineZShape polylineZShape = new PolylineZShape(0, new StringDictionary(), extent, parts, positions, 1.0, 8.0, zValues, 0.0, 0.0, new double[] { });
            Polyline polyline = new Polyline(polylineZShape, m_document, Color.Blue);
            polyline.Write();
            string result = m_document.StringWriter.ToString();
            string polylinePattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[0.0,0.0,0.0,1.0,1.0,1.0,2.0,2.0,2.0,3.0,3.0,3.0\]},""polyline"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polylinePattern));
        }

        [Test]
        public void TestPolygonConversion()
        {
            string shapefileName = ".\\..\\..\\SampleShapefiles\\110m_ocean.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_document.StringWriter.ToString();
            string polygonPattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[(-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,?)+\]},""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polygonPattern));
        }

        [Test]
        public void TestPolygonZValues()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 5.0),
                new Rectangular(5.0, 10.0),
                new Rectangular(10.0, 5.0),
                new Rectangular(5.0, 0.0),
                new Rectangular(0.0, 5.0),

                new Rectangular(2.0, 5.0),
                new Rectangular(5.0, 2.0),
                new Rectangular(8.0, 5.0),
                new Rectangular(5.0, 8.0),
                new Rectangular(2.0, 5.0),
            };

            double[] zValues = new double[] {
                1.0, 2.0, 3.0, 4.0, 1.0,
                5.0, 6.0, 7.0, 8.0, 5.0
            };

            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] { 0, 5 };

            PolygonZShape polygonZShape = new PolygonZShape(0, new StringDictionary(), extent, parts, positions, 1.0, 8.0, zValues, 0.0, 0.0, new double[] { });
            Polygon polygon = new Polygon(polygonZShape, m_document, Color.Blue);
            polygon.Write();
            string result = m_document.StringWriter.ToString();
            string polygonPattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[0.0,5.0,1.0,5.0,10.0,2.0,10.0,5.0,3.0,8.0,5.0,7.0,5.0,8.0,8.0,2.0,5.0,5.0,5.0,2.0,6.0,8.0,5.0,7.0,10.0,5.0,3.0,5.0,0.0,4.0,0.0,5.0,1.0\]},""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polygonPattern));
        }

        [Test]
        public void JoinsPolygonHoleWhenIntersectionIsAtVertex()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 5.0),
                new Rectangular(5.0, 10.0),
                new Rectangular(10.0, 5.0),
                new Rectangular(5.0, 0.0),
                new Rectangular(0.0, 5.0),

                new Rectangular(2.0, 5.0),
                new Rectangular(5.0, 2.0),
                new Rectangular(8.0, 5.0),
                new Rectangular(5.0, 8.0),
                new Rectangular(2.0, 5.0)
            };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] {0, 5};

            Polygon polygon = new Polygon(new PolygonShape(0, new StringDictionary(), extent, parts, positions), m_document, Color.Blue);
            polygon.Write();
            string result = m_document.StringWriter.ToString();
            string polygonPattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[0.0,5.0,0.0,5.0,10.0,0.0,10.0,5.0,0.0,8.0,5.0,0.0,5.0,8.0,0.0,2.0,5.0,0.0,5.0,2.0,0.0,8.0,5.0,0.0,10.0,5.0,0.0,5.0,0.0,0.0,0.0,5.0,0.0\]},""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polygonPattern));
        }

        [Test]
        public void JoinsPolygonHoleWhenIntersectionIsAtEdge()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 5.0),
                new Rectangular(5.0, 10.0),
                new Rectangular(10.0, 5.0),
                new Rectangular(5.0, 0.0),
                new Rectangular(0.0, 5.0),

                new Rectangular(3.0, 7.0),
                new Rectangular(3.0, 3.0),
                new Rectangular(7.0, 3.0),
                new Rectangular(7.0, 7.0),
                new Rectangular(3.0, 7.0)
            };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] { 0, 5 };

            Polygon polygon = new Polygon(new PolygonShape(0, new StringDictionary(), extent, parts, positions), m_document, Color.Blue);
            polygon.Write();
            string result = m_document.StringWriter.ToString();
            string polygonPattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[0.0,5.0,0.0,5.0,10.0,0.0,10.0,5.0,0.0,7.0,3.0,0.0,7.0,7.0,0.0,3.0,7.0,0.0,3.0,3.0,0.0,7.0,3.0,0.0,10.0,5.0,0.0,5.0,0.0,0.0,0.0,5.0,0.0\]},""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polygonPattern));
        }

        [Test]
        public void JoinsPolygonWithReflexVertices()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 0.0),
                new Rectangular(0.0, 10.0),
                new Rectangular(9.0, 10.0),
                new Rectangular(10.0, 2.0),
                new Rectangular(8.0, 0.0),
                new Rectangular(7.0, 4.5),
                new Rectangular(6.0, 5.2),
                new Rectangular(5.5, 4.75),
                new Rectangular(5.0, 5.5),

                new Rectangular(0.0, 0.0),
                new Rectangular(3.0, 6.0),
                new Rectangular(2.0, 6.0),
                new Rectangular(2.0, 4.0),
                new Rectangular(3.0, 6.0)
            };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] { 0, 10 };

            Polygon polygon = new Polygon(new PolygonShape(0, new StringDictionary(), extent, parts, positions), m_document, Color.Blue);
            polygon.Write();
            string result = m_document.StringWriter.ToString();
            string polygonPattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[0.0,0.0,0.0,0.0,10.0,0.0,9.0,10.0,0.0,10.0,2.0,0.0,8.0,0.0,0.0,7.0,4.5,0.0,6.0,5.2,0.0,5.5,4.75,0.0,5.0,5.5,0.0,3.0,6.0,0.0,2.0,6.0,0.0,2.0,4.0,0.0,3.0,6.0,0.0,5.0,5.5,0.0,0.0,0.0,0.0\]},""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polygonPattern));
        }

        [Test]
        public void JoinsPolygonWithMultipleHoles()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(3.0, 5.0),
                new Rectangular(5.0, 5.0),
                new Rectangular(5.0, 8.0),
                new Rectangular(3.0, 6.0),
                new Rectangular(3.0, 5.0),

                new Rectangular(0.0, 5.0),
                new Rectangular(5.0, 10.0),
                new Rectangular(10.0, 5.0),
                new Rectangular(5.0, 0.0),
                new Rectangular(0.0, 5.0),

                new Rectangular(6.0, 5.0),
                new Rectangular(7.0, 4.0),
                new Rectangular(8.0, 5.0),
                new Rectangular(7.0, 6.0),
                new Rectangular(6.0, 5.0)
            };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] { 0, 5, 10 };

            Polygon polygon = new Polygon(new PolygonShape(0, new StringDictionary(), extent, parts, positions), m_document, Color.Blue);
            polygon.Write();
            string result = m_document.StringWriter.ToString();
            string polygonPattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[0.0,5.0,0.0,5.0,10.0,0.0,10.0,5.0,0.0,8.0,5.0,0.0,7.0,6.0,0.0,6.0,5.0,0.0,5.0,5.0,0.0,5.0,8.0,0.0,3.0,6.0,0.0,3.0,5.0,0.0,5.0,5.0,0.0,6.0,5.0,0.0,7.0,4.0,0.0,8.0,5.0,0.0,10.0,5.0,0.0,5.0,0.0,0.0,0.0,5.0,0.0\]},""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}}}";
            Assert.That(System.Text.RegularExpressions.Regex.IsMatch(result, polygonPattern));
        }

        [Test]
        public void JoinsPolygonWithMultipleOuterRings()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 5.0),
                new Rectangular(5.0, 10.0),
                new Rectangular(10.0, 5.0),
                new Rectangular(5.0, 0.0),
                new Rectangular(0.0, 5.0),

                new Rectangular(2.0, 5.0),
                new Rectangular(5.0, 2.0),
                new Rectangular(8.0, 5.0),
                new Rectangular(5.0, 8.0),
                new Rectangular(2.0, 5.0),

                new Rectangular(20.0, 5.0),
                new Rectangular(25.0, 10.0),
                new Rectangular(30.0, 5.0),
                new Rectangular(25.0, 0.0),
                new Rectangular(20.0, 5.0),

                new Rectangular(22.0, 5.0),
                new Rectangular(25.0, 2.0),
                new Rectangular(28.0, 5.0),
                new Rectangular(25.0, 8.0),
                new Rectangular(22.0, 5.0)
            };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 30.0, 10.0);
            int[] parts = new int[] { 0, 5, 10, 15 };

            Polygon polygon = new Polygon(new PolygonShape(0, new StringDictionary(), extent, parts, positions), m_document, Color.Blue);
            polygon.Write();
            string result = m_document.StringWriter.ToString();
            Regex polygonPattern = new Regex(@"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicDegrees"":\[(-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,?)+\]},""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}}}");
            Assert.That(polygonPattern.Matches(result).Count == 2);
        }
    }
}
