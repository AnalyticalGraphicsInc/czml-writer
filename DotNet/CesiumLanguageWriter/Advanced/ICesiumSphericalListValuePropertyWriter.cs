using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of spherical values.
    /// </summary>
    public interface ICesiumSphericalListValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of spherical values.
        /// </summary>
        /// <param name="values">The values.</param>
        void WriteSpherical(IEnumerable<Spherical> values);
    }
}