package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
public abstract class TestCesiumPropertyWriter<TDerived extends CesiumPropertyWriter<TDerived>> extends TestWriterBase {
    @Nonnull
    protected abstract CesiumPropertyWriter<TDerived> createPropertyWriter(@Nonnull String propertyName);

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

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}