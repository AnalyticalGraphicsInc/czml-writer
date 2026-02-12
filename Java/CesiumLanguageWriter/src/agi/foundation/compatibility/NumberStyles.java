package agi.foundation.compatibility;

import java.util.EnumSet;

import javax.annotation.Nonnull;

/**
 * Determines the styles permitted in numeric string arguments that are passed to the
 * {@code Parse} and {@code TryParse} methods of the integral and floating-point numeric
 * types.
 */
public class NumberStyles implements Enumeration {
    /**
     * Indicates that no style elements, such as leading or trailing white space,
     * thousands separators, or a decimal separator, can be present in the parsed string.
     * The string to be parsed must consist of integral decimal digits only.
     */
    @Nonnull
    public static final NumberStyles NONE = new NumberStyles();
    /**
     * Indicates that leading white-space characters can be present in the parsed string.
     * Valid white-space characters have the Unicode values U+0009, U+000A, U+000B,
     * U+000C, U+000D, and U+0020. Note that this is a subset of the characters for which
     * the {@link Character#isWhitespace(char)} method returns {@code true}.
     */
    @Nonnull
    public static final NumberStyles ALLOW_LEADING_WHITE = new NumberStyles(EnumSet.of(Values.ALLOW_LEADING_WHITE));
    /**
     * Indicates that trailing white-space characters can be present in the parsed string.
     * Valid white-space characters have the Unicode values U+0009, U+000A, U+000B,
     * U+000C, U+000D, and U+0020. Note that this is a subset of the characters for which
     * the {@link Character#isWhitespace(char)} method returns {@code true}.
     */
    @Nonnull
    public static final NumberStyles ALLOW_TRAILING_WHITE = new NumberStyles(EnumSet.of(Values.ALLOW_TRAILING_WHITE));
    /**
     * Indicates that the numeric string can have a leading sign.
     */
    @Nonnull
    public static final NumberStyles ALLOW_LEADING_SIGN = new NumberStyles(EnumSet.of(Values.ALLOW_LEADING_SIGN));
    /**
     * Indicates that the numeric string can have a trailing sign.
     */
    @Nonnull
    public static final NumberStyles ALLOW_TRAILING_SIGN = new NumberStyles(EnumSet.of(Values.ALLOW_TRAILING_SIGN));
    /**
     * Indicates that the numeric string can have one pair of parentheses enclosing the
     * number. The parentheses indicate that the string to be parsed represents a negative
     * number.
     */
    @Nonnull
    public static final NumberStyles ALLOW_PARENTHESES = new NumberStyles(EnumSet.of(Values.ALLOW_PARENTHESES));
    /**
     * Indicates that the numeric string can have a decimal point. The decimal separator
     * character is determined by the {@code NumberDecimalSeparator}
     * ({@link NumberFormatInfo#getNumberDecimalSeparator get}) property.
     */
    @Nonnull
    public static final NumberStyles ALLOW_DECIMAL_POINT = new NumberStyles(EnumSet.of(Values.ALLOW_DECIMAL_POINT));
    /**
     * Indicates that the numeric string can have group separators, such as symbols that
     * separate hundreds from thousands.
     */
    @Nonnull
    public static final NumberStyles ALLOW_THOUSANDS = new NumberStyles(EnumSet.of(Values.ALLOW_THOUSANDS));
    /**
     * Indicates that the numeric string can be in exponential notation. The
     * {@link NumberStyles#ALLOW_EXPONENT} flag allows the parsed string to contain an
     * exponent that begins with the "E" or "e" character and that is followed by an
     * optional positive or negative sign and an integer. In other words, it successfully
     * parses strings in the form nnnExx, nnnE+xx, and nnnE-xx. It does not allow a
     * decimal separator or sign in the significand or mantissa; to allow these elements
     * in the string to be parsed, use the {@link NumberStyles#ALLOW_DECIMAL_POINT} and
     * {@link NumberStyles#ALLOW_LEADING_SIGN} flags, or use a composite style that
     * includes these individual flags.
     */
    @Nonnull
    public static final NumberStyles ALLOW_EXPONENT = new NumberStyles(EnumSet.of(Values.ALLOW_EXPONENT));
    /**
     * Indicates that the numeric string can contain a currency symbol.
     */
    @Nonnull
    public static final NumberStyles ALLOW_CURRENCY_SYMBOL = new NumberStyles(EnumSet.of(Values.ALLOW_CURRENCY_SYMBOL));
    /**
     * Indicates that the numeric string represents a hexadecimal value. Valid hexadecimal
     * values include the numeric digits 0-9 and the hexadecimal digits A-F and a-f.
     * Strings that are parsed using this style cannot be prefixed with "0x" or "&amp;h".
     * A string that is parsed with the {@link NumberStyles#ALLOW_HEX_SPECIFIER} style
     * will always be interpreted as a hexadecimal value. The only flags that can be
     * combined with {@link NumberStyles#ALLOW_HEX_SPECIFIER} are
     * {@link NumberStyles#ALLOW_LEADING_WHITE} and
     * {@link NumberStyles#ALLOW_TRAILING_WHITE}. The {@link NumberStyles} enumeration
     * includes a composite style, {@link NumberStyles#HEX_NUMBER}, that consists of these
     * three flags.
     */
    @Nonnull
    public static final NumberStyles ALLOW_HEX_SPECIFIER = new NumberStyles(EnumSet.of(Values.ALLOW_HEX_SPECIFIER));
    /**
     * Indicates that the {@link NumberStyles#ALLOW_LEADING_WHITE},
     * {@link NumberStyles#ALLOW_TRAILING_WHITE}, and
     * {@link NumberStyles#ALLOW_LEADING_SIGN} styles are used. This is a composite number
     * style.
     */
    @Nonnull
    public static final NumberStyles INTEGER = new NumberStyles(EnumSet.of(Values.ALLOW_LEADING_SIGN, Values.ALLOW_TRAILING_WHITE, Values.ALLOW_LEADING_WHITE));
    /**
     * Indicates that the {@link NumberStyles#ALLOW_LEADING_WHITE},
     * {@link NumberStyles#ALLOW_TRAILING_WHITE}, and
     * {@link NumberStyles#ALLOW_HEX_SPECIFIER} styles are used. This is a composite
     * number style.
     */
    @Nonnull
    public static final NumberStyles HEX_NUMBER = new NumberStyles(EnumSet.of(Values.ALLOW_HEX_SPECIFIER, Values.ALLOW_TRAILING_WHITE, Values.ALLOW_LEADING_WHITE));
    /**
     * Indicates that the {@link NumberStyles#ALLOW_LEADING_WHITE},
     * {@link NumberStyles#ALLOW_TRAILING_WHITE}, {@link NumberStyles#ALLOW_LEADING_SIGN},
     * {@link NumberStyles#ALLOW_TRAILING_SIGN}, {@link NumberStyles#ALLOW_DECIMAL_POINT},
     * and {@link NumberStyles#ALLOW_THOUSANDS} styles are used. This is a composite
     * number style.
     */
    @Nonnull
    public static final NumberStyles NUMBER = new NumberStyles(INTEGER, ALLOW_THOUSANDS, ALLOW_DECIMAL_POINT, ALLOW_TRAILING_SIGN);
    /**
     * Indicates that the {@link NumberStyles#ALLOW_LEADING_WHITE},
     * {@link NumberStyles#ALLOW_TRAILING_WHITE}, {@link NumberStyles#ALLOW_LEADING_SIGN},
     * {@link NumberStyles#ALLOW_DECIMAL_POINT}, and {@link NumberStyles#ALLOW_EXPONENT}
     * styles are used. This is a composite number style.
     */
    @Nonnull
    public static final NumberStyles FLOAT = new NumberStyles(INTEGER, ALLOW_EXPONENT, ALLOW_DECIMAL_POINT);
    /**
     * Indicates that all styles except {@link NumberStyles#ALLOW_EXPONENT} and
     * {@link NumberStyles#ALLOW_HEX_SPECIFIER} are used. This is a composite number
     * style.
     */
    @Nonnull
    public static final NumberStyles CURRENCY = new NumberStyles(NUMBER, ALLOW_CURRENCY_SYMBOL, ALLOW_PARENTHESES);
    /**
     * Indicates that all styles except {@link NumberStyles#ALLOW_HEX_SPECIFIER} are used.
     * This is a composite number style.
     */
    @Nonnull
    public static final NumberStyles ANY = new NumberStyles(CURRENCY, ALLOW_EXPONENT);

    private enum Values implements Enumeration {
        NONE(0),
        ALLOW_LEADING_WHITE(1),
        ALLOW_TRAILING_WHITE(2),
        ALLOW_LEADING_SIGN(4),
        ALLOW_TRAILING_SIGN(8),
        ALLOW_PARENTHESES(16),
        ALLOW_DECIMAL_POINT(32),
        ALLOW_THOUSANDS(64),
        ALLOW_EXPONENT(128),
        ALLOW_CURRENCY_SYMBOL(256),
        ALLOW_HEX_SPECIFIER(512);

        private final int value;

        Values(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Nonnull
        public static Values getFromValue(int value) {
            switch (value) {
            case 0:
                return NONE;
            case 1:
                return ALLOW_LEADING_WHITE;
            case 2:
                return ALLOW_TRAILING_WHITE;
            case 4:
                return ALLOW_LEADING_SIGN;
            case 8:
                return ALLOW_TRAILING_SIGN;
            case 16:
                return ALLOW_PARENTHESES;
            case 32:
                return ALLOW_DECIMAL_POINT;
            case 64:
                return ALLOW_THOUSANDS;
            case 128:
                return ALLOW_EXPONENT;
            case 256:
                return ALLOW_CURRENCY_SYMBOL;
            case 512:
                return ALLOW_HEX_SPECIFIER;
            default:
                throw new IllegalArgumentException("Undefined enum value.");
            }
        }
    }

    @Nonnull
    private final EnumSet<Values> value;

    private NumberStyles() {
        this.value = EnumSet.noneOf(Values.class);
    }

    private NumberStyles(@Nonnull NumberStyles e) {
        this.value = EnumSet.copyOf(e.value);
    }

    private NumberStyles(@Nonnull EnumSet<Values> value) {
        this.value = value;
    }

    private NumberStyles(@Nonnull NumberStyles e1, @Nonnull NumberStyles e2) {
        this(e1);
        this.value.addAll(e2.value);
    }

    private NumberStyles(@Nonnull NumberStyles... enums) {
        this();
        for (NumberStyles e : enums) {
            this.value.addAll(e.value);
        }
    }

    /**
     * Create a new value built by combining the specified values.
     *
     * @return A value that is the combination of the specified values.
     * @param e1
     *            a value that the new value will contain.
     * @param e2
     *            a value that the new value will contain.
     */
    @Nonnull
    public static NumberStyles of(@Nonnull NumberStyles e1, @Nonnull NumberStyles e2) {
        return new NumberStyles(e1, e2);
    }

    /**
     * Create a new value built by combining the specified values.
     *
     * @return A value that is the combination of the specified values.
     * @param enums
     *            the values that the new value will contain.
     */
    @Nonnull
    public static NumberStyles of(@Nonnull NumberStyles... enums) {
        return new NumberStyles(enums);
    }

    /**
     * Add the specified value to the current set and return the result.
     *
     * @return A value that is the combination of the current set and the specified value.
     * @param other
     *            the new value to be added into the current set.
     */
    @Nonnull
    public NumberStyles add(@Nonnull NumberStyles other) {
        return new NumberStyles(this, other);
    }

    /**
     * Create a new value built by logical and-ing the specified values.
     *
     * @return A value that is the logical and of the specified values.
     * @param enums
     *            the values.
     */
    @Nonnull
    public static NumberStyles logicalAnd(@Nonnull NumberStyles... enums) {
        NumberStyles result = new NumberStyles(EnumSet.allOf(Values.class));
        for (NumberStyles e : enums) {
            result.value.retainAll(e.value);
        }
        return result;
    }

    /**
     * Remove the specified value from the current set and return the result.
     *
     * @return A value that is the current set without the specified value.
     * @param other
     *            the new value to be removed from the current set.
     */
    @Nonnull
    public NumberStyles remove(@Nonnull NumberStyles other) {
        NumberStyles result = new NumberStyles(this);
        result.value.removeAll(other.value);
        return result;
    }

    /**
     * Determines whether the specified value is present in the current set.
     *
     * @return True if the specified value is present in the current set, false otherwise.
     * @param other
     *            the value to be checked against the current set.
     */
    public boolean contains(@Nonnull NumberStyles other) {
        return value.containsAll(other.value);
    }

    /**
     * Get the numeric value associated with this value.
     *
     * @return A numeric value.
     */
    @Override
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
    @Nonnull
    public static NumberStyles getFromValue(int value) {
        NumberStyles result = new NumberStyles();
        for (int i = 0; i <= 7; ++i) {
            int currentBit = 1 << i;
            if ((value & currentBit) != 0)
                result.value.add(Values.getFromValue(currentBit));
        }
        return result;
    }

    /**
     * Returns an array containing the constants of this enum type, in the order they're
     * declared.
     *
     * @return The constants of this enum type.
     */
    @Nonnull
    public static NumberStyles[] values() {
        return new NumberStyles[] {
            NONE,
            ALLOW_LEADING_WHITE,
            ALLOW_TRAILING_WHITE,
            ALLOW_LEADING_SIGN,
            ALLOW_TRAILING_SIGN,
            ALLOW_DECIMAL_POINT,
            ALLOW_THOUSANDS,
            ALLOW_EXPONENT,
            INTEGER,
            NUMBER,
            FLOAT
        };
    }

    /**
     * Get the value that is considered to be the default.
     *
     * @return The default value.
     */
    @Nonnull
    public static NumberStyles getDefault() {
        return NONE;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NumberStyles))
            return false;
        NumberStyles e = (NumberStyles) o;
        return value.equals(e.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}