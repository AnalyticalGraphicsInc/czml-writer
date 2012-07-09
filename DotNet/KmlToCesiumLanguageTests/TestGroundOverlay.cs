using System.IO;
using System.Xml.Linq;
using KmlToCesiumLanguage;
using NUnit.Framework;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestGroundOverlay
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
        public void GroundOverlayTimeSpanProducesAvailability()
        {
            XElement element = new XElement("GroundOverlay",
                                            new XElement("TimeSpan",
                                                         new XElement("begin", "2007-12-06T16:31")),
                                            new XElement("LatLonBox",
                                                         new XElement("north", "90"),
                                                         new XElement("south", "-90"),
                                                         new XElement("east", "180"),
                                                         new XElement("west", "-180")));

            var groundOverlay = new GroundOverlay(element, m_document);
            groundOverlay.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"availability\":\"20071206T1631Z/99991231T235959.9999998999992Z\""));
        }

        [Test]
        public void LatLonBoxProducesVertexPositions()
        {
            XElement element = new XElement("GroundOverlay",
                                            new XElement("LatLonBox",
                                                         new XElement("north", "90"),
                                                         new XElement("south", "-90"),
                                                         new XElement("east", "180"),
                                                         new XElement("west", "-180")));

            var groundOverlay = new GroundOverlay(element, m_document);
            groundOverlay.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicRadians\":[-3.141592653589793,1.5707963267948966,0.0,3.141592653589793,1.5707963267948966,0.0,3.141592653589793,-1.5707963267948966,0.0,-3.141592653589793,-1.5707963267948966,0.0]}"));
        }

        [Test]
        public void AltitudeModeAbsoluteChangesHeight()
        {
            XElement element = new XElement("GroundOverlay",
                                            new XElement("altitudeMode", "absolute"),
                                            new XElement("altitude", "1000"),
                                            new XElement("LatLonBox",
                                                         new XElement("north", "90"),
                                                         new XElement("south", "-90"),
                                                         new XElement("east", "180"),
                                                         new XElement("west", "-180")));

            var groundOverlay = new GroundOverlay(element, m_document);
            groundOverlay.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicRadians\":[-3.141592653589793,1.5707963267948966,1e3,3.141592653589793,1.5707963267948966,1e3,3.141592653589793,-1.5707963267948966,1e3,-3.141592653589793,-1.5707963267948966,1e3]}"));
        }

        [Test]
        public void VisibilityElementProducesShowProperty()
        {
            XElement element = new XElement("GroundOverlay",
                                            new XElement("visibility", 1));
            var groundOverlay = new GroundOverlay(element, m_document);
            groundOverlay.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"polygon\":{\"show\":true"));
        }

        [Test]
        public void VisibilityElementProducesShowFalseProperty()
        {
            XElement element = new XElement("GroundOverlay",
                                            new XElement("visibility", 0));
            var groundOverlay = new GroundOverlay(element, m_document);
            groundOverlay.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"polygon\":{\"show\":false"));
        }

        [Test]
        public void ColorElementProducesColorMaterial()
        {
            XElement element = new XElement("GroundOverlay",
                                            new XElement("color", "96ffffff"));
            var groundOverlay = new GroundOverlay(element, m_document);
            groundOverlay.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"polygon\":{\"material\":{\"solidColor\":{\"color\":{\"rgba\":[255,255,255,150]}}}}"));
        }
    }
}