// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Font</code> to a <see cref="CesiumOutputStream" />.  A <code>Font</code> tODO
    /// </summary>
    public class FontCesiumWriter : CesiumPropertyWriter<FontCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public FontCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected FontCesiumWriter(FontCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override FontCesiumWriter Clone()
        {
            return new FontCesiumWriter(this);
        }

    }
}
