using System;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    internal class GeometryFactory
    {
        static public Geometry Create(XElement element, CzmlDocument document, XElement placemark)
        {
            if (element.Name == document.Namespace + "Point")
                return new Point(element, document, placemark);
            if (element.Name == document.Namespace + "Polygon")
                return new Polygon(element, document, placemark);
            if (element.Name == document.Namespace + "LineString")
                return new LineString(element, document, placemark);
            if (document.NamespaceDeclarations.ContainsKey(Utility.GxPrefix))
            {
                if (element.Name == document.NamespaceDeclarations[Utility.GxPrefix] + "MultiTrack")
                    return new GxMultiTrack(element, document, placemark);
                if (element.Name == document.NamespaceDeclarations[Utility.GxPrefix] + "Track")
                    return new GxTrack(element, document, placemark);
            }
            throw new NotImplementedException();
        }
    }
}
