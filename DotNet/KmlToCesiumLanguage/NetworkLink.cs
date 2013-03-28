using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// 
    /// </summary>
    public class NetworkLink : Feature
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="NetworkLink"/> class.
        /// </summary>
        /// <param name="element">The element.</param>
        /// <param name="document">The document.</param>
        public NetworkLink(XElement element, CzmlDocument document)
        {
            m_element = element;
            m_document = document;
            var networkLinkControl = element.Document.Descendants().Where(o => o.Name == document.Namespace + "NetworkLinkControl").FirstOrDefault();
            if (networkLinkControl != null)
            {
                m_networkLinkControl = networkLinkControl;
            }
        }

        /// <summary>
        /// Writes the packet.
        /// </summary>
        public override void WritePacket(CesiumOutputStream stream)
        {
            using (PacketCesiumWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(stream))
            {
                packetWriter.WriteId(Guid.NewGuid().ToString());
                XElement linkElement = m_element.Element(m_document.Namespace + "Link");
                if (linkElement != null)
                {
                    WriteUri(linkElement, packetWriter);
                }
                else
                {
                    XElement urlElement = m_element.Element(m_document.Namespace + "Url");
                    if (urlElement != null)
                    {
                        WriteUri(urlElement, packetWriter);
                    }
                }
            }
        }

        private void WriteUri(XElement element, PacketCesiumWriter packetWriter)
        {
            var hrefElement = element.Element(m_document.Namespace + "href");
            if (hrefElement != null)
            {
                using (var externalWriter = packetWriter.OpenExternalProperty())
                {
                    Uri href = new Uri(hrefElement.Value, UriKind.RelativeOrAbsolute);
                    if (m_document.ParentUri != null)
                    {
                        href = new Uri(m_document.ParentUri, href);
                    }
                    externalWriter.WriteUrlProperty(m_uri + Uri.EscapeDataString(href.AbsoluteUri));
                    XElement refreshIntervalElement = element.Element(m_document.Namespace + "refreshInterval");
                    if (refreshIntervalElement != null)
                    {
                        double value;
                        var refreshIntervalParsed = double.TryParse(refreshIntervalElement.Value, out value);

                        if (m_networkLinkControl != null)
                        {
                            XElement minRefreshPeriod = m_networkLinkControl.Element(m_document.Namespace + "minRefreshPeriod");
                            if (minRefreshPeriod != null)
                            {
                                using (var pollUpdateWriter = externalWriter.OpenPollingUpdateProperty())
                                {
                                    double minRefresh;
                                    bool minRefreshParsed = double.TryParse(minRefreshPeriod.Value, out minRefresh);
                                    if (minRefreshParsed && refreshIntervalParsed && minRefresh > value)
                                    {
                                        pollUpdateWriter.WriteRefreshIntervalProperty(minRefresh);
                                    }
                                    else if (refreshIntervalParsed)
                                    {
                                        pollUpdateWriter.WriteRefreshIntervalProperty(value);
                                    }
                                }
                            }
                            XElement maxSessionLength = m_networkLinkControl.Element(m_document.Namespace + "maxSessionLength");
                            if (maxSessionLength != null)
                            {
                                double sessionLength;
                                if (double.TryParse(maxSessionLength.Value, out sessionLength))
                                {
                                    externalWriter.WriteMaxSessionLengthProperty(sessionLength);
                                }
                            }
                        }
                        else
                        {
                            if (refreshIntervalParsed)
                            {
                                using (var pollUpdateWriter = externalWriter.OpenPollingUpdateProperty())
                                    pollUpdateWriter.WriteRefreshIntervalProperty(value);
                            }
                        }
                    }
                    externalWriter.WriteScopeProperty(CesiumExternalDocumentScope.Shared);
                }
            }
        }

        private CzmlDocument m_document;
        private XElement m_element;
        private XElement m_networkLinkControl;
        private static string m_uri = "http://localhost/conversions/kml?kmlUrl=";
    }
}
