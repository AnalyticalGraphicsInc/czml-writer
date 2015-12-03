package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a <code>Double</code> to a  {@link CesiumOutputStream}.  A <code>Double</code> a floating-point number.
 

 */
public class DoubleCesiumWriter extends CesiumInterpolatablePropertyWriter<DoubleCesiumWriter> {
	/**
	 *  
	The name of the <code>number</code> property.
	

	 */
	public static final String NumberPropertyName = "number";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Double>> m_asNumber;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

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
		m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
				"createReferenceAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
				return createReferenceAdaptor();
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
		m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
				"createReferenceAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
				return createReferenceAdaptor();
			}
		}, false);
	}

	@Override
	public DoubleCesiumWriter clone() {
		return new DoubleCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point number.  The value may be a single number, or an array with one element, in which case the value is constant.  If it is an array with two or more elements, they are time-tagged samples arranged as `[Time, Value, Time, Value, ...]`, where Time is an ISO 8601 date and time string or seconds since epoch.
	
	

	 * @param value The value.
	 */
	public final void writeNumber(double value) {
		String PropertyName = NumberPropertyName;
		if (getForceInterval()) {
			openIntervalIfNecessary();
		}
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point number.  The value may be a single number, or an array with one element, in which case the value is constant.  If it is an array with two or more elements, they are time-tagged samples arranged as `[Time, Value, Time, Value, ...]`, where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the floating-point number specified as a reference to another property.
	
	

	 * @param value The reference.
	 */
	public final void writeReference(Reference value) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the floating-point number specified as a reference to another property.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeReference(String value) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the floating-point number specified as a reference to another property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeReference(String identifier, String propertyName) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the floating-point number specified as a reference to another property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeReference(String identifier, String[] propertyNames) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
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
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DoubleCesiumWriter, Double>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DoubleCesiumWriter, Double>() {
			public void invoke(DoubleCesiumWriter me, Double value) {
				me.writeNumber(value);
			}
		}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DoubleCesiumWriter, Double>() {
			public void invoke(DoubleCesiumWriter me, List<JulianDate> dates, List<Double> values, int startIndex, int length) {
				me.writeNumber(dates, values, startIndex, length);
			}
		});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Reference</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Reference> asReference() {
		return m_asReference.getValue();
	}

	final private ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.DoubleCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DoubleCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(DoubleCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}