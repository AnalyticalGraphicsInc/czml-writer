package agi.foundation.compatibility;

import java.util.Map;

/**
 * Helper class for Map methods.
 */
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
    public static <K, V> boolean tryGetValue(Map<K, V> map, K key, V[] value) {
        if (key == null)
            throw new ArgumentNullException("key");

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
    public static <K, V> boolean remove(Map<K, V> map, K key) {
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
    public static <K, V> void add(Map<K, V> map, K key, V value) {
        if (key == null)
            throw new ArgumentNullException("key");
        if (map.containsKey(key))
            throw new ArgumentException("An entry with the same key already exists.");
        map.put(key, value);
    }
}
