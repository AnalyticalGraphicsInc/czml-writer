package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Cartesian;
import cesiumlanguagewriter.Spherical;
import java.util.List;

/**
 *  
 Writes a <code>Direction</code> to a  {@link CesiumOutputStream}.  A <code>Direction</code> defines a direction.  The direction can optionally vary over time.
 

 */
public class DirectionCesiumWriter extends CesiumInterpolatablePropertyWriter<DirectionCesiumWriter> {
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
	The name of the <code>spherical</code> property.
	

	 */
	public static final String SphericalPropertyName = "spherical";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>> m_asSpherical;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public DirectionCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(this, "createSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical> invoke() {
						return createSphericalAdaptor();
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
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(this, "createSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical> invoke() {
						return createSphericalAdaptor();
					}
				}, false);
	}

	@Override
	public DirectionCesiumWriter clone() {
		return new DirectionCesiumWriter(this);
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
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the direction represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	

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
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the direction represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the direction represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

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
	Writes the <code>spherical</code> property.  The <code>spherical</code> property specifies a direction specified as a spherical [Clock, Cone, Magnitude] angles in radians, magnitude in meters. If the array has three elements, the direction is constant. If it has four or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Magnitude, Time, Clock, Cone, Time, Clock, Cone, Magnitude, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	

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
	Writes the <code>spherical</code> property.  The <code>spherical</code> property specifies a direction specified as a spherical [Clock, Cone, Magnitude] angles in radians, magnitude in meters. If the array has three elements, the direction is constant. If it has four or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Magnitude, Time, Clock, Cone, Time, Clock, Cone, Magnitude, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeSpherical(List<JulianDate> dates, List<Spherical> values) {
		writeSpherical(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>spherical</code> property.  The <code>spherical</code> property specifies a direction specified as a spherical [Clock, Cone, Magnitude] angles in radians, magnitude in meters. If the array has three elements, the direction is constant. If it has four or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Magnitude, Time, Clock, Cone, Time, Clock, Cone, Magnitude, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
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
}