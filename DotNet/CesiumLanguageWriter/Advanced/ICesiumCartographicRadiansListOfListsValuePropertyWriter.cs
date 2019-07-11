using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of lists of Cartographic WGS84 coordinates, where Longitude and Latitude are in radians and Height is in meters.
    /// </summary>
    public interface ICesiumCartographicRadiansListOfListsValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a list of lists of Cartographic WGS84 coordinates, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="values">The values.</param>
        [CSToJavaUseWildcardGenerics]
        void WriteCartographicRadians(IEnumerable<IEnumerable<Cartographic>> values);
    }
}