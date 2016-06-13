namespace CesiumLanguageWriter
{
    /// <summary>
    /// Specifies the style of a corner.
    /// </summary>
    public enum CesiumCornerType
    {
        /// <summary>
        /// The corner has a smooth edge.
        /// </summary>
        Rounded,

        /// <summary>
        /// The corner point is the intersection of adjacent edges.
        /// </summary>
        Mitered,

        /// <summary>
        /// The corner is clipped.
        /// </summary>
        Beveled,
    }
}