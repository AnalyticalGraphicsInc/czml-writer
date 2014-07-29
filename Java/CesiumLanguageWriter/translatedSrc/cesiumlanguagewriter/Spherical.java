package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;

/**
 *  
 A set of curvilinear 3-dimensional coordinates.
 

 */
public class Spherical implements IEquatable<Spherical>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Spherical() {}

	/**
	 *  Gets a set of  {@link Spherical} coordinates with values of zero.
	

	 */
	public static Spherical getZero() {
		return s_zero;
	}

	/**
	 *  
	Initializes a set of  {@link Spherical} coordinates from the provided array.
	
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @param startIndex The index of the first element in the array to use.
	 * @exception ArgumentNullException 
	Thrown when the array of <code>elements</code> is null.
	
	 * @exception ArgumentOutOfRangeException 
	Thrown when an object of this type is constructed from an array with less than 3 <code>elements</code>.
	
	 */
	public Spherical(double[] elements, int startIndex) {
		if (elements == null) {
			throw new ArgumentNullException("elements");
		} else if (startIndex >= elements.length || elements.length - startIndex < s_length) {
			throw new ArgumentOutOfRangeException("elements", StringHelper.format(CultureInfoHelper.getCurrentCulture(), CesiumLocalization.getMustBeConstructedFromSpecificNumberOfElements(),
					Spherical.class, 3));
		} else {
			m_clock = elements[startIndex + 0];
			m_cone = elements[startIndex + 1];
			m_magnitude = elements[startIndex + 2];
		}
	}

	/**
	 *  
	Initializes a set of  {@link Spherical} coordinates from the first 3 consecutive elements in the provided array.
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @exception ArgumentNullException 
	The array of <code>elements</code> cannot be null.
	
	 * @exception ArgumentOutOfRangeException 
	An object of this type must be constructed from an array with at least 3 <code>elements</code>.
	
	 */
	public Spherical(double[] elements) {
		this(elements, 0);
	}

	/**
	 *  
	Initializes a set of  {@link Spherical} coordinates from the provided clock angle, cone angle, and magnitude.
	
	
	
	

	 * @param clock The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
	 * @param cone The angular coordinate measured from the positive z-axis and toward the negative z-axis.
	 * @param magnitude The linear coordinate measured from the origin.
	 */
	public Spherical(double clock, double cone, double magnitude) {
		m_clock = clock;
		m_cone = cone;
		m_magnitude = magnitude;
	}

	/**
	 *  
	Initializes a set of  {@link Spherical} coordinates from the provided set of  {@link Cartesian} coordinates.
	
	

	 * @param coordinates The set of Cartesian coordinates.
	 */
	public Spherical(Cartesian coordinates) {
		double x = coordinates.getX();
		double y = coordinates.getY();
		double z = coordinates.getZ();
		double radialSquared = x * x + y * y;
		m_clock = Math.atan2(y, x);
		m_cone = Math.atan2(Math.sqrt(radialSquared), z);
		m_magnitude = Math.sqrt(radialSquared + z * z);
	}

	/**
	 *  Gets the angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
	

	 */
	public final double getClock() {
		return m_clock;
	}

	/**
	 *  Gets the angular coordinate measured from the positive z-axis and toward the negative z-axis.
	

	 */
	public final double getCone() {
		return m_cone;
	}

	/**
	 *  Gets the linear coordinate measured from the origin.
	

	 */
	public final double getMagnitude() {
		return m_magnitude;
	}

	/**
	 *  
	Forms a set of  {@link UnitSpherical} coordinates from this instance.
	
	

	 * @return The resulting set of  {@link UnitSpherical} coordinates.
	 */
	public final UnitSpherical normalize() {
		return new UnitSpherical(this);
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Spherical) {
			return equalsType((Spherical) obj);
		} else {
			return false;
		}
	}

	/**
	 *  
	Indicates whether each coordinate value of another instance of this type
	is within the required tolerance of the corresponding coordinate value of this instance.
	
	
	
	

	 * @param other The set of  {@link Spherical} coordinates to compare to this instance.
	 * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
	 * @return 
	<see langword="true" /> if the absolute differences are less than <code>epsilon</code>; otherwise, <see langword="false" />.
	
	 */
	public final boolean equalsEpsilon(Spherical other, double epsilon) {
		return Math.abs(getClock() - other.getClock()) < epsilon && Math.abs(getCone() - other.getCone()) < epsilon && Math.abs(getMagnitude() - other.getMagnitude()) < epsilon;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return DoubleHelper.hashCode(m_clock) ^ DoubleHelper.hashCode(m_cone) ^ DoubleHelper.hashCode(m_magnitude);
	}

	/**
	 *  
	Returns the string representation of the value of this instance.
	
	

	 * @return 
	A string that represents the value of this instance in the form
	Clock, Cone, and Magnitude.
	
	 */
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder(80);
		build.append(DoubleHelper.toString(m_clock, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
		build.append(DoubleHelper.toString(m_cone, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
		build.append(DoubleHelper.toString(m_magnitude, CultureInfoHelper.getCurrentCulture()));
		return build.toString();
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are exactly equal.
	
	
	
	

	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> represents the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Spherical,Spherical)'")
	public static boolean equals(Spherical left, Spherical right) {
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Spherical,Spherical)'")
	public static boolean notEquals(Spherical left, Spherical right) {
		return !left.equalsType(right);
	}

	private double m_clock;
	private double m_cone;
	private double m_magnitude;
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	private static int s_length = 3;
	private static Spherical s_zero = new Spherical(0.0, 0.0, 0.0);

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(Spherical other) {
		return getClock() == other.getClock() && getCone() == other.getCone() && getMagnitude() == other.getMagnitude();
	}

	/**
	 *  Gets the number of elements in this set of coordinates.
	

	 */
	public final int getLength() {
		return s_length;
	}

	/**
	 *  Gets the value of the specified element with <code>index</code> of 0, 1, and 2 corresponding to the coordinates
	Clock, Cone, and Magnitude.
	
	
	
	

	 * @param index Either 0, 1, or 2 corresponding to the coordinates Clock, Cone, or Magnitude.
	 * @return The coordinate associated with the specified <code>index</code>.
	 * @exception ArgumentOutOfRangeException 
	Thrown when the <code>index</code> is less than 0 or is equal to or greater than <code>Length</code> ({@link #getLength get}).
	
	 */
	public final double get(int index) {
		switch (index) {
		case 0: {
			return getClock();
		}
		case 1: {
			return getCone();
		}
		case 2: {
			return getMagnitude();
		}
		default: {
			throw new ArgumentOutOfRangeException("index");
		}
		}
	}
}