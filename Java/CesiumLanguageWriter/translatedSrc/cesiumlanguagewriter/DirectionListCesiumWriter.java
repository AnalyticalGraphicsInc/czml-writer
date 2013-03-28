package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>DirectionList</code> to a  {@link CesiumOutputStream}.  A <code>DirectionList</code> a list of directions.
 

 */
public class DirectionListCesiumWriter extends CesiumPropertyWriter<DirectionListCesiumWriter> {
	/**
	 *  
	The name of the <code>unitSpherical</code> property.
	

	 */
	public static final String UnitSphericalPropertyName = "unitSpherical";
	/**
	 *  
	The name of the <code>unitCartesian</code> property.
	

	 */
	public static final String UnitCartesianPropertyName = "unitCartesian";
	private Lazy<ICesiumValuePropertyWriter<Iterable<UnitSpherical>>> m_asUnitSpherical;
	private Lazy<ICesiumValuePropertyWriter<Iterable<UnitCartesian>>> m_asUnitCartesian;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public DirectionListCesiumWriter(String propertyName) {
		super(propertyName);
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>> invoke() {
						return createUnitSphericalAdaptor();
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
		m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>> invoke() {
						return createUnitSphericalAdaptor();
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