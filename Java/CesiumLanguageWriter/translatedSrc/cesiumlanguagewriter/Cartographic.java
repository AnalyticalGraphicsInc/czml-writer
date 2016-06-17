package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;

/**
 *  
 A set of curvilinear 3-dimensional coordinates.
 

 */
public class Cartographic implements IEquatable<Cartographic>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Cartographic() {}

	/**
	 *  Gets a set of  {@link Cartographic} coordinates representing the zero vector.
	

	 */
	public static Cartographic getZero() {
		return s_zero;
	}

	/**
	 *  
	Initializes a set of  {@link Cartographic} coordinates from the provided values.
	
	
	
	

	 * @param longitude The angular coordinate lying in the equatorial plane of the ellipsoid and measured from the prime meridian.
	 * @param latitude The angular coordinate measured perpendicular to the equatorial plane.
	 * @param height The linear coordinate measured perpendicular to the surface of the ellipsoid and positive above the surface.
	 */
	public Cartographic(double longitude, double latitude, double height) {
		m_longitude = longitude;
		m_latitude = latitude;
		m_height = height;
	}

	/**
	 *  Gets the angular coordinate lying in the equatorial plane of the ellipsoid and measured from the prime meridian.
	

	 */
	public final double getLongitude() {
		return m_longitude;
	}

	/**
	 *  Gets the angular coordinate measured perpendicular to the equatorial plane.
	

	 */
	public final double getLatitude() {
		return m_latitude;
	}

	/**
	 *  Gets the linear coordinate measured perpendicular to the surface of the ellipsoid and positive above the surface.
	

	 */
	public final double getHeight() {
		return m_height;
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Cartographic && equalsType((Cartographic) obj);
	}

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(Cartographic other) {
		return Double.valueOf(m_longitude).equals(other.m_longitude) && Double.valueOf(m_latitude).equals(other.m_latitude) && Double.valueOf(m_height).equals(other.m_height);
	}

	/**
	 *  
	Indicates whether each coordinate value of another instance of this type
	is within the required tolerance of the corresponding coordinate value of this instance.
	
	
	
	

	 * @param other The set of  {@link Cartographic} coordinates to compare to this instance.
	 * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
	 * @return 
	<see langword="true" /> if the absolute differences are less than or equal to <code>epsilon</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JWarning("Unhandled attribute removed: Pure")
	public final boolean equalsEpsilon(Cartographic other, double epsilon) {
		return Math.abs(m_longitude - other.m_longitude) <= epsilon && Math.abs(m_latitude - other.m_latitude) <= epsilon && Math.abs(m_height - other.m_height) <= epsilon;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return HashCode.combine(DoubleHelper.hashCode(m_longitude), DoubleHelper.hashCode(m_latitude), DoubleHelper.hashCode(m_height));
	}

	/**
	 *  
	Returns the string representation of the value of this instance.
	
	

	 * @return 
	A string that represents the value of this instance in the form
	"Longitude, Latitude, Height".
	
	 */
	@Override
	public String toString() {
		return StringHelper.format("{0}, {1}, {2}", m_longitude, m_latitude, m_height);
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are exactly equal.
	
	
	
	

	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> represents the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Cartographic,Cartographic)'")
	public static boolean equals(Cartographic left, Cartographic right) {
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Cartographic,Cartographic)'")
	public static boolean notEquals(Cartographic left, Cartographic right) {
		return !left.equalsType(right);
	}

	private double m_latitude;
	private double m_longitude;
	private double m_height;
	private static Cartographic s_zero = new Cartographic(0.0, 0.0, 0.0);
}