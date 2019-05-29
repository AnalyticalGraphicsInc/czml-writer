namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a string.
    /// </summary>
    public interface ICesiumStringValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a string value.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteString(string value);
    }
}