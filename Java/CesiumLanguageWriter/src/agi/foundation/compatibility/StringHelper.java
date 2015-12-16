package agi.foundation.compatibility;

import java.text.Collator;
import java.text.Format;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Helper methods related to Strings.
 */
public final class StringHelper {
	private enum PaddingType {
		LEFT, RIGHT,
	}

	private static final Pattern splitWhitespacePattern;
	private static final char[] trimWhitespaceChars;

	static {
		// this set of characters is taken from the .NET documentation for
		// String.Split.
		char[] splitWhitespaceChars = new char[] {
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
		pattern.append("[");
		for (char c : splitWhitespaceChars) {
			pattern.append(c);
		}
		pattern.append("]");
		splitWhitespacePattern = Pattern.compile(pattern.toString());

		// This set of characters is taken from the .NET documentation for
		// String.Trim and has one extra character in it (the last one) than the
		// above set for String.Split. The .NET doc makes special note of this.
		trimWhitespaceChars = new char[] {
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
	}

	private StringHelper() {}

	/**
	 * Indicates whether the specified string is null or an Empty string.
	 * 
	 * @param str
	 *            The string.
	 * @return true if the value parameter is null or an empty string (""); otherwise,
	 *         false.
	 */
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static boolean isNotNullOrEmpty(String str) {
		return !isNullOrEmpty(str);
	}

	/**
	 * Returns a string array that contains the substrings in this instance that are
	 * delimited by elements of a specified Unicode character array.
	 * 
	 * @param string
	 *            the String to split.
	 * @param separator
	 *            An array of Unicode characters that delimit the substrings in this
	 *            instance, an empty array that contains no delimiters, or null.
	 * @return An array whose elements contain the substrings in this instance that are
	 *         delimited by one or more characters in separator.
	 */
	public static String[] split(String string, char... separator) {
		return split(string, separator, -1);
	}

	/**
	 * Returns a string array that contains the substrings in this instance that are
	 * delimited by elements of a specified Unicode character array. A parameter specifies
	 * the maximum number of substrings to return.
	 * 
	 * @param string
	 *            the String to split.
	 * @param separator
	 *            An array of Unicode characters that delimit the substrings in this
	 *            instance, an empty array that contains no delimiters, or null.
	 * @param count
	 *            The maximum number of substrings to return.
	 * @return An array whose elements contain the substrings in this instance that are
	 *         delimited by one or more characters in separator.
	 */
	public static String[] split(String string, char[] separator, int count) {
		return split(string, separator, count, StringSplitOptions.NONE);
	}

	/**
	 * Returns a string array that contains the substrings in this string that are
	 * delimited by elements of a specified Unicode character array. A parameter specifies
	 * whether to return empty array elements.
	 * 
	 * @param string
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
	public static String[] split(String string, char[] separator, int count, StringSplitOptions options) {
		String regex = null;
		if (separator != null && separator.length > 0) {
			StringBuilder builder = new StringBuilder("[");
			for (int i = 0; i < separator.length; i++) {
				// Encode the characters with \\uhhhh where hhhh is the hex
				// representation of the value of the character. Alternatively,
				// we could just escape the characters that have special meaning
				// in a regular expression, but that approach is more error
				// prone.
				builder.append("\\u");
				builder.append(StringHelper.padLeft(Integer.toHexString(separator[i]), 4, '0'));
			}
			builder.append("]");
			regex = builder.toString();
		}

		return split(string, regex, options, count);
	}
	
	/**
	 * Returns a string array that contains the substrings in this string that are
	 * delimited by elements of a specified string array. Parameters specify the maximum
	 * number of substrings to return and whether to return empty array elements.
	 * 
	 * @param string
	 *            the String to split.
	 * @param separator
	 *            An array of strings that delimit the substrings in this string, an empty
	 *            array that contains no delimiters, or null.
	 * @param count
	 *            The maximum number of substrings to return.
	 * @param options
	 *            Specify <code>RemoveEmptyEntries</code> to omit empty array elements
	 *            from the array returned, or <code>None</code> to include empty array
	 *            elements in the array returned.
	 * @return An array whose elements contain the substrings in this string that are
	 *         delimited by one or more strings in separator.
	 */
	public static String[] split(String string, String[] separator, int count, StringSplitOptions options) {
		String regex = null;
		if (separator != null && separator.length > 0) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < separator.length; i++) {
				builder.append(separator[i]);
				if (i < separator.length - 1)
					builder.append("|");
			}
			regex = builder.toString();
		}

		return split(string, regex, options, count);
	}

	/**
	 * Do the work of splitting the string according to the specified regex and options.
	 */
	private static String[] split(String string, String regex, StringSplitOptions options, int count) {
		if (options == null) {
			throw new IllegalArgumentException("String split option is invalid.");
		}

		Pattern pattern = regex == null ? splitWhitespacePattern : Pattern.compile(regex);

		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(pattern);

		boolean removeEmptyEntries = options == StringSplitOptions.REMOVE_EMPTY_ENTRIES;
		ArrayList<String> result = new ArrayList<String>();

		boolean firstToken = true;
		int lastMatchEnd = 0;
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
				result.add("");
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
				result.add(string.substring(match.start()));
				lastMatchEnd = string.length();
				break;
			}

			// otherwise, this token is good
			result.add(next);

			lastMatchEnd = match.end();
		}

		if (lastMatchEnd < string.length() && !removeEmptyEntries) {
			// if the end of the last match is not at the end of the string,
			// and we're not supposed to remove empty entries, then that means
			// there is a delimiter at the end of the string, and so we should
			// add an empty result to represent the zero-length "match" after
			// the last delimiter.
			result.add("");
		}

		return result.toArray(new String[result.size()]);
	}

	/**
	 * Returns a new string that right-aligns the characters in this instance by padding
	 * them on the left with a specified Unicode character, for a specified total length.
	 * 
	 * @param str
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
	public static String padLeft(String str, int totalWidth, char paddingChar) {
		return pad(str, totalWidth, paddingChar, PaddingType.LEFT);
	}

	private static String pad(String str, int totalWidth, char paddingChar, PaddingType paddingType) {
		if (totalWidth < 0)
			throw new ArgumentOutOfRangeException("totalWidth", "Non-negative number required.");

		int numPaddingChars = totalWidth - str.length();
		if (numPaddingChars <= 0)
			return str;

		StringBuilder result = new StringBuilder(totalWidth);

		if (paddingType == PaddingType.RIGHT)
			result.append(str);

		for (int i = 0; i < numPaddingChars; ++i)
			result.append(paddingChar);

		if (paddingType == PaddingType.LEFT)
			result.append(str);

		return result.toString();
	}

	private static boolean getIgnoreCase(StringComparison comparisonType) {
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

	private static Locale getLocale(StringComparison comparisonType) {
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
	 *            A Locale object that supplies culture-specific comparison information.
	 * @return A 32-bit signed integer indicating the lexical relationship between the two
	 *         comparands.
	 */
	public static int compare(String strA, String strB, boolean ignoreCase, Locale locale) {
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
	 *            A Locale object that supplies culture-specific comparison information.
	 * @return An integer indicating the lexical relationship between the two comparands.
	 */
	public static int compare(String strA, int indexA, String strB, int indexB, int length, boolean ignoreCase, Locale locale) {
		if (length == 0)
			return 0;
		if (strA == null) {
			return strB == null ? 0 : -1;
		} else if (strB == null) {
			return 1;
		}

		String subStrA = strA.substring(indexA);
		String subStrB = strB.substring(indexB);

		int compareLength = Math.min(length, Math.min(subStrA.length(), subStrB.length()));

		subStrA = subStrA.substring(0, compareLength);
		subStrB = subStrB.substring(0, compareLength);

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
	public static int compare(String strA, int indexA, String strB, int indexB, int length, StringComparison comparisonType) {
		return compare(strA, indexA, strB, indexB, length, getIgnoreCase(comparisonType), getLocale(comparisonType));
	}

	/**
	 * Represents the empty string. This field is read-only.
	 */
	public static final String empty = "";

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
	public static String format(String format, Object... args) {
		return format(CultureInfoHelper.getCurrentCulture(), format, args);
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
	public static String format(Locale locale, String format, Object... args) {
		MessageFormat messageFormat = new MessageFormat("", locale);

		FormatConverter.loadFormat(locale, messageFormat, format, args);

		return messageFormat.format(args, new StringBuffer(), null).toString();
	}

	public static final class FormatConverter {
		/**
		 * C# format items are of the form: {index[,alignment][:formatString]}
		 */
		private static final String formatItemRegex = "\\{(\\d+)(?:,([\\d-]+))??(?:\\:([^}]+))??\\}";
		private static final Pattern escapeQuotes = Pattern.compile("'");
		private static final Pattern formatItemPattern = Pattern.compile(formatItemRegex);

		public static void loadFormat(Locale locale, MessageFormat messageFormat, String pattern, Object[] arguments) {
			pattern = escapeQuotes.matcher(pattern).replaceAll("''");
			Matcher formatItemMatcher = formatItemPattern.matcher(pattern);

			StringBuilder result = new StringBuilder(pattern.length());

			int previousMatchEnd = 0;

			HashMap<Integer, Format> formatsByArgumentIndex = new HashMap<Integer, Format>();

			while (formatItemMatcher.find()) {
				// groups are numbered from left to right
				String index = formatItemMatcher.group(1);
				String alignment = formatItemMatcher.group(2);
				String formatString = formatItemMatcher.group(3);

				// append the non-matching text between the end of the previous
				// match and the start of this match
				if (previousMatchEnd != formatItemMatcher.start())
					result.append(pattern.substring(previousMatchEnd, formatItemMatcher.start()));

				result.append("{").append(index);

				int indexInt = Integer.parseInt(index);
				Object arg = arguments[indexInt];

				if ((arg instanceof Number)) {
					int width = 0;

					if (alignment != null)
						width = Integer.parseInt(alignment);

					// set explicit format object for this argument
					Format paddingDecimalFormat = FormatHelper.buildFormat(locale, formatString, width);
					formatsByArgumentIndex.put(indexInt, paddingDecimalFormat);
				}

				result.append("}");

				previousMatchEnd = formatItemMatcher.end();
			}

			// append the non-matching text between the end of the previous
			// match and the end of the pattern
			if (previousMatchEnd < pattern.length())
				result.append(pattern.substring(previousMatchEnd, pattern.length()));

			messageFormat.applyPattern(result.toString());

			for (Entry<Integer, Format> entry : formatsByArgumentIndex.entrySet()) {
				messageFormat.setFormatByArgumentIndex(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * Returns a copy of this String object converted to lowercase using the casing rules
	 * of the invariant culture.
	 * 
	 * @param str
	 *            The string.
	 * @return A String object in lowercase.
	 */
	public static String toLowerInvariant(String str) {
		return str.toLowerCase(CultureInfoHelper.getInvariantCulture());
	}

	/**
	 * Determines whether the beginning of this string instance matches the specified
	 * string.
	 * 
	 * @param str
	 *            The string.
	 * @param value
	 *            The string to compare.
	 * @return true if value matches the beginning of this string; otherwise, false.
	 */
	public static boolean startsWith(String str, String value) {
		if (value == null)
			throw new ArgumentNullException("value");
		if (str == value)
			return true;

		return str.startsWith(value);
	}

	/**
	 * Returns a new string in which all occurrences of a specified string in the current
	 * instance are replaced with another specified string.
	 * 
	 * @param str
	 *            The string.
	 * @param oldValue
	 *            The string to be replaced.
	 * @param newValue
	 *            The string to replace all occurrences of oldValue.
	 * @return A string that is equivalent to the current string except that all instances
	 *         of oldValue are replaced with newValue.
	 */
	public static String replace(String str, String oldValue, String newValue) {
		if (oldValue == null)
			throw new ArgumentNullException("oldValue");
		if ("".equals(oldValue))
			throw new ArgumentException("String cannot be of zero length.", "oldValue");

		return str.replace(oldValue, newValue);
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
	public static String trimStart(String str, char... trimChars) {
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

	private static boolean arrayContains(char[] array, char charToFind) {
		for (char c : array) {
			if (c == charToFind)
				return true;
		}
		return false;
	}
}
