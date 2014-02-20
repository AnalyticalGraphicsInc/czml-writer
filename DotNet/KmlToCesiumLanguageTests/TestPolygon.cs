using System.IO;
using System.Xml.Linq;
using KmlToCesiumLanguage;
using NUnit.Framework;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestPolygon
    {
        private StringWriter m_stringWriter;
        private CzmlDocument m_document;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_document = new CzmlDocument(m_stringWriter);
        }

        [Test]
        public void PolygonWithTimeSpanProducesAvailability()
        {
            XElement placemark = new XElement("Placemark",
                                              new XElement("TimeSpan",
                                                           new XElement("begin", "2007-12-06T16:38:22.920"),
                                                           new XElement("end", "2007-12-06T16:38:32.920")),
                                              new XElement("Polygon",
                                                           new XElement("altitudeMode", "absolute"),
                                                           new XElement("outerBoundaryIs",
                                                                        new XElement("LinearRing",
                                                                                     new XElement("coordinates", "-74.42333000000001,39.364163,1 -74.1855216770938,33.4296610235422,105622.226606304")))));
            var polygon = new Polygon(placemark.Element("Polygon"), m_document, placemark);
            polygon.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"availability\":\"20071206T163822.9199999999983Z/20071206T163832.9199999999983Z\"", result);
        }

        [Test]
        public void PolygonOuterBoundaryProducesVertexPositions()
        {
            XElement placemark = new XElement("Placemark",
                                              new XElement("name", "Access Polygon"),
                                              new XElement("Polygon",
                                                           new XElement("altitudeMode", "absolute"),
                                                           new XElement("outerBoundaryIs",
                                                                        new XElement("LinearRing",
                                                                                     new XElement("coordinates", "-74.42333000000001,39.364163,1 -74.1855216770938,33.4296610235422,105622.226606304")))));
            var polygon = new Polygon(placemark.Element("Polygon"), m_document, placemark);
            polygon.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"vertexPositions\":{\"cartographicRadians\":[-1.2989321487982717,0.6870342516417286,1,-1.2947816105749124,0.583457652686429,105622.226606304]}", result);
        }

        [Test]
        public void PolygonWithPolyStyleProducesPolygonGraphics()
        {
            XElement placemark = new XElement("Placemark",
                                              new XElement("Style",
                                                           new XElement("PolyStyle",
                                                                        new XElement("color", "ffffffff"))),
                                              new XElement("Polygon",
                                                           new XElement("altitudeMode", "absolute"),
                                                           new XElement("outerBoundaryIs",
                                                                        new XElement("LinearRing",
                                                                                     new XElement("coordinates", "-74.42333000000001,39.364163,1 -74.1855216770938,33.4296610235422,105622.226606304")))));
            var polygon = new Polygon(placemark.Element("Polygon"), m_document, placemark);
            polygon.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"polygon\":{\"material\":{\"solidColor\":{\"color\":{\"rgba\":[255,255,255,255]}}}}", result);
        }

        [Test]
        public void PolygonClampToGroundProducesCartographicsWithZeroHeight()
        {
            XElement placemark = new XElement("Placemark",
                                              new XElement("name", "Access Polygon"),
                                              new XElement("Polygon",
                                                           new XElement("altitudeMode", "clampToGround"),
                                                           new XElement("outerBoundaryIs",
                                                                        new XElement("LinearRing",
                                                                                     new XElement("coordinates", "-74.42333000000001,39.364163,1 -74.1855216770938,33.4296610235422,105622.226606304")))));
            var polygon = new Polygon(placemark.Element("Polygon"), m_document, placemark);
            polygon.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"vertexPositions\":{\"cartographicRadians\":[-1.2989321487982717,0.6870342516417286,0,-1.2947816105749124,0.583457652686429,0]}", result);
        }

        [Test]
        public void PolygonWithHoles()
        {
            XElement placemark = new XElement("Placemark",
                                              new XElement("name", "Access Polygon"),
                                              new XElement(
                                                  "Polygon",
                                                  new XElement("altitudeMode", "clampToGround"),
                                                  new XElement(
                                                      "outerBoundaryIs",
                                                      new XElement(
                                                          "LinearRing",
                                                          new XElement("coordinates", "-122.0,37.0 -121.9,37.0 -121.9,37.1 -122.0,37.1 -122.0,37.0"))),
                                                  new XElement(
                                                      "innerBoundaryIs",
                                                      new XElement(
                                                          "LinearRing",
                                                          new XElement("coordinates", "-121.99,37.01 -121.96,37.01 -121.96,37.04 -121.99,37.04 -121.99,37.01")))));
            var polygon = new Polygon(placemark.Element("Polygon"), m_document, placemark);
            polygon.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"vertexPositions\":{\"cartographicRadians\":[-2.129301687433082,0.6457718232379019,0,-2.1275563581810877,0.6457718232379019,0,-2.128603555732284,0.6464699549386996,0,-2.128603555732284,0.6459463561631014,0,-2.1291271545078825,0.6459463561631014,0,-2.1291271545078825,0.6464699549386996,0,-2.128603555732284,0.6464699549386996,0,-2.1275563581810877,0.6457718232379019,0,-2.1275563581810877,0.6475171524898963,0,-2.129301687433082,0.6475171524898963,0,-2.129301687433082,0.6457718232379019,0]}", result);
        }

        [Test]
        public void PolygonWithMultipleHoles()
        {
            XElement placemark = new XElement("Placemark",
                                              new XElement("name", "Access Polygon"),
                                              new XElement(
                                                  "Polygon",
                                                  new XElement("altitudeMode", "clampToGround"),
                                                  new XElement(
                                                      "outerBoundaryIs",
                                                      new XElement(
                                                          "LinearRing",
                                                          new XElement("coordinates", "-122.0,37.0 -121.9,37.0 -121.9,37.1 -122.0,37.1 -122.0,37.0"))),
                                                  new XElement(
                                                      "innerBoundaryIs",
                                                      new XElement(
                                                          "LinearRing",
                                                          new XElement("coordinates", "-121.99,37.01 -121.96,37.01 -121.96,37.04 -121.99,37.04 -121.99,37.01"))),
                                                  new XElement(
                                                      "innerBoundaryIs",
                                                      new XElement(
                                                          "LinearRing",
                                                          new XElement("coordinates", "-121.94,37.06 -121.91,37.06 -121.91,37.09 -121.94,37.09 -121.94,37.06")))));
            var polygon = new Polygon(placemark.Element("Polygon"), m_document, placemark);
            polygon.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"vertexPositions\":{\"cartographicRadians\":[-2.129301687433082,0.6457718232379019,0,-2.1275563581810877,0.6457718232379019,0,-2.128603555732284,0.6464699549386996,0,-2.128603555732284,0.6459463561631014,0,-2.1291271545078825,0.6459463561631014,0,-2.1291271545078825,0.6464699549386996,0,-2.128603555732284,0.6464699549386996,0,-2.1275563581810877,0.6457718232379019,0,-2.1275563581810877,0.6475171524898963,0,-2.127730891106287,0.6473426195646969,0,-2.127730891106287,0.6468190207890986,0,-2.1282544898818854,0.6468190207890986,0,-2.1282544898818854,0.6473426195646969,0,-2.127730891106287,0.6473426195646969,0,-2.1275563581810877,0.6475171524898963,0,-2.129301687433082,0.6475171524898963,0,-2.129301687433082,0.6457718232379019,0]}", result);
        }
    }
}