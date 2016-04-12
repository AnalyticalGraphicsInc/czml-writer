package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.RepeatCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;

/**
 *  
 Writes a <code>ImageMaterial</code> to a  {@link CesiumOutputStream}.  A <code>ImageMaterial</code> fills the surface with an image.
 

 */
public class ImageMaterialCesiumWriter extends CesiumPropertyWriter<ImageMaterialCesiumWriter> {
	/**
	 *  
	The name of the <code>image</code> property.
	

	 */
	public static final String ImagePropertyName = "image";
	/**
	 *  
	The name of the <code>color</code> property.
	

	 */
	public static final String ColorPropertyName = "color";
	/**
	 *  
	The name of the <code>transparent</code> property.
	

	 */
	public static final String TransparentPropertyName = "transparent";
	/**
	 *  
	The name of the <code>repeat</code> property.
	

	 */
	public static final String RepeatPropertyName = "repeat";
	private Lazy<UriCesiumWriter> m_image = new Lazy<cesiumlanguagewriter.UriCesiumWriter>(new Func1<cesiumlanguagewriter.UriCesiumWriter>() {
		public cesiumlanguagewriter.UriCesiumWriter invoke() {
			return new UriCesiumWriter(ImagePropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(ColorPropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_transparent = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(TransparentPropertyName);
		}
	}, false);
	private Lazy<RepeatCesiumWriter> m_repeat = new Lazy<cesiumlanguagewriter.RepeatCesiumWriter>(new Func1<cesiumlanguagewriter.RepeatCesiumWriter>() {
		public cesiumlanguagewriter.RepeatCesiumWriter invoke() {
			return new RepeatCesiumWriter(RepeatPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ImageMaterialCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ImageMaterialCesiumWriter(ImageMaterialCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public ImageMaterialCesiumWriter clone() {
		return new ImageMaterialCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>image</code> property defines the image to display on the surface.
	

	 */
	public final UriCesiumWriter getImageWriter() {
		return m_image.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the image to display on the surface.
	

	 */
	public final UriCesiumWriter openImageProperty() {
		openIntervalIfNecessary();
		return this.<UriCesiumWriter> openAndReturn(getImageWriter());
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	

	 * @param resource A resource object describing external data.
	 */
	public final void writeImageProperty(CesiumResource resource) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeUri(resource);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

	 * @param uri The URI of the data.
	 * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
	 */
	public final void writeImageProperty(URI uri, CesiumResourceBehavior resourceBehavior) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeUri(uri, resourceBehavior);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

	 * @param uri The URI of the data.
	 * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
	 */
	public final void writeImageProperty(String uri, CesiumResourceBehavior resourceBehavior) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeUri(uri, resourceBehavior);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

	 * @param uri The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
	 * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
	 */
	public final void writeImageProperty(URI uri, ICesiumUriResolver resolver) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeUri(uri, resolver);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

	 * @param uri The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
	 * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
	 */
	public final void writeImageProperty(String uri, ICesiumUriResolver resolver) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeUri(uri, resolver);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	

	 * @param image The image.  A data URI will be created for this image, using PNG encoding.
	 */
	public final void writeImageProperty(RenderedImage image) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeUri(image);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

	 * @param image The image.  A data URI will be created for this image.
	 * @param imageFormat The image format to use to encode the image in the data URI.
	 */
	public final void writeImageProperty(RenderedImage image, CesiumImageFormat imageFormat) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeUri(image, imageFormat);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	

	 * @param value The reference.
	 */
	public final void writeImagePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeImagePropertyReference(String value) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeImagePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeImagePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openImageProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>color</code> property defines the color of the image. This color value is multiplied with the image to produce the final color.
	

	 */
	public final ColorCesiumWriter getColorWriter() {
		return m_color.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the image. This color value is multiplied with the image to produce the final color.
	

	 */
	public final ColorCesiumWriter openColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	

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
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	

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
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the image. This color value is multiplied with the image to produce the final color.
	
	
	

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
	 *  Gets the writer for the <code>transparent</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>transparent</code> property defines whether or not the image has transparency.
	

	 */
	public final BooleanCesiumWriter getTransparentWriter() {
		return m_transparent.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>transparent</code> property.  The <code>transparent</code> property defines whether or not the image has transparency.
	

	 */
	public final BooleanCesiumWriter openTransparentProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getTransparentWriter());
	}

	/**
	 *  
	Writes a value for the <code>transparent</code> property as a <code>boolean</code> value.  The <code>transparent</code> property specifies whether or not the image has transparency.
	
	

	 * @param value The value.
	 */
	public final void writeTransparentProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openTransparentProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>transparent</code> property as a <code>reference</code> value.  The <code>transparent</code> property specifies whether or not the image has transparency.
	
	

	 * @param value The reference.
	 */
	public final void writeTransparentPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openTransparentProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>transparent</code> property as a <code>reference</code> value.  The <code>transparent</code> property specifies whether or not the image has transparency.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeTransparentPropertyReference(String value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openTransparentProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>transparent</code> property as a <code>reference</code> value.  The <code>transparent</code> property specifies whether or not the image has transparency.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeTransparentPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openTransparentProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>transparent</code> property as a <code>reference</code> value.  The <code>transparent</code> property specifies whether or not the image has transparency.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeTransparentPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openTransparentProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>repeat</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>repeat</code> property defines the number of times the image repeats along each axis.
	

	 */
	public final RepeatCesiumWriter getRepeatWriter() {
		return m_repeat.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>repeat</code> property.  The <code>repeat</code> property defines the number of times the image repeats along each axis.
	

	 */
	public final RepeatCesiumWriter openRepeatProperty() {
		openIntervalIfNecessary();
		return this.<RepeatCesiumWriter> openAndReturn(getRepeatWriter());
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>cartesian2</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	

	 * @param value The value.
	 */
	public final void writeRepeatProperty(Rectangular value) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeCartesian2(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>cartesian2</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	
	

	 * @param x The X component.
	 * @param y The Y component.
	 */
	public final void writeRepeatProperty(double x, double y) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeCartesian2(x, y);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>cartesian2</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeRepeatProperty(List<JulianDate> dates, List<Rectangular> values) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeCartesian2(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>cartesian2</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRepeatProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeCartesian2(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	

	 * @param value The reference.
	 */
	public final void writeRepeatPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeRepeatPropertyReference(String value) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeRepeatPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>repeat</code> property as a <code>reference</code> value.  The <code>repeat</code> property specifies the number of times the image repeats along each axis.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeRepeatPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.RepeatCesiumWriter writer = openRepeatProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}