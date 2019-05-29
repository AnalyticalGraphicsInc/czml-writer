namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a height reference.
    /// </summary>
    public interface ICesiumHeightReferenceValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a height reference.
        /// </summary>
        /// <param name="value">The height reference.</param>
        void WriteHeightReference(CesiumHeightReference value);
    }
}