using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Represents a calendar year, month, and day.
    /// </summary>
    [CSToJavaExcludeBase("IComparable")]
    [CSToJavaImmutableValueType]
    public struct YearMonthDay : IComparable<YearMonthDay>, IComparable, IEquatable<YearMonthDay>
    {
        /// <summary>
        /// Initializes a <see cref="YearMonthDay"/> from the provided values.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="month">The month of the year (in the range 1 through 12)</param>
        /// <param name="day">The day of the month (in the range 1 through the number of
        /// days in <paramref name="month"/>)</param>
        /// <exception cref="ArgumentException">
        /// Thrown when the <paramref name="year"/>, <paramref name="month"/>, or
        /// <paramref name="day"/> is outside of its acceptable range.</exception>
        public YearMonthDay(int year, int month, int day)
        {
            if (!IsValidDate(year, month, day))
                throw new ArgumentException(CesiumLocalization.YearMonthDayInvalidArgument);

            // fields are stored zero-indexed
            m_year = year - 1;
            m_month = month - 1;
            m_day = day - 1;
        }

        /// <summary>
        /// Initializes a <see cref="YearMonthDay"/> from the provided values.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="dayOfYear">The day of the year
        /// (in the range 1 through the number of days in the year).</param>
        public YearMonthDay(int year, int dayOfYear)
        {
            if (dayOfYear > DaysInYear(year))
                throw new ArgumentException(CesiumLocalization.YearMonthDayInvalidArgument, "dayOfYear");

            // year is stored zero-indexed
            m_year = year - 1;

            int[] cumulativeMonthTable = GetCumulativeMonthTable(year);

            // month is stored zero-indexed
            for (m_month = 11; m_month > 0; --m_month)
            {
                if (cumulativeMonthTable[m_month] < dayOfYear)
                    break;
            }

            // day is stored zero-indexed
            m_day = dayOfYear - cumulativeMonthTable[m_month] - 1;

            if (!IsValidDate(m_year + 1, m_month + 1, m_day + 1))
                throw new ArgumentException(CesiumLocalization.YearMonthDayInvalidArgument);
        }

        /// <summary>
        /// Initializes a <see cref="YearMonthDay"/> in the Gregorian calendar from the
        /// provided astronomical  Julian day number, assuming the beginning of the Julian
        /// day (noon).
        /// </summary>
        /// <param name="astronomicalJulianDayNumber">The astronomical Julian day number.
        /// </param>
        [SuppressMessage("Microsoft.Usage", "CA2233:OperationsShouldNotOverflow", MessageId = "astronomicalJulianDayNumber+68569", Justification = "In order for this to overflow you would need to pass in a Julian day number above 2 billion, which is safely 54 million years away or so.")]
        public YearMonthDay(int astronomicalJulianDayNumber)
        {
            // Algorithm from page 604 of the Explanatory Supplement to the
            // Astronomical Almanac (Seidelmann 1992).
            int L = astronomicalJulianDayNumber + 68569;
            int N = 4 * L / 146097;
            L = L - (146097 * N + 3) / 4;
            int I = 4000 * (L + 1) / 1461001;
            L = L - 1461 * I / 4 + 31;
            int J = 80 * L / 2447;
            m_day = L - 2447 * J / 80;
            L = J / 11;
            m_month = J + 2 - 12 * L;
            m_year = 100 * (N - 49) + I + L;

            // fields are stored zero-indexed
            m_year--;
            m_month--;
            m_day--;

            if (!IsValidDate(m_year + 1, m_month + 1, m_day + 1))
                throw new ArgumentOutOfRangeException(CesiumLocalization.YearMonthDayInvalidArgument);
        }

        /// <summary>
        /// Initializes a new instance from a <see cref="JulianDate"/>.
        /// </summary>
        /// <param name="date">The date.</param>
        public YearMonthDay(JulianDate date)
            : this(GetAdjustedJulianDayNumber(date))
        {
        }

        /// <summary>
        /// The constructor taking an integer Julian day number assumes that the desired
        /// <see cref="YearMonthDay" /> should represent the Gregorian day corresponding to
        /// the beginning of the provided Julian day number. If the
        /// <see cref="JulianDate"/> is more than one half day later than that, the
        /// calculation will be wrong.
        ///
        /// So, if <paramref name="date"/> is more than 12 hours past the start of the
        /// Julian day, we instead use the  Julian date number of tomorrow.
        /// </summary>
        /// <param name="date">The date.</param>
        /// <returns>The Julian day number that will produce the correct Gregorian day
        /// number.</returns>
        private static int GetAdjustedJulianDayNumber(JulianDate date)
        {
            int day = date.Day;
            if (date.SecondsOfDay >= 43200.0)
            {
                ++day;
            }
            return day;
        }

        /// <summary>
        /// Gets the year.
        /// </summary>
        public int Year
        {
            get { return m_year + 1; }
        }

        /// <summary>
        /// Gets the month of the year (in the range 1 through 12).
        /// </summary>
        public int Month
        {
            get
            {
                // month is stored zero-indexed
                return m_month + 1;
            }
        }

        /// <summary>
        /// Gets the day of the month (in the range 1 through the number of days in the
        /// month).
        /// </summary>
        public int Day
        {
            get
            {
                // day is stored zero-indexed
                return m_day + 1;
            }
        }

        /// <summary>
        /// Gets the day of the year (in the range 1 through the number of days in the year).
        /// </summary>
        public int DayOfYear
        {
            get
            {
                int[] cumulativeMonthTable = GetCumulativeMonthTable(Year);
                return Day + cumulativeMonthTable[m_month];
            }
        }

        /// <summary>Gets the day of the week represented by this instance.</summary>
        /// <returns>A <see cref="DayOfWeek" /> enumerated constant that indicates the day
        /// of the week. This property value ranges from zero, indicating Sunday, to six,
        /// indicating Saturday.</returns>
        public DayOfWeek DayOfWeek
        {
            get { return new DateTime(Year, Month, Day).DayOfWeek; }
        }

        /// <summary>
        /// Gets the Julian day number for this <see cref="YearMonthDay"/> instance,
        /// assuming noon on this day.
        /// </summary>
        public int JulianDayNumber
        {
            get
            {
                // Algorithm from page 604 of the Explanatory Supplement to the
                // Astronomical Almanac (Seidelmann 1992).
                int a = (Month - 14) / 12;
                int b = Year + 4800 + a;
                return 1461 * b / 4
                       + 367 * (Month - 2 - 12 * a) / 12
                       - 3 * ((b + 100) / 100) / 4
                       + Day
                       - 32075;
            }
        }

        /// <summary>
        /// Indicates whether the year in question is a leap year.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <returns><see langword="true"/> if <paramref name="year"/> is a leap year and
        /// <see langword="false"/> if it is not.
        /// </returns>
        public static bool IsLeapYear(int year)
        {
            return DateTime.IsLeapYear(year);
        }

        /// <summary>
        /// Provides the number of days in the month of the indicated year.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="month">The month of the year.</param>
        /// <returns>The number of days in the month.</returns>
        public static int DaysInMonth(int year, int month)
        {
            return DateTime.DaysInMonth(year, month);
        }

        /// <summary>
        /// Provides the number of days in the indicated year.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <returns>The number of days in the year (365 for a common year and 366 for a
        /// leap year).</returns>
        public static int DaysInYear(int year)
        {
            return IsLeapYear(year) ? 366 : 365;
        }

        /// <summary>
        /// Indicates whether the year, month, and day are a valid representation.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="month">The month of the year (in the range 1 through 12)</param>
        /// <param name="day">The day of the month (in the range 1 through the number of days in
        /// <paramref name="month"/>)</param>
        /// <returns><see langword="true"/> if the representation is valid and
        /// <see langword="false"/> if it is not.</returns>
        public static bool IsValidDate(int year, int month, int day)
        {
            return year >= 1 && year <= 9999 &&
                   month >= 1 && month <= 12 &&
                   day >= 1 && day <= DaysInMonth(year, month);
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_year.GetHashCode(),
                                    m_month.GetHashCode(),
                                    m_day.GetHashCode());
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(YearMonthDay other)
        {
            return m_year == other.m_year &&
                   m_month == other.m_month &&
                   m_day == other.m_day;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is YearMonthDay && Equals((YearMonthDay)obj);
        }

        /// <summary>
        /// Returns a string formatted as Year:Month:Day
        /// </summary>
        /// <returns>The string.</returns>
        public override string ToString()
        {
            return string.Format(CultureInfo.CurrentCulture, "{0}:{1}:{2}", Year, Month, Day);
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
        public int CompareTo(YearMonthDay other)
        {
            int result = m_year.CompareTo(other.m_year);
            if (result == 0)
            {
                result = m_month.CompareTo(other.m_month);
                if (result == 0)
                {
                    result = m_day.CompareTo(other.m_day);
                }
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

            if (!(obj is YearMonthDay))
                throw new ArgumentException(CesiumLocalization.ArgumentTypeInvalid, "obj");

            return CompareTo((YearMonthDay)obj);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(YearMonthDay left, YearMonthDay right)
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
        public static bool operator !=(YearMonthDay left, YearMonthDay right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is less than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is less than <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator <(YearMonthDay left, YearMonthDay right)
        {
            return left.CompareTo(right) < 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is greater than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is greater than <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator >(YearMonthDay left, YearMonthDay right)
        {
            return left.CompareTo(right) > 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is less than or equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is less than or equal to <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator <=(YearMonthDay left, YearMonthDay right)
        {
            return left.CompareTo(right) <= 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is greater than or equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is greater than or equal to <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator >=(YearMonthDay left, YearMonthDay right)
        {
            return left.CompareTo(right) >= 0;
        }

        /// <summary>
        /// Gets the appropriate table of cumulative days per month for the given year.
        /// </summary>
        private static int[] GetCumulativeMonthTable(int year)
        {
            return IsLeapYear(year) ? s_leapYearCumulativeMonthTable : s_commonYearCumulativeMonthTable;
        }

        // fields are stored zero-indexed so that default-constructed instances are valid
        private readonly int m_year;
        private readonly int m_month;
        private readonly int m_day;

        // these tables contain the cumulative days of year at the start of each of the zero-indexed months of the year.
        private static readonly int[] s_commonYearCumulativeMonthTable = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
        private static readonly int[] s_leapYearCumulativeMonthTable = { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 };
    }
}