using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a list of lists of three-dimensional Cartesian values.
    /// </summary>
    public interface ICesiumCartesian3ListOfListsValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a list of lists of three-dimensional Cartesian values.
        /// </summary>
        /// <param name="values">The values.</param>
        [CSToJavaUseWildcardGenerics]
        void WriteCartesian(IEnumerable<IEnumerable<Cartesian>> values);
    }
}