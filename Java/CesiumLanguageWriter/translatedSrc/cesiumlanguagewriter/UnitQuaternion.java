package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.Enumeration;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;

/**
 *  
 A set of 4-dimensional coordinates used to represent rotation in 3-dimensional space.
 
 
 

 * 
 To transform a  {@link Cartesian} with this rotation, see  {@link Cartesian#rotate(UnitQuaternion)}.
 
 * @see Matrix3By3
 */
@CS2JWarning("Unhandled attribute removed: SuppressMessage")
public class UnitQuaternion implements IEquatable<UnitQuaternion>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public UnitQuaternion() {}

	/**
	 *  Gets a set of  {@link UnitQuaternion} coordinates with values of  {@link Double#NaN}.
	
	

	 * 
	Use <code>IsUndefined</code> ({@link UnitQuaternion#getIsUndefined get}) to test whether a  {@link UnitQuaternion} instance
	is undefined since it will return <see langword="true" /> if any of the coordinate values
	are  {@link Double#NaN}.
	
	 */
	public static UnitQuaternion getUndefined() {
		return s_undefined;
	}

	/**
	 *  Gets a set of  {@link UnitQuaternion} coordinates representing the identity vector.
	

	 */
	public static UnitQuaternion getIdentity() {
		return s_identity;
	}

	/**
	 *  
	Initializes a set of  {@link UnitQuaternion} coordinates from the provided values.
	
	
	
	
	
	
	
	

	 * The given values will be normalized to ensure a unit magnitude.
	 * @param w The W coordinate.
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 * @param z The Z coordinate.
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be zero.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be infinite.
	
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public UnitQuaternion(double w, double x, double y, double z) {
		this(w, x, y, z, Normalization.UNNORMALIZED);
	}

	/**
	 *  
	Initializes a set of  {@link UnitQuaternion} coordinates from the provided values.
	
	
	
	
	
	
	
	
	

	 * The given values will be normalized to ensure a unit magnitude.
	 * @param w The W coordinate.
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 * @param z The Z coordinate.
	 * @param magnitude 
	On input, an array with one element.  On return, the array is populated with
	
	the magnitude of the original set of coordinates.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be zero.
	
	 * @exception ArithmeticException 
	The magnitude of the provided coordinates must not be infinite.
	
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public UnitQuaternion(double w, double x, double y, double z, double[] magnitude) {
		double[] ref$w_0 = {
			w
		};
		double[] ref$x_1 = {
			x
		};
		double[] ref$y_2 = {
			y
		};
		double[] ref$z_3 = {
			z
		};
		normalizeCoordinates(ref$w_0, ref$x_1, ref$y_2, ref$z_3, magnitude);
		z = ref$z_3[0];
		y = ref$y_2[0];
		x = ref$x_1[0];
		w = ref$w_0[0];
		m_w = w;
		m_x = x;
		m_y = y;
		m_z = z;
	}

	/**
	 *  
	Initializes a set of  {@link UnitQuaternion} coordinates from the provided rotation matrix ( {@link Matrix3By3}).
	Note that if the given <code>matrix</code> is not an orthogonal rotation matrix, 
	it will create a non-unit  {@link UnitQuaternion} and could cause problems in code which assumes that the  {@link UnitQuaternion} represents a rotation.
	
	
	
	

	 * For performance reasons, there is no check to ensure that the <code>matrix</code> is a unit rotation prior
	to converting to a unit quaternion.  If necessary, the surrounding code is responsible for ensuring that the given
	<code>matrix</code> is a valid orthogonal rotation matrix.
	 * @param matrix The 3-by-3 rotation matrix.
	 * @return The resulting quaternion.
	 */
	public UnitQuaternion(Matrix3By3 matrix) {
		double factor = matrix.getM11() + matrix.getM22() + matrix.getM33();
		int type = 0;
		if (matrix.getM11() > factor) {
			type = 1;
			factor = matrix.getM11();
		}
		if (matrix.getM22() > factor) {
			type = 2;
			factor = matrix.getM22();
		}
		if (matrix.getM33() > factor) {
			type = 3;
			factor = matrix.getM33();
		}
		if (type == 1) {
			m_x = 0.5 * Math.sqrt(1.0 + matrix.getM11() - matrix.getM22() - matrix.getM33());
			factor = 1.0 / (4.0 * m_x);
			m_w = factor * (matrix.getM23() - matrix.getM32());
			if (m_w < 0) {
				m_w = -m_w;
				m_x = -m_x;
				factor = -factor;
			}
			m_y = factor * (matrix.getM12() + matrix.getM21());
			m_z = factor * (matrix.getM13() + matrix.getM31());
		} else if (type == 2) {
			m_y = 0.5 * Math.sqrt(1.0 - matrix.getM11() + matrix.getM22() - matrix.getM33());
			factor = 1.0 / (4.0 * m_y);
			m_w = factor * (matrix.getM31() - matrix.getM13());
			if (m_w < 0) {
				m_w = -m_w;
				m_y = -m_y;
				factor = -factor;
			}
			m_x = factor * (matrix.getM12() + matrix.getM21());
			m_z = factor * (matrix.getM23() + matrix.getM32());
		} else if (type == 3) {
			m_z = 0.5 * Math.sqrt(1.0 - matrix.getM11() - matrix.getM22() + matrix.getM33());
			factor = 1.0 / (4.0 * m_z);
			m_w = factor * (matrix.getM12() - matrix.getM21());
			if (m_w < 0) {
				m_w = -m_w;
				m_z = -m_z;
				factor = -factor;
			}
			m_x = factor * (matrix.getM13() + matrix.getM31());
			m_y = factor * (matrix.getM23() + matrix.getM32());
		} else {
			m_w = 0.5 * Math.sqrt(1.0 + factor);
			factor = 1.0 / (4.0 * m_w);
			m_x = factor * (matrix.getM23() - matrix.getM32());
			m_y = factor * (matrix.getM31() - matrix.getM13());
			m_z = factor * (matrix.getM12() - matrix.getM21());
		}
	}

	/**
	 *  Gets the W coordinate.
	

	 */
	public final double getW() {
		return m_w;
	}

	/**
	 *  Gets the X coordinate.
	

	 */
	public final double getX() {
		return m_x;
	}

	/**
	 *  Gets the Y coordinate.
	

	 */
	public final double getY() {
		return m_y;
	}

	/**
	 *  Gets the Z coordinate.
	

	 */
	public final double getZ() {
		return m_z;
	}

	/**
	 *  
	Forms the conjugate of this instance.
	
	

	 * @return A set of  {@link UnitQuaternion} coordinates that represents the conjugate of this instance.
	 */
	public final UnitQuaternion conjugate() {
		return new UnitQuaternion(m_w, -m_x, -m_y, -m_z, Normalization.NORMALIZED);
	}

	/**
	 *  
	Multiplies this instance by the specified  {@link UnitQuaternion}, yielding a new  {@link UnitQuaternion}.
	
	
	

	 * @param quaternion The quaternion by which to multiply this quaternion.
	 * @return The result of the multiplication.
	 */
	public final UnitQuaternion multiply(UnitQuaternion quaternion) {
		return new UnitQuaternion(m_w * quaternion.m_w - m_x * quaternion.m_x - m_y * quaternion.m_y - m_z * quaternion.m_z, m_w * quaternion.m_x + m_x * quaternion.m_w - m_y * quaternion.m_z + m_z
				* quaternion.m_y, m_w * quaternion.m_y + m_x * quaternion.m_z + m_y * quaternion.m_w - m_z * quaternion.m_x, m_w * quaternion.m_z - m_x * quaternion.m_y + m_y * quaternion.m_x + m_z
				* quaternion.m_w);
	}

	/**
	 *  
	Multiplies a specified  {@link UnitQuaternion} by another specified  {@link UnitQuaternion}, yielding a new  {@link UnitQuaternion}.
	
	
	
	

	 * @param left The first unit quaternion.
	 * @param right The second unit quaternion.
	 * @return The result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'UnitQuaternion *(UnitQuaternion,UnitQuaternion)'")
	public static UnitQuaternion multiply(UnitQuaternion left, UnitQuaternion right) {
		return left.multiply(right);
	}

	/**
	 *  
	Negates the specified  {@link UnitQuaternion}, yielding a new  {@link UnitQuaternion}.
	
	
	

	 * @param coordinates The set of coordinates.
	 * @return The result of negating the elements of the original  {@link UnitQuaternion}.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'UnitQuaternion -(UnitQuaternion)'")
	public static UnitQuaternion negate(UnitQuaternion coordinates) {
		return new UnitQuaternion(-coordinates.m_w, -coordinates.m_x, -coordinates.m_y, -coordinates.m_z, Normalization.NORMALIZED);
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitQuaternion) {
			return equalsType((UnitQuaternion) obj);
		} else {
			return false;
		}
	}

	/**
	 *  
	Indicates whether each coordinate value of another instance of this type
	is within the required tolerance of the corresponding coordinate value of this instance.
	
	
	
	

	 * @param other The set of  {@link UnitQuaternion} coordinates to compare to this instance.
	 * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
	 * @return 
	<see langword="true" /> if the absolute differences are less than <code>epsilon</code>; otherwise, <see langword="false" />.
	
	 */
	public final boolean equalsEpsilon(UnitQuaternion other, double epsilon) {
		return Math.abs(getW() - other.getW()) < epsilon && Math.abs(getX() - other.getX()) < epsilon && Math.abs(getY() - other.getY()) < epsilon && Math.abs(getZ() - other.getZ()) < epsilon;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return DoubleHelper.hashCode(m_w) ^ DoubleHelper.hashCode(m_x) ^ DoubleHelper.hashCode(m_y) ^ DoubleHelper.hashCode(m_z);
	}

	/**
	 *  
	Returns the string representation of the value of this instance.
	
	

	 * @return 
	A string that represents the value of this instance in the form
	"W, X, Y, Z".
	
	 */
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder(80);
		build.append(DoubleHelper.toString(m_w, CultureInfoHelper.getCurrentCulture()));
		build.append(", ");
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(UnitQuaternion,UnitQuaternion)'")
	public static boolean equals(UnitQuaternion left, UnitQuaternion right) {
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(UnitQuaternion,UnitQuaternion)'")
	public static boolean notEquals(UnitQuaternion left, UnitQuaternion right) {
		return !left.equalsType(right);
	}

	/**
	 *  Gets whether or not any of the coordinates for this instance have the value  {@link Double#NaN}.
	

	 */
	public final boolean getIsUndefined() {
		return Double.isNaN(m_w) || Double.isNaN(m_x) || Double.isNaN(m_y) || Double.isNaN(m_z);
	}

	private UnitQuaternion(double w, double x, double y, double z, Normalization normalization) {
		if (normalization == Normalization.NORMALIZED) {
			m_w = w;
			m_x = x;
			m_y = y;
			m_z = z;
		} else {
			double magnitude = 0D;
			double[] ref$w_4 = {
				w
			};
			double[] ref$x_5 = {
				x
			};
			double[] ref$y_6 = {
				y
			};
			double[] ref$z_7 = {
				z
			};
			double[] out$magnitude_8 = {
				0D
			};
			normalizeCoordinates(ref$w_4, ref$x_5, ref$y_6, ref$z_7, out$magnitude_8);
			magnitude = out$magnitude_8[0];
			z = ref$z_7[0];
			y = ref$y_6[0];
			x = ref$x_5[0];
			w = ref$w_4[0];
			m_w = w;
			m_x = x;
			m_y = y;
			m_z = z;
		}
	}

	static private void normalizeCoordinates(double[] w, double[] x, double[] y, double[] z, double[] magnitude) {
		magnitude[0] = Math.sqrt(w[0] * w[0] + x[0] * x[0] + y[0] * y[0] + z[0] * z[0]);
		if (magnitude[0] == 0.0) {
			throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeZero());
		} else if (Double.isInfinite(magnitude[0])) {
			throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeInfinite());
		} else {
			w[0] /= magnitude[0];
			x[0] /= magnitude[0];
			y[0] /= magnitude[0];
			z[0] /= magnitude[0];
		}
	}

	private double m_w;
	private double m_x;
	private double m_y;
	private double m_z;
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	private static int s_length = 4;
	private static UnitQuaternion s_identity = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);
	private static UnitQuaternion s_undefined = new UnitQuaternion(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Normalization.NORMALIZED);

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
	public final boolean equalsType(UnitQuaternion other) {
		return other.getW() == getW() && other.getX() == getX() && other.getY() == getY() && other.getZ() == getZ();
	}

	/**
	 *  Gets the number of elements in this set of coordinates.
	

	 */
	public final int getLength() {
		return s_length;
	}

	/**
	 *  Gets the value of the specified element with <code>index</code> of 0, 1, 2, and 3 corresponding to the coordinates
	W, X, Y, and Z.
	
	
	
	

	 * @param index Either 0, 1, 2, or 3 corresponding to the coordinates W, X, Y, or Z.
	 * @return The coordinate associated with the specified <code>index</code>.
	 * @exception ArgumentOutOfRangeException 
	Thrown when <code>index</code> is less than 0 or is greater than or equal to the <code>Length</code> ({@link #getLength get}).
	
	 */
	public final double get(int index) {
		switch (index) {
		case 0: {
			return getW();
		}
		case 1: {
			return getX();
		}
		case 2: {
			return getY();
		}
		case 3: {
			return getZ();
		}
		default: {
			throw new ArgumentOutOfRangeException("index");
		}
		}
	}
}