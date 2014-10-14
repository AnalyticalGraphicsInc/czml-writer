using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A resource to be linked from or embedded into a CZML document.
    /// </summary>
    public class CesiumResource
    {
        private readonly string m_url;
        private readonly CesiumResourceBehavior m_behavior;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="uri">The URI of the resource.</param>
        /// <param name="behavior">The enumeration describing how the resource is to be included in the document.</param>
        public CesiumResource(string uri, CesiumResourceBehavior behavior)
        {
            m_url = uri;
            m_behavior = behavior;
        }

        /// <summary>
        /// Gets the URI of the resource.
        /// </summary>
        public string Uri
        {
            get { return m_url; }
        }

        /// <summary>
        /// Gets how the resource is to be included in the document.
        /// </summary>
        public CesiumResourceBehavior Behavior
        {
            get { return m_behavior; }
        }
    }
}