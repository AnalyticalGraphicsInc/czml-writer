using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumDistanceDisplayConditionValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Bounds"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumDistanceDisplayConditionValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumDistanceDisplayConditionValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Bounds>
        where TFrom : class, ICesiumDistanceDisplayConditionValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Bounds"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Bounds"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumDistanceDisplayConditionValuePropertyAdaptor([NotNull] TFrom parent,
                                                                  [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Bounds> writeValueCallback,
                                                                  [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Bounds> writeSamplesCallback,
                                                                  [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}