package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Tileset} to a {@link CesiumOutputStream}. A {@code Tileset} is a 3D Tiles tileset.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class TilesetCesiumWriter extends CesiumPropertyWriter<TilesetCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code uri} property.
    */
    @Nonnull
    public static final String UriPropertyName = "uri";
    /**
    * The name of the {@code maximumScreenSpaceError} property.
    */
    @Nonnull
    public static final String MaximumScreenSpaceErrorPropertyName = "maximumScreenSpaceError";
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<UriCesiumWriter> m_uri = new Lazy<UriCesiumWriter>(new Func1<UriCesiumWriter>() {
        public UriCesiumWriter invoke() {
            return new UriCesiumWriter(UriPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_maximumScreenSpaceError = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MaximumScreenSpaceErrorPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public TilesetCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected TilesetCesiumWriter(@Nonnull TilesetCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public TilesetCesiumWriter clone() {
        return new TilesetCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the tileset is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the tileset is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the tileset is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the tileset is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the tileset is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the tileset is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the tileset is shown. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code uri} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code uri} property defines the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final UriCesiumWriter getUriWriter() {
        return m_uri.getValue();
    }

    /**
    * Opens and returns the writer for the {@code uri} property. The {@code uri} property defines the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final UriCesiumWriter openUriProperty() {
        openIntervalIfNecessary();
        return this.<UriCesiumWriter> openAndReturn(getUriWriter());
    }

    /**
    * Writes a value for the {@code uri} property as a {@code uri} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param resource A resource object describing external data.
    */
    public final void writeUriProperty(CesiumResource resource) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(resource);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code uri} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUriProperty(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resourceBehavior);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code uri} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUriProperty(String uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resourceBehavior);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code uri} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUriProperty(URI uri, ICesiumUriResolver resolver) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resolver);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code uri} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUriProperty(String uri, ICesiumUriResolver resolver) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resolver);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code uri} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param image The image. A data URI will be created for this image, using PNG encoding.
    */
    public final void writeUriProperty(RenderedImage image) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(image);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code uri} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param image The image. A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    public final void writeUriProperty(RenderedImage image, @Nonnull CesiumImageFormat imageFormat) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(image, imageFormat);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code reference} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeUriPropertyReference(Reference value) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code reference} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeUriPropertyReference(String value) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code reference} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeUriPropertyReference(String identifier, String propertyName) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code uri} property as a {@code reference} value. The {@code uri} property specifies the URI of a 3D tiles tileset. For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS). This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeUriPropertyReference(String identifier, String[] propertyNames) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openUriProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code maximumScreenSpaceError} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code maximumScreenSpaceError} property defines the maximum screen space error used to drive level of detail refinement.
    */
    @Nonnull
    public final DoubleCesiumWriter getMaximumScreenSpaceErrorWriter() {
        return m_maximumScreenSpaceError.getValue();
    }

    /**
    * Opens and returns the writer for the {@code maximumScreenSpaceError} property. The {@code maximumScreenSpaceError} property defines the maximum screen space error used to drive level of detail refinement.
    */
    @Nonnull
    public final DoubleCesiumWriter openMaximumScreenSpaceErrorProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMaximumScreenSpaceErrorWriter());
    }

    /**
    * Writes a value for the {@code maximumScreenSpaceError} property as a {@code number} value. The {@code maximumScreenSpaceError} property specifies the maximum screen space error used to drive level of detail refinement.
    * @param value The value.
    */
    public final void writeMaximumScreenSpaceErrorProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScreenSpaceErrorProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code maximumScreenSpaceError} property as a {@code number} value. The {@code maximumScreenSpaceError} property specifies the maximum screen space error used to drive level of detail refinement.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMaximumScreenSpaceErrorProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScreenSpaceErrorProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code maximumScreenSpaceError} property as a {@code number} value. The {@code maximumScreenSpaceError} property specifies the maximum screen space error used to drive level of detail refinement.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMaximumScreenSpaceErrorProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScreenSpaceErrorProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code maximumScreenSpaceError} property as a {@code reference} value. The {@code maximumScreenSpaceError} property specifies the maximum screen space error used to drive level of detail refinement.
    * @param value The reference.
    */
    public final void writeMaximumScreenSpaceErrorPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScreenSpaceErrorProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumScreenSpaceError} property as a {@code reference} value. The {@code maximumScreenSpaceError} property specifies the maximum screen space error used to drive level of detail refinement.
    * @param value The reference.
    */
    public final void writeMaximumScreenSpaceErrorPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScreenSpaceErrorProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumScreenSpaceError} property as a {@code reference} value. The {@code maximumScreenSpaceError} property specifies the maximum screen space error used to drive level of detail refinement.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMaximumScreenSpaceErrorPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScreenSpaceErrorProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code maximumScreenSpaceError} property as a {@code reference} value. The {@code maximumScreenSpaceError} property specifies the maximum screen space error used to drive level of detail refinement.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMaximumScreenSpaceErrorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumScreenSpaceErrorProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}