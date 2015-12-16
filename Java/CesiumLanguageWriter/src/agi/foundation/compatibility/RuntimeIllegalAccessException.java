package agi.foundation.compatibility;

/**
 * {@link RuntimeException} wrapper around {@link IllegalAccessException}.
 */
public class RuntimeIllegalAccessException extends WrappedRuntimeException {
	public RuntimeIllegalAccessException(IllegalAccessException e) {
		super(e);
	}

	public RuntimeIllegalAccessException() {
		this(new IllegalAccessException());
	}

	public RuntimeIllegalAccessException(String s) {
		this(new IllegalAccessException(s));
	}
}
