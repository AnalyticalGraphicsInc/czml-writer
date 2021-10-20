package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.util.LinkedHashMap;
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
public class TestBooleanCesiumWriter extends TestCesiumPropertyWriter<BooleanCesiumWriter> {
    @Test
    public final void booleanCanBeWrittenAsSimpleBoolean() {
        final String expectedPropertyName = "foo";
        final boolean expectedValue = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<BooleanCesiumWriter> using$1 = new Using<BooleanCesiumWriter>(new BooleanCesiumWriter(expectedPropertyName))) {
                final BooleanCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeBoolean(expectedValue);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, expectedPropertyName, expectedValue);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void booleanCanBeWrittenInsideInterval() {
        JulianDate start = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addSeconds(100.0);
        final String expectedPropertyName = "foo";
        final boolean expectedValue = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<BooleanCesiumWriter> using$1 = new Using<BooleanCesiumWriter>(new BooleanCesiumWriter(expectedPropertyName))) {
                final BooleanCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeInterval(start, stop);
                writer.writeBoolean(expectedValue);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$0, BooleanCesiumWriter.BooleanPropertyName, expectedValue);
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addDays(1.0);
        final String expectedId = "id";
        final String expectedPropertyName = "foo";
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            getPacket().writeId(expectedId);
            try (Using<BooleanCesiumWriter> using$1 = new Using<BooleanCesiumWriter>(new BooleanCesiumWriter(expectedPropertyName))) {
                final BooleanCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeInterval(start, stop);
                writer.writeDelete(expectedDelete);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, BooleanCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, expectedPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        final String expectedId = "id";
        final String expectedPropertyName = "foo";
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            getPacket().writeId(expectedId);
            try (Using<BooleanCesiumWriter> using$1 = new Using<BooleanCesiumWriter>(new BooleanCesiumWriter(expectedPropertyName))) {
                final BooleanCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeDelete(expectedDelete);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, BooleanCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, expectedPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<BooleanCesiumWriter> createPropertyWriter(String propertyName) {
        return new BooleanCesiumWriter(propertyName);
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