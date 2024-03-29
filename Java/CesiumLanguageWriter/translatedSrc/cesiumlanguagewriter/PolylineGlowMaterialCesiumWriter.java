package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code PolylineGlowMaterial} to a {@link CesiumOutputStream}. A {@code PolylineGlowMaterial} is a material that fills the surface of a line with a glowing color.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class PolylineGlowMaterialCesiumWriter extends CesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> {
    /**
    * The name of the {@code color} property.
    */
    @Nonnull
    public static final String ColorPropertyName = "color";
    /**
    * The name of the {@code glowPower} property.
    */
    @Nonnull
    public static final String GlowPowerPropertyName = "glowPower";
    /**
    * The name of the {@code taperPower} property.
    */
    @Nonnull
    public static final String TaperPowerPropertyName = "taperPower";
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(ColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_glowPower = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(GlowPowerPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_taperPower = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(TaperPowerPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public PolylineGlowMaterialCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected PolylineGlowMaterialCesiumWriter(@Nonnull PolylineGlowMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public PolylineGlowMaterialCesiumWriter clone() {
        return new PolylineGlowMaterialCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code color} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code color} property defines the color of the surface. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    * Opens and returns the writer for the {@code color} property. The {@code color} property defines the color of the surface. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
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
    * Gets the writer for the {@code glowPower} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code glowPower} property defines the strength of the glow. If not specified, the default value is 0.25.
    */
    @Nonnull
    public final DoubleCesiumWriter getGlowPowerWriter() {
        return m_glowPower.getValue();
    }

    /**
    * Opens and returns the writer for the {@code glowPower} property. The {@code glowPower} property defines the strength of the glow. If not specified, the default value is 0.25.
    */
    @Nonnull
    public final DoubleCesiumWriter openGlowPowerProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getGlowPowerWriter());
    }

    /**
    * Writes a value for the {@code glowPower} property as a {@code number} value. The {@code glowPower} property specifies the strength of the glow. If not specified, the default value is 0.25.
    * @param value The value.
    */
    public final void writeGlowPowerProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGlowPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code glowPower} property as a {@code number} value. The {@code glowPower} property specifies the strength of the glow. If not specified, the default value is 0.25.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeGlowPowerProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGlowPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code glowPower} property as a {@code number} value. The {@code glowPower} property specifies the strength of the glow. If not specified, the default value is 0.25.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeGlowPowerProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGlowPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code glowPower} property as a {@code reference} value. The {@code glowPower} property specifies the strength of the glow. If not specified, the default value is 0.25.
    * @param value The reference.
    */
    public final void writeGlowPowerPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGlowPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code glowPower} property as a {@code reference} value. The {@code glowPower} property specifies the strength of the glow. If not specified, the default value is 0.25.
    * @param value The reference.
    */
    public final void writeGlowPowerPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGlowPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code glowPower} property as a {@code reference} value. The {@code glowPower} property specifies the strength of the glow. If not specified, the default value is 0.25.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeGlowPowerPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGlowPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code glowPower} property as a {@code reference} value. The {@code glowPower} property specifies the strength of the glow. If not specified, the default value is 0.25.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeGlowPowerPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGlowPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code taperPower} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code taperPower} property defines the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getTaperPowerWriter() {
        return m_taperPower.getValue();
    }

    /**
    * Opens and returns the writer for the {@code taperPower} property. The {@code taperPower} property defines the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openTaperPowerProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getTaperPowerWriter());
    }

    /**
    * Writes a value for the {@code taperPower} property as a {@code number} value. The {@code taperPower} property specifies the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeTaperPowerProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openTaperPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code taperPower} property as a {@code number} value. The {@code taperPower} property specifies the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTaperPowerProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openTaperPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code taperPower} property as a {@code number} value. The {@code taperPower} property specifies the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeTaperPowerProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openTaperPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code taperPower} property as a {@code reference} value. The {@code taperPower} property specifies the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeTaperPowerPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openTaperPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code taperPower} property as a {@code reference} value. The {@code taperPower} property specifies the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeTaperPowerPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openTaperPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code taperPower} property as a {@code reference} value. The {@code taperPower} property specifies the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTaperPowerPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openTaperPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code taperPower} property as a {@code reference} value. The {@code taperPower} property specifies the strength of the tapering effect.  1.0 and higher means no tapering. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTaperPowerPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openTaperPowerProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}