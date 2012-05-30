// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>VerticalOrigin</code> to a <see cref="CesiumOutputStream" />.  A <code>VerticalOrigin</code> defines the vertical origin of an element, which can optionally vary over time.  It controls whether the element is bottom-, center-, or top-aligned with the `position`.
    /// </summary>
    public class VerticalOriginCesiumWriter : CesiumValuePropertyWriter<CesiumVerticalOrigin, VerticalOriginCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>verticalOrigin</code> property.
        /// </summary>
        public const string VerticalOriginPropertyName = "verticalOrigin";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public VerticalOriginCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected VerticalOriginCesiumWriter(VerticalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override VerticalOriginCesiumWriter Clone()
        {
            return new VerticalOriginCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property specifies the vertical origin.  Valid values are "BOTTOM", "CENTER", and "TOP".
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public override void WriteValue(CesiumVerticalOrigin value)
        {
            const string PropertyName = VerticalOriginPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.VerticalOriginToString(value));
        }

    }
}
