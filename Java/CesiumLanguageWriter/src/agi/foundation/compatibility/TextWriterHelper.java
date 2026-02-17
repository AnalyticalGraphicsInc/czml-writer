package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;
import static agi.foundation.compatibility.DisposeHelper.dispose;
import static java.lang.System.lineSeparator;

import agi.foundation.compatibility.annotations.Internal;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper methods related to TextWriter.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class TextWriterHelper {
    private TextWriterHelper() {}

    public static void close(@Nonnull Writer writer) {
        assertNonNull(writer, "writer");
        dispose(writer);
    }

    public static void write(@Nonnull Writer writer, char value) {
        assertNonNull(writer, "writer");

        try {
            writer.write(value);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void write(@Nonnull Writer writer, @Nonnull char[] buffer, int index, int count) {
        assertNonNull(writer, "writer");
        assertNonNull(buffer, "buffer");

        try {
            writer.write(buffer, index, count);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void write(@Nonnull Writer writer, @Nullable String value) {
        assertNonNull(writer, "writer");

        if (value == null)
            return;

        try {
            writer.write(value);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void writeLine(@Nonnull Writer writer, @Nullable String value) {
        write(writer, value);
        writeLine(writer);
    }

    public static void writeLine(@Nonnull Writer writer) {
        write(writer, getNewLine());
    }

    /**
     * Gets the line terminator string.
     *
     * @return The line terminator string.
     */
    public static String getNewLine() {
        return lineSeparator();
    }
}
