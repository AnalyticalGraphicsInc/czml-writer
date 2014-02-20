namespace CesiumLanguageWriter
{
    /// <summary>
    /// Defines the behavior of a clock when its current time reaches its start or end point.
    /// </summary>
    public enum ClockRange
    {
        /// <summary>
        /// The clock can continue forever in either direction.
        /// </summary>
        Unbounded,

        /// <summary>
        /// The clock stops when either its start or end time is reached.
        /// </summary>
        Clamped,

        /// <summary>
        /// The clock stops when its start time is reached, but loops back to start when its end time is reached.
        /// </summary>
        LoopStop,
    }
}