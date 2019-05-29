using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumHorizontalOriginValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumHorizontalOrigin"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumHorizontalOriginValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumHorizontalOriginValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumHorizontalOrigin>
        where TFrom : class, ICesiumHorizontalOriginValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumHorizontalOrigin"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumHorizontalOriginValuePropertyAdaptor([NotNull] TFrom parent,
                                                          [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumHorizontalOrigin> writeValueCallback,
                                                          [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}