using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Diagnostics.CodeAnalysis;

namespace KmlToCesiumLanguage
{
    public static class Constants
    {
        /// <summary>
        /// The number of radians in a degree.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double RadiansPerDegree = (2 * Math.PI) / 360.0;
    }
}
