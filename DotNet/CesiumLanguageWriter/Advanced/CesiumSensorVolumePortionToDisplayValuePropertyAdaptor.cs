using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumSensorVolumePortionToDisplayValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumSensorVolumePortionToDisplay"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumSensorVolumePortionToDisplayValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumSensorVolumePortionToDisplay>
        where TFrom : class, ICesiumSensorVolumePortionToDisplayValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumSensorVolumePortionToDisplay"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumSensorVolumePortionToDisplayValuePropertyAdaptor([NotNull] TFrom parent,
                                                                      [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumSensorVolumePortionToDisplay> writeValueCallback,
                                                                      [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}