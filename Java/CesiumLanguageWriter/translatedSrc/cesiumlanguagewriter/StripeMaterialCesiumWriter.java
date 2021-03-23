package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.StripeOrientationCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code StripeMaterial} to a {@link CesiumOutputStream}. A {@code StripeMaterial} is a material that fills the surface with alternating colors.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class StripeMaterialCesiumWriter extends CesiumPropertyWriter<StripeMaterialCesiumWriter> {
    /**
    * The name of the {@code orientation} property.
    */
    @Nonnull
    public static final String OrientationPropertyName = "orientation";
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
    * The name of the {@code offset} property.
    */
    @Nonnull
    public static final String OffsetPropertyName = "offset";
    /**
    * The name of the {@code repeat} property.
    */
    @Nonnull
    public static final String RepeatPropertyName = "repeat";
    @Nonnull
    private final Lazy<StripeOrientationCesiumWriter> m_orientation = new Lazy<cesiumlanguagewriter.StripeOrientationCesiumWriter>(new Func1<cesiumlanguagewriter.StripeOrientationCesiumWriter>() {
        public cesiumlanguagewriter.StripeOrientationCesiumWriter invoke() {
            return new StripeOrientationCesiumWriter(OrientationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_evenColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(EvenColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_oddColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(OddColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_offset = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(OffsetPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_repeat = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(RepeatPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public StripeMaterialCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected StripeMaterialCesiumWriter(@Nonnull StripeMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public StripeMaterialCesiumWriter clone() {
        return new StripeMaterialCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code orientation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code orientation} property defines the value indicating if the stripes are horizontal or vertical. If not specified, the default value is HORIZONTAL.
    */
    @Nonnull
    public final StripeOrientationCesiumWriter getOrientationWriter() {
        return m_orientation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code orientation} property. The {@code orientation} property defines the value indicating if the stripes are horizontal or vertical. If not specified, the default value is HORIZONTAL.
    */
    @Nonnull
    public final StripeOrientationCesiumWriter openOrientationProperty() {
        openIntervalIfNecessary();
        return this.<StripeOrientationCesiumWriter> openAndReturn(getOrientationWriter());
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code stripeOrientation} value. The {@code orientation} property specifies the value indicating if the stripes are horizontal or vertical. If not specified, the default value is HORIZONTAL.
    * @param value The orientation.
    */
    public final void writeOrientationProperty(@Nonnull CesiumStripeOrientation value) {
        {
            StripeOrientationCesiumWriter writer = openOrientationProperty();
            try {
                writer.writeStripeOrientation(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the value indicating if the stripes are horizontal or vertical. If not specified, the default value is HORIZONTAL.
    * @param value The reference.
    */
    public final void writeOrientationPropertyReference(Reference value) {
        {
            StripeOrientationCesiumWriter writer = openOrientationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the value indicating if the stripes are horizontal or vertical. If not specified, the default value is HORIZONTAL.
    * @param value The reference.
    */
    public final void writeOrientationPropertyReference(String value) {
        {
            StripeOrientationCesiumWriter writer = openOrientationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the value indicating if the stripes are horizontal or vertical. If not specified, the default value is HORIZONTAL.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOrientationPropertyReference(String identifier, String propertyName) {
        {
            StripeOrientationCesiumWriter writer = openOrientationProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the value indicating if the stripes are horizontal or vertical. If not specified, the default value is HORIZONTAL.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOrientationPropertyReference(String identifier, String[] propertyNames) {
        {
            StripeOrientationCesiumWriter writer = openOrientationProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
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
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgba} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEvenColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgbaf} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeEvenColorPropertyRgbaf(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code rgbaf} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEvenColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeEvenColorPropertyReference(Reference value) {
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeEvenColorPropertyReference(String value) {
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEvenColorPropertyReference(String identifier, String propertyName) {
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code evenColor} property as a {@code reference} value. The {@code evenColor} property specifies the even color. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEvenColorPropertyReference(String identifier, String[] propertyNames) {
        {
            ColorCesiumWriter writer = openEvenColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgba} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOddColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgbaf} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOddColorPropertyRgbaf(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code rgbaf} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOddColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOddColorPropertyReference(Reference value) {
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOddColorPropertyReference(String value) {
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOddColorPropertyReference(String identifier, String propertyName) {
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code oddColor} property as a {@code reference} value. The {@code oddColor} property specifies the odd color. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOddColorPropertyReference(String identifier, String[] propertyNames) {
        {
            ColorCesiumWriter writer = openOddColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code offset} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code offset} property defines the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getOffsetWriter() {
        return m_offset.getValue();
    }

    /**
    * Opens and returns the writer for the {@code offset} property. The {@code offset} property defines the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openOffsetProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOffsetWriter());
    }

    /**
    * Writes a value for the {@code offset} property as a {@code number} value. The {@code offset} property specifies the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeOffsetProperty(double value) {
        {
            DoubleCesiumWriter writer = openOffsetProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code offset} property as a {@code number} value. The {@code offset} property specifies the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOffsetProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openOffsetProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code offset} property as a {@code number} value. The {@code offset} property specifies the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOffsetProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openOffsetProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code offset} property as a {@code reference} value. The {@code offset} property specifies the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeOffsetPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code offset} property as a {@code reference} value. The {@code offset} property specifies the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeOffsetPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code offset} property as a {@code reference} value. The {@code offset} property specifies the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOffsetPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openOffsetProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code offset} property as a {@code reference} value. The {@code offset} property specifies the value indicating where in the pattern to begin drawing, with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOffsetPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openOffsetProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code repeat} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code repeat} property defines the number of times the stripes repeat. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getRepeatWriter() {
        return m_repeat.getValue();
    }

    /**
    * Opens and returns the writer for the {@code repeat} property. The {@code repeat} property defines the number of times the stripes repeat. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openRepeatProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getRepeatWriter());
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code number} value. The {@code repeat} property specifies the number of times the stripes repeat. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeRepeatProperty(double value) {
        {
            DoubleCesiumWriter writer = openRepeatProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code number} value. The {@code repeat} property specifies the number of times the stripes repeat. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRepeatProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openRepeatProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code number} value. The {@code repeat} property specifies the number of times the stripes repeat. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRepeatProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openRepeatProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the stripes repeat. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeRepeatPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openRepeatProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the stripes repeat. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeRepeatPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openRepeatProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the stripes repeat. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRepeatPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openRepeatProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code repeat} property as a {@code reference} value. The {@code repeat} property specifies the number of times the stripes repeat. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRepeatPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openRepeatProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}