using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumStringValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for <see cref="string"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumStringValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumStringValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, string>
        where TFrom : class, ICesiumStringValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="string"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumStringValuePropertyAdaptor([NotNull] TFrom parent,
                                                [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, string> writeValueCallback,
                                                [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}