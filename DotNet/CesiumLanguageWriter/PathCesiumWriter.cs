// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Path</code> to a <see cref="CesiumOutputStream" />.  A <code>Path</code> tODO
    /// </summary>
    public class PathCesiumWriter : CesiumPropertyWriter<PathCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PathCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PathCesiumWriter(PathCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PathCesiumWriter Clone()
        {
            return new PathCesiumWriter(this);
        }

    }
}
