package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Color} to a {@link CesiumOutputStream}. A {@code Color} is a color. The color can optionally vary over time.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class ColorCesiumWriter extends CesiumInterpolatablePropertyWriter<ColorCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumRgbaValuePropertyWriter, ICesiumRgbafValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code rgba} property.
    */
    @Nonnull
    public static final String RgbaPropertyName = "rgba";
    /**
    * The name of the {@code rgbaf} property.
    */
    @Nonnull
    public static final String RgbafPropertyName = "rgbaf";
    /**
    * The name of the {@code reference} property.
    */
    @Nonnull
    public static final String ReferencePropertyName = "reference";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    @Nonnull
    private final Lazy<CesiumRgbaValuePropertyAdaptor<ColorCesiumWriter>> m_asRgba;
    @Nonnull
    private final Lazy<CesiumRgbafValuePropertyAdaptor<ColorCesiumWriter>> m_asRgbaf;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ColorCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ColorCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asRgba = createAsRgba();
        m_asRgbaf = createAsRgbaf();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ColorCesiumWriter(@Nonnull ColorCesiumWriter existingInstance) {
        super(existingInstance);
        m_asRgba = createAsRgba();
        m_asRgbaf = createAsRgbaf();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ColorCesiumWriter clone() {
        return new ColorCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param color The color.
    */
    public final void writeRgba(@Nonnull Color color) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgba(getOutput(), color);
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeRgba(int red, int green, int blue, int alpha) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgba(getOutput(), red, green, blue, alpha);
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRgba(List<JulianDate> dates, List<Color> values) {
        writeRgba(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRgba(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeRgba(getOutput(), PropertyName, dates, colors, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param color The color.
    */
    public final void writeRgbaf(@Nonnull Color color) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgbaf(getOutput(), color);
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeRgbaf(float red, float green, float blue, float alpha) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgbaf(getOutput(), red, green, blue, alpha);
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRgbaf(List<JulianDate> dates, List<Color> values) {
        writeRgbaf(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the color specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeRgbaf(getOutput(), PropertyName, dates, colors, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the color specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the color specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the color specified as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeReference(String identifier, String propertyName) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the color specified as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeReference(String identifier, String[] propertyNames) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
    }

    /**
    * Writes the value expressed as a {@code delete}, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumRgbaValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumRgbaValuePropertyAdaptor<ColorCesiumWriter> asRgba() {
        return m_asRgba.getValue();
    }

    @Nonnull
    private final Lazy<CesiumRgbaValuePropertyAdaptor<ColorCesiumWriter>> createAsRgba() {
        return new Lazy<CesiumRgbaValuePropertyAdaptor<ColorCesiumWriter>>(Func1.<CesiumRgbaValuePropertyAdaptor<ColorCesiumWriter>> of(this::createRgba, this, "createRgba"), false);
    }

    @Nonnull
    private final CesiumRgbaValuePropertyAdaptor<ColorCesiumWriter> createRgba() {
        return CesiumValuePropertyAdaptors.<ColorCesiumWriter> createRgba(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumRgbafValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumRgbafValuePropertyAdaptor<ColorCesiumWriter> asRgbaf() {
        return m_asRgbaf.getValue();
    }

    @Nonnull
    private final Lazy<CesiumRgbafValuePropertyAdaptor<ColorCesiumWriter>> createAsRgbaf() {
        return new Lazy<CesiumRgbafValuePropertyAdaptor<ColorCesiumWriter>>(Func1.<CesiumRgbafValuePropertyAdaptor<ColorCesiumWriter>> of(this::createRgbaf, this, "createRgbaf"), false);
    }

    @Nonnull
    private final CesiumRgbafValuePropertyAdaptor<ColorCesiumWriter> createRgbaf() {
        return CesiumValuePropertyAdaptors.<ColorCesiumWriter> createRgbaf(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<ColorCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ColorCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<ColorCesiumWriter>>(Func1.<CesiumReferenceValuePropertyAdaptor<ColorCesiumWriter>> of(this::createReference, this, "createReference"),
                false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<ColorCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<ColorCesiumWriter> createReference(this);
    }
}