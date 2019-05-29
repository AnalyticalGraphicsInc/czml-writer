using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as an integer.
    /// </summary>
    public interface ICesiumIntegerValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as an integer.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteNumber(int value);

        /// <summary>
        /// Writes the value expressed as an integer.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteNumber(IList<JulianDate> dates, IList<int> values);

        /// <summary>
        /// Writes the value expressed as an integer.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteNumber(IList<JulianDate> dates, IList<int> values, int startIndex, int length);
    }
}