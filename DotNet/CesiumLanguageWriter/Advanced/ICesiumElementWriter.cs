using System;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// An interface to an instance that can write elements of <topic name="Cesium">Cesium</topic>.
    /// </summary>
    public interface ICesiumElementWriter : IDisposable
    {
        /// <summary>
        /// Gets <see langword="true" /> if the writer is open; otherwise, <see langword="false" />.
        /// </summary>
        bool IsOpen { get; }

        /// <summary>
        /// Gets the <see cref="CesiumOutputStream"/> on which this writer is currently open.  If the writer is
        /// not open, accessing this property will throw an exception.
        /// </summary>
        /// <exception cref="InvalidOperationException">The writer is not currently open on a stream.</exception>
        CesiumOutputStream Output { get; }

        /// <summary>
        /// Opens this writer on a given <see cref="CesiumOutputStream"/>.  A single writer can write to multiple
        /// streams over its lifetime.  Opening a writer on a stream may cause data to be written to the stream.
        /// </summary>
        /// <param name="output">The stream to which to write.</param>
        /// <exception cref="InvalidOperationException">The writer is already open on a stream.</exception>
        void Open(CesiumOutputStream output);

        /// <summary>
        /// Closes this writer on a given stream, but does not close the underlying stream.  Closing a writer
        /// on a stream may cause data to be written to the stream.
        /// </summary>
        /// <exception cref="InvalidOperationException">The writer is not open on a stream.</exception>
        void Close();
    }
}