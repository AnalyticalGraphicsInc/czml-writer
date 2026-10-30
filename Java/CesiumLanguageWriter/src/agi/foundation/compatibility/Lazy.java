package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

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
    private final Strategy<T> m_strategy;

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
        assertNonNull(valueFactory, "valueFactory");
        m_strategy = Strategy.create(valueFactory, mode);
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

    private static abstract class Strategy<T> {
        @Nonnull
        private final Supplier<? extends T> m_valueFactory;

        protected Strategy(@Nonnull Supplier<? extends T> m_valueFactory) {
            this.m_valueFactory = m_valueFactory;
        }

        public abstract boolean getIsValueCreated();

        public abstract T getValue();

        protected T createValue() {
            return m_valueFactory.get();
        }

        @Nonnull
        public static <T> Strategy<T> create(@Nonnull Supplier<? extends T> valueFactory, @Nonnull LazyThreadSafetyMode mode) {
            switch (mode) {
            case EXECUTION_AND_PUBLICATION:
                return new ExecutionAndPublicationStrategy<>(valueFactory);
            case PUBLICATION_ONLY:
                return new PublicationOnlyStrategy<>(valueFactory);
            case NONE:
                return new NoneStrategy<>(valueFactory);
            default:
                return ArgumentOutOfRangeException._throw();
            }
        }
    }

    /**
     * Non-thread-safe.
     */
    private static final class NoneStrategy<T> extends Strategy<T> {
        private T m_value;

        public NoneStrategy(@Nonnull Supplier<? extends T> m_valueFactory) {
            super(m_valueFactory);
        }

        @Override
        public boolean getIsValueCreated() {
            return m_value != null;
        }

        @Override
        public T getValue() {
            if (m_value == null) {
                m_value = createValue();
            }
            return m_value;
        }
    }

    /**
     * Allows multiple invocations of value factory but only one winning value.
     */
    private static final class PublicationOnlyStrategy<T> extends Strategy<T> {
        @Nonnull
        private final AtomicReference<T> m_value = new AtomicReference<>();

        public PublicationOnlyStrategy(@Nonnull Supplier<? extends T> m_valueFactory) {
            super(m_valueFactory);
        }

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

            value = createValue();

            if (m_value.compareAndSet(null, value)) {
                return value;
            }

            return m_value.get();
        }
    }

    /**
     * Synchronizes on invocations of value factory.
     */
    private static final class ExecutionAndPublicationStrategy<T> extends Strategy<T> {
        private volatile T m_value;

        public ExecutionAndPublicationStrategy(@Nonnull Supplier<? extends T> m_valueFactory) {
            super(m_valueFactory);
        }

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
                        m_value = value = createValue();
                    }
                }
            }
            return value;
        }
    }
}