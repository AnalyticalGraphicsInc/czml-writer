using System.Drawing;
using CesiumLanguageWriter;
using Shapefile;

namespace ShapefileToCesiumLanguage
{
    /// <summary>
    /// Represents a shapefile shape that can be written to a <see cref="CzmlDocument"/>.
    /// </summary>
    public abstract class CzmlShape
    {
        /// <summary>
        /// Constructs a new <see cref="CzmlShape"/>.
        /// </summary>
        /// <param name="document">The <see cref="CzmlDocument"/> to which the shape's CZML is written.</param>
        /// <param name="color">A color for the shape's visualization.</param>
        protected CzmlShape(CzmlDocument document, Color color)
        {
            m_document = document;
            m_color = color;
        }

        /// <summary>
        /// Writes the CZML representation of the shape as a series of packets to its <see cref="CzmlDocument"/>.
        /// </summary>
        public abstract void Write();

        /// <summary>
        /// Gets the shape's <see cref="CzmlDocument"/>.
        /// </summary>
        protected CzmlDocument Document { get { return m_document; } }

        protected Shape m_shape;
        protected CzmlDocument m_document;
        protected Color m_color;
    }
}
