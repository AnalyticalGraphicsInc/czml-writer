using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartesian3ValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Cartesian"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian3ValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartesian3ValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Cartesian>
        where TFrom : class, ICesiumCartesian3ValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Cartesian"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Cartesian"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartesian3ValuePropertyAdaptor([NotNull] TFrom parent,
                                                    [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Cartesian> writeValueCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Cartesian> writeSamplesCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}