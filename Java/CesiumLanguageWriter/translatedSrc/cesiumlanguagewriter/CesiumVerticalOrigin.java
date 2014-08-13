package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The vertical origin of a billboard or label relative to its position.
 

 */
public enum CesiumVerticalOrigin implements Enumeration {
	/**
	 *  
	The bottom of the billboard or label is located at the position.
	

	 */
	BOTTOM(0), /**
				 *  
				The billboard or label is vertically centered at the position.
				

				 */
	CENTER(1), /**
				 *  
				The top of the billboard or label is located at the position.
				

				 */
	TOP(2);
	private final int value;

	CesiumVerticalOrigin(int value) {
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
	public static CesiumVerticalOrigin getFromValue(int value) {
		switch (value) {
		case 0:
			return BOTTOM;
		case 1:
			return CENTER;
		case 2:
			return TOP;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumVerticalOrigin getDefault() {
		return BOTTOM;
	}
}