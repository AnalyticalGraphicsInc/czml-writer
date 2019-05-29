using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a spherical.
    /// </summary>
    public interface ICesiumSphericalValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value as a spherical value <c>[Clock, Cone, Magnitude]</c>. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteSpherical(Spherical value);

        /// <summary>
        /// Writes the value as a spherical value <c>[Clock, Cone, Magnitude]</c>. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values);

        /// <summary>
        /// Writes the value as a spherical value <c>[Clock, Cone, Magnitude]</c>. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values, int startIndex, int length);
    }
}