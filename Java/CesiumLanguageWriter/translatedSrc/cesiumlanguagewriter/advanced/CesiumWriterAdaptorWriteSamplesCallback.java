package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.Internal;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.Delegate;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.*;
import java.util.List;

/**
 *  
 A callback to write a value to a  {@link CesiumOutputStream} using a given
 wrapped property writer.
 
 
 
 
 
 
 
 

 * @param <TWrappedWriter> The type of the wrapped writer.
 * @param <TValue> The type of the value to write.
 */
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
	 * @param methodParams The type of the parameters of the instance method.
	 */
	public CesiumWriterAdaptorWriteSamplesCallback(Object targetObject, String methodName, Class<?>[] methodParams) {
		super(targetObject, methodName, methodParams);
	}

	/**
	 * Initializes a delegate that will invoke a static method on a class.
	 * @param targetClass The class that defines the method.
	 * @param methodName The name of the static method.
	 * @param methodParams The type of the parameters of the static method.
	 */
	public CesiumWriterAdaptorWriteSamplesCallback(Class<?> targetClass, String methodName, Class<?>[] methodParams) {
		super(targetClass, methodName, methodParams);
	}

	/**
	 *  
	A callback to write a value to a  {@link CesiumOutputStream} using a given
	wrapped property writer.
	
	
	
	
	
	
	
	

	 * @param wrappedWriter The wrapper writer.
	 * @param dates The dates at which samples are provided.
	 * @param values The sampled value corresponding to each date.
	 * @param startIndex The index of the first sample to write.
	 * @param length The number of samples to write.
	 */
	public abstract void invoke(TWrappedWriter wrappedWriter, List<JulianDate> dates, List<TValue> values, int startIndex, int length);

	/**
	 * Combines two delegate instances, forming a new delegate that will invoke both delegates when invoked.
	 * @param a The delegate which will be invoked first.
	 * @param b The delegate which will be invoked last.
	 * @return A new delegate that will invoke a, then b, in that order. Returns a if b is null, returns b if a is null, and returns null if both a and b are null.
	 */
	public static <TWrappedWriter, TValue> CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> combine(CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> a,
			CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		return new MulticastCesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>(a, b);
	}

	/**
	 * Removes one delegate from another, if it was previously combined.
	 * @param source The delegate from which to remove value.
	 * @param value The delegate to remove from source.
	 * @return A new delegate formed by removing value from source, if value is found within source. Returns source if value is null, null if source is the same as value, or if source is null.
	 */
	public static <TWrappedWriter, TValue> CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> remove(CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> source,
			CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> value) {
		if (source == null) {
			return null;
		}
		if (value == null) {
			return source;
		}
		return source.removeImpl(value);
	}

	@Internal
	protected CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> removeImpl(CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> d) {
		if (this.equals(d)) {
			return null;
		}
		return this;
	}

	final static private class MulticastCesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> extends CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> implements
			MulticastDelegate<CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>> {
		private MulticastList<CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>> delegates;

		public MulticastCesiumWriterAdaptorWriteSamplesCallback(CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> a, CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> b) {
			delegates = new MulticastList<CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>>(a, b);
		}

		public MulticastCesiumWriterAdaptorWriteSamplesCallback(MulticastList<CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>> delegates) {
			this.delegates = delegates;
		}

		@Override
		public void invoke(TWrappedWriter wrappedWriter, List<JulianDate> dates, List<TValue> values, int startIndex, int length) {
			for (CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> delegate : delegates.list()) {
				delegate.invoke(wrappedWriter, dates, values, startIndex, length);
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
		public MulticastList<CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>> list() {
			return delegates;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MulticastCesiumWriterAdaptorWriteSamplesCallback)) {
				return false;
			}
			MulticastCesiumWriterAdaptorWriteSamplesCallback that = (MulticastCesiumWriterAdaptorWriteSamplesCallback) obj;
			return delegates.equals(that.delegates);
		}

		@Override
		public int hashCode() {
			return delegates.hashCode();
		}

		@Override
		protected CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> removeImpl(CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue> d) {
			if (this.equals(d)) {
				return null;
			}
			return new MulticastCesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>(delegates.removeLast(d));
		}
	}
}