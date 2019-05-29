package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.IDisposable;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumInterpolatablePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for a different type of value.
 Typically, the class has a method to write values of the new type, but that method is not exposed via an interface.
 This class adapts the method to the interface via a callback delegate.
 
 
 

 * @param <TFrom> The class that implements {@link ICesiumInterpolatablePropertyWriter} to adapt.
 * @param <TValue> The type of value to which to adapt the class to write.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumInterpolatableWriterAdaptor<TFrom extends ICesiumPropertyWriter & ICesiumInterpolatablePropertyWriter, TValue> implements ICesiumWriterAdaptor<TFrom>,
        ICesiumInterpolatableValuePropertyWriter<TValue>, ICesiumDeletablePropertyWriter {
    /**
    *  
    Initializes a new instance.
    
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a value of type {@code TValue}.
    * @param writeSamplesCallback The callback to write samples of type {@code TValue}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumInterpolatableWriterAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, TValue> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        if (parent == null) {
            throw new ArgumentNullException("parent");
        }
        if (writeValueCallback == null) {
            throw new ArgumentNullException("writeValueCallback");
        }
        if (writeSamplesCallback == null) {
            throw new ArgumentNullException("writeSamplesCallback");
        }
        if (writeDeleteValueCallback == null) {
            throw new ArgumentNullException("writeDeleteValueCallback");
        }
        m_parent = parent;
        m_writeValueCallback = writeValueCallback;
        m_writeSamplesCallback = writeSamplesCallback;
        m_writeDeleteValueCallback = writeDeleteValueCallback;
        m_interval = new Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>>(new Func1<CesiumInterpolatableWriterAdaptor<TFrom, TValue>>() {
            public CesiumInterpolatableWriterAdaptor<TFrom, TValue> invoke() {
                return new CesiumInterpolatableWriterAdaptor<TFrom, TValue>((TFrom) m_parent.getIntervalWriter(), m_writeValueCallback, m_writeSamplesCallback, m_writeDeleteValueCallback);
            }
        }, false);
    }

    /**
    *  

    */
    public final void dispose() {
        m_parent.close();
    }

    /**
    *  Gets the parent being adapted.
    

    */
    public final TFrom getParent() {
        return m_parent;
    }

    /**
    *  
    Gets a value indicating whether the writer is open.
    

    */
    public final boolean getIsOpen() {
        return m_parent.getIsOpen();
    }

    /**
    *  
    Gets the {@link CesiumOutputStream} on which this writer is currently open.  If the writer is
    not open, accessing this property will throw an exception.
    
    

    * @exception IllegalStateException The writer is not currently open on a stream.
    */
    public final CesiumOutputStream getOutput() {
        return m_parent.getOutput();
    }

    /**
    *  

    */
    public final void writeValue(TValue value) {
        m_writeValueCallback.invoke(m_parent, value);
    }

    /**
    *  
    
    Writes an indication that the client should delete existing samples or interval data for this property.
    Data will be deleted for the containing interval, or if there is no containing interval, then all data.
    If true, all other properties in this property will be ignored.
    
    

    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        m_writeDeleteValueCallback.invoke(m_parent);
    }

    /**
    *  

    */
    public final void writeValue(List<JulianDate> dates, List<TValue> values, int startIndex, int length) {
        m_writeSamplesCallback.invoke(m_parent, dates, values, startIndex, length);
    }

    /**
    *  
    
    Writes the interpolation algorithm to use to interpolate the sampled data in this interval.
    
    

    * @param interpolationAlgorithm The interpolation algorithm.
    */
    public final void writeInterpolationAlgorithm(@Nonnull CesiumInterpolationAlgorithm interpolationAlgorithm) {
        m_parent.writeInterpolationAlgorithm(interpolationAlgorithm);
    }

    /**
    *  
    
    Writes the degree of polynomial to use to interpolate sampled data in this interval.
    
    

    * @param degree The degree.
    */
    public final void writeInterpolationDegree(int degree) {
        m_parent.writeInterpolationDegree(degree);
    }

    /**
    *  
    
    Writes the type of extrapolation to perform when a value is requested at a time after any available samples.
    
    

    * @param extrapolationType The extrapolation type.
    */
    public final void writeForwardExtrapolationType(@Nonnull CesiumExtrapolationType extrapolationType) {
        m_parent.writeForwardExtrapolationType(extrapolationType);
    }

    /**
    *  
    
    Writes the amount of time to extrapolate forward before the property becomes undefined.  A value of 0 will extrapolate forever.
    
    

    * @param duration The duration.
    */
    public final void writeForwardExtrapolationDuration(@Nonnull Duration duration) {
        m_parent.writeForwardExtrapolationDuration(duration);
    }

    /**
    *  
    
    Writes the type of extrapolation to perform when a value is requested at a time before any available samples.
    
    

    * @param extrapolationType The extrapolation type.
    */
    public final void writeBackwardExtrapolationType(@Nonnull CesiumExtrapolationType extrapolationType) {
        m_parent.writeBackwardExtrapolationType(extrapolationType);
    }

    /**
    *  
    
    Writes the amount of time to extrapolate backward before the property becomes undefined.  A value of 0 will extrapolate forever.
    
    

    * @param duration The duration.
    */
    public final void writeBackwardExtrapolationDuration(@Nonnull Duration duration) {
        m_parent.writeBackwardExtrapolationDuration(duration);
    }

    /**
    *  
    
    Writes the actual interval of time covered by this CZML interval.
    
    
    

    * @param start The start of the interval.
    * @param stop The end of the interval.
    */
    public final void writeInterval(@Nonnull JulianDate start, @Nonnull JulianDate stop) {
        m_parent.writeInterval(start, stop);
    }

    /**
    *  
    Opens a writer that is used to write information about this property for a single interval.
    
    

    * @return The writer.
    */
    @Nonnull
    public final ICesiumInterpolatableValuePropertyWriter<TValue> openInterval() {
        m_interval.getValue().open(m_parent.getOutput());
        return m_interval.getValue();
    }

    /**
    *  
    Opens a writer that is used to write information about this property for multiple discrete intervals.
    
    

    * @return The writer.
    */
    @Nonnull
    public final ICesiumInterpolatableIntervalListWriter<TValue> openMultipleIntervals() {
        return new MultipleIntervalsAdaptor<TFrom, TValue>(this, m_parent.openMultipleIntervals());
    }

    /**
    *  
    Gets a writer for intervals of this property.  The returned instance must be opened by calling
    the {@link ICesiumElementWriter#open} method before it can be used for writing.  Consider
    calling the {@link #openInterval} or {@link #openMultipleIntervals} method, which will automatically
    open the writer, instead of accessing this property directly.
    

    */
    public final ICesiumPropertyWriter getIntervalWriter() {
        return m_interval.getValue();
    }

    /**
    *  
    Gets a value indicating whether this instance should always open an interval.
    

    */
    public final boolean getForceInterval() {
        return m_parent.getForceInterval();
    }

    /**
    *  
    Sets a value indicating whether this instance should always open an interval.
    

    */
    public final void setForceInterval(boolean value) {
        m_parent.setForceInterval(value);
    }

    /**
    *  
    
    Opens this writer on a given {@link CesiumOutputStream}.  A single writer can write to multiple
    streams over its lifetime.  Opening a writer on a stream may cause data to be written to the stream.
    
    
    

    * @param output The stream to which to write.
    * @exception IllegalStateException The writer is already open on a stream.
    */
    public final void open(CesiumOutputStream output) {
        m_parent.open(output);
    }

    /**
    *  
    
    Closes this writer on a given stream, but does not close the underlying stream.  Closing a writer
    on a stream may cause data to be written to the stream.
    
    

    * @exception IllegalStateException The writer is not open on a stream.
    */
    public final void close() {
        m_parent.close();
    }

    @Nonnull
    private TFrom m_parent;
    @Nonnull
    private CesiumWriterAdaptorWriteCallback<TFrom, TValue> m_writeValueCallback;
    @Nonnull
    private CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> m_writeSamplesCallback;
    @Nonnull
    private CesiumWriterAdaptorWriteDeleteCallback<TFrom> m_writeDeleteValueCallback;
    @Nonnull
    private Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>> m_interval;

    private static class MultipleIntervalsAdaptor<TFrom extends ICesiumPropertyWriter & ICesiumInterpolatablePropertyWriter, TValue> implements ICesiumInterpolatableIntervalListWriter<TValue> {
        public MultipleIntervalsAdaptor(@Nonnull CesiumInterpolatableWriterAdaptor<TFrom, TValue> intervalAdaptor, @Nonnull ICesiumIntervalListWriter parent) {
            if (intervalAdaptor == null) {
                throw new ArgumentNullException("intervalAdaptor");
            }
            if (parent == null) {
                throw new ArgumentNullException("parent");
            }
            m_intervalAdaptor = intervalAdaptor;
            m_parent = parent;
        }

        public final void dispose() {
            m_parent.close();
        }

        public final ICesiumInterpolatableValuePropertyWriter<TValue> openInterval() {
            return m_intervalAdaptor.openInterval();
        }

        public final ICesiumInterpolatableValuePropertyWriter<TValue> openInterval(@Nonnull JulianDate start, @Nonnull JulianDate stop) {
            ICesiumInterpolatableValuePropertyWriter<TValue> intervalWriter = m_intervalAdaptor.openInterval();
            intervalWriter.writeInterval(start, stop);
            return intervalWriter;
        }

        public final boolean getIsOpen() {
            return m_parent.getIsOpen();
        }

        public final CesiumOutputStream getOutput() {
            return m_parent.getOutput();
        }

        public final void open(CesiumOutputStream output) {
            m_parent.open(output);
        }

        public final void close() {
            m_parent.close();
        }

        @Nonnull
        private CesiumInterpolatableWriterAdaptor<TFrom, TValue> m_intervalAdaptor;
        @Nonnull
        private ICesiumIntervalListWriter m_parent;
    }
}