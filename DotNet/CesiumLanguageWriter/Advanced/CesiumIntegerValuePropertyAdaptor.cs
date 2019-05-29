using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumIntegerValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="int"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumIntegerValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumIntegerValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, int>
        where TFrom : class, ICesiumIntegerValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="int"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="int"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumIntegerValuePropertyAdaptor([NotNull] TFrom parent,
                                                 [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, int> writeValueCallback,
                                                 [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, int> writeSamplesCallback,
                                                 [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}