package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Rectangular;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a <code>Repeat</code> to a  {@link CesiumOutputStream}.  A <code>Repeat</code> the number of times the image repeats along each axis.
 

 */
public class RepeatCesiumWriter extends CesiumInterpolatablePropertyWriter<RepeatCesiumWriter> {
	/**
	 *  
	The name of the <code>cartesian2</code> property.
	

	 */
	public static final String Cartesian2PropertyName = "cartesian2";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>> m_asCartesian2;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public RepeatCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
						return createCartesian2Adaptor();
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
	protected RepeatCesiumWriter(RepeatCesiumWriter existingInstance) {
		super(existingInstance);
		m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
						return createCartesian2Adaptor();
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
	public RepeatCesiumWriter clone() {
		return new RepeatCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the number of times the image repeats along each axis.
	
	

	 * @param value The value.
	 */
	public final void writeCartesian2(Rectangular value) {
		String PropertyName = Cartesian2PropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian2(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the number of times the image repeats along each axis.
	
	
	

	 * @param x The X component.
	 * @param y The Y component.
	 */
	public final void writeCartesian2(double x, double y) {
		writeCartesian2(new Rectangular(x, y));
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the number of times the image repeats along each axis.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values) {
		writeCartesian2(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the number of times the image repeats along each axis.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
		String PropertyName = Cartesian2PropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartesian2(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Cartesian2</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Rectangular> asCartesian2() {
		return m_asCartesian2.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Rectangular> createCartesian2Adaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.RepeatCesiumWriter, cesiumlanguagewriter.Rectangular>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.RepeatCesiumWriter, cesiumlanguagewriter.Rectangular>() {
					public void invoke(RepeatCesiumWriter me, Rectangular value) {
						me.writeCartesian2(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.RepeatCesiumWriter, cesiumlanguagewriter.Rectangular>() {
					public void invoke(RepeatCesiumWriter me, List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
						me.writeCartesian2(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.RepeatCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.RepeatCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(RepeatCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}