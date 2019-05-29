namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a label style.
    /// </summary>
    public interface ICesiumLabelStyleValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a label style.
        /// </summary>
        /// <param name="value">The label style.</param>
        void WriteLabelStyle(CesiumLabelStyle value);
    }
}