namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a type of a corner.
    /// </summary>
    public interface ICesiumCornerTypeValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a corner type.
        /// </summary>
        /// <param name="value">The type of a corner.</param>
        void WriteCornerType(CesiumCornerType value);
    }
}