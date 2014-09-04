namespace CesiumLanguageWriter
{
    /// <summary>
    /// Defines how a simulated clock advances in time.
    /// </summary>
    public enum ClockStep
    {
        /// <summary>
        /// The clock always matches the system clock.
        /// </summary>
        SystemClock,

        /// <summary>
        /// The clock advances by the elapsed system time between ticks, multiplied by a user specified value.
        /// </summary>
        SystemClockMultiplier,

        /// <summary>
        /// The clock advances by a fixed step each tick.
        /// </summary>
        TickDependent,
    }
}