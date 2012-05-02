
namespace CesiumLanguageWriter
{
    /// <summary>
    /// Provides a means for measuring time by specifying the rate at which time passes and/or points in time.
    /// </summary>
    public enum TimeStandard
    {
        /// <summary>
        /// The International Atomic Time (TAI) time standard.
        /// </summary>
        InternationalAtomicTime,

        /// <summary>
        /// The Coordinated Universal Time (UTC) time standard.
        /// </summary>
        /// <remarks>
        /// <para>
        /// UTC is related to TAI according to the relationship
        /// </para>
        /// <para>
        /// <code>UTC = TAI - deltaT</code>
        /// </para>
        /// <para>
        /// where 
        /// <code>deltaT</code>
        /// is the number of leap seconds which have been introduced as of 
        /// the time in TAI.
        /// </para>
        /// </remarks>
        CoordinatedUniversalTime
    }
}