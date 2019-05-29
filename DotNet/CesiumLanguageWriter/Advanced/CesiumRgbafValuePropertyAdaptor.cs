using System.Drawing;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumRgbafValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Color"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumRgbafValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumRgbafValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Color>
        where TFrom : class, ICesiumRgbafValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Color"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Color"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumRgbafValuePropertyAdaptor([NotNull] TFrom parent,
                                               [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Color> writeValueCallback,
                                               [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Color> writeSamplesCallback,
                                               [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}