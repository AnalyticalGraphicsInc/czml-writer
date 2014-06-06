package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import java.awt.image.RenderedImage;
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
	The name of the <code>minimumPixelSize</code> property.
	

	 */
	public static final String MinimumPixelSizePropertyName = "minimumPixelSize";
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
	private Lazy<DoubleCesiumWriter> m_minimumPixelSize = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(MinimumPixelSizePropertyName);
		}
	}, false);
	private Lazy<UriCesiumWriter> m_gltf = new Lazy<cesiumlanguagewriter.UriCesiumWriter>(new Func1<cesiumlanguagewriter.UriCesiumWriter>() {
		public cesiumlanguagewriter.UriCesiumWriter invoke() {
			return new UriCesiumWriter(GltfPropertyName);
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
	 *  
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
	
	

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
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
	
	

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
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
	
	
	

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
	Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
	
	
	

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
	 *  Gets the writer for the <code>minimumPixelSize</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>minimumPixelSize</code> property defines the approximate minimum pixel size of the model regardless of zoom.
	

	 */
	public final DoubleCesiumWriter getMinimumPixelSizeWriter() {
		return m_minimumPixelSize.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>minimumPixelSize</code> property.  The <code>minimumPixelSize</code> property defines the approximate minimum pixel size of the model regardless of zoom.
	

	 */
	public final DoubleCesiumWriter openMinimumPixelSizeProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getMinimumPixelSizeWriter());
	}

	/**
	 *  
	Writes a value for the <code>minimumPixelSize</code> property as a <code>number</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
	
	

	 * @param value The value.
	 */
	public final void writeMinimumPixelSizeProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMinimumPixelSizeProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>minimumPixelSize</code> property as a <code>number</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeMinimumPixelSizeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMinimumPixelSizeProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
	
	

	 * @param value The reference.
	 */
	public final void writeMinimumPixelSizePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMinimumPixelSizeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeMinimumPixelSizePropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMinimumPixelSizeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeMinimumPixelSizePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMinimumPixelSizeProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeMinimumPixelSizePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMinimumPixelSizeProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>gltf</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>gltf</code> property defines the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	

	 */
	public final UriCesiumWriter getGltfWriter() {
		return m_gltf.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>gltf</code> property.  The <code>gltf</code> property defines the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	

	 */
	public final UriCesiumWriter openGltfProperty() {
		openIntervalIfNecessary();
		return this.<UriCesiumWriter> openAndReturn(getGltfWriter());
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	

	 * @param resource A resource object describing external data.
	 */
	public final void writeGltfProperty(CesiumResource resource) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeUri(resource);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	
	

	 * @param url The URL of the data.
	 * @param resourceBehavior An enumeration describing how to include the URL in the document. For even more control, use the overload that takes a ICesiumUrlResolver.
	 */
	public final void writeGltfProperty(String url, CesiumResourceBehavior resourceBehavior) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeUri(url, resourceBehavior);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	
	

	 * @param url The URL of the data.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeGltfProperty(String url, ICesiumUrlResolver resolver) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
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
	
	

	 * @param image The image.  A data URI will be created for this image, using PNG encoding.
	 */
	public final void writeGltfProperty(RenderedImage image) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeUri(image);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	
	

	 * @param image The image.  A data URI will be created for this image.
	 * @param imageFormat The image format to use to encode the image in the data URI.
	 */
	public final void writeGltfProperty(RenderedImage image, CesiumImageFormat imageFormat) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeUri(image, imageFormat);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	

	 * @param value The reference.
	 */
	public final void writeGltfPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeGltfPropertyReference(String value) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeGltfPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URL of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeGltfPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}