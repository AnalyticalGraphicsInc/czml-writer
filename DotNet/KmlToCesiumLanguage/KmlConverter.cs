using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    public class KmlConverter
    {
        public static string ConvertToCZML(XDocument root, CzmlDocument document)
        {
            document.Namespace = root.Root.GetDefaultNamespace();
            var properties = new List<Dictionary<string, object>>();
            var placemarks = root.Descendants(document.Namespace + "Placemark").Select(o => new Placemark(o, document));
            return "";
        }
    }
}
