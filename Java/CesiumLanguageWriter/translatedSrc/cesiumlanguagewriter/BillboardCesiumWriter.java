package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.AlignedAxisCesiumWriter;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.BoundingRectangleCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.EyeOffsetCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.HorizontalOriginCesiumWriter;
import cesiumlanguagewriter.NearFarScalarCesiumWriter;
import cesiumlanguagewriter.PixelOffsetCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import cesiumlanguagewriter.VerticalOriginCesiumWriter;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Billboard} to a {@link CesiumOutputStream}. A {@code Billboard} is a billboard, or viewport-aligned image. The billboard is positioned in the scene by the {@code position} property. A billboard is sometimes called a marker.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class BillboardCesiumWriter extends CesiumPropertyWriter<BillboardCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code image} property.
    */
    @Nonnull
    public static final String ImagePropertyName = "image";
    /**
    * The name of the {@code scale} property.
    */
    @Nonnull
    public static final String ScalePropertyName = "scale";
    /**
    * The name of the {@code pixelOffset} property.
    */
    @Nonnull
    public static final String PixelOffsetPropertyName = "pixelOffset";
    /**
    * The name of the {@code eyeOffset} property.
    */
    @Nonnull
    public static final String EyeOffsetPropertyName = "eyeOffset";
    /**
    * The name of the {@code horizontalOrigin} property.
    */
    @Nonnull
    public static final String HorizontalOriginPropertyName = "horizontalOrigin";
    /**
    * The name of the {@code verticalOrigin} property.
    */
    @Nonnull
    public static final String VerticalOriginPropertyName = "verticalOrigin";
    /**
    * The name of the {@code heightReference} property.
    */
    @Nonnull
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    * The name of the {@code color} property.
    */
    @Nonnull
    public static final String ColorPropertyName = "color";
    /**
    * The name of the {@code rotation} property.
    */
    @Nonnull
    public static final String RotationPropertyName = "rotation";
    /**
    * The name of the {@code alignedAxis} property.
    */
    @Nonnull
    public static final String AlignedAxisPropertyName = "alignedAxis";
    /**
    * The name of the {@code sizeInMeters} property.
    */
    @Nonnull
    public static final String SizeInMetersPropertyName = "sizeInMeters";
    /**
    * The name of the {@code width} property.
    */
    @Nonnull
    public static final String WidthPropertyName = "width";
    /**
    * The name of the {@code height} property.
    */
    @Nonnull
    public static final String HeightPropertyName = "height";
    /**
    * The name of the {@code scaleByDistance} property.
    */
    @Nonnull
    public static final String ScaleByDistancePropertyName = "scaleByDistance";
    /**
    * The name of the {@code translucencyByDistance} property.
    */
    @Nonnull
    public static final String TranslucencyByDistancePropertyName = "translucencyByDistance";
    /**
    * The name of the {@code pixelOffsetScaleByDistance} property.
    */
    @Nonnull
    public static final String PixelOffsetScaleByDistancePropertyName = "pixelOffsetScaleByDistance";
    /**
    * The name of the {@code imageSubRegion} property.
    */
    @Nonnull
    public static final String ImageSubRegionPropertyName = "imageSubRegion";
    /**
    * The name of the {@code distanceDisplayCondition} property.
    */
    @Nonnull
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    /**
    * The name of the {@code disableDepthTestDistance} property.
    */
    @Nonnull
    public static final String DisableDepthTestDistancePropertyName = "disableDepthTestDistance";
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<UriCesiumWriter> m_image = new Lazy<UriCesiumWriter>(new Func1<UriCesiumWriter>() {
        public UriCesiumWriter invoke() {
            return new UriCesiumWriter(ImagePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ScalePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<PixelOffsetCesiumWriter>(new Func1<PixelOffsetCesiumWriter>() {
        public PixelOffsetCesiumWriter invoke() {
            return new PixelOffsetCesiumWriter(PixelOffsetPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(new Func1<EyeOffsetCesiumWriter>() {
        public EyeOffsetCesiumWriter invoke() {
            return new EyeOffsetCesiumWriter(EyeOffsetPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(new Func1<HorizontalOriginCesiumWriter>() {
        public HorizontalOriginCesiumWriter invoke() {
            return new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<VerticalOriginCesiumWriter>(new Func1<VerticalOriginCesiumWriter>() {
        public VerticalOriginCesiumWriter invoke() {
            return new VerticalOriginCesiumWriter(VerticalOriginPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<HeightReferenceCesiumWriter>(new Func1<HeightReferenceCesiumWriter>() {
        public HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(ColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_rotation = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(RotationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<AlignedAxisCesiumWriter> m_alignedAxis = new Lazy<AlignedAxisCesiumWriter>(new Func1<AlignedAxisCesiumWriter>() {
        public AlignedAxisCesiumWriter invoke() {
            return new AlignedAxisCesiumWriter(AlignedAxisPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_sizeInMeters = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(SizeInMetersPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_width = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(WidthPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_height = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(HeightPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<NearFarScalarCesiumWriter> m_scaleByDistance = new Lazy<NearFarScalarCesiumWriter>(new Func1<NearFarScalarCesiumWriter>() {
        public NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(ScaleByDistancePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<NearFarScalarCesiumWriter>(new Func1<NearFarScalarCesiumWriter>() {
        public NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<NearFarScalarCesiumWriter> m_pixelOffsetScaleByDistance = new Lazy<NearFarScalarCesiumWriter>(new Func1<NearFarScalarCesiumWriter>() {
        public NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(PixelOffsetScaleByDistancePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BoundingRectangleCesiumWriter> m_imageSubRegion = new Lazy<BoundingRectangleCesiumWriter>(new Func1<BoundingRectangleCesiumWriter>() {
        public BoundingRectangleCesiumWriter invoke() {
            return new BoundingRectangleCesiumWriter(ImageSubRegionPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DistanceDisplayConditionCesiumWriter> m_distanceDisplayCondition = new Lazy<DistanceDisplayConditionCesiumWriter>(new Func1<DistanceDisplayConditionCesiumWriter>() {
        public DistanceDisplayConditionCesiumWriter invoke() {
            return new DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_disableDepthTestDistance = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(DisableDepthTestDistancePropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public BillboardCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected BillboardCesiumWriter(@Nonnull BillboardCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public BillboardCesiumWriter clone() {
        return new BillboardCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the billboard is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the billboard is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the billboard is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        {
            BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the billboard is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        {
            BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the billboard is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        {
            BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the billboard is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String propertyName) {
        {
            BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the billboard is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String[] propertyNames) {
        {
            BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code image} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code image} property defines the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final UriCesiumWriter getImageWriter() {
        return m_image.getValue();
    }

    /**
    * Opens and returns the writer for the {@code image} property. The {@code image} property defines the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final UriCesiumWriter openImageProperty() {
        openIntervalIfNecessary();
        return this.<UriCesiumWriter> openAndReturn(getImageWriter());
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param resource A resource object describing external data.
    */
    public final void writeImageProperty(CesiumResource resource) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeUri(resource);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeImageProperty(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeUri(uri, resourceBehavior);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeImageProperty(String uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeUri(uri, resourceBehavior);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeImageProperty(URI uri, ICesiumUriResolver resolver) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeUri(uri, resolver);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeImageProperty(String uri, ICesiumUriResolver resolver) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeUri(uri, resolver);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param image The image. A data URI will be created for this image, using PNG encoding.
    */
    public final void writeImageProperty(RenderedImage image) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeUri(image);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param image The image. A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    public final void writeImageProperty(RenderedImage image, @Nonnull CesiumImageFormat imageFormat) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeUri(image, imageFormat);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeImagePropertyReference(Reference value) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeImagePropertyReference(String value) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeImagePropertyReference(String identifier, String propertyName) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the URI of the image displayed on the billboard. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeImagePropertyReference(String identifier, String[] propertyNames) {
        {
            UriCesiumWriter writer = openImageProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code scale} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code scale} property defines the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getScaleWriter() {
        return m_scale.getValue();
    }

    /**
    * Opens and returns the writer for the {@code scale} property. The {@code scale} property defines the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openScaleProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeScaleProperty(double value) {
        {
            DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeScalePropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeScalePropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the billboard. The scale is multiplied with the pixel size of the billboard's {@code image}. For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the {@code image}. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code pixelOffset} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code pixelOffset} property defines the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    */
    @Nonnull
    public final PixelOffsetCesiumWriter getPixelOffsetWriter() {
        return m_pixelOffset.getValue();
    }

    /**
    * Opens and returns the writer for the {@code pixelOffset} property. The {@code pixelOffset} property defines the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    */
    @Nonnull
    public final PixelOffsetCesiumWriter openPixelOffsetProperty() {
        openIntervalIfNecessary();
        return this.<PixelOffsetCesiumWriter> openAndReturn(getPixelOffsetWriter());
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param value The value.
    */
    public final void writePixelOffsetProperty(@Nonnull Rectangular value) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writePixelOffsetProperty(double x, double y) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(x, y);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param value The reference.
    */
    public final void writePixelOffsetPropertyReference(Reference value) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param value The reference.
    */
    public final void writePixelOffsetPropertyReference(String value) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePixelOffsetPropertyReference(String identifier, String propertyName) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the billboard origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the billboard, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePixelOffsetPropertyReference(String identifier, String[] propertyNames) {
        {
            PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code eyeOffset} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code eyeOffset} property defines the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final EyeOffsetCesiumWriter getEyeOffsetWriter() {
        return m_eyeOffset.getValue();
    }

    /**
    * Opens and returns the writer for the {@code eyeOffset} property. The {@code eyeOffset} property defines the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final EyeOffsetCesiumWriter openEyeOffsetProperty() {
        openIntervalIfNecessary();
        return this.<EyeOffsetCesiumWriter> openAndReturn(getEyeOffsetWriter());
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The value.
    */
    public final void writeEyeOffsetProperty(@Nonnull Cartesian value) {
        {
            EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeCartesian(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values) {
        {
            EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeCartesian(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        {
            EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeCartesian(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeEyeOffsetPropertyReference(Reference value) {
        {
            EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeEyeOffsetPropertyReference(String value) {
        {
            EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEyeOffsetPropertyReference(String identifier, String propertyName) {
        {
            EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEyeOffsetPropertyReference(String identifier, String[] propertyNames) {
        {
            EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code horizontalOrigin} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code horizontalOrigin} property defines the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final HorizontalOriginCesiumWriter getHorizontalOriginWriter() {
        return m_horizontalOrigin.getValue();
    }

    /**
    * Opens and returns the writer for the {@code horizontalOrigin} property. The {@code horizontalOrigin} property defines the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final HorizontalOriginCesiumWriter openHorizontalOriginProperty() {
        openIntervalIfNecessary();
        return this.<HorizontalOriginCesiumWriter> openAndReturn(getHorizontalOriginWriter());
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code horizontalOrigin} value. The {@code horizontalOrigin} property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The horizontal origin.
    */
    public final void writeHorizontalOriginProperty(@Nonnull CesiumHorizontalOrigin value) {
        {
            HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeHorizontalOrigin(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeHorizontalOriginPropertyReference(Reference value) {
        {
            HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeHorizontalOriginPropertyReference(String value) {
        {
            HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHorizontalOriginPropertyReference(String identifier, String propertyName) {
        {
            HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHorizontalOriginPropertyReference(String identifier, String[] propertyNames) {
        {
            HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code verticalOrigin} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code verticalOrigin} property defines the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final VerticalOriginCesiumWriter getVerticalOriginWriter() {
        return m_verticalOrigin.getValue();
    }

    /**
    * Opens and returns the writer for the {@code verticalOrigin} property. The {@code verticalOrigin} property defines the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final VerticalOriginCesiumWriter openVerticalOriginProperty() {
        openIntervalIfNecessary();
        return this.<VerticalOriginCesiumWriter> openAndReturn(getVerticalOriginWriter());
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code verticalOrigin} value. The {@code verticalOrigin} property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The vertical origin.
    */
    public final void writeVerticalOriginProperty(@Nonnull CesiumVerticalOrigin value) {
        {
            VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeVerticalOrigin(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeVerticalOriginPropertyReference(Reference value) {
        {
            VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeVerticalOriginPropertyReference(String value) {
        {
            VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeVerticalOriginPropertyReference(String identifier, String propertyName) {
        {
            VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeVerticalOriginPropertyReference(String identifier, String[] propertyNames) {
        {
            VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code heightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code heightReference} property defines the height reference of the billboard, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code heightReference} property. The {@code heightReference} property defines the height reference of the billboard, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code heightReference} value. The {@code heightReference} property specifies the height reference of the billboard, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The height reference.
    */
    public final void writeHeightReferenceProperty(@Nonnull CesiumHeightReference value) {
        {
            HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeHeightReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the billboard, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(Reference value) {
        {
            HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the billboard, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(String value) {
        {
            HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the billboard, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String propertyName) {
        {
            HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the billboard, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String[] propertyNames) {
        {
            HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code color} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code color} property defines the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    * Opens and returns the writer for the {@code color} property. The {@code color} property defines the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorProperty(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeColorProperty(int red, int green, int blue, int alpha) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(Reference value) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(String value) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String propertyName) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the billboard. This color value is multiplied with the values of the billboard's {@code image} to produce the final color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String[] propertyNames) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code rotation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code rotation} property defines the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getRotationWriter() {
        return m_rotation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code rotation} property. The {@code rotation} property defines the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openRotationProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getRotationWriter());
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeRotationProperty(double value) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code alignedAxis} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code alignedAxis} property defines the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final AlignedAxisCesiumWriter getAlignedAxisWriter() {
        return m_alignedAxis.getValue();
    }

    /**
    * Opens and returns the writer for the {@code alignedAxis} property. The {@code alignedAxis} property defines the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final AlignedAxisCesiumWriter openAlignedAxisProperty() {
        openIntervalIfNecessary();
        return this.<AlignedAxisCesiumWriter> openAndReturn(getAlignedAxisWriter());
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code unitCartesian} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The value.
    */
    public final void writeAlignedAxisProperty(@Nonnull UnitCartesian value) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeUnitCartesian(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code unitCartesian} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeAlignedAxisProperty(List<JulianDate> dates, List<UnitCartesian> values) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeUnitCartesian(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code unitCartesian} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeAlignedAxisProperty(List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeUnitCartesian(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code unitSpherical} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The value.
    */
    public final void writeAlignedAxisPropertyUnitSpherical(@Nonnull UnitSpherical value) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeUnitSpherical(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code unitSpherical} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeAlignedAxisPropertyUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeUnitSpherical(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code unitSpherical} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeAlignedAxisPropertyUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeUnitSpherical(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code reference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeAlignedAxisPropertyReference(Reference value) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code reference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeAlignedAxisPropertyReference(String value) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code reference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeAlignedAxisPropertyReference(String identifier, String propertyName) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code reference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeAlignedAxisPropertyReference(String identifier, String[] propertyNames) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code velocityReference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeAlignedAxisPropertyVelocityReference(Reference value) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeVelocityReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code velocityReference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeAlignedAxisPropertyVelocityReference(String value) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeVelocityReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code velocityReference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeAlignedAxisPropertyVelocityReference(String identifier, String propertyName) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeVelocityReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code alignedAxis} property as a {@code velocityReference} value. The {@code alignedAxis} property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeAlignedAxisPropertyVelocityReference(String identifier, String[] propertyNames) {
        {
            AlignedAxisCesiumWriter writer = openAlignedAxisProperty();
            try {
                writer.writeVelocityReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code sizeInMeters} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code sizeInMeters} property defines whether this billboard's size ({@code width} and {@code height}) should be measured in meters, otherwise size is measured in pixels. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getSizeInMetersWriter() {
        return m_sizeInMeters.getValue();
    }

    /**
    * Opens and returns the writer for the {@code sizeInMeters} property. The {@code sizeInMeters} property defines whether this billboard's size ({@code width} and {@code height}) should be measured in meters, otherwise size is measured in pixels. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openSizeInMetersProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getSizeInMetersWriter());
    }

    /**
    * Writes a value for the {@code sizeInMeters} property as a {@code boolean} value. The {@code sizeInMeters} property specifies whether this billboard's size ({@code width} and {@code height}) should be measured in meters, otherwise size is measured in pixels. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeSizeInMetersProperty(boolean value) {
        {
            BooleanCesiumWriter writer = openSizeInMetersProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code sizeInMeters} property as a {@code reference} value. The {@code sizeInMeters} property specifies whether this billboard's size ({@code width} and {@code height}) should be measured in meters, otherwise size is measured in pixels. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeSizeInMetersPropertyReference(Reference value) {
        {
            BooleanCesiumWriter writer = openSizeInMetersProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code sizeInMeters} property as a {@code reference} value. The {@code sizeInMeters} property specifies whether this billboard's size ({@code width} and {@code height}) should be measured in meters, otherwise size is measured in pixels. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeSizeInMetersPropertyReference(String value) {
        {
            BooleanCesiumWriter writer = openSizeInMetersProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code sizeInMeters} property as a {@code reference} value. The {@code sizeInMeters} property specifies whether this billboard's size ({@code width} and {@code height}) should be measured in meters, otherwise size is measured in pixels. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSizeInMetersPropertyReference(String identifier, String propertyName) {
        {
            BooleanCesiumWriter writer = openSizeInMetersProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code sizeInMeters} property as a {@code reference} value. The {@code sizeInMeters} property specifies whether this billboard's size ({@code width} and {@code height}) should be measured in meters, otherwise size is measured in pixels. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSizeInMetersPropertyReference(String identifier, String[] propertyNames) {
        {
            BooleanCesiumWriter writer = openSizeInMetersProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code width} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code width} property defines the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    */
    @Nonnull
    public final DoubleCesiumWriter getWidthWriter() {
        return m_width.getValue();
    }

    /**
    * Opens and returns the writer for the {@code width} property. The {@code width} property defines the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    */
    @Nonnull
    public final DoubleCesiumWriter openWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getWidthWriter());
    }

    /**
    * Writes a value for the {@code width} property as a {@code number} value. The {@code width} property specifies the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    * @param value The value.
    */
    public final void writeWidthProperty(double value) {
        {
            DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code width} property as a {@code number} value. The {@code width} property specifies the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWidthProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code width} property as a {@code number} value. The {@code width} property specifies the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code width} property as a {@code reference} value. The {@code width} property specifies the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    * @param value The reference.
    */
    public final void writeWidthPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code width} property as a {@code reference} value. The {@code width} property specifies the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    * @param value The reference.
    */
    public final void writeWidthPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code width} property as a {@code reference} value. The {@code width} property specifies the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeWidthPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code width} property as a {@code reference} value. The {@code width} property specifies the width of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native width of the image is used.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeWidthPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code height} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code height} property defines the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    */
    @Nonnull
    public final DoubleCesiumWriter getHeightWriter() {
        return m_height.getValue();
    }

    /**
    * Opens and returns the writer for the {@code height} property. The {@code height} property defines the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    */
    @Nonnull
    public final DoubleCesiumWriter openHeightProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getHeightWriter());
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    * @param value The value.
    */
    public final void writeHeightProperty(double value) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeHeightProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeHeightProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    * @param value The reference.
    */
    public final void writeHeightPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    * @param value The reference.
    */
    public final void writeHeightPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHeightPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the billboard, in pixels (or meters, if {@code sizeInMeters} is true). By default, the native height of the image is used.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHeightPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code scaleByDistance} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code scaleByDistance} property defines how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter getScaleByDistanceWriter() {
        return m_scaleByDistance.getValue();
    }

    /**
    * Opens and returns the writer for the {@code scaleByDistance} property. The {@code scaleByDistance} property defines how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter openScaleByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getScaleByDistanceWriter());
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param value The value.
    */
    public final void writeScaleByDistanceProperty(@Nonnull NearFarScalar value) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param value The reference.
    */
    public final void writeScaleByDistancePropertyReference(Reference value) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param value The reference.
    */
    public final void writeScaleByDistancePropertyReference(String value) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScaleByDistancePropertyReference(String identifier, String propertyName) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the billboard's scale should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code translucencyByDistance} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code translucencyByDistance} property defines how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter getTranslucencyByDistanceWriter() {
        return m_translucencyByDistance.getValue();
    }

    /**
    * Opens and returns the writer for the {@code translucencyByDistance} property. The {@code translucencyByDistance} property defines how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter openTranslucencyByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getTranslucencyByDistanceWriter());
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param value The value.
    */
    public final void writeTranslucencyByDistanceProperty(@Nonnull NearFarScalar value) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeTranslucencyByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param value The reference.
    */
    public final void writeTranslucencyByDistancePropertyReference(Reference value) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param value The reference.
    */
    public final void writeTranslucencyByDistancePropertyReference(String value) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTranslucencyByDistancePropertyReference(String identifier, String propertyName) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the billboard's translucency should change based on the billboard's distance from the camera. This scalar value should range from 0 to 1.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTranslucencyByDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code pixelOffsetScaleByDistance} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code pixelOffsetScaleByDistance} property defines how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter getPixelOffsetScaleByDistanceWriter() {
        return m_pixelOffsetScaleByDistance.getValue();
    }

    /**
    * Opens and returns the writer for the {@code pixelOffsetScaleByDistance} property. The {@code pixelOffsetScaleByDistance} property defines how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter openPixelOffsetScaleByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getPixelOffsetScaleByDistanceWriter());
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param value The value.
    */
    public final void writePixelOffsetScaleByDistanceProperty(@Nonnull NearFarScalar value) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writePixelOffsetScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param value The reference.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(Reference value) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param value The reference.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String value) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String propertyName) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code imageSubRegion} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code imageSubRegion} property defines a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    */
    @Nonnull
    public final BoundingRectangleCesiumWriter getImageSubRegionWriter() {
        return m_imageSubRegion.getValue();
    }

    /**
    * Opens and returns the writer for the {@code imageSubRegion} property. The {@code imageSubRegion} property defines a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    */
    @Nonnull
    public final BoundingRectangleCesiumWriter openImageSubRegionProperty() {
        openIntervalIfNecessary();
        return this.<BoundingRectangleCesiumWriter> openAndReturn(getImageSubRegionWriter());
    }

    /**
    * Writes a value for the {@code imageSubRegion} property as a {@code boundingRectangle} value. The {@code imageSubRegion} property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    * @param value The value.
    */
    public final void writeImageSubRegionProperty(@Nonnull BoundingRectangle value) {
        {
            BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
            try {
                writer.writeBoundingRectangle(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code imageSubRegion} property as a {@code boundingRectangle} value. The {@code imageSubRegion} property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeImageSubRegionProperty(List<JulianDate> dates, List<BoundingRectangle> values) {
        {
            BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
            try {
                writer.writeBoundingRectangle(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code imageSubRegion} property as a {@code boundingRectangle} value. The {@code imageSubRegion} property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeImageSubRegionProperty(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
        {
            BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
            try {
                writer.writeBoundingRectangle(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code imageSubRegion} property as a {@code reference} value. The {@code imageSubRegion} property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    * @param value The reference.
    */
    public final void writeImageSubRegionPropertyReference(Reference value) {
        {
            BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code imageSubRegion} property as a {@code reference} value. The {@code imageSubRegion} property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    * @param value The reference.
    */
    public final void writeImageSubRegionPropertyReference(String value) {
        {
            BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code imageSubRegion} property as a {@code reference} value. The {@code imageSubRegion} property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeImageSubRegionPropertyReference(String identifier, String propertyName) {
        {
            BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code imageSubRegion} property as a {@code reference} value. The {@code imageSubRegion} property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeImageSubRegionPropertyReference(String identifier, String[] propertyNames) {
        {
            BoundingRectangleCesiumWriter writer = openImageSubRegionProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code distanceDisplayCondition} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this billboard will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    * Opens and returns the writer for the {@code distanceDisplayCondition} property. The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this billboard will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param value The value.
    */
    public final void writeDistanceDisplayConditionProperty(@Nonnull Bounds value) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param lowerBound The lower bound.
    * @param upperBound The upper bound.
    */
    public final void writeDistanceDisplayConditionProperty(double lowerBound, double upperBound) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(lowerBound, upperBound);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDistanceDisplayConditionProperty(List<JulianDate> dates, List<Bounds> values) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDistanceDisplayConditionProperty(List<JulianDate> dates, List<Bounds> values, int startIndex, int length) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(Reference value) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String value) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String propertyName) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this billboard will be displayed.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String[] propertyNames) {
        {
            DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code disableDepthTestDistance} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code disableDepthTestDistance} property defines the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getDisableDepthTestDistanceWriter() {
        return m_disableDepthTestDistance.getValue();
    }

    /**
    * Opens and returns the writer for the {@code disableDepthTestDistance} property. The {@code disableDepthTestDistance} property defines the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openDisableDepthTestDistanceProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getDisableDepthTestDistanceWriter());
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code number} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeDisableDepthTestDistanceProperty(double value) {
        {
            DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code number} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDisableDepthTestDistanceProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code number} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDisableDepthTestDistanceProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeDisableDepthTestDistancePropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}