package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>ModelUri</code> to a  {@link CesiumOutputStream}.  A <code>ModelUri</code> defines a model associated with an element, which can optionally vary over time.  The model is specified as multiple URLs where each property maps to a different format.  The client can choose its best supported format from those provided.
 

 */
public class ModelUriCesiumWriter extends CesiumPropertyWriter<ModelUriCesiumWriter> {
	/**
	 *  
	The name of the <code>webgltf</code> property.
	

	 */
	public static final String WebgltfPropertyName = "webgltf";
	/**
	 *  
	The name of the <code>dae</code> property.
	

	 */
	public static final String DaePropertyName = "dae";
	private Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asWebgltf;
	private Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asDae;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ModelUriCesiumWriter(String propertyName) {
		super(propertyName);
		m_asWebgltf = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createWebgltfAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createWebgltfAdaptor();
			}
		}, false);
		m_asDae = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createDaeAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createDaeAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ModelUriCesiumWriter(ModelUriCesiumWriter existingInstance) {
		super(existingInstance);
		m_asWebgltf = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createWebgltfAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createWebgltfAdaptor();
			}
		}, false);
		m_asDae = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createDaeAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createDaeAdaptor();
			}
		}, false);
	}

	@Override
	public ModelUriCesiumWriter clone() {
		return new ModelUriCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>webgltf</code> property.  The <code>webgltf</code> property specifies the URL of a WebGLTF model.
	
	

	 * @param resource A resource object describing the model.
	 */
	public final void writeWebgltf(CesiumResource resource) {
		writeWebgltf(resource.getUrl(), resource.getBehavior());
	}

	/**
	 *  
	Writes the <code>webgltf</code> property.  The <code>webgltf</code> property specifies the URL of a WebGLTF model.
	
	
	

	 * @param url The URL of the model.
	 * @param resourceBehavior An enumeration describing how to include the model in the document. For even more control, use the overload that takes a ICesiumUrlResolver.
	 */
	public final void writeWebgltf(String url, CesiumResourceBehavior resourceBehavior) {
		String PropertyName = WebgltfPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.getResourceUrl(url, resourceBehavior));
	}

	/**
	 *  
	Writes the <code>webgltf</code> property.  The <code>webgltf</code> property specifies the URL of a WebGLTF model.
	
	
	

	 * @param url The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeWebgltf(String url, ICesiumUrlResolver resolver) {
		String PropertyName = WebgltfPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(resolver.resolveUrl(url));
	}

	/**
	 *  
	Writes the <code>dae</code> property.  The <code>dae</code> property specifies the URL of a Collada model.
	
	

	 * @param resource A resource object describing the model.
	 */
	public final void writeDae(CesiumResource resource) {
		writeDae(resource.getUrl(), resource.getBehavior());
	}

	/**
	 *  
	Writes the <code>dae</code> property.  The <code>dae</code> property specifies the URL of a Collada model.
	
	
	

	 * @param url The URL of the model.
	 * @param resourceBehavior An enumeration describing how to include the model in the document. For even more control, use the overload that takes a ICesiumUrlResolver.
	 */
	public final void writeDae(String url, CesiumResourceBehavior resourceBehavior) {
		String PropertyName = DaePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(CesiumFormattingHelper.getResourceUrl(url, resourceBehavior));
	}

	/**
	 *  
	Writes the <code>dae</code> property.  The <code>dae</code> property specifies the URL of a Collada model.
	
	
	

	 * @param url The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeDae(String url, ICesiumUrlResolver resolver) {
		String PropertyName = DaePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(resolver.resolveUrl(url));
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Webgltf</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumResource> asWebgltf() {
		return m_asWebgltf.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumResource> createWebgltfAdaptor() {
		return new CesiumWriterAdaptor<ModelUriCesiumWriter, CesiumResource>(this, new CesiumWriterAdaptorWriteCallback<ModelUriCesiumWriter, CesiumResource>() {
			public void invoke(ModelUriCesiumWriter me, CesiumResource value) {
				me.writeWebgltf(value);
			}
		});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Dae</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumResource> asDae() {
		return m_asDae.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumResource> createDaeAdaptor() {
		return new CesiumWriterAdaptor<ModelUriCesiumWriter, CesiumResource>(this, new CesiumWriterAdaptorWriteCallback<ModelUriCesiumWriter, CesiumResource>() {
			public void invoke(ModelUriCesiumWriter me, CesiumResource value) {
				me.writeDae(value);
			}
		});
	}
}