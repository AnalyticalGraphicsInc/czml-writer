using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as Cartographic WGS84 coordinates, where Longitude and Latitude are in radians and Height is in meters.
    /// </summary>
    public interface ICesiumCartographicRadiansValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value as Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="value">The interval.</param>
        void WriteCartographicRadians(Cartographic value);

        /// <summary>
        /// Writes the value as Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values);

        /// <summary>
        /// Writes the value as Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length);
    }
}