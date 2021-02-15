using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartesian2ListValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for a list of <see cref="Rectangular"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian2ListValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartesian2ListValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<Rectangular>>
        where TFrom : class, ICesiumCartesian2ListValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of <see cref="Rectangular"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartesian2ListValuePropertyAdaptor([NotNull] TFrom parent,
                                                        [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<Rectangular>> writeValueCallback,
                                                        [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}