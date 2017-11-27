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
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.ShadowModeCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a {@code Cylinder} to a {@link CesiumOutputStream}.  A {@code Cylinder} is a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius.
 

 */
@SuppressWarnings("unused")
public class CylinderCesiumWriter extends CesiumPropertyWriter<CylinderCesiumWriter> {
    /**
    *  
    The name of the {@code show} property.
    

    */
    public static final String ShowPropertyName = "show";
    /**
    *  
    The name of the {@code length} property.
    

    */
    public static final String LengthPropertyName = "length";
    /**
    *  
    The name of the {@code topRadius} property.
    

    */
    public static final String TopRadiusPropertyName = "topRadius";
    /**
    *  
    The name of the {@code bottomRadius} property.
    

    */
    public static final String BottomRadiusPropertyName = "bottomRadius";
    /**
    *  
    The name of the {@code fill} property.
    

    */
    public static final String FillPropertyName = "fill";
    /**
    *  
    The name of the {@code material} property.
    

    */
    public static final String MaterialPropertyName = "material";
    /**
    *  
    The name of the {@code outline} property.
    

    */
    public static final String OutlinePropertyName = "outline";
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
    The name of the {@code numberOfVerticalLines} property.
    

    */
    public static final String NumberOfVerticalLinesPropertyName = "numberOfVerticalLines";
    /**
    *  
    The name of the {@code slices} property.
    

    */
    public static final String SlicesPropertyName = "slices";
    /**
    *  
    The name of the {@code shadows} property.
    

    */
    public static final String ShadowsPropertyName = "shadows";
    /**
    *  
    The name of the {@code distanceDisplayCondition} property.
    

    */
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_length = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(LengthPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_topRadius = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(TopRadiusPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_bottomRadius = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(BottomRadiusPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_fill = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(FillPropertyName);
        }
    }, false);
    private Lazy<MaterialCesiumWriter> m_material = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(MaterialPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_outline = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(OutlinePropertyName);
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
    private Lazy<DoubleCesiumWriter> m_numberOfVerticalLines = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(NumberOfVerticalLinesPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_slices = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(SlicesPropertyName);
        }
    }, false);
    private Lazy<ShadowModeCesiumWriter> m_shadows = new Lazy<cesiumlanguagewriter.ShadowModeCesiumWriter>(new Func1<cesiumlanguagewriter.ShadowModeCesiumWriter>() {
        public cesiumlanguagewriter.ShadowModeCesiumWriter invoke() {
            return new ShadowModeCesiumWriter(ShadowsPropertyName);
        }
    }, false);
    private Lazy<DistanceDisplayConditionCesiumWriter> m_distanceDisplayCondition = new Lazy<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter>(
            new Func1<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter>() {
                public cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter invoke() {
                    return new DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionPropertyName);
                }
            }, false);

    /**
    *  
    Initializes a new instance.
    

    */
    public CylinderCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected CylinderCesiumWriter(CylinderCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public CylinderCesiumWriter clone() {
        return new CylinderCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code show} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code show} property defines whether or not the cylinder is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code show} property.  The {@code show} property defines whether or not the cylinder is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code boolean} value.  The {@code show} property specifies whether or not the cylinder is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the cylinder is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the cylinder is shown.  If not specified, the default value is {@code true}.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the cylinder is shown.  If not specified, the default value is {@code true}.
    
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the cylinder is shown.  If not specified, the default value is {@code true}.
    
    
    

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
    *  Gets the writer for the {@code length} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code length} property defines the length of the cylinder.
    

    */
    public final DoubleCesiumWriter getLengthWriter() {
        return m_length.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code length} property.  The {@code length} property defines the length of the cylinder.
    

    */
    public final DoubleCesiumWriter openLengthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getLengthWriter());
    }

    /**
    *  
    Writes a value for the {@code length} property as a {@code number} value.  The {@code length} property specifies the length of the cylinder.
    
    

    * @param value The value.
    */
    public final void writeLengthProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLengthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code length} property as a {@code number} value.  The {@code length} property specifies the length of the cylinder.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeLengthProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLengthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code length} property as a {@code number} value.  The {@code length} property specifies the length of the cylinder.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeLengthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLengthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code length} property as a {@code reference} value.  The {@code length} property specifies the length of the cylinder.
    
    

    * @param value The reference.
    */
    public final void writeLengthPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLengthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code length} property as a {@code reference} value.  The {@code length} property specifies the length of the cylinder.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeLengthPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLengthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code length} property as a {@code reference} value.  The {@code length} property specifies the length of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeLengthPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLengthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code length} property as a {@code reference} value.  The {@code length} property specifies the length of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeLengthPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLengthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code topRadius} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code topRadius} property defines the radius of the top of the cylinder.
    

    */
    public final DoubleCesiumWriter getTopRadiusWriter() {
        return m_topRadius.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code topRadius} property.  The {@code topRadius} property defines the radius of the top of the cylinder.
    

    */
    public final DoubleCesiumWriter openTopRadiusProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getTopRadiusWriter());
    }

    /**
    *  
    Writes a value for the {@code topRadius} property as a {@code number} value.  The {@code topRadius} property specifies the radius of the top of the cylinder.
    
    

    * @param value The value.
    */
    public final void writeTopRadiusProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTopRadiusProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code topRadius} property as a {@code number} value.  The {@code topRadius} property specifies the radius of the top of the cylinder.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTopRadiusProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTopRadiusProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code topRadius} property as a {@code number} value.  The {@code topRadius} property specifies the radius of the top of the cylinder.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeTopRadiusProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTopRadiusProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code topRadius} property as a {@code reference} value.  The {@code topRadius} property specifies the radius of the top of the cylinder.
    
    

    * @param value The reference.
    */
    public final void writeTopRadiusPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTopRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code topRadius} property as a {@code reference} value.  The {@code topRadius} property specifies the radius of the top of the cylinder.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeTopRadiusPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTopRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code topRadius} property as a {@code reference} value.  The {@code topRadius} property specifies the radius of the top of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTopRadiusPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTopRadiusProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code topRadius} property as a {@code reference} value.  The {@code topRadius} property specifies the radius of the top of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTopRadiusPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTopRadiusProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code bottomRadius} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code bottomRadius} property defines the radius of the bottom of the cylinder.
    

    */
    public final DoubleCesiumWriter getBottomRadiusWriter() {
        return m_bottomRadius.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code bottomRadius} property.  The {@code bottomRadius} property defines the radius of the bottom of the cylinder.
    

    */
    public final DoubleCesiumWriter openBottomRadiusProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getBottomRadiusWriter());
    }

    /**
    *  
    Writes a value for the {@code bottomRadius} property as a {@code number} value.  The {@code bottomRadius} property specifies the radius of the bottom of the cylinder.
    
    

    * @param value The value.
    */
    public final void writeBottomRadiusProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openBottomRadiusProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code bottomRadius} property as a {@code number} value.  The {@code bottomRadius} property specifies the radius of the bottom of the cylinder.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBottomRadiusProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openBottomRadiusProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code bottomRadius} property as a {@code number} value.  The {@code bottomRadius} property specifies the radius of the bottom of the cylinder.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBottomRadiusProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openBottomRadiusProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code bottomRadius} property as a {@code reference} value.  The {@code bottomRadius} property specifies the radius of the bottom of the cylinder.
    
    

    * @param value The reference.
    */
    public final void writeBottomRadiusPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openBottomRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code bottomRadius} property as a {@code reference} value.  The {@code bottomRadius} property specifies the radius of the bottom of the cylinder.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeBottomRadiusPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openBottomRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code bottomRadius} property as a {@code reference} value.  The {@code bottomRadius} property specifies the radius of the bottom of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeBottomRadiusPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openBottomRadiusProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code bottomRadius} property as a {@code reference} value.  The {@code bottomRadius} property specifies the radius of the bottom of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeBottomRadiusPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openBottomRadiusProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code fill} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code fill} property defines whether or not the cylinder is filled.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getFillWriter() {
        return m_fill.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code fill} property.  The {@code fill} property defines whether or not the cylinder is filled.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openFillProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
    }

    /**
    *  
    Writes a value for the {@code fill} property as a {@code boolean} value.  The {@code fill} property specifies whether or not the cylinder is filled.  If not specified, the default value is {@code true}.
    
    

    * @param value The value.
    */
    public final void writeFillProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the cylinder is filled.  If not specified, the default value is {@code true}.
    
    

    * @param value The reference.
    */
    public final void writeFillPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the cylinder is filled.  If not specified, the default value is {@code true}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeFillPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the cylinder is filled.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFillPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the cylinder is filled.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFillPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code material} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code material} property defines the material to display on the surface of the cylinder.
    

    */
    public final MaterialCesiumWriter getMaterialWriter() {
        return m_material.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code material} property.  The {@code material} property defines the material to display on the surface of the cylinder.
    

    */
    public final MaterialCesiumWriter openMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
    }

    /**
    *  Gets the writer for the {@code outline} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outline} property defines whether or not the cylinder is outlined.  If not specified, the default value is {@code false}.
    

    */
    public final BooleanCesiumWriter getOutlineWriter() {
        return m_outline.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outline} property.  The {@code outline} property defines whether or not the cylinder is outlined.  If not specified, the default value is {@code false}.
    

    */
    public final BooleanCesiumWriter openOutlineProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
    }

    /**
    *  
    Writes a value for the {@code outline} property as a {@code boolean} value.  The {@code outline} property specifies whether or not the cylinder is outlined.  If not specified, the default value is {@code false}.
    
    

    * @param value The value.
    */
    public final void writeOutlineProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the cylinder is outlined.  If not specified, the default value is {@code false}.
    
    

    * @param value The reference.
    */
    public final void writeOutlinePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the cylinder is outlined.  If not specified, the default value is {@code false}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeOutlinePropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the cylinder is outlined.  If not specified, the default value is {@code false}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlinePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the cylinder is outlined.  If not specified, the default value is {@code false}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlinePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code outlineColor} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineColor} property defines the color of the cylinder outline.
    

    */
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineColor} property.  The {@code outlineColor} property defines the color of the cylinder outline.
    

    */
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the cylinder outline.
    
    
    

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
    *  Gets the writer for the {@code outlineWidth} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineWidth} property defines the width of the cylinder outline.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineWidth} property.  The {@code outlineWidth} property defines the width of the cylinder outline.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the cylinder outline.  If not specified, the default value is 1.0.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the cylinder outline.  If not specified, the default value is 1.0.
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the cylinder outline.  If not specified, the default value is 1.0.
    
    
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the cylinder outline.  If not specified, the default value is 1.0.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the cylinder outline.  If not specified, the default value is 1.0.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the cylinder outline.  If not specified, the default value is 1.0.
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the cylinder outline.  If not specified, the default value is 1.0.
    
    
    

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
    *  Gets the writer for the {@code numberOfVerticalLines} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code numberOfVerticalLines} property defines the number of vertical lines to draw along the perimeter for the outline.
    

    */
    public final DoubleCesiumWriter getNumberOfVerticalLinesWriter() {
        return m_numberOfVerticalLines.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code numberOfVerticalLines} property.  The {@code numberOfVerticalLines} property defines the number of vertical lines to draw along the perimeter for the outline.
    

    */
    public final DoubleCesiumWriter openNumberOfVerticalLinesProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getNumberOfVerticalLinesWriter());
    }

    /**
    *  
    Writes a value for the {@code numberOfVerticalLines} property as a {@code number} value.  The {@code numberOfVerticalLines} property specifies the number of vertical lines to draw along the perimeter for the outline.
    
    

    * @param value The value.
    */
    public final void writeNumberOfVerticalLinesProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfVerticalLines} property as a {@code number} value.  The {@code numberOfVerticalLines} property specifies the number of vertical lines to draw along the perimeter for the outline.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumberOfVerticalLinesProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfVerticalLines} property as a {@code number} value.  The {@code numberOfVerticalLines} property specifies the number of vertical lines to draw along the perimeter for the outline.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumberOfVerticalLinesProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value.  The {@code numberOfVerticalLines} property specifies the number of vertical lines to draw along the perimeter for the outline.
    
    

    * @param value The reference.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value.  The {@code numberOfVerticalLines} property specifies the number of vertical lines to draw along the perimeter for the outline.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value.  The {@code numberOfVerticalLines} property specifies the number of vertical lines to draw along the perimeter for the outline.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value.  The {@code numberOfVerticalLines} property specifies the number of vertical lines to draw along the perimeter for the outline.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code slices} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code slices} property defines the number of edges around the perimeter of the cylinder.
    

    */
    public final DoubleCesiumWriter getSlicesWriter() {
        return m_slices.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code slices} property.  The {@code slices} property defines the number of edges around the perimeter of the cylinder.
    

    */
    public final DoubleCesiumWriter openSlicesProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getSlicesWriter());
    }

    /**
    *  
    Writes a value for the {@code slices} property as a {@code number} value.  The {@code slices} property specifies the number of edges around the perimeter of the cylinder.
    
    

    * @param value The value.
    */
    public final void writeSlicesProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicesProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code slices} property as a {@code number} value.  The {@code slices} property specifies the number of edges around the perimeter of the cylinder.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSlicesProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicesProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code slices} property as a {@code number} value.  The {@code slices} property specifies the number of edges around the perimeter of the cylinder.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSlicesProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicesProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code slices} property as a {@code reference} value.  The {@code slices} property specifies the number of edges around the perimeter of the cylinder.
    
    

    * @param value The reference.
    */
    public final void writeSlicesPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code slices} property as a {@code reference} value.  The {@code slices} property specifies the number of edges around the perimeter of the cylinder.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeSlicesPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code slices} property as a {@code reference} value.  The {@code slices} property specifies the number of edges around the perimeter of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSlicesPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code slices} property as a {@code reference} value.  The {@code slices} property specifies the number of edges around the perimeter of the cylinder.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSlicesPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code shadows} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code shadows} property defines whether or not the cylinder casts or receives shadows.  If not specified, the default value is DISABLED.
    

    */
    public final ShadowModeCesiumWriter getShadowsWriter() {
        return m_shadows.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code shadows} property.  The {@code shadows} property defines whether or not the cylinder casts or receives shadows.  If not specified, the default value is DISABLED.
    

    */
    public final ShadowModeCesiumWriter openShadowsProperty() {
        openIntervalIfNecessary();
        return this.<ShadowModeCesiumWriter> openAndReturn(getShadowsWriter());
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code shadowMode} value.  The {@code shadows} property specifies whether or not the cylinder casts or receives shadows.  If not specified, the default value is DISABLED.
    
    

    * @param value The shadow mode.
    */
    public final void writeShadowsProperty(CesiumShadowMode value) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeShadowMode(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the cylinder casts or receives shadows.  If not specified, the default value is DISABLED.
    
    

    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the cylinder casts or receives shadows.  If not specified, the default value is DISABLED.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShadowsPropertyReference(String value) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the cylinder casts or receives shadows.  If not specified, the default value is DISABLED.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code shadows} property as a {@code reference} value.  The {@code shadows} property specifies whether or not the cylinder casts or receives shadows.  If not specified, the default value is DISABLED.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code distanceDisplayCondition} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this cylinder will be displayed.
    

    */
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code distanceDisplayCondition} property.  The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this cylinder will be displayed.
    

    */
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    *  
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    

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
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    
    

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
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    
    

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
    Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    
    
    
    

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
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    

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
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    

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
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    
    

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
    Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value.  The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this cylinder will be displayed.
    
    
    

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
}