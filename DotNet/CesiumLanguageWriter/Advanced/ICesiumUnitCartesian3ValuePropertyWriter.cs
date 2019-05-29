using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a three-dimensional unit magnitude Cartesian.
    /// </summary>
    public interface ICesiumUnitCartesian3ValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a three-dimensional unit magnitude Cartesian value.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteUnitCartesian(UnitCartesian value);

        /// <summary>
        /// Writes the value expressed as a three-dimensional unit magnitude Cartesian value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values);

        /// <summary>
        /// Writes the value expressed as a three-dimensional unit magnitude Cartesian value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values, int startIndex, int length);
    }
}