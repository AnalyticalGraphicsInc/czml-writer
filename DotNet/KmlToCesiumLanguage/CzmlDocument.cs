using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;
using System.Xml.Linq;
using System.IO;

namespace KmlToCesiumLanguage
{
    public class CzmlDocument
    {
        public CzmlDocument()
            : this(new Dictionary<string, object>())
        {
            m_sw = new StringWriter();
            m_output = new CesiumOutputStream(m_sw);
            m_output.PrettyFormatting = true;
            m_writer = new CesiumStreamWriter();
        }

        public CzmlDocument(Dictionary<string, object> imageMap)
        {
            this.ImageMap = imageMap;
        }

        public JulianDate? MinimumTime { get; set; }
        public JulianDate? MaximumTime { get; set; }
        public Dictionary<string, object> ImageMap { get; private set; }
        public XNamespace Namespace { get; set; }

        public StringWriter StringWriter { get { return m_sw; } }
        public CesiumOutputStream CesiumOutputStream { get { return m_output; } }
        public CesiumStreamWriter CesiumStreamWriter { get { return m_writer; } }

        private StringWriter m_sw;
        private CesiumOutputStream m_output;
        private CesiumStreamWriter m_writer;
    }
}
