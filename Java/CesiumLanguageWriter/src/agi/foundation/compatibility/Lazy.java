package agi.foundation.compatibility;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Provides support for lazy initialization. Currently only supports non-thread-safe
 * initialization.
 *
 * @param <T>
 *            The type of object that is being lazily initialized.
 */
@Internal
@Deprecated
public class Lazy<T> {
    @Nonnull
    private Supplier<T> m_valueFactory;
    private T m_instance;

    /**
     * Initializes a new instance.
     *
     * @param valueFactory
     *            The delegate that is invoked to produce the lazily initialized value
     *            when it is needed.
     * @param isThreadSafe
     *            Must be {@code false}.
     */
    public Lazy(@Nonnull Supplier<T> valueFactory, boolean isThreadSafe) {
        ArgumentNullException.assertNonNull(valueFactory, "valueFactory");

        if (isThreadSafe) {
            throw new UnsupportedOperationException();
        }

        m_valueFactory = valueFactory;
    }

    /**
     * Gets the lazily initialized value of the current instance.
     */
    public final T getValue() {
        if (m_instance == null) {
            m_instance = m_valueFactory.get();
        }
        return m_instance;
    }
}