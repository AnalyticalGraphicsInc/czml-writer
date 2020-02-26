using System;
using System.Diagnostics.CodeAnalysis;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A 3-by-3 matrix. This type is often used to represent a rotation. This
    /// represents an 'alias' rotation which transforms coordinates by modifying the underlying coordinate
    /// basis rather than modifying the coordinates themselves.
    /// </summary>
    /// <seealso cref="UnitQuaternion"/>
    [CSToJavaImmutableValueType]
    public struct Matrix3By3 : IEquatable<Matrix3By3>
    {
        /// <summary>
        /// Initializes a new instance from a <see cref="UnitQuaternion"/>.
        /// </summary>
        /// <param name="quaternion">The quaternion.</param>
        public Matrix3By3(UnitQuaternion quaternion)
        {
            double x2 = quaternion.X * quaternion.X;
            double xy = quaternion.X * quaternion.Y;
            double xz = quaternion.X * quaternion.Z;
            double xw = quaternion.X * quaternion.W;
            double y2 = quaternion.Y * quaternion.Y;
            double yz = quaternion.Y * quaternion.Z;
            double yw = quaternion.Y * quaternion.W;
            double z2 = quaternion.Z * quaternion.Z;
            double zw = quaternion.Z * quaternion.W;
            double w2 = quaternion.W * quaternion.W;

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

        /// <summary>
        /// Initializes a new instance from elements.
        /// </summary>
        /// <param name="m11">1,1</param>
        /// <param name="m12">1,2</param>
        /// <param name="m13">1,3</param>
        /// <param name="m21">2,1</param>
        /// <param name="m22">2,2</param>
        /// <param name="m23">2,3</param>
        /// <param name="m31">3,1</param>
        /// <param name="m32">3,2</param>
        /// <param name="m33">3,3</param>
        public Matrix3By3(double m11, double m12, double m13,
                          double m21, double m22, double m23,
                          double m31, double m32, double m33)
        {
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
        /// <summary>
        /// Gets a <see cref="Matrix3By3"/> representing an identity transformation.
        /// </summary>
        /// <returns>The 3-by-3 identity matrix.</returns>
        public static Matrix3By3 Identity
        {
            get { return s_identity; }
        }

        /// <summary>
        /// Gets a <see cref="Matrix3By3"/> with elements of <see cref="double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="IsUndefined"/> to test whether a <see cref="Matrix3By3"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the element values
        /// are <see cref="double.NaN"/>.
        /// </remarks>
        public static Matrix3By3 Undefined
        {
            get { return s_undefined; }
        }

        /// <summary>
        /// Gets a <see cref="Matrix3By3"/> representing the zero matrix.
        /// </summary>
        /// <returns>The 3-by-3 zero matrix.</returns>
        public static Matrix3By3 Zero
        {
            get { return s_zero; }
        }

        /// <summary>
        /// Forms a diagonal matrix from the input elements.
        /// </summary>
        /// <param name="m11">1,1</param>
        /// <param name="m22">2,2</param>
        /// <param name="m33">3,3</param>
        /// <returns>The diagonal matrix.</returns>
        public static Matrix3By3 DiagonalMatrix(double m11, double m22, double m33)
        {
            return new Matrix3By3(m11, 0.0, 0.0, 0.0, m22, 0.0, 0.0, 0.0, m33);
        }

        /// <summary>
        /// Forms a diagonal matrix from the input vector.
        /// </summary>
        /// <param name="vector">The vector.</param>
        /// <returns>The diagonal matrix</returns>
        public static Matrix3By3 DiagonalMatrix(Cartesian vector)
        {
            return DiagonalMatrix(vector.X, vector.Y, vector.Z);
        }

        /// <summary>
        /// Forms a diagonal matrix from the input unit vector.
        /// </summary>
        /// <param name="vector">The vector.</param>
        /// <returns>The diagonal matrix.</returns>
        public static Matrix3By3 DiagonalMatrix(UnitCartesian vector)
        {
            return DiagonalMatrix(vector.X, vector.Y, vector.Z);
        }

        /// <summary>
        /// Accesses the matrix elements using zero-based indexing.
        /// </summary>
        /// <param name="row">The row index.</param>
        /// <param name="column">The column index.</param>
        /// <returns>The value corresponding to the indicated element of the matrix.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when either <paramref name="row"/> or <paramref name="column"/> is less than 0 or greater than 2.
        /// </exception>
        [SuppressMessage("Microsoft.Design", "CA1023:IndexersShouldNotBeMultidimensional")]
        public double this[int row, int column]
        {
            get
            {
                switch (row)
                {
                    case 0:
                        switch (column)
                        {
                            case 0:
                                return m_m11;
                            case 1:
                                return m_m12;
                            case 2:
                                return m_m13;
                            default:
                                throw new ArgumentOutOfRangeException("column");
                        }
                    case 1:
                        switch (column)
                        {
                            case 0:
                                return m_m21;
                            case 1:
                                return m_m22;
                            case 2:
                                return m_m23;
                            default:
                                throw new ArgumentOutOfRangeException("column");
                        }
                    case 2:
                        switch (column)
                        {
                            case 0:
                                return m_m31;
                            case 1:
                                return m_m32;
                            case 2:
                                return m_m33;
                            default:
                                throw new ArgumentOutOfRangeException("column");
                        }
                    default:
                        throw new ArgumentOutOfRangeException("row");
                }
            }
        }

        /// <summary>
        /// Gets the element in the first row, first column.
        /// </summary>
        public double M11
        {
            get { return m_m11; }
        }

        /// <summary>
        /// Gets the element in the first row, second column.
        /// </summary>
        public double M12
        {
            get { return m_m12; }
        }

        /// <summary>
        /// Gets the element in the first row, third column.
        /// </summary>
        public double M13
        {
            get { return m_m13; }
        }

        /// <summary>
        /// Gets the element in the second row, first column.
        /// </summary>
        public double M21
        {
            get { return m_m21; }
        }

        /// <summary>
        /// Gets the element in the second row, second column.
        /// </summary>
        public double M22
        {
            get { return m_m22; }
        }

        /// <summary>
        /// Gets the element in the second row, third column.
        /// </summary>
        public double M23
        {
            get { return m_m23; }
        }

        /// <summary>
        /// Gets the element in the third row, first column.
        /// </summary>
        public double M31
        {
            get { return m_m31; }
        }

        /// <summary>
        /// Gets the element in the third row, second column.
        /// </summary>
        public double M32
        {
            get { return m_m32; }
        }

        /// <summary>
        /// Gets the element in the third row, third column.
        /// </summary>
        public double M33
        {
            get { return m_m33; }
        }

        /// <summary>
        /// Transposes the matrix.
        /// </summary>
        /// <returns>The transposed matrix.</returns>
        [Pure]
        public Matrix3By3 Transpose()
        {
            return new Matrix3By3(m_m11, m_m21, m_m31,
                                  m_m12, m_m22, m_m32,
                                  m_m13, m_m23, m_m33);
        }

        /// <summary>
        /// Gets a value indicating whether any of the matrix values are <see cref="double.NaN"/>.
        /// </summary>
        public bool IsUndefined
        {
            get
            {
                return double.IsNaN(m_m11) || double.IsNaN(m_m12) || double.IsNaN(m_m13) ||
                       double.IsNaN(m_m21) || double.IsNaN(m_m22) || double.IsNaN(m_m23) ||
                       double.IsNaN(m_m31) || double.IsNaN(m_m32) || double.IsNaN(m_m33);
            }
        }

        /// <summary>
        /// Adds a matrix to this matrix.
        /// </summary>
        /// <param name="matrix">The matrix.</param>
        /// <returns>The sum of the matrices.</returns>
        [Pure]
        public Matrix3By3 Add(Matrix3By3 matrix)
        {
            return new Matrix3By3(m_m11 + matrix.m_m11, m_m12 + matrix.m_m12, m_m13 + matrix.m_m13,
                                  m_m21 + matrix.m_m21, m_m22 + matrix.m_m22, m_m23 + matrix.m_m23,
                                  m_m31 + matrix.m_m31, m_m32 + matrix.m_m32, m_m33 + matrix.m_m33);
        }

        /// <summary>
        /// Subtracts a matrix from this matrix.
        /// </summary>
        /// <param name="matrix">The matrix to subtract.</param>
        /// <returns>The result of the subtraction.</returns>
        [Pure]
        public Matrix3By3 Subtract(Matrix3By3 matrix)
        {
            return new Matrix3By3(m_m11 - matrix.m_m11, m_m12 - matrix.m_m12, m_m13 - matrix.m_m13,
                                  m_m21 - matrix.m_m21, m_m22 - matrix.m_m22, m_m23 - matrix.m_m23,
                                  m_m31 - matrix.m_m31, m_m32 - matrix.m_m32, m_m33 - matrix.m_m33);
        }

        /// <summary>
        /// Multiplies this matrix by a scalar.
        /// </summary>
        /// <param name="scalar">The scalar to multiply by.</param>
        /// <returns>The result of the multiplication.</returns>
        [Pure]
        public Matrix3By3 Multiply(double scalar)
        {
            return new Matrix3By3(m_m11 * scalar, m_m12 * scalar, m_m13 * scalar,
                                  m_m21 * scalar, m_m22 * scalar, m_m23 * scalar,
                                  m_m31 * scalar, m_m32 * scalar, m_m33 * scalar);
        }

        /// <summary>
        /// Multiplies this matrix by a matrix.
        /// </summary>
        /// <param name="matrix">The matrix to multiply by.</param>
        /// <returns>The result of the multiplication.</returns>
        [Pure]
        public Matrix3By3 Multiply(Matrix3By3 matrix)
        {
            return new Matrix3By3(m_m11 * matrix.m_m11 + m_m12 * matrix.m_m21 + m_m13 * matrix.m_m31,
                                  m_m11 * matrix.m_m12 + m_m12 * matrix.m_m22 + m_m13 * matrix.m_m32,
                                  m_m11 * matrix.m_m13 + m_m12 * matrix.m_m23 + m_m13 * matrix.m_m33,
                                  m_m21 * matrix.m_m11 + m_m22 * matrix.m_m21 + m_m23 * matrix.m_m31,
                                  m_m21 * matrix.m_m12 + m_m22 * matrix.m_m22 + m_m23 * matrix.m_m32,
                                  m_m21 * matrix.m_m13 + m_m22 * matrix.m_m23 + m_m23 * matrix.m_m33,
                                  m_m31 * matrix.m_m11 + m_m32 * matrix.m_m21 + m_m33 * matrix.m_m31,
                                  m_m31 * matrix.m_m12 + m_m32 * matrix.m_m22 + m_m33 * matrix.m_m32,
                                  m_m31 * matrix.m_m13 + m_m32 * matrix.m_m23 + m_m33 * matrix.m_m33);
        }

        /// <summary>
        /// Forms a new Cartesian vector as the product of this 3-by-3 matrix and the provided Cartesian vector.
        /// </summary>
        /// <param name="vector">The vector.</param>
        /// <returns>The resulting Cartesian vector.</returns>
        [Pure]
        public Cartesian Multiply(Cartesian vector)
        {
            return new Cartesian(m_m11 * vector.X + m_m12 * vector.Y + m_m13 * vector.Z,
                                 m_m21 * vector.X + m_m22 * vector.Y + m_m23 * vector.Z,
                                 m_m31 * vector.X + m_m32 * vector.Y + m_m33 * vector.Z);
        }

        /// <summary>
        /// Multiplies a matrix by a scalar.
        /// </summary>
        /// <param name="matrix">The matrix.</param>
        /// <param name="scalar">The scalar.</param>
        /// <returns>The result of the multiplication.</returns>
        public static Matrix3By3 operator *(Matrix3By3 matrix, double scalar)
        {
            return matrix.Multiply(scalar);
        }

        /// <summary>
        /// Multiplies a scalar by a matrix.
        /// </summary>
        /// <param name="scalar">The scalar.</param>
        /// <param name="matrix">The matrix.</param>
        /// <returns>The result of the multiplication.</returns>
        public static Matrix3By3 operator *(double scalar, Matrix3By3 matrix)
        {
            return matrix.Multiply(scalar);
        }

        /// <summary>
        /// Multiplies the left matrix by the right matrix.
        /// </summary>
        /// <param name="left">The matrix on the left.</param>
        /// <param name="right">The matrix on the right.</param>
        /// <returns>The result of the multiplication.</returns>
        public static Matrix3By3 operator *(Matrix3By3 left, Matrix3By3 right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Multiplies the 3-by-3 matrix by the Cartesian vector.
        /// </summary>
        /// <param name="matrix">The matrix.</param>
        /// <param name="vector">The vector.</param>
        /// <returns>The result of the multiplication.</returns>
        public static Cartesian operator *(Matrix3By3 matrix, Cartesian vector)
        {
            return matrix.Multiply(vector);
        }

        /// <summary>
        /// Adds a matrix to this matrix.
        /// </summary>
        /// <param name="left">The left matrix.</param>
        /// <param name="right">The right matrix.</param>
        /// <returns>The sum of the matrices.</returns>
        public static Matrix3By3 operator +(Matrix3By3 left, Matrix3By3 right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Subtracts the second matrix from the first.
        /// </summary>
        /// <param name="left">The left matrix.</param>
        /// <param name="right">The right matrix.</param>
        /// <returns>The result of subtracting the second matrix from the first.</returns>
        public static Matrix3By3 operator -(Matrix3By3 left, Matrix3By3 right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is Matrix3By3 && Equals((Matrix3By3)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        [SuppressMessage("ReSharper", "CompareOfFloatsByEqualityOperator")]
        public bool Equals(Matrix3By3 other)
        {
            return m_m11 == other.m_m11 && m_m12 == other.m_m12 && m_m13 == other.m_m13 &&
                   m_m21 == other.m_m21 && m_m22 == other.m_m22 && m_m23 == other.m_m23 &&
                   m_m31 == other.m_m31 && m_m32 == other.m_m32 && m_m33 == other.m_m33;
        }

        /// <summary>
        /// Returns true if all of the elements of this matrix are within <paramref name="epsilon"/>
        /// of the same elements of the specified matrix.  That is, in order for the matrices to be
        /// considered equal (and for this function to return true), the absolute value of the
        /// difference between each of their elements must be less than or equal to <paramref name="epsilon"/>.
        /// </summary>
        /// <param name="other">The <see cref="Matrix3By3"/> to compare to this matrix.</param>
        /// <param name="epsilon">The largest difference between the elements of the matrices for which they will be considered equal.</param>
        /// <returns>true if the matrices are equal as defined by the epsilon value.</returns>
        [Pure]
        public bool EqualsEpsilon(Matrix3By3 other, double epsilon)
        {
            return Math.Abs(m_m11 - other.m_m11) <= epsilon &&
                   Math.Abs(m_m12 - other.m_m12) <= epsilon &&
                   Math.Abs(m_m13 - other.m_m13) <= epsilon &&
                   Math.Abs(m_m21 - other.m_m21) <= epsilon &&
                   Math.Abs(m_m22 - other.m_m22) <= epsilon &&
                   Math.Abs(m_m23 - other.m_m23) <= epsilon &&
                   Math.Abs(m_m31 - other.m_m31) <= epsilon &&
                   Math.Abs(m_m32 - other.m_m32) <= epsilon &&
                   Math.Abs(m_m33 - other.m_m33) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_m11.GetHashCode(), m_m12.GetHashCode(), m_m13.GetHashCode(),
                                    m_m21.GetHashCode(), m_m22.GetHashCode(), m_m23.GetHashCode(),
                                    m_m31.GetHashCode(), m_m32.GetHashCode(), m_m33.GetHashCode());
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(Matrix3By3 left, Matrix3By3 right)
        {
            return left.Equals(right);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are not exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> does not represent the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator !=(Matrix3By3 left, Matrix3By3 right)
        {
            return !left.Equals(right);
        }

        private readonly double m_m11;
        private readonly double m_m12;
        private readonly double m_m13;

        private readonly double m_m21;
        private readonly double m_m22;
        private readonly double m_m23;

        private readonly double m_m31;
        private readonly double m_m32;
        private readonly double m_m33;

        private static readonly Matrix3By3 s_identity = new Matrix3By3(1.0, 0.0, 0.0,
                                                                       0.0, 1.0, 0.0,
                                                                       0.0, 0.0, 1.0);

        private static readonly Matrix3By3 s_undefined = new Matrix3By3(double.NaN, double.NaN, double.NaN,
                                                                        double.NaN, double.NaN, double.NaN,
                                                                        double.NaN, double.NaN, double.NaN);

        private static readonly Matrix3By3 s_zero = new Matrix3By3(0.0, 0.0, 0.0,
                                                                   0.0, 0.0, 0.0,
                                                                   0.0, 0.0, 0.0);
    }
}
