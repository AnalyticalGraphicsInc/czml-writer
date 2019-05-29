using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of unit spherical values.
    /// </summary>
    public interface ICesiumUnitSphericalListValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of unit spherical values.
        /// </summary>
        /// <param name="values">The values.</param>
        void WriteUnitSpherical(IEnumerable<UnitSpherical> values);
    }
}