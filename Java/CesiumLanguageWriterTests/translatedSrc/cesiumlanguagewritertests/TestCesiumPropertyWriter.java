package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings( {
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

    public final PacketCesiumWriter getPacket() {
        return backingField$Packet;
    }

    private final void setPacket(PacketCesiumWriter value) {
        backingField$Packet = value;
    }

    @Before
    public final void testCesiumPropertyWriterSetUp() {
        setStringWriter(new StringWriter());
        setOutputStream(new CesiumOutputStream(getStringWriter()));
        setWriter(new CesiumStreamWriter());
        setPacket(getWriter().openPacket(getOutputStream()));
    }

    @Nonnull
    protected abstract CesiumPropertyWriter<TDerived> createPropertyWriter(@Nonnull String propertyName);

    /**
    * Helper method for creating expected JSON output from key-value pairs.
    */
    @Nonnull
    public static String createExpectedJson(@Nonnull String topLevelPropertyName, @Nonnull Map<String, Object> dictionary) {
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
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
            // in C#, booleans format with a capital first letter
            return StringHelper.toLowerInvariant(value.toString());
        }
        if (value instanceof Duration) {
            Duration duration = (Duration) value;
            value = duration.getTotalSeconds();
        }
        if (value instanceof Double) {
            double d = (Double) value;
            return DoubleHelper.toString(d, CultureInfoHelper.getInvariantCulture());
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
            final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$0, "rgba", tempCollection$1);
            return createExpectedJson(tempCollection$0);
        }
        if (value instanceof Bounds) {
            Bounds bounds = (Bounds) value;
            final ArrayList<Object> tempCollection$3 = new ArrayList<Object>();
            tempCollection$3.add(bounds.getLowerBound());
            tempCollection$3.add(bounds.getUpperBound());
            final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$2, "distanceDisplayCondition", tempCollection$3);
            return createExpectedJson(tempCollection$2);
        }
        if (value instanceof NearFarScalar) {
            NearFarScalar nearFarScalar = (NearFarScalar) value;
            final ArrayList<Object> tempCollection$5 = new ArrayList<Object>();
            tempCollection$5.add(nearFarScalar.getNearDistance());
            tempCollection$5.add(nearFarScalar.getNearValue());
            tempCollection$5.add(nearFarScalar.getFarDistance());
            tempCollection$5.add(nearFarScalar.getFarValue());
            final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$4, "nearFarScalar", tempCollection$5);
            return createExpectedJson(tempCollection$4);
        }
        if (value instanceof Rectangular) {
            Rectangular rectangular = (Rectangular) value;
            final ArrayList<Object> tempCollection$7 = new ArrayList<Object>();
            tempCollection$7.add(rectangular.getX());
            tempCollection$7.add(rectangular.getY());
            final Map<String, Object> tempCollection$6 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$6, "cartesian2", tempCollection$7);
            return createExpectedJson(tempCollection$6);
        }
        if (value instanceof Cartesian) {
            Cartesian cartesian = (Cartesian) value;
            final ArrayList<Object> tempCollection$9 = new ArrayList<Object>();
            tempCollection$9.add(cartesian.getX());
            tempCollection$9.add(cartesian.getY());
            tempCollection$9.add(cartesian.getZ());
            final Map<String, Object> tempCollection$8 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$8, "cartesian", tempCollection$9);
            return createExpectedJson(tempCollection$8);
        }
        if (value instanceof Cartographic) {
            Cartographic cartographic = (Cartographic) value;
            final ArrayList<Object> tempCollection$11 = new ArrayList<Object>();
            tempCollection$11.add(cartographic.getLongitude());
            tempCollection$11.add(cartographic.getLatitude());
            tempCollection$11.add(cartographic.getHeight());
            final Map<String, Object> tempCollection$10 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$10, "cartographicRadians", tempCollection$11);
            return createExpectedJson(tempCollection$10);
        }
        if (value instanceof UnitQuaternion) {
            UnitQuaternion unitQuaternion = (UnitQuaternion) value;
            final ArrayList<Object> tempCollection$13 = new ArrayList<Object>();
            tempCollection$13.add(unitQuaternion.getX());
            tempCollection$13.add(unitQuaternion.getY());
            tempCollection$13.add(unitQuaternion.getZ());
            tempCollection$13.add(unitQuaternion.getW());
            final Map<String, Object> tempCollection$12 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$12, "unitQuaternion", tempCollection$13);
            return createExpectedJson(tempCollection$12);
        }
        Map<String, Object> dictionary = (value instanceof Map) ? (Map<String, Object>) value : null;
        if (dictionary != null) {
            return createExpectedJson(dictionary);
        }
        Iterable<Object> list = (value instanceof Iterable) ? (Iterable<Object>) value : null;
        if (list != null) {
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            for (final Object o : list) {
                builder.append(formatValue(o)).append(',');
            }
            builder.setCharAt(builder.length() - 1, ']');
            return builder.toString();
        }
        return value.toString();
    }

    @CS2JWarning("Unhandled attribute removed: AssertionMethod")
    public final void assertExpectedJson(@Nonnull String topLevelPropertyName, @Nonnull Map<String, Object> dictionary) {
        String expectedJson = createExpectedJson(topLevelPropertyName, dictionary);
        Assert.assertEquals(expectedJson, getStringWriter().toString());
    }

    @CS2JWarning("Unhandled attribute removed: AssertionMethod")
    public final void assertExpectedJson(@Nonnull Map<String, Object> dictionary) {
        String expectedJson = createExpectedJson(dictionary);
        Assert.assertEquals(expectedJson, getStringWriter().toString());
    }

    @Test
    public final void writesPropertyNameOnOpenAndNothingOnClose() {
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("foobar");
        propertyWriter.open(getOutputStream());
        Assert.assertEquals("{\"foobar\":", getStringWriter().toString());
        propertyWriter.close();
        Assert.assertEquals("{\"foobar\":", getStringWriter().toString());
    }

    @Test
    public final void singleIntervalWritesOpenObjectLiteral() {
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("woot");
        propertyWriter.open(getOutputStream());
        TDerived intervalWriter = propertyWriter.openInterval();
        Assert.assertNotNull(intervalWriter);
        Assert.assertEquals("{\"woot\":{", getStringWriter().toString());
    }

    @Test
    public final void multipleIntervalsWritesOpenArray() {
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("woot");
        propertyWriter.open(getOutputStream());
        CesiumIntervalListWriter<TDerived> intervalListWriter = propertyWriter.openMultipleIntervals();
        Assert.assertNotNull(intervalListWriter);
        Assert.assertEquals("{\"woot\":[", getStringWriter().toString());
    }

    @Test
    public final void closingMultipleIntervalsWritesCloseArray() {
        CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("woot");
        propertyWriter.open(getOutputStream());
        CesiumIntervalListWriter<TDerived> intervalListWriter = propertyWriter.openMultipleIntervals();
        intervalListWriter.close();
        Assert.assertEquals("{\"woot\":[]", getStringWriter().toString());
    }

    @Test
    public final void multipleIntervalsAllowsWritingMultipleIntervals() {
        final String expectedPropertyName = "woot";
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stop = new GregorianDate(2012, 4, 2, 13, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(expectedPropertyName);
                    try {
                        propertyWriter.open(getOutputStream());
                        {
                            CesiumIntervalListWriter<TDerived> intervalListWriter = propertyWriter.openMultipleIntervals();
                            try {
                                {
                                    TDerived intervalWriter = intervalListWriter.openInterval();
                                    try {
                                        intervalWriter.writeInterval(start, stop);
                                    } finally {
                                        DisposeHelper.dispose(intervalWriter);
                                    }
                                }
                                {
                                    TDerived intervalWriter = intervalListWriter.openInterval();
                                    try {
                                        intervalWriter.writeInterval(new TimeInterval(start, stop));
                                    } finally {
                                        DisposeHelper.dispose(intervalWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(intervalListWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(propertyWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        final ArrayList<Object> tempCollection$1 = new ArrayList<Object>();
        tempCollection$1.add(tempCollection$2);
        tempCollection$1.add(tempCollection$3);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, expectedPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void throwsWhenWritingToBeforeOpening() {
        final CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("woot");
        IllegalStateException exception = AssertHelper.<IllegalStateException> assertThrows(new TypeLiteral<IllegalStateException>() {}, new Action() {
            public void invoke() {
                propertyWriter.openInterval();
            }
        });
        AssertHelper.assertStringContains("not currently open", exception.getMessage());
    }

    @Test
    public final void throwsWhenWritingToAfterClosed() {
        final CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter("woot");
        propertyWriter.open(getOutputStream());
        propertyWriter.close();
        IllegalStateException exception = AssertHelper.<IllegalStateException> assertThrows(new TypeLiteral<IllegalStateException>() {}, new Action() {
            public void invoke() {
                propertyWriter.openInterval();
            }
        });
        AssertHelper.assertStringContains("not currently open", exception.getMessage());
    }

    private StringWriter backingField$StringWriter;
    private CesiumOutputStream backingField$OutputStream;
    private CesiumStreamWriter backingField$Writer;
    private PacketCesiumWriter backingField$Packet;
    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}