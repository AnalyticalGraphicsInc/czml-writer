package agi.foundation.compatibility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

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
	public static <T> ArrayList<T> create(Iterable<T> iterable) {
		if (iterable instanceof Map<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) iterable;
			@SuppressWarnings("unchecked")
			Set<T> entrySet = (Set<T>) map.entrySet();
			return new ArrayList<T>(entrySet);
		}

		if (iterable instanceof Collection<?>) {
			return new ArrayList<T>((Collection<T>) iterable);
		}

		ArrayList<T> result = new ArrayList<T>();
		for (T t : iterable) {
			result.add(t);
		}
		return result;
	}
}
