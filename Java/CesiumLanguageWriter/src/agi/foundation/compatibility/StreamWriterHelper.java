package agi.foundation.compatibility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Helper methods related to StreamWriter.
 */
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
    public static OutputStreamWriter create(String path) {
        try {
            return new OutputStreamWriter(new FileOutputStream(path), Encoding.UTF8);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }
}
