using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;
using System.Xml.Linq;

namespace KmlToCesiumLanguage
{
    public class CzmlDocument
    {
        public CzmlDocument()
            : this(new Dictionary<string, object>())
        {
        }

        public CzmlDocument(Dictionary<string, object> imageMap)
        {
            this.ImageMap = imageMap;
        }

        public JulianDate? MinimumTime { get; set; }
        public JulianDate? MaximumTime { get; set; }
        public Dictionary<string, object> ImageMap { get; private set; }
        public XNamespace Namespace { get; set; }
    }
}
