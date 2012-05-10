using System.Collections.Generic;
using System.IO;
using System.Xml.Linq;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// Stores data about the kml file.
    /// </summary>
    public class CzmlDocument
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="CzmlDocument"/> class.
        /// </summary>
        public CzmlDocument()
            : this(new Dictionary<string, object>())
        {
            m_sw = new StringWriter();
            m_output = new CesiumOutputStream(m_sw);
            m_writer = new CesiumStreamWriter();
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="CzmlDocument"/> class.
        /// </summary>
        /// <param name="imageMap">The image map.</param>
        public CzmlDocument(Dictionary<string, object> imageMap)
        {
            this.ImageMap = imageMap;
        }

        /// <summary>
        /// Gets or sets the minimum time.
        /// </summary>
        /// <value>
        /// The minimum time.
        /// </value>
        public JulianDate? MinimumTime { get; set; }

        /// <summary>
        /// Gets or sets the maximum time.
        /// </summary>
        /// <value>
        /// The maximum time.
        /// </value>
        public JulianDate? MaximumTime { get; set; }

        /// <summary>
        /// Gets the image map.
        /// </summary>
        public Dictionary<string, object> ImageMap { get; private set; }

        /// <summary>
        /// Gets or sets the namespace.
        /// </summary>
        /// <value>
        /// The namespace.
        /// </value>
        public XNamespace Namespace { get; set; }

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
