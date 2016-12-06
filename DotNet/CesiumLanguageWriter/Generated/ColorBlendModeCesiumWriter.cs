// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>ColorBlendMode</c> to a <see cref="CesiumOutputStream" />.  A <c>ColorBlendMode</c> is defines different modes for blending between a target color and an entity's source color.
    /// </summary>
    public class ColorBlendModeCesiumWriter : CesiumPropertyWriter<ColorBlendModeCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>colorBlendMode</c> property.
        /// </summary>
        public const string ColorBlendModePropertyName = "colorBlendMode";

        /// <summary>
        /// The name of the <c>reference</c> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>> m_asColorBlendMode;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ColorBlendModeCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asColorBlendMode = new Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>>(CreateColorBlendModeAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected ColorBlendModeCesiumWriter(ColorBlendModeCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asColorBlendMode = new Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>>(CreateColorBlendModeAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override ColorBlendModeCesiumWriter Clone()
        {
            return new ColorBlendModeCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>colorBlendMode</c>, which is the color blend mode.
        /// </summary>
        /// <param name="value">The blend mode.</param>
        public void WriteColorBlendMode(CesiumColorBlendMode value)
        {
            const string PropertyName = ColorBlendModePropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(CesiumFormattingHelper.ColorBlendModeToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the color blend mode specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the color blend mode specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the color blend mode specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the color blend mode specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>ColorBlendMode</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumColorBlendMode> AsColorBlendMode()
        {
            return m_asColorBlendMode.Value;
        }

        private ICesiumValuePropertyWriter<CesiumColorBlendMode> CreateColorBlendModeAdaptor()
        {
            return new CesiumWriterAdaptor<ColorBlendModeCesiumWriter, CesiumColorBlendMode>(this, (me, value) => me.WriteColorBlendMode(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Reference</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<Reference> AsReference()
        {
            return m_asReference.Value;
        }

        private ICesiumValuePropertyWriter<Reference> CreateReferenceAdaptor()
        {
            return new CesiumWriterAdaptor<ColorBlendModeCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
