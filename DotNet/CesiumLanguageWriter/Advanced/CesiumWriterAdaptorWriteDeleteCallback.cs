using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A callback to write an indication that the client should delete existing samples for a given wrapped property writer.
    /// </summary>
    /// <typeparam name="TWrappedWriter">The type of the wrapped writer.</typeparam>
    /// <param name="wrappedWriter">The wrapper writer.</param>
    public delegate void CesiumWriterAdaptorWriteDeleteCallback<TWrappedWriter>([NotNull] TWrappedWriter wrappedWriter)
        where TWrappedWriter : class, ICesiumPropertyWriter;
}