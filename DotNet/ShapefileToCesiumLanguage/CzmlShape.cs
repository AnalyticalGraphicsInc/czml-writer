using System.Drawing;
using CesiumLanguageWriter;
using Shapefile;

namespace ShapefileToCesiumLanguage
{
    public abstract class CzmlShape
    {
        protected CzmlShape(CzmlDocument document, Color color)
        {
            m_document = document;
            m_color = color;
        }

        /// <summary>
        /// Writes the CZML representation of the shape as a series of packets.
        /// </summary>
        public abstract void Write();

        /// <summary>
        /// Gets the document.
        /// </summary>
        protected CzmlDocument Document { get { return m_document; } }

        /// <summary>
        /// Gets the packet writer.
        /// </summary>
        protected PacketCesiumWriter PacketWriter { get; set; }

        protected Shape m_shape;
        protected CzmlDocument m_document;
        protected Color m_color;
    }
}
