package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ClassificationTypeCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.IntegerCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.ShadowModeCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Ellipse} to a {@link CesiumOutputStream}. A {@code Ellipse} is an ellipse, which is a closed curve on or above the surface of the Earth.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class EllipseCesiumWriter extends CesiumPropertyWriter<EllipseCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code semiMajorAxis} property.
    */
    @Nonnull
    public static final String SemiMajorAxisPropertyName = "semiMajorAxis";
    /**
    * The name of the {@code semiMinorAxis} property.
    */
    @Nonnull
    public static final String SemiMinorAxisPropertyName = "semiMinorAxis";
    /**
    * The name of the {@code height} property.
    */
    @Nonnull
    public static final String HeightPropertyName = "height";
    /**
    * The name of the {@code heightReference} property.
    */
    @Nonnull
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    * The name of the {@code extrudedHeight} property.
    */
    @Nonnull
    public static final String ExtrudedHeightPropertyName = "extrudedHeight";
    /**
    * The name of the {@code extrudedHeightReference} property.
    */
    @Nonnull
    public static final String ExtrudedHeightReferencePropertyName = "extrudedHeightReference";
    /**
    * The name of the {@code rotation} property.
    */
    @Nonnull
    public static final String RotationPropertyName = "rotation";
    /**
    * The name of the {@code stRotation} property.
    */
    @Nonnull
    public static final String StRotationPropertyName = "stRotation";
    /**
    * The name of the {@code granularity} property.
    */
    @Nonnull
    public static final String GranularityPropertyName = "granularity";
    /**
    * The name of the {@code fill} property.
    */
    @Nonnull
    public static final String FillPropertyName = "fill";
    /**
    * The name of the {@code material} property.
    */
    @Nonnull
    public static final String MaterialPropertyName = "material";
    /**
    * The name of the {@code outline} property.
    */
    @Nonnull
    public static final String OutlinePropertyName = "outline";
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
    * The name of the {@code numberOfVerticalLines} property.
    */
    @Nonnull
    public static final String NumberOfVerticalLinesPropertyName = "numberOfVerticalLines";
    /**
    * The name of the {@code shadows} property.
    */
    @Nonnull
    public static final String ShadowsPropertyName = "shadows";
    /**
    * The name of the {@code distanceDisplayCondition} property.
    */
    @Nonnull
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    /**
    * The name of the {@code classificationType} property.
    */
    @Nonnull
    public static final String ClassificationTypePropertyName = "classificationType";
    /**
    * The name of the {@code zIndex} property.
    */
    @Nonnull
    public static final String ZIndexPropertyName = "zIndex";
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_semiMajorAxis = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(SemiMajorAxisPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_semiMinorAxis = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(SemiMinorAxisPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_height = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(HeightPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<cesiumlanguagewriter.HeightReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.HeightReferenceCesiumWriter>() {
        public cesiumlanguagewriter.HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_extrudedHeight = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ExtrudedHeightPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_extrudedHeightReference = new Lazy<cesiumlanguagewriter.HeightReferenceCesiumWriter>(
            new Func1<cesiumlanguagewriter.HeightReferenceCesiumWriter>() {
                public cesiumlanguagewriter.HeightReferenceCesiumWriter invoke() {
                    return new HeightReferenceCesiumWriter(ExtrudedHeightReferencePropertyName);
                }
            }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_rotation = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(RotationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_stRotation = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(StRotationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_granularity = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(GranularityPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_fill = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(FillPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<MaterialCesiumWriter> m_material = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
        public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(MaterialPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_outline = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(OutlinePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
        public cesiumlanguagewriter.ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(OutlineColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(OutlineWidthPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<IntegerCesiumWriter> m_numberOfVerticalLines = new Lazy<cesiumlanguagewriter.IntegerCesiumWriter>(new Func1<cesiumlanguagewriter.IntegerCesiumWriter>() {
        public cesiumlanguagewriter.IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(NumberOfVerticalLinesPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ShadowModeCesiumWriter> m_shadows = new Lazy<cesiumlanguagewriter.ShadowModeCesiumWriter>(new Func1<cesiumlanguagewriter.ShadowModeCesiumWriter>() {
        public cesiumlanguagewriter.ShadowModeCesiumWriter invoke() {
            return new ShadowModeCesiumWriter(ShadowsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DistanceDisplayConditionCesiumWriter> m_distanceDisplayCondition = new Lazy<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter>(
            new Func1<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter>() {
                public cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter invoke() {
                    return new DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionPropertyName);
                }
            }, false);
    @Nonnull
    private final Lazy<ClassificationTypeCesiumWriter> m_classificationType = new Lazy<cesiumlanguagewriter.ClassificationTypeCesiumWriter>(
            new Func1<cesiumlanguagewriter.ClassificationTypeCesiumWriter>() {
                public cesiumlanguagewriter.ClassificationTypeCesiumWriter invoke() {
                    return new ClassificationTypeCesiumWriter(ClassificationTypePropertyName);
                }
            }, false);
    @Nonnull
    private final Lazy<IntegerCesiumWriter> m_zIndex = new Lazy<cesiumlanguagewriter.IntegerCesiumWriter>(new Func1<cesiumlanguagewriter.IntegerCesiumWriter>() {
        public cesiumlanguagewriter.IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(ZIndexPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public EllipseCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected EllipseCesiumWriter(@Nonnull EllipseCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public EllipseCesiumWriter clone() {
        return new EllipseCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the ellipse is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the ellipse is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the ellipse is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipse is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipse is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipse is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipse is shown. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code semiMajorAxis} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code semiMajorAxis} property defines the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DoubleCesiumWriter getSemiMajorAxisWriter() {
        return m_semiMajorAxis.getValue();
    }

    /**
    * Opens and returns the writer for the {@code semiMajorAxis} property. The {@code semiMajorAxis} property defines the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DoubleCesiumWriter openSemiMajorAxisProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getSemiMajorAxisWriter());
    }

    /**
    * Writes a value for the {@code semiMajorAxis} property as a {@code number} value. The {@code semiMajorAxis} property specifies the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeSemiMajorAxisProperty(double value) {
        {
            DoubleCesiumWriter writer = openSemiMajorAxisProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMajorAxis} property as a {@code number} value. The {@code semiMajorAxis} property specifies the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSemiMajorAxisProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openSemiMajorAxisProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMajorAxis} property as a {@code number} value. The {@code semiMajorAxis} property specifies the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSemiMajorAxisProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openSemiMajorAxisProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMajorAxis} property as a {@code reference} value. The {@code semiMajorAxis} property specifies the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeSemiMajorAxisPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openSemiMajorAxisProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMajorAxis} property as a {@code reference} value. The {@code semiMajorAxis} property specifies the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeSemiMajorAxisPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openSemiMajorAxisProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMajorAxis} property as a {@code reference} value. The {@code semiMajorAxis} property specifies the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSemiMajorAxisPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openSemiMajorAxisProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMajorAxis} property as a {@code reference} value. The {@code semiMajorAxis} property specifies the length of the ellipse's semi-major axis in meters. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSemiMajorAxisPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openSemiMajorAxisProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code semiMinorAxis} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code semiMinorAxis} property defines the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DoubleCesiumWriter getSemiMinorAxisWriter() {
        return m_semiMinorAxis.getValue();
    }

    /**
    * Opens and returns the writer for the {@code semiMinorAxis} property. The {@code semiMinorAxis} property defines the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DoubleCesiumWriter openSemiMinorAxisProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getSemiMinorAxisWriter());
    }

    /**
    * Writes a value for the {@code semiMinorAxis} property as a {@code number} value. The {@code semiMinorAxis} property specifies the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeSemiMinorAxisProperty(double value) {
        {
            DoubleCesiumWriter writer = openSemiMinorAxisProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMinorAxis} property as a {@code number} value. The {@code semiMinorAxis} property specifies the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSemiMinorAxisProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openSemiMinorAxisProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMinorAxis} property as a {@code number} value. The {@code semiMinorAxis} property specifies the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSemiMinorAxisProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openSemiMinorAxisProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMinorAxis} property as a {@code reference} value. The {@code semiMinorAxis} property specifies the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeSemiMinorAxisPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openSemiMinorAxisProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMinorAxis} property as a {@code reference} value. The {@code semiMinorAxis} property specifies the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeSemiMinorAxisPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openSemiMinorAxisProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMinorAxis} property as a {@code reference} value. The {@code semiMinorAxis} property specifies the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSemiMinorAxisPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openSemiMinorAxisProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code semiMinorAxis} property as a {@code reference} value. The {@code semiMinorAxis} property specifies the length of the ellipse's semi-minor axis in meters. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSemiMinorAxisPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openSemiMinorAxisProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code height} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code height} property defines the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getHeightWriter() {
        return m_height.getValue();
    }

    /**
    * Opens and returns the writer for the {@code height} property. The {@code height} property defines the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openHeightProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getHeightWriter());
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeHeightProperty(double value) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeHeightProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeHeightProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeHeightPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeHeightPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHeightPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the altitude of the ellipse relative to the surface. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHeightPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openHeightProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code heightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code heightReference} property defines the height reference of the ellipse, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code heightReference} property. The {@code heightReference} property defines the height reference of the ellipse, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code heightReference} value. The {@code heightReference} property specifies the height reference of the ellipse, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipse, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipse, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipse, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipse, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
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
    * Gets the writer for the {@code extrudedHeight} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code extrudedHeight} property defines the altitude of the ellipse's extruded face relative to the surface.
    */
    @Nonnull
    public final DoubleCesiumWriter getExtrudedHeightWriter() {
        return m_extrudedHeight.getValue();
    }

    /**
    * Opens and returns the writer for the {@code extrudedHeight} property. The {@code extrudedHeight} property defines the altitude of the ellipse's extruded face relative to the surface.
    */
    @Nonnull
    public final DoubleCesiumWriter openExtrudedHeightProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getExtrudedHeightWriter());
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code number} value. The {@code extrudedHeight} property specifies the altitude of the ellipse's extruded face relative to the surface.
    * @param value The value.
    */
    public final void writeExtrudedHeightProperty(double value) {
        {
            DoubleCesiumWriter writer = openExtrudedHeightProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code number} value. The {@code extrudedHeight} property specifies the altitude of the ellipse's extruded face relative to the surface.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeExtrudedHeightProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openExtrudedHeightProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code number} value. The {@code extrudedHeight} property specifies the altitude of the ellipse's extruded face relative to the surface.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeExtrudedHeightProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openExtrudedHeightProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the altitude of the ellipse's extruded face relative to the surface.
    * @param value The reference.
    */
    public final void writeExtrudedHeightPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openExtrudedHeightProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the altitude of the ellipse's extruded face relative to the surface.
    * @param value The reference.
    */
    public final void writeExtrudedHeightPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openExtrudedHeightProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the altitude of the ellipse's extruded face relative to the surface.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeExtrudedHeightPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openExtrudedHeightProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the altitude of the ellipse's extruded face relative to the surface.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeExtrudedHeightPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openExtrudedHeightProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code extrudedHeightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code extrudedHeightReference} property defines the extruded height reference of the ellipse, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getExtrudedHeightReferenceWriter() {
        return m_extrudedHeightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code extrudedHeightReference} property. The {@code extrudedHeightReference} property defines the extruded height reference of the ellipse, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openExtrudedHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getExtrudedHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code heightReference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the ellipse, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The height reference.
    */
    public final void writeExtrudedHeightReferenceProperty(@Nonnull CesiumHeightReference value) {
        {
            HeightReferenceCesiumWriter writer = openExtrudedHeightReferenceProperty();
            try {
                writer.writeHeightReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the ellipse, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeExtrudedHeightReferencePropertyReference(Reference value) {
        {
            HeightReferenceCesiumWriter writer = openExtrudedHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the ellipse, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeExtrudedHeightReferencePropertyReference(String value) {
        {
            HeightReferenceCesiumWriter writer = openExtrudedHeightReferenceProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the ellipse, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeExtrudedHeightReferencePropertyReference(String identifier, String propertyName) {
        {
            HeightReferenceCesiumWriter writer = openExtrudedHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the ellipse, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeExtrudedHeightReferencePropertyReference(String identifier, String[] propertyNames) {
        {
            HeightReferenceCesiumWriter writer = openExtrudedHeightReferenceProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code rotation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code rotation} property defines the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getRotationWriter() {
        return m_rotation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code rotation} property. The {@code rotation} property defines the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openRotationProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getRotationWriter());
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeRotationProperty(double value) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the angle from north (counter-clockwise) in radians. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code stRotation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code stRotation} property defines the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getStRotationWriter() {
        return m_stRotation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code stRotation} property. The {@code stRotation} property defines the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openStRotationProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getStRotationWriter());
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code number} value. The {@code stRotation} property specifies the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeStRotationProperty(double value) {
        {
            DoubleCesiumWriter writer = openStRotationProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code number} value. The {@code stRotation} property specifies the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeStRotationProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openStRotationProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code number} value. The {@code stRotation} property specifies the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeStRotationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openStRotationProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeStRotationPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openStRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeStRotationPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openStRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeStRotationPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openStRotationProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture coordinates. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeStRotationPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openStRotationProperty();
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
    * Gets the writer for the {@code fill} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code fill} property defines whether or not the ellipse is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getFillWriter() {
        return m_fill.getValue();
    }

    /**
    * Opens and returns the writer for the {@code fill} property. The {@code fill} property defines whether or not the ellipse is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openFillProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
    }

    /**
    * Writes a value for the {@code fill} property as a {@code boolean} value. The {@code fill} property specifies whether or not the ellipse is filled. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipse is filled. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipse is filled. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipse is filled. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipse is filled. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code material} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code material} property defines the material to use to fill the ellipse. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getMaterialWriter() {
        return m_material.getValue();
    }

    /**
    * Opens and returns the writer for the {@code material} property. The {@code material} property defines the material to use to fill the ellipse. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
    }

    /**
    * Gets the writer for the {@code outline} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outline} property defines whether or not the ellipse is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getOutlineWriter() {
        return m_outline.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outline} property. The {@code outline} property defines whether or not the ellipse is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openOutlineProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
    }

    /**
    * Writes a value for the {@code outline} property as a {@code boolean} value. The {@code outline} property specifies whether or not the ellipse is outlined. If not specified, the default value is {@code false}.
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
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipse is outlined. If not specified, the default value is {@code false}.
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
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipse is outlined. If not specified, the default value is {@code false}.
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
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipse is outlined. If not specified, the default value is {@code false}.
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
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipse is outlined. If not specified, the default value is {@code false}.
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
    * Gets the writer for the {@code outlineColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineColor} property defines the color of the ellipse outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineColor} property. The {@code outlineColor} property defines the color of the ellipse outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipse outline. If not specified, the default value is black.
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
    * Gets the writer for the {@code outlineWidth} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineWidth} property defines the width of the ellipse outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineWidth} property. The {@code outlineWidth} property defines the width of the ellipse outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the ellipse outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the ellipse outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the ellipse outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipse outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipse outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipse outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipse outline. If not specified, the default value is 1.0.
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
    * Gets the writer for the {@code numberOfVerticalLines} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code numberOfVerticalLines} property defines the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    */
    @Nonnull
    public final IntegerCesiumWriter getNumberOfVerticalLinesWriter() {
        return m_numberOfVerticalLines.getValue();
    }

    /**
    * Opens and returns the writer for the {@code numberOfVerticalLines} property. The {@code numberOfVerticalLines} property defines the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    */
    @Nonnull
    public final IntegerCesiumWriter openNumberOfVerticalLinesProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getNumberOfVerticalLinesWriter());
    }

    /**
    * Writes a value for the {@code numberOfVerticalLines} property as a {@code number} value. The {@code numberOfVerticalLines} property specifies the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    * @param value The value.
    */
    public final void writeNumberOfVerticalLinesProperty(int value) {
        {
            IntegerCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code numberOfVerticalLines} property as a {@code number} value. The {@code numberOfVerticalLines} property specifies the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumberOfVerticalLinesProperty(List<JulianDate> dates, List<Integer> values) {
        {
            IntegerCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code numberOfVerticalLines} property as a {@code number} value. The {@code numberOfVerticalLines} property specifies the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumberOfVerticalLinesProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        {
            IntegerCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value. The {@code numberOfVerticalLines} property specifies the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    * @param value The reference.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(Reference value) {
        {
            IntegerCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value. The {@code numberOfVerticalLines} property specifies the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    * @param value The reference.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(String value) {
        {
            IntegerCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value. The {@code numberOfVerticalLines} property specifies the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(String identifier, String propertyName) {
        {
            IntegerCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code numberOfVerticalLines} property as a {@code reference} value. The {@code numberOfVerticalLines} property specifies the number of vertical lines to use when outlining an extruded ellipse. If not specified, the default value is 16.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeNumberOfVerticalLinesPropertyReference(String identifier, String[] propertyNames) {
        {
            IntegerCesiumWriter writer = openNumberOfVerticalLinesProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code shadows} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code shadows} property defines whether or not the ellipse casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter getShadowsWriter() {
        return m_shadows.getValue();
    }

    /**
    * Opens and returns the writer for the {@code shadows} property. The {@code shadows} property defines whether or not the ellipse casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter openShadowsProperty() {
        openIntervalIfNecessary();
        return this.<ShadowModeCesiumWriter> openAndReturn(getShadowsWriter());
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code shadowMode} value. The {@code shadows} property specifies whether or not the ellipse casts or receives shadows. If not specified, the default value is DISABLED.
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
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipse casts or receives shadows. If not specified, the default value is DISABLED.
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
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipse casts or receives shadows. If not specified, the default value is DISABLED.
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
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipse casts or receives shadows. If not specified, the default value is DISABLED.
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
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipse casts or receives shadows. If not specified, the default value is DISABLED.
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
    * Gets the writer for the {@code distanceDisplayCondition} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this ellipse will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    * Opens and returns the writer for the {@code distanceDisplayCondition} property. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this ellipse will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipse will be displayed.
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
    * Gets the writer for the {@code classificationType} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code classificationType} property defines whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    */
    @Nonnull
    public final ClassificationTypeCesiumWriter getClassificationTypeWriter() {
        return m_classificationType.getValue();
    }

    /**
    * Opens and returns the writer for the {@code classificationType} property. The {@code classificationType} property defines whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    */
    @Nonnull
    public final ClassificationTypeCesiumWriter openClassificationTypeProperty() {
        openIntervalIfNecessary();
        return this.<ClassificationTypeCesiumWriter> openAndReturn(getClassificationTypeWriter());
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code classificationType} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param value The classification type.
    */
    public final void writeClassificationTypeProperty(@Nonnull CesiumClassificationType value) {
        {
            ClassificationTypeCesiumWriter writer = openClassificationTypeProperty();
            try {
                writer.writeClassificationType(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param value The reference.
    */
    public final void writeClassificationTypePropertyReference(Reference value) {
        {
            ClassificationTypeCesiumWriter writer = openClassificationTypeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param value The reference.
    */
    public final void writeClassificationTypePropertyReference(String value) {
        {
            ClassificationTypeCesiumWriter writer = openClassificationTypeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeClassificationTypePropertyReference(String identifier, String propertyName) {
        {
            ClassificationTypeCesiumWriter writer = openClassificationTypeProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeClassificationTypePropertyReference(String identifier, String[] propertyNames) {
        {
            ClassificationTypeCesiumWriter writer = openClassificationTypeProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code zIndex} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code zIndex} property defines the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    */
    @Nonnull
    public final IntegerCesiumWriter getZIndexWriter() {
        return m_zIndex.getValue();
    }

    /**
    * Opens and returns the writer for the {@code zIndex} property. The {@code zIndex} property defines the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    */
    @Nonnull
    public final IntegerCesiumWriter openZIndexProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getZIndexWriter());
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code number} value. The {@code zIndex} property specifies the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param value The value.
    */
    public final void writeZIndexProperty(int value) {
        {
            IntegerCesiumWriter writer = openZIndexProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code number} value. The {@code zIndex} property specifies the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeZIndexProperty(List<JulianDate> dates, List<Integer> values) {
        {
            IntegerCesiumWriter writer = openZIndexProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code number} value. The {@code zIndex} property specifies the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeZIndexProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        {
            IntegerCesiumWriter writer = openZIndexProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param value The reference.
    */
    public final void writeZIndexPropertyReference(Reference value) {
        {
            IntegerCesiumWriter writer = openZIndexProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param value The reference.
    */
    public final void writeZIndexPropertyReference(String value) {
        {
            IntegerCesiumWriter writer = openZIndexProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeZIndexPropertyReference(String identifier, String propertyName) {
        {
            IntegerCesiumWriter writer = openZIndexProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the ellipse, used for ordering ground geometry. Only has an effect if the ellipse is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeZIndexPropertyReference(String identifier, String[] propertyNames) {
        {
            IntegerCesiumWriter writer = openZIndexProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}