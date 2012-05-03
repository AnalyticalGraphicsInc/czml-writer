using System;
using System.Globalization;
using System.Text;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of curvilinear 3-dimensional coordinates with unit magnitude.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct UnitSpherical : IEquatable<UnitSpherical>
    {
        /// <summary>
        /// Initializes a set of <see cref="UnitSpherical"/> coordinates from the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <param name="startIndex">The index of the first element in the array to use.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the array of <paramref name="elements"/> is null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when an object of this type is constructed from an array with less than 2 <paramref name="elements"/>.
        /// </exception>
        public UnitSpherical(double[] elements, int startIndex)
        {
            if (elements == null)
            {
                throw new ArgumentNullException("elements");
            }
            else if (startIndex >= elements.Length ||
                     elements.Length - startIndex < s_length)
            {
                throw new ArgumentOutOfRangeException("elements", String.Format(CultureInfo.CurrentCulture, CesiumLocalization.MustBeConstructedFromSpecificNumberOfElements, typeof(UnitSpherical), 2));
            }
            else
            {
                m_clock = elements[startIndex + 0];
                m_cone = elements[startIndex + 1];
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitSpherical"/> coordinates from the first 2 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <exception cref="ArgumentNullException">
        /// The array of <paramref name="elements"/> cannot be null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// An object of this type must be constructed from an array with at least 2 <paramref name="elements"/>.
        /// </exception>
        public UnitSpherical(double[] elements)
            : this(elements, 0)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitSpherical"/> coordinates from the provided clock angle and cone angle.
        /// </summary>
        /// <param name="clock">The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.</param>
        /// <param name="cone">The angular coordinate measured from the positive z-axis and toward the negative z-axis.</param>
        public UnitSpherical(double clock, double cone)
        {
            m_clock = clock;
            m_cone = cone;
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitSpherical"/> coordinates from the provided set of <see cref="UnitCartesian3"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of UnitCartesian3 coordinates.</param>
        public UnitSpherical(UnitCartesian3 coordinates)
        {
            double x = coordinates.X;
            double y = coordinates.Y;
            double z = coordinates.Z;
            double radialSquared = x * x + y * y;
            m_clock = Math.Atan2(y, x);
            m_cone = Math.Atan2(Math.Sqrt(radialSquared), z);
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
        /// Gets the linear coordinate measured from the origin.  The value of this property is always 1.0.
        /// </summary>
        public double Magnitude
        {
            get { return 1.0; }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is UnitSpherical)
            {
                return Equals((UnitSpherical)obj);
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
        /// <param name="other">The set of <see cref="UnitSpherical"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(UnitSpherical other, double epsilon)
        {
            return Math.Abs(Clock - other.Clock) < epsilon &&
                   Math.Abs(Cone - other.Cone) < epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_clock.GetHashCode() ^ m_cone.GetHashCode();
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
        public static bool operator ==(UnitSpherical left, UnitSpherical right)
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
        public static bool operator !=(UnitSpherical left, UnitSpherical right)
        {
            return !left.Equals(right);
        }

        private readonly double m_clock;
        private readonly double m_cone;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 2;

        #region IEquatable<UnitSpherical> Members

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(UnitSpherical other)
        {
            return Clock == other.Clock && Cone == other.Cone;
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
        /// Clock and Cone.
        /// </summary>
        /// <param name="index">Either 0 or 1 corresponding to the coordinates Clock or Cone.</param>
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
                    default:
                        throw new ArgumentOutOfRangeException("index");
                }
            }
        }
    }
}
