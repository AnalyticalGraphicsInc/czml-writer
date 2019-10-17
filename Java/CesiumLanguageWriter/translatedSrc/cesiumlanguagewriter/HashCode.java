package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Contains static methods for working with hash codes.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class HashCode {
    private HashCode() {}

    /**
    * Combines an arbitrary number of hash codes.
    * @param hashes The hash codes.
    * @return The combined hash code.
    */
    public static int combine(@Nonnull int... hashes) {
        int result = 17;
        for (final int hash : hashes) {
            result = result * 31 + hash;
        }
        return result;
    }

    /**
    * Gets a hash code for a specified object, or zero if the object is {@code null}.
    * @param o The object for which to get the hash code.
    * @return The hash code of the object, or zero if the object is {@code null}.
    */
    public static int getHashCode(@Nullable Object o) {
        return o == null ? 0 : o.hashCode();
    }
}