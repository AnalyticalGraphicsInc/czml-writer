using System.Collections.Generic;
using System.Drawing;
using System.Text.RegularExpressions;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System;
using GeometricComputations;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// A Polygon is defined by an outer boundary. Inner boundaries are not supported in CZML yet. 
    /// </summary>
    public class Polygon : Geometry
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Polygon"/> class.
        /// </summary>
        /// <param name="element">The element.</param>
        /// <param name="document">The document.</param>
        /// <param name="placemark">The placemark.</param>
        public Polygon(XElement element, CzmlDocument document, XElement placemark)
            : base(document, placemark)
        {
            m_element = element;
            XElement altitudeMode = m_element.Element(Document.Namespace + "altitudeMode");
            if (altitudeMode != null)
            {
                m_altitudeMode = altitudeMode.Value;
            }
            
        }

        /// <inheritdoc />
        protected override void AddPolyStyle(XElement polyElement)
        {
            XElement colorElement = polyElement.Element(Document.Namespace + "color");
            if (colorElement != null)
            {
                Color color = Utility.HexStringToColor(colorElement.Value);
                using (var polygon = this.PacketWriter.OpenPolygonProperty())
                {
                    using (var material = polygon.OpenMaterialProperty())
                    {
                        using (var solidColor = material.OpenSolidColorProperty())
                        {
                            solidColor.WriteColorProperty(color);
                        }
                    }
                }
            }
        }

        /// <inheritdoc />
        protected override void Write()
        {
            XElement coordinatesElement = m_element.Element(Document.Namespace + "outerBoundaryIs").Element(Document.Namespace + "LinearRing").Element(Document.Namespace + "coordinates");
            IEnumerable<XElement> innerElements = m_element.Elements(Document.Namespace + "innerBoundaryIs");
            List<List<Cartographic>> innerRings = new List<List<Cartographic>>();
            foreach (XElement innerElement in innerElements)
            {
                string innerCoords = innerElement.Element(Document.Namespace + "LinearRing").Element(Document.Namespace + "coordinates").Value.Trim();
                List<Cartographic> innerCoordinates = ParseCoordinates(innerCoords);
                innerRings.Add(innerCoordinates);
            }
            //outerboundary/linearRing
            
            string coordinates = coordinatesElement.Value.Trim();
            var outerRing = ParseCoordinates(coordinates);
            List<Cartographic> outerPositions = outerRing;

            while (innerRings.Count > 0)
            {
                outerPositions = PolygonAlgorithms.EliminateHole(outerPositions, innerRings);
            }
            using (var positions = this.PacketWriter.OpenVertexPositionsProperty())
            {
                positions.WriteCartographicRadians(outerPositions);
            }
        }

        private List<Cartographic> ParseCoordinates(string coordinates)
        {
            List<Cartographic> points = new List<Cartographic>();
            Regex coordinateExpression = new Regex(@"(?<longitude>-?\d+\.?\d*)          # capture longitude value
                                                     \s*,\s*                            # capture separator 
                                                     (?<latitude>-?\d+\.?\d*)           # capture latitude value
                                                     \s*,\s*                            # capture separator
                                                     (?<altitude>-?\d+\.?\d*)           # capture altitude value", RegexOptions.IgnorePatternWhitespace);
            MatchCollection mc = coordinateExpression.Matches(coordinates);
            if (mc.Count > 0)
            {
                foreach (Match match in mc)
                {
                    string longitude = match.Groups["longitude"].Value;
                    string latitude = match.Groups["latitude"].Value;
                    string altitude = match.Groups["altitude"].Value;
                    if (m_altitudeMode == "" || (m_altitudeMode == "clampToGround"))
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
                    throw new NotSupportedException("The coordinates value describing the Polygon is improperly formatted.");
                }
            }
            return points;
        }

        private XElement m_element;
        private string m_altitudeMode;
    }
}
