package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.StripeOrientationCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>StripeMaterial</code> to a  {@link CesiumOutputStream}.  A <code>StripeMaterial</code> fills the surface with alternating colors.
 

 */
public class StripeMaterialCesiumWriter extends CesiumPropertyWriter<StripeMaterialCesiumWriter> {
	/**
	 *  
	The name of the <code>orientation</code> property.
	

	 */
	public static final String OrientationPropertyName = "orientation";
	/**
	 *  
	The name of the <code>evenColor</code> property.
	

	 */
	public static final String EvenColorPropertyName = "evenColor";
	/**
	 *  
	The name of the <code>oddColor</code> property.
	

	 */
	public static final String OddColorPropertyName = "oddColor";
	/**
	 *  
	The name of the <code>offset</code> property.
	

	 */
	public static final String OffsetPropertyName = "offset";
	/**
	 *  
	The name of the <code>repeat</code> property.
	

	 */
	public static final String RepeatPropertyName = "repeat";
	private Lazy<StripeOrientationCesiumWriter> m_orientation = new Lazy<cesiumlanguagewriter.StripeOrientationCesiumWriter>(new Func1<cesiumlanguagewriter.StripeOrientationCesiumWriter>() {
		public cesiumlanguagewriter.StripeOrientationCesiumWriter invoke() {
			return new StripeOrientationCesiumWriter(OrientationPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_evenColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(EvenColorPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_oddColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(OddColorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_offset = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(OffsetPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_repeat = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RepeatPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public StripeMaterialCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected StripeMaterialCesiumWriter(StripeMaterialCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public StripeMaterialCesiumWriter clone() {
		return new StripeMaterialCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>orientation</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>orientation</code> property defines the value indicating if the stripes are horizontal or vertical.
	

	 */
	public final StripeOrientationCesiumWriter getOrientationWriter() {
		return m_orientation.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>orientation</code> property.  The <code>orientation</code> property defines the value indicating if the stripes are horizontal or vertical.
	

	 */
	public final StripeOrientationCesiumWriter openOrientationProperty() {
		openIntervalIfNecessary();
		return this.<StripeOrientationCesiumWriter> openAndReturn(getOrientationWriter());
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>StripeOrientation</code> value.  The <code>orientation</code> property specifies the value indicating if the stripes are horizontal or vertical.
	
	

	 * @param value The orientation.
	 */
	public final void writeOrientationProperty(CesiumStripeOrientation value) {
		{
			cesiumlanguagewriter.StripeOrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeStripeOrientation(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the value indicating if the stripes are horizontal or vertical.
	
	

	 * @param value The reference.
	 */
	public final void writeOrientationPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.StripeOrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the value indicating if the stripes are horizontal or vertical.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOrientationPropertyReference(String value) {
		{
			cesiumlanguagewriter.StripeOrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the value indicating if the stripes are horizontal or vertical.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOrientationPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.StripeOrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the value indicating if the stripes are horizontal or vertical.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOrientationPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.StripeOrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>evenColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>evenColor</code> property defines the even color.
	

	 */
	public final ColorCesiumWriter getEvenColorWriter() {
		return m_evenColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>evenColor</code> property.  The <code>evenColor</code> property defines the even color.
	

	 */
	public final ColorCesiumWriter openEvenColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getEvenColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>rgba</code> value.  The <code>evenColor</code> property specifies the even color.
	
	

	 * @param color The color.
	 */
	public final void writeEvenColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>rgba</code> value.  The <code>evenColor</code> property specifies the even color.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeEvenColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>rgba</code> value.  The <code>evenColor</code> property specifies the even color.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeEvenColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>rgbaf</code> value.  The <code>evenColor</code> property specifies the even color.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeEvenColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>reference</code> value.  The <code>evenColor</code> property specifies the even color.
	
	

	 * @param value The reference.
	 */
	public final void writeEvenColorPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>reference</code> value.  The <code>evenColor</code> property specifies the even color.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeEvenColorPropertyReference(String value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>reference</code> value.  The <code>evenColor</code> property specifies the even color.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeEvenColorPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>evenColor</code> property as a <code>reference</code> value.  The <code>evenColor</code> property specifies the even color.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeEvenColorPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openEvenColorProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>oddColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>oddColor</code> property defines the odd color.
	

	 */
	public final ColorCesiumWriter getOddColorWriter() {
		return m_oddColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>oddColor</code> property.  The <code>oddColor</code> property defines the odd color.
	

	 */
	public final ColorCesiumWriter openOddColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getOddColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>rgba</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	

	 * @param color The color.
	 */
	public final void writeOddColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>rgba</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeOddColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>rgba</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeOddColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>rgbaf</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeOddColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>reference</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	

	 * @param value The reference.
	 */
	public final void writeOddColorPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>reference</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOddColorPropertyReference(String value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>reference</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOddColorPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>oddColor</code> property as a <code>reference</code> value.  The <code>oddColor</code> property specifies the odd color.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOddColorPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOddColorProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>offset</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>offset</code> property defines the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	

	 */
	public final DoubleCesiumWriter getOffsetWriter() {
		return m_offset.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>offset</code> property.  The <code>offset</code> property defines the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	

	 */
	public final DoubleCesiumWriter openOffsetProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getOffsetWriter());
	}

	/**
	 *  
	Writes a value for the <code>offset</code> property as a <code>number</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	
	

	 * @param value The value.
	 */
	public final void writeOffsetProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOffsetProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>offset</code> property as a <code>number</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeOffsetProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOffsetProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>offset</code> property as a <code>reference</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	
	

	 * @param value The reference.
	 */
	public final void writeOffsetPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOffsetProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>offset</code> property as a <code>reference</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOffsetPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOffsetProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>offset</code> property as a <code>reference</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOffsetPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOffsetProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>offset</code> property as a <code>reference</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOffsetPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOffsetProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>repeat</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>repeat</code> property defines the number of time the stripes repeat.
	

	 */
	public final DoubleCesiumWriter getRepeatWriter() {
		return m_repeat.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>repeat</code> property.  The <code>repeat</code> property defines the number of time the stripes repeat.
	

	 */
	public final DoubleCesiumWriter openRepeatProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRepeatWriter());
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>number</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
	
	

	 * @param value The value.
	 */
	public final void writeRepeatProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>number</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRepeatProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
	
	

	 * @param value The reference.
	 */
	public final void writeRepeatPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeRepeatPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeRepeatPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeRepeatPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}