package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Cartesian;
import cesiumlanguagewriter.Reference;
import cesiumlanguagewriter.Spherical;
import cesiumlanguagewriter.UnitCartesian;
import cesiumlanguagewriter.UnitSpherical;
import java.util.List;

/**
 *  
 Writes a <code>Direction</code> to a  {@link CesiumOutputStream}.  A <code>Direction</code> is a unit vector, in world coordinates, that defines a direction.
 

 */
public class DirectionCesiumWriter extends CesiumInterpolatablePropertyWriter<DirectionCesiumWriter> {
	/**
	 *  
	The name of the <code>spherical</code> property.
	

	 */
	public static final String SphericalPropertyName = "spherical";
	/**
	 *  
	The name of the <code>unitSpherical</code> property.
	

	 */
	public static final String UnitSphericalPropertyName = "unitSpherical";
	/**
	 *  
	The name of the <code>cartesian</code> property.
	

	 */
	public static final String CartesianPropertyName = "cartesian";
	/**
	 *  
	The name of the <code>unitCartesian</code> property.
	

	 */
	public static final String UnitCartesianPropertyName = "unitCartesian";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>> m_asSpherical;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>> m_asUnitSpherical;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>> m_asUnitCartesian;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public DirectionCesiumWriter(String propertyName) {
		super(propertyName);
		m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(this, "createSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical> invoke() {
						return createSphericalAdaptor();
					}
				}, false);
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
						return createUnitSphericalAdaptor();
					}
				}, false);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
						return createUnitCartesianAdaptor();
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
	protected DirectionCesiumWriter(DirectionCesiumWriter existingInstance) {
		super(existingInstance);
		m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(this, "createSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical> invoke() {
						return createSphericalAdaptor();
					}
				}, false);
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
						return createUnitSphericalAdaptor();
					}
				}, false);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
						return createUnitCartesianAdaptor();
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
	public DirectionCesiumWriter clone() {
		return new DirectionCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>spherical</code>, which is the direction specified as a spherical value `[Clock, Cone, Magnitude]`, with angles in radians and magnitude in meters.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	

	 * @param value The value.
	 */
	public final void writeSpherical(Spherical value) {
		String PropertyName = SphericalPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeSpherical(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>spherical</code>, which is the direction specified as a spherical value `[Clock, Cone, Magnitude]`, with angles in radians and magnitude in meters.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeSpherical(List<JulianDate> dates, List<Spherical> values) {
		writeSpherical(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>spherical</code>, which is the direction specified as a spherical value `[Clock, Cone, Magnitude]`, with angles in radians and magnitude in meters.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeSpherical(List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
		String PropertyName = SphericalPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>unitSpherical</code>, which is the direction specified as a unit spherical value `[Clock, Cone]`, in radians.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	

	 * @param value The value.
	 */
	public final void writeUnitSpherical(UnitSpherical value) {
		String PropertyName = UnitSphericalPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeUnitSpherical(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>unitSpherical</code>, which is the direction specified as a unit spherical value `[Clock, Cone]`, in radians.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
		writeUnitSpherical(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>unitSpherical</code>, which is the direction specified as a unit spherical value `[Clock, Cone]`, in radians.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
		String PropertyName = UnitSphericalPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeUnitSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesian</code>, which is the direction specified as a three-dimensional Cartesian value `[X, Y, Z]`, in world coordinates in meters.
	
	

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
	Writes the value expressed as a <code>cartesian</code>, which is the direction specified as a three-dimensional Cartesian value `[X, Y, Z]`, in world coordinates in meters.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesian</code>, which is the direction specified as a three-dimensional Cartesian value `[X, Y, Z]`, in world coordinates in meters.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
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
	Writes the value expressed as a <code>unitCartesian</code>, which is the direction specified as a three-dimensional unit magnitude Cartesian value `[X, Y, Z]`, in world coordinates in meters.
	
	

	 * @param value The value.
	 */
	public final void writeUnitCartesian(UnitCartesian value) {
		String PropertyName = UnitCartesianPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeUnitCartesian3(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>unitCartesian</code>, which is the direction specified as a three-dimensional unit magnitude Cartesian value `[X, Y, Z]`, in world coordinates in meters.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
		writeUnitCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>unitCartesian</code>, which is the direction specified as a three-dimensional unit magnitude Cartesian value `[X, Y, Z]`, in world coordinates in meters.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
		String PropertyName = UnitCartesianPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeUnitCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the direction specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the direction specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the direction specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the direction specified as a reference to another property.
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Spherical</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Spherical> asSpherical() {
		return m_asSpherical.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Spherical> createSphericalAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Spherical>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Spherical>() {
					public void invoke(DirectionCesiumWriter me, Spherical value) {
						me.writeSpherical(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Spherical>() {
					public void invoke(DirectionCesiumWriter me, List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
						me.writeSpherical(dates, values, startIndex, length);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>UnitSpherical</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<UnitSpherical> asUnitSpherical() {
		return m_asUnitSpherical.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<UnitSpherical> createUnitSphericalAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.UnitSpherical>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.UnitSpherical>() {
					public void invoke(DirectionCesiumWriter me, UnitSpherical value) {
						me.writeUnitSpherical(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.UnitSpherical>() {
					public void invoke(DirectionCesiumWriter me, List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
						me.writeUnitSpherical(dates, values, startIndex, length);
					}
				});
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
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Cartesian>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(DirectionCesiumWriter me, Cartesian value) {
						me.writeCartesian(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(DirectionCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
						me.writeCartesian(dates, values, startIndex, length);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>UnitCartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<UnitCartesian> asUnitCartesian() {
		return m_asUnitCartesian.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<UnitCartesian> createUnitCartesianAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.UnitCartesian>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.UnitCartesian>() {
					public void invoke(DirectionCesiumWriter me, UnitCartesian value) {
						me.writeUnitCartesian(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.UnitCartesian>() {
					public void invoke(DirectionCesiumWriter me, List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
						me.writeUnitCartesian(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(DirectionCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}