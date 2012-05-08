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
    internal class Polygon : Geometry
    {
        private Dictionary<string, object> m_values;
        private List<object> m_innerProperties;

        public Polygon(XElement element, CzmlDocument document)
            : base(document)
        {
            m_values = new Dictionary<string, object>();
            m_values.Add("id", Guid.NewGuid().ToString());
            m_innerProperties = new List<object>();
            m_values.Add("properties", m_innerProperties);

            List<Cartographic> points = new List<Cartographic>();
            XElement coordinatesElement = element.Element(Document.Namespace + "outerBoundaryIs").Element(Document.Namespace + "LinearRing").Element(Document.Namespace + "coordinates");
            //outerboundary/linearRing
            XElement altitudeMode = element.Element(Document.Namespace + "altitudeMode");
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
            m_innerProperties.Add(new { name = "points", value = points });
        }

        public override Dictionary<string, object> Properties
        {
            get { return m_values; }
        }

        public override void AddProperty(object property)
        {
            m_innerProperties.Add(property);
        }

        public override void AddTimeSpan(XElement placemark)
        {
            InternalAddTimeSpan("polygon_show", placemark);
        }

        public override void AddPolyStyle(XElement polyElement)
        {
            XElement colorElement = polyElement.Element(Document.Namespace + "color");
            if (colorElement != null)
            {
                string hexColor = colorElement.Value;
                Color color = ColorTranslator.FromHtml("#" + hexColor);
                AddProperty(new { name = "polygon_material", value = "color" });
                //B and R intentionally switched
                AddProperty(new { name = "polygon_material_color", value = new { a = color.A, r = color.B, g = color.G, b = color.R } });
            }
        }
    }
}
