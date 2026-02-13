package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DirectionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Vector} to a {@link CesiumOutputStream}. A {@code Vector} is defines a graphical vector that originates at the {@code position} property and extends in the provided direction for the provided length.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class VectorCesiumWriter extends CesiumPropertyWriter<VectorCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code color} property.
    */
    @Nonnull
    public static final String ColorPropertyName = "color";
    /**
    * The name of the {@code direction} property.
    */
    @Nonnull
    public static final String DirectionPropertyName = "direction";
    /**
    * The name of the {@code length} property.
    */
    @Nonnull
    public static final String LengthPropertyName = "length";
    /**
    * The name of the {@code minimumLengthInPixels} property.
    */
    @Nonnull
    public static final String MinimumLengthInPixelsPropertyName = "minimumLengthInPixels";
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(ColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DirectionCesiumWriter> m_direction = new Lazy<DirectionCesiumWriter>(Func1.<DirectionCesiumWriter> of(() -> {
        return new DirectionCesiumWriter(DirectionPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_length = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(LengthPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_minimumLengthInPixels = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(MinimumLengthInPixelsPropertyName);
    }), false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public VectorCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected VectorCesiumWriter(@Nonnull VectorCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public VectorCesiumWriter clone() {
        return new VectorCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the vector is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the vector is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the vector is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the vector is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the vector is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the vector is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the vector is shown. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code color} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code color} property defines the color of the vector. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    * Opens and returns the writer for the {@code color} property. The {@code color} property defines the color of the vector. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the vector. If not specified, the default value is white.
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
    * Gets the writer for the {@code direction} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code direction} property defines the direction of the vector. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DirectionCesiumWriter getDirectionWriter() {
        return m_direction.getValue();
    }

    /**
    * Opens and returns the writer for the {@code direction} property. The {@code direction} property defines the direction of the vector. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DirectionCesiumWriter openDirectionProperty() {
        openIntervalIfNecessary();
        return this.<DirectionCesiumWriter> openAndReturn(getDirectionWriter());
    }

    /**
    * Writes a value for the {@code direction} property as a {@code spherical} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeDirectionProperty(@Nonnull Spherical value) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeSpherical(value);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code spherical} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDirectionProperty(List<JulianDate> dates, List<Spherical> values) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeSpherical(dates, values);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code spherical} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDirectionProperty(List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeSpherical(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code unitSpherical} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeDirectionPropertyUnitSpherical(@Nonnull UnitSpherical value) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeUnitSpherical(value);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code unitSpherical} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDirectionPropertyUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeUnitSpherical(dates, values);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code unitSpherical} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDirectionPropertyUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeUnitSpherical(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code cartesian} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeDirectionPropertyCartesian(@Nonnull Cartesian value) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code cartesian} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDirectionPropertyCartesian(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code cartesian} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDirectionPropertyCartesian(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code unitCartesian} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeDirectionPropertyUnitCartesian(@Nonnull UnitCartesian value) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeUnitCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code unitCartesian} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDirectionPropertyUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeUnitCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code unitCartesian} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDirectionPropertyUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeUnitCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code reference} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeDirectionPropertyReference(Reference value) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code reference} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeDirectionPropertyReference(String value) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code reference} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDirectionPropertyReference(String identifier, String propertyName) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code direction} property as a {@code reference} value. The {@code direction} property specifies the direction of the vector. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDirectionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DirectionCesiumWriter> using$0 = new Using<DirectionCesiumWriter>(openDirectionProperty())) {
            final DirectionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code length} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code length} property defines the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getLengthWriter() {
        return m_length.getValue();
    }

    /**
    * Opens and returns the writer for the {@code length} property. The {@code length} property defines the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openLengthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getLengthWriter());
    }

    /**
    * Writes a value for the {@code length} property as a {@code number} value. The {@code length} property specifies the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeLengthProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openLengthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code length} property as a {@code number} value. The {@code length} property specifies the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeLengthProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openLengthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code length} property as a {@code number} value. The {@code length} property specifies the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeLengthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openLengthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code length} property as a {@code reference} value. The {@code length} property specifies the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeLengthPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openLengthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code length} property as a {@code reference} value. The {@code length} property specifies the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeLengthPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openLengthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code length} property as a {@code reference} value. The {@code length} property specifies the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeLengthPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openLengthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code length} property as a {@code reference} value. The {@code length} property specifies the graphical length of the vector, in meters. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeLengthPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openLengthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code minimumLengthInPixels} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code minimumLengthInPixels} property defines the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getMinimumLengthInPixelsWriter() {
        return m_minimumLengthInPixels.getValue();
    }

    /**
    * Opens and returns the writer for the {@code minimumLengthInPixels} property. The {@code minimumLengthInPixels} property defines the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openMinimumLengthInPixelsProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMinimumLengthInPixelsWriter());
    }

    /**
    * Writes a value for the {@code minimumLengthInPixels} property as a {@code number} value. The {@code minimumLengthInPixels} property specifies the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeMinimumLengthInPixelsProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumLengthInPixelsProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code minimumLengthInPixels} property as a {@code number} value. The {@code minimumLengthInPixels} property specifies the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMinimumLengthInPixelsProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumLengthInPixelsProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code minimumLengthInPixels} property as a {@code number} value. The {@code minimumLengthInPixels} property specifies the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMinimumLengthInPixelsProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumLengthInPixelsProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code minimumLengthInPixels} property as a {@code reference} value. The {@code minimumLengthInPixels} property specifies the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumLengthInPixelsPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumLengthInPixelsProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumLengthInPixels} property as a {@code reference} value. The {@code minimumLengthInPixels} property specifies the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumLengthInPixelsPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumLengthInPixelsProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumLengthInPixels} property as a {@code reference} value. The {@code minimumLengthInPixels} property specifies the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMinimumLengthInPixelsPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumLengthInPixelsProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code minimumLengthInPixels} property as a {@code reference} value. The {@code minimumLengthInPixels} property specifies the minimum graphical length of the vector in pixels. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMinimumLengthInPixelsPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumLengthInPixelsProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}