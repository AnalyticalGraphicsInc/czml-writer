// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Video</code> to a <see cref="CesiumOutputStream" />.  A <code>Video</code> defines a video associated with an element, which can optionally vary over time.  The video is specified as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    /// </summary>
    public class VideoCesiumWriter : CesiumPropertyWriter<VideoCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>video</code> property.
        /// </summary>
        public const string VideoPropertyName = "video";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asVideo;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public VideoCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asVideo = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateVideoAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected VideoCesiumWriter(VideoCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asVideo = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateVideoAdaptor, false);
        }

        /// <inheritdoc />
        public override VideoCesiumWriter Clone()
        {
            return new VideoCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>video</code> property.  The <code>video</code> property specifies the URL of the video.
        /// </summary>
        /// <param name="resource">A resource object describing the video.</param>
        public void WriteVideo(CesiumResource resource)
        {
            WriteVideo(resource.Url, resource.Behavior);
        }

        /// <summary>
        /// Writes the <code>video</code> property.  The <code>video</code> property specifies the URL of the video.
        /// </summary>
        /// <param name="url">The URL of the video.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the video in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteVideo(string url, CesiumResourceBehavior resourceBehavior)
        {
            const string PropertyName = VideoPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.GetResourceUrl(url, resourceBehavior));
        }

        /// <summary>
        /// Writes the <code>video</code> property.  The <code>video</code> property specifies the URL of the video.
        /// </summary>
        /// <param name="url">The URL of the video.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteVideo(string url, ICesiumUrlResolver resolver)
        {
            const string PropertyName = VideoPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(resolver.ResolveUrl(url));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Video</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumResource> AsVideo()
        {
            return m_asVideo.Value;
        }

        private ICesiumValuePropertyWriter<CesiumResource> CreateVideoAdaptor()
        {
            return new CesiumWriterAdaptor<VideoCesiumWriter, CesiumResource>(
                this, (me, value) => me.WriteVideo(value));
        }

    }
}
