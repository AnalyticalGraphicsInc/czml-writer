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
            Assert.That(result.Contains("\"availability\":\"20071206T163822.9199999999983Z/20071206T163832.9199999999983Z\""));
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
            Assert.That(result.Contains("\"vertexPositions\":{\"cartesian\":[1325931.7904320182,-4756430.587707164,4023655.821483748,1476128.3382630164,-5211500.059230109,3552014.7369627557]}"));
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
            Assert.That(result.Contains("\"polygon\":{\"material\":{\"solidColor\":{\"color\":{\"rgba\":[255,255,255,255]}}}}"));
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
            Assert.That(result.Contains("\"vertexPositions\":{\"cartesian\":[1325931.5828251496,-4756429.842972279,4023655.1872366834,1452105.843660085,-5126688.17072362,3493826.094821111]}"));
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
            Assert.That(result.Contains("\"vertexPositions\":{\"cartesian\":[1325931.5828251496,-4756429.842972279,4023655.1872366834,1452105.843660085,-5126688.17072362,3493826.094821111]}"));
        }
    }
}