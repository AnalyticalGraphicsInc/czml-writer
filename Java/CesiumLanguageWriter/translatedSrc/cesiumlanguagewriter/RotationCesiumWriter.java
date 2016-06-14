package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;
import cesiumlanguagewriter.UnitQuaternion;
import java.util.List;

/**
 *  
 Writes a <code>Rotation</code> to a  {@link CesiumOutputStream}.  A <code>Rotation</code> is defines a rotation that transforms a vector expressed in one axes and transforms it to another.
 

 */
public class RotationCesiumWriter extends CesiumInterpolatablePropertyWriter<RotationCesiumWriter> {
	/**
	 *  
	The name of the <code>unitQuaternion</code> property.
	

	 */
	public static final String UnitQuaternionPropertyName = "unitQuaternion";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asUnitQuaternion;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public RotationCesiumWriter(String propertyName) {
		super(propertyName);
		m_asUnitQuaternion = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(this, "createUnitQuaternionAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> invoke() {
						return createUnitQuaternionAdaptor();
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
	protected RotationCesiumWriter(RotationCesiumWriter existingInstance) {
		super(existingInstance);
		m_asUnitQuaternion = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(this, "createUnitQuaternionAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> invoke() {
						return createUnitQuaternionAdaptor();
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
	public RotationCesiumWriter clone() {
		return new RotationCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>unitQuaternion</code>, which is the rotation specified as a 4-dimensional unit magnitude quaternion, specified as `[X, Y, Z, W]`.
	
	

	 * @param value The value.
	 */
	public final void writeUnitQuaternion(UnitQuaternion value) {
		String PropertyName = UnitQuaternionPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeUnitQuaternion(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>unitQuaternion</code>, which is the rotation specified as a 4-dimensional unit magnitude quaternion, specified as `[X, Y, Z, W]`.
	
	
	

	 * @param dates The dates at which the rotation is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values) {
		writeUnitQuaternion(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>unitQuaternion</code>, which is the rotation specified as a 4-dimensional unit magnitude quaternion, specified as `[X, Y, Z, W]`.
	
	
	
	
	

	 * @param dates The dates at which the rotation is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
		String PropertyName = UnitQuaternionPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeUnitQuaternion(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the rotation specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the rotation specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the rotation specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the rotation specified as a reference to another property.
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>UnitQuaternion</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> asUnitQuaternion() {
		return m_asUnitQuaternion.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> createUnitQuaternionAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.RotationCesiumWriter, cesiumlanguagewriter.UnitQuaternion>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.RotationCesiumWriter, cesiumlanguagewriter.UnitQuaternion>() {
					public void invoke(RotationCesiumWriter me, UnitQuaternion value) {
						me.writeUnitQuaternion(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.RotationCesiumWriter, cesiumlanguagewriter.UnitQuaternion>() {
					public void invoke(RotationCesiumWriter me, List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
						me.writeUnitQuaternion(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.RotationCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.RotationCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(RotationCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}