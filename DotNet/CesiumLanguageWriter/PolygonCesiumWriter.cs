// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Polygon</code> to a <see cref="CesiumOutputStream" />.  A <code>Polygon</code> tODO
    /// </summary>
    public class PolygonCesiumWriter : CesiumPropertyWriter<PolygonCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolygonCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PolygonCesiumWriter(PolygonCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolygonCesiumWriter Clone()
        {
            return new PolygonCesiumWriter(this);
        }

    }
}
