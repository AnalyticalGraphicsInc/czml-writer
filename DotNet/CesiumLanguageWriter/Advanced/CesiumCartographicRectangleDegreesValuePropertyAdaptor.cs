using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartographicRectangleDegreesValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="CartographicExtent"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicRectangleDegreesValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartographicRectangleDegreesValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, CartographicExtent>
        where TFrom : class, ICesiumCartographicRectangleDegreesValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CartographicExtent"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="CartographicExtent"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartographicRectangleDegreesValuePropertyAdaptor([NotNull] TFrom parent,
                                                                      [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CartographicExtent> writeValueCallback,
                                                                      [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, CartographicExtent> writeSamplesCallback,
                                                                      [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}