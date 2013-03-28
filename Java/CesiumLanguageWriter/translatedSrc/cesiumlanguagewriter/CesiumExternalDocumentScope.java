package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The scope of the document. Shared scopes merge objects with the same ids. Privately scoped documents do not merge objects with the same ids.
 

 */
public enum CesiumExternalDocumentScope implements Enumeration {
	/**
	 *  
	The document is shared. 
	

	 */
	SHARED(0), /**
				 *  
				The document is private.
				

				 */
	PRIVATE(1);
	private final int value;

	CesiumExternalDocumentScope(int value) {
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
	public static CesiumExternalDocumentScope getFromValue(int value) {
		switch (value) {
		case 0:
			return SHARED;
		case 1:
			return PRIVATE;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumExternalDocumentScope getDefault() {
		return SHARED;
	}
}