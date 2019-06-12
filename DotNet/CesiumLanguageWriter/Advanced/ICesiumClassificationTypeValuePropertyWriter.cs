namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a classification type.
    /// </summary>
    public interface ICesiumClassificationTypeValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a classification type.
        /// </summary>
        /// <param name="value">The classification type.</param>
        void WriteClassificationType(CesiumClassificationType value);
    }
}