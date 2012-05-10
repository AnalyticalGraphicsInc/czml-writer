using System;
using System.Diagnostics.CodeAnalysis;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// Constants used to translate kml to czml.
    /// </summary>
    public static class Constants
    {
        /// <summary>
        /// The number of radians in a degree.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double RadiansPerDegree = (2 * Math.PI) / 360.0;

        /// <summary>
        /// Default texture size used to scale images.
        /// </summary>
        public static readonly double DefaultTextureSize = 24;
    }
}
