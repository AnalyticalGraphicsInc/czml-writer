// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>HorizontalOrigin</code> to a <see cref="CesiumOutputStream" />.  A <code>HorizontalOrigin</code> defines the horizontal origin of an element, which can optionally vary over time.  It controls whether the element is left-, center-, or right-aligned with the `position`.
    /// </summary>
    public class HorizontalOriginCesiumWriter : CesiumPropertyWriter<HorizontalOriginCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public HorizontalOriginCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asHorizontalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(CreateHorizontalOriginAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected HorizontalOriginCesiumWriter(HorizontalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asHorizontalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(CreateHorizontalOriginAdaptor, false);
        }

        /// <inheritdoc />
        public override HorizontalOriginCesiumWriter Clone()
        {
            return new HorizontalOriginCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property specifies the horizontal origin.  Valid values are "LEFT", "CENTER", and "RIGHT".
        /// </summary>
        /// <param name="value">The horizontal origin.</param>
        public void WriteHorizontalOrigin(CesiumHorizontalOrigin value)
        {
            const string PropertyName = HorizontalOriginPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.HorizontalOriginToString(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>HorizontalOrigin</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumHorizontalOrigin> AsHorizontalOrigin()
        {
            return m_asHorizontalOrigin.Value;
        }

        private ICesiumValuePropertyWriter<CesiumHorizontalOrigin> CreateHorizontalOriginAdaptor()
        {
            return new CesiumWriterAdaptor<HorizontalOriginCesiumWriter, CesiumHorizontalOrigin>(
                this, (me, value) => me.WriteHorizontalOrigin(value));
        }

    }
}
