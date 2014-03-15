// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Uri</code> to a <see cref="CesiumOutputStream" />.  A <code>Uri</code> a URI value.  The URI can optionally vary with time.
    /// </summary>
    public class UriCesiumWriter : CesiumPropertyWriter<UriCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>uri</code> property.
        /// </summary>
        public const string UriPropertyName = "uri";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asUri;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public UriCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asUri = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateUriAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected UriCesiumWriter(UriCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asUri = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateUriAdaptor, false);
        }

        /// <inheritdoc />
        public override UriCesiumWriter Clone()
        {
            return new UriCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
        /// </summary>
        /// <param name="resource">A resource object describing external data.</param>
        public void WriteUri(CesiumResource resource)
        {
            WriteUri(resource.Url, resource.Behavior);
        }

        /// <summary>
        /// Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
        /// </summary>
        /// <param name="url">The URL of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URL in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteUri(string url, CesiumResourceBehavior resourceBehavior)
        {
            const string PropertyName = UriPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.GetResourceUrl(url, resourceBehavior));
        }

        /// <summary>
        /// Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
        /// </summary>
        /// <param name="url">The URL of the data.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteUri(string url, ICesiumUrlResolver resolver)
        {
            const string PropertyName = UriPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(resolver.ResolveUrl(url));
        }

        /// <summary>
        /// Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image, using PNG encoding.</param>
        public void WriteUri(Image image)
        {
            WriteUri(image, CesiumImageFormat.Png);
        }

        /// <summary>
        /// Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image.</param>
        /// <param name="imageFormat">The image format to use to encode the image in the data URI.</param>
        public void WriteUri(Image image, CesiumImageFormat imageFormat)
        {
            const string PropertyName = UriPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ImageToDataUri(image, imageFormat));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Uri</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumResource> AsUri()
        {
            return m_asUri.Value;
        }

        private ICesiumValuePropertyWriter<CesiumResource> CreateUriAdaptor()
        {
            return new CesiumWriterAdaptor<UriCesiumWriter, CesiumResource>(
                this, (me, value) => me.WriteUri(value));
        }

    }
}
