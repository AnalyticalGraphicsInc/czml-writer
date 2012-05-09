using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using KmlToCesiumLanguage;
using System.Xml.Linq;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestPoint
    {
        [Test]
        public void BasicPoint()
        {
            CzmlDocument document = new CzmlDocument();
            document.Namespace = "";

            XElement element = new XElement("Placemark",
                new XElement("name", "STS-122"),
                new XElement("TimeSpan",
                    new XElement("begin", "2007-12-06T16:31")),
                new XElement("description", new XCData("<html><table><tr><td><b>Start Time (T-0:44): </b></td><td>2007 Dec 6 16:31:00.000 EST</td></tr></table></html>")),
                new XElement("Point",
                    new XElement("altitudeMode", "absolute"),
                    new XElement("coordinates", "-80.604015,28.608305,48.5300000004579")));

            var point = new Point(element.Element("Point"), document, element);
            point.WritePacket();
            string result = document.StringWriter.ToString();
            Assert.That(result.Contains("\"availability\":\"2007-12-06T16:31:00Z/-4713-11--2147483625T11:59:25Z\""));
            Assert.That(result.Contains("\"position\":{\"cartographicRadians\":[-1.4068054520768973,0.4993091156647564,0.8470082860008401]}"));
        }
    }
}
