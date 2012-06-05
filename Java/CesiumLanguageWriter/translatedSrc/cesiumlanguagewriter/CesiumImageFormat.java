package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The format of an image embedded in a <topic name="Cesium">Cesium</topic> stream.
 

 */
public enum CesiumImageFormat implements Enumeration {
	/**
	 *  
	The image is in Portable Network Graphics (PNG) format.
	

	 */
	PNG(0), /**
			 *  
			The image is in Joint Photographic Experts Group (JPEG) format.
			

			 */
	JPEG(1);
	private final int value;

	CesiumImageFormat(int value) {
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
	public static CesiumImageFormat getFromValue(int value) {
		switch (value) {
		case 0:
			return PNG;
		case 1:
			return JPEG;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumImageFormat getDefault() {
		return PNG;
	}
}