using System;
using System.Globalization;
using System.Text;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Represents a span of time.
    /// <filter name="DotNet">This is different from the .NET <see cref="System.TimeSpan"/> class in that it</filter>
    /// <filter name="Java">This class</filter>
    /// offers the same precision as the <see cref="JulianDate"/> type.  It stores a
    /// number of days as an <see cref="int"/> and a number of seconds as a <see cref="double"/>.
    /// </summary>
    [CSToJavaExcludeBase("IComparable")]
    [CSToJavaImmutableValueType]
    public struct Duration : IComparable<Duration>, IComparable, IEquatable<Duration>
    {
        /// <summary>
        /// Initializes a new instance of <see cref="Duration"/> from a specified number
        /// of days, hours, minutes, and seconds.
        /// </summary>
        /// <param name="days">The number of days in the new <see cref="Duration"/>.</param>
        /// <param name="hours">The number of hours in the new <see cref="Duration"/>.</param>
        /// <param name="minutes">The number of minutes in the new <see cref="Duration"/>.</param>
        /// <param name="seconds">The number of seconds in the new <see cref="Duration"/>.</param>
        public Duration(int days, int hours, int minutes, double seconds)
            : this(days, HoursMinutesSecondsToSeconds(hours, minutes, seconds))
        {
        }

        /// <summary>
        /// Initializes a new instance of <see cref="Duration"/> from a specified number
        /// of days and seconds.
        /// </summary>
        /// <param name="days">The number of days in the new <see cref="Duration"/>.</param>
        /// <param name="seconds">The number of seconds in the new <see cref="Duration"/>.</param>
        public Duration(int days, double seconds)
        {
            // Ensure that the number of seconds is less than a whole (positive or negative) day.
            if (seconds >= TimeConstants.SecondsPerDay || seconds <= -TimeConstants.SecondsPerDay)
            {
                int newDays = (int)(seconds / TimeConstants.SecondsPerDay);
                days += newDays;
                seconds -= TimeConstants.SecondsPerDay * newDays;
            }

            // Ensure that days and seconds are either both negative or both positive
            if (days < 0 && seconds > 0)
            {
                ++days;
                seconds -= TimeConstants.SecondsPerDay;

                if (seconds < -TimeConstants.NextBefore86400)
                {
                    // In theory seconds can't actually be less than -86400.0.
                    // But it can be equal to that, or it can be in the 80-bit floating point
                    // unit and thus in between -86400.0 and the next smaller representable 64-bit
                    // double.  If it's the latter, it's in danger of being rounded to -86400.0.
                    // -86400.0 is of course not a valid value for seconds, so we need to
                    // reset it to 0.0 and decrement days.
                    //
                    // This can happen if the original seconds coming in is a very small
                    // positive number.  When we subtract 86400.0 from it, we get -86400.0 instead of
                    // something slightly greater than that as expected, because a double has more
                    // precision near 0.0 than near -86400.0.
                    --days;
                    seconds = 0.0;
                }
            }
            else if (days > 0 && seconds < 0)
            {
                --days;
                seconds += TimeConstants.SecondsPerDay;

                if (seconds > TimeConstants.NextBefore86400)
                {
                    // In theory seconds can't actually be greater than 86400.0.
                    // But it can be equal to that, or it can be in the 80-bit floating point
                    // unit and thus in between 86400.0 and the next smaller representable 64-bit
                    // double.  If it's the latter, it's in danger of being rounded to 86400.0.
                    // 86400.0 is of course not a valid value for seconds, so we need to
                    // reset it to 0.0 and increment day.
                    //
                    // This can happen if the original seconds coming in is a very small
                    // negative number.  When we add 86400.0 to it, we get 86400.0 instead of
                    // something slightly less than that as expected, because a double has more
                    // precision near 0.0 than near 86400.0.
                    ++days;
                    seconds = 0.0;
                }
            }

            m_days = days;
            m_seconds = seconds;
        }

        /// <summary>
        /// Converts the specified number of hours, minutes, and seconds to total duration in seconds.
        /// </summary>
        /// <param name="hours">The number of hours.</param>
        /// <param name="minutes">The number of minutes.</param>
        /// <param name="seconds">The number of seconds.</param>
        /// <returns>The corresponding duration in seconds.</returns>
        public static double HoursMinutesSecondsToSeconds(int hours, int minutes, double seconds)
        {
            return hours * TimeConstants.SecondsPerHour + minutes * TimeConstants.SecondsPerMinute + seconds;
        }

        /// <summary>
        /// Gets the largest possible value of a <see cref="Duration"/>.
        /// </summary>
        /// <remarks>
        /// The value is <see cref="int.MaxValue"/> days and 86399.0 seconds.
        /// </remarks>
        public static Duration MaxValue
        {
            get { return s_maxValue; }
        }

        /// <summary>
        /// Gets the smallest possible value of a <see cref="Duration"/>.
        /// </summary>
        /// <remarks>
        /// The value is <see cref="int.MinValue"/> days and -86399.0 seconds.
        /// </remarks>
        public static Duration MinValue
        {
            get { return s_minValue; }
        }

        /// <summary>
        /// Gets a <see cref="Duration"/> of 0 days and seconds.
        /// </summary>
        public static Duration Zero
        {
            get { return s_zero; }
        }

        /// <summary>
        /// Gets the day component of this <see cref="Duration"/>.
        /// </summary>
        public int Days
        {
            get { return m_days; }
        }

        /// <summary>
        /// Gets the seconds component of this <see cref="Duration"/>.  This is the number of seconds represented by
        /// this <see cref="Duration"/> in addition to the <see cref="Days"/>, so it will always be less than
        /// <see cref="TimeConstants.SecondsPerDay"/>.
        /// </summary>
        public double Seconds
        {
            get { return m_seconds; }
        }

        /// <summary>
        /// Gets the total number of whole and fractional days represented by this <see cref="Duration"/>.
        /// </summary>
        public double TotalDays
        {
            get { return m_days + m_seconds / TimeConstants.SecondsPerDay; }
        }

        /// <summary>
        /// Gets the total number of seconds represented by this <see cref="Duration"/>, including the seconds
        /// that compose the days returned by the <see cref="Days"/> property.
        /// </summary>
        public double TotalSeconds
        {
            get { return m_days * TimeConstants.SecondsPerDay + m_seconds; }
        }

        /// <summary>
        /// Returns the value of the <see cref="Duration"/> in <see cref="Days"/>:<see cref="Seconds"/>.
        /// </summary>
        /// <returns>The string.</returns>
        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendFormat(CultureInfo.CurrentCulture, "{0}:{1}", m_days, m_seconds);
            return builder.ToString();
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_days.GetHashCode(),
                                    m_seconds.GetHashCode());
        }

        /// <summary>
        /// Returns <see langword="true"/> if this <see cref="Duration"/> exactly equals another <see cref="Duration"/>, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical and the
        /// difference between the <see cref="Seconds"/> properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="other">The other <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if this <see cref="Duration"/> exactly equals the <paramref name="other"/> <see cref="Duration"/>, within the limits of floating point precision.</returns>
        public bool Equals(Duration other)
        {
            return m_days == other.m_days &&
                   Math.Abs(m_seconds - other.m_seconds) < Constants.Epsilon10;
        }

        /// <summary>
        /// Returns <see langword="true"/> if this <see cref="Duration"/> exactly equals another <see cref="Duration"/>, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical and the
        /// difference between the <see cref="Seconds"/> properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="obj">The other <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if this <see cref="Duration"/> exactly equals the <paramref name="obj"/> <see cref="Duration"/>, within the limits of floating point precision.</returns>
        public override bool Equals(object obj)
        {
            return obj is Duration && Equals((Duration)obj);
        }

        /// <summary>
        /// Returns <see langword="true"/> if this <see cref="Duration"/> is within <paramref name="epsilon"/> seconds of the
        /// specified <see cref="Duration"/>.  That is, in order for the <see cref="Duration">Durations</see> to be considered equal (and for
        /// this function to return <see langword="true"/>), the absolute value of the difference between them, in
        /// seconds, must be less than or equal to <paramref name="epsilon"/>.
        /// </summary>
        /// <param name="other">The <see cref="Duration"/> to compare to this <see cref="Duration"/>.</param>
        /// <param name="epsilon">The largest difference between the <see cref="Duration">Durations</see>, in seconds, such that they will be considered equal.</param>
        /// <returns><see langword="true"/> if the dates are equal as defined by the epsilon value.</returns>
        [Pure]
        public bool EqualsEpsilon(Duration other, double epsilon)
        {
            return Math.Abs(Subtract(other).TotalSeconds) <= epsilon;
        }

        /// <summary>
        /// Compares this instance with another instance of the same type.
        /// </summary>
        /// <param name="other">An object to compare with this instance.</param>
        /// <returns>
        /// A value indicating the relative order of the objects being compared.  The return value has these meanings:
        /// <list type="table">
        ///   <listheader>
        ///     <term>Value</term>
        ///     <description>Meaning</description>
        ///   </listheader>
        ///   <item>
        ///     <term>Less than zero</term>
        ///     <description>
        ///       This instance is less than <paramref name="other"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Zero</term>
        ///     <description>
        ///       This instance is equal to <paramref name="other"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Greater than zero</term>
        ///     <description>
        ///       This instance is greater than <paramref name="other"/>.
        ///     </description>
        ///   </item>
        /// </list>
        /// </returns>
        public int CompareTo(Duration other)
        {
            int result = m_days.CompareTo(other.m_days);
            if (result == 0)
            {
                result = m_seconds.CompareTo(other.m_seconds);
            }

            return result;
        }

        /// <summary>
        /// Compares this instance with another instance of the same type.
        /// </summary>
        /// <param name="obj">An object to compare with this instance.</param>
        /// <returns>
        /// A value indicating the relative order of the objects being compared.  The return value has these meanings:
        /// <list type="table">
        ///   <listheader>
        ///     <term>Value</term>
        ///     <description>Meaning</description>
        ///   </listheader>
        ///   <item>
        ///     <term>Less than zero</term>
        ///     <description>
        ///       This instance is less than <paramref name="obj"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Zero</term>
        ///     <description>
        ///       This instance is equal to <paramref name="obj"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Greater than zero</term>
        ///     <description>
        ///       This instance is greater than <paramref name="obj"/>.
        ///     </description>
        ///   </item>
        /// </list>
        /// </returns>
        [CSToJavaExclude("The T in Comparable<T> in Java prevents having an Object overload.")]
        public int CompareTo(object obj)
        {
            if (obj == null)
                return 1;
            if (!(obj is Duration))
                throw new ArgumentException(CesiumLocalization.ArgumentTypeInvalid, "obj");

            return CompareTo((Duration)obj);
        }

        /// <summary>
        /// Adds the specified <see cref="Duration"/> to this instance.
        /// </summary>
        /// <param name="other">The <see cref="Duration"/> to add to this instance.</param>
        /// <returns>A <see cref="Duration"/> that represents the value of this instance plus the value of <paramref name="other"/>.</returns>
        public Duration Add(Duration other)
        {
            int days = m_days + other.m_days;
            double seconds = m_seconds + other.m_seconds;
            return new Duration(days, seconds);
        }

        /// <summary>
        /// Subtracts the specified <see cref="Duration"/> from this instance.
        /// </summary>
        /// <param name="other">The <see cref="Duration"/> to subtract from this instance.</param>
        /// <returns>A <see cref="Duration"/> that represents the value of this instance minus the value of <paramref name="other"/>.</returns>
        public Duration Subtract(Duration other)
        {
            int days = m_days - other.m_days;
            double seconds = m_seconds - other.m_seconds;
            return new Duration(days, seconds);
        }

        /// <summary>
        /// Multiplies the <see cref="Duration"/> by a constant.
        /// </summary>
        /// <param name="constant">The constant by which to multiply the <see cref="Duration"/>.</param>
        /// <returns>A <see cref="Duration"/> that represents the value of this instance multiplied by the constant.</returns>
        [Pure]
        public Duration Multiply(double constant)
        {
            double days = m_days * constant;
            int wholeDays = (int)days;
            double fractionOfDay = days - wholeDays;
            double seconds = fractionOfDay * TimeConstants.SecondsPerDay + m_seconds * constant;
            return new Duration(wholeDays, seconds);
        }

        /// <summary>
        /// Divides the <see cref="Duration"/> by another <see cref="Duration"/>, yield a constant.
        /// </summary>
        /// <param name="divisor">The <see cref="Duration"/> by which to divide this <see cref="Duration"/>.</param>
        /// <returns>The result of dividing this <see cref="Duration"/> by another.</returns>
        [Pure]
        public double Divide(Duration divisor)
        {
            return TotalSeconds / divisor.TotalSeconds;
        }

        /// <summary>
        /// Divides the <see cref="Duration"/> by a constant.
        /// </summary>
        /// <param name="constant">The constant by which to divide the <see cref="Duration"/>.</param>
        /// <returns>A <see cref="Duration"/> that represents the value of this instance divided by the constant.</returns>
        [Pure]
        public Duration Divide(double constant)
        {
            double days = m_days / constant;
            int wholeDays = (int)days;
            double fractionOfDay = days - wholeDays;
            double seconds = fractionOfDay * TimeConstants.SecondsPerDay + m_seconds / constant;
            return new Duration(wholeDays, seconds);
        }

        /// <summary>
        /// Adds a specified number of seconds to this <see cref="Duration"/> and returns the new <see cref="Duration"/>.
        /// </summary>
        /// <param name="seconds">The number of seconds to add.</param>
        /// <returns>A new <see cref="Duration"/> which is the sum of the original <see cref="Duration"/> and the specified number of seconds.</returns>
        [Pure]
        public Duration AddSeconds(double seconds)
        {
            return Add(FromSeconds(seconds));
        }

        /// <summary>
        /// Adds a specified number of days to this <see cref="Duration"/> and returns the new <see cref="Duration"/>.
        /// </summary>
        /// <param name="days">The number of days to add.</param>
        /// <returns>A new <see cref="Duration"/> which is the sum of the original <see cref="Duration"/> and the specified number of days.</returns>
        [Pure]
        public Duration AddDays(double days)
        {
            return Add(FromDays(days));
        }

        /// <summary>
        /// Returns <see langword="true"/> if two <see cref="Duration">Durations</see> are exactly equal, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical and the
        /// difference between the <see cref="Seconds"/> properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="left">The left <see cref="Duration"/>.</param>
        /// <param name="right">The second <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if the <see cref="Duration">Durations</see> are equal, otherwise <see langword="false"/>.</returns>
        public static bool operator ==(Duration left, Duration right)
        {
            return left.Equals(right);
        }

        /// <summary>
        /// Returns <see langword="true"/> if two <see cref="Duration">Durations</see> are NOT exactly equal, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical (or one must be null) and the
        /// difference between the <see cref="Seconds"/> properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="left">The first <see cref="Duration"/>.</param>
        /// <param name="right">The second <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if the <see cref="Duration">Durations</see> are not equal, otherwise <see langword="false"/>.</returns>
        public static bool operator !=(Duration left, Duration right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is shorter than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left <see cref="Duration"/>.</param>
        /// <param name="right">The right <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if left is less than right, otherwise <see langword="false"/>.</returns>
        public static bool operator <(Duration left, Duration right)
        {
            return left.CompareTo(right) < 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is longer than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left <see cref="Duration"/>.</param>
        /// <param name="right">The right <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if left is greater than right, otherwise <see langword="false"/>.</returns>
        public static bool operator >(Duration left, Duration right)
        {
            return left.CompareTo(right) > 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is shorter than or exactly equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left <see cref="Duration"/>.</param>
        /// <param name="right">The right <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if left is less than or equal to right, otherwise <see langword="false"/>.</returns>
        public static bool operator <=(Duration left, Duration right)
        {
            return left.CompareTo(right) <= 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is longer than or exactly equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left <see cref="Duration"/>.</param>
        /// <param name="right">The right <see cref="Duration"/>.</param>
        /// <returns><see langword="true"/> if left is greater than or equal to right, otherwise <see langword="false"/>.</returns>
        public static bool operator >=(Duration left, Duration right)
        {
            return left.CompareTo(right) >= 0;
        }

        /// <summary>
        /// Adds two specified <see cref="Duration"/> instances.
        /// </summary>
        /// <param name="left">The first <see cref="Duration"/> to add.</param>
        /// <param name="right">The second <see cref="Duration"/> to add.</param>
        /// <returns>The sum of <paramref name="left"/> and <paramref name="right"/>.</returns>
        public static Duration operator +(Duration left, Duration right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Subtracts a specified <see cref="Duration"/> from another specified <see cref="Duration"/>.
        /// </summary>
        /// <param name="left">The subtrahend.</param>
        /// <param name="right">The minuend.</param>
        /// <returns>The difference <paramref name="left"/> minus <paramref name="right"/>.</returns>
        public static Duration operator -(Duration left, Duration right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Inverts a specified <see cref="Duration"/>.  For example, if the <paramref name="value"/> represents a positive
        /// quantity of time, the returned <see cref="Duration"/> will be a negative quantity of time.
        /// </summary>
        /// <param name="value">The value to invert.</param>
        /// <returns>The inverted <see cref="Duration"/>.</returns>
        public static Duration operator -(Duration value)
        {
            return new Duration(-value.m_days, -value.m_seconds);
        }

        /// <summary>
        /// Multiplies the <see cref="Duration"/> by a constant.
        /// </summary>
        /// <param name="left">The <see cref="Duration"/> to multiply.</param>
        /// <param name="right">The constant by which to multiply the <see cref="Duration"/>.</param>
        /// <returns>A <see cref="Duration"/> that represents the value of this instance multiplied by the constant.</returns>
        public static Duration operator *(Duration left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Divides the <see cref="Duration"/> by another duration.
        /// </summary>
        /// <param name="dividend">The <see cref="Duration"/> to divide.</param>
        /// <param name="divisor">The <see cref="Duration"/> by which to divide the <see cref="Duration"/>.</param>
        /// <returns>The result of dividing the dividend by the divisor.</returns>
        public static double operator /(Duration dividend, Duration divisor)
        {
            return dividend.Divide(divisor);
        }

        /// <summary>
        /// Divides the <see cref="Duration"/> by a constant.
        /// </summary>
        /// <param name="dividend">The <see cref="Duration"/> to divide.</param>
        /// <param name="divisor">The constant by which to divide the <see cref="Duration"/>.</param>
        /// <returns>The result of dividing the dividend by the divisor.</returns>
        public static Duration operator /(Duration dividend, double divisor)
        {
            return dividend.Divide(divisor);
        }

        /// <summary>
        /// Returns a <see cref="Duration"/> that represents the specified number of days.
        /// </summary>
        /// <param name="days">The number of days to be represented by the returned <see cref="Duration"/>.</param>
        /// <returns>A <see cref="Duration"/> representing the specified number of days.</returns>
        public static Duration FromDays(double days)
        {
            int wholeDays = (int)days;
            double seconds = (days - wholeDays) * TimeConstants.SecondsPerDay;
            return new Duration(wholeDays, seconds);
        }

        /// <summary>
        /// Returns a <see cref="Duration"/> that represents the specified number of seconds.
        /// </summary>
        /// <param name="seconds">The number of seconds to be represented by the returned <see cref="Duration"/>.</param>
        /// <returns>A <see cref="Duration"/> representing the specified number of seconds.</returns>
        public static Duration FromSeconds(double seconds)
        {
            return new Duration(0, seconds);
        }

        [CSToJavaFinalField]
        private static readonly Duration s_maxValue = new Duration(int.MaxValue, 0.0);
        [CSToJavaFinalField]
        private static readonly Duration s_minValue = new Duration(int.MinValue, 0.0);
        [CSToJavaFinalField]
        private static readonly Duration s_zero = new Duration(0, 0.0);

        private readonly int m_days;
        private readonly double m_seconds;
    }
}
