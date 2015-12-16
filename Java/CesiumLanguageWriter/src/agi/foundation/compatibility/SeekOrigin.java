package agi.foundation.compatibility;

/**
 * Provides the fields that represent reference points in streams for seeking.
 */
public enum SeekOrigin implements Enumeration {
	BEGIN(0), CURRENT(1), END(2);
	private final int value;

	SeekOrigin(int value) {
		this.value = value;
	}

	/**
	 * Get the numeric value associated with this enum constant.
	 * 
	 * @return A numeric value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Get the enum constant that is associated with the given numeric value.
	 * 
	 * @return The enum constant associated with value.
	 * @param value
	 *            a numeric value.
	 */
	public static SeekOrigin getFromValue(int value) {
		switch (value) {
		case 0:
			return BEGIN;
		case 1:
			return CURRENT;
		case 2:
			return END;
		default:
			throw new IllegalArgumentException("Undefined enum value.");
		}
	}

	/**
	 * Get the enum constant that is considered to be the default.
	 * 
	 * @return The default enum constant.
	 */
	public static SeekOrigin getDefault() {
		return BEGIN;
	}
}