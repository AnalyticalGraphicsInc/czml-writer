using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartesian2ValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Rectangular"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian2ValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartesian2ValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Rectangular>
        where TFrom : class, ICesiumCartesian2ValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Rectangular"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Rectangular"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartesian2ValuePropertyAdaptor([NotNull] TFrom parent,
                                                    [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Rectangular> writeValueCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Rectangular> writeSamplesCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}