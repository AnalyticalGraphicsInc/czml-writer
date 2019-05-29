using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumUnitCartesian3ValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="UnitCartesian"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitCartesian3ValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumUnitCartesian3ValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, UnitCartesian>
        where TFrom : class, ICesiumUnitCartesian3ValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="UnitCartesian"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="UnitCartesian"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumUnitCartesian3ValuePropertyAdaptor([NotNull] TFrom parent,
                                                        [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, UnitCartesian> writeValueCallback,
                                                        [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, UnitCartesian> writeSamplesCallback,
                                                        [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}