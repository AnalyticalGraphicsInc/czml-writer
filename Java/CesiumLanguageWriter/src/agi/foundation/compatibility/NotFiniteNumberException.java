package agi.foundation.compatibility;

public class NotFiniteNumberException extends ArithmeticException {
    private static final long serialVersionUID = -2306307019873202030L;
    private static final String DEFAULT_MESSAGE = "Number encountered was not a finite quantity.";
    private double offendingNumber;

    public NotFiniteNumberException() {
        this(DEFAULT_MESSAGE);
    }

    public NotFiniteNumberException(double offendingNumber) {
        this(DEFAULT_MESSAGE, offendingNumber);
    }

    public NotFiniteNumberException(String message) {
        super(message);
    }

    public NotFiniteNumberException(String message, double offendingNumber) {
        this(message);
        this.offendingNumber = offendingNumber;
    }

    public NotFiniteNumberException(String message, Exception cause) {
        this(message);
        initCause(cause);
    }

    public NotFiniteNumberException(String message, double offendingNumber, Exception cause) {
        this(message, cause);
        this.offendingNumber = offendingNumber;
    }

    public double getOffendingNumber() {
        return offendingNumber;
    }
}
