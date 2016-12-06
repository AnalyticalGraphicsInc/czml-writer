package agi.foundation.compatibility;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Wraps an exception as a RuntimeException and delegates methods to the wrapped
 * exception.
 */
public class WrappedRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 3685892054016909266L;
    private final Exception cause;

    WrappedRuntimeException(Exception e) {
        super(e);
        this.cause = e;
    }

    @Override
    public void printStackTrace() {
        cause.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        cause.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        cause.printStackTrace(s);
    }

    @Override
    public Throwable getCause() {
        return cause.getCause();
    }

    @Override
    public String getLocalizedMessage() {
        return cause.getLocalizedMessage();
    }

    @Override
    public String getMessage() {
        return cause.getMessage();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return cause.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        cause.setStackTrace(stackTrace);
    }

    @Override
    public String toString() {
        return cause.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return cause.equals(obj);
    }

    @Override
    public int hashCode() {
        return cause.hashCode();
    }
}
