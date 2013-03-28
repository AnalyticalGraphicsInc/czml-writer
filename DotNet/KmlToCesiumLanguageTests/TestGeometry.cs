using System.IO;
using System.Xml.Linq;
using CesiumLanguageWriter;
using KmlToCesiumLanguage;
using NUnit.Framework;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestGeometry
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
        public void GeometryProducesId()
        {
            var placemark = new XElement("Placemark",
                                         new XAttribute("id", "STS-122"),
                                         new XElement("LineString",
                                                      new XElement("altitudeMode", "absolute"),
                                                      new XElement("coordinates", "-68,37,105045 -68,37,105041")));

            var geometry = new Placemark(placemark, m_document);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                geometry.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"id\":\"STS-122\""));
        }
    }
}