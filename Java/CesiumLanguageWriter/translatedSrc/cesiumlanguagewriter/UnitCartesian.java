package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.Enumeration;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import cesiumlanguagewriter.Cartesian;

/**
 *  
 A set of rectilinear 3-dimensional coordinates with unit magnitude.
 
 

 * 
 
 */
@CS2JWarning("Unhandled attribute removed: SuppressMessage")
public class UnitCartesian implements IEquatable<UnitCartesian>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public UnitCartesian() {}

	/**
	 *  Gets a set of  {@link UnitCartesian} coordinates with values of  {@link Double#NaN}.
	
	

	 * 
	Use <code>IsUndefined</code> ({@link UnitCartesian#getIsUndefined get}) to test whether a  {@link UnitCartesian} instance
	is undefined since it will return <see langword="true" /> if any of the coordinate values
	are  {@link Double#NaN}.
	
	 */
	public static UnitCartesian getUndefined() {
		return s_undefined;
	}

	/**
	 *  Gets a set of  {@link UnitCartesian} coordinates representing the x-axis.
	

	 */
	public static UnitCartesian getUnitX() {
		return s_x;
	}

	/**
	 *  Gets a set of  {@link UnitCartesian} coordinates representing the y-axis.
	

	 */
	public static UnitCartesian getUnitY() {
		return s_y;
	}

	/**
	 *  Gets a set of  {@link UnitCartesian} coordinates representing the z-axis.
	

	 */
	public static UnitCartesian getUnitZ() {
		return s_z;
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from 3 consecutive elements in the provided array.
	
	
	
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @param startIndex The index of the first element in the array to use.
	 * @exception ArgumentNullException 
	Thrown when the array of <code>elements</code> is null.
	
	 * @exception ArgumentOutOfRangeException 
	Thrown when an object of this type is constructed from an array with less than 3 <code>elements</code>.
	
	 * @exception ArithmeticException 
	Thrown when the magnitude of the provided coordinates are zero.
	
	 * @exception ArithmeticException 
	Thrown when the magnitude of the provided coordinates is infinite.
	
	 */
	public UnitCartesian(double[] elements, int startIndex) {
		if (elements == null) {
			throw new ArgumentNullException("elements");
		} else if (startIndex >= elements.length || elements.length - startIndex < s_length) {
			throw new ArgumentOutOfRangeException("elements", StringHelper.format(CultureInfoHelper.getCurrentCulture(), CesiumLocalization.getMustBeConstructedFromSpecificNumberOfElements(),
					UnitCartesian.class, 3));
		} else {
			double magnitude = 0D;
			double[] ref$elements_0 = {
				elements[startIndex + 0]
			};
			double[] ref$elements_1 = {
				elements[startIndex + 1]
			};
			double[] ref$elements_2 = {
				elements[startIndex + 2]
			};
			double[] out$magnitude_3 = {
				0D
			};
			normalizeCoordinates(ref$elements_0, ref$elements_1, ref$elements_2, out$magnitude_3);
			magnitude = out$magnitude_3[0];
			elements[startIndex + 2] = ref$elements_2[0];
			elements[startIndex + 1] = ref$elements_1[0];
			elements[startIndex + 0] = ref$elements_0[0];
			m_x = elements[startIndex + 0];
			m_y = elements[startIndex + 1];
			m_z = elements[startIndex + 2];
		}
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from the first 3 consecutive elements in the provided array.
	
	
	
	
	
	

	 * @param elements The array of coordinate values.
	 * @exception ArgumentNullException 
	The array of <code>elements</code> cannot be null.
	
	 * @exception ArgumentOutOfRangeException 
	An object of this type must be constructed from an array with at least 3 <code>elements</code>.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be zero.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be infinite.
	
	 */
	public UnitCartesian(double[] elements) {
		this(elements, 0);
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from the provided values.
	
	
	
	
	
	

	 * @param x The linear coordinate along the positive x-axis.
	 * @param y The linear coordinate along the positive y-axis.
	 * @param z The linear coordinate along the positive z-axis.
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be zero.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be infinite.
	
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public UnitCartesian(double x, double y, double z) {
		this(x, y, z, Normalization.UNNORMALIZED);
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from the provided values.
	
	
	
	
	
	
	

	 * @param x The linear coordinate along the positive x-axis.
	 * @param y The linear coordinate along the positive y-axis.
	 * @param z The linear coordinate along the positive z-axis.
	 * @param magnitude 
	On input, an array with one element.  On return, the array is populated with
	
	the magnitude of the original set of coordinates.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be zero.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be infinite.
	
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public UnitCartesian(double x, double y, double z, double[] magnitude) {
		double[] ref$x_4 = {
			x
		};
		double[] ref$y_5 = {
			y
		};
		double[] ref$z_6 = {
			z
		};
		normalizeCoordinates(ref$x_4, ref$y_5, ref$z_6, magnitude);
		z = ref$z_6[0];
		y = ref$y_5[0];
		x = ref$x_4[0];
		m_x = x;
		m_y = y;
		m_z = z;
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from the provided set of  {@link Cartesian} coordinates.
	
	
	
	

	 * @param coordinates The set of  {@link Cartesian} coordinates.
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be zero.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be infinite.
	
	 */
	public UnitCartesian(Cartesian coordinates) {
		this(coordinates.getX(), coordinates.getY(), coordinates.getZ(), Normalization.UNNORMALIZED);
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from the provided set of  {@link Cartesian} coordinates.
	
	
	
	
	

	 * @param coordinates The set of  {@link Cartesian} coordinates.
	 * @param magnitude 
	On input, an array with one element.  On return, the array is populated with
	
	the magnitude of the original set of coordinates.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be zero.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be infinite.
	
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public UnitCartesian(Cartesian coordinates, double[] magnitude) {
		this(coordinates.getX(), coordinates.getY(), coordinates.getZ(), magnitude);
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from the provided spherical coordinates.
	
	
	

	 * @param clock The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
	 * @param cone The angular coordinate measured from the positive z-axis and toward the negative z-axis.
	 */
	public UnitCartesian(double clock, double cone) {
		double s = Math.sin(cone);
		m_x = s * Math.cos(clock);
		m_y = s * Math.sin(clock);
		m_z = Math.cos(cone);
	}

	/**
	 *  
	Initializes a set of  {@link UnitCartesian} coordinates from the provided set of
	{@link UnitSpherical} coordinates.
	
	

	 * @param unitSpherical The set of  {@link UnitSpherical} coordinates.
	 */
	public UnitCartesian(UnitSpherical unitSpherical) {
		this(unitSpherical.getClock(), unitSpherical.getCone());
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
	 *  Gets the linear coordinate along the positive z-axis.
	

	 */
	public final double getZ() {
		return m_z;
	}

	/**
	 *  
	Inverts this instance.
	
	

	 * @return A set of  {@link UnitCartesian} coordinates that represents the inverse of this instance.
	 */
	public final UnitCartesian invert() {
		return new UnitCartesian(-m_x, -m_y, -m_z, Normalization.NORMALIZED);
	}

	/**
	 *  
	Multiplies this instance by a scalar.
	
	
	

	 * @param scalar The multiplier, or value by which to multiply this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the multiplication.
	 */
	public final Cartesian multiply(double scalar) {
		return new Cartesian(m_x * scalar, m_y * scalar, m_z * scalar);
	}

	/**
	 *  
	Divides this instance by a scalar.
	
	
	

	 * @param scalar The divisor, or value by which to divide this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the division.
	 */
	public final Cartesian divide(double scalar) {
		return new Cartesian(m_x / scalar, m_y / scalar, m_z / scalar);
	}

	/**
	 *  
	Adds the specified set of  {@link Cartesian} coordinates to this instance.
	
	
	

	 * @param other The addend, or value which is to be added to this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the addition.
	 */
	public final Cartesian add(Cartesian other) {
		return new Cartesian(m_x + other.getX(), m_y + other.getY(), m_z + other.getZ());
	}

	/**
	 *  
	Adds the specified set of  {@link UnitCartesian} coordinates to this instance.
	
	
	

	 * @param other The addend, or value which is to be added to this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the addition.
	 */
	public final Cartesian add(UnitCartesian other) {
		return new Cartesian(m_x + other.m_x, m_y + other.m_y, m_z + other.m_z);
	}

	/**
	 *  
	Subtracts the specified set of  {@link Cartesian} coordinates from this instance.
	
	
	

	 * @param other The subtrahend, or value which is to be subtracted from this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the subtraction.
	 */
	public final Cartesian subtract(Cartesian other) {
		return new Cartesian(m_x - other.getX(), m_y - other.getY(), m_z - other.getZ());
	}

	/**
	 *  
	Subtracts the specified set of  {@link UnitCartesian} coordinates from this instance.
	
	
	

	 * @param other The subtrahend, or value which is to be subtracted from this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the subtraction.
	 */
	public final Cartesian subtract(UnitCartesian other) {
		return new Cartesian(m_x - other.m_x, m_y - other.m_y, m_z - other.m_z);
	}

	/**
	 *  
	Forms the cross product of the specified set of  {@link Cartesian} coordinates with this instance.
	
	
	

	 * @param other The set of  {@link Cartesian} coordinates to cross with this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the product.
	 */
	public final Cartesian cross(Cartesian other) {
		return new Cartesian(m_y * other.getZ() - m_z * other.getY(), m_z * other.getX() - m_x * other.getZ(), m_x * other.getY() - m_y * other.getX());
	}

	/**
	 *  
	Forms the cross product of the specified set of  {@link UnitCartesian} coordinates with this instance.
	
	
	

	 * @param other The set of  {@link Cartesian} coordinates to cross with this instance.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the product.
	 */
	public final Cartesian cross(UnitCartesian other) {
		return new Cartesian(m_y * other.m_z - m_z * other.m_y, m_z * other.m_x - m_x * other.m_z, m_x * other.m_y - m_y * other.m_x);
	}

	/**
	 *  
	Forms the dot product of the specified set of  {@link Cartesian} coordinates with this instance.
	
	
	

	 * @param other The set of  {@link Cartesian} coordinates to dot with this instance.
	 * @return A  <code>double</code> that represents the result of the product.
	 */
	public final double dot(Cartesian other) {
		return m_x * other.getX() + m_y * other.getY() + m_z * other.getZ();
	}

	/**
	 *  
	Forms the dot product of the specified set of  {@link UnitCartesian} coordinates with this instance.
	
	
	

	 * @param other The set of  {@link Cartesian} coordinates to dot with this instance.
	 * @return A  <code>double</code> that represents the result of the product.
	 */
	public final double dot(UnitCartesian other) {
		return m_x * other.m_x + m_y * other.m_y + m_z * other.m_z;
	}

	/**
	 *  
	Multiplies a specified set of  {@link UnitCartesian} coordinates by a scalar.
	
	
	
	

	 * @param left The multiplicand, or value which is to be multiplied by <code>right</code>.
	 * @param right The multiplier, or value which is to multiply <code>left</code>.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian *(UnitCartesian,System.Double)'")
	public static Cartesian multiply(UnitCartesian left, double right) {
		return left.multiply(right);
	}

	/**
	 *  
	Multiplies a scalar by a specified set of  {@link UnitCartesian} coordinates.
	
	
	
	

	 * @param left The multiplicand, or value to be multiplied by <code>right</code>.
	 * @param right The multiplier, or value which by which <code>left</code> is to be multiplied.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian *(System.Double,UnitCartesian)'")
	public static Cartesian multiply(double left, UnitCartesian right) {
		return right.multiply(left);
	}

	/**
	 *  
	Divides a specified set of  {@link UnitCartesian} coordinates by a scalar.
	
	
	
	

	 * @param left The dividend, or value to be divided by <code>right</code>.
	 * @param right The divisor, or value by which <code>left</code> is to be divided.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the division.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian /(UnitCartesian,System.Double)'")
	public static Cartesian divide(UnitCartesian left, double right) {
		return left.divide(right);
	}

	/**
	 *  
	Adds a specified set of  {@link UnitCartesian} coordinates to another specified set of  {@link UnitCartesian} coordinates.
	
	
	
	

	 * @param left The augend, or value to which <code>right</code> is to be added.
	 * @param right The addend, or value which is to be added to <code>left</code>.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the addition.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian +(UnitCartesian,UnitCartesian)'")
	public static Cartesian add(UnitCartesian left, UnitCartesian right) {
		return left.add(Cartesian.toCartesian(right));
	}

	/**
	 *  
	Adds a specified set of  {@link Cartesian} coordinates to a specified set of  {@link UnitCartesian} coordinates.
	
	
	
	

	 * @param left The augend, or value to which <code>right</code> is to be added.
	 * @param right The addend, or value which is to be added to <code>left</code>.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the addition.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian +(UnitCartesian,Cartesian)'")
	public static Cartesian add(UnitCartesian left, Cartesian right) {
		return left.add(right);
	}

	/**
	 *  
	Adds a specified set of  {@link UnitCartesian} coordinates to a specified set of  {@link Cartesian} coordinates.
	
	
	
	

	 * @param left The augend, or value to which <code>right</code> is to be added.
	 * @param right The addend, or value which is to be added to <code>left</code>.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the addition.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian +(Cartesian,UnitCartesian)'")
	public static Cartesian add(Cartesian left, UnitCartesian right) {
		return right.add(left);
	}

	/**
	 *  
	Subtracts a specified set of  {@link UnitCartesian} coordinates from another specified set of  {@link UnitCartesian} coordinates.
	
	
	
	

	 * @param left The minuend, or value from which <code>right</code> is to be subtracted.
	 * @param right The subtrahend, or value which is to be subtracted from <code>left</code>.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the subtraction.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(UnitCartesian,UnitCartesian)'")
	public static Cartesian subtract(UnitCartesian left, UnitCartesian right) {
		return left.subtract(Cartesian.toCartesian(right));
	}

	/**
	 *  
	Subtracts a specified set of  {@link Cartesian} coordinates from a specified set of  {@link UnitCartesian} coordinates.
	
	
	
	

	 * @param left The minuend, or value from which <code>right</code> is to be subtracted.
	 * @param right The subtrahend, or value which is to be subtracted from <code>left</code>.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the subtraction.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(UnitCartesian,Cartesian)'")
	public static Cartesian subtract(UnitCartesian left, Cartesian right) {
		return left.subtract(right);
	}

	/**
	 *  
	Subtracts a specified set of  {@link UnitCartesian} coordinates from a specified set of  {@link Cartesian} coordinates.
	
	
	
	

	 * @param left The minuend, or value from which <code>right</code> is to be subtracted.
	 * @param right The subtrahend, or value which is to be subtracted from <code>left</code>.
	 * @return A set of  {@link Cartesian} coordinates that represents the result of the subtraction.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(Cartesian,UnitCartesian)'")
	public static Cartesian subtract(Cartesian left, UnitCartesian right) {
		return left.subtract(Cartesian.toCartesian(right));
	}

	/**
	 *  
	Negates the specified  {@link UnitCartesian}, yielding a new  {@link UnitCartesian}.
	
	
	

	 * @param coordinates The set of coordinates.
	 * @return The result of negating the elements of the original  {@link UnitCartesian}.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'UnitCartesian -(UnitCartesian)'")
	public static UnitCartesian negate(UnitCartesian coordinates) {
		return new UnitCartesian(-coordinates.m_x, -coordinates.m_y, -coordinates.m_z, Normalization.NORMALIZED);
	}

	/**
	 *  
	Produces a set of  {@link UnitCartesian} coordinates representing this instance which results from rotating
	the original axes used to represent this instance by the provided  {@link Matrix3By3} rotation.
	
	
	
	

	 * 
	This type of rotation is sometimes referred to as an "alias rotation".
	
	 * @param rotation The  {@link Matrix3By3} rotation.
	 * @return A set of  {@link UnitCartesian} coordinates which is the result of the rotation.
	 */
	public final UnitCartesian rotate(Matrix3By3 rotation) {
		return new UnitCartesian(rotation.getM11() * m_x + rotation.getM12() * m_y + rotation.getM13() * m_z, rotation.getM21() * m_x + rotation.getM22() * m_y + rotation.getM23() * m_z, rotation
				.getM31()
				* m_x + rotation.getM32() * m_y + rotation.getM33() * m_z, Normalization.NORMALIZED);
	}

	/**
	 *  
	Produces a set of  {@link UnitCartesian} coordinates representing this instance which results from rotating
	the original axes used to represent this instance by the provided  {@link UnitQuaternion} rotation.
	
	
	
	

	 * 
	This type of rotation is sometimes referred to as an "alias rotation".
	
	 * @param rotation The  {@link UnitQuaternion} rotation.
	 * @return A set of  {@link UnitCartesian} coordinates which is the result of the rotation.
	 */
	public final UnitCartesian rotate(UnitQuaternion rotation) {
		double w = rotation.getW();
		double difference = w * w - rotation.getX() * rotation.getX() - rotation.getY() * rotation.getY() - rotation.getZ() * rotation.getZ();
		double dot = m_x * rotation.getX() + m_y * rotation.getY() + m_z * rotation.getZ();
		return new UnitCartesian(difference * m_x + 2.0 * (w * (m_y * rotation.getZ() - m_z * rotation.getY()) + dot * rotation.getX()), difference * m_y + 2.0
				* (w * (m_z * rotation.getX() - m_x * rotation.getZ()) + dot * rotation.getY()),
				difference * m_z + 2.0 * (w * (m_x * rotation.getY() - m_y * rotation.getX()) + dot * rotation.getZ()), Normalization.NORMALIZED);
	}

	/**
	 *  Gets the axis that is most orthogonal to this instance.
	

	 */
	public final UnitCartesian getMostOrthogonalAxis() {
		double x = Math.abs(m_x);
		double y = Math.abs(m_y);
		double z = Math.abs(m_z);
		if (x <= y) {
			return ((x <= z) ? UnitCartesian.getUnitX() : UnitCartesian.getUnitZ());
		} else {
			return ((y <= z) ? UnitCartesian.getUnitY() : UnitCartesian.getUnitZ());
		}
	}

	/**
	 *  Gets the axis which is most parallel to this instance.
	

	 */
	public final UnitCartesian getMostParallelAxis() {
		double x = Math.abs(m_x);
		double y = Math.abs(m_y);
		double z = Math.abs(m_z);
		if (x >= y) {
			return ((x >= z) ? UnitCartesian.getUnitX() : UnitCartesian.getUnitZ());
		} else {
			return ((y >= z) ? UnitCartesian.getUnitY() : UnitCartesian.getUnitZ());
		}
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitCartesian) {
			return equalsType((UnitCartesian) obj);
		} else {
			return false;
		}
	}

	/**
	 *  
	Indicates whether each coordinate value of another instance of this type
	is within the required tolerance of the corresponding coordinate value of this instance.
	
	
	
	

	 * @param other The set of  {@link UnitCartesian} coordinates to compare to this instance.
	 * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
	 * @return 
	<see langword="true" /> if the absolute differences are less than <code>epsilon</code>; otherwise, <see langword="false" />.
	
	 */
	public final boolean equalsEpsilon(UnitCartesian other, double epsilon) {
		return Math.abs(getX() - other.getX()) < epsilon && Math.abs(getY() - other.getY()) < epsilon && Math.abs(getZ() - other.getZ()) < epsilon;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return DoubleHelper.hashCode(m_x) ^ DoubleHelper.hashCode(m_y) ^ DoubleHelper.hashCode(m_z);
	}

	/**
	 *  
	Returns the string representation of the value of this instance.
	
	

	 * @return 
	A string that represents the value of this instance in the form
	"X, Y, Z".
	
	 */
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder(80);
		build.append(DoubleHelper.toString(m_x, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
		build.append(DoubleHelper.toString(m_y, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
		build.append(DoubleHelper.toString(m_z, CultureInfoHelper.getCurrentCulture()));
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(UnitCartesian,UnitCartesian)'")
	public static boolean equals(UnitCartesian left, UnitCartesian right) {
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(UnitCartesian,UnitCartesian)'")
	public static boolean notEquals(UnitCartesian left, UnitCartesian right) {
		return !left.equalsType(right);
	}

	/**
	 *  Gets whether or not any of the coordinates for this instance have the value  {@link Double#NaN}.
	

	 */
	public final boolean getIsUndefined() {
		return Double.isNaN(m_x) || Double.isNaN(m_y) || Double.isNaN(m_z);
	}

	/**
	 *  
	Determines the angle in radians between the specified set of  {@link UnitCartesian} coordinates and this instance.
	
	
	

	 * @param other The set of  {@link UnitCartesian} coordinates to evaluate.
	 * @return A  <code>double</code> that represents the angle in radians between the two instances.
	 */
	public final double angleBetween(UnitCartesian other) {
		double cosine = this.dot(Cartesian.toCartesian(other));
		double sine = this.cross(Cartesian.toCartesian(other)).getMagnitude();
		return Math.atan2(sine, cosine);
	}

	private UnitCartesian(double x, double y, double z, Normalization normalization) {
		if (normalization == Normalization.NORMALIZED) {
			m_x = x;
			m_y = y;
			m_z = z;
		} else {
			double magnitude = 0D;
			double[] ref$x_7 = {
				x
			};
			double[] ref$y_8 = {
				y
			};
			double[] ref$z_9 = {
				z
			};
			double[] out$magnitude_10 = {
				0D
			};
			normalizeCoordinates(ref$x_7, ref$y_8, ref$z_9, out$magnitude_10);
			magnitude = out$magnitude_10[0];
			z = ref$z_9[0];
			y = ref$y_8[0];
			x = ref$x_7[0];
			m_x = x;
			m_y = y;
			m_z = z;
		}
	}

	static private void normalizeCoordinates(double[] x, double[] y, double[] z, double[] magnitude) {
		magnitude[0] = Math.sqrt(x[0] * x[0] + y[0] * y[0] + z[0] * z[0]);
		if (magnitude[0] == 0.0) {
			throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeZero());
		} else if (Double.isInfinite(magnitude[0])) {
			throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeInfinite());
		} else {
			x[0] /= magnitude[0];
			y[0] /= magnitude[0];
			z[0] /= magnitude[0];
		}
	}

	private double m_x;
	private double m_y;
	private double m_z;
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	private static int s_length = 3;
	private static UnitCartesian s_x = new UnitCartesian(1.0, 0.0, 0.0, Normalization.NORMALIZED);
	private static UnitCartesian s_y = new UnitCartesian(0.0, 1.0, 0.0, Normalization.NORMALIZED);
	private static UnitCartesian s_z = new UnitCartesian(0.0, 0.0, 1.0, Normalization.NORMALIZED);
	private static UnitCartesian s_undefined = new UnitCartesian(Double.NaN, Double.NaN, Double.NaN, Normalization.NORMALIZED);

	static private enum Normalization implements Enumeration {
		UNNORMALIZED(0), NORMALIZED(1);
		private final int value;

		Normalization(int value) {
			this.value = value;
		}

		/**
		 * Get the numeric value associated with this enum constant.
		 * @return A numeric value.
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Get the enum constant that is associated with the given numeric value.
		 * @return The enum constant associated with value.
		 * @param value a numeric value.
		 */
		public static Normalization getFromValue(int value) {
			switch (value) {
			case 0:
				return UNNORMALIZED;
			case 1:
				return NORMALIZED;
			default:
				throw new IllegalArgumentException("Undefined enum value.");
			}
		}

		/**
		 * Get the enum constant that is considered to be the default.
		 * @return The default enum constant.
		 */
		public static Normalization getDefault() {
			return UNNORMALIZED;
		}
	}

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(UnitCartesian other) {
		return other.m_x == m_x && other.m_y == m_y && other.m_z == m_z;
	}

	/**
	 *  Gets the number of elements in this set of coordinates.
	

	 */
	public final int getLength() {
		return s_length;
	}

	/**
	 *  Gets the value of the specified element with <code>index</code> of 0, 1, and 2 corresponding to the coordinates
	X, Y, and Z.
	
	
	
	

	 * @param index Either 0, 1, or 2 corresponding to the coordinates X, Y, or Z.
	 * @return The coordinate associated with the specified <code>index</code>.
	 * @exception ArgumentOutOfRangeException 
	Thrown when <code>index</code> is less than 0 or is equal to or greater than <code>Length</code> ({@link #getLength get}).
	
	 */
	public final double get(int index) {
		switch (index) {
		case 0:
			return getX();
		case 1:
			return getY();
		case 2:
			return getZ();
		default:
			throw new ArgumentOutOfRangeException("index");
		}
	}
}