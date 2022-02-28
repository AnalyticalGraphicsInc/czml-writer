package agi.foundation.compatibility;

/**
 * {@link RuntimeException} wrapper around {@link ClassNotFoundException}.
 */
public class RuntimeClassNotFoundException extends WrappedRuntimeException {
    private static final long serialVersionUID = 8542565475462911469L;

    public RuntimeClassNotFoundException(ClassNotFoundException e) {
        super(e);
    }

    public RuntimeClassNotFoundException() {
        this(new ClassNotFoundException());
    }

    public RuntimeClassNotFoundException(String s) {
        this(new ClassNotFoundException(s));
    }

    public RuntimeClassNotFoundException(String s, Throwable ex) {
        this(new ClassNotFoundException(s, ex));
    }
}
