package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A URL resolver transforms URLs into another form for inclusion in a CZML document.
 For example,  {@link CachingCesiumUrlResolver} downloads files and converts them to data URIs,
 while  {@link PassThroughCesiumUrlResolver} leaves URLs unchanged.
 

 */
public interface ICesiumUrlResolver {
	/**
	 *  
	Resolves a URL, producing a new URL for inclusion in a CZML document.
	
	
	

	 * @param url The source URL.
	 * @return A URL suitable for CZML.
	 */
	String resolveUrl(String url);
}