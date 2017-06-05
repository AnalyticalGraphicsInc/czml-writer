using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A URI resolver transforms URIs into another form for inclusion in a CZML document.
    /// For example, <see cref="CachingCesiumUriResolver"/> downloads files and converts them to data URIs,
    /// while <see cref="PassThroughCesiumUriResolver"/> leaves URIs unchanged.
    /// </summary>
    public interface ICesiumUriResolver
    {
        /// <summary>
        /// Resolves a URI, producing a new URI for inclusion in a CZML document.
        /// </summary>
        /// <param name="uri">The source URI.</param>
        /// <returns>A URI suitable for CZML.</returns>
        [NotNull]
        string ResolveUri([NotNull] string uri);
    }
}