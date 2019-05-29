namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a boolean.
    /// </summary>
    public interface ICesiumBooleanValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a boolean value.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteBoolean(bool value);
    }
}