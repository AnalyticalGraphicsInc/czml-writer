// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ModelUri</code> to a <see cref="CesiumOutputStream" />.  A <code>ModelUri</code> defines a model associated with an element, which can optionally vary over time.  The model is specified as multiple URLs where each property maps to a different format.  The client can choose its best supported format from those provided.
    /// </summary>
    public class ModelUriCesiumWriter : CesiumPropertyWriter<ModelUriCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>webgltf</code> property.
        /// </summary>
        public const string WebgltfPropertyName = "webgltf";

        /// <summary>
        /// The name of the <code>dae</code> property.
        /// </summary>
        public const string DaePropertyName = "dae";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asWebgltf;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asDae;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ModelUriCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asWebgltf = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateWebgltfAdaptor, false);
            m_asDae = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateDaeAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ModelUriCesiumWriter(ModelUriCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asWebgltf = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateWebgltfAdaptor, false);
            m_asDae = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateDaeAdaptor, false);
        }

        /// <inheritdoc />
        public override ModelUriCesiumWriter Clone()
        {
            return new ModelUriCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>webgltf</code> property.  The <code>webgltf</code> property specifies the URL of a WebGLTF model.
        /// </summary>
        /// <param name="resource">A resource object describing the model.</param>
        public void WriteWebgltf(CesiumResource resource)
        {
            WriteWebgltf(resource.Url, resource.Behavior);
        }

        /// <summary>
        /// Writes the <code>webgltf</code> property.  The <code>webgltf</code> property specifies the URL of a WebGLTF model.
        /// </summary>
        /// <param name="url">The URL of the model.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the model in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteWebgltf(string url, CesiumResourceBehavior resourceBehavior)
        {
            const string PropertyName = WebgltfPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.GetResourceUrl(url, resourceBehavior));
        }

        /// <summary>
        /// Writes the <code>webgltf</code> property.  The <code>webgltf</code> property specifies the URL of a WebGLTF model.
        /// </summary>
        /// <param name="url">The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteWebgltf(string url, ICesiumUrlResolver resolver)
        {
            const string PropertyName = WebgltfPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(resolver.ResolveUrl(url));
        }

        /// <summary>
        /// Writes the <code>dae</code> property.  The <code>dae</code> property specifies the URL of a Collada model.
        /// </summary>
        /// <param name="resource">A resource object describing the model.</param>
        public void WriteDae(CesiumResource resource)
        {
            WriteDae(resource.Url, resource.Behavior);
        }

        /// <summary>
        /// Writes the <code>dae</code> property.  The <code>dae</code> property specifies the URL of a Collada model.
        /// </summary>
        /// <param name="url">The URL of the model.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the model in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteDae(string url, CesiumResourceBehavior resourceBehavior)
        {
            const string PropertyName = DaePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.GetResourceUrl(url, resourceBehavior));
        }

        /// <summary>
        /// Writes the <code>dae</code> property.  The <code>dae</code> property specifies the URL of a Collada model.
        /// </summary>
        /// <param name="url">The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteDae(string url, ICesiumUrlResolver resolver)
        {
            const string PropertyName = DaePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(resolver.ResolveUrl(url));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Webgltf</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumResource> AsWebgltf()
        {
            return m_asWebgltf.Value;
        }

        private ICesiumValuePropertyWriter<CesiumResource> CreateWebgltfAdaptor()
        {
            return new CesiumWriterAdaptor<ModelUriCesiumWriter, CesiumResource>(
                this, (me, value) => me.WriteWebgltf(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Dae</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumResource> AsDae()
        {
            return m_asDae.Value;
        }

        private ICesiumValuePropertyWriter<CesiumResource> CreateDaeAdaptor()
        {
            return new CesiumWriterAdaptor<ModelUriCesiumWriter, CesiumResource>(
                this, (me, value) => me.WriteDae(value));
        }

    }
}
