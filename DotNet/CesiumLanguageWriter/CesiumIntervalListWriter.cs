using CesiumLanguageWriter.Advanced;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a list of intervals for which a property is defined.
    /// </summary>
    /// <typeparam name="TPropertyWriter">The type used to represent the value of this property for a single interval.</typeparam>
    public class CesiumIntervalListWriter<TPropertyWriter> : CesiumElementWriter, ICesiumIntervalListWriter
        where TPropertyWriter : CesiumPropertyWriter<TPropertyWriter>
    {
        private readonly TPropertyWriter m_propertyWriter;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyWriter">The instance used to write the value of this property for a single interval.</param>
        public CesiumIntervalListWriter(TPropertyWriter propertyWriter)
        {
            m_propertyWriter = propertyWriter;
        }

        /// <summary>
        /// Writes the start of a JSON sequence representing the interval list.
        /// </summary>
        protected override void OnOpen()
        {
            Output.WriteStartSequence();
        }

        /// <summary>
        /// Writes the end of a JSON array representing the interval list.
        /// </summary>
        protected override void OnClose()
        {
            Output.WriteEndSequence();
        }

        /// <summary>
        /// Opens a writer to write information about a single interval.
        /// </summary>
        /// <returns>The interval writer.</returns>
        public TPropertyWriter OpenInterval()
        {
            return m_propertyWriter.OpenInterval();
        }

        /// <summary>
        /// Opens a writer to write information about a single interval.
        /// </summary>
        /// <param name="start">The start of the interval of time covered by this interval element.</param>
        /// <param name="stop">The end of the interval of time covered by this interval element.</param>
        /// <returns>The interval writer.</returns>
        public TPropertyWriter OpenInterval(JulianDate start, JulianDate stop)
        {
            return m_propertyWriter.OpenInterval(start, stop);
        }

        ICesiumPropertyWriter ICesiumIntervalListWriter.OpenInterval()
        {
            return OpenInterval();
        }

        ICesiumPropertyWriter ICesiumIntervalListWriter.OpenInterval(JulianDate start, JulianDate stop)
        {
            return OpenInterval(start, stop);
        }
    }
}