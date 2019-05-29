using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumBooleanValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="bool"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumBooleanValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumBooleanValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, bool>
        where TFrom : class, ICesiumBooleanValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="bool"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumBooleanValuePropertyAdaptor([NotNull] TFrom parent,
                                                 [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, bool> writeValueCallback,
                                                 [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}