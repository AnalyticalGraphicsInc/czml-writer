package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorBlendModeCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.NodeTransformationsCesiumWriter;
import cesiumlanguagewriter.ShadowModeCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;

/**
 *  
 Writes a {@code Model} to a  {@link CesiumOutputStream}.  A {@code Model} is a 3D model.
 

 */
public class ModelCesiumWriter extends CesiumPropertyWriter<ModelCesiumWriter> {
    /**
    *  
    The name of the {@code show} property.
    

    */
    public static final String ShowPropertyName = "show";
    /**
    *  
    The name of the {@code gltf} property.
    

    */
    public static final String GltfPropertyName = "gltf";
    /**
    *  
    The name of the {@code scale} property.
    

    */
    public static final String ScalePropertyName = "scale";
    /**
    *  
    The name of the {@code minimumPixelSize} property.
    

    */
    public static final String MinimumPixelSizePropertyName = "minimumPixelSize";
    /**
    *  
    The name of the {@code maximumScale} property.
    

    */
    public static final String MaximumScalePropertyName = "maximumScale";
    /**
    *  
    The name of the {@code incrementallyLoadTextures} property.
    

    */
    public static final String IncrementallyLoadTexturesPropertyName = "incrementallyLoadTextures";
    /**
    *  
    The name of the {@code runAnimations} property.
    

    */
    public static final String RunAnimationsPropertyName = "runAnimations";
    /**
    *  
    The name of the {@code shadows} property.
    

    */
    public static final String ShadowsPropertyName = "shadows";
    /**
    *  
    The name of the {@code heightReference} property.
    

    */
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    *  
    The name of the {@code silhouetteColor} property.
    

    */
    public static final String SilhouetteColorPropertyName = "silhouetteColor";
    /**
    *  
    The name of the {@code silhouetteSize} property.
    

    */
    public static final String SilhouetteSizePropertyName = "silhouetteSize";
    /**
    *  
    The name of the {@code color} property.
    

    */
    public static final String ColorPropertyName = "color";
    /**
    *  
    The name of the {@code colorBlendMode} property.
    

    */
    public static final String ColorBlendModePropertyName = "colorBlendMode";
    /**
    *  
    The name of the {@code colorBlendAmount} property.
    

    */
    public static final String ColorBlendAmountPropertyName = "colorBlendAmount";
    /**
    *  
    The name of the {@code nodeTransformations} property.
    

    */
    public static final String NodeTransformationsPropertyName = "nodeTransformations";
    private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    private Lazy<UriCesiumWriter> m_gltf = new Lazy<cesiumlanguagewriter.UriCesiumWriter>(new Func1<cesiumlanguagewriter.UriCesiumWriter>() {
        public cesiumlanguagewriter.UriCesiumWriter invoke() {
            return new UriCesiumWriter(GltfPropertyName);
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
    private Lazy<DoubleCesiumWriter> m_maximumScale = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MaximumScalePropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_incrementallyLoadTextures = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(IncrementallyLoadTexturesPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_runAnimations = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(RunAnimationsPropertyName);
        }
    }, false);
    private Lazy<ShadowModeCesiumWriter> m_shadows = new Lazy<cesiumlanguagewriter.ShadowModeCesiumWriter>(new Func1<cesiumlanguagewriter.ShadowModeCesiumWriter>() {
        public cesiumlanguagewriter.ShadowModeCesiumWriter invoke() {
            return new ShadowModeCesiumWriter(ShadowsPropertyName);
        }
    }, false);
    private Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<cesiumlanguagewriter.HeightReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.HeightReferenceCesiumWriter>() {
        public cesiumlanguagewriter.HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_silhouetteColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(SilhouetteColorPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_silhouetteSize = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(SilhouetteSizePropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(ColorPropertyName);
        }
    }, false);
    private Lazy<ColorBlendModeCesiumWriter> m_colorBlendMode = new Lazy<cesiumlanguagewriter.ColorBlendModeCesiumWriter>(new Func1<cesiumlanguagewriter.ColorBlendModeCesiumWriter>() {
        public cesiumlanguagewriter.ColorBlendModeCesiumWriter invoke() {
            return new ColorBlendModeCesiumWriter(ColorBlendModePropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_colorBlendAmount = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ColorBlendAmountPropertyName);
        }
    }, false);
    private Lazy<NodeTransformationsCesiumWriter> m_nodeTransformations = new Lazy<cesiumlanguagewriter.NodeTransformationsCesiumWriter>(
            new Func1<cesiumlanguagewriter.NodeTransformationsCesiumWriter>() {
                public cesiumlanguagewriter.NodeTransformationsCesiumWriter invoke() {
                    return new NodeTransformationsCesiumWriter(NodeTransformationsPropertyName);
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
    *  Gets the writer for the {@code show} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code show} property defines whether or not the model is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code show} property.  The {@code show} property defines whether or not the model is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code boolean} value.  The {@code show} property specifies whether or not the model is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the model is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the model is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the model is shown.  If not specified, the default value is {@code true}.
    
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the model is shown.  If not specified, the default value is {@code true}.
    
    
    

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
    *  Gets the writer for the {@code gltf} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code gltf} property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    

    */
    public final UriCesiumWriter getGltfWriter() {
        return m_gltf.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code gltf} property.  The {@code gltf} property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    

    */
    public final UriCesiumWriter openGltfProperty() {
        openIntervalIfNecessary();
        return this.<UriCesiumWriter> openAndReturn(getGltfWriter());
    }

    /**
    *  
    Writes a value for the {@code gltf} property as a {@code uri} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    

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
    Writes a value for the {@code gltf} property as a {@code uri} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeGltfProperty(URI uri, CesiumResourceBehavior resourceBehavior) {
        {
            cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
            try {
                writer.writeUri(uri, resourceBehavior);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gltf} property as a {@code uri} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeGltfProperty(String uri, CesiumResourceBehavior resourceBehavior) {
        {
            cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
            try {
                writer.writeUri(uri, resourceBehavior);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gltf} property as a {@code uri} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    
    

    * @param uri The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeGltfProperty(URI uri, ICesiumUriResolver resolver) {
        {
            cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
            try {
                writer.writeUri(uri, resolver);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gltf} property as a {@code uri} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    
    

    * @param uri The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeGltfProperty(String uri, ICesiumUriResolver resolver) {
        {
            cesiumlanguagewriter.UriCesiumWriter writer = openGltfProperty();
            try {
                writer.writeUri(uri, resolver);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gltf} property as a {@code uri} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    

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
    Writes a value for the {@code gltf} property as a {@code uri} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    
    

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
    Writes a value for the {@code gltf} property as a {@code reference} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    

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
    Writes a value for the {@code gltf} property as a {@code reference} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    

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
    Writes a value for the {@code gltf} property as a {@code reference} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    
    

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
    Writes a value for the {@code gltf} property as a {@code reference} value.  The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
    
    
    

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

    /**
    *  Gets the writer for the {@code scale} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code scale} property defines the scale of the model.
    

    */
    public final DoubleCesiumWriter getScaleWriter() {
        return m_scale.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code scale} property.  The {@code scale} property defines the scale of the model.
    

    */
    public final DoubleCesiumWriter openScaleProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code number} value.  The {@code scale} property specifies the scale of the model.
    
    

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
    Writes a value for the {@code scale} property as a {@code number} value.  The {@code scale} property specifies the scale of the model.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code number} value.  The {@code scale} property specifies the scale of the model.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
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
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the model.
    
    

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
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the model.
    
    

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
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the model.
    
    
    

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
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the model.
    
    
    

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
    *  Gets the writer for the {@code minimumPixelSize} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code minimumPixelSize} property defines the approximate minimum pixel size of the model regardless of zoom.
    

    */
    public final DoubleCesiumWriter getMinimumPixelSizeWriter() {
        return m_minimumPixelSize.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code minimumPixelSize} property.  The {@code minimumPixelSize} property defines the approximate minimum pixel size of the model regardless of zoom.
    

    */
    public final DoubleCesiumWriter openMinimumPixelSizeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMinimumPixelSizeWriter());
    }

    /**
    *  
    Writes a value for the {@code minimumPixelSize} property as a {@code number} value.  The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom.
    
    

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
    Writes a value for the {@code minimumPixelSize} property as a {@code number} value.  The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMinimumPixelSizeProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMinimumPixelSizeProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code minimumPixelSize} property as a {@code number} value.  The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
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
    Writes a value for the {@code minimumPixelSize} property as a {@code reference} value.  The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom.
    
    

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
    Writes a value for the {@code minimumPixelSize} property as a {@code reference} value.  The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom.
    
    

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
    Writes a value for the {@code minimumPixelSize} property as a {@code reference} value.  The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom.
    
    
    

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
    Writes a value for the {@code minimumPixelSize} property as a {@code reference} value.  The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom.
    
    
    

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
    *  Gets the writer for the {@code maximumScale} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code maximumScale} property defines the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    

    */
    public final DoubleCesiumWriter getMaximumScaleWriter() {
        return m_maximumScale.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code maximumScale} property.  The {@code maximumScale} property defines the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    

    */
    public final DoubleCesiumWriter openMaximumScaleProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMaximumScaleWriter());
    }

    /**
    *  
    Writes a value for the {@code maximumScale} property as a {@code number} value.  The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    
    

    * @param value The value.
    */
    public final void writeMaximumScaleProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMaximumScaleProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code maximumScale} property as a {@code number} value.  The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMaximumScaleProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMaximumScaleProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code maximumScale} property as a {@code number} value.  The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMaximumScaleProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMaximumScaleProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code maximumScale} property as a {@code reference} value.  The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    
    

    * @param value The reference.
    */
    public final void writeMaximumScalePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMaximumScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code maximumScale} property as a {@code reference} value.  The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeMaximumScalePropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMaximumScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code maximumScale} property as a {@code reference} value.  The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMaximumScalePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMaximumScaleProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code maximumScale} property as a {@code reference} value.  The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMaximumScalePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openMaximumScaleProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code incrementallyLoadTextures} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code incrementallyLoadTextures} property defines whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getIncrementallyLoadTexturesWriter() {
        return m_incrementallyLoadTextures.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code incrementallyLoadTextures} property.  The {@code incrementallyLoadTextures} property defines whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openIncrementallyLoadTexturesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getIncrementallyLoadTexturesWriter());
    }

    /**
    *  
    Writes a value for the {@code incrementallyLoadTextures} property as a {@code boolean} value.  The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is {@code true}.
    
    

    * @param value The value.
    */
    public final void writeIncrementallyLoadTexturesProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openIncrementallyLoadTexturesProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value.  The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is {@code true}.
    
    

    * @param value The reference.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openIncrementallyLoadTexturesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value.  The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is {@code true}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openIncrementallyLoadTexturesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value.  The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openIncrementallyLoadTexturesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value.  The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openIncrementallyLoadTexturesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code runAnimations} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code runAnimations} property defines whether or not to run all animations defined in the glTF model.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getRunAnimationsWriter() {
        return m_runAnimations.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code runAnimations} property.  The {@code runAnimations} property defines whether or not to run all animations defined in the glTF model.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openRunAnimationsProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getRunAnimationsWriter());
    }

    /**
    *  
    Writes a value for the {@code runAnimations} property as a {@code boolean} value.  The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is {@code true}.
    
    

    * @param value The value.
    */
    public final void writeRunAnimationsProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openRunAnimationsProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code runAnimations} property as a {@code reference} value.  The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is {@code true}.
    
    

    * @param value The reference.
    */
    public final void writeRunAnimationsPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openRunAnimationsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code runAnimations} property as a {@code reference} value.  The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is {@code true}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeRunAnimationsPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openRunAnimationsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code runAnimations} property as a {@code reference} value.  The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRunAnimationsPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openRunAnimationsProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code runAnimations} property as a {@code reference} value.  The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRunAnimationsPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openRunAnimationsProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code shadows} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code shadows} property defines whether or not the model casts or receives shadows.  If not specified, the default value is ENABLED.
    

    */
    public final ShadowModeCesiumWriter getShadowsWriter() {
        return m_shadows.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code shadows} property.  The {@code shadows} property defines whether or not the model casts or receives shadows.  If not specified, the default value is ENABLED.
    

    */
    public final ShadowModeCesiumWriter openShadowsProperty() {
        openIntervalIfNecessary();
        return this.<ShadowModeCesiumWriter> openAndReturn(getShadowsWriter());
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code shadowMode} value.  The {@code shadows} property specifies whether or not the model casts or receives shadows.  If not specified, the default value is ENABLED.
    
    

    * @param value The shadow mode.
    */
    public final void writeShadowsProperty(CesiumShadowMode value) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeShadowMode(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the model casts or receives shadows.  If not specified, the default value is ENABLED.
    
    

    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the model casts or receives shadows.  If not specified, the default value is ENABLED.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShadowsPropertyReference(String value) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the model casts or receives shadows.  If not specified, the default value is ENABLED.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the model casts or receives shadows.  If not specified, the default value is ENABLED.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code heightReference} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code heightReference} property defines the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    

    */
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code heightReference} property.  The {@code heightReference} property defines the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    

    */
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code heightReference} value.  The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

    * @param value The height reference.
    */
    public final void writeHeightReferenceProperty(CesiumHeightReference value) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeHeightReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeHeightReferencePropertyReference(String value) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code silhouetteColor} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code silhouetteColor} property defines the color of the silhouette drawn around the model.
    

    */
    public final ColorCesiumWriter getSilhouetteColorWriter() {
        return m_silhouetteColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code silhouetteColor} property.  The {@code silhouetteColor} property defines the color of the silhouette drawn around the model.
    

    */
    public final ColorCesiumWriter openSilhouetteColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getSilhouetteColorWriter());
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgba} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    

    * @param color The color.
    */
    public final void writeSilhouetteColorProperty(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgba} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeSilhouetteColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgba} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSilhouetteColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgba} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSilhouetteColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    

    * @param color The color.
    */
    public final void writeSilhouetteColorPropertyRgbaf(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeSilhouetteColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSilhouetteColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSilhouetteColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code reference} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    

    * @param value The reference.
    */
    public final void writeSilhouetteColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code reference} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeSilhouetteColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code reference} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSilhouetteColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteColor} property as a {@code reference} value.  The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSilhouetteColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openSilhouetteColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code silhouetteSize} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code silhouetteSize} property defines the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    

    */
    public final DoubleCesiumWriter getSilhouetteSizeWriter() {
        return m_silhouetteSize.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code silhouetteSize} property.  The {@code silhouetteSize} property defines the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    

    */
    public final DoubleCesiumWriter openSilhouetteSizeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getSilhouetteSizeWriter());
    }

    /**
    *  
    Writes a value for the {@code silhouetteSize} property as a {@code number} value.  The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    
    

    * @param value The value.
    */
    public final void writeSilhouetteSizeProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSilhouetteSizeProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteSize} property as a {@code number} value.  The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSilhouetteSizeProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSilhouetteSizeProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteSize} property as a {@code number} value.  The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSilhouetteSizeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSilhouetteSizeProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteSize} property as a {@code reference} value.  The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    
    

    * @param value The reference.
    */
    public final void writeSilhouetteSizePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSilhouetteSizeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteSize} property as a {@code reference} value.  The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeSilhouetteSizePropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSilhouetteSizeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteSize} property as a {@code reference} value.  The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSilhouetteSizePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSilhouetteSizeProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code silhouetteSize} property as a {@code reference} value.  The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model.  If not specified, the default value is 0.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSilhouetteSizePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSilhouetteSizeProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code color} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code color} property defines the color to blend with the model's rendered color.
    

    */
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code color} property.  The {@code color} property defines the color to blend with the model's rendered color.
    

    */
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    

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
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    
    
    

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
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
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
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    

    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    
    
    

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
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    

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
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    

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
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    

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
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color to blend with the model's rendered color.
    
    
    

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
    *  Gets the writer for the {@code colorBlendMode} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code colorBlendMode} property defines the mode to use for blending between {@code color} and the model's color.  If not specified, the default value is HIGHLIGHT.
    

    */
    public final ColorBlendModeCesiumWriter getColorBlendModeWriter() {
        return m_colorBlendMode.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code colorBlendMode} property.  The {@code colorBlendMode} property defines the mode to use for blending between {@code color} and the model's color.  If not specified, the default value is HIGHLIGHT.
    

    */
    public final ColorBlendModeCesiumWriter openColorBlendModeProperty() {
        openIntervalIfNecessary();
        return this.<ColorBlendModeCesiumWriter> openAndReturn(getColorBlendModeWriter());
    }

    /**
    *  
    Writes a value for the {@code colorBlendMode} property as a {@code colorBlendMode} value.  The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color.  If not specified, the default value is HIGHLIGHT.
    
    

    * @param value The blend mode.
    */
    public final void writeColorBlendModeProperty(CesiumColorBlendMode value) {
        {
            cesiumlanguagewriter.ColorBlendModeCesiumWriter writer = openColorBlendModeProperty();
            try {
                writer.writeColorBlendMode(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendMode} property as a {@code reference} value.  The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color.  If not specified, the default value is HIGHLIGHT.
    
    

    * @param value The reference.
    */
    public final void writeColorBlendModePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorBlendModeCesiumWriter writer = openColorBlendModeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendMode} property as a {@code reference} value.  The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color.  If not specified, the default value is HIGHLIGHT.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeColorBlendModePropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorBlendModeCesiumWriter writer = openColorBlendModeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendMode} property as a {@code reference} value.  The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color.  If not specified, the default value is HIGHLIGHT.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorBlendModePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorBlendModeCesiumWriter writer = openColorBlendModeProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendMode} property as a {@code reference} value.  The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color.  If not specified, the default value is HIGHLIGHT.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorBlendModePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorBlendModeCesiumWriter writer = openColorBlendModeProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code colorBlendAmount} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code colorBlendAmount} property defines the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    

    */
    public final DoubleCesiumWriter getColorBlendAmountWriter() {
        return m_colorBlendAmount.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code colorBlendAmount} property.  The {@code colorBlendAmount} property defines the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    

    */
    public final DoubleCesiumWriter openColorBlendAmountProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getColorBlendAmountWriter());
    }

    /**
    *  
    Writes a value for the {@code colorBlendAmount} property as a {@code number} value.  The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    
    

    * @param value The value.
    */
    public final void writeColorBlendAmountProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openColorBlendAmountProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendAmount} property as a {@code number} value.  The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorBlendAmountProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openColorBlendAmountProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendAmount} property as a {@code number} value.  The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorBlendAmountProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openColorBlendAmountProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendAmount} property as a {@code reference} value.  The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    
    

    * @param value The reference.
    */
    public final void writeColorBlendAmountPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openColorBlendAmountProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendAmount} property as a {@code reference} value.  The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeColorBlendAmountPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openColorBlendAmountProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendAmount} property as a {@code reference} value.  The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorBlendAmountPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openColorBlendAmountProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code colorBlendAmount} property as a {@code reference} value.  The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.  If not specified, the default value is 0.5.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorBlendAmountPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openColorBlendAmountProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code nodeTransformations} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code nodeTransformations} property defines a mapping of node names to node transformations.
    

    */
    public final NodeTransformationsCesiumWriter getNodeTransformationsWriter() {
        return m_nodeTransformations.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code nodeTransformations} property.  The {@code nodeTransformations} property defines a mapping of node names to node transformations.
    

    */
    public final NodeTransformationsCesiumWriter openNodeTransformationsProperty() {
        openIntervalIfNecessary();
        return this.<NodeTransformationsCesiumWriter> openAndReturn(getNodeTransformationsWriter());
    }
}