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
    public static String createExpectedJson(@Nonnull String topLevelPropertyName, @Nonnull Map<String, Object> dictionary) {
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, topLevelPropertyName, dictionary);
        return createExpectedJson(tempCollection$0);
    }

    /**
    * Helper method for creating expected JSON output from key-value pairs.
    */
    public static String createExpectedJson(@Nonnull Map<String, Object> dictionary) {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        for (final Map.Entry<String, Object> pair : dictionary.entrySet()) {
            builder.append('"').append(pair.getKey()).append('"').append(':').append(formatValue(pair.getValue())).append(',');
        }
        builder.setCharAt(builder.length() - 1, '}');
        return builder.toString();
    }

    private static String formatValue(@Nonnull Object value) {
        if (value instanceof Boolean) {
            // in C#, booleans format with a capital first letter
            return StringHelper.toLowerInvariant(value.toString());
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
            final ArrayList<Object> tempCollection$2 = new ArrayList<Object>();
            tempCollection$2.add(color.getRed());
            tempCollection$2.add(color.getGreen());
            tempCollection$2.add(color.getBlue());
            tempCollection$2.add(color.getAlpha());
            final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$1, "rgba", tempCollection$2);
            return createExpectedJson(tempCollection$1);
        }
        if (value instanceof NearFarScalar) {
            NearFarScalar nearFarScalar = (NearFarScalar) value;
            final ArrayList<Object> tempCollection$4 = new ArrayList<Object>();
            tempCollection$4.add(nearFarScalar.getNearDistance());
            tempCollection$4.add(nearFarScalar.getNearValue());
            tempCollection$4.add(nearFarScalar.getFarDistance());
            tempCollection$4.add(nearFarScalar.getFarValue());
            final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$3, "nearFarScalar", tempCollection$4);
            return createExpectedJson(tempCollection$3);
        }
        if (value instanceof Rectangular) {
            Rectangular rectangular = (Rectangular) value;
            final ArrayList<Object> tempCollection$6 = new ArrayList<Object>();
            tempCollection$6.add(rectangular.getX());
            tempCollection$6.add(rectangular.getY());
            final Map<String, Object> tempCollection$5 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$5, "cartesian2", tempCollection$6);
            return createExpectedJson(tempCollection$5);
        }
        if (value instanceof Cartesian) {
            Cartesian cartesian = (Cartesian) value;
            final ArrayList<Object> tempCollection$8 = new ArrayList<Object>();
            tempCollection$8.add(cartesian.getX());
            tempCollection$8.add(cartesian.getY());
            tempCollection$8.add(cartesian.getZ());
            final Map<String, Object> tempCollection$7 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$7, "cartesian", tempCollection$8);
            return createExpectedJson(tempCollection$7);
        }
        if (value instanceof Cartographic) {
            Cartographic cartographic = (Cartographic) value;
            final ArrayList<Object> tempCollection$10 = new ArrayList<Object>();
            tempCollection$10.add(cartographic.getLongitude());
            tempCollection$10.add(cartographic.getLatitude());
            tempCollection$10.add(cartographic.getHeight());
            final Map<String, Object> tempCollection$9 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$9, "cartographicRadians", tempCollection$10);
            return createExpectedJson(tempCollection$9);
        }
        if (value instanceof UnitQuaternion) {
            UnitQuaternion unitQuaternion = (UnitQuaternion) value;
            final ArrayList<Object> tempCollection$12 = new ArrayList<Object>();
            tempCollection$12.add(unitQuaternion.getX());
            tempCollection$12.add(unitQuaternion.getY());
            tempCollection$12.add(unitQuaternion.getZ());
            tempCollection$12.add(unitQuaternion.getW());
            final Map<String, Object> tempCollection$11 = new LinkedHashMap<String, Object>();
            MapHelper.add(tempCollection$11, "unitQuaternion", tempCollection$12);
            return createExpectedJson(tempCollection$11);
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
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("foobar");
        property.open(getOutputStream());
        Assert.assertEquals("{\"foobar\":", getStringWriter().toString());
        property.close();
        Assert.assertEquals("{\"foobar\":", getStringWriter().toString());
    }

    @Test
    public final void singleIntervalWritesOpenObjectLiteral() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
        property.open(getOutputStream());
        TDerived interval = property.openInterval();
        Assert.assertNotNull(interval);
        Assert.assertEquals("{\"woot\":{", getStringWriter().toString());
    }

    @Test
    public final void multipleIntervalsWritesOpenArray() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
        property.open(getOutputStream());
        CesiumIntervalListWriter<TDerived> intervalList = property.openMultipleIntervals();
        Assert.assertNotNull(intervalList);
        Assert.assertEquals("{\"woot\":[", getStringWriter().toString());
    }

    @Test
    public final void closingMultipleIntervalsWritesCloseArray() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
        property.open(getOutputStream());
        CesiumIntervalListWriter<TDerived> intervalList = property.openMultipleIntervals();
        intervalList.close();
        Assert.assertEquals("{\"woot\":[]", getStringWriter().toString());
    }

    @Test
    public final void multipleIntervalsAllowsWritingMultipleIntervals() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stop = new GregorianDate(2012, 4, 2, 13, 0, 0D).toJulianDate();
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
        property.open(getOutputStream());
        CesiumIntervalListWriter<TDerived> intervalList = property.openMultipleIntervals();
        {
            TDerived interval = intervalList.openInterval();
            try {
                interval.writeInterval(start, stop);
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        {
            TDerived interval = intervalList.openInterval();
            try {
                interval.writeInterval(new TimeInterval(start, stop));
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        intervalList.close();
        Assert.assertEquals("{\"woot\":[{\"interval\":\"20120402T12Z/20120402T13Z\"},{\"interval\":\"20120402T12Z/20120402T13Z\"}]", getStringWriter().toString());
    }

    @Test
    public final void throwsWhenWritingToBeforeOpening() {
        final CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
        IllegalStateException exception = AssertHelper.<IllegalStateException> assertThrows(new TypeLiteral<IllegalStateException>() {}, new Action() {
            public void invoke() {
                property.openInterval();
            }
        });
        AssertHelper.assertStringContains("not currently open", exception.getMessage());
    }

    @Test
    public final void throwsWhenWritingToAfterClosed() {
        final CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
        property.open(getOutputStream());
        property.close();
        IllegalStateException exception = AssertHelper.<IllegalStateException> assertThrows(new TypeLiteral<IllegalStateException>() {}, new Action() {
            public void invoke() {
                property.openInterval();
            }
        });
        AssertHelper.assertStringContains("not currently open", exception.getMessage());
    }

    private StringWriter backingField$StringWriter;
    private CesiumOutputStream backingField$OutputStream;
    private CesiumStreamWriter backingField$Writer;
    private PacketCesiumWriter backingField$Packet;
    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}