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

    public static void copyTo(@Nonnull InputStream stream, @Nonnull MemoryStream destination, int bufferSize) {
        ArgumentNullException.assertNonNull(stream, "stream");
        ArgumentNullException.assertNonNull(destination, "destination");
        if (bufferSize <= 0)
            throw new ArgumentOutOfRangeException("bufferSize");

        byte[] buffer = new byte[bufferSize];
        int count;
        try {
            while ((count = stream.read(buffer)) > 0) {
                destination.write(buffer, 0, count);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
