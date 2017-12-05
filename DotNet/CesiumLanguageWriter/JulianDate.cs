using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.Text;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// An astronomical Julian Date, which is the number of days since noon on January 1, -4712 (4713 BC).
    /// For increased precision, this class stores the whole number part of the date as an <see cref="int"/>
    /// and the seconds into the day as a <see cref="double"/>.
    /// </summary>
    /// <remarks>
    /// This type assumes that days always have <see cref="TimeConstants.SecondsPerDay"/> (86400.0) seconds.
    /// When using a <see cref="JulianDate"/> with the <see cref="TimeStandard.CoordinatedUniversalTime"/> (UTC) time standard,
    /// a day with a leap second actually has 86401.0 seconds.  The end result is that <see cref="JulianDate"/> cannot
    /// represent the moment of a leap second with the UTC time standard.  It CAN represent the moment of a
    /// leap second in <see cref="TimeStandard.InternationalAtomicTime"/> (TAI), however.  Also, subtracting two
    /// UTC dates that are on opposite sides of a leap second will correctly take the leap second into account.
    /// </remarks>
    [CSToJavaExcludeBase("IConvertible")]
    [CSToJavaExcludeBase("IComparable")]
    [CSToJavaImmutableValueType]
    public struct JulianDate : IComparable<JulianDate>, IComparable, IEquatable<JulianDate>, IConvertible
    {
        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from a <see cref="DateTime"/>.
        /// The time standard will be Coordinated Universal Time (UTC).
        /// </summary>
        /// <param name="dateTime">The <see cref="DateTime"/>.</param>
        public JulianDate(DateTime dateTime)
            : this(new GregorianDate(dateTime))
        {
        }

        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from a <see cref="GregorianDate"/>.
        /// The time standard will be <see cref="TimeStandard.CoordinatedUniversalTime"/> (UTC), except when
        /// the <paramref name="gregorianDate"/> represents time during a leap second.  During a leap second,
        /// the <see cref="JulianDate"/> will be in the <see cref="TimeStandard.InternationalAtomicTime"/> (TAI)
        /// standard.
        /// </summary>
        /// <param name="gregorianDate">The <see cref="GregorianDate"/> to use to specify the
        /// <see cref="JulianDate"/>.</param>
        public JulianDate(GregorianDate gregorianDate)
        {
            JulianDate converted = gregorianDate.ToJulianDate();
            m_day = converted.m_day;
            m_secondsOfDay = converted.m_secondsOfDay;
            m_timeStandard = converted.m_timeStandard;
        }

        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from a <see cref="DateTime"/> and specified time standard.
        /// </summary>
        /// <param name="dateTime">The <see cref="DateTime"/>.</param>
        /// <param name="standard">
        /// The time standard to use for this Julian Date.  The <paramref name="dateTime"/> is assumed to be expressed
        /// in this time standard.
        /// </param>
        public JulianDate(DateTime dateTime, TimeStandard standard)
            : this(new GregorianDate(dateTime), standard)
        {
        }

        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from a <see cref="GregorianDate"/> where the <see cref="GregorianDate"/>
        /// is expressed in the given <see cref="TimeStandard"/>.  If the date is during a leap second, the
        /// <see cref="JulianDate"/> will be expressed in <see cref="TimeStandard.InternationalAtomicTime"/> (TAI).
        /// </summary>
        /// <param name="gregorianDate">The <see cref="GregorianDate"/>.</param>
        /// <param name="standard">
        /// The time standard in which the <paramref name="gregorianDate"/> is expressed.
        /// </param>
        public JulianDate(GregorianDate gregorianDate, TimeStandard standard)
        {
            JulianDate converted = gregorianDate.ToJulianDate(standard);
            m_day = converted.m_day;
            m_secondsOfDay = converted.m_secondsOfDay;
            m_timeStandard = converted.Standard;
        }

        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from the provided values.  The values will be
        /// normalized so that the <see cref="SecondsOfDay"/> property is less than the length of a day.
        /// The time standard will be International Atomic Time (TAI).
        /// </summary>
        /// <param name="day">The whole number part of the date.</param>
        /// <param name="secondsOfDay">The time of day, expressed as seconds past noon on the given whole-number day.</param>
        public JulianDate(int day, double secondsOfDay)
            : this(day, secondsOfDay, TimeStandard.InternationalAtomicTime)
        {
        }

        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from the provided values.  The values will be
        /// normalized so that the <see cref="SecondsOfDay"/> property is less than the length of the day.
        /// </summary>
        /// <param name="day">The whole number part of the date.</param>
        /// <param name="secondsOfDay">The time of day, expressed as seconds past noon on the given whole-number day.</param>
        /// <param name="timeStandard">The time standard to use for this Julian Date.</param>
        public JulianDate(int day, double secondsOfDay, TimeStandard timeStandard)
        {
            m_timeStandard = timeStandard;
            m_day = day;
            m_secondsOfDay = secondsOfDay;

            // Normalize so that the number of seconds is >= 0 and < a day.
            if (m_secondsOfDay < 0)
            {
                int wholeDays = (int)(m_secondsOfDay / TimeConstants.SecondsPerDay);
                --wholeDays;

                m_day += wholeDays;
                m_secondsOfDay -= TimeConstants.SecondsPerDay * wholeDays;

                if (m_secondsOfDay > TimeConstants.NextBefore86400)
                {
                    // In theory m_secondsOfDay can't actually be greater than 86400.0.
                    // But it can be equal to that, or it can be in the 80-bit floating point
                    // unit and thus in between 86400.0 and the next smaller representable 64-bit
                    // double.  If it's the latter, it's in danger of being rounded to 86400.0.
                    // 86400.0 is of course not a valid value for m_secondsOfDay, so we need to
                    // reset it to 0.0 and increment m_day.
                    //
                    // This can happen if the original m_secondsOfDay coming in is a very small
                    // negative number.  When we add 86400.0 to it, we get 86400.0 instead of
                    // something slightly less than that as expected, because a double has more
                    // precision near 0.0 than near 86400.0.
                    ++m_day;
                    m_secondsOfDay = 0.0;
                }
            }
            else if (m_secondsOfDay >= TimeConstants.SecondsPerDay)
            {
                int wholeDays = (int)(m_secondsOfDay / TimeConstants.SecondsPerDay);
                m_day += wholeDays;
                m_secondsOfDay -= TimeConstants.SecondsPerDay * wholeDays;
            }
        }

        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from a double expressing the complete astronomical Julian Date.
        /// The time standard will be <see cref="TimeStandard.InternationalAtomicTime">International Atomic Time (TAI)</see>.
        /// </summary>
        /// <param name="dayCount">The complete astronomical Julian date.</param>
        public JulianDate(double dayCount)
            : this(dayCount, TimeStandard.InternationalAtomicTime)
        {
        }

        /// <summary>
        /// Initializes a <see cref="JulianDate"/> from a double expressing the complete astronomical Julian Date.
        /// </summary>
        /// <param name="dayCount">The complete Julian date.</param>
        /// <param name="timeStandard">The time standard to use for this Julian Date.</param>
        public JulianDate(double dayCount, TimeStandard timeStandard)
        {
            m_timeStandard = timeStandard;
            m_day = (int)dayCount;
            m_secondsOfDay = (dayCount - m_day) * TimeConstants.SecondsPerDay;
        }

        /// <summary>
        /// Gets the smallest value possible of <see cref="JulianDate"/>.
        /// </summary>
        public static JulianDate MinValue
        {
            get { return s_minValue; }
        }

        /// <summary>
        /// Gets the largest possible value of <see cref="JulianDate"/>.
        /// </summary>
        public static JulianDate MaxValue
        {
            get { return s_maxValue; }
        }

        /// <summary>
        /// Gets the total number of whole and fractional days represented by this astronomical Julian date.
        /// </summary>
        public double TotalDays
        {
            get { return m_day + m_secondsOfDay / TimeConstants.SecondsPerDay; }
        }

        /// <summary>
        /// Gets the integer portion of the Julian Date (or astronomical Julian day number).
        /// </summary>
        public int Day
        {
            get { return m_day; }
        }

        /// <summary>
        /// Gets the number of seconds past noon on the whole-number Julian Day.
        /// </summary>
        public double SecondsOfDay
        {
            get { return m_secondsOfDay; }
        }

        /// <summary>
        /// Gets the <see cref="TimeStandard"/> that this astronomical Julian date is based upon.
        /// </summary>
        public TimeStandard Standard
        {
            get { return m_timeStandard; }
        }

        /// <summary>
        /// Gets the <see cref="JulianDate"/> that represents the current date and time. The time standard will be Coordinated Universal Time (UTC).
        /// </summary>
        public static JulianDate Now
        {
            get { return new JulianDate(DateTime.UtcNow); }
        }

        /// <summary>
        /// Converts this <see cref="JulianDate"/> to the specified time standard.
        /// </summary>
        /// <param name="timeStandard">The requested time standard.</param>
        /// <returns>An equivalent <see cref="JulianDate"/> using the requested time standard.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown if the specified <see cref="TimeStandard"/> is not capable of
        /// representing this <see cref="JulianDate"/>.
        /// </exception>
        [Pure]
        public JulianDate ToTimeStandard(TimeStandard timeStandard)
        {
            JulianDate result;
            if (!TryConvertTimeStandard(timeStandard, out result))
                throw new ArgumentOutOfRangeException(CesiumLocalization.CannotRepresentLeapSecondAsUTCJulianDate);
            return result;
        }

        /// <summary>
        /// Try to convert this <see cref="JulianDate"/> to the specified
        /// <see cref="TimeStandard"/>, if the specified <see cref="TimeStandard"/> is
        /// capable of representing this time.
        /// </summary>
        /// <param name="timeStandard">The requested time standard.</param>
        /// <param name="result">
        /// <filter name="Java">On input, an array with one element.  On return, the array is populated with</filter>
        /// <filter name="DotNet">On return,</filter>
        /// an equivalent
        /// <see cref="JulianDate"/> using the requested <see cref="TimeStandard"/>, if it
        /// is capable of representing this time, otherwise <see cref="MinValue"/>.
        /// </param>
        /// <returns><see langword="true"/> if this date could be converted to the
        /// requested <see cref="TimeStandard"/>, otherwise false.</returns>
        [Pure]
        public bool TryConvertTimeStandard(TimeStandard timeStandard, out JulianDate result)
        {
            if (timeStandard == Standard)
            {
                result = this;
                return true;
            }

            if (timeStandard == TimeStandard.InternationalAtomicTime && Standard == TimeStandard.CoordinatedUniversalTime)
            {
                result = new JulianDate(Day, SecondsOfDay + LeapSeconds.Instance.GetTaiMinusUtc(this), timeStandard);
                return true;
            }

            if (timeStandard == TimeStandard.CoordinatedUniversalTime && Standard == TimeStandard.InternationalAtomicTime)
            {
                return LeapSeconds.Instance.TryConvertTaiToUtc(this, out result);
            }

            result = MinValue;
            return false;
        }

        /// <summary>
        /// Converts this date to <see cref="TimeStandard.InternationalAtomicTime"/> (TAI).
        /// </summary>
        /// <returns>An equivalent date expressed in TAI.</returns>
        public JulianDate ToInternationalAtomicTime()
        {
            if (Standard == TimeStandard.InternationalAtomicTime)
                return this;
            return new JulianDate(Day, SecondsOfDay + LeapSeconds.Instance.GetTaiMinusUtc(this), TimeStandard.InternationalAtomicTime);
        }

        /// <summary>
        /// Computes the number of seconds that have elapsed from this Julian date to the
        /// <paramref name="other"/> Julian date.
        /// </summary>
        /// <param name="other">The other Julian date, which is the end of the interval.</param>
        /// <returns>The number of seconds that have elapsed from this Julian date to the other Julian date.</returns>
        /// <remarks>
        /// This method subtracts the Julian date on which it is called from the <paramref name="other"/>
        /// Julian date and returns the number of seconds between them.  The computation is done in the time
        /// standard of this Julian date, or the closest standard that is safe for arithmetic if this
        /// Julian date's time standard is not safe.  For best performance, this Julian date and the
        /// <paramref name="other"/> Julian date should have the same time standard and it should be
        /// safe for arithmetic.
        /// </remarks>
        [Pure]
        public double SecondsDifference(JulianDate other)
        {
            JulianDate start = ToInternationalAtomicTime();
            JulianDate end = other.ToInternationalAtomicTime();

            int startDay = start.Day;
            int endDay = end.Day;
            return (endDay - startDay) * TimeConstants.SecondsPerDay + (end.SecondsOfDay - start.SecondsOfDay);
        }

        /// <summary>
        /// Computes the number of minutes that have elapsed from this Julian date to the
        /// <paramref name="other"/> Julian date.
        /// </summary>
        /// <param name="other">The other Julian date, which is the end of the interval.</param>
        /// <returns>The number of minutes that have elapsed from this Julian date to the other Julian date.</returns>
        /// <remarks>
        /// This method subtracts the Julian date on which it is called from the <paramref name="other"/>
        /// Julian date and returns the number of minutes between them.  The computation is done in the time
        /// standard of this Julian date, or the closest standard that is safe for arithmetic if this
        /// Julian date's time standard is not safe.  For best performance, this Julian date and the
        /// <paramref name="other"/> Julian date should have the same time standard and it should be
        /// safe for arithmetic.
        /// </remarks>
        [Pure]
        public double MinutesDifference(JulianDate other)
        {
            JulianDate start = ToInternationalAtomicTime();
            JulianDate end = other.ToInternationalAtomicTime();

            int startDay = start.Day;
            int endDay = end.Day;
            return (endDay - startDay) * TimeConstants.MinutesPerDay + (end.SecondsOfDay - start.SecondsOfDay) / TimeConstants.SecondsPerMinute;
        }

        /// <summary>
        /// Computes the number of days that have elapsed from this Julian date to the
        /// <paramref name="other"/> Julian date.
        /// </summary>
        /// <param name="other">The other Julian date, which is the end of the interval.</param>
        /// <returns>The number of days that have elapsed from this Julian date to the other Julian date.</returns>
        /// <remarks>
        /// This method subtracts the Julian date on which it is called from the <paramref name="other"/>
        /// Julian date and returns the number of days between them.  The computation is done in the time
        /// standard of this Julian date, or the closest standard that is safe for arithmetic if this
        /// Julian date's time standard is not safe.  For best performance, this Julian date and the
        /// <paramref name="other"/> Julian date should have the same time standard and it should be
        /// safe for arithmetic.
        /// </remarks>
        [Pure]
        public double DaysDifference(JulianDate other)
        {
            JulianDate start = ToInternationalAtomicTime();
            JulianDate end = other.ToInternationalAtomicTime();

            int startDay = start.Day;
            int endDay = end.Day;
            return endDay - startDay + (end.SecondsOfDay - start.SecondsOfDay) / TimeConstants.SecondsPerDay;
        }

        /// <summary>
        /// Adds a <see cref="Duration"/> to this Julian date, producing a new Julian date.
        /// </summary>
        /// <param name="duration">The duration to add.</param>
        /// <returns>
        /// A new <see cref="JulianDate"/> that is the result of the addition.
        /// </returns>
        [Pure]
        public JulianDate Add(Duration duration)
        {
            const TimeStandard additionTimeStandard = TimeStandard.InternationalAtomicTime;

            if (additionTimeStandard != Standard)
            {
                // Do the addition in the addition time standard
                JulianDate resultInAdditionStandard = ToInternationalAtomicTime().AddIgnoringTimeStandard(duration);

                //then convert back if possible
                JulianDate result;
                if (resultInAdditionStandard.TryConvertTimeStandard(Standard, out result))
                    return result;

                //if we couldn't convert back, then use the valid result in the addition standard
                return resultInAdditionStandard;
            }

            // Time standards match up, so do the addition directly.
            return AddIgnoringTimeStandard(duration);
        }

        private JulianDate AddIgnoringTimeStandard(Duration duration)
        {
            int days = Day + duration.Days;
            double seconds = SecondsOfDay + duration.Seconds;
            return new JulianDate(days, seconds, Standard);
        }

        /// <summary>
        /// Subtracts another Julian date from this Julian date.
        /// </summary>
        /// <param name="subtrahend">The Julian Date to subtract from this Julian Date.</param>
        /// <returns>The Duration that is the result of the subtraction.  The time standard will be the same as the time standard of the subtrahend.</returns>
        /// <remarks>
        /// This method subtracts the <paramref name="subtrahend"/> Julian date from this
        /// Julian date and returns the <see cref="Duration"/> between them.  The computation is done in
        /// the time standard of the <paramref name="subtrahend"/>, or the closest standard that is safe for
        /// arithmetic if the subtrahend's time standard is not safe.  For best performance, this Julian date
        /// and the subtrahend Julian date should have the same time standard and it should be
        /// safe for arithmetic.
        /// </remarks>
        [Pure]
        public Duration Subtract(JulianDate subtrahend)
        {
            const TimeStandard subtractionTimeStandard = TimeStandard.InternationalAtomicTime;

            if (subtractionTimeStandard != Standard && subtractionTimeStandard != subtrahend.Standard)
            {
                // Convert both the subtrahend and the minuend to the subtraction time standard.
                return ToInternationalAtomicTime().SubtractIgnoringTimeStandard(subtrahend.ToInternationalAtomicTime());
            }

            if (subtractionTimeStandard != Standard)
            {
                // Convert the minuend to the subtraction time standard - subtrahend is already in the correct standard.
                return ToInternationalAtomicTime().SubtractIgnoringTimeStandard(subtrahend);
            }

            if (subtractionTimeStandard != subtrahend.Standard)
            {
                // Convert the subtrahend to the subtraction time standard - minuend is already in the correct standard.
                return SubtractIgnoringTimeStandard(subtrahend.ToInternationalAtomicTime());
            }

            // Time standards match up, so do the subtraction directly.
            return SubtractIgnoringTimeStandard(subtrahend);
        }

        private Duration SubtractIgnoringTimeStandard(JulianDate subtrahend)
        {
            int days = Day - subtrahend.Day;
            double seconds = SecondsOfDay - subtrahend.SecondsOfDay;
            return new Duration(days, seconds);
        }

        /// <summary>
        /// Subtracts a <see cref="Duration"/> from this Julian date, producing a new
        /// Julian date.
        /// </summary>
        /// <param name="duration">The duration to subtract.</param>
        /// <returns>
        /// A new <see cref="JulianDate"/> that is the result of the subtraction.
        /// </returns>
        [Pure]
        public JulianDate Subtract(Duration duration)
        {
            return Add(new Duration(-duration.Days, -duration.Seconds));
        }

        /// <summary>
        /// Adds the specified number of seconds to this date and returns the new date.
        /// </summary>
        /// <param name="seconds">The number of seconds.</param>
        /// <returns>The new date.</returns>
        [Pure]
        public JulianDate AddSeconds(double seconds)
        {
            return Add(Duration.FromSeconds(seconds));
        }

        /// <summary>
        /// Subtracts the specified number of seconds to this date and returns the new
        /// date.
        /// </summary>
        /// <param name="seconds">The number of seconds.</param>
        /// <returns>The new date.</returns>
        [Pure]
        public JulianDate SubtractSeconds(double seconds)
        {
            return Subtract(Duration.FromSeconds(seconds));
        }

        /// <summary>
        /// Adds the specified number of days to this date and returns the new date.
        /// </summary>
        /// <param name="days">The number of days.</param>
        /// <returns>The new date.</returns>
        [Pure]
        public JulianDate AddDays(double days)
        {
            return Add(Duration.FromDays(days));
        }

        /// <summary>
        /// Subtracts a Julian date from another Julian date, yielding a
        /// <see cref="Duration"/>.
        /// </summary>
        /// <param name="left">The minuend.</param>
        /// <param name="right">The subtrahend.</param>
        /// <returns>
        /// The Duration that is the result of the subtraction; that is,
        /// <paramref name="left"/> minus <paramref name="right"/>.  The time standard will
        /// be the same as the time standard of the subtrahend.
        /// </returns>
        public static Duration operator -(JulianDate left, JulianDate right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Subtracts a <see cref="Duration"/> from a Julian date, yielding a new
        /// <see cref="JulianDate"/>.
        /// </summary>
        /// <param name="left">The minuend.</param>
        /// <param name="right">The subtrahend.</param>
        /// <returns>
        /// A new Julian Date that is the result of the subtraction; that is,
        /// <paramref name="left"/> minus <paramref name="right"/>.
        /// </returns>
        public static JulianDate operator -(JulianDate left, Duration right)
        {
            return left.Subtract(right);
        }

        /// <summary>
        /// Adds a <see cref="Duration"/> to a <see cref="JulianDate"/>, producing a new
        /// Julian date.
        /// </summary>
        /// <param name="left">The Julian date.</param>
        /// <param name="right">The duration.</param>
        /// <returns>A new Julian Date that is the result of the addition.</returns>
        public static JulianDate operator +(JulianDate left, Duration right)
        {
            return left.Add(right);
        }

        /// <summary>
        /// Returns true if the two dates are exactly equal.  To be considered equal, the <see cref="Day"/>
        /// and <see cref="SecondsOfDay"/> properties must be identical when converted to a common time standard.
        /// It is highly recommended that you use <see cref="EqualsEpsilon"/> or <see cref="IsIdentical"/>
        /// instead of this method.
        /// </summary>
        /// <param name="left">The date on the left side.</param>
        /// <param name="right">The date on the right side.</param>
        /// <returns><see langword="true"/> if the dates are equal, otherwise <see langword="false"/>.</returns>
        public static bool operator ==(JulianDate left, JulianDate right)
        {
            return left.Equals(right);
        }

        /// <summary>
        /// Returns true if the two dates are NOT exactly equal.  To be considered equal, the <see cref="Day"/>
        /// and <see cref="SecondsOfDay"/> properties must be identical when converted to a common time standard.
        /// It is highly recommended that you use <see cref="EqualsEpsilon"/> or <see cref="IsIdentical"/>
        /// instead of this method.
        /// </summary>
        /// <param name="left">The date on the left side.</param>
        /// <param name="right">The date on the right side.</param>
        /// <returns><see langword="true"/> if the dates are not equal, otherwise <see langword="false"/>.</returns>
        public static bool operator !=(JulianDate left, JulianDate right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> occurs before <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The date on the left side.</param>
        /// <param name="right">The date on the right side.</param>
        /// <returns><see langword="true"/> if the <paramref name="left"/> is less than <paramref name="right"/>, otherwise <see langword="false"/>.</returns>
        public static bool operator <(JulianDate left, JulianDate right)
        {
            return left.CompareTo(right) < 0;
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> occurs after <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The date on the left side.</param>
        /// <param name="right">The date on the right side.</param>
        /// <returns><see langword="true"/> if the <paramref name="left"/> is greater than <paramref name="right"/>, otherwise <see langword="false"/>.</returns>
        public static bool operator >(JulianDate left, JulianDate right)
        {
            return left.CompareTo(right) > 0;
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> occurs before or at the same time as <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The date on the left side.</param>
        /// <param name="right">The date on the right side.</param>
        /// <returns><see langword="true"/> if the <paramref name="left"/> is less than or equal to <paramref name="right"/>, otherwise <see langword="false"/>.</returns>
        public static bool operator <=(JulianDate left, JulianDate right)
        {
            return left.CompareTo(right) <= 0;
        }

        /// <summary>
        /// Returns true if <paramref name="left"/> occurs after or at the same time as <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The date on the left side.</param>
        /// <param name="right">The date on the right side.</param>
        /// <returns><see langword="true"/> if the <paramref name="left"/> is greater than or equal to <paramref name="right"/>, otherwise <see langword="false"/>.</returns>
        public static bool operator >=(JulianDate left, JulianDate right)
        {
            return left.CompareTo(right) >= 0;
        }

        /// <summary>
        /// Returns true if this date exactly equals another date.  To be considered equal, the <see cref="Day"/>
        /// and <see cref="SecondsOfDay"/> properties must be identical when converted to a common time standard.
        /// It is highly recommended that you use <see cref="EqualsEpsilon"/> or <see cref="IsIdentical"/>
        /// instead of this method.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is JulianDate && Equals((JulianDate)obj);
        }

        /// <summary>
        /// Returns true if this date exactly equals another date.  To be considered equal, the <see cref="Day"/>
        /// and <see cref="SecondsOfDay"/> properties must be identical when converted to a common time standard.
        /// It is highly recommended that you use <see cref="EqualsEpsilon"/> or <see cref="IsIdentical"/>
        /// instead of this method.
        /// </summary>
        /// <param name="other">The date to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(JulianDate other)
        {
            return CompareTo(other) == 0;
        }

        /// <summary>
        /// Returns true if this date is identical to another date.  Unlike <see cref="Equals(JulianDate)"/>, this method will
        /// consider two dates with different time standards to be different even if the dates represent the same
        /// moment when expressed in the same time standard.
        /// </summary>
        /// <param name="other">The date to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> is identical to this instance; otherwise, <see langword="false"/>.</returns>
        [Pure]
        [SuppressMessage("ReSharper", "CompareOfFloatsByEqualityOperator")]
        public bool IsIdentical(JulianDate other)
        {
            return m_day == other.m_day &&
                   m_secondsOfDay == other.m_secondsOfDay &&
                   m_timeStandard == other.m_timeStandard;
        }

        /// <summary>
        /// Returns true if this date is within <paramref name="epsilon"/> seconds of the
        /// specified date.  That is, in order for the dates to be considered equal (and for
        /// this function to return true), the absolute value of the difference between them, in
        /// seconds, must be less than or equal to <paramref name="epsilon"/>.
        /// </summary>
        /// <param name="other">The Julian Date to compare to this date.</param>
        /// <param name="epsilon">The largest difference between the dates, in seconds, such that they will be considered equal.</param>
        /// <returns>true if the dates are equal as defined by the epsilon value.</returns>
        [Pure]
        public bool EqualsEpsilon(JulianDate other, double epsilon)
        {
            return Math.Abs(other.SecondsDifference(this)) <= epsilon;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_day.GetHashCode(), m_secondsOfDay.GetHashCode(), Standard.GetHashCode());
        }

        /// <summary>
        /// Returns the value of this <see cref="JulianDate"/> in the standard format.
        /// </summary>
        /// <returns>The string.</returns>
        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendFormat(CultureInfo.CurrentCulture, "{0}:{1} ", m_day, m_secondsOfDay);
            builder.Append(Standard == TimeStandard.CoordinatedUniversalTime ? "UTC" : "TAI");

            if (this < GregorianDate.MinValue.ToJulianDate())
            {
                builder.AppendFormat(CultureInfo.CurrentCulture, " (before {0})", GregorianDate.MinValue);
            }
            else if (this > GregorianDate.MaxValue.ToJulianDate())
            {
                builder.AppendFormat(CultureInfo.CurrentCulture, " (after {0})", GregorianDate.MaxValue);
            }
            else
            {
                builder.AppendFormat(CultureInfo.CurrentCulture, " ({0})", ToGregorianDate());
            }

            return builder.ToString();
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
        public int CompareTo(JulianDate other)
        {
            // If the days aren't even close, don't bother thinking about the time standard.
            int isClose = IsClose(other);
            if (isClose != 0)
            {
                return isClose;
            }

            JulianDate self;
            JulianDate otherDate;

            if (other.TryConvertTimeStandard(Standard, out otherDate))
            {
                self = this;
            }
            else
            {
                //if we can't convert the other date to our time standard, then try our ArithmeticSafeStandard
                self = ToInternationalAtomicTime();
                otherDate = other.ToInternationalAtomicTime();
            }

            if (self.Day != otherDate.Day)
            {
                return self.Day < otherDate.Day ? -1 : 1;
            }

            if (self.SecondsOfDay != otherDate.SecondsOfDay)
            {
                return self.SecondsOfDay < otherDate.SecondsOfDay ? -1 : 1;
            }

            return 0;
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

            if (!(obj is JulianDate))
            {
                throw new ArgumentException(CesiumLocalization.ArgumentTypeInvalid, "obj");
            }

            return CompareTo((JulianDate)obj);
        }

        /// <summary>
        /// Converts this <see cref="JulianDate"/> to a <filter name="DotNet">.NET standard</filter>
        /// <see cref="DateTime"/> with a default time standard of Coordinated Universal
        /// Time.
        /// </summary>
        /// <returns>The <see cref="DateTime"/>.</returns>
        [Pure]
        public DateTime ToDateTime()
        {
            return ToGregorianDate().ToDateTime();
        }

        /// <summary>
        /// Converts this <see cref="JulianDate"/> to a <filter name="DotNet">.NET standard</filter>
        /// <see cref="DateTime"/> expressed in the specified time standard.
        /// </summary>
        /// <param name="standard">The time standard in which to express the returned
        /// <see cref="DateTime"/>.</param>
        /// <returns>The <see cref="DateTime"/>.</returns>
        [Pure]
        public DateTime ToDateTime(TimeStandard standard)
        {
            return ToGregorianDate(standard).ToDateTime();
        }

        /// <summary>
        /// Converts this <see cref="JulianDate"/> to a <see cref="GregorianDate"/> with a
        /// default time standard of Coordinated Universal Time.
        /// </summary>
        /// <returns>The <see cref="GregorianDate"/>.</returns>
        [Pure]
        public GregorianDate ToGregorianDate()
        {
            return ToGregorianDate(TimeStandard.CoordinatedUniversalTime);
        }

        /// <summary>
        /// Converts this <see cref="JulianDate"/> to a <see cref="GregorianDate"/>
        /// expressed in the specified time standard.
        /// </summary>
        /// <param name="standard">The time standard in which to express the returned
        /// <see cref="GregorianDate"/>.</param>
        /// <returns>The <see cref="GregorianDate"/>.</returns>
        [Pure]
        public GregorianDate ToGregorianDate(TimeStandard standard)
        {
            return new GregorianDate(this, standard);
        }

        /// <summary>
        /// Returns 0 if this date is anywhere near the specified date such that time
        /// standard conversions might affect their equality or ordering.  Otherwise
        /// returns the difference Day - other.Day.  This is helpful for optimizations.
        /// </summary>
        private int IsClose(JulianDate other)
        {
            int dayDifference = m_day - other.m_day;
            if (dayDifference > 1 || dayDifference < -1)
            {
                return m_day < other.m_day ? -1 : 1;
            }

            return 0;
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Converts a
        /// <see cref="JulianDate"/> to a <see cref="DateTime"/> object.
        /// </summary>
        /// <returns>A <see cref="DateTime"/> representation of a <see cref="JulianDate"/>
        /// </returns>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        DateTime IConvertible.ToDateTime(IFormatProvider provider)
        {
            return ToDateTime();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Returns the
        /// <see cref="TypeCode"/> for this instance.
        /// </summary>
        /// <returns><see cref="TypeCode.Object"/></returns>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        TypeCode IConvertible.GetTypeCode()
        {
            return TypeCode.Object;
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Boolean IConvertible.ToBoolean(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Byte IConvertible.ToByte(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Char IConvertible.ToChar(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Decimal IConvertible.ToDecimal(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Converts
        /// <see cref="JulianDate"/> to its decimal representation.
        /// </summary>
        /// <returns>The total number of whole and fractional days represented by this astronomical
        /// Julian date.</returns>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Double IConvertible.ToDouble(IFormatProvider provider)
        {
            return TotalDays;
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Int16 IConvertible.ToInt16(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Int32 IConvertible.ToInt32(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Int64 IConvertible.ToInt64(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        SByte IConvertible.ToSByte(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Single IConvertible.ToSingle(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Converts the
        /// <see cref="JulianDate"/> to a string representation.
        /// </summary>
        /// <returns>The string representation of this <see cref="JulianDate"/>.</returns>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        String IConvertible.ToString(IFormatProvider provider)
        {
            return ToString();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Converts this
        /// <see cref="JulianDate"/> to the  type given by
        /// <paramref name="conversionType"/>.
        /// </summary>
        /// <returns>A <see cref="JulianDate"/> converted to the type specified by
        /// <paramref name="conversionType"/>.</returns>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        Object IConvertible.ToType(Type conversionType, IFormatProvider provider)
        {
            return Convert.ChangeType(this, conversionType, provider);
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        UInt16 IConvertible.ToUInt16(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        UInt32 IConvertible.ToUInt32(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        /// <summary>
        /// Implements <see cref="IConvertible"/> interface. Throws an
        /// <see cref="InvalidCastException"/> because a <see cref="JulianDate"/> cannot be
        /// converted to this type of object.
        /// </summary>
        [CSToJavaExclude("No IConvertible interface in Java.")]
        UInt64 IConvertible.ToUInt64(IFormatProvider provider)
        {
            throw new InvalidCastException();
        }

        private readonly int m_day;
        private readonly double m_secondsOfDay;
        private readonly TimeStandard m_timeStandard;
        private static readonly JulianDate s_maxValue = new JulianDate(int.MaxValue, 0.0, TimeStandard.InternationalAtomicTime);
        private static readonly JulianDate s_minValue = new JulianDate(int.MinValue, 0.0, TimeStandard.InternationalAtomicTime);
    }
}
