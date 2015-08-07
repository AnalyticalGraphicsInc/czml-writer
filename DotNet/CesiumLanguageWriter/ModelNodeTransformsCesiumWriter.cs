using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Model</code> to a <see cref="CesiumOutputStream" />.  A <code>Model</code> a 3D model.
    /// </summary>
    public class ModelNodeTransformsCesiumWriter : CesiumPropertyWriter<ModelNodeTransformsCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ModelNodeTransformsCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected ModelNodeTransformsCesiumWriter(ModelNodeTransformsCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ModelNodeTransformsCesiumWriter Clone()
        {
            return new ModelNodeTransformsCesiumWriter(this);
        }

        /// <summary>
        /// Opens and returns the writer for an individual node transformation.
        /// </summary>
        /// <param name="nodeName">The name of the model node to apply transformations to.</param>
        public ModelNodeTransformationCesiumWriter OpenNewNodeTransformation(string nodeName)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(new ModelNodeTransformationCesiumWriter(nodeName));
        }
    }
}
