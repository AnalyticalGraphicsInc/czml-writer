using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumStripeOrientationValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="CesiumStripeOrientation"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumStripeOrientationValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumStripeOrientationValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumStripeOrientation>
        where TFrom : class, ICesiumStripeOrientationValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumStripeOrientation"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumStripeOrientationValuePropertyAdaptor([NotNull] TFrom parent,
                                                           [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumStripeOrientation> writeValueCallback,
                                                           [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}