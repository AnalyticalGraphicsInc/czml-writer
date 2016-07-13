namespace CesiumLanguageWriter
{
    /// <summary>
    /// The height reference of an object, which indicates if the object's position is relative to terrain or not.
    /// </summary>
    public enum CesiumHeightReference
    {
        /// <summary>
        /// The position is absolute.
        /// </summary>
        None,

        /// <summary>
        /// The position is clamped to the terrain.
        /// </summary>
        ClampToGround,

        /// <summary>
        /// The position height is the height above the terrain.
        /// </summary>
        RelativeToGround,
    }
}