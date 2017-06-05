using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// An interface to an object that writes a list of intervals for a CZML
    /// property.
    /// </summary>
    public interface ICesiumIntervalListWriter : ICesiumElementWriter
    {
        /// <summary>
        /// Opens a writer to write information about a single interval.
        /// </summary>
        /// <returns>The interval writer.</returns>
        [NotNull]
        ICesiumPropertyWriter OpenInterval();

        /// <summary>
        /// Opens a writer to write information about a single interval.
        /// </summary>
        /// <param name="start">The start of the interval of time covered by this interval element.</param>
        /// <param name="stop">The end of the interval of time covered by this interval element.</param>
        /// <returns>The interval writer.</returns>
        [NotNull]
        ICesiumPropertyWriter OpenInterval(JulianDate start, JulianDate stop);
    }
}