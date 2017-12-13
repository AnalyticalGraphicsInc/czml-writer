package agi.foundation.compatibility;

/**
 * Helper methods related to Objects.
 */
public final class ObjectHelper {
    /**
     * made default constructor private to avoid Object Creation.
     */
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
    public static boolean equals(final Object objA, final Object objB) {
        if (objA == objB)
            return true;

        if (objA != null && objB != null)
            return objA.equals(objB);

        return false;
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
    public static boolean notEquals(final Object objA, final Object objB) {
        return !equals(objA, objB);
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
    public static boolean referenceEquals(final Object objA, final Object objB) {
        return objA == objB;
    }
}
