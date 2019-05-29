package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.IntegerCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code PolylineDashMaterial} to a {@link CesiumOutputStream}. A {@code PolylineDashMaterial} is a material that fills the surface of a line with a pattern of dashes.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class PolylineDashMaterialCesiumWriter extends CesiumPropertyWriter<PolylineDashMaterialCesiumWriter> {
    /**
    *  
    The name of the {@code color} property.
    

    */
    public static final String ColorPropertyName = "color";
    /**
    *  
    The name of the {@code gapColor} property.
    

    */
    public static final String GapColorPropertyName = "gapColor";
    /**
    *  
    The name of the {@code dashLength} property.
    

    */
    public static final String DashLengthPropertyName = "dashLength";
    /**
    *  
    The name of the {@code dashPattern} property.
    

    */
    public static final String DashPatternPropertyName = "dashPattern";
    private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(ColorPropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_gapColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(GapColorPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_dashLength = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(DashLengthPropertyName);
        }
    }, false);
    private Lazy<IntegerCesiumWriter> m_dashPattern = new Lazy<cesiumlanguagewriter.IntegerCesiumWriter>(new Func1<cesiumlanguagewriter.IntegerCesiumWriter>() {
        public cesiumlanguagewriter.IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(DashPatternPropertyName);
        }
    }, false);

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public PolylineDashMaterialCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected PolylineDashMaterialCesiumWriter(@Nonnull PolylineDashMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public PolylineDashMaterialCesiumWriter clone() {
        return new PolylineDashMaterialCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code color} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code color} property defines the color of the dashes on the line. If not specified, the default value is white.
    

    */
    @Nonnull
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code color} property. The {@code color} property defines the color of the dashes on the line. If not specified, the default value is white.
    

    */
    @Nonnull
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    

    * @param color The color.
    */
    public final void writeColorProperty(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    

    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    

    * @param value The reference.
    */
    public final void writeColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    

    * @param value The reference.
    */
    public final void writeColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the dashes on the line. If not specified, the default value is white.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code gapColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code gapColor} property defines the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    

    */
    @Nonnull
    public final ColorCesiumWriter getGapColorWriter() {
        return m_gapColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code gapColor} property. The {@code gapColor} property defines the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    

    */
    @Nonnull
    public final ColorCesiumWriter openGapColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getGapColorWriter());
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgba} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    

    * @param color The color.
    */
    public final void writeGapColorProperty(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgba} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeGapColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgba} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeGapColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgba} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeGapColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgbaf} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    

    * @param color The color.
    */
    public final void writeGapColorPropertyRgbaf(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgbaf} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeGapColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgbaf} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeGapColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code rgbaf} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeGapColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code reference} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    

    * @param value The reference.
    */
    public final void writeGapColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code reference} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    

    * @param value The reference.
    */
    public final void writeGapColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code reference} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeGapColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code gapColor} property as a {@code reference} value. The {@code gapColor} property specifies the color of the gaps between dashes on the line. If not specified, the default value is transparent.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeGapColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openGapColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code dashLength} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code dashLength} property defines the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    

    */
    @Nonnull
    public final DoubleCesiumWriter getDashLengthWriter() {
        return m_dashLength.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code dashLength} property. The {@code dashLength} property defines the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    

    */
    @Nonnull
    public final DoubleCesiumWriter openDashLengthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getDashLengthWriter());
    }

    /**
    *  
    Writes a value for the {@code dashLength} property as a {@code number} value. The {@code dashLength} property specifies the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    
    

    * @param value The value.
    */
    public final void writeDashLengthProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDashLengthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashLength} property as a {@code number} value. The {@code dashLength} property specifies the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDashLengthProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDashLengthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashLength} property as a {@code number} value. The {@code dashLength} property specifies the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDashLengthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDashLengthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashLength} property as a {@code reference} value. The {@code dashLength} property specifies the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    
    

    * @param value The reference.
    */
    public final void writeDashLengthPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDashLengthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashLength} property as a {@code reference} value. The {@code dashLength} property specifies the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    
    

    * @param value The reference.
    */
    public final void writeDashLengthPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDashLengthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashLength} property as a {@code reference} value. The {@code dashLength} property specifies the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDashLengthPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDashLengthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashLength} property as a {@code reference} value. The {@code dashLength} property specifies the length in screen-space pixels of a single dash and gap pattern. If not specified, the default value is 16.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDashLengthPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDashLengthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code dashPattern} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code dashPattern} property defines a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    

    */
    @Nonnull
    public final IntegerCesiumWriter getDashPatternWriter() {
        return m_dashPattern.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code dashPattern} property. The {@code dashPattern} property defines a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    

    */
    @Nonnull
    public final IntegerCesiumWriter openDashPatternProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getDashPatternWriter());
    }

    /**
    *  
    Writes a value for the {@code dashPattern} property as a {@code number} value. The {@code dashPattern} property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    
    

    * @param value The value.
    */
    public final void writeDashPatternProperty(int value) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openDashPatternProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashPattern} property as a {@code number} value. The {@code dashPattern} property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDashPatternProperty(List<JulianDate> dates, List<Integer> values) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openDashPatternProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashPattern} property as a {@code number} value. The {@code dashPattern} property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDashPatternProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openDashPatternProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashPattern} property as a {@code reference} value. The {@code dashPattern} property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    
    

    * @param value The reference.
    */
    public final void writeDashPatternPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openDashPatternProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashPattern} property as a {@code reference} value. The {@code dashPattern} property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    
    

    * @param value The reference.
    */
    public final void writeDashPatternPropertyReference(String value) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openDashPatternProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashPattern} property as a {@code reference} value. The {@code dashPattern} property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDashPatternPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openDashPatternProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code dashPattern} property as a {@code reference} value. The {@code dashPattern} property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0). The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash. If not specified, the default value is 255.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDashPatternPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openDashPatternProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}