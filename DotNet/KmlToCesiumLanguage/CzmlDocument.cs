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
        public CzmlDocument(TextWriter outputWriter)
        {
            m_output = new CesiumOutputStream(outputWriter);
            m_writer = new CesiumStreamWriter();
            ImageMap = new Dictionary<string, string>();
            Namespace = "";
        }

        /// <summary>
        /// Gets or sets the image map.
        /// </summary>
        /// <value>
        /// The image map.
        /// </value>
        public Dictionary<string, string> ImageMap { get; set; }

        /// <summary>
        /// Gets or sets the namespace.
        /// </summary>
        /// <value>
        /// The namespace.
        /// </value>
        public XNamespace Namespace { get; set; }

        /// <summary>
        /// Gets the cesium output stream.
        /// </summary>
        public CesiumOutputStream CesiumOutputStream
        {
            get { return m_output; }
        }

        /// <summary>
        /// Gets the cesium stream writer.
        /// </summary>
        public CesiumStreamWriter CesiumStreamWriter
        {
            get { return m_writer; }
        }

        private readonly CesiumOutputStream m_output;
        private readonly CesiumStreamWriter m_writer;
    }
}