package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper methods for arrays.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class ArrayHelper {
    /**
     * This class differs from the one used by Arrays.asList in that it preserves value
     * type semantics when creating arrays by making deep clones.
     */
    private static class ArrayList<E> extends AbstractList<E> implements RandomAccess {
        @Nonnull
        private final E[] a;

        public ArrayList(@Nonnull E[] array) {
            a = Objects.requireNonNull(array);
        }

        @Override
        public int size() {
            return a.length;
        }

        @Override
        public Object[] toArray() {
            return toArray(new Object[a.length]);
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = this.a.length;
            if (a.length < size) {
                a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
            }

            copy(this.a, 0, a, 0, size);

            if (a.length > size) {
                a[size] = null;
            }

            return a;
        }

        @Override
        public E get(int index) {
            return a[index];
        }

        @Override
        public E set(int index, E element) {
            E oldValue = a[index];
            a[index] = element;
            return oldValue;
        }

        @Override
        public int indexOf(Object o) {
            E[] a = this.a;
            for (int i = 0; i < a.length; ++i) {
                if (Objects.equals(o, a[i])) {
                    return i;
                }
            }

            return -1;
        }

        @Override
        public boolean contains(Object o) {
            return indexOf(o) != -1;
        }

        @Override
        public Spliterator<E> spliterator() {
            return Spliterators.spliterator(a, Spliterator.ORDERED);
        }

        @Override
        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            for (E e : a) {
                action.accept(e);
            }
        }

        @Override
        public void replaceAll(UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
            E[] a = this.a;
            for (int i = 0; i < a.length; ++i) {
                a[i] = operator.apply(a[i]);
            }
        }

        @Override
        public void sort(Comparator<? super E> c) {
            Arrays.sort(a, c);
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
    @SafeVarargs
    @Nullable
    public static <T> List<T> arrayAsList(@Nullable T... a) {
        return a == null ? null : new ArrayList<>(a);
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
        if (isMutableValueType(sourceArray.getClass().getComponentType())) {
            // if it's a non-immutable value type, we can't rely on System.arrayCopy, and
            // must do a deep copy to preserve value type semantics.
            for (int endSourceIndex = sourceIndex + length; sourceIndex < endSourceIndex; ++sourceIndex, ++destinationIndex) {
                ICloneable sourceItem = (ICloneable) Array.get(sourceArray, sourceIndex);
                Array.set(destinationArray, destinationIndex, sourceItem.clone());
            }
        } else {
            System.arraycopy(sourceArray, sourceIndex, destinationArray, destinationIndex, length);
        }
    }

    private static boolean isMutableValueType(Class<?> type) {
        return ValueType.class.isAssignableFrom(type) && !ImmutableValueType.class.isAssignableFrom(type);
    }
}
