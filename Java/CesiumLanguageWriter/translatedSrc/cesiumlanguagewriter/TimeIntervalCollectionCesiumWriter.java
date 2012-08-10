package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;

/**
 *  
 Writes a <code>TimeIntervalCollection</code> to a  {@link CesiumOutputStream}.  A <code>TimeIntervalCollection</code> a collection of intervals of time.
 

 */
public class TimeIntervalCollectionCesiumWriter extends CesiumPropertyWriter<TimeIntervalCollectionCesiumWriter> {
	/**
	 *  
	The name of the <code>segmentInterval</code> property.
	

	 */
	public static final String SegmentIntervalPropertyName = "segmentInterval";
	/**
	 *  
	The name of the <code>segmentIntervals</code> property.
	

	 */
	public static final String SegmentIntervalsPropertyName = "segmentIntervals";
	private Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asSegmentInterval;
	private Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asSegmentIntervals;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public TimeIntervalCollectionCesiumWriter(String propertyName) {
		super(propertyName);
		m_asSegmentInterval = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createSegmentIntervalAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createSegmentIntervalAdaptor();
			}
		}, false);
		m_asSegmentIntervals = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createSegmentIntervalsAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createSegmentIntervalsAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected TimeIntervalCollectionCesiumWriter(TimeIntervalCollectionCesiumWriter existingInstance) {
		super(existingInstance);
		m_asSegmentInterval = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createSegmentIntervalAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createSegmentIntervalAdaptor();
			}
		}, false);
		m_asSegmentIntervals = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createSegmentIntervalsAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createSegmentIntervalsAdaptor();
			}
		}, false);
	}

	@Override
	public TimeIntervalCollectionCesiumWriter clone() {
		return new TimeIntervalCollectionCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>segmentInterval</code> property.  The <code>segmentInterval</code> property specifies the interval value.
	
	

	 * @param value The interval.
	 */
	public final void writeSegmentInterval(TimeInterval value) {
		String PropertyName = SegmentIntervalPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeInterval(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>segmentInterval</code> property.  The <code>segmentInterval</code> property specifies the interval value.
	
	
	

	 * @param start The earliest date of the interval.
	 * @param stop The latest date of the interval.
	 */
	public final void writeSegmentInterval(JulianDate start, JulianDate stop) {
		writeSegmentInterval(new TimeInterval(start, stop));
	}

	/**
	 *  
	Writes the <code>segmentIntervals</code> property.  The <code>segmentIntervals</code> property specifies the intervals value.
	
	

	 * @param value The interval.
	 */
	public final void writeSegmentIntervals(TimeInterval value) {
		String PropertyName = SegmentIntervalsPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeInterval(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>segmentIntervals</code> property.  The <code>segmentIntervals</code> property specifies the intervals value.
	
	
	

	 * @param start The earliest date of the interval.
	 * @param stop The latest date of the interval.
	 */
	public final void writeSegmentIntervals(JulianDate start, JulianDate stop) {
		writeSegmentIntervals(new TimeInterval(start, stop));
	}

	/**
	 *  
	Writes the <code>segmentIntervals</code> property.  The <code>segmentIntervals</code> property specifies the intervals value.
	
	

	 * @param value The intervals.
	 */
	public final void writeSegmentIntervals(List<TimeInterval> value) {
		String PropertyName = SegmentIntervalsPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeIntervalCollection(getOutput(), value);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>SegmentInterval</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<TimeInterval> asSegmentInterval() {
		return m_asSegmentInterval.getValue();
	}

	final private ICesiumValuePropertyWriter<TimeInterval> createSegmentIntervalAdaptor() {
		return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(this, new CesiumWriterAdaptorWriteCallback<TimeIntervalCollectionCesiumWriter, TimeInterval>() {
			public void invoke(TimeIntervalCollectionCesiumWriter me, TimeInterval value) {
				me.writeSegmentInterval(value);
			}
		});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>SegmentIntervals</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<TimeInterval> asSegmentIntervals() {
		return m_asSegmentIntervals.getValue();
	}

	final private ICesiumValuePropertyWriter<TimeInterval> createSegmentIntervalsAdaptor() {
		return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(this, new CesiumWriterAdaptorWriteCallback<TimeIntervalCollectionCesiumWriter, TimeInterval>() {
			public void invoke(TimeIntervalCollectionCesiumWriter me, TimeInterval value) {
				me.writeSegmentIntervals(value);
			}
		});
	}
}