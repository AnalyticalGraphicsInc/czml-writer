package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;

/**
 *  
 Writes a <code>Double</code> to a  {@link CesiumOutputStream}.  A <code>Double</code> a floating-point value.
 

 */
public class DoubleCesiumWriter extends CesiumInterpolatablePropertyWriter<DoubleCesiumWriter> {
	/**
	 *  
	The name of the <code>number</code> property.
	

	 */
	public static final String NumberPropertyName = "number";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Double>> m_asNumber;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public DoubleCesiumWriter(String propertyName) {
		super(propertyName);
		m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(this, "createNumberAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double> invoke() {
						return createNumberAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected DoubleCesiumWriter(DoubleCesiumWriter existingInstance) {
		super(existingInstance);
		m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(this, "createNumberAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double> invoke() {
						return createNumberAdaptor();
					}
				}, false);
	}

	@Override
	public DoubleCesiumWriter clone() {
		return new DoubleCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point value. The value may be a single number, in which case the value is constant over the interval, or it may be an array.  If it is an array and the array has one element, the value is constant over the interval. If it has two or more elements, they are time-tagged samples arranged as [Time, Value, Time, Value, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	

	 * @param value The value.
	 */
	public final void writeNumber(double value) {
		String PropertyName = NumberPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point value. The value may be a single number, in which case the value is constant over the interval, or it may be an array.  If it is an array and the array has one element, the value is constant over the interval. If it has two or more elements, they are time-tagged samples arranged as [Time, Value, Time, Value, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeNumber(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		String PropertyName = NumberPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeDouble(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Number</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Double> asNumber() {
		return m_asNumber.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Double> createNumberAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<DoubleCesiumWriter, Double>(this, new CesiumWriterAdaptorWriteCallback<DoubleCesiumWriter, Double>() {
			public void invoke(DoubleCesiumWriter me, Double value) {
				me.writeNumber(value);
			}
		}, new CesiumWriterAdaptorWriteSamplesCallback<DoubleCesiumWriter, Double>() {
			public void invoke(DoubleCesiumWriter me, List<JulianDate> dates, List<Double> values, int startIndex, int length) {
				me.writeNumber(dates, values, startIndex, length);
			}
		});
	}
}