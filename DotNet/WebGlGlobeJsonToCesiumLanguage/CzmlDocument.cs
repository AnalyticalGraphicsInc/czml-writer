using System.Collections.Generic;
using System.IO;
using System.Linq;
using CesiumLanguageWriter;

namespace WebGlGlobeJsonToCesiumLanguage
{
    /// <summary>
    /// Stores data about the json file.
    /// </summary>
    public class CzmlDocument
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="CzmlDocument"/> class.
        /// </summary>
        public CzmlDocument()
        {
            m_sw = new StringWriter();
            m_output = new CesiumOutputStream(m_sw);
            m_writer = new CesiumStreamWriter();
        }

        /// <summary>
        /// Gets the string writer.
        /// </summary>
        public StringWriter StringWriter { get { return m_sw; } }

        /// <summary>
        /// Gets the cesium output stream.
        /// </summary>
        public CesiumOutputStream CesiumOutputStream { get { return m_output; } }

        /// <summary>
        /// Gets the cesium stream writer.
        /// </summary>
        public CesiumStreamWriter CesiumStreamWriter { get { return m_writer; } }

        private StringWriter m_sw;
        private CesiumOutputStream m_output;
        private CesiumStreamWriter m_writer;
    }
}
