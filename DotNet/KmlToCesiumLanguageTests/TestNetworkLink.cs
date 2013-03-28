using System.IO;
using System.Xml.Linq;
using CesiumLanguageWriter;
using KmlToCesiumLanguage;
using NUnit.Framework;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestNetworkLink
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
        public void NetworkLinkContainsBasicExternalInfo()
        {
            var kml = @"
                <NetworkLink>
                  <name>Random Placemark</name>
                  <visibility>0</visibility>
                  <open>0</open>
                  <description>A simple server-side script that generates a new random
                    placemark on each call</description>
                  <refreshVisibility>0</refreshVisibility>
                  <flyToView>0</flyToView>
                  <Link>
                    <href>http://yourserver.com/cgi-bin/randomPlacemark.py</href>
                  </Link>
                </NetworkLink>";
            var doc = XDocument.Parse(kml);
            var networkLink = new NetworkLink(doc.Root, m_document);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                networkLink.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"external\":{\"url\":\"http://localhost/conversions/kml?kmlUrl=http%3A%2F%2Fyourserver.com%2Fcgi-bin%2FrandomPlacemark.py\",\"scope\":\"SHARED\"}}"));
        }

        [Test]
        public void NetworkLinkWithRefreshIntervalGeneratesCZMLRefreshInterval()
        {
            var kml = @"
                <NetworkLink>
                  <name>Random Placemark</name>
                  <visibility>0</visibility>
                  <open>0</open>
                  <description>A simple server-side script that generates a new random
                    placemark on each call</description>
                  <refreshVisibility>0</refreshVisibility>
                  <flyToView>0</flyToView>
                  <Link>
                    <href>http://yourserver.com/cgi-bin/randomPlacemark.py</href>
                    <refreshInterval>30</refreshInterval>
                  </Link>
                </NetworkLink>";
            var doc = XDocument.Parse(kml);
            var networkLink = new NetworkLink(doc.Root, m_document);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                networkLink.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"refreshInterval\":30.0"));
        }

        [Test]
        public void NetworkLinkWithControlChangesRefreshInterval()
        {
            var kml = @"<kml>
                <NetworkLink>
                  <name>Random Placemark</name>
                  <visibility>0</visibility>
                  <open>0</open>
                  <description>A simple server-side script that generates a new random
                    placemark on each call</description>
                  <refreshVisibility>0</refreshVisibility>
                  <flyToView>0</flyToView>
                  <Link>
                    <href>http://yourserver.com/cgi-bin/randomPlacemark.py</href>
                    <refreshInterval>30</refreshInterval>
                  </Link>
                </NetworkLink>
                <NetworkLinkControl>
                  <minRefreshPeriod>60</minRefreshPeriod>
                </NetworkLinkControl>
                </kml>";
            var doc = XDocument.Parse(kml);
            var networkLink = new NetworkLink(doc.Root.Element("NetworkLink"), m_document);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                networkLink.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"refreshInterval\":60.0"));
        }

        [Test]
        public void NetworkLinkWithControlDoesNotChangeRefreshInterval()
        {
            var kml = @"<kml>
                <NetworkLink>
                  <name>Random Placemark</name>
                  <visibility>0</visibility>
                  <open>0</open>
                  <description>A simple server-side script that generates a new random
                    placemark on each call</description>
                  <refreshVisibility>0</refreshVisibility>
                  <flyToView>0</flyToView>
                  <Link>
                    <href>http://yourserver.com/cgi-bin/randomPlacemark.py</href>
                    <refreshInterval>30</refreshInterval>
                  </Link>
                </NetworkLink>
                <NetworkLinkControl>
                  <minRefreshPeriod>20</minRefreshPeriod>
                </NetworkLinkControl>
                </kml>";
            var doc = XDocument.Parse(kml);
            var networkLink = new NetworkLink(doc.Root.Element("NetworkLink"), m_document);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                networkLink.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"refreshInterval\":30.0"));
        }

        [Test]
        public void NetworkLinkWithControlAddsCZMLMaxSessionLength()
        {
            var kml = @"<kml>
                <NetworkLink>
                  <name>Random Placemark</name>
                  <visibility>0</visibility>
                  <open>0</open>
                  <description>A simple server-side script that generates a new random
                    placemark on each call</description>
                  <refreshVisibility>0</refreshVisibility>
                  <flyToView>0</flyToView>
                  <Link>
                    <href>http://yourserver.com/cgi-bin/randomPlacemark.py</href>
                    <refreshInterval>30</refreshInterval>
                  </Link>
                </NetworkLink>
                <NetworkLinkControl>
                  <minRefreshPeriod>20</minRefreshPeriod>
                  <maxSessionLength>200</maxSessionLength>
                </NetworkLinkControl>
                </kml>";
            var doc = XDocument.Parse(kml);
            var networkLink = new NetworkLink(doc.Root.Element("NetworkLink"), m_document);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                networkLink.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"maxSessionLength\":2e2"));
        }

        [Test]
        public void NetworkLinkWithDeprecatedUrlWorks()
        {
            var kml = @"
                <NetworkLink>
                  <name>Random Placemark</name>
                  <visibility>0</visibility>
                  <open>0</open>
                  <description>A simple server-side script that generates a new random
                    placemark on each call</description>
                  <refreshVisibility>0</refreshVisibility>
                  <flyToView>0</flyToView>
                  <Url>
                    <href>http://yourserver.com/cgi-bin/randomPlacemark.py</href>
                  </Url>
                </NetworkLink>";
            var doc = XDocument.Parse(kml);
            var networkLink = new NetworkLink(doc.Root, m_document);
            using (var outputstream = new CesiumOutputStream(m_stringWriter))
                networkLink.WritePacket(outputstream);

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"external\":{\"url\":\"http://localhost/conversions/kml?kmlUrl=http%3A%2F%2Fyourserver.com%2Fcgi-bin%2FrandomPlacemark.py\",\"scope\":\"SHARED\"}}"));
        }
    }
}
