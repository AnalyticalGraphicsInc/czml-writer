using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
    /// </summary>
    public interface ICesiumNearFarScalarValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteNearFarScalar(NearFarScalar value);

        /// <summary>
        /// Writes the value expressed as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        void WriteNearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue);

        /// <summary>
        /// Writes the value expressed as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteNearFarScalar(IList<JulianDate> dates, IList<NearFarScalar> values);

        /// <summary>
        /// Writes the value expressed as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteNearFarScalar(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length);
    }
}