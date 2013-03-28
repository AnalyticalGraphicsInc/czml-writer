package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumResource;
import java.awt.image.RenderedImage;

/**
 *  
 Writes a <code>Image</code> to a  {@link CesiumOutputStream}.  A <code>Image</code> defines an image associated with an element, which can optionally vary over time.  The image is specified as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
 

 */
public class ImageCesiumWriter extends CesiumPropertyWriter<ImageCesiumWriter> {
	/**
	 *  
	The name of the <code>image</code> property.
	

	 */
	public static final String ImagePropertyName = "image";
	private Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asImage;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ImageCesiumWriter(String propertyName) {
		super(propertyName);
		m_asImage = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createImageAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createImageAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ImageCesiumWriter(ImageCesiumWriter existingInstance) {
		super(existingInstance);
		m_asImage = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createImageAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createImageAdaptor();
			}
		}, false);
	}

	@Override
	public ImageCesiumWriter clone() {
		return new ImageCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
	
	

	 * @param resource A resource object describing the image.
	 */
	public final void writeImage(CesiumResource resource) {
		writeImage(resource.getUrl(), resource.getBehavior());
	}

	/**
	 *  
	Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
	
	
	

	 * @param url The URL of the image.
	 * @param resourceBehavior An enumeration describing how to include the image in the document. For even more control, use the overload that takes a ICesiumUrlResolver.
	 */
	public final void writeImage(String url, CesiumResourceBehavior resourceBehavior) {
		String PropertyName = ImagePropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.getResourceUrl(url, resourceBehavior));
	}

	/**
	 *  
	Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
	
	
	

	 * @param url The URL of the image.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeImage(String url, ICesiumUrlResolver resolver) {
		String PropertyName = ImagePropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(resolver.resolveUrl(url));
	}

	/**
	 *  
	Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
	
	

	 * @param image The image.  A data URI will be created for this image, using PNG encoding.
	 */
	public final void writeImage(RenderedImage image) {
		writeImage(image, CesiumImageFormat.PNG);
	}

	/**
	 *  
	Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
	
	
	

	 * @param image The image.  A data URI will be created for this image.
	 * @param imageFormat The image format to use to encode the image in the data URI.
	 */
	public final void writeImage(RenderedImage image, CesiumImageFormat imageFormat) {
		String PropertyName = ImagePropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.imageToDataUri(image, imageFormat));
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Image</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumResource> asImage() {
		return m_asImage.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumResource> createImageAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.ImageCesiumWriter, cesiumlanguagewriter.CesiumResource>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ImageCesiumWriter, cesiumlanguagewriter.CesiumResource>() {
					public void invoke(ImageCesiumWriter me, CesiumResource value) {
						me.writeImage(value);
					}
				});
	}
}