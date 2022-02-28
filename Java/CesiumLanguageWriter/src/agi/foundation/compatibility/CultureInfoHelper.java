package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.util.Locale;

import javax.annotation.Nonnull;

/**
 * Helper methods related to CultureInfo.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class CultureInfoHelper {
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
     * Initializes a new instance based on the culture specified by name.
     *
     * The format for the culture name is
     * "&lt;languagecode2&gt;-&lt;country/regioncode2&gt;", where &lt;languagecode2&gt; is
     * the language code and &lt;country/regioncode2&gt; is the subculture code. Examples
     * include ja-JP for Japanese (Japan) and en-US for English (United States).
     */
    @Nonnull
    public static Locale create(@Nonnull String name) {
        assertNonNull(name, "name");

        if (StringHelper.isEmpty(name)) {
            return getInvariantCulture();
        }

        return Locale.forLanguageTag(name);
    }

    /**
     * Retrieves an instance of a culture using the specified culture name.
     *
     * NOTE: in .NET, this method caches culture info objects. The current implementation
     * does not cache results.
     */
    @Nonnull
    public static Locale getCultureInfo(@Nonnull String name) {
        return create(name);
    }
}
