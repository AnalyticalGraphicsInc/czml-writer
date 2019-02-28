namespace CesiumLanguageWriter
{
    /// <summary>
    /// Specifies the type of an arc.
    /// </summary>
    public enum CesiumArcType
    {
        /// <summary>
        /// The arc is a straight line that does not conform to the surface of an ellipsoid.
        /// </summary>
        None,

        /// <summary>
        /// The arc is a geodesic, which is the shortest path conforming to the surface of an ellipsoid.
        /// </summary>
        Geodesic,

        /// <summary>
        /// The arc is a rhumb line, or loxodrome, which is the path of constant heading conforming to the surface of an ellipsoid.
        /// </summary>
        Rhumb,
    }
}