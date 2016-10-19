// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>NodeTransformations</c> to a <see cref="CesiumOutputStream" />.  A <c>NodeTransformations</c> is a mapping of node names to node transformations.
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
        /// Gets a new writer for a <c>NodeTransformation</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  A <c>NodeTransformation</c> property defines transformations to apply to a particular node in a 3D model.
        /// </summary>
        public NodeTransformationCesiumWriter GetNodeTransformationWriter(string name)
        {
            return new NodeTransformationCesiumWriter(name);
        }

        /// <summary>
        /// Opens and returns a new writer for a <c>NodeTransformation</c> property.  A <c>NodeTransformation</c> property defines transformations to apply to a particular node in a 3D model.
        /// </summary>
        /// <param name="name">The name of the new property writer.</param>
        public NodeTransformationCesiumWriter OpenNodeTransformationProperty(string name)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(new NodeTransformationCesiumWriter(name));
        }

    }
}
