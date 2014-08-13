namespace CesiumLanguageWriter
{
    /// <summary>
    /// The horizontal origin of a billboard or label in a CZML stream
    /// relative to an associated position.
    /// </summary>
    public enum CesiumHorizontalOrigin
    {
        /// <summary>
        /// The left side of the billboard or label is located at the position.
        /// </summary>
        Left,

        /// <summary>
        /// The billboard or label is horizontally centered on the position.
        /// </summary>
        Center,

        /// <summary>
        /// The right side of the billboard or label is located at the position.
        /// </summary>
        Right,
    }
}