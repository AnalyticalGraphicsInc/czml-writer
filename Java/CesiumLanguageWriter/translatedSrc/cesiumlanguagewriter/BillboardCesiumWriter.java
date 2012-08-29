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
import cesiumlanguagewriter.HorizontalOriginCesiumWriter;
import cesiumlanguagewriter.ImageCesiumWriter;
import cesiumlanguagewriter.PixelOffsetCesiumWriter;
import cesiumlanguagewriter.VerticalOriginCesiumWriter;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.util.List;

/**
 *  
 Writes a <code>Billboard</code> to a  {@link CesiumOutputStream}.  A <code>Billboard</code> specifies a billboard, or viewport-aligned image. The billboard is positioned in the scene by the `position` property. A billboard is sometimes called a marker.
 

 */
public class BillboardCesiumWriter extends CesiumPropertyWriter<BillboardCesiumWriter> {
	/**
	 *  
	The name of the <code>color</code> property.
	

	 */
	public static final String ColorPropertyName = "color";
	/**
	 *  
	The name of the <code>eyeOffset</code> property.
	

	 */
	public static final String EyeOffsetPropertyName = "eyeOffset";
	/**
	 *  
	The name of the <code>horizontalOrigin</code> property.
	

	 */
	public static final String HorizontalOriginPropertyName = "horizontalOrigin";
	/**
	 *  
	The name of the <code>image</code> property.
	

	 */
	public static final String ImagePropertyName = "image";
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
	The name of the <code>verticalOrigin</code> property.
	

	 */
	public static final String VerticalOriginPropertyName = "verticalOrigin";
	private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(ColorPropertyName);
		}
	}, false);
	private Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<cesiumlanguagewriter.EyeOffsetCesiumWriter>(new Func1<cesiumlanguagewriter.EyeOffsetCesiumWriter>() {
		public cesiumlanguagewriter.EyeOffsetCesiumWriter invoke() {
			return new EyeOffsetCesiumWriter(EyeOffsetPropertyName);
		}
	}, false);
	private Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<cesiumlanguagewriter.HorizontalOriginCesiumWriter>(new Func1<cesiumlanguagewriter.HorizontalOriginCesiumWriter>() {
		public cesiumlanguagewriter.HorizontalOriginCesiumWriter invoke() {
			return new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName);
		}
	}, false);
	private Lazy<ImageCesiumWriter> m_image = new Lazy<cesiumlanguagewriter.ImageCesiumWriter>(new Func1<cesiumlanguagewriter.ImageCesiumWriter>() {
		public cesiumlanguagewriter.ImageCesiumWriter invoke() {
			return new ImageCesiumWriter(ImagePropertyName);
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
	private Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<cesiumlanguagewriter.VerticalOriginCesiumWriter>(new Func1<cesiumlanguagewriter.VerticalOriginCesiumWriter>() {
		public cesiumlanguagewriter.VerticalOriginCesiumWriter invoke() {
			return new VerticalOriginCesiumWriter(VerticalOriginPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public BillboardCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected BillboardCesiumWriter(BillboardCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public BillboardCesiumWriter clone() {
		return new BillboardCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>color</code> property defines the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	

	 */
	public final ColorCesiumWriter getColorWriter() {
		return m_color.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	

	 */
	public final ColorCesiumWriter openColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	
	
	
	

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
	 *  Gets the writer for the <code>eyeOffset</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>eyeOffset</code> property defines the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	

	 */
	public final EyeOffsetCesiumWriter getEyeOffsetWriter() {
		return m_eyeOffset.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>eyeOffset</code> property.  The <code>eyeOffset</code> property defines the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	

	 */
	public final EyeOffsetCesiumWriter openEyeOffsetProperty() {
		openIntervalIfNecessary();
		return this.<EyeOffsetCesiumWriter> openAndReturn(getEyeOffsetWriter());
	}

	/**
	 *  
	Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	

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
	Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	

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
	Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	
	
	

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
	 *  Gets the writer for the <code>horizontalOrigin</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard.  It controls whether the billboard image is left-, center-, or right-aligned with the `position`.
	

	 */
	public final HorizontalOriginCesiumWriter getHorizontalOriginWriter() {
		return m_horizontalOrigin.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard.  It controls whether the billboard image is left-, center-, or right-aligned with the `position`.
	

	 */
	public final HorizontalOriginCesiumWriter openHorizontalOriginProperty() {
		openIntervalIfNecessary();
		return this.<HorizontalOriginCesiumWriter> openAndReturn(getHorizontalOriginWriter());
	}

	/**
	 *  
	Writes a value for the <code>horizontalOrigin</code> property as a <code>horizontalOrigin</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard.  It controls whether the billboard image is left-, center-, or right-aligned with the `position`.
	
	

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
	 *  Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>image</code> property defines the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	

	 */
	public final ImageCesiumWriter getImageWriter() {
		return m_image.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	

	 */
	public final ImageCesiumWriter openImageProperty() {
		openIntervalIfNecessary();
		return this.<ImageCesiumWriter> openAndReturn(getImageWriter());
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	

	 * @param resource A resource object describing the image.
	 */
	public final void writeImageProperty(CesiumResource resource) {
		{
			cesiumlanguagewriter.ImageCesiumWriter writer = openImageProperty();
			try {
				writer.writeImage(resource);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

	 * @param url The URL of the image.
	 * @param resourceBehavior An enumeration describing how to include the image in the document. For even more control, use the overload that takes a ICesiumUrlResolver.
	 */
	public final void writeImageProperty(String url, CesiumResourceBehavior resourceBehavior) {
		{
			cesiumlanguagewriter.ImageCesiumWriter writer = openImageProperty();
			try {
				writer.writeImage(url, resourceBehavior);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

	 * @param url The URL of the image.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeImageProperty(String url, ICesiumUrlResolver resolver) {
		{
			cesiumlanguagewriter.ImageCesiumWriter writer = openImageProperty();
			try {
				writer.writeImage(url, resolver);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	

	 * @param image The image.  A data URI will be created for this image, using PNG encoding.
	 */
	public final void writeImageProperty(RenderedImage image) {
		{
			cesiumlanguagewriter.ImageCesiumWriter writer = openImageProperty();
			try {
				writer.writeImage(image);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

	 * @param image The image.  A data URI will be created for this image.
	 * @param imageFormat The image format to use to encode the image in the data URI.
	 */
	public final void writeImageProperty(RenderedImage image, CesiumImageFormat imageFormat) {
		{
			cesiumlanguagewriter.ImageCesiumWriter writer = openImageProperty();
			try {
				writer.writeImage(image, imageFormat);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>pixelOffset</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	

	 */
	public final PixelOffsetCesiumWriter getPixelOffsetWriter() {
		return m_pixelOffset.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>pixelOffset</code> property.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	

	 */
	public final PixelOffsetCesiumWriter openPixelOffsetProperty() {
		openIntervalIfNecessary();
		return this.<PixelOffsetCesiumWriter> openAndReturn(getPixelOffsetWriter());
	}

	/**
	 *  
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	

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
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	
	

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
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	
	

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
	Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	
	
	
	

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
	 *  Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
	

	 */
	public final DoubleCesiumWriter getScaleWriter() {
		return m_scale.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
	

	 */
	public final DoubleCesiumWriter openScaleProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
	
	

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
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
	
	
	
	
	

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
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the billboard is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the billboard is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.
	
	

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
	 *  Gets the writer for the <code>verticalOrigin</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard.  It controls whether the billboard image is bottom-, center-, or top-aligned with the `position`.
	

	 */
	public final VerticalOriginCesiumWriter getVerticalOriginWriter() {
		return m_verticalOrigin.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard.  It controls whether the billboard image is bottom-, center-, or top-aligned with the `position`.
	

	 */
	public final VerticalOriginCesiumWriter openVerticalOriginProperty() {
		openIntervalIfNecessary();
		return this.<VerticalOriginCesiumWriter> openAndReturn(getVerticalOriginWriter());
	}

	/**
	 *  
	Writes a value for the <code>verticalOrigin</code> property as a <code>verticalOrigin</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard.  It controls whether the billboard image is bottom-, center-, or top-aligned with the `position`.
	
	

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
}