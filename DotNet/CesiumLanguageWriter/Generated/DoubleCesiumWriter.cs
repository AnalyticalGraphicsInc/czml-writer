// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Double</code> to a <see cref="CesiumOutputStream" />.  A <code>Double</code> is a floating-point number.
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
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public DoubleCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asNumber = new Lazy<ICesiumInterpolatableValuePropertyWriter<double>>(CreateNumberAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected DoubleCesiumWriter(DoubleCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asNumber = new Lazy<ICesiumInterpolatableValuePropertyWriter<double>>(CreateNumberAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override DoubleCesiumWriter Clone()
        {
            return new DoubleCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>number</code>, which is the number.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteNumber(double value)
        {
            const string PropertyName = NumberPropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>number</code>, which is the number.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteNumber(IList<JulianDate> dates, IList<double> values)
        {
            WriteNumber(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>number</code>, which is the number.
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
        /// Writes the value expressed as a <code>reference</code>, which is the number specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the number specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the number specified as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteReference(string identifier, string propertyName)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyName);
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the number specified as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteReference(string identifier, string[] propertyNames)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyNames);
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
            return new CesiumInterpolatableWriterAdaptor<DoubleCesiumWriter, double>(this, (me, value) => me.WriteNumber(value), (me, dates, values, startIndex, length) => me.WriteNumber(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Reference</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<Reference> AsReference()
        {
            return m_asReference.Value;
        }

        private ICesiumValuePropertyWriter<Reference> CreateReferenceAdaptor()
        {
            return new CesiumWriterAdaptor<DoubleCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
