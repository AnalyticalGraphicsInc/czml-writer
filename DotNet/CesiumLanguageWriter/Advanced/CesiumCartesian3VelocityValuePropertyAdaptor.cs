using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCartesian3VelocityValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Motion{Cartesian}"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian3VelocityValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCartesian3VelocityValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Motion<Cartesian>>
        where TFrom : class, ICesiumCartesian3VelocityValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Motion{Cartesian}"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Motion{Cartesian}"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCartesian3VelocityValuePropertyAdaptor([NotNull] TFrom parent,
                                                            [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Motion<Cartesian>> writeValueCallback,
                                                            [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Motion<Cartesian>> writeSamplesCallback,
                                                            [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}