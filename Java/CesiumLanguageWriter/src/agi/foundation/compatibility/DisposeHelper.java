package agi.foundation.compatibility;

import java.io.Closeable;
import java.io.IOException;

/**
 * Helper methods to safely dispose various types.
 */
public final class DisposeHelper {
	private DisposeHelper() {}

	/**
	 * Dispose the given object if not null.
	 * 
	 * @param closeable
	 *            the object to dispose.
	 */
	public static void dispose(Closeable closeable) {
		try {
			if (closeable != null)
				closeable.close();
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * Dispose the given object if not null.
	 * 
	 * @param disposable
	 *            the object to dispose.
	 */
	public static void dispose(IDisposable disposable) {
		if (disposable != null)
			disposable.dispose();
	}

	/**
	 * Dispose the given object if not null.
	 * 
	 * @param memoryStream
	 *            the object to dispose.
	 */
	public static void dispose(MemoryStream memoryStream) {
		if (memoryStream != null)
			memoryStream.dispose();
	}
}
