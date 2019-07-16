package agi.foundation.compatibility;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Provides support for lazy initialization.
 *
 * @param <T>
 *            The type of object that is being lazily initialized.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class Lazy<T> {
    @Nonnull
    private final Supplier<? extends T> m_valueFactory;
    @Nonnull
    private final Strategy<T> m_strategy;

    private interface Strategy<T> {
        boolean getIsValueCreated();

        T getValue();
    }

    /**
     * Non-thread-safe.
     */
    private final class NoneStrategy implements Strategy<T> {
        private T m_value;

        @Override
        public boolean getIsValueCreated() {
            return m_value != null;
        }

        @Override
        public T getValue() {
            if (m_value == null) {
                m_value = m_valueFactory.get();
            }
            return m_value;
        }
    }

    /**
     * Allows multiple invocations of value factory but only one winning value.
     */
    private final class PublicationOnlyStrategy implements Strategy<T> {
        @Nonnull
        private final AtomicReference<T> m_value = new AtomicReference<>();

        @Override
        public boolean getIsValueCreated() {
            return m_value.get() != null;
        }

        @Override
        public T getValue() {
            T value = m_value.get();
            if (value != null) {
                return value;
            }

            value = m_valueFactory.get();

            if (m_value.compareAndSet(null, value)) {
                return value;
            }

            return m_value.get();
        }
    }

    /**
     * Synchronizes on invocations of value factory.
     */
    private final class ExecutionAndPublicationStrategy implements Strategy<T> {
        private volatile T m_value;

        @Override
        public boolean getIsValueCreated() {
            return m_value != null;
        }

        @Override
        public T getValue() {
            T value = m_value;
            if (value == null) {
                synchronized (this) {
                    value = m_value;
                    if (value == null) {
                        m_value = value = m_valueFactory.get();
                    }
                }
            }
            return value;
        }
    }

    /**
     * Initializes a new instance.
     *
     * @param valueFactory
     *            The delegate that is invoked to produce the lazily initialized value
     *            when it is needed.
     */
    public Lazy(@Nonnull Supplier<? extends T> valueFactory) {
        this(valueFactory, LazyThreadSafetyMode.EXECUTION_AND_PUBLICATION);
    }

    /**
     * Initializes a new instance.
     *
     * @param valueFactory
     *            The delegate that is invoked to produce the lazily initialized value
     *            when it is needed.
     * @param isThreadSafe
     *            {@code true} to make this instance usable concurrently by multiple
     *            threads; {@code false} to make this instance usable by only one thread
     *            at a time.
     */
    public Lazy(@Nonnull Supplier<? extends T> valueFactory, boolean isThreadSafe) {
        this(valueFactory, isThreadSafe ? LazyThreadSafetyMode.EXECUTION_AND_PUBLICATION : LazyThreadSafetyMode.NONE);
    }

    /**
     * Initializes a new instance that uses the specified initialization function and
     * thread-safety mode.
     *
     * @param valueFactory
     *            The delegate that is invoked to produce the lazily initialized value
     *            when it is needed.
     * @param mode
     *            The thread safety mode.
     */
    public Lazy(@Nonnull Supplier<? extends T> valueFactory, @Nonnull LazyThreadSafetyMode mode) {
        ArgumentNullException.assertNonNull(valueFactory, "valueFactory");

        m_valueFactory = valueFactory;

        switch (mode) {
        case EXECUTION_AND_PUBLICATION:
            m_strategy = new ExecutionAndPublicationStrategy();
            break;
        case PUBLICATION_ONLY:
            m_strategy = new PublicationOnlyStrategy();
            break;
        case NONE:
            m_strategy = new NoneStrategy();
            break;
        default:
            throw new ArgumentOutOfRangeException("mode", "Undefined enum value.");
        }
    }

    /**
     * Gets a value that indicates whether a value has been created for this Lazy<T>
     * instance.
     */
    public boolean getIsValueCreated() {
        return m_strategy.getIsValueCreated();
    }

    /**
     * Gets the lazily initialized value of the current instance.
     */
    public final T getValue() {
        return m_strategy.getValue();
    }
}