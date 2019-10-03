namespace CesiumLanguageWriter
{
    /// <summary>
    /// Contains time-related constants.
    /// </summary>
    public static class TimeConstants
    {
        /// <summary>
        /// The number of seconds in a minute.
        /// </summary>
        public const double SecondsPerMinute = 60.0;

        /// <summary>
        /// The number of minutes in an hour.
        /// </summary>
        public const double MinutesPerHour = 60.0;

        /// <summary>
        /// The number of hours in a day.
        /// </summary>
        public const double HoursPerDay = 24.0;

        /// <summary>
        /// The number of seconds in an hour.
        /// </summary>
        public const double SecondsPerHour = SecondsPerMinute * MinutesPerHour;

        /// <summary>
        /// The number of minutes in a day.
        /// </summary>
        public const double MinutesPerDay = HoursPerDay * MinutesPerHour;

        /// <summary>
        /// The number of seconds in a standard day that does not have leap seconds.
        /// </summary>
        public const double SecondsPerDay = HoursPerDay * MinutesPerHour * SecondsPerMinute;

        /// <summary>
        /// The next representable 64-bit double before 86400.0.  This is useful for normalizing
        /// times that must be less than a day (for example, the <see cref="JulianDate.SecondsOfDay"/> property
        /// of <see cref="JulianDate"/>).
        /// </summary>
        public static readonly double NextBefore86400 = 86399.999999999985;
    }
}