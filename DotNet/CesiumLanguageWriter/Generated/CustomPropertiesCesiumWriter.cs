// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>CustomProperties</c> to a <see cref="CesiumOutputStream" />.  A <c>CustomProperties</c> is a set of custom properties.
    /// </summary>
    public class CustomPropertiesCesiumWriter : CesiumPropertyWriter<CustomPropertiesCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CustomPropertiesCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CustomPropertiesCesiumWriter(CustomPropertiesCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override CustomPropertiesCesiumWriter Clone()
        {
            return new CustomPropertiesCesiumWriter(this);
        }

        /// <summary>
        /// Gets a new writer for a <c>CustomProperty</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  A <c>CustomProperty</c> property defines a custom property.
        /// </summary>
        public CustomPropertyCesiumWriter GetCustomPropertyWriter(string name)
        {
            return new CustomPropertyCesiumWriter(name);
        }

        /// <summary>
        /// Opens and returns a new writer for a <c>CustomProperty</c> property.  A <c>CustomProperty</c> property defines a custom property.
        /// </summary>
        /// <param name="name">The name of the new property writer.</param>
        public CustomPropertyCesiumWriter OpenCustomPropertyProperty(string name)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(new CustomPropertyCesiumWriter(name));
        }

    }
}
