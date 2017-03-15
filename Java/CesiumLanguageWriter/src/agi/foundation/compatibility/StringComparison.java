package agi.foundation.compatibility;

/**
 * Specifies the culture, case, and sort rules to be used by certain overloads of the
 * {@link StringHelper#compare(String,String)} and {@link String#equals(Object)} methods.
 */
public enum StringComparison implements Enumeration {
    CURRENT_CULTURE(0),
    CURRENT_CULTURE_IGNORE_CASE(1),
    INVARIANT_CULTURE(2),
    INVARIANT_CULTURE_IGNORE_CASE(3),
    ORDINAL(4),
    ORDINAL_IGNORE_CASE(5);
    private final int value;

    StringComparison(int value) {
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
    public static StringComparison getFromValue(int value) {
        switch (value) {
        case 0:
            return CURRENT_CULTURE;
        case 1:
            return CURRENT_CULTURE_IGNORE_CASE;
        case 2:
            return INVARIANT_CULTURE;
        case 3:
            return INVARIANT_CULTURE_IGNORE_CASE;
        case 4:
            return ORDINAL;
        case 5:
            return ORDINAL_IGNORE_CASE;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
     * Get the enum constant that is considered to be the default.
     *
     * @return The default enum constant.
     */
    public static StringComparison getDefault() {
        return CURRENT_CULTURE;
    }
}