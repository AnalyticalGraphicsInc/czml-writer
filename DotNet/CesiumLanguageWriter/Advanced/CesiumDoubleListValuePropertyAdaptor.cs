using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumDoubleListValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for a list of <see cref="double"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumDoubleValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumDoubleListValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<double>>
        where TFrom : class, ICesiumDoubleListValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of <see cref="double"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumDoubleListValuePropertyAdaptor([NotNull] TFrom parent,
                                                    [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<double>> writeValueCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}