package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ClassificationTypeCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.HeightReferenceCesiumWriter;
import cesiumlanguagewriter.IntegerCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.RectangleCoordinatesCesiumWriter;
import cesiumlanguagewriter.ShadowModeCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Rectangle} to a {@link CesiumOutputStream}. A {@code Rectangle} is a cartographic rectangle, which conforms to the curvature of the globe and can be placed on the surface or at altitude and can optionally be extruded into a volume.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class RectangleCesiumWriter extends CesiumPropertyWriter<RectangleCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code coordinates} property.
    */
    @Nonnull
    public static final String CoordinatesPropertyName = "coordinates";
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
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
        public BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<RectangleCoordinatesCesiumWriter> m_coordinates = new Lazy<RectangleCoordinatesCesiumWriter>(new Func1<RectangleCoordinatesCesiumWriter>() {
        public RectangleCoordinatesCesiumWriter invoke() {
            return new RectangleCoordinatesCesiumWriter(CoordinatesPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_height = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(HeightPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<HeightReferenceCesiumWriter>(new Func1<HeightReferenceCesiumWriter>() {
        public HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(HeightReferencePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_extrudedHeight = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ExtrudedHeightPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<HeightReferenceCesiumWriter> m_extrudedHeightReference = new Lazy<HeightReferenceCesiumWriter>(new Func1<HeightReferenceCesiumWriter>() {
        public HeightReferenceCesiumWriter invoke() {
            return new HeightReferenceCesiumWriter(ExtrudedHeightReferencePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_rotation = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(RotationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_stRotation = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(StRotationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_granularity = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(GranularityPropertyName);
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
    @Nonnull
    private final Lazy<ClassificationTypeCesiumWriter> m_classificationType = new Lazy<ClassificationTypeCesiumWriter>(new Func1<ClassificationTypeCesiumWriter>() {
        public ClassificationTypeCesiumWriter invoke() {
            return new ClassificationTypeCesiumWriter(ClassificationTypePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<IntegerCesiumWriter> m_zIndex = new Lazy<IntegerCesiumWriter>(new Func1<IntegerCesiumWriter>() {
        public IntegerCesiumWriter invoke() {
            return new IntegerCesiumWriter(ZIndexPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public RectangleCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected RectangleCesiumWriter(@Nonnull RectangleCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public RectangleCesiumWriter clone() {
        return new RectangleCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the rectangle is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the rectangle is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the rectangle is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the rectangle is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the rectangle is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the rectangle is shown. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the rectangle is shown. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code coordinates} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code coordinates} property defines the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final RectangleCoordinatesCesiumWriter getCoordinatesWriter() {
        return m_coordinates.getValue();
    }

    /**
    * Opens and returns the writer for the {@code coordinates} property. The {@code coordinates} property defines the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final RectangleCoordinatesCesiumWriter openCoordinatesProperty() {
        openIntervalIfNecessary();
        return this.<RectangleCoordinatesCesiumWriter> openAndReturn(getCoordinatesWriter());
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsen} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeCoordinatesProperty(CartographicExtent value) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsen(value);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsen} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeCoordinatesProperty(double west, double south, double east, double north) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsen(west, south, east, north);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsen} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCoordinatesProperty(List<JulianDate> dates, List<CartographicExtent> values) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsen(dates, values);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsen} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCoordinatesProperty(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsen(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsenDegrees} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param value The value.
    */
    public final void writeCoordinatesPropertyWsenDegrees(CartographicExtent value) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsenDegrees(value);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsenDegrees} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeCoordinatesPropertyWsenDegrees(double west, double south, double east, double north) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsenDegrees(west, south, east, north);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsenDegrees} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCoordinatesPropertyWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsenDegrees(dates, values);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code wsenDegrees} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCoordinatesPropertyWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeWsenDegrees(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code reference} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeCoordinatesPropertyReference(Reference value) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code reference} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param value The reference.
    */
    public final void writeCoordinatesPropertyReference(String value) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code reference} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeCoordinatesPropertyReference(String identifier, String propertyName) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code coordinates} property as a {@code reference} value. The {@code coordinates} property specifies the coordinates of the rectangle. This value must be specified in order for the client to display graphics.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeCoordinatesPropertyReference(String identifier, String[] propertyNames) {
        try (Using<RectangleCoordinatesCesiumWriter> using$0 = new Using<RectangleCoordinatesCesiumWriter>(openCoordinatesProperty())) {
            final RectangleCoordinatesCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code height} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code height} property defines the height of the rectangle. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getHeightWriter() {
        return m_height.getValue();
    }

    /**
    * Opens and returns the writer for the {@code height} property. The {@code height} property defines the height of the rectangle. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openHeightProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getHeightWriter());
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the height of the rectangle. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeHeightProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the height of the rectangle. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeHeightProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code number} value. The {@code height} property specifies the height of the rectangle. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeHeightProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the rectangle. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeHeightPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the rectangle. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeHeightPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the rectangle. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeHeightPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code height} property as a {@code reference} value. The {@code height} property specifies the height of the rectangle. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeHeightPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code heightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code heightReference} property defines the height reference of the rectangle, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getHeightReferenceWriter() {
        return m_heightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code heightReference} property. The {@code heightReference} property defines the height reference of the rectangle, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code heightReference} value. The {@code heightReference} property specifies the height reference of the rectangle, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The height reference.
    */
    public final void writeHeightReferenceProperty(@Nonnull CesiumHeightReference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeHeightReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the rectangle, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(Reference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the rectangle, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeHeightReferencePropertyReference(String value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the rectangle, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
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
    * Writes a value for the {@code heightReference} property as a {@code reference} value. The {@code heightReference} property specifies the height reference of the rectangle, which indicates if {@code height} is relative to terrain or not. If not specified, the default value is NONE.
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
    * Gets the writer for the {@code extrudedHeight} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code extrudedHeight} property defines the extruded height of the rectangle.
    */
    @Nonnull
    public final DoubleCesiumWriter getExtrudedHeightWriter() {
        return m_extrudedHeight.getValue();
    }

    /**
    * Opens and returns the writer for the {@code extrudedHeight} property. The {@code extrudedHeight} property defines the extruded height of the rectangle.
    */
    @Nonnull
    public final DoubleCesiumWriter openExtrudedHeightProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getExtrudedHeightWriter());
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code number} value. The {@code extrudedHeight} property specifies the extruded height of the rectangle.
    * @param value The value.
    */
    public final void writeExtrudedHeightProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openExtrudedHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code number} value. The {@code extrudedHeight} property specifies the extruded height of the rectangle.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeExtrudedHeightProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openExtrudedHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code number} value. The {@code extrudedHeight} property specifies the extruded height of the rectangle.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeExtrudedHeightProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openExtrudedHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the extruded height of the rectangle.
    * @param value The reference.
    */
    public final void writeExtrudedHeightPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openExtrudedHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the extruded height of the rectangle.
    * @param value The reference.
    */
    public final void writeExtrudedHeightPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openExtrudedHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the extruded height of the rectangle.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeExtrudedHeightPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openExtrudedHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeight} property as a {@code reference} value. The {@code extrudedHeight} property specifies the extruded height of the rectangle.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeExtrudedHeightPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openExtrudedHeightProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code extrudedHeightReference} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code extrudedHeightReference} property defines the extruded height reference of the rectangle, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter getExtrudedHeightReferenceWriter() {
        return m_extrudedHeightReference.getValue();
    }

    /**
    * Opens and returns the writer for the {@code extrudedHeightReference} property. The {@code extrudedHeightReference} property defines the extruded height reference of the rectangle, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    */
    @Nonnull
    public final HeightReferenceCesiumWriter openExtrudedHeightReferenceProperty() {
        openIntervalIfNecessary();
        return this.<HeightReferenceCesiumWriter> openAndReturn(getExtrudedHeightReferenceWriter());
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code heightReference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the rectangle, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The height reference.
    */
    public final void writeExtrudedHeightReferenceProperty(@Nonnull CesiumHeightReference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openExtrudedHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeHeightReference(value);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the rectangle, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeExtrudedHeightReferencePropertyReference(Reference value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openExtrudedHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the rectangle, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param value The reference.
    */
    public final void writeExtrudedHeightReferencePropertyReference(String value) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openExtrudedHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the rectangle, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeExtrudedHeightReferencePropertyReference(String identifier, String propertyName) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openExtrudedHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code extrudedHeightReference} property as a {@code reference} value. The {@code extrudedHeightReference} property specifies the extruded height reference of the rectangle, which indicates if {@code extrudedHeight} is relative to terrain or not. If not specified, the default value is NONE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeExtrudedHeightReferencePropertyReference(String identifier, String[] propertyNames) {
        try (Using<HeightReferenceCesiumWriter> using$0 = new Using<HeightReferenceCesiumWriter>(openExtrudedHeightReferenceProperty())) {
            final HeightReferenceCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code rotation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code rotation} property defines the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getRotationWriter() {
        return m_rotation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code rotation} property. The {@code rotation} property defines the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openRotationProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getRotationWriter());
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeRotationProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code number} value. The {@code rotation} property specifies the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation of the rectangle clockwise from north. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code stRotation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code stRotation} property defines the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getStRotationWriter() {
        return m_stRotation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code stRotation} property. The {@code stRotation} property defines the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openStRotationProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getStRotationWriter());
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code number} value. The {@code stRotation} property specifies the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    * @param value The value.
    */
    public final void writeStRotationProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openStRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code number} value. The {@code stRotation} property specifies the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeStRotationProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openStRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code number} value. The {@code stRotation} property specifies the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeStRotationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openStRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeStRotationPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openStRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    * @param value The reference.
    */
    public final void writeStRotationPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openStRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeStRotationPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openStRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code stRotation} property as a {@code reference} value. The {@code stRotation} property specifies the rotation of any applied texture. A positive rotation is counter-clockwise. If not specified, the default value is 0.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeStRotationPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openStRotationProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
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
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGranularityProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code number} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeGranularityProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGranularityProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
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
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGranularityProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param value The reference.
    */
    public final void writeGranularityPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGranularityProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param value The reference.
    */
    public final void writeGranularityPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGranularityProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeGranularityPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGranularityProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code granularity} property as a {@code reference} value. The {@code granularity} property specifies the sampling distance, in radians. If not specified, the default value is π / 180.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeGranularityPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openGranularityProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code fill} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code fill} property defines whether or not the rectangle is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getFillWriter() {
        return m_fill.getValue();
    }

    /**
    * Opens and returns the writer for the {@code fill} property. The {@code fill} property defines whether or not the rectangle is filled. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openFillProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
    }

    /**
    * Writes a value for the {@code fill} property as a {@code boolean} value. The {@code fill} property specifies whether or not the rectangle is filled. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeFillProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the rectangle is filled. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeFillPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the rectangle is filled. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeFillPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openFillProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the rectangle is filled. If not specified, the default value is {@code true}.
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
    * Writes a value for the {@code fill} property as a {@code reference} value. The {@code fill} property specifies whether or not the rectangle is filled. If not specified, the default value is {@code true}.
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
    * Gets the writer for the {@code material} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code material} property defines the material to display on the surface of the rectangle. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getMaterialWriter() {
        return m_material.getValue();
    }

    /**
    * Opens and returns the writer for the {@code material} property. The {@code material} property defines the material to display on the surface of the rectangle. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
    }

    /**
    * Gets the writer for the {@code outline} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outline} property defines whether or not the rectangle is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getOutlineWriter() {
        return m_outline.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outline} property. The {@code outline} property defines whether or not the rectangle is outlined. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openOutlineProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
    }

    /**
    * Writes a value for the {@code outline} property as a {@code boolean} value. The {@code outline} property specifies whether or not the rectangle is outlined. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeOutlineProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the rectangle is outlined. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeOutlinePropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the rectangle is outlined. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeOutlinePropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openOutlineProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the rectangle is outlined. If not specified, the default value is {@code false}.
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
    * Writes a value for the {@code outline} property as a {@code reference} value. The {@code outline} property specifies whether or not the rectangle is outlined. If not specified, the default value is {@code false}.
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
    * Gets the writer for the {@code outlineColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineColor} property defines the color of the rectangle outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter getOutlineColorWriter() {
        return m_outlineColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineColor} property. The {@code outlineColor} property defines the color of the rectangle outline. If not specified, the default value is black.
    */
    @Nonnull
    public final ColorCesiumWriter openOutlineColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOutlineColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgba} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
    * @param color The color.
    */
    public final void writeOutlineColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code rgbaf} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
    * @param value The reference.
    */
    public final void writeOutlineColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openOutlineColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Writes a value for the {@code outlineColor} property as a {@code reference} value. The {@code outlineColor} property specifies the color of the rectangle outline. If not specified, the default value is black.
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
    * Gets the writer for the {@code outlineWidth} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code outlineWidth} property defines the width of the rectangle outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getOutlineWidthWriter() {
        return m_outlineWidth.getValue();
    }

    /**
    * Opens and returns the writer for the {@code outlineWidth} property. The {@code outlineWidth} property defines the width of the rectangle outline. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openOutlineWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the rectangle outline. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeOutlineWidthProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the rectangle outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code number} value. The {@code outlineWidth} property specifies the width of the rectangle outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the rectangle outline. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the rectangle outline. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeOutlineWidthPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openOutlineWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the rectangle outline. If not specified, the default value is 1.0.
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
    * Writes a value for the {@code outlineWidth} property as a {@code reference} value. The {@code outlineWidth} property specifies the width of the rectangle outline. If not specified, the default value is 1.0.
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
    * Gets the writer for the {@code shadows} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code shadows} property defines whether or not the rectangle casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter getShadowsWriter() {
        return m_shadows.getValue();
    }

    /**
    * Opens and returns the writer for the {@code shadows} property. The {@code shadows} property defines whether or not the rectangle casts or receives shadows. If not specified, the default value is DISABLED.
    */
    @Nonnull
    public final ShadowModeCesiumWriter openShadowsProperty() {
        openIntervalIfNecessary();
        return this.<ShadowModeCesiumWriter> openAndReturn(getShadowsWriter());
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code shadowMode} value. The {@code shadows} property specifies whether or not the rectangle casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The shadow mode.
    */
    public final void writeShadowsProperty(@Nonnull CesiumShadowMode value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeShadowMode(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the rectangle casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(Reference value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the rectangle casts or receives shadows. If not specified, the default value is DISABLED.
    * @param value The reference.
    */
    public final void writeShadowsPropertyReference(String value) {
        try (Using<ShadowModeCesiumWriter> using$0 = new Using<ShadowModeCesiumWriter>(openShadowsProperty())) {
            final ShadowModeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the rectangle casts or receives shadows. If not specified, the default value is DISABLED.
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
    * Writes a value for the {@code shadows} property as a {@code reference} value. The {@code shadows} property specifies whether or not the rectangle casts or receives shadows. If not specified, the default value is DISABLED.
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
    * Gets the writer for the {@code distanceDisplayCondition} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this rectangle will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter getDistanceDisplayConditionWriter() {
        return m_distanceDisplayCondition.getValue();
    }

    /**
    * Opens and returns the writer for the {@code distanceDisplayCondition} property. The {@code distanceDisplayCondition} property defines the display condition specifying at what distance from the camera this rectangle will be displayed.
    */
    @Nonnull
    public final DistanceDisplayConditionCesiumWriter openDistanceDisplayConditionProperty() {
        openIntervalIfNecessary();
        return this.<DistanceDisplayConditionCesiumWriter> openAndReturn(getDistanceDisplayConditionWriter());
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
    * @param value The value.
    */
    public final void writeDistanceDisplayConditionProperty(@Nonnull Bounds value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeDistanceDisplayCondition(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code distanceDisplayCondition} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(Reference value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
    * @param value The reference.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String value) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
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
    * Writes a value for the {@code distanceDisplayCondition} property as a {@code reference} value. The {@code distanceDisplayCondition} property specifies the display condition specifying at what distance from the camera this rectangle will be displayed.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDistanceDisplayConditionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DistanceDisplayConditionCesiumWriter> using$0 = new Using<DistanceDisplayConditionCesiumWriter>(openDistanceDisplayConditionProperty())) {
            final DistanceDisplayConditionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
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
        try (Using<ClassificationTypeCesiumWriter> using$0 = new Using<ClassificationTypeCesiumWriter>(openClassificationTypeProperty())) {
            final ClassificationTypeCesiumWriter writer = using$0.resource;
            writer.writeClassificationType(value);
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param value The reference.
    */
    public final void writeClassificationTypePropertyReference(Reference value) {
        try (Using<ClassificationTypeCesiumWriter> using$0 = new Using<ClassificationTypeCesiumWriter>(openClassificationTypeProperty())) {
            final ClassificationTypeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param value The reference.
    */
    public final void writeClassificationTypePropertyReference(String value) {
        try (Using<ClassificationTypeCesiumWriter> using$0 = new Using<ClassificationTypeCesiumWriter>(openClassificationTypeProperty())) {
            final ClassificationTypeCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeClassificationTypePropertyReference(String identifier, String propertyName) {
        try (Using<ClassificationTypeCesiumWriter> using$0 = new Using<ClassificationTypeCesiumWriter>(openClassificationTypeProperty())) {
            final ClassificationTypeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code classificationType} property as a {@code reference} value. The {@code classificationType} property specifies whether a classification affects terrain, 3D Tiles, or both. If not specified, the default value is BOTH.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeClassificationTypePropertyReference(String identifier, String[] propertyNames) {
        try (Using<ClassificationTypeCesiumWriter> using$0 = new Using<ClassificationTypeCesiumWriter>(openClassificationTypeProperty())) {
            final ClassificationTypeCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code zIndex} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code zIndex} property defines the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    */
    @Nonnull
    public final IntegerCesiumWriter getZIndexWriter() {
        return m_zIndex.getValue();
    }

    /**
    * Opens and returns the writer for the {@code zIndex} property. The {@code zIndex} property defines the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    */
    @Nonnull
    public final IntegerCesiumWriter openZIndexProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getZIndexWriter());
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code number} value. The {@code zIndex} property specifies the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param value The value.
    */
    public final void writeZIndexProperty(int value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openZIndexProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code number} value. The {@code zIndex} property specifies the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeZIndexProperty(List<JulianDate> dates, List<Integer> values) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openZIndexProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code number} value. The {@code zIndex} property specifies the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeZIndexProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openZIndexProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param value The reference.
    */
    public final void writeZIndexPropertyReference(Reference value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openZIndexProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param value The reference.
    */
    public final void writeZIndexPropertyReference(String value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openZIndexProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeZIndexPropertyReference(String identifier, String propertyName) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openZIndexProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code zIndex} property as a {@code reference} value. The {@code zIndex} property specifies the z-index of the rectangle, used for ordering ground geometry. Only has an effect if the rectangle is constant, and {@code height} and {@code extrudedHeight} are not specified. If not specified, the default value is 0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeZIndexPropertyReference(String identifier, String[] propertyNames) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openZIndexProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}