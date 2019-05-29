using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of Cartographic WGS84 coordinates, where Longitude and Latitude are in degrees and Height is in meters.
    /// </summary>
    public interface ICesiumCartographicDegreesListValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a list of Cartographic WGS84 coordinates, where Longitude and Latitude are in degrees and Height is in meters.
        /// </summary>
        /// <param name="values">The values.</param>
        void WriteCartographicDegrees(IEnumerable<Cartographic> values);
    }
}