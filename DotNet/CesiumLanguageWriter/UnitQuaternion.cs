using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.Text;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of 4-dimensional coordinates used to represent rotation in 3-dimensional space.
    /// </summary>
    /// <remarks>
    /// To transform a <see cref="Cartesian"/> with this rotation, see <see cref="Cartesian.Rotate(UnitQuaternion)"/>.
    /// </remarks>
    /// <seealso cref="Matrix3By3"/>
    [CSToJavaImmutableValueType]
    public struct UnitQuaternion : IEquatable<UnitQuaternion>
    {
        /// <summary>
        /// Gets a set of <see cref="UnitQuaternion"/> coordinates with values of <see cref="Double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="UnitQuaternion.IsUndefined"/> to test whether a <see cref="UnitQuaternion"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the coordinate values
        /// are <see cref="Double.NaN"/>.
        /// </remarks>
        public static UnitQuaternion Undefined
        {
            get { return s_undefined; }
        }

        /// <summary>
        /// Gets a set of <see cref="UnitQuaternion"/> coordinates representing the identity vector.
        /// </summary>
        public static UnitQuaternion Identity
        {
            get { return s_identity; }
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitQuaternion"/> coordinates from the provided values.
        /// </summary>
        /// <param name="w">The W coordinate.</param>
        /// <param name="x">The X coordinate.</param>
        /// <param name="y">The Y coordinate.</param>
        /// <param name="z">The Z coordinate.</param>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        /// <remarks>The given values will be normalized to ensure a unit magnitude.</remarks>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "w")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "3#z")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "2#y")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#x")]
        public UnitQuaternion(double w, double x, double y, double z)
            : this(w, x, y, z, Normalization.Unnormalized)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitQuaternion"/> coordinates from the provided values.
        /// </summary>
        /// <param name="w">The W coordinate.</param>
        /// <param name="x">The X coordinate.</param>
        /// <param name="y">The Y coordinate.</param>
        /// <param name="z">The Z coordinate.</param>
        /// <param name="magnitude">
        /// <filter name="Java">On input, an array with one element.  On return, the array is populated with</filter>
        /// <filter name="DotNet,Silverlight">On return,</filter>
        /// the magnitude of the original set of coordinates.
        /// </param>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        /// <remarks>The given values will be normalized to ensure a unit magnitude.</remarks>
        [SuppressMessage("Microsoft.Design", "CA1021:AvoidOutParameters", MessageId = "4#")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "w")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "3#z")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "2#y")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#x")]
        public UnitQuaternion(double w, double x, double y, double z, out double magnitude)
        {
            NormalizeCoordinates(ref w, ref x, ref y, ref z, out magnitude);
            m_w = w;
            m_x = x;
            m_y = y;
            m_z = z;
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitQuaternion"/> coordinates from the provided rotation matrix (<see cref="Matrix3By3"/>).
        /// Note that if the given <paramref name="matrix"/> is not an orthogonal rotation matrix, 
        /// it will create a non-unit <see cref="UnitQuaternion"/> and could cause problems in code which assumes that the <see cref="UnitQuaternion"/> represents a rotation.
        /// </summary>
        /// <param name="matrix">The 3-by-3 rotation matrix.</param>
        /// <returns>The resulting quaternion.</returns>
        /// <remarks>For performance reasons, there is no check to ensure that the <paramref name="matrix"/> is a unit rotation prior
        /// to converting to a unit quaternion.  If necessary, the surrounding code is responsible for ensuring that the given
        /// <paramref name="matrix"/> is a valid orthogonal rotation matrix.</remarks>
        public UnitQuaternion(Matrix3By3 matrix)
        {
            double factor = matrix.M11 + matrix.M22 + matrix.M33;

            int type = 0;
            if (matrix.M11 > factor)
            {
                type = 1;
                factor = matrix.M11;
            }

            if (matrix.M22 > factor)
            {
                type = 2;
                factor = matrix.M22;
            }

            if (matrix.M33 > factor)
            {
                type = 3;
                factor = matrix.M33;
            }

            if (type == 1)
            {
                m_x = 0.5 * Math.Sqrt(1.0 + matrix.M11 - matrix.M22 - matrix.M33);
                factor = 1.0 / (4.0 * m_x);

                m_w = factor * (matrix.M23 - matrix.M32);

                if (m_w < 0)
                {
                    m_w = -m_w;
                    m_x = -m_x;
                    factor = -factor;
                }

                m_y = factor * (matrix.M12 + matrix.M21);
                m_z = factor * (matrix.M13 + matrix.M31);
            }
            else if (type == 2)
            {
                m_y = 0.5 * Math.Sqrt(1.0 - matrix.M11 + matrix.M22 - matrix.M33);
                factor = 1.0 / (4.0 * m_y);

                m_w = factor * (matrix.M31 - matrix.M13);

                if (m_w < 0)
                {
                    m_w = -m_w;
                    m_y = -m_y;
                    factor = -factor;
                }

                m_x = factor * (matrix.M12 + matrix.M21);
                m_z = factor * (matrix.M23 + matrix.M32);
            }
            else if (type == 3)
            {
                m_z = 0.5 * Math.Sqrt(1.0 - matrix.M11 - matrix.M22 + matrix.M33);
                factor = 1.0 / (4.0 * m_z);

                m_w = factor * (matrix.M12 - matrix.M21);

                if (m_w < 0)
                {
                    m_w = -m_w;
                    m_z = -m_z;
                    factor = -factor;
                }

                m_x = factor * (matrix.M13 + matrix.M31);
                m_y = factor * (matrix.M23 + matrix.M32);
            }
            else
            {
                m_w = 0.5 * Math.Sqrt(1.0 + factor);
                factor = 1.0 / (4.0 * m_w);

                m_x = factor * (matrix.M23 - matrix.M32);
                m_y = factor * (matrix.M31 - matrix.M13);
                m_z = factor * (matrix.M12 - matrix.M21);
            }
        }

        /// <summary>
        /// Gets the W coordinate.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "W")]
        public double W
        {
            get { return m_w; }
        }

        /// <summary>
        /// Gets the X coordinate.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "X")]
        public double X
        {
            get { return m_x; }
        }

        /// <summary>
        /// Gets the Y coordinate.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Y")]
        public double Y
        {
            get { return m_y; }
        }

        /// <summary>
        /// Gets the Z coordinate.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Z")]
        public double Z
        {
            get { return m_z; }
        }

        /// <summary>
        /// Forms the conjugate of this instance.
        /// </summary>
        /// <returns>A set of <see cref="UnitQuaternion"/> coordinates that represents the conjugate of this instance.</returns>
        public UnitQuaternion Conjugate()
        {
            return new UnitQuaternion(m_w, -m_x, -m_y, -m_z, Normalization.Normalized);
        }

        /// <summary>
        /// Multiplies this instance by the specified <see cref="UnitQuaternion"/>, yielding a new <see cref="UnitQuaternion"/>.
        /// </summary>
        /// <param name="quaternion">The quaternion by which to multiply this quaternion.</param>
        /// <returns>The result of the multiplication.</returns>
        public UnitQuaternion Multiply(UnitQuaternion quaternion)
        {
            return new UnitQuaternion(m_w * quaternion.m_w - m_x * quaternion.m_x - m_y * quaternion.m_y - m_z * quaternion.m_z,
                                      m_w * quaternion.m_x + m_x * quaternion.m_w - m_y * quaternion.m_z + m_z * quaternion.m_y,
                                      m_w * quaternion.m_y + m_x * quaternion.m_z + m_y * quaternion.m_w - m_z * quaternion.m_x,
                                      m_w * quaternion.m_z - m_x * quaternion.m_y + m_y * quaternion.m_x + m_z * quaternion.m_w);
        }

        /// <summary>
        /// Multiplies a specified <see cref="UnitQuaternion"/> by another specified <see cref="UnitQuaternion"/>, yielding a new <see cref="UnitQuaternion"/>.
        /// </summary>
        /// <param name="left">The first unit quaternion.</param>
        /// <param name="right">The second unit quaternion.</param>
        /// <returns>The result of the multiplication.</returns>
        public static UnitQuaternion operator *(UnitQuaternion left, UnitQuaternion right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Negates the specified <see cref="UnitQuaternion"/>, yielding a new <see cref="UnitQuaternion"/>.
        /// </summary>
        /// <param name="coordinates">The set of coordinates.</param>
        /// <returns>The result of negating the elements of the original <see cref="UnitQuaternion"/>.</returns>
        public static UnitQuaternion operator -(UnitQuaternion coordinates)
        {
            return new UnitQuaternion(-coordinates.m_w, -coordinates.m_x, -coordinates.m_y, -coordinates.m_z, Normalization.Normalized);
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is UnitQuaternion)
            {
                return Equals((UnitQuaternion)obj);
            }
            else
            {
                return false;
            }
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="UnitQuaternion"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(UnitQuaternion other, double epsilon)
        {
            return Math.Abs(W - other.W) < epsilon &&
                   Math.Abs(X - other.X) < epsilon &&
                   Math.Abs(Y - other.Y) < epsilon &&
                   Math.Abs(Z - other.Z) < epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_w.GetHashCode() ^ m_x.GetHashCode() ^ m_y.GetHashCode() ^ m_z.GetHashCode();
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// "W, X, Y, Z".
        /// </returns>
        public override string ToString()
        {
            StringBuilder build = new StringBuilder(80);
            build.Append(m_w.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_x.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_y.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_z.ToString(CultureInfo.CurrentCulture));
            return build.ToString();
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(UnitQuaternion left, UnitQuaternion right)
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
        public static bool operator !=(UnitQuaternion left, UnitQuaternion right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Gets whether or not any of the coordinates for this instance have the value <see cref="Double.NaN"/>.
        /// </summary>
        public bool IsUndefined
        {
            get
            {
                return Double.IsNaN(m_w) || Double.IsNaN(m_x) || Double.IsNaN(m_y) || Double.IsNaN(m_z);
            }
        }

        private UnitQuaternion(double w, double x, double y, double z, Normalization normalization)
        {
            if (normalization == Normalization.Normalized)
            {
                m_w = w;
                m_x = x;
                m_y = y;
                m_z = z;
            }
            else
            {
                double magnitude;
                NormalizeCoordinates(ref w, ref x, ref y, ref z, out magnitude);

                m_w = w;
                m_x = x;
                m_y = y;
                m_z = z;
            }
        }

        private static void NormalizeCoordinates(ref double w, ref double x, ref double y, ref double z, out double magnitude)
        {
            magnitude = Math.Sqrt(w * w + x * x + y * y + z * z);

            if (magnitude == 0.0)
            {
                throw new DivideByZeroException(CesiumLocalization.MagnitudeMustNotBeZero);
            }
            else if (Double.IsInfinity(magnitude))
            {
                throw new NotFiniteNumberException(CesiumLocalization.MagnitudeMustNotBeInfinite);
            }
            else
            {
                w /= magnitude;
                x /= magnitude;
                y /= magnitude;
                z /= magnitude;
            }
        }

        private readonly double m_w;
        private readonly double m_x;
        private readonly double m_y;
        private readonly double m_z;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 4;

        private static readonly UnitQuaternion s_identity = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);

        private static readonly UnitQuaternion s_undefined = new UnitQuaternion(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Normalization.Normalized);

        private enum Normalization
        {
            Unnormalized = 0,
            Normalized = 1
        };

        #region IEquatable<UnitQuaternion> Members

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(UnitQuaternion other)
        {
            return other.W == W && other.X == X && other.Y == Y && other.Z == Z;
        }

        #endregion

        /// <summary>
        /// Gets the number of elements in this set of coordinates.
        /// </summary>
        public int Length
        {
            get { return s_length; }
        }

        /// <summary>
        /// Gets the value of the specified element with <paramref name="index"/> of 0, 1, 2, and 3 corresponding to the coordinates
        /// W, X, Y, and Z.
        /// </summary>
        /// <param name="index">Either 0, 1, 2, or 3 corresponding to the coordinates W, X, Y, or Z.</param>
        /// <returns>The coordinate associated with the specified <paramref name="index"/>.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when <paramref name="index"/> is less than 0 or is greater than or equal to the <see cref="Length"/>.
        /// </exception>
        public double this[int index]
        {
            get
            {
                switch (index)
                {
                    case 0:
                        return W;
                    case 1:
                        return X;
                    case 2:
                        return Y;
                    case 3:
                        return Z;
                    default:
                        throw new ArgumentOutOfRangeException("index");
                }
            }
        }
    }
}