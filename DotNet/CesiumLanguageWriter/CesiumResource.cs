
#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A resource to include in a CZML document, whether embedded or linked to.
    /// </summary>
    public class CesiumResource
    {
        private readonly string m_url;
        private readonly CesiumResourceBehavior m_behavior;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="url">The URL of the resource.</param>
        /// <param name="behavior">An enumeration describing how to include the resource in the document.</param>
        public CesiumResource(string url, CesiumResourceBehavior behavior)
        {
            m_url = url;
            m_behavior = behavior;
        }

        /// <summary>
        /// The URL of the resource.
        /// </summary>
        public string Url
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