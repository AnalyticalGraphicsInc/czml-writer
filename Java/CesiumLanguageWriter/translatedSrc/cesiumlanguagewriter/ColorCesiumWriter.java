package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ReferenceCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Color</code> to a  {@link CesiumOutputStream}.  A <code>Color</code> defines a a color.  The color can optionally vary over time.
 

 */
public class ColorCesiumWriter extends CesiumInterpolatablePropertyWriter<ColorCesiumWriter> {
	/**
	 *  
	The name of the <code>rgba</code> property.
	

	 */
	public static final String RgbaPropertyName = "rgba";
	/**
	 *  
	The name of the <code>rgbaf</code> property.
	

	 */
	public static final String RgbafPropertyName = "rgbaf";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Color>> m_asRgba;
	private Lazy<ReferenceCesiumWriter> m_reference = new Lazy<cesiumlanguagewriter.ReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.ReferenceCesiumWriter>() {
		public cesiumlanguagewriter.ReferenceCesiumWriter invoke() {
			return new ReferenceCesiumWriter(ReferencePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ColorCesiumWriter(String propertyName) {
		super(propertyName);
		m_asRgba = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
				this, "createRgbaAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
				return createRgbaAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ColorCesiumWriter(ColorCesiumWriter existingInstance) {
		super(existingInstance);
		m_asRgba = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
				this, "createRgbaAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
				return createRgbaAdaptor();
			}
		}, false);
	}

	@Override
	public ColorCesiumWriter clone() {
		return new ColorCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>rgba</code> property.  The <code>rgba</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0-255. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	

	 * @param color The color.
	 */
	public final void writeRgba(Color color) {
		String PropertyName = RgbaPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeRgba(getOutput(), color);
	}

	/**
	 *  
	Writes the <code>rgba</code> property.  The <code>rgba</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0-255. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeRgba(int red, int green, int blue, int alpha) {
		String PropertyName = RgbaPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeRgba(getOutput(), red, green, blue, alpha);
	}

	/**
	 *  
	Writes the <code>rgba</code> property.  The <code>rgba</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0-255. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeRgba(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		String PropertyName = RgbaPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeRgba(getOutput(), PropertyName, dates, colors, startIndex, length);
	}

	/**
	 *  
	Writes the <code>rgbaf</code> property.  The <code>rgbaf</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0.0-1.0. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeRgbaf(float red, float green, float blue, float alpha) {
		String PropertyName = RgbafPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeRgbaf(getOutput(), red, green, blue, alpha);
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
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Rgba</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Color> asRgba() {
		return m_asRgba.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Color> createRgbaAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.ColorCesiumWriter, Color>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ColorCesiumWriter, Color>() {
			public void invoke(ColorCesiumWriter me, Color value) {
				me.writeRgba(value);
			}
		}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.ColorCesiumWriter, Color>() {
			public void invoke(ColorCesiumWriter me, List<JulianDate> dates, List<Color> values, int startIndex, int length) {
				me.writeRgba(dates, values, startIndex, length);
			}
		});
	}
}