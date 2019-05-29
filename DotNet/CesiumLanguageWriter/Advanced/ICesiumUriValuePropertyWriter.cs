using System;
using System.Drawing;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a URI.
    /// </summary>
    public interface ICesiumUriValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a URI.
        /// </summary>
        /// <param name="resource">A resource object describing external data.</param>
        void WriteUri(CesiumResource resource);

        /// <summary>
        /// Writes the value expressed as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        void WriteUri(Uri uri, CesiumResourceBehavior resourceBehavior);

        /// <summary>
        /// Writes the value expressed as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        void WriteUri(string uri, CesiumResourceBehavior resourceBehavior);

        /// <summary>
        /// Writes the value expressed as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        void WriteUri(Uri uri, ICesiumUriResolver resolver);

        /// <summary>
        /// Writes the value expressed as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        void WriteUri(string uri, ICesiumUriResolver resolver);

        /// <summary>
        /// Writes the value expressed as a URI.
        /// </summary>
        /// <param name="image">The image. A data URI will be created for this image, using PNG encoding.</param>
        void WriteUri(Image image);

        /// <summary>
        /// Writes the value expressed as a URI.
        /// </summary>
        /// <param name="image">The image. A data URI will be created for this image.</param>
        /// <param name="imageFormat">The image format to use to encode the image in the data URI.</param>
        void WriteUri(Image image, CesiumImageFormat imageFormat);
    }
}