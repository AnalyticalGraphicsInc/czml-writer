package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Cartesian;
import java.util.List;

/**
 *  
 Writes a <code>DirectionList</code> to a  {@link CesiumOutputStream}.  A <code>DirectionList</code> a list of directions.
 

 */
public class DirectionListCesiumWriter extends CesiumPropertyWriter<DirectionListCesiumWriter> {
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
	private Lazy<ICesiumValuePropertyWriter<Iterable<Spherical>>> m_asSpherical;
	private Lazy<ICesiumValuePropertyWriter<Iterable<UnitSpherical>>> m_asUnitSpherical;
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
	private Lazy<ICesiumValuePropertyWriter<Iterable<UnitCartesian>>> m_asUnitCartesian;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public DirectionListCesiumWriter(String propertyName) {
		super(propertyName);
		m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(this, "createSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>> invoke() {
						return createSphericalAdaptor();
					}
				}, false);
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>> invoke() {
						return createUnitSphericalAdaptor();
					}
				}, false);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>> invoke() {
						return createUnitCartesianAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected DirectionListCesiumWriter(DirectionListCesiumWriter existingInstance) {
		super(existingInstance);
		m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(this, "createSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>> invoke() {
						return createSphericalAdaptor();
					}
				}, false);
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>> invoke() {
						return createUnitSphericalAdaptor();
					}
				}, false);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
		m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>> invoke() {
						return createUnitCartesianAdaptor();
					}
				}, false);
	}

	@Override
	public DirectionListCesiumWriter clone() {
		return new DirectionListCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>spherical</code> property.  The <code>spherical</code> property specifies the list of directions represented as a clock angle, a cone angle, both in radians, and magnitude in meters.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	

	 * @param values The values.
	 */
	public final void writeSpherical(Iterable<Spherical> values) {
		String PropertyName = SphericalPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeSphericalList(getOutput(), values);
	}

	/**
	 *  
	Writes the <code>unitSpherical</code> property.  The <code>unitSpherical</code> property specifies the list of directions represented as a clock angle and a cone angle, both in radians.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
	
	

	 * @param values The values.
	 */
	public final void writeUnitSpherical(Iterable<UnitSpherical> values) {
		String PropertyName = UnitSphericalPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeUnitSphericalList(getOutput(), values);
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the list of directions represented as Cartesian `[X, Y, Z, X, Y, Z, ...]`
	
	

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
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the list of directions represented as Cartesian `[X, Y, Z, X, Y, Z, ...]`
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the list of directions represented as Cartesian `[X, Y, Z, X, Y, Z, ...]`
	
	
	
	
	

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
	Writes the <code>unitCartesian</code> property.  The <code>unitCartesian</code> property specifies the list of directions represented as Cartesian `[X, Y, Z, X, Y, Z, ...]`.
	
	

	 * @param values The values.
	 */
	public final void writeUnitCartesian(Iterable<UnitCartesian> values) {
		String PropertyName = UnitCartesianPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeUnitCartesian3List(getOutput(), values);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Spherical</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Iterable<Spherical>> asSpherical() {
		return m_asSpherical.getValue();
	}

	final private ICesiumValuePropertyWriter<Iterable<Spherical>> createSphericalAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<Spherical>>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<Spherical>>() {
					public void invoke(DirectionListCesiumWriter me, Iterable<Spherical> value) {
						me.writeSpherical(value);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>UnitSpherical</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Iterable<UnitSpherical>> asUnitSpherical() {
		return m_asUnitSpherical.getValue();
	}

	final private ICesiumValuePropertyWriter<Iterable<UnitSpherical>> createUnitSphericalAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitSpherical>>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitSpherical>>() {
					public void invoke(DirectionListCesiumWriter me, Iterable<UnitSpherical> value) {
						me.writeUnitSpherical(value);
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
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, cesiumlanguagewriter.Cartesian>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(DirectionListCesiumWriter me, Cartesian value) {
						me.writeCartesian(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DirectionListCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(DirectionListCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
						me.writeCartesian(dates, values, startIndex, length);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>UnitCartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Iterable<UnitCartesian>> asUnitCartesian() {
		return m_asUnitCartesian.getValue();
	}

	final private ICesiumValuePropertyWriter<Iterable<UnitCartesian>> createUnitCartesianAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitCartesian>>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitCartesian>>() {
					public void invoke(DirectionListCesiumWriter me, Iterable<UnitCartesian> value) {
						me.writeUnitCartesian(value);
					}
				});
	}
}