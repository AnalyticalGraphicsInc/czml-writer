package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Delegate;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A callback to write a value to a {@link CesiumOutputStream} using a given
 wrapped property writer.
 * @param <TWrappedWriter> The type of the wrapped writer.
 * @param <TValue> The type of the value to write.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public abstract class CesiumWriterAdaptorWriteCallback<TWrappedWriter extends ICesiumPropertyWriter, TValue> extends Delegate {
    /**
    * Creates a new instance of this delegate.
    */
    public CesiumWriterAdaptorWriteCallback() {
        super();
    }

    /**
    * Initializes a delegate that will invoke an instance method on a class instance.
    * @param targetObject The class instance on which the delegate will invoke the method.
    * @param methodName The name of the instance method.
    * @param methodParameterClasses The type of the parameters of the instance method.
    */
    public CesiumWriterAdaptorWriteCallback(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetObject, methodName, methodParameterClasses);
    }

    /**
    * Initializes a delegate that will invoke a static method on a class.
    * @param targetClass The class that defines the method.
    * @param methodName The name of the static method.
    * @param methodParameterClasses The type of the parameters of the static method.
    */
    public CesiumWriterAdaptorWriteCallback(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetClass, methodName, methodParameterClasses);
    }

    /**
    * A callback to write a value to a {@link CesiumOutputStream} using a given
    wrapped property writer.
    * @param wrappedWriter The wrapper writer.
    * @param value The value.
    */
    public abstract void invoke(@Nonnull TWrappedWriter wrappedWriter, TValue value);

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CesiumWriterAdaptorWriteCallback)) {
            return false;
        }
        return super.equals(obj);
    }

    /**
    * Create a delegate for the given interface. This can be used to create a delegate from a lambda expression.
    * @param f The function which will be invoked.
    * @return A new delegate that will invoke the given function.
    */
    @Nonnull
    public static <TWrappedWriter extends ICesiumPropertyWriter, TValue> CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> of(@Nonnull Function<TWrappedWriter, TValue> f) {
        return new FunctionImpl<TWrappedWriter, TValue>(f);
    }

    /**
    * Create a delegate for the given interface. This can be used to create a delegate from a method reference to an instance method.
    * @param f The function which will be invoked.
    * @param targetObject The class instance on which the delegate will invoke the method.
    * @param methodName The name of the instance method.
    * @param methodParameterClasses The type of the parameters of the instance method.
    * @return A new delegate that will invoke the given function.
    */
    @Nonnull
    public static <TWrappedWriter extends ICesiumPropertyWriter, TValue> CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> of(@Nonnull Function<TWrappedWriter, TValue> f,
            @Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        return new FunctionImpl<TWrappedWriter, TValue>(f, targetObject, methodName, methodParameterClasses);
    }

    /**
    * Create a delegate for the given interface. This can be used to create a delegate from a method reference to a static method.
    * @param f The function which will be invoked.
    * @param targetClass The class that defines the method.
    * @param methodName The name of the static method.
    * @param methodParameterClasses The type of the parameters of the static method.
    * @return A new delegate that will invoke the given function.
    */
    @Nonnull
    public static <TWrappedWriter extends ICesiumPropertyWriter, TValue> CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> of(@Nonnull Function<TWrappedWriter, TValue> f,
            @Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        return new FunctionImpl<TWrappedWriter, TValue>(f, targetClass, methodName, methodParameterClasses);
    }

    /**
    * A functional interface for the containing delegate type.
    * @param <TWrappedWriter> The type of the wrapped writer.
    * @param <TValue> The type of the value to write.
    */
    @FunctionalInterface
    public interface Function<TWrappedWriter extends ICesiumPropertyWriter, TValue> {
        /**
        * A callback to write a value to a {@link CesiumOutputStream} using a given
        wrapped property writer.
        * @param wrappedWriter The wrapper writer.
        * @param value The value.
        */
        void invoke(@Nonnull TWrappedWriter wrappedWriter, TValue value);
    }

    private static final class FunctionImpl<TWrappedWriter extends ICesiumPropertyWriter, TValue> extends CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> {
        @Nonnull
        private final Function<TWrappedWriter, TValue> f;

        public FunctionImpl(@Nonnull Function<TWrappedWriter, TValue> f) {
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<TWrappedWriter, TValue> f, @Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetObject, methodName, methodParameterClasses);
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<TWrappedWriter, TValue> f, @Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetClass, methodName, methodParameterClasses);
            this.f = f;
        }

        @Override
        public void invoke(@Nonnull TWrappedWriter wrappedWriter, TValue value) {
            f.invoke(wrappedWriter, value);
        }
    }
}