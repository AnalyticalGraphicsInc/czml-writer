// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Polyline</code> to a <see cref="CesiumOutputStream" />.  A <code>Polyline</code> tODO
    /// </summary>
    public class PolylineCesiumWriter : CesiumPropertyWriter<PolylineCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolylineCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PolylineCesiumWriter(PolylineCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolylineCesiumWriter Clone()
        {
            return new PolylineCesiumWriter(this);
        }

    }
}
