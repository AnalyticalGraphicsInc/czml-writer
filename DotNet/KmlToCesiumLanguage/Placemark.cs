using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;
using CesiumLanguageWriter;

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
            XNamespace gxNs = null;
            XName gxNsTrack = null;
            XName gxNsMultiTrack = null;
            XName gxNsInterpolate = null;
            if (document.NamespaceDeclarations.TryGetValue(Utility.GxPrefix, out gxNs))
            {
                gxNsTrack = gxNs + "Track";
                gxNsMultiTrack = gxNs + "MultiTrack";
                gxNsInterpolate = gxNs + "interpolate";
            }
            m_geometries = placemark.Descendants().Where(
                o =>
                {
                    if ((o.Name == document.Namespace + "Point") || 
                        (o.Name == document.Namespace + "Polygon") || 
                        (o.Name == document.Namespace + "LineString") ||
                        (gxNs != null && ((o.Name == gxNsTrack && gxNsMultiTrack != o.Parent.Name) ||
                            (o.Name == gxNsTrack && gxNsMultiTrack == o.Parent.Name && (o.Parent.Element(gxNsInterpolate) == null || o.Parent.Element(gxNsInterpolate).Value == "0")) ||
                            (o.Name == gxNsTrack && gxNsMultiTrack == o.Parent.Name && (o.Parent.Element(gxNsInterpolate) == null || o.Parent.Element(gxNsInterpolate).Value == "0")) ||
                            (o.Name == gxNsMultiTrack && (o.Element(gxNsInterpolate) != null && Utility.ParseBoolean(o.Element(gxNsInterpolate)))))))
                    {
                        return true;
                    }
                    return false;
                }
                ).Select(o => GeometryFactory.Create(o, document, placemark));
        }

        /// <summary>
        /// Writes this instance.
        /// </summary>
        public override void WritePacket(CesiumOutputStream stream)
        {
            foreach (var geometry in m_geometries)
            {
                geometry.WritePacket(stream);
            }
        }

        private IEnumerable<Geometry> m_geometries;
    }
}