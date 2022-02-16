package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

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
     * Initializes a new instance that is empty and has the default initial capacity.
     *
     * @return The new map.
     */
    @Nonnull
    public static <K, V> LinkedHashMap<K, V> create() {
        return new Dictionary<>();
    }

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
        assertNonNull(key, "key");

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
        assertNonNull(key, "key");

        if (map.containsKey(key))
            throw new ArgumentException("An item with the same key has already been added.");

        map.put(key, value);
    }

    /**
     * Map subclass that disallows null keys.
     */
    private static final class Dictionary<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = 7326623111245956508L;

        public Dictionary() {
            super();
        }

        public Dictionary(int initialCapacity) {
            super(initialCapacity);
        }

        public Dictionary(Map<? extends K, ? extends V> m) {
            super(m);
        }

        @Override
        public boolean containsKey(Object key) {
            assertNonNull(key, "key");
            return super.containsKey(key);
        }

        @Override
        public V get(Object key) {
            assertNonNull(key, "key");
            return super.get(key);
        }

        @Override
        public V put(K key, V value) {
            assertNonNull(key, "key");
            return super.put(key, value);
        }

        @Override
        public V remove(Object key) {
            assertNonNull(key, "key");
            return super.remove(key);
        }

        @Override
        public V getOrDefault(Object key, V defaultValue) {
            assertNonNull(key, "key");
            return super.getOrDefault(key, defaultValue);
        }

        @Override
        public V putIfAbsent(K key, V value) {
            assertNonNull(key, "key");
            return super.putIfAbsent(key, value);
        }

        @Override
        public boolean remove(Object key, Object value) {
            assertNonNull(key, "key");
            return super.remove(key, value);
        }

        @Override
        public boolean replace(K key, V oldValue, V newValue) {
            assertNonNull(key, "key");
            return super.replace(key, oldValue, newValue);
        }

        @Override
        public V replace(K key, V value) {
            assertNonNull(key, "key");
            return super.replace(key, value);
        }

        @Override
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            assertNonNull(key, "key");
            return super.computeIfAbsent(key, mappingFunction);
        }

        @Override
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            assertNonNull(key, "key");
            return super.computeIfPresent(key, remappingFunction);
        }

        @Override
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            assertNonNull(key, "key");
            return super.compute(key, remappingFunction);
        }

        @Override
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            assertNonNull(key, "key");
            return super.merge(key, value, remappingFunction);
        }
    }
}
