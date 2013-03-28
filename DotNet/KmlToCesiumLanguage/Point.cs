using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Drawing;
using System.Text.RegularExpressions;
using System.Xml.Linq;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// A geographic location defined by longitude, latitude, and (optional) altitude. 
    /// When a Point is contained by a Placemark, the point itself determines the position of the Placemark's name and icon. 
    /// When a Point is extruded, it is connected to the ground with a line. This "tether" uses the current LineStyle.
    /// </summary>
    public class Point : Geometry
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Point"/> class.
        /// </summary>
        /// <param name="element">The element.</param>
        /// <param name="document">The document.</param>
        /// <param name="placemark">The placemark.</param>
        public Point(XElement element, CzmlDocument document, XElement placemark)
            : base(document, placemark)
        {
            m_element = element;
            XElement extrudeElement = m_element.Element(Document.Namespace + "extrude");
            if (extrudeElement != null && extrudeElement.Value == "1")
            {
                m_extrude = true;
            }

            string coordinates = m_element.Element(Document.Namespace + "coordinates").Value.Trim();
            string[] coord = Regex.Split(coordinates, @"[,\s]+", RegexOptions.Multiline);
            XElement altitudeMode = m_element.Element(Document.Namespace + "altitudeMode");
            if (altitudeMode != null && altitudeMode.Value == "clampToGround")
            {
                m_position = new Cartographic(double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, 0);
                Debug.Assert(coord.Length == 2 || coord.Length == 3);
            }
            else
            {
                if (coord.Length == 1)
                {
                    m_position = new Cartographic(double.Parse(coord[0]) * Constants.RadiansPerDegree, 0.0, 0.0);
                }
                else if (coord.Length == 2)
                {
                    m_position = new Cartographic(double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, 0.0);
                }
                else
                {
                    m_position = new Cartographic(double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, double.Parse(coord[2]));
                }
            }
        }

        /// <inheritdoc />
        protected override void AddIconStyle(XElement iconElement)
        {
            using (var billboard = PacketWriter.OpenBillboardProperty())
            {
                XElement scaleElement = iconElement.Element(Document.Namespace + "scale");
                if (scaleElement != null)
                    billboard.WriteScaleProperty(double.Parse(scaleElement.Value));

                string href = iconElement.Element(Document.Namespace + "Icon").Element(Document.Namespace + "href").Value;
                if(!Document.ImageResolver.ContainsUrl(href) && Document.ParentUri != null)
                {
                    href = new Uri(Document.ParentUri, href).AbsoluteUri;
                }
                billboard.WriteImageProperty(href, Document.ImageResolver);
            }
        }

        /// <inheritdoc />
        protected override void Write()
        {
            using (PositionCesiumWriter position = PacketWriter.OpenPositionProperty())
            {
                position.WriteCartographicRadians(m_position);
            }
            if (m_extrude)
            {
                List<Cartographic> positions = new List<Cartographic>();
                positions.Add(m_position);
                positions.Add(new Cartographic(m_position.Longitude, m_position.Latitude, 0.0));
                using (PositionListCesiumWriter polyline = PacketWriter.OpenVertexPositionsProperty())
                {
                    polyline.WriteCartographicRadians(positions);
                }
            }
        }

        /// <inheritdoc/>
        protected override void AddLineStyle(XElement lineElement)
        {
            if (m_extrude)
            {
                using (PolylineCesiumWriter polyline = PacketWriter.OpenPolylineProperty())
                {
                    XElement colorElement = lineElement.Element(Document.Namespace + "color");
                    if (colorElement != null)
                    {
                        Color color = Utility.HexStringToColor(colorElement.Value);
                        polyline.WriteColorProperty(color);
                    }
                    XElement widthElement = lineElement.Element(Document.Namespace + "width");
                    if (widthElement != null)
                    {
                        polyline.WriteWidthProperty(double.Parse(widthElement.Value));
                    }
                }
            }
        }

        private Cartographic m_position;
        private readonly XElement m_element;
        private readonly bool m_extrude;
    }
}