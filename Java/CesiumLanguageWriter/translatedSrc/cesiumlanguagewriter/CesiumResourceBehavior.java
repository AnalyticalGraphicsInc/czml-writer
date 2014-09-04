package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 Specifies whether to embed a resource into a CZML stream or simply link to them.
 

 */
public enum CesiumResourceBehavior implements Enumeration {
	/**
	 *  
	Download and embed the resource inline in the document as a data URI.  This is the most compatible
	option, but produces larger documents.
	

	 */
	EMBED(0), /**
				 *  
				Link to the resource directly in the document.  Browser-based CZML clients may need to make
				cross-origin requests using <a href="http://www.w3.org/TR/cors/">Cross-Origin Resource Sharing</a>
				to access the resource, which may need server configuration changes, see
				<a href="http://enable-cors.org/">http://enable-cors.org/</a>.
				

				 */
	LINK_TO(1);
	private final int value;

	CesiumResourceBehavior(int value) {
		this.value = value;
	}

	/**
	 * Get the numeric value associated with this enum constant.
	 * @return A numeric value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Get the enum constant that is associated with the given numeric value.
	 * @return The enum constant associated with value.
	 * @param value a numeric value.
	 */
	public static CesiumResourceBehavior getFromValue(int value) {
		switch (value) {
		case 0:
			return EMBED;
		case 1:
			return LINK_TO;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumResourceBehavior getDefault() {
		return EMBED;
	}
}