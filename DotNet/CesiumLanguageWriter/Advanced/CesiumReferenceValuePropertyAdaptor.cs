using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumReferenceValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Reference"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumReferenceValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumReferenceValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, Reference>
        where TFrom : class, ICesiumReferenceValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Reference"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumReferenceValuePropertyAdaptor([NotNull] TFrom parent,
                                                   [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Reference> writeValueCallback,
                                                   [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}