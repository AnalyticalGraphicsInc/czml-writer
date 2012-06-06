package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The algorithm to use to interpolation sampled data.
 

 */
public enum CesiumInterpolationAlgorithm implements Enumeration {
	/**
	 *  
	Simple linear interpolation between two samples.
	

	 */
	LINEAR(0), /**
				 *  
				Lagrange polynomial approximation.
				

				 */
	LAGRANGE(1), /**
					 *  
					Hermite polynomial approximation.
					

					 */
	HERMITE(2);
	private final int value;

	CesiumInterpolationAlgorithm(int value) {
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
	public static CesiumInterpolationAlgorithm getFromValue(int value) {
		switch (value) {
		case 0:
			return LINEAR;
		case 1:
			return LAGRANGE;
		case 2:
			return HERMITE;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * @return The default enum constant.
	 */
	public static CesiumInterpolationAlgorithm getDefault() {
		return LINEAR;
	}
}