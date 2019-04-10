package agi.foundation.compatibility;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a method that takes no parameters and does not return a value.
 */
public abstract class Action extends Delegate {
    /**
     * Creates a new instance of this delegate.
     */
    public Action() {
        super();
    }

    /**
     * Initializes a delegate that will invoke an instance method on a class instance.
     *
     * @param targetObject
     *            The class instance on which the delegate will invoke the method.
     * @param methodName
     *            The name of the instance method.
     * @param methodParameterClasses
     *            The type of the parameters of the instance method.
     */
    public Action(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetObject, methodName, methodParameterClasses);
    }

    /**
     * Initializes a delegate that will invoke a static method on a class.
     *
     * @param targetClass
     *            The class that defines the method.
     * @param methodName
     *            The name of the static method.
     * @param methodParameterClasses
     *            The type of the parameters of the static method.
     */
    public Action(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetClass, methodName, methodParameterClasses);
    }

    /**
     * Represents a method that takes no parameters and does not return a value.
     */
    public abstract void invoke();

    /**
     * Combines two delegate instances, forming a new delegate that will invoke both
     * delegates when invoked.
     *
     * @param a
     *            The delegate which will be invoked first.
     * @param b
     *            The delegate which will be invoked last.
     * @return A new delegate that will invoke a, then b, in that order. Returns a if b is
     *         null, returns b if a is null, and returns null if both a and b are null.
     */
    @Nullable
    public static Action combine(@Nullable Action a, @Nullable Action b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return new Multicast(a, b);
    }

    /**
     * Removes one delegate from another, if it was previously combined.
     *
     * @param source
     *            The delegate from which to remove value.
     * @param value
     *            The delegate to remove from source.
     * @return A new delegate formed by removing value from source, if value is found
     *         within source. Returns source if value is null, null if source is the same
     *         as value, or if source is null.
     */
    @Nullable
    public static Action remove(@Nullable Action source, @Nullable Action value) {
        if (source == null) {
            return null;
        }
        if (value == null) {
            return source;
        }
        return source.removeImpl(value);
    }

    Action removeImpl(Action d) {
        if (equals(d)) {
            return null;
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        return super.equals(obj);
    }

    /**
     * Create a delegate for the given interface. This can be used to create a delegate
     * from a lambda expression.
     *
     * @param f
     *            The function which will be invoked.
     * @return A new delegate that will invoke the given function.
     */
    @Nonnull
    public static Action of(@Nonnull Function f) {
        return new FunctionImpl(f);
    }

    private static final class Multicast extends Action implements MulticastDelegate<Action> {
        @Nonnull
        private final MulticastList<Action> delegates;

        public Multicast(@Nonnull Action a, @Nonnull Action b) {
            delegates = new MulticastList<>(a, b);
        }

        public Multicast(@Nonnull MulticastList<Action> delegates) {
            this.delegates = delegates;
        }

        @Override
        public void invoke() {
            for (final Action delegate : delegates.list()) {
                delegate.invoke();
            }
        }

        @Override
        public java.lang.reflect.Method getMethod() {
            return delegates.last().getMethod();
        }

        @Override
        public Object getTarget() {
            return delegates.last().getTarget();
        }

        @Override
        @Nonnull
        public MulticastList<Action> list() {
            return delegates;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Multicast)) {
                return false;
            }
            final Multicast that = (Multicast) obj;
            return delegates.equals(that.delegates);
        }

        @Override
        public int hashCode() {
            return delegates.hashCode();
        }

        @Override
        Action removeImpl(Action d) {
            if (equals(d)) {
                return null;
            }
            return new Multicast(delegates.removeLast(d));
        }
    }

    /**
     * A functional interface for the containing delegate type.
     */
    @FunctionalInterface
    public interface Function {
        /**
         * Represents a method that takes no parameters and does not return a value.
         */
        void invoke();
    }

    private static final class FunctionImpl extends Action {
        @Nonnull
        private final Function f;

        public FunctionImpl(@Nonnull Function f) {
            this.f = f;
        }

        @Override
        public void invoke() {
            f.invoke();
        }
    }
}