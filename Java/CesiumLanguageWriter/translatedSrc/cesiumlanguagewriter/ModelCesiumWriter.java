package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ArticulationsCesiumWriter;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorBlendModeCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.NodeTransformationsCesiumWriter;
import cesiumlanguagewriter.ShadowModeCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Model} to a {@link CesiumOutputStream}. A {@code Model} is a 3D model.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class ModelCesiumWriter extends CesiumPropertyWriter<ModelCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code gltf} property.
    */
    @Nonnull
    public static final String GltfPropertyName = "gltf";
    /**
    * The name of the {@code scale} property.
    */
    @Nonnull
    public static final String ScalePropertyName = "scale";
    /**
    * The name of the {@code minimumPixelSize} property.
    */
    @Nonnull
    public static final String MinimumPixelSizePropertyName = "minimumPixelSize";
    /**
    * The name of the {@code maximumScale} property.
    */
    @Nonnull
    public static final String MaximumScalePropertyName = "maximumScale";
    /**
    * The name of the {@code incrementallyLoadTextures} property.
    */
    @Nonnull
    public static final String IncrementallyLoadTexturesPropertyName = "incrementallyLoadTextures";
    /**
    * The name of the {@code runAnimations} property.
    */
    @Nonnull
    public static final String RunAnimationsPropertyName = "runAnimations";
    /**
    * The name of the {@code shadows} property.
    */
    @Nonnull
    public static final String ShadowsPropertyName = "shadows";
    /**
    * The name of the {@code heightReference} property.
    */
    @Nonnull
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    * The name of the {@code silhouetteColor} property.
    */
    @Nonnull
    public static final String SilhouetteColorPropertyName = "silhouetteColor";
    /**
    * The name of the {@code silhouetteSize} property.
    */
    @Nonnull
    public static final String SilhouetteSizePropertyName = "silhouetteSize";
    /**
    * The name of the {@code color} property.
    */
    @Nonnull
    public static final String ColorPropertyName = "color";
    /**
    * The name of the {@code colorBlendMode} property.
    */
    @Nonnull
    public static final String ColorBlendModePropertyName = "colorBlendMode";
    /**
    * The name of the {@code colorBlendAmount} property.
    */
    @Nonnull
    public static final String ColorBlendAmountPropertyName = "colorBlendAmount";
    /**
    * The name of the {@code distanceDisplayCondition} property.
    */
    @Nonnull
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    /**
    * The name of the {@code nodeTransformations} property.
    */
    @Nonnull
    public static final String NodeTransformationsPropertyName = "nodeTransformations";
    /**
    * The name of the {@code articulations} property.
    */
    @Nonnull
    public static final String ArticulationsPropertyName = "articulations";
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<UriCesiumWriter> m_gltf = new Lazy<UriCesiumWriter>(new Func1<UriCesiumWriter>() {
        public UriCesiumWriter invoke() {
            return new UriCesiumWriter(GltfPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ScalePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_minimumPixelSize = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MinimumPixelSizePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_maximumScale = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MaximumScalePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_incrementallyLoadTextures = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(IncrementallyLoadTexturesPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_runAnimations = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(RunAnimationsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ShadowModeCesiumWriter> m_shadows = new Lazy<ShadowModeCesiumWriter>(new Func1<ShadowModeCesiumWriter>() {
        public ShadowModeCesiumWriter invoke() {
            return new ShadowModeCesiumWriter(ShadowsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<HeightReferenceCesiumWriter>(new Func1<HeightReferenceCesiumWriter>() {
        public HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_silhouetteColor = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(SilhouetteColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_silhouetteSize = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(SilhouetteSizePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(ColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorBlendModeCesiumWriter> m_colorBlendMode = new Lazy<ColorBlendModeCesiumWriter>(new Func1<ColorBlendModeCesiumWriter>() {
        public ColorBlendModeCesiumWriter invoke() {
            return new ColorBlendModeCesiumWriter(ColorBlendModePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_colorBlendAmount = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ColorBlendAmountPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DistanceDisplayConditionCesiumWriter> m_distanceDisplayCondition = new Lazy<DistanceDisplayConditionCesiumWriter>(new Func1<DistanceDisplayConditionCesiumWriter>() {
        public DistanceDisplayConditionCesiumWriter invoke() {
            return new DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<NodeTransformationsCesiumWriter> m_nodeTransformations = new Lazy<NodeTransformationsCesiumWriter>(new Func1<NodeTransformationsCesiumWriter>() {
        public NodeTransformationsCesiumWriter invoke() {
            return new NodeTransformationsCesiumWriter(NodeTransformationsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ArticulationsCesiumWriter> m_articulations = new Lazy<ArticulationsCesiumWriter>(new Func1<ArticulationsCesiumWriter>() {
        public ArticulationsCesiumWriter invoke() {
            return new ArticulationsCesiumWriter(ArticulationsPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ModelCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ModelCesiumWriter(@Nonnull ModelCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ModelCesiumWriter clone() {
        return new ModelCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the model is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the model is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the model is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the model is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the model is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the model is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the model is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code gltf} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code gltf} property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final UriCesiumWriter getGltfWriter() {
        return m_gltf.getValue();
    }

    /**
    * Opens and returns the writer for the {@code gltf} property. The {@code gltf} property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final UriCesiumWriter openGltfProperty() {
        openIntervalIfNecessary();
        return this.<UriCesiumWriter> openAndReturn(getGltfWriter());
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code uri} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param resource A resource object describing external data.
    */
    public final void writeGltfProperty(CesiumResource resource) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(resource);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code uri} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeGltfProperty(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resourceBehavior);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code uri} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeGltfProperty(String uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resourceBehavior);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code uri} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeGltfProperty(URI uri, ICesiumUriResolver resolver) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resolver);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code uri} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeGltfProperty(String uri, ICesiumUriResolver resolver) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resolver);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code uri} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param image The image. A data URI will be created for this image, using PNG encoding.
    */
    public final void writeGltfProperty(RenderedImage image) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(image);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code uri} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param image The image. A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    public final void writeGltfProperty(RenderedImage image, @Nonnull CesiumImageFormat imageFormat) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(image, imageFormat);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code reference} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeGltfPropertyReference(Reference value) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code reference} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeGltfPropertyReference(String value) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code reference} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeGltfPropertyReference(String identifier, String propertyName) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code gltf} property as a {@code reference} value. The {@code gltf} property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeGltfPropertyReference(String identifier, String[] propertyNames) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openGltfProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code scale} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code scale} property defines the scale of the model. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getScaleWriter() {
        return m_scale.getValue();
    }

    /**
    * Opens and returns the writer for the {@code scale} property. The {@code scale} property defines the scale of the model. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openScaleProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the model. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeScaleProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the model. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the model. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the model. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeScalePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the model. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeScalePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the model. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the model. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code minimumPixelSize} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code minimumPixelSize} property defines the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getMinimumPixelSizeWriter() {
        return m_minimumPixelSize.getValue();
    }

    /**
    * Opens and returns the writer for the {@code minimumPixelSize} property. The {@code minimumPixelSize} property defines the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openMinimumPixelSizeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMinimumPixelSizeWriter());
    }

    /**
    * Writes a value for the {@code minimumPixelSize} property as a {@code number} value. The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeMinimumPixelSizeProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumPixelSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code minimumPixelSize} property as a {@code number} value. The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMinimumPixelSizeProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumPixelSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code minimumPixelSize} property as a {@code number} value. The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMinimumPixelSizeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumPixelSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code minimumPixelSize} property as a {@code reference} value. The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumPixelSizePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumPixelSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumPixelSize} property as a {@code reference} value. The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumPixelSizePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumPixelSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumPixelSize} property as a {@code reference} value. The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMinimumPixelSizePropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumPixelSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code minimumPixelSize} property as a {@code reference} value. The {@code minimumPixelSize} property specifies the approximate minimum pixel size of the model regardless of zoom. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMinimumPixelSizePropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumPixelSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code maximumScale} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code maximumScale} property defines the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    */
    @Nonnull
    public final DoubleCesiumWriter getMaximumScaleWriter() {
        return m_maximumScale.getValue();
    }

    /**
    * Opens and returns the writer for the {@code maximumScale} property. The {@code maximumScale} property defines the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    */
    @Nonnull
    public final DoubleCesiumWriter openMaximumScaleProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMaximumScaleWriter());
    }

    /**
    * Writes a value for the {@code maximumScale} property as a {@code number} value. The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    * @param value The value.
    */
    public final void writeMaximumScaleProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code maximumScale} property as a {@code number} value. The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMaximumScaleProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code maximumScale} property as a {@code number} value. The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMaximumScaleProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code maximumScale} property as a {@code reference} value. The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    * @param value The reference.
    */
    public final void writeMaximumScalePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumScale} property as a {@code reference} value. The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    * @param value The reference.
    */
    public final void writeMaximumScalePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumScale} property as a {@code reference} value. The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMaximumScalePropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code maximumScale} property as a {@code reference} value. The {@code maximumScale} property specifies the maximum scale size of the model. This is used as an upper limit for {@code minimumPixelSize}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMaximumScalePropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code incrementallyLoadTextures} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code incrementallyLoadTextures} property defines whether or not the model can be rendered before all textures have loaded. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getIncrementallyLoadTexturesWriter() {
        return m_incrementallyLoadTextures.getValue();
    }

    /**
    * Opens and returns the writer for the {@code incrementallyLoadTextures} property. The {@code incrementallyLoadTextures} property defines whether or not the model can be rendered before all textures have loaded. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openIncrementallyLoadTexturesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getIncrementallyLoadTexturesWriter());
    }

    /**
    * Writes a value for the {@code incrementallyLoadTextures} property as a {@code boolean} value. The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeIncrementallyLoadTexturesProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openIncrementallyLoadTexturesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value. The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openIncrementallyLoadTexturesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value. The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openIncrementallyLoadTexturesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value. The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openIncrementallyLoadTexturesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code incrementallyLoadTextures} property as a {@code reference} value. The {@code incrementallyLoadTextures} property specifies whether or not the model can be rendered before all textures have loaded. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeIncrementallyLoadTexturesPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openIncrementallyLoadTexturesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code runAnimations} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code runAnimations} property defines whether or not to run all animations defined in the glTF model. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getRunAnimationsWriter() {
        return m_runAnimations.getValue();
    }

    /**
    * Opens and returns the writer for the {@code runAnimations} property. The {@code runAnimations} property defines whether or not to run all animations defined in the glTF model. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openRunAnimationsProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getRunAnimationsWriter());
    }

    /**
    * Writes a value for the {@code runAnimations} property as a {@code boolean} value. The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeRunAnimationsProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openRunAnimationsProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code runAnimations} property as a {@code reference} value. The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeRunAnimationsPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openRunAnimationsProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code runAnimations} property as a {@code reference} value. The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeRunAnimationsPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openRunAnimationsProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code runAnimations} property as a {@code reference} value. The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRunAnimationsPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openRunAnimationsProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code runAnimations} property as a {@code reference} value. The {@code runAnimations} property specifies whether or not to run all animations defined in the glTF model. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRunAnimationsPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openRunAnimationsProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code shadows} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code shadows} property defines whether or not the model casts or receives shadows. If not specified, the default value is ENABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter getShadowsWriter() {
        return m_shadows.getValue();
    }

    /**
    * Opens and returns the writer for the {@code shadows} property. The {@code shadows} property defines whether or not the model casts or receives shadows. If not specified, the default value is ENABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter openShadowsProperty() {
        openIntervalIfNecessary();
        return this.<ShadowModeCesiumWriter> openAndReturn(getShadowsWriter());
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code shadowMode} value. The {@code shadows} property specifies whether or not the model casts or receives shadows. If not specified, the default value is ENABLED.
    * @param value The shadow mode.
    */
    public final void writeShadowsProperty(@Nonnull CesiumShadowMode value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeShadowMode(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the model casts or receives shadows. If not specified, the default value is ENABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(Reference value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the model casts or receives shadows. If not specified, the default value is ENABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(String value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the model casts or receives shadows. If not specified, the default value is ENABLED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String propertyName) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the model casts or receives shadows. If not specified, the default value is ENABLED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code heightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code heightReference} property defines the height reference of the model, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code heightReference} property. The {@code heightReference} property defines the height reference of the model, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code heightReference} value. The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The height reference.
    */
    public final void writeHeightReferenceProperty(@Nonnull CesiumHeightReference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeHeightReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(Reference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(String value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String propertyName) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the model, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String[] propertyNames) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code silhouetteColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code silhouetteColor} property defines the color of the silhouette drawn around the model. If not specified, the default value is red.
    */
    @Nonnull
    public final ColorCesiumWriter getSilhouetteColorWriter() {
        return m_silhouetteColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code silhouetteColor} property. The {@code silhouetteColor} property defines the color of the silhouette drawn around the model. If not specified, the default value is red.
    */
    @Nonnull
    public final ColorCesiumWriter openSilhouetteColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getSilhouetteColorWriter());
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgba} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param color The color.
    */
    public final void writeSilhouetteColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgba} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeSilhouetteColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgba} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSilhouetteColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgba} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSilhouetteColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param color The color.
    */
    public final void writeSilhouetteColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeSilhouetteColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSilhouetteColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code rgbaf} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSilhouetteColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code reference} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param value The reference.
    */
    public final void writeSilhouetteColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code reference} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param value The reference.
    */
    public final void writeSilhouetteColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code reference} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSilhouetteColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code silhouetteColor} property as a {@code reference} value. The {@code silhouetteColor} property specifies the color of the silhouette drawn around the model. If not specified, the default value is red.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSilhouetteColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openSilhouetteColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code silhouetteSize} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code silhouetteSize} property defines the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getSilhouetteSizeWriter() {
        return m_silhouetteSize.getValue();
    }

    /**
    * Opens and returns the writer for the {@code silhouetteSize} property. The {@code silhouetteSize} property defines the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openSilhouetteSizeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getSilhouetteSizeWriter());
    }

    /**
    * Writes a value for the {@code silhouetteSize} property as a {@code number} value. The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeSilhouetteSizeProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openSilhouetteSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code silhouetteSize} property as a {@code number} value. The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSilhouetteSizeProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openSilhouetteSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code silhouetteSize} property as a {@code number} value. The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSilhouetteSizeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openSilhouetteSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code silhouetteSize} property as a {@code reference} value. The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeSilhouetteSizePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openSilhouetteSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code silhouetteSize} property as a {@code reference} value. The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeSilhouetteSizePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openSilhouetteSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code silhouetteSize} property as a {@code reference} value. The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSilhouetteSizePropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openSilhouetteSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code silhouetteSize} property as a {@code reference} value. The {@code silhouetteSize} property specifies the size, in pixels, of the silhouette drawn around the model. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSilhouetteSizePropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openSilhouetteSizeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code color} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code color} property defines the color to blend with the model's rendered color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    * Opens and returns the writer for the {@code color} property. The {@code color} property defines the color to blend with the model's rendered color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color to blend with the model's rendered color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code colorBlendMode} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code colorBlendMode} property defines the mode to use for blending between {@code color} and the model's color. If not specified, the default value is HIGHLIGHT.
    */
    @Nonnull
    public final ColorBlendModeCesiumWriter getColorBlendModeWriter() {
        return m_colorBlendMode.getValue();
    }

    /**
    * Opens and returns the writer for the {@code colorBlendMode} property. The {@code colorBlendMode} property defines the mode to use for blending between {@code color} and the model's color. If not specified, the default value is HIGHLIGHT.
    */
    @Nonnull
    public final ColorBlendModeCesiumWriter openColorBlendModeProperty() {
        openIntervalIfNecessary();
        return this.<ColorBlendModeCesiumWriter> openAndReturn(getColorBlendModeWriter());
    }

    /**
    * Writes a value for the {@code colorBlendMode} property as a {@code colorBlendMode} value. The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color. If not specified, the default value is HIGHLIGHT.
    * @param value The blend mode.
    */
    public final void writeColorBlendModeProperty(@Nonnull CesiumColorBlendMode value) {
        try (Using<ColorBlendModeCesiumWriter> using$0 = new Using<ColorBlendModeCesiumWriter>(openColorBlendModeProperty())) {
            final ColorBlendModeCesiumWriter writer = using$0.resource;
            writer.writeColorBlendMode(value);
        }
    }

    /**
    * Writes a value for the {@code colorBlendMode} property as a {@code reference} value. The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color. If not specified, the default value is HIGHLIGHT.
    * @param value The reference.
    */
    public final void writeColorBlendModePropertyReference(Reference value) {
        try (Using<ColorBlendModeCesiumWriter> using$0 = new Using<ColorBlendModeCesiumWriter>(openColorBlendModeProperty())) {
            final ColorBlendModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code colorBlendMode} property as a {@code reference} value. The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color. If not specified, the default value is HIGHLIGHT.
    * @param value The reference.
    */
    public final void writeColorBlendModePropertyReference(String value) {
        try (Using<ColorBlendModeCesiumWriter> using$0 = new Using<ColorBlendModeCesiumWriter>(openColorBlendModeProperty())) {
            final ColorBlendModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code colorBlendMode} property as a {@code reference} value. The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color. If not specified, the default value is HIGHLIGHT.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorBlendModePropertyReference(String identifier, String propertyName) {
        try (Using<ColorBlendModeCesiumWriter> using$0 = new Using<ColorBlendModeCesiumWriter>(openColorBlendModeProperty())) {
            final ColorBlendModeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code colorBlendMode} property as a {@code reference} value. The {@code colorBlendMode} property specifies the mode to use for blending between {@code color} and the model's color. If not specified, the default value is HIGHLIGHT.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorBlendModePropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorBlendModeCesiumWriter> using$0 = new Using<ColorBlendModeCesiumWriter>(openColorBlendModeProperty())) {
            final ColorBlendModeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code colorBlendAmount} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code colorBlendAmount} property defines the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    */
    @Nonnull
    public final DoubleCesiumWriter getColorBlendAmountWriter() {
        return m_colorBlendAmount.getValue();
    }

    /**
    * Opens and returns the writer for the {@code colorBlendAmount} property. The {@code colorBlendAmount} property defines the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    */
    @Nonnull
    public final DoubleCesiumWriter openColorBlendAmountProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getColorBlendAmountWriter());
    }

    /**
    * Writes a value for the {@code colorBlendAmount} property as a {@code number} value. The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    * @param value The value.
    */
    public final void writeColorBlendAmountProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openColorBlendAmountProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code colorBlendAmount} property as a {@code number} value. The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorBlendAmountProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openColorBlendAmountProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code colorBlendAmount} property as a {@code number} value. The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorBlendAmountProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openColorBlendAmountProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code colorBlendAmount} property as a {@code reference} value. The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    * @param value The reference.
    */
    public final void writeColorBlendAmountPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openColorBlendAmountProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code colorBlendAmount} property as a {@code reference} value. The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    * @param value The reference.
    */
    public final void writeColorBlendAmountPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openColorBlendAmountProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code colorBlendAmount} property as a {@code reference} value. The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorBlendAmountPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openColorBlendAmountProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code colorBlendAmount} property as a {@code reference} value. The {@code colorBlendAmount} property specifies the color strength when {@code colorBlendMode} is {@code MIX}. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two. If not specified, the default value is 0.5.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorBlendAmountPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openColorBlendAmountProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code distanceDisplayCondition} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this model will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    * Opens and returns the writer for the {@code distanceDisplayCondition} property. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this model will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param value The value.
    */
    public final void writeDistanceDisplayConditionProperty(@Nonnull Bounds value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeDistanceDisplayCondition(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param lowerBound The lower bound.
    * @param upperBound The upper bound.
    */
    public final void writeDistanceDisplayConditionProperty(double lowerBound, double upperBound) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeDistanceDisplayCondition(lowerBound, upperBound);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDistanceDisplayConditionProperty(List<JulianDate> dates, List<Bounds> values) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeDistanceDisplayCondition(dates, values);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDistanceDisplayConditionProperty(List<JulianDate> dates, List<Bounds> values, int startIndex, int length) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeDistanceDisplayCondition(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(Reference value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String propertyName) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this model will be displayed.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code nodeTransformations} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code nodeTransformations} property defines a mapping of node names to node transformations.
    */
    @Nonnull
    public final NodeTransformationsCesiumWriter getNodeTransformationsWriter() {
        return m_nodeTransformations.getValue();
    }

    /**
    * Opens and returns the writer for the {@code nodeTransformations} property. The {@code nodeTransformations} property defines a mapping of node names to node transformations.
    */
    @Nonnull
    public final NodeTransformationsCesiumWriter openNodeTransformationsProperty() {
        openIntervalIfNecessary();
        return this.<NodeTransformationsCesiumWriter> openAndReturn(getNodeTransformationsWriter());
    }

    /**
    * Gets the writer for the {@code articulations} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code articulations} property defines a mapping of keys to articulation values, where the keys are the name of the articulation, a single space, and the name of the stage.
    */
    @Nonnull
    public final ArticulationsCesiumWriter getArticulationsWriter() {
        return m_articulations.getValue();
    }

    /**
    * Opens and returns the writer for the {@code articulations} property. The {@code articulations} property defines a mapping of keys to articulation values, where the keys are the name of the articulation, a single space, and the name of the stage.
    */
    @Nonnull
    public final ArticulationsCesiumWriter openArticulationsProperty() {
        openIntervalIfNecessary();
        return this.<ArticulationsCesiumWriter> openAndReturn(getArticulationsWriter());
    }
}