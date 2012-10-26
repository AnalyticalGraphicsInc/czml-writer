// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Time</code> to a <see cref="CesiumOutputStream" />.  A <code>Time</code> defines a date and time as an ISO8601 string.
    /// </summary>
    public class TimeCesiumWriter : CesiumPropertyWriter<TimeCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>time</code> property.
        /// </summary>
        public const string TimePropertyName = "time";

        private readonly Lazy<ICesiumValuePropertyWriter<JulianDate>> m_asTime;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public TimeCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asTime = new Lazy<ICesiumValuePropertyWriter<JulianDate>>(CreateTimeAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected TimeCesiumWriter(TimeCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asTime = new Lazy<ICesiumValuePropertyWriter<JulianDate>>(CreateTimeAdaptor, false);
        }

        /// <inheritdoc />
        public override TimeCesiumWriter Clone()
        {
            return new TimeCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>time</code> property.  The <code>time</code> property specifies the value.
        /// </summary>
        /// <param name="value">The time.</param>
        public void WriteTime(JulianDate value)
        {
            const string PropertyName = TimePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteDate(Output, value);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Time</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<JulianDate> AsTime()
        {
            return m_asTime.Value;
        }

        private ICesiumValuePropertyWriter<JulianDate> CreateTimeAdaptor()
        {
            return new CesiumWriterAdaptor<TimeCesiumWriter, JulianDate>(
                this, (me, value) => me.WriteTime(value));
        }

    }
}
