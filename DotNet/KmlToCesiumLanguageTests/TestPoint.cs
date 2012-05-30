using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using KmlToCesiumLanguage;
using System.Xml.Linq;
using System.IO;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestPoint
    {
        CzmlDocument m_document;
        public TestPoint()
        {
            m_document = new CzmlDocument();
        }

        [Test]
        public void PointTimeSpanProducesAvailability()
        {
            XElement element = new XElement("Placemark",
                new XElement("name", "STS-122"),
                new XElement("TimeSpan",
                    new XElement("begin", "2007-12-06T16:31")),
                new XElement("description", new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                new XElement("Point",
                    new XElement("altitudeMode", "absolute"),
                    new XElement("coordinates", "-80.604015,28.608305,48.5300000004579")));

            var point = new Point(element.Element("Point"), m_document, element);
            point.WritePacket();
            string result = m_document.StringWriter.ToString();
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
            point.WritePacket();
            string result = m_document.StringWriter.ToString();
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
            point.WritePacket();
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"billboard\":{"));
            Assert.That(result.Contains("\"scale\":2.0"));
            Assert.That(result.Contains("\"image\":\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAACxIAAAsSAdLdfvwAAAAGYktHRAAAAAAAAPlDu38AAAAJb0ZGcwAAAKAAAADgAJ1IVMwAAADPSURBVFhH7ZYhDsJQEERrsKhaFIRLVIIlwWKRtShOgeUWHKFHK/MSMAQWkgXWzCZP7czP/mnZ0jQuJ+AEnMBnCUwka8VMLAPoo0P/tZrqpIXoxFpsAuijQ48vXdyEw1ZiJ3pxCKCPDj2+dBLEyY049ChO4hxAHx16fPhTxTMlVm7G4RcxBNBHhx4f/lTxwvHMiZ2bD2NQt8HQoceHP1VPB5hv9+MjzOUBnMDfEnj1Q/jFAOV7oHwTln8L2GKlX8P7Gi39P5Da5TY7ASfwLoErb9PjPacZAtEAAAAASUVORK5CYII=\"}"));
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
            point.WritePacket();
            string result = m_document.StringWriter.ToString();
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
            point.WritePacket();
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"polyline\":{\"color\":{\"rgba\":[255,0,255,161]}}"));
        }



        [Test]
        [Explicit]
        public void Sandbox()
        {
            CzmlDocument document = new CzmlDocument();
            document.CesiumOutputStream.PrettyFormatting = true;
            KmlConverter.KmlToCesiumLanguage(File.ReadAllBytes(@"\KmlDocs\STS-122-STS-122Ascent.kml"), document);
            string czml = document.StringWriter.ToString();
            Console.WriteLine(czml);
        }

        [Test]
        [Explicit]
        public void KmzSandbox()
        {
            CzmlDocument document = new CzmlDocument();
            document.CesiumOutputStream.PrettyFormatting = true;
            KmlConverter.KmzToCesiumLanguage(File.ReadAllBytes(@"KmlDocs\I&W KML.kmz"), document);
            string czml = document.StringWriter.ToString();
            Console.WriteLine(czml);
        }
    }
}
