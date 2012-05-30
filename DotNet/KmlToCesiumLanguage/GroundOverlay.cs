using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Drawing;
using System.IO;
using System.Net;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// 
    /// </summary>
    public class GroundOverlay : Feature
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="GroundOverlay"/> class.
        /// </summary>
        /// <param name="element">The element.</param>
        /// <param name="document">The document.</param>
        public GroundOverlay(XElement element, CzmlDocument document)
        {
            m_element = element;
            m_document = document;
        }

        /// <inheritdoc />
        public override void WritePacket()
        {
            using (var packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                packetWriter.WriteId(Guid.NewGuid().ToString());
                Utility.WriteAvailability(m_element, packetWriter, m_document.Namespace);
                XElement latLon = m_element.Element(m_document.Namespace + "LatLonBox");
                if (latLon != null)
                {
                    var north = double.Parse(latLon.Element(m_document.Namespace + "north").Value) * Constants.RadiansPerDegree;
                    var south = double.Parse(latLon.Element(m_document.Namespace + "south").Value) * Constants.RadiansPerDegree;
                    var east = double.Parse(latLon.Element(m_document.Namespace + "east").Value) * Constants.RadiansPerDegree;
                    var west = double.Parse(latLon.Element(m_document.Namespace + "west").Value) * Constants.RadiansPerDegree;
                    var rotation = 0.00;
                    XElement rotationElement = latLon.Element(m_document.Namespace + "rotation");
                    if (rotationElement != null)
                    {
                        rotation = double.Parse(rotationElement.Value) * Constants.RadiansPerDegree;
                    }
                    var altitude = 0.0;
                    XElement altitudeMode = m_element.Element(m_document.Namespace + "altitudeMode");
                    if (altitudeMode != null && altitudeMode.Value == "absolute")
                    {
                        XElement altitudeElement = m_element.Element(m_document.Namespace + "altitude");
                        if (altitudeElement != null)
                        {
                            altitude = double.Parse(altitudeElement.Value);
                        }
                    }
                    var cartographicPositions = new[] { new Cartographic(west, north, altitude), 
                                                new Cartographic(east, north, altitude), 
                                                new Cartographic(east, south, altitude),
                                                new Cartographic(west, south, altitude)};
                    using (var positions = packetWriter.OpenVertexPositionsProperty())
                    {
                        positions.WriteValue(cartographicPositions);
                    }
                }
                using (var polygon = packetWriter.OpenPolygonProperty())
                {
                    XElement visibilityElement = m_element.Element(m_document.Namespace + "visibility");
                    if (visibilityElement != null)
                    {
                        using (var visibility = polygon.OpenShowProperty())
                        {
                            visibility.WriteValue(Convert.ToBoolean(int.Parse(visibilityElement.Value)));
                        }
                    }
                    XElement iconElement = m_element.Element(m_document.Namespace + "Icon");
                    if (iconElement != null)
                    {
                        string href = iconElement.Element(m_document.Namespace + "href").Value;
                        string imageRef;
                        if (m_document.ImageMap.TryGetValue(href, out imageRef))
                        {
                            href = imageRef as string;
                        }
                        else
                        {
                            string dataUrl = Utility.DownloadImage(href);
                            m_document.ImageMap.Add(href, dataUrl);
                            href = dataUrl;
                        }
                        using (var material = polygon.OpenMaterialProperty())
                        {
                            using (var image = material.OpenImageProperty())
                            {
                                image.WriteImageProperty(href);
                            }
                        }
                    }
                    else
                    {
                        XElement colorElement = m_element.Element(m_document.Namespace + "color");
                        if (colorElement != null)
                        {
                            Color color = Utility.HexStringToColor(colorElement.Value);
                            using (var material = polygon.OpenMaterialProperty())
                            {
                                using (var solidColor = material.OpenSolidColorProperty())
                                {
                                    solidColor.WriteColorProperty(color);
                                }
                            }
                        }
                    }
                            
                    //TODO: find out what style information applies to GroundOverlays.
                    //description
                    //drawOrder... cesium needs to support this. where is it specified in czml?
                }
            }
        }

        private XElement m_element;
        CzmlDocument m_document;
    }
}
