using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// 
    /// </summary>
    public class Placemark
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Placemark"/> class.
        /// </summary>
        /// <param name="placemark">The placemark.</param>
        /// <param name="document">The document.</param>
        public Placemark(XElement placemark, CzmlDocument document)
        {
            m_geometries = placemark.Descendants().Where(o => o.Name == document.Namespace + "Point" || o.Name == document.Namespace + "Polygon" || o.Name == document.Namespace + "LineString").Select(o => GeometryFactory.Create(o, document, placemark));
        }

        /// <summary>
        /// Writes this instance.
        /// </summary>
        public void Write()
        {
            foreach (var geometry in m_geometries)
            {
                geometry.WritePacket();
            }
        }

        private IEnumerable<Geometry> m_geometries;
    }
}
