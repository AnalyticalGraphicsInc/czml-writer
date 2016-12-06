package agi.foundation.compatibility;

import java.net.MalformedURLException;

/**
 * {@link RuntimeException} wrapper around {@link MalformedURLException}.
 */
public class RuntimeMalformedURLException extends WrappedRuntimeException {
    private static final long serialVersionUID = 382771401247947766L;

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
