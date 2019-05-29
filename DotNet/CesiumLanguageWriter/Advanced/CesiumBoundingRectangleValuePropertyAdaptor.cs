using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumBoundingRectangleValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="BoundingRectangle"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumBoundingRectangleValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumBoundingRectangleValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, BoundingRectangle>
        where TFrom : class, ICesiumBoundingRectangleValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="BoundingRectangle"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="BoundingRectangle"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumBoundingRectangleValuePropertyAdaptor([NotNull] TFrom parent,
                                                           [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, BoundingRectangle> writeValueCallback,
                                                           [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, BoundingRectangle> writeSamplesCallback,
                                                           [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}