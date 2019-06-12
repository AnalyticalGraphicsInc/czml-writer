using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumClassificationTypeValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for <see cref="CesiumClassificationType"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumClassificationTypeValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumClassificationTypeValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, CesiumClassificationType>
        where TFrom : class, ICesiumClassificationTypeValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <see cref="CesiumClassificationType"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumClassificationTypeValuePropertyAdaptor([NotNull] TFrom parent,
                                                            [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, CesiumClassificationType> writeValueCallback,
                                                            [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}