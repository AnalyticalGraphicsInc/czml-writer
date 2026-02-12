package agi.foundation.compatibility;

import javax.annotation.Nonnull;

/**
 * Specifies the strategy that mathematical rounding methods should use to round a number.
 */
public enum MidpointRounding implements Enumeration {
    /**
     * The strategy of rounding to the nearest number, and when a number is halfway
     * between two others, it's rounded toward the nearest even number.
     */
    TO_EVEN(0),
    /**
     * The strategy of rounding to the nearest number, and when a number is halfway
     * between two others, it's rounded toward the nearest number that's away from zero.
     */
    AWAY_FROM_ZERO(1);

    private final int value;

    MidpointRounding(int value) {
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
    public static MidpointRounding getFromValue(int value) {
        switch (value) {
        case 0:
            return TO_EVEN;
        case 1:
            return AWAY_FROM_ZERO;
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
    public static MidpointRounding getDefault() {
        return TO_EVEN;
    }
}