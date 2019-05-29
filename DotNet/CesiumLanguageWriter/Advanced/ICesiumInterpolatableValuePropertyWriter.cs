using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// An interface to a property that writes a sampled, interpolatable value.
    /// </summary>
    /// <typeparam name="TValue">The type of the value.</typeparam>
    public interface ICesiumInterpolatableValuePropertyWriter<TValue> : ICesiumValuePropertyWriter<TValue>, ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes time-tagged samples for this property.  Clients will interpolate over the samples
        /// to determine the property value at a given time.  The <paramref name="dates"/> need not all
        /// fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>, because having samples
        /// outside the interval is often useful for interpolation.  However, the samples within an interval
        /// will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="dates">The dates of the samples.  This collection must have the same number of elements as the <paramref name="values"/> collection.</param>
        /// <param name="values">The values corresponding to the <paramref name="dates"/>.  This collection must have the same number of elements as the <paramref name="dates"/> collection.</param>
        /// <param name="startIndex">The first index in the collections to write.</param>
        /// <param name="length">The number of elements from the collections to write.</param>
        void WriteValue(IList<JulianDate> dates, IList<TValue> values, int startIndex, int length);
    }
}