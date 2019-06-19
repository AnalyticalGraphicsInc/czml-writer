using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartesian3ListOfListsValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for a list of lists of <see cref="Cartesian"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian3ListOfListsValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartesian3ListOfListsValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<IEnumerable<Cartesian>>>
        where TFrom : class, ICesiumCartesian3ListOfListsValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of lists of <see cref="Cartesian"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartesian3ListOfListsValuePropertyAdaptor([NotNull] TFrom parent,
                                                               [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<IEnumerable<Cartesian>>> writeValueCallback,
                                                               [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}