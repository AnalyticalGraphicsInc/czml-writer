using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A callback to write a value to a <see cref="CesiumOutputStream"/> using a given
    /// wrapped property writer.
    /// </summary>
    /// <typeparam name="TWrappedWriter">The type of the wrapped writer.</typeparam>
    /// <typeparam name="TValue">The type of the value to write.</typeparam>
    /// <param name="wrappedWriter">The wrapper writer.</param>
    /// <param name="value">The value.</param>
    public delegate void CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>([NotNull] TWrappedWriter wrappedWriter, TValue value);
}