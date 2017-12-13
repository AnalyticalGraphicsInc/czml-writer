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
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code CustomPatternSensor} to a {@link CesiumOutputStream}.  A {@code CustomPatternSensor} is a custom sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CustomPatternSensorCesiumWriter extends CesiumPropertyWriter<CustomPatternSensorCesiumWriter> {
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
    The name of the {@code showIntersection} property.
    

    */
    public static final String ShowIntersectionPropertyName = "showIntersection";
    /**
    *  
    The name of the {@code intersectionColor} property.
    

    */
    public static final String IntersectionColorPropertyName = "intersectionColor";
    /**
    *  
    The name of the {@code intersectionWidth} property.
    

    */
    public static final String IntersectionWidthPropertyName = "intersectionWidth";
    /**
    *  
    The name of the {@code showLateralSurfaces} property.
    

    */
    public static final String ShowLateralSurfacesPropertyName = "showLateralSurfaces";
    /**
    *  
    The name of the {@code lateralSurfaceMaterial} property.
    

    */
    public static final String LateralSurfaceMaterialPropertyName = "lateralSurfaceMaterial";
    /**
    *  
    The name of the {@code showEllipsoidSurfaces} property.
    

    */
    public static final String ShowEllipsoidSurfacesPropertyName = "showEllipsoidSurfaces";
    /**
    *  
    The name of the {@code ellipsoidSurfaceMaterial} property.
    

    */
    public static final String EllipsoidSurfaceMaterialPropertyName = "ellipsoidSurfaceMaterial";
    /**
    *  
    The name of the {@code showEllipsoidHorizonSurfaces} property.
    

    */
    public static final String ShowEllipsoidHorizonSurfacesPropertyName = "showEllipsoidHorizonSurfaces";
    /**
    *  
    The name of the {@code ellipsoidHorizonSurfaceMaterial} property.
    

    */
    public static final String EllipsoidHorizonSurfaceMaterialPropertyName = "ellipsoidHorizonSurfaceMaterial";
    /**
    *  
    The name of the {@code showDomeSurfaces} property.
    

    */
    public static final String ShowDomeSurfacesPropertyName = "showDomeSurfaces";
    /**
    *  
    The name of the {@code domeSurfaceMaterial} property.
    

    */
    public static final String DomeSurfaceMaterialPropertyName = "domeSurfaceMaterial";
    /**
    *  
    The name of the {@code portionToDisplay} property.
    

    */
    public static final String PortionToDisplayPropertyName = "portionToDisplay";
    /**
    *  
    The name of the {@code environmentConstraint} property.
    

    */
    public static final String EnvironmentConstraintPropertyName = "environmentConstraint";
    /**
    *  
    The name of the {@code showEnvironmentOcclusion} property.
    

    */
    public static final String ShowEnvironmentOcclusionPropertyName = "showEnvironmentOcclusion";
    /**
    *  
    The name of the {@code environmentOcclusionMaterial} property.
    

    */
    public static final String EnvironmentOcclusionMaterialPropertyName = "environmentOcclusionMaterial";
    /**
    *  
    The name of the {@code showEnvironmentIntersection} property.
    

    */
    public static final String ShowEnvironmentIntersectionPropertyName = "showEnvironmentIntersection";
    /**
    *  
    The name of the {@code environmentIntersectionColor} property.
    

    */
    public static final String EnvironmentIntersectionColorPropertyName = "environmentIntersectionColor";
    /**
    *  
    The name of the {@code environmentIntersectionWidth} property.
    

    */
    public static final String EnvironmentIntersectionWidthPropertyName = "environmentIntersectionWidth";
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
    private Lazy<BooleanCesiumWriter> m_showIntersection = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowIntersectionPropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_intersectionColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(IntersectionColorPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_intersectionWidth = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(IntersectionWidthPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_showLateralSurfaces = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowLateralSurfacesPropertyName);
        }
    }, false);
    private Lazy<MaterialCesiumWriter> m_lateralSurfaceMaterial = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(LateralSurfaceMaterialPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_showEllipsoidSurfaces = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowEllipsoidSurfacesPropertyName);
        }
    }, false);
    private Lazy<MaterialCesiumWriter> m_ellipsoidSurfaceMaterial = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(EllipsoidSurfaceMaterialPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_showEllipsoidHorizonSurfaces = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowEllipsoidHorizonSurfacesPropertyName);
        }
    }, false);
    private Lazy<MaterialCesiumWriter> m_ellipsoidHorizonSurfaceMaterial = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(EllipsoidHorizonSurfaceMaterialPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_showDomeSurfaces = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowDomeSurfacesPropertyName);
        }
    }, false);
    private Lazy<MaterialCesiumWriter> m_domeSurfaceMaterial = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(DomeSurfaceMaterialPropertyName);
        }
    }, false);
    private Lazy<SensorVolumePortionToDisplayCesiumWriter> m_portionToDisplay = new Lazy<cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter>(
            new Func1<cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter>() {
                public cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter invoke() {
                    return new SensorVolumePortionToDisplayCesiumWriter(PortionToDisplayPropertyName);
                }
            }, false);
    private Lazy<BooleanCesiumWriter> m_environmentConstraint = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(EnvironmentConstraintPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_showEnvironmentOcclusion = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowEnvironmentOcclusionPropertyName);
        }
    }, false);
    private Lazy<MaterialCesiumWriter> m_environmentOcclusionMaterial = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(EnvironmentOcclusionMaterialPropertyName);
        }
    }, false);
    private Lazy<BooleanCesiumWriter> m_showEnvironmentIntersection = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowEnvironmentIntersectionPropertyName);
        }
    }, false);
    private Lazy<ColorCesiumWriter> m_environmentIntersectionColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(EnvironmentIntersectionColorPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_environmentIntersectionWidth = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(EnvironmentIntersectionWidthPropertyName);
        }
    }, false);

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public CustomPatternSensorCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected CustomPatternSensorCesiumWriter(@Nonnull CustomPatternSensorCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public CustomPatternSensorCesiumWriter clone() {
        return new CustomPatternSensorCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code show} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code show} property defines whether or not the entire custom sensor is shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code show} property.  The {@code show} property defines whether or not the entire custom sensor is shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code boolean} value.  The {@code show} property specifies whether or not the entire custom sensor is shown.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the entire custom sensor is shown.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the entire custom sensor is shown.
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the entire custom sensor is shown.
    
    
    

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
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the entire custom sensor is shown.
    
    
    

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
    *  Gets the writer for the {@code directions} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code directions} property defines the list of directions defining the custom sensor.
    

    */
    @Nonnull
    public final DirectionListCesiumWriter getDirectionsWriter() {
        return m_directions.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code directions} property.  The {@code directions} property defines the list of directions defining the custom sensor.
    

    */
    @Nonnull
    public final DirectionListCesiumWriter openDirectionsProperty() {
        openIntervalIfNecessary();
        return this.<DirectionListCesiumWriter> openAndReturn(getDirectionsWriter());
    }

    /**
    *  
    Writes a value for the {@code directions} property as a {@code spherical} value.  The {@code directions} property specifies the list of directions defining the custom sensor.
    
    

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
    Writes a value for the {@code directions} property as a {@code unitSpherical} value.  The {@code directions} property specifies the list of directions defining the custom sensor.
    
    

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
    Writes a value for the {@code directions} property as a {@code cartesian} value.  The {@code directions} property specifies the list of directions defining the custom sensor.
    
    

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
    Writes a value for the {@code directions} property as a {@code unitCartesian} value.  The {@code directions} property specifies the list of directions defining the custom sensor.
    
    

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
    *  Gets the writer for the {@code radius} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code radius} property defines the radial limit of the sensor.
    

    */
    @Nonnull
    public final DoubleCesiumWriter getRadiusWriter() {
        return m_radius.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code radius} property.  The {@code radius} property defines the radial limit of the sensor.
    

    */
    @Nonnull
    public final DoubleCesiumWriter openRadiusProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getRadiusWriter());
    }

    /**
    *  
    Writes a value for the {@code radius} property as a {@code number} value.  The {@code radius} property specifies the radial limit of the sensor.
    
    

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
    Writes a value for the {@code radius} property as a {@code number} value.  The {@code radius} property specifies the radial limit of the sensor.
    
    
    

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
    Writes a value for the {@code radius} property as a {@code number} value.  The {@code radius} property specifies the radial limit of the sensor.
    
    
    
    
    

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
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the sensor.
    
    

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
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the sensor.
    
    

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
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the sensor.
    
    
    

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
    Writes a value for the {@code radius} property as a {@code reference} value.  The {@code radius} property specifies the radial limit of the sensor.
    
    
    

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
    *  Gets the writer for the {@code showIntersection} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showIntersection} property defines whether or not the intersection of the sensor with the Earth is shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowIntersectionWriter() {
        return m_showIntersection.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showIntersection} property.  The {@code showIntersection} property defines whether or not the intersection of the sensor with the Earth is shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowIntersectionProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowIntersectionWriter());
    }

    /**
    *  
    Writes a value for the {@code showIntersection} property as a {@code boolean} value.  The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown.
    
    

    * @param value The value.
    */
    public final void writeShowIntersectionProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowIntersectionProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showIntersection} property as a {@code reference} value.  The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown.
    
    

    * @param value The reference.
    */
    public final void writeShowIntersectionPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowIntersectionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showIntersection} property as a {@code reference} value.  The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowIntersectionPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowIntersectionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showIntersection} property as a {@code reference} value.  The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowIntersectionPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowIntersectionProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showIntersection} property as a {@code reference} value.  The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowIntersectionPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowIntersectionProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code intersectionColor} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code intersectionColor} property defines the color of the intersection of the sensor with the Earth.
    

    */
    @Nonnull
    public final ColorCesiumWriter getIntersectionColorWriter() {
        return m_intersectionColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code intersectionColor} property.  The {@code intersectionColor} property defines the color of the intersection of the sensor with the Earth.
    

    */
    @Nonnull
    public final ColorCesiumWriter openIntersectionColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getIntersectionColorWriter());
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgba} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    

    * @param color The color.
    */
    public final void writeIntersectionColorProperty(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgba} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeIntersectionColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgba} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeIntersectionColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgba} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeIntersectionColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    

    * @param color The color.
    */
    public final void writeIntersectionColorPropertyRgbaf(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code reference} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    

    * @param value The reference.
    */
    public final void writeIntersectionColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code reference} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeIntersectionColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code reference} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeIntersectionColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionColor} property as a {@code reference} value.  The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeIntersectionColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code intersectionWidth} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code intersectionWidth} property defines the width of the intersection in pixels.
    

    */
    @Nonnull
    public final DoubleCesiumWriter getIntersectionWidthWriter() {
        return m_intersectionWidth.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code intersectionWidth} property.  The {@code intersectionWidth} property defines the width of the intersection in pixels.
    

    */
    @Nonnull
    public final DoubleCesiumWriter openIntersectionWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getIntersectionWidthWriter());
    }

    /**
    *  
    Writes a value for the {@code intersectionWidth} property as a {@code number} value.  The {@code intersectionWidth} property specifies the width of the intersection in pixels.
    
    

    * @param value The value.
    */
    public final void writeIntersectionWidthProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openIntersectionWidthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionWidth} property as a {@code number} value.  The {@code intersectionWidth} property specifies the width of the intersection in pixels.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeIntersectionWidthProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openIntersectionWidthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionWidth} property as a {@code number} value.  The {@code intersectionWidth} property specifies the width of the intersection in pixels.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeIntersectionWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openIntersectionWidthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionWidth} property as a {@code reference} value.  The {@code intersectionWidth} property specifies the width of the intersection in pixels.
    
    

    * @param value The reference.
    */
    public final void writeIntersectionWidthPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openIntersectionWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionWidth} property as a {@code reference} value.  The {@code intersectionWidth} property specifies the width of the intersection in pixels.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeIntersectionWidthPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openIntersectionWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionWidth} property as a {@code reference} value.  The {@code intersectionWidth} property specifies the width of the intersection in pixels.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeIntersectionWidthPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openIntersectionWidthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code intersectionWidth} property as a {@code reference} value.  The {@code intersectionWidth} property specifies the width of the intersection in pixels.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeIntersectionWidthPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openIntersectionWidthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code showLateralSurfaces} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showLateralSurfaces} property defines whether or not the lateral surfaces of the sensor are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowLateralSurfacesWriter() {
        return m_showLateralSurfaces.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showLateralSurfaces} property.  The {@code showLateralSurfaces} property defines whether or not the lateral surfaces of the sensor are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowLateralSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowLateralSurfacesWriter());
    }

    /**
    *  
    Writes a value for the {@code showLateralSurfaces} property as a {@code boolean} value.  The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces of the sensor are shown.
    
    

    * @param value The value.
    */
    public final void writeShowLateralSurfacesProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowLateralSurfacesProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value.  The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces of the sensor are shown.
    
    

    * @param value The reference.
    */
    public final void writeShowLateralSurfacesPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowLateralSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value.  The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces of the sensor are shown.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowLateralSurfacesPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowLateralSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value.  The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces of the sensor are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowLateralSurfacesPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowLateralSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value.  The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces of the sensor are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowLateralSurfacesPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowLateralSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code lateralSurfaceMaterial} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code lateralSurfaceMaterial} property defines the material to use for the sensor's lateral surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter getLateralSurfaceMaterialWriter() {
        return m_lateralSurfaceMaterial.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code lateralSurfaceMaterial} property.  The {@code lateralSurfaceMaterial} property defines the material to use for the sensor's lateral surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter openLateralSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getLateralSurfaceMaterialWriter());
    }

    /**
    *  Gets the writer for the {@code showEllipsoidSurfaces} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showEllipsoidSurfaces} property defines whether or not ellipsoid surfaces are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowEllipsoidSurfacesWriter() {
        return m_showEllipsoidSurfaces.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showEllipsoidSurfaces} property.  The {@code showEllipsoidSurfaces} property defines whether or not ellipsoid surfaces are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowEllipsoidSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEllipsoidSurfacesWriter());
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidSurfaces} property as a {@code boolean} value.  The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown.
    
    

    * @param value The value.
    */
    public final void writeShowEllipsoidSurfacesProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidSurfacesProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value.  The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown.
    
    

    * @param value The reference.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value.  The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value.  The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value.  The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code ellipsoidSurfaceMaterial} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code ellipsoidSurfaceMaterial} property defines the material to use for the sensor's ellipsoid surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter getEllipsoidSurfaceMaterialWriter() {
        return m_ellipsoidSurfaceMaterial.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code ellipsoidSurfaceMaterial} property.  The {@code ellipsoidSurfaceMaterial} property defines the material to use for the sensor's ellipsoid surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter openEllipsoidSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getEllipsoidSurfaceMaterialWriter());
    }

    /**
    *  Gets the writer for the {@code showEllipsoidHorizonSurfaces} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showEllipsoidHorizonSurfaces} property defines whether or not ellipsoid horizon surfaces are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowEllipsoidHorizonSurfacesWriter() {
        return m_showEllipsoidHorizonSurfaces.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showEllipsoidHorizonSurfaces} property.  The {@code showEllipsoidHorizonSurfaces} property defines whether or not ellipsoid horizon surfaces are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowEllipsoidHorizonSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEllipsoidHorizonSurfacesWriter());
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code boolean} value.  The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown.
    
    

    * @param value The value.
    */
    public final void writeShowEllipsoidHorizonSurfacesProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidHorizonSurfacesProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value.  The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown.
    
    

    * @param value The reference.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidHorizonSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value.  The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidHorizonSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value.  The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidHorizonSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value.  The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEllipsoidHorizonSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code ellipsoidHorizonSurfaceMaterial} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code ellipsoidHorizonSurfaceMaterial} property defines the material to use for the sensor's ellipsoid horizon surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter getEllipsoidHorizonSurfaceMaterialWriter() {
        return m_ellipsoidHorizonSurfaceMaterial.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code ellipsoidHorizonSurfaceMaterial} property.  The {@code ellipsoidHorizonSurfaceMaterial} property defines the material to use for the sensor's ellipsoid horizon surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter openEllipsoidHorizonSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getEllipsoidHorizonSurfaceMaterialWriter());
    }

    /**
    *  Gets the writer for the {@code showDomeSurfaces} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showDomeSurfaces} property defines whether or not dome surfaces are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowDomeSurfacesWriter() {
        return m_showDomeSurfaces.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showDomeSurfaces} property.  The {@code showDomeSurfaces} property defines whether or not dome surfaces are shown.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowDomeSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowDomeSurfacesWriter());
    }

    /**
    *  
    Writes a value for the {@code showDomeSurfaces} property as a {@code boolean} value.  The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown.
    
    

    * @param value The value.
    */
    public final void writeShowDomeSurfacesProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowDomeSurfacesProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value.  The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown.
    
    

    * @param value The reference.
    */
    public final void writeShowDomeSurfacesPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowDomeSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value.  The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowDomeSurfacesPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowDomeSurfacesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value.  The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowDomeSurfacesPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowDomeSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value.  The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowDomeSurfacesPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowDomeSurfacesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code domeSurfaceMaterial} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code domeSurfaceMaterial} property defines the material to use for the sensor's dome surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter getDomeSurfaceMaterialWriter() {
        return m_domeSurfaceMaterial.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code domeSurfaceMaterial} property.  The {@code domeSurfaceMaterial} property defines the material to use for the sensor's dome surfaces.
    

    */
    @Nonnull
    public final MaterialCesiumWriter openDomeSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getDomeSurfaceMaterialWriter());
    }

    /**
    *  Gets the writer for the {@code portionToDisplay} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code portionToDisplay} property defines what part of the sensor should be displayed.
    

    */
    @Nonnull
    public final SensorVolumePortionToDisplayCesiumWriter getPortionToDisplayWriter() {
        return m_portionToDisplay.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code portionToDisplay} property.  The {@code portionToDisplay} property defines what part of the sensor should be displayed.
    

    */
    @Nonnull
    public final SensorVolumePortionToDisplayCesiumWriter openPortionToDisplayProperty() {
        openIntervalIfNecessary();
        return this.<SensorVolumePortionToDisplayCesiumWriter> openAndReturn(getPortionToDisplayWriter());
    }

    /**
    *  
    Writes a value for the {@code portionToDisplay} property as a {@code portionToDisplay} value.  The {@code portionToDisplay} property specifies what part of the sensor should be displayed.
    
    

    * @param value The portion of the sensor to display.
    */
    public final void writePortionToDisplayProperty(@Nonnull CesiumSensorVolumePortionToDisplay value) {
        {
            cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter writer = openPortionToDisplayProperty();
            try {
                writer.writePortionToDisplay(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code portionToDisplay} property as a {@code reference} value.  The {@code portionToDisplay} property specifies what part of the sensor should be displayed.
    
    

    * @param value The reference.
    */
    public final void writePortionToDisplayPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter writer = openPortionToDisplayProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code portionToDisplay} property as a {@code reference} value.  The {@code portionToDisplay} property specifies what part of the sensor should be displayed.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writePortionToDisplayPropertyReference(String value) {
        {
            cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter writer = openPortionToDisplayProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code portionToDisplay} property as a {@code reference} value.  The {@code portionToDisplay} property specifies what part of the sensor should be displayed.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePortionToDisplayPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter writer = openPortionToDisplayProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code portionToDisplay} property as a {@code reference} value.  The {@code portionToDisplay} property specifies what part of the sensor should be displayed.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePortionToDisplayPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter writer = openPortionToDisplayProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code environmentConstraint} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code environmentConstraint} property defines whether or not the sensor will intersect the environment, e.g. terrain or models.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getEnvironmentConstraintWriter() {
        return m_environmentConstraint.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code environmentConstraint} property.  The {@code environmentConstraint} property defines whether or not the sensor will intersect the environment, e.g. terrain or models.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openEnvironmentConstraintProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getEnvironmentConstraintWriter());
    }

    /**
    *  
    Writes a value for the {@code environmentConstraint} property as a {@code boolean} value.  The {@code environmentConstraint} property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
    
    

    * @param value The value.
    */
    public final void writeEnvironmentConstraintProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openEnvironmentConstraintProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentConstraint} property as a {@code reference} value.  The {@code environmentConstraint} property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
    
    

    * @param value The reference.
    */
    public final void writeEnvironmentConstraintPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openEnvironmentConstraintProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentConstraint} property as a {@code reference} value.  The {@code environmentConstraint} property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeEnvironmentConstraintPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openEnvironmentConstraintProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentConstraint} property as a {@code reference} value.  The {@code environmentConstraint} property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEnvironmentConstraintPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openEnvironmentConstraintProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentConstraint} property as a {@code reference} value.  The {@code environmentConstraint} property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEnvironmentConstraintPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openEnvironmentConstraintProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code showEnvironmentOcclusion} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showEnvironmentOcclusion} property defines whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowEnvironmentOcclusionWriter() {
        return m_showEnvironmentOcclusion.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showEnvironmentOcclusion} property.  The {@code showEnvironmentOcclusion} property defines whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowEnvironmentOcclusionProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEnvironmentOcclusionWriter());
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentOcclusion} property as a {@code boolean} value.  The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
    
    

    * @param value The value.
    */
    public final void writeShowEnvironmentOcclusionProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentOcclusionProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value.  The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
    
    

    * @param value The reference.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentOcclusionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value.  The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentOcclusionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value.  The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentOcclusionProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value.  The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentOcclusionProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code environmentOcclusionMaterial} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code environmentOcclusionMaterial} property defines the material to use for the portion of the sensor occluded by the environment.
    

    */
    @Nonnull
    public final MaterialCesiumWriter getEnvironmentOcclusionMaterialWriter() {
        return m_environmentOcclusionMaterial.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code environmentOcclusionMaterial} property.  The {@code environmentOcclusionMaterial} property defines the material to use for the portion of the sensor occluded by the environment.
    

    */
    @Nonnull
    public final MaterialCesiumWriter openEnvironmentOcclusionMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getEnvironmentOcclusionMaterialWriter());
    }

    /**
    *  Gets the writer for the {@code showEnvironmentIntersection} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code showEnvironmentIntersection} property defines whether or not a line showing where the sensor intersects the environment will be drawn.
    

    */
    @Nonnull
    public final BooleanCesiumWriter getShowEnvironmentIntersectionWriter() {
        return m_showEnvironmentIntersection.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code showEnvironmentIntersection} property.  The {@code showEnvironmentIntersection} property defines whether or not a line showing where the sensor intersects the environment will be drawn.
    

    */
    @Nonnull
    public final BooleanCesiumWriter openShowEnvironmentIntersectionProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEnvironmentIntersectionWriter());
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentIntersection} property as a {@code boolean} value.  The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
    
    

    * @param value The value.
    */
    public final void writeShowEnvironmentIntersectionProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentIntersectionProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value.  The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
    
    

    * @param value The reference.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentIntersectionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value.  The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentIntersectionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value.  The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentIntersectionProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value.  The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowEnvironmentIntersectionProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code environmentIntersectionColor} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code environmentIntersectionColor} property defines the color of the intersection line between the sensor and the environment.
    

    */
    @Nonnull
    public final ColorCesiumWriter getEnvironmentIntersectionColorWriter() {
        return m_environmentIntersectionColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code environmentIntersectionColor} property.  The {@code environmentIntersectionColor} property defines the color of the intersection line between the sensor and the environment.
    

    */
    @Nonnull
    public final ColorCesiumWriter openEnvironmentIntersectionColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getEnvironmentIntersectionColorWriter());
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    

    * @param color The color.
    */
    public final void writeEnvironmentIntersectionColorProperty(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeEnvironmentIntersectionColorProperty(int red, int green, int blue, int alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEnvironmentIntersectionColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEnvironmentIntersectionColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    

    * @param color The color.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(@Nonnull Color color) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    

    * @param value The reference.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(String value) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value.  The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.ColorCesiumWriter writer = openEnvironmentIntersectionColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code environmentIntersectionWidth} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code environmentIntersectionWidth} property defines the width in meters of the intersection line between the sensor and the environment.
    

    */
    @Nonnull
    public final DoubleCesiumWriter getEnvironmentIntersectionWidthWriter() {
        return m_environmentIntersectionWidth.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code environmentIntersectionWidth} property.  The {@code environmentIntersectionWidth} property defines the width in meters of the intersection line between the sensor and the environment.
    

    */
    @Nonnull
    public final DoubleCesiumWriter openEnvironmentIntersectionWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getEnvironmentIntersectionWidthWriter());
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionWidth} property as a {@code number} value.  The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment.
    
    

    * @param value The value.
    */
    public final void writeEnvironmentIntersectionWidthProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openEnvironmentIntersectionWidthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionWidth} property as a {@code number} value.  The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEnvironmentIntersectionWidthProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openEnvironmentIntersectionWidthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionWidth} property as a {@code number} value.  The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEnvironmentIntersectionWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openEnvironmentIntersectionWidthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value.  The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment.
    
    

    * @param value The reference.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openEnvironmentIntersectionWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value.  The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openEnvironmentIntersectionWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value.  The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openEnvironmentIntersectionWidthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value.  The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openEnvironmentIntersectionWidthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}