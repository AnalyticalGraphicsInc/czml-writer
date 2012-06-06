package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.Internal;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.Delegate;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.*;

/**
 *  
 A callback to write a value to a  {@link CesiumOutputStream} using a given
 wrapped property writer.
 
 
 
 
 

 * @param <TWrappedWriter> The type of the wrapped writer.
 * @param <TValue> The type of the value to write.
 */
public abstract class CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> extends Delegate {
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
	 * @param methodParams The type of the parameters of the instance method.
	 */
	public CesiumWriterAdaptorWriteCallback(Object targetObject, String methodName, Class<?>[] methodParams) {
		super(targetObject, methodName, methodParams);
	}

	/**
	 * Initializes a delegate that will invoke a static method on a class.
	 * @param targetClass The class that defines the method.
	 * @param methodName The name of the static method.
	 * @param methodParams The type of the parameters of the static method.
	 */
	public CesiumWriterAdaptorWriteCallback(Class<?> targetClass, String methodName, Class<?>[] methodParams) {
		super(targetClass, methodName, methodParams);
	}

	/**
	 *  
	A callback to write a value to a  {@link CesiumOutputStream} using a given
	wrapped property writer.
	
	
	
	
	

	 * @param wrappedWriter The wrapper writer.
	 * @param value The value.
	 */
	public abstract void invoke(TWrappedWriter wrappedWriter, TValue value);

	/**
	 * Combines two delegate instances, forming a new delegate that will invoke both delegates when invoked.
	 * @param a The delegate which will be invoked first.
	 * @param b The delegate which will be invoked last.
	 * @return A new delegate that will invoke a, then b, in that order. Returns a if b is null, returns b if a is null, and returns null if both a and b are null.
	 */
	public static <TWrappedWriter, TValue> CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> combine(CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> a,
			CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		return new MulticastCesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>(a, b);
	}

	/**
	 * Removes one delegate from another, if it was previously combined.
	 * @param source The delegate from which to remove value.
	 * @param value The delegate to remove from source.
	 * @return A new delegate formed by removing value from source, if value is found within source. Returns source if value is null, null if source is the same as value, or if source is null.
	 */
	public static <TWrappedWriter, TValue> CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> remove(CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> source,
			CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> value) {
		if (source == null) {
			return null;
		}
		if (value == null) {
			return source;
		}
		return source.removeImpl(value);
	}

	@Internal
	protected CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> removeImpl(CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> d) {
		if (this.equals(d)) {
			return null;
		}
		return this;
	}

	final static private class MulticastCesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> extends CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> implements
			MulticastDelegate<CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>> {
		private MulticastList<CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>> delegates;

		public MulticastCesiumWriterAdaptorWriteCallback(CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> a, CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> b) {
			delegates = new MulticastList<CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>>(a, b);
		}

		public MulticastCesiumWriterAdaptorWriteCallback(MulticastList<CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>> delegates) {
			this.delegates = delegates;
		}

		@Override
		public void invoke(TWrappedWriter wrappedWriter, TValue value) {
			for (CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> delegate : delegates.list()) {
				delegate.invoke(wrappedWriter, value);
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
		public MulticastList<CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>> list() {
			return delegates;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MulticastCesiumWriterAdaptorWriteCallback)) {
				return false;
			}
			MulticastCesiumWriterAdaptorWriteCallback that = (MulticastCesiumWriterAdaptorWriteCallback) obj;
			return delegates.equals(that.delegates);
		}

		@Override
		public int hashCode() {
			return delegates.hashCode();
		}

		@Override
		protected CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> removeImpl(CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue> d) {
			if (this.equals(d)) {
				return null;
			}
			return new MulticastCesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>(delegates.removeLast(d));
		}
	}
}