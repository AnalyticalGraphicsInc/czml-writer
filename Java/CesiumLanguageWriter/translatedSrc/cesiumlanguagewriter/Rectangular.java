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
 A set of rectilinear 2-dimensional coordinates.
 
 

 * 
 The corresponding 3-dimensional coordinates are  {@link Cartesian} coordinates.
 
 */
@CS2JWarning("Unhandled attribute removed: SuppressMessage")
public class Rectangular implements IEquatable<Rectangular>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Rectangular() {}

	/**
	 *  Gets a set of  {@link Rectangular} coordinates with values of zero.
	

	 */
	public static Rectangular getZero() {
		return s_zero;
	}

	/**
	 *  Gets a set of  {@link Rectangular} coordinates with values of  {@link Double#NaN}.
	
	

	 * 
	Use <code>IsUndefined</code> ({@link Rectangular#getIsUndefined get}) to test whether a  {@link Rectangular} instance
	is undefined since it will return <see langword="true" /> if any of the coordinate values
	are  {@link Double#NaN}.
	
	 */
	public static Rectangular getUndefined() {
		return s_undefined;
	}

	/**
	 *  
	Initializes a set of  {@link Rectangular} coordinates from 2 consecutive elements in the provided array.
	
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @param startIndex The index of the first element in the array to use.
	 * @exception ArgumentNullException 
	Thrown when the array of <code>elements</code> is null.
	
	 * @exception ArgumentOutOfRangeException 
	Thrown when an object of this type is constructed from an array with less than 2 <code>elements</code>.
	
	 */
	public Rectangular(double[] elements, int startIndex) {
		if (elements == null) {
			throw new ArgumentNullException("elements");
		} else if (startIndex >= elements.length || elements.length - startIndex < s_length) {
			throw new ArgumentOutOfRangeException("elements", StringHelper.format(CultureInfoHelper.getCurrentCulture(), CesiumLocalization.getMustBeConstructedFromSpecificNumberOfElements(),
					Rectangular.class, 2));
		} else {
			m_x = elements[startIndex + 0];
			m_y = elements[startIndex + 1];
		}
	}

	/**
	 *  
	Initializes a set of  {@link Rectangular} coordinates from the first 2 consecutive elements in the provided array.
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @exception ArgumentNullException 
	The array of <code>elements</code> cannot be null.
	
	 * @exception ArgumentOutOfRangeException 
	An object of this type must be constructed from an array with at least 2 <code>elements</code>.
	
	 */
	public Rectangular(double[] elements) {
		this(elements, 0);
	}

	/**
	 *  
	Initializes a set of  {@link Rectangular} coordinates from the provided values.
	
	
	

	 * @param x The linear coordinate along the positive x-axis.
	 * @param y The linear coordinate along the positive y-axis.
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public Rectangular(double x, double y) {
		m_x = x;
		m_y = y;
	}

	/**
	 *  Gets the linear coordinate along the positive x-axis.
	

	 */
	public final double getX() {
		return m_x;
	}

	/**
	 *  Gets the linear coordinate along the positive y-axis.
	

	 */
	public final double getY() {
		return m_y;
	}

	/**
	 *  
	Inverts this instance.
	
	

	 * @return A set of  {@link Rectangular} coordinates that represents the inverse of this instance.
	 */
	public final Rectangular invert() {
		return new Rectangular(-m_x, -m_y);
	}

	/**
	 *  
	Multiplies this instance by a scalar.
	
	
	

	 * @param scalar The multiplier, or value which is to multiply this instance.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the multiplication.
	 */
	public final Rectangular multiply(double scalar) {
		return new Rectangular(m_x * scalar, m_y * scalar);
	}

	/**
	 *  
	Divides this instance by a scalar.
	
	
	

	 * @param scalar The divisor, or value which is to divide this instance.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the division.
	 */
	public final Rectangular divide(double scalar) {
		return new Rectangular(m_x / scalar, m_y / scalar);
	}

	/**
	 *  
	Adds the specified set of  {@link Rectangular} coordinates to this instance.
	
	
	

	 * @param other The addend, or value which is to be added to this instance.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the addition.
	 */
	public final Rectangular add(Rectangular other) {
		return new Rectangular(m_x + other.m_x, m_y + other.m_y);
	}

	/**
	 *  
	Subtracts the specified set of  {@link Rectangular} coordinates from this instance.
	
	
	

	 * @param other The subtrahend, or value which is to be subtracted from this instance.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the subtraction.
	 */
	public final Rectangular subtract(Rectangular other) {
		return new Rectangular(m_x - other.m_x, m_y - other.m_y);
	}

	/**
	 *  
	Forms the dot product of the specified set of  {@link Rectangular} coordinates with this instance.
	
	
	

	 * @param other The set of  {@link Rectangular} coordinates to dot with this instance.
	 * @return A  <code>double</code> that represents the result of the product.
	 */
	public final double dot(Rectangular other) {
		return m_x * other.m_x + m_y * other.m_y;
	}

	/**
	 *  
	Multiplies a specified set of  {@link Rectangular} coordinates by a scalar.
	
	
	
	

	 * @param left The multiplicand, or value which is to be multiplied by <code>right</code>.
	 * @param right The multiplier, or value which is to multiply <code>left</code>.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular *(Rectangular,System.Double)'")
	public static Rectangular multiply(Rectangular left, double right) {
		return left.multiply(right);
	}

	/**
	 *  
	Multiplies a scalar by a specified set of set of  {@link Rectangular} coordinates.
	
	
	
	

	 * @param left The multiplicand, or value which is to be multiplied by <code>right</code>.
	 * @param right The multiplier, or value which is to multiply <code>left</code>.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular *(System.Double,Rectangular)'")
	public static Rectangular multiply(double left, Rectangular right) {
		return right.multiply(left);
	}

	/**
	 *  
	Divides a specified set of  {@link Rectangular} coordinates by a scalar.
	
	
	
	

	 * @param left The dividend, or value which is to be divided by <code>right</code>.
	 * @param right The divisor, or value which is to divide <code>left</code>.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the division.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular /(Rectangular,System.Double)'")
	public static Rectangular divide(Rectangular left, double right) {
		return left.divide(right);
	}

	/**
	 *  
	Adds a specified set of  {@link Rectangular} coordinates to another specified set of  {@link Cartesian} coordinates.
	
	
	
	

	 * @param left The augend, or value to which <code>right</code> is to be added.
	 * @param right The addend, or value which is to be added to <code>left</code>.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the addition.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular +(Rectangular,Rectangular)'")
	public static Rectangular add(Rectangular left, Rectangular right) {
		return left.add(right);
	}

	/**
	 *  
	Subtracts a specified set of  {@link Rectangular} coordinates from another specified set of  {@link Rectangular} coordinates.
	
	
	
	

	 * @param left The minuend, or value from which <code>right</code> is to be subtracted.
	 * @param right The subtrahend, or value which is to be subtracted from <code>left</code>.
	 * @return A set of  {@link Rectangular} coordinates that represents the result of the subtraction.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular -(Rectangular,Rectangular)'")
	public static Rectangular subtract(Rectangular left, Rectangular right) {
		return left.subtract(right);
	}

	/**
	 *  
	Negates the specified set of  {@link Rectangular} coordinates, yielding a new set of  {@link Rectangular} coordinates.
	
	
	

	 * @param coordinates The set of coordinates.
	 * @return The result of negating the elements of the original set of  {@link Rectangular} coordinates.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular -(Rectangular)'")
	public static Rectangular negate(Rectangular coordinates) {
		return new Rectangular(-coordinates.m_x, -coordinates.m_y);
	}

	/**
	 *  
	Produces a set of  {@link Rectangular} coordinates representing this instance which results from rotating
	the original axes used to represent this instance by the provided angle.
	
	
	
	

	 * 
	This type of rotation is sometimes referred to as an "alias rotation".
	
	 * @param angle The angle of rotation.
	 * @return A set of  {@link Rectangular} coordinates which is the result of the rotation.
	 */
	public final Rectangular rotate(double angle) {
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		return new Rectangular(c * m_x - s * m_y, s * m_x + c * m_y);
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangular) {
			return equalsType((Rectangular) obj);
		} else {
			return false;
		}
	}

	/**
	 *  
	Indicates whether each coordinate value of another instance of this type
	is within the required tolerance of the corresponding coordinate value of this instance.
	
	
	
	

	 * @param other The set of  {@link Rectangular} coordinates to compare to this instance.
	 * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
	 * @return 
	<see langword="true" /> if the absolute differences are less than <code>epsilon</code>; otherwise, <see langword="false" />.
	
	 */
	public final boolean equalsEpsilon(Rectangular other, double epsilon) {
		return Math.abs(getX() - other.getX()) < epsilon && Math.abs(getY() - other.getY()) < epsilon;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return DoubleHelper.hashCode(m_x) ^ DoubleHelper.hashCode(m_y);
	}

	/**
	 *  
	Returns the string representation of the value of this instance.
	
	

	 * @return 
	A string that represents the value of this instance in the form
	"X, Y".
	
	 */
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder(80);
		build.append(DoubleHelper.toString(m_x, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
		build.append(DoubleHelper.toString(m_y, CultureInfoHelper.getCurrentCulture()));
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Rectangular,Rectangular)'")
	public static boolean equals(Rectangular left, Rectangular right) {
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Rectangular,Rectangular)'")
	public static boolean notEquals(Rectangular left, Rectangular right) {
		return !left.equalsType(right);
	}

	/**
	 *  Gets the magnitude of this instance.
	

	 */
	public final double getMagnitude() {
		return Math.sqrt(getMagnitudeSquared());
	}

	/**
	 *  Gets the square of the <code>Magnitude</code> ({@link #getMagnitude get}) of this instance.
	

	 */
	public final double getMagnitudeSquared() {
		return m_x * m_x + m_y * m_y;
	}

	/**
	 *  Gets a value indicating if the <code>Magnitude</code> ({@link #getMagnitude get}) of this instance is zero.
	

	 */
	public final boolean getHasZeroMagnitude() {
		// Test the square of the magnitude since this is equivalent and more efficient.
		return (getMagnitudeSquared() == 0.0);
	}

	/**
	 *  Gets whether or not any of the coordinates for this instance have the value  {@link Double#NaN}.
	

	 */
	public final boolean getIsUndefined() {
		return Double.isNaN(m_x) || Double.isNaN(m_y);
	}

	private double m_x;
	private double m_y;
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	private static int s_length = 2;
	private static Rectangular s_zero = new Rectangular(0.0, 0.0);
	private static Rectangular s_undefined = new Rectangular(Double.NaN, Double.NaN);

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(Rectangular other) {
		return other.m_x == m_x && other.m_y == m_y;
	}

	/**
	 *  Gets the number of elements in this set of coordinates.
	

	 */
	public final int getLength() {
		return s_length;
	}

	/**
	 *  Gets the value of the specified element with <code>index</code> of 0 and 1 corresponding to the coordinates
	X and Y.
	
	
	
	

	 * @param index Either 0 or 1 corresponding to the coordinates X or Y.
	 * @return The coordinate associated with the specified <code>index</code>.
	 * @exception ArgumentOutOfRangeException 
	Thrown when the <code>index</code> is less than 0 or is equal to or greater than <code>Length</code> ({@link #getLength get}).
	
	 */
	public final double get(int index) {
		switch (index) {
		case 0:
			return getX();
		case 1:
			return getY();
		default:
			throw new ArgumentOutOfRangeException("index");
		}
	}
}