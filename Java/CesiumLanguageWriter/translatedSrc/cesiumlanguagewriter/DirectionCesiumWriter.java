package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.UnitCartesian;
import cesiumlanguagewriter.UnitSpherical;
import java.util.List;

/**
 *  
 Writes a <code>Direction</code> to a  {@link CesiumOutputStream}.  A <code>Direction</code> defines a direction.  The direction can optionally vary over time.
 

 */
public class DirectionCesiumWriter extends CesiumInterpolatablePropertyWriter<DirectionCesiumWriter> {
	/**
	 *  
	The name of the <code>axes</code> property.
	

	 */
	public static final String AxesPropertyName = "axes";
	/**
	 *  
	The name of the <code>unitCartesian</code> property.
	

	 */
	public static final String UnitCartesianPropertyName = "unitCartesian";
	/**
	 *  
	The name of the <code>unitSpherical</code> property.
	

	 */
	public static final String UnitSphericalPropertyName = "unitSpherical";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>> m_asUnitCartesian;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>> m_asUnitSpherical;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public DirectionCesiumWriter(String propertyName) {
		super(propertyName);
		m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
						return createUnitCartesianAdaptor();
					}
				}, false);
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
						return createUnitSphericalAdaptor();
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
		m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
						return createUnitCartesianAdaptor();
					}
				}, false);
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
						return createUnitSphericalAdaptor();
					}
				}, false);
	}

	@Override
	public DirectionCesiumWriter clone() {
		return new DirectionCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>axes</code> property.  The <code>axes</code> property specifies tODO
	
	

	 * @param value The value.
	 */
	public final void writeAxes(String value) {
		String PropertyName = AxesPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the <code>unitCartesian</code> property.  The <code>unitCartesian</code> property specifies the direction represented as a unit Cartesian `[X, Y, Z]`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	

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
	Writes the <code>unitCartesian</code> property.  The <code>unitCartesian</code> property specifies the direction represented as a unit Cartesian `[X, Y, Z]`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
		writeUnitCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>unitCartesian</code> property.  The <code>unitCartesian</code> property specifies the direction represented as a unit Cartesian `[X, Y, Z]`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
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
	Writes the <code>unitSpherical</code> property.  The <code>unitSpherical</code> property specifies a direction specified as a unit spherical [Clock, Cone] angles in radians. If the array has two elements, the direction is constant. If it has three or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Time, Clock, Cone, Time, Clock, Cone, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	

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
	Writes the <code>unitSpherical</code> property.  The <code>unitSpherical</code> property specifies a direction specified as a unit spherical [Clock, Cone] angles in radians. If the array has two elements, the direction is constant. If it has three or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Time, Clock, Cone, Time, Clock, Cone, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
		writeUnitSpherical(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>unitSpherical</code> property.  The <code>unitSpherical</code> property specifies a direction specified as a unit spherical [Clock, Cone] angles in radians. If the array has two elements, the direction is constant. If it has three or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Time, Clock, Cone, Time, Clock, Cone, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference.
	
	

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
}