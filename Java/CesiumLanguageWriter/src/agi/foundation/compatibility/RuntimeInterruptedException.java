package agi.foundation.compatibility;

/**
 * {@link RuntimeException} wrapper around {@link InterruptedException}.
 */
public class RuntimeInterruptedException extends WrappedRuntimeException {
    private static final long serialVersionUID = 4328263769188665677L;

    public RuntimeInterruptedException(InterruptedException e) {
        super(e);
    }

    public RuntimeInterruptedException() {
        this(new InterruptedException());
    }

    public RuntimeInterruptedException(String s) {
        this(new InterruptedException(s));
    }
}
