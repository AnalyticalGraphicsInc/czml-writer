namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write an indication that the client should delete existing samples or interval data for this property.
    /// </summary>
    public interface ICesiumDeletablePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes an indication that the client should delete existing samples or interval data for this property.
        /// Data will be deleted for the containing interval, or if there is no containing interval, then all data.
        /// If true, all other properties in this property will be ignored.
        /// </summary>
        /// <param name="value">The value.</param>
        void WriteDelete(bool value);
    }
}