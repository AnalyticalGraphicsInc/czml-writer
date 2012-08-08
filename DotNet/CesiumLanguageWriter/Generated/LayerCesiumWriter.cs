// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Layer</code> to a <see cref="CesiumOutputStream" />.  A <code>Layer</code> a czml document or link to another layer
    /// </summary>
    public class LayerCesiumWriter : CesiumPropertyWriter<LayerCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>layerUrl</code> property.
        /// </summary>
        public const string LayerUrlPropertyName = "layerUrl";


        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<StringCesiumWriter> m_layerUrl = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(LayerUrlPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public LayerCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected LayerCesiumWriter(LayerCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override LayerCesiumWriter Clone()
        {
            return new LayerCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the layer is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the layer is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the layer is shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>layerUrl</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>layerUrl</code> property defines the url where the czml document resides.
        /// </summary>
        public StringCesiumWriter LayerUrlWriter
        {
            get { return m_layerUrl.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>layerUrl</code> property.  The <code>layerUrl</code> property defines the url where the czml document resides.
        /// </summary>
        public StringCesiumWriter OpenLayerUrlProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LayerUrlWriter);
        }

        /// <summary>
        /// Writes a value for the <code>layerUrl</code> property as a <code>string</code> value.  The <code>layerUrl</code> property specifies the url where the czml document resides.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLayerUrlProperty(string value)
        {
            using (var writer = OpenLayerUrlProperty())
            {
                writer.WriteString(value);
            }
        }

    }
}
