package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.NearFarScalarCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a {@code Point} to a {@link CesiumOutputStream}.  A {@code Point} is a point, or viewport-aligned circle.
 

 */
@SuppressWarnings("unused")
public class PointCesiumWriter extends CesiumPropertyWriter<PointCesiumWriter> {
    /**
    *  
    The name of the {@code show} property.
    

    */
    public static final String ShowPropertyName = "show";
    /**
    *  
    The name of the {@code pixelSize} property.
    

    */
    public static final String PixelSizePropertyName = "pixelSize";
    /**
    *  
    The name of the {@code heightReference} property.
    

    */
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    *  
    The name of the {@code color} property.
    

    */
    public static final String ColorPropertyName = "color";
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
    The name of the {@code scaleByDistance} property.
    

    */
    public static final String ScaleByDistancePropertyName = "scaleByDistance";
    /**
    *  
    The name of the {@code translucencyByDistance} property.
    

    */
    public static final String TranslucencyByDistancePropertyName = "translucencyByDistance";
    /**
    *  
    The name of the {@code distanceDisplayCondition} property.
    

    */
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    /**
    *  
    The name of the {@code disableDepthTestDistance} property.
    

    */
    public static final String DisableDepthTestDistancePropertyName = "disableDepthTestDistance";
    private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_pixelSize = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(PixelSizePropertyName);
        }
    }, false);
    private Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<cesiumlanguagewriter.HeightReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.HeightReferenceCesiumWriter>() {
        public cesiumlanguagewriter.HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(ColorPropertyName);
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
    private Lazy<NearFarScalarCesiumWriter> m_scaleByDistance = new Lazy<cesiumlanguagewriter.NearFarScalarCesiumWriter>(new Func1<cesiumlanguagewriter.NearFarScalarCesiumWriter>() {
        public cesiumlanguagewriter.NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(ScaleByDistancePropertyName);
        }
    }, false);
    private Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<cesiumlanguagewriter.NearFarScalarCesiumWriter>(new Func1<cesiumlanguagewriter.NearFarScalarCesiumWriter>() {
        public cesiumlanguagewriter.NearFarScalarCesiumWriter invoke() {
            return new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName);
        }
    }, false);
    private Lazy<DistanceDisplayConditionCesiumWriter> m_distanceDisplayCondition = new Lazy<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter>(
            new Func1<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter>() {
                public cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter invoke() {
                    return new DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionPropertyName);
                }
            }, false);
    private Lazy<DoubleCesiumWriter> m_disableDepthTestDistance = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(DisableDepthTestDistancePropertyName);
        }
    }, false);

    /**
    *  
    Initializes a new instance.
    

    */
    public PointCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected PointCesiumWriter(PointCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public PointCesiumWriter clone() {
        return new PointCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code show} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code show} property defines whether or not the point is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code show} property.  The {@code show} property defines whether or not the point is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code boolean} value.  The {@code show} property specifies whether or not the point is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the point is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the point is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the point is shown.  If not specified, the default value is {@code true}.
    
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the point is shown.  If not specified, the default value is {@code true}.
    
    
    

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
    *  Gets the writer for the {@code pixelSize} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code pixelSize} property defines the size of the point, in pixels.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter getPixelSizeWriter() {
        return m_pixelSize.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code pixelSize} property.  The {@code pixelSize} property defines the size of the point, in pixels.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter openPixelSizeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getPixelSizeWriter());
    }

    /**
    *  
    Writes a value for the {@code pixelSize} property as a {@code number} value.  The {@code pixelSize} property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
    
    

    * @param value The value.
    */
    public final void writePixelSizeProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelSize} property as a {@code number} value.  The {@code pixelSize} property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePixelSizeProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelSize} property as a {@code number} value.  The {@code pixelSize} property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePixelSizeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelSize} property as a {@code reference} value.  The {@code pixelSize} property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
    
    

    * @param value The reference.
    */
    public final void writePixelSizePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelSize} property as a {@code reference} value.  The {@code pixelSize} property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writePixelSizePropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelSize} property as a {@code reference} value.  The {@code pixelSize} property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePixelSizePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code pixelSize} property as a {@code reference} value.  The {@code pixelSize} property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePixelSizePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openPixelSizeProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code heightReference} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code heightReference} property defines the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    

    */
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code heightReference} property.  The {@code heightReference} property defines the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    

    */
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    *  
    Writes a value for the {@code heightReference} property as a {@code heightReference} value.  The {@code heightReference} property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

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
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

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
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    

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
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    
    

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
    Writes a value for the {@code heightReference} property as a {@code reference} value.  The {@code heightReference} property specifies the height reference of the point, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
    
    
    

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
    *  Gets the writer for the {@code color} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code color} property defines the color of the point.
    

    */
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code color} property.  The {@code color} property defines the color of the point.
    

    */
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    *  
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color of the point.
    
    

    * @param color The color.
    */
    public final void writeColorProperty(Color color) {
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
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color of the point.
    
    
    
    
    

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
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color of the point.
    
    
    

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
    Writes a value for the {@code color} property as a {@code rgba} value.  The {@code color} property specifies the color of the point.
    
    
    
    
    

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
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color of the point.
    
    

    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(Color color) {
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
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color of the point.
    
    
    
    
    

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
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color of the point.
    
    
    

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
    Writes a value for the {@code color} property as a {@code rgbaf} value.  The {@code color} property specifies the color of the point.
    
    
    
    
    

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
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color of the point.
    
    

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
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color of the point.
    
    

    * @param value The earliest date of the interval.
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
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color of the point.
    
    
    

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
    Writes a value for the {@code color} property as a {@code reference} value.  The {@code color} property specifies the color of the point.
    
    
    

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
    *  Gets the writer for the {@code outlineColor} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineColor} property defines the color of the outline of the point.
    

    */
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineColor} property.  The {@code outlineColor} property defines the color of the outline of the point.
    

    */
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the outline of the point.
    
    
    

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
    *  Gets the writer for the {@code outlineWidth} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineWidth} property defines the width of the outline of the point.  If not specified, the default value is 0.0.
    

    */
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineWidth} property.  The {@code outlineWidth} property defines the width of the outline of the point.  If not specified, the default value is 0.0.
    

    */
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
    
    
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
    
    
    

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
    *  Gets the writer for the {@code scaleByDistance} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code scaleByDistance} property defines how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    

    */
    public final NearFarScalarCesiumWriter getScaleByDistanceWriter() {
        return m_scaleByDistance.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code scaleByDistance} property.  The {@code scaleByDistance} property defines how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    

    */
    public final NearFarScalarCesiumWriter openScaleByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getScaleByDistanceWriter());
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    

    * @param value The value.
    */
    public final void writeScaleByDistanceProperty(NearFarScalar value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    
    
    
    

    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code nearFarScalar} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeScaleByDistanceProperty(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeNearFarScalar(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code reference} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    

    * @param value The reference.
    */
    public final void writeScaleByDistancePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code reference} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeScaleByDistancePropertyReference(String value) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code reference} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScaleByDistancePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code scaleByDistance} property as a {@code reference} value.  The {@code scaleByDistance} property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by {@code pixelSize}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScaleByDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.NearFarScalarCesiumWriter writer = openScaleByDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code translucencyByDistance} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code translucencyByDistance} property defines how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    

    */
    public final NearFarScalarCesiumWriter getTranslucencyByDistanceWriter() {
        return m_translucencyByDistance.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code translucencyByDistance} property.  The {@code translucencyByDistance} property defines how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    

    */
    public final NearFarScalarCesiumWriter openTranslucencyByDistanceProperty() {
        openIntervalIfNecessary();
        return this.<NearFarScalarCesiumWriter> openAndReturn(getTranslucencyByDistanceWriter());
    }

    /**
    *  
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    

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
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    
    
    

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
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    

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
    Writes a value for the {@code translucencyByDistance} property as a {@code nearFarScalar} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    
    
    

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
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    

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
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    

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
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    

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
    Writes a value for the {@code translucencyByDistance} property as a {@code reference} value.  The {@code translucencyByDistance} property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
    
    
    

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
    *  Gets the writer for the {@code distanceDisplayCondition} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this point will be displayed.
    

    */
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code distanceDisplayCondition} property.  The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this point will be displayed.
    

    */
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    

    * @param value The value.
    */
    public final void writeDistanceDisplayConditionProperty(Bounds value) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    
    

    * @param lowerBound The lower bound.
    * @param upperBound The upper bound.
    */
    public final void writeDistanceDisplayConditionProperty(double lowerBound, double upperBound) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(lowerBound, upperBound);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDistanceDisplayConditionProperty(List<JulianDate> dates, List<Bounds> values) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDistanceDisplayConditionProperty(List<JulianDate> dates, List<Bounds> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeDistanceDisplayCondition(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    

    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String value) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this point will be displayed.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter writer = openDistanceDisplayConditionProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code disableDepthTestDistance} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code disableDepthTestDistance} property defines the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    

    */
    public final DoubleCesiumWriter getDisableDepthTestDistanceWriter() {
        return m_disableDepthTestDistance.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code disableDepthTestDistance} property.  The {@code disableDepthTestDistance} property defines the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    

    */
    public final DoubleCesiumWriter openDisableDepthTestDistanceProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getDisableDepthTestDistanceWriter());
    }

    /**
    *  
    Writes a value for the {@code disableDepthTestDistance} property as a {@code number} value.  The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    
    

    * @param value The value.
    */
    public final void writeDisableDepthTestDistanceProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code disableDepthTestDistance} property as a {@code number} value.  The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDisableDepthTestDistanceProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code disableDepthTestDistance} property as a {@code number} value.  The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDisableDepthTestDistanceProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value.  The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    
    

    * @param value The reference.
    */
    public final void writeDisableDepthTestDistancePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value.  The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value.  The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code disableDepthTestDistance} property as a {@code reference} value.  The {@code disableDepthTestDistance} property specifies the distance from the camera at which to disable the depth test. This can be used to prevent clipping against terrain, for example. When set to zero, the depth test is always applied. When set to Infinity, the depth test is never applied.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDisableDepthTestDistancePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openDisableDepthTestDistanceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}