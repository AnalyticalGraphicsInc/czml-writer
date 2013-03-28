package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The source data type of the external document.
 

 */
public enum CesiumExternalDocumentSourceType implements Enumeration {
	/**
	 *  
	The data is formatted as json.
	

	 */
	JSON(0), /**
				 *  
				The data is formatted as eventstream.
				

				 */
	EVENT_STREAM(1);
	private final int value;

	CesiumExternalDocumentSourceType(int value) {
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
	public static CesiumExternalDocumentSourceType getFromValue(int value) {
		switch (value) {
		case 0:
			return JSON;
		case 1:
			return EVENT_STREAM;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumExternalDocumentSourceType getDefault() {
		return JSON;
	}
}