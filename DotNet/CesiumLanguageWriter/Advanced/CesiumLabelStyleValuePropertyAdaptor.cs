using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumLabelStyleValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumLabelStyle"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumLabelStyleValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumLabelStyleValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumLabelStyle>
        where TFrom : class, ICesiumLabelStyleValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumLabelStyle"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumLabelStyleValuePropertyAdaptor([NotNull] TFrom parent,
                                                    [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumLabelStyle> writeValueCallback,
                                                    [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}