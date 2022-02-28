package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper methods related to Strings.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class StringHelper {
    @Nonnull
    static final String[] emptyStringArray = new String[0];
    @Nonnull
    private static final Pattern splitWhitespacePattern;

    static {
        // this set of characters is taken from the .NET documentation for
        // String.Split.
        final char[] splitWhitespaceChars = {
                '\u0009',
                '\n',
                '\u000b',
                '\u000c',
                '\r',
                '\u0020',
                '\u0085',
                '\u00a0',
                '\u1680',
                '\u2000',
                '\u2001',
                '\u2002',
                '\u2003',
                '\u2004',
                '\u2005',
                '\u2006',
                '\u2007',
                '\u2008',
                '\u2009',
                '\u200a',
                '\u200b',
                '\u2028',
                '\u2029',
                '\u3000',
        };

        // create a pattern matching any character in the above set
        StringBuilder pattern = new StringBuilder(2 + splitWhitespaceChars.length);
        pattern.append('[').append(splitWhitespaceChars, 0, splitWhitespaceChars.length).append(']');

        splitWhitespacePattern = Pattern.compile(pattern.toString());
    }

    /**
     * This set of characters is taken from the .NET documentation for String.Trim and has
     * one extra character in it (the last one) than the above set for String.Split. The
     * .NET doc makes special note of this.
     */
    @Nonnull
    private static final char[] trimWhitespaceChars = {
            '\u0009',
            '\n',
            '\u000b',
            '\u000c',
            '\r',
            '\u0020',
            '\u0085',
            '\u00a0',
            '\u1680',
            '\u2000',
            '\u2001',
            '\u2002',
            '\u2003',
            '\u2004',
            '\u2005',
            '\u2006',
            '\u2007',
            '\u2008',
            '\u2009',
            '\u200a',
            '\u200b',
            '\u2028',
            '\u2029',
            '\u3000',
            '\ufeff',
    };

    /**
     * Represents the empty string.
     */
    @Nonnull
    public static final String empty = "";

    private StringHelper() {}

    /**
     * Initializes a new instance of the String class to the value indicated by a
     * specified Unicode character repeated a specified number of times.
     *
     * @param c
     *            A Unicode character.
     * @param count
     *            The number of times c occurs.
     * @return the new String.
     */
    @Nonnull
    public static String create(char c, int count) {
        char[] array = new char[count];
        Arrays.fill(array, c);
        return new String(array);
    }

    /**
     * Initializes a new instance of the StringBuilder class using the specified capacity.
     *
     * @param capacity
     *            The suggested starting size of this instance.
     * @return the new StringBuilder
     */
    @Nonnull
    public static StringBuilder createStringBuilder(int capacity) {
        return new StringBuilder(capacity);
    }

    public static boolean isEmpty(@Nullable String str) {
        return str != null && str.length() == 0;
    }

    /**
     * Indicates whether the specified string is null or an Empty string.
     *
     * @param str
     *            The string.
     * @return true if the value parameter is null or an empty string (""); otherwise,
     *         false.
     */
    public static boolean isNullOrEmpty(@Nullable String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotNullOrEmpty(@Nullable String str) {
        return !isNullOrEmpty(str);
    }

    /**
     * Returns a string array that contains the substrings in this instance that are
     * delimited by elements of a specified Unicode character array.
     *
     * @param s
     *            the String to split.
     * @param separator
     *            An array of Unicode characters that delimit the substrings in this
     *            instance, an empty array that contains no delimiters, or null.
     * @return An array whose elements contain the substrings in this instance that are
     *         delimited by one or more characters in separator.
     */
    public static String[] split(@Nonnull String s, @Nullable char... separator) {
        return split(s, separator, Integer.MAX_VALUE, StringSplitOptions.NONE);
    }

    /**
     * Returns a string array that contains the substrings in this instance that are
     * delimited by elements of a specified Unicode character array. A parameter specifies
     * the maximum number of substrings to return.
     *
     * @param s
     *            the String to split.
     * @param separator
     *            An array of Unicode characters that delimit the substrings in this
     *            instance, an empty array that contains no delimiters, or null.
     * @param count
     *            The maximum number of substrings to return.
     * @return An array whose elements contain the substrings in this instance that are
     *         delimited by one or more characters in separator.
     */
    public static String[] split(@Nonnull String s, @Nullable char[] separator, int count) {
        return split(s, separator, count, StringSplitOptions.NONE);
    }

    /**
     * Returns a string array that contains the substrings in this string that are
     * delimited by elements of a specified Unicode character array. A parameter specifies
     * whether to return empty array elements.
     *
     * @param s
     *            the String to split.
     * @param separator
     *            An array of Unicode characters that delimit the substrings in this
     *            instance, an empty array that contains no delimiters, or null.
     * @param count
     *            The maximum number of substrings to return.
     * @param options
     *            Specify <code>RemoveEmptyEntries</code> to omit empty array elements
     *            from the array returned, or <code>None</code> to include empty array
     *            elements in the array returned.
     * @return An array whose elements contain the substrings in this string that are
     *         delimited by one or more characters in separator.
     */
    public static String[] split(@Nonnull String s, @Nullable char[] separator, int count, @Nonnull StringSplitOptions options) {
        String regex = null;
        if (separator != null && separator.length > 0) {
            StringBuilder builder = new StringBuilder(2 + 6 * separator.length);
            builder.append('[');
            for (char separatorChar : separator) {
                // Encode the characters with \\uhhhh where hhhh is the hex
                // representation of the value of the character. Alternatively,
                // we could just escape the characters that have special meaning
                // in a regular expression, but that approach is more error prone.
                builder.append("\\u").append(StringHelper.padLeft(Integer.toHexString(separatorChar), 4, '0'));
            }
            builder.append(']');
            regex = builder.toString();
        }

        return split(s, regex, options, count);
    }

    /**
     * Do the work of splitting the string according to the specified regex and options.
     */
    private static String[] split(@Nonnull String s, @Nullable String regex, @Nonnull StringSplitOptions options, int count) {
        assertNonNull(s, "s");
        assertNonNull(options, "options");

        boolean removeEmptyEntries = options == StringSplitOptions.REMOVE_EMPTY_ENTRIES;
        if (count == 0 || removeEmptyEntries && s.length() == 0)
            return emptyStringArray;

        if (count == 1 || s.length() == 0) {
            return new String[] {
                    s
            };
        }

        Pattern pattern = regex == null ? splitWhitespacePattern : Pattern.compile(regex);

        ArrayList<String> result = new ArrayList<>();
        boolean firstToken = true;
        int lastMatchEnd = 0;

        try (Scanner scanner = new Scanner(s)) {
            scanner.useDelimiter(pattern);

            while (scanner.hasNext()) {
                // grab next token
                String next = scanner.next();

                MatchResult match = scanner.match();
                if (firstToken && match.start() > 0 && !removeEmptyEntries) {
                    // if A) this is the first token, B) the token doesn't start at
                    // index 0, and C) we're not supposed to remove empty entries,
                    // then we've already skipped past one delimiter, and so we
                    // should add an empty result to represent the zero-length
                    // "match" before the first delimiter.
                    result.add(empty);
                }

                firstToken = false;

                if (removeEmptyEntries && next.length() == 0) {
                    // if the token is empty, and we are being asked to remove empty
                    // entries, then skip it
                    continue;
                }

                if (count > 0 && result.size() >= count - 1) {
                    // if we've exceeded our maximum result count, just use the
                    // end of the input string, starting from the current
                    // token's start, as the final token, then break
                    result.add(s.substring(match.start()));
                    lastMatchEnd = s.length();
                    break;
                }

                // otherwise, this token is good
                result.add(next);

                lastMatchEnd = match.end();
            }
        }

        if (lastMatchEnd < s.length() && !removeEmptyEntries) {
            // if the end of the last match is not at the end of the string,
            // and we're not supposed to remove empty entries, then that means
            // there is a delimiter at the end of the string, and so we should
            // add an empty result to represent the zero-length "match" after
            // the last delimiter.
            result.add(empty);
        }

        return result.toArray(emptyStringArray);
    }

    /**
     * Deletes a specified number of characters from this instance beginning at a
     * specified position.
     *
     * @param s
     *            The string.
     * @param startIndex
     *            The zero-based position to begin deleting characters.
     * @param count
     *            The number of characters to delete.
     * @return A new string that is equivalent to this string except for the removed
     *         characters.
     */
    @Nonnull
    public static String remove(String s, int startIndex, int count) {
        assertNonNull(s, "s");
        if (startIndex < 0)
            throw new ArgumentOutOfRangeException("startIndex", "startIndex cannot be less than zero.");
        if (count < 0)
            throw new ArgumentOutOfRangeException("count", "count cannot be less than zero.");

        int strLength = s.length();
        if (startIndex > strLength - count)
            throw new ArgumentOutOfRangeException("startIndex", "startIndex must be less than length of string minus count.");

        StringBuilder result = new StringBuilder(strLength - count);
        result.append(s, 0, startIndex);
        result.append(s, startIndex + count, strLength);
        return result.toString();
    }

    private enum PaddingType {
        LEFT,
        RIGHT,
    }

    /**
     * Returns a new string that right-aligns the characters in this instance by padding
     * them on the left with a specified Unicode character, for a specified total length.
     *
     * @param s
     *            The string.
     * @param totalWidth
     *            The number of characters in the resulting string, equal to the number of
     *            original characters plus any additional padding characters.
     * @param paddingChar
     *            A Unicode padding character.
     * @return A new string that is equivalent to this instance, but right-aligned and
     *         padded on the left with as many paddingChar characters as needed to create
     *         a length of totalWidth. Or, if totalWidth is less than the length of this
     *         instance, a new string that is identical to this instance.
     */
    @Nonnull
    public static String padLeft(@Nonnull String s, int totalWidth, char paddingChar) {
        return pad(s, totalWidth, paddingChar, PaddingType.LEFT);
    }

    /**
     * Returns a new string that left-aligns the characters in this string by padding them
     * on the right with a specified Unicode character, for a specified total length.
     *
     * @param s
     *            The string.
     * @param totalWidth
     *            The number of characters in the resulting string, equal to the number of
     *            original characters plus any additional padding characters.
     * @param paddingChar
     *            A Unicode padding character.
     * @return A new string that is equivalent to this instance, but left-aligned and
     *         padded on the right with as many paddingChar characters as needed to create
     *         a length of totalWidth. Or, if totalWidth is less than the length of this
     *         instance, a new string that is identical to this instance.
     */
    @Nonnull
    public static String padRight(@Nonnull String s, int totalWidth, char paddingChar) {
        return pad(s, totalWidth, paddingChar, PaddingType.RIGHT);
    }

    @Nonnull
    private static String pad(@Nonnull String s, int totalWidth, char paddingChar, @Nonnull PaddingType paddingType) {
        assertNonNull(s, "s");
        if (totalWidth < 0)
            throw new ArgumentOutOfRangeException("totalWidth", "Non-negative number required.");

        int numPaddingChars = totalWidth - s.length();
        if (numPaddingChars <= 0)
            return s;

        StringBuilder result = new StringBuilder(totalWidth);

        if (paddingType == PaddingType.RIGHT)
            result.append(s);

        for (int i = 0; i < numPaddingChars; ++i)
            result.append(paddingChar);

        if (paddingType == PaddingType.LEFT)
            result.append(s);

        return result.toString();
    }

    private static boolean getIgnoreCase(@Nonnull StringComparison comparisonType) {
        switch (comparisonType) {
        case CURRENT_CULTURE_IGNORE_CASE:
        case INVARIANT_CULTURE_IGNORE_CASE:
        case ORDINAL_IGNORE_CASE:
            return true;
        case CURRENT_CULTURE:
        case INVARIANT_CULTURE:
        case ORDINAL:
            return false;
        default:
            throw new ArgumentException("Unknown comparisonType");
        }
    }

    private static Locale getLocale(@Nonnull StringComparison comparisonType) {
        switch (comparisonType) {
        case INVARIANT_CULTURE:
        case INVARIANT_CULTURE_IGNORE_CASE:
        case ORDINAL:
        case ORDINAL_IGNORE_CASE:
            return CultureInfoHelper.getInvariantCulture();
        case CURRENT_CULTURE:
        case CURRENT_CULTURE_IGNORE_CASE:
            return CultureInfoHelper.getCurrentCulture();
        default:
            throw new ArgumentException("Unknown comparisonType");
        }
    }

    /**
     * Compares two specified String objects, ignoring or honoring their case, and using
     * culture-specific information to influence the comparison.
     *
     * @param strA
     *            The first String.
     * @param strB
     *            The second String.
     * @param ignoreCase
     *            A boolean indicating a case-sensitive or insensitive comparison. (true
     *            indicates a case-insensitive comparison.)
     * @param locale
     *            An object that supplies culture-specific comparison information.
     * @return A 32-bit signed integer indicating the lexical relationship between the two
     *         comparands.
     */
    public static int compare(@Nullable String strA, @Nullable String strB, boolean ignoreCase, Locale locale) {
        if (strA == null) {
            return strB == null ? 0 : -1;
        } else if (strB == null) {
            return 1;
        }

        Collator collator = Collator.getInstance(locale);
        collator.setStrength(ignoreCase ? Collator.PRIMARY : Collator.IDENTICAL);
        return collator.compare(strA, strB);
    }

    /**
     * Compares substrings of two specified String objects, ignoring or honoring their
     * case, and using culture-specific information to influence the comparison.
     *
     * @param strA
     *            The first String.
     * @param indexA
     *            The position of the substring within strA.
     * @param strB
     *            The second String.
     * @param indexB
     *            The position of the substring within the strB.
     * @param length
     *            The maximum number of characters in the substrings to compare.
     * @param ignoreCase
     *            A boolean indicating a case-sensitive or insensitive comparison. (true
     *            indicates a case-insensitive comparison.)
     * @param locale
     *            An object that supplies culture-specific comparison information.
     * @return An integer indicating the lexical relationship between the two comparands.
     */
    public static int compare(@Nullable String strA, int indexA, @Nullable String strB, int indexB, int length, boolean ignoreCase, Locale locale) {
        if (length == 0)
            return 0;
        if (strA == null) {
            return strB == null ? 0 : -1;
        } else if (strB == null) {
            return 1;
        }

        String subStrA = strA.substring(indexA);
        String subStrB = strB.substring(indexB);

        subStrA = subStrA.substring(0, Math.min(length, subStrA.length()));
        subStrB = subStrB.substring(0, Math.min(length, subStrB.length()));

        return compare(subStrA, subStrB, ignoreCase, locale);
    }

    /**
     * Compares substrings of two specified String objects using the specified rules, and
     * retursn an integer indicating their relative position in the sort order.
     *
     * @param strA
     *            The first String.
     * @param indexA
     *            The position of the substring within strA.
     * @param strB
     *            The second String.
     * @param indexB
     *            The position of the substring within the strB.
     * @param length
     *            The maximum number of characters in the substrings to compare.
     * @param comparisonType
     *            One of the enumeration values that specifies the rules to use in the
     *            comparison.
     * @return An integer indicating the lexical relationship between the two comparands.
     */
    public static int compare(@Nullable String strA, int indexA, @Nullable String strB, int indexB, int length, @Nonnull StringComparison comparisonType) {
        return compare(strA, indexA, strB, indexB, length, getIgnoreCase(comparisonType), getLocale(comparisonType));
    }

    /**
     * Replaces the format item in a specified string with the string representation of a
     * corresponding object in a specified array.
     *
     * @param format
     *            A composite format string.
     * @param args
     *            An object array that contains zero or more objects to format.
     * @return A copy of format in which the format items have been replaced by the string
     *         representation of the corresponding objects in args.
     */
    @Nonnull
    public static String format(@Nonnull String format, @Nonnull Object... args) {
        return format(null, format, args);
    }

    /**
     * Replaces the format item in a specified string with the string representation of a
     * corresponding object in a specified array. A specified parameter supplies
     * culture-specific formatting information.
     *
     * @param locale
     *            An object that supplies culture-specific formatting information.
     * @param format
     *            A composite format string
     * @param args
     *            An object array that contains zero or more objects to format.
     * @return A copy of format in which the format items have been replaced by the string
     *         representation of the corresponding objects in args.
     */
    @Nonnull
    public static String format(@Nullable Locale locale, @Nonnull String format, @Nonnull Object... args) {
        assertNonNull(format, "format");
        assertNonNull(args, "args");

        return new Helper(locale, format, args).format();
    }

    // C# format items are of the form: {index[,alignment][:formatString]}
    // { is escaped by {{ and } is escaped by }}
    private static final class Helper {
        @Nullable
        private final Locale locale;
        @Nonnull
        private final String format;
        @Nonnull
        private final Object[] args;
        private final int length;
        @Nonnull
        private final StringBuilder result;
        private int position;
        private char c;

        public Helper(@Nullable Locale locale, @Nonnull String format, @Nonnull Object... args) {
            this.locale = locale;
            this.format = format;
            this.args = args;
            this.length = format.length();
            this.result = new StringBuilder();
        }

        @Nonnull
        public String format() {
            if (length == 0)
                return empty;

            // walk the format string start to finish, substituting formatted items
            // for specifiers as we go.
            do {
                c = currentChar();

                if (c == '}') {
                    // next char must be a close brace to escape
                    advanceChar(true);

                    if (c != '}') {
                        throwInvalidFormatString();
                    }
                } else if (c == '{') {
                    // check for escaped open brace
                    advanceChar(true);

                    if (c != '{') {
                        // not escaped, start formatting an item. formatItem will consume
                        // the entire item and set position past the item.
                        formatItem();
                        continue;
                    }
                }

                // otherwise append the character as-is
                result.append(c);
                advanceChar(false);
            } while (position < length);

            return result.toString();
        }

        private void advanceChar(boolean mustExist) {
            ++position;
            if (mustExist && position >= length) {
                throwInvalidFormatString();
            }
            if (position < length) {
                c = currentChar();
            }
        }

        private char currentChar() {
            return format.charAt(position);
        }

        private void formatItem() {
            // parse index
            int index = parseNumber();

            if (index >= args.length) {
                throwInvalidFormatString();
            }

            Object arg = args[index];

            // eat whitespace after index
            skipWhitespace();

            // look for alignment
            PaddingType paddingType = PaddingType.LEFT;
            int alignment = 0;
            if (c == ',') {
                advanceChar(true);

                skipWhitespace();

                if (c == '-') {
                    // negative alignment means right padding
                    paddingType = PaddingType.RIGHT;
                    advanceChar(true);
                }

                // parse alignment
                alignment = parseNumber();
            }

            // eat whitespace after alignment
            skipWhitespace();

            // look for format specifier
            StringBuilder formatSpecifier = null;
            if (c == ':') {
                formatSpecifier = new StringBuilder();

                while (true) {
                    advanceChar(true);

                    if (c == '{') {
                        // next char must be a open brace to escape
                        advanceChar(true);

                        if (c != '{') {
                            throwInvalidFormatString();
                        }
                    } else if (c == '}') {
                        // check for escaped close brace
                        advanceChar(false);

                        if (position >= length || c != '}') {
                            // not escaped, stop formatting this item
                            --position;
                            c = currentChar();
                            break;
                        }
                    }

                    formatSpecifier.append(c);
                }
            }

            // should be done with item at this point
            if (c != '}') {
                throwInvalidFormatString();
            }

            ++position;

            String formattedItem;

            if (arg instanceof Number) {
                // in C#, this checks for IFormattable.
                // Future types to consider here that support format specifiers, but are
                // not Java Numbers:
                //
                // DateTime, TimeSpan, Guid, Enum
                String format = null;
                if (formatSpecifier != null) {
                    format = formatSpecifier.toString();
                }
                formattedItem = FormatHelper.buildFormat(locale, format).format(arg);
            } else {
                formattedItem = arg == null ? empty : arg.toString();
            }

            int numPaddingChars = alignment - formattedItem.length();
            if (numPaddingChars > 0 && paddingType == PaddingType.LEFT) {
                pad(numPaddingChars);
            }

            result.append(formattedItem);

            if (numPaddingChars > 0 && paddingType == PaddingType.RIGHT) {
                pad(numPaddingChars);
            }
        }

        private void pad(int numPaddingChars) {
            for (int i = 0; i < numPaddingChars; ++i) {
                result.append(' ');
            }
        }

        private void skipWhitespace() {
            while (c == ' ' && position < length) {
                advanceChar(false);
            }
        }

        private int parseNumber() {
            if (!isAsciiDigit(c)) {
                throwInvalidFormatString();
            }

            int result = 0;
            do {
                // format specifiers use only ASCII digits
                result *= 10;
                result += c - '0';

                advanceChar(true);
            } while (isAsciiDigit(c));

            return result;
        }

        private static void throwInvalidFormatString() {
            throw new ArgumentException("Invalid format string");
        }

        private static boolean isAsciiDigit(char c) {
            return c >= '0' && c <= '9';
        }
    }

    /**
     * Determines whether the beginning of this string instance matches the specified
     * string.
     *
     * @param s
     *            The string.
     * @param value
     *            The string to compare.
     * @return true if value matches the beginning of this string; otherwise, false.
     */
    public static boolean startsWith(@Nonnull String s, @Nonnull String value) {
        assertNonNull(s, "s");
        assertNonNull(value, "value");

        return s.startsWith(value);
    }

    /**
     * Determines whether the beginning of this string matches the specified string when
     * compared using the specified comparison option.
     *
     * @param s
     *            The string to search.
     * @param value
     *            A String object to compare to.
     * @param comparisonType
     *            One of the StringComparison values that determines how this string and
     *            value are compared.
     * @return true if the value parameter matches the beginning of this string;
     *         otherwise, false.
     */
    public static boolean startsWith(@Nonnull String s, @Nonnull String value, @Nonnull StringComparison comparisonType) {
        assertNonNull(s, "s");
        assertNonNull(value, "value");

        if (getIgnoreCase(comparisonType)) {
            Locale locale = getLocale(comparisonType);

            s = s.toUpperCase(locale);
            value = value.toUpperCase(locale);
        }

        return s.startsWith(value);
    }

    /**
     * Determines whether the end of this string matches the specified string when
     * compared using the specified comparison option.
     *
     * @param s
     *            The string to search.
     * @param value
     *            A String object to compare to.
     * @param comparisonType
     *            One of the StringComparison values that determines how this string and
     *            value are compared.
     * @return true if the value parameter matches the end of this string; otherwise,
     *         false.
     */
    public static boolean endsWith(@Nonnull String s, @Nonnull String value, @Nonnull StringComparison comparisonType) {
        assertNonNull(s, "s");
        assertNonNull(value, "value");

        if (getIgnoreCase(comparisonType)) {
            Locale locale = getLocale(comparisonType);

            s = s.toUpperCase(locale);
            value = value.toUpperCase(locale);
        }

        return s.endsWith(value);
    }

    /**
     * Reports the index of the first occurrence of the specified string in the current
     * String object. A parameter specifies the type of search to use for the specified
     * string.
     *
     * @param s
     *            The String to search.
     * @param value
     *            The String object to seek.
     * @param comparisonType
     *            One of the StringComparison values.
     * @return The index position of the value parameter if that string is found, or -1 if
     *         it is not. If value is Empty, the return value is 0.
     */
    public static int indexOf(@Nonnull String s, @Nonnull String value, @Nonnull StringComparison comparisonType) {
        assertNonNull(s, "s");
        assertNonNull(value, "value");

        if (getIgnoreCase(comparisonType)) {
            Locale locale = getLocale(comparisonType);

            s = s.toLowerCase(locale);
            value = value.toLowerCase(locale);
        }

        return s.indexOf(value);
    }

    /**
     * Returns a copy of this String object converted to lowercase using the casing rules
     * of the invariant culture.
     *
     * @param s
     *            The string.
     * @return A String object in lowercase.
     */
    @Nonnull
    public static String toLowerInvariant(@Nonnull String s) {
        assertNonNull(s, "s");
        return s.toLowerCase(CultureInfoHelper.getInvariantCulture());
    }

    /**
     * Retrieves a substring from this instance. The substring starts at a specified
     * character position.
     *
     * @param s
     *            The string.
     * @param startIndex
     *            The zero-based starting character position of a substring in this
     *            instance.
     * @return A string that is equivalent to the substring that begins at startIndex in
     *         this instance, or Empty if startIndex is equal to the length of this
     *         instance.
     */
    public static String substring(@Nonnull String s, int startIndex) {
        return substring(s, startIndex, s.length() - startIndex);
    }

    /**
     * Retrieves a substring from this instance. The substring starts at a specified
     * character position and has a specified length.
     *
     * @param s
     *            The string.
     * @param startIndex
     *            The zero-based starting character position of a substring in this
     *            instance.
     * @param length
     *            The number of characters in the substring.
     * @return A string that is equivalent to the substring of length length that begins
     *         at startIndex in this instance, or Empty if startIndex is equal to the
     *         length of this instance and length is zero.
     */
    @Nonnull
    public static String substring(@Nonnull String s, int startIndex, int length) {
        assertNonNull(s, "s");
        if (startIndex < 0)
            throw new ArgumentOutOfRangeException("startIndex", "startIndex cannot be less than zero.");

        int strLen = s.length();
        if (startIndex > strLen)
            throw new ArgumentOutOfRangeException("startIndex", "startIndex cannot be larger than length of string.");

        if (length < 0)
            throw new ArgumentOutOfRangeException("length", "Length cannot be less than zero.");

        int endIndex = startIndex + length;
        if (endIndex > strLen)
            throw new ArgumentOutOfRangeException("length", "Index and length must refer to a location within the string.");

        if (length == 0)
            return empty;

        return s.substring(startIndex, endIndex);
    }

    /**
     * Returns a new string in which all occurrences of a specified string in the current
     * instance are replaced with another specified string.
     *
     * @param s
     *            The string.
     * @param oldValue
     *            The string to be replaced.
     * @param newValue
     *            The string to replace all occurrences of oldValue.
     * @return A string that is equivalent to the current string except that all instances
     *         of oldValue are replaced with newValue.
     */
    @Nonnull
    public static String replace(@Nonnull String s, @Nonnull String oldValue, @Nullable String newValue) {
        assertNonNull(s, "s");
        assertNonNull(oldValue, "oldValue");

        if (empty.equals(oldValue))
            throw new ArgumentException("String cannot be of zero length.", "oldValue");

        if (newValue == null)
            newValue = empty;

        return s.replace(oldValue, newValue);
    }

    /**
     * Removes all occurrences of a set of characters specified in an array from the end
     * of this instance.
     *
     * @param str
     *            The string.
     * @param trimChars
     *            An array of Unicode characters to be removed or null.
     * @return The String that remains after all occurrences of the characters in
     *         trimChars are removed from the end. If trimChars is null, white space
     *         characters are removed instead.
     */
    @Nonnull
    public static String trimStart(@Nonnull String str, char... trimChars) {
        if (trimChars == null || trimChars.length == 0)
            trimChars = trimWhitespaceChars;

        int strLen = str.length();
        if (strLen == 0)
            return str;

        int index = 0;
        while (index != strLen && arrayContains(trimChars, str.charAt(index))) {
            index++;
        }
        return str.substring(index);
    }

    private static boolean arrayContains(@Nonnull char[] array, char charToFind) {
        for (char c : array) {
            if (c == charToFind)
                return true;
        }
        return false;
    }

    /**
     * Appends the string returned by processing a composite format string, which contains
     * zero or more format items, to this instance. Each format item is replaced by the
     * string representation of a corresponding argument in a parameter array.
     *
     * @param builder
     *            The StringBuilder.
     * @param locale
     *            An object that supplies culture-specific comparison information.
     * @param format
     *            A composite format string
     * @param args
     *            An array of objects to format.
     * @return A reference to this instance with format appended. Each format item in
     *         format is replaced by the string representation of the corresponding object
     *         argument.
     */
    @Nonnull
    public static StringBuilder appendFormat(@Nonnull StringBuilder builder, @Nullable Locale locale, @Nonnull String format, @Nonnull Object... args) {
        assertNonNull(builder, "builder");
        assertNonNull(format, "format");
        assertNonNull(args, "args");

        return builder.append(format(locale, format, args));
    }

    /**
     * Appends a specified number of copies of the string representation of a Unicode
     * character to a given instance.
     *
     * @param s
     *            The StringBuilder
     * @param c
     *            The character to append
     * @param repeatCount
     *            The number of times to append c.
     * @return The StringBuilder after the append operation has completed.
     */
    @Nonnull
    public static StringBuilder append(@Nonnull StringBuilder s, char c, int repeatCount) {
        s.ensureCapacity(s.length() + repeatCount);
        for (int i = 0; i < repeatCount; ++i) {
            s.append(c);
        }
        return s;
    }

    /**
     * Appends a copy of a specified substring to the given StringBuilder object.
     *
     * @param builder
     *            The StringBuilder.
     * @param value
     *            The string that contains the substring to append.
     * @param startIndex
     *            The starting position of the substring within value.
     * @param count
     *            The number of characters in value to append.
     * @return A reference to the StringBuilder object after the append operation has
     *         completed.
     */
    @Nonnull
    public static StringBuilder append(@Nonnull StringBuilder builder, String value, int startIndex, int count) {
        return builder.append(value, startIndex, startIndex + count);
    }
}
