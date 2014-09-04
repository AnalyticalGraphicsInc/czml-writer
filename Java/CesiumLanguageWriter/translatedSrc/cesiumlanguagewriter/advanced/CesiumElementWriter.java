package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.IDisposable;
import cesiumlanguagewriter.*;

/**
 *  
 The base class for types that write CZML data to a stream.
 

 */
public abstract class CesiumElementWriter implements ICesiumElementWriter, IDisposable {
	private CesiumOutputStream m_output;

	/**
	 *  
	Opens this writer on a given  {@link CesiumOutputStream}.  A single writer can write to multiple
	streams over its lifetime.  Opening a writer on a stream may cause data to be written to the stream.
	
	
	

	 * @param output The stream to which to write.
	 * @exception IllegalStateException The writer is already open on a stream.
	 */
	public final void open(CesiumOutputStream output) {
		if (m_output != null) {
			throw new IllegalStateException(CesiumLocalization.getWriterAlreadyOpen());
		}
		m_output = output;
		onOpen();
	}

	/**
	 *  
	Closes this writer on a given stream, but does not close the underlying stream.  Closing a writer
	on a stream may cause data to be written to the stream.
	
	

	 * @exception IllegalStateException The writer is not open on a stream.
	 */
	public final void close() {
		if (m_output == null) {
			throw new IllegalStateException(CesiumLocalization.getWriterAlreadyClosed());
		}
		onClose();
		m_output = null;
	}

	public final void dispose() {
		close();
	}

	/**
	 *  Gets <see langword="true" /> if the writer is open; otherwise, <see langword="false" />.
	

	 */
	public final boolean getIsOpen() {
		return getOutputOrNull() != null;
	}

	/**
	 *  Gets the  {@link CesiumOutputStream} on which this writer is currently open.  If the writer is
	not open, accessing this property will throw an exception.
	
	
	

	 * @exception IllegalStateException The writer is not currently open on a stream.
	 * @see #getOutputOrNull
	 */
	public final CesiumOutputStream getOutput() {
		if (getOutputOrNull() == null) {
			throw new IllegalStateException(CesiumLocalization.getWriterNotOpen());
		}
		return getOutputOrNull();
	}

	/**
	 *  Gets the  {@link CesiumOutputStream} on which this writer is currently open, or
	<see langword="null" /> if the writer is not open.
	
	

	 * @see #getOutput
	 */
	final protected CesiumOutputStream getOutputOrNull() {
		return m_output;
	}

	/**
	 *  
	When overridden in a derived class, writes content to the stream immediately after opening the writer on it.
	

	 */
	protected void onOpen() {}

	/**
	 *  
	When overridden in a derived class, writes content to the stream immediately before closing the writer on it.
	

	 */
	protected void onClose() {}

	/**
	 *  
	Opens a  {@link CesiumElementWriter} on the same stream on which this one is currently open.
	For convenience, this method returns a reference to the same writer passed to it.
	
	
	
	

	 * @param <T> The type of the writer to open.
	 * @param writer The writer.
	 * @return The same writer, now opened on the stream.
	 */
	final protected <T extends CesiumElementWriter> T openAndReturn(T writer) {
		writer.open(getOutput());
		return writer;
	}
}