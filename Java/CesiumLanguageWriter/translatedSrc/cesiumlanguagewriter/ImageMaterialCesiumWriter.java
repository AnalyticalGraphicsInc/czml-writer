package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ImageCesiumWriter;
import java.awt.image.RenderedImage;

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
	private Lazy<ImageCesiumWriter> m_image = new Lazy<cesiumlanguagewriter.ImageCesiumWriter>(new Func1<cesiumlanguagewriter.ImageCesiumWriter>() {
		public cesiumlanguagewriter.ImageCesiumWriter invoke() {
			return new ImageCesiumWriter(ImagePropertyName);
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
	public final ImageCesiumWriter getImageWriter() {
		return m_image.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the image to display on the surface.
	

	 */
	public final ImageCesiumWriter openImageProperty() {
		openIntervalIfNecessary();
		return this.<ImageCesiumWriter> openAndReturn(getImageWriter());
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	

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
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

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
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	

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
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	
	

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
}