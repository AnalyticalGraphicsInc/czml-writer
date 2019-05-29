using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumUnitSphericalValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="UnitSpherical"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitSphericalValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumUnitSphericalValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, UnitSpherical>
        where TFrom : class, ICesiumUnitSphericalValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="UnitSpherical"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="UnitSpherical"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumUnitSphericalValuePropertyAdaptor([NotNull] TFrom parent,
                                                       [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, UnitSpherical> writeValueCallback,
                                                       [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, UnitSpherical> writeSamplesCallback,
                                                       [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}