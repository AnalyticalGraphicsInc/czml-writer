using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumArcTypeValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumArcType"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumArcTypeValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumArcTypeValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumArcType>
        where TFrom : class, ICesiumArcTypeValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumArcType"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumArcTypeValuePropertyAdaptor([NotNull] TFrom parent,
                                                 [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumArcType> writeValueCallback,
                                                 [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}