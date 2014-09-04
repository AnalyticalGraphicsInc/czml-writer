namespace CesiumLanguageWriter
{
    /// <summary>
    /// The format of an image to be embedded in a CZML stream.
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