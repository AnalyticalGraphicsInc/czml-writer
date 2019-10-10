package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.IDisposable;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *  
 The base class for types that write CZML data to a stream.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public abstract class CesiumElementWriter implements ICesiumElementWriter {
    public final void dispose() {
        close();
    }

    /**
    *  
    Opens this writer on a given {@link CesiumOutputStream}.  A single writer can write to multiple
    streams over its lifetime.  Opening a writer on a stream may cause data to be written to the stream.
    
    
    

    * @param output The stream to write to.
    * @exception IllegalStateException The writer is already open on a stream.
    */
    public final void open(CesiumOutputStream output) {
        if (output == null) {
            throw new ArgumentNullException("output");
        }
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

    /**
    *  Gets a value indicating whether the writer is open.
    

    */
    public final boolean getIsOpen() {
        return m_output != null;
    }

    /**
    *  Gets the {@link CesiumOutputStream} on which this writer is currently open.  If the writer is
    not open, accessing this property will throw an exception.
    
    
    

    * @exception IllegalStateException The writer is not currently open on a stream.
    * @see #getOutputOrNull
    */
    public final CesiumOutputStream getOutput() {
        if (m_output == null) {
            throw new IllegalStateException(CesiumLocalization.getWriterNotOpen());
        }
        return m_output;
    }

    /**
    *  Gets the {@link CesiumOutputStream} on which this writer is currently open, or
    {@code null} if the writer is not open.
    
    

    * @see #getOutput
    */
    @Nullable
    protected final CesiumOutputStream getOutputOrNull() {
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
    Opens a {@link CesiumElementWriter} on the same stream on which this one is currently open.
    For convenience, this method returns a reference to the same writer passed to it.
    
    
    
    

    * @param <T> The type of the writer to open.
    * @param writer The writer.
    * @return The same writer, now opened on the stream.
    */
    @Nonnull
    protected final <T extends CesiumElementWriter> T openAndReturn(@Nonnull T writer) {
        if (writer == null) {
            throw new ArgumentNullException("writer");
        }
        writer.open(getOutput());
        return writer;
    }

    @Nullable
    private CesiumOutputStream m_output;
}