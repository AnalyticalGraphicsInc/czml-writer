package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.util.Map;
import javax.annotation.Nonnull;
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
public class TestHorizontalOriginCesiumWriter extends TestCesiumPropertyWriter<HorizontalOriginCesiumWriter> {
    @Test
    public final void horizontalOriginCanBeWrittenAsSimpleString() {
        final String expectedPropertyName = "foo";
        final CesiumHorizontalOrigin expectedValue = CesiumHorizontalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<HorizontalOriginCesiumWriter> using$1 = new Using<HorizontalOriginCesiumWriter>(new HorizontalOriginCesiumWriter(expectedPropertyName))) {
                final HorizontalOriginCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeHorizontalOrigin(expectedValue);
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, expectedPropertyName, CesiumFormattingHelper.horizontalOriginToString(expectedValue));
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void horizontalOriginCanBeWrittenInsideInterval() {
        JulianDate start = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addSeconds(100.0);
        final String expectedPropertyName = "foo";
        final CesiumHorizontalOrigin expectedValue = CesiumHorizontalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<HorizontalOriginCesiumWriter> using$1 = new Using<HorizontalOriginCesiumWriter>(new HorizontalOriginCesiumWriter(expectedPropertyName))) {
                final HorizontalOriginCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeInterval(start, stop);
                writer.writeHorizontalOrigin(expectedValue);
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$0, HorizontalOriginCesiumWriter.HorizontalOriginPropertyName, CesiumFormattingHelper.horizontalOriginToString(expectedValue));
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<HorizontalOriginCesiumWriter> createPropertyWriter(String propertyName) {
        return new HorizontalOriginCesiumWriter(propertyName);
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