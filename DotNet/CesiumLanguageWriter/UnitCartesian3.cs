using System;
using System.Globalization;
using System.Text;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of rectilinear 3-dimensional coordinates with unit magnitude.
    /// </summary>
    /// <remarks>
    /// </remarks>
    [CSToJavaImmutableValueType]
    public struct UnitCartesian3 : IEquatable<UnitCartesian3>
    {
        /// <summary>
        /// Gets a set of <see cref="UnitCartesian3"/> coordinates with values of <see cref="Double.NaN"/>.
        /// </summary>
        /// <remarks>
        /// Use <see cref="UnitCartesian3.IsUndefined"/> to test whether a <see cref="UnitCartesian3"/> instance
        /// is undefined since it will return <see langword="true"/> if any of the coordinate values
        /// are <see cref="Double.NaN"/>.
        /// </remarks>
        public static UnitCartesian3 Undefined
        {
            get
            {
                return s_undefined;
            }
        }

        /// <summary>
        /// Gets a set of <see cref="UnitCartesian3"/> coordinates representing the x-axis.
        /// </summary>
        public static UnitCartesian3 UnitX
        {
            get
            {
                return s_x;
            }
        }

        /// <summary>
        /// Gets a set of <see cref="UnitCartesian3"/> coordinates representing the y-axis.
        /// </summary>
        public static UnitCartesian3 UnitY
        {
            get
            {
                return s_y;
            }
        }

        /// <summary>
        /// Gets a set of <see cref="UnitCartesian3"/> coordinates representing the z-axis.
        /// </summary>
        public static UnitCartesian3 UnitZ
        {
            get
            {
                return s_z;
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <param name="startIndex">The index of the first element in the array to use.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the array of <paramref name="elements"/> is null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when an object of this type is constructed from an array with less than 3 <paramref name="elements"/>.
        /// </exception>
        /// <exception cref="DivideByZeroException">
        /// Thrown when the magnitude of the provided coordinates are zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// Thrown when the magnitude of the provided coordinates is infinite.
        /// </exception>
        public UnitCartesian3(double[] elements, int startIndex)
        {
            if (elements == null)
            {
                throw new ArgumentNullException("elements");
            }
            else if (startIndex >= elements.Length ||
                     elements.Length - startIndex < s_length)
            {
                throw new ArgumentOutOfRangeException("elements", String.Format(CultureInfo.CurrentCulture, CesiumLocalization.MustBeConstructedFromSpecificNumberOfElements, typeof(UnitCartesian3), 3));
            }
            else
            {
                double magnitude;
                NormalizeCoordinates(ref elements[startIndex + 0], ref elements[startIndex + 1], ref elements[startIndex + 2], out magnitude);

                m_x = elements[startIndex + 0];
                m_y = elements[startIndex + 1];
                m_z = elements[startIndex + 2];
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from the first 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <exception cref="ArgumentNullException">
        /// The array of <paramref name="elements"/> cannot be null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// An object of this type must be constructed from an array with at least 3 <paramref name="elements"/>.
        /// </exception>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        public UnitCartesian3(double[] elements)
            : this(elements, 0)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from the provided values.
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
        public UnitCartesian3(double x, double y, double z)
            : this(x, y, z, Normalization.Unnormalized)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from the provided values.
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
        public UnitCartesian3(double x, double y, double z, out double magnitude)
        {
            NormalizeCoordinates(ref x, ref y, ref z, out magnitude);
            m_x = x;
            m_y = y;
            m_z = z;
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from the provided set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of <see cref="Cartesian3"/> coordinates.</param>
        /// <exception cref="DivideByZeroException">
        /// The magnitude of the provided coordinates must not be zero.
        /// </exception>
        /// <exception cref="NotFiniteNumberException">
        /// The magnitude of the provided coordinates must not be infinite.
        /// </exception>
        public UnitCartesian3(Cartesian3 coordinates)
            : this(coordinates.X, coordinates.Y, coordinates.Z, Normalization.Unnormalized)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from the provided set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of <see cref="Cartesian3"/> coordinates.</param>
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
        public UnitCartesian3(Cartesian3 coordinates, out double magnitude)
            : this(coordinates.X, coordinates.Y, coordinates.Z, out magnitude)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from the provided spherical coordinates.
        /// </summary>
        /// <param name="clock">The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.</param>
        /// <param name="cone">The angular coordinate measured from the positive z-axis and toward the negative z-axis.</param>
        public UnitCartesian3(double clock, double cone)
        {
            double s = Math.Sin(cone);
            m_x = s * Math.Cos(clock);
            m_y = s * Math.Sin(clock);
            m_z = Math.Cos(cone);
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitCartesian3"/> coordinates from the provided set of
        /// <see cref="UnitSpherical"/> coordinates.
        /// </summary>
        /// <param name="unitSpherical">The set of <see cref="UnitSpherical"/> coordinates.</param>
        public UnitCartesian3(UnitSpherical unitSpherical)
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
        /// <returns>A set of <see cref="UnitCartesian3"/> coordinates that represents the inverse of this instance.</returns>
        public UnitCartesian3 Invert()
        {
            return new UnitCartesian3(-m_x, -m_y, -m_z, Normalization.Normalized);
        }

        /// <summary>
        /// Multiplies this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The multiplier, or value by which to multiply this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the multiplication.</returns>
        public Cartesian3 Multiply(double scalar)
        {
            return new Cartesian3(m_x * scalar, m_y * scalar, m_z * scalar);
        }

        /// <summary>
        /// Divides this instance by a scalar.
        /// </summary>
        /// <param name="scalar">The divisor, or value by which to divide this instance.</param>
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
            return new Cartesian3(m_x + other.X, m_y + other.Y, m_z + other.Z);
        }

        /// <summary>
        /// Adds the specified set of <see cref="UnitCartesian3"/> coordinates to this instance.
        /// </summary>
        /// <param name="other">The addend, or value which is to be added to this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the addition.</returns>
        public Cartesian3 Add(UnitCartesian3 other)
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
            return new Cartesian3(m_x - other.X, m_y - other.Y, m_z - other.Z);
        }

        /// <summary>
        /// Subtracts the specified set of <see cref="UnitCartesian3"/> coordinates from this instance.
        /// </summary>
        /// <param name="other">The subtrahend, or value which is to be subtracted from this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the subtraction.</returns>
        public Cartesian3 Subtract(UnitCartesian3 other)
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
            return new Cartesian3(m_y * other.Z - m_z * other.Y, m_z * other.X - m_x * other.Z, m_x * other.Y - m_y * other.X);
        }

        /// <summary>
        /// Forms the cross product of the specified set of <see cref="UnitCartesian3"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian3"/> coordinates to cross with this instance.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the product.</returns>
        public Cartesian3 Cross(UnitCartesian3 other)
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
            return m_x * other.X + m_y * other.Y + m_z * other.Z;
        }

        /// <summary>
        /// Forms the dot product of the specified set of <see cref="UnitCartesian3"/> coordinates with this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartesian3"/> coordinates to dot with this instance.</param>
        /// <returns>A <see cref="double"/> that represents the result of the product.</returns>
        public double Dot(UnitCartesian3 other)
        {
            return m_x * other.m_x + m_y * other.m_y + m_z * other.m_z;
        }

        /// <summary>
        /// Multiplies a specified set of <see cref="UnitCartesian3"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The multiplicand, or value which is to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which is to multiply <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian3 operator *(UnitCartesian3 left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Multiplies a scalar by a specified set of <see cref="UnitCartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The multiplicand, or value to be multiplied by <paramref name="right"/>.</param>
        /// <param name="right">The multiplier, or value which by which <paramref name="left"/> is to be multiplied.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the multiplication.</returns>
        public static Cartesian3 operator *(double left, UnitCartesian3 right)
        {
            return right.Multiply(left);
        }

        /// <summary>
        /// Divides a specified set of <see cref="UnitCartesian3"/> coordinates by a scalar.
        /// </summary>
        /// <param name="left">The dividend, or value to be divided by <paramref name="right"/>.</param>
        /// <param name="right">The divisor, or value by which <paramref name="left"/> is to be divided.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the division.</returns>
        public static Cartesian3 operator /(UnitCartesian3 left, double right)
        {
            return left.Divide(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="UnitCartesian3"/> coordinates to another specified set of <see cref="UnitCartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian3 operator +(UnitCartesian3 left, UnitCartesian3 right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="Cartesian3"/> coordinates to a specified set of <see cref="UnitCartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian3 operator +(UnitCartesian3 left, Cartesian3 right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Adds a specified set of <see cref="UnitCartesian3"/> coordinates to a specified set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The augend, or value to which <paramref name="right"/> is to be added.</param>
        /// <param name="right">The addend, or value which is to be added to <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the addition.</returns>
        public static Cartesian3 operator +(Cartesian3 left, UnitCartesian3 right)
        {
            return right.Add(left);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="UnitCartesian3"/> coordinates from another specified set of <see cref="UnitCartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian3 operator -(UnitCartesian3 left, UnitCartesian3 right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="Cartesian3"/> coordinates from a specified set of <see cref="UnitCartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian3 operator -(UnitCartesian3 left, Cartesian3 right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Subtracts a specified set of <see cref="UnitCartesian3"/> coordinates from a specified set of <see cref="Cartesian3"/> coordinates.
        /// </summary>
        /// <param name="left">The minuend, or value from which <paramref name="right"/> is to be subtracted.</param>
        /// <param name="right">The subtrahend, or value which is to be subtracted from <paramref name="left"/>.</param>
        /// <returns>A set of <see cref="Cartesian3"/> coordinates that represents the result of the subtraction.</returns>
        public static Cartesian3 operator -(Cartesian3 left, UnitCartesian3 right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Negates the specified <see cref="UnitCartesian3"/>, yielding a new <see cref="UnitCartesian3"/>.
        /// </summary>
        /// <param name="coordinates">The set of coordinates.</param>
        /// <returns>The result of negating the elements of the original <see cref="UnitCartesian3"/>.</returns>
        public static UnitCartesian3 operator -(UnitCartesian3 coordinates)
        {
            return new UnitCartesian3(-coordinates.m_x, -coordinates.m_y, -coordinates.m_z, Normalization.Normalized);
        }

        /// <summary>
        /// Produces a set of <see cref="UnitCartesian3"/> coordinates representing this instance which results from rotating
        /// the original axes used to represent this instance by the provided <see cref="Matrix3By3"/> rotation.
        /// </summary>
        /// <param name="rotation">The <see cref="Matrix3By3"/> rotation.</param>
        /// <returns>A set of <see cref="UnitCartesian3"/> coordinates which is the result of the rotation.</returns>
        /// <remarks>
        /// This type of rotation is sometimes referred to as an "alias rotation".
        /// </remarks>
        public UnitCartesian3 Rotate(Matrix3By3 rotation)
        {
            return new UnitCartesian3(rotation.M11 * m_x + rotation.M12 * m_y + rotation.M13 * m_z,
                                      rotation.M21 * m_x + rotation.M22 * m_y + rotation.M23 * m_z,
                                      rotation.M31 * m_x + rotation.M32 * m_y + rotation.M33 * m_z,
                                      Normalization.Normalized);
        }

        /// <summary>
        /// Produces a set of <see cref="UnitCartesian3"/> coordinates representing this instance which results from rotating
        /// the original axes used to represent this instance by the provided <see cref="UnitQuaternion"/> rotation.
        /// </summary>
        /// <param name="rotation">The <see cref="UnitQuaternion"/> rotation.</param>
        /// <returns>A set of <see cref="UnitCartesian3"/> coordinates which is the result of the rotation.</returns>
        /// <remarks>
        /// This type of rotation is sometimes referred to as an "alias rotation".
        /// </remarks>
        public UnitCartesian3 Rotate(UnitQuaternion rotation)
        {
            double w = rotation.W;
            double difference = w * w - rotation.X * rotation.X - rotation.Y * rotation.Y - rotation.Z * rotation.Z;
            double dot = m_x * rotation.X + m_y * rotation.Y + m_z * rotation.Z;

            return new UnitCartesian3(difference * m_x + 2.0 * (w * (m_y * rotation.Z - m_z * rotation.Y) + dot * rotation.X),
                                      difference * m_y + 2.0 * (w * (m_z * rotation.X - m_x * rotation.Z) + dot * rotation.Y),
                                      difference * m_z + 2.0 * (w * (m_x * rotation.Y - m_y * rotation.X) + dot * rotation.Z),
                                      Normalization.Normalized);
        }

        /// <summary>
        /// Gets the axis that is most orthogonal to this instance.
        /// </summary>
        public UnitCartesian3 MostOrthogonalAxis
        {
            get
            {
                double x = Math.Abs(m_x);
                double y = Math.Abs(m_y);
                double z = Math.Abs(m_z);

                if (x <= y)
                {
                    return ((x <= z) ? UnitCartesian3.UnitX : UnitCartesian3.UnitZ);
                }
                else
                {
                    return ((y <= z) ? UnitCartesian3.UnitY : UnitCartesian3.UnitZ);
                }
            }
        }

        /// <summary>
        /// Gets the axis which is most parallel to this instance.
        /// </summary>
        public UnitCartesian3 MostParallelAxis
        {
            get
            {
                double x = Math.Abs(m_x);
                double y = Math.Abs(m_y);
                double z = Math.Abs(m_z);

                if (x >= y)
                {
                    return ((x >= z) ? UnitCartesian3.UnitX : UnitCartesian3.UnitZ);
                }
                else
                {
                    return ((y >= z) ? UnitCartesian3.UnitY : UnitCartesian3.UnitZ);
                }
            }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is UnitCartesian3)
            {
                return Equals((UnitCartesian3)obj);
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
        /// <param name="other">The set of <see cref="UnitCartesian3"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(UnitCartesian3 other, double epsilon)
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
        public static bool operator ==(UnitCartesian3 left, UnitCartesian3 right)
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
        public static bool operator !=(UnitCartesian3 left, UnitCartesian3 right)
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

        /// <summary>
        /// Determines the angle in radians between the specified set of <see cref="UnitCartesian3"/> coordinates and this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="UnitCartesian3"/> coordinates to evaluate.</param>
        /// <returns>A <see cref="double"/> that represents the angle in radians between the two instances.</returns>
        public double AngleBetween(UnitCartesian3 other)
        {
            double cosine = this.Dot(other);
            double sine = this.Cross(other).Magnitude;

            return Math.Atan2(sine, cosine);
        }

        private UnitCartesian3(double x, double y, double z, Normalization normalization)
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
            else if (Double.IsInfinity(magnitude))
            {
                throw new NotFiniteNumberException(CesiumLocalization.MagnitudeMustNotBeInfinite);
            }
            else
            {
                x /= magnitude;
                y /= magnitude;
                z /= magnitude;
            }
        }

        private readonly double m_x;
        private readonly double m_y;
        private readonly double m_z;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 3;

        private static readonly UnitCartesian3 s_x = new UnitCartesian3(1.0, 0.0, 0.0, Normalization.Normalized);

        private static readonly UnitCartesian3 s_y = new UnitCartesian3(0.0, 1.0, 0.0, Normalization.Normalized);

        private static readonly UnitCartesian3 s_z = new UnitCartesian3(0.0, 0.0, 1.0, Normalization.Normalized);

        private static readonly UnitCartesian3 s_undefined = new UnitCartesian3(Double.NaN, Double.NaN, Double.NaN, Normalization.Normalized);

        private enum Normalization
        {
            Unnormalized = 0,
            Normalized = 1
        };

        #region IEquatable<UnitCartesian3> Members

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(UnitCartesian3 other)
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
        /// <param name="index">Either 0, 1, or 2 corresponding to the coordinates X, Y, or Z.</param>
        /// <returns>The coordinate associated with the specified <paramref name="index"/>.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when <paramref name="index"/> is less than 0 or is equal to or greater than <see cref="Length"/>.
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
