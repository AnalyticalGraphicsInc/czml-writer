package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class derived from {@link CesiumPropertyWriter} to implement
 {@link ICesiumValuePropertyWriter} for a different type of value.  Typically, the
 class has a method to write values of the new type, but that method is not exposed via an interface.
 This class adapts the method to the interface via a callback delegate.
 
 
 

 * @param <TFrom> The class derived from {@link CesiumPropertyWriter} to adapt.
 * @param <TValue> The type of value to which to adapt the class to write.
 */
@SuppressWarnings("unused")
public class CesiumWriterAdaptor<TFrom extends ICesiumPropertyWriter, TValue> implements ICesiumValuePropertyWriter<TValue>, ICesiumWriterAdaptor<TFrom> {
    /**
    *  
    Initializes a new instance.
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@code TValue}.
    */
    public CesiumWriterAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, TValue> writeValueCallback) {
        if (parent == null) {
            throw new ArgumentNullException("parent");
        }
        if (writeValueCallback == null) {
            throw new ArgumentNullException("writeValueCallback");
        }
        m_parent = parent;
        m_writeValueCallback = writeValueCallback;
        m_interval = new Lazy<CesiumWriterAdaptor<TFrom, TValue>>(new Func1<CesiumWriterAdaptor<TFrom, TValue>>() {
            public CesiumWriterAdaptor<TFrom, TValue> invoke() {
                return new CesiumWriterAdaptor<TFrom, TValue>((TFrom) m_parent.getIntervalWriter(), m_writeValueCallback);
            }
        }, false);
    }

    public final void dispose() {
        m_parent.close();
    }

    /**
    *  Gets the parent being adapted.
    

    */
    public final TFrom getParent() {
        return m_parent;
    }

    public final boolean getIsOpen() {
        return m_parent.getIsOpen();
    }

    public final CesiumOutputStream getOutput() {
        return m_parent.getOutput();
    }

    public final void writeValue(TValue value) {
        m_writeValueCallback.invoke(m_parent, value);
    }

    public final void writeInterval(JulianDate start, JulianDate stop) {
        m_parent.writeInterval(start, stop);
    }

    public final ICesiumPropertyWriter openInterval() {
        m_interval.getValue().open(m_parent.getOutput());
        return m_interval.getValue();
    }

    public final ICesiumIntervalListWriter openMultipleIntervals() {
        return m_parent.openMultipleIntervals();
    }

    public final ICesiumPropertyWriter getIntervalWriter() {
        return m_interval.getValue();
    }

    public final boolean getForceInterval() {
        return m_parent.getForceInterval();
    }

    public final void setForceInterval(boolean value) {
        m_parent.setForceInterval(value);
    }

    public final void open(CesiumOutputStream output) {
        m_parent.open(output);
    }

    public final void close() {
        m_parent.close();
    }

    @Nonnull
    private TFrom m_parent;
    @Nonnull
    private CesiumWriterAdaptorWriteCallback<TFrom, TValue> m_writeValueCallback;
    @Nonnull
    private Lazy<CesiumWriterAdaptor<TFrom, TValue>> m_interval;
}