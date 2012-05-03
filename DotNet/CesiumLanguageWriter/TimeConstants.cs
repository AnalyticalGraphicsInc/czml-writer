using System.Diagnostics.CodeAnalysis;

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// Contains time-related constants.
    /// </summary>
    public static class TimeConstants
    {
        /// <summary>
        /// The number of seconds in a minute.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double SecondsPerMinute = 60.0;

        /// <summary>
        /// The number of minutes in an hour.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double MinutesPerHour = 60.0;

        /// <summary>
        /// The number of hours in a day.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double HoursPerDay = 24.0;

        /// <summary>
        /// The number of seconds in an hour.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double SecondsPerHour = SecondsPerMinute * MinutesPerHour;

        /// <summary>
        /// The number of minutes in a day.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double MinutesPerDay = HoursPerDay * MinutesPerHour;

        /// <summary>
        /// The number of seconds in a standard day that does not have leap seconds.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double SecondsPerDay = HoursPerDay * MinutesPerHour * SecondsPerMinute;

        /// <summary>
        /// The number of standard days in a Julian century.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double DaysPerJulianCentury = 36525.0;

        /// <summary>
        /// One picosecond
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double PicoSecond = .000000001;

        /// <summary>
        /// The difference between a Julian date and a modified Julian date.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double ModifiedJulianDateDifference = 2400000.5;

        /// <summary>
        /// The next representable 64-bit double before 86400.0.  This is useful for normalizing
        /// times that must be less than a day (for example, the <see cref="JulianDate.SecondsOfDay"/> property
        /// of <see cref="JulianDate"/>).
        /// </summary>
        public static readonly double NextBefore86400 = 86399.999999999985;
    }
}
