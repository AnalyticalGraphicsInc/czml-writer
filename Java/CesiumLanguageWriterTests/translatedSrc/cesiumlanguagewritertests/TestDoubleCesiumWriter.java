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
public class TestDoubleCesiumWriter extends TestCesiumPropertyWriter<DoubleCesiumWriter> {
    @Test
    public final void doubleCanBeWrittenAsSimpleNumber() {
        final String expectedPropertyName = "foo";
        final double expectedValue = 1.23;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<DoubleCesiumWriter> using$1 = new Using<DoubleCesiumWriter>(new DoubleCesiumWriter(expectedPropertyName))) {
                final DoubleCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeNumber(expectedValue);
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, expectedPropertyName, expectedValue);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void doubleCanBeWrittenInsideInterval() {
        JulianDate start = new GregorianDate(2012, 6, 7, 12, 0, 0.0).toJulianDate();
        JulianDate stop = start.addSeconds(100.0);
        final String expectedPropertyName = "foo";
        final double expectedValue = 1.23;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<DoubleCesiumWriter> using$1 = new Using<DoubleCesiumWriter>(new DoubleCesiumWriter(expectedPropertyName))) {
                final DoubleCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeInterval(start, stop);
                writer.writeNumber(expectedValue);
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$0, DoubleCesiumWriter.NumberPropertyName, expectedValue);
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stop = start.addDays(1.0);
        final String expectedId = "id";
        final String expectedPropertyName = "foo";
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            getPacket().writeId(expectedId);
            try (Using<DoubleCesiumWriter> using$1 = new Using<DoubleCesiumWriter>(new DoubleCesiumWriter(expectedPropertyName))) {
                final DoubleCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeInterval(start, stop);
                writer.writeDelete(expectedDelete);
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, DoubleCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
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
            try (Using<DoubleCesiumWriter> using$1 = new Using<DoubleCesiumWriter>(new DoubleCesiumWriter(expectedPropertyName))) {
                final DoubleCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeDelete(expectedDelete);
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, DoubleCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, expectedPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<DoubleCesiumWriter> createPropertyWriter(String propertyName) {
        return new DoubleCesiumWriter(propertyName);
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