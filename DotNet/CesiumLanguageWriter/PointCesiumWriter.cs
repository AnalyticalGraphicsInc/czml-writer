// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Point</code> to a <see cref="CesiumOutputStream" />.  A <code>Point</code> tODO
    /// </summary>
    public class PointCesiumWriter : CesiumPropertyWriter<PointCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PointCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PointCesiumWriter(PointCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PointCesiumWriter Clone()
        {
            return new PointCesiumWriter(this);
        }

    }
}
