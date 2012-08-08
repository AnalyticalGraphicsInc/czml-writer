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
                    var hrefElement = linkElement.Element(m_document.Namespace + "href");
                    if (hrefElement != null)
                    {
                        using (var layerWriter = packetWriter.OpenLayerProperty())
                        {
                            Uri href = new Uri(hrefElement.Value, UriKind.RelativeOrAbsolute);
                            if (m_document.ParentUri != null)
                            {
                                href = new Uri(m_document.ParentUri, href);
                            }
                            layerWriter.WriteLayerUrlProperty(m_uri + Uri.EscapeDataString(href.AbsoluteUri));
                        }
                    }
                }
                else
                {
                    XElement urlElement = m_element.Element(m_document.Namespace + "Url");
                    if (urlElement != null)
                    {
                        var hrefElement = urlElement.Element(m_document.Namespace + "href");
                        if (hrefElement != null)
                        {
                            using (var layerWriter = packetWriter.OpenLayerProperty())
                            {
                                Uri href = new Uri(hrefElement.Value, UriKind.RelativeOrAbsolute);
                                if (m_document.ParentUri != null)
                                {
                                    href = new Uri(m_document.ParentUri, href);
                                }
                                layerWriter.WriteLayerUrlProperty(m_uri + Uri.EscapeDataString(href.AbsoluteUri));
                            }
                        }
                    }
                }
            }
        }

        private CzmlDocument m_document;
        private XElement m_element;
        private static string m_uri = "http://localhost/conversions/kml?kmlUrl=";
    }
}
