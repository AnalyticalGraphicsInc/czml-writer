using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Text.RegularExpressions;
using CesiumLanguageWriter;
using System.Diagnostics;
using System.Drawing;
using System.Net;
using System.IO;

namespace KmlToCesiumLanguage
{
    internal class Point : Geometry
    {
        private XElement m_element;
        private XElement m_placemark;
        private Dictionary<string, object> m_values;
        private List<object> m_innerProperties;
        private double defaultTextureSize = 24;

        public Point(XElement element, CzmlDocument document)
            : base(document)
        {
            this.m_element = element;
            m_values = new Dictionary<string, object>();
            m_values.Add("id", Guid.NewGuid().ToString());
            m_innerProperties = new List<object>();
            m_values.Add("properties", m_innerProperties);
            string coordinates = element.Element(Document.Namespace + "coordinates").Value.Trim();

            string[] coord = Regex.Split(coordinates, @"[,\s]+", RegexOptions.Multiline | RegexOptions.IgnorePatternWhitespace);
            XElement altitudeMode = element.Element(Document.Namespace + "altitudeMode");
            Cartographic coordinate;
            if (altitudeMode != null && altitudeMode.Value == "clampToGround")
            {
                coordinate = new Cartographic (double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, 0);
                Debug.Assert(coord.Length == 2 || coord.Length == 3);
                m_innerProperties.Add(new { name = "position", value = coordinate });

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
                coordinate = new Cartographic(double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, double.Parse(coord[2]) * Constants.RadiansPerDegree);
                m_innerProperties.Add(new { name = "position", value = coordinate });
            }

            XElement extrudeElement = element.Element(Document.Namespace + "extrude");
            if (extrudeElement != null && extrudeElement.Value == "1")
            {
                m_innerProperties.Add(new { name = "line_startPosition", value = coordinate });
                Cartographic groundPosition = new Cartographic(coordinate.Longitude, coordinate.Latitude, 0 );
                m_innerProperties.Add(new { name = "line_endPosition", value = groundPosition });
            }
        }

        public override Dictionary<string, object> Properties
        {
             get { return m_values; }
        }

        public override void AddProperty(object property)
        {
            m_innerProperties.Add(property);
        }

        public override void AddTimeSpan(System.Xml.Linq.XElement placemark)
        {
            m_placemark = placemark;

            XElement extrudeElement = m_element.Element(Document.Namespace + "extrude");
            if (extrudeElement != null && extrudeElement.Value == "true")
            {
                InternalAddTimeSpan("line_show", placemark);
            }
        }

        public override void AddIconStyle(XElement iconElement)
        {
            InternalAddTimeSpan("billboard_show", m_placemark);
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
                    if (width > defaultTextureSize || height > defaultTextureSize || (width < defaultTextureSize && height < defaultTextureSize))
                    {
                        var max = Math.Max(width, height);
                        var scale = defaultTextureSize / max;
                        AddProperty(new { name = "billboard_scale", value = scale });
                    }
                }
                else
                {
                    href = imageRef as string;
                    AddScaleProperty(iconElement);
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
                    AddScaleProperty(iconElement);
                    Document.ImageMap.Add(href, hrefValue);
                    href = hrefValue;
                }
            }

            AddProperty(new { name = "billboard_texture", value = href });
        }

        private void AddScaleProperty(XElement iconElement)
        {
            XElement scaleElement = iconElement.Element(Document.Namespace + "scale");
            if (scaleElement != null)
            {
                AddProperty(new { name = "billboard_scale", value = scaleElement.Value });
            }
        }
    }
}
