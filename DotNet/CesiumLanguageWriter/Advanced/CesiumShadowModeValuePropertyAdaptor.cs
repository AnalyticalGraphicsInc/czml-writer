using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumShadowModeValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="CesiumShadowMode"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumShadowModeValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumShadowModeValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumShadowMode>
        where TFrom : class, ICesiumShadowModeValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumArcType"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumShadowModeValuePropertyAdaptor([NotNull] TFrom parent,
                                                    [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumShadowMode> writeValueCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}