using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumUnitQuaternionValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="UnitQuaternion"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitQuaternionValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumUnitQuaternionValuePropertyAdaptor<TFrom> : CesiumInterpolatableWriterAdaptor<TFrom, UnitQuaternion>
        where TFrom : class, ICesiumUnitQuaternionValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="UnitQuaternion"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <see cref="UnitQuaternion"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumUnitQuaternionValuePropertyAdaptor([NotNull] TFrom parent,
                                                        [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, UnitQuaternion> writeValueCallback,
                                                        [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, UnitQuaternion> writeSamplesCallback,
                                                        [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback)
        {
        }
    }
}