using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumColorBlendModeValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumColorBlendMode"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumColorBlendModeValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumColorBlendModeValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumColorBlendMode>
        where TFrom : class, ICesiumColorBlendModeValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumColorBlendMode"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumColorBlendModeValuePropertyAdaptor([NotNull] TFrom parent,
                                                        [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumColorBlendMode> writeValueCallback,
                                                        [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}