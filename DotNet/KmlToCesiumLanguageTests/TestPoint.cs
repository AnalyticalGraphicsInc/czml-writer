using System.IO;
using System.Xml.Linq;
using KmlToCesiumLanguage;
using NUnit.Framework;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestPoint
    {
        private StringWriter m_stringWriter;
        private CzmlDocument m_document;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_document = new CzmlDocument();
        }

        [Test]
        public void PointTimeSpanProducesAvailability()
        {
            XElement element = new XElement("Placemark",
                                            new XElement("name", "STS-122"),
                                            new XElement("TimeSpan",
                                                         new XElement("begin", "2007-12-06T16:31")),
                                            new XElement("description",
                                                         new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                                            new XElement("Point",
                                                         new XElement("altitudeMode", "absolute"),
                                                         new XElement("coordinates", "-80.604015,28.608305,48.5300000004579")));

            var point = new Point(element.Element("Point"), m_document, element);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                point.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"availability\":\"20071206T1631Z/99991231T235959.9999998999992Z\""));
        }

        [Test]
        public void PointPositionProducesCartographicRadians()
        {
            XElement element = new XElement("Placemark",
                                            new XElement("name", "STS-122"),
                                            new XElement("Point",
                                                         new XElement("altitudeMode", "absolute"),
                                                         new XElement("coordinates", "-80.604015,28.608305,48.5300000004579")));

            var point = new Point(element.Element("Point"), m_document, element);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                point.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"position\":{\"cartographicRadians\":[-1.4068054520768973,0.4993091156647564,48.5300000004579]}"));
        }

        [Test]
        public void PointWithIconStyleProducesBillboard()
        {
            XElement element = new XElement("Placemark",
                                            new XElement("name", "STS-122"),
                                            new XElement("TimeSpan",
                                                         new XElement("begin", "2007-12-06T16:31")),
                                            new XElement("Style",
                                                         new XElement("IconStyle",
                                                                      new XElement("color", "a1ff00ff"),
                                                                      new XElement("scale", "2"),
                                                                      new XElement("Icon",
                                                                                   new XElement("href", "http://maps.google.com/mapfiles/kml/pal3/icon61.png")))),
                                            new XElement("Point",
                                                         new XElement("altitudeMode", "absolute"),
                                                         new XElement("coordinates", "-80.604015,28.608305,48.5300000004579")));

            var point = new Point(element.Element("Point"), m_document, element);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                point.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"billboard\":{"));
            Assert.That(result.Contains("\"scale\":2.0"));
            Assert.That(result.Contains("\"image\":\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUg"));
        }

        [Test]
        public void ExtrudedPointProducesPolyline()
        {
            XElement element = new XElement("Placemark",
                                            new XElement("name", "STS-122"),
                                            new XElement("Point",
                                                         new XElement("extrude", 1),
                                                         new XElement("altitudeMode", "absolute"),
                                                         new XElement("coordinates", "-80.604015,28.608305,48.5300000004579")));

            var point = new Point(element.Element("Point"), m_document, element);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                point.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicRadians\":[-1.4068054520768973,0.4993091156647564,48.5300000004579,-1.4068054520768973,0.4993091156647564,0.0]}}"));
        }

        [Test]
        public void ExtrudedPointWithLineStyleProducesPolylineColor()
        {
            XElement element = new XElement("Placemark",
                                            new XElement("name", "STS-122"),
                                            new XElement("Style",
                                                         new XElement("LineStyle",
                                                                      new XElement("color", "a1ff00ff"))),
                                            new XElement("Point",
                                                         new XElement("extrude", 1),
                                                         new XElement("altitudeMode", "absolute"),
                                                         new XElement("coordinates", "-80.604015,28.608305,48.5300000004579")));

            var point = new Point(element.Element("Point"), m_document, element);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                point.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"polyline\":{\"color\":{\"rgba\":[255,0,255,161]}}"));
        }
    }
}