package agi.foundation.compatibility;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Helper class for List methods.
 */
public final class ListHelper {
    private ListHelper() {}

    /**
     * Initializes a new list that contains elements copied from the specified sequence
     * and has sufficient capacity to accommodate the number of elements copied.
     *
     * @param iterable
     *            The sequence whose elements are copied to the new list.
     * @return The new list.
     */
    public static <T> ArrayList<T> create(Iterable<? extends T> iterable) {
        if (iterable instanceof Collection<?>) {
            return new ArrayList<T>((Collection<? extends T>) iterable);
        }

        ArrayList<T> result = new ArrayList<T>();
        for (T t : iterable) {
            result.add(t);
        }
        return result;
    }
}
