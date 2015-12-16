package agi.foundation.compatibility;

/**
 * Defines a generalized method that a value type or class implements to create
 * a type-specific method for determining equality of instances.
 * 
 * @param <T>
 *            The type of objects to compare.
 */
public interface IEquatable<T> {
	/**
	 * Indicates whether the current object is equal to another object of the
	 * same type.
	 * 
	 * @param other
	 *            An object to compare with this object.
	 * @return true if the current object is equal to the other parameter;
	 *         otherwise, false.
	 */
	boolean equalsType(T other);
}
