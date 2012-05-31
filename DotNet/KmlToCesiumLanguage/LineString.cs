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
                Color color = Utility.HexStringToColor(colorElement.Value);
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
            string coordinates = m_element.Element(Document.Namespace + "coordinates").Value.Trim();
            XElement tessellateElement = m_element.Element(Document.Namespace + "tessellate");
            XElement altitudeModeElement = m_element.Element(Document.Namespace + "altitudeMode");
            int tessellate = tessellateElement != null ? int.Parse(tessellateElement.Value) : 0;
            string altitudeMode = altitudeModeElement != null ? altitudeModeElement.Value : "clampToGround";
            Regex coordinateExpression = new Regex(@"(?<longitude>-?\d+\.?\d*)          # capture longitude value
                                                     \s*,\s*                            # capture separator 
                                                     (?<latitude>-?\d+\.?\d*)           # capture latitude value
                                                     \s*,\s*                            # capture separator
                                                     (?<altitude>-?\d+\.?\d*)           # capture altitude value", RegexOptions.IgnorePatternWhitespace);
            MatchCollection mc = coordinateExpression.Matches(coordinates);
            List<Cartographic> points = new List<Cartographic>();
            if (mc.Count > 0)
            {
                foreach (Match match in mc)
                {
                    string longitude = match.Groups["longitude"].Value;
                    string latitude = match.Groups["latitude"].Value;
                    string altitude = match.Groups["altitude"].Value;
                    if (tessellate == 1 && altitudeMode == "clampToGround")
                    {
                        altitude = "0";
                    }
                    points.Add(new Cartographic(double.Parse(longitude) * Constants.RadiansPerDegree, double.Parse(latitude) * Constants.RadiansPerDegree, double.Parse(altitude)));
                }
            }
            else
            {
                coordinateExpression = new Regex(@"(?<longitude>-?\d+\.?\d*)    # capture longitude value
                                                   \s*,\s*                      # capture separator
                                                   (?<latitude>-?\d+\.?\d*)     # capture latitude value", RegexOptions.IgnorePatternWhitespace);
                mc = coordinateExpression.Matches(coordinates);
                if (mc.Count > 0)
                {
                    foreach (Match match in mc)
                    {
                        string longitude = match.Groups["longitude"].Value;
                        string latitude = match.Groups["latitude"].Value;
                        points.Add(new Cartographic(double.Parse(longitude) * Constants.RadiansPerDegree, double.Parse(latitude) * Constants.RadiansPerDegree, 0.00));
                    }
                }
                else
                {
                    throw new NotSupportedException("The coordinates value describing the LineString is improperly formatted.");
                }
            }

            using (var positions = this.PacketWriter.OpenVertexPositionsProperty())
            {
                positions.WriteCartographicRadians(points);
            }
        }

        private XElement m_element;
    }
}
