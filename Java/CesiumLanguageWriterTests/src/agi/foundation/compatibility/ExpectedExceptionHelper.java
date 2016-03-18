package agi.foundation.compatibility;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

import org.hamcrest.Matcher;
import org.junit.rules.ExpectedException;

public final class ExpectedExceptionHelper {
	public static void expectException(ExpectedException rule, Class<? extends Throwable> expectedExceptionType) {
		rule.expect(expectedExceptionType);
	}

	public static void expectException(ExpectedException rule, Class<? extends Throwable> expectedExceptionType, String message) {
		expectException(rule, expectedExceptionType, message, MessageMatch.getDefault());
	}

	public static void expectException(ExpectedException rule, Class<? extends Throwable> expectedExceptionType, String message, MessageMatch match) {
		expectException(rule, expectedExceptionType);

		rule.expectMessage(getMatcher(message, match));
	}

	private static Matcher<String> getMatcher(String message, MessageMatch match) {
		switch (match) {
		case EXACT:
			return equalTo(message);
		case CONTAINS:
			return containsString(message);
		case STARTS_WITH:
			return startsWith(message);
		default:
			throw new IllegalArgumentException("Unknown enum value.");
		}
	}
}
