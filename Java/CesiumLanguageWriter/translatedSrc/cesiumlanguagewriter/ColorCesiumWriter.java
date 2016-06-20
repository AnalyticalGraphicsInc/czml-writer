package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Color</code> to a  {@link CesiumOutputStream}.  A <code>Color</code> is a color.  The color can optionally vary over time.
 

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
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Color>> m_asRgbaf;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

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
		m_asRgbaf = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
				this, "createRgbafAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
				return createRgbafAdaptor();
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
	protected ColorCesiumWriter(ColorCesiumWriter existingInstance) {
		super(existingInstance);
		m_asRgba = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
				this, "createRgbaAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
				return createRgbaAdaptor();
			}
		}, false);
		m_asRgbaf = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
				this, "createRgbafAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
				return createRgbafAdaptor();
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
	public ColorCesiumWriter clone() {
		return new ColorCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>rgba</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is an integer in the range 0-255.
	
	

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
	Writes the value expressed as a <code>rgba</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is an integer in the range 0-255.
	
	
	
	
	

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
	Writes the value expressed as a <code>rgba</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is an integer in the range 0-255.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeRgba(List<JulianDate> dates, List<Color> values) {
		writeRgba(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>rgba</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is an integer in the range 0-255.
	
	
	
	
	

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
	Writes the value expressed as a <code>rgbaf</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is a double in the range 0.0-1.0.
	
	

	 * @param color The color.
	 */
	public final void writeRgbaf(Color color) {
		String PropertyName = RgbafPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeRgbaf(getOutput(), color);
	}

	/**
	 *  
	Writes the value expressed as a <code>rgbaf</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is a double in the range 0.0-1.0.
	
	
	
	
	

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
	 *  
	Writes the value expressed as a <code>rgbaf</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is a double in the range 0.0-1.0.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeRgbaf(List<JulianDate> dates, List<Color> values) {
		writeRgbaf(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the value expressed as a <code>rgbaf</code>, which is the color specified as an array of color components `[Red, Green, Blue, Alpha]` where each component is a double in the range 0.0-1.0.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		String PropertyName = RgbafPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeRgbaf(getOutput(), PropertyName, dates, colors, startIndex, length);
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
	
	
	

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

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Rgbaf</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Color> asRgbaf() {
		return m_asRgbaf.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Color> createRgbafAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.ColorCesiumWriter, Color>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ColorCesiumWriter, Color>() {
			public void invoke(ColorCesiumWriter me, Color value) {
				me.writeRgbaf(value);
			}
		}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.ColorCesiumWriter, Color>() {
			public void invoke(ColorCesiumWriter me, List<JulianDate> dates, List<Color> values, int startIndex, int length) {
				me.writeRgbaf(dates, values, startIndex, length);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.ColorCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ColorCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(ColorCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}