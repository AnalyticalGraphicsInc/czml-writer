package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.awt.image.RenderedImage;

/**
 *  
 Writes a <code>ImageMaterial</code> to a  {@link CesiumOutputStream}.  A <code>ImageMaterial</code> a material that fills the surface with an image.
 

 */
public class ImageMaterialCesiumWriter extends CesiumPropertyWriter<ImageMaterialCesiumWriter> {
	/**
	 *  
	The name of the <code>image</code> property.
	

	 */
	public static final String ImagePropertyName = "image";
	private Lazy<ImageCesiumWriter> m_image = new Lazy<ImageCesiumWriter>(new Func1<ImageCesiumWriter>() {
		public ImageCesiumWriter invoke() {
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
	
	

	 * @param url The URL of the image.
	 */
	public final void writeImageProperty(String url) {
		{
			cesiumlanguagewriter.ImageCesiumWriter writer = openImageProperty();
			try {
				writer.writeImage(url);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
	
	

	 * @param image The image for which to create a data URL.
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
}