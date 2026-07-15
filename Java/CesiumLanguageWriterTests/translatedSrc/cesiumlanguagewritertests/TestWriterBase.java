package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.Func2;
import agi.foundation.compatibility.IntHelper;
import agi.foundation.compatibility.IterableHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TextWriterHelper;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.Before;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public abstract class TestWriterBase {
    public final StringWriter getStringWriter() {
        return backingField$StringWriter;
    }

    private final void setStringWriter(StringWriter value) {
        backingField$StringWriter = value;
    }

    public final CesiumOutputStream getOutputStream() {
        return backingField$OutputStream;
    }

    private final void setOutputStream(CesiumOutputStream value) {
        backingField$OutputStream = value;
    }

    public final CesiumStreamWriter getWriter() {
        return backingField$Writer;
    }

    private final void setWriter(CesiumStreamWriter value) {
        backingField$Writer = value;
    }

    @Before
    public final void testWriterBaseSetUp() {
        setStringWriter(new StringWriter());
        setOutputStream(new CesiumOutputStream(getStringWriter()));
        setWriter(new CesiumStreamWriter());
    }

    @After
    public final void testWriterBaseTearDown() {
        TextWriterHelper.close(getStringWriter());
    }

    @Nonnull
    public final PacketCesiumWriter openPacket() {
        return getWriter().openPacket(getOutputStream());
    }

    /**
    * Helper method for creating expected JSON output from key-value pairs.
    */
    @Nonnull
    public static String createExpectedJson(@Nonnull String topLevelPropertyName, @Nonnull Map<String, Object> dictionary) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, topLevelPropertyName, dictionary);
        return createExpectedJson(tempCollection$0);
    }

    /**
    * Helper method for creating expected JSON output from key-value pairs.
    */
    @Nonnull
    public static String createExpectedJson(@Nonnull Map<String, Object> dictionary) {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        for (final Map.Entry<String, Object> pair : dictionary.entrySet()) {
            builder.append('"').append(pair.getKey()).append('"').append(':').append(formatValue(pair.getValue())).append(',');
        }
        builder.setCharAt(builder.length() - 1, '}');
        return builder.toString();
    }

    @Nonnull
    private static String formatValue(@Nonnull Object value) {
        if (value instanceof Boolean) {
            // by default, .NET uses "True" and "False" but we need lowercase.
            return (Boolean) value ? "true" : "false";
        }
        if (value instanceof Duration) {
            Duration duration = (Duration) value;
            value = duration.getTotalSeconds();
        }
        if (value instanceof Integer) {
            int i = (Integer) value;
            return IntHelper.toString(i, CultureInfoHelper.getInvariantCulture());
        }
        if (value instanceof Double) {
            double d = (Double) value;
            return DoubleHelper.toString(d, CultureInfoHelper.getInvariantCulture());
        }
        if (value instanceof CesiumStripeOrientation) {
            value = CesiumFormattingHelper.stripeOrientationToString((CesiumStripeOrientation) value);
        } else if (value instanceof CesiumHorizontalOrigin) {
            value = CesiumFormattingHelper.horizontalOriginToString((CesiumHorizontalOrigin) value);
        } else if (value instanceof CesiumVerticalOrigin) {
            value = CesiumFormattingHelper.verticalOriginToString((CesiumVerticalOrigin) value);
        } else if (value instanceof CesiumHeightReference) {
            value = CesiumFormattingHelper.heightReferenceToString((CesiumHeightReference) value);
        } else if (value instanceof CesiumPathMode) {
            value = CesiumFormattingHelper.pathModeToString((CesiumPathMode) value);
        } else if (value instanceof CesiumShadowMode) {
            value = CesiumFormattingHelper.shadowModeToString((CesiumShadowMode) value);
        } else if (value instanceof CesiumInterpolationAlgorithm) {
            value = CesiumFormattingHelper.interpolationAlgorithmToString((CesiumInterpolationAlgorithm) value);
        } else if (value instanceof CesiumExtrapolationType) {
            value = CesiumFormattingHelper.extrapolationTypeToString((CesiumExtrapolationType) value);
        } else if (value instanceof CesiumLabelStyle) {
            value = CesiumFormattingHelper.labelStyleToString((CesiumLabelStyle) value);
        } else if (value instanceof CesiumArcType) {
            value = CesiumFormattingHelper.arcTypeToString((CesiumArcType) value);
        } else if (value instanceof CesiumCornerType) {
            value = CesiumFormattingHelper.cornerTypeToString((CesiumCornerType) value);
        } else if (value instanceof CesiumClassificationType) {
            value = CesiumFormattingHelper.classificationTypeToString((CesiumClassificationType) value);
        } else if (value instanceof CesiumColorBlendMode) {
            value = CesiumFormattingHelper.colorBlendModeToString((CesiumColorBlendMode) value);
        } else if (value instanceof CesiumSensorVolumePortionToDisplay) {
            value = CesiumFormattingHelper.sensorVolumePortionToDisplayToString((CesiumSensorVolumePortionToDisplay) value);
        } else if (value instanceof ClockRange) {
            value = CesiumFormattingHelper.clockRangeToString((ClockRange) value);
        } else if (value instanceof ClockStep) {
            value = CesiumFormattingHelper.clockStepToString((ClockStep) value);
        }
        if (value instanceof String) {
            return StringHelper.format("\"{0}\"", value);
        }
        {
            DoubleList doubleList = value instanceof DoubleList ? (DoubleList) value : null;
            if (!ObjectHelper.referenceEquals(doubleList, null)) {
                final Map<String, Object> tempCollection$0 = MapHelper.create();
                MapHelper.add(tempCollection$0, DoubleListCesiumWriter.ArrayPropertyName, IterableHelper.toList(doubleList));
                return createExpectedJson(tempCollection$0);
            }
        }
        if (value instanceof Color) {
            Color color = (Color) value;
            return formatValueType(ColorCesiumWriter.RgbaPropertyName, decompose(color));
        }
        if (value instanceof Bounds) {
            Bounds bounds = (Bounds) value;
            return formatValueType(DistanceDisplayConditionCesiumWriter.DistanceDisplayConditionPropertyName, decompose(bounds));
        }
        if (value instanceof BoundingRectangle) {
            BoundingRectangle boundingRectangle = (BoundingRectangle) value;
            return formatValueType(BoundingRectangleCesiumWriter.BoundingRectanglePropertyName, decompose(boundingRectangle));
        }
        if (value instanceof NearFarScalar) {
            NearFarScalar nearFarScalar = (NearFarScalar) value;
            return formatValueType(NearFarScalarCesiumWriter.NearFarScalarPropertyName, decompose(nearFarScalar));
        }
        {
            NearFarScalarList nearFarScalarList = value instanceof NearFarScalarList ? (NearFarScalarList) value : null;
            if (!ObjectHelper.referenceEquals(nearFarScalarList, null)) {
                final Map<String, Object> tempCollection$1 = MapHelper.create();
                MapHelper.add(tempCollection$1, NearFarScalarCesiumWriter.NearFarScalarPropertyName,
                        IterableHelper.selectMany(nearFarScalarList, Func2.<NearFarScalar, Iterable<Object>> of((NearFarScalar o) -> {
                            return decompose(o);
                        })));
                return createExpectedJson(tempCollection$1);
            }
        }
        if (value instanceof Rectangular) {
            Rectangular rectangular = (Rectangular) value;
            return formatValueType(PixelOffsetCesiumWriter.Cartesian2PropertyName, decompose(rectangular));
        }
        {
            ShapeList shapeList = value instanceof ShapeList ? (ShapeList) value : null;
            if (!ObjectHelper.referenceEquals(shapeList, null)) {
                final Map<String, Object> tempCollection$2 = MapHelper.create();
                MapHelper.add(tempCollection$2, ShapeCesiumWriter.Cartesian2PropertyName, IterableHelper.selectMany(shapeList, Func2.<Rectangular, Iterable<Object>> of((Rectangular o) -> {
                    return decompose(o);
                })));
                return createExpectedJson(tempCollection$2);
            }
        }
        if (value instanceof Cartesian) {
            Cartesian cartesian = (Cartesian) value;
            return formatValueType(PositionCesiumWriter.CartesianPropertyName, decompose(cartesian));
        }
        {
            PositionList positionList = value instanceof PositionList ? (PositionList) value : null;
            if (!ObjectHelper.referenceEquals(positionList, null)) {
                final Map<String, Object> tempCollection$3 = MapHelper.create();
                MapHelper.add(tempCollection$3, PositionListCesiumWriter.CartesianPropertyName, IterableHelper.selectMany(positionList, Func2.<Cartesian, Iterable<Object>> of((Cartesian o) -> {
                    return decompose(o);
                })));
                return createExpectedJson(tempCollection$3);
            }
        }
        if (value instanceof Cartographic) {
            Cartographic cartographic = (Cartographic) value;
            return formatValueType(PositionCesiumWriter.CartographicRadiansPropertyName, decompose(cartographic));
        }
        if (value instanceof UnitCartesian) {
            UnitCartesian unitCartesian = (UnitCartesian) value;
            return formatValueType(DirectionCesiumWriter.UnitCartesianPropertyName, decompose(unitCartesian));
        }
        if (value instanceof UnitQuaternion) {
            UnitQuaternion unitQuaternion = (UnitQuaternion) value;
            return formatValueType(RotationCesiumWriter.UnitQuaternionPropertyName, decompose(unitQuaternion));
        }
        if (value instanceof UnitSpherical) {
            UnitSpherical unitSpherical = (UnitSpherical) value;
            return formatValueType(DirectionCesiumWriter.UnitSphericalPropertyName, decompose(unitSpherical));
        }
        {
            UnitSphericalList unitSphericalList = value instanceof UnitSphericalList ? (UnitSphericalList) value : null;
            if (!ObjectHelper.referenceEquals(unitSphericalList, null)) {
                final Map<String, Object> tempCollection$4 = MapHelper.create();
                MapHelper.add(tempCollection$4, DirectionListCesiumWriter.UnitSphericalPropertyName,
                        IterableHelper.selectMany(unitSphericalList, Func2.<UnitSpherical, Iterable<Object>> of((UnitSpherical o) -> {
                            return decompose(o);
                        })));
                return createExpectedJson(tempCollection$4);
            }
        }
        {
            CartographicExtent cartographicExtent = value instanceof CartographicExtent ? (CartographicExtent) value : null;
            if (!ObjectHelper.referenceEquals(cartographicExtent, null)) {
                return formatValueType(RectangleCoordinatesCesiumWriter.WsenPropertyName, decompose(cartographicExtent));
            }
        }
        {
            Map<String, Object> dictionary = value instanceof Map ? (Map<String, Object>) value : null;
            if (!ObjectHelper.referenceEquals(dictionary, null)) {
                return createExpectedJson(dictionary);
            }
        }
        {
            Iterable list = value instanceof Iterable ? (Iterable) value : null;
            if (!ObjectHelper.referenceEquals(list, null)) {
                StringBuilder builder = new StringBuilder();
                builder.append('[');
                for (final Object o : list) {
                    builder.append(formatValue(o)).append(',');
                }
                builder.setCharAt(builder.length() - 1, ']');
                return builder.toString();
            }
        }
        return value.toString();
    }

    private static ArrayList<Object> decompose(@Nonnull UnitSpherical value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getClock());
        tempCollection$0.add(value.getCone());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull Color value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getRed());
        tempCollection$0.add(value.getGreen());
        tempCollection$0.add(value.getBlue());
        tempCollection$0.add(value.getAlpha());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull Bounds value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getLowerBound());
        tempCollection$0.add(value.getUpperBound());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull BoundingRectangle value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getLeft());
        tempCollection$0.add(value.getBottom());
        tempCollection$0.add(value.getWidth());
        tempCollection$0.add(value.getHeight());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull NearFarScalar value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getNearDistance());
        tempCollection$0.add(value.getNearValue());
        tempCollection$0.add(value.getFarDistance());
        tempCollection$0.add(value.getFarValue());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull Rectangular value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getX());
        tempCollection$0.add(value.getY());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull Cartesian value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getX());
        tempCollection$0.add(value.getY());
        tempCollection$0.add(value.getZ());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull Cartographic value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getLongitude());
        tempCollection$0.add(value.getLatitude());
        tempCollection$0.add(value.getHeight());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull UnitCartesian value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getX());
        tempCollection$0.add(value.getY());
        tempCollection$0.add(value.getZ());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(@Nonnull UnitQuaternion value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getX());
        tempCollection$0.add(value.getY());
        tempCollection$0.add(value.getZ());
        tempCollection$0.add(value.getW());
        return tempCollection$0;
    }

    private static ArrayList<Object> decompose(CartographicExtent value) {
        final ArrayList<Object> tempCollection$0 = new ArrayList<Object>();
        tempCollection$0.add(value.getWestLongitude());
        tempCollection$0.add(value.getSouthLatitude());
        tempCollection$0.add(value.getEastLongitude());
        tempCollection$0.add(value.getNorthLatitude());
        return tempCollection$0;
    }

    private static String formatValueType(String propertyName, Iterable values) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, values);
        return createExpectedJson(tempCollection$0);
    }

    @CS2JWarning("Unhandled attribute removed: AssertionMethod")
    public final void assertExpectedJson(@Nonnull String topLevelPropertyName, @Nonnull Map<String, Object> dictionary) {
        String expectedJson = createExpectedJson(topLevelPropertyName, dictionary);
        AssertHelper.assertEquals(expectedJson, getStringWriter().toString());
    }

    @CS2JWarning("Unhandled attribute removed: AssertionMethod")
    public final void assertExpectedJson(@Nonnull Map<String, Object> dictionary) {
        String expectedJson = createExpectedJson(dictionary);
        AssertHelper.assertEquals(expectedJson, getStringWriter().toString());
    }

    public static final class UnitSphericalList extends ArrayList<UnitSpherical> {}

    public static final class DoubleList extends ArrayList<Double> {}

    public static final class NearFarScalarList extends ArrayList<NearFarScalar> {}

    public static final class PositionList extends ArrayList<Cartesian> {}

    public static final class ShapeList extends ArrayList<Rectangular> {}

    private StringWriter backingField$StringWriter;
    private CesiumOutputStream backingField$OutputStream;
    private CesiumStreamWriter backingField$Writer;
}