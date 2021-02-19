package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.CornerTypeCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.PositionListCesiumWriter;
import cesiumlanguagewriter.ShadowModeCesiumWriter;
import cesiumlanguagewriter.ShapeCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code PolylineVolume} to a {@link CesiumOutputStream}. A {@code PolylineVolume} is a polyline with a volume, defined as a 2D shape extruded along a polyline that conforms to the curvature of the globe.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class PolylineVolumeCesiumWriter extends CesiumPropertyWriter<PolylineVolumeCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code positions} property.
    */
    public static final String PositionsPropertyName = "positions";
    /**
    * The name of the {@code shape} property.
    */
    public static final String ShapePropertyName = "shape";
    /**
    * The name of the {@code cornerType} property.
    */
    public static final String CornerTypePropertyName = "cornerType";
    /**
    * The name of the {@code granularity} property.
    */
    public static final String GranularityPropertyName = "granularity";
    /**
    * The name of the {@code fill} property.
    */
    public static final String FillPropertyName = "fill";
    /**
    * The name of the {@code material} property.
    */
    public static final String MaterialPropertyName = "material";
    /**
    * The name of the {@code outline} property.
    */
    public static final String OutlinePropertyName = "outline";
    /**
    * The name of the {@code outlineColor} property.
    */
    public static final String OutlineColorPropertyName = "outlineColor";
    /**
    * The name of the {@code outlineWidth} property.
    */
    public static final String OutlineWidthPropertyName = "outlineWidth";
    /**
    * The name of the {@code shadows} property.
    */
    public static final String ShadowsPropertyName = "shadows";
    /**
    * The name of the {@code distanceDisplayCondition} property.
    */
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    private Lazy<PositionListCesiumWriter> m_positions = new Lazy<cesiumlanguagewriter.PositionListCesiumWriter>(new Func1<cesiumlanguagewriter.PositionListCesiumWriter>() {
        public cesiumlanguagewriter.PositionListCesiumWriter invoke() {
            return new PositionListCesiumWriter(PositionsPropertyName);
        }
    }, false);
    private Lazy<ShapeCesiumWriter> m_shape = new Lazy<cesiumlanguagewriter.ShapeCesiumWriter>(new Func1<cesiumlanguagewriter.ShapeCesiumWriter>() {
        public cesiumlanguagewriter.ShapeCesiumWriter invoke() {
            return new ShapeCesiumWriter(ShapePropertyName);
        }
    }, false);
    private Lazy<CornerTypeCesiumWriter> m_cornerType = new Lazy<cesiumlanguagewriter.CornerTypeCesiumWriter>(new Func1<cesiumlanguagewriter.CornerTypeCesiumWriter>() {
        public cesiumlanguagewriter.CornerTypeCesiumWriter invoke() {
            return new CornerTypeCesiumWriter(CornerTypePropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_granularity = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(GranularityPropertyName);
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
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public PolylineVolumeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected PolylineVolumeCesiumWriter(@Nonnull PolylineVolumeCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public PolylineVolumeCesiumWriter clone() {
        return new PolylineVolumeCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the volume is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the volume is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the volume is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the volume is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the volume is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the volume is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the volume is shown. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code positions} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code positions} property defines the array of positions defining the center of the polyline volume. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final PositionListCesiumWriter getPositionsWriter() {
        return m_positions.getValue();
    }

    /**
    * Opens and returns the writer for the {@code positions} property. The {@code positions} property defines the array of positions defining the center of the polyline volume. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final PositionListCesiumWriter openPositionsProperty() {
        openIntervalIfNecessary();
        return this.<PositionListCesiumWriter> openAndReturn(getPositionsWriter());
    }

    /**
    * Writes a value for the {@code positions} property as a {@code cartesian} value. The {@code positions} property specifies the array of positions defining the center of the polyline volume. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writePositionsProperty(Iterable<Cartesian> values) {
        {
            PositionListCesiumWriter writer = openPositionsProperty();
            try {
                writer.writeCartesian(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code positions} property as a {@code cartographicRadians} value. The {@code positions} property specifies the array of positions defining the center of the polyline volume. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writePositionsPropertyCartographicRadians(Iterable<Cartographic> values) {
        {
            PositionListCesiumWriter writer = openPositionsProperty();
            try {
                writer.writeCartographicRadians(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code positions} property as a {@code cartographicDegrees} value. The {@code positions} property specifies the array of positions defining the center of the polyline volume. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writePositionsPropertyCartographicDegrees(Iterable<Cartographic> values) {
        {
            PositionListCesiumWriter writer = openPositionsProperty();
            try {
                writer.writeCartographicDegrees(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code positions} property as a {@code references} value. The {@code positions} property specifies the array of positions defining the center of the polyline volume. This value must be specified in order for the client to display graphics.
    * @param references The list of references.
    */
    public final void writePositionsPropertyReferences(Iterable<Reference> references) {
        {
            PositionListCesiumWriter writer = openPositionsProperty();
            try {
                writer.writeReferences(references);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code shape} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code shape} property defines the array of positions defining the shape of the volume to be extruded. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final ShapeCesiumWriter getShapeWriter() {
        return m_shape.getValue();
    }

    /**
    * Opens and returns the writer for the {@code shape} property. The {@code shape} property defines the array of positions defining the shape of the volume to be extruded. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final ShapeCesiumWriter openShapeProperty() {
        openIntervalIfNecessary();
        return this.<ShapeCesiumWriter> openAndReturn(getShapeWriter());
    }

    /**
    * Writes a value for the {@code shape} property as a {@code cartesian2} value. The {@code shape} property specifies the array of positions defining the shape of the volume to be extruded. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writeShapeProperty(Iterable<Rectangular> values) {
        {
            ShapeCesiumWriter writer = openShapeProperty();
            try {
                writer.writeCartesian2(values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code cornerType} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code cornerType} property defines the style of the corners of the volume. If not specified, the default value is ROUNDED.
    */
    @Nonnull
    public final CornerTypeCesiumWriter getCornerTypeWriter() {
        return m_cornerType.getValue();
    }

    /**
    * Opens and returns the writer for the {@code cornerType} property. The {@code cornerType} property defines the style of the corners of the volume. If not specified, the default value is ROUNDED.
    */
    @Nonnull
    public final CornerTypeCesiumWriter openCornerTypeProperty() {
        openIntervalIfNecessary();
        return this.<CornerTypeCesiumWriter> openAndReturn(getCornerTypeWriter());
    }

    /**
    * Writes a value for the {@code cornerType} property as a {@code cornerType} value. The {@code cornerType} property specifies the style of the corners of the volume. If not specified, the default value is ROUNDED.
    * @param value The style of a corner.
    */
    public final void writeCornerTypeProperty(@Nonnull CesiumCornerType value) {
        {
            CornerTypeCesiumWriter writer = openCornerTypeProperty();
            try {
                writer.writeCornerType(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cornerType} property as a {@code reference} value. The {@code cornerType} property specifies the style of the corners of the volume. If not specified, the default value is ROUNDED.
    * @param value The reference.
    */
    public final void writeCornerTypePropertyReference(Reference value) {
        {
            CornerTypeCesiumWriter writer = openCornerTypeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cornerType} property as a {@code reference} value. The {@code cornerType} property specifies the style of the corners of the volume. If not specified, the default value is ROUNDED.
    * @param value The reference.
    */
    public final void writeCornerTypePropertyReference(String value) {
        {
            CornerTypeCesiumWriter writer = openCornerTypeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cornerType} property as a {@code reference} value. The {@code cornerType} property specifies the style of the corners of the volume. If not specified, the default value is ROUNDED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeCornerTypePropertyReference(String identifier, String propertyName) {
        {
            CornerTypeCesiumWriter writer = openCornerTypeProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cornerType} property as a {@code reference} value. The {@code cornerType} property specifies the style of the corners of the volume. If not specified, the default value is ROUNDED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeCornerTypePropertyReference(String identifier, String[] propertyNames) {
        {
            CornerTypeCesiumWriter writer = openCornerTypeProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code granularity} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code granularity} property defines the sampling distance, in radians. If not specified, the default value is π / 180.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getGranularityWriter() {
        return m_granularity.getValue();
    }

    /**
    * Opens and returns the writer for the {@code granularity} property. The {@code granularity} property defines the sampling distance, in radians. If not specified, the default value is π / 180.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openGranularityProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getGranularityWriter());
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code number} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param value The value.
    */
    public final void writeGranularityProperty(double value) {
        {
            DoubleCesiumWriter writer = openGranularityProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code number} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeGranularityProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openGranularityProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code number} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeGranularityProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openGranularityProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param value The reference.
    */
    public final void writeGranularityPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openGranularityProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param value The reference.
    */
    public final void writeGranularityPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openGranularityProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeGranularityPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openGranularityProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeGranularityPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openGranularityProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code fill} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code fill} property defines whether or not the volume is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getFillWriter() {
        return m_fill.getValue();
    }

    /**
    * Opens and returns the writer for the {@code fill} property. The {@code fill} property defines whether or not the volume is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openFillProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
    }

    /**
    * Writes a value for the {@code fill} property as a {@code boolean} value. The {@code fill} property specifies whether or not the volume is filled. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeFillProperty(boolean value) {
        {
            BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the volume is filled. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeFillPropertyReference(Reference value) {
        {
            BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the volume is filled. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeFillPropertyReference(String value) {
        {
            BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the volume is filled. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFillPropertyReference(String identifier, String propertyName) {
        {
            BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the volume is filled. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFillPropertyReference(String identifier, String[] propertyNames) {
        {
            BooleanCesiumWriter writer = openFillProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code material} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code material} property defines the material to use to fill the volume. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getMaterialWriter() {
        return m_material.getValue();
    }

    /**
    * Opens and returns the writer for the {@code material} property. The {@code material} property defines the material to use to fill the volume. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
    }

    /**
    * Gets the writer for the {@code outline} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outline} property defines whether or not the volume is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getOutlineWriter() {
        return m_outline.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outline} property. The {@code outline} property defines whether or not the volume is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openOutlineProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
    }

    /**
    * Writes a value for the {@code outline} property as a {@code boolean} value. The {@code outline} property specifies whether or not the volume is outlined. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeOutlineProperty(boolean value) {
        {
            BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the volume is outlined. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeOutlinePropertyReference(Reference value) {
        {
            BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the volume is outlined. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeOutlinePropertyReference(String value) {
        {
            BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the volume is outlined. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlinePropertyReference(String identifier, String propertyName) {
        {
            BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the volume is outlined. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlinePropertyReference(String identifier, String[] propertyNames) {
        {
            BooleanCesiumWriter writer = openOutlineProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code outlineColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineColor} property defines the color of the volume outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineColor} property. The {@code outlineColor} property defines the color of the volume outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the volume outline. If not specified, the default value is black.
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
    * Gets the writer for the {@code outlineWidth} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineWidth} property defines the width of the volume outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineWidth} property. The {@code outlineWidth} property defines the width of the volume outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the volume outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the volume outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the volume outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the volume outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the volume outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the volume outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the volume outline. If not specified, the default value is 1.0.
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
    * Gets the writer for the {@code shadows} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code shadows} property defines whether or not the volume casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter getShadowsWriter() {
        return m_shadows.getValue();
    }

    /**
    * Opens and returns the writer for the {@code shadows} property. The {@code shadows} property defines whether or not the volume casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter openShadowsProperty() {
        openIntervalIfNecessary();
        return this.<ShadowModeCesiumWriter> openAndReturn(getShadowsWriter());
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code shadowMode} value. The {@code shadows} property specifies whether or not the volume casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The shadow mode.
    */
    public final void writeShadowsProperty(@Nonnull CesiumShadowMode value) {
        {
            ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeShadowMode(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the volume casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(Reference value) {
        {
            ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the volume casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(String value) {
        {
            ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the volume casts or receives shadows. If not specified, the default value is DISABLED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String propertyName) {
        {
            ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the volume casts or receives shadows. If not specified, the default value is DISABLED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String[] propertyNames) {
        {
            ShadowModeCesiumWriter writer = openShadowsProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code distanceDisplayCondition} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this volume will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    * Opens and returns the writer for the {@code distanceDisplayCondition} property. The {@code distanceDisplayCondition} property defines the display condition specifying the distance from the camera at which this volume will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying the distance from the camera at which this volume will be displayed.
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
}