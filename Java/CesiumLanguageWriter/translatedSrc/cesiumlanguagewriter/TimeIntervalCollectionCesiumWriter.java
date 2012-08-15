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
	The name of the <code>value</code> property.
	

	 */
	public static final String ValuePropertyName = "value";
	/**
	 *  
	The name of the <code>values</code> property.
	

	 */
	public static final String ValuesPropertyName = "values";
	private Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asValue;
	private Lazy<ICesiumValuePropertyWriter<TimeInterval>> m_asValues;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public TimeIntervalCollectionCesiumWriter(String propertyName) {
		super(propertyName);
		m_asValue = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createValueAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createValueAdaptor();
			}
		}, false);
		m_asValues = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createValuesAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createValuesAdaptor();
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
		m_asValue = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createValueAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createValueAdaptor();
			}
		}, false);
		m_asValues = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval>>(this,
				"createValuesAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<TimeInterval> invoke() {
				return createValuesAdaptor();
			}
		}, false);
	}

	@Override
	public TimeIntervalCollectionCesiumWriter clone() {
		return new TimeIntervalCollectionCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>value</code> property.  The <code>value</code> property specifies a single time interval.
	
	

	 * @param value The interval.
	 */
	public final void writeValue(TimeInterval value) {
		String PropertyName = ValuePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeInterval(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>value</code> property.  The <code>value</code> property specifies a single time interval.
	
	
	

	 * @param start The earliest date of the interval.
	 * @param stop The latest date of the interval.
	 */
	public final void writeValue(JulianDate start, JulianDate stop) {
		writeValue(new TimeInterval(start, stop));
	}

	/**
	 *  
	Writes the <code>values</code> property.  The <code>values</code> property specifies an array of time intervals.
	
	

	 * @param value The interval.
	 */
	public final void writeValues(TimeInterval value) {
		String PropertyName = ValuesPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeInterval(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>values</code> property.  The <code>values</code> property specifies an array of time intervals.
	
	
	

	 * @param start The earliest date of the interval.
	 * @param stop The latest date of the interval.
	 */
	public final void writeValues(JulianDate start, JulianDate stop) {
		writeValues(new TimeInterval(start, stop));
	}

	/**
	 *  
	Writes the <code>values</code> property.  The <code>values</code> property specifies an array of time intervals.
	
	

	 * @param value The intervals.
	 */
	public final void writeValues(List<TimeInterval> value) {
		String PropertyName = ValuesPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeIntervalCollection(getOutput(), value);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Value</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<TimeInterval> asValue() {
		return m_asValue.getValue();
	}

	final private ICesiumValuePropertyWriter<TimeInterval> createValueAdaptor() {
		return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(this, new CesiumWriterAdaptorWriteCallback<TimeIntervalCollectionCesiumWriter, TimeInterval>() {
			public void invoke(TimeIntervalCollectionCesiumWriter me, TimeInterval value) {
				me.writeValue(value);
			}
		});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Values</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<TimeInterval> asValues() {
		return m_asValues.getValue();
	}

	final private ICesiumValuePropertyWriter<TimeInterval> createValuesAdaptor() {
		return new CesiumWriterAdaptor<TimeIntervalCollectionCesiumWriter, TimeInterval>(this, new CesiumWriterAdaptorWriteCallback<TimeIntervalCollectionCesiumWriter, TimeInterval>() {
			public void invoke(TimeIntervalCollectionCesiumWriter me, TimeInterval value) {
				me.writeValues(value);
			}
		});
	}
}