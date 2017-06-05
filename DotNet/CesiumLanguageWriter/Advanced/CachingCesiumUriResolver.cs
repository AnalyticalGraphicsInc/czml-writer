using System;
using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A URI resolver that downloads files and converts them to data URIs.  Downloaded files are cached
    /// using a least-recently used cache.
    /// </summary>
    public class CachingCesiumUriResolver : ICesiumUriResolver
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="max">The maximum number of remote files to cache before removing the oldest.</param>
        public CachingCesiumUriResolver(int max)
        {
            m_max = max;
            m_dictionary = new Dictionary<string, LinkedListNode<CacheItem>>();
            m_lruList = new LinkedList<CacheItem>();
        }

        /// <summary>
        /// Resolves a URI, producing a new URI for inclusion in a CZML document.
        /// </summary>
        /// <param name="uri">The source URI.</param>
        /// <returns>A URI suitable for CZML.</returns>
        public string ResolveUri(string uri)
        {
            if (uri == null)
                throw new ArgumentNullException("uri");

            LinkedListNode<CacheItem> node;
            if (m_dictionary.TryGetValue(uri, out node))
            {
                if (m_lruList.First != node)
                {
                    //move to front
                    m_lruList.Remove(node);
                    m_lruList.AddFirst(node);
                }
                return node.Value.ResolvedUri;
            }

            //load image into data URI
            string resolvedUri = CesiumFormattingHelper.DownloadUriIntoDataUri(uri);
            AddUri(uri, resolvedUri);
            return resolvedUri;
        }

        /// <summary>
        /// Add a URI to the cache for future calls to <see cref="ResolveUri"/>.
        /// </summary>
        /// <param name="sourceUri">The source URI.</param>
        /// <param name="resolvedUri">The resolved URI.</param>
        public void AddUri([NotNull] string sourceUri, [NotNull] string resolvedUri)
        {
            if (sourceUri == null)
                throw new ArgumentNullException("sourceUri");
            if (resolvedUri == null)
                throw new ArgumentNullException("resolvedUri");

            var newNode = m_lruList.AddFirst(new CacheItem(sourceUri, resolvedUri));
            m_dictionary.Add(sourceUri, newNode);

            if (m_lruList.Count > m_max)
            {
                //trim least recently used
                m_dictionary.Remove(m_lruList.Last.Value.SourceUri);
                m_lruList.RemoveLast();
            }
        }

        /// <summary>
        /// Checks whether the cache already contains a resolved URI for the given URI.
        /// </summary>
        /// <param name="sourceUri">The source URI.</param>
        /// <returns>True if the cache already has a resolved URI for that URI, false otherwise.</returns>
        public bool ContainsUri([NotNull] string sourceUri)
        {
            if (sourceUri == null)
                throw new ArgumentNullException("sourceUri");

            return m_dictionary.ContainsKey(sourceUri);
        }

        /// <summary>
        /// An instance of <see cref="CachingCesiumUriResolver"/> local to the calling thread.
        /// </summary>
        [NotNull]
        public static CachingCesiumUriResolver ThreadLocalInstance
        {
            get
            {
                if (s_threadLocalInstance == null)
                    s_threadLocalInstance = new CachingCesiumUriResolver(50);

                return s_threadLocalInstance;
            }
        }

        [ThreadStatic]
        private static CachingCesiumUriResolver s_threadLocalInstance;

        private readonly int m_max;
        [NotNull]
        private readonly Dictionary<string, LinkedListNode<CacheItem>> m_dictionary;
        [NotNull]
        private readonly LinkedList<CacheItem> m_lruList;

        private class CacheItem
        {
            public CacheItem([NotNull] string sourceUri, [NotNull] string resolvedUri)
            {
                SourceUri = sourceUri;
                ResolvedUri = resolvedUri;
            }

            [NotNull]
            public readonly string SourceUri;
            [NotNull]
            public readonly string ResolvedUri;
        }
    }
}