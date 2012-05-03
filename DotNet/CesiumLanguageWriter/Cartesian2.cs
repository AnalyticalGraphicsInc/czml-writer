using System;
using System.Globalization;
using System.Text;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of rectilinear 2-dimensional coordinates.
    /// </summary>
    /// <remarks>
    /// The corresponding 3-dimensional coordinates are <see cref="Cartesian3"/> coordinates.
    /// </remarks>
    [CSToJavaImmutableValueType]
    public struct Cartesian2 : IEquatable<Cartesian2>
    {
        /// <summary>
        /// Gets a set of <see cref="Cartesian2"/> coordinates with values of zero.
        /// </summary>
        public static Cartesian2 Zero
        {
            get
            {
                return s_zero;
            }
        }

        /// <summary>
        /// Gets a set of <see cref="Cartesian2"/> coordinates with values of <see cref="Double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="Cartesian2.IsUndefined"/> to test whether a <see cref="Cartesian2"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the coordinate values
        /// are <see cref="Double.NaN"/>.
        /// </remarks>
        public static Cartesian2 Undefined
        {
            get
            {
                return s_undefined;
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian2"/> coordinates from 2 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <param name="startIndex">The index of the first element in the array to use.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the array of <paramref name="elements"/> is null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when an object of this type is constructed from an array with less than 2 <paramref name="elements"/>.
        /// </exception>
        public Cartesian2(double[] elements, int startIndex)
        {
            if (elements == null)
            {
                throw new ArgumentNullException("elements");
            }
            else if (startIndex >= elements.Length ||
                     elements.Length - startIndex < s_length)
            {
                throw new ArgumentOutOfRangeException("elements", String.Format(CultureInfo.CurrentCulture, CesiumLocalization.MustBeConstructedFromSpecificNumberOfElements, typeof(Cartesian2), 2));
            }
            else
            {
                m_x = elements[startIndex + 0];
                m_y = elements[startIndex + 1];
            }
        }
        
        /// <summary>
        /// Initializes a set of <see cref="Cartesian2"/> coordinates from the first 2 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <exception cref="ArgumentNullException">
        /// The array of <paramref name="elements"/> cannot be null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// An object of this type must be constructed from an array with at least 2 <paramref name="elements"/>.
        /// </exception>
        public Cartesian2(double[] elements)
            : this(elements, 0)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartesian2"/> coordinates from the provided values.
        /// </summary>
        /// <param name="x">The linear coordinate along the positive x-axis.</param>
        /// <param name="y">The linear coordinate along the positive y-axis.</param>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "0#x")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#y")]
        public Cartesian2(double x, double y)
        {
            m_x = x;
            m_y = y;
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
        /// Inverts this instance.
        /// </summary>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the inverse of this instance.</returns>
        public Cartesian2 Invert()
        {
            return new Cartesian2(-m_x, -m_y);
        }

        /// <summary>
        /// Multiplies this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The multiplier, or value which is to multiply this instance.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the multiplication.</returns>
        public Cartesian2 Multiply(double scalar)
        {
            return new Cartesian2(m_x * scalar, m_y * scalar);
        }

        /// <summary>
        /// Divides this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The divisor, or value which is to divide this instance.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the division.</returns>
        public Cartesian2 Divide(double scalar)
        {
            return new Cartesian2(m_x / scalar, m_y / scalar);
        }

        /// <summary>
        /// Adds the specified set of <see cref="Cartesian2"/> coordinates to this instance.
        /// </summary>
        /// <param name="other">The addend, or value which is to be added to this instance.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the addition.</returns>
        public Cartesian2 Add(Cartesian2 other)
        {
            return new Cartesian2(m_x + other.m_x, m_y + other.m_y);
        }

        /// <summary>
        /// Subtracts the specified set of <see cref="Cartesian2"/> coordinates from this instance.
        /// </summary>
        /// <param name="other">The subtrahend, or value which is to be subtracted from this instance.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the subtraction.</returns>
        public Cartesian2 Subtract(Cartesian2 other)
        {
            return new Cartesian2(m_x - other.m_x, m_y - other.m_y);
        }

        /// <summary>
        /// Forms the dot product of the specified set of <see cref="Cartesian2"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian2"/> coordinates to dot with this instance.</param>
        /// <returns>A <see cref="double"/> that represents the result of the product.</returns>
        public double Dot(Cartesian2 other)
        {
            return m_x * other.m_x + m_y * other.m_y;
        }

        /// <summary>
        /// Multiplies a specified set of <see cref="Cartesian2"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian2 operator *(Cartesian2 left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Multiplies a scalar by a specified set of set of <see cref="Cartesian2"/> coordinates.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian2 operator *(double left, Cartesian2 right)
        {
            return right.Multiply(left);
        }

        /// <summary>
        /// Divides a specified set of <see cref="Cartesian2"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The dividend, or value which is to be divided by <paramref name="right"/>.</param>
        /// <param name="right">The divisor, or value which is to divide <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the division.</returns>
        public static Cartesian2 operator /(Cartesian2 left, double right)
        {
            return left.Divide(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="Cartesian2"/> coordinates to another specified set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian2 operator +(Cartesian2 left, Cartesian2 right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="Cartesian2"/> coordinates from another specified set of <see cref="Cartesian2"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian2 operator -(Cartesian2 left, Cartesian2 right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Negates the specified set of <see cref="Cartesian2"/> coordinates, yielding a new set of <see cref="Cartesian2"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of coordinates.</param>
        /// <returns>The result of negating the elements of the original set of <see cref="Cartesian2"/> coordinates.</returns>
        public static Cartesian2 operator -(Cartesian2 coordinates)
        {
            return new Cartesian2(-coordinates.m_x, -coordinates.m_y);
        }

        /// <summary>
        /// Produces a set of <see cref="Cartesian2"/> coordinates representing this instance which results from rotating
        /// the original axes used to represent this instance by the provided angle.
        /// </summary>
        /// <param name="angle">The angle of rotation.</param>
        /// <returns>A set of <see cref="Cartesian2"/> coordinates which is the result of the rotation.</returns>
        /// <remarks>
        /// This type of rotation is sometimes referred to as an "alias rotation".
        /// </remarks>
        public Cartesian2 Rotate(double angle)
        {
            double c = Math.Cos(angle);
            double s = Math.Sin(angle);
            return new Cartesian2(c * m_x - s * m_y, s * m_x + c * m_y);
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is Cartesian2)
            {
                return Equals((Cartesian2)obj);
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
        /// <param name="other">The set of <see cref="Cartesian2"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(Cartesian2 other, double epsilon)
        {
            return Math.Abs(X - other.X) < epsilon &&
                   Math.Abs(Y - other.Y) < epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_x.GetHashCode() ^ m_y.GetHashCode();
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// "X, Y".
        /// </returns>
        public override string ToString()
        {
            StringBuilder build = new StringBuilder(80);
            build.Append(m_x.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_y.ToString(CultureInfo.CurrentCulture));
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
        public static bool operator ==(Cartesian2 left, Cartesian2 right)
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
        public static bool operator !=(Cartesian2 left, Cartesian2 right)
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
                return m_x * m_x + m_y * m_y;
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
                return Double.IsNaN(m_x) || Double.IsNaN(m_y);
            }
        }

        private readonly double m_x;
        private readonly double m_y;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 2;

        private static readonly Cartesian2 s_zero = new Cartesian2(0.0, 0.0);

        private static readonly Cartesian2 s_undefined = new Cartesian2(Double.NaN, Double.NaN);

        #region IEquatable<Cartesian2> Members

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(Cartesian2 other)
        {
            return other.m_x == m_x && other.m_y == m_y;
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
        /// Gets the value of the specified element with <paramref name="index"/> of 0 and 1 corresponding to the coordinates
        /// X and Y.
        /// </summary>
        /// <param name="index">Either 0 or 1 corresponding to the coordinates X or Y.</param>
        /// <returns>The coordinate associated with the specified <paramref name="index"/>.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when the <paramref name="index"/> is less than 0 or is equal to or greater than <see cref="Length"/>.
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
                    default:
                        throw new ArgumentOutOfRangeException("index");
                }
            }
        }
    }
}
