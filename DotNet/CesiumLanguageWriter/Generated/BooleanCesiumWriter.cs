// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Boolean</code> to a <see cref="CesiumOutputStream" />.  A <code>Boolean</code> a boolean value.
    /// </summary>
    public class BooleanCesiumWriter : CesiumPropertyWriter<BooleanCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>boolean</code> property.
        /// </summary>
        public const string BooleanPropertyName = "boolean";

        private readonly Lazy<ICesiumValuePropertyWriter<bool>> m_asBoolean;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public BooleanCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asBoolean = new Lazy<ICesiumValuePropertyWriter<bool>>(CreateBooleanAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected BooleanCesiumWriter(BooleanCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asBoolean = new Lazy<ICesiumValuePropertyWriter<bool>>(CreateBooleanAdaptor, false);
        }

        /// <inheritdoc />
        public override BooleanCesiumWriter Clone()
        {
            return new BooleanCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>boolean</code> property.  The <code>boolean</code> property specifies the boolean value.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBoolean(bool value)
        {
            const string PropertyName = BooleanPropertyName;
            if (ForceInterval)
                OpenIntervalIfNecessary();
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Boolean</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<bool> AsBoolean()
        {
            return m_asBoolean.Value;
        }

        private ICesiumValuePropertyWriter<bool> CreateBooleanAdaptor()
        {
            return new CesiumWriterAdaptor<BooleanCesiumWriter, bool>(
                this, (me, value) => me.WriteBoolean(value));
        }

    }
}
