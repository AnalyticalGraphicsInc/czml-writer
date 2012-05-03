using System;
using System.Globalization;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Represents a span of time.  
    /// <filter name="DotNet,Silverlight">This is different from the .NET <see cref="System.TimeSpan"/> class in that it</filter>
    /// <filter name="Java">This class</filter>
    /// offers the same precision as the <see cref="JulianDate"/> type.  It stores a
    /// number of days as an <see cref="System.Int32"/> and a number of seconds as a <see cref="System.Double"/>.
    /// </summary>
    [CSToJavaExcludeBase("IComparable")]
    [CSToJavaImmutableValueType]
    public struct Duration :
        IComparable<Duration>,
        IComparable,
        IEquatable<Duration>
    {
        /// <summary>
        /// Gets the largest possible value of a <see cref="Duration"/>. 
        /// </summary>
        /// <remarks>
        /// The value is <see cref="Int32.MaxValue"/> days and 86399.0 seconds.
        /// </remarks>
        public static Duration MaxValue
        {
            get { return s_maxValue; }
        }

        /// <summary>
        /// Gets the smallest possible value of a <see cref="Duration"/>. 
        /// </summary>
        /// <remarks>
        /// The value is <see cref="Int32.MinValue"/> days and -86399.0 seconds.
        /// </remarks>
        public static Duration MinValue
        {
            get { return s_minValue; }
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
        /// Initializes a new instance of Duration from a specified number
        /// of days, hours, minutes, and seconds.
        /// </summary>
        /// <param name="days">The number of days in the new duration.</param>
        /// <param name="hours">The number of hours in the new duration.</param>
        /// <param name="minutes">The number of minutes in the new duration.</param>
        /// <param name="seconds">The number of seconds in the new duration.</param>
        public Duration(int days, int hours, int minutes, double seconds) :
            this(days, Duration.HoursMinutesSecondsToSeconds(hours, minutes, seconds))
        {
        }

        /// <summary>
        /// Initializes a new instance of Duration from a specified number
        /// of days and seconds.
        /// </summary>
        /// <param name="days">The number of days in the new duration.</param>
        /// <param name="seconds">The number of seconds in the new duration.</param>
        public Duration(int days, double seconds)
        {
            // Ensure that the number of seconds is less than a whole (positive or negative) day.
            if (seconds >= 86400.0 || seconds <= -86400.0)
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
        /// Initializes a new Duration from a <see cref="System.TimeSpan"/>.
        /// </summary>
        /// <param name="timeSpan">The time span.</param>
        public Duration(TimeSpan timeSpan)
        {
            m_days = timeSpan.Days;
            m_seconds = (timeSpan - TimeSpan.FromDays(m_days)).TotalSeconds;
        }

        /// <summary>
        /// Gets the day component of this duration.
        /// </summary>
        public int Days
        {
            get
            {
                return m_days;
            }
        }

        /// <summary>
        /// Gets the seconds component of this duration.  This is the number of seconds represented by
        /// this duration in addition to the <see cref="Days"/>, so it will always be less than
        /// <see cref="TimeConstants.SecondsPerDay"/>.
        /// </summary>
        public double Seconds
        {
            get
            {
                return m_seconds;
            }
        }

        /// <summary>
        /// Gets the total number of whole and fractional days represented by this Duration.
        /// </summary>
        public double TotalDays
        {
            get
            {
                return (double)Days + (Seconds / TimeConstants.SecondsPerDay);
            }
        }

        /// <summary>
        /// Gets the total number of seconds represented by this duration, including the seconds
        /// that compose the days returned by the <see cref="Days"/> property.
        /// </summary>
        public double TotalSeconds
        {
            get
            {
                return Days * TimeConstants.SecondsPerDay + Seconds;
            }
        }

        /// <summary>
        /// Returns a <see cref="System.TimeSpan"/> equivalent to this Duration.
        /// </summary>
        /// <returns>The time span.</returns>
        [CSToJavaRename("toPeriod")]
        public TimeSpan ToTimeSpan()
        {
            long dayTicks = Days * TimeSpan.TicksPerDay;
            long secondTicks = (long)Math.Round(Seconds * TimeSpan.TicksPerSecond);

            return new TimeSpan(dayTicks + secondTicks);
        }

        /// <summary>
        /// Returns the value of the <see cref="Duration"/> in <see cref="Days"/>:<see cref="Seconds"/>.
        /// </summary>
        /// <returns>The string.</returns>
        public override string ToString()
        {
            return String.Format(CultureInfo.CurrentCulture, "{0}:{1}", Days, Seconds);
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return Days.GetHashCode() ^ Seconds.GetHashCode();
        }

        /// <summary>
        /// Returns true if this Duration exactly equals another duration, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical and the difference between the <see cref="Seconds"/>
        /// properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="other">The other duration.</param>
        /// <returns>true if this duration exactly equals the <paramref name="other"/> duration, within the limits of floating point precision.</returns>
        public bool Equals(Duration other)
        {
            return Days == other.Days &&
                   (m_seconds - other.m_seconds) < 1e-10 &&
                   (m_seconds - other.m_seconds) > -1e-10;
        }

        /// <summary>
        /// Returns true if this Duration exactly equals another duration, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical and the
        /// difference between the <see cref="Seconds"/> properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="obj">The other duration.</param>
        /// <returns>true if this duration exactly equals the <paramref name="obj"/> duration, within the limits of floating point precision.</returns>
        public override bool Equals(object obj)
        {
            if (obj is Duration)
            {
                return Equals((Duration)obj);
            }
            return false;
        }

        /// <summary>
        /// Returns true if this Duration is within <paramref name="epsilon"/> seconds of the
        /// specified Duration.  That is, in order for the Durations to be considered equal (and for
        /// this function to return true), the absolute value of the difference between them, in
        /// seconds, must be less than <paramref name="epsilon"/>.
        /// </summary>
        /// <param name="other">The Duration to compare to this Duration.</param>
        /// <param name="epsilon">The smallest difference between the Durations, in seconds, such that they will NOT be considered equal.</param>
        /// <returns>true if the dates are equal as defined by the epsilon value.</returns>
        public bool EqualsEpsilon(Duration other, double epsilon)
        {
            return Math.Abs(Subtract(other).TotalSeconds) < epsilon;
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
            if (Days != other.Days)
            {
                if (Days < other.Days)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                if (Seconds == other.Seconds)
                {
                    return 0;
                }
                else if (Seconds < other.Seconds)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
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
            {
                return 1;
            }
            else if (!(obj is Duration))
            {
                throw new ArgumentException(CesiumLocalization.ArgumentTypeInvalid, "obj");
            }
            else
            {
                return CompareTo((Duration)obj);
            }
        }

        /// <summary>
        /// Adds the specified Duration to this instance.
        /// </summary>
        /// <param name="other">The duration to add to this instance.</param>
        /// <returns>A <see cref="Duration"/> that represents the value of this instance plus the value of <paramref name="other"/>.</returns>
        public Duration Add(Duration other)
        {
            return new Duration(Days + other.Days, Seconds + other.Seconds);
        }

        /// <summary>
        /// Subtracts the specified Duration from this instance.
        /// </summary>
        /// <param name="other">The Duration to subtract from this instance.</param>
        /// <returns>A Duration that represents the value of this instance minus the value of other.</returns>
        public Duration Subtract(Duration other)
        {
            return new Duration(Days - other.Days, Seconds - other.Seconds);
        }

        /// <summary>
        /// Multiplies the duration by a constant.
        /// </summary>
        /// <param name="constant">The constant by which to multiply the Duration.</param>
        /// <returns>A Duration that represents the value of this instance multiplied by the constant.</returns>
        public Duration Multiply(double constant)
        {
            double days = (double)Days * constant;
            int wholeDays = (int)days;
            double fractionOfDay = days - (double)wholeDays;
            double seconds = fractionOfDay * TimeConstants.SecondsPerDay + Seconds * constant;
            return new Duration(wholeDays, seconds);
        }

        /// <summary>
        /// Divides the duration by another duration, yield a constant.
        /// </summary>
        /// <param name="divisor">The duration by which to divide this duration.</param>
        /// <returns>The result of dividing this Duration by another.</returns>
        public double Divide(Duration divisor)
        {
            return TotalSeconds / divisor.TotalSeconds;
        }

        /// <summary>
        /// Divides the duration by a constant.
        /// </summary>
        /// <param name="constant">The constant by which to divide the <see cref="Duration"/>.</param>
        /// <returns>A <see cref="Duration"/> that represents the value of this instance divided by the constant.</returns>
        public Duration Divide(double constant)
        {
            double days = (double)Days / constant;
            int wholeDays = (int)days;
            double fractionOfDay = days - (double)wholeDays;
            double seconds = fractionOfDay * TimeConstants.SecondsPerDay + Seconds / constant;
            return new Duration(wholeDays, seconds);
        }

        /// <summary>
        /// Adds a specified number of seconds to this duration and returns the new duration.
        /// </summary>
        /// <param name="seconds">The number of seconds to add.</param>
        /// <returns>A new duration which is the sum of the original duration and the specified number of seconds.</returns>
        public Duration AddSeconds(double seconds)
        {
            return Add(Duration.FromSeconds(seconds));
        }

        /// <summary>
        /// Adds a specified number of days to this duration and returns the new duration.
        /// </summary>
        /// <param name="days">The number of days to add.</param>
        /// <returns>A new duration which is the sum of the original duration and the specified number of days.</returns>
        public Duration AddDays(double days)
        {
            return Add(Duration.FromDays(days));
        }

        /// <summary>
        /// Returns true if two Durations are exactly equal, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical and the
        /// difference between the <see cref="Seconds"/> properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="left">The left duration.</param>
        /// <param name="right">The second duration.</param>
        /// <returns><see langword="true"/> if the durations are equal, otherwise <see langword="false"/>.</returns>
        public static bool operator ==(Duration left, Duration right)
        {
            return left.Equals(right);
        }

        /// <summary>
        /// Returns true if two Durations are NOT exactly equal, within the limits
        /// of floating point precision.  To be considered equal, the <see cref="Days"/>
        /// property must be identical (or one must be null) and the
        /// difference between the <see cref="Seconds"/> properties must be less than 1.0e-10.
        /// </summary>
        /// <param name="left">The first duration.</param>
        /// <param name="right">The second duration.</param>
        /// <returns><see langword="true"/> if the durations are not equal, otherwise <see langword="false"/>.</returns>
        public static bool operator !=(Duration left, Duration right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> is shorter than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left duration.</param>
        /// <param name="right">The right duration.</param>
        /// <returns>true if left is less than right, otherwise false.</returns>
        public static bool operator <(Duration left, Duration right)
        {
            return left.CompareTo(right) < 0;
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> is longer than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left duration.</param>
        /// <param name="right">The right duration.</param>
        /// <returns>true if left is greater than right, otherwise false.</returns>
        public static bool operator >(Duration left, Duration right)
        {
            return left.CompareTo(right) > 0;
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> is shorter than or exactly equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left duration.</param>
        /// <param name="right">The right duration.</param>
        /// <returns>true if left is less than or equal to right, otherwise false.</returns>
        public static bool operator <=(Duration left, Duration right)
        {
            return left.CompareTo(right) <= 0;
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> is longer than or exactly equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The left duration.</param>
        /// <param name="right">The right duration.</param>
        /// <returns>true if left is greater than or equal to right, otherwise false.</returns>
        public static bool operator >=(Duration left, Duration right)
        {
            return left.CompareTo(right) >= 0;
        }

        /// <summary>
        /// Adds two specified Duration instances.
        /// </summary>
        /// <param name="left">The first duration to add.</param>
        /// <param name="right">The second duration to add.</param>
        /// <returns>The sum of <paramref name="left"/> and <paramref name="right"/>.</returns>
        public static Duration operator +(Duration left, Duration right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Subtracts a specified Duration from another specified Duration.
        /// </summary>
        /// <param name="left">The subtrahend.</param>
        /// <param name="right">The minuend.</param>
        /// <returns>The difference <paramref name="left"/> minus <paramref name="right"/>.</returns>
        public static Duration operator -(Duration left, Duration right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Inverts a specified Duration.  For example, if the <paramref name="value"/> represents a positive
        /// quantity of time, the returned Duration will be a negative quantity of time.
        /// </summary>
        /// <param name="value">The value to invert.</param>
        /// <returns>The inverted duration.</returns>
        public static Duration operator -(Duration value)
        {
            return new Duration(-value.m_days, -value.m_seconds);
        }

        /// <summary>
        /// Multiplies the duration by a constant.
        /// </summary>
        /// <param name="left">The duration to multiply.</param>
        /// <param name="right">The constant by which to multiply the Duration.</param>
        /// <returns>A Duration that represents the value of this instance multiplied by the constant.</returns>
        public static Duration operator *(Duration left, double right)
        {
            return left.Multiply(right);
        }

        /// <summary>
        /// Divides the duration by another duration.
        /// </summary>
        /// <param name="dividend">The duration to divide.</param>
        /// <param name="divisor">The duration by which to divide the Duration.</param>
        /// <returns>The result of dividing the dividend by the divisor.</returns>
        public static double operator /(Duration dividend, Duration divisor)
        {
            return dividend.Divide(divisor);
        }

        /// <summary>
        /// Divides the duration by a constant.
        /// </summary>
        /// <param name="dividend">The duration to divide.</param>
        /// <param name="divisor">The constant by which to divide the duration.</param>
        /// <returns>The result of dividing the dividend by the divisor.</returns>
        public static Duration operator /(Duration dividend, double divisor)
        {
            return dividend.Divide(divisor);
        }

        /// <summary>
        /// Returns a Duration that represents the specified number of days.
        /// </summary>
        /// <param name="days">The number of days to be represented by the returned duration.</param>
        /// <returns>A <see cref="Duration"/> representing the specified number of days.</returns>
        public static Duration FromDays(double days)
        {
            int wholeDays = (int)days;
            double seconds = (days - wholeDays) * TimeConstants.SecondsPerDay;
            return new Duration(wholeDays, seconds);
        }

        /// <summary>
        /// Returns a Duration that represents the specified number of seconds.
        /// </summary>
        /// <param name="seconds">The number of seconds to be represented by the returned duration.</param>
        /// <returns>A <see cref="Duration"/> representing the specified number of seconds.</returns>
        public static Duration FromSeconds(double seconds)
        {
            return new Duration(0, seconds);
        }

        private readonly int m_days;
        private readonly double m_seconds;

        private static readonly Duration s_maxValue = new Duration(Int32.MaxValue, 0.0);
        private static readonly Duration s_minValue = new Duration(Int32.MinValue, 0.0);
    }
}
