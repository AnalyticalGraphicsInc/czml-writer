using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of lists of references to other properties.
    /// </summary>
    public interface ICesiumReferenceListOfListsValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of lists of references.
        /// </summary>
        /// <param name="references">The list of lists of references.</param>
        [CSToJavaUseWildcardGenerics]
        void WriteReferences(IEnumerable<IEnumerable<Reference>> references);
    }
}