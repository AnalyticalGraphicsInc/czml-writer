package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ReferenceCesiumWriter;
import cesiumlanguagewriter.UnitQuaternion;
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
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asUnitQuaternion;
	private Lazy<ReferenceCesiumWriter> m_reference = new Lazy<cesiumlanguagewriter.ReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.ReferenceCesiumWriter>() {
		public cesiumlanguagewriter.ReferenceCesiumWriter invoke() {
			return new ReferenceCesiumWriter(ReferencePropertyName);
		}
	}, false);

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
	 *  Gets the writer for the <code>reference</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>reference</code> property defines a reference property.
	

	 */
	public final ReferenceCesiumWriter getReferenceWriter() {
		return m_reference.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>reference</code> property.  The <code>reference</code> property defines a reference property.
	

	 */
	public final ReferenceCesiumWriter openReferenceProperty() {
		openIntervalIfNecessary();
		return this.<ReferenceCesiumWriter> openAndReturn(getReferenceWriter());
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	

	 * @param value The reference.
	 */
	public final void writeReferenceProperty(Reference value) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeReferenceProperty(String value) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeReferenceProperty(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeReferenceProperty(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
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
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.OrientationCesiumWriter, cesiumlanguagewriter.UnitQuaternion>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.OrientationCesiumWriter, cesiumlanguagewriter.UnitQuaternion>() {
					public void invoke(OrientationCesiumWriter me, UnitQuaternion value) {
						me.writeUnitQuaternion(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.OrientationCesiumWriter, cesiumlanguagewriter.UnitQuaternion>() {
					public void invoke(OrientationCesiumWriter me, List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
						me.writeUnitQuaternion(dates, values, startIndex, length);
					}
				});
	}
}