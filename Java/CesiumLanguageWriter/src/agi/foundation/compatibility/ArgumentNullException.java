package agi.foundation.compatibility;

/**
 * The exception that is thrown when a null reference is passed to a method that does not
 * accept it as a valid argument.
 */
public class ArgumentNullException extends ArgumentException {
    private static final long serialVersionUID = 3515157804741239199L;
    private static final String DEFAULT_MESSAGE = "Value cannot be null.";

    /**
     * Initializes a new instance.
     */
    public ArgumentNullException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Initializes a new instance with the name of the parameter that causes this
     * exception.
     *
     * @param paramName
     *            The name of the parameter that caused the exception.
     */
    public ArgumentNullException(String paramName) {
        super(DEFAULT_MESSAGE, paramName);
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
    public ArgumentNullException(String message, Exception cause) {
        super(message, cause);
    }

    /**
     * Initializes an instance with a specified error message and the name of the
     * parameter that causes this exception.
     *
     * @param paramName
     *            The name of the parameter that caused the exception.
     * @param message
     *            A message that describes the error.
     */
    public ArgumentNullException(String paramName, String message) {
        super(message, paramName);
    }

    /**
     * Checks that the specified object reference is not {@code null} and throws a
     * {@link ArgumentNullException} with the specified {@code paramName} if it is.
     *
     * @param <T>
     *            The type of {@code value}.
     * @param value
     *            The object to check.
     * @param paramName
     *            The name of the parameter that is being checked.
     * @throws ArgumentNullException
     *             Thrown when {@code value} is {@code null}.
     */
    public static <T> void assertNonNull(T value, String paramName) {
        if (value == null)
            throw new ArgumentNullException(paramName);
    }
}
