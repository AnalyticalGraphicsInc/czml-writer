package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import javax.annotation.Nonnull;

/**
 * Specifies how a {@link Lazy} instance synchronizes access among multiple threads.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public enum LazyThreadSafetyMode implements Enumeration {
    /**
     * The {@link Lazy} instance is not thread safe; if the instance is accessed from
     * multiple threads, its behavior is undefined. Use this mode only when high
     * performance is crucial and the {@link Lazy} instance is guaranteed never to be
     * initialized from more than one thread.
     */
    NONE(0),
    /**
     * When multiple threads try to initialize a {@link Lazy} instance simultaneously, all
     * threads are allowed to run the initialization method (or the parameterless
     * constructor, if there is no initialization method). The first thread to complete
     * initialization sets the value of the {@link Lazy} instance. This is referred to as
     * Publication in the field names. That value is returned to any other threads that
     * were simultaneously running the initialization method, unless the initialization
     * method throws exceptions on those threads. Any instances of {@code T} that were
     * created by the competing threads are discarded. Effectively, the publication of the
     * initialized value is thread-safe in the sense that only one of the initialized
     * values may be published and used by all threads.
     */
    PUBLICATION_ONLY(1),
    /**
     * Locks are used to ensure that only a single thread can initialize a {@link Lazy}
     * instance in a thread-safe manner. Effectively, the initialization method is
     * executed in a thread-safe manner (referred to as Execution in the field name).
     * Publication of the initialized value is also thread-safe in the sense that only one
     * value may be published and used by all threads. If the initialization method (or
     * the parameterless constructor, if there is no initialization method) uses locks
     * internally, deadlocks can occur.
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
