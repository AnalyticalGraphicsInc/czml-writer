using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a floating-point number.
    /// </summary>
    public interface ICesiumDoubleValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a floating-point number.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteNumber(double value);

        /// <summary>
        /// Writes the value expressed as a floating-point number.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteNumber(IList<JulianDate> dates, IList<double> values);

        /// <summary>
        /// Writes the value expressed as a floating-point number.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteNumber(IList<JulianDate> dates, IList<double> values, int startIndex, int length);
    }
}