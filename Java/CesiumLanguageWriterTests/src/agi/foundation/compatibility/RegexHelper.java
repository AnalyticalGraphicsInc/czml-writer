package agi.foundation.compatibility;

import java.util.regex.Pattern;

public final class RegexHelper {
    private RegexHelper() {}

    /**
     * Initializes and compiles a new instance of the Regex class for the specified
     * regular expression.
     *
     * @param pattern
     *            The regular expression pattern to match.
     */
    public static Pattern create(String pattern) {
        return Pattern.compile(pattern);
    }

    /**
     * Indicates whether the regular expression specified in the Regex constructor finds a
     * match in the input string.
     *
     * @param pattern
     *            The regular expression.
     * @param input
     *            The string to search for a match.
     * @return true if the regular expression finds a match; otherwise, false.
     */
    public static boolean isMatch(Pattern pattern, String input) {
        return pattern.matcher(input).find();
    }
}
