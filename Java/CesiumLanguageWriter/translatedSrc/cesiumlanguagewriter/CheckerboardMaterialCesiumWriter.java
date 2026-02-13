package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.RepeatCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code CheckerboardMaterial} to a {@link CesiumOutputStream}. A {@code CheckerboardMaterial} is a material that fills the surface with a checkerboard pattern.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CheckerboardMaterialCesiumWriter extends CesiumPropertyWriter<CheckerboardMaterialCesiumWriter> {
    /**
    * The name of the {@code evenColor} property.
    */
    @Nonnull
    public static final String EvenColorPropertyName = "evenColor";
    /**
    * The name of the {@code oddColor} property.
    */
    @Nonnull
    public static final String OddColorPropertyName = "oddColor";
    /**
    * The name of the {@code repeat} property.
    */
    @Nonnull
    public static final String RepeatPropertyName = "repeat";
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_evenColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(EvenColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_oddColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(OddColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<RepeatCesiumWriter> m_repeat = new Lazy<RepeatCesiumWriter>(Func1.<RepeatCesiumWriter> of(() -> {
        return new RepeatCesiumWriter(RepeatPropertyName);
    }), false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public CheckerboardMaterialCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected CheckerboardMaterialCesiumWriter(@Nonnull CheckerboardMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public CheckerboardMaterialCesiumWriter clone() {
        return new CheckerboardMaterialCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code evenColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code evenColor} property defines the even color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getEvenColorWriter() {
        return m_evenColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code evenColor} property. The {@code evenColor} property defines the even color. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openEvenColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getEvenColorWriter());
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgba} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeEvenColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgba} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeEvenColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgba} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEvenColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgba} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEvenColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgbaf} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeEvenColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgbaf} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeEvenColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgbaf} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEvenColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgbaf} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEvenColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeEvenColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeEvenColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEvenColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEvenColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEvenColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code oddColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code oddColor} property defines the odd color. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter getOddColorWriter() {
        return m_oddColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code oddColor} property. The {@code oddColor} property defines the odd color. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter openOddColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOddColorWriter());
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgba} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOddColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgba} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeOddColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgba} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOddColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgba} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOddColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgbaf} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOddColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgbaf} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeOddColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgbaf} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOddColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgbaf} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOddColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOddColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOddColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOddColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOddColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOddColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code repeat} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code repeat} property defines the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
    */
    @Nonnull
    public final RepeatCesiumWriter getRepeatWriter() {
        return m_repeat.getValue();
    }

    /**
    * Opens and returns the writer for the {@code repeat} property. The {@code repeat} property defines the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
    */
    @Nonnull
    public final RepeatCesiumWriter openRepeatProperty() {
        openIntervalIfNecessary();
        return this.<RepeatCesiumWriter> openAndReturn(getRepeatWriter());
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
    * @param value The value.
    */
    public final void writeRepeatProperty(@Nonnull Rectangular value) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(value);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
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
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
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
    * Writes a value for the {@code repeat} property as a {@code cartesian2} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
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
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
    * @param value The reference.
    */
    public final void writeRepeatPropertyReference(Reference value) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
    * @param value The reference.
    */
    public final void writeRepeatPropertyReference(String value) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
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
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the tiles repeat along each axis. If not specified, the default value is [2, 2].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRepeatPropertyReference(String identifier, String[] propertyNames) {
        try (Using<RepeatCesiumWriter> using$0 = new Using<RepeatCesiumWriter>(openRepeatProperty())) {
            final RepeatCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}