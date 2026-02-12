package agi.foundation.compatibility;

import javax.annotation.Nonnull;

/**
 * Specifies the position in a stream to use for seeking.
 */
public enum SeekOrigin implements Enumeration {
    /**
     * Specifies the beginning of a stream.
     */
    BEGIN(0),
    /**
     * Specifies the current position within a stream.
     */
    CURRENT(1),
    /**
     * Specifies the end of a stream.
     */
    END(2);

    private final int value;

    SeekOrigin(int value) {
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
    @Nonnull
    public static SeekOrigin getDefault() {
        return BEGIN;
    }
}