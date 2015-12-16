package agi.foundation.compatibility;

import java.io.IOException;

/**
 * {@link RuntimeException} wrapper around {@link IOException}.
 */
public class RuntimeIOException extends WrappedRuntimeException {
	public RuntimeIOException(IOException e) {
		super(e);
	}

	public RuntimeIOException() {
		this(new IOException());
	}

	public RuntimeIOException(String message) {
		this(new IOException(message));
	}

	public RuntimeIOException(String message, Throwable cause) {
		this(new IOException(message, cause));
	}
}
