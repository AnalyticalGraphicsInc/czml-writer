using System;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    ///<summary>
    /// A bounding rectangle in a two-dimensional plane given by two corner points.
    ///</summary>
    [CSToJavaImmutableValueType]
    public struct BoundingRectangle : IEquatable<BoundingRectangle>
    {
        /// <summary>
        /// Gets a <see cref="BoundingRectangle"/> with all values set to zero.
        /// </summary>
        public static BoundingRectangle Empty
        {
            get { return s_empty; }
        }

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="left">The x coordinate of the lower-left corner.</param>
        /// <param name="bottom">The y coordinate of the lower-left corner.</param>
        /// <param name="right">The x coordinate of the upper-right corner.</param>
        /// <param name="top">The y coordinate of the upper-right corner.</param>
        /// <exception cref="ArgumentException">
        /// Thrown when the right parameter is less than the left parameter or when the top parameter is less than the bottom parameter.
        /// </exception>
        public BoundingRectangle(double left, double bottom, double right, double top)
        {
            if (right < left)
                throw new ArgumentException("right must be greater than or equal to left");

            if (top < bottom)
                throw new ArgumentException("top must be greater than or equal to bottom");

            m_left = left;
            m_bottom = bottom;
            m_right = right;
            m_top = top;
        }

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="x">The x coordinate of the lower-left corner.</param>
        /// <param name="y">The y coordinate of the lower-left corner.</param>
        /// <param name="width">The width of the rectangle.</param>
        /// <param name="height">The height of the rectangle.</param>
        public static BoundingRectangle FromWidthHeight(double x, double y, double width, double height)
        {
            return new BoundingRectangle(x, y, x + width, y + height);
        }

        ///<summary>
        /// Gets the x-coordinate of the left edge of the rectangle.
        ///</summary>
        public double Left
        {
            get { return m_left; }
        }

        ///<summary>
        /// Gets the y-coordinate of the top edge of the rectangle.
        ///</summary>
        public double Top
        {
            get { return m_top; }
        }

        ///<summary>
        /// Gets the y-coordinate of the bottom edge of the rectangle.
        ///</summary>
        public double Bottom
        {
            get { return m_bottom; }
        }

        ///<summary>
        /// Gets the x-coordinate of the right edge of the rectangle.
        ///</summary>
        public double Right
        {
            get { return m_right; }
        }

        ///<summary>
        /// Gets the width of the rectangle.
        ///</summary>
        public double Width
        {
            get { return m_right - m_left; }
        }

        ///<summary>
        /// Gets the height of the rectangle.
        ///</summary>
        public double Height
        {
            get { return m_top - m_bottom; }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is BoundingRectangle && Equals((BoundingRectangle)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(BoundingRectangle other)
        {
            return m_left.Equals(other.m_left) &&
                   m_bottom.Equals(other.m_bottom) &&
                   m_right.Equals(other.m_right) &&
                   m_top.Equals(other.m_top);
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="BoundingRectangle"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than or equal to <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        [Pure]
        public bool EqualsEpsilon(BoundingRectangle other, double epsilon)
        {
            return Math.Abs(m_left - other.m_left) <= epsilon &&
                   Math.Abs(m_bottom - other.m_bottom) <= epsilon &&
                   Math.Abs(m_right - other.m_right) <= epsilon &&
                   Math.Abs(m_top - other.m_top) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_left.GetHashCode(),
                                    m_bottom.GetHashCode(),
                                    m_right.GetHashCode(),
                                    m_top.GetHashCode());
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// "Left, Bottom, Right, Top".
        /// </returns>
        public override string ToString()
        {
            return string.Format("{0}, {1}, {2}, {3}", m_left, m_bottom, m_right, m_top);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(BoundingRectangle left, BoundingRectangle right)
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
        public static bool operator !=(BoundingRectangle left, BoundingRectangle right)
        {
            return !left.Equals(right);
        }

        private readonly double m_left;
        private readonly double m_right;
        private readonly double m_bottom;
        private readonly double m_top;

        private static readonly BoundingRectangle s_empty = new BoundingRectangle(0, 0, 0, 0);
    }
}