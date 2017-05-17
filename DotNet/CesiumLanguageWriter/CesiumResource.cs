using System;
using System.Drawing;
using System.IO;
using CesiumLanguageWriter.Advanced;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A resource to be linked from or embedded into a CZML document.
    /// </summary>
    public class CesiumResource
    {
        private readonly string m_uri;
        private readonly CesiumResourceBehavior m_behavior;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="uri">The URI of the resource.</param>
        /// <param name="behavior">The enumeration describing how the resource is to be included in the document.</param>
        public CesiumResource(Uri uri, CesiumResourceBehavior behavior)
            : this(uri.ToString(), behavior)
        {
        }

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="uri">The URI of the resource.</param>
        /// <param name="behavior">The enumeration describing how the resource is to be included in the document.</param>
        public CesiumResource(string uri, CesiumResourceBehavior behavior)
        {
            m_uri = uri;
            m_behavior = behavior;
        }

        /// <summary>
        /// Gets the URI of the resource.
        /// </summary>
        public string Uri
        {
            get { return m_uri; }
        }

        /// <summary>
        /// Gets how the resource is to be included in the document.
        /// </summary>
        public CesiumResourceBehavior Behavior
        {
            get { return m_behavior; }
        }

        /// <summary>
        /// Create a CZML resource from an image loaded into memory.  The image data will 
        /// be embedded in the CZML document using a data URI.
        /// </summary>
        /// <param name="image">The image to write.</param>
        /// <param name="imageFormat">The format of the image.</param>
        /// <returns>A new <see cref="CesiumResource"/> containing the image data as a data URI.</returns>
        public static CesiumResource FromImage(Image image, CesiumImageFormat imageFormat)
        {
            string dataUri = CesiumFormattingHelper.ImageToDataUri(image, imageFormat);
            return new CesiumResource(dataUri, CesiumResourceBehavior.Embed);
        }

        /// <summary>
        /// Create a CZML resource from an stream containing image data.  The image data will 
        /// be embedded in the CZML document using a data URI.
        /// </summary>
        /// <param name="stream">The stream containing image data to write.</param>
        /// <param name="imageFormat">The format of the image.</param>
        /// <returns>A new <see cref="CesiumResource"/> containing the image data as a data URI.</returns>
        public static CesiumResource FromStream(Stream stream, CesiumImageFormat imageFormat)
        {
            string dataUri = CesiumFormattingHelper.ImageToDataUri(stream, imageFormat);
            return new CesiumResource(dataUri, CesiumResourceBehavior.Embed);
        }

        /// <summary>
        /// Create a CZML resource from an stream.  The data will 
        /// be embedded in the CZML document using a data URI.
        /// </summary>
        /// <param name="stream">The stream containing data to write.</param>
        /// <param name="mimeType">The mime type of the data.</param>
        /// <returns>A new <see cref="CesiumResource"/> containing the data as a data URI.</returns>
        public static CesiumResource FromStream(Stream stream, string mimeType)
        {
            string dataUri = CesiumFormattingHelper.StreamToDataUri(stream, mimeType);
            return new CesiumResource(dataUri, CesiumResourceBehavior.Embed);
        }
    }
}