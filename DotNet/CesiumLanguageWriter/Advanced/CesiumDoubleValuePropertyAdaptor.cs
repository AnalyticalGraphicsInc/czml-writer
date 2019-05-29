using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumDoubleValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="double"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumDoubleValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumDoubleValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, double>
        where TFrom : class, ICesiumDoubleValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="double"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="double"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumDoubleValuePropertyAdaptor([NotNull] TFrom parent,
                                                [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, double> writeValueCallback,
                                                [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, double> writeSamplesCallback,
                                                [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}