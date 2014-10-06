namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// An interface to an object that writes the values of a CZML
    /// property over one or more intervals.
    /// </summary>
    public interface ICesiumPropertyWriter : ICesiumElementWriter
    {
        /// <summary>
        /// Writes the actual interval of time covered by this CZML interval.
        /// </summary>
        /// <param name="start">The start of the interval.</param>
        /// <param name="stop">The end of the interval.</param>
        void WriteInterval(JulianDate start, JulianDate stop);

        /// <summary>
        /// Opens a writer that is used to write information about this property for a single interval.
        /// </summary>
        /// <returns>The writer.</returns>
        ICesiumPropertyWriter OpenInterval();

        /// <summary>
        /// Opens a writer that is used to write information about this property for multiple discrete intervals.
        /// </summary>
        /// <returns>The writer.</returns>
        ICesiumIntervalListWriter OpenMultipleIntervals();

        /// <summary>
        /// Gets a writer for intervals of this property.  The returned instance must be opened by calling
        /// the <see cref="ICesiumElementWriter.Open"/> method before it can be used for writing.  Consider
        /// calling the <see cref="OpenInterval"/> or <see cref="OpenMultipleIntervals"/> method, which will automatically
        /// open the writer, instead of accessing this property directly.
        /// </summary>
        ICesiumPropertyWriter IntervalWriter { get; }

        /// <summary>
        /// Gets or sets a value indicating whether this instance should always open an interval.
        /// </summary>
        bool ForceInterval { get; set; }
    }
}