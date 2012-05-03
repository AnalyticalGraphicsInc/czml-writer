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
    /// The corresponding 2-dimensional coordinates are <see cref="Cartesian2"/> coordinates.
    /// </remarks>
    [CSToJavaImmutableValueType]
    public struct Cartesian3 : IEquatable<Cartesian3>
    {
        /// <summary>
        /// Gets a set of <see cref="Cartesian3"/> coordinates with values of zero.
        /// </summary>
        public static Cartesian3 Zero
        {
            get
            {
                return s_zero;
            }
        }

        /// <summary>
        /// Gets a set of <see cref="Cartesian3"/> coordinates with values of <see cref="Double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="Cartesian3.IsUndefined"/> to test whether a <see cref="Cartesian3"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the coordinate values
        /// are <see cref="Double.NaN"/>.
        /// </remarks>
        public static Cartesian3 Undefined
        {
            get
            {
                return s_undefined;
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian3"/> coordinates from 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <param name="startIndex">The index of the first element in the array to use.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the array of <paramref name="elements"/> is <see langword="null"/>.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when an object of this type is constructed from an array with less than 3 <paramref name="elements"/>.
        /// </exception>
        public Cartesian3(double[] elements, int startIndex)
        {
            if (elements == null)
            {
                throw new ArgumentNullException("elements");
            }
            else if (startIndex >= elements.Length ||
                     elements.Length - startIndex < s_length)
            {
                throw new ArgumentOutOfRangeException("elements", String.Format(CultureInfo.CurrentCulture, CesiumLocalization.MustBeConstructedFromSpecificNumberOfElements, typeof(Cartesian3), 3));
            }
            else
            {
                m_x = elements[startIndex + 0];
                m_y = elements[startIndex + 1];
                m_z = elements[startIndex + 2];
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian3"/> coordinates from the first 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <exception cref="ArgumentNullException">
        /// The array of <paramref name="elements"/> cannot be null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// An object of this type must be constructed from an array with at least 3 <paramref name="elements"/>.
        /// </exception>
        public Cartesian3(double[] elements)
            : this(elements, 0)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian3"/> coordinates from the provided values.
        /// </summary>
        /// <param name="x">The linear coordinate along the positive x-axis.</param>
        /// <param name="y">The linear coordinate along the positive y-axis.</param>
        /// <param name="z">The linear coordinate along the positive z-axis.</param>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "2#z")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#y")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "0#x")]
        public Cartesian3(double x, double y, double z)
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
        /// Inverts this instance.
        /// </summary>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the inverse of this instance.</returns>
        public Cartesian3 Invert()
        {
            return new Cartesian3(-m_x, -m_y, -m_z);
        }

        /// <summary>
        /// Multiplies this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The multiplier, or value which is to multiply this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the multiplication.</returns>
        public Cartesian3 Multiply(double scalar)
        {
            return new Cartesian3(m_x * scalar, m_y * scalar, m_z * scalar);
        }

        /// <summary>
        /// Divides this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The divisor, or value which is to divide this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the division.</returns>
        public Cartesian3 Divide(double scalar)
        {
            return new Cartesian3(m_x / scalar, m_y / scalar, m_z / scalar);
        }

        /// <summary>
        /// Adds the specified set of <see cref="Cartesian3"/> coordinates to this instance.
        /// </summary>
        /// <param name="other">The addend, or value which is to be added to this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the addition.</returns>
        public Cartesian3 Add(Cartesian3 other)
        {
            return new Cartesian3(m_x + other.m_x, m_y + other.m_y, m_z + other.m_z);
        }

        /// <summary>
        /// Subtracts the specified set of <see cref="Cartesian3"/> coordinates from this instance.
        /// </summary>
        /// <param name="other">The subtrahend, or value which is to be subtracted from this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the subtraction.</returns>
        public Cartesian3 Subtract(Cartesian3 other)
        {
            return new Cartesian3(m_x - other.m_x, m_y - other.m_y, m_z - other.m_z);
        }

        /// <summary>
        /// Forms the cross product of the specified set of <see cref="Cartesian3"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian3"/> coordinates to cross with this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the product.</returns>
        public Cartesian3 Cross(Cartesian3 other)
        {
            return new Cartesian3(m_y * other.m_z - m_z * other.m_y, m_z * other.m_x - m_x * other.m_z, m_x * other.m_y - m_y * other.m_x);
        }

        /// <summary>
        /// Forms the dot product of the specified set of <see cref="Cartesian3"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian3"/> coordinates to dot with this instance.</param>
        /// <returns>A <see cref="double"/> that represents the result of the product.</returns>
        public double Dot(Cartesian3 other)
        {
            return m_x * other.m_x + m_y * other.m_y + m_z * other.m_z;
        }

        /// <summary>
        /// Multiplies a specified set of <see cref="Cartesian3"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian3 operator *(Cartesian3 left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Multiplies a scalar by a specified set of set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian3 operator *(double left, Cartesian3 right)
        {
            return right.Multiply(left);
        }

        /// <summary>
        /// Divides a specified set of <see cref="Cartesian3"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The dividend, or value which is to be divided by <paramref name="right"/>.</param>
        /// <param name="right">The divisor, or value which is to divide <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the division.</returns>
        public static Cartesian3 operator /(Cartesian3 left, double right)
        {
            return left.Divide(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="Cartesian3"/> coordinates to another specified set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian3 operator +(Cartesian3 left, Cartesian3 right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="Cartesian3"/> coordinates from another specified set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian3 operator -(Cartesian3 left, Cartesian3 right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Negates the specified set of <see cref="Cartesian3"/> coordinates, yielding a new set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of coordinates.</param>
        /// <returns>The result of negating the elements of the original set of <see cref="Cartesian3"/> coordinates.</returns>
        public static Cartesian3 operator -(Cartesian3 coordinates)
        {
            return new Cartesian3(-coordinates.m_x, -coordinates.m_y, -coordinates.m_z);
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Method[@name="Equals"]/*'/>
        public override bool Equals(object obj)
        {
            if (obj is Cartesian3)
            {
                return Equals((Cartesian3)obj);
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
        /// <param name="other">The set of <see cref="Cartesian3"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(Cartesian3 other, double epsilon)
        {
            return Math.Abs(X - other.X) < epsilon &&
                   Math.Abs(Y - other.Y) < epsilon &&
                   Math.Abs(Z - other.Z) < epsilon;
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Method[@name="GetHashCode"]/*'/>
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

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Operator[@name="Equality"]/*'/>
        public static bool operator ==(Cartesian3 left, Cartesian3 right)
        {
            return left.Equals(right);
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Operator[@name="Inequality"]/*'/>
        public static bool operator !=(Cartesian3 left, Cartesian3 right)
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
        /// Forms a set of <see cref="UnitCartesian3"/> coordinates from this instance.
        /// </summary>
        /// <returns>The resulting set of <see cref="UnitCartesian3"/> coordinates.</returns>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        public UnitCartesian3 Normalize()
        {
            double magnitude;
            return Normalize(out magnitude);
        }

        /// <summary>
        /// Forms a set of <see cref="UnitCartesian3"/> coordinates from this instance
        /// and returns the <see cref="Magnitude"/> of the original instance in the provided parameter.
        /// </summary>
        /// <param name="magnitude">
        /// <filter name="Java">On input, an array with one element.  On return, the array is populated with</filter>
        /// <filter name="DotNet,Silverlight">On return,</filter>
        /// the magnitude of the original set of <see cref="Cartesian3"/> coordinates.
        /// </param>
        /// <returns>The resulting set of <see cref="UnitCartesian3"/> coordinates.</returns>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        [SuppressMessage("Microsoft.Design", "CA1021:AvoidOutParameters", MessageId = "0#")]
        public UnitCartesian3 Normalize(out double magnitude)
        {
            return new UnitCartesian3(m_x, m_y, m_z, out magnitude);
        }

        /// <summary>
        /// Converts a set of <see cref="UnitCartesian3"/> coordinates to a set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of <see cref="UnitCartesian3"/> coordinates.</param>
        /// <returns>The resulting set of <see cref="Cartesian"/> coordinates.</returns>
        public static implicit operator Cartesian3(UnitCartesian3 coordinates)
        {
            return new Cartesian3(coordinates.X, coordinates.Y, coordinates.Z);
        }

        private readonly double m_x;
        private readonly double m_y;
        private readonly double m_z;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 3;

        private static readonly Cartesian3 s_zero = new Cartesian3(0.0, 0.0, 0.0);

        private static readonly Cartesian3 s_undefined = new Cartesian3(Double.NaN, Double.NaN, Double.NaN);

        #region IEquatable<Cartesian3> Members

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/IEquatableOfT/Method[@name="Equals"]/*'/>
        public bool Equals(Cartesian3 other)
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
