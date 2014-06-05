package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.EyeOffsetCesiumWriter;
import cesiumlanguagewriter.FontCesiumWriter;
import cesiumlanguagewriter.HorizontalOriginCesiumWriter;
import cesiumlanguagewriter.LabelStyleCesiumWriter;
import cesiumlanguagewriter.PixelOffsetCesiumWriter;
import cesiumlanguagewriter.StringCesiumWriter;
import cesiumlanguagewriter.VerticalOriginCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Label</code> to a  {@link CesiumOutputStream}.  A <code>Label</code> a string of text.
 

 */
public class LabelCesiumWriter extends CesiumPropertyWriter<LabelCesiumWriter> {
	/**
	 *  
	The name of the <code>eyeOffset</code> property.
	

	 */
	public static final String EyeOffsetPropertyName = "eyeOffset";
	/**
	 *  
	The name of the <code>fillColor</code> property.
	

	 */
	public static final String FillColorPropertyName = "fillColor";
	/**
	 *  
	The name of the <code>font</code> property.
	

	 */
	public static final String FontPropertyName = "font";
	/**
	 *  
	The name of the <code>horizontalOrigin</code> property.
	

	 */
	public static final String HorizontalOriginPropertyName = "horizontalOrigin";
	/**
	 *  
	The name of the <code>outlineColor</code> property.
	

	 */
	public static final String OutlineColorPropertyName = "outlineColor";
	/**
	 *  
	The name of the <code>outlineWidth</code> property.
	

	 */
	public static final String OutlineWidthPropertyName = "outlineWidth";
	/**
	 *  
	The name of the <code>pixelOffset</code> property.
	

	 */
	public static final String PixelOffsetPropertyName = "pixelOffset";
	/**
	 *  
	The name of the <code>scale</code> property.
	

	 */
	public static final String ScalePropertyName = "scale";
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>style</code> property.
	

	 */
	public static final String StylePropertyName = "style";
	/**
	 *  
	The name of the <code>text</code> property.
	

	 */
	public static final String TextPropertyName = "text";
	/**
	 *  
	The name of the <code>verticalOrigin</code> property.
	

	 */
	public static final String VerticalOriginPropertyName = "verticalOrigin";
	private Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<cesiumlanguagewriter.EyeOffsetCesiumWriter>(new Func1<cesiumlanguagewriter.EyeOffsetCesiumWriter>() {
		public cesiumlanguagewriter.EyeOffsetCesiumWriter invoke() {
			return new EyeOffsetCesiumWriter(EyeOffsetPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_fillColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(FillColorPropertyName);
		}
	}, false);
	private Lazy<FontCesiumWriter> m_font = new Lazy<cesiumlanguagewriter.FontCesiumWriter>(new Func1<cesiumlanguagewriter.FontCesiumWriter>() {
		public cesiumlanguagewriter.FontCesiumWriter invoke() {
			return new FontCesiumWriter(FontPropertyName);
		}
	}, false);
	private Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<cesiumlanguagewriter.HorizontalOriginCesiumWriter>(new Func1<cesiumlanguagewriter.HorizontalOriginCesiumWriter>() {
		public cesiumlanguagewriter.HorizontalOriginCesiumWriter invoke() {
			return new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(OutlineColorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(OutlineWidthPropertyName);
		}
	}, false);
	private Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<cesiumlanguagewriter.PixelOffsetCesiumWriter>(new Func1<cesiumlanguagewriter.PixelOffsetCesiumWriter>() {
		public cesiumlanguagewriter.PixelOffsetCesiumWriter invoke() {
			return new PixelOffsetCesiumWriter(PixelOffsetPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_scale = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ScalePropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<LabelStyleCesiumWriter> m_style = new Lazy<cesiumlanguagewriter.LabelStyleCesiumWriter>(new Func1<cesiumlanguagewriter.LabelStyleCesiumWriter>() {
		public cesiumlanguagewriter.LabelStyleCesiumWriter invoke() {
			return new LabelStyleCesiumWriter(StylePropertyName);
		}
	}, false);
	private Lazy<StringCesiumWriter> m_text = new Lazy<cesiumlanguagewriter.StringCesiumWriter>(new Func1<cesiumlanguagewriter.StringCesiumWriter>() {
		public cesiumlanguagewriter.StringCesiumWriter invoke() {
			return new StringCesiumWriter(TextPropertyName);
		}
	}, false);
	private Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<cesiumlanguagewriter.VerticalOriginCesiumWriter>(new Func1<cesiumlanguagewriter.VerticalOriginCesiumWriter>() {
		public cesiumlanguagewriter.VerticalOriginCesiumWriter invoke() {
			return new VerticalOriginCesiumWriter(VerticalOriginPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public LabelCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected LabelCesiumWriter(LabelCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public LabelCesiumWriter clone() {
		return new LabelCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>eyeOffset</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>eyeOffset</code> property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	

	 */
	public final EyeOffsetCesiumWriter getEyeOffsetWriter() {
		return m_eyeOffset.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>eyeOffset</code> property.  The <code>eyeOffset</code> property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	

	 */
	public final EyeOffsetCesiumWriter openEyeOffsetProperty() {
		openIntervalIfNecessary();
		return this.<EyeOffsetCesiumWriter> openAndReturn(getEyeOffsetWriter());
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	

	 * @param value The value.
	 */
	public final void writeEyeOffsetProperty(Cartesian value) {
		{
			cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
			try {
				writer.writeCartesian(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values) {
		{
			cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
			try {
				writer.writeCartesian(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
			try {
				writer.writeCartesian(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	

	 * @param value The reference.
	 */
	public final void writeEyeOffsetPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeEyeOffsetPropertyReference(String value) {
		{
			cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeEyeOffsetPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeEyeOffsetPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>fillColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>fillColor</code> property defines the fill color of the label.
	

	 */
	public final ColorCesiumWriter getFillColorWriter() {
		return m_fillColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>fillColor</code> property.  The <code>fillColor</code> property defines the fill color of the label.
	

	 */
	public final ColorCesiumWriter openFillColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getFillColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>rgba</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	

	 * @param color The color.
	 */
	public final void writeFillColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>rgba</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeFillColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>rgba</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeFillColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>rgbaf</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeFillColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>reference</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	

	 * @param value The reference.
	 */
	public final void writeFillColorPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>reference</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeFillColorPropertyReference(String value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>reference</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeFillColorPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fillColor</code> property as a <code>reference</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeFillColorPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>font</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>font</code> property defines the font to use for the label.
	

	 */
	public final FontCesiumWriter getFontWriter() {
		return m_font.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>font</code> property.  The <code>font</code> property defines the font to use for the label.
	

	 */
	public final FontCesiumWriter openFontProperty() {
		openIntervalIfNecessary();
		return this.<FontCesiumWriter> openAndReturn(getFontWriter());
	}

	/**
	 *  
	Writes a value for the <code>font</code> property as a <code>font</code> value.  The <code>font</code> property specifies the font to use for the label.
	
	

	 * @param font The font.
	 */
	public final void writeFontProperty(String font) {
		{
			cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
			try {
				writer.writeFont(font);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>font</code> property as a <code>reference</code> value.  The <code>font</code> property specifies the font to use for the label.
	
	

	 * @param value The reference.
	 */
	public final void writeFontPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>font</code> property as a <code>reference</code> value.  The <code>font</code> property specifies the font to use for the label.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeFontPropertyReference(String value) {
		{
			cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>font</code> property as a <code>reference</code> value.  The <code>font</code> property specifies the font to use for the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeFontPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>font</code> property as a <code>reference</code> value.  The <code>font</code> property specifies the font to use for the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeFontPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>horizontalOrigin</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>horizontalOrigin</code> property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
	

	 */
	public final HorizontalOriginCesiumWriter getHorizontalOriginWriter() {
		return m_horizontalOrigin.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
	

	 */
	public final HorizontalOriginCesiumWriter openHorizontalOriginProperty() {
		openIntervalIfNecessary();
		return this.<HorizontalOriginCesiumWriter> openAndReturn(getHorizontalOriginWriter());
	}

	/**
	 *  
	Writes a value for the <code>horizontalOrigin</code> property as a <code>horizontalOrigin</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
	
	

	 * @param value The horizontal origin.
	 */
	public final void writeHorizontalOriginProperty(CesiumHorizontalOrigin value) {
		{
			cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
			try {
				writer.writeHorizontalOrigin(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
	
	

	 * @param value The reference.
	 */
	public final void writeHorizontalOriginPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeHorizontalOriginPropertyReference(String value) {
		{
			cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeHorizontalOriginPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeHorizontalOriginPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineColor</code> property defines the outline color of the label.
	

	 */
	public final ColorCesiumWriter getOutlineColorWriter() {
		return m_outlineColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the outline color of the label.
	

	 */
	public final ColorCesiumWriter openOutlineColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	

	 * @param color The color.
	 */
	public final void writeOutlineColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeOutlineColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeOutlineColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	

	 * @param value The reference.
	 */
	public final void writeOutlineColorPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOutlineColorPropertyReference(String value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOutlineColorPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOutlineColorPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineWidth</code> property defines the outline width of the label.
	

	 */
	public final DoubleCesiumWriter getOutlineWidthWriter() {
		return m_outlineWidth.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the outline width of the label.
	

	 */
	public final DoubleCesiumWriter openOutlineWidthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
	
	

	 * @param value The value.
	 */
	public final void writeOutlineWidthProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
	
	

	 * @param value The reference.
	 */
	public final void writeOutlineWidthPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOutlineWidthPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOutlineWidthPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOutlineWidthPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>pixelOffset</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	

	 */
	public final PixelOffsetCesiumWriter getPixelOffsetWriter() {
		return m_pixelOffset.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>pixelOffset</code> property.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	

	 */
	public final PixelOffsetCesiumWriter openPixelOffsetProperty() {
		openIntervalIfNecessary();
		return this.<PixelOffsetCesiumWriter> openAndReturn(getPixelOffsetWriter());
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	

	 * @param value The value.
	 */
	public final void writePixelOffsetProperty(Rectangular value) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeCartesian2(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	
	

	 * @param x The X component.
	 * @param y The Y component.
	 */
	public final void writePixelOffsetProperty(double x, double y) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeCartesian2(x, y);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeCartesian2(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeCartesian2(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	

	 * @param value The reference.
	 */
	public final void writePixelOffsetPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writePixelOffsetPropertyReference(String value) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writePixelOffsetPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writePixelOffsetPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>scale</code> property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	

	 */
	public final DoubleCesiumWriter getScaleWriter() {
		return m_scale.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	

	 */
	public final DoubleCesiumWriter openScaleProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	
	

	 * @param value The value.
	 */
	public final void writeScaleProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeScaleProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	
	

	 * @param value The reference.
	 */
	public final void writeScalePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeScalePropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeScalePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeScalePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the label is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the label is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the label is shown.
	
	

	 * @param value The value.
	 */
	public final void writeShowProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>style</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>style</code> property defines the style of the label.
	

	 */
	public final LabelStyleCesiumWriter getStyleWriter() {
		return m_style.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>style</code> property.  The <code>style</code> property defines the style of the label.
	

	 */
	public final LabelStyleCesiumWriter openStyleProperty() {
		openIntervalIfNecessary();
		return this.<LabelStyleCesiumWriter> openAndReturn(getStyleWriter());
	}

	/**
	 *  
	Writes a value for the <code>style</code> property as a <code>labelStyle</code> value.  The <code>style</code> property specifies the style of the label.
	
	

	 * @param value The label style.
	 */
	public final void writeStyleProperty(CesiumLabelStyle value) {
		{
			cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
			try {
				writer.writeLabelStyle(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>style</code> property as a <code>reference</code> value.  The <code>style</code> property specifies the style of the label.
	
	

	 * @param value The reference.
	 */
	public final void writeStylePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>style</code> property as a <code>reference</code> value.  The <code>style</code> property specifies the style of the label.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeStylePropertyReference(String value) {
		{
			cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>style</code> property as a <code>reference</code> value.  The <code>style</code> property specifies the style of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeStylePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>style</code> property as a <code>reference</code> value.  The <code>style</code> property specifies the style of the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeStylePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>text</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>text</code> property defines the text displayed by the label.
	

	 */
	public final StringCesiumWriter getTextWriter() {
		return m_text.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>text</code> property.  The <code>text</code> property defines the text displayed by the label.
	

	 */
	public final StringCesiumWriter openTextProperty() {
		openIntervalIfNecessary();
		return this.<StringCesiumWriter> openAndReturn(getTextWriter());
	}

	/**
	 *  
	Writes a value for the <code>text</code> property as a <code>string</code> value.  The <code>text</code> property specifies the text displayed by the label.
	
	

	 * @param value The value.
	 */
	public final void writeTextProperty(String value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
			try {
				writer.writeString(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>text</code> property as a <code>reference</code> value.  The <code>text</code> property specifies the text displayed by the label.
	
	

	 * @param value The reference.
	 */
	public final void writeTextPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>text</code> property as a <code>reference</code> value.  The <code>text</code> property specifies the text displayed by the label.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeTextPropertyReference(String value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>text</code> property as a <code>reference</code> value.  The <code>text</code> property specifies the text displayed by the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeTextPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>text</code> property as a <code>reference</code> value.  The <code>text</code> property specifies the text displayed by the label.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeTextPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>verticalOrigin</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>verticalOrigin</code> property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
	

	 */
	public final VerticalOriginCesiumWriter getVerticalOriginWriter() {
		return m_verticalOrigin.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
	

	 */
	public final VerticalOriginCesiumWriter openVerticalOriginProperty() {
		openIntervalIfNecessary();
		return this.<VerticalOriginCesiumWriter> openAndReturn(getVerticalOriginWriter());
	}

	/**
	 *  
	Writes a value for the <code>verticalOrigin</code> property as a <code>verticalOrigin</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
	
	

	 * @param value The vertical origin.
	 */
	public final void writeVerticalOriginProperty(CesiumVerticalOrigin value) {
		{
			cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
			try {
				writer.writeVerticalOrigin(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
	
	

	 * @param value The reference.
	 */
	public final void writeVerticalOriginPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeVerticalOriginPropertyReference(String value) {
		{
			cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeVerticalOriginPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeVerticalOriginPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}