package agi.foundation.compatibility;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Nonnull;

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
    @Nonnull
    public static <T> ArrayList<T> create(@Nonnull Iterable<? extends T> iterable) {
        ArgumentNullException.assertNonNull(iterable, "iterable");

        if (iterable instanceof Collection<?>) {
            return new ArrayList<>((Collection<? extends T>) iterable);
        }

        ArrayList<T> result = new ArrayList<>();
        for (T t : iterable) {
            result.add(t);
        }
        return result;
    }
}
