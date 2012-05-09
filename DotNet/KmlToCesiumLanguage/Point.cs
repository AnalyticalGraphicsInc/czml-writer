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
        private Dictionary<string, object> m_values;
        private double defaultTextureSize = 24;

        public Point(XElement element, CzmlDocument document)
            : base(document)
        {
            this.m_element = element;
            m_values = new Dictionary<string, object>();

            this.PacketWriter.WriteIdentifier(Guid.NewGuid().ToString());
            string coordinates = element.Element(Document.Namespace + "coordinates").Value.Trim();
            string[] coord = Regex.Split(coordinates, @"[,\s]+", RegexOptions.Multiline | RegexOptions.IgnorePatternWhitespace);
            XElement altitudeMode = element.Element(Document.Namespace + "altitudeMode");
            Cartographic coordinate;
            if (altitudeMode != null && altitudeMode.Value == "clampToGround")
            {
                coordinate = new Cartographic (double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, 0);
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
                coordinate = new Cartographic(double.Parse(coord[0]) * Constants.RadiansPerDegree, double.Parse(coord[1]) * Constants.RadiansPerDegree, double.Parse(coord[2]) * Constants.RadiansPerDegree);
            }
            
            using (PositionCesiumWriter position = this.PacketWriter.OpenPositionProperty())
            {
                position.WriteCartographicRadiansValue(coordinate);
            }

            XElement extrudeElement = element.Element(Document.Namespace + "extrude");
            if (extrudeElement != null && extrudeElement.Value == "1")
            {
                using (PolylineCesiumWriter polyline = this.PacketWriter.OpenPolylineProperty())
                {
                    List<Cartographic> positions = new List<Cartographic>();
                    positions.Add(coordinate);
                    positions.Add(new Cartographic(coordinate.Longitude, coordinate.Latitude, 0.0));
                    polyline.WritePositionsProperty(positions);
                }
            }
        }


        public override void AddIconStyle(XElement iconElement)
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
                        if (width > defaultTextureSize || height > defaultTextureSize || (width < defaultTextureSize && height < defaultTextureSize))
                        {
                            var max = Math.Max(width, height);
                            var scale = defaultTextureSize / max;
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

        private void AddScaleProperty(XElement iconElement, BillboardCesiumWriter billboard)
        {
            XElement scaleElement = iconElement.Element(Document.Namespace + "scale");
            if (scaleElement != null)
            {
                billboard.WriteScaleProperty(double.Parse(scaleElement.Value));
            }
        }
    }
}
