package agi.foundation.compatibility;

import javax.annotation.Nonnull;

/**
 * Specifies the culture, case, and sort rules to be used by certain overloads of the
 * string compare and equals methods.
 */
public enum StringComparison implements Enumeration {
    /**
     * Compare strings using culture-sensitive sort rules and the current culture.
     */
    CURRENT_CULTURE(0),
    /**
     * Compare strings using culture-sensitive sort rules, the current culture, and
     * ignoring the case of the strings being compared.
     */
    CURRENT_CULTURE_IGNORE_CASE(1),
    /**
     * Compare strings using culture-sensitive sort rules and the invariant culture.
     */
    INVARIANT_CULTURE(2),
    /**
     * Compare strings using culture-sensitive sort rules, the invariant culture, and
     * ignoring the case of the strings being compared.
     */
    INVARIANT_CULTURE_IGNORE_CASE(3),
    /**
     * Compare strings using ordinal (binary) sort rules.
     */
    ORDINAL(4),
    /**
     * Compare strings using ordinal (binary) sort rules and ignoring the case of the
     * strings being compared.
     */
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
    @Nonnull
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
    @Nonnull
    public static StringComparison getDefault() {
        return CURRENT_CULTURE;
    }
}