package agi.foundation.compatibility;

import static java.lang.System.lineSeparator;

/**
 * The exception that is thrown when one of the arguments provided to a method is not
 * valid.
 */
public class ArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = -5541530755505468417L;
    private final String paramName;

    /**
     * Initializes a new instance.
     */
    public ArgumentException() {
        super("Value does not fall within the expected range.");
        paramName = null;
    }

    /**
     * Initializes a new instance with a specified error message.
     *
     * @param message
     *            The error message that explains the reason for the exception.
     */
    public ArgumentException(String message) {
        super(message);
        paramName = null;
    }

    /**
     * Initializes a new instance with a specified error message and a reference to the
     * inner exception that is the cause of this exception.
     *
     * @param message
     *            The error message that explains the reason for the exception.
     * @param cause
     *            The exception that is the cause of the current exception.
     */
    public ArgumentException(String message, Exception cause) {
        super(message, cause);
        paramName = null;
    }

    /**
     * Initializes a new instance with a specified error message and the name of the
     * parameter that causes this exception.
     *
     * @param message
     *            The error message that explains the reason for the exception.
     * @param paramName
     *            The name of the parameter that caused the current exception.
     */
    public ArgumentException(String message, String paramName) {
        super(message);
        this.paramName = paramName;
    }

    /**
     * Initializes a new instance with a specified error message, the parameter name, and
     * a reference to the inner exception that is the cause of this exception.
     *
     * @param message
     *            The error message that explains the reason for the exception.
     * @param paramName
     *            The name of the parameter that caused the current exception.
     * @param cause
     *            The exception that is the cause of the current exception.
     */
    public ArgumentException(String message, String paramName, Exception cause) {
        super(message, cause);
        this.paramName = paramName;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (StringHelper.isNullOrEmpty(paramName)) {
            return message;
        }
        return message + lineSeparator() + "Parameter name: " + paramName;
    }

    /**
     * Gets the name of the parameter that causes this exception.
     *
     * @return The parameter name.
     */
    public String getParamName() {
        return paramName;
    }
}
