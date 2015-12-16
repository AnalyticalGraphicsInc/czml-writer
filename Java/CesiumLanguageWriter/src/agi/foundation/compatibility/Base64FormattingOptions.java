package agi.foundation.compatibility;

import java.util.EnumSet;

/**
 * Specifies whether conversions to base64 strings insert line breaks in their output.
 */
public class Base64FormattingOptions implements Enumeration {
	/**
	 * Does not insert line breaks after every 76 characters in the string representation.
	 */
	public static final Base64FormattingOptions NONE = new Base64FormattingOptions();
	/**
	 * Inserts line breaks after every 76 characters in the string representation.
	 */
	public static final Base64FormattingOptions INSERT_LINE_BREAKS = new Base64FormattingOptions(Values.INSERT_LINE_BREAKS);

	private enum Values {
		NONE(0), INSERT_LINE_BREAKS(1);
		private final int value;

		Values(int value) {
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
		public static Values getFromValue(int value) {
			switch (value) {
			case 0:
				return NONE;
			case 1:
				return INSERT_LINE_BREAKS;
			default:
				throw new IllegalArgumentException("Undefined enum value.");
			}
		}
	}

	private final EnumSet<Values> value;

	private Base64FormattingOptions() {
		this.value = EnumSet.noneOf(Values.class);
	}

	private Base64FormattingOptions(Base64FormattingOptions... enums) {
		this();
		for (int i = 0; i < enums.length; ++i) {
			this.value.addAll(enums[i].value);
		}
	}

	private Base64FormattingOptions(Values... values) {
		this();
		for (int i = 0; i < values.length; ++i) {
			this.value.add(values[i]);
		}
	}

	/**
	 * Create a new value built by combining the specified values.
	 * 
	 * @return A value that is the combination of the specified values.
	 * @param enums
	 *            the values that the new value will contain.
	 */
	public static Base64FormattingOptions of(Base64FormattingOptions... enums) {
		return new Base64FormattingOptions(enums);
	}

	/**
	 * Add the specified value to the current set and return the result.
	 * 
	 * @return A value that is the combination of the current set and the specified value.
	 * @param other
	 *            the new value to be added into the current set.
	 */
	public Base64FormattingOptions add(Base64FormattingOptions other) {
		return new Base64FormattingOptions(this, other);
	}

	/**
	 * Determines whether the specified value is present in the current set.
	 * 
	 * @return True if the specified value is present in the current set, false otherwise.
	 * @param other
	 *            the value to be checked against the current set.
	 */
	public boolean contains(Base64FormattingOptions other) {
		return value.containsAll(other.value);
	}

	/**
	 * Get the numeric value associated with this value.
	 * 
	 * @return A numeric value.
	 */
	public int getValue() {
		int result = 0;
		for (Values v : value) {
			result |= v.getValue();
		}
		return result;
	}

	/**
	 * Get the set of values that are associated with the given numeric value.
	 * 
	 * @return The set of values associated with the numeric value.
	 * @param value
	 *            a numeric value.
	 */
	public static Base64FormattingOptions getFromValue(int value) {
		Base64FormattingOptions result = new Base64FormattingOptions();
		for (int i = 0; i <= 0; ++i) {
			int currentBit = 1 << i;
			if ((value & currentBit) != 0)
				result.value.add(Values.getFromValue(currentBit));
		}
		return result;
	}

	/**
	 * Get the value that is considered to be the default.
	 * 
	 * @return The default value.
	 */
	public static Base64FormattingOptions getDefault() {
		return NONE;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Base64FormattingOptions))
			return false;
		Base64FormattingOptions e = (Base64FormattingOptions) o;
		return this.value.equals(e.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}