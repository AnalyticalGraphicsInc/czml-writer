package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.AlignedAxisCesiumWriter;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.BoundingRectangleCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.EyeOffsetCesiumWriter;
import cesiumlanguagewriter.HorizontalOriginCesiumWriter;
import cesiumlanguagewriter.NearFarScalarCesiumWriter;
import cesiumlanguagewriter.PixelOffsetCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import cesiumlanguagewriter.VerticalOriginCesiumWriter;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;

/**
 *  
 Writes a <code>Billboard</code> to a  {@link CesiumOutputStream}.  A <code>Billboard</code> is a billboard, or viewport-aligned image.  The billboard is positioned in the scene by the `position` property.  A billboard is sometimes called a marker.
 

 */
public class BillboardCesiumWriter extends CesiumPropertyWriter<BillboardCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>image</code> property.
	

	 */
	public static final String ImagePropertyName = "image";
	/**
	 *  
	The name of the <code>scale</code> property.
	

	 */
	public static final String ScalePropertyName = "scale";
	/**
	 *  
	The name of the <code>pixelOffset</code> property.
	

	 */
	public static final String PixelOffsetPropertyName = "pixelOffset";
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
	The name of the <code>verticalOrigin</code> property.
	

	 */
	public static final String VerticalOriginPropertyName = "verticalOrigin";
	/**
	 *  
	The name of the <code>color</code> property.
	

	 */
	public static final String ColorPropertyName = "color";
	/**
	 *  
	The name of the <code>rotation</code> property.
	

	 */
	public static final String RotationPropertyName = "rotation";
	/**
	 *  
	The name of the <code>alignedAxis</code> property.
	

	 */
	public static final String AlignedAxisPropertyName = "alignedAxis";
	/**
	 *  
	The name of the <code>sizeInMeters</code> property.
	

	 */
	public static final String SizeInMetersPropertyName = "sizeInMeters";
	/**
	 *  
	The name of the <code>width</code> property.
	

	 */
	public static final String WidthPropertyName = "width";
	/**
	 *  
	The name of the <code>height</code> property.
	

	 */
	public static final String HeightPropertyName = "height";
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
	/**
	 *  
	The name of the <code>pixelOffsetScaleByDistance</code> property.
	

	 */
	public static final String PixelOffsetScaleByDistancePropertyName = "pixelOffsetScaleByDistance";
	/**
	 *  
	The name of the <code>imageSubRegion</code> property.
	

	 */
	public static final String ImageSubRegionPropertyName = "imageSubRegion";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<UriCesiumWriter> m_image = new Lazy<cesiumlanguagewriter.UriCesiumWriter>(new Func1<cesiumlanguagewriter.UriCesiumWriter>() {
		public cesiumlanguagewriter.UriCesiumWriter invoke() {
			return new UriCesiumWriter(ImagePropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_scale = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ScalePropertyName);
		}
	}, false);
	private Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<cesiumlanguagewriter.PixelOffsetCesiumWriter>(new Func1<cesiumlanguagewriter.PixelOffsetCesiumWriter>() {
		public cesiumlanguagewriter.PixelOffsetCesiumWriter invoke() {
			return new PixelOffsetCesiumWriter(PixelOffsetPropertyName);
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
	private Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<cesiumlanguagewriter.VerticalOriginCesiumWriter>(new Func1<cesiumlanguagewriter.VerticalOriginCesiumWriter>() {
		public cesiumlanguagewriter.VerticalOriginCesiumWriter invoke() {
			return new VerticalOriginCesiumWriter(VerticalOriginPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(ColorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_rotation = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RotationPropertyName);
		}
	}, false);
	private Lazy<AlignedAxisCesiumWriter> m_alignedAxis = new Lazy<cesiumlanguagewriter.AlignedAxisCesiumWriter>(new Func1<cesiumlanguagewriter.AlignedAxisCesiumWriter>() {
		public cesiumlanguagewriter.AlignedAxisCesiumWriter invoke() {
			return new AlignedAxisCesiumWriter(AlignedAxisPropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_sizeInMeters = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(SizeInMetersPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_width = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(WidthPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_height = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(HeightPropertyName);
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
	private Lazy<NearFarScalarCesiumWriter> m_pixelOffsetScaleByDistance = new Lazy<cesiumlanguagewriter.NearFarScalarCesiumWriter>(new Func1<cesiumlanguagewriter.NearFarScalarCesiumWriter>() {
		public cesiumlanguagewriter.NearFarScalarCesiumWriter invoke() {
			return new NearFarScalarCesiumWriter(PixelOffsetScaleByDistancePropertyName);
		}
	}, false);
	private Lazy<BoundingRectangleCesiumWriter> m_imageSubRegion = new Lazy<cesiumlanguagewriter.BoundingRectangleCesiumWriter>(new Func1<cesiumlanguagewriter.BoundingRectangleCesiumWriter>() {
		public cesiumlanguagewriter.BoundingRectangleCesiumWriter invoke() {
			return new BoundingRectangleCesiumWriter(ImageSubRegionPropertyName);
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
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the billboard is shown.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the billboard is shown.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true" />.
	
	

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
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true" />.
	
	

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
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true" />.
	
	

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
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true" />.
	
	
	

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
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true" />.
	
	
	

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
	 *  Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>image</code> property defines the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	

	 */
	public final UriCesiumWriter getImageWriter() {
		return m_image.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	

	 */
	public final UriCesiumWriter openImageProperty() {
		openIntervalIfNecessary();
		return this.<UriCesiumWriter> openAndReturn(getImageWriter());
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	

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
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	

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
	Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	

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
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	

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
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
	
	
	

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
	 *  Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	

	 */
	public final DoubleCesiumWriter getScaleWriter() {
		return m_scale.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	

	 */
	public final DoubleCesiumWriter openScaleProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	
	

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
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	
	
	
	
	

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
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	
	

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
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	
	

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
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	
	
	

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
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
	
	
	

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
	
	
	

	 * @param dates The dates at which the value is specified.
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
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
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
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	

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
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	

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
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	
	

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
	Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
	
	
	

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
	
	
	

	 * @param dates The dates at which the value is specified.
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
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
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
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	

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
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	

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
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	

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
	Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
	
	
	

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
	 *  Gets the writer for the <code>horizontalOrigin</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
	

	 */
	public final HorizontalOriginCesiumWriter getHorizontalOriginWriter() {
		return m_horizontalOrigin.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
	

	 */
	public final HorizontalOriginCesiumWriter openHorizontalOriginProperty() {
		openIntervalIfNecessary();
		return this.<HorizontalOriginCesiumWriter> openAndReturn(getHorizontalOriginWriter());
	}

	/**
	 *  
	Writes a value for the <code>horizontalOrigin</code> property as a <code>horizontalOrigin</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
	
	

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
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
	
	

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
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
	
	

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
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
	
	
	

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
	Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
	
	
	

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
	 *  Gets the writer for the <code>verticalOrigin</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
	

	 */
	public final VerticalOriginCesiumWriter getVerticalOriginWriter() {
		return m_verticalOrigin.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
	

	 */
	public final VerticalOriginCesiumWriter openVerticalOriginProperty() {
		openIntervalIfNecessary();
		return this.<VerticalOriginCesiumWriter> openAndReturn(getVerticalOriginWriter());
	}

	/**
	 *  
	Writes a value for the <code>verticalOrigin</code> property as a <code>verticalOrigin</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
	
	

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
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
	
	

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
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
	
	

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
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
	
	
	

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
	Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
	
	
	

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
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	

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
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	

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
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
	
	
	

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
	 *  Gets the writer for the <code>rotation</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>rotation</code> property defines the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	

	 */
	public final DoubleCesiumWriter getRotationWriter() {
		return m_rotation.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>rotation</code> property.  The <code>rotation</code> property defines the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	

	 */
	public final DoubleCesiumWriter openRotationProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRotationWriter());
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>number</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	
	

	 * @param value The value.
	 */
	public final void writeRotationProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>number</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRotationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	
	

	 * @param value The reference.
	 */
	public final void writeRotationPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeRotationPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeRotationPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeRotationPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>alignedAxis</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>alignedAxis</code> property defines the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	

	 */
	public final AlignedAxisCesiumWriter getAlignedAxisWriter() {
		return m_alignedAxis.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>alignedAxis</code> property.  The <code>alignedAxis</code> property defines the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	

	 */
	public final AlignedAxisCesiumWriter openAlignedAxisProperty() {
		openIntervalIfNecessary();
		return this.<AlignedAxisCesiumWriter> openAndReturn(getAlignedAxisWriter());
	}

	/**
	 *  
	Writes a value for the <code>alignedAxis</code> property as a <code>cartesian</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	
	

	 * @param value The value.
	 */
	public final void writeAlignedAxisProperty(Cartesian value) {
		{
			cesiumlanguagewriter.AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
			try {
				writer.writeCartesian(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>alignedAxis</code> property as a <code>cartesian</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeAlignedAxisProperty(List<JulianDate> dates, List<Cartesian> values) {
		{
			cesiumlanguagewriter.AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
			try {
				writer.writeCartesian(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>alignedAxis</code> property as a <code>cartesian</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeAlignedAxisProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
			try {
				writer.writeCartesian(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	
	

	 * @param value The reference.
	 */
	public final void writeAlignedAxisPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeAlignedAxisPropertyReference(String value) {
		{
			cesiumlanguagewriter.AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeAlignedAxisPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeAlignedAxisPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>sizeInMeters</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>sizeInMeters</code> property defines whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false" />.
	

	 */
	public final BooleanCesiumWriter getSizeInMetersWriter() {
		return m_sizeInMeters.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>sizeInMeters</code> property.  The <code>sizeInMeters</code> property defines whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false" />.
	

	 */
	public final BooleanCesiumWriter openSizeInMetersProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getSizeInMetersWriter());
	}

	/**
	 *  
	Writes a value for the <code>sizeInMeters</code> property as a <code>boolean</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false" />.
	
	

	 * @param value The value.
	 */
	public final void writeSizeInMetersProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openSizeInMetersProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false" />.
	
	

	 * @param value The reference.
	 */
	public final void writeSizeInMetersPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openSizeInMetersProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false" />.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeSizeInMetersPropertyReference(String value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openSizeInMetersProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeSizeInMetersPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openSizeInMetersProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeSizeInMetersPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openSizeInMetersProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>width</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>width</code> property defines the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	

	 */
	public final DoubleCesiumWriter getWidthWriter() {
		return m_width.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>width</code> property.  The <code>width</code> property defines the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	

	 */
	public final DoubleCesiumWriter openWidthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getWidthWriter());
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	

	 * @param value The value.
	 */
	public final void writeWidthProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	

	 * @param value The reference.
	 */
	public final void writeWidthPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeWidthPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeWidthPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeWidthPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>height</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>height</code> property defines the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	

	 */
	public final DoubleCesiumWriter getHeightWriter() {
		return m_height.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>height</code> property.  The <code>height</code> property defines the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	

	 */
	public final DoubleCesiumWriter openHeightProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getHeightWriter());
	}

	/**
	 *  
	Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	

	 * @param value The value.
	 */
	public final void writeHeightProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openHeightProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeHeightProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openHeightProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	

	 * @param value The reference.
	 */
	public final void writeHeightPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openHeightProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeHeightPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openHeightProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeHeightPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openHeightProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeHeightPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openHeightProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>scaleByDistance</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>scaleByDistance</code> property defines how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	

	 */
	public final NearFarScalarCesiumWriter getScaleByDistanceWriter() {
		return m_scaleByDistance.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>scaleByDistance</code> property.  The <code>scaleByDistance</code> property defines how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	

	 */
	public final NearFarScalarCesiumWriter openScaleByDistanceProperty() {
		openIntervalIfNecessary();
		return this.<NearFarScalarCesiumWriter> openAndReturn(getScaleByDistanceWriter());
	}

	/**
	 *  
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	

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
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	
	
	
	

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
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	
	

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
	Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	
	
	
	

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
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	

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
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	

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
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	
	

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
	Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
	
	
	

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
	 *  Gets the writer for the <code>translucencyByDistance</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>translucencyByDistance</code> property defines how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	

	 */
	public final NearFarScalarCesiumWriter getTranslucencyByDistanceWriter() {
		return m_translucencyByDistance.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>translucencyByDistance</code> property.  The <code>translucencyByDistance</code> property defines how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	

	 */
	public final NearFarScalarCesiumWriter openTranslucencyByDistanceProperty() {
		openIntervalIfNecessary();
		return this.<NearFarScalarCesiumWriter> openAndReturn(getTranslucencyByDistanceWriter());
	}

	/**
	 *  
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	

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
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	
	
	

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
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	

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
	Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	
	
	

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
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	

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
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	

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
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	

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
	Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
	
	
	

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

	/**
	 *  Gets the writer for the <code>pixelOffsetScaleByDistance</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>pixelOffsetScaleByDistance</code> property defines how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	

	 */
	public final NearFarScalarCesiumWriter getPixelOffsetScaleByDistanceWriter() {
		return m_pixelOffsetScaleByDistance.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>pixelOffsetScaleByDistance</code> property.  The <code>pixelOffsetScaleByDistance</code> property defines how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	

	 */
	public final NearFarScalarCesiumWriter openPixelOffsetScaleByDistanceProperty() {
		openIntervalIfNecessary();
		return this.<NearFarScalarCesiumWriter> openAndReturn(getPixelOffsetScaleByDistanceWriter());
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	

	 * @param value The value.
	 */
	public final void writePixelOffsetScaleByDistanceProperty(NearFarScalar value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	
	
	
	

	 * @param nearDistance The lower bound of the camera distance range.
	 * @param nearValue The value to use at the lower bound of the camera distance range.
	 * @param farDistance The upper bound of the camera distance range.
	 * @param farValue The value to use at the upper bound of the camera distance range.
	 */
	public final void writePixelOffsetScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeNearFarScalar(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	

	 * @param value The reference.
	 */
	public final void writePixelOffsetScaleByDistancePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writePixelOffsetScaleByDistancePropertyReference(String value) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>imageSubRegion</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>imageSubRegion</code> property defines a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	

	 */
	public final BoundingRectangleCesiumWriter getImageSubRegionWriter() {
		return m_imageSubRegion.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>imageSubRegion</code> property.  The <code>imageSubRegion</code> property defines a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	

	 */
	public final BoundingRectangleCesiumWriter openImageSubRegionProperty() {
		openIntervalIfNecessary();
		return this.<BoundingRectangleCesiumWriter> openAndReturn(getImageSubRegionWriter());
	}

	/**
	 *  
	Writes a value for the <code>imageSubRegion</code> property as a <code>cartesian</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	
	

	 * @param value The value.
	 */
	public final void writeImageSubRegionProperty(BoundingRectangle value) {
		{
			cesiumlanguagewriter.BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
			try {
				writer.writeCartesian(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>imageSubRegion</code> property as a <code>cartesian</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeImageSubRegionProperty(List<JulianDate> dates, List<BoundingRectangle> values) {
		{
			cesiumlanguagewriter.BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
			try {
				writer.writeCartesian(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>imageSubRegion</code> property as a <code>cartesian</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeImageSubRegionProperty(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
			try {
				writer.writeCartesian(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	
	

	 * @param value The reference.
	 */
	public final void writeImageSubRegionPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeImageSubRegionPropertyReference(String value) {
		{
			cesiumlanguagewriter.BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeImageSubRegionPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeImageSubRegionPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}