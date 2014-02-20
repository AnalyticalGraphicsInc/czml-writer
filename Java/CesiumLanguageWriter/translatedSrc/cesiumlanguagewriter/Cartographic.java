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
	Initializes a set of  {@link Cartographic} coordinates from the provided array.
	
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @param startIndex The index of the first element in the array to use.
	 * @exception ArgumentNullException 
	Thrown when the array of <code>elements</code> is null.
	
	 * @exception ArgumentOutOfRangeException 
	Thrown when an object of this type is constructed from an array with less than 3 <code>elements</code>.
	
	 */
	public Cartographic(double[] elements, int startIndex) {
		if (elements == null) {
			throw new ArgumentNullException("elements");
		} else if (startIndex >= elements.length || elements.length - startIndex < s_length) {
			throw new ArgumentOutOfRangeException("elements", StringHelper.format(CultureInfoHelper.getCurrentCulture(), CesiumLocalization.getMustBeConstructedFromSpecificNumberOfElements(),
					Cartographic.class, 3));
		} else {
			m_longitude = elements[startIndex + 0];
			m_latitude = elements[startIndex + 1];
			m_height = elements[startIndex + 2];
		}
	}

	/**
	 *  
	Initializes a set of  {@link Cartographic} coordinates from the first 3 consecutive elements in the provided array.
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @exception ArgumentNullException 
	The array of <code>elements</code> cannot be null.
	
	 * @exception ArgumentOutOfRangeException 
	An object of this type must be constructed from an array with at least 3 <code>elements</code>.
	
	 */
	public Cartographic(double[] elements) {
		this(elements, 0);
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
		if (obj instanceof Cartographic) {
			return equalsType((Cartographic) obj);
		} else {
			return false;
		}
	}

	/**
	 *  
	Indicates whether each coordinate value of another instance of this type
	is within the required tolerance of the corresponding coordinate value of this instance.
	
	
	
	

	 * @param other The set of  {@link Cartographic} coordinates to compare to this instance.
	 * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
	 * @return 
	<see langword="true" /> if the absolute differences are less than <code>epsilon</code>; otherwise, <see langword="false" />.
	
	 */
	public final boolean equalsEpsilon(Cartographic other, double epsilon) {
		return Math.abs(getLongitude() - other.getLongitude()) < epsilon && Math.abs(getLatitude() - other.getLatitude()) < epsilon && Math.abs(getHeight() - other.getHeight()) < epsilon;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return DoubleHelper.hashCode(m_longitude) ^ DoubleHelper.hashCode(m_latitude) ^ DoubleHelper.hashCode(m_height);
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
		StringBuilder build = new StringBuilder(80);
		build.append(DoubleHelper.toString(m_longitude, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
		build.append(DoubleHelper.toString(m_latitude, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
		build.append(DoubleHelper.toString(m_height, CultureInfoHelper.getCurrentCulture()));
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

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(Cartographic other) {
		return getLongitude() == other.getLongitude() && getLatitude() == other.getLatitude() && getHeight() == other.getHeight();
	}

	/**
	 *  Gets the number of elements in this set of coordinates.
	

	 */
	public final int getLength() {
		return s_length;
	}

	/**
	 *  Gets the value of the specified element with <code>index</code> of 0, 1, and 2 corresponding to the coordinates
	"Longitude, Latitude, Height".
	
	
	
	

	 * @param index Either a 0, 1, or 2 corresponding to the coordinates "Longitude, Latitude, Height".
	 * @return The coordinate associated with the specified <code>index</code>.
	 * @exception ArgumentOutOfRangeException 
	Thrown when the <code>index</code> is less than 0 or greater than or equal to the <code>Length</code> ({@link #getLength get}).
	
	 */
	public final double get(int index) {
		switch (index) {
		case 0: {
			return getLongitude();
		}
		case 1: {
			return getLatitude();
		}
		case 2: {
			return getHeight();
		}
		default: {
			throw new ArgumentOutOfRangeException("index");
		}
		}
	}

	private double m_latitude;
	private double m_longitude;
	private double m_height;
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	private static int s_length = 3;
	private static Cartographic s_zero = new Cartographic(0.0, 0.0, 0.0);
}