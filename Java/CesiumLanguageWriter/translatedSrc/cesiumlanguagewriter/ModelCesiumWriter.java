package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.GltfUrlCesiumWriter;
import java.net.URI;
import java.util.List;

/**
 *  
 Writes a <code>Model</code> to a  {@link CesiumOutputStream}.  A <code>Model</code> a 3D model.
 

 */
public class ModelCesiumWriter extends CesiumPropertyWriter<ModelCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>scale</code> property.
	

	 */
	public static final String ScalePropertyName = "scale";
	/**
	 *  
	The name of the <code>gltf</code> property.
	

	 */
	public static final String GltfPropertyName = "gltf";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_scale = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ScalePropertyName);
		}
	}, false);
	private Lazy<GltfUrlCesiumWriter> m_gltf = new Lazy<cesiumlanguagewriter.GltfUrlCesiumWriter>(new Func1<cesiumlanguagewriter.GltfUrlCesiumWriter>() {
		public cesiumlanguagewriter.GltfUrlCesiumWriter invoke() {
			return new GltfUrlCesiumWriter(GltfPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ModelCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ModelCesiumWriter(ModelCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public ModelCesiumWriter clone() {
		return new ModelCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the model is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the model is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the model is shown.
	
	

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
	 *  Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>scale</code> property defines the scale of the model.
	

	 */
	public final DoubleCesiumWriter getScaleWriter() {
		return m_scale.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the model.
	

	 */
	public final DoubleCesiumWriter openScaleProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
	}

	/**
	 *  
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the model.
	
	

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
	Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the model.
	
	
	
	
	

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
	 *  Gets the writer for the <code>gltf</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>gltf</code> property defines the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	

	 */
	public final GltfUrlCesiumWriter getGltfWriter() {
		return m_gltf.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>gltf</code> property.  The <code>gltf</code> property defines the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	

	 */
	public final GltfUrlCesiumWriter openGltfProperty() {
		openIntervalIfNecessary();
		return this.<GltfUrlCesiumWriter> openAndReturn(getGltfWriter());
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	
	

	 * @param url The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeGltfProperty(String url, ICesiumUrlResolver resolver) {
		{
			cesiumlanguagewriter.GltfUrlCesiumWriter writer = openGltfProperty();
			try {
				writer.writeUri(url, resolver);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	
	

	 * @param url The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeGltfProperty(URI url, ICesiumUrlResolver resolver) {
		{
			cesiumlanguagewriter.GltfUrlCesiumWriter writer = openGltfProperty();
			try {
				writer.writeUri(url, resolver);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}