// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>CornerType</code> to a <see cref="CesiumOutputStream" />.  A <code>CornerType</code> is the style of a corner.
    /// </summary>
    public class CornerTypeCesiumWriter : CesiumPropertyWriter<CornerTypeCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>cornerType</code> property.
        /// </summary>
        public const string CornerTypePropertyName = "cornerType";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumCornerType>> m_asCornerType;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CornerTypeCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCornerType = new Lazy<ICesiumValuePropertyWriter<CesiumCornerType>>(CreateCornerTypeAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CornerTypeCesiumWriter(CornerTypeCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asCornerType = new Lazy<ICesiumValuePropertyWriter<CesiumCornerType>>(CreateCornerTypeAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override CornerTypeCesiumWriter Clone()
        {
            return new CornerTypeCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cornerType</code>, which is the corner style.  Valid values are "ROUNDED", "MITERED", and "BEVELED".
        /// </summary>
        /// <param name="value">The style of a corner.</param>
        public void WriteCornerType(CesiumCornerType value)
        {
            const string PropertyName = CornerTypePropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(CesiumFormattingHelper.CornerTypeToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>CornerType</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumCornerType> AsCornerType()
        {
            return m_asCornerType.Value;
        }

        private ICesiumValuePropertyWriter<CesiumCornerType> CreateCornerTypeAdaptor()
        {
            return new CesiumWriterAdaptor<CornerTypeCesiumWriter, CesiumCornerType>(this, (me, value) => me.WriteCornerType(value));
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
            return new CesiumWriterAdaptor<CornerTypeCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
