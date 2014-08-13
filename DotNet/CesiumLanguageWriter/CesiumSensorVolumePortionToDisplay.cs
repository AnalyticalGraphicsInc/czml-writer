namespace CesiumLanguageWriter
{
    /// <summary>
    /// Specifies what part of a CZML sensor should be displayed.
    /// </summary>
    public enum CesiumSensorVolumePortionToDisplay
    {
        /// <summary>
        /// The entire sensor projection is shown.
        /// </summary>
        Complete,

        /// <summary>
        /// Only the part of the sensor projection below the ellipsoid horizon is shown.
        /// </summary>
        BelowEllipsoidHorizon,

        /// <summary>
        /// Only the part of the sensor projection above the ellipsoid horizon is shown.
        /// </summary>
        AboveEllipsoidHorizon
    }
}