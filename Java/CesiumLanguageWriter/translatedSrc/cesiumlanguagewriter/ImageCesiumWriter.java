package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
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
	private Lazy<ICesiumValuePropertyWriter<String>> m_asImage;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ImageCesiumWriter(String propertyName) {
		super(propertyName);
		m_asImage = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this, "createImageAdaptor",
				new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
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
		m_asImage = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this, "createImageAdaptor",
				new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
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
	
	

	 * @param url The URL of the image.
	 */
	public final void writeImage(String url) {
		String PropertyName = ImagePropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(url);
	}

	/**
	 *  
	Writes the <code>image</code> property.  The <code>image</code> property specifies the URL of the image.
	
	

	 * @param image The image for which to create a data URL.
	 */
	public final void writeImage(RenderedImage image) {
		writeImage(CesiumFormattingHelper.imageToDataUrl(image));
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Image</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<String> asImage() {
		return m_asImage.getValue();
	}

	final private ICesiumValuePropertyWriter<String> createImageAdaptor() {
		return new CesiumWriterAdaptor<ImageCesiumWriter, String>(this, new CesiumWriterAdaptorWriteCallback<ImageCesiumWriter, String>() {
			public void invoke(ImageCesiumWriter me, String value) {
				me.writeImage(value);
			}
		});
	}
}