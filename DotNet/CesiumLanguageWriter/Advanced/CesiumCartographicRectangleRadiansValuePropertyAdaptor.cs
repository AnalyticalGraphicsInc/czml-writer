using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartographicRectangleRadiansValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="CartographicExtent"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicRectangleRadiansValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartographicRectangleRadiansValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, CartographicExtent>
        where TFrom : class, ICesiumCartographicRectangleRadiansValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CartographicExtent"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="CartographicExtent"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartographicRectangleRadiansValuePropertyAdaptor([NotNull] TFrom parent,
                                                                      [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CartographicExtent> writeValueCallback,
                                                                      [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, CartographicExtent> writeSamplesCallback,
                                                                      [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}