using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.Text;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of rectilinear 3-dimensional coordinates.
    /// </summary>
    /// <remarks>
    /// The corresponding 2-dimensional coordinates are <see cref="Rectangular"/> coordinates.
    /// </remarks>
    [CSToJavaImmutableValueType]
    public struct Cartesian : IEquatable<Cartesian>
    {
        /// <summary>
        /// Gets a set of <see cref="Cartesian"/> coordinates with values of zero.
        /// </summary>
        public static Cartesian Zero
        {
            get
            {
                return s_zero;
            }
        }

        /// <summary>
        /// Gets a set of <see cref="Cartesian"/> coordinates with values of <see cref="Double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="Cartesian.IsUndefined"/> to test whether a <see cref="Cartesian"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the coordinate values
        /// are <see cref="Double.NaN"/>.
        /// </remarks>
        public static Cartesian Undefined
        {
            get
            {
                return s_undefined;
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian"/> coordinates from 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <param name="startIndex">The index of the first element in the array to use.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the array of <paramref name="elements"/> is <see langword="null"/>.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when an object of this type is constructed from an array with less than 3 <paramref name="elements"/>.
        /// </exception>
        public Cartesian(double[] elements, int startIndex)
        {
            if (elements == null)
            {
                throw new ArgumentNullException("elements");
            }
            else if (startIndex >= elements.Length ||
                     elements.Length - startIndex < s_length)
            {
                throw new ArgumentOutOfRangeException("elements", String.Format(CultureInfo.CurrentCulture, CesiumLocalization.MustBeConstructedFromSpecificNumberOfElements, typeof(Cartesian), 3));
            }
            else
            {
                m_x = elements[startIndex + 0];
                m_y = elements[startIndex + 1];
                m_z = elements[startIndex + 2];
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian"/> coordinates from the first 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <exception cref="ArgumentNullException">
        /// The array of <paramref name="elements"/> cannot be null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// An object of this type must be constructed from an array with at least 3 <paramref name="elements"/>.
        /// </exception>
        public Cartesian(double[] elements)
            : this(elements, 0)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian"/> coordinates from the provided values.
        /// </summary>
        /// <param name="x">The linear coordinate along the positive x-axis.</param>
        /// <param name="y">The linear coordinate along the positive y-axis.</param>
        /// <param name="z">The linear coordinate along the positive z-axis.</param>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "2#z")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#y")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "0#x")]
        public Cartesian(double x, double y, double z)
        {
            m_x = x;
            m_y = y;
            m_z = z;
        }

        /// <summary>
        /// Gets the linear coordinate along the positive x-axis.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "X")]
        public double X
        {
            get { return m_x; }
        }

        /// <summary>
        /// Gets the linear coordinate along the positive y-axis.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Y")]
        public double Y
        {
            get { return m_y; }
        }

        /// <summary>
        /// Gets the linear coordinate along the positive z-axis.
        /// </summary>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Z")]
        public double Z
        {
            get { return m_z; }
        }

        /// <summary>
        /// Gets the <see cref="UnitCartesian"/> of the axis most orthogonal to this Cartesian.
        /// </summary>
        public UnitCartesian MostOrthogonalAxis
        {
            get
            {
                double x = Math.Abs(m_x);
                double y = Math.Abs(m_y);
                double z = Math.Abs(m_z);

                if (x <= y)
                {
                    return ((x <= z) ? UnitCartesian.UnitX : UnitCartesian.UnitZ);
                }
                else
                {
                    return ((y <= z) ? UnitCartesian.UnitY : UnitCartesian.UnitZ);
                }
            }
        }

        /// <summary>
        /// Inverts this instance.
        /// </summary>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the inverse of this instance.</returns>
        public Cartesian Invert()
        {
            return new Cartesian(-m_x, -m_y, -m_z);
        }

        /// <summary>
        /// Multiplies this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The multiplier, or value which is to multiply this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the multiplication.</returns>
        public Cartesian Multiply(double scalar)
        {
            return new Cartesian(m_x * scalar, m_y * scalar, m_z * scalar);
        }

        /// <summary>
        /// Divides this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The divisor, or value which is to divide this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the division.</returns>
        public Cartesian Divide(double scalar)
        {
            return new Cartesian(m_x / scalar, m_y / scalar, m_z / scalar);
        }

        /// <summary>
        /// Adds the specified set of <see cref="Cartesian"/> coordinates to this instance.
        /// </summary>
        /// <param name="other">The addend, or value which is to be added to this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the addition.</returns>
        public Cartesian Add(Cartesian other)
        {
            return new Cartesian(m_x + other.m_x, m_y + other.m_y, m_z + other.m_z);
        }

        /// <summary>
        /// Subtracts the specified set of <see cref="Cartesian"/> coordinates from this instance.
        /// </summary>
        /// <param name="other">The subtrahend, or value which is to be subtracted from this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the subtraction.</returns>
        public Cartesian Subtract(Cartesian other)
        {
            return new Cartesian(m_x - other.m_x, m_y - other.m_y, m_z - other.m_z);
        }

        /// <summary>
        /// Forms the cross product of the specified set of <see cref="Cartesian"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian"/> coordinates to cross with this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the product.</returns>
        public Cartesian Cross(Cartesian other)
        {
            return new Cartesian(m_y * other.m_z - m_z * other.m_y, m_z * other.m_x - m_x * other.m_z, m_x * other.m_y - m_y * other.m_x);
        }

        /// <summary>
        /// Forms the dot product of the specified set of <see cref="Cartesian"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian"/> coordinates to dot with this instance.</param>
        /// <returns>A <see cref="double"/> that represents the result of the product.</returns>
        public double Dot(Cartesian other)
        {
            return m_x * other.m_x + m_y * other.m_y + m_z * other.m_z;
        }

        /// <summary>
        /// Multiplies a specified set of <see cref="Cartesian"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian operator *(Cartesian left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Multiplies a scalar by a specified set of set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian operator *(double left, Cartesian right)
        {
            return right.Multiply(left);
        }

        /// <summary>
        /// Divides a specified set of <see cref="Cartesian"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The dividend, or value which is to be divided by <paramref name="right"/>.</param>
        /// <param name="right">The divisor, or value which is to divide <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the division.</returns>
        public static Cartesian operator /(Cartesian left, double right)
        {
            return left.Divide(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="Cartesian"/> coordinates to another specified set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian operator +(Cartesian left, Cartesian right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="Cartesian"/> coordinates from another specified set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian operator -(Cartesian left, Cartesian right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Negates the specified set of <see cref="Cartesian"/> coordinates, yielding a new set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of coordinates.</param>
        /// <returns>The result of negating the elements of the original set of <see cref="Cartesian"/> coordinates.</returns>
        public static Cartesian operator -(Cartesian coordinates)
        {
            return new Cartesian(-coordinates.m_x, -coordinates.m_y, -coordinates.m_z);
        }

        /// <summary>
        /// Performs a component-wise greater than check.
        /// </summary>
        /// <param name="other">The <see cref="Cartesian"/> to compare against.</param>
        /// <returns><see langword="true"/> if all components of this Cartesian are greater than all components of <paramref name="other"/></returns>
        public bool AllComponentsAreGreaterThan(Cartesian other)
        {
            return (m_x > other.X) && (m_y > other.Y) && (m_z > other.Z);
        }

        /// <summary>
        /// Performs a component-wise greater than or equal to check.
        /// </summary>
        /// <param name="other">The <see cref="Cartesian"/> to compare against.</param>
        /// <returns><see langword="true"/> if all components of this <see cref="Cartesian"/> are greater than or equal to all components of <paramref name="other"/></returns>
        public bool AllComponentsAreGreaterThanOrEqualTo(Cartesian other)
        {
            return (m_x >= other.X) && (m_y >= other.Y) && (m_z >= other.Z);
        }

        /// <summary>
        /// Performs a component-wise less than check.
        /// </summary>
        /// <param name="other">The <see cref="Cartesian"/> to compare against.</param>
        /// <returns><see langword="true"/> if all components of this <see cref="Cartesian"/> are less than all components of <paramref name="other"/></returns>
        public bool AllComponentsAreLessThan(Cartesian other)
        {
            return (m_x < other.X) && (m_y < other.Y) && (m_z < other.Z);
        }

        /// <summary>
        /// Performs a component-wise less than or equal to check.
        /// </summary>
        /// <param name="other">The <see cref="Cartesian"/> to compare against.</param>
        /// <returns><see langword="true"/> if all components of this <see cref="Cartesian"/> are less than or equal to all components of <paramref name="other"/></returns>
        public bool AllComponentsAreLessThanOrEqualTo(Cartesian other)
        {
            return (m_x <= other.X) && (m_y <= other.Y) && (m_z <= other.Z);
        }

        /// <summary>
        /// Produces a set of <see cref="Cartesian"/> coordinates representing this instance which results from rotating
        /// the original axes used to represent this instance by the provided <see cref="Matrix3By3"/> rotation.
        /// </summary>
        /// <param name="rotation">The <see cref="Matrix3By3"/> rotation.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates which is the result of the rotation.</returns>
        /// <remarks>
        /// This type of rotation is sometimes referred to as an "alias rotation".
        /// </remarks>
        public Cartesian Rotate(Matrix3By3 rotation)
        {
            return new Cartesian(rotation.M11 * m_x + rotation.M12 * m_y + rotation.M13 * m_z,
                                  rotation.M21 * m_x + rotation.M22 * m_y + rotation.M23 * m_z,
                                  rotation.M31 * m_x + rotation.M32 * m_y + rotation.M33 * m_z);
        }

        /// <summary>
        /// Produces a set of <see cref="Cartesian"/> coordinates representing this instance which results from rotating
        /// the original axes used to represent this instance by the provided <see cref="UnitQuaternion"/> rotation.
        /// </summary>
        /// <param name="rotation">The <see cref="UnitQuaternion"/> rotation.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates which is the result of the rotation.</returns>
        /// <remarks>
        /// This type of rotation is sometimes referred to as an "alias rotation".
        /// </remarks>
        public Cartesian Rotate(UnitQuaternion rotation)
        {
            double w = rotation.W;
            double difference = w * w - rotation.X * rotation.X - rotation.Y * rotation.Y - rotation.Z * rotation.Z;
            double dot = m_x * rotation.X + m_y * rotation.Y + m_z * rotation.Z;

            return new Cartesian(difference * m_x + 2.0 * (w * (m_y * rotation.Z - m_z * rotation.Y) + dot * rotation.X),
                                  difference * m_y + 2.0 * (w * (m_z * rotation.X - m_x * rotation.Z) + dot * rotation.Y),
                                  difference * m_z + 2.0 * (w * (m_x * rotation.Y - m_y * rotation.X) + dot * rotation.Z));
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is Cartesian)
            {
                return Equals((Cartesian)obj);
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
        /// <param name="other">The set of <see cref="Cartesian"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(Cartesian other, double epsilon)
        {
            return Math.Abs(X - other.X) < epsilon &&
                   Math.Abs(Y - other.Y) < epsilon &&
                   Math.Abs(Z - other.Z) < epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_x.GetHashCode() ^ m_y.GetHashCode() ^ m_z.GetHashCode();
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// "X, Y, Z".
        /// </returns>
        public override string ToString()
        {
            StringBuilder build = new StringBuilder(80);
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
        public static bool operator ==(Cartesian left, Cartesian right)
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
        public static bool operator !=(Cartesian left, Cartesian right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Gets the magnitude of this instance.
        /// </summary>
        public double Magnitude
        {
            get
            {
                return Math.Sqrt(MagnitudeSquared);
            }
        }

        /// <summary>
        /// Gets the square of the <see cref="Magnitude"/> of this instance.
        /// </summary>
        public double MagnitudeSquared
        {
            get
            {
                return m_x * m_x + m_y * m_y + m_z * m_z;
            }
        }

        /// <summary>
        /// Gets a value indicating if the <see cref="Magnitude"/> of this instance is zero.
        /// </summary>
        public bool HasZeroMagnitude
        {
            get
            {
                // Test the square of the magnitude since this is equivalent and more efficient.
                return (MagnitudeSquared == 0.0);
            }
        }

        /// <summary>
        /// Gets whether or not any of the coordinates for this instance have the value <see cref="Double.NaN"/>.
        /// </summary>
        public bool IsUndefined
        {
            get
            {
                return Double.IsNaN(m_x) || Double.IsNaN(m_y) || Double.IsNaN(m_z);
            }
        }

        /// <summary>
        /// Forms a set of <see cref="UnitCartesian"/> coordinates from this instance.
        /// </summary>
        /// <returns>The resulting set of <see cref="UnitCartesian"/> coordinates.</returns>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        public UnitCartesian Normalize()
        {
            double magnitude;
            return Normalize(out magnitude);
        }

        /// <summary>
        /// Forms a set of <see cref="UnitCartesian"/> coordinates from this instance
        /// and returns the <see cref="Magnitude"/> of the original instance in the provided parameter.
        /// </summary>
        /// <param name="magnitude">
        /// <filter name="Java">On input, an array with one element.  On return, the array is populated with</filter>
        /// <filter name="DotNet,Silverlight">On return,</filter>
        /// the magnitude of the original set of <see cref="Cartesian"/> coordinates.
        /// </param>
        /// <returns>The resulting set of <see cref="UnitCartesian"/> coordinates.</returns>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        [SuppressMessage("Microsoft.Design", "CA1021:AvoidOutParameters", MessageId = "0#")]
        public UnitCartesian Normalize(out double magnitude)
        {
            return new UnitCartesian(m_x, m_y, m_z, out magnitude);
        }

        /// <summary>
        /// Converts a set of <see cref="UnitCartesian"/> coordinates to a set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of <see cref="UnitCartesian"/> coordinates.</param>
        /// <returns>The resulting set of <see cref="Cartesian"/> coordinates.</returns>
        public static implicit operator Cartesian(UnitCartesian coordinates)
        {
            return new Cartesian(coordinates.X, coordinates.Y, coordinates.Z);
        }

        private readonly double m_x;
        private readonly double m_y;
        private readonly double m_z;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 3;

        private static readonly Cartesian s_zero = new Cartesian(0.0, 0.0, 0.0);

        private static readonly Cartesian s_undefined = new Cartesian(Double.NaN, Double.NaN, Double.NaN);

        #region IEquatable<Cartesian3> Members

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(Cartesian other)
        {
            return other.m_x == m_x && other.m_y == m_y && other.m_z == m_z;
        }

        #endregion

        /// <summary>
        /// Gets the number of elements in this set of coordinates.
        /// </summary>
        public int Length
        {
            get
            {
                return s_length;
            }
        }

        /// <summary>
        /// Gets the value of the specified element with <paramref name="index"/> of 0, 1, and 2 corresponding to the coordinates
        /// X, Y, and Z.
        /// </summary>
        /// <param name="index">Either a 0, 1, or 2 corresponding to the coordinates X, Y, or Z.</param>
        /// <returns>The coordinate associated with the specified <paramref name="index"/>.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown if the <paramref name="index"/> is less than 0 or greater than or equal to the <see cref="Length"/>.
        /// </exception>
        public double this[int index]
        {
            get
            {
                switch (index)
                {
                    case 0:
                        return X;
                    case 1:
                        return Y;
                    case 2:
                        return Z;
                    default:
                        throw new ArgumentOutOfRangeException("index");
                }
            }
        }
    }
}
