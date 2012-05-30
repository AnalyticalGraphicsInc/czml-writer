// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Material</code> to a <see cref="CesiumOutputStream" />.  A <code>Material</code> tODO
    /// </summary>
    public class MaterialCesiumWriter : CesiumPropertyWriter<MaterialCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public MaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected MaterialCesiumWriter(MaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override MaterialCesiumWriter Clone()
        {
            return new MaterialCesiumWriter(this);
        }

    }
}
