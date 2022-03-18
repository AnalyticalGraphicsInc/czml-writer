package agi.foundation.compatibility;

import static java.lang.System.lineSeparator;

/**
 * The exception that is thrown when the value of an argument is outside the allowable
 * range of values as defined by the invoked method.
 */
public class ArgumentOutOfRangeException extends ArgumentException {
    private static final long serialVersionUID = 6879363115706763498L;
    private static final String DEFAULT_MESSAGE = "Specified argument was out of the range of valid values.";
    private final Object actualValue;

    /**
     * Initializes a new instance.
     */
    public ArgumentOutOfRangeException() {
        super(DEFAULT_MESSAGE);
        actualValue = null;
    }

    /**
     * Initializes a new instance with the name of the parameter that causes this
     * exception.
     *
     * @param paramName
     *            The name of the parameter that causes this exception.
     */
    public ArgumentOutOfRangeException(String paramName) {
        super(DEFAULT_MESSAGE, paramName);
        actualValue = null;
    }

    /**
     * Initializes a new instance with a specified error message and the exception that is
     * the cause of this exception.
     *
     * @param message
     *            The error message that explains the reason for this exception.
     * @param cause
     *            The exception that is the cause of the current exception, or a null
     *            reference if no inner exception is specified.
     */
    public ArgumentOutOfRangeException(String message, Exception cause) {
        super(message, cause);
        actualValue = null;
    }

    /**
     * Initializes a new instance with a specified error message and the name of the
     * parameter that causes this exception.
     *
     * @param paramName
     *            The name of the parameter that caused the exception.
     * @param message
     *            The message that describes the error.
     */
    public ArgumentOutOfRangeException(String paramName, String message) {
        super(message, paramName);
        actualValue = null;
    }

    /**
     * Initializes a new instance with a specified error message, the parameter name, and
     * the value of the argument.
     *
     * @param paramName
     *            The name of the parameter that caused the exception.
     * @param actualValue
     *            The value of the argument that causes this exception.
     * @param message
     *            The message that describes the error.
     */
    public ArgumentOutOfRangeException(String paramName, Object actualValue, String message) {
        super(message, paramName);
        this.actualValue = actualValue;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (actualValue == null)
            return message;
        return message + lineSeparator() + "Actual value was " + actualValue + ".";
    }

    /**
     * Gets the argument value that causes this exception.
     *
     * @return An Object that contains the value of the parameter that caused the current
     *         Exception.
     */
    public Object getActualValue() {
        return actualValue;
    }

    static void assertNonNegative(int value, String paramName) {
        if (value < 0)
            throw new ArgumentOutOfRangeException(paramName, "Non-negative number required.");
    }
}
