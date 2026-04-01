using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumPathModeValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="CesiumPathMode"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumPathModeValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumPathModeValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumPathMode>
        where TFrom : class, ICesiumPathModeValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumPathMode"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumPathModeValuePropertyAdaptor([NotNull] TFrom parent,
                                                  [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumPathMode> writeValueCallback,
                                                  [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}
