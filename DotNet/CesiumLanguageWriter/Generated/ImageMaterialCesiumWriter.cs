// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ImageMaterial</code> to a <see cref="CesiumOutputStream" />.  A <code>ImageMaterial</code> a material that fills the surface with an image.
    /// </summary>
    public class ImageMaterialCesiumWriter : CesiumPropertyWriter<ImageMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public const string ImagePropertyName = "image";

        private readonly Lazy<ImageCesiumWriter> m_image = new Lazy<ImageCesiumWriter>(() => new ImageCesiumWriter(ImagePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ImageMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ImageMaterialCesiumWriter(ImageMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ImageMaterialCesiumWriter Clone()
        {
            return new ImageMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>image</code> property defines the image to display on the surface.
        /// </summary>
        public ImageCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the image to display on the surface.
        /// </summary>
        public ImageCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the image.  If this URL is not a data URI, it will be downloaded and embedded in the document, using a thread-local cache to avoid downloading the same image multiple times.  For more control over how the image is referenced in the document, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteImageProperty(string url)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(url);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the image.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteImageProperty(string url, ICesiumUrlResolver resolver)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(url, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image, using PNG encoding.</param>
        public void WriteImageProperty(Image image)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(image);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image.</param>
        /// <param name="imageFormat">The image format to use to encode the image in the data URI.</param>
        public void WriteImageProperty(Image image, CesiumImageFormat imageFormat)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(image, imageFormat);
            }
        }

    }
}
