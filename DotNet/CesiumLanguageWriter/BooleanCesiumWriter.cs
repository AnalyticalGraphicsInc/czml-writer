// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Boolean</code> to a <see cref="CesiumOutputStream" />.  A <code>Boolean</code> a boolean value.
    /// </summary>
    public class BooleanCesiumWriter : CesiumValuePropertyWriter<bool, BooleanCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>boolean</code> property.
        /// </summary>
        public const string BooleanPropertyName = "boolean";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public BooleanCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected BooleanCesiumWriter(BooleanCesiumWriter existingInstance)
            : base(existingInstance)
        {
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
        public override void WriteValue(bool value)
        {
            const string PropertyName = BooleanPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

    }
}
