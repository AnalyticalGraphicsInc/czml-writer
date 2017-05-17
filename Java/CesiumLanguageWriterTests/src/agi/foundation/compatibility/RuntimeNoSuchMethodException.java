package agi.foundation.compatibility;

/**
 * {@link RuntimeException} wrapper around {@link NoSuchMethodException}.
 */
public class RuntimeNoSuchMethodException extends WrappedRuntimeException {
    private static final long serialVersionUID = -7060058165456497629L;

    public RuntimeNoSuchMethodException(NoSuchMethodException e) {
        super(e);
    }

    public RuntimeNoSuchMethodException() {
        this(new NoSuchMethodException());
    }

    public RuntimeNoSuchMethodException(String s) {
        this(new NoSuchMethodException(s));
    }
}
