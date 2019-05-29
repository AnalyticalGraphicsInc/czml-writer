using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumVerticalOriginValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="CesiumVerticalOrigin"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumVerticalOriginValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumVerticalOriginValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumVerticalOrigin>
        where TFrom : class, ICesiumVerticalOriginValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumVerticalOrigin"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumVerticalOriginValuePropertyAdaptor([NotNull] TFrom parent,
                                                        [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumVerticalOrigin> writeValueCallback,
                                                        [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}