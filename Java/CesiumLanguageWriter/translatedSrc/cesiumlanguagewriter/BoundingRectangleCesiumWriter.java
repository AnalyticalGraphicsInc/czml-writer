package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BoundingRectangle;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a <code>BoundingRectangle</code> to a  {@link CesiumOutputStream}.  A <code>BoundingRectangle</code> is a bounding rectangle specified by a corner, width and height.
 

 */
public class BoundingRectangleCesiumWriter extends CesiumInterpolatablePropertyWriter<BoundingRectangleCesiumWriter> {
	/**
	 *  
	The name of the <code>cartesian</code> property.
	

	 */
	public static final String CartesianPropertyName = "cartesian";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>> m_asCartesian;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public BoundingRectangleCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> invoke() {
						return createCartesianAdaptor();
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
	protected BoundingRectangleCesiumWriter(BoundingRectangleCesiumWriter existingInstance) {
		super(existingInstance);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> invoke() {
						return createCartesianAdaptor();
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
	public BoundingRectangleCesiumWriter clone() {
		return new BoundingRectangleCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesian</code>, which is the bounding rectangle specified as `[X, Y, Width, Height]`.
	
	

	 * @param value The value.
	 */
	public final void writeCartesian(BoundingRectangle value) {
		String PropertyName = CartesianPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeBoundingRectangle(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesian</code>, which is the bounding rectangle specified as `[X, Y, Width, Height]`.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<BoundingRectangle> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>cartesian</code>, which is the bounding rectangle specified as `[X, Y, Width, Height]`.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
		String PropertyName = CartesianPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeBoundingRectangle(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
	
	
	

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
	public final ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> asCartesian() {
		return m_asCartesian.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> createCartesianAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.BoundingRectangle>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.BoundingRectangle>() {
					public void invoke(BoundingRectangleCesiumWriter me, BoundingRectangle value) {
						me.writeCartesian(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.BoundingRectangle>() {
					public void invoke(BoundingRectangleCesiumWriter me, List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
						me.writeCartesian(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(BoundingRectangleCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}