// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>String</code> to a <see cref="CesiumOutputStream" />.  A <code>String</code> a string value.  The string can optionally vary with time.
    /// </summary>
    public class StringCesiumWriter : CesiumValuePropertyWriter<String, StringCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>string</code> property.
        /// </summary>
        public const string StringPropertyName = "string";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public StringCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected StringCesiumWriter(StringCesiumWriter existingInstance)
            : base(existingInstance)
        {
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
        public override void WriteValue(String value)
        {
            const string PropertyName = StringPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

    }
}
