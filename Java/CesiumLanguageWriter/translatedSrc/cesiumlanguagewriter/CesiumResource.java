package cesiumlanguagewriter;


import agi.foundation.compatibility.*;

/**
 *  
 A resource to include in a CZML document, whether embedded or linked to.
 

 */
public class CesiumResource {
	private String m_url;
	private CesiumResourceBehavior m_behavior = CesiumResourceBehavior.getDefault();

	/**
	 *  
	Initializes a new instance.
	
	
	

	 * @param url The URL of the resource.
	 * @param behavior An enumeration describing how to include the resource in the document.
	 */
	public CesiumResource(String url, CesiumResourceBehavior behavior) {
		m_url = url;
		m_behavior = behavior;
	}

	/**
	 *  
	The URL of the resource.
	

	 */
	public final String getUrl() {
		return m_url;
	}

	/**
	 *  
	An enumeration describing how to include the resource in the document.
	

	 */
	public final CesiumResourceBehavior getBehavior() {
		return m_behavior;
	}
}