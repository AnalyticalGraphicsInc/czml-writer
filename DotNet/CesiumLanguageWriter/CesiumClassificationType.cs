namespace CesiumLanguageWriter
{
    /// <summary>
    /// Whether a classification affects terrain, 3D Tiles or both.
    /// </summary>
    public enum CesiumClassificationType
    {
        /// <summary>
        /// Only terrain will be classified.
        /// </summary>
        Terrain,

        /// <summary>
        /// Only 3D Tiles will be classified.
        /// </summary>
        Cesium3DTile,

        /// <summary>
        /// Both terrain and 3D Tiles will be classified.
        /// </summary>
        Both,
    }
}