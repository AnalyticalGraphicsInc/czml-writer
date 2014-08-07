// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>WebMapService</code> to a <see cref="CesiumOutputStream" />.  A <code>WebMapService</code> a Web Map Service (WMS) server.
    /// </summary>
    public class WebMapServiceCesiumWriter : CesiumPropertyWriter<WebMapServiceCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>url</code> property.
        /// </summary>
        public const string UrlPropertyName = "url";

        /// <summary>
        /// The name of the <code>layers</code> property.
        /// </summary>
        public const string LayersPropertyName = "layers";

        /// <summary>
        /// The name of the <code>parameters</code> property.
        /// </summary>
        public const string ParametersPropertyName = "parameters";

        private readonly Lazy<StringCesiumWriter> m_url = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(UrlPropertyName), false);
        private readonly Lazy<StringCesiumWriter> m_layers = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(LayersPropertyName), false);
        private readonly Lazy<PropertyBagCesiumWriter> m_parameters = new Lazy<PropertyBagCesiumWriter>(() => new PropertyBagCesiumWriter(ParametersPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public WebMapServiceCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected WebMapServiceCesiumWriter(WebMapServiceCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override WebMapServiceCesiumWriter Clone()
        {
            return new WebMapServiceCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>url</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>url</code> property defines the base URL of the WMS server
        /// </summary>
        public StringCesiumWriter UrlWriter
        {
            get { return m_url.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>url</code> property.  The <code>url</code> property defines the base URL of the WMS server
        /// </summary>
        public StringCesiumWriter OpenUrlProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(UrlWriter);
        }

        /// <summary>
        /// Writes a value for the <code>url</code> property as a <code>string</code> value.  The <code>url</code> property specifies the base URL of the WMS server
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUrlProperty(string value)
        {
            using (var writer = OpenUrlProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>url</code> property as a <code>reference</code> value.  The <code>url</code> property specifies the base URL of the WMS server
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteUrlPropertyReference(Reference value)
        {
            using (var writer = OpenUrlProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>url</code> property as a <code>reference</code> value.  The <code>url</code> property specifies the base URL of the WMS server
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteUrlPropertyReference(string value)
        {
            using (var writer = OpenUrlProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>url</code> property as a <code>reference</code> value.  The <code>url</code> property specifies the base URL of the WMS server
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteUrlPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenUrlProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>url</code> property as a <code>reference</code> value.  The <code>url</code> property specifies the base URL of the WMS server
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteUrlPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenUrlProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>layers</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>layers</code> property defines the WMS layers to use.  To specify multiple layers, separate them with commas.
        /// </summary>
        public StringCesiumWriter LayersWriter
        {
            get { return m_layers.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>layers</code> property.  The <code>layers</code> property defines the WMS layers to use.  To specify multiple layers, separate them with commas.
        /// </summary>
        public StringCesiumWriter OpenLayersProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LayersWriter);
        }

        /// <summary>
        /// Writes a value for the <code>layers</code> property as a <code>string</code> value.  The <code>layers</code> property specifies the WMS layers to use.  To specify multiple layers, separate them with commas.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLayersProperty(string value)
        {
            using (var writer = OpenLayersProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>layers</code> property as a <code>reference</code> value.  The <code>layers</code> property specifies the WMS layers to use.  To specify multiple layers, separate them with commas.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteLayersPropertyReference(Reference value)
        {
            using (var writer = OpenLayersProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>layers</code> property as a <code>reference</code> value.  The <code>layers</code> property specifies the WMS layers to use.  To specify multiple layers, separate them with commas.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteLayersPropertyReference(string value)
        {
            using (var writer = OpenLayersProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>layers</code> property as a <code>reference</code> value.  The <code>layers</code> property specifies the WMS layers to use.  To specify multiple layers, separate them with commas.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteLayersPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenLayersProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>layers</code> property as a <code>reference</code> value.  The <code>layers</code> property specifies the WMS layers to use.  To specify multiple layers, separate them with commas.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteLayersPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenLayersProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>parameters</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>parameters</code> property defines specifies additional parameters to pass to the WMS server in the GetMap request.
        /// </summary>
        public PropertyBagCesiumWriter ParametersWriter
        {
            get { return m_parameters.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>parameters</code> property.  The <code>parameters</code> property defines specifies additional parameters to pass to the WMS server in the GetMap request.
        /// </summary>
        public PropertyBagCesiumWriter OpenParametersProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ParametersWriter);
        }

    }
}
