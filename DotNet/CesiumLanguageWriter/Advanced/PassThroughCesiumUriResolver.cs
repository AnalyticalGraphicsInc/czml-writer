using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A URI resolver that leaves URIs unchanged.
    /// </summary>
    public class PassThroughCesiumUriResolver : ICesiumUriResolver
    {
        /// <summary>
        /// Resolves a URI, leaving it unchanged.
        /// </summary>
        /// <param name="uri">The source URI.</param>
        /// <returns>The same URI.</returns>
        public string ResolveUri(string uri)
        {
            return uri;
        }

        /// <summary>
        /// Gets a static instance of <see cref="PassThroughCesiumUriResolver"/> usable from any thread.
        /// </summary>
        [NotNull]
        public static PassThroughCesiumUriResolver Instance
        {
            get { return s_instance; }
        }

        [NotNull]
        private static readonly PassThroughCesiumUriResolver s_instance = new PassThroughCesiumUriResolver();
    }
}