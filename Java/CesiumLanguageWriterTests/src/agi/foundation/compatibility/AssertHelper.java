package agi.foundation.compatibility;

import static agi.foundation.compatibility.ConvertHelper.toDouble;
import static agi.foundation.compatibility.ConvertHelper.toInt32;
import static agi.foundation.compatibility.ConvertHelper.toInt64;
import static agi.foundation.compatibility.ConvertHelper.toSingle;
import static agi.foundation.compatibility.StringHelper.format;
import static agi.foundation.compatibility.StringHelper.nullToEmpty;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.fail;

import java.lang.reflect.Array;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.StringDescription;
import org.junit.Assert;
import org.junit.internal.ArrayComparisonFailure;

import agi.foundation.TypeLiteral;

/**
 * Extra assert methods.
 */
public final class AssertHelper {
    private AssertHelper() {}

    @Nonnull
    private static final String emptyString = StringHelper.empty;
    @Nonnull
    private static final Object[] emptyArray = ArrayHelper.empty;

    public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(actual, matcher);
    }

    public static <T> void assertThat(T actual, Matcher<? super T> matcher, String message) {
        MatcherAssert.assertThat(message, actual, matcher);
    }

    public static <T> void assertThat(T actual, Matcher<? super T> matcher, String message, Object... args) {
        if (!matcher.matches(actual)) {
            Description description = new StringDescription();
            description.appendText(formatMessage(message, args)).appendText(System.lineSeparator()) //
                    .appendText("Expected: ").appendDescriptionOf(matcher).appendText(System.lineSeparator()) //
                    .appendText("     but: ");
            matcher.describeMismatch(actual, description);
            throw new AssertionError(description.toString());
        }
    }

    private static String formatMessage(String message, Object... args) {
        message = nullToEmpty(message);
        args = args == null ? emptyArray : args;
        if (args.length == 0)
            return message;
        return format(message, args);
    }

    // assertNotEqual

    public static void assertNotEqual(Object expected, Object actual) {
        assertNotEqual(expected, actual, emptyString, emptyArray);
    }

    public static void assertNotEqual(Object expected, Object actual, String message, Object... args) {
        assertThat(actual, not(equalTo(expected)), message, args);
    }

    // assertIsEmpty

    public static void assertIsEmpty(String actual) {
        assertIsEmpty(actual, emptyString, emptyArray);
    }

    public static void assertIsEmpty(String actual, String message, Object... args) {
        assertThat(actual, emptyString(), message, args);
    }

    // assertLess

    public static <T extends Comparable<T>> void assertLess(T a, T b) {
        assertThat(a, lessThan(b));
    }

    // assertGreater

    public static <T extends Comparable<T>> void assertGreater(T a, T b) {
        assertThat(a, greaterThan(b));
    }

    // assertStringContains

    public static void assertStringContains(String expected, String actual) {
        assertStringContains(expected, actual, emptyString, emptyArray);
    }

    public static void assertStringContains(String expected, String actual, String message, Object... args) {
        assertThat(actual, containsString(expected), message, args);
    }

    // assertStringStartsWith

    public static void assertStringStartsWith(String expected, String actual) {
        assertStringStartsWith(expected, actual, emptyString, emptyArray);
    }

    public static void assertStringStartsWith(String expected, String actual, String message, Object... args) {
        assertThat(actual, startsWith(expected), message, args);
    }

    // NUnit allows comparing two boxed numbers of different type.
    public static void assertEquals(Object expected, Object actual) {
        assertEquals(emptyString, expected, actual);
    }

    public static void assertEquals(Object expected, Object actual, String message, Object... args) {
        assertEquals(formatMessage(message, args), expected, actual);
    }

    private static void assertEquals(String message, Object expected, Object actual) {
        if (expected instanceof Number && actual instanceof Number) {
            assertNumbersAreEqual(message, (Number) expected, (Number) actual);
        } else if (isArray(expected) && isArray(actual)) {
            assertArraysAreEqual(message, expected, actual);
        } else {
            Assert.assertEquals(message, expected, actual);
        }
    }

    private static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    // based on the internal implementation of Assert.assertArrayEquals
    private static void assertArraysAreEqual(String message, Object expecteds, Object actuals) {
        if (expecteds == actuals) {
            return;
        }

        String header = nullToEmpty(message);
        if (!header.isEmpty())
            header += ": ";

        if (expecteds == null)
            fail(header + "expected array was null");
        if (actuals == null)
            fail(header + "actual array was null");

        int actualsLength = Array.getLength(actuals);
        int expectedsLength = Array.getLength(expecteds);
        if (actualsLength != expectedsLength) {
            fail(header + "array lengths differed, expected.length=" + expectedsLength + " actual.length=" + actualsLength);
        }

        for (int i = 0; i < expectedsLength; ++i) {
            Object expected = Array.get(expecteds, i);
            Object actual = Array.get(actuals, i);

            if (isArray(expected) && isArray(actual)) {
                try {
                    assertArraysAreEqual(message, expected, actual);
                } catch (ArrayComparisonFailure e) {
                    e.addDimension(i);
                    throw e;
                }
            } else {
                try {
                    Assert.assertEquals(expected, actual);
                } catch (AssertionError e) {
                    throw new ArrayComparisonFailure(header, e, i);
                }
            }
        }
    }

    private static void assertNumbersAreEqual(String message, Number expected, Number actual) {
        // based on the logic in NUnit
        if (expected instanceof Double || actual instanceof Double) {
            Assert.assertEquals(message, toDouble(expected), toDouble(actual), 0D);
        } else if (expected instanceof Float || actual instanceof Float) {
            Assert.assertEquals(message, toSingle(expected), toSingle(actual), 0F);
        } else if (expected instanceof Long || actual instanceof Long) {
            Assert.assertEquals(message, toInt64(expected), toInt64(actual));
        } else {
            Assert.assertEquals(message, toInt32(expected), toInt32(actual));
        }
    }

    public static void assertEquals(double expected, double actual, double delta) {
        Assert.assertEquals(expected, actual, delta);
    }

    // assertThrows
    //
    // An assertThrows method is built-in to JUnit, however, NUnit requires
    // "Assert.Throws" to match the exception type exactly, while "Assert.Catch" allows
    // derived exception types.

    public static <T extends Throwable> T assertThrows(@Nonnull TypeLiteral<T> typeLiteralT, @Nonnull Action action) {
        return assertThrows(typeLiteralT.asClass(), action);
    }

    public static <T extends Throwable> T assertThrows(@Nonnull TypeLiteral<T> typeLiteralT, @Nonnull Action action, String message, Object... args) {
        return assertThrows(typeLiteralT.asClass(), action, message, args);
    }

    public static <T extends Throwable> T assertThrows(Class<T> expectedExceptionType, @Nonnull Action action) {
        return assertThrows(expectedExceptionType, action, emptyString, emptyArray);
    }

    public static <T extends Throwable> T assertThrows(Class<T> expectedExceptionType, @Nonnull Action action, String message, Object... args) {
        return assertThrows(expectedExceptionType, action, () -> hasClass(expectedExceptionType), message, args);
    }

    private static final class ExactClassMatcher extends BaseMatcher<Object> {
        private final Class<?> expectedClass;

        public ExactClassMatcher(Class<?> expectedClass) {
            this.expectedClass = expectedClass;
        }

        @Override
        public boolean matches(Object item) {
            return item != null && item.getClass().equals(expectedClass);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("instance of ");
            description.appendValue(expectedClass);
        }
    }

    private static ExactClassMatcher hasClass(Class<?> expectedClass) {
        return new ExactClassMatcher(expectedClass);
    }
    private static <T extends Throwable> T assertThrows(Class<T> expectedExceptionType, @Nonnull Action action, @Nonnull Supplier<Matcher<?>> matcher, String message,
                                                        Object... args) {
        try {
            action.invoke();
        } catch (Throwable actualThrown) {
            if (matcher.get().matches(actualThrown)) {
                @SuppressWarnings("unchecked")
                T result = (T) actualThrown;
                return result;
            }

            String msg = formatMessage(message, args);
            msg += " unexpected exception type thrown; expected " + formatClass(expectedExceptionType) + " but was " + formatClass(actualThrown.getClass());
            AssertionError assertionError = new AssertionError(msg);
            assertionError.initCause(actualThrown);
            throw assertionError;
        }

        String msg = formatMessage(message, args);
        msg += " expected " + formatClass(expectedExceptionType) + " to be thrown but nothing was thrown";
        throw new AssertionError(msg);
    }

    private static String formatClass(Class<?> c) {
        String className = c.getCanonicalName();
        return className == null ? c.getName() : className;
    }
}