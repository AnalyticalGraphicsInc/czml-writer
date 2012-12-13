package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.LinkedList;
import agi.foundation.compatibility.LinkedListNode;
import agi.foundation.compatibility.MapHelper;
import cesiumlanguagewriter.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *  
 A URL resolver that downloads files and converts them to data URIs.  Downloaded files are cached
 using a least-recently used cache.
 

 */
public class CachingCesiumUrlResolver implements ICesiumUrlResolver {
	static private class CacheItem {
		public final String SourceUrl;
		public final String ResolvedUrl;

		public CacheItem(String sourceUrl, String resolvedUrl) {
			SourceUrl = sourceUrl;
			ResolvedUrl = resolvedUrl;
		}
	}

	private static ThreadLocal_0 s_threadLocalInstance = new ThreadLocal_0();
	private int m_max;
	private Map<String, LinkedListNode<CacheItem>> m_dictionary;
	private LinkedList<CacheItem> m_lruList;

	/**
	 *  
	Initializes a new instance.
	
	

	 * @param max The maximum number of remote files to cache before removing the oldest.
	 */
	public CachingCesiumUrlResolver(int max) {
		m_max = max;
		m_dictionary = new HashMap<String, LinkedListNode<CacheItem>>();
		m_lruList = new LinkedList<CacheItem>();
	}

	/**
	 *  
	Resolves a URL, producing a new URL for inclusion in a CZML document.
	
	
	

	 * @param url The source URL.
	 * @return A URL suitable for CZML.
	 */
	public final String resolveUrl(String url) {
		LinkedListNode<cesiumlanguagewriter.advanced.CachingCesiumUrlResolver.CacheItem> node = null;
		LinkedListNode<cesiumlanguagewriter.advanced.CachingCesiumUrlResolver.CacheItem>[] out$node_1 = new LinkedListNode[] {
			null
		};
		boolean temp_0 = MapHelper.tryGetValue(m_dictionary, url, out$node_1);
		node = out$node_1[0];
		if (temp_0) {
			//move to front
			m_lruList.remove(node);
			m_lruList.addFirst(node);
			return node.getValue().ResolvedUrl;
		}
		//load image into data URI
		String resolvedUrl = CesiumFormattingHelper.downloadUrlIntoDataUri(url);
		addUrl(url, resolvedUrl);
		return resolvedUrl;
	}

	/**
	 *  
	Add a URL to the cache for future calls to ResolveUrl.
	
	
	

	 * @param sourceUrl The source URL.
	 * @param resolvedUrl The resolved URL.
	 */
	public final void addUrl(String sourceUrl, String resolvedUrl) {
		LinkedListNode<cesiumlanguagewriter.advanced.CachingCesiumUrlResolver.CacheItem> newNode = m_lruList.addFirst(new CacheItem(sourceUrl, resolvedUrl));
		MapHelper.add(m_dictionary, sourceUrl, newNode);
		if (m_lruList.size() > m_max) {
			//trim least recently used
			MapHelper.remove(m_dictionary, m_lruList.getLast().getValue().SourceUrl);
			m_lruList.removeLast();
		}
	}

	/**
	 *  
	Checks whether the cache already contains a resolved URL for the given URL.
	
	
	

	 * @param sourceUrl The source URL.
	 * @return True if the cache already has a resolved URL for that URL, false otherwise.
	 */
	public final boolean containsUrl(String sourceUrl) {
		return m_dictionary.containsKey(sourceUrl);
	}

	/**
	 *  
	An instance of  {@link CachingCesiumUrlResolver} local to the calling thread.
	

	 */
	public static CachingCesiumUrlResolver getThreadLocalInstance() {
		if (s_threadLocalInstance.get() == null) {
			s_threadLocalInstance.set(new CachingCesiumUrlResolver(50));
		}
		return s_threadLocalInstance.get();
	}

	static private class ThreadLocal_0 extends ThreadLocal<CachingCesiumUrlResolver> {
		final protected CachingCesiumUrlResolver initialValue() {
			return (CachingCesiumUrlResolver) null;
		}
	}
}