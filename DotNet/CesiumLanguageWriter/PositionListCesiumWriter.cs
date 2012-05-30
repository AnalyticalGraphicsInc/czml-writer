// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>PositionList</code> to a <see cref="CesiumOutputStream" />.  A <code>PositionList</code> tODO
    /// </summary>
    public class PositionListCesiumWriter : CesiumPropertyWriter<PositionListCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PositionListCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PositionListCesiumWriter(PositionListCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PositionListCesiumWriter Clone()
        {
            return new PositionListCesiumWriter(this);
        }

    }
}
