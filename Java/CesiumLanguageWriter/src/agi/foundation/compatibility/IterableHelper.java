package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper class for Iterable methods.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class IterableHelper {
    private IterableHelper() {}

    /**
     * Creates a list from a sequence.
     *
     * @param <TSource>
     *            The type of the elements of source.
     * @param source
     *            The sequence to create a list from.
     * @return A list that contains elements from the input sequence.
     */
    @Nonnull
    public static <TSource> ArrayList<TSource> toList(@Nonnull Iterable<? extends TSource> source) {
        assertNonNull(source, "source");

        if (source instanceof Collection<?>) {
            Collection<? extends TSource> collection = (Collection<? extends TSource>) source;
            return new ArrayList<>(collection);
        }

        ArrayList<TSource> list = new ArrayList<>();
        for (TSource item : source) {
            list.add(item);
        }
        return list;
    }

    private static <TSource> TSource throwNoElements() {
        throw new IllegalStateException("Sequence contains no elements");
    }

    private static <TSource> TSource throwNoMatch() {
        throw new IllegalStateException("Sequence contains no matching element");
    }

    private static <TSource> TSource returnNull() {
        return null;
    }

    /**
     * Returns the first element of a sequence.
     *
     * @param <TSource>
     *            The type of the elements of source.
     * @param source
     *            The sequence to return the first element of.
     * @return The first element in the specified sequence.
     */
    public static <TSource> TSource first(@Nonnull Iterable<? extends TSource> source) {
        return firstOrDefault(source, IterableHelper::throwNoElements);
    }

    private static <TSource> TSource firstOrDefault(@Nonnull Iterable<? extends TSource> source, @Nonnull Supplier<? extends TSource> defaultSupplier) {
        assertNonNull(source, "source");

        if (source instanceof List<?>) {
            List<? extends TSource> list = (List<? extends TSource>) source;
            if (list.size() > 0) {
                return list.get(0);
            }
        } else {
            for (TSource item : source) {
                return item;
            }
        }

        return defaultSupplier.get();
    }

    /**
     * Returns the last element of a sequence.
     *
     * @param <TSource>
     *            The type of the elements of source.
     * @param source
     *            The sequence to return the last element of.
     * @return The last element in the specified sequence.
     */
    public static <TSource> TSource last(@Nonnull Iterable<? extends TSource> source) {
        return lastOrDefault(source, IterableHelper::throwNoElements);
    }

    private static <TSource> TSource lastOrDefault(@Nonnull Iterable<? extends TSource> source, @Nonnull Supplier<? extends TSource> defaultSupplier) {
        assertNonNull(source, "source");

        if (source instanceof List<?>) {
            List<? extends TSource> list = (List<? extends TSource>) source;
            int size = list.size();
            if (size > 0) {
                return list.get(size - 1);
            }
        } else {
            TSource result = null;
            boolean found = false;
            for (TSource item : source) {
                result = item;
                found = true;
            }

            if (found) {
                return result;
            }
        }

        return defaultSupplier.get();
    }

    public static <T> Iterable<T> concat(@Nonnull Iterable<? extends Iterable<? extends T>> iterables) {
        return new ConcatIterable<>(iterables);
    }

    /**
     * Projects each element of a sequence into a new form.
     *
     * @param <TSource>
     *            The type of the elements of source.
     * @param <TResult>
     *            The type of the value returned by selector.
     * @param source
     *            A sequence of values to invoke a transform function on.
     * @param selector
     *            A transform function to apply to each element.
     * @return A sequence whose elements are the result of invoking the transform function
     *         on each element of source.
     */
    @Nonnull
    public static <TSource, TResult> Iterable<TResult> select(@Nonnull Iterable<? extends TSource> source, @Nonnull Function<? super TSource, ? extends TResult> selector) {
        assertNonNull(source, "source");
        assertNonNull(selector, "selector");

        return new SelectIterable<>(source, selector);
    }

    /**
     * Projects each element of a sequence to a new sequence and flattens the resulting
     * sequences into one sequence.
     *
     * @param <TSource>
     *            The type of the elements of source.
     * @param <TResult>
     *            The type of the elements of the sequence returned by selector.
     * @param source
     *            A sequence of values to invoke a transform function on.
     * @param selector
     *            A transform function to apply to each element.
     * @return A sequence whose elements are the result of invoking the transform function
     *         on each element of source and flattening the sequences.
     */
    @SuppressWarnings("null")
    @Nonnull
    public static <TSource, TResult> Iterable<TResult> selectMany(@Nonnull Iterable<? extends TSource> source,
                                                                  @Nonnull Function<? super TSource, ? extends Iterable<? extends TResult>> selector) {
        assertNonNull(source, "source");
        assertNonNull(selector, "selector");

        return concat(select(source, selector));
    }

    private interface ResultYielder<T> {
        void yield(T item);

        void end();
    }

    private static abstract class BaseIterator<T> implements Iterator<T>, ResultYielder<T> {
        private T next;
        @Nonnull
        private State state = State.NEED_NEXT;

        private enum State {
            HAVE_NEXT,
            NEED_NEXT,
            END,
        }

        @Override
        public boolean hasNext() {
            switch (state) {
            case END:
                return false;
            case HAVE_NEXT:
                return true;
            case NEED_NEXT:
                yieldNext(this);
                return state != State.END;
            default:
                throw new UnsupportedOperationException();
            }
        }

        protected abstract void yieldNext(@Nonnull ResultYielder<T> yielder);

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            state = State.NEED_NEXT;
            return next;
        }

        @Override
        public void yield(T item) {
            state = State.HAVE_NEXT;
            next = item;
        }

        @Override
        public void end() {
            state = State.END;
            next = null;
        }
    }

    private static final class GetIteratorFromIterable<T> implements Function<Iterable<? extends T>, Iterator<? extends T>> {
        @Override
        public Iterator<? extends T> apply(Iterable<? extends T> arg) {
            return arg.iterator();
        }
    }

    private static final class ConcatIterable<T> implements Iterable<T> {
        @Nonnull
        private final Iterable<? extends Iterable<? extends T>> iterables;

        public ConcatIterable(@Nonnull Iterable<? extends Iterable<? extends T>> iterables) {
            this.iterables = iterables;
        }

        public ConcatIterable(@Nonnull Iterable<? extends T> first, @Nonnull Iterable<? extends T> second) {
            this.iterables = Arrays.asList(first, second);
        }

        @Override
        public Iterator<T> iterator() {
            return new ConcatIterator<>(select(iterables, new GetIteratorFromIterable<T>()).iterator());
        }

        private static final class ConcatIterator<T> extends BaseIterator<T> {
            @Nonnull
            private final Iterator<Iterator<? extends T>> iterators;
            private Iterator<? extends T> current;

            public ConcatIterator(@Nonnull Iterator<Iterator<? extends T>> iterators) {
                this.iterators = iterators;
            }

            @Override
            protected void yieldNext(ResultYielder<T> yielder) {
                if (current != null && current.hasNext()) {
                    yielder.yield(current.next());
                    return;
                }

                if (iterators.hasNext()) {
                    current = iterators.next();
                    yieldNext(yielder);
                    return;
                }

                yielder.end();
            }
        }
    }

    private static final class SelectIterable<TSource, TResult> implements Iterable<TResult> {
        @Nonnull
        private final Iterable<? extends TSource> source;
        @Nonnull
        private final Function<? super TSource, ? extends TResult> selector;

        public SelectIterable(@Nonnull Iterable<? extends TSource> source, @Nonnull Function<? super TSource, ? extends TResult> selector) {
            this.source = source;
            this.selector = selector;
        }

        @Override
        public Iterator<TResult> iterator() {
            return new SelectIterator<>(source.iterator(), selector);
        }

        private static final class SelectIterator<TSource, TResult> extends BaseIterator<TResult> {
            @Nonnull
            private final Iterator<? extends TSource> iterator;
            @Nonnull
            private final Function<? super TSource, ? extends TResult> selector;

            public SelectIterator(@Nonnull Iterator<? extends TSource> iterator, @Nonnull Function<? super TSource, ? extends TResult> selector) {
                this.iterator = iterator;
                this.selector = selector;
            }

            @Override
            protected void yieldNext(ResultYielder<TResult> yielder) {
                if (iterator.hasNext()) {
                    yielder.yield(selector.apply(iterator.next()));
                    return;
                }

                yielder.end();
            }
        }
    }
}
