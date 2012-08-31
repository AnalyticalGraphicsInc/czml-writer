using System;
using System.Collections.Generic;

#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// A URL resolver that downloads files and converts them to data URIs.  Downloaded files are cached
    /// using a least-recently used cache.
    /// </summary>
    public class CachingCesiumUrlResolver : ICesiumUrlResolver
    {
        private class CacheItem
        {
            public readonly string SourceUrl;
            public readonly string ResolvedUrl;

            public CacheItem(string sourceUrl, string resolvedUrl)
            {
                SourceUrl = sourceUrl;
                ResolvedUrl = resolvedUrl;
            }
        }

        [ThreadStatic]
        private static CachingCesiumUrlResolver s_threadLocalInstance;

        private readonly int m_max;
        private readonly Dictionary<string, LinkedListNode<CacheItem>> m_dictionary;
        private readonly LinkedList<CacheItem> m_lruList;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="max">The maximum number of remote files to cache before removing the oldest.</param>
        public CachingCesiumUrlResolver(int max)
        {
            m_max = max;
            m_dictionary = new Dictionary<string, LinkedListNode<CacheItem>>();
            m_lruList = new LinkedList<CacheItem>();
        }

        /// <summary>
        /// Resolves a URL, producing a new URL for inclusion in a CZML document.
        /// </summary>
        /// <param name="url">The source URL.</param>
        /// <returns>A URL suitable for CZML.</returns>
        public string ResolveUrl(string url)
        {
            LinkedListNode<CacheItem> node;
            if (m_dictionary.TryGetValue(url, out node))
            {
                //move to front
                m_lruList.Remove(node);
                m_lruList.AddFirst(node);

                return node.Value.ResolvedUrl;
            }

            //load image into data URI
            string resolvedUrl = CesiumFormattingHelper.DownloadUrlIntoDataUri(url);
            AddUrl(url, resolvedUrl);
            return resolvedUrl;
        }

        /// <summary>
        /// Add a URL to the cache for future calls to ResolveUrl.
        /// </summary>
        /// <param name="sourceUrl">The source URL.</param>
        /// <param name="resolvedUrl">The resolved URL.</param>
        public void AddUrl(string sourceUrl, string resolvedUrl)
        {
            var newNode = m_lruList.AddFirst(new CacheItem(sourceUrl, resolvedUrl));
            m_dictionary.Add(sourceUrl, newNode);

            if (m_lruList.Count > m_max)
            {
                //trim least recently used
                m_dictionary.Remove(m_lruList.Last.Value.SourceUrl);
                m_lruList.RemoveLast();
            }
        }

        /// <summary>
        /// Checks whether the cache already contains a resolved URL for the given URL.
        /// </summary>
        /// <param name="sourceUrl">The source URL.</param>
        /// <returns>True if the cache already has a resolved URL for that URL, false otherwise.</returns>
        public bool ContainsUrl(string sourceUrl)
        {
            return m_dictionary.ContainsKey(sourceUrl);
        }

        /// <summary>
        /// An instance of <see cref="CachingCesiumUrlResolver"/> local to the calling thread.
        /// </summary>
        public static CachingCesiumUrlResolver ThreadLocalInstance
        {
            get
            {
                if (s_threadLocalInstance == null)
                    s_threadLocalInstance = new CachingCesiumUrlResolver(50);

                return s_threadLocalInstance;
            }
        }
    }
}