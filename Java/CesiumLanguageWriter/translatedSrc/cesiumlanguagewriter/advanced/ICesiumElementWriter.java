package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.IDisposable;
import cesiumlanguagewriter.*;

/**
 *  
 An interface to an instance that can write elements of <topic name="Cesium">Cesium</topic>.
 

 */
public interface ICesiumElementWriter extends IDisposable {
	/**
	 *  Gets <see langword="true" /> if the writer is open; otherwise, <see langword="false" />.
	

	 */
	boolean getIsOpen();

	/**
	 *  Gets the  {@link CesiumOutputStream} on which this writer is currently open.  If the writer is
	not open, accessing this property will throw an exception.
	
	

	 * @exception IllegalStateException The writer is not currently open on a stream.
	 */
	CesiumOutputStream getOutput();

	/**
	 *  
	Opens this writer on a given  {@link CesiumOutputStream}.  A single writer can write to multiple
	streams over its lifetime.  Opening a writer on a stream may cause data to be written to the stream.
	
	
	

	 * @param output The stream to which to write.
	 * @exception IllegalStateException The writer is already open on a stream.
	 */
	void open(CesiumOutputStream output);

	/**
	 *  
	Closes this writer on a given stream, but does not close the underlying stream.  Closing a writer
	on a stream may cause data to be written to the stream.
	
	

	 * @exception IllegalStateException The writer is not open on a stream.
	 */
	void close();
}