using System;
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
    /// A <topic name="Cesium">Cesium</topic> writer for a property.  The property may be defined over a
    /// single interval or over multiple intervals.
    /// </summary>
    /// <typeparam name="TDerived">The type of the class derived from this one.</typeparam>
    public abstract class CesiumPropertyWriter<TDerived> : CesiumElementWriter, ICesiumPropertyWriter
        where TDerived : CesiumPropertyWriter<TDerived>
    {
        private readonly string m_propertyName;
        private readonly Lazy<CesiumIntervalListWriter<TDerived>> m_multipleIntervals;
        private readonly Lazy<TDerived> m_interval;
        private ElementType m_elementType = ElementType.Property;

        private enum ElementType
        {
            Property,
            Interval,
            PropertyConvertedToInterval
        }

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public CesiumPropertyWriter(string propertyName)
        {
            m_propertyName = propertyName;
            m_multipleIntervals = new Lazy<CesiumIntervalListWriter<TDerived>>(() => new CesiumIntervalListWriter<TDerived>((TDerived)(object)this), false);
            m_interval = new Lazy<TDerived>(() => CopyForInterval(), false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CesiumPropertyWriter(CesiumPropertyWriter<TDerived> existingInstance)
            : this(existingInstance.m_propertyName)
        {
        }

        /// <summary>
        /// Gets the name of the property written by this instance.
        /// </summary>
        public string PropertyName
        {
            get { return m_propertyName; }
        }

        /// <summary>
        /// Gets a value indicating whether this instance represents an open interval.
        /// </summary>
        public bool IsInterval
        {
            get { return m_elementType == ElementType.Interval || m_elementType == ElementType.PropertyConvertedToInterval; }
        }

        /// <summary>
        /// Gets a writer for intervals of this property.  The returned instance must be opened by calling
        /// the <see cref="ICesiumElementWriter.Open"/> method before it can be used for writing.  Consider
        /// calling the <see cref="OpenInterval(JulianDate,JulianDate)"/> or <see cref="OpenMultipleIntervals"/> method, which will automatically
        /// open the writer, instead of accessing this property directly.
        /// </summary>
        public TDerived IntervalWriter
        {
            get { return m_interval.Value; }
        }

        /// <summary>
        /// Copies this instance and returns the copy.
        /// </summary>
        /// <returns>The copy.</returns>
        public abstract TDerived Clone();

        /// <summary>
        /// Opens a writer that is used to write information about this property for a single interval.
        /// </summary>
        /// <returns>The writer.</returns>
        public TDerived OpenInterval()
        {
            TDerived result = OpenAndReturn(m_interval.Value);
            return result;
        }

        /// <summary>
        /// Opens a writer that is used to write information about this property for a single interval.
        /// </summary>
        /// <param name="start">The start of the interval of time covered by this interval element.</param>
        /// <param name="stop">The end of the interval of time covered by this interval element.</param>
        /// <returns>The writer.</returns>
        public TDerived OpenInterval(JulianDate start, JulianDate stop)
        {
            TDerived result = OpenAndReturn(m_interval.Value);
            result.WriteInterval(start, stop);
            return result;
        }

        /// <summary>
        /// Opens a writer that is used to write information about this property for multiple discrete intervals.
        /// </summary>
        /// <returns>The writer.</returns>
        public CesiumIntervalListWriter<TDerived> OpenMultipleIntervals()
        {
            return OpenAndReturn(m_multipleIntervals.Value);
        }

        /// <summary>
        /// Writes the actual interval of time covered by this <topic name="Cesium">Cesium</topic> interval.
        /// </summary>
        /// <param name="start">The first date of the interval.</param>
        /// <param name="stop">The last date of the interval.</param>
        public void WriteInterval(JulianDate start, JulianDate stop)
        {
            WriteInterval(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the actual interval of time covered by this <topic name="Cesium">Cesium</topic> interval.
        /// </summary>
        /// <param name="interval">The interval.</param>
        public void WriteInterval(TimeInterval interval)
        {
            Output.WritePropertyName("interval");
            Output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(interval.Start, interval.Stop));
        }

        /// <inheritdoc />
        protected sealed override void OnOpen()
        {
            if (m_elementType == ElementType.Interval || m_elementType == ElementType.PropertyConvertedToInterval)
                Output.WriteStartObject();
            else
                Output.WritePropertyName(m_propertyName);
        }

        /// <inheritdoc />
        protected sealed override void OnClose()
        {
            if (m_elementType == ElementType.Interval || m_elementType == ElementType.PropertyConvertedToInterval)
            {
                Output.WriteEndObject();
                if (m_elementType == ElementType.PropertyConvertedToInterval)
                    m_elementType = ElementType.Property;
            }
        }

        /// <summary>
        /// Opens an interval for this property if one is not already open.  This method should be called by
        /// derived-class <filter name="DotNet,Silverlight"><code>Open...</code></filter>
        /// <filter name="Java"><code>open...</code></filter> methods prior to opening the nested property.
        /// </summary>
        protected void OpenIntervalIfNecessary()
        {
            if (m_elementType == ElementType.Property)
            {
                m_elementType = ElementType.PropertyConvertedToInterval;
                OnOpen();
            }
        }

        private TDerived CopyForInterval()
        {
            TDerived result = Clone();
            result.m_elementType = ElementType.Interval;
            return result;
        }

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
