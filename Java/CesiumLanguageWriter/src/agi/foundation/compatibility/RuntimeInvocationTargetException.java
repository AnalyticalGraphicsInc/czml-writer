package agi.foundation.compatibility;

import java.lang.reflect.InvocationTargetException;

/**
 * {@link RuntimeException} wrapper around {@link InvocationTargetException}.
 */
public class RuntimeInvocationTargetException extends WrappedRuntimeException {
    private static final long serialVersionUID = -1347127370192379291L;

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
