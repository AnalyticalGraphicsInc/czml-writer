package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import java.net.URI;

/**
 *  
 A resource to include in a CZML document, whether embedded or linked to.
 

 */
public class CesiumResource {
	private URI m_url;
	private CesiumResourceBehavior m_behavior = CesiumResourceBehavior.getDefault();

	/**
	 *  
	Initializes a new instance.
	
	
	

	 * @param uri The URI of the resource.
	 * @param behavior An enumeration describing how to include the resource in the document.
	 */
	public CesiumResource(URI uri, CesiumResourceBehavior behavior) {
		m_url = uri;
		m_behavior = behavior;
	}

	/**
	 *  
	The URI of the resource.
	

	 */
	public final URI getUri() {
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