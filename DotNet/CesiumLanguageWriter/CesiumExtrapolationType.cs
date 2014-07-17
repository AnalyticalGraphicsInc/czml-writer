namespace CesiumLanguageWriter
{
    /// <summary>
    /// The type of extrapolation to perform when outside the sample data range of an interpolatable property.
    /// </summary>
    public enum CesiumExtrapolationType
    {
        /// <summary>
        /// No extrpolation is performed; the property is undefined.
        /// </summary>
        None,

        /// <summary>
        /// Return the first or last sample value.
        /// </summary>
        Hold,

        /// <summary>
        /// Extrapolate the value.
        /// </summary>
        Extrapolate,
    }
}
