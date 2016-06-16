using System;
using System.Diagnostics.CodeAnalysis;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of rectilinear 3-dimensional coordinates with unit magnitude.
    /// </summary>
    /// <remarks>
    /// </remarks>
    [CSToJavaImmutableValueType]
    public struct UnitCartesian : IEquatable<UnitCartesian>
    {
        /// <summary>
        /// Gets a set of <see cref="UnitCartesian"/> coordinates with values of <see cref="Double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="UnitCartesian.IsUndefined"/> to test whether a <see cref="UnitCartesian"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the coordinate values
        /// are <see cref="Double.NaN"/>.
        /// </remarks>
        public static UnitCartesian Undefined
        {
            get { return s_undefined; }
        }

        /// <summary>
        /// Gets a set of <see cref="UnitCartesian"/> coordinates representing the x-axis.
        /// </summary>
        public static UnitCartesian UnitX
        {
            get { return s_x; }
        }

        /// <summary>
        /// Gets a set of <see cref="UnitCartesian"/> coordinates representing the y-axis.
        /// </summary>
        public static UnitCartesian UnitY
        {
            get { return s_y; }
        }

        /// <summary>
        /// Gets a set of <see cref="UnitCartesian"/> coordinates representing the z-axis.
        /// </summary>
        public static UnitCartesian UnitZ
        {
            get { return s_z; }
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian"/> coordinates from the provided values.
        /// </summary>
        /// <param name="x">The linear coordinate along the positive x-axis.</param>
        /// <param name="y">The linear coordinate along the positive y-axis.</param>
        /// <param name="z">The linear coordinate along the positive z-axis.</param>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "2#z")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#y")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "0#x")]
        public UnitCartesian(double x, double y, double z)
            : this(x, y, z, Normalization.Unnormalized)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian"/> coordinates from the provided values.
        /// </summary>
        /// <param name="x">The linear coordinate along the positive x-axis.</param>
        /// <param name="y">The linear coordinate along the positive y-axis.</param>
        /// <param name="z">The linear coordinate along the positive z-axis.</param>
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
        [SuppressMessage("Microsoft.Design", "CA1021:AvoidOutParameters", MessageId = "3#")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "2#z")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "1#y")]
        [SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "0#x")]
        public UnitCartesian(double x, double y, double z, out double magnitude)
        {
            NormalizeCoordinates(ref x, ref y, ref z, out magnitude);
            m_x = x;
            m_y = y;
            m_z = z;
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian"/> coordinates from the provided set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of <see cref="Cartesian"/> coordinates.</param>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        public UnitCartesian(Cartesian coordinates)
            : this(coordinates.X, coordinates.Y, coordinates.Z, Normalization.Unnormalized)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian"/> coordinates from the provided set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of <see cref="Cartesian"/> coordinates.</param>
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
        [SuppressMessage("Microsoft.Design", "CA1021:AvoidOutParameters", MessageId = "1#")]
        public UnitCartesian(Cartesian coordinates, out double magnitude)
            : this(coordinates.X, coordinates.Y, coordinates.Z, out magnitude)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian"/> coordinates from the provided spherical coordinates.
        /// </summary>
        /// <param name="clock">The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.</param>
        /// <param name="cone">The angular coordinate measured from the positive z-axis and toward the negative z-axis.</param>
        public UnitCartesian(double clock, double cone)
        {
            double s = Math.Sin(cone);
            m_x = s * Math.Cos(clock);
            m_y = s * Math.Sin(clock);
            m_z = Math.Cos(cone);
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian"/> coordinates from the provided set of
        /// <see cref="UnitSpherical"/> coordinates.
        /// </summary>
        /// <param name="unitSpherical">The set of <see cref="UnitSpherical"/> coordinates.</param>
        public UnitCartesian(UnitSpherical unitSpherical)
            : this(unitSpherical.Clock, unitSpherical.Cone)
        {
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
        /// <returns>A set of <see cref="UnitCartesian"/> coordinates that represents the inverse of this instance.</returns>
        [Pure]
        public UnitCartesian Invert()
        {
            return new UnitCartesian(-m_x, -m_y, -m_z, Normalization.Normalized);
        }

        /// <summary>
        /// Multiplies this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The multiplier, or value by which to multiply this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the multiplication.</returns>
        [Pure]
        public Cartesian Multiply(double scalar)
        {
            return new Cartesian(m_x * scalar, m_y * scalar, m_z * scalar);
        }

        /// <summary>
        /// Divides this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The divisor, or value by which to divide this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the division.</returns>
        [Pure]
        public Cartesian Divide(double scalar)
        {
            return new Cartesian(m_x / scalar, m_y / scalar, m_z / scalar);
        }

        /// <summary>
        /// Adds the specified set of <see cref="Cartesian"/> coordinates to this instance.
        /// </summary>
        /// <param name="other">The addend, or value which is to be added to this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the addition.</returns>
        [Pure]
        public Cartesian Add(Cartesian other)
        {
            return new Cartesian(m_x + other.X, m_y + other.Y, m_z + other.Z);
        }

        /// <summary>
        /// Adds the specified set of <see cref="UnitCartesian"/> coordinates to this instance.
        /// </summary>
        /// <param name="other">The addend, or value which is to be added to this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the addition.</returns>
        [Pure]
        public Cartesian Add(UnitCartesian other)
        {
            return new Cartesian(m_x + other.m_x, m_y + other.m_y, m_z + other.m_z);
        }

        /// <summary>
        /// Subtracts the specified set of <see cref="Cartesian"/> coordinates from this instance.
        /// </summary>
        /// <param name="other">The subtrahend, or value which is to be subtracted from this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the subtraction.</returns>
        [Pure]
        public Cartesian Subtract(Cartesian other)
        {
            return new Cartesian(m_x - other.X, m_y - other.Y, m_z - other.Z);
        }

        /// <summary>
        /// Subtracts the specified set of <see cref="UnitCartesian"/> coordinates from this instance.
        /// </summary>
        /// <param name="other">The subtrahend, or value which is to be subtracted from this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the subtraction.</returns>
        [Pure]
        public Cartesian Subtract(UnitCartesian other)
        {
            return new Cartesian(m_x - other.m_x, m_y - other.m_y, m_z - other.m_z);
        }

        /// <summary>
        /// Forms the cross product of the specified set of <see cref="Cartesian"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian"/> coordinates to cross with this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the product.</returns>
        [Pure]
        public Cartesian Cross(Cartesian other)
        {
            return new Cartesian(m_y * other.Z - m_z * other.Y, m_z * other.X - m_x * other.Z, m_x * other.Y - m_y * other.X);
        }

        /// <summary>
        /// Forms the cross product of the specified set of <see cref="UnitCartesian"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian"/> coordinates to cross with this instance.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the product.</returns>
        [Pure]
        public Cartesian Cross(UnitCartesian other)
        {
            return new Cartesian(m_y * other.m_z - m_z * other.m_y, m_z * other.m_x - m_x * other.m_z, m_x * other.m_y - m_y * other.m_x);
        }

        /// <summary>
        /// Forms the dot product of the specified set of <see cref="Cartesian"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian"/> coordinates to dot with this instance.</param>
        /// <returns>A <see cref="double"/> that represents the result of the product.</returns>
        [Pure]
        public double Dot(Cartesian other)
        {
            return m_x * other.X + m_y * other.Y + m_z * other.Z;
        }

        /// <summary>
        /// Forms the dot product of the specified set of <see cref="UnitCartesian"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian"/> coordinates to dot with this instance.</param>
        /// <returns>A <see cref="double"/> that represents the result of the product.</returns>
        [Pure]
        public double Dot(UnitCartesian other)
        {
            return m_x * other.m_x + m_y * other.m_y + m_z * other.m_z;
        }

        /// <summary>
        /// Multiplies a specified set of <see cref="UnitCartesian"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian operator *(UnitCartesian left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Multiplies a scalar by a specified set of <see cref="UnitCartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The multiplicand, or value to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which by which <paramref name="left"/> is to be multiplied.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian operator *(double left, UnitCartesian right)
        {
            return right.Multiply(left);
        }

        /// <summary>
        /// Divides a specified set of <see cref="UnitCartesian"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The dividend, or value to be divided by <paramref name="right"/>.</param>
        /// <param name="right">The divisor, or value by which <paramref name="left"/> is to be divided.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the division.</returns>
        public static Cartesian operator /(UnitCartesian left, double right)
        {
            return left.Divide(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="UnitCartesian"/> coordinates to another specified set of <see cref="UnitCartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian operator +(UnitCartesian left, UnitCartesian right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="Cartesian"/> coordinates to a specified set of <see cref="UnitCartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian operator +(UnitCartesian left, Cartesian right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="UnitCartesian"/> coordinates to a specified set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian operator +(Cartesian left, UnitCartesian right)
        {
            return right.Add(left);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="UnitCartesian"/> coordinates from another specified set of <see cref="UnitCartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian operator -(UnitCartesian left, UnitCartesian right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="Cartesian"/> coordinates from a specified set of <see cref="UnitCartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian operator -(UnitCartesian left, Cartesian right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="UnitCartesian"/> coordinates from a specified set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian operator -(Cartesian left, UnitCartesian right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Negates the specified <see cref="UnitCartesian"/>, yielding a new <see cref="UnitCartesian"/>.
        /// </summary>
        /// <param name="coordinates">The set of coordinates.</param>
        /// <returns>The result of negating the elements of the original <see cref="UnitCartesian"/>.</returns>
        public static UnitCartesian operator -(UnitCartesian coordinates)
        {
            return new UnitCartesian(-coordinates.m_x, -coordinates.m_y, -coordinates.m_z, Normalization.Normalized);
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is UnitCartesian && Equals((UnitCartesian)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(UnitCartesian other)
        {
            return m_x == other.m_x &&
                   m_y == other.m_y &&
                   m_z == other.m_z;
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="UnitCartesian"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than or equal to <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        [Pure]
        public bool EqualsEpsilon(UnitCartesian other, double epsilon)
        {
            return Math.Abs(m_x - other.m_x) <= epsilon &&
                   Math.Abs(m_y - other.m_y) <= epsilon &&
                   Math.Abs(m_z - other.m_z) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_x.GetHashCode(),
                                    m_y.GetHashCode(),
                                    m_z.GetHashCode());
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
            return string.Format("{0}, {1}, {2}", m_x, m_y, m_z);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(UnitCartesian left, UnitCartesian right)
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
        public static bool operator !=(UnitCartesian left, UnitCartesian right)
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
                return Double.IsNaN(m_x) || Double.IsNaN(m_y) || Double.IsNaN(m_z);
            }
        }
        
        private UnitCartesian(double x, double y, double z, Normalization normalization)
        {
            if (normalization == Normalization.Normalized)
            {
                m_x = x;
                m_y = y;
                m_z = z;
            }
            else
            {
                double magnitude;
                NormalizeCoordinates(ref x, ref y, ref z, out magnitude);

                m_x = x;
                m_y = y;
                m_z = z;
            }
        }

        private static void NormalizeCoordinates(ref double x, ref double y, ref double z, out double magnitude)
        {
            magnitude = Math.Sqrt(x * x + y * y + z * z);

            if (magnitude == 0.0)
            {
                throw new DivideByZeroException(CesiumLocalization.MagnitudeMustNotBeZero);
            }
            if (double.IsInfinity(magnitude))
            {
                throw new NotFiniteNumberException(CesiumLocalization.MagnitudeMustNotBeInfinite);
            }

            x /= magnitude;
            y /= magnitude;
            z /= magnitude;
        }

        private enum Normalization
        {
            Unnormalized = 0,
            Normalized = 1
        }

        private readonly double m_x;
        private readonly double m_y;
        private readonly double m_z;

        private static readonly UnitCartesian s_x = new UnitCartesian(1.0, 0.0, 0.0, Normalization.Normalized);
        private static readonly UnitCartesian s_y = new UnitCartesian(0.0, 1.0, 0.0, Normalization.Normalized);
        private static readonly UnitCartesian s_z = new UnitCartesian(0.0, 0.0, 1.0, Normalization.Normalized);
        private static readonly UnitCartesian s_undefined = new UnitCartesian(double.NaN, double.NaN, double.NaN, Normalization.Normalized);
    }
}
