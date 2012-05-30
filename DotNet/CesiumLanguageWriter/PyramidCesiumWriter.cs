// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Pyramid</code> to a <see cref="CesiumOutputStream" />.  A <code>Pyramid</code> tODO
    /// </summary>
    public class PyramidCesiumWriter : CesiumPropertyWriter<PyramidCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PyramidCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PyramidCesiumWriter(PyramidCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PyramidCesiumWriter Clone()
        {
            return new PyramidCesiumWriter(this);
        }

    }
}
