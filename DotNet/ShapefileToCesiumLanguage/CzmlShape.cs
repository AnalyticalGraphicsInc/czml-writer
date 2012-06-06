using System;
using System.Drawing;
using Shapefile;
using CesiumLanguageWriter;

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
        /// Writes the czml packet of the shape.
        /// </summary>
        public void WritePacket()
        {
            using (this.PacketWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                this.PacketWriter.WriteId(m_shape.RecordNumber.ToString());
                // Add style information?
                this.Write();
            }
        }

        /// <summary>
        /// Writes the CZML representation of the shape.
        /// </summary>
        protected abstract void Write();

        /// <summary>
        /// Gets the document.
        /// </summary>
        protected CzmlDocument Document { get { return m_document; } }

        /// <summary>
        /// Gets the packet writer.
        /// </summary>
        protected PacketCesiumWriter PacketWriter { get; private set; }

        protected Shape m_shape;
        protected CzmlDocument m_document;
        protected Color m_color;
    }
}
