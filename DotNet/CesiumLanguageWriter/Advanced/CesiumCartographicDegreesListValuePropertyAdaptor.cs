using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartographicDegreesListValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for a list of <see cref="Cartographic"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicDegreesValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartographicDegreesListValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<Cartographic>>
        where TFrom : class, ICesiumCartographicDegreesListValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of <see cref="Cartographic"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartographicDegreesListValuePropertyAdaptor([NotNull] TFrom parent,
                                                                 [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<Cartographic>> writeValueCallback,
                                                                 [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}