package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A URL resolver that leaves URLs unchanged.
 

 */
public class PassThroughCesiumUrlResolver implements ICesiumUrlResolver {
	private static PassThroughCesiumUrlResolver s_instance = new PassThroughCesiumUrlResolver();

	/**
	 *  
	Resolves a URL, leaving it unchanged.
	
	
	

	 * @param url The source URL.
	 * @return The same URL.
	 */
	public final String resolveUrl(String url) {
		return url;
	}

	/**
	 *  
	A static instance of  {@link PassThroughCesiumUrlResolver} usable from any thread.
	

	 */
	public static PassThroughCesiumUrlResolver getInstance() {
		return s_instance;
	}
}