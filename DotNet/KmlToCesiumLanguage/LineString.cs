using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text.RegularExpressions;
using System.Xml.Linq;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// Defines a connected set of line segments.
    /// </summary>
    public class LineString : Geometry
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="LineString"/> class.
        /// </summary>
        /// <param name="element">The element.</param>
        /// <param name="document">The document.</param>
        /// <param name="placemark">The placemark.</param>
        public LineString(XElement element, CzmlDocument document, XElement placemark)
            : base(document, placemark)
        {
            m_element = element;
        }

        /// <inheritdoc />
        protected override void AddLineStyle(XElement lineElement)
        {
            XElement colorElement = lineElement.Element(Document.Namespace + "color");
            PolylineCesiumWriter polyline = null;
            if (colorElement != null)
            {
                string hexColor = colorElement.Value;
                Color color = ColorTranslator.FromHtml("#" + hexColor);
                polyline = this.PacketWriter.OpenPolylineProperty();
                polyline.WriteColorProperty(color);
            }
            XElement widthElement = lineElement.Element(Document.Namespace + "width");
            if (widthElement != null)
            {
                if (polyline == null)
                {
                    polyline = this.PacketWriter.OpenPolylineProperty();
                }
                polyline.WriteWidthProperty(double.Parse(widthElement.Value));
                polyline.WriteOutlineWidthProperty(0);
            }
            if (polyline != null)
            {
                polyline.Close();
            }
        }

        /// <inheritdoc />
        protected override void Write()
        {
            List<Cartographic> points = new List<Cartographic>();
            string coordinates = m_element.Element(Document.Namespace + "coordinates").Value.Trim();
            XElement tessellateElement = m_element.Element(Document.Namespace + "tessellate");
            XElement altitudeModeElement = m_element.Element(Document.Namespace + "altitudeMode");
            int tessellate = tessellateElement != null ? int.Parse(tessellateElement.Value) : 0;
            string altitudeMode = altitudeModeElement != null ? altitudeModeElement.Value : "clampToGround";
            Regex r = new Regex(@"(-?\d+\.?\d*)\s*,\s*(-?\d+\.?\d*)\s*,\s*(-?\d+\.?\d*)");
            MatchCollection mc = r.Matches(coordinates);
            string[] coord = new string[] { };
            if (mc.Count > 0)
            {
                foreach (Match match in mc)
                {
                    string[] location = Regex.Split(match.Value.Trim(), @"[,\s]+", RegexOptions.Multiline | RegexOptions.IgnorePatternWhitespace);
                    if (tessellate == 1 && altitudeMode == "clampToGround")
                    {
                        location[2] = "0";
                    }
                    coord = coord.Concat(location).ToArray();
                }
            }
            else
            {
                r = new Regex(@"(-?\d+\.?\d*)\s*,\s*(-?\d+\.?\d*\s+)");
                mc = r.Matches(coordinates);
                if (mc.Count > 0)
                {
                    foreach (Match match in mc)
                    {
                        string[] location = Regex.Split(match.Value.Trim(), @"[,\s]+", RegexOptions.Multiline | RegexOptions.IgnorePatternWhitespace);
                        coord = coord.Concat(location).Concat(new List<string> { "0" }).ToArray();
                    }
                }
                else
                {
                    throw new NotImplementedException();
                }
            }

            for (int i = 0; i < coord.Length; i += 3)
            {
                points.Add(new Cartographic(double.Parse(coord[i]) * Constants.RadiansPerDegree, double.Parse(coord[i + 1]) * Constants.RadiansPerDegree, double.Parse(coord[i + 2]) * Constants.RadiansPerDegree));
            }
            using (var positions = this.PacketWriter.OpenVertexPositionsProperty())
            {
                positions.WriteValue(points);
            }
        }

        private XElement m_element;
    }
}
