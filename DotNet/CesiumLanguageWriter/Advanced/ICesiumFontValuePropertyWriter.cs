namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a CSS font.
    /// </summary>
    public interface ICesiumFontValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a CSS font.
        /// </summary>
        /// <param name="font">The font.</param>
        void WriteFont(string font);
    }
}