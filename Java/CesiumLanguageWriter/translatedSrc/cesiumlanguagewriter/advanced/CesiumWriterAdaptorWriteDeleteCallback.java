package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Delegate;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A callback to write an indication that the client should delete existing samples for a given wrapped property writer.
 * @param <TWrappedWriter> The type of the wrapped writer.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public abstract class CesiumWriterAdaptorWriteDeleteCallback<TWrappedWriter extends ICesiumPropertyWriter> extends Delegate {
    /**
    * Creates a new instance of this delegate.
    */
    public CesiumWriterAdaptorWriteDeleteCallback() {
        super();
    }

    /**
    * Initializes a delegate that will invoke an instance method on a class instance.
    * @param targetObject The class instance on which the delegate will invoke the method.
    * @param methodName The name of the instance method.
    * @param methodParameterClasses The type of the parameters of the instance method.
    */
    public CesiumWriterAdaptorWriteDeleteCallback(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetObject, methodName, methodParameterClasses);
    }

    /**
    * Initializes a delegate that will invoke a static method on a class.
    * @param targetClass The class that defines the method.
    * @param methodName The name of the static method.
    * @param methodParameterClasses The type of the parameters of the static method.
    */
    public CesiumWriterAdaptorWriteDeleteCallback(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        super(targetClass, methodName, methodParameterClasses);
    }

    /**
    * A callback to write an indication that the client should delete existing samples for a given wrapped property writer.
    * @param wrappedWriter The wrapper writer.
    */
    public abstract void invoke(@Nonnull TWrappedWriter wrappedWriter);

    /**
    * Create a delegate for the given interface. This can be used to create a delegate from a lambda expression.
    * @param f The function which will be invoked.
    * @return A new delegate that will invoke the given function.
    */
    @Nonnull
    public static <TWrappedWriter extends ICesiumPropertyWriter> CesiumWriterAdaptorWriteDeleteCallback<TWrappedWriter> of(@Nonnull Function<TWrappedWriter> f) {
        return new FunctionImpl<TWrappedWriter>(f);
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
    public static <TWrappedWriter extends ICesiumPropertyWriter> CesiumWriterAdaptorWriteDeleteCallback<TWrappedWriter> of(@Nonnull Function<TWrappedWriter> f, @Nonnull Object targetObject,
            @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        return new FunctionImpl<TWrappedWriter>(f, targetObject, methodName, methodParameterClasses);
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
    public static <TWrappedWriter extends ICesiumPropertyWriter> CesiumWriterAdaptorWriteDeleteCallback<TWrappedWriter> of(@Nonnull Function<TWrappedWriter> f, @Nonnull Class<?> targetClass,
            @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
        return new FunctionImpl<TWrappedWriter>(f, targetClass, methodName, methodParameterClasses);
    }

    /**
    * A functional interface for the containing delegate type.
    * @param <TWrappedWriter> The type of the wrapped writer.
    */
    @FunctionalInterface
    public interface Function<TWrappedWriter extends ICesiumPropertyWriter> {
        /**
        * A callback to write an indication that the client should delete existing samples for a given wrapped property writer.
        * @param wrappedWriter The wrapper writer.
        */
        void invoke(@Nonnull TWrappedWriter wrappedWriter);
    }

    private static final class FunctionImpl<TWrappedWriter extends ICesiumPropertyWriter> extends CesiumWriterAdaptorWriteDeleteCallback<TWrappedWriter> {
        @Nonnull
        private final Function<TWrappedWriter> f;

        public FunctionImpl(@Nonnull Function<TWrappedWriter> f) {
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<TWrappedWriter> f, @Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetObject, methodName, methodParameterClasses);
            this.f = f;
        }

        public FunctionImpl(@Nonnull Function<TWrappedWriter> f, @Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>... methodParameterClasses) {
            super(targetClass, methodName, methodParameterClasses);
            this.f = f;
        }

        @Override
        public void invoke(@Nonnull TWrappedWriter wrappedWriter) {
            f.invoke(wrappedWriter);
        }
    }
}