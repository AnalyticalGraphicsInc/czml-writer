package agi.foundation.compatibility;

import java.lang.reflect.InvocationTargetException;

/**
 * {@link RuntimeException} wrapper around {@link InvocationTargetException}.
 */
public class RuntimeInvocationTargetException extends WrappedRuntimeException {
	public RuntimeInvocationTargetException(InvocationTargetException e) {
		super(e);
	}

	public RuntimeInvocationTargetException(Throwable target) {
		this(new InvocationTargetException(target));
	}

	public RuntimeInvocationTargetException(Throwable target, String s) {
		this(new InvocationTargetException(target, s));
	}

	public Throwable getTargetException() {
		return getCause();
	}
}
