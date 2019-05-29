using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of double values.
    /// </summary>
    public interface ICesiumDoubleListValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of double values.
        /// </summary>
        /// <param name="values">The values.</param>
        void WriteArray(IEnumerable<double> values);
    }
}