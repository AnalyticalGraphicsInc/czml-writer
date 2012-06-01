// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Image</code> to a <see cref="CesiumOutputStream" />.  A <code>Image</code> defines an image associated with an element, which can optionally vary over time.  The image is specified as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    /// </summary>
    public class ImageCesiumWriter : CesiumPropertyWriter<ImageCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public const string ImagePropertyName = "image";

        private readonly Lazy<ICesiumValuePropertyWriter<string>> m_asImage;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ImageCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asImage = new Lazy<ICesiumValuePropertyWriter<string>>(CreateImageAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ImageCesiumWriter(ImageCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asImage = new Lazy<ICesiumValuePropertyWriter<string>>(CreateImageAdaptor, false);
        }

        /// <inheritdoc />
        public override ImageCesiumWriter Clone()
        {
            return new ImageCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
        /// </summary>
        /// <param name="url">The URL of the image.</param>
        public void WriteImage(string url)
        {
            const string PropertyName = ImagePropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(url);
        }

        /// <summary>
        /// Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
        /// </summary>
        /// <param name="image">The image for which to create a data URL.</param>
        public void WriteImage(Image image)
        {
            WriteImage(CesiumFormattingHelper.ImageToDataUrl(image));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Image</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<string> AsImage()
        {
            return m_asImage.Value;
        }

        private ICesiumValuePropertyWriter<string> CreateImageAdaptor()
        {
            return new CesiumWriterAdaptor<ImageCesiumWriter, string>(
                this, (me, value) => me.WriteImage(value));
        }

    }
}
