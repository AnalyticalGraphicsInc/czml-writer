using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    internal class FeatureFactory
    {
        static public Feature Create(XElement feature, CzmlDocument document)
        {
            if (feature.Name == document.Namespace + "Placemark")
                return new Placemark(feature, document);
            if (feature.Name == document.Namespace + "GroundOverlay")
                return new GroundOverlay(feature, document);
            throw new NotImplementedException();
        }
    }
}
