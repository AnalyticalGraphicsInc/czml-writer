package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.Nonnull;

/**
 * Helper methods related to StreamWriter.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class StreamWriterHelper {
    private StreamWriterHelper() {}

    /**
     * Initializes a new instance of the StreamWriter class for the specified file on the
     * specified path.
     *
     * @param path
     *            The complete file path to write to.
     * @return the new writer.
     */
    public static OutputStreamWriter create(@Nonnull String path) {
        ArgumentNullException.assertNonNull(path, "path");
        try {
            return new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
