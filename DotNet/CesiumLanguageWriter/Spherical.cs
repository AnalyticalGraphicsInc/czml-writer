using System;
using System.Globalization;
using System.Text;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of curvilinear 3-dimensional coordinates.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct Spherical : IEquatable<Spherical>
    {
        /// <summary>
        /// Gets a set of <see cref="Spherical"/> coordinates with values of zero.
        /// </summary>
        public static Spherical Zero
        {
            get
            {
                return s_zero;
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Spherical"/> coordinates from the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <param name="startIndex">The index of the first element in the array to use.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the array of <paramref name="elements"/> is null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when an object of this type is constructed from an array with less than 3 <paramref name="elements"/>.
        /// </exception>
        public Spherical(double[] elements, int startIndex)
        {
            if (elements == null)
            {
                throw new ArgumentNullException("elements");
            }
            else if (startIndex >= elements.Length ||
                     elements.Length - startIndex < s_length)
            {
                throw new ArgumentOutOfRangeException("elements", String.Format(CultureInfo.CurrentCulture, CesiumLocalization.MustBeConstructedFromSpecificNumberOfElements, typeof(Spherical), 3));
            }
            else
            {
                m_clock = elements[startIndex + 0];
                m_cone = elements[startIndex + 1];
                m_magnitude = elements[startIndex + 2];
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Spherical"/> coordinates from the first 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <exception cref="ArgumentNullException">
        /// The array of <paramref name="elements"/> cannot be null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// An object of this type must be constructed from an array with at least 3 <paramref name="elements"/>.
        /// </exception>
        public Spherical(double[] elements)
            : this(elements, 0)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="Spherical"/> coordinates from the provided clock angle, cone angle, and magnitude.
        /// </summary>
        /// <param name="clock">The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.</param>
        /// <param name="cone">The angular coordinate measured from the positive z-axis and toward the negative z-axis.</param>
        /// <param name="magnitude">The linear coordinate measured from the origin.</param>
        public Spherical(double clock, double cone, double magnitude)
        {
            m_clock = clock;
            m_cone = cone;
            m_magnitude = magnitude;
        }

        /// <summary>
        /// Initializes a set of <see cref="Spherical"/> coordinates from the provided set of <see cref="Cartesian"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of Cartesian coordinates.</param>
        public Spherical(Cartesian coordinates)
        {
            double x = coordinates.X;
            double y = coordinates.Y;
            double z = coordinates.Z;
            double radialSquared = x * x + y * y;
            m_clock = Math.Atan2(y, x);
            m_cone = Math.Atan2(Math.Sqrt(radialSquared), z);
            m_magnitude = Math.Sqrt(radialSquared + z * z);
        }

        /// <summary>
        /// Gets the angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
        /// </summary>
        public double Clock
        {
            get { return m_clock; }
        }

        /// <summary>
        /// Gets the angular coordinate measured from the positive z-axis and toward the negative z-axis.
        /// </summary>
        public double Cone
        {
            get { return m_cone; }
        }

        /// <summary>
        /// Gets the linear coordinate measured from the origin.
        /// </summary>
        public double Magnitude
        {
            get { return m_magnitude; }
        }

        /// <summary>
        /// Forms a set of <see cref="UnitSpherical"/> coordinates from this instance.
        /// </summary>
        /// <returns>The resulting set of <see cref="UnitSpherical"/> coordinates.</returns>
        public UnitSpherical Normalize()
        {
            return new UnitSpherical(this);
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is Spherical)
            {
                return Equals((Spherical)obj);
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
        /// <param name="other">The set of <see cref="Spherical"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(Spherical other, double epsilon)
        {
            return Math.Abs(Clock - other.Clock) < epsilon &&
                   Math.Abs(Cone - other.Cone) < epsilon &&
                   Math.Abs(Magnitude - other.Magnitude) < epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_clock.GetHashCode() ^ m_cone.GetHashCode() ^ m_magnitude.GetHashCode();
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// Clock, Cone, and Magnitude.
        /// </returns>
        public override string ToString()
        {
            StringBuilder build = new StringBuilder(80);
            build.Append(m_clock.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_cone.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_magnitude.ToString(CultureInfo.CurrentCulture));
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
        public static bool operator ==(Spherical left, Spherical right)
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
        public static bool operator !=(Spherical left, Spherical right)
        {
            return !left.Equals(right);
        }

        private readonly double m_clock;
        private readonly double m_cone;
        private readonly double m_magnitude;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 3;

        private static readonly Spherical s_zero = new Spherical(0.0, 0.0, 0.0);

        #region IEquatable<Spherical> Members

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(Spherical other)
        {
            return Clock == other.Clock && Cone == other.Cone && Magnitude == other.Magnitude;
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
        /// Clock, Cone, and Magnitude.
        /// </summary>
        /// <param name="index">Either 0, 1, or 2 corresponding to the coordinates Clock, Cone, or Magnitude.</param>
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
                        return Clock;
                    case 1:
                        return Cone;
                    case 2:
                        return Magnitude;
                    default:
                        throw new ArgumentOutOfRangeException("index");
                }
            }
        }
    }
}
