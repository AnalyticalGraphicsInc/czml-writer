package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.IDisposable;
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

	public final void writeValue(List<JulianDate> dates, List<TValue> values, int startIndex, int length) {
		m_writeSamplesCallback.invoke(m_parent, dates, values, startIndex, length);
	}

	public final void writeInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm) {
		m_parent.writeInterpolationAlgorithm(interpolationAlgorithm);
	}

	public final void writeInterpolationDegree(int degree) {
		m_parent.writeInterpolationDegree(degree);
	}

	public final void writeForwardExtrapolationType(CesiumExtrapolationType extrapolationType) {
		m_parent.writeForwardExtrapolationType(extrapolationType);
	}

	public final void writeForwardExtrapolationDuration(Duration duration) {
		m_parent.writeForwardExtrapolationDuration(duration);
	}

	public final void writeBackwardExtrapolationType(CesiumExtrapolationType extrapolationType) {
		m_parent.writeBackwardExtrapolationType(extrapolationType);
	}

	public final void writeBackwardExtrapolationDuration(Duration duration) {
		m_parent.writeBackwardExtrapolationDuration(duration);
	}

	public final void writeInterval(JulianDate start, JulianDate stop) {
		m_parent.writeInterval(start, stop);
	}

	public final ICesiumInterpolatableValuePropertyWriter<TValue> openInterval() {
		m_interval.getValue().open(m_parent.getOutput());
		return m_interval.getValue();
	}

	public final ICesiumInterpolatableIntervalListWriter<TValue> openMultipleIntervals() {
		return new MultipleIntervalsAdaptor<TFrom, TValue>(this, m_parent.openMultipleIntervals());
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

	public final void dispose() {
		m_parent.close();
	}

	static private class MultipleIntervalsAdaptor<TFrom extends ICesiumPropertyWriter & ICesiumInterpolationInformationWriter, TValue> implements ICesiumInterpolatableIntervalListWriter<TValue> {
		private CesiumInterpolatableWriterAdaptor<TFrom, TValue> m_intervalAdaptor;
		private ICesiumIntervalListWriter m_parent;

		public MultipleIntervalsAdaptor(CesiumInterpolatableWriterAdaptor<TFrom, TValue> intervalAdaptor, ICesiumIntervalListWriter parent) {
			m_intervalAdaptor = intervalAdaptor;
			m_parent = parent;
		}

		public final ICesiumInterpolatableValuePropertyWriter<TValue> openInterval() {
			return m_intervalAdaptor.openInterval();
		}

		public final ICesiumInterpolatableValuePropertyWriter<TValue> openInterval(JulianDate start, JulianDate stop) {
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

		public final void dispose() {
			m_parent.dispose();
		}
	}
}