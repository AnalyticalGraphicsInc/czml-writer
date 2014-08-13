using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A resource to include in a CZML document, whether embedded or linked to.
    /// </summary>
    public class CesiumResource
    {
        private readonly Uri m_url;
        private readonly CesiumResourceBehavior m_behavior;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="uri">The URI of the resource.</param>
        /// <param name="behavior">An enumeration describing how to include the resource in the document.</param>
        public CesiumResource(Uri uri, CesiumResourceBehavior behavior)
        {
            m_url = uri;
            m_behavior = behavior;
        }

        /// <summary>
        /// The URI of the resource.
        /// </summary>
        public Uri Uri
        {
            get { return m_url; }
        }

        /// <summary>
        /// An enumeration describing how to include the resource in the document.
        /// </summary>
        public CesiumResourceBehavior Behavior
        {
            get { return m_behavior; }
        }
    }
}