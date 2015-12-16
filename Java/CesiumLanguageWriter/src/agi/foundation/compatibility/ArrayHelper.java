package agi.foundation.compatibility;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * Helper methods for Arrays.
 */
public final class ArrayHelper {
	private static class ArrayList<E> extends AbstractList<E> implements RandomAccess {
		private final E[] array;

		public ArrayList(E[] array) {
			if (array == null)
				throw new NullPointerException();
			this.array = array;
		}

		public int size() {
			return array.length;
		}

		public Object[] toArray() {
			Object[] result = new Object[array.length];
			for (int i = 0; i < array.length; i++) {
				result[i] = array[i];
			}
			return result;
		}

		@SuppressWarnings("unchecked")
		public <T> T[] toArray(T[] a) {
			int size = array.length;
			if (a.length < size)
				a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);

			copy(array, 0, a, 0, size);

			if (a.length > size)
				a[size] = null;

			return a;
		}

		public E get(int index) {
			return array[index];
		}

		public E set(int index, E element) {
			E oldValue = array[index];
			array[index] = element;
			return oldValue;
		}

		public int indexOf(Object o) {
			if (o == null)
				return -1;

			for (int i = 0; i < array.length; i++)
				if (o.equals(array[i]))
					return i;

			return -1;
		}

		public boolean contains(Object o) {
			return indexOf(o) != -1;
		}
	}

	/**
	 * Copies a range of elements from an Array starting at the specified source index and
	 * pastes them to another Array starting at the specified destination index. The
	 * length and the indexes are specified as 32-bit integers.
	 * 
	 * @param sourceArray
	 *            The Array that contains the data to copy.
	 * @param sourceIndex
	 *            A 32-bit integer that represents the index in the sourceArray at which
	 *            copying begins.
	 * @param destinationArray
	 *            The Array that receives the data.
	 * @param destinationIndex
	 *            A 32-bit integer that represents the index in the destinationArray at
	 *            which storing begins.
	 * @param length
	 *            A 32-bit integer that represents the number of elements to copy.
	 */
	public static void copy(Object sourceArray, int sourceIndex, Object destinationArray, int destinationIndex, int length) {
		Class<?> sourceArrayComponentType = sourceArray.getClass().getComponentType();
		if (ValueType.class.isAssignableFrom(sourceArrayComponentType) && !ImmutableValueType.class.isAssignableFrom(sourceArrayComponentType)) {
			// if it's a non-immutable value type, we can't rely on System.arrayCopy, and
			// must do a deep copy to preserve value type semantics.

			int endSourceIndex = sourceIndex + length;
			for (; sourceIndex < endSourceIndex; sourceIndex++, destinationIndex++) {
				ICloneable sourceItem = (ICloneable) Array.get(sourceArray, sourceIndex);
				Array.set(destinationArray, destinationIndex, sourceItem.clone());
			}
		} else {
			System.arraycopy(sourceArray, sourceIndex, destinationArray, destinationIndex, length);
		}
	}

	/**
	 * Returns a fixed-size list backed by the specified array, or null if the specified
	 * array is null.
	 * 
	 * @param a
	 *            the array by which the list will be backed
	 * @return a list view of the specified array
	 */
	public static <T> List<T> arrayAsList(T... a) {
		return a == null ? null : new ArrayList<T>(a);
	}
}
