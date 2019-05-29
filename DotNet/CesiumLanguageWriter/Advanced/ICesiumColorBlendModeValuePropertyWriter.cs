namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a color blend mode.
    /// </summary>
    public interface ICesiumColorBlendModeValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a color blend mode.
        /// </summary>
        /// <param name="value">The blend mode.</param>
        void WriteColorBlendMode(CesiumColorBlendMode value);
    }
}