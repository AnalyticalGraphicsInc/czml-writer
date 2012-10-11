package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.Internal;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.Delegate;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.*;
import java.util.List;

/**
 *  
 Adapts a class derived from  {@link CesiumInterpolatablePropertyWriter} to implement
  {@link ICesiumValuePropertyWriter} for a different type of value.  Typically, the
 class has a method to write values of the new type, but that method is not exposed via an interface.
 This class adapts the method to the interface via a callback delegate.
 
 
 

 * @param <TFrom> The class derived from  {@link CesiumInterpolatablePropertyWriter} to adapt.
 * @param <TValue> The type of value to which to adapt the class to write.
 */
public class CesiumInterpolatableWriterAdaptor<TFrom extends ICesiumPropertyWriter & ICesiumInterpolationInformationWriter, TValue> implements ICesiumInterpolatableValuePropertyWriter<TValue> {
	private TFrom m_parent;
	private CesiumWriterAdaptorWriteCallback<TFrom, TValue> m_writeValueCallback;
	private CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> m_writeSamplesCallback;
	private Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>> m_interval;

	/**
	 *  
	Initializes a new instance.
	
	
	
	

	 * @param parent The instance to wrap.
	 * @param writeValueCallback The callback to write a value of type <code>TValue</code>.
	 * @param writeSamplesCallback The callback to write samples of type <code>TValue</code>.
	 */
	public CesiumInterpolatableWriterAdaptor(TFrom parent, CesiumWriterAdaptorWriteCallback<TFrom, TValue> writeValueCallback,
			CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> writeSamplesCallback) {
		if (parent == null) {
			throw new ArgumentNullException("parent");
		}
		if (writeValueCallback == null) {
			throw new ArgumentNullException("writeValueCallback");
		}
		if (writeSamplesCallback == null) {
			throw new ArgumentNullException("writeSamplesCallback");
		}
		m_parent = parent;
		m_writeValueCallback = writeValueCallback;
		m_writeSamplesCallback = writeSamplesCallback;
		m_interval = new Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>>(new Func1<CesiumInterpolatableWriterAdaptor<TFrom, TValue>>() {
			public CesiumInterpolatableWriterAdaptor<TFrom, TValue> invoke() {
				return new CesiumInterpolatableWriterAdaptor<TFrom, TValue>((TFrom) m_parent.getIntervalWriter(), m_writeValueCallback, m_writeSamplesCallback);
			}
		}, false);
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

	public final void writeValue(List<JulianDate> dates, List<TValue> values, int startIndex, int length) {
		m_writeSamplesCallback.invoke(m_parent, dates, values, startIndex, length);
	}

	public final void writeInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm) {
		m_parent.writeInterpolationAlgorithm(interpolationAlgorithm);
	}

	public final void writeInterpolationDegree(int degree) {
		m_parent.writeInterpolationDegree(degree);
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

	public final void open(CesiumOutputStream output) {
		m_parent.open(output);
	}

	public final void close() {
		m_parent.close();
	}

	public final void dispose() {
		m_parent.close();
	}
}