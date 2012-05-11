using NUnit.Framework;
using KmlToCesiumLanguage;
using System.Xml.Linq;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    class TestLineString
    {
        /// <summary>
        /// This will be broken down. Just a starting point.
        /// </summary>
        [Test]
        public void BasicLineString()
        {
            CzmlDocument document = new CzmlDocument();
            document.Namespace = "";
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
            Assert.That(result.Contains("\"availability\":\"2007-12-06T16:31:00Z/2007-12-06T16:40:18.0400000000009Z\""));
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicRadians\":[-1.199672027924945,0.6518798123947666,105045.668999999,-1.1997160587632991,0.6518491712145866,105041.867978398]}"));
        }
    }
}
