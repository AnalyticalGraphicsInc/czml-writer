using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of two-dimensional Cartesian values.
    /// </summary>
    public interface ICesiumCartesian2ListValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of two-dimensional Cartesian values.
        /// </summary>
        /// <param name="values">The values.</param>
        void WriteCartesian2(IEnumerable<Rectangular> values);
    }
}