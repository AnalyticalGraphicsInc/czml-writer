package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

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
        assertNonNull(stream, "stream");
        assertNonNull(b, "b");

        try {
            return stream.read(b, off, len);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void copyTo(@Nonnull InputStream stream, @Nonnull MemoryStream destination, int bufferSize) {
        assertNonNull(stream, "stream");
        assertNonNull(destination, "destination");
        if (bufferSize <= 0)
            throw new ArgumentOutOfRangeException("bufferSize");

        byte[] buffer = new byte[bufferSize];
        int count;
        while ((count = read(stream, buffer, 0, buffer.length)) > 0) {
            destination.write(buffer, 0, count);
        }
    }
}
