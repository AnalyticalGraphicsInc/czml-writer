package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
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
@SuppressWarnings( {
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
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<StringCesiumWriter> m_text = new Lazy<StringCesiumWriter>(new Func1<StringCesiumWriter>() {
        public StringCesiumWriter invoke() {
            return new StringCesiumWriter(TextPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<FontCesiumWriter> m_font = new Lazy<FontCesiumWriter>(new Func1<FontCesiumWriter>() {
        public FontCesiumWriter invoke() {
            return new FontCesiumWriter(FontPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<LabelStyleCesiumWriter> m_style = new Lazy<LabelStyleCesiumWriter>(new Func1<LabelStyleCesiumWriter>() {
        public LabelStyleCesiumWriter invoke() {
            return new LabelStyleCesiumWriter(StylePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ScalePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showBackground = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowBackgroundPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_backgroundColor = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(BackgroundColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BackgroundPaddingCesiumWriter> m_backgroundPadding = new Lazy<BackgroundPaddingCesiumWriter>(new Func1<BackgroundPaddingCesiumWriter>() {
        public BackgroundPaddingCesiumWriter invoke() {
            return new BackgroundPaddingCesiumWriter(BackgroundPaddingPropertyName);
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
    private final Lazy<ColorCesiumWriter> m_fillColor = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(FillColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(OutlineColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(OutlineWidthPropertyName);
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
    private final Lazy<NearFarScalarCesiumWriter> m_scaleByDistance = new Lazy<NearFarScalarCesiumWriter>(new Func1<NearFarScalarCesiumWriter>() {
        public NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(ScaleByDistancePropertyName);
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the label is shown. If not specified, the default value is {@code true}.
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
        {
            StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeString(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param value The reference.
    */
    public final void writeTextPropertyReference(Reference value) {
        {
            StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param value The reference.
    */
    public final void writeTextPropertyReference(String value) {
        {
            StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTextPropertyReference(String identifier, String propertyName) {
        {
            StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code text} property as a {@code reference} value. The {@code text} property specifies the text displayed by the label. The newline character (\n) indicates line breaks.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTextPropertyReference(String identifier, String[] propertyNames) {
        {
            StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeFont(font);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param value The reference.
    */
    public final void writeFontPropertyReference(Reference value) {
        {
            FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param value The reference.
    */
    public final void writeFontPropertyReference(String value) {
        {
            FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFontPropertyReference(String identifier, String propertyName) {
        {
            FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code font} property as a {@code reference} value. The {@code font} property specifies the font to use for the label. If not specified, the default value is 30px sans-serif.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFontPropertyReference(String identifier, String[] propertyNames) {
        {
            FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeLabelStyle(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param value The reference.
    */
    public final void writeStylePropertyReference(Reference value) {
        {
            LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param value The reference.
    */
    public final void writeStylePropertyReference(String value) {
        {
            LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeStylePropertyReference(String identifier, String propertyName) {
        {
            LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code style} property as a {@code reference} value. The {@code style} property specifies the style of the label. If not specified, the default value is FILL.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeStylePropertyReference(String identifier, String[] propertyNames) {
        {
            LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code number} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scale of the label. The scale is multiplied with the pixel size of the label's text. For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text. If not specified, the default value is 1.0.
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
        {
            BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowBackgroundPropertyReference(Reference value) {
        {
            BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowBackgroundPropertyReference(String value) {
        {
            BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowBackgroundPropertyReference(String identifier, String propertyName) {
        {
            BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code showBackground} property as a {@code reference} value. The {@code showBackground} property specifies whether or not a background behind the label is shown. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowBackgroundPropertyReference(String identifier, String[] propertyNames) {
        {
            BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgba} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param color The color.
    */
    public final void writeBackgroundColorPropertyRgbaf(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param value The reference.
    */
    public final void writeBackgroundColorPropertyReference(Reference value) {
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param value The reference.
    */
    public final void writeBackgroundColorPropertyReference(String value) {
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeBackgroundColorPropertyReference(String identifier, String propertyName) {
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundColor} property as a {@code reference} value. The {@code backgroundColor} property specifies the color of the background behind the label. If not specified, the default value is [0.165, 0.165, 0.165, 0.8].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeBackgroundColorPropertyReference(String identifier, String[] propertyNames) {
        {
            ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeBackgroundPaddingProperty(double x, double y) {
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(x, y);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundPaddingProperty(List<JulianDate> dates, List<Rectangular> values) {
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param value The reference.
    */
    public final void writeBackgroundPaddingPropertyReference(Reference value) {
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param value The reference.
    */
    public final void writeBackgroundPaddingPropertyReference(String value) {
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeBackgroundPaddingPropertyReference(String identifier, String propertyName) {
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code backgroundPadding} property as a {@code reference} value. The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background. If not specified, the default value is [7, 5].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeBackgroundPaddingPropertyReference(String identifier, String[] propertyNames) {
        {
            BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
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
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
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
    * Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
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
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
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
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
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
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
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
    * Writes a value for the {@code pixelOffset} property as a {@code reference} value. The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}. A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}. If not specified, the default value is [0.0, 0.0].
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
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
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
    * Writes a value for the {@code eyeOffset} property as a {@code cartesian} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
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
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
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
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
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
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
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
    * Writes a value for the {@code eyeOffset} property as a {@code reference} value. The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property. Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen. If not specified, the default value is [0.0, 0.0, 0.0].
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
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code horizontalOrigin} property as a {@code reference} value. The {@code horizontalOrigin} property specifies the horizontal origin of the label. It controls whether the label is left-, center-, or right-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code verticalOrigin} property as a {@code reference} value. The {@code verticalOrigin} property specifies the vertical origin of the label. It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}. If not specified, the default value is CENTER.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgba} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeFillColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgbaf} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeFillColorPropertyRgbaf(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code rgbaf} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeFillColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeFillColorPropertyReference(Reference value) {
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeFillColorPropertyReference(String value) {
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFillColorPropertyReference(String identifier, String propertyName) {
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fillColor} property as a {@code reference} value. The {@code fillColor} property specifies the fill color of the label. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFillColorPropertyReference(String identifier, String[] propertyNames) {
        {
            ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOutlineColorPropertyRgbaf(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(Reference value) {
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(String value) {
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlineColorPropertyReference(String identifier, String propertyName) {
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the outline color of the label. If not specified, the default value is black.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlineColorPropertyReference(String identifier, String[] propertyNames) {
        {
            ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlineWidthPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the outline width of the label. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlineWidthPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
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
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
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
    * Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
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
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
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
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
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
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
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
    * Writes a value for the {@code translucencyByDistance} property as a {@code reference} value. The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera. This scalar value should range from 0 to 1.
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
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
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
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
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
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
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
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
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
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
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
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
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
    * Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value. The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera. This scalar value will be multiplied by {@code pixelOffset}.
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
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
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
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
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
    * Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
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
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
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
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
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
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
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
    * Writes a value for the {@code scaleByDistance} property as a {@code reference} value. The {@code scaleByDistance} property specifies how the label's scale should change based on the label's distance from the camera. This scalar value will be multiplied by {@code scale}.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this label will be displayed.
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