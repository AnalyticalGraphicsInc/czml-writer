namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Interface for classes that adapt a class derived from <see cref="CesiumPropertyWriter{TDerived}"/>.
    /// </summary>
    /// <typeparam name="TFrom">The type of property writer class to adapt.</typeparam>
    public interface ICesiumWriterAdaptor<TFrom>
    {
        /// <summary>
        /// Gets the parent being adapted.
        /// </summary>
        TFrom Parent { get; }
    }
}