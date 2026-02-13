package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BackgroundPaddingCesiumWriter;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.EyeOffsetCesiumWriter;
import cesiumlanguagewriter.FontCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.HorizontalOriginCesiumWriter;
import cesiumlanguagewriter.LabelStyleCesiumWriter;
import cesiumlanguagewriter.NearFarScalarCesiumWriter;
import cesiumlanguagewriter.PixelOffsetCesiumWriter;
import cesiumlanguagewriter.StringCesiumWriter;
import cesiumlanguagewriter.VerticalOriginCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Label} to a {@link CesiumOutputStream}. A {@code Label} is a string of text.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class LabelCesiumWriter extends CesiumPropertyWriter<LabelCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code text} property.
    */
    @Nonnull
    public static final String TextPropertyName = "text";
    /**
    * The name of the {@code font} property.
    */
    @Nonnull
    public static final String FontPropertyName = "font";
    /**
    * The name of the {@code style} property.
    */
    @Nonnull
    public static final String StylePropertyName = "style";
    /**
    * The name of the {@code scale} property.
    */
    @Nonnull
    public static final String ScalePropertyName = "scale";
    /**
    * The name of the {@code showBackground} property.
    */
    @Nonnull
    public static final String ShowBackgroundPropertyName = "showBackground";
    /**
    * The name of the {@code backgroundColor} property.
    */
    @Nonnull
    public static final String BackgroundColorPropertyName = "backgroundColor";
    /**
    * The name of the {@code backgroundPadding} property.
    */
    @Nonnull
    public static final String BackgroundPaddingPropertyName = "backgroundPadding";
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
    * The name of the {@code fillColor} property.
    */
    @Nonnull
    public static final String FillColorPropertyName = "fillColor";
    /**
    * The name of the {@code outlineColor} property.
    */
    @Nonnull
    public static final String OutlineColorPropertyName = "outlineColor";
    /**
    * The name of the {@code outlineWidth} property.
    */
    @Nonnull
    public static final String OutlineWidthPropertyName = "outlineWidth";
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
    * The name of the {@code scaleByDistance} property.
    */
    @Nonnull
    public static final String ScaleByDistancePropertyName = "scaleByDistance";
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
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowPropertyName);
    }), false);
    @Nonnull
    private final Lazy<StringCesiumWriter> m_text = new Lazy<StringCesiumWriter>(Func1.<StringCesiumWriter> of(() -> {
        return new StringCesiumWriter(TextPropertyName);
    }), false);
    @Nonnull
    private final Lazy<FontCesiumWriter> m_font = new Lazy<FontCesiumWriter>(Func1.<FontCesiumWriter> of(() -> {
        return new FontCesiumWriter(FontPropertyName);
    }), false);
    @Nonnull
    private final Lazy<LabelStyleCesiumWriter> m_style = new Lazy<LabelStyleCesiumWriter>(Func1.<LabelStyleCesiumWriter> of(() -> {
        return new LabelStyleCesiumWriter(StylePropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(ScalePropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showBackground = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowBackgroundPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_backgroundColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(BackgroundColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BackgroundPaddingCesiumWriter> m_backgroundPadding = new Lazy<BackgroundPaddingCesiumWriter>(Func1.<BackgroundPaddingCesiumWriter> of(() -> {
        return new BackgroundPaddingCesiumWriter(BackgroundPaddingPropertyName);
    }), false);
    @Nonnull
    private final Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<PixelOffsetCesiumWriter>(Func1.<PixelOffsetCesiumWriter> of(() -> {
        return new PixelOffsetCesiumWriter(PixelOffsetPropertyName);
    }), false);
    @Nonnull
    private final Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(Func1.<EyeOffsetCesiumWriter> of(() -> {
        return new EyeOffsetCesiumWriter(EyeOffsetPropertyName);
    }), false);
    @Nonnull
    private final Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(Func1.<HorizontalOriginCesiumWriter> of(() -> {
        return new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName);
    }), false);
    @Nonnull
    private final Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<VerticalOriginCesiumWriter>(Func1.<VerticalOriginCesiumWriter> of(() -> {
        return new VerticalOriginCesiumWriter(VerticalOriginPropertyName);
    }), false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<HeightReferenceCesiumWriter>(Func1.<HeightReferenceCesiumWriter> of(() -> {
        return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_fillColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(FillColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(OutlineColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(OutlineWidthPropertyName);
    }), false);
    @Nonnull
    private final Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<NearFarScalarCesiumWriter>(Func1.<NearFarScalarCesiumWriter> of(() -> {
        return new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName);
    }), false);
    @Nonnull
    private final Lazy<NearFarScalarCesiumWriter> m_pixelOffsetScaleByDistance = new Lazy<NearFarScalarCesiumWriter>(Func1.<NearFarScalarCesiumWriter> of(() -> {
        return new NearFarScalarCesiumWriter(PixelOffsetScaleByDistancePropertyName);
    }), false);
    @Nonnull
    private final Lazy<NearFarScalarCesiumWriter> m_scaleByDistance = new Lazy<NearFarScalarCesiumWriter>(Func1.<NearFarScalarCesiumWriter> of(() -> {
        return new NearFarScalarCesiumWriter(ScaleByDistancePropertyName);
    }), false);
    @Nonnull
    private final Lazy<DistanceDisplayConditionCesiumWriter> m_distanceDisplayCondition = new Lazy<DistanceDisplayConditionCesiumWriter>(Func1.<DistanceDisplayConditionCesiumWriter> of(() -> {
        return new DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_disableDepthTestDistance = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(DisableDepthTestDistancePropertyName);
    }), false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public LabelCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected LabelCesiumWriter(@Nonnull LabelCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public LabelCesiumWriter clone() {
        return new LabelCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the label is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the label is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code text} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code text} property defines the text displayed by the label. The newline character (\n) indicates line breaks.
    */
    @Nonnull
    public final StringCesiumWriter getTextWriter() {
        return m_text.getValue();
    }

    /**
    * Opens and returns the writer for the {@code text} property. The {@code text} property defines the text displayed by the label. The newline character (\n) indicates line breaks.
    */
    @Nonnull
    public final StringCesiumWriter openTextProperty() {
        openIntervalIfNecessary();
        return this.<StringCesiumWriter> openAndReturn(getTextWriter());
    }

    /**
    * Writes a value for the {@code text} property as a {@code string} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param value The value.
    */
    public final void writeTextProperty(String value) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openTextProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeString(value);
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param value The reference.
    */
    public final void writeTextPropertyReference(Reference value) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openTextProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param value The reference.
    */
    public final void writeTextPropertyReference(String value) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openTextProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTextPropertyReference(String identifier, String propertyName) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openTextProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTextPropertyReference(String identifier, String[] propertyNames) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openTextProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code font} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code font} property defines the font to use for the label. If not specified, the default value is 30px sans-serif.
    */
    @Nonnull
    public final FontCesiumWriter getFontWriter() {
        return m_font.getValue();
    }

    /**
    * Opens and returns the writer for the {@code font} property. The {@code font} property defines the font to use for the label. If not specified, the default value is 30px sans-serif.
    */
    @Nonnull
    public final FontCesiumWriter openFontProperty() {
        openIntervalIfNecessary();
        return this.<FontCesiumWriter> openAndReturn(getFontWriter());
    }

    /**
    * Writes a value for the {@code font} property as a {@code font} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param font The font.
    */
    public final void writeFontProperty(String font) {
        try (Using<FontCesiumWriter> using$0 = new Using<FontCesiumWriter>(openFontProperty())) {
            final FontCesiumWriter writer = using$0.resource;
            writer.writeFont(font);
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param value The reference.
    */
    public final void writeFontPropertyReference(Reference value) {
        try (Using<FontCesiumWriter> using$0 = new Using<FontCesiumWriter>(openFontProperty())) {
            final FontCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param value The reference.
    */
    public final void writeFontPropertyReference(String value) {
        try (Using<FontCesiumWriter> using$0 = new Using<FontCesiumWriter>(openFontProperty())) {
            final FontCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFontPropertyReference(String identifier, String propertyName) {
        try (Using<FontCesiumWriter> using$0 = new Using<FontCesiumWriter>(openFontProperty())) {
            final FontCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFontPropertyReference(String identifier, String[] propertyNames) {
        try (Using<FontCesiumWriter> using$0 = new Using<FontCesiumWriter>(openFontProperty())) {
            final FontCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code style} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code style} property defines the style of the label. If not specified, the default value is FILL.
    */
    @Nonnull
    public final LabelStyleCesiumWriter getStyleWriter() {
        return m_style.getValue();
    }

    /**
    * Opens and returns the writer for the {@code style} property. The {@code style} property defines the style of the label. If not specified, the default value is FILL.
    */
    @Nonnull
    public final LabelStyleCesiumWriter openStyleProperty() {
        openIntervalIfNecessary();
        return this.<LabelStyleCesiumWriter> openAndReturn(getStyleWriter());
    }

    /**
    * Writes a value for the {@code style} property as a {@code labelStyle} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param value The label style.
    */
    public final void writeStyleProperty(@Nonnull CesiumLabelStyle value) {
        try (Using<LabelStyleCesiumWriter> using$0 = new Using<LabelStyleCesiumWriter>(openStyleProperty())) {
            final LabelStyleCesiumWriter writer = using$0.resource;
            writer.writeLabelStyle(value);
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param value The reference.
    */
    public final void writeStylePropertyReference(Reference value) {
        try (Using<LabelStyleCesiumWriter> using$0 = new Using<LabelStyleCesiumWriter>(openStyleProperty())) {
            final LabelStyleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param value The reference.
    */
    public final void writeStylePropertyReference(String value) {
        try (Using<LabelStyleCesiumWriter> using$0 = new Using<LabelStyleCesiumWriter>(openStyleProperty())) {
            final LabelStyleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeStylePropertyReference(String identifier, String propertyName) {
        try (Using<LabelStyleCesiumWriter> using$0 = new Using<LabelStyleCesiumWriter>(openStyleProperty())) {
            final LabelStyleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeStylePropertyReference(String identifier, String[] propertyNames) {
        try (Using<LabelStyleCesiumWriter> using$0 = new Using<LabelStyleCesiumWriter>(openStyleProperty())) {
            final LabelStyleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code scale} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code scale} property defines the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getScaleWriter() {
        return m_scale.getValue();
    }

    /**
    * Opens and returns the writer for the {@code scale} property. The {@code scale} property defines the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openScaleProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeScaleProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeScalePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeScalePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openScaleProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Gets the writer for the {@code showBackground} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showBackground} property defines whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowBackgroundWriter() {
        return m_showBackground.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showBackground} property. The {@code showBackground} property defines whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowBackgroundProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowBackgroundWriter());
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code boolean} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeShowBackgroundProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowBackgroundProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowBackgroundPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowBackgroundProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowBackgroundPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowBackgroundProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowBackgroundPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowBackgroundProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowBackgroundPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowBackgroundProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code backgroundColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code backgroundColor} property defines the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    */
    @Nonnull
    public final ColorCesiumWriter getBackgroundColorWriter() {
        return m_backgroundColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code backgroundColor} property. The {@code backgroundColor} property defines the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    */
    @Nonnull
    public final ColorCesiumWriter openBackgroundColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getBackgroundColorWriter());
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgba} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param color The color.
    */
    public final void writeBackgroundColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgba} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeBackgroundColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgba} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgba} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBackgroundColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param color The color.
    */
    public final void writeBackgroundColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeBackgroundColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBackgroundColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param value The reference.
    */
    public final void writeBackgroundColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param value The reference.
    */
    public final void writeBackgroundColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeBackgroundColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeBackgroundColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openBackgroundColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code backgroundPadding} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code backgroundPadding} property defines the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    */
    @Nonnull
    public final BackgroundPaddingCesiumWriter getBackgroundPaddingWriter() {
        return m_backgroundPadding.getValue();
    }

    /**
    * Opens and returns the writer for the {@code backgroundPadding} property. The {@code backgroundPadding} property defines the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    */
    @Nonnull
    public final BackgroundPaddingCesiumWriter openBackgroundPaddingProperty() {
        openIntervalIfNecessary();
        return this.<BackgroundPaddingCesiumWriter> openAndReturn(getBackgroundPaddingWriter());
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param value The value.
    */
    public final void writeBackgroundPaddingProperty(@Nonnull Rectangular value) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(value);
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeBackgroundPaddingProperty(double x, double y) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(x, y);
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundPaddingProperty(List<JulianDate> dates, List<Rectangular> values) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(dates, values);
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBackgroundPaddingProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param value The reference.
    */
    public final void writeBackgroundPaddingPropertyReference(Reference value) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param value The reference.
    */
    public final void writeBackgroundPaddingPropertyReference(String value) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeBackgroundPaddingPropertyReference(String identifier, String propertyName) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeBackgroundPaddingPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BackgroundPaddingCesiumWriter> using$0 = new Using<BackgroundPaddingCesiumWriter>(openBackgroundPaddingProperty())) {
            final BackgroundPaddingCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code pixelOffset} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code pixelOffset} property defines the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    */
    @Nonnull
    public final PixelOffsetCesiumWriter getPixelOffsetWriter() {
        return m_pixelOffset.getValue();
    }

    /**
    * Opens and returns the writer for the {@code pixelOffset} property. The {@code pixelOffset} property defines the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    */
    @Nonnull
    public final PixelOffsetCesiumWriter openPixelOffsetProperty() {
        openIntervalIfNecessary();
        return this.<PixelOffsetCesiumWriter> openAndReturn(getPixelOffsetWriter());
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param value The value.
    */
    public final void writePixelOffsetProperty(@Nonnull Rectangular value) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(value);
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writePixelOffsetProperty(double x, double y) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(x, y);
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(dates, values);
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeCartesian2(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param value The reference.
    */
    public final void writePixelOffsetPropertyReference(Reference value) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param value The reference.
    */
    public final void writePixelOffsetPropertyReference(String value) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePixelOffsetPropertyReference(String identifier, String propertyName) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePixelOffsetPropertyReference(String identifier, String[] propertyNames) {
        try (Using<PixelOffsetCesiumWriter> using$0 = new Using<PixelOffsetCesiumWriter>(openPixelOffsetProperty())) {
            final PixelOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code eyeOffset} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code eyeOffset} property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final EyeOffsetCesiumWriter getEyeOffsetWriter() {
        return m_eyeOffset.getValue();
    }

    /**
    * Opens and returns the writer for the {@code eyeOffset} property. The {@code eyeOffset} property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final EyeOffsetCesiumWriter openEyeOffsetProperty() {
        openIntervalIfNecessary();
        return this.<EyeOffsetCesiumWriter> openAndReturn(getEyeOffsetWriter());
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The value.
    */
    public final void writeEyeOffsetProperty(@Nonnull Cartesian value) {
        try (Using<EyeOffsetCesiumWriter> using$0 = new Using<EyeOffsetCesiumWriter>(openEyeOffsetProperty())) {
            final EyeOffsetCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<EyeOffsetCesiumWriter> using$0 = new Using<EyeOffsetCesiumWriter>(openEyeOffsetProperty())) {
            final EyeOffsetCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<EyeOffsetCesiumWriter> using$0 = new Using<EyeOffsetCesiumWriter>(openEyeOffsetProperty())) {
            final EyeOffsetCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeEyeOffsetPropertyReference(Reference value) {
        try (Using<EyeOffsetCesiumWriter> using$0 = new Using<EyeOffsetCesiumWriter>(openEyeOffsetProperty())) {
            final EyeOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeEyeOffsetPropertyReference(String value) {
        try (Using<EyeOffsetCesiumWriter> using$0 = new Using<EyeOffsetCesiumWriter>(openEyeOffsetProperty())) {
            final EyeOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEyeOffsetPropertyReference(String identifier, String propertyName) {
        try (Using<EyeOffsetCesiumWriter> using$0 = new Using<EyeOffsetCesiumWriter>(openEyeOffsetProperty())) {
            final EyeOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEyeOffsetPropertyReference(String identifier, String[] propertyNames) {
        try (Using<EyeOffsetCesiumWriter> using$0 = new Using<EyeOffsetCesiumWriter>(openEyeOffsetProperty())) {
            final EyeOffsetCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code horizontalOrigin} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code horizontalOrigin} property defines the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final HorizontalOriginCesiumWriter getHorizontalOriginWriter() {
        return m_horizontalOrigin.getValue();
    }

    /**
    * Opens and returns the writer for the {@code horizontalOrigin} property. The {@code horizontalOrigin} property defines the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final HorizontalOriginCesiumWriter openHorizontalOriginProperty() {
        openIntervalIfNecessary();
        return this.<HorizontalOriginCesiumWriter> openAndReturn(getHorizontalOriginWriter());
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code horizontalOrigin} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The horizontal origin.
    */
    public final void writeHorizontalOriginProperty(@Nonnull CesiumHorizontalOrigin value) {
        try (Using<HorizontalOriginCesiumWriter> using$0 = new Using<HorizontalOriginCesiumWriter>(openHorizontalOriginProperty())) {
            final HorizontalOriginCesiumWriter writer = using$0.resource;
            writer.writeHorizontalOrigin(value);
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeHorizontalOriginPropertyReference(Reference value) {
        try (Using<HorizontalOriginCesiumWriter> using$0 = new Using<HorizontalOriginCesiumWriter>(openHorizontalOriginProperty())) {
            final HorizontalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeHorizontalOriginPropertyReference(String value) {
        try (Using<HorizontalOriginCesiumWriter> using$0 = new Using<HorizontalOriginCesiumWriter>(openHorizontalOriginProperty())) {
            final HorizontalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHorizontalOriginPropertyReference(String identifier, String propertyName) {
        try (Using<HorizontalOriginCesiumWriter> using$0 = new Using<HorizontalOriginCesiumWriter>(openHorizontalOriginProperty())) {
            final HorizontalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHorizontalOriginPropertyReference(String identifier, String[] propertyNames) {
        try (Using<HorizontalOriginCesiumWriter> using$0 = new Using<HorizontalOriginCesiumWriter>(openHorizontalOriginProperty())) {
            final HorizontalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code verticalOrigin} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code verticalOrigin} property defines the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final VerticalOriginCesiumWriter getVerticalOriginWriter() {
        return m_verticalOrigin.getValue();
    }

    /**
    * Opens and returns the writer for the {@code verticalOrigin} property. The {@code verticalOrigin} property defines the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    */
    @Nonnull
    public final VerticalOriginCesiumWriter openVerticalOriginProperty() {
        openIntervalIfNecessary();
        return this.<VerticalOriginCesiumWriter> openAndReturn(getVerticalOriginWriter());
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code verticalOrigin} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The vertical origin.
    */
    public final void writeVerticalOriginProperty(@Nonnull CesiumVerticalOrigin value) {
        try (Using<VerticalOriginCesiumWriter> using$0 = new Using<VerticalOriginCesiumWriter>(openVerticalOriginProperty())) {
            final VerticalOriginCesiumWriter writer = using$0.resource;
            writer.writeVerticalOrigin(value);
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeVerticalOriginPropertyReference(Reference value) {
        try (Using<VerticalOriginCesiumWriter> using$0 = new Using<VerticalOriginCesiumWriter>(openVerticalOriginProperty())) {
            final VerticalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param value The reference.
    */
    public final void writeVerticalOriginPropertyReference(String value) {
        try (Using<VerticalOriginCesiumWriter> using$0 = new Using<VerticalOriginCesiumWriter>(openVerticalOriginProperty())) {
            final VerticalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeVerticalOriginPropertyReference(String identifier, String propertyName) {
        try (Using<VerticalOriginCesiumWriter> using$0 = new Using<VerticalOriginCesiumWriter>(openVerticalOriginProperty())) {
            final VerticalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeVerticalOriginPropertyReference(String identifier, String[] propertyNames) {
        try (Using<VerticalOriginCesiumWriter> using$0 = new Using<VerticalOriginCesiumWriter>(openVerticalOriginProperty())) {
            final VerticalOriginCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code heightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code heightReference} property defines the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code heightReference} property. The {@code heightReference} property defines the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code heightReference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The height reference.
    */
    public final void writeHeightReferenceProperty(@Nonnull CesiumHeightReference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeHeightReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(Reference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(String value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
    * Gets the writer for the {@code fillColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code fillColor} property defines the fill color of the label. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getFillColorWriter() {
        return m_fillColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code fillColor} property. The {@code fillColor} property defines the fill color of the label. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openFillColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getFillColorWriter());
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgba} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeFillColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgba} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeFillColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgba} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeFillColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgba} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeFillColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgbaf} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeFillColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgbaf} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeFillColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgbaf} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeFillColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgbaf} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeFillColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeFillColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeFillColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFillColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFillColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openFillColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code outlineColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineColor} property defines the outline color of the label. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineColor} property. The {@code outlineColor} property defines the outline color of the label. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOutlineColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeOutlineColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOutlineColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeOutlineColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlineColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlineColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code outlineWidth} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineWidth} property defines the outline width of the label. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineWidth} property. The {@code outlineWidth} property defines the outline width of the label. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeOutlineWidthProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlineWidthPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlineWidthPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code translucencyByDistance} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code translucencyByDistance} property defines how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter getTranslucencyByDistanceWriter() {
        return m_translucencyByDistance.getValue();
    }

    /**
    * Opens and returns the writer for the {@code translucencyByDistance} property. The {@code translucencyByDistance} property defines how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter openTranslucencyByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getTranslucencyByDistanceWriter());
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param value The value.
    */
    public final void writeTranslucencyByDistanceProperty(@Nonnull NearFarScalar value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(value);
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeTranslucencyByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(dates, values);
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param value The reference.
    */
    public final void writeTranslucencyByDistancePropertyReference(Reference value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param value The reference.
    */
    public final void writeTranslucencyByDistancePropertyReference(String value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTranslucencyByDistancePropertyReference(String identifier, String propertyName) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTranslucencyByDistancePropertyReference(String identifier, String[] propertyNames) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openTranslucencyByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code pixelOffsetScaleByDistance} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code pixelOffsetScaleByDistance} property defines how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter getPixelOffsetScaleByDistanceWriter() {
        return m_pixelOffsetScaleByDistance.getValue();
    }

    /**
    * Opens and returns the writer for the {@code pixelOffsetScaleByDistance} property. The {@code pixelOffsetScaleByDistance} property defines how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter openPixelOffsetScaleByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getPixelOffsetScaleByDistanceWriter());
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param value The value.
    */
    public final void writePixelOffsetScaleByDistanceProperty(@Nonnull NearFarScalar value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(value);
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writePixelOffsetScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(dates, values);
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param value The reference.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(Reference value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param value The reference.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String propertyName) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openPixelOffsetScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code scaleByDistance} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code scaleByDistance} property defines how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter getScaleByDistanceWriter() {
        return m_scaleByDistance.getValue();
    }

    /**
    * Opens and returns the writer for the {@code scaleByDistance} property. The {@code scaleByDistance} property defines how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    */
    @Nonnull
    public final NearFarScalarCesiumWriter openScaleByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getScaleByDistanceWriter());
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param value The value.
    */
    public final void writeScaleByDistanceProperty(@Nonnull NearFarScalar value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(value);
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(dates, values);
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeNearFarScalar(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param value The reference.
    */
    public final void writeScaleByDistancePropertyReference(Reference value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param value The reference.
    */
    public final void writeScaleByDistancePropertyReference(String value) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScaleByDistancePropertyReference(String identifier, String propertyName) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
        try (Using<NearFarScalarCesiumWriter> using$0 = new Using<NearFarScalarCesiumWriter>(openScaleByDistanceProperty())) {
            final NearFarScalarCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code distanceDisplayCondition} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this label will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    * Opens and returns the writer for the {@code distanceDisplayCondition} property. The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this label will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
    * @param value The value.
    */
    public final void writeDistanceDisplayConditionProperty(@Nonnull Bounds value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeDistanceDisplayCondition(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(Reference value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openDisableDepthTestDistanceProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code number} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDisableDepthTestDistanceProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openDisableDepthTestDistanceProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
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
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openDisableDepthTestDistanceProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeDisableDepthTestDistancePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openDisableDepthTestDistanceProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openDisableDepthTestDistanceProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openDisableDepthTestDistanceProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value. The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openDisableDepthTestDistanceProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}