using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumSphericalValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="Spherical"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumSphericalValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumSphericalValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, Spherical>
        where TFrom : class, ICesiumSphericalValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="Spherical"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="Spherical"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumSphericalValuePropertyAdaptor([NotNull] TFrom parent,
                                                   [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, Spherical> writeValueCallback,
                                                   [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, Spherical> writeSamplesCallback,
                                                   [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}