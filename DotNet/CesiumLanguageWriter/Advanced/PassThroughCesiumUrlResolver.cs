using System;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A URI resolver that leaves URIs unchanged.
    /// </summary>
    public class PassThroughCesiumUriResolver : ICesiumUriResolver
    {
        private static readonly PassThroughCesiumUriResolver s_instance = new PassThroughCesiumUriResolver();

        /// <summary>
        /// Resolves a URI, leaving it unchanged.
        /// </summary>
        /// <param name="uri">The source URI.</param>
        /// <returns>The same URI.</returns>
        public Uri ResolveUri(Uri uri)
        {
            return uri;
        }

        /// <summary>
        /// A static instance of <see cref="PassThroughCesiumUriResolver"/> usable from any thread.
        /// </summary>
        public static PassThroughCesiumUriResolver Instance
        {
            get { return s_instance; }
        }
    }
}