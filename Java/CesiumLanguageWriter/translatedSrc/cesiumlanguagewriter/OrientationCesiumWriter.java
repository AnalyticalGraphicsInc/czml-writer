package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;

/**
 *  
 Writes a <code>Orientation</code> to a  {@link CesiumOutputStream}.  A <code>Orientation</code> defines an orientation.  An orientation is a rotation that takes a vector expressed in the "body" axes of the object and transforms it to the set of axes identified by the `axes` property.
 

 */
public class OrientationCesiumWriter extends CesiumInterpolatablePropertyWriter<OrientationCesiumWriter> {
	/**
	 *  
	The name of the <code>axes</code> property.
	

	 */
	public static final String AxesPropertyName = "axes";
	/**
	 *  
	The name of the <code>unitQuaternion</code> property.
	

	 */
	public static final String UnitQuaternionPropertyName = "unitQuaternion";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asUnitQuaternion;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public OrientationCesiumWriter(String propertyName) {
		super(propertyName);
		m_asUnitQuaternion = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(this, "createUnitQuaternionAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> invoke() {
						return createUnitQuaternionAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected OrientationCesiumWriter(OrientationCesiumWriter existingInstance) {
		super(existingInstance);
		m_asUnitQuaternion = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(this, "createUnitQuaternionAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> invoke() {
						return createUnitQuaternionAdaptor();
					}
				}, false);
	}

	@Override
	public OrientationCesiumWriter clone() {
		return new OrientationCesiumWriter(this);
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
	Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
	
	

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
	Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
	
	
	

	 * @param dates The dates at which the rotation is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values) {
		writeUnitQuaternion(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
	
	
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>UnitQuaternion</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> asUnitQuaternion() {
		return m_asUnitQuaternion.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> createUnitQuaternionAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<OrientationCesiumWriter, UnitQuaternion>(this, new CesiumWriterAdaptorWriteCallback<OrientationCesiumWriter, UnitQuaternion>() {
			public void invoke(OrientationCesiumWriter me, UnitQuaternion value) {
				me.writeUnitQuaternion(value);
			}
		}, new CesiumWriterAdaptorWriteSamplesCallback<OrientationCesiumWriter, UnitQuaternion>() {
			public void invoke(OrientationCesiumWriter me, List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
				me.writeUnitQuaternion(dates, values, startIndex, length);
			}
		});
	}
}