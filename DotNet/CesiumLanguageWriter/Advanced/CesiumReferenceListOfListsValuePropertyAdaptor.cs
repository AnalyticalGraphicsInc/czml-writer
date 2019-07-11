using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumReferenceListOfListsValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for a list of lists of <see cref="Reference"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumReferenceListOfListsValuePropertyWriter"/> to adapt.</typeparam>
    [CSToJavaUseWildcardGenerics]
    public class CesiumReferenceListOfListsValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<IEnumerable<Reference>>>
        where TFrom : class, ICesiumReferenceListOfListsValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of lists of <see cref="Reference"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumReferenceListOfListsValuePropertyAdaptor([NotNull] TFrom parent,
                                                              [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<IEnumerable<Reference>>> writeValueCallback,
                                                              [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}