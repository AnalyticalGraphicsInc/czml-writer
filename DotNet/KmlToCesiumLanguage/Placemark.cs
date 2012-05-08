using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    internal class Placemark
    {
        private XElement m_element;
        private List<Dictionary<string, object>> m_values;
        private CzmlDocument m_document;

        public Placemark(XElement placemark, CzmlDocument document)
        {
            m_document = document;
            m_element = placemark;
            m_values = new List<Dictionary<string, object>>();
            var geometry = placemark.Descendants().Where(o => o.Name == document.Namespace + "Point" || o.Name == document.Namespace + "Polygon" || o.Name == document.Namespace + "LineString").Select(o => GeometryFactory.Create(o, document));
        }
    }
}
