using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
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
            string[] coord = Regex.Split(coordinates, @"[,\s]+", RegexOptions.Multiline | RegexOptions.IgnorePatternWhitespace);
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
                    coord = coord.Concat(new List<string> { "0.0", "0.0" }).ToArray();
                }
                if (coord.Length == 2)
                {
                    coord = coord.Concat(new List<string> { "0.0" }).ToArray();
                }
                m_position = new Cartographic(double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, double.Parse(coord[2]));
            }
        }

        /// <inheritdoc />
        protected override void AddIconStyle(XElement iconElement)
        {
            using (var billboard = this.PacketWriter.OpenBillboardProperty())
            {
                string href = iconElement.Element(Document.Namespace + "Icon").Element(Document.Namespace + "href").Value;
                object imageRef;
                if (Document.ImageMap.TryGetValue(href, out imageRef))
                {
                    if (imageRef is Image)
                    {
                        Image image = imageRef as Image;
                        string extension = Path.GetExtension(href).Remove(0, 1);
                        href = "data:image/" + extension + ";base64," + ImageProcessing.ToBase64String(image);
                        double height = image.Height;
                        double width = image.Width;
                        if (width > DefaultTextureSize || height > DefaultTextureSize || (width < DefaultTextureSize && height < DefaultTextureSize))
                        {
                            var max = Math.Max(width, height);
                            var scale = DefaultTextureSize / max;
                            billboard.WriteScaleProperty(scale);
                        }
                    }
                    else
                    {
                        href = imageRef as string;
                        AddScaleProperty(iconElement, billboard);
                    }
                }
                else
                {
                    if (href.StartsWith("http:"))
                    {
                        string extension = Path.GetExtension(href).Remove(0, 1);
                        WebClient client = new WebClient();
                        byte[] data = client.DownloadData(href);
                        string hrefValue = "data:image/" + extension + ";base64," + Convert.ToBase64String(data);
                        AddScaleProperty(iconElement, billboard);
                        Document.ImageMap.Add(href, hrefValue);
                        href = hrefValue;
                    }
                }

                billboard.WriteImageProperty(href);
            }
        }

        /// <inheritdoc />
        protected override void Write()
        {
            using (PositionCesiumWriter position = this.PacketWriter.OpenPositionProperty())
            {
                position.WriteCartographicRadiansValue(m_position);
            }
            if (m_extrude)
            {
                List<Cartographic> positions = new List<Cartographic>();
                positions.Add(m_position);
                positions.Add(new Cartographic(m_position.Longitude, m_position.Latitude, 0.0));
                using (PositionListCesiumWriter polyline = this.PacketWriter.OpenVertexPositionsProperty())
                {
                    polyline.WriteValue(positions);
                }
            }
        }

        /// <inheritdoc/>
        protected override void AddLineStyle(XElement lineElement)
        {
            if (m_extrude)
            {
                using (PolylineCesiumWriter polyline = this.PacketWriter.OpenPolylineProperty())
                {
                    XElement colorElement = lineElement.Element(Document.Namespace + "color");
                    if (colorElement != null)
                    {
                        Color color = HexStringToColor(colorElement.Value);
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

        private void AddScaleProperty(XElement iconElement, BillboardCesiumWriter billboard)
        {
            XElement scaleElement = iconElement.Element(Document.Namespace + "scale");
            if (scaleElement != null)
            {
                billboard.WriteScaleProperty(double.Parse(scaleElement.Value));
            }
        }

        private Cartographic m_position;
        private XElement m_element;
        private bool m_extrude;
        private static readonly double DefaultTextureSize = 24;
    }
}
