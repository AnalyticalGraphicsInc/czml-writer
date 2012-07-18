package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A URL resolver that leaves URLs unchanged.
 

 */
public class PassThroughCesiumUrlResolver implements ICesiumUrlResolver {
	/**
	 *  
	Resolves a URL, leaving it unchanged.
	
	
	

	 * @param url The source URL.
	 * @return The same URL.
	 */
	public final String resolveUrl(String url) {
		return url;
	}
}