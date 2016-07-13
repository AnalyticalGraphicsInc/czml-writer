package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.NearFarScalarCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Point</code> to a  {@link CesiumOutputStream}.  A <code>Point</code> is a point, or viewport-aligned circle.
 

 */
public class PointCesiumWriter extends CesiumPropertyWriter<PointCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>pixelSize</code> property.
	

	 */
	public static final String PixelSizePropertyName = "pixelSize";
	/**
	 *  
	The name of the <code>heightReference</code> property.
	

	 */
	public static final String HeightReferencePropertyName = "heightReference";
	/**
	 *  
	The name of the <code>color</code> property.
	

	 */
	public static final String ColorPropertyName = "color";
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
	The name of the <code>scaleByDistance</code> property.
	

	 */
	public static final String ScaleByDistancePropertyName = "scaleByDistance";
	/**
	 *  
	The name of the <code>translucencyByDistance</code> property.
	

	 */
	public static final String TranslucencyByDistancePropertyName = "translucencyByDistance";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_pixelSize = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(PixelSizePropertyName);
		}
	}, false);
	private Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<cesiumlanguagewriter.HeightReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.HeightReferenceCesiumWriter>() {
		public cesiumlanguagewriter.HeightReferenceCesiumWriter invoke() {
			return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(ColorPropertyName);
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
	private Lazy<NearFarScalarCesiumWriter> m_scaleByDistance = new Lazy<cesiumlanguagewriter.NearFarScalarCesiumWriter>(new Func1<cesiumlanguagewriter.NearFarScalarCesiumWriter>() {
		public cesiumlanguagewriter.NearFarScalarCesiumWriter invoke() {
			return new NearFarScalarCesiumWriter(ScaleByDistancePropertyName);
		}
	}, false);
	private Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<cesiumlanguagewriter.NearFarScalarCesiumWriter>(new Func1<cesiumlanguagewriter.NearFarScalarCesiumWriter>() {
		public cesiumlanguagewriter.NearFarScalarCesiumWriter invoke() {
			return new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PointCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected PointCesiumWriter(PointCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public PointCesiumWriter clone() {
		return new PointCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the point is shown.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the point is shown.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true" />.
	
	

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
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true" />.
	
	

	 * @param value The reference.
	 */
	public final void writeShowPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true" />.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeShowPropertyReference(String value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeShowPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeShowPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>pixelSize</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>pixelSize</code> property defines the size of the point, in pixels.  If not specified, the default value is 1.0.
	

	 */
	public final DoubleCesiumWriter getPixelSizeWriter() {
		return m_pixelSize.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>pixelSize</code> property.  The <code>pixelSize</code> property defines the size of the point, in pixels.  If not specified, the default value is 1.0.
	

	 */
	public final DoubleCesiumWriter openPixelSizeProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getPixelSizeWriter());
	}

	/**
	 *  
	Writes a value for the <code>pixelSize</code> property as a <code>number</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
	
	

	 * @param value The value.
	 */
	public final void writePixelSizeProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelSize</code> property as a <code>number</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writePixelSizeProperty(List<JulianDate> dates, List<Double> values) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
			try {
				writer.writeNumber(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelSize</code> property as a <code>number</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writePixelSizeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
	
	

	 * @param value The reference.
	 */
	public final void writePixelSizePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writePixelSizePropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writePixelSizePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writePixelSizePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>heightReference</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>heightReference</code> property defines the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
	

	 */
	public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
		return m_heightReference.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>heightReference</code> property.  The <code>heightReference</code> property defines the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
	

	 */
	public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
		openIntervalIfNecessary();
		return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
	}

	/**
	 *  
	Writes a value for the <code>heightReference</code> property as a <code>heightReference</code> value.  The <code>heightReference</code> property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
	
	

	 * @param value The height reference.
	 */
	public final void writeHeightReferenceProperty(CesiumHeightReference value) {
		{
			cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
			try {
				writer.writeHeightReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>heightReference</code> property as a <code>reference</code> value.  The <code>heightReference</code> property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
	
	

	 * @param value The reference.
	 */
	public final void writeHeightReferencePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>heightReference</code> property as a <code>reference</code> value.  The <code>heightReference</code> property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeHeightReferencePropertyReference(String value) {
		{
			cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>heightReference</code> property as a <code>reference</code> value.  The <code>heightReference</code> property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeHeightReferencePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>heightReference</code> property as a <code>reference</code> value.  The <code>heightReference</code> property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeHeightReferencePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>color</code> property defines the color of the point.
	

	 */
	public final ColorCesiumWriter getColorWriter() {
		return m_color.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the point.
	

	 */
	public final ColorCesiumWriter openColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
	
	

	 * @param color The color.
	 */
	public final void writeColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeColorProperty(List<JulianDate> dates, List<Color> values) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgba(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
	
	

	 * @param color The color.
	 */
	public final void writeColorPropertyRgbaf(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgbaf(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgbaf(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgbaf(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
	
	

	 * @param value The reference.
	 */
	public final void writeColorPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeColorPropertyReference(String value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeColorPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeColorPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineColor</code> property defines the color of the outline of the point.
	

	 */
	public final ColorCesiumWriter getOutlineColorWriter() {
		return m_outlineColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the color of the outline of the point.
	

	 */
	public final ColorCesiumWriter openOutlineColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> values) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	

	 * @param color The color.
	 */
	public final void writeOutlineColorPropertyRgbaf(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
	
	
	

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
	 *  Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineWidth</code> property defines the width of the outline of the point.  If not specified, the default value is 0.0.
	

	 */
	public final DoubleCesiumWriter getOutlineWidthWriter() {
		return m_outlineWidth.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the width of the outline of the point.  If not specified, the default value is 0.0.
	

	 */
	public final DoubleCesiumWriter openOutlineWidthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeNumber(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
	
	
	
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
	
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
	
	
	

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
	 *  Gets the writer for the <code>scaleByDistance</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>scaleByDistance</code> property defines how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	

	 */
	public final NearFarScalarCesiumWriter getScaleByDistanceWriter() {
		return m_scaleByDistance.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>scaleByDistance</code> property.  The <code>scaleByDistance</code> property defines how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	

	 */
	public final NearFarScalarCesiumWriter openScaleByDistanceProperty() {
		openIntervalIfNecessary();
		return this.<NearFarScalarCesiumWriter> openAndReturn(getScaleByDistanceWriter());
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	

	 * @param value The value.
	 */
	public final void writeScaleByDistanceProperty(NearFarScalar value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	
	
	
	

	 * @param nearDistance The lower bound of the camera distance range.
	 * @param nearValue The value to use at the lower bound of the camera distance range.
	 * @param farDistance The upper bound of the camera distance range.
	 * @param farValue The value to use at the upper bound of the camera distance range.
	 */
	public final void writeScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	

	 * @param value The reference.
	 */
	public final void writeScaleByDistancePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeScaleByDistancePropertyReference(String value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeScaleByDistancePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>translucencyByDistance</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>translucencyByDistance</code> property defines how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	

	 */
	public final NearFarScalarCesiumWriter getTranslucencyByDistanceWriter() {
		return m_translucencyByDistance.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>translucencyByDistance</code> property.  The <code>translucencyByDistance</code> property defines how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	

	 */
	public final NearFarScalarCesiumWriter openTranslucencyByDistanceProperty() {
		openIntervalIfNecessary();
		return this.<NearFarScalarCesiumWriter> openAndReturn(getTranslucencyByDistanceWriter());
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	

	 * @param value The value.
	 */
	public final void writeTranslucencyByDistanceProperty(NearFarScalar value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeNearFarScalar(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	
	
	

	 * @param nearDistance The lower bound of the camera distance range.
	 * @param nearValue The value to use at the lower bound of the camera distance range.
	 * @param farDistance The upper bound of the camera distance range.
	 * @param farValue The value to use at the upper bound of the camera distance range.
	 */
	public final void writeTranslucencyByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeNearFarScalar(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeNearFarScalar(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	

	 * @param value The reference.
	 */
	public final void writeTranslucencyByDistancePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeTranslucencyByDistancePropertyReference(String value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeTranslucencyByDistancePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeTranslucencyByDistancePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}