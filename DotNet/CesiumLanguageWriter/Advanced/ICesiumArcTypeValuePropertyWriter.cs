namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a type of an arc.
    /// </summary>
    public interface ICesiumArcTypeValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value expressed as an arc type.
        /// </summary>
        /// <param name="value">The type of an arc.</param>
        void WriteArcType(CesiumArcType value);
    }
}