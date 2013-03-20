namespace CesiumLanguageWriter
{
    /// <summary>
    /// The horizontal origin of a billboard or label in a <topic name="Cesium">Cesium</topic> stream
    /// relative to an associated position.
    /// </summary>
    public enum ClockStep
    {
        /// <summary>
        /// The left side of the billboard or label is located at the position.
        /// </summary>
        SystemClock,

        /// <summary>
        /// The billboard or label is horizontally centered on the position.
        /// </summary>
        SystemClockMultiplier,

        /// <summary>
        /// The right side of the billboard or label is located at the position.
        /// </summary>
        TickDependant,
    }
}