using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A two dimensional region specified as longitude and latitude coordinates.
    /// </summary>
    public class CartographicExtent : IEquatable<CartographicExtent>
    {
        /// <summary>
        /// Initializes a new instance with the specified extents.
        /// </summary>
        /// <param name="west">The westernmost longitude.</param>
        /// <param name="south">The southernmost latitude.</param>
        /// <param name="east">The easternmost longitude.</param>
        /// <param name="north">The northernmost latitude.</param>
        public CartographicExtent(double west, double south, double east, double north)
        {
            m_west = west;
            m_south = south;
            m_east = east;
            m_north = north;
        }

        /// <summary>
        /// Gets the northernmost latitude.
        /// </summary>
        public double NorthLatitude
        {
            get { return m_north; }
        }

        /// <summary>
        /// Gets the southernmost latitude.
        /// </summary>
        public double SouthLatitude
        {
            get { return m_south; }
        }

        /// <summary>
        /// Gets the easternmost longitude.
        /// </summary>
        public double EastLongitude
        {
            get { return m_east; }
        }

        /// <summary>
        /// Gets the westernmost longitude.
        /// </summary>
        public double WestLongitude
        {
            get { return m_west; }
        }

        /// <summary>
        /// Returns true if the specified location is inside the extent, otherwise false.
        /// </summary>
        /// <param name="longitude">The longitude.</param>
        /// <param name="latitude">The latitude.</param>
        /// <returns>
        /// <see langword="true"/> if the specified location is inside the extent (or on the border),
        /// otherwise <see langword="false"/>.
        /// </returns>
        public bool IsInsideExtent(double longitude, double latitude)
        {
            return longitude >= m_west &&
                   longitude <= m_east &&
                   latitude >= m_south &&
                   latitude <= m_north;
        }

        /// <summary>
        /// Computes the union of this extent with another extent.  The union of two extents is
        /// the smallest extent that includes both.
        /// </summary>
        /// <param name="other">The other extent.</param>
        /// <returns>The union of the two extents.</returns>
        public CartographicExtent Union(CartographicExtent other)
        {
            return new CartographicExtent(Math.Min(m_west, other.m_west),
                                          Math.Min(m_south, other.m_south),
                                          Math.Max(m_east, other.m_east),
                                          Math.Max(m_north, other.m_north));
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="CartographicExtent"/> to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(CartographicExtent other, double epsilon)
        {
            return Math.Abs(m_north - other.m_north) < epsilon &&
                   Math.Abs(m_south - other.m_south) < epsilon &&
                   Math.Abs(m_east - other.m_east) < epsilon &&
                   Math.Abs(m_west - other.m_west) < epsilon;
        }

        /// <summary>
        /// Indicates whether another <see cref="CartographicExtent"/> is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The <see cref="CartographicExtent"/> to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(CartographicExtent other)
        {
            return other != null &&
                   m_north == other.m_north &&
                   m_south == other.m_south &&
                   m_east == other.m_east &&
                   m_west == other.m_west;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return Equals(obj as CartographicExtent);
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_north.GetHashCode() ^ m_south.GetHashCode() ^ m_east.GetHashCode() ^ m_west.GetHashCode();
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(CartographicExtent left, CartographicExtent right)
        {
            if (ReferenceEquals(left, null))
                return ReferenceEquals(right, null);
            else
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
        public static bool operator !=(CartographicExtent left, CartographicExtent right)
        {
            if (ReferenceEquals(left, null))
                return !ReferenceEquals(right, null);
            else
                return !left.Equals(right);
        }

        private readonly double m_north;
        private readonly double m_south;
        private readonly double m_east;
        private readonly double m_west;
    }
}
