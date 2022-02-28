package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.lang.reflect.Array;
import java.util.Collection;

import javax.annotation.Nonnull;

/**
 * Helper methods related to collections.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class CollectionsHelper {
    private CollectionsHelper() {}

    public static boolean isEmpty(@Nonnull Collection<?> self) {
        return self.size() == 0;
    }

    public static boolean containsAll(@Nonnull Collection<?> self, Collection<?> c) {
        for (Object o : c) {
            if (!self.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Nonnull
    public static Object[] toArray(@Nonnull Collection<?> self) {
        Object[] result = new Object[self.size()];
        int i = 0;
        for (Object o : self) {
            result[i++] = o;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    public static <T> T[] toArray(@Nonnull Collection<?> self, T[] a) {
        int size = self.size();
        T[] result = a.length >= size ? a : (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        int i = 0;
        for (Object o : self) {
            result[i++] = (T) o;
        }
        return result;
    }
}
