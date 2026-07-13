package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.TextWriterHelper;
import agi.foundation.compatibility.Using;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class TestCesiumPropertyWriter<TDerived extends CesiumPropertyWriter<TDerived>> {
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
    public final void testCesiumPropertyWriterSetUp() {
        setStringWriter(new StringWriter());
        setOutputStream(new CesiumOutputStream(getStringWriter()));
        setWriter(new CesiumStreamWriter());
    }

    @After
    public final void tearDown() {
        TextWriterHelper.close(getStringWriter());
    }

    @Nonnull
    public final PacketCesiumWriter openPacket() {
        return getWriter().openPacket(getOutputStream());
    }

    @Nonnull
    protected abstract CesiumPropertyWriter<TDerived> createPropertyWriter(@Nonnull String propertyName);

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
        if (value instanceof Color) {
            Color color = (Color) value;
            final ArrayList<Object> tempCollection$1 = new ArrayList<Object>();
            tempCollection$1.add(color.getRed());
            tempCollection$1.add(color.getGreen());
            tempCollection$1.add(color.getBlue());
            tempCollection$1.add(color.getAlpha());
            final Map<String, Object> tempCollection$0 = MapHelper.create();
            MapHelper.add(tempCollection$0, "rgba", tempCollection$1);
            return createExpectedJson(tempCollection$0);
        }
        if (value instanceof Bounds) {
            Bounds bounds = (Bounds) value;
            final ArrayList<Object> tempCollection$3 = new ArrayList<Object>();
            tempCollection$3.add(bounds.getLowerBound());
            tempCollection$3.add(bounds.getUpperBound());
            final Map<String, Object> tempCollection$2 = MapHelper.create();
            MapHelper.add(tempCollection$2, "distanceDisplayCondition", tempCollection$3);
            return createExpectedJson(tempCollection$2);
        }
        if (value instanceof BoundingRectangle) {
            BoundingRectangle boundingRectangle = (BoundingRectangle) value;
            final ArrayList<Object> tempCollection$5 = new ArrayList<Object>();
            tempCollection$5.add(boundingRectangle.getLeft());
            tempCollection$5.add(boundingRectangle.getBottom());
            tempCollection$5.add(boundingRectangle.getWidth());
            tempCollection$5.add(boundingRectangle.getHeight());
            final Map<String, Object> tempCollection$4 = MapHelper.create();
            MapHelper.add(tempCollection$4, "boundingRectangle", tempCollection$5);
            return createExpectedJson(tempCollection$4);
        }
        if (value instanceof CartographicExtent) {
            CartographicExtent extent = (CartographicExtent) value;
            final ArrayList<Object> tempCollection$7 = new ArrayList<Object>();
            tempCollection$7.add(extent.getWestLongitude());
            tempCollection$7.add(extent.getSouthLatitude());
            tempCollection$7.add(extent.getEastLongitude());
            tempCollection$7.add(extent.getNorthLatitude());
            final Map<String, Object> tempCollection$6 = MapHelper.create();
            MapHelper.add(tempCollection$6, "wsen", tempCollection$7);
            return createExpectedJson(tempCollection$6);
        }
        if (value instanceof NearFarScalar) {
            NearFarScalar nearFarScalar = (NearFarScalar) value;
            final ArrayList<Object> tempCollection$9 = new ArrayList<Object>();
            tempCollection$9.add(nearFarScalar.getNearDistance());
            tempCollection$9.add(nearFarScalar.getNearValue());
            tempCollection$9.add(nearFarScalar.getFarDistance());
            tempCollection$9.add(nearFarScalar.getFarValue());
            final Map<String, Object> tempCollection$8 = MapHelper.create();
            MapHelper.add(tempCollection$8, "nearFarScalar", tempCollection$9);
            return createExpectedJson(tempCollection$8);
        }
        if (value instanceof Rectangular) {
            Rectangular rectangular = (Rectangular) value;
            final ArrayList<Object> tempCollection$11 = new ArrayList<Object>();
            tempCollection$11.add(rectangular.getX());
            tempCollection$11.add(rectangular.getY());
            final Map<String, Object> tempCollection$10 = MapHelper.create();
            MapHelper.add(tempCollection$10, "cartesian2", tempCollection$11);
            return createExpectedJson(tempCollection$10);
        }
        if (value instanceof Cartesian) {
            Cartesian cartesian = (Cartesian) value;
            final ArrayList<Object> tempCollection$13 = new ArrayList<Object>();
            tempCollection$13.add(cartesian.getX());
            tempCollection$13.add(cartesian.getY());
            tempCollection$13.add(cartesian.getZ());
            final Map<String, Object> tempCollection$12 = MapHelper.create();
            MapHelper.add(tempCollection$12, "cartesian", tempCollection$13);
            return createExpectedJson(tempCollection$12);
        }
        if (value instanceof Cartographic) {
            Cartographic cartographic = (Cartographic) value;
            final ArrayList<Object> tempCollection$15 = new ArrayList<Object>();
            tempCollection$15.add(cartographic.getLongitude());
            tempCollection$15.add(cartographic.getLatitude());
            tempCollection$15.add(cartographic.getHeight());
            final Map<String, Object> tempCollection$14 = MapHelper.create();
            MapHelper.add(tempCollection$14, "cartographicRadians", tempCollection$15);
            return createExpectedJson(tempCollection$14);
        }
        if (value instanceof UnitCartesian) {
            UnitCartesian unitCartesian = (UnitCartesian) value;
            final ArrayList<Object> tempCollection$17 = new ArrayList<Object>();
            tempCollection$17.add(unitCartesian.getX());
            tempCollection$17.add(unitCartesian.getY());
            tempCollection$17.add(unitCartesian.getZ());
            final Map<String, Object> tempCollection$16 = MapHelper.create();
            MapHelper.add(tempCollection$16, "unitCartesian", tempCollection$17);
            return createExpectedJson(tempCollection$16);
        }
        if (value instanceof UnitQuaternion) {
            UnitQuaternion unitQuaternion = (UnitQuaternion) value;
            final ArrayList<Object> tempCollection$19 = new ArrayList<Object>();
            tempCollection$19.add(unitQuaternion.getX());
            tempCollection$19.add(unitQuaternion.getY());
            tempCollection$19.add(unitQuaternion.getZ());
            tempCollection$19.add(unitQuaternion.getW());
            final Map<String, Object> tempCollection$18 = MapHelper.create();
            MapHelper.add(tempCollection$18, "unitQuaternion", tempCollection$19);
            return createExpectedJson(tempCollection$18);
        }
        {
            Map<String, Object> dictionary = value instanceof Map ? (Map<String, Object>) value : null;
            if (dictionary != null) {
                return createExpectedJson(dictionary);
            }
        }
        {
            Iterable list = value instanceof Iterable ? (Iterable) value : null;
            if (list != null) {
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

    @Test
    public final void writesPropertyNameOnOpenAndNothingOnClose() {
        final String propertyName = "foobar";
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(propertyName);
        propertyWriter.open(getOutputStream());
        final String expected = "\"" + propertyName + "\":";
        AssertHelper.assertEquals(expected, getStringWriter().toString());
        propertyWriter.close();
        AssertHelper.assertEquals(expected, getStringWriter().toString());
    }

    @Test
    public final void singleIntervalWritesOpenObjectLiteral() {
        final String propertyName = "testObj";
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(propertyName);
        propertyWriter.open(getOutputStream());
        TDerived intervalWriter = propertyWriter.openInterval();
        Assert.assertNotNull(intervalWriter);
        final String expected = "\"" + propertyName + "\":{";
        AssertHelper.assertEquals(expected, getStringWriter().toString());
    }

    @Test
    public final void multipleIntervalsWritesOpenArray() {
        final String propertyName = "testArr";
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(propertyName);
        propertyWriter.open(getOutputStream());
        CesiumIntervalListWriter<TDerived> intervalListWriter = propertyWriter.openMultipleIntervals();
        Assert.assertNotNull(intervalListWriter);
        final String expected = "\"" + propertyName + "\":[";
        AssertHelper.assertEquals(expected, getStringWriter().toString());
    }

    @Test
    public final void closingMultipleIntervalsWritesCloseArray() {
        final String propertyName = "testArr";
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(propertyName);
        propertyWriter.open(getOutputStream());
        CesiumIntervalListWriter<TDerived> intervalListWriter = propertyWriter.openMultipleIntervals();
        Assert.assertNotNull(intervalListWriter);
        intervalListWriter.close();
        final String expected = "\"" + propertyName + "\":[]";
        AssertHelper.assertEquals(expected, getStringWriter().toString());
    }

    @Test
    public final void multipleIntervalsAllowsWritingMultipleIntervals() {
        final String expectedPropertyName = "woot";
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stop = new GregorianDate(2012, 4, 2, 13, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            try (Using<CesiumPropertyWriter<TDerived>> using$1 = new Using<CesiumPropertyWriter<TDerived>>(createPropertyWriter(expectedPropertyName))) {
                final CesiumPropertyWriter<TDerived> propertyWriter = using$1.resource;
                propertyWriter.open(getOutputStream());
                try (Using<CesiumIntervalListWriter<TDerived>> using$2 = new Using<CesiumIntervalListWriter<TDerived>>(propertyWriter.openMultipleIntervals())) {
                    final CesiumIntervalListWriter<TDerived> intervalListWriter = using$2.resource;
                    try (Using<TDerived> using$3 = new Using<TDerived>(intervalListWriter.openInterval())) {
                        final TDerived intervalWriter = using$3.resource;
                        intervalWriter.writeInterval(start, stop);
                    }
                    try (Using<TDerived> using$4 = new Using<TDerived>(intervalListWriter.openInterval())) {
                        final TDerived intervalWriter = using$4.resource;
                        intervalWriter.writeInterval(new TimeInterval(start, stop));
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        final Map<String, Object> tempCollection$3 = MapHelper.create();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        final ArrayList<Object> tempCollection$1 = new ArrayList<Object>();
        tempCollection$1.add(tempCollection$2);
        tempCollection$1.add(tempCollection$3);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, expectedPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void throwsWhenWritingToBeforeOpening() {
        final CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("woot");
        IllegalStateException exception = AssertHelper.<IllegalStateException> assertThrows(new TypeLiteral<IllegalStateException>() {}, Action.of(() -> {
            propertyWriter.openInterval();
        }));
        AssertHelper.assertStringContains("not currently open", exception.getMessage());
    }

    @Test
    public final void throwsWhenWritingToAfterClosed() {
        final CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("woot");
        propertyWriter.open(getOutputStream());
        propertyWriter.close();
        IllegalStateException exception = AssertHelper.<IllegalStateException> assertThrows(new TypeLiteral<IllegalStateException>() {}, Action.of(() -> {
            propertyWriter.openInterval();
        }));
        AssertHelper.assertStringContains("not currently open", exception.getMessage());
    }

    private StringWriter backingField$StringWriter;
    private CesiumOutputStream backingField$OutputStream;
    private CesiumStreamWriter backingField$Writer;
    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}