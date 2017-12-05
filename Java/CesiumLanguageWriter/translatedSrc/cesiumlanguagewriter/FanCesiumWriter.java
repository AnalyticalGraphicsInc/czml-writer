package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DirectionListCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.IntegerCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code Fan} to a {@link CesiumOutputStream}.  A {@code Fan} is a fan.  A fan starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the fan extending to the specified radius.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class FanCesiumWriter extends CesiumPropertyWriter<FanCesiumWriter> {
    /**
    *  
    The name of the {@code show} property.
    

    */
    public static final String ShowPropertyName = "show";
    /**
    *  
    The name of the {@code directions} property.
    

    */
    public static final String DirectionsPropertyName = "directions";
    /**
    *  
    The name of the {@code radius} property.
    

    */
    public static final String RadiusPropertyName = "radius";
    /**
    *  
    The name of the {@code perDirectionRadius} property.
    

    */
    public static final String PerDirectionRadiusPropertyName = "perDirectionRadius";
    /**
    *  
    The name of the {@code material} property.
    

    */
    public static final String MaterialPropertyName = "material";
    /**
    *  
    The name of the {@code fill} property.
    

    */
    public static final String FillPropertyName = "fill";
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
    The name of the {@code numberOfRings} property.
    

    */
    public static final String NumberOfRingsPropertyName = "numberOfRings";
    private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    private Lazy<DirectionListCesiumWriter> m_directions = new Lazy<cesiumlanguagewriter.DirectionListCesiumWriter>(new Func1<cesiumlanguagewriter.DirectionListCesiumWriter>() {
        public cesiumlanguagewriter.DirectionListCesiumWriter invoke() {
            return new DirectionListCesiumWriter(DirectionsPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_radius = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(RadiusPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_perDirectionRadius = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(PerDirectionRadiusPropertyName);
        }
    }, false);
    private Lazy<MaterialCesiumWriter> m_material = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(MaterialPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_fill = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(FillPropertyName);
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
    private Lazy<IntegerCesiumWriter> m_numberOfRings = new Lazy<cesiumlanguagewriter.IntegerCesiumWriter>(new Func1<cesiumlanguagewriter.IntegerCesiumWriter>() {
        public cesiumlanguagewriter.IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(NumberOfRingsPropertyName);
        }
    }, false);

    /**
    *  
    Initializes a new instance.
    

    */
    public FanCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected FanCesiumWriter(FanCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public FanCesiumWriter clone() {
        return new FanCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code show} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code show} property defines whether or not the fan is shown.
    

    */
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code show} property.  The {@code show} property defines whether or not the fan is shown.
    

    */
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code boolean} value.  The {@code show} property specifies whether or not the fan is shown.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the fan is shown.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the fan is shown.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the fan is shown.
    
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the fan is shown.
    
    
    

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
    *  Gets the writer for the {@code directions} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code directions} property defines the list of directions defining the fan.
    

    */
    public final DirectionListCesiumWriter getDirectionsWriter() {
        return m_directions.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code directions} property.  The {@code directions} property defines the list of directions defining the fan.
    

    */
    public final DirectionListCesiumWriter openDirectionsProperty() {
        openIntervalIfNecessary();
        return this.<DirectionListCesiumWriter> openAndReturn(getDirectionsWriter());
    }

    /**
    *  
    Writes a value for the {@code directions} property as a {@code spherical} value.  The {@code directions} property specifies the list of directions defining the fan.
    
    

    * @param values The values.
    */
    public final void writeDirectionsProperty(Iterable<Spherical> values) {
        {
            cesiumlanguagewriter.DirectionListCesiumWriter writer = openDirectionsProperty();
            try {
                writer.writeSpherical(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code directions} property as a {@code unitSpherical} value.  The {@code directions} property specifies the list of directions defining the fan.
    
    

    * @param values The values.
    */
    public final void writeDirectionsPropertyUnitSpherical(Iterable<UnitSpherical> values) {
        {
            cesiumlanguagewriter.DirectionListCesiumWriter writer = openDirectionsProperty();
            try {
                writer.writeUnitSpherical(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code directions} property as a {@code cartesian} value.  The {@code directions} property specifies the list of directions defining the fan.
    
    

    * @param values The values.
    */
    public final void writeDirectionsPropertyCartesian(Iterable<Cartesian> values) {
        {
            cesiumlanguagewriter.DirectionListCesiumWriter writer = openDirectionsProperty();
            try {
                writer.writeCartesian(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code directions} property as a {@code unitCartesian} value.  The {@code directions} property specifies the list of directions defining the fan.
    
    

    * @param values The values.
    */
    public final void writeDirectionsPropertyUnitCartesian(Iterable<UnitCartesian> values) {
        {
            cesiumlanguagewriter.DirectionListCesiumWriter writer = openDirectionsProperty();
            try {
                writer.writeUnitCartesian(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code radius} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code radius} property defines the radial limit of the fan.
    

    */
    public final DoubleCesiumWriter getRadiusWriter() {
        return m_radius.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code radius} property.  The {@code radius} property defines the radial limit of the fan.
    

    */
    public final DoubleCesiumWriter openRadiusProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getRadiusWriter());
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code number} value.  The {@code radius} property specifies the radial limit of the fan.
    
    

    * @param value The value.
    */
    public final void writeRadiusProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code number} value.  The {@code radius} property specifies the radial limit of the fan.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRadiusProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code number} value.  The {@code radius} property specifies the radial limit of the fan.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRadiusProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the fan.
    
    

    * @param value The reference.
    */
    public final void writeRadiusPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the fan.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeRadiusPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the fan.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRadiusPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the fan.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRadiusPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code perDirectionRadius} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code perDirectionRadius} property defines whether the magnitude of each direction is used instead of a constant radius.
    

    */
    public final BooleanCesiumWriter getPerDirectionRadiusWriter() {
        return m_perDirectionRadius.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code perDirectionRadius} property.  The {@code perDirectionRadius} property defines whether the magnitude of each direction is used instead of a constant radius.
    

    */
    public final BooleanCesiumWriter openPerDirectionRadiusProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getPerDirectionRadiusWriter());
    }

    /**
    *  
    Writes a value for the {@code perDirectionRadius} property as a {@code boolean} value.  The {@code perDirectionRadius} property specifies whether the magnitude of each direction is used instead of a constant radius.
    
    

    * @param value The value.
    */
    public final void writePerDirectionRadiusProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openPerDirectionRadiusProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code perDirectionRadius} property as a {@code reference} value.  The {@code perDirectionRadius} property specifies whether the magnitude of each direction is used instead of a constant radius.
    
    

    * @param value The reference.
    */
    public final void writePerDirectionRadiusPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openPerDirectionRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code perDirectionRadius} property as a {@code reference} value.  The {@code perDirectionRadius} property specifies whether the magnitude of each direction is used instead of a constant radius.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writePerDirectionRadiusPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openPerDirectionRadiusProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code perDirectionRadius} property as a {@code reference} value.  The {@code perDirectionRadius} property specifies whether the magnitude of each direction is used instead of a constant radius.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePerDirectionRadiusPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openPerDirectionRadiusProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code perDirectionRadius} property as a {@code reference} value.  The {@code perDirectionRadius} property specifies whether the magnitude of each direction is used instead of a constant radius.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePerDirectionRadiusPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openPerDirectionRadiusProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code material} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code material} property defines the material to display on the surface of the fan.
    

    */
    public final MaterialCesiumWriter getMaterialWriter() {
        return m_material.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code material} property.  The {@code material} property defines the material to display on the surface of the fan.
    

    */
    public final MaterialCesiumWriter openMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
    }

    /**
    *  Gets the writer for the {@code fill} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code fill} property defines whether or not the fan is filled.
    

    */
    public final BooleanCesiumWriter getFillWriter() {
        return m_fill.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code fill} property.  The {@code fill} property defines whether or not the fan is filled.
    

    */
    public final BooleanCesiumWriter openFillProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
    }

    /**
    *  
    Writes a value for the {@code fill} property as a {@code boolean} value.  The {@code fill} property specifies whether or not the fan is filled.
    
    

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
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the fan is filled.
    
    

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
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the fan is filled.
    
    

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
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the fan is filled.
    
    
    

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
    Writes a value for the {@code fill} property as a {@code reference} value.  The {@code fill} property specifies whether or not the fan is filled.
    
    
    

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
    *  Gets the writer for the {@code outline} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outline} property defines whether or not the fan is outlined.
    

    */
    public final BooleanCesiumWriter getOutlineWriter() {
        return m_outline.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outline} property.  The {@code outline} property defines whether or not the fan is outlined.
    

    */
    public final BooleanCesiumWriter openOutlineProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
    }

    /**
    *  
    Writes a value for the {@code outline} property as a {@code boolean} value.  The {@code outline} property specifies whether or not the fan is outlined.
    
    

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
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the fan is outlined.
    
    

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
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the fan is outlined.
    
    

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
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the fan is outlined.
    
    
    

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
    Writes a value for the {@code outline} property as a {@code reference} value.  The {@code outline} property specifies whether or not the fan is outlined.
    
    
    

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
    *  Gets the writer for the {@code outlineColor} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineColor} property defines the color of the fan outline.
    

    */
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineColor} property.  The {@code outlineColor} property defines the color of the fan outline.
    

    */
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    

    * @param color The color.
    */
    public final void writeOutlineColorProperty(@Nonnull Color color) {
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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgba} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    

    * @param color The color.
    */
    public final void writeOutlineColorPropertyRgbaf(@Nonnull Color color) {
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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code rgbaf} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    

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
    Writes a value for the {@code outlineColor} property as a {@code reference} value.  The {@code outlineColor} property specifies the color of the fan outline.
    
    
    

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
    *  Gets the writer for the {@code outlineWidth} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code outlineWidth} property defines the width of the fan outline.
    

    */
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code outlineWidth} property.  The {@code outlineWidth} property defines the width of the fan outline.
    

    */
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    *  
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the fan outline.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the fan outline.
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code number} value.  The {@code outlineWidth} property specifies the width of the fan outline.
    
    
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the fan outline.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the fan outline.
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the fan outline.
    
    
    

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
    Writes a value for the {@code outlineWidth} property as a {@code reference} value.  The {@code outlineWidth} property specifies the width of the fan outline.
    
    
    

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
    *  Gets the writer for the {@code numberOfRings} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code numberOfRings} property defines the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    

    */
    public final IntegerCesiumWriter getNumberOfRingsWriter() {
        return m_numberOfRings.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code numberOfRings} property.  The {@code numberOfRings} property defines the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    

    */
    public final IntegerCesiumWriter openNumberOfRingsProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getNumberOfRingsWriter());
    }

    /**
    *  
    Writes a value for the {@code numberOfRings} property as a {@code number} value.  The {@code numberOfRings} property specifies the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    
    

    * @param value The value.
    */
    public final void writeNumberOfRingsProperty(int value) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openNumberOfRingsProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfRings} property as a {@code number} value.  The {@code numberOfRings} property specifies the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumberOfRingsProperty(List<JulianDate> dates, List<Integer> values) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openNumberOfRingsProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfRings} property as a {@code number} value.  The {@code numberOfRings} property specifies the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumberOfRingsProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openNumberOfRingsProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfRings} property as a {@code reference} value.  The {@code numberOfRings} property specifies the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    
    

    * @param value The reference.
    */
    public final void writeNumberOfRingsPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openNumberOfRingsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfRings} property as a {@code reference} value.  The {@code numberOfRings} property specifies the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeNumberOfRingsPropertyReference(String value) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openNumberOfRingsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfRings} property as a {@code reference} value.  The {@code numberOfRings} property specifies the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeNumberOfRingsPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openNumberOfRingsProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code numberOfRings} property as a {@code reference} value.  The {@code numberOfRings} property specifies the number of outline rings to draw, starting from the outer edge and equidistantly spaced towards the center.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeNumberOfRingsPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.IntegerCesiumWriter writer = openNumberOfRingsProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}