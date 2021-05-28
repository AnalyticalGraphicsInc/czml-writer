package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.util.Map;

import javax.annotation.Nonnull;

/**
 * Helper class for Map methods.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class MapHelper {
    private MapHelper() {}

    /**
     * Gets the value associated with the specified key.
     *
     * @param map
     *            map to get value from
     * @param key
     *            The key of the value to get.
     * @param value
     *            When this method returns, contains the value associated with the
     *            specified key, if the key is found; otherwise, the default value for the
     *            type of the value parameter. This parameter is passed uninitialized.
     * @return true if the map contains an element with the specified key; otherwise,
     *         false.
     */
    public static <K, V> boolean tryGetValue(@Nonnull Map<K, V> map, @Nonnull K key, @Nonnull V[] value) {
        ArgumentNullException.assertNonNull(key, "key");

        value[0] = map.get(key);

        return value[0] != null;
    }

    /**
     * Removes the value with the specified key from the map.
     *
     * @param map
     *            the map
     * @param key
     *            The key of the element to remove.
     * @return true if the element is successfully found and removed; otherwise, false.
     *         This method returns false if key is not found in the map.
     */
    public static <K, V> boolean remove(@Nonnull Map<K, V> map, K key) {
        int oldSize = map.size();

        if (map.remove(key) != null)
            return true;

        return oldSize != map.size();
    }

    /**
     * Adds the specified key and value to the dictionary.
     *
     * @param map
     *            the map
     * @param key
     *            The key of the element to add.
     * @param value
     *            The value of the element to add.
     */
    public static <K, V> void add(@Nonnull Map<K, V> map, @Nonnull K key, V value) {
        ArgumentNullException.assertNonNull(key, "key");

        if (map.containsKey(key))
            throw new ArgumentException("An item with the same key has already been added.");

        map.put(key, value);
    }
}
