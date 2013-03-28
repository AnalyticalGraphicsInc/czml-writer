namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A URL resolver transforms URLs into another form for inclusion in a CZML document.
    /// For example, <see cref="CachingCesiumUrlResolver"/> downloads files and converts them to data URIs,
    /// while <see cref="PassThroughCesiumUrlResolver"/> leaves URLs unchanged.
    /// </summary>
    public interface ICesiumUrlResolver
    {
        /// <summary>
        /// Resolves a URL, producing a new URL for inclusion in a CZML document.
        /// </summary>
        /// <param name="url">The source URL.</param>
        /// <returns>A URL suitable for CZML.</returns>
        string ResolveUrl(string url);
    }
}