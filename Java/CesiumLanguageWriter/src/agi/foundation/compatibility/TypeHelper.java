package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import javax.annotation.Nonnull;

/**
 * Provides the wrapper functions for C# methods of System.Type class.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class TypeHelper {
    static final byte DEFAULT_BYTE = 0;

    private TypeHelper() {}

    /**
     * This method expects that the class must exist.
     */
    @Nonnull
    static Class<?> classForName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeClassNotFoundException(e);
        }
    }
}
