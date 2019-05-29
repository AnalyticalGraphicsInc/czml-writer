using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumUriValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="CesiumResource"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUriValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumUriValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumResource>
        where TFrom : class, ICesiumUriValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumArcType"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumUriValuePropertyAdaptor([NotNull] TFrom parent,
                                             [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumResource> writeValueCallback,
                                             [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}