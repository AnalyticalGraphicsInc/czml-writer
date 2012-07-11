namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A URL resolver that leaves URLs unchanged.
    /// </summary>
    public class PassThroughCesiumUrlResolver : ICesiumUrlResolver
    {
        /// <summary>
        /// Resolves a URL, leaving it unchanged.
        /// </summary>
        /// <param name="url">The source URL.</param>
        /// <returns>The same URL.</returns>
        public string ResolveUrl(string url)
        {
            return url;
        }
    }
}