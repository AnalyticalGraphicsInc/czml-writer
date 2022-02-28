package agi.foundation.compatibility;

import javax.annotation.Nonnull;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Contains methods related to threads.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class ThreadHelper {
    private ThreadHelper() {}

    @Internal
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeInterruptedException(e);
        }
    }

    @Internal
    @Nonnull
    public static <T> ThreadLocal<T> createThreadLocal(T initialValue) {
        return ThreadLocal.withInitial(() -> initialValue);
    }
}
