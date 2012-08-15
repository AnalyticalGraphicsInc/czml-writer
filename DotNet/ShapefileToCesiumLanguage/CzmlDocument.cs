using System.IO;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    /// <summary>
    /// Contains the <see cref="CesiumOutputStream"/> and <see cref="CesiumStreamWriter"/> for converting to CZML.
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
        }

        /// <summary>
        /// Gets the cesium output stream.
        /// </summary>
        public CesiumOutputStream CesiumOutputStream { get { return m_output; } }

        /// <summary>
        /// Gets the cesium stream writer.
        /// </summary>
        public CesiumStreamWriter CesiumStreamWriter { get { return m_writer; } }

        private readonly CesiumOutputStream m_output;
        private readonly CesiumStreamWriter m_writer;
    }
}