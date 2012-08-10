// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>TimeIntervalCollection</code> to a <see cref="CesiumOutputStream" />.  A <code>TimeIntervalCollection</code> a collection of intervals of time.
    /// </summary>
    public class TimeIntervalCollectionCesiumWriter : CesiumPropertyWriter<TimeIntervalCollectionCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>segmentInterval</code> property.
        /// </summary>
        public const string SegmentIntervalPropertyName = "segmentInterval";

        /// <summary>
        /// The name of the <code>segmentIntervals</code> property.
        /// </summary>
        public const string SegmentIntervalsPropertyName = "segmentIntervals";

        private readonly Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asSegmentInterval;
        private readonly Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asSegmentIntervals;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public TimeIntervalCollectionCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asSegmentInterval = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateSegmentIntervalAdaptor, false);
            m_asSegmentIntervals = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateSegmentIntervalsAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected TimeIntervalCollectionCesiumWriter(TimeIntervalCollectionCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asSegmentInterval = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateSegmentIntervalAdaptor, false);
            m_asSegmentIntervals = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateSegmentIntervalsAdaptor, false);
        }

        /// <inheritdoc />
        public override TimeIntervalCollectionCesiumWriter Clone()
        {
            return new TimeIntervalCollectionCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>segmentInterval</code> property.  The <code>segmentInterval</code> property specifies the interval value.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteSegmentInterval(TimeInterval value)
        {
            const string PropertyName = SegmentIntervalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeInterval(Output, value);
        }

        /// <summary>
        /// Writes the <code>segmentInterval</code> property.  The <code>segmentInterval</code> property specifies the interval value.
        /// </summary>
        /// <param name="start">The earliest date of the interval.</param>
        /// <param name="stop">The latest date of the interval.</param>
        public void WriteSegmentInterval(JulianDate start, JulianDate stop)
        {
            WriteSegmentInterval(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the <code>segmentIntervals</code> property.  The <code>segmentIntervals</code> property specifies the intervals value.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteSegmentIntervals(TimeInterval value)
        {
            const string PropertyName = SegmentIntervalsPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeInterval(Output, value);
        }

        /// <summary>
        /// Writes the <code>segmentIntervals</code> property.  The <code>segmentIntervals</code> property specifies the intervals value.
        /// </summary>
        /// <param name="start">The earliest date of the interval.</param>
        /// <param name="stop">The latest date of the interval.</param>
        public void WriteSegmentIntervals(JulianDate start, JulianDate stop)
        {
            WriteSegmentIntervals(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the <code>segmentIntervals</code> property.  The <code>segmentIntervals</code> property specifies the intervals value.
        /// </summary>
        /// <param name="value">The intervals.</param>
        public void WriteSegmentIntervals(IList<TimeInterval> value)
        {
            const string PropertyName = SegmentIntervalsPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeIntervalCollection(Output, value);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>SegmentInterval</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<TimeInterval> AsSegmentInterval()
        {
            return m_asSegmentInterval.Value;
        }

        private ICesiumValuePropertyWriter<TimeInterval> CreateSegmentIntervalAdaptor()
        {
            return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(
                this, (me, value) => me.WriteSegmentInterval(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>SegmentIntervals</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<TimeInterval> AsSegmentIntervals()
        {
            return m_asSegmentIntervals.Value;
        }

        private ICesiumValuePropertyWriter<TimeInterval> CreateSegmentIntervalsAdaptor()
        {
            return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(
                this, (me, value) => me.WriteSegmentIntervals(value));
        }

    }
}
