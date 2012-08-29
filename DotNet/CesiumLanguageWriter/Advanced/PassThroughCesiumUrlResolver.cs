
#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// A URL resolver that leaves URLs unchanged.
    /// </summary>
    public class PassThroughCesiumUrlResolver : ICesiumUrlResolver
    {
        private static readonly PassThroughCesiumUrlResolver s_instance = new PassThroughCesiumUrlResolver();

        /// <summary>
        /// Resolves a URL, leaving it unchanged.
        /// </summary>
        /// <param name="url">The source URL.</param>
        /// <returns>The same URL.</returns>
        public string ResolveUrl(string url)
        {
            return url;
        }

        /// <summary>
        /// A static instance of <see cref="PassThroughCesiumUrlResolver"/> usable from any thread.
        /// </summary>
        public static PassThroughCesiumUrlResolver Instance
        {
            get { return s_instance; }
        }
    }
}