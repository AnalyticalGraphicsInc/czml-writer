package agi.foundation.compatibility;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.Array;

import org.junit.Assert;
import org.junit.internal.ArrayComparisonFailure;

import agi.foundation.TypeLiteral;

/**
 * Extra assert methods.
 */
public final class AssertHelper {
    private AssertHelper() {}

    public static void assertNotEqual(Object expected, Object actual) {
        assertNotEqual("", expected, actual);
    }

    public static void assertNotEqual(String message, Object expected, Object actual) {
        assertThat(message, actual, not(equalTo(expected)));
    }

    public static void assertIsEmpty(String actual) {
        assertThat(actual, isEmptyString());
    }

    public static <T extends Comparable<T>> void assertLess(T a, T b) {
        assertThat(a, lessThan(b));
    }

    public static <T extends Comparable<T>> void assertGreater(T a, T b) {
        assertThat(a, greaterThan(b));
    }

    public static void assertStringContains(String expected, String actual) {
        assertThat(actual, containsString(expected));
    }

    public static void assertStringStartsWith(String expected, String actual) {
        assertThat(actual, startsWith(expected));
    }

    // NUnit allows comparing two boxed numbers of different type.
    public static void assertEquals(Object expected, Object actual) {
        assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, Object expected, Object actual) {
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

        String header = message == null ? "" : message + ": ";

        if (expecteds == null) {
            fail(header + "expected array was null");
        }

        if (actuals == null) {
            fail(header + "actual array was null");
        }

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
            Assert.assertEquals(message, ConvertHelper.toDouble(expected), ConvertHelper.toDouble(actual), 0D);
        } else if (expected instanceof Float || actual instanceof Float) {
            Assert.assertEquals(message, ConvertHelper.toSingle(expected), ConvertHelper.toSingle(actual), 0D);
        } else if (expected instanceof Long || actual instanceof Long) {
            Assert.assertEquals(message, ConvertHelper.toInt64(expected), ConvertHelper.toInt64(actual));
        } else {
            Assert.assertEquals(message, ConvertHelper.toInt32(expected), ConvertHelper.toInt32(actual));
        }
    }

    /**
     * An assertThrows method is built-in in JUnit 4.13 (not yet released). However, NUnit
     * requires "Assert.Throws" to match the exception type exactly while "Assert.Catch"
     * allows derived exception types.
     */
    public static <T extends Throwable> T assertThrows(TypeLiteral<T> typeLiteralT, Action action) {
        return assertThrows(typeLiteralT.asClass(), action);
    }

    public static <T extends Throwable> T assertThrows(TypeLiteral<T> typeLiteralT, String message, Action action) {
        return assertThrows(message, typeLiteralT.asClass(), action);
    }

    public static <T extends Throwable> T assertThrows(Class<T> expectedExceptionType, Action action) {
        return assertThrows(null, expectedExceptionType, action);
    }

    public static <T extends Throwable> T assertThrows(String message, Class<T> expectedExceptionType, Action action) {
        return assertThrows(true, message, expectedExceptionType, action);
    }

    private static <T extends Throwable> T assertThrows(boolean exact, String message, Class<T> expectedExceptionType, Action action) {
        if (message == null) {
            message = "";
        }

        try {
            action.invoke();
        } catch (Throwable actualThrown) {
            boolean exceptionIsCorrectType;
            if (exact) {
                exceptionIsCorrectType = actualThrown.getClass().equals(expectedExceptionType);
            } else {
                exceptionIsCorrectType = expectedExceptionType.isInstance(actualThrown);
            }

            if (exceptionIsCorrectType) {
                @SuppressWarnings("unchecked")
                T result = (T) actualThrown;
                return result;
            }

            message += " unexpected exception type thrown; expected " + formatClass(expectedExceptionType) + " but was " + formatClass(actualThrown.getClass());
            AssertionError assertionError = new AssertionError(message);
            assertionError.initCause(actualThrown);
            throw assertionError;
        }

        message += " expected " + formatClass(expectedExceptionType) + " to be thrown but nothing was thrown";
        throw new AssertionError(message);
    }

    private static String formatClass(Class<?> c) {
        String className = c.getCanonicalName();
        return className == null ? c.getName() : className;
    }
}