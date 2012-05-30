// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>LabelStyle</code> to a <see cref="CesiumOutputStream" />.  A <code>LabelStyle</code> tODO
    /// </summary>
    public class LabelStyleCesiumWriter : CesiumPropertyWriter<LabelStyleCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public LabelStyleCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected LabelStyleCesiumWriter(LabelStyleCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override LabelStyleCesiumWriter Clone()
        {
            return new LabelStyleCesiumWriter(this);
        }

    }
}
