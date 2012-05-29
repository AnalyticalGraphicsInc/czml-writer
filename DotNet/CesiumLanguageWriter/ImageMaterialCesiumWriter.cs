using System;
using System.Drawing;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing properties related to the image material to a
    /// <topic name="Cesium">Cesium</topic> stream.
    /// </summary>
    public class ImageMaterialCesiumWriter : CesiumPropertyWriter<ImageMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public static readonly string ImagePropertyName = "image";


        private readonly Lazy<ImageCesiumWriter> m_image = new Lazy<ImageCesiumWriter>(() => new ImageCesiumWriter(ImagePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The base name of properties.</param>
        public ImageMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private ImageMaterialCesiumWriter(ImageMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ImageMaterialCesiumWriter Clone()
        {
            return new ImageMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>*_image</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenImageProperty"/> method for more information.
        /// </summary>
        public ImageCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens a property describing the image.
        /// </summary>
        /// <returns>The writer that is used to write image information.</returns>
        public ImageCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_image</code> property.
        /// See the documentation for the <see cref="OpenImageProperty"/> method for more information.
        /// </summary>
        /// <param name="color">The value of the property.</param>
        public void WriteImageProperty(Image color)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteValue(color);
            }
        }

        /// <summary>
        /// Writes a constant value for the <code>*_image</code> property.
        /// See the documentation for the <see cref="OpenImageProperty"/> method for more information.
        /// </summary>
        /// <param name="imageUrl">The image URL.</param>
        public void WriteImageProperty(string imageUrl)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteValue(imageUrl);
            }
        }
    }
}
