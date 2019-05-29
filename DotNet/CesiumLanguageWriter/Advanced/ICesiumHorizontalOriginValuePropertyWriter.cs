namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a horizontal origin.
    /// </summary>
    public interface ICesiumHorizontalOriginValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as a horizontal origin.
        /// </summary>
        /// <param name="value">The horizontal origin.</param>
        void WriteHorizontalOrigin(CesiumHorizontalOrigin value);
    }
}