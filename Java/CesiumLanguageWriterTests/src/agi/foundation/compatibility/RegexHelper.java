package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import java.util.regex.Pattern;

import javax.annotation.Nonnull;

public final class RegexHelper {
    private RegexHelper() {}

    /**
     * Initializes and compiles a new instance of the Regex class for the specified
     * regular expression.
     *
     * @param pattern
     *            The regular expression pattern to match.
     */
    @Nonnull
    public static Pattern create(@Nonnull String pattern) {
        assertNonNull(pattern, "pattern");
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
    public static boolean isMatch(@Nonnull Pattern pattern, @Nonnull String input) {
        assertNonNull(pattern, "pattern");
        assertNonNull(input, "input");

        return pattern.matcher(input).find();
    }
}
