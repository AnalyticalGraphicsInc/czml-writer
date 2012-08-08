using System.IO;
using System.Xml.Linq;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using System;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// Stores data about the kml file.
    /// </summary>
    public class CzmlDocument
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="CzmlDocument"/> class.
        /// </summary>
        public CzmlDocument(Uri parentUri = null)
        {
            m_writer = new CesiumStreamWriter();
            m_imageResolver = new CachingCesiumUrlResolver(int.MaxValue);
            m_parentUri = parentUri;
            Namespace = "";
        }

        /// <summary>
        /// Gets the resolver to use for images.
        /// </summary>
        public CachingCesiumUrlResolver ImageResolver
        {
            get { return m_imageResolver; }
        }

        /// <summary>
        /// Gets or sets the namespace.
        /// </summary>
        /// <value>
        /// The namespace.
        /// </value>
        public XNamespace Namespace { get; set; }


        /// <summary>
        /// Gets the cesium stream writer.
        /// </summary>
        public CesiumStreamWriter CesiumStreamWriter
        {
            get { return m_writer; }
        }

        public Uri ParentUri
        {
            get { return m_parentUri; }
        }

        private readonly CesiumStreamWriter m_writer;
        private readonly CachingCesiumUrlResolver m_imageResolver;
        private readonly Uri m_parentUri;
    }
}