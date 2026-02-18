using System;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Describes a single leap second.
    /// </summary>
    /// <remarks>
    /// The International Earth Rotation Service (IERS) periodically introduces an intercalary adjustment
    /// to the Coordinated Universal Time (UTC) time scale in order to keep it in close agreement with the
    /// Universal Time (UT1) time scale.  This adjustment amounts to a one second discontinuity, a leap second,
    /// in the UTC time scale that, in addition to the UT1 time scales, also affects transformations to
    /// other continuous time scales.  Since the inception of leap seconds, all adjustments have been
    /// performed either at the end of 30 June or 31 December UTC though a leap second could, by rule,
    /// be applied at the end of any month.
    /// </remarks>
    [CSToJavaImmutableValueType]
    public struct LeapSecond : IEquatable<LeapSecond>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="date">The Julian date of the leap second, in Coordinated Universal Time (UTC).</param>
        /// <param name="totalTaiOffsetFromUtc">The offset of TAI from UTC after this leap second.</param>
        public LeapSecond(double date, double totalTaiOffsetFromUtc)
        {
            m_date = new JulianDate(date, TimeStandard.CoordinatedUniversalTime);
            m_totalTaiOffsetFromUtc = totalTaiOffsetFromUtc;
        }

        /// <summary>
        /// Initializes a new instance of a Leap Second.
        /// </summary>
        /// <param name="date">The date of the leap second.  This date must be in Coordinated Universal Time (UTC).</param>
        /// <param name="totalTaiOffsetFromUtc">The offset of TAI from UTC after this leap second.</param>
        /// <exception cref="ArgumentException">
        /// Thrown if the given date is not in UTC.
        /// </exception>
        public LeapSecond(JulianDate date, double totalTaiOffsetFromUtc)
        {
            if (date.Standard != TimeStandard.CoordinatedUniversalTime)
                throw new ArgumentException(CesiumLocalization.DateMustBeUTC, "date");

            m_date = date;
            m_totalTaiOffsetFromUtc = totalTaiOffsetFromUtc;
        }

        /// <summary>
        /// Gets the date of the leap second.
        /// </summary>
        public JulianDate Date
        {
            get { return m_date; }
        }

        /// <summary>
        /// Gets the total difference TAI - UTC after this leap second, in seconds.
        /// </summary>
        public double TotalTaiOffsetFromUtc
        {
            get { return m_totalTaiOffsetFromUtc; }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is LeapSecond && Equals((LeapSecond)obj);
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        [SuppressMessage("ReSharper", "CompareOfFloatsByEqualityOperator")]
        public bool Equals(LeapSecond other)
        {
            return m_date.IsIdentical(other.m_date) &&
                   m_totalTaiOffsetFromUtc == other.m_totalTaiOffsetFromUtc;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_date.GetHashCode(),
                                    m_totalTaiOffsetFromUtc.GetHashCode());
        }

        /// <summary>
        /// Returns the date of this LeapSecond and offset from UTC as a string.
        /// </summary>
        /// <returns>The string.</returns>
        public override string ToString()
        {
            return string.Format("{0}, {1}", m_date, m_totalTaiOffsetFromUtc);
        }


        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(LeapSecond left, LeapSecond right)
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
        public static bool operator !=(LeapSecond left, LeapSecond right)
        {
            return !left.Equals(right);
        }

        private readonly JulianDate m_date;
        private readonly double m_totalTaiOffsetFromUtc;
    }
}
