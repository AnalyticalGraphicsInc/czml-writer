// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>String</code> to a <see cref="CesiumOutputStream" />.  A <code>String</code> a string value.  The string can optionally vary with time.
    /// </summary>
    public class StringCesiumWriter : CesiumPropertyWriter<StringCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>string</code> property.
        /// </summary>
        public const string StringPropertyName = "string";

        private readonly Lazy<ICesiumValuePropertyWriter<string>> m_asString;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public StringCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asString = new Lazy<ICesiumValuePropertyWriter<string>>(CreateStringAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected StringCesiumWriter(StringCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asString = new Lazy<ICesiumValuePropertyWriter<string>>(CreateStringAdaptor, false);
        }

        /// <inheritdoc />
        public override StringCesiumWriter Clone()
        {
            return new StringCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>string</code> property.  The <code>string</code> property specifies the string value.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteString(string value)
        {
            const string PropertyName = StringPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>String</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<string> AsString()
        {
            return m_asString.Value;
        }

        private ICesiumValuePropertyWriter<string> CreateStringAdaptor()
        {
            return new CesiumWriterAdaptor<StringCesiumWriter, string>(
                this, (me, value) => me.WriteString(value));
        }

    }
}
