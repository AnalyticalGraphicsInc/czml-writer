using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartographicDegreesValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Cartographic"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicDegreesValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartographicDegreesValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Cartographic>
        where TFrom : class, ICesiumCartographicDegreesValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Cartographic"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Cartographic"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartographicDegreesValuePropertyAdaptor([NotNull] TFrom parent,
                                                             [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Cartographic> writeValueCallback,
                                                             [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Cartographic> writeSamplesCallback,
                                                             [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}