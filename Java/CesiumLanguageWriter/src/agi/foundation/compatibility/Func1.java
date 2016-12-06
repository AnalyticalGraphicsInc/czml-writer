package agi.foundation.compatibility;

/**
 * Represents a method that has no parameters and returns a value of the type specified by
 * the TResult parameter.
 *
 * @param <TResult>
 *            The type of the return value of the method.
 */
public abstract class Func1<TResult> extends Delegate {
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
     * @param methodParams
     *            The type of the parameters of the instance method.
     */
    public Func1(Object targetObject, String methodName, Class<?>[] methodParams) {
        super(targetObject, methodName, methodParams);
    }

    /**
     * Initializes a delegate that will invoke a static method on a class.
     *
     * @param targetClass
     *            The class that defines the method.
     * @param methodName
     *            The name of the static method.
     * @param methodParams
     *            The type of the parameters of the static method.
     */
    public Func1(Class<?> targetClass, String methodName, Class<?>[] methodParams) {
        super(targetClass, methodName, methodParams);
    }

    /**
     * Represents a method that has no parameters and returns a value of the type
     * specified by the TResult parameter.
     *
     * @return The return value of the method.
     */
    public abstract TResult invoke();

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Func1<?>)) {
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
    public static <TResult> Func1<TResult> of(Function<TResult> f) {
        return new FunctionImpl<TResult>(f);
    }

    /**
     * A functional interface for the containing delegate type.
     */
    public interface Function<TResult> {
        /**
         * Represents a method that has no parameters and returns a value of the type
         * specified by the TResult parameter.
         *
         * @return The return value of the method.
         */
        public abstract TResult invoke();
    }

    private static final class FunctionImpl<TResult> extends Func1<TResult> {
        private final Function<TResult> f;

        public FunctionImpl(Function<TResult> f) {
            this.f = f;
        }

        @Override
        public TResult invoke() {
            return f.invoke();
        }
    }
}