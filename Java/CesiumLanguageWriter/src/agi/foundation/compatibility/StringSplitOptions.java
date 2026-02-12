package agi.foundation.compatibility;

import java.util.EnumSet;

import javax.annotation.Nonnull;

/**
 * Specifies options for applicable method overloads, such as whether to omit empty
 * substrings from the returned array or trim whitespace from substrings.
 */
public class StringSplitOptions implements Enumeration {
    /**
     * Use the default options when splitting strings.
     */
    @Nonnull
    public static final StringSplitOptions NONE = new StringSplitOptions();
    /**
     * Omit array elements that contain an empty string from the result.
     */
    @Nonnull
    public static final StringSplitOptions REMOVE_EMPTY_ENTRIES = new StringSplitOptions(EnumSet.of(Values.REMOVE_EMPTY_ENTRIES));

    private enum Values implements Enumeration {
        NONE(0),
        REMOVE_EMPTY_ENTRIES(1);

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
                return REMOVE_EMPTY_ENTRIES;
            default:
                throw new IllegalArgumentException("Undefined enum value.");
            }
        }
    }

    @Nonnull
    private final EnumSet<Values> value;

    private StringSplitOptions() {
        this.value = EnumSet.noneOf(Values.class);
    }

    private StringSplitOptions(@Nonnull StringSplitOptions e) {
        this.value = EnumSet.copyOf(e.value);
    }

    private StringSplitOptions(@Nonnull EnumSet<Values> value) {
        this.value = value;
    }

    private StringSplitOptions(@Nonnull StringSplitOptions e1, @Nonnull StringSplitOptions e2) {
        this(e1);
        this.value.addAll(e2.value);
    }

    private StringSplitOptions(@Nonnull StringSplitOptions... enums) {
        this();
        for (StringSplitOptions e : enums) {
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
    public static StringSplitOptions of(@Nonnull StringSplitOptions e1, @Nonnull StringSplitOptions e2) {
        return new StringSplitOptions(e1, e2);
    }

    /**
     * Create a new value built by combining the specified values.
     *
     * @return A value that is the combination of the specified values.
     * @param enums
     *            the values that the new value will contain.
     */
    @Nonnull
    public static StringSplitOptions of(@Nonnull StringSplitOptions... enums) {
        return new StringSplitOptions(enums);
    }

    /**
     * Add the specified value to the current set and return the result.
     *
     * @return A value that is the combination of the current set and the specified value.
     * @param other
     *            the new value to be added into the current set.
     */
    @Nonnull
    public StringSplitOptions add(@Nonnull StringSplitOptions other) {
        return new StringSplitOptions(this, other);
    }

    /**
     * Create a new value built by logical and-ing the specified values.
     *
     * @return A value that is the logical and of the specified values.
     * @param enums
     *            the values.
     */
    @Nonnull
    public static StringSplitOptions logicalAnd(@Nonnull StringSplitOptions... enums) {
        StringSplitOptions result = new StringSplitOptions(EnumSet.allOf(Values.class));
        for (StringSplitOptions e : enums) {
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
    public StringSplitOptions remove(@Nonnull StringSplitOptions other) {
        StringSplitOptions result = new StringSplitOptions(this);
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
    public boolean contains(@Nonnull StringSplitOptions other) {
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
    public static StringSplitOptions getFromValue(int value) {
        StringSplitOptions result = new StringSplitOptions();
        for (int i = 0; i <= 0; ++i) {
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
    public static StringSplitOptions[] values() {
        return new StringSplitOptions[] {
            NONE,
            REMOVE_EMPTY_ENTRIES
        };
    }

    /**
     * Get the value that is considered to be the default.
     *
     * @return The default value.
     */
    @Nonnull
    public static StringSplitOptions getDefault() {
        return NONE;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StringSplitOptions))
            return false;
        StringSplitOptions e = (StringSplitOptions) o;
        return value.equals(e.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}