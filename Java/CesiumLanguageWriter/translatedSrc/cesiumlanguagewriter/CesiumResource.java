package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import java.net.URI;

/**
 *  
 A resource to be linked from or embedded into a CZML document.
 

 */
public class CesiumResource {
	private URI m_url;
	private CesiumResourceBehavior m_behavior = CesiumResourceBehavior.getDefault();

	/**
	 *  
	Initializes a new instance.
	
	
	

	 * @param uri The URI of the resource.
	 * @param behavior The enumeration describing how the resource is to be included in the document.
	 */
	public CesiumResource(URI uri, CesiumResourceBehavior behavior) {
		m_url = uri;
		m_behavior = behavior;
	}

	/**
	 *  Gets the URI of the resource.
	

	 */
	public final URI getUri() {
		return m_url;
	}

	/**
	 *  Gets how the resource is to be included in the document.
	

	 */
	public final CesiumResourceBehavior getBehavior() {
		return m_behavior;
	}
}