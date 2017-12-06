using System;
using System.Diagnostics.CodeAnalysis;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of curvilinear 3-dimensional coordinates with unit magnitude.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct UnitSpherical : IEquatable<UnitSpherical>
    {
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
        /// Initializes a set of <see cref="UnitSpherical"/> coordinates from a <see cref="Spherical"/> instance.
        /// <param name="spherical">An existing Spherical instance.</param>
        /// </summary>
        public UnitSpherical(Spherical spherical) :
            this(spherical.Clock, spherical.Cone)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="UnitSpherical"/> coordinates from the provided set of <see cref="UnitCartesian"/> coordinates.
        /// </summary>
        /// <param name="coordinates">The set of <see cref="UnitCartesian"/> coordinates.</param>
        public UnitSpherical(UnitCartesian coordinates)
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
            return obj is UnitSpherical && Equals((UnitSpherical)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        [SuppressMessage("ReSharper", "CompareOfFloatsByEqualityOperator")]
        public bool Equals(UnitSpherical other)
        {
            return m_clock == other.m_clock &&
                   m_cone == other.m_cone;
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="UnitSpherical"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than or equal to <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        [Pure]
        public bool EqualsEpsilon(UnitSpherical other, double epsilon)
        {
            return Math.Abs(m_clock - other.m_clock) <= epsilon &&
                   Math.Abs(m_cone - other.m_cone) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_clock.GetHashCode(),
                                    m_cone.GetHashCode());
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// Clock, Cone.
        /// </returns>
        public override string ToString()
        {
            return string.Format("{0}, {1}", m_clock, m_cone);
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
   }
}
