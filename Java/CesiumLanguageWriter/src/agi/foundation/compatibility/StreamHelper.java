package agi.foundation.compatibility;

import java.io.IOException;
import java.io.InputStream;

public final class StreamHelper {
	private StreamHelper() {}

	public static int read(InputStream stream, byte[] b, int off, int len) {
		try {
			return stream.read(b, off, len);
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}
}
