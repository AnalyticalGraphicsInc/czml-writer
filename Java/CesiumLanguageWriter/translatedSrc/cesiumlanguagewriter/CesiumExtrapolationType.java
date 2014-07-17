package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The type of extrapolation to perform when outside the sample data range of an interpolatable property.
 

 */
public enum CesiumExtrapolationType implements Enumeration {
	/**
	 *  
	No extrpolation is performed; the property is undefined.
	

	 */
	NONE(0), /**
				 *  
				Return the first or last sample value.
				

				 */
	HOLD(1), /**
				 *  
				Extrapolate the value.
				

				 */
	EXTRAPOLATE(2);
	private final int value;

	CesiumExtrapolationType(int value) {
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
	public static CesiumExtrapolationType getFromValue(int value) {
		switch (value) {
		case 0:
			return NONE;
		case 1:
			return HOLD;
		case 2:
			return EXTRAPOLATE;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumExtrapolationType getDefault() {
		return NONE;
	}
}