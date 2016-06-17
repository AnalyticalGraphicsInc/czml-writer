package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;

/**
 *  
 A numeric value which will be linearly interpolated between two values based 
 on an object's distance from the camera, in eye coordinates.  The computed value 
 will interpolate between the near value and the far value while the camera distance 
 falls between the near distance and the far distance, and will be clamped to the 
 near or far value while the distance is less than the near distance or greater 
 than the far distance, respectively.
 

 */
public class NearFarScalar implements IEquatable<NearFarScalar>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public NearFarScalar() {}

	/**
	 *  
	Initializes a new instance.
	
	
	
	
	

	 * @param nearDistance The lower bound of the camera distance range.
	 * @param nearValue The value to use at the lower bound of the camera distance range.
	 * @param farDistance The upper bound of the camera distance range.
	 * @param farValue The value to use at the upper bound of the camera distance range.
	 */
	public NearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue) {
		m_nearDistance = nearDistance;
		m_nearValue = nearValue;
		m_farDistance = farDistance;
		m_farValue = farValue;
	}

	/**
	 *  
	The lower bound of the camera distance range.
	

	 */
	public final double getNearDistance() {
		return m_nearDistance;
	}

	/**
	 *  
	The value to use at the lower bound of the camera distance range.
	

	 */
	public final double getNearValue() {
		return m_nearValue;
	}

	/**
	 *  
	The upper bound of the camera distance range.
	

	 */
	public final double getFarDistance() {
		return m_farDistance;
	}

	/**
	 *  
	The value to use at the upper bound of the camera distance range.
	

	 */
	public final double getFarValue() {
		return m_farValue;
	}

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(NearFarScalar other) {
		return Double.valueOf(m_nearDistance).equals(other.m_nearDistance) && Double.valueOf(m_nearValue).equals(other.m_nearValue) && Double.valueOf(m_farDistance).equals(other.m_farDistance)
				&& Double.valueOf(m_farValue).equals(other.m_farValue);
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NearFarScalar && equalsType((NearFarScalar) obj);
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return HashCode.combine(DoubleHelper.hashCode(m_nearDistance), DoubleHelper.hashCode(m_nearValue), DoubleHelper.hashCode(m_farDistance), DoubleHelper.hashCode(m_farValue));
	}

	/**
	 *  
	Returns the string representation of the value of this instance.
	
	

	 * @return 
	A string that represents the value of this instance in the form
	"NearDistance, NearValue, FarDistance, FarValue".
	
	 */
	@Override
	public String toString() {
		return StringHelper.format("{0}, {1}, {2}, {3}", m_nearDistance, m_nearValue, m_farDistance, m_farValue);
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are exactly equal.
	
	
	
	

	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> represents the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(NearFarScalar,NearFarScalar)'")
	public static boolean equals(NearFarScalar left, NearFarScalar right) {
		return left.equalsType(right);
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are not exactly equal.
	
	
	
	

	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> does not represent the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(NearFarScalar,NearFarScalar)'")
	public static boolean notEquals(NearFarScalar left, NearFarScalar right) {
		return !left.equalsType(right);
	}

	private double m_nearDistance;
	private double m_nearValue;
	private double m_farDistance;
	private double m_farValue;
}