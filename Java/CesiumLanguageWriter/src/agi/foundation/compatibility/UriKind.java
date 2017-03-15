package agi.foundation.compatibility;

public enum UriKind implements Enumeration {
    RELATIVE_OR_ABSOLUTE(0),
    ABSOLUTE(1),
    RELATIVE(2);
    private final int value;

    UriKind(int value) {
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
    public static UriKind getFromValue(int value) {
        switch (value) {
        case 0:
            return RELATIVE_OR_ABSOLUTE;
        case 1:
            return ABSOLUTE;
        case 2:
            return RELATIVE;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
     * Get the enum constant that is considered to be the default.
     *
     * @return The default enum constant.
     */
    public static UriKind getDefault() {
        return RELATIVE_OR_ABSOLUTE;
    }
}