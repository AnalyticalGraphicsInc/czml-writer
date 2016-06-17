package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CartographicExtent;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a <code>RectangleCoordinates</code> to a  {@link CesiumOutputStream}.  A <code>RectangleCoordinates</code> is a set of coordinates describing a cartographic rectangle on the surface of the ellipsoid.
 

 */
public class RectangleCoordinatesCesiumWriter extends CesiumInterpolatablePropertyWriter<RectangleCoordinatesCesiumWriter> {
	/**
	 *  
	The name of the <code>wsenDegrees</code> property.
	

	 */
	public static final String WsenDegreesPropertyName = "wsenDegrees";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>> m_asWsenDegrees;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public RectangleCoordinatesCesiumWriter(String propertyName) {
		super(propertyName);
		m_asWsenDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(this, "createWsenDegreesAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent> invoke() {
						return createWsenDegreesAdaptor();
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
	protected RectangleCoordinatesCesiumWriter(RectangleCoordinatesCesiumWriter existingInstance) {
		super(existingInstance);
		m_asWsenDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(this, "createWsenDegreesAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent> invoke() {
						return createWsenDegreesAdaptor();
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
	public RectangleCoordinatesCesiumWriter clone() {
		return new RectangleCoordinatesCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
	
	

	 * @param value The value.
	 */
	public final void writeWsenDegrees(CartographicExtent value) {
		String PropertyName = WsenDegreesPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartographicExtent(getOutput(), value);
	}

	/**
	 *  
	Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
	
	
	
	
	

	 * @param west The westernmost longitude.
	 * @param south The southernmost latitude.
	 * @param east The easternmost longitude.
	 * @param north The northernmost latitude.
	 */
	public final void writeWsenDegrees(double west, double south, double east, double north) {
		writeWsenDegrees(new CartographicExtent(west, south, east, north));
	}

	/**
	 *  
	Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values) {
		writeWsenDegrees(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
		String PropertyName = WsenDegreesPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartographicExtent(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>WsenDegrees</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<CartographicExtent> asWsenDegrees() {
		return m_asWsenDegrees.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<CartographicExtent> createWsenDegreesAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.RectangleCoordinatesCesiumWriter, cesiumlanguagewriter.CartographicExtent>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.RectangleCoordinatesCesiumWriter, cesiumlanguagewriter.CartographicExtent>() {
					public void invoke(RectangleCoordinatesCesiumWriter me, CartographicExtent value) {
						me.writeWsenDegrees(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.RectangleCoordinatesCesiumWriter, cesiumlanguagewriter.CartographicExtent>() {
					public void invoke(RectangleCoordinatesCesiumWriter me, List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
						me.writeWsenDegrees(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.RectangleCoordinatesCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.RectangleCoordinatesCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(RectangleCoordinatesCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}