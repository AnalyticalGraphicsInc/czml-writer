namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a shadow mode.
    /// </summary>
    public interface ICesiumShadowModeValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a shadow mode.
        /// </summary>
        /// <param name="value">The shadow mode.</param>
        void WriteShadowMode(CesiumShadowMode value);
    }
}