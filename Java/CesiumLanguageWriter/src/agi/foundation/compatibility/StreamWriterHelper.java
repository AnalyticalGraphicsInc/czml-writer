package agi.foundation.compatibility;

import java.io.FileWriter;
import java.io.IOException;

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
	public static FileWriter create(String path) {
		try {
			return new FileWriter(path);
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}
}
