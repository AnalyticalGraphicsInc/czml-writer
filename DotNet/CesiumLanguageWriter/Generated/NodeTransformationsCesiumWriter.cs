// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>NodeTransformations</code> to a <see cref="CesiumOutputStream" />.  A <code>NodeTransformations</code> defines a mapping of node names to node transformations.
    /// </summary>
    public class NodeTransformationsCesiumWriter : CesiumPropertyWriter<NodeTransformationsCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public NodeTransformationsCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected NodeTransformationsCesiumWriter(NodeTransformationsCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override NodeTransformationsCesiumWriter Clone()
        {
            return new NodeTransformationsCesiumWriter(this);
        }

        /// <summary>
        /// Opens and returns a new writer for a <code>NodeTransformation</code> property.  A <code>NodeTransformation</code> property defines transformations to apply to a particular node in a 3D model.
        /// </summary>
        /// <param name="name">The name of the new property writer.</param>
        public NodeTransformationCesiumWriter OpenNodeTransformationProperty(string name)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(new NodeTransformationCesiumWriter(name));
        }

    }
}
