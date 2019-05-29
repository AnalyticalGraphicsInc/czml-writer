using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumCornerTypeValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumCornerType"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCornerTypeValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumCornerTypeValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumCornerType>
        where TFrom : class, ICesiumCornerTypeValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumArcType"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumCornerTypeValuePropertyAdaptor([NotNull] TFrom parent,
                                                    [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumCornerType> writeValueCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}