package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
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
     * Initializes a new instance for the specified file on the specified path.
     *
     * @param path
     *            The complete file path to write to.
     * @return the new writer.
     */
    @Nonnull
    public static OutputStreamWriter create(@Nonnull String path) {
        return create(path, false, StandardCharsets.UTF_8);
    }

    /**
     * Initializes a new instance for the specified file on the specified path, using the
     * specified encoding and default buffer size. If the file exists, it can be either
     * overwritten or appended to. If the file does not exist, this constructor creates a
     * new file.
     *
     * @param path
     *            The complete file path to write to.
     * @param append
     *            Determines whether data is to be appended to the file. If the file
     *            exists and append is false, the file is overwritten. If the file exists
     *            and append is true, the data is appended to the file. Otherwise, a new
     *            file is created.
     * @param charset
     *            The character encoding to use.
     * @return the new writer.
     */
    @Nonnull
    public static OutputStreamWriter create(@Nonnull String path, boolean append, @Nonnull Charset charset) {
        ArgumentNullException.assertNonNull(path, "path");
        ArgumentNullException.assertNonNull(charset, "charset");
        try {
            return new OutputStreamWriter(new FileOutputStream(path, append), charset);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
