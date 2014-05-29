package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Rectangular;
import cesiumlanguagewriter.ReferenceCesiumWriter;
import java.util.List;

/**
 *  
 Writes a <code>PixelOffset</code> to a  {@link CesiumOutputStream}.  A <code>PixelOffset</code> defines a pixel offset in viewport coordinates.  A pixel offset is the number of pixels up and to the right to place an element relative to an origin.
 

 */
public class PixelOffsetCesiumWriter extends CesiumInterpolatablePropertyWriter<PixelOffsetCesiumWriter> {
	/**
	 *  
	The name of the <code>cartesian2</code> property.
	

	 */
	public static final String Cartesian2PropertyName = "cartesian2";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>> m_asCartesian2;
	private Lazy<ReferenceCesiumWriter> m_reference = new Lazy<cesiumlanguagewriter.ReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.ReferenceCesiumWriter>() {
		public cesiumlanguagewriter.ReferenceCesiumWriter invoke() {
			return new ReferenceCesiumWriter(ReferencePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PixelOffsetCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
						return createCartesian2Adaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected PixelOffsetCesiumWriter(PixelOffsetCesiumWriter existingInstance) {
		super(existingInstance);
		m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
						return createCartesian2Adaptor();
					}
				}, false);
	}

	@Override
	public PixelOffsetCesiumWriter clone() {
		return new PixelOffsetCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
	
	

	 * @param value The value.
	 */
	public final void writeCartesian2(Rectangular value) {
		String PropertyName = Cartesian2PropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian2(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param x The X component.
	 * @param y The Y component.
	 */
	public final void writeCartesian2(double x, double y) {
		writeCartesian2(new Rectangular(x, y));
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values) {
		writeCartesian2(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
		String PropertyName = Cartesian2PropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartesian2(getOutput(), PropertyName, dates, values, startIndex, length);
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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Cartesian2</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Rectangular> asCartesian2() {
		return m_asCartesian2.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Rectangular> createCartesian2Adaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PixelOffsetCesiumWriter, cesiumlanguagewriter.Rectangular>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PixelOffsetCesiumWriter, cesiumlanguagewriter.Rectangular>() {
					public void invoke(PixelOffsetCesiumWriter me, Rectangular value) {
						me.writeCartesian2(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PixelOffsetCesiumWriter, cesiumlanguagewriter.Rectangular>() {
					public void invoke(PixelOffsetCesiumWriter me, List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
						me.writeCartesian2(dates, values, startIndex, length);
					}
				});
	}
}