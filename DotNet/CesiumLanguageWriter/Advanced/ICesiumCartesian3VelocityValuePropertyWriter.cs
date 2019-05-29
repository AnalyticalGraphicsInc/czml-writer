using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a three-dimensional Cartesian value and its derivative.
    /// </summary>
    public interface ICesiumCartesian3VelocityValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value as a three-dimensional Cartesian value and its derivative.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteCartesianVelocity(Motion<Cartesian> value);

        /// <summary>
        /// Writes the value as a three-dimensional Cartesian value and its derivative.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values);

        /// <summary>
        /// Writes the value as a three-dimensional Cartesian value and its derivative.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values, int startIndex, int length);
    }
}