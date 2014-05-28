// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Double</code> to a <see cref="CesiumOutputStream" />.  A <code>Double</code> a floating-point value.
    /// </summary>
    public class DoubleCesiumWriter : CesiumInterpolatablePropertyWriter<DoubleCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>number</code> property.
        /// </summary>
        public const string NumberPropertyName = "number";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<double>> m_asNumber;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public DoubleCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asNumber = new Lazy<ICesiumInterpolatableValuePropertyWriter<double>>(CreateNumberAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected DoubleCesiumWriter(DoubleCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asNumber = new Lazy<ICesiumInterpolatableValuePropertyWriter<double>>(CreateNumberAdaptor, false);
        }

        /// <inheritdoc />
        public override DoubleCesiumWriter Clone()
        {
            return new DoubleCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point value. The value may be a single number, in which case the value is constant over the interval, or it may be an array.  If it is an array and the array has one element, the value is constant over the interval. If it has two or more elements, they are time-tagged samples arranged as [Time, Value, Time, Value, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteNumber(double value)
        {
            const string PropertyName = NumberPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point value. The value may be a single number, in which case the value is constant over the interval, or it may be an array.  If it is an array and the array has one element, the value is constant over the interval. If it has two or more elements, they are time-tagged samples arranged as [Time, Value, Time, Value, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteNumber(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            const string PropertyName = NumberPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteDouble(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReference(Reference value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteReference(string value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="id">The earliest date of the interval.</param>
        /// <param name="propertyName">The latest date of the interval.</param>
        public void WriteReference(string id, string propertyName)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, id, propertyName);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="id">The earliest date of the interval.</param>
        /// <param name="propertyNames">The latest date of the interval.</param>
        public void WriteReference(string id, string[] propertyNames)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, id, propertyNames);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Number</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<double> AsNumber()
        {
            return m_asNumber.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<double> CreateNumberAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<DoubleCesiumWriter, double>(
                this, (me, value) => me.WriteNumber(value), (DoubleCesiumWriter me, IList<JulianDate> dates, IList<double> values, int startIndex, int length) => me.WriteNumber(dates, values, startIndex, length));
        }

    }
}
