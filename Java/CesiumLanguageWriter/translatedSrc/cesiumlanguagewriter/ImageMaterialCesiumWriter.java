package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.RepeatCesiumWriter;
import cesiumlanguagewriter.UriCesiumWriter;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code ImageMaterial} to a {@link CesiumOutputStream}. A {@code ImageMaterial} is a material that fills the surface with an image.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class ImageMaterialCesiumWriter extends CesiumPropertyWriter<ImageMaterialCesiumWriter> {
    /**
    * The name of the {@code image} property.
    */
    @Nonnull
    public static final String ImagePropertyName = "image";
    /**
    * The name of the {@code repeat} property.
    */
    @Nonnull
    public static final String RepeatPropertyName = "repeat";
    /**
    * The name of the {@code color} property.
    */
    @Nonnull
    public static final String ColorPropertyName = "color";
    /**
    * The name of the {@code transparent} property.
    */
    @Nonnull
    public static final String TransparentPropertyName = "transparent";
    @Nonnull
    private final Lazy<UriCesiumWriter> m_image = new Lazy<UriCesiumWriter>(Func1.<UriCesiumWriter> of(() -> {
        return new UriCesiumWriter(ImagePropertyName);
    }), false);
    @Nonnull
    private final Lazy<RepeatCesiumWriter> m_repeat = new Lazy<RepeatCesiumWriter>(Func1.<RepeatCesiumWriter> of(() -> {
        return new RepeatCesiumWriter(RepeatPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(ColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_transparent = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(TransparentPropertyName);
    }), false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ImageMaterialCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ImageMaterialCesiumWriter(@Nonnull ImageMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ImageMaterialCesiumWriter clone() {
        return new ImageMaterialCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code image} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code image} property defines the image to display on the surface.
    */
    @Nonnull
    public final UriCesiumWriter getImageWriter() {
        return m_image.getValue();
    }

    /**
    * Opens and returns the writer for the {@code image} property. The {@code image} property defines the image to display on the surface.
    */
    @Nonnull
    public final UriCesiumWriter openImageProperty() {
        openIntervalIfNecessary();
        return this.<UriCesiumWriter> openAndReturn(getImageWriter());
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the image to display on the surface.
    * @param resource A resource object describing external data.
    */
    public final void writeImageProperty(CesiumResource resource) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(resource);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the image to display on the surface.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeImageProperty(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resourceBehavior);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the image to display on the surface.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeImageProperty(String uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resourceBehavior);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the image to display on the surface.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeImageProperty(URI uri, ICesiumUriResolver resolver) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resolver);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the image to display on the surface.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeImageProperty(String uri, ICesiumUriResolver resolver) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(uri, resolver);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the image to display on the surface.
    * @param image The image. A data URI will be created for this image, using PNG encoding.
    */
    public final void writeImageProperty(RenderedImage image) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(image);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code uri} value. The {@code image} property specifies the image to display on the surface.
    * @param image The image. A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    public final void writeImageProperty(RenderedImage image, @Nonnull CesiumImageFormat imageFormat) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeUri(image, imageFormat);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the image to display on the surface.
    * @param value The reference.
    */
    public final void writeImagePropertyReference(Reference value) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the image to display on the surface.
    * @param value The reference.
    */
    public final void writeImagePropertyReference(String value) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the image to display on the surface.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeImagePropertyReference(String identifier, String propertyName) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code image} property as a {@code reference} value. The {@code image} property specifies the image to display on the surface.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeImagePropertyReference(String identifier, String[] propertyNames) {
        try (Using<UriCesiumWriter> using$0 = new Using<UriCesiumWriter>(openImageProperty())) {
            final UriCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code repeat} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code repeat} property defines the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    */
    @Nonnull
    public final RepeatCesiumWriter getRepeatWriter() {
        return m_repeat.getValue();
    }

    /**
    * Opens and returns the writer for the {@code repeat} property. The {@code repeat} property defines the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    */
    @Nonnull
    public final RepeatCesiumWriter openRepeatProperty() {
        openIntervalIfNecessary();
        return this.<RepeatCesiumWriter> openAndReturn(getRepeatWriter());
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param value The value.
    */
    public final void writeRepeatProperty(@Nonnull Rectangular value) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(value);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeRepeatProperty(double x, double y) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(x, y);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRepeatProperty(List<JulianDate> dates, List<Rectangular> values) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(dates, values);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRepeatProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param value The reference.
    */
    public final void writeRepeatPropertyReference(Reference value) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param value The reference.
    */
    public final void writeRepeatPropertyReference(String value) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRepeatPropertyReference(String identifier, String propertyName) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the image repeats along each axis. If not specified, the default value is [1, 1].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRepeatPropertyReference(String identifier, String[] propertyNames) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code color} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code color} property defines the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    * Opens and returns the writer for the {@code color} property. The {@code color} property defines the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the image. This color value is multiplied with the image to produce the final color. If not specified, the default value is white.
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
    * Gets the writer for the {@code transparent} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code transparent} property defines whether or not the image has transparency. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getTransparentWriter() {
        return m_transparent.getValue();
    }

    /**
    * Opens and returns the writer for the {@code transparent} property. The {@code transparent} property defines whether or not the image has transparency. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openTransparentProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getTransparentWriter());
    }

    /**
    * Writes a value for the {@code transparent} property as a {@code boolean} value. The {@code transparent} property specifies whether or not the image has transparency. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeTransparentProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openTransparentProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code transparent} property as a {@code reference} value. The {@code transparent} property specifies whether or not the image has transparency. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeTransparentPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openTransparentProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code transparent} property as a {@code reference} value. The {@code transparent} property specifies whether or not the image has transparency. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeTransparentPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openTransparentProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code transparent} property as a {@code reference} value. The {@code transparent} property specifies whether or not the image has transparency. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTransparentPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openTransparentProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code transparent} property as a {@code reference} value. The {@code transparent} property specifies whether or not the image has transparency. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTransparentPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openTransparentProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}