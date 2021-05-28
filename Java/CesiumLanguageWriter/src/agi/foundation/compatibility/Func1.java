package agi.foundation.compatibility;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

/**
 * Represents a method that has no parameters and returns a value of the type specified by
 * the {@code TResult} parameter.
 *
 * @param <TResult>
 *            The type of the return value of the method.
 */
public abstract class Func1<TResult> extends Delegate implements Supplier<TResult> {
    /**
     * Creates a new instance of this delegate.
     */
    public Func1() {
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
    public Func1(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
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
    public Func1(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetClass, methodName, methodParameterClasses);
    }

    /**
     * Represents a method that has no parameters and returns a value of the type
     * specified by the TResult parameter.
     *
     * @return The return value of the method.
     */
    public abstract TResult invoke();

    @Override
    public final TResult get() {
        return invoke();
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
    public static <TResult> Func1<TResult> of(@Nonnull Function<TResult> f) {
        return new FunctionImpl<>(f);
    }

    /**
     * Create a delegate for the given interface. This can be used to create a delegate
     * from a method reference to an instance method.
     *
     * @param f
     *            The function which will be invoked.
     * @param targetObject
     *            The class instance on which the delegate will invoke the method.
     * @param methodName
     *            The name of the instance method.
     * @param methodParameterClasses
     *            The type of the parameters of the instance method.
     * @return A new delegate that will invoke the given function.
     */
    @Nonnull
    public static <TResult> Func1<TResult> of(@Nonnull Function<TResult> f, @Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        return new FunctionImpl<>(f, targetObject, methodName, methodParameterClasses);
    }

    /**
     * Create a delegate for the given interface. This can be used to create a delegate
     * from a method reference to a static method.
     *
     * @param f
     *            The function which will be invoked.
     * @param targetClass
     *            The class that defines the method.
     * @param methodName
     *            The name of the static method.
     * @param methodParameterClasses
     *            The type of the parameters of the static method.
     * @return A new delegate that will invoke the given function.
     */
    @Nonnull
    public static <TResult> Func1<TResult> of(@Nonnull Function<TResult> f, @Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        return new FunctionImpl<>(f, targetClass, methodName, methodParameterClasses);
    }

    /**
     * A functional interface for the containing delegate type.
     */
    @FunctionalInterface
    public interface Function<TResult> {
        /**
         * Represents a method that has no parameters and returns a value of the type
         * specified by the TResult parameter.
         *
         * @return The return value of the method.
         */
        TResult invoke();
    }

    private static final class FunctionImpl<TResult> extends Func1<TResult> {
        @Nonnull
        private final Function<TResult> f;

        public FunctionImpl(@Nonnull Function<TResult> f) {
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<TResult> f, @Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetObject, methodName, methodParameterClasses);
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<TResult> f, @Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetClass, methodName, methodParameterClasses);
            this.f = f;
        }

        @Override
        public TResult invoke() {
            return f.invoke();
        }
    }
}