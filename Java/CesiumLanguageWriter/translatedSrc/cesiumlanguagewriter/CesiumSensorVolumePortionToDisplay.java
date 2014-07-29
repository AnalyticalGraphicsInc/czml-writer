package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 Specifies what part of a <topic name="Cesium">Cesium</topic> sensor should be displayed.
 

 */
public enum CesiumSensorVolumePortionToDisplay implements Enumeration {
	/**
	 *  
	The entire sensor projection is shown.
	

	 */
	COMPLETE(0), /**
					 *  
					Only the part of the sensor projection below the ellipsoid horizon is shown.
					

					 */
	BELOW_ELLIPSOID_HORIZON(1), /**
								 *  
								Only the part of the sensor projection above the ellipsoid horizon is shown.
								

								 */
	ABOVE_ELLIPSOID_HORIZON(2);
	private final int value;

	CesiumSensorVolumePortionToDisplay(int value) {
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
	public static CesiumSensorVolumePortionToDisplay getFromValue(int value) {
		switch (value) {
		case 0:
			return COMPLETE;
		case 1:
			return BELOW_ELLIPSOID_HORIZON;
		case 2:
			return ABOVE_ELLIPSOID_HORIZON;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumSensorVolumePortionToDisplay getDefault() {
		return COMPLETE;
	}
}