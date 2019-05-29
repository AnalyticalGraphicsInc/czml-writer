using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a two-dimensional Cartesian.
    /// </summary>
    public interface ICesiumCartesian2ValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a two-dimensional Cartesian value.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteCartesian2(Rectangular value);

        /// <summary>
        /// Writes the value expressed as a two-dimensional Cartesian value.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        void WriteCartesian2(double x, double y);

        /// <summary>
        /// Writes the value expressed as a two-dimensional Cartesian value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values);

        /// <summary>
        /// Writes the value expressed as a two-dimensional Cartesian value.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length);
    }
}