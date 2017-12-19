package agi.foundation.compatibility;

import java.util.Objects;

import javax.annotation.Nullable;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Helper methods related to Objects.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class ObjectHelper {
    private ObjectHelper() {}

    /**
     * Determines whether the specified Object instances are considered equal.
     *
     * @param objA
     *            The first Object to compare.
     * @param objB
     *            The second Object to compare.
     * @return true if the instances are equal; otherwise false.
     */
    public static boolean equals(@Nullable Object objA, @Nullable Object objB) {
        return Objects.equals(objA, objB);
    }

    /**
     * Determines whether the specified Object instances are considered not equal.
     *
     * @param objA
     *            The first Object to compare.
     * @param objB
     *            The second Object to compare.
     * @return true if the instances are not equal; otherwise false.
     */
    public static boolean notEquals(@Nullable Object objA, @Nullable Object objB) {
        return !Objects.equals(objA, objB);
    }

    /**
     * Determines whether the specified Object instances are the same instance.
     *
     * @param objA
     *            The first Object to compare.
     * @param objB
     *            The second Object to compare.
     * @return true if objA is the same instance as objB or if both are null references;
     *         otherwise, false.
     */
    public static boolean referenceEquals(@Nullable Object objA, @Nullable Object objB) {
        return objA == objB;
    }
}
