using NUnit.Framework;
using KmlToCesiumLanguage;
using System.Xml.Linq;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    class TestLineString
    {
        [Test]
        public void LineStringTimeSpanProducesAvailability()
        {
            CzmlDocument document = new CzmlDocument();
            var placemark = new XElement("Placemark",
                                new XElement("name", "STS-122"),
                                new XElement("TimeSpan",
                                    new XElement("begin", "2007-12-06T16:31"),
                                    new XElement("end", "2007-12-06T16:40:18.040")),
                                new XElement("LineString",
                                    new XElement("altitudeMode", "absolute"),
                                    new XElement("coordinates", "-68.736144,37.34996200000001,105045.668999999 -68.73866678120611,37.3482063896964,105041.867978398")));

            var lineString = new LineString(placemark.Element("LineString"), document, placemark);
            lineString.WritePacket();
            string result = document.StringWriter.ToString();
            Assert.That(result.Contains("\"availability\":\"20071206T1631Z/20071206T164018.0400000000009Z\""));
        }

        [Test]
        public void LineStringProducesVertexPositions()
        {
            CzmlDocument document = new CzmlDocument();
            var placemark = new XElement("Placemark",
                                new XElement("LineString",
                                    new XElement("altitudeMode", "absolute"),
                                    new XElement("coordinates", "-68.736144,37.34996200000001,105045.668999999 -68.73866678120611,37.3482063896964,105041.867978398")));

            var lineString = new LineString(placemark.Element("LineString"), document, placemark);
            lineString.WritePacket();
            string result = document.StringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicRadians\":[-1.199672027924945,0.6518798123947666,105045.668999999,-1.1997160587632991,0.6518491712145866,105041.867978398]}"));
        }

        [Test]
        public void LineStringWithStyleProducesPolylineGraphics()
        {
            CzmlDocument document = new CzmlDocument();
            var placemark = new XElement("Placemark",
                                new XElement("Style", 
                                    new XElement("LineStyle",
                                        new XElement("color", "ffffffff"),
                                        new XElement("width", "2"))),
                                new XElement("LineString",
                                    new XElement("altitudeMode", "absolute"),
                                    new XElement("coordinates", "-68.736144,37.34996200000001,105045.668999999 -68.73866678120611,37.3482063896964,105041.867978398")));

            var lineString = new LineString(placemark.Element("LineString"), document, placemark);
            lineString.WritePacket();
            string result = document.StringWriter.ToString();
            Assert.That(result.Contains("\"polyline\":{\"color\":{\"rgba\":[255,255,255,255]},\"width\":2.0,\"outlineWidth\":0.0}"));
        }

        [Test]
        public void LineStringWithoutAltitudeProducesCartographicWithZeroHeight()
        {
            CzmlDocument document = new CzmlDocument();
            var placemark = new XElement("Placemark",
                                new XElement("LineString",
                                    new XElement("altitudeMode", "absolute"),
                                    new XElement("coordinates", "-68.736144,37.34996200000001 -68.73866678120611,37.3482063896964")));

            var lineString = new LineString(placemark.Element("LineString"), document, placemark);
            lineString.WritePacket();
            string result = document.StringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicRadians\":[-1.199672027924945,0.6518798123947666,0.0,-1.1997160587632991,0.6518491712145866,0.0]}"));
        }

        [Test]
        public void LineStringTesselateAndClampToGroundProducesCartographicWithZeroHeight()
        {
            CzmlDocument document = new CzmlDocument();
            var placemark = new XElement("Placemark",
                                new XElement("LineString",
                                    new XElement("tessellate", "1"),
                                    new XElement("altitudeMode", "clampToGround"),
                                    new XElement("coordinates", "-68.736144,37.34996200000001,105045.668999999 -68.73866678120611,37.3482063896964,105045.668999999")));

            var lineString = new LineString(placemark.Element("LineString"), document, placemark);
            lineString.WritePacket();
            string result = document.StringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicRadians\":[-1.199672027924945,0.6518798123947666,0.0,-1.1997160587632991,0.6518491712145866,0.0]}"));
        }
    }
}
