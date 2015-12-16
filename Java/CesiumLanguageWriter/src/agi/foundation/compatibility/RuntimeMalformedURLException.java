package agi.foundation.compatibility;

import java.net.MalformedURLException;

/**
 * {@link RuntimeException} wrapper around {@link MalformedURLException}.
 */
public class RuntimeMalformedURLException extends WrappedRuntimeException {
	public RuntimeMalformedURLException(MalformedURLException e) {
		super(e);
	}

	public RuntimeMalformedURLException() {
		this(new MalformedURLException());
	}

	public RuntimeMalformedURLException(String msg) {
		this(new MalformedURLException(msg));
	}
}
