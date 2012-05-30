// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>HorizontalOrigin</code> to a <see cref="CesiumOutputStream" />.  A <code>HorizontalOrigin</code> defines the horizontal origin of an element, which can optionally vary over time.  It controls whether the element is left-, center-, or right-aligned with the `position`.
    /// </summary>
    public class HorizontalOriginCesiumWriter : CesiumValuePropertyWriter<CesiumHorizontalOrigin, HorizontalOriginCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public HorizontalOriginCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected HorizontalOriginCesiumWriter(HorizontalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
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
        public override void WriteValue(CesiumHorizontalOrigin value)
        {
            const string PropertyName = HorizontalOriginPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.HorizontalOriginToString(value));
        }

    }
}
