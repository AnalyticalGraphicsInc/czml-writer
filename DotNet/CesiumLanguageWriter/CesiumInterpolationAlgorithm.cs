namespace CesiumLanguageWriter
{
    /// <summary>
    /// The algorithm to use to interpolation sampled data.
    /// </summary>
    public enum CesiumInterpolationAlgorithm
    {
        /// <summary>
        /// Simple linear interpolation between two samples.
        /// </summary>
        Linear,

        /// <summary>
        /// Lagrange polynomial approximation.
        /// </summary>
        Lagrange,

        /// <summary>
        /// Hermite polynomial approximation.
        /// </summary>
        Hermite,
    }
}
