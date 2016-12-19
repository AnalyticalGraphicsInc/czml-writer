package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BackgroundPaddingCesiumWriter;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
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

/**
 *  
 Writes a {@code Label} to a  {@link CesiumOutputStream}.  A {@code Label} is a string of text.
 

 */
public class LabelCesiumWriter extends CesiumPropertyWriter<LabelCesiumWriter> {
    /**
    *  
    The name of the {@code show} property.
    

    */
    public static final String ShowPropertyName = "show";
    /**
    *  
    The name of the {@code text} property.
    

    */
    public static final String TextPropertyName = "text";
    /**
    *  
    The name of the {@code font} property.
    

    */
    public static final String FontPropertyName = "font";
    /**
    *  
    The name of the {@code style} property.
    

    */
    public static final String StylePropertyName = "style";
    /**
    *  
    The name of the {@code scale} property.
    

    */
    public static final String ScalePropertyName = "scale";
    /**
    *  
    The name of the {@code showBackground} property.
    

    */
    public static final String ShowBackgroundPropertyName = "showBackground";
    /**
    *  
    The name of the {@code backgroundColor} property.
    

    */
    public static final String BackgroundColorPropertyName = "backgroundColor";
    /**
    *  
    The name of the {@code backgroundPadding} property.
    

    */
    public static final String BackgroundPaddingPropertyName = "backgroundPadding";
    /**
    *  
    The name of the {@code pixelOffset} property.
    

    */
    public static final String PixelOffsetPropertyName = "pixelOffset";
    /**
    *  
    The name of the {@code eyeOffset} property.
    

    */
    public static final String EyeOffsetPropertyName = "eyeOffset";
    /**
    *  
    The name of the {@code horizontalOrigin} property.
    

    */
    public static final String HorizontalOriginPropertyName = "horizontalOrigin";
    /**
    *  
    The name of the {@code verticalOrigin} property.
    

    */
    public static final String VerticalOriginPropertyName = "verticalOrigin";
    /**
    *  
    The name of the {@code heightReference} property.
    

    */
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    *  
    The name of the {@code fillColor} property.
    

    */
    public static final String FillColorPropertyName = "fillColor";
    /**
    *  
    The name of the {@code outlineColor} property.
    

    */
    public static final String OutlineColorPropertyName = "outlineColor";
    /**
    *  
    The name of the {@code outlineWidth} property.
    

    */
    public static final String OutlineWidthPropertyName = "outlineWidth";
    /**
    *  
    The name of the {@code translucencyByDistance} property.
    

    */
    public static final String TranslucencyByDistancePropertyName = "translucencyByDistance";
    /**
    *  
    The name of the {@code pixelOffsetScaleByDistance} property.
    

    */
    public static final String PixelOffsetScaleByDistancePropertyName = "pixelOffsetScaleByDistance";
    private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    private Lazy<StringCesiumWriter> m_text = new Lazy<cesiumlanguagewriter.StringCesiumWriter>(new Func1<cesiumlanguagewriter.StringCesiumWriter>() {
        public cesiumlanguagewriter.StringCesiumWriter invoke() {
            return new StringCesiumWriter(TextPropertyName);
        }
    }, false);
    private Lazy<FontCesiumWriter> m_font = new Lazy<cesiumlanguagewriter.FontCesiumWriter>(new Func1<cesiumlanguagewriter.FontCesiumWriter>() {
        public cesiumlanguagewriter.FontCesiumWriter invoke() {
            return new FontCesiumWriter(FontPropertyName);
        }
    }, false);
    private Lazy<LabelStyleCesiumWriter> m_style = new Lazy<cesiumlanguagewriter.LabelStyleCesiumWriter>(new Func1<cesiumlanguagewriter.LabelStyleCesiumWriter>() {
        public cesiumlanguagewriter.LabelStyleCesiumWriter invoke() {
            return new LabelStyleCesiumWriter(StylePropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_scale = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ScalePropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_showBackground = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowBackgroundPropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_backgroundColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(BackgroundColorPropertyName);
        }
    }, false);
    private Lazy<BackgroundPaddingCesiumWriter> m_backgroundPadding = new Lazy<cesiumlanguagewriter.BackgroundPaddingCesiumWriter>(new Func1<cesiumlanguagewriter.BackgroundPaddingCesiumWriter>() {
        public cesiumlanguagewriter.BackgroundPaddingCesiumWriter invoke() {
            return new BackgroundPaddingCesiumWriter(BackgroundPaddingPropertyName);
        }
    }, false);
    private Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<cesiumlanguagewriter.PixelOffsetCesiumWriter>(new Func1<cesiumlanguagewriter.PixelOffsetCesiumWriter>() {
        public cesiumlanguagewriter.PixelOffsetCesiumWriter invoke() {
            return new PixelOffsetCesiumWriter(PixelOffsetPropertyName);
        }
    }, false);
    private Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<cesiumlanguagewriter.EyeOffsetCesiumWriter>(new Func1<cesiumlanguagewriter.EyeOffsetCesiumWriter>() {
        public cesiumlanguagewriter.EyeOffsetCesiumWriter invoke() {
            return new EyeOffsetCesiumWriter(EyeOffsetPropertyName);
        }
    }, false);
    private Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<cesiumlanguagewriter.HorizontalOriginCesiumWriter>(new Func1<cesiumlanguagewriter.HorizontalOriginCesiumWriter>() {
        public cesiumlanguagewriter.HorizontalOriginCesiumWriter invoke() {
            return new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName);
        }
    }, false);
    private Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<cesiumlanguagewriter.VerticalOriginCesiumWriter>(new Func1<cesiumlanguagewriter.VerticalOriginCesiumWriter>() {
        public cesiumlanguagewriter.VerticalOriginCesiumWriter invoke() {
            return new VerticalOriginCesiumWriter(VerticalOriginPropertyName);
        }
    }, false);
    private Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<cesiumlanguagewriter.HeightReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.HeightReferenceCesiumWriter>() {
        public cesiumlanguagewriter.HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_fillColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(FillColorPropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(OutlineColorPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(OutlineWidthPropertyName);
        }
    }, false);
    private Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<cesiumlanguagewriter.NearFarScalarCesiumWriter>(new Func1<cesiumlanguagewriter.NearFarScalarCesiumWriter>() {
        public cesiumlanguagewriter.NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName);
        }
    }, false);
    private Lazy<NearFarScalarCesiumWriter> m_pixelOffsetScaleByDistance = new Lazy<cesiumlanguagewriter.NearFarScalarCesiumWriter>(new Func1<cesiumlanguagewriter.NearFarScalarCesiumWriter>() {
        public cesiumlanguagewriter.NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(PixelOffsetScaleByDistancePropertyName);
        }
    }, false);

    /**
    *  
    Initializes a new instance.
    

    */
    public LabelCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected LabelCesiumWriter(LabelCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public LabelCesiumWriter clone() {
        return new LabelCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code show} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code show} property defines whether or not the label is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code show} property.  The {@code show} property defines whether or not the label is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code boolean} value.  The {@code show} property specifies whether or not the label is shown.  If not specified, the default value is {@code true}.
    
    

    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the label is shown.  If not specified, the default value is {@code true}.
    
    

    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the label is shown.  If not specified, the default value is {@code true}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the label is shown.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the label is shown.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code text} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code text} property defines the text displayed by the label.  The newline character (\n) indicates line breaks.
    

    */
    public final StringCesiumWriter getTextWriter() {
        return m_text.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code text} property.  The {@code text} property defines the text displayed by the label.  The newline character (\n) indicates line breaks.
    

    */
    public final StringCesiumWriter openTextProperty() {
        openIntervalIfNecessary();
        return this.<StringCesiumWriter> openAndReturn(getTextWriter());
    }

    /**
    *  
    Writes a value for the {@code text} property as a {@code string} value.  The {@code text} property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
    
    

    * @param value The value.
    */
    public final void writeTextProperty(String value) {
        {
            cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeString(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code text} property as a {@code reference} value.  The {@code text} property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
    
    

    * @param value The reference.
    */
    public final void writeTextPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code text} property as a {@code reference} value.  The {@code text} property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeTextPropertyReference(String value) {
        {
            cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code text} property as a {@code reference} value.  The {@code text} property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTextPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code text} property as a {@code reference} value.  The {@code text} property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTextPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.StringCesiumWriter writer = openTextProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code font} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code font} property defines the font to use for the label.
    

    */
    public final FontCesiumWriter getFontWriter() {
        return m_font.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code font} property.  The {@code font} property defines the font to use for the label.
    

    */
    public final FontCesiumWriter openFontProperty() {
        openIntervalIfNecessary();
        return this.<FontCesiumWriter> openAndReturn(getFontWriter());
    }

    /**
    *  
    Writes a value for the {@code font} property as a {@code font} value.  The {@code font} property specifies the font to use for the label.
    
    

    * @param font The font.
    */
    public final void writeFontProperty(String font) {
        {
            cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeFont(font);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code font} property as a {@code reference} value.  The {@code font} property specifies the font to use for the label.
    
    

    * @param value The reference.
    */
    public final void writeFontPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code font} property as a {@code reference} value.  The {@code font} property specifies the font to use for the label.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeFontPropertyReference(String value) {
        {
            cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code font} property as a {@code reference} value.  The {@code font} property specifies the font to use for the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFontPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code font} property as a {@code reference} value.  The {@code font} property specifies the font to use for the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFontPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.FontCesiumWriter writer = openFontProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code style} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code style} property defines the style of the label.
    

    */
    public final LabelStyleCesiumWriter getStyleWriter() {
        return m_style.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code style} property.  The {@code style} property defines the style of the label.
    

    */
    public final LabelStyleCesiumWriter openStyleProperty() {
        openIntervalIfNecessary();
        return this.<LabelStyleCesiumWriter> openAndReturn(getStyleWriter());
    }

    /**
    *  
    Writes a value for the {@code style} property as a {@code labelStyle} value.  The {@code style} property specifies the style of the label.
    
    

    * @param value The label style.
    */
    public final void writeStyleProperty(CesiumLabelStyle value) {
        {
            cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeLabelStyle(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code style} property as a {@code reference} value.  The {@code style} property specifies the style of the label.
    
    

    * @param value The reference.
    */
    public final void writeStylePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code style} property as a {@code reference} value.  The {@code style} property specifies the style of the label.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeStylePropertyReference(String value) {
        {
            cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code style} property as a {@code reference} value.  The {@code style} property specifies the style of the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeStylePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code style} property as a {@code reference} value.  The {@code style} property specifies the style of the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeStylePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.LabelStyleCesiumWriter writer = openStyleProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code scale} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code scale} property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter getScaleWriter() {
        return m_scale.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code scale} property.  The {@code scale} property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter openScaleProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getScaleWriter());
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code number} value.  The {@code scale} property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    
    

    * @param value The value.
    */
    public final void writeScaleProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code number} value.  The {@code scale} property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code number} value.  The {@code scale} property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    
    

    * @param value The reference.
    */
    public final void writeScalePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeScalePropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scale} property as a {@code reference} value.  The {@code scale} property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code showBackground} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showBackground} property defines whether or not a background behind the label is shown.  If not specified, the default value is {@code false}.
    

    */
    public final BooleanCesiumWriter getShowBackgroundWriter() {
        return m_showBackground.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showBackground} property.  The {@code showBackground} property defines whether or not a background behind the label is shown.  If not specified, the default value is {@code false}.
    

    */
    public final BooleanCesiumWriter openShowBackgroundProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowBackgroundWriter());
    }

    /**
    *  
    Writes a value for the {@code showBackground} property as a {@code boolean} value.  The {@code showBackground} property specifies whether or not a background behind the label is shown.  If not specified, the default value is {@code false}.
    
    

    * @param value The value.
    */
    public final void writeShowBackgroundProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showBackground} property as a {@code reference} value.  The {@code showBackground} property specifies whether or not a background behind the label is shown.  If not specified, the default value is {@code false}.
    
    

    * @param value The reference.
    */
    public final void writeShowBackgroundPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showBackground} property as a {@code reference} value.  The {@code showBackground} property specifies whether or not a background behind the label is shown.  If not specified, the default value is {@code false}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowBackgroundPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showBackground} property as a {@code reference} value.  The {@code showBackground} property specifies whether or not a background behind the label is shown.  If not specified, the default value is {@code false}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowBackgroundPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showBackground} property as a {@code reference} value.  The {@code showBackground} property specifies whether or not a background behind the label is shown.  If not specified, the default value is {@code false}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowBackgroundPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowBackgroundProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code backgroundColor} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code backgroundColor} property defines the color of the background behind the label.
    

    */
    public final ColorCesiumWriter getBackgroundColorWriter() {
        return m_backgroundColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code backgroundColor} property.  The {@code backgroundColor} property defines the color of the background behind the label.
    

    */
    public final ColorCesiumWriter openBackgroundColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getBackgroundColorWriter());
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgba} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    

    * @param color The color.
    */
    public final void writeBackgroundColorProperty(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgba} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeBackgroundColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgba} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgba} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBackgroundColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    

    * @param color The color.
    */
    public final void writeBackgroundColorPropertyRgbaf(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeBackgroundColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code rgbaf} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBackgroundColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code reference} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    

    * @param value The reference.
    */
    public final void writeBackgroundColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code reference} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeBackgroundColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code reference} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeBackgroundColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundColor} property as a {@code reference} value.  The {@code backgroundColor} property specifies the color of the background behind the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeBackgroundColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openBackgroundColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code backgroundPadding} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code backgroundPadding} property defines the amount of padding between the text and the label's background.
    

    */
    public final BackgroundPaddingCesiumWriter getBackgroundPaddingWriter() {
        return m_backgroundPadding.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code backgroundPadding} property.  The {@code backgroundPadding} property defines the amount of padding between the text and the label's background.
    

    */
    public final BackgroundPaddingCesiumWriter openBackgroundPaddingProperty() {
        openIntervalIfNecessary();
        return this.<BackgroundPaddingCesiumWriter> openAndReturn(getBackgroundPaddingWriter());
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    

    * @param value The value.
    */
    public final void writeBackgroundPaddingProperty(Rectangular value) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    
    

    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeBackgroundPaddingProperty(double x, double y) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(x, y);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBackgroundPaddingProperty(List<JulianDate> dates, List<Rectangular> values) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code cartesian2} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBackgroundPaddingProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeCartesian2(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code reference} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    

    * @param value The reference.
    */
    public final void writeBackgroundPaddingPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code reference} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeBackgroundPaddingPropertyReference(String value) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code reference} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeBackgroundPaddingPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code backgroundPadding} property as a {@code reference} value.  The {@code backgroundPadding} property specifies the amount of padding between the text and the label's background.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeBackgroundPaddingPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BackgroundPaddingCesiumWriter writer = openBackgroundPaddingProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code pixelOffset} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code pixelOffset} property defines the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    

    */
    public final PixelOffsetCesiumWriter getPixelOffsetWriter() {
        return m_pixelOffset.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code pixelOffset} property.  The {@code pixelOffset} property defines the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    

    */
    public final PixelOffsetCesiumWriter openPixelOffsetProperty() {
        openIntervalIfNecessary();
        return this.<PixelOffsetCesiumWriter> openAndReturn(getPixelOffsetWriter());
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    

    * @param value The value.
    */
    public final void writePixelOffsetProperty(Rectangular value) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    
    

    * @param x The X component.
    * @param y The Y component.
    */
    public final void writePixelOffsetProperty(double x, double y) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(x, y);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code cartesian2} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePixelOffsetProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeCartesian2(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code reference} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    

    * @param value The reference.
    */
    public final void writePixelOffsetPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code reference} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writePixelOffsetPropertyReference(String value) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code reference} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePixelOffsetPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffset} property as a {@code reference} value.  The {@code pixelOffset} property specifies the offset, in viewport pixels, of the label origin from the {@code position}.  A pixel offset is the number of pixels up and to the right to place the label, relative to the {@code position}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePixelOffsetPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.PixelOffsetCesiumWriter writer = openPixelOffsetProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code eyeOffset} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code eyeOffset} property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    

    */
    public final EyeOffsetCesiumWriter getEyeOffsetWriter() {
        return m_eyeOffset.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code eyeOffset} property.  The {@code eyeOffset} property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    

    */
    public final EyeOffsetCesiumWriter openEyeOffsetProperty() {
        openIntervalIfNecessary();
        return this.<EyeOffsetCesiumWriter> openAndReturn(getEyeOffsetWriter());
    }

    /**
    *  
    Writes a value for the {@code eyeOffset} property as a {@code cartesian} value.  The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    
    

    * @param value The value.
    */
    public final void writeEyeOffsetProperty(Cartesian value) {
        {
            cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeCartesian(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code eyeOffset} property as a {@code cartesian} value.  The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values) {
        {
            cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeCartesian(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code eyeOffset} property as a {@code cartesian} value.  The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEyeOffsetProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeCartesian(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code eyeOffset} property as a {@code reference} value.  The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    
    

    * @param value The reference.
    */
    public final void writeEyeOffsetPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code eyeOffset} property as a {@code reference} value.  The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeEyeOffsetPropertyReference(String value) {
        {
            cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code eyeOffset} property as a {@code reference} value.  The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEyeOffsetPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code eyeOffset} property as a {@code reference} value.  The {@code eyeOffset} property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the {@code position} property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEyeOffsetPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.EyeOffsetCesiumWriter writer = openEyeOffsetProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code horizontalOrigin} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code horizontalOrigin} property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the {@code position}.  If not specified, the default value is CENTER.
    

    */
    public final HorizontalOriginCesiumWriter getHorizontalOriginWriter() {
        return m_horizontalOrigin.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code horizontalOrigin} property.  The {@code horizontalOrigin} property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the {@code position}.  If not specified, the default value is CENTER.
    

    */
    public final HorizontalOriginCesiumWriter openHorizontalOriginProperty() {
        openIntervalIfNecessary();
        return this.<HorizontalOriginCesiumWriter> openAndReturn(getHorizontalOriginWriter());
    }

    /**
    *  
    Writes a value for the {@code horizontalOrigin} property as a {@code horizontalOrigin} value.  The {@code horizontalOrigin} property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    

    * @param value The horizontal origin.
    */
    public final void writeHorizontalOriginProperty(CesiumHorizontalOrigin value) {
        {
            cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeHorizontalOrigin(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code horizontalOrigin} property as a {@code reference} value.  The {@code horizontalOrigin} property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    

    * @param value The reference.
    */
    public final void writeHorizontalOriginPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code horizontalOrigin} property as a {@code reference} value.  The {@code horizontalOrigin} property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeHorizontalOriginPropertyReference(String value) {
        {
            cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code horizontalOrigin} property as a {@code reference} value.  The {@code horizontalOrigin} property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHorizontalOriginPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code horizontalOrigin} property as a {@code reference} value.  The {@code horizontalOrigin} property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHorizontalOriginPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.HorizontalOriginCesiumWriter writer = openHorizontalOriginProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code verticalOrigin} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code verticalOrigin} property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}.  If not specified, the default value is CENTER.
    

    */
    public final VerticalOriginCesiumWriter getVerticalOriginWriter() {
        return m_verticalOrigin.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code verticalOrigin} property.  The {@code verticalOrigin} property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}.  If not specified, the default value is CENTER.
    

    */
    public final VerticalOriginCesiumWriter openVerticalOriginProperty() {
        openIntervalIfNecessary();
        return this.<VerticalOriginCesiumWriter> openAndReturn(getVerticalOriginWriter());
    }

    /**
    *  
    Writes a value for the {@code verticalOrigin} property as a {@code verticalOrigin} value.  The {@code verticalOrigin} property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    

    * @param value The vertical origin.
    */
    public final void writeVerticalOriginProperty(CesiumVerticalOrigin value) {
        {
            cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeVerticalOrigin(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code verticalOrigin} property as a {@code reference} value.  The {@code verticalOrigin} property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    

    * @param value The reference.
    */
    public final void writeVerticalOriginPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code verticalOrigin} property as a {@code reference} value.  The {@code verticalOrigin} property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeVerticalOriginPropertyReference(String value) {
        {
            cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code verticalOrigin} property as a {@code reference} value.  The {@code verticalOrigin} property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeVerticalOriginPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code verticalOrigin} property as a {@code reference} value.  The {@code verticalOrigin} property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the {@code position}.  If not specified, the default value is CENTER.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeVerticalOriginPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.VerticalOriginCesiumWriter writer = openVerticalOriginProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code heightReference} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code heightReference} property defines the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    

    */
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code heightReference} property.  The {@code heightReference} property defines the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    

    */
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code heightReference} value.  The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

    * @param value The height reference.
    */
    public final void writeHeightReferenceProperty(CesiumHeightReference value) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeHeightReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeHeightReferencePropertyReference(String value) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHeightReferencePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.HeightReferenceCesiumWriter writer = openHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code fillColor} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code fillColor} property defines the fill color of the label.
    

    */
    public final ColorCesiumWriter getFillColorWriter() {
        return m_fillColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code fillColor} property.  The {@code fillColor} property defines the fill color of the label.
    

    */
    public final ColorCesiumWriter openFillColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getFillColorWriter());
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgba} value.  The {@code fillColor} property specifies the fill color of the label.
    
    

    * @param color The color.
    */
    public final void writeFillColorProperty(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgba} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeFillColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgba} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeFillColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgba} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeFillColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgbaf} value.  The {@code fillColor} property specifies the fill color of the label.
    
    

    * @param color The color.
    */
    public final void writeFillColorPropertyRgbaf(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgbaf} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeFillColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgbaf} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeFillColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code rgbaf} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeFillColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code reference} value.  The {@code fillColor} property specifies the fill color of the label.
    
    

    * @param value The reference.
    */
    public final void writeFillColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code reference} value.  The {@code fillColor} property specifies the fill color of the label.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeFillColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code reference} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFillColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fillColor} property as a {@code reference} value.  The {@code fillColor} property specifies the fill color of the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFillColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openFillColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code outlineColor} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineColor} property defines the outline color of the label.
    

    */
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineColor} property.  The {@code outlineColor} property defines the outline color of the label.
    

    */
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    

    * @param color The color.
    */
    public final void writeOutlineColorProperty(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeOutlineColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    

    * @param color The color.
    */
    public final void writeOutlineColorPropertyRgbaf(Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeOutlineColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    

    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeOutlineColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlineColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the outline color of the label.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlineColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code outlineWidth} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineWidth} property defines the outline width of the label.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineWidth} property.  The {@code outlineWidth} property defines the outline width of the label.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the outline width of the label.  If not specified, the default value is 1.0.
    
    

    * @param value The value.
    */
    public final void writeOutlineWidthProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the outline width of the label.  If not specified, the default value is 1.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the outline width of the label.  If not specified, the default value is 1.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the outline width of the label.  If not specified, the default value is 1.0.
    
    

    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the outline width of the label.  If not specified, the default value is 1.0.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeOutlineWidthPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the outline width of the label.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlineWidthPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the outline width of the label.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlineWidthPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code translucencyByDistance} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code translucencyByDistance} property defines how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    

    */
    public final NearFarScalarCesiumWriter getTranslucencyByDistanceWriter() {
        return m_translucencyByDistance.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code translucencyByDistance} property.  The {@code translucencyByDistance} property defines how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    

    */
    public final NearFarScalarCesiumWriter openTranslucencyByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getTranslucencyByDistanceWriter());
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    

    * @param value The value.
    */
    public final void writeTranslucencyByDistanceProperty(NearFarScalar value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    
    
    

    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeTranslucencyByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeTranslucencyByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    

    * @param value The reference.
    */
    public final void writeTranslucencyByDistancePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeTranslucencyByDistancePropertyReference(String value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTranslucencyByDistancePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTranslucencyByDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openTranslucencyByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code pixelOffsetScaleByDistance} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code pixelOffsetScaleByDistance} property defines how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    

    */
    public final NearFarScalarCesiumWriter getPixelOffsetScaleByDistanceWriter() {
        return m_pixelOffsetScaleByDistance.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code pixelOffsetScaleByDistance} property.  The {@code pixelOffsetScaleByDistance} property defines how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    

    */
    public final NearFarScalarCesiumWriter openPixelOffsetScaleByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getPixelOffsetScaleByDistanceWriter());
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    

    * @param value The value.
    */
    public final void writePixelOffsetScaleByDistanceProperty(NearFarScalar value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    
    
    
    

    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writePixelOffsetScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code nearFarScalar} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePixelOffsetScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    

    * @param value The reference.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelOffsetScaleByDistance} property as a {@code reference} value.  The {@code pixelOffsetScaleByDistance} property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by {@code pixelOffset}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePixelOffsetScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openPixelOffsetScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}