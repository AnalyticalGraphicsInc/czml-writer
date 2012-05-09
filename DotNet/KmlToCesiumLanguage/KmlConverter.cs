using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.IO;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    public class KmlConverter
    {
        public static void ConvertToCZML(XDocument root, CzmlDocument document)
        {
            document.Namespace = root.Root.GetDefaultNamespace();
            var properties = new List<Dictionary<string, object>>();
            var placemarks = root.Descendants(document.Namespace + "Placemark").Select(o => new Placemark(o, document));
            foreach (var placemark in placemarks)
            {
                placemark.Write();
            }
        }
    }
}
