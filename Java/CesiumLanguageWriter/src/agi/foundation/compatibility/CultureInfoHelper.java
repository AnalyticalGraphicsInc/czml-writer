package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

/**
 * Helper methods related to CultureInfo.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class CultureInfoHelper {
    @Nonnull
    private static final Pattern nameSplitter = Pattern.compile("(\\p{Alpha}{2})-(\\p{Alpha}{2})");

    private CultureInfoHelper() {}

    /**
     * Gets the Locale that is culture-independent (invariant).
     */
    @SuppressWarnings("null")
    @Nonnull
    public static Locale getInvariantCulture() {
        return Locale.US;
    }

    /**
     * Gets the Locale that represents the culture used by the current VM.
     */
    @Nonnull
    public static Locale getCurrentCulture() {
        return Locale.getDefault();
    }

    /**
     * Gets the locale using the specified C#-style culture name.
     *
     * The format for the culture name is
     * "&lt;languagecode2&gt;-&lt;country/regioncode2&gt;", where &lt;languagecode2&gt; is
     * the language code and &lt;country/regioncode2&gt; is the subculture code. Examples
     * include ja-JP for Japanese (Japan) and en-US for English (United States).
     */
    @Nonnull
    public static Locale getCultureInfo(String name) {
        Matcher matcher = nameSplitter.matcher(name);

        if (!matcher.matches())
            throw new IllegalArgumentException("unknown Locale " + name);

        String language = matcher.group(1);
        String country = matcher.group(2);

        return new Locale(language, country);
    }
}
