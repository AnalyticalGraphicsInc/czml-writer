using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Drawing;

namespace KmlToCesiumLanguage
{
    internal class Placemark
    {
        private CzmlDocument m_document;
        private IEnumerable<Geometry> m_geometries;
        public Placemark(XElement placemark, CzmlDocument document)
        {
            m_document = document;
            m_geometries = placemark.Descendants().Where(o => o.Name == document.Namespace + "Point" || o.Name == document.Namespace + "Polygon" || o.Name == document.Namespace + "LineString").Select(o => GeometryFactory.Create(o, document, placemark));
        }

        public void Write()
        {
            foreach (var geometry in m_geometries)
            {
                geometry.WritePacket();
            }
        }
    }
}
