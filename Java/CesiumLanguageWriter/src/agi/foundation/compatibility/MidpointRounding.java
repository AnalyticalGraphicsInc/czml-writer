package agi.foundation.compatibility;

/**
 * Specifies how mathematical rounding methods should process a number that is midway
 * between two numbers.
 */
public enum MidpointRounding implements Enumeration {
    TO_EVEN(0), AWAY_FROM_ZERO(1);
    private final int value;

    MidpointRounding(int value) {
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
    public static MidpointRounding getDefault() {
        return TO_EVEN;
    }
}