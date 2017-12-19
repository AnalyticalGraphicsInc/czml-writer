package agi.foundation.compatibility;

import javax.annotation.Nonnull;

/**
 * Enumeration indicating how the expected message parameter is to be used
 */
public enum MessageMatch implements Enumeration {
    /**
     * Expect an exact match
     */
    EXACT(0),

    /**
     * Expect a message containing the parameter string
     */
    CONTAINS(1),

    /**
     * Match the regular expression provided as a parameter
     */
    // REGEX(2),

    /**
     * Expect a message that starts with the parameter string
     */
    STARTS_WITH(3);

    private final int value;

    MessageMatch(int value) {
        this.value = value;
    }

    /**
     * Get the numeric value associated with this enum constant.
     *
     * @return A numeric value.
     */
    @Override
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
    @Nonnull
    public static MessageMatch getFromValue(int value) {
        switch (value) {
        case 0:
            return EXACT;
        case 1:
            return CONTAINS;
        // case 2:
        // return REGEX;
        case 3:
            return STARTS_WITH;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
     * Get the enum constant that is considered to be the default.
     *
     * @return The default enum constant.
     */
    @Nonnull
    public static MessageMatch getDefault() {
        return EXACT;
    }
}