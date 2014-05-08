package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Cartesian;
import cesiumlanguagewriter.Cartographic;
import cesiumlanguagewriter.Motion1;
import java.util.List;

/**
 *  
 Writes a <code>Position</code> to a  {@link CesiumOutputStream}.  A <code>Position</code> defines a position.  The position can optionally vary over time.
 

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
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicRadians;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicDegrees;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>> m_asCartesianVelocity;

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
	}

	@Override
	public PositionCesiumWriter clone() {
		return new PositionCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>referenceFrame</code> property.  The <code>referenceFrame</code> property specifies the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL". In addition, the value of this property can be a hash (#) symbol followed by the ID of another object in the same scope whose "position" and "orientation" properties define the reference frame in which this position is defined.  This property is ignored when specifying position with any type other than cartesian. If this property is not specified, the default reference frame is "FIXED".
	
	

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
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the position represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	

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
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the position represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the position represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

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
	Writes the <code>cartographicRadians</code> property.  The <code>cartographicRadians</code> property specifies the position represented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in radians and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	

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
	Writes the <code>cartographicRadians</code> property.  The <code>cartographicRadians</code> property specifies the position represented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in radians and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the position is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
		writeCartographicRadians(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartographicRadians</code> property.  The <code>cartographicRadians</code> property specifies the position represented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in radians and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
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
	Writes the <code>cartographicDegrees</code> property.  The <code>cartographicDegrees</code> property specifies the position reprsented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in degrees and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	

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
	Writes the <code>cartographicDegrees</code> property.  The <code>cartographicDegrees</code> property specifies the position reprsented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in degrees and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the position is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
		writeCartographicDegrees(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartographicDegrees</code> property.  The <code>cartographicDegrees</code> property specifies the position reprsented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in degrees and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
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
	Writes the <code>cartesianVelocity</code> property.  The <code>cartesianVelocity</code> property specifies the position and velocity represented as two Cartesians `[X, Y, Z, vX, vY, vZ]` in the meters relative to the `referenceFrame`. If the array has six elements, the position is constant. If it has seven or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, vX, vY, vZ, Time, X, Y, Z, vX, vY, vZ, Time, X, Y, Z, vX, vY, vZ, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	

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
	Writes the <code>cartesianVelocity</code> property.  The <code>cartesianVelocity</code> property specifies the position and velocity represented as two Cartesians `[X, Y, Z, vX, vY, vZ]` in the meters relative to the `referenceFrame`. If the array has six elements, the position is constant. If it has seven or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, vX, vY, vZ, Time, X, Y, Z, vX, vY, vZ, Time, X, Y, Z, vX, vY, vZ, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values) {
		writeCartesianVelocity(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesianVelocity</code> property.  The <code>cartesianVelocity</code> property specifies the position and velocity represented as two Cartesians `[X, Y, Z, vX, vY, vZ]` in the meters relative to the `referenceFrame`. If the array has six elements, the position is constant. If it has seven or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, vX, vY, vZ, Time, X, Y, Z, vX, vY, vZ, Time, X, Y, Z, vX, vY, vZ, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
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
}