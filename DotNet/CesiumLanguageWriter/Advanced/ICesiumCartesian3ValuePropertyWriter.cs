using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a three-dimensional Cartesian.
    /// </summary>
    public interface ICesiumCartesian3ValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a three-dimensional Cartesian value.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteCartesian(Cartesian value);

        /// <summary>
        /// Writes the value expressed as a three-dimensional Cartesian value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values);

        /// <summary>
        /// Writes the value expressed as a three-dimensional Cartesian value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length);
    }
}