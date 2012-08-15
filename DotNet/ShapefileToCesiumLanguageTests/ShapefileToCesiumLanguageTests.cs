﻿using System.Collections.Specialized;
using System.Drawing;
using System.IO;
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
        private CzmlDocument m_document;
        private StringDictionary m_metadata;
        private StringWriter m_stringWriter;

        private string m_pointPattern;
        private string m_polygonPattern;
        private string m_polylinePattern;
        private string m_trianglePattern;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_document = new CzmlDocument(m_stringWriter);
            m_metadata = new StringDictionary();
            m_pointPattern = @"{""id"":""[0-9a-zA-Z-]+"",""position"":{""cartographicRadians"":\[-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*\]},""point"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}";
            m_polygonPattern = @"{""id"":""[0-9a-zA-Z-]+"",""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}},""vertexPositions"":{""cartographicRadians"":\[(-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,?)+\]}}";
            m_polylinePattern = @"{""id"":""[0-9a-zA-Z-]+"",""vertexPositions"":{""cartographicRadians"":\[(-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,-?(\d)*\.([\de-])*,?)+\]},""polyline"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}";
            m_trianglePattern = @"{""id"":""[0-9a-zA-Z-]+"",""polygon"":{""material"":{""solidColor"":{""color"":{""rgba"":\[\d{1,3},\d{1,3},\d{1,3},\d{1,3}\]}}}},""vertexPositions"":{""cartographicRadians"":\[(-?(\d)*\.([\de-])*,?){9}\]}}";
        }

        [Test]
        public void TestPointConversion()
        {
            // Shapefile contains 37 points
            string shapefileName = "SampleShapefiles/110m_admin_0_tiny_countries.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            Regex pointPattern = new Regex(m_pointPattern);
            string result = m_stringWriter.ToString();
            Assert.AreEqual(37, pointPattern.Matches(result).Count);
        }

        [Test]
        public void TestPointZConversion()
        {
            string shapefileName = "SampleShapefiles/zpoint_example.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_stringWriter.ToString();
            Assert.IsTrue(System.Text.RegularExpressions.Regex.IsMatch(result, m_pointPattern));
        }

        [Test]
        public void TestPolylineConversion()
        {
            // Shapefile contains 8 polylines: 7 with 1 part, and 1 with 4 parts
            string shapefileName = "SampleShapefiles/ne_110m_geographic_lines.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            Regex polylinePattern = new Regex(m_polylinePattern);
            string result = m_stringWriter.ToString();
            Assert.AreEqual(11, polylinePattern.Matches(result).Count);
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
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0 };

            PolylineZShape polylineZShape = new PolylineZShape(0, new StringDictionary(), extent, parts, positions, 1.0, 8.0, zValues, 0.0, 0.0, measures);
            Polyline polyline = new Polyline(polylineZShape, m_document, Color.Blue);
            polyline.Write();
            string result = m_stringWriter.ToString();
            Assert.IsTrue(System.Text.RegularExpressions.Regex.IsMatch(result, m_polylinePattern));
        }

        [Test]
        public void TestPolygonConversion()
        {
            string shapefileName = "SampleShapefiles/110m_ocean.shp";
            ShapefileReader reader = new ShapefileReader(shapefileName);
            ShapefileConverter.ShapefileToCesiumLanguage(reader, m_document, Color.Blue);
            string result = m_stringWriter.ToString();
            Assert.IsTrue(System.Text.RegularExpressions.Regex.IsMatch(result, m_polygonPattern));
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
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

            PolygonZShape polygonZShape = new PolygonZShape(0, m_metadata, extent, parts, positions, 1.0, 8.0, zValues, 0.0, 0.0, measures);
            Polygon polygon = new Polygon(polygonZShape, m_document, Color.Blue);
            polygon.Write();
            string result = m_stringWriter.ToString();
            Assert.IsTrue(System.Text.RegularExpressions.Regex.IsMatch(result, m_polygonPattern));
        }

        [Test]
        public void JoinsPolygonWithMultipleHoles()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(-122.0, 37.0),
                new Rectangular(-121.9, 37.0),
                new Rectangular(-121.9, 37.1),
                new Rectangular(-122.0, 37.1),
                new Rectangular(-122.0, 37.0),
                
                new Rectangular(-121.99, 37.01),
                new Rectangular(-121.99, 37.04),
                new Rectangular(-121.96, 37.04),
                new Rectangular(-121.96, 37.01),
                new Rectangular(-121.99, 37.01),
                
                new Rectangular(-121.94, 37.06),
                new Rectangular(-121.94, 37.09),
                new Rectangular(-121.91, 37.09),
                new Rectangular(-121.91, 37.06),
                new Rectangular(-121.94, 37.06),

                new Rectangular(-121.99, 37.06),
                new Rectangular(-121.99, 37.09),                
                new Rectangular(-121.96, 37.09),
                new Rectangular(-121.96, 37.06),                
                new Rectangular(-121.99, 37.06),
                                           
                new Rectangular(-121.94, 37.01),
                new Rectangular(-121.94, 37.04),
                new Rectangular(-121.91, 37.04),
                new Rectangular(-121.91, 37.01),
                new Rectangular(-121.94, 37.01)
            };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] { 0, 5, 10, 15, 20 };

            Polygon polygon = new Polygon(new PolygonShape(0, m_metadata, extent, parts, positions), m_document, Color.Blue);
            polygon.Write();
            string result = m_stringWriter.ToString();
            Regex polygonPattern = new Regex(m_polygonPattern);
            Assert.AreEqual(1, polygonPattern.Matches(result).Count);
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

            Polygon polygon = new Polygon(new PolygonShape(0, m_metadata, extent, parts, positions), m_document, Color.Blue);
            polygon.Write();
            string result = m_stringWriter.ToString();
            Regex polygonPattern = new Regex(m_polygonPattern);
            Assert.AreEqual(2, polygonPattern.Matches(result).Count);
        }

        [Test]
        public void TestMultipatchConversionWithInnerAndOuterRings()
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

            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] { 0, 5 };
            MultiPatchPartType[] partTypes = new MultiPatchPartType[] { MultiPatchPartType.OuterRing, MultiPatchPartType.InnerRing} ;

            double[] zValues = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

            MultiPatchShape multipatch = new MultiPatchShape(0, m_metadata, extent, parts, partTypes, positions, 0.0, 0.0, zValues, 0.0, 0.0, measures);
            MultiPatch patch = new MultiPatch(multipatch, m_document, Color.Blue);
            patch.Write();
            string result = m_stringWriter.ToString();
            Assert.IsTrue(System.Text.RegularExpressions.Regex.IsMatch(result, m_polygonPattern));
        }

        [Test]
        public void TestMultipatchConversionWithMultipleRings()
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

            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 10.0, 10.0);
            int[] parts = new int[] { 0, 5 };
            MultiPatchPartType[] partTypes = new MultiPatchPartType[] { MultiPatchPartType.Ring, MultiPatchPartType.Ring };

            double[] zValues = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

            MultiPatchShape multipatch = new MultiPatchShape(0, m_metadata, extent, parts, partTypes, positions, 0.0, 0.0, zValues, 0.0, 0.0, measures);
            MultiPatch patch = new MultiPatch(multipatch, m_document, Color.Blue);
            patch.Write();
            string result = m_stringWriter.ToString();
            Regex polygonPattern = new Regex(m_polygonPattern);
            Assert.AreEqual(2, polygonPattern.Matches(result).Count);
        }

        [Test]
        public void TestMultipatchConversionWithTriangleFan()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 0.0),
                new Rectangular(1.0, 2.0),
                new Rectangular(2.0, 0.0),
                new Rectangular(1.0, -1.0),
                new Rectangular(-1.0, -1.0),
                new Rectangular(-2.0, 0.0),
                new Rectangular(-1.0, 2.0)
            };

            CartographicExtent extent = new CartographicExtent(-2.0, -1.0, 2.0, 2.0);
            int[] parts = new int[] { 0 };
            MultiPatchPartType[] partTypes = new MultiPatchPartType[] { MultiPatchPartType.TriangleFan };

            double[] zValues = new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

            MultiPatchShape multipatch = new MultiPatchShape(0, m_metadata, extent, parts, partTypes, positions, 0.0, 0.0, zValues, 0.0, 0.0, measures);
            MultiPatch patch = new MultiPatch(multipatch, m_document, Color.Blue);
            patch.Write();
            string result = m_stringWriter.ToString();
            Regex trianglePattern = new Regex(m_trianglePattern);
            Assert.AreEqual(5, trianglePattern.Matches(result).Count);
        }

        [Test]
        public void TestMultipatchConversionWithTriangleStrip()
        {
            Rectangular[] positions = new Rectangular[] {
                new Rectangular(0.0, 0.0),
                new Rectangular(0.0, 1.0),
                new Rectangular(1.0, 0.0),
                new Rectangular(1.0, 1.0),
                new Rectangular(2.0, 0.0),
                new Rectangular(2.0, 1.0),
                new Rectangular(3.0, 0.0)
            };

            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 3.0, 1.0);
            int[] parts = new int[] { 0 };
            MultiPatchPartType[] partTypes = new MultiPatchPartType[] { MultiPatchPartType.TriangleStrip };

            double[] zValues = new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 };
            double[] measures = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

            MultiPatchShape multipatch = new MultiPatchShape(0, m_metadata, extent, parts, partTypes, positions, 0.0, 0.0, zValues, 0.0, 0.0, measures);
            MultiPatch patch = new MultiPatch(multipatch, m_document, Color.Blue);
            patch.Write();
            string result = m_stringWriter.ToString();
            Regex trianglePattern = new Regex(m_trianglePattern);
            Assert.AreEqual(5, trianglePattern.Matches(result).Count);
        }

        [Test]
        public void TestMultiPoint()
        {
            Cartographic[] points = new Cartographic[] {
                new Cartographic(0.0, 0.0, 0.0),
                new Cartographic(1.0, 1.0, 1.0),
                new Cartographic(2.0, 2.0, 2.0)
            };
            CartographicExtent extent = new CartographicExtent(0.0, 0.0, 2.0, 2.0);
            MultiPointShape multipoint = new MultiPointShape(0, m_metadata, extent, points);
            MultiPoint mp = new MultiPoint(multipoint, m_document, Color.Blue);
            mp.Write();
            string result = m_stringWriter.ToString();
            Regex pointPattern = new Regex(m_pointPattern);
            Assert.AreEqual(3, pointPattern.Matches(result).Count);
        }
    }
}
