using System.Drawing;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumRgbaValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Color"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumRgbaValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumRgbaValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Color>
        where TFrom : class, ICesiumRgbaValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Color"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Color"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumRgbaValuePropertyAdaptor([NotNull] TFrom parent,
                                              [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Color> writeValueCallback,
                                              [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Color> writeSamplesCallback,
                                              [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}