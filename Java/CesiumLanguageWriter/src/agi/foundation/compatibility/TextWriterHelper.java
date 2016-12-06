package agi.foundation.compatibility;

import java.io.IOException;
import java.io.Writer;

/**
 * Helper methods related to TextWriter.
 */
public final class TextWriterHelper {
    private TextWriterHelper() {}

    public static void print(Writer writer, char c) {
        try {
            writer.write(c);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    public static void print(Writer writer, char s[], int index, int count) {
        try {
            writer.write(s, index, count);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    public static void print(Writer writer, String s) {
        try {
            writer.write(s == null ? "null" : s);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    public static void writeLine(Writer writer, String s) {
        print(writer, s);
        writeLine(writer);
    }

    public static void writeLine(Writer writer) {
        try {
            writer.write(getNewLine());
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    /**
     * Gets the line terminator string.
     * 
     * @return The line terminator string.
     */
    public static String getNewLine() {
        return System.getProperty("line.separator");
    }
}
