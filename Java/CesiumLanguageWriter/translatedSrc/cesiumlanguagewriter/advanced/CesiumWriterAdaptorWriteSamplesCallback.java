package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Delegate;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 A callback to write a value to a {@link CesiumOutputStream} using a given
 wrapped property writer.
 
 
 
 
 
 
 
 

 * @param <TWrappedWriter> The type of the wrapped writer.
 * @param <TValue> The type of the value to write.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public abstract class CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> extends Delegate {
    /**
    * Creates a new instance of this delegate.
    */
    public CesiumWriterAdaptorWriteSamplesCallback() {
        super();
    }

    /**
    * Initializes a delegate that will invoke an instance method on a class instance.
    * @param targetObject The class instance on which the delegate will invoke the method.
    * @param methodName The name of the instance method.
    * @param methodParameterClasses The type of the parameters of the instance method.
    */
    public CesiumWriterAdaptorWriteSamplesCallback(@javax.annotation.Nonnull Object targetObject, @javax.annotation.Nonnull String methodName,
            @javax.annotation.Nonnull Class<?>... methodParameterClasses) {
        super(targetObject, methodName, methodParameterClasses);
    }

    /**
    * Initializes a delegate that will invoke a static method on a class.
    * @param targetClass The class that defines the method.
    * @param methodName The name of the static method.
    * @param methodParameterClasses The type of the parameters of the static method.
    */
    public CesiumWriterAdaptorWriteSamplesCallback(@javax.annotation.Nonnull Class<?> targetClass, @javax.annotation.Nonnull String methodName,
            @javax.annotation.Nonnull Class<?>... methodParameterClasses) {
        super(targetClass, methodName, methodParameterClasses);
    }

    /**
    *  
    A callback to write a value to a {@link CesiumOutputStream} using a given
    wrapped property writer.
    
    
    
    
    
    
    
    

    * @param wrappedWriter The wrapper writer.
    * @param dates The dates at which samples are provided.
    * @param values The sampled value corresponding to each date.
    * @param startIndex The index of the first sample to write.
    * @param length The number of samples to write.
    */
    public abstract void invoke(TWrappedWriter wrappedWriter, List<JulianDate> dates, List<TValue> values, int startIndex, int length);

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CesiumWriterAdaptorWriteSamplesCallback)) {
            return false;
        }
        return super.equals(obj);
    }

    /**
    * Create a delegate for the given interface.  This can be used to create a delegate from a lambda expression.
    * @param f The function which will be invoked.
    * @return A new delegate that will invoke the given function.
    */
    @Nonnull
    public static <TWrappedWriter, TValue> CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> of(@javax.annotation.Nonnull Function<TWrappedWriter, TValue> f) {
        return new FunctionImpl<TWrappedWriter, TValue>(f);
    }

    /**
    * A functional interface for the containing delegate type.
    * @param <TWrappedWriter> The type of the wrapped writer.
    * @param <TValue> The type of the value to write.
    */
    @FunctionalInterface
    public interface Function<TWrappedWriter, TValue> {
        /**
        *  
        A callback to write a value to a {@link CesiumOutputStream} using a given
        wrapped property writer.
        
        
        
        
        
        
        
        

        * @param wrappedWriter The wrapper writer.
        * @param dates The dates at which samples are provided.
        * @param values The sampled value corresponding to each date.
        * @param startIndex The index of the first sample to write.
        * @param length The number of samples to write.
        */
        public abstract void invoke(TWrappedWriter wrappedWriter, List<JulianDate> dates, List<TValue> values, int startIndex, int length);
    }

    private static final class FunctionImpl<TWrappedWriter, TValue> extends CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> {
        @javax.annotation.Nonnull
        private final Function<TWrappedWriter, TValue> f;

        public FunctionImpl(@javax.annotation.Nonnull Function<TWrappedWriter, TValue> f) {
            this.f = f;
        }

        @Override
        public void invoke(TWrappedWriter wrappedWriter, List<JulianDate> dates, List<TValue> values, int startIndex, int length) {
            f.invoke(wrappedWriter, dates, values, startIndex, length);
        }
    }
}