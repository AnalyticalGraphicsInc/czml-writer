package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.EllipsoidRadiiCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.IntegerCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.ShadowModeCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Ellipsoid} to a {@link CesiumOutputStream}. A {@code Ellipsoid} is a closed quadric surface that is a three-dimensional analogue of an ellipse.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class EllipsoidCesiumWriter extends CesiumPropertyWriter<EllipsoidCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code radii} property.
    */
    @Nonnull
    public static final String RadiiPropertyName = "radii";
    /**
    * The name of the {@code innerRadii} property.
    */
    @Nonnull
    public static final String InnerRadiiPropertyName = "innerRadii";
    /**
    * The name of the {@code minimumClock} property.
    */
    @Nonnull
    public static final String MinimumClockPropertyName = "minimumClock";
    /**
    * The name of the {@code maximumClock} property.
    */
    @Nonnull
    public static final String MaximumClockPropertyName = "maximumClock";
    /**
    * The name of the {@code minimumCone} property.
    */
    @Nonnull
    public static final String MinimumConePropertyName = "minimumCone";
    /**
    * The name of the {@code maximumCone} property.
    */
    @Nonnull
    public static final String MaximumConePropertyName = "maximumCone";
    /**
    * The name of the {@code heightReference} property.
    */
    @Nonnull
    public static final String HeightReferencePropertyName = "heightReference";
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
    * The name of the {@code stackPartitions} property.
    */
    @Nonnull
    public static final String StackPartitionsPropertyName = "stackPartitions";
    /**
    * The name of the {@code slicePartitions} property.
    */
    @Nonnull
    public static final String SlicePartitionsPropertyName = "slicePartitions";
    /**
    * The name of the {@code subdivisions} property.
    */
    @Nonnull
    public static final String SubdivisionsPropertyName = "subdivisions";
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
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<EllipsoidRadiiCesiumWriter> m_radii = new Lazy<EllipsoidRadiiCesiumWriter>(new Func1<EllipsoidRadiiCesiumWriter>() {
        public EllipsoidRadiiCesiumWriter invoke() {
            return new EllipsoidRadiiCesiumWriter(RadiiPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<EllipsoidRadiiCesiumWriter> m_innerRadii = new Lazy<EllipsoidRadiiCesiumWriter>(new Func1<EllipsoidRadiiCesiumWriter>() {
        public EllipsoidRadiiCesiumWriter invoke() {
            return new EllipsoidRadiiCesiumWriter(InnerRadiiPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_minimumClock = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MinimumClockPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_maximumClock = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MaximumClockPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_minimumCone = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MinimumConePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_maximumCone = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(MaximumConePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<HeightReferenceCesiumWriter>(new Func1<HeightReferenceCesiumWriter>() {
        public HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_fill = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(FillPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(new Func1<MaterialCesiumWriter>() {
        public MaterialCesiumWriter invoke() {
            return new MaterialCesiumWriter(MaterialPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_outline = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(OutlinePropertyName);
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
    private final Lazy<IntegerCesiumWriter> m_stackPartitions = new Lazy<IntegerCesiumWriter>(new Func1<IntegerCesiumWriter>() {
        public IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(StackPartitionsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<IntegerCesiumWriter> m_slicePartitions = new Lazy<IntegerCesiumWriter>(new Func1<IntegerCesiumWriter>() {
        public IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(SlicePartitionsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<IntegerCesiumWriter> m_subdivisions = new Lazy<IntegerCesiumWriter>(new Func1<IntegerCesiumWriter>() {
        public IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(SubdivisionsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ShadowModeCesiumWriter> m_shadows = new Lazy<ShadowModeCesiumWriter>(new Func1<ShadowModeCesiumWriter>() {
        public ShadowModeCesiumWriter invoke() {
            return new ShadowModeCesiumWriter(ShadowsPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DistanceDisplayConditionCesiumWriter> m_distanceDisplayCondition = new Lazy<DistanceDisplayConditionCesiumWriter>(new Func1<DistanceDisplayConditionCesiumWriter>() {
        public DistanceDisplayConditionCesiumWriter invoke() {
            return new DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public EllipsoidCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected EllipsoidCesiumWriter(@Nonnull EllipsoidCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public EllipsoidCesiumWriter clone() {
        return new EllipsoidCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the ellipsoid is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the ellipsoid is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the ellipsoid is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipsoid is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipsoid is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipsoid is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the ellipsoid is shown. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code radii} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code radii} property defines the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final EllipsoidRadiiCesiumWriter getRadiiWriter() {
        return m_radii.getValue();
    }

    /**
    * Opens and returns the writer for the {@code radii} property. The {@code radii} property defines the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final EllipsoidRadiiCesiumWriter openRadiiProperty() {
        openIntervalIfNecessary();
        return this.<EllipsoidRadiiCesiumWriter> openAndReturn(getRadiiWriter());
    }

    /**
    * Writes a value for the {@code radii} property as a {@code cartesian} value. The {@code radii} property specifies the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeRadiiProperty(@Nonnull Cartesian value) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code radii} property as a {@code cartesian} value. The {@code radii} property specifies the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRadiiProperty(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code radii} property as a {@code cartesian} value. The {@code radii} property specifies the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRadiiProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code radii} property as a {@code reference} value. The {@code radii} property specifies the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeRadiiPropertyReference(Reference value) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code radii} property as a {@code reference} value. The {@code radii} property specifies the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeRadiiPropertyReference(String value) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code radii} property as a {@code reference} value. The {@code radii} property specifies the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRadiiPropertyReference(String identifier, String propertyName) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code radii} property as a {@code reference} value. The {@code radii} property specifies the radii of the ellipsoid. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRadiiPropertyReference(String identifier, String[] propertyNames) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code innerRadii} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code innerRadii} property defines the inner radii of the ellipsoid.
    */
    @Nonnull
    public final EllipsoidRadiiCesiumWriter getInnerRadiiWriter() {
        return m_innerRadii.getValue();
    }

    /**
    * Opens and returns the writer for the {@code innerRadii} property. The {@code innerRadii} property defines the inner radii of the ellipsoid.
    */
    @Nonnull
    public final EllipsoidRadiiCesiumWriter openInnerRadiiProperty() {
        openIntervalIfNecessary();
        return this.<EllipsoidRadiiCesiumWriter> openAndReturn(getInnerRadiiWriter());
    }

    /**
    * Writes a value for the {@code innerRadii} property as a {@code cartesian} value. The {@code innerRadii} property specifies the inner radii of the ellipsoid.
    * @param value The value.
    */
    public final void writeInnerRadiiProperty(@Nonnull Cartesian value) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openInnerRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code innerRadii} property as a {@code cartesian} value. The {@code innerRadii} property specifies the inner radii of the ellipsoid.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeInnerRadiiProperty(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openInnerRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code innerRadii} property as a {@code cartesian} value. The {@code innerRadii} property specifies the inner radii of the ellipsoid.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeInnerRadiiProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openInnerRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code innerRadii} property as a {@code reference} value. The {@code innerRadii} property specifies the inner radii of the ellipsoid.
    * @param value The reference.
    */
    public final void writeInnerRadiiPropertyReference(Reference value) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openInnerRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code innerRadii} property as a {@code reference} value. The {@code innerRadii} property specifies the inner radii of the ellipsoid.
    * @param value The reference.
    */
    public final void writeInnerRadiiPropertyReference(String value) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openInnerRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code innerRadii} property as a {@code reference} value. The {@code innerRadii} property specifies the inner radii of the ellipsoid.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeInnerRadiiPropertyReference(String identifier, String propertyName) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openInnerRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code innerRadii} property as a {@code reference} value. The {@code innerRadii} property specifies the inner radii of the ellipsoid.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeInnerRadiiPropertyReference(String identifier, String[] propertyNames) {
        try (Using<EllipsoidRadiiCesiumWriter> using$0 = new Using<EllipsoidRadiiCesiumWriter>(openInnerRadiiProperty())) {
            final EllipsoidRadiiCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code minimumClock} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code minimumClock} property defines the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getMinimumClockWriter() {
        return m_minimumClock.getValue();
    }

    /**
    * Opens and returns the writer for the {@code minimumClock} property. The {@code minimumClock} property defines the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openMinimumClockProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMinimumClockWriter());
    }

    /**
    * Writes a value for the {@code minimumClock} property as a {@code number} value. The {@code minimumClock} property specifies the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeMinimumClockProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code minimumClock} property as a {@code number} value. The {@code minimumClock} property specifies the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMinimumClockProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code minimumClock} property as a {@code number} value. The {@code minimumClock} property specifies the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMinimumClockProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code minimumClock} property as a {@code reference} value. The {@code minimumClock} property specifies the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumClockPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumClock} property as a {@code reference} value. The {@code minimumClock} property specifies the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumClockPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumClock} property as a {@code reference} value. The {@code minimumClock} property specifies the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMinimumClockPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code minimumClock} property as a {@code reference} value. The {@code minimumClock} property specifies the minimum clock angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMinimumClockPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code maximumClock} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code maximumClock} property defines the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    */
    @Nonnull
    public final DoubleCesiumWriter getMaximumClockWriter() {
        return m_maximumClock.getValue();
    }

    /**
    * Opens and returns the writer for the {@code maximumClock} property. The {@code maximumClock} property defines the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    */
    @Nonnull
    public final DoubleCesiumWriter openMaximumClockProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMaximumClockWriter());
    }

    /**
    * Writes a value for the {@code maximumClock} property as a {@code number} value. The {@code maximumClock} property specifies the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    * @param value The value.
    */
    public final void writeMaximumClockProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code maximumClock} property as a {@code number} value. The {@code maximumClock} property specifies the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMaximumClockProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code maximumClock} property as a {@code number} value. The {@code maximumClock} property specifies the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMaximumClockProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code maximumClock} property as a {@code reference} value. The {@code maximumClock} property specifies the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    * @param value The reference.
    */
    public final void writeMaximumClockPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumClock} property as a {@code reference} value. The {@code maximumClock} property specifies the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    * @param value The reference.
    */
    public final void writeMaximumClockPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumClock} property as a {@code reference} value. The {@code maximumClock} property specifies the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMaximumClockPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code maximumClock} property as a {@code reference} value. The {@code maximumClock} property specifies the maximum clock angle of the ellipsoid. If not specified, the default value is 2π.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMaximumClockPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumClockProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code minimumCone} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code minimumCone} property defines the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getMinimumConeWriter() {
        return m_minimumCone.getValue();
    }

    /**
    * Opens and returns the writer for the {@code minimumCone} property. The {@code minimumCone} property defines the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openMinimumConeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMinimumConeWriter());
    }

    /**
    * Writes a value for the {@code minimumCone} property as a {@code number} value. The {@code minimumCone} property specifies the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeMinimumConeProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code minimumCone} property as a {@code number} value. The {@code minimumCone} property specifies the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMinimumConeProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code minimumCone} property as a {@code number} value. The {@code minimumCone} property specifies the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMinimumConeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code minimumCone} property as a {@code reference} value. The {@code minimumCone} property specifies the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumConePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumCone} property as a {@code reference} value. The {@code minimumCone} property specifies the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeMinimumConePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code minimumCone} property as a {@code reference} value. The {@code minimumCone} property specifies the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMinimumConePropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code minimumCone} property as a {@code reference} value. The {@code minimumCone} property specifies the minimum cone angle of the ellipsoid. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMinimumConePropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMinimumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code maximumCone} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code maximumCone} property defines the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    */
    @Nonnull
    public final DoubleCesiumWriter getMaximumConeWriter() {
        return m_maximumCone.getValue();
    }

    /**
    * Opens and returns the writer for the {@code maximumCone} property. The {@code maximumCone} property defines the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    */
    @Nonnull
    public final DoubleCesiumWriter openMaximumConeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getMaximumConeWriter());
    }

    /**
    * Writes a value for the {@code maximumCone} property as a {@code number} value. The {@code maximumCone} property specifies the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    * @param value The value.
    */
    public final void writeMaximumConeProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code maximumCone} property as a {@code number} value. The {@code maximumCone} property specifies the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeMaximumConeProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code maximumCone} property as a {@code number} value. The {@code maximumCone} property specifies the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeMaximumConeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code maximumCone} property as a {@code reference} value. The {@code maximumCone} property specifies the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    * @param value The reference.
    */
    public final void writeMaximumConePropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumCone} property as a {@code reference} value. The {@code maximumCone} property specifies the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    * @param value The reference.
    */
    public final void writeMaximumConePropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code maximumCone} property as a {@code reference} value. The {@code maximumCone} property specifies the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeMaximumConePropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code maximumCone} property as a {@code reference} value. The {@code maximumCone} property specifies the maximum cone angle of the ellipsoid. If not specified, the default value is π.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeMaximumConePropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openMaximumConeProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code heightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code heightReference} property defines the height reference of the ellipsoid, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code heightReference} property. The {@code heightReference} property defines the height reference of the ellipsoid, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code heightReference} value. The {@code heightReference} property specifies the height reference of the ellipsoid, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The height reference.
    */
    public final void writeHeightReferenceProperty(@Nonnull CesiumHeightReference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeHeightReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipsoid, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(Reference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipsoid, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(String value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipsoid, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the ellipsoid, which indicates if the position is relative to terrain or not. If not specified, the default value is NONE.
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
    * Gets the writer for the {@code fill} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code fill} property defines whether or not the ellipsoid is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getFillWriter() {
        return m_fill.getValue();
    }

    /**
    * Opens and returns the writer for the {@code fill} property. The {@code fill} property defines whether or not the ellipsoid is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openFillProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
    }

    /**
    * Writes a value for the {@code fill} property as a {@code boolean} value. The {@code fill} property specifies whether or not the ellipsoid is filled. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeFillProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipsoid is filled. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeFillPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipsoid is filled. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeFillPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipsoid is filled. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeFillPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the ellipsoid is filled. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeFillPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code material} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code material} property defines the material to display on the surface of the ellipsoid. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getMaterialWriter() {
        return m_material.getValue();
    }

    /**
    * Opens and returns the writer for the {@code material} property. The {@code material} property defines the material to display on the surface of the ellipsoid. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
    }

    /**
    * Gets the writer for the {@code outline} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outline} property defines whether or not the ellipsoid is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getOutlineWriter() {
        return m_outline.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outline} property. The {@code outline} property defines whether or not the ellipsoid is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openOutlineProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
    }

    /**
    * Writes a value for the {@code outline} property as a {@code boolean} value. The {@code outline} property specifies whether or not the ellipsoid is outlined. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeOutlineProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipsoid is outlined. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeOutlinePropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipsoid is outlined. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeOutlinePropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipsoid is outlined. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOutlinePropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the ellipsoid is outlined. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOutlinePropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code outlineColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineColor} property defines the color of the ellipsoid outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineColor} property. The {@code outlineColor} property defines the color of the ellipsoid outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOutlineColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOutlineColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the ellipsoid outline. If not specified, the default value is black.
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
    * Gets the writer for the {@code outlineWidth} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineWidth} property defines the width of the ellipsoid outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineWidth} property. The {@code outlineWidth} property defines the width of the ellipsoid outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the ellipsoid outline. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeOutlineWidthProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the ellipsoid outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the ellipsoid outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipsoid outline. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipsoid outline. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipsoid outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the ellipsoid outline. If not specified, the default value is 1.0.
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
    * Gets the writer for the {@code stackPartitions} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code stackPartitions} property defines the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    */
    @Nonnull
    public final IntegerCesiumWriter getStackPartitionsWriter() {
        return m_stackPartitions.getValue();
    }

    /**
    * Opens and returns the writer for the {@code stackPartitions} property. The {@code stackPartitions} property defines the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    */
    @Nonnull
    public final IntegerCesiumWriter openStackPartitionsProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getStackPartitionsWriter());
    }

    /**
    * Writes a value for the {@code stackPartitions} property as a {@code number} value. The {@code stackPartitions} property specifies the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    * @param value The value.
    */
    public final void writeStackPartitionsProperty(int value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openStackPartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code stackPartitions} property as a {@code number} value. The {@code stackPartitions} property specifies the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeStackPartitionsProperty(List<JulianDate> dates, List<Integer> values) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openStackPartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code stackPartitions} property as a {@code number} value. The {@code stackPartitions} property specifies the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeStackPartitionsProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openStackPartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code stackPartitions} property as a {@code reference} value. The {@code stackPartitions} property specifies the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    * @param value The reference.
    */
    public final void writeStackPartitionsPropertyReference(Reference value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openStackPartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code stackPartitions} property as a {@code reference} value. The {@code stackPartitions} property specifies the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    * @param value The reference.
    */
    public final void writeStackPartitionsPropertyReference(String value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openStackPartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code stackPartitions} property as a {@code reference} value. The {@code stackPartitions} property specifies the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeStackPartitionsPropertyReference(String identifier, String propertyName) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openStackPartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code stackPartitions} property as a {@code reference} value. The {@code stackPartitions} property specifies the number of times to partition the ellipsoid into stacks. If not specified, the default value is 64.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeStackPartitionsPropertyReference(String identifier, String[] propertyNames) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openStackPartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code slicePartitions} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code slicePartitions} property defines the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    */
    @Nonnull
    public final IntegerCesiumWriter getSlicePartitionsWriter() {
        return m_slicePartitions.getValue();
    }

    /**
    * Opens and returns the writer for the {@code slicePartitions} property. The {@code slicePartitions} property defines the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    */
    @Nonnull
    public final IntegerCesiumWriter openSlicePartitionsProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getSlicePartitionsWriter());
    }

    /**
    * Writes a value for the {@code slicePartitions} property as a {@code number} value. The {@code slicePartitions} property specifies the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    * @param value The value.
    */
    public final void writeSlicePartitionsProperty(int value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSlicePartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code slicePartitions} property as a {@code number} value. The {@code slicePartitions} property specifies the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSlicePartitionsProperty(List<JulianDate> dates, List<Integer> values) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSlicePartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code slicePartitions} property as a {@code number} value. The {@code slicePartitions} property specifies the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSlicePartitionsProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSlicePartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code slicePartitions} property as a {@code reference} value. The {@code slicePartitions} property specifies the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    * @param value The reference.
    */
    public final void writeSlicePartitionsPropertyReference(Reference value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSlicePartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code slicePartitions} property as a {@code reference} value. The {@code slicePartitions} property specifies the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    * @param value The reference.
    */
    public final void writeSlicePartitionsPropertyReference(String value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSlicePartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code slicePartitions} property as a {@code reference} value. The {@code slicePartitions} property specifies the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSlicePartitionsPropertyReference(String identifier, String propertyName) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSlicePartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code slicePartitions} property as a {@code reference} value. The {@code slicePartitions} property specifies the number of times to partition the ellipsoid into radial slices. If not specified, the default value is 64.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSlicePartitionsPropertyReference(String identifier, String[] propertyNames) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSlicePartitionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code subdivisions} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code subdivisions} property defines the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    */
    @Nonnull
    public final IntegerCesiumWriter getSubdivisionsWriter() {
        return m_subdivisions.getValue();
    }

    /**
    * Opens and returns the writer for the {@code subdivisions} property. The {@code subdivisions} property defines the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    */
    @Nonnull
    public final IntegerCesiumWriter openSubdivisionsProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getSubdivisionsWriter());
    }

    /**
    * Writes a value for the {@code subdivisions} property as a {@code number} value. The {@code subdivisions} property specifies the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    * @param value The value.
    */
    public final void writeSubdivisionsProperty(int value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSubdivisionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code subdivisions} property as a {@code number} value. The {@code subdivisions} property specifies the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSubdivisionsProperty(List<JulianDate> dates, List<Integer> values) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSubdivisionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code subdivisions} property as a {@code number} value. The {@code subdivisions} property specifies the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSubdivisionsProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSubdivisionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code subdivisions} property as a {@code reference} value. The {@code subdivisions} property specifies the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    * @param value The reference.
    */
    public final void writeSubdivisionsPropertyReference(Reference value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSubdivisionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code subdivisions} property as a {@code reference} value. The {@code subdivisions} property specifies the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    * @param value The reference.
    */
    public final void writeSubdivisionsPropertyReference(String value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSubdivisionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code subdivisions} property as a {@code reference} value. The {@code subdivisions} property specifies the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeSubdivisionsPropertyReference(String identifier, String propertyName) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSubdivisionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code subdivisions} property as a {@code reference} value. The {@code subdivisions} property specifies the number of samples per outline ring, determining the granularity of the curvature. If not specified, the default value is 128.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeSubdivisionsPropertyReference(String identifier, String[] propertyNames) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openSubdivisionsProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code shadows} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code shadows} property defines whether or not the ellipsoid casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter getShadowsWriter() {
        return m_shadows.getValue();
    }

    /**
    * Opens and returns the writer for the {@code shadows} property. The {@code shadows} property defines whether or not the ellipsoid casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter openShadowsProperty() {
        openIntervalIfNecessary();
        return this.<ShadowModeCesiumWriter> openAndReturn(getShadowsWriter());
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code shadowMode} value. The {@code shadows} property specifies whether or not the ellipsoid casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The shadow mode.
    */
    public final void writeShadowsProperty(@Nonnull CesiumShadowMode value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeShadowMode(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipsoid casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(Reference value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipsoid casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(String value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipsoid casts or receives shadows. If not specified, the default value is DISABLED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String propertyName) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the ellipsoid casts or receives shadows. If not specified, the default value is DISABLED.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShadowsPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code distanceDisplayCondition} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this ellipsoid will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    * Opens and returns the writer for the {@code distanceDisplayCondition} property. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this ellipsoid will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
    * @param value The value.
    */
    public final void writeDistanceDisplayConditionProperty(@Nonnull Bounds value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeDistanceDisplayCondition(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(Reference value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this ellipsoid will be displayed.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}