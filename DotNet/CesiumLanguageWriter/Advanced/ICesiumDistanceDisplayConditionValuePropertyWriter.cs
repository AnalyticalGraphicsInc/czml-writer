using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as two values <c>[NearDistance, FarDistance]</c>.
    /// </summary>
    public interface ICesiumDistanceDisplayConditionValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value as two values <c>[NearDistance, FarDistance]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteDistanceDisplayCondition(Bounds value);

        /// <summary>
        /// Writes the value as two values <c>[NearDistance, FarDistance]</c>.
        /// </summary>
        /// <param name="lowerBound">The lower bound.</param>
        /// <param name="upperBound">The upper bound.</param>
        void WriteDistanceDisplayCondition(double lowerBound, double upperBound);

        /// <summary>
        /// Writes the value as two values <c>[NearDistance, FarDistance]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteDistanceDisplayCondition(IList<JulianDate> dates, IList<Bounds> values);

        /// <summary>
        /// Writes the value as two values <c>[NearDistance, FarDistance]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteDistanceDisplayCondition(IList<JulianDate> dates, IList<Bounds> values, int startIndex, int length);
    }
}