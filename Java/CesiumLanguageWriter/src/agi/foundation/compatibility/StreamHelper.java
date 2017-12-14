package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

import javax.annotation.Nonnull;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class StreamHelper {
    private StreamHelper() {}

    public static int read(@Nonnull InputStream stream, @Nonnull byte[] b, int off, int len) {
        ArgumentNullException.assertNonNull(stream, "stream");
        ArgumentNullException.assertNonNull(b, "b");

        try {
            return stream.read(b, off, len);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
