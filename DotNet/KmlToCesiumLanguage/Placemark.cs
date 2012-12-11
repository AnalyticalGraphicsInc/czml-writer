using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// 
    /// </summary>
    public class Placemark : Feature
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Placemark"/> class.
        /// </summary>
        /// <param name="placemark">The placemark.</param>
        /// <param name="document">The document.</param>
        public Placemark(XElement placemark, CzmlDocument document)
        {
            m_geometries = placemark.Descendants().Where(
                o =>
                {
                    if (o.Name == document.Namespace + "Point")
                        return true;
                    if (o.Name == document.Namespace + "Polygon")
                        return true;
                    if (o.Name == document.Namespace + "LineString")
                        return true;
                    if (document.NamespaceDeclarations.ContainsKey(Utility.GxPrefix))
                    {
                        var gxNs = document.NamespaceDeclarations[Utility.GxPrefix];
                        if (o.Name == gxNs + "Track" && gxNs + "MultiTrack" != o.Parent.Name)
                            return true;
                        if (o.Name == gxNs + "Track" && gxNs + "MultiTrack" == o.Parent.Name && (o.Parent.Element(gxNs + "interpolate") == null || o.Parent.Element(gxNs + "interpolate").Value == "0"))
                            return true;
                        if (o.Name == gxNs + "MultiTrack" && (o.Element(gxNs + "interpolate") != null && o.Element(gxNs + "interpolate").Value == "1"))
                            return true;
                    }
                    return false;
                }
                ).Select(o => GeometryFactory.Create(o, document, placemark));
        }

        /// <summary>
        /// Writes this instance.
        /// </summary>
        public override void WritePacket()
        {
            foreach (var geometry in m_geometries)
            {
                geometry.WritePacket();
            }
        }

        private IEnumerable<Geometry> m_geometries;
    }
}