package agi.foundation.compatibility;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

import javax.annotation.Nonnull;

import org.hamcrest.Matcher;
import org.junit.rules.ExpectedException;

public final class ExpectedExceptionHelper {
    public static void expectException(@Nonnull ExpectedException rule, @Nonnull Class<? extends Throwable> expectedExceptionType) {
        rule.expect(expectedExceptionType);
    }

    public static void expectException(@Nonnull ExpectedException rule, @Nonnull Class<? extends Throwable> expectedExceptionType, @Nonnull String message) {
        expectException(rule, expectedExceptionType, message, MessageMatch.getDefault());
    }

    public static void expectException(@Nonnull ExpectedException rule, @Nonnull Class<? extends Throwable> expectedExceptionType, @Nonnull String message,
                                       @Nonnull MessageMatch match) {
        expectException(rule, expectedExceptionType);

        rule.expectMessage(getMatcher(message, match));
    }

    private static Matcher<String> getMatcher(@Nonnull String message, @Nonnull MessageMatch match) {
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
