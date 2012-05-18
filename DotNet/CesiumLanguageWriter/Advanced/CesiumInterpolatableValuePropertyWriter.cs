using System.Collections.Generic;
#if StkComponents
using AGI.Foundation.Time;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// A <topic name="Cesium">Cesium</topic> writer for a property that represents a value that may be sampled
    /// and interpolated.  The property may be defined over a single interval or over multiple intervals.
    /// </summary>
    /// <typeparam name="TValue">
    /// The type of the value held by this property.  If the property's value can be multiple types, this
    /// should be the most common one.
    /// </typeparam>
    /// <typeparam name="TDerived">The type of the class derived from this one.</typeparam>
    public abstract class CesiumInterpolatableValuePropertyWriter<TValue, TDerived> :
        CesiumValuePropertyWriter<TValue, TDerived>,
        ICesiumInterpolatableValuePropertyWriter<TValue>
            where TDerived : CesiumPropertyWriter<TDerived>, ICesiumValuePropertyWriter<TValue>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        protected CesiumInterpolatableValuePropertyWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CesiumInterpolatableValuePropertyWriter(CesiumInterpolatableValuePropertyWriter<TValue, TDerived> existingInstance)
            : base(existingInstance)
        {
        }

        /// <summary>
        /// Writes the interpolation algorithm to use to interpolate the sampled data in this interval.
        /// </summary>
        /// <param name="interpolationAlgorithm">The interpolation algorithm.</param>
        public void WriteInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("interpolationAlgorithm");
            Output.WriteValue(CesiumFormattingHelper.InterpolationAlgorithmToString(interpolationAlgorithm));
        }

        /// <summary>
        /// Writes the degree of polynomial to use to interpolate sampled data in this interval.
        /// </summary>
        /// <param name="degree">The degree.</param>
        public void WriteInterpolationDegree(int degree)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("interpolationDegree");
            Output.WriteValue(degree);
        }

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
        public abstract void WriteValue(IList<JulianDate> dates, IList<TValue> values, int startIndex, int length);

        /// <summary>
        /// Gets an appropriate epoch from a list of dates and writes it to the <see cref="CesiumOutputStream"/>
        /// as the "epoch" property.  If the <paramref name="dates"/> collection is empty, the <paramref name="startIndex"/>
        /// is past the end of the collection, or the <paramref name="length"/> is zero, this method does not write
        /// the "epoch" property and returns <see cref="JulianDate.MinValue"/>.
        /// </summary>
        /// <param name="dates">The collection of dates from which to determine the epoch.</param>
        /// <param name="startIndex">The first index in the collection to use.</param>
        /// <param name="length">The number of items from the collection to use.</param>
        /// <returns>A suitable epoch determined from the collection.</returns>
        protected JulianDate GetAndWriteEpoch(IList<JulianDate> dates, int startIndex, int length)
        {
            OpenIntervalIfNecessary();

            if (startIndex < dates.Count)
            {
                JulianDate epoch = dates[startIndex];
                Output.WritePropertyName("epoch");
                Output.WriteValue(CesiumFormattingHelper.ToIso8601(epoch, Output.PrettyFormatting ? Iso8601Format.Extended : Iso8601Format.Compact));
                return epoch;
            }
            else
            {
                return JulianDate.MinValue;
            }
        }
    }
}
