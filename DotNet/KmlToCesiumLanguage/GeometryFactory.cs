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
            throw new NotImplementedException();
        }
    }
}
