namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a reference to another property.
    /// </summary>
    public interface ICesiumReferenceValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a reference to another property.
        /// </summary>
        /// <param name="value">The reference.</param>
        void WriteReference(Reference value);

        /// <summary>
        /// Writes the value as a reference to another property.
        /// </summary>
        /// <param name="value">The reference.</param>
        void WriteReference(string value);

        /// <summary>
        /// Writes the value as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        void WriteReference(string identifier, string propertyName);

        /// <summary>
        /// Writes the value as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        void WriteReference(string identifier, string[] propertyNames);
    }
}