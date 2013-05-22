using System.IO;
using System.Linq;
using System.Xml.Linq;
using KmlToCesiumLanguage;
using NUnit.Framework;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestGxMultiTrack
    {
        private StringWriter m_stringWriter;
        private CzmlDocument m_document;
        private readonly XNamespace m_gxNamespace = "http://www.google.com/kml/ext/2.2";

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
            StringAssert.Contains("\"availability\":\"20071206T1631Z/20071206T1631Z\"", result);
        }

        [Test]
        public void GxMultiTrackProducesAvailability()
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
            StringAssert.Contains("\"availability\":\"20071206T1631Z/20071206T1731Z\"", result);
        }

        [Test]
        public void GxMultiTrackWithInterpolateTrueGeneratesOneTrack()
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
        public void GxMultiTrackAltitudeModeAbsolutePreservesHeight()
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
            StringAssert.Contains("\"position\":{\"epoch\":\"20071206T1631Z\",\"cartographicRadians\":[0,0,0.017453292519943295,5,3.6e3,0,0.03490658503988659,6,7.2e3,0,0.05235987755982989,7]},\"position\":{\"epoch\":\"20071206T1931Z\",\"cartographicRadians\":[0,0,0.017453292519943295,5,3.6e3,0,0.03490658503988659,6,7.2e3,0,0.05235987755982989,7]}", result);
        }

        [Test]
        public void GxMultiTrackAltitudeModeAbsolutePreservesHeightWhenGxTrackUsesDefaultClampToGround()
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
                                                                      new XElement(m_gxNamespace + "coord", "0 3 7")),
                                                         new XElement(m_gxNamespace + "Track",
                                                                      new XElement("when", "2007-12-06T19:31"),
                                                                      new XElement(m_gxNamespace + "coord", "0 1 5"),
                                                                      new XElement("when", "2007-12-06T20:31"),
                                                                      new XElement(m_gxNamespace + "coord", "0 2 6"),
                                                                      new XElement("when", "2007-12-06T21:31"),
                                                                      new XElement(m_gxNamespace + "coord", "0 3 7"))));

            Placemark p = new Placemark(element, m_document);
            p.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"position\":{\"epoch\":\"20071206T1631Z\",\"cartographicRadians\":[0,0,0.017453292519943295,5,3.6e3,0,0.03490658503988659,6,7.2e3,0,0.05235987755982989,7]},\"position\":{\"epoch\":\"20071206T1931Z\",\"cartographicRadians\":[0,0,0.017453292519943295,5,3.6e3,0,0.03490658503988659,6,7.2e3,0,0.05235987755982989,7]}", result);
        }

        [Test]
        public void GxMultiTrackAltitudeModeAbsolutePreservesHeightWhenGxTrackSpecifiesClampToGround()
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
                                                                      new XElement("altitudeMode", "clampToGround")),
                                                         new XElement(m_gxNamespace + "Track",
                                                                      new XElement("when", "2007-12-06T19:31"),
                                                                      new XElement(m_gxNamespace + "coord", "0 1 5"),
                                                                      new XElement("when", "2007-12-06T20:31"),
                                                                      new XElement(m_gxNamespace + "coord", "0 2 6"),
                                                                      new XElement("when", "2007-12-06T21:31"),
                                                                      new XElement(m_gxNamespace + "coord", "0 3 7"),
                                                                      new XElement("altitudeMode", "clampToGround"))));

            Placemark p = new Placemark(element, m_document);
            p.WritePacket();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"position\":{\"epoch\":\"20071206T1631Z\",\"cartographicRadians\":[0,0,0.017453292519943295,5,3.6e3,0,0.03490658503988659,6,7.2e3,0,0.05235987755982989,7]},\"position\":{\"epoch\":\"20071206T1931Z\",\"cartographicRadians\":[0,0,0.017453292519943295,5,3.6e3,0,0.03490658503988659,6,7.2e3,0,0.05235987755982989,7]}", result);
        }

        [Test]
        public void GxMultiTrackAltitudeModeClampToGroundSetsHeightToZero()
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
            StringAssert.Contains("\"position\":{\"epoch\":\"20071206T1631Z\",\"cartographicRadians\":[0,0,0.017453292519943295,0,3.6e3,0,0.03490658503988659,0,7.2e3,0,0.05235987755982989,0]},\"position\":{\"epoch\":\"20071206T1931Z\",\"cartographicRadians\":[0,0,0.017453292519943295,0,3.6e3,0,0.03490658503988659,0,7.2e3,0,0.05235987755982989,0]}", result);
        }
    }
}