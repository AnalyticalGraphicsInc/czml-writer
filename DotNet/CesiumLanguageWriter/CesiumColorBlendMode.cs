namespace CesiumLanguageWriter
{
    /// <summary>
    /// The mode to use when blending between a target color and an entity's source color.
    /// </summary>
    public enum CesiumColorBlendMode
    {
        /// <summary>
        /// Multiplies the source color by the target color.
        /// </summary>
        Highlight,

        /// <summary>
        /// Replaces the source color with the target color.
        /// </summary>
        Replace,

        /// <summary>
        /// Blends the source color and target color together.
        /// </summary>
        Mix,
    }
}