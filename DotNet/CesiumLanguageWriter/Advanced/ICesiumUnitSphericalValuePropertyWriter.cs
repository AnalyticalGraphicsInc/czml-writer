using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a unit spherical.
    /// </summary>
    public interface ICesiumUnitSphericalValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a unit spherical value.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteUnitSpherical(UnitSpherical value);

        /// <summary>
        /// Writes the value expressed as a unit spherical value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values);

        /// <summary>
        /// Writes the value expressed as a unit spherical value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values, int startIndex, int length);
    }
}