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
 A URI resolver that downloads files and converts them to data URIs.  Downloaded files are cached
 using a least-recently used cache.
 

 */
public class CachingCesiumUriResolver implements ICesiumUriResolver {
    private static class CacheItem {
        public final String SourceUri;
        public final String ResolvedUri;

        public CacheItem(String sourceUri, String resolvedUri) {
            SourceUri = sourceUri;
            ResolvedUri = resolvedUri;
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
    public CachingCesiumUriResolver(int max) {
        m_max = max;
        m_dictionary = new HashMap<String, LinkedListNode<CacheItem>>();
        m_lruList = new LinkedList<CacheItem>();
    }

    /**
    *  
    Resolves a URI, producing a new URI for inclusion in a CZML document.
    
    
    

    * @param uri The source URI.
    * @return A URI suitable for CZML.
    */
    public final String resolveUri(String uri) {
        LinkedListNode<cesiumlanguagewriter.advanced.CachingCesiumUriResolver.CacheItem> node = null;
        final LinkedListNode<cesiumlanguagewriter.advanced.CachingCesiumUriResolver.CacheItem>[] out$node$1 = new LinkedListNode[] {
            null
        };
        final boolean temp$0 = MapHelper.tryGetValue(m_dictionary, uri, out$node$1);
        node = out$node$1[0];
        if (temp$0) {
            if (m_lruList.getFirst() != node) {
                //move to front
                m_lruList.remove(node);
                m_lruList.addFirst(node);
            }
            return node.getValue().ResolvedUri;
        }
        //load image into data URI
        String resolvedUri = CesiumFormattingHelper.downloadUriIntoDataUri(uri);
        addUri(uri, resolvedUri);
        return resolvedUri;
    }

    /**
    *  
    Add a URI to the cache for future calls to ResolveUri.
    
    
    

    * @param sourceUri The source URI.
    * @param resolvedUri The resolved URI.
    */
    public final void addUri(String sourceUri, String resolvedUri) {
        LinkedListNode<cesiumlanguagewriter.advanced.CachingCesiumUriResolver.CacheItem> newNode = m_lruList.addFirst(new CacheItem(sourceUri, resolvedUri));
        MapHelper.add(m_dictionary, sourceUri, newNode);
        if (m_lruList.size() > m_max) {
            //trim least recently used
            MapHelper.remove(m_dictionary, m_lruList.getLast().getValue().SourceUri);
            m_lruList.removeLast();
        }
    }

    /**
    *  
    Checks whether the cache already contains a resolved URI for the given URI.
    
    
    

    * @param sourceUri The source URI.
    * @return True if the cache already has a resolved URI for that URI, false otherwise.
    */
    public final boolean containsUri(String sourceUri) {
        return m_dictionary.containsKey(sourceUri);
    }

    /**
    *  
    An instance of  {@link CachingCesiumUriResolver} local to the calling thread.
    

    */
    public static CachingCesiumUriResolver getThreadLocalInstance() {
        if (s_threadLocalInstance.get() == null) {
            s_threadLocalInstance.set(new CachingCesiumUriResolver(50));
        }
        return s_threadLocalInstance.get();
    }

    private static class ThreadLocal_0 extends ThreadLocal<CachingCesiumUriResolver> {
        protected final CachingCesiumUriResolver initialValue() {
            return (CachingCesiumUriResolver) null;
        }
    }
}