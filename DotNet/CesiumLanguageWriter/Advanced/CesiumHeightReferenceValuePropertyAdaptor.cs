using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumHeightReferenceValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumHeightReference"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumHeightReferenceValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumHeightReferenceValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumHeightReference>
        where TFrom : class, ICesiumHeightReferenceValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumArcType"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumHeightReferenceValuePropertyAdaptor([NotNull] TFrom parent,
                                                         [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumHeightReference> writeValueCallback,
                                                         [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}