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
        /// The name of the <code>value</code> property.
        /// </summary>
        public const string ValuePropertyName = "value";

        /// <summary>
        /// The name of the <code>values</code> property.
        /// </summary>
        public const string ValuesPropertyName = "values";

        private readonly Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asValue;
        private readonly Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asValues;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public TimeIntervalCollectionCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asValue = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateValueAdaptor, false);
            m_asValues = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateValuesAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected TimeIntervalCollectionCesiumWriter(TimeIntervalCollectionCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asValue = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateValueAdaptor, false);
            m_asValues = new Lazy<ICesiumValuePropertyWriter<TimeInterval>>(CreateValuesAdaptor, false);
        }

        /// <inheritdoc />
        public override TimeIntervalCollectionCesiumWriter Clone()
        {
            return new TimeIntervalCollectionCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>value</code> property.  The <code>value</code> property specifies a single time interval.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteValue(TimeInterval value)
        {
            const string PropertyName = ValuePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeInterval(Output, value);
        }

        /// <summary>
        /// Writes the <code>value</code> property.  The <code>value</code> property specifies a single time interval.
        /// </summary>
        /// <param name="start">The earliest date of the interval.</param>
        /// <param name="stop">The latest date of the interval.</param>
        public void WriteValue(JulianDate start, JulianDate stop)
        {
            WriteValue(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the <code>values</code> property.  The <code>values</code> property specifies an array of time intervals.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteValues(TimeInterval value)
        {
            const string PropertyName = ValuesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeInterval(Output, value);
        }

        /// <summary>
        /// Writes the <code>values</code> property.  The <code>values</code> property specifies an array of time intervals.
        /// </summary>
        /// <param name="start">The earliest date of the interval.</param>
        /// <param name="stop">The latest date of the interval.</param>
        public void WriteValues(JulianDate start, JulianDate stop)
        {
            WriteValues(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the <code>values</code> property.  The <code>values</code> property specifies an array of time intervals.
        /// </summary>
        /// <param name="value">The intervals.</param>
        public void WriteValues(IList<TimeInterval> value)
        {
            const string PropertyName = ValuesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeIntervalCollection(Output, value);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Value</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<TimeInterval> AsValue()
        {
            return m_asValue.Value;
        }

        private ICesiumValuePropertyWriter<TimeInterval> CreateValueAdaptor()
        {
            return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(
                this, (me, value) => me.WriteValue(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Values</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<TimeInterval> AsValues()
        {
            return m_asValues.Value;
        }

        private ICesiumValuePropertyWriter<TimeInterval> CreateValuesAdaptor()
        {
            return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(
                this, (me, value) => me.WriteValues(value));
        }

    }
}
