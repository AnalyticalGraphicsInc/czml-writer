using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumReferenceListValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for a list of <see cref="Reference"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumReferenceListValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumReferenceListValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<Reference>>
        where TFrom : class, ICesiumReferenceListValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of <see cref="Reference"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumReferenceListValuePropertyAdaptor([NotNull] TFrom parent,
                                                       [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<Reference>> writeValueCallback,
                                                       [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}