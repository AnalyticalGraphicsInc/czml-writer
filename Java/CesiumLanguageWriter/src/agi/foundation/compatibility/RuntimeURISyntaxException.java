package agi.foundation.compatibility;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * {@link RuntimeException} wrapper around {@link URISyntaxException}.
 */
public class RuntimeURISyntaxException extends WrappedRuntimeException {
    private static final long serialVersionUID = 685406337875011180L;

    public RuntimeURISyntaxException(URISyntaxException e) {
        super(e);
    }

    public RuntimeURISyntaxException(MalformedURLException e) {
        super(e);
    }

    public RuntimeURISyntaxException(String input, String msg) {
        this(new URISyntaxException(input, msg));
    }
}
