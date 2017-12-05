package agi.foundation.compatibility;

import java.util.EnumSet;

import javax.annotation.Nonnull;

/**
 * Determines the styles permitted in numeric string arguments that are passed to the
 * Parse methods of the numeric base type classes.
 */
public class NumberStyles implements Enumeration {
    /**
     * Indicates that none of the bit styles are allowed.
     */
    @Nonnull
    public static final NumberStyles NONE = new NumberStyles();

    /**
     * Indicates that the numeric string is parsed as currency if it contains a currency
     * symbol; otherwise, it is parsed as a number. Valid currency symbols are determined
     * by the {@link NumberFormatInfo.CurrencySymbol} property of .
     */
    @Nonnull
    public static final NumberStyles ALLOW_CURRENCY_SYMBOL = new NumberStyles(Values.ALLOW_CURRENCY_SYMBOL);

    /**
     * Indicates that the numeric string can have a decimal point. Valid decimal point
     * characters are determined by the {@link NumberFormatInfo.NumberDecimalSeparator}
     * and properties of .
     */
    @Nonnull
    public static final NumberStyles ALLOW_DECIMAL_POINT = new NumberStyles(Values.ALLOW_DECIMAL_POINT);

    /**
     * Indicates that the numeric string can be in exponential notation.
     */
    @Nonnull
    public static final NumberStyles ALLOW_EXPONENT = new NumberStyles(Values.ALLOW_EXPONENT);

    /**
     * Indicates that the numeric string represents a hexadecimal value. Valid hexadecimal
     * values include the numeric digits 0-9 and the hexadecimal digits A-F and a-f.
     * Hexadecimal values can be left-padded with zeros. Strings parsed using this style
     * are not permitted to be prefixed with "0x".
     */
    @Nonnull
    public static final NumberStyles ALLOW_HEX_SPECIFIER = new NumberStyles(Values.ALLOW_HEX_SPECIFIER);

    /**
     * Indicates that the numeric string can have a leading sign. Valid leading sign
     * characters are determined by the {@link NumberFormatInfo.PositiveSign} and
     * properties of .
     */
    @Nonnull
    public static final NumberStyles ALLOW_LEADING_SIGN = new NumberStyles(Values.ALLOW_LEADING_SIGN);

    /**
     * Indicates that a leading white-space character must be ignored during parsing.
     * Valid white-space characters have the Unicode values U+0009, U+000A, U+000B,
     * U+000C, U+000D, and U+0020.
     */
    @Nonnull
    public static final NumberStyles ALLOW_LEADING_WHITE = new NumberStyles(Values.ALLOW_LEADING_WHITE);

    /**
     * Indicates that the numeric string can have one pair of parentheses enclosing the
     * number.
     */
    @Nonnull
    public static final NumberStyles ALLOW_PARENTHESES = new NumberStyles(Values.ALLOW_PARENTHESES);

    /**
     * Indicates that the numeric string can have group separators; for example,
     * separating the hundreds from the thousands. Valid group separator characters are
     * determined by the {@link NumberFormatInfo.NumberGroupSeparator} and properties of
     * and the number of digits in each group is determined by the and properties of .
     */
    @Nonnull
    public static final NumberStyles ALLOW_THOUSANDS = new NumberStyles(Values.ALLOW_THOUSANDS);

    /**
     * Indicates that the numeric string can have a trailing sign. Valid trailing sign
     * characters are determined by the {@link NumberFormatInfo.PositiveSign} and
     * properties of .
     */
    @Nonnull
    public static final NumberStyles ALLOW_TRAILING_SIGN = new NumberStyles(Values.ALLOW_TRAILING_SIGN);

    /**
     * Indicates that trailing white-space character must be ignored during parsing. Valid
     * white-space characters have the Unicode values U+0009, U+000A, U+000B, U+000C,
     * U+000D, and U+0020.
     */
    @Nonnull
    public static final NumberStyles ALLOW_TRAILING_WHITE = new NumberStyles(Values.ALLOW_TRAILING_WHITE);

    /**
     * Indicates that all styles, except AllowHexSpecifier, are used. This is a composite
     * number style.
     */
    @Nonnull
    public static final NumberStyles ANY = new NumberStyles(Values.ALLOW_LEADING_WHITE, Values.ALLOW_TRAILING_WHITE, Values.ALLOW_LEADING_SIGN,
            Values.ALLOW_TRAILING_SIGN, Values.ALLOW_PARENTHESES, Values.ALLOW_DECIMAL_POINT, Values.ALLOW_THOUSANDS, Values.ALLOW_EXPONENT,
            Values.ALLOW_CURRENCY_SYMBOL);

    /**
     * Indicates that all styles, except AllowExponent and AllowHexSpecifier, are used.
     * This is a composite number style.
     */
    @Nonnull
    public static final NumberStyles CURRENCY = new NumberStyles(Values.ALLOW_LEADING_WHITE, Values.ALLOW_TRAILING_WHITE, Values.ALLOW_LEADING_SIGN,
            Values.ALLOW_TRAILING_SIGN, Values.ALLOW_PARENTHESES, Values.ALLOW_DECIMAL_POINT, Values.ALLOW_THOUSANDS, Values.ALLOW_CURRENCY_SYMBOL);

    /**
     * Indicates that the AllowLeadingWhite, AllowTrailingWhite, AllowLeadingSign,
     * AllowDecimalPoint, and AllowExponent styles are used. This is a composite number
     * style.
     */
    @Nonnull
    public static final NumberStyles FLOAT = new NumberStyles(Values.ALLOW_LEADING_WHITE, Values.ALLOW_TRAILING_WHITE, Values.ALLOW_LEADING_SIGN,
            Values.ALLOW_DECIMAL_POINT, Values.ALLOW_EXPONENT);

    /**
     * Indicates that the AllowLeadingWhite, AllowTrailingWhite, and AllowHexSpecifier
     * styles are used. This is a composite number style.
     */
    @Nonnull
    public static final NumberStyles HEX_NUMBER = new NumberStyles(Values.ALLOW_LEADING_WHITE, Values.ALLOW_TRAILING_WHITE,
            Values.ALLOW_HEX_SPECIFIER);

    /**
     * Indicates that the AllowLeadingWhite, AllowTrailingWhite, and AllowLeadingSign
     * styles are used. This is a composite number style.
     */
    @Nonnull
    public static final NumberStyles INTEGER = new NumberStyles(Values.ALLOW_LEADING_WHITE, Values.ALLOW_TRAILING_WHITE, Values.ALLOW_LEADING_SIGN);

    /**
     * Indicates that the AllowLeadingWhite, AllowTrailingWhite, AllowLeadingSign,
     * AllowTrailingSign, AllowDecimalPoint, and AllowThousands styles are used. This is a
     * composite number style.
     */
    @Nonnull
    public static final NumberStyles NUMBER = new NumberStyles(Values.ALLOW_LEADING_WHITE, Values.ALLOW_TRAILING_WHITE, Values.ALLOW_LEADING_SIGN,
            Values.ALLOW_TRAILING_SIGN, Values.ALLOW_DECIMAL_POINT, Values.ALLOW_THOUSANDS);

    private enum Values {
        ALLOW_CURRENCY_SYMBOL(256),
        ALLOW_DECIMAL_POINT(32),
        ALLOW_EXPONENT(128),
        ALLOW_HEX_SPECIFIER(512),
        ALLOW_LEADING_SIGN(4),
        ALLOW_LEADING_WHITE(1),
        ALLOW_PARENTHESES(16),
        ALLOW_THOUSANDS(64),
        ALLOW_TRAILING_SIGN(8),
        ALLOW_TRAILING_WHITE(2),
        NONE(0);
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
        value = EnumSet.noneOf(Values.class);
    }

    private NumberStyles(@Nonnull NumberStyles... enums) {
        this();
        for (NumberStyles e : enums) {
            value.addAll(e.value);
        }
    }

    private NumberStyles(@Nonnull Values... values) {
        this();
        for (Values v : values) {
            value.add(v);
        }
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
        for (int i = 0; i <= 9; ++i) {
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
                ALLOW_CURRENCY_SYMBOL,
                ALLOW_DECIMAL_POINT,
                ALLOW_EXPONENT,
                ALLOW_HEX_SPECIFIER,
                ALLOW_LEADING_SIGN,
                ALLOW_LEADING_WHITE,
                ALLOW_PARENTHESES,
                ALLOW_THOUSANDS,
                ALLOW_TRAILING_SIGN,
                ALLOW_TRAILING_WHITE,
                ANY,
                CURRENCY,
                FLOAT,
                HEX_NUMBER,
                INTEGER,
                NONE,
                NUMBER
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