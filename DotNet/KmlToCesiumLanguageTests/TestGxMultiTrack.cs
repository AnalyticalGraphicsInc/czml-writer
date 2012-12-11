using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using System.IO;
using KmlToCesiumLanguage;
using System.Xml.Linq;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    class TestGxMultiTrack
    {
        private StringWriter m_stringWriter;
        private CzmlDocument m_document;
        private XNamespace m_gxNamespace = "http://www.google.com/kml/ext/2.2";

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_document = new CzmlDocument(m_stringWriter);
            m_document.NamespaceDeclarations["gx"] = m_gxNamespace;
        }

        [Test]
        public void GxMultiTrackProducesInstantaneousAvailability()
        {
            XElement element = new XElement("Placemark", new XAttribute(XNamespace.Xmlns + "gx", "http://www.google.com/kml/ext/2.2"),
                                new XElement("name", "STS-122"),
                                new XElement("description",
                                             new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                                new XElement(m_gxNamespace + "MultiTrack",
                                    new XElement(m_gxNamespace + "interpolate", "1"),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T16:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"))));



            var point = new GxMultiTrack(element.Element(m_gxNamespace + "MultiTrack"), m_document, element);
            point.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"availability\":\"20071206T1631Z/20071206T1631Z\""));
        }

        [Test]
        public void GxTrackProducesAvailability()
        {
            XElement element = new XElement("Placemark", new XAttribute(XNamespace.Xmlns + "gx", "http://www.google.com/kml/ext/2.2"),
                                new XElement("name", "STS-122"),
                                new XElement("description",
                                             new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                                new XElement(m_gxNamespace + "MultiTrack",
                                    new XElement(m_gxNamespace + "interpolate", "1"),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T16:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"),
                                             new XElement("when", "2007-12-06T17:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 2"))));

            var point = new GxMultiTrack(element.Element(m_gxNamespace + "MultiTrack"), m_document, element);
            point.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"availability\":\"20071206T1631Z/20071206T1731Z\""));
        }

        [Test]
        public void MultiTrackWithInterpolateTrueGeneratesOneTrack()
        {
            XElement element = new XElement("Placemark", new XAttribute(XNamespace.Xmlns + "gx", "http://www.google.com/kml/ext/2.2"),
                                new XElement("name", "STS-122"),
                                new XElement("description",
                                             new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                                new XElement(m_gxNamespace + "MultiTrack",
                                    new XElement(m_gxNamespace + "interpolate", "1"),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T16:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"),
                                             new XElement("when", "2007-12-06T17:31"),
                                             new XElement(m_gxNamespace + "coord", "0 2 6"),
                                             new XElement("when", "2007-12-06T18:31"),
                                             new XElement(m_gxNamespace + "coord", "0 3 7"),
                                             new XElement("altitudeMode", "absolute")),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T19:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"),
                                             new XElement("when", "2007-12-06T20:31"),
                                             new XElement(m_gxNamespace + "coord", "0 2 6"),
                                             new XElement("when", "2007-12-06T21:31"),
                                             new XElement(m_gxNamespace + "coord", "0 3 7"),
                                             new XElement("altitudeMode", "absolute"))));

            Placemark p = new Placemark(element, m_document);
            p.WritePacket();

            string result = m_stringWriter.ToString();
            var count = result.Select((c, i) =>
            {
                if (i < result.Count() - 2)
                    return result.Substring(i, 2);
                return "";
            }).Count(sub => sub.Equals("id"));
            Assert.AreEqual(1, count);
        }

        [Test]
        public void MultiTrackAltitudeModeAbsolutePreservesHeight()
        {
            XElement element = new XElement("Placemark", new XAttribute(XNamespace.Xmlns + "gx", "http://www.google.com/kml/ext/2.2"),
                                new XElement("name", "STS-122"),
                                new XElement("description",
                                             new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                                new XElement(m_gxNamespace + "MultiTrack",
                                    new XElement(m_gxNamespace + "interpolate", "1"),
                                    new XElement("altitudeMode", "absolute"),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T16:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"),
                                             new XElement("when", "2007-12-06T17:31"),
                                             new XElement(m_gxNamespace + "coord", "0 2 6"),
                                             new XElement("when", "2007-12-06T18:31"),
                                             new XElement(m_gxNamespace + "coord", "0 3 7"),
                                             new XElement("altitudeMode", "absolute")),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T19:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"),
                                             new XElement("when", "2007-12-06T20:31"),
                                             new XElement(m_gxNamespace + "coord", "0 2 6"),
                                             new XElement("when", "2007-12-06T21:31"),
                                             new XElement(m_gxNamespace + "coord", "0 3 7"),
                                             new XElement("altitudeMode", "absolute"))));

            Placemark p = new Placemark(element, m_document);
            p.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.IsTrue(result.Contains("\"position\":{\"epoch\":\"20071206T1631Z\",\"cartographicRadians\":[0.0,0.0,0.017453292519943295,5.0,3.6e3,0.0,0.03490658503988659,6.0,7.2e3,0.0,0.05235987755982989,7.0]},\"position\":{\"epoch\":\"20071206T1931Z\",\"cartographicRadians\":[0.0,0.0,0.017453292519943295,5.0,3.6e3,0.0,0.03490658503988659,6.0,7.2e3,0.0,0.05235987755982989,7.0]}"));
        }

        [Test]
        public void MultiTrackAltitudeModeClampToGroundSetsHeightToZero()
        {
            XElement element = new XElement("Placemark", new XAttribute(XNamespace.Xmlns + "gx", "http://www.google.com/kml/ext/2.2"),
                                new XElement("name", "STS-122"),
                                new XElement("description",
                                             new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                                new XElement(m_gxNamespace + "MultiTrack",
                                    new XElement(m_gxNamespace + "interpolate", "1"),
                                    new XElement("altitudeMode", "clampToGround"),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T16:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"),
                                             new XElement("when", "2007-12-06T17:31"),
                                             new XElement(m_gxNamespace + "coord", "0 2 6"),
                                             new XElement("when", "2007-12-06T18:31"),
                                             new XElement(m_gxNamespace + "coord", "0 3 7"),
                                             new XElement("altitudeMode", "absolute")),
                                    new XElement(m_gxNamespace + "Track",
                                             new XElement("when", "2007-12-06T19:31"),
                                             new XElement(m_gxNamespace + "coord", "0 1 5"),
                                             new XElement("when", "2007-12-06T20:31"),
                                             new XElement(m_gxNamespace + "coord", "0 2 6"),
                                             new XElement("when", "2007-12-06T21:31"),
                                             new XElement(m_gxNamespace + "coord", "0 3 7"),
                                             new XElement("altitudeMode", "absolute"))));

            Placemark p = new Placemark(element, m_document);
            p.WritePacket();

            string result = m_stringWriter.ToString();
            Assert.IsTrue(result.Contains("\"position\":{\"epoch\":\"20071206T1631Z\",\"cartographicRadians\":[0.0,0.0,0.017453292519943295,0.0,3.6e3,0.0,0.03490658503988659,0.0,7.2e3,0.0,0.05235987755982989,0.0]},\"position\":{\"epoch\":\"20071206T1931Z\",\"cartographicRadians\":[0.0,0.0,0.017453292519943295,0.0,3.6e3,0.0,0.03490658503988659,0.0,7.2e3,0.0,0.05235987755982989,0.0]}"));
        }


    }
}
