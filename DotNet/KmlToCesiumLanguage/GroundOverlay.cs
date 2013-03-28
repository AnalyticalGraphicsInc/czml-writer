using System;
using System.Drawing;
using System.Xml.Linq;
using CesiumLanguageWriter;

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
        public override void WritePacket(CesiumOutputStream stream)
        {
            using (var packetWriter = m_document.CesiumStreamWriter.OpenPacket(stream))
            {
                packetWriter.WriteId(Utility.GetId(m_element));
                Utility.WriteAvailability(m_element, packetWriter, m_document.Namespace);
                XElement latLon = m_element.Element(m_document.Namespace + "LatLonBox");
                if (latLon != null)
                {
                    var north = double.Parse(latLon.Element(m_document.Namespace + "north").Value) * Constants.RadiansPerDegree;
                    var south = double.Parse(latLon.Element(m_document.Namespace + "south").Value) * Constants.RadiansPerDegree;
                    var east = double.Parse(latLon.Element(m_document.Namespace + "east").Value) * Constants.RadiansPerDegree;
                    var west = double.Parse(latLon.Element(m_document.Namespace + "west").Value) * Constants.RadiansPerDegree;
                    double rotation = 0.00;
                    XElement rotationElement = latLon.Element(m_document.Namespace + "rotation");
                    if (rotationElement != null)
                    {
                        rotation = double.Parse(rotationElement.Value) * Constants.RadiansPerDegree;
                    }
                    double altitude = 0.0;
                    XElement altitudeMode = m_element.Element(m_document.Namespace + "altitudeMode");
                    if (altitudeMode != null && altitudeMode.Value == "absolute")
                    {
                        XElement altitudeElement = m_element.Element(m_document.Namespace + "altitude");
                        if (altitudeElement != null)
                        {
                            altitude = double.Parse(altitudeElement.Value);
                        }
                    }
                    var cartographicPositions = new[]
                                                    {
                                                        new Cartographic(west, north, altitude),
                                                        new Cartographic(east, north, altitude),
                                                        new Cartographic(east, south, altitude),
                                                        new Cartographic(west, south, altitude)
                                                    };
                    using (var positions = packetWriter.OpenVertexPositionsProperty())
                    {
                        positions.WriteCartographicRadians(cartographicPositions);
                    }
                }
                using (var polygon = packetWriter.OpenPolygonProperty())
                {
                    XElement visibilityElement = m_element.Element(m_document.Namespace + "visibility");
                    if (visibilityElement != null)
                    {
                        using (var visibility = polygon.OpenShowProperty())
                        {
                            visibility.WriteBoolean(Convert.ToBoolean(int.Parse(visibilityElement.Value)));
                        }
                    }
                    XElement iconElement = m_element.Element(m_document.Namespace + "Icon");
                    if (iconElement != null)
                    {
                        using (var material = polygon.OpenMaterialProperty())
                        {
                            using (var image = material.OpenImageProperty())
                            {
                                string href = iconElement.Element(m_document.Namespace + "href").Value;
                                if (m_document.ParentUri != null)
                                {
                                    href = new Uri(m_document.ParentUri, href).AbsoluteUri;
                                }
                                image.WriteImageProperty(href, m_document.ImageResolver);
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

        private readonly XElement m_element;
        private readonly CzmlDocument m_document;
    }
}