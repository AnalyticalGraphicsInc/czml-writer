
#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// A <topic name="Cesium">Cesium</topic> writer for a property that represents a value.  The property may be
    /// defined over a single interval or over multiple intervals.
    /// </summary>
    /// <typeparam name="TValue">
    /// The type of the value held by this property.  If the property's value can be multiple types, this
    /// should be the most common one.
    /// </typeparam>
    /// <typeparam name="TDerived">The type of the class derived from this one.</typeparam>
    public abstract class CesiumValuePropertyWriter<TValue, TDerived> : CesiumPropertyWriter<TDerived>, ICesiumValuePropertyWriter<TValue>
        where TDerived : CesiumPropertyWriter<TDerived>, ICesiumValuePropertyWriter<TValue>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        protected CesiumValuePropertyWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CesiumValuePropertyWriter(CesiumValuePropertyWriter<TValue, TDerived> existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public abstract void WriteValue(TValue value);

        ICesiumPropertyWriter ICesiumPropertyWriter.OpenInterval()
        {
            return OpenInterval();
        }

        ICesiumIntervalListWriter ICesiumPropertyWriter.OpenMultipleIntervals()
        {
            return OpenMultipleIntervals();
        }

        ICesiumPropertyWriter ICesiumPropertyWriter.IntervalWriter
        {
            get { return IntervalWriter; }
        }
    }
}
