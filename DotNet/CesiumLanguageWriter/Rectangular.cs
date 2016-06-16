using System;
using System.Diagnostics.CodeAnalysis;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of rectilinear 2-dimensional coordinates.
    /// </summary>
    /// <remarks>
    /// The corresponding 3-dimensional coordinates are <see cref="Cartesian"/> coordinates.
    /// </remarks>
    [CSToJavaImmutableValueType]
    public struct Rectangular : IEquatable<Rectangular>
    {
        /// <summary>
        /// Gets a set of <see cref="Rectangular"/> coordinates with values of zero.
        /// </summary>
        public static Rectangular Zero
        {
            get { return s_zero; }
        }

        /// <summary>
        /// Gets a set of <see cref="Rectangular"/> coordinates with values of <see cref="Double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="Rectangular.IsUndefined"/> to test whether a <see cref="Rectangular"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the coordinate values
        /// are <see cref="Double.NaN"/>.
        /// </remarks>
        public static Rectangular Undefined
        {
            get { return s_undefined; }
        }

        /// <summary>
        /// Initializes a set of <see cref="Rectangular"/> coordinates from the provided values.
        /// </summary>
        /// <param name="x">The linear coordinate along the positive x-axis.</param>
        /// <param name="y">The linear coordinate along the positive y-axis.</param>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "0#x")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#y")]
        public Rectangular(double x, double y)
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
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the inverse of this instance.</returns>
        [Pure]
        public Rectangular Invert()
        {
            return new Rectangular(-m_x, -m_y);
        }

        /// <summary>
        /// Multiplies this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The multiplier, or value which is to multiply this instance.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the multiplication.</returns>
        [Pure]
        public Rectangular Multiply(double scalar)
        {
            return new Rectangular(m_x * scalar, m_y * scalar);
        }

        /// <summary>
        /// Divides this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The divisor, or value which is to divide this instance.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the division.</returns>
        [Pure]
        public Rectangular Divide(double scalar)
        {
            return new Rectangular(m_x / scalar, m_y / scalar);
        }

        /// <summary>
        /// Adds the specified set of <see cref="Rectangular"/> coordinates to this instance.
        /// </summary>
        /// <param name="other">The addend, or value which is to be added to this instance.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the addition.</returns>
        [Pure]
        public Rectangular Add(Rectangular other)
        {
            return new Rectangular(m_x + other.m_x, m_y + other.m_y);
        }

        /// <summary>
        /// Subtracts the specified set of <see cref="Rectangular"/> coordinates from this instance.
        /// </summary>
        /// <param name="other">The subtrahend, or value which is to be subtracted from this instance.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the subtraction.</returns>
        [Pure]
        public Rectangular Subtract(Rectangular other)
        {
            return new Rectangular(m_x - other.m_x, m_y - other.m_y);
        }

        /// <summary>
        /// Forms the dot product of the specified set of <see cref="Rectangular"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Rectangular"/> coordinates to dot with this instance.</param>
        /// <returns>A <see cref="double"/> that represents the result of the product.</returns>
        [Pure]
        public double Dot(Rectangular other)
        {
            return m_x * other.m_x + m_y * other.m_y;
        }

        /// <summary>
        /// Multiplies a specified set of <see cref="Rectangular"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the multiplication.</returns>
        public static Rectangular operator *(Rectangular left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Multiplies a scalar by a specified set of set of <see cref="Rectangular"/> coordinates.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the multiplication.</returns>
        public static Rectangular operator *(double left, Rectangular right)
        {
            return right.Multiply(left);
        }

        /// <summary>
        /// Divides a specified set of <see cref="Rectangular"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The dividend, or value which is to be divided by <paramref name="right"/>.</param>
        /// <param name="right">The divisor, or value which is to divide <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the division.</returns>
        public static Rectangular operator /(Rectangular left, double right)
        {
            return left.Divide(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="Rectangular"/> coordinates to another specified set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the addition.</returns>
        public static Rectangular operator +(Rectangular left, Rectangular right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="Rectangular"/> coordinates from another specified set of <see cref="Rectangular"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates that represents the result of the subtraction.</returns>
        public static Rectangular operator -(Rectangular left, Rectangular right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Negates the specified set of <see cref="Rectangular"/> coordinates, yielding a new set of <see cref="Rectangular"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of coordinates.</param>
        /// <returns>The result of negating the elements of the original set of <see cref="Rectangular"/> coordinates.</returns>
        public static Rectangular operator -(Rectangular coordinates)
        {
            return new Rectangular(-coordinates.m_x, -coordinates.m_y);
        }

        /// <summary>
        /// Produces a set of <see cref="Rectangular"/> coordinates representing this instance which results from rotating
        /// the original axes used to represent this instance by the provided angle.
        /// </summary>
        /// <param name="angle">The angle of rotation.</param>
        /// <returns>A set of <see cref="Rectangular"/> coordinates which is the result of the rotation.</returns>
        /// <remarks>
        /// This type of rotation is sometimes referred to as an "alias rotation".
        /// </remarks>
        [Pure]
        public Rectangular Rotate(double angle)
        {
            double c = Math.Cos(angle);
            double s = Math.Sin(angle);
            return new Rectangular(c * m_x - s * m_y, s * m_x + c * m_y);
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is Rectangular && Equals((Rectangular)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(Rectangular other)
        {
            return m_x.Equals(other.m_x) &&
                   m_y.Equals(other.m_y);
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Rectangular"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than or equal to <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(Rectangular other, double epsilon)
        {
            return Math.Abs(m_x - other.m_x) <= epsilon &&
                   Math.Abs(m_y - other.m_y) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_x.GetHashCode(),
                                    m_y.GetHashCode());
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
            return string.Format("{0}, {1}", m_x, m_y);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(Rectangular left, Rectangular right)
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
        public static bool operator !=(Rectangular left, Rectangular right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Gets whether or not any of the coordinates for this instance have the value <see cref="Double.NaN"/>.
        /// </summary>
        public bool IsUndefined
        {
            get { return double.IsNaN(m_x) || double.IsNaN(m_y); }
        }

        private readonly double m_x;
        private readonly double m_y;

        private static readonly Rectangular s_zero = new Rectangular(0.0, 0.0);

        private static readonly Rectangular s_undefined = new Rectangular(double.NaN, double.NaN);
    }
}
