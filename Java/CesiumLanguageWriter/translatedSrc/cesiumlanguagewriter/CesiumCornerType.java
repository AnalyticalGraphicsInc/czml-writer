package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 Specifies the style of a corner.
 

 */
public enum CesiumCornerType implements Enumeration {
	/**
	 *  
	The corner has a smooth edge.
	

	 */
	ROUNDED(0), /**
				 *  
				The corner point is the intersection of adjacent edges.
				

				 */
	MITERED(1), /**
				 *  
				The corner is clipped.
				

				 */
	BEVELED(2);
	private final int value;

	CesiumCornerType(int value) {
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
	public static CesiumCornerType getFromValue(int value) {
		switch (value) {
		case 0:
			return ROUNDED;
		case 1:
			return MITERED;
		case 2:
			return BEVELED;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumCornerType getDefault() {
		return ROUNDED;
	}
}