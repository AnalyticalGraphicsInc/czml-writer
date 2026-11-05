package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.io.FileInputStream;
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

    public static long getLength(@Nonnull InputStream stream) {
        assertNonNull(stream, "stream");

        if (stream instanceof ISeekableStream) {
            return ((ISeekableStream) stream).getLength();
        } else if (stream instanceof FileInputStream) {
            try {
                return ((FileInputStream) stream).getChannel().size();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        } else {
            throw new UnsupportedOperationException("Get length operation not supported for stream of type: " + stream.getClass());
        }
    }

    public static long getPosition(@Nonnull InputStream stream) {
        assertNonNull(stream, "stream");

        if (stream instanceof ISeekableStream) {
            return ((ISeekableStream) stream).getPosition();
        } else if (stream instanceof FileInputStream) {
            try {
                return ((FileInputStream) stream).getChannel().position();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        } else {
            throw new UnsupportedOperationException("Get position operation not supported for stream of type: " + stream.getClass());
        }
    }

    static long calculateSeekPosition(@Nonnull InputStream stream, long offset, @Nonnull SeekOrigin origin) {
        switch (origin) {
        case BEGIN:
            break;
        case CURRENT:
            offset += getPosition(stream);
            break;
        case END:
            offset += getLength(stream);
            break;
        default:
            ArgumentOutOfRangeException._throw();
        }

        if (offset < 0)
            throw new UncheckedIOException(new IOException("An attempt was made to move the position before the beginning of the stream."));

        return offset;
    }

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
            ArgumentOutOfRangeException._throw("bufferSize");

        byte[] buffer = new byte[bufferSize];
        int count;
        while ((count = read(stream, buffer, 0, buffer.length)) > 0) {
            destination.write(buffer, 0, count);
        }
    }
}
