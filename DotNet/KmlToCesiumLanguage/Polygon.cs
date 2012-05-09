using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Text.RegularExpressions;
using System.Drawing;

namespace KmlToCesiumLanguage
{
    public class Polygon : Geometry
    {
        private XElement m_element;
        public Polygon(XElement element, CzmlDocument document, XElement placemark)
            : base(document, placemark)
        {
            m_element = element;
        }


        protected override void AddPolyStyle(XElement polyElement)
        {
            XElement colorElement = polyElement.Element(Document.Namespace + "color");
            if (colorElement != null)
            {
                string hexColor = colorElement.Value;
                Color color = ColorTranslator.FromHtml("#" + hexColor);
                using (var polygon = this.PacketWriter.OpenPolygonProperty())
                {
                    using (var material = polygon.OpenCapMaterialProperty())
                    {
                        using (var solidColor = material.OpenSolidColorProperty())
                        {
                            solidColor.WriteColorProperty(color);
                        }
                    }
                }
            }
        }

        protected override void Write()
        {
            List<Cartographic> points = new List<Cartographic>();
            XElement coordinatesElement = m_element.Element(Document.Namespace + "outerBoundaryIs").Element(Document.Namespace + "LinearRing").Element(Document.Namespace + "coordinates");
            //outerboundary/linearRing
            XElement altitudeMode = m_element.Element(Document.Namespace + "altitudeMode");
            string coordinates = coordinatesElement.Value.Trim();
            string[] coord = Regex.Split(coordinates, @"[,\s]+", RegexOptions.Multiline | RegexOptions.IgnorePatternWhitespace);
            if (altitudeMode != null && altitudeMode.Value == "clampToGround")
            {
                for (int i = 0; i < coord.Length; i += 2)
                {
                    points.Add(new Cartographic(double.Parse(coord[i]) * Constants.RadiansPerDegree, double.Parse(coord[i + 1]) * Constants.RadiansPerDegree, 0));
                }
            }
            else
            {
                for (int i = 0; i < coord.Length; i += 3)
                {
                    points.Add(new Cartographic(double.Parse(coord[i]) * Constants.RadiansPerDegree, double.Parse(coord[i + 1]) * Constants.RadiansPerDegree, double.Parse(coord[i + 2]) * Constants.RadiansPerDegree));
                }
            }

            using (var positions = this.PacketWriter.OpenVertexPositionsProperty())
            {
                positions.WriteValue(points);
            }
        }
    }
}
