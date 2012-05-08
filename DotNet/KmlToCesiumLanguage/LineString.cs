using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Drawing;
using System.Text.RegularExpressions;

namespace KmlToCesiumLanguage
{
    internal class LineString : Geometry
    {
        private Dictionary<string, object> m_values;
        private List<object> m_innerProperties;
        
        public LineString(XElement element, CzmlDocument document)
            : base(document)
        {
            this.Points = new List<Cartographic>();
            m_values = new Dictionary<string, object>();
            string coordinates = element.Element(Document.Namespace + "coordinates").Value.Trim();
            XElement tessellateElement = element.Element(Document.Namespace + "tessellate");
            XElement altitudeModeElement = element.Element(Document.Namespace + "altitudeMode");
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
                this.Points.Add(new Cartographic (double.Parse(coord[i]) * Constants.RadiansPerDegree, double.Parse(coord[i + 1]) * Constants.RadiansPerDegree, double.Parse(coord[i + 2]) * Constants.RadiansPerDegree));
            }

            m_values.Add("id", Guid.NewGuid().ToString());
            m_innerProperties = new List<object>();
            m_values.Add("properties", m_innerProperties);
            m_innerProperties.Add(new { name = "points", value = this.Points });
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
            InternalAddTimeSpan("polyline_show", placemark);
        }

        public override void AddLineStyle(XElement lineElement)
        {
            XElement colorElement = lineElement.Element(Document.Namespace + "color");
            if (colorElement != null)
            {
                string hexColor = colorElement.Value;
                Color color = ColorTranslator.FromHtml("#" + hexColor);
                //B and R intentionally switched
                AddProperty(new { name = "polyline_color", value = new { a = color.A, r = color.B, g = color.G, b = color.R } });
            }
            XElement widthElement = lineElement.Element(Document.Namespace + "width");
            if (widthElement != null)
            {
                AddProperty(new { name = "polyline_width", value = widthElement.Value });
                AddProperty(new { name = "polyline_outlineWidth", value = 0 });
            }
        }

        public List<Cartographic> Points { get; private set; }
    }
}
