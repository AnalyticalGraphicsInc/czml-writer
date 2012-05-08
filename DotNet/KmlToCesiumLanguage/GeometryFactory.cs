using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    internal class GeometryFactory
    {
        static public Geometry Create(XElement element, CzmlDocument document)
        {
            if (element.Name == document.Namespace + "Point")
                return new Point(element, document);
            if (element.Name == document.Namespace + "Polygon")
                return new Polygon(element, document);
            if (element.Name == document.Namespace + "LineString")
                return new LineString(element, document);
            throw new NotImplementedException();
        }
    }
}
