using System;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// The base class for types that write CZML data to a stream.
    /// </summary>
    public abstract class CesiumElementWriter : ICesiumElementWriter
    {
        void IDisposable.Dispose()
        {
            Close();
        }

        /// <summary>
        /// Opens this writer on a given <see cref="CesiumOutputStream"/>.  A single writer can write to multiple
        /// streams over its lifetime.  Opening a writer on a stream may cause data to be written to the stream.
        /// </summary>
        /// <param name="output">The stream to which to write.</param>
        /// <exception cref="InvalidOperationException">The writer is already open on a stream.</exception>
        public void Open(CesiumOutputStream output)
        {
            if (output == null)
                throw new ArgumentNullException("output");

            if (m_output != null)
                throw new InvalidOperationException(CesiumLocalization.WriterAlreadyOpen);

            m_output = output;
            OnOpen();
        }

        /// <summary>
        /// Closes this writer on a given stream, but does not close the underlying stream.  Closing a writer
        /// on a stream may cause data to be written to the stream.
        /// </summary>
        /// <exception cref="InvalidOperationException">The writer is not open on a stream.</exception>
        public void Close()
        {
            if (m_output == null)
                throw new InvalidOperationException(CesiumLocalization.WriterAlreadyClosed);

            OnClose();
            m_output = null;
        }

        /// <summary>
        /// Gets <see langword="true" /> if the writer is open; otherwise, <see langword="false" />.
        /// </summary>
        public bool IsOpen
        {
            get { return m_output != null; }
        }

        /// <summary>
        /// Gets the <see cref="CesiumOutputStream"/> on which this writer is currently open.  If the writer is
        /// not open, accessing this property will throw an exception.
        /// </summary>
        /// <exception cref="InvalidOperationException">The writer is not currently open on a stream.</exception>
        /// <seealso cref="OutputOrNull"/>
        public CesiumOutputStream Output
        {
            get
            {
                if (m_output == null)
                    throw new InvalidOperationException(CesiumLocalization.WriterNotOpen);
                return m_output;
            }
        }

        /// <summary>
        /// Gets the <see cref="CesiumOutputStream"/> on which this writer is currently open, or
        /// <see langword="null"/> if the writer is not open.
        /// </summary>
        /// <seealso cref="Output"/>
        [CanBeNull]
        protected CesiumOutputStream OutputOrNull
        {
            get { return m_output; }
        }

        /// <summary>
        /// When overridden in a derived class, writes content to the stream immediately after opening the writer on it.
        /// </summary>
        protected virtual void OnOpen()
        {
        }

        /// <summary>
        /// When overridden in a derived class, writes content to the stream immediately before closing the writer on it.
        /// </summary>
        protected virtual void OnClose()
        {
        }

        /// <summary>
        /// Opens a <see cref="CesiumElementWriter"/> on the same stream on which this one is currently open.
        /// For convenience, this method returns a reference to the same writer passed to it.
        /// </summary>
        /// <typeparam name="T">The type of the writer to open.</typeparam>
        /// <param name="writer">The writer.</param>
        /// <returns>The same writer, now opened on the stream.</returns>
        [NotNull]
        protected T OpenAndReturn<T>([NotNull] T writer)
            where T : CesiumElementWriter
        {
            if (writer == null)
                throw new ArgumentNullException("writer");

            writer.Open(Output);
            return writer;
        }

        [CanBeNull]
        private CesiumOutputStream m_output;
    }
}