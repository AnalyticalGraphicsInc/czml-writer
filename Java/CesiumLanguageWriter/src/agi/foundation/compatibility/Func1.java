package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Encapsulates a method that has no parameters and returns a value of the type specified
 * by the TResult parameter.
 * 
 * @param <TResult>
 *            The type of the return value of the method that this delegate encapsulates.
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
	 * Encapsulates a method that has no parameters and returns a value of the type
	 * specified by the TResult parameter.
	 * 
	 * @return The return value of the method that this delegate encapsulates.
	 */
	public abstract TResult invoke();

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
	public static <TResult> Func1<TResult> combine(Func1<TResult> a, Func1<TResult> b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		return new MulticastFunc1<TResult>(a, b);
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
	public static <TResult> Func1<TResult> remove(Func1<TResult> source, Func1<TResult> value) {
		if (source == null) {
			return null;
		}
		if (value == null) {
			return source;
		}
		return source.removeImpl(value);
	}

	@Internal
	protected Func1<TResult> removeImpl(Func1<TResult> d) {
		if (this.equals(d)) {
			return null;
		}
		return this;
	}

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

	final static private class MulticastFunc1<TResult> extends Func1<TResult> implements MulticastDelegate<Func1<TResult>> {
		private MulticastList<Func1<TResult>> delegates;

		public MulticastFunc1(Func1<TResult> a, Func1<TResult> b) {
			delegates = new MulticastList<Func1<TResult>>(a, b);
		}

		public MulticastFunc1(MulticastList<Func1<TResult>> delegates) {
			this.delegates = delegates;
		}

		@Override
		public TResult invoke() {
			TResult result = null;
			for (Func1<TResult> delegate : delegates.list()) {
				result = delegate.invoke();
			}
			return result;
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
		public MulticastList<Func1<TResult>> list() {
			return delegates;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof MulticastFunc1)) {
				return false;
			}
			MulticastFunc1<?> that = (MulticastFunc1<?>) obj;
			return delegates.equals(that.delegates);
		}

		@Override
		public int hashCode() {
			return delegates.hashCode();
		}

		@Override
		protected Func1<TResult> removeImpl(Func1<TResult> d) {
			if (this.equals(d)) {
				return null;
			}
			return new MulticastFunc1<TResult>(delegates.removeLast(d));
		}
	}
}