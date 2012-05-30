// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Label</code> to a <see cref="CesiumOutputStream" />.  A <code>Label</code> tODO
    /// </summary>
    public class LabelCesiumWriter : CesiumPropertyWriter<LabelCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public LabelCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected LabelCesiumWriter(LabelCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override LabelCesiumWriter Clone()
        {
            return new LabelCesiumWriter(this);
        }

    }
}
