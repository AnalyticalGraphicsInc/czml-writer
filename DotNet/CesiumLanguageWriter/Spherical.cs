using System;
using System.Globalization;
using System.Text;
using System.Diagnostics.CodeAnalysis;
using JetBrains.Annotations;

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
            get { return s_zero; }
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
        [Pure]
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
            return obj is Spherical && Equals((Spherical)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(Spherical other)
        {
            return m_clock == other.m_clock &&
                   m_cone == other.m_cone &&
                   m_magnitude == other.m_magnitude;
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Spherical"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than or equal to <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        [Pure]
        public bool EqualsEpsilon(Spherical other, double epsilon)
        {
            return Math.Abs(m_clock - other.m_clock) <= epsilon &&
                   Math.Abs(m_cone - other.m_cone) <= epsilon &&
                   Math.Abs(m_magnitude - other.m_magnitude) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_clock.GetHashCode(),
                                    m_cone.GetHashCode(),
                                    m_magnitude.GetHashCode());
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
            return string.Format("{0}, {1}, {2}", m_clock, m_cone, m_magnitude);
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

        private static readonly Spherical s_zero = new Spherical(0.0, 0.0, 0.0);
    }
}
