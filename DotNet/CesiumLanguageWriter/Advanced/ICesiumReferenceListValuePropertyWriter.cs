using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of references to other properties.
    /// </summary>
    public interface ICesiumReferenceListValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of references.
        /// </summary>
        /// <param name="references">The list of references.</param>
        void WriteReferences(IEnumerable<Reference> references);
    }
}