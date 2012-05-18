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
            Assert.That(result.Contains("\"availability\":\"2007-12-06T16:31:00Z/-4713-11--2147483625T11:59:25Z\""));
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
            Assert.That(result.Contains("\"image\":\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAABmJLR0QAAAAAAAD5Q7t/AAAACW9GRnMAAACgAAAA4ACdSFTMAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAsUlEQVRYw+2WIQ6EMBREMdhVtVVLuAQSLMla7MpaFKfAcguOwNFgSMaR/JC0S1fMJM/N/51fQtuikCRJuqcSOOBBbeDpK1Mu/gIVaEAHeoOOvop1SSY/m7VgAAGMBoG+lnXRO+E40dl0AjNYDGb6Bta52ACe2xrYfAWbwUpfYJ2PDVDz246ccNsNMcRCf8/69AHen+8FBVCARwM8+RdkPweyn4TZ74Lst+FfvAckSfqpDm/T4z3U/oIsAAAAAElFTkSuQmCC\"}"));
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
            KmlConverter.KmlToCesiumLanguage(File.ReadAllBytes(@"KmlDocs\STS-122-STS-122Ascent.kml"), document);
            Console.WriteLine(document.StringWriter.ToString());
        }

        [Test]
        [Explicit]
        public void KmzSandbox()
        {
            CzmlDocument document = new CzmlDocument();
            document.CesiumOutputStream.PrettyFormatting = true;
            KmlConverter.KmzToCesiumLanguage(File.ReadAllBytes(@"KmlDocs\I&W KML.kmz"), document);
            Console.WriteLine(document.StringWriter.ToString());
        }
    }
}
