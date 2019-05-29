using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumNearFarScalarValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="NearFarScalar"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumNearFarScalarValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumNearFarScalarValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, NearFarScalar>
        where TFrom : class, ICesiumNearFarScalarValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="NearFarScalar"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="NearFarScalar"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumNearFarScalarValuePropertyAdaptor([NotNull] TFrom parent,
                                                       [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, NearFarScalar> writeValueCallback,
                                                       [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, NearFarScalar> writeSamplesCallback,
                                                       [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}