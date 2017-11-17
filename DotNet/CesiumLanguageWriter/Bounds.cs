using System;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Holds two values which form the bounds of a range of real numbers.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct Bounds : IEquatable<Bounds>
    {
        /// <summary>
        /// Holds the values which form the bounds of a range of real numbers.
        /// </summary>
        /// <param name="lowerBound">The minimal value defining the range or numbers.</param>
        /// <param name="upperBound">The maximal value defining the range or numbers.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the <paramref name="upperBound"/> is less than the <paramref name="lowerBound"/>.
        /// </exception>
        public Bounds(double lowerBound, double upperBound)
        {
            if (upperBound < lowerBound)
            {
                throw new ArgumentException(CesiumLocalization.UpperBoundCannotBeLessThanLowerBound);
            }

            m_lowerBound = lowerBound;
            m_upperBound = upperBound;
        }

        /// <summary>
        /// Gets a set of <see cref="Bounds"/> representing the full range of real values from negative infinity to positive infinity.
        /// </summary>
        /// <remarks>
        /// Use <see cref="IsUnbounded"/> to test whether a <see cref="Bounds"/> instance is unbounded
        /// since it will return <see langword="true"/> if the values range from <see cref="double.NegativeInfinity"/> to <see cref="double.PositiveInfinity"/>.
        /// </remarks>
        public static Bounds Unbounded
        {
            get { return s_unbounded; }
        }

        /// <summary>
        /// Gets the minimal value defining the range of numbers.
        /// </summary>
        public double LowerBound
        {
            get { return m_lowerBound; }
        }

        /// <summary>
        /// Gets the maximal value defining the range of numbers.
        /// </summary>
        public double UpperBound
        {
            get { return m_upperBound; }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is Bounds && Equals((Bounds)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        [SuppressMessage("ReSharper", "CompareOfFloatsByEqualityOperator")]
        public bool Equals(Bounds other)
        {
            return m_lowerBound == other.m_lowerBound &&
                   m_upperBound == other.m_upperBound;
        }

        /// <summary>
        /// Indicates whether each value of another instance of this type
        /// is within the required tolerance of the corresponding value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Bounds"/> to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than or equal to <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(Bounds other, double epsilon)
        {
            return Math.Abs(m_lowerBound - other.m_lowerBound) <= epsilon &&
                   Math.Abs(m_upperBound - other.m_upperBound) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_lowerBound.GetHashCode(),
                                    m_upperBound.GetHashCode());
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the values of this instance in the form
        /// "LowerBound, UpperBound".
        /// </returns>
        public override string ToString()
        {
            return string.Format("{0}, {1}", m_lowerBound, m_upperBound);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(Bounds left, Bounds right)
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
        public static bool operator !=(Bounds left, Bounds right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Gets whether or not this instance has a finite value as either the lower or upper bound.
        /// </summary>
        public bool IsFinite
        {
            get { return !double.IsNegativeInfinity(m_lowerBound) && !double.IsPositiveInfinity(m_upperBound); }
        }

        /// <summary>
        /// Gets whether or not this instance ranges from <see cref="double.NegativeInfinity"/> to <see cref="double.PositiveInfinity"/>.
        /// </summary>
        public bool IsUnbounded
        {
            get { return double.IsNegativeInfinity(m_lowerBound) && double.IsPositiveInfinity(m_upperBound); }
        }

        private static readonly Bounds s_unbounded = new Bounds(double.NegativeInfinity, double.PositiveInfinity);

        private readonly double m_lowerBound;
        private readonly double m_upperBound;
    }
}