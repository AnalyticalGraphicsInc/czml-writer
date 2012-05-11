using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// The entry point to convert a kml file.
    /// </summary>
    public static class KmlConverter
    {
        /// <summary>
        /// Converts an kml document to CZML.
        /// </summary>
        /// <param name="kmlDocument">The kml document.</param>
        /// <param name="document">The czml document.</param>
        public static void ConvertToCesiumLanguage(XDocument kmlDocument, CzmlDocument document)
        {
            document.Namespace = kmlDocument.Root.GetDefaultNamespace();
            var properties = new List<Dictionary<string, object>>();
            var placemarks = kmlDocument.Descendants(document.Namespace + "Placemark").Select(o => new Placemark(o, document));
            foreach (var placemark in placemarks)
            {
                placemark.Write();
            }
        }
    }
}
