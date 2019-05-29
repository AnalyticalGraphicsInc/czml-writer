namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as the normalized velocity vector of a position property.
    /// </summary>
    public interface ICesiumVelocityReferenceValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as the normalized velocity vector of a position property.
        /// </summary>
        /// <param name="value">The reference.</param>
        void WriteVelocityReference(Reference value);

        /// <summary>
        /// Writes the value as the normalized velocity vector of a position property.
        /// </summary>
        /// <param name="value">The reference.</param>
        void WriteVelocityReference(string value);

        /// <summary>
        /// Writes the value as the normalized velocity vector of a position property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        void WriteVelocityReference(string identifier, string propertyName);

        /// <summary>
        /// Writes the value as the normalized velocity vector of a position property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        void WriteVelocityReference(string identifier, string[] propertyNames);
    }
}