package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.IntHelper;

/**
 *  
 Describes motion, including a coordinate and optionally one or more derivatives.
 
 
 

 * @param <T> The coordinate type used to describe the motion.
 * @param <TDerivative> The derivative type used to describe the motion.
 */
public class Motion2<T, TDerivative> implements IEquatable<Motion2<T, TDerivative>>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Motion2() {}

	/**
	 *  
	Initializes a new instance.
	
	
	
	

	 * 
	The first array element describes the first derivative, the second describes
	the second derivative, and so on.
	
	 * @param value The value of the coordinate.
	 * @param derivatives The derivatives describing the motion.
	 */
	public Motion2(T value, TDerivative... derivatives) {
		m_value = value;
		m_derivatives = derivatives;
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	
	

	 * 
	For two Motion instances to be considered equal, the value and derivatives of each
	must compare as equal.
	
	 * @param other The object to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(Motion2<T, TDerivative> other) {
		if (m_value == null) {
			return other.m_value == null;
		}
		if (!m_value.equals(other.m_value)) {
			return false;
		}
		if (m_derivatives == null && other.m_derivatives == null) {
			return true;
		}
		if (m_derivatives == null || other.m_derivatives == null || m_derivatives.length != other.m_derivatives.length) {
			return false;
		}
		for (int i = 0; i < m_derivatives.length; ++i) {
			if (!m_derivatives[i].equals(other.m_derivatives[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	
	

	 * 
	For two Motion instances to be considered equal, the value and derivatives of each
	must compare as equal.
	
	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Motion2) {
			Motion2<T, TDerivative> motion = (Motion2<T, TDerivative>) obj;
			return equalsType(motion);
		} else {
			return false;
		}
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		int hashValue = m_value.hashCode();
		if (m_derivatives != null) {
			for (int i = 0; i < m_derivatives.length; ++i) {
				hashValue ^= m_derivatives[i].hashCode();
			}
		}
		return hashValue;
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are exactly equal.
	
	
	
	
	

	 * 
	For two Motion instances to be considered equal, the value and derivatives of each
	must compare as equal.
	
	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> represents the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Motion,Motion)'")
	public static <T, TDerivative> boolean equals(Motion2<T, TDerivative> left, Motion2<T, TDerivative> right) {
		return left.equalsType(right);
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are not exactly equal.
	
	
	
	
	

	 * 
	For two Motion instances to be considered equal, the value and derivatives of each
	must compare as equal.
	
	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> does not represent the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Motion,Motion)'")
	public static <T, TDerivative> boolean notEquals(Motion2<T, TDerivative> left, Motion2<T, TDerivative> right) {
		return !left.equalsType(right);
	}

	private T m_value;
	private TDerivative[] m_derivatives;

	/**
	 *  Gets the coordinate value.
	

	 */
	public final T getValue() {
		return m_value;
	}

	/**
	 *  Gets the first derivative, if it is available.
	
	

	 * @exception ArgumentOutOfRangeException 
	This motion instance does not contain a first derivative.
	
	 */
	public final TDerivative getFirstDerivative() {
		return get(1);
	}

	/**
	 *  Gets the second derivative, if it is available.
	
	

	 * @exception ArgumentOutOfRangeException 
	This motion instance does not contain a second derivative.
	
	 */
	public final TDerivative getSecondDerivative() {
		return get(2);
	}

	/**
	 *  Gets the indicated derivative of the motion.
	Index 1 retrieves the first derivative, if it exists.  Index 2 retrieves the second
	derivative, if it exists.  The number of available derivatives is indicated by the
	<code>Order</code> ({@link #getOrder get}) property.
	
	
	
	
	

	 * Requesting index 0 will result in an  {@link ArgumentOutOfRangeException}.
	 * @param index The index of the derivative to retrieve.
	 * @return The requested derivative.
	 * @exception ArgumentOutOfRangeException 
	Thrown when the <code>index</code> is less than one or greater than the <code>Order</code> ({@link #getOrder get}).
	This exception can also be thrown if this object does not contain any derivatives.
	
	 */
	public final TDerivative get(int index) {
		if (m_derivatives == null || index < 1 || index > m_derivatives.length) {
			throw new ArgumentOutOfRangeException("index");
		}
		return m_derivatives[index - 1];
	}

	/**
	 *  Gets the number of derivatives described by this instance.
	

	 */
	public final int getOrder() {
		if (m_derivatives == null) {
			return 0;
		} else {
			return m_derivatives.length;
		}
	}
}