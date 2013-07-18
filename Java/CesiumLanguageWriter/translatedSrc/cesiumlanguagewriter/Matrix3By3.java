package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;

/**
 *  
 A 3-by-3 matrix. This type is often used to represent a rotation.
 
 

 * @see UnitQuaternion
 */
@CS2JWarning("Unhandled attribute removed: SuppressMessage")
public class Matrix3By3 implements IEquatable<Matrix3By3>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Matrix3By3() {}

	/**
	 *  Gets a  {@link Matrix3By3} representing an identity transformation.
	
	

	 * @return The 3-by-3 identity matrix.
	 */
	public static Matrix3By3 getIdentity() {
		return s_identity;
	}

	/**
	 *  Gets a  {@link Matrix3By3} with elements of  {@link Double#NaN}.
	
	

	 * 
	Use <code>IsUndefined</code> ({@link Matrix3By3#getIsUndefined get}) to test whether a  {@link Matrix3By3} instance
	is undefined since it will return <see langword="true" /> if any of the element values
	are  {@link Double#NaN}.
	
	 */
	public static Matrix3By3 getUndefined() {
		return s_undefined;
	}

	/**
	 *  Gets a  {@link Matrix3By3} representing the zero matrix.
	
	

	 * @return The 3-by-3 zero matrix.
	 */
	public static Matrix3By3 getZero() {
		return s_zero;
	}

	/**
	 *  
	Forms a  {@link Matrix3By3} from the input vector such that the result of the cross product of the input vector
	with another vector is equivalent to pre-multiplying the other vector by the returned matrix.
	
	
	

	 * @param vector The vector for which the cross product equivalent matrix is desired.
	 * @return The cross product equivalent matrix.
	 */
	public static Matrix3By3 crossProductEquivalentMatrix(Cartesian vector) {
		return new Matrix3By3(0.0, -vector.getZ(), vector.getY(), vector.getZ(), 0.0, -vector.getX(), -vector.getY(), vector.getX(), 0.0);
	}

	/**
	 *  
	Forms a  {@link Matrix3By3} from the input vector such that the result of the cross product of the input unit vector
	with another vector is equivalent to pre-multiplying the other vector by the returned matrix.
	
	
	

	 * @param vector The unit vector for which the cross product equivalent matrix is desired.
	 * @return The cross product equivalent matrix.
	 */
	public static Matrix3By3 crossProductEquivalentMatrix(UnitCartesian vector) {
		return new Matrix3By3(0.0, -vector.getZ(), vector.getY(), vector.getZ(), 0.0, -vector.getX(), -vector.getY(), vector.getX(), 0.0);
	}

	/**
	 *  
	Forms a diagonal matrix from the input elements.
	
	
	
	
	

	 * @param m11 1,1
	 * @param m22 2,2
	 * @param m33 3,3
	 * @return The diagonal matrix.
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static Matrix3By3 diagonalMatrix(double m11, double m22, double m33) {
		return new Matrix3By3(m11, 0.0, 0.0, 0.0, m22, 0.0, 0.0, 0.0, m33);
	}

	/**
	 *  
	Forms a diagonal matrix from the input vector.
	
	
	

	 * @param vector The vector.
	 * @return The diagonal matrix
	 */
	public static Matrix3By3 diagonalMatrix(Cartesian vector) {
		return diagonalMatrix(vector.getX(), vector.getY(), vector.getZ());
	}

	/**
	 *  
	Forms a diagonal matrix from the input unit vector.
	
	
	

	 * @param vector The vector.
	 * @return The diagonal matrix.
	 */
	public static Matrix3By3 diagonalMatrix(UnitCartesian vector) {
		return diagonalMatrix(vector.getX(), vector.getY(), vector.getZ());
	}

	/**
	 *  
	Initializes a new instance from a  {@link UnitQuaternion}.
	
	
	

	 * @param quaternion The quaternion.
	 * @return The resulting 3-by-3 matrix.
	 */
	public Matrix3By3(UnitQuaternion quaternion) {
		double x2 = quaternion.getX() * quaternion.getX();
		double xy = quaternion.getX() * quaternion.getY();
		double xz = quaternion.getX() * quaternion.getZ();
		double xw = quaternion.getX() * quaternion.getW();
		double y2 = quaternion.getY() * quaternion.getY();
		double yz = quaternion.getY() * quaternion.getZ();
		double yw = quaternion.getY() * quaternion.getW();
		double z2 = quaternion.getZ() * quaternion.getZ();
		double zw = quaternion.getZ() * quaternion.getW();
		double w2 = quaternion.getW() * quaternion.getW();
		m_m11 = x2 - y2 - z2 + w2;
		m_m12 = 2.0 * (xy + zw);
		m_m13 = 2.0 * (xz - yw);
		m_m21 = 2.0 * (xy - zw);
		m_m22 = -x2 + y2 - z2 + w2;
		m_m23 = 2.0 * (yz + xw);
		m_m31 = 2.0 * (xz + yw);
		m_m32 = 2.0 * (yz - xw);
		m_m33 = -x2 - y2 + z2 + w2;
	}

	/**
	 *  
	Initializes a new instance from elements.
	
	
	
	
	
	
	
	
	
	

	 * @param m11 1,1
	 * @param m12 1,2
	 * @param m13 1,3
	 * @param m21 2,1
	 * @param m22 2,2
	 * @param m23 2,3
	 * @param m31 3,1
	 * @param m32 3,2
	 * @param m33 3,3
	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public Matrix3By3(double m11, double m12, double m13, double m21, double m22, double m23, double m31, double m32, double m33) {
		m_m11 = m11;
		m_m12 = m12;
		m_m13 = m13;
		m_m21 = m21;
		m_m22 = m22;
		m_m23 = m23;
		m_m31 = m31;
		m_m32 = m32;
		m_m33 = m33;
	}

	/**
	 *  
	Accesses the matrix elements using zero-based indexing.
	
	
	
	
	

	 * @param row The row index.
	 * @param column The column index.
	 * @return The value corresponding to the indicated element of the matrix.
	 * @exception ArgumentOutOfRangeException 
	Thrown when either <code>row</code> or <code>column</code> is less than 0 or greater than 2.
	
	 */
	public final double get(int row, int column) {
		switch (row) {
		case 0: {
			switch (column) {
			case 0: {
				return m_m11;
			}
			case 1: {
				return m_m12;
			}
			case 2: {
				return m_m13;
			}
			default: {
				throw new ArgumentOutOfRangeException("column");
			}
			}
		}
		case 1: {
			switch (column) {
			case 0: {
				return m_m21;
			}
			case 1: {
				return m_m22;
			}
			case 2: {
				return m_m23;
			}
			default: {
				throw new ArgumentOutOfRangeException("column");
			}
			}
		}
		case 2: {
			switch (column) {
			case 0: {
				return m_m31;
			}
			case 1: {
				return m_m32;
			}
			case 2: {
				return m_m33;
			}
			default: {
				throw new ArgumentOutOfRangeException("column");
			}
			}
		}
		default: {
			throw new ArgumentOutOfRangeException("row");
		}
		}
	}

	/**
	 *  Gets the element in the first row, first column.
	

	 */
	public final double getM11() {
		return m_m11;
	}

	/**
	 *  Gets the element in the first row, second column.
	

	 */
	public final double getM12() {
		return m_m12;
	}

	/**
	 *  Gets the element in the first row, third column.
	

	 */
	public final double getM13() {
		return m_m13;
	}

	/**
	 *  Gets the element in the second row, first column.
	

	 */
	public final double getM21() {
		return m_m21;
	}

	/**
	 *  Gets the element in the second row, second column.
	

	 */
	public final double getM22() {
		return m_m22;
	}

	/**
	 *  Gets the element in the second row, third column.
	

	 */
	public final double getM23() {
		return m_m23;
	}

	/**
	 *  Gets the element in the third row, first column.
	

	 */
	public final double getM31() {
		return m_m31;
	}

	/**
	 *  Gets the element in the third row, second column.
	

	 */
	public final double getM32() {
		return m_m32;
	}

	/**
	 *  Gets the element in the third row, third column.
	

	 */
	public final double getM33() {
		return m_m33;
	}

	/**
	 *  
	Transposes the matrix.
	
	

	 * @return The transposed matrix.
	 */
	public final Matrix3By3 transpose() {
		return new Matrix3By3(m_m11, m_m21, m_m31, m_m12, m_m22, m_m32, m_m13, m_m23, m_m33);
	}

	/**
	 *  
	The determinant of the matrix.
	
	

	 * @return The determinant of the matrix.
	 */
	public final double determinant() {
		double determinant = m_m11 * (m_m22 * m_m33 - m_m23 * m_m32) + m_m12 * (m_m23 * m_m31 - m_m21 * m_m33) + m_m13 * (m_m21 * m_m32 - m_m22 * m_m31);
		return determinant;
	}

	/**
	 *  
	Inverts the matrix.
	
	
	

	 * @return The inverted matrix.
	 * @exception ArithmeticException 
	Thrown when the absolute value of the  {@link #determinant} is less than
	{@link Constants#Epsilon15}.
	 */
	public final Matrix3By3 invert() {
		double determinant = determinant();
		if (Math.abs(determinant) > Constants.Epsilon15) {
			Matrix3By3 m = new Matrix3By3(m_m22 * m_m33 - m_m23 * m_m32, m_m13 * m_m32 - m_m12 * m_m33, m_m12 * m_m23 - m_m13 * m_m22, m_m23 * m_m31 - m_m21 * m_m33, m_m11 * m_m33 - m_m13 * m_m31,
					m_m13 * m_m21 - m_m11 * m_m23, m_m21 * m_m32 - m_m22 * m_m31, m_m12 * m_m31 - m_m11 * m_m32, m_m11 * m_m22 - m_m12 * m_m21);
			double scale = 1.0 / determinant;
			return Matrix3By3.multiply(m, scale);
		} else {
			throw new ArithmeticException();
		}
	}

	/**
	 *  Gets an indication as to whether any of the matrix values are  {@link Double#NaN}.
	

	 */
	public final boolean getIsUndefined() {
		return Double.isNaN(m_m11) || Double.isNaN(m_m12) || Double.isNaN(m_m13) || Double.isNaN(m_m21) || Double.isNaN(m_m22) || Double.isNaN(m_m23) || Double.isNaN(m_m31) || Double.isNaN(m_m32)
				|| Double.isNaN(m_m33);
	}

	/**
	 *  
	Adds a matrix to this matrix.
	
	
	

	 * @param matrix The matrix.
	 * @return The sum of the matrices.
	 */
	public final Matrix3By3 add(Matrix3By3 matrix) {
		return new Matrix3By3(m_m11 + matrix.m_m11, m_m12 + matrix.m_m12, m_m13 + matrix.m_m13, m_m21 + matrix.m_m21, m_m22 + matrix.m_m22, m_m23 + matrix.m_m23, m_m31 + matrix.m_m31, m_m32
				+ matrix.m_m32, m_m33 + matrix.m_m33);
	}

	/**
	 *  
	Subtracts a matrix from this matrix.
	
	
	

	 * @param matrix The matrix to subtract.
	 * @return The result of the subtraction.
	 */
	public final Matrix3By3 subtract(Matrix3By3 matrix) {
		return new Matrix3By3(m_m11 - matrix.m_m11, m_m12 - matrix.m_m12, m_m13 - matrix.m_m13, m_m21 - matrix.m_m21, m_m22 - matrix.m_m22, m_m23 - matrix.m_m23, m_m31 - matrix.m_m31, m_m32
				- matrix.m_m32, m_m33 - matrix.m_m33);
	}

	/**
	 *  
	Multiplies this matrix by a scalar.
	
	
	

	 * @param scalar The scalar to multiply by.
	 * @return The result of the multiplication.
	 */
	public final Matrix3By3 multiply(double scalar) {
		return new Matrix3By3(m_m11 * scalar, m_m12 * scalar, m_m13 * scalar, m_m21 * scalar, m_m22 * scalar, m_m23 * scalar, m_m31 * scalar, m_m32 * scalar, m_m33 * scalar);
	}

	/**
	 *  
	Multiplies this matrix by a matrix.
	
	
	

	 * @param matrix The matrix to multiply by.
	 * @return The result of the multiplication.
	 */
	public final Matrix3By3 multiply(Matrix3By3 matrix) {
		return new Matrix3By3(m_m11 * matrix.m_m11 + m_m12 * matrix.m_m21 + m_m13 * matrix.m_m31, m_m11 * matrix.m_m12 + m_m12 * matrix.m_m22 + m_m13 * matrix.m_m32, m_m11 * matrix.m_m13 + m_m12
				* matrix.m_m23 + m_m13 * matrix.m_m33, m_m21 * matrix.m_m11 + m_m22 * matrix.m_m21 + m_m23 * matrix.m_m31, m_m21 * matrix.m_m12 + m_m22 * matrix.m_m22 + m_m23 * matrix.m_m32, m_m21
				* matrix.m_m13 + m_m22 * matrix.m_m23 + m_m23 * matrix.m_m33, m_m31 * matrix.m_m11 + m_m32 * matrix.m_m21 + m_m33 * matrix.m_m31, m_m31 * matrix.m_m12 + m_m32 * matrix.m_m22 + m_m33
				* matrix.m_m32, m_m31 * matrix.m_m13 + m_m32 * matrix.m_m23 + m_m33 * matrix.m_m33);
	}

	/**
	 *  
	Forms a new Cartesian3 vector as the product of this 3-by-3 matrix and the provided Cartesian3 vector.
	
	
	

	 * @param vector The vector.
	 * @return The resulting Cartesian3 vector.
	 */
	public final Cartesian multiply(Cartesian vector) {
		return new Cartesian(m_m11 * vector.getX() + m_m12 * vector.getY() + m_m13 * vector.getZ(), m_m21 * vector.getX() + m_m22 * vector.getY() + m_m23 * vector.getZ(), m_m31 * vector.getX()
				+ m_m32 * vector.getY() + m_m33 * vector.getZ());
	}

	/**
	 *  
	Multiplies a matrix by a scalar.
	
	
	
	

	 * @param matrix The matrix.
	 * @param scalar The scalar.
	 * @return The result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Matrix3By3 *(Matrix3By3,System.Double)'")
	public static Matrix3By3 multiply(Matrix3By3 matrix, double scalar) {
		return matrix.multiply(scalar);
	}

	/**
	 *  
	Multiplies a scalar by a matrix.
	
	
	
	

	 * @param scalar The scalar.
	 * @param matrix The matrix.
	 * @return The result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Matrix3By3 *(System.Double,Matrix3By3)'")
	public static Matrix3By3 multiply(double scalar, Matrix3By3 matrix) {
		return matrix.multiply(scalar);
	}

	/**
	 *  
	Multiplies the left matrix by the right matrix.
	
	
	
	

	 * @param left The matrix on the left.
	 * @param right The matrix on the right.
	 * @return The result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Matrix3By3 *(Matrix3By3,Matrix3By3)'")
	public static Matrix3By3 multiply(Matrix3By3 left, Matrix3By3 right) {
		return left.multiply(right);
	}

	/**
	 *  
	Multiplies the 3-by-3 matrix by the Cartesian3 vector.
	
	
	
	

	 * @param matrix The matrix.
	 * @param vector The vector.
	 * @return The result of the multiplication.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian *(Matrix3By3,Cartesian)'")
	public static Cartesian multiply(Matrix3By3 matrix, Cartesian vector) {
		return matrix.multiply(vector);
	}

	/**
	 *  
	Adds a matrix to this matrix.
	
	
	
	

	 * @param left The left matrix.
	 * @param right The right matrix.
	 * @return The sum of the matrices.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Matrix3By3 +(Matrix3By3,Matrix3By3)'")
	public static Matrix3By3 add(Matrix3By3 left, Matrix3By3 right) {
		return left.add(right);
	}

	/**
	 *  
	Subtracts the second matrix from the first.
	
	
	
	

	 * @param left The left matrix.
	 * @param right The right matrix.
	 * @return The result of subtracting the second matrix from the first.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Matrix3By3 -(Matrix3By3,Matrix3By3)'")
	public static Matrix3By3 subtract(Matrix3By3 left, Matrix3By3 right) {
		return left.subtract(right);
	}

	/**
	 *  
	Returns true if all of the elements of this matrix are within <code>epsilon</code>
	of the same elements of the specified matrix.  That is, in order for the matrices to be
	considered equal (and for this function to return true), the absolute value of the
	difference between each of their elements must be less than <code>epsilon</code>.
	
	
	
	

	 * @param other The  {@link Matrix3By3} to compare to this matrix.
	 * @param epsilon The smallest difference between the elements of the matrices for which they will NOT be considered equal.
	 * @return true if the matrices are equal as defined by the epsilon value.
	 */
	public final boolean equalsEpsilon(Matrix3By3 other, double epsilon) {
		return Math.abs(getM11() - other.getM11()) < epsilon && Math.abs(getM12() - other.getM12()) < epsilon && Math.abs(getM13() - other.getM13()) < epsilon
				&& Math.abs(getM21() - other.getM21()) < epsilon && Math.abs(getM22() - other.getM22()) < epsilon && Math.abs(getM23() - other.getM23()) < epsilon
				&& Math.abs(getM31() - other.getM31()) < epsilon && Math.abs(getM32() - other.getM32()) < epsilon && Math.abs(getM33() - other.getM33()) < epsilon;
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Matrix3By3) {
			return equalsType((Matrix3By3) obj);
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
		return DoubleHelper.hashCode(m_m11) ^ DoubleHelper.hashCode(m_m12) ^ DoubleHelper.hashCode(m_m13) ^ DoubleHelper.hashCode(m_m21) ^ DoubleHelper.hashCode(m_m22) ^ DoubleHelper.hashCode(m_m23)
				^ DoubleHelper.hashCode(m_m31) ^ DoubleHelper.hashCode(m_m32) ^ DoubleHelper.hashCode(m_m33);
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are exactly equal.
	
	
	
	

	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> represents the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Matrix3By3,Matrix3By3)'")
	public static boolean equals(Matrix3By3 left, Matrix3By3 right) {
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
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Matrix3By3,Matrix3By3)'")
	public static boolean notEquals(Matrix3By3 left, Matrix3By3 right) {
		return !left.equalsType(right);
	}

	private double m_m11;
	private double m_m12;
	private double m_m13;
	private double m_m21;
	private double m_m22;
	private double m_m23;
	private double m_m31;
	private double m_m32;
	private double m_m33;
	private static Matrix3By3 s_identity = new Matrix3By3(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0);
	private static Matrix3By3 s_undefined = new Matrix3By3(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN);
	private static Matrix3By3 s_zero = new Matrix3By3(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(Matrix3By3 other) {
		return other.getM11() == getM11() && other.getM12() == getM12() && other.getM13() == getM13() && other.getM21() == getM21() && other.getM22() == getM22() && other.getM23() == getM23()
				&& other.getM31() == getM31() && other.getM32() == getM32() && other.getM33() == getM33();
	}
}