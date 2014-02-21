package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;
import java.net.URI;

/**
 *  
 Writes a <code>GltfUrl</code> to a  {@link CesiumOutputStream}.  A <code>GltfUrl</code> the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
 

 */
public class GltfUrlCesiumWriter extends CesiumPropertyWriter<GltfUrlCesiumWriter> {
	/**
	 *  
	The name of the <code>uri</code> property.
	

	 */
	public static final String UriPropertyName = "uri";

	/**
	 *  
	Initializes a new instance.
	

	 */
	public GltfUrlCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected GltfUrlCesiumWriter(GltfUrlCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public GltfUrlCesiumWriter clone() {
		return new GltfUrlCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URL of the glTF model.
	
	
	

	 * @param url The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeUri(String url, ICesiumUrlResolver resolver) {
		String PropertyName = UriPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(resolver.resolveUrl(url));
	}

	/**
	 *  
	Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URL of the glTF model.
	
	
	

	 * @param url The uri.  A data URI will be created for this image, using PNG encoding.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeUri(URI url, ICesiumUrlResolver resolver) {
		String PropertyName = UriPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(resolver.resolveUrl(url.toString()));
	}
}