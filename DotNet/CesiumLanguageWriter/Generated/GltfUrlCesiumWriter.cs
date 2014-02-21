// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>GltfUrl</code> to a <see cref="CesiumOutputStream" />.  A <code>GltfUrl</code> the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
    /// </summary>
    public class GltfUrlCesiumWriter : CesiumPropertyWriter<GltfUrlCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>uri</code> property.
        /// </summary>
        public const string UriPropertyName = "uri";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public GltfUrlCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected GltfUrlCesiumWriter(GltfUrlCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override GltfUrlCesiumWriter Clone()
        {
            return new GltfUrlCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
        /// </summary>
        /// <param name="url">The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteUri(string url, ICesiumUrlResolver resolver)
        {
            const string PropertyName = UriPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(resolver.ResolveUrl(url));
        }

        /// <summary>
        /// Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
        /// </summary>
        /// <param name="url">The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteUri(Uri url, ICesiumUrlResolver resolver)
        {
            const string PropertyName = UriPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(resolver.ResolveUrl(url.ToString()));
        }

    }
}
