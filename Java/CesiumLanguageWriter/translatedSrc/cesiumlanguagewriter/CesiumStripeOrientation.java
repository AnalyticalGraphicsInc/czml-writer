package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The orientation of an element.
 

 */
public enum CesiumStripeOrientation implements Enumeration {
	/**
	 *  
	The element is oriented horizontally.
	

	 */
	HORIZONTAL(0), /**
					 *  
					The element is oriented vertically.
					

					 */
	VERTICAL(1);
	private final int value;

	CesiumStripeOrientation(int value) {
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
	public static CesiumStripeOrientation getFromValue(int value) {
		switch (value) {
		case 0:
			return HORIZONTAL;
		case 1:
			return VERTICAL;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumStripeOrientation getDefault() {
		return HORIZONTAL;
	}
}