package agi.foundation.compatibility;

import java.net.URISyntaxException;

/**
 * {@link RuntimeException} wrapper around {@link URISyntaxException}.
 */
public class RuntimeURISyntaxException extends WrappedRuntimeException {
	public RuntimeURISyntaxException(URISyntaxException e) {
		super(e);
	}
}
