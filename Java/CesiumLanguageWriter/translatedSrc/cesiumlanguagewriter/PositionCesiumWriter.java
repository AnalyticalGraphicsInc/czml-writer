package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Cartesian;
import cesiumlanguagewriter.Cartographic;
import cesiumlanguagewriter.Motion1;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a <code>Position</code> to a  {@link CesiumOutputStream}.  A <code>Position</code> is defines a position.  The position can optionally vary over time.
 

 */
public class PositionCesiumWriter extends CesiumInterpolatablePropertyWriter<PositionCesiumWriter> {
	/**
	 *  
	The name of the <code>referenceFrame</code> property.
	

	 */
	public static final String ReferenceFramePropertyName = "referenceFrame";
	/**
	 *  
	The name of the <code>cartesian</code> property.
	

	 */
	public static final String CartesianPropertyName = "cartesian";
	/**
	 *  
	The name of the <code>cartographicRadians</code> property.
	

	 */
	public static final String CartographicRadiansPropertyName = "cartographicRadians";
	/**
	 *  
	The name of the <code>cartographicDegrees</code> property.
	

	 */
	public static final String CartographicDegreesPropertyName = "cartographicDegrees";
	/**
	 *  
	The name of the <code>cartesianVelocity</code> property.
	

	 */
	public static final String CartesianVelocityPropertyName = "cartesianVelocity";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicRadians;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicDegrees;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>> m_asCartesianVelocity;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PositionCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicRadiansAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
						return createCartographicRadiansAdaptor();
					}
				}, false);
		m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicDegreesAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
						return createCartographicDegreesAdaptor();
					}
				}, false);
		m_asCartesianVelocity = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(this, "createCartesianVelocityAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> invoke() {
						return createCartesianVelocityAdaptor();
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
	protected PositionCesiumWriter(PositionCesiumWriter existingInstance) {
		super(existingInstance);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicRadiansAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
						return createCartographicRadiansAdaptor();
					}
				}, false);
		m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicDegreesAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
						return createCartographicDegreesAdaptor();
					}
				}, false);
		m_asCartesianVelocity = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(this, "createCartesianVelocityAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> invoke() {
						return createCartesianVelocityAdaptor();
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
	public PositionCesiumWriter clone() {
		return new PositionCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>referenceFrame</code>, which is the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL".  If not specified, the default value is FIXED.
	
	

	 * @param value The value.
	 */
	public final void writeReferenceFrame(String value) {
		String PropertyName = ReferenceFramePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesian</code>, which is the position specified as a three-dimensional Cartesian value, `[X, Y, Z]`, in meters relative to the `referenceFrame`.
	
	

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
	Writes the value expressed as a <code>cartesian</code>, which is the position specified as a three-dimensional Cartesian value, `[X, Y, Z]`, in meters relative to the `referenceFrame`.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesian</code>, which is the position specified as a three-dimensional Cartesian value, `[X, Y, Z]`, in meters relative to the `referenceFrame`.
	
	
	
	
	

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
	Writes the value expressed as a <code>cartographicRadians</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in radians and Height is in meters.
	
	

	 * @param value The interval.
	 */
	public final void writeCartographicRadians(Cartographic value) {
		String PropertyName = CartographicRadiansPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartographic(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartographicRadians</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in radians and Height is in meters.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
		writeCartographicRadians(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>cartographicRadians</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in radians and Height is in meters.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The position corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
		String PropertyName = CartographicRadiansPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartographicDegrees</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in degrees and Height is in meters.
	
	

	 * @param value The interval.
	 */
	public final void writeCartographicDegrees(Cartographic value) {
		String PropertyName = CartographicDegreesPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartographic(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartographicDegrees</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in degrees and Height is in meters.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
		writeCartographicDegrees(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>cartographicDegrees</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in degrees and Height is in meters.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The position corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
		String PropertyName = CartographicDegreesPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesianVelocity</code>, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, `[X, Y, Z, dX, dY, dZ]`, in meters relative to the `referenceFrame`.
	
	

	 * @param value The value.
	 */
	public final void writeCartesianVelocity(Motion1<Cartesian> value) {
		String PropertyName = CartesianVelocityPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian3Velocity(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesianVelocity</code>, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, `[X, Y, Z, dX, dY, dZ]`, in meters relative to the `referenceFrame`.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values) {
		writeCartesianVelocity(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesianVelocity</code>, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, `[X, Y, Z, dX, dY, dZ]`, in meters relative to the `referenceFrame`.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values, int startIndex, int length) {
		String PropertyName = CartesianVelocityPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartesian3Velocity(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
	
	
	

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
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartesian>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(PositionCesiumWriter me, Cartesian value) {
						me.writeCartesian(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
						me.writeCartesian(dates, values, startIndex, length);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>CartographicRadians</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Cartographic> asCartographicRadians() {
		return m_asCartographicRadians.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Cartographic> createCartographicRadiansAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
					public void invoke(PositionCesiumWriter me, Cartographic value) {
						me.writeCartographicRadians(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
					public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
						me.writeCartographicRadians(dates, values, startIndex, length);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>CartographicDegrees</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Cartographic> asCartographicDegrees() {
		return m_asCartographicDegrees.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Cartographic> createCartographicDegreesAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
					public void invoke(PositionCesiumWriter me, Cartographic value) {
						me.writeCartographicDegrees(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
					public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
						me.writeCartographicDegrees(dates, values, startIndex, length);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>CartesianVelocity</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> asCartesianVelocity() {
		return m_asCartesianVelocity.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> createCartesianVelocityAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Motion1<Cartesian>>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Motion1<Cartesian>>() {
					public void invoke(PositionCesiumWriter me, Motion1<Cartesian> value) {
						me.writeCartesianVelocity(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Motion1<Cartesian>>() {
					public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Motion1<Cartesian>> values, int startIndex, int length) {
						me.writeCartesianVelocity(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(PositionCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}