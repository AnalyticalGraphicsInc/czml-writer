package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 Specifies the style of <topic name="Cesium">Cesium</topic> label.
 

 */
public enum CesiumLabelStyle implements Enumeration {
	/**
	 *  
	The label is filled.
	

	 */
	FILL(0), /**
				 *  
				The label is outlined.
				

				 */
	OUTLINE(1), /**
				 *  
				The label is filled and outlined.
				

				 */
	FILL_AND_OUTLINE(2);
	private final int value;

	CesiumLabelStyle(int value) {
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
	public static CesiumLabelStyle getFromValue(int value) {
		switch (value) {
		case 0:
			return FILL;
		case 1:
			return OUTLINE;
		case 2:
			return FILL_AND_OUTLINE;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumLabelStyle getDefault() {
		return FILL;
	}
}