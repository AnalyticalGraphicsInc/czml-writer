namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a vertical origin.
    /// </summary>
    public interface ICesiumVerticalOriginValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a vertical origin.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        void WriteVerticalOrigin(CesiumVerticalOrigin value);
    }
}