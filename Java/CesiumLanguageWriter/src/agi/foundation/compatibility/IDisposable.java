package agi.foundation.compatibility;

/**
 * Defines a method to release allocated resources.
 */
public interface IDisposable extends AutoCloseable {
    /**
     * Performs application-defined tasks associated with freeing, releasing, or resetting
     * unmanaged resources.
     */
    void dispose();

    @Override
    default void close() {
        dispose();
    }
}
