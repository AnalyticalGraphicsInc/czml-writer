using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a bounding rectangle.
    /// </summary>
    public interface ICesiumBoundingRectangleValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a bounding rectangle.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteBoundingRectangle(BoundingRectangle value);

        /// <summary>
        /// Writes the value expressed as a bounding rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values);

        /// <summary>
        /// Writes the value expressed as a bounding rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values, int startIndex, int length);
    }
}