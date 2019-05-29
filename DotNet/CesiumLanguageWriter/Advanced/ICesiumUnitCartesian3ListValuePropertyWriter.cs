using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of three-dimensional unit magnitude Cartesian values.
    /// </summary>
    public interface ICesiumUnitCartesian3ListValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of three-dimensional unit magnitude Cartesian values.
        /// </summary>
        /// <param name="values">The values.</param>
        void WriteUnitCartesian(IEnumerable<UnitCartesian> values);
    }
}