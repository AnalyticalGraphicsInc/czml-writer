// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>VerticalOrigin</code> to a <see cref="CesiumOutputStream" />.  A <code>VerticalOrigin</code> is the vertical origin of an element, which can optionally vary over time.  It controls whether the element is bottom-, center-, or top-aligned with the `position`.
    /// </summary>
    public class VerticalOriginCesiumWriter : CesiumPropertyWriter<VerticalOriginCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>verticalOrigin</code> property.
        /// </summary>
        public const string VerticalOriginPropertyName = "verticalOrigin";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>> m_asVerticalOrigin;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public VerticalOriginCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asVerticalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(CreateVerticalOriginAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected VerticalOriginCesiumWriter(VerticalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asVerticalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(CreateVerticalOriginAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override VerticalOriginCesiumWriter Clone()
        {
            return new VerticalOriginCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>verticalOrigin</code>, which is the vertical origin.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public void WriteVerticalOrigin(CesiumVerticalOrigin value)
        {
            const string PropertyName = VerticalOriginPropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(CesiumFormattingHelper.VerticalOriginToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>VerticalOrigin</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumVerticalOrigin> AsVerticalOrigin()
        {
            return m_asVerticalOrigin.Value;
        }

        private ICesiumValuePropertyWriter<CesiumVerticalOrigin> CreateVerticalOriginAdaptor()
        {
            return new CesiumWriterAdaptor<VerticalOriginCesiumWriter, CesiumVerticalOrigin>(this, (me, value) => me.WriteVerticalOrigin(value));
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
            return new CesiumWriterAdaptor<VerticalOriginCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
