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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write an image property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class ImageCesiumWriter : CesiumValuePropertyWriter<string, ImageCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public ImageCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private ImageCesiumWriter(ImageCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ImageCesiumWriter Clone()
        {
            return new ImageCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value of the property for all time.
        /// </summary>
        /// <param name="imageUrl">The URL of the image.  If the URL is relative, it must be relative to the <topic name="Cesium">Cesium</topic> stream.</param>
        public override void WriteValue(string imageUrl)
        {
            if (IsInterval)
                Output.WritePropertyName("image");
            Output.WriteValue(imageUrl);
        }

        /// <summary>
        /// Writes the value of the property for all time by building a data URL from
        /// a specified image.
        /// </summary>
        /// <param name="image">The image for which to create a data URL.</param>
        public void WriteValue(Image image)
        {
            WriteValue(CesiumFormattingHelper.ImageToDataUrl(image));
        }
    }
}
