namespace CesiumLanguageWriter
{
    /// <summary>
    /// The vertical origin of an item relative to its position.
    /// </summary>
    public enum CesiumVerticalOrigin
    {
        /// <summary>
        /// The bottom of the item is located at the position.
        /// </summary>
        Bottom,

        /// <summary>
        /// The item is at the vertical center between <see cref="Baseline"/> and <see cref="Top"/>.
        /// </summary>
        Center,

        /// <summary>
        /// The top of the item is located at the position.
        /// </summary>
        Top,

        /// <summary>
        /// If the object contains text, the origin is at the baseline of the text, otherwise the origin is at the bottom of the object.
        /// </summary>
        Baseline,
    }
}