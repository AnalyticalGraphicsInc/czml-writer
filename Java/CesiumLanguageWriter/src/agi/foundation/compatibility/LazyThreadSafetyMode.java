package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import javax.annotation.Nonnull;

/**
 * Specifies how a Lazy instance synchronizes access among multiple threads.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public enum LazyThreadSafetyMode implements Enumeration {
    /**
     * The Lazy instance is not thread safe; if the instance is accessed from multiple
     * threads, its behavior is undefined.
     */
    NONE(0),
    /**
     * When multiple threads try to initialize a Lazy instance simultaneously, all threads
     * are allowed to run the initialization method (or the default constructor, if there
     * is no initialization method). The first thread to complete initialization sets the
     * value of the Lazy instance.
     */
    PUBLICATION_ONLY(1),
    /**
     * Locks are used to ensure that only a single thread can initialize a Lazy instance
     * in a thread-safe manner.
     */
    EXECUTION_AND_PUBLICATION(2);

    private final int value;

    LazyThreadSafetyMode(int value) {
        this.value = value;
    }

    /**
     * Get the numeric value associated with this enum constant.
     *
     * @return A numeric value.
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * Get the enum constant that is associated with the given numeric value.
     *
     * @return The enum constant associated with value.
     * @param value
     *            a numeric value.
     */
    @Nonnull
    public static LazyThreadSafetyMode getFromValue(int value) {
        switch (value) {
        case 0:
            return NONE;
        case 1:
            return PUBLICATION_ONLY;
        case 2:
            return EXECUTION_AND_PUBLICATION;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
     * Get the enum constant that is considered to be the default.
     *
     * @return The default enum constant.
     */
    @Nonnull
    public static LazyThreadSafetyMode getDefault() {
        return NONE;
    }
}
