using System;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A CZML writer for a property.  The property may be defined over a
    /// single interval or over multiple intervals.
    /// </summary>
    /// <typeparam name="TDerived">The type of the class derived from this one.</typeparam>
    public abstract class CesiumPropertyWriter<TDerived> : CesiumElementWriter, ICesiumPropertyWriter
        where TDerived : CesiumPropertyWriter<TDerived>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        protected CesiumPropertyWriter([NotNull] string propertyName)
            : this()
        {
            if (propertyName == null)
                throw new ArgumentNullException("propertyName");

            m_propertyName = propertyName;
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CesiumPropertyWriter([NotNull] CesiumPropertyWriter<TDerived> existingInstance)
            : this()
        {
            if (existingInstance == null)
                throw new ArgumentNullException("existingInstance");

            m_propertyName = existingInstance.m_propertyName;
        }

        private CesiumPropertyWriter()
        {
            m_multipleIntervals = new Lazy<CesiumIntervalListWriter<TDerived>>(CreateIntervalListWriter, false);
            m_interval = new Lazy<TDerived>(CopyForInterval, false);
        }

        /// <summary>
        /// Copies this instance and returns the copy.
        /// </summary>
        /// <returns>The copy.</returns>
        [NotNull]
        public abstract TDerived Clone();

        [NotNull]
        private CesiumIntervalListWriter<TDerived> CreateIntervalListWriter()
        {
            return new CesiumIntervalListWriter<TDerived>((TDerived)this);
        }

        /// <summary>
        /// Gets the name of the property written by this instance.
        /// </summary>
        [NotNull]
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
        /// Gets or sets a value indicating whether this instance should always open an interval.
        /// </summary>
        public bool ForceInterval { get; set; }

        /// <summary>
        /// Opens a writer that is used to write information about this property for a single interval.
        /// </summary>
        /// <returns>The writer.</returns>
        [NotNull]
        public TDerived OpenInterval()
        {
            return OpenAndReturn(m_interval.Value);
        }

        /// <summary>
        /// Opens a writer that is used to write information about this property for a single interval.
        /// </summary>
        /// <param name="start">The start of the interval of time covered by this interval element.</param>
        /// <param name="stop">The end of the interval of time covered by this interval element.</param>
        /// <returns>The writer.</returns>
        [NotNull]
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
        [NotNull]
        public CesiumIntervalListWriter<TDerived> OpenMultipleIntervals()
        {
            return OpenAndReturn(m_multipleIntervals.Value);
        }

        /// <summary>
        /// Writes the actual interval of time covered by this CZML interval.
        /// </summary>
        /// <param name="start">The first date of the interval.</param>
        /// <param name="stop">The last date of the interval.</param>
        public void WriteInterval(JulianDate start, JulianDate stop)
        {
            WriteInterval(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the actual interval of time covered by this CZML interval.
        /// </summary>
        /// <param name="interval">The interval.</param>
        public void WriteInterval([NotNull] TimeInterval interval)
        {
            if (interval == null)
                throw new ArgumentNullException("interval");

            OpenIntervalIfNecessary();
            Output.WritePropertyName("interval");
            Output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(interval.Start, interval.Stop, Output.PrettyFormatting ? Iso8601Format.Extended : Iso8601Format.Compact));
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
        /// Opens an interval for this property if one is not already open.
        /// </summary>
        protected void OpenIntervalIfNecessary()
        {
            if (m_elementType == ElementType.Property)
            {
                m_elementType = ElementType.PropertyConvertedToInterval;
                OnOpen();
            }
        }

        [NotNull]
        private TDerived CopyForInterval()
        {
            TDerived result = Clone();

            CesiumPropertyWriter<TDerived> cesiumPropertyWriter = result;
            cesiumPropertyWriter.m_elementType = ElementType.Interval;

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

        [NotNull]
        private readonly string m_propertyName;
        [NotNull]
        private readonly Lazy<CesiumIntervalListWriter<TDerived>> m_multipleIntervals;
        [NotNull]
        private readonly Lazy<TDerived> m_interval;
        private ElementType m_elementType = ElementType.Property;

        private enum ElementType
        {
            Property,
            Interval,
            PropertyConvertedToInterval
        }
    }
}