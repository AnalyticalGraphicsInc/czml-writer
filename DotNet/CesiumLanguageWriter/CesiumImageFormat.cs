
#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// The format of an image embedded in a <topic name="Cesium">Cesium</topic> stream.
    /// </summary>
    public enum CesiumImageFormat
    {
        /// <summary>
        /// The image is in Portable Network Graphics (PNG) format.
        /// </summary>
        Png,

        /// <summary>
        /// The image is in Joint Photographic Experts Group (JPEG) format.
        /// </summary>
        Jpeg,

        /// <summary>
        /// The image is in Graphics Interchange Format (GIF) format.
        /// </summary>
        Gif,

        /// <summary>
        /// The image is in bitmap (BMP) format.
        /// </summary>
        Bmp,
    }
}