package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Cartesian;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a <code>Translation</code> to a  {@link CesiumOutputStream}.  A <code>Translation</code> defines a translational offset which can optionally vary over time.
 

 */
public class TranslationCesiumWriter extends CesiumInterpolatablePropertyWriter<TranslationCesiumWriter> {
	/**
	 *  
	The name of the <code>cartesian</code> property.
	

	 */
	public static final String CartesianPropertyName = "cartesian";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public TranslationCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
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
	protected TranslationCesiumWriter(TranslationCesiumWriter existingInstance) {
		super(existingInstance);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
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
	public TranslationCesiumWriter clone() {
		return new TranslationCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the translation specified as a Cartesian `[X, Y, Z]` position in meters.  If the array has three elements, the value is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since epoch.
	
	

	 * @param value The value.
	 */
	public final void writeCartesian(Cartesian value) {
		String PropertyName = CartesianPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian3(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the translation specified as a Cartesian `[X, Y, Z]` position in meters.  If the array has three elements, the value is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the translation specified as a Cartesian `[X, Y, Z]` position in meters.  If the array has three elements, the value is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		String PropertyName = CartesianPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Cartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Cartesian> asCartesian() {
		return m_asCartesian.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Cartesian> createCartesianAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.TranslationCesiumWriter, cesiumlanguagewriter.Cartesian>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.TranslationCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(TranslationCesiumWriter me, Cartesian value) {
						me.writeCartesian(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.TranslationCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(TranslationCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
						me.writeCartesian(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.TranslationCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.TranslationCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(TranslationCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}