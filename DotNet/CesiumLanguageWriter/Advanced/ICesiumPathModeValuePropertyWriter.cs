namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a path mode.
    /// </summary>
    public interface ICesiumPathModeValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a path mode.
        /// </summary>
        /// <param name="value">The path mode.</param>
        void WritePathMode(CesiumPathMode value);
    }
}
