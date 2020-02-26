using System;
using System.Diagnostics.CodeAnalysis;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of curvilinear 3-dimensional coordinates.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct Cartographic : IEquatable<Cartographic>
    {
        /// <summary>
        /// Initializes a set of <see cref="Cartographic"/> coordinates from the provided values.
        /// </summary>
        /// <param name="longitude">The angular coordinate lying in the equatorial plane of the ellipsoid and measured from the prime meridian.</param>
        /// <param name="latitude">The angular coordinate measured perpendicular to the equatorial plane.</param>
        /// <param name="height">The linear coordinate measured perpendicular to the surface of the ellipsoid and positive above the surface.</param>
        public Cartographic(double longitude, double latitude, double height)
        {
            m_longitude = longitude;
            m_latitude = latitude;
            m_height = height;
        }

        /// <summary>
        /// Gets a set of <see cref="Cartographic"/> coordinates representing the zero vector.
        /// </summary>
        public static Cartographic Zero
        {
            get { return s_zero; }
        }

        /// <summary>
        /// Gets the angular coordinate lying in the equatorial plane of the ellipsoid and measured from the prime meridian.
        /// </summary>
        public double Longitude
        {
            get { return m_longitude; }
        }

        /// <summary>
        /// Gets the angular coordinate measured perpendicular to the equatorial plane.
        /// </summary>
        public double Latitude
        {
            get { return m_latitude; }
        }

        /// <summary>
        /// Gets the linear coordinate measured perpendicular to the surface of the ellipsoid and positive above the surface.
        /// </summary>
        public double Height
        {
            get { return m_height; }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is Cartographic && Equals((Cartographic)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        [SuppressMessage("ReSharper", "CompareOfFloatsByEqualityOperator")]
        public bool Equals(Cartographic other)
        {
            return m_longitude == other.m_longitude &&
                   m_latitude == other.m_latitude &&
                   m_height == other.m_height;
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartographic"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than or equal to <paramref name="epsilon"/>; otherwise <see langword="false"/>.
        /// </returns>
        [Pure]
        public bool EqualsEpsilon(Cartographic other, double epsilon)
        {
            return Math.Abs(m_longitude - other.m_longitude) <= epsilon &&
                   Math.Abs(m_latitude - other.m_latitude) <= epsilon &&
                   Math.Abs(m_height - other.m_height) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_longitude.GetHashCode(),
                                    m_latitude.GetHashCode(),
                                    m_height.GetHashCode());
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// "Longitude, Latitude, Height".
        /// </returns>
        public override string ToString()
        {
            return string.Format("{0}, {1}, {2}", m_longitude, m_latitude, m_height);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(Cartographic left, Cartographic right)
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
        public static bool operator !=(Cartographic left, Cartographic right)
        {
            return !left.Equals(right);
        }

        private static readonly Cartographic s_zero = new Cartographic(0.0, 0.0, 0.0);

        private readonly double m_latitude;
        private readonly double m_longitude;
        private readonly double m_height;
    }
}