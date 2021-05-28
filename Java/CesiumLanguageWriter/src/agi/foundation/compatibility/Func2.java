package agi.foundation.compatibility;

import javax.annotation.Nonnull;

/**
 * Represents a method that has one parameter and returns a value of the type specified by
 * the {@code TResult} parameter.
 *
 * @param <T>
 *            The type of the parameter.
 * @param <TResult>
 *            The type of the return value of the method.
 */
public abstract class Func2<T, TResult> extends Delegate implements java.util.function.Function<T, TResult> {
    /**
     * Creates a new instance of this delegate.
     */
    public Func2() {
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
    public Func2(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
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
    public Func2(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetClass, methodName, methodParameterClasses);
    }

    /**
     * Represents a method that has has one parameter and returns a value of the type
     * specified by the {@code TResult} parameter.
     *
     * @param arg
     *            The parameter of the method.
     * @return The return value of the method.
     */
    public abstract TResult invoke(T arg);

    @Override
    public final TResult apply(T t) {
        return invoke(t);
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
    public static <T, TResult> Func2<T, TResult> of(@Nonnull Function<T, TResult> f) {
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
    public static <T, TResult> Func2<T, TResult> of(@Nonnull Function<T, TResult> f, @Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
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
    public static <T, TResult> Func2<T, TResult> of(@Nonnull Function<T, TResult> f, @Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        return new FunctionImpl<>(f, targetClass, methodName, methodParameterClasses);
    }

    /**
     * A functional interface for the containing delegate type.
     */
    @FunctionalInterface
    public interface Function<T, TResult> {
        /**
         * Represents a method that has has one parameter and returns a value of the type
         * specified by the {@code TResult} parameter.
         *
         * @param arg
         *            The parameter of the method.
         * @return The return value of the method.
         */
        TResult invoke(T arg);
    }

    private static final class FunctionImpl<T, TResult> extends Func2<T, TResult> {
        @Nonnull
        private final Function<T, TResult> f;

        public FunctionImpl(@Nonnull Function<T, TResult> f) {
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<T, TResult> f, @Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetObject, methodName, methodParameterClasses);
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<T, TResult> f, @Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetClass, methodName, methodParameterClasses);
            this.f = f;
        }

        @Override
        public TResult invoke(T arg) {
            return f.invoke(arg);
        }
    }
}