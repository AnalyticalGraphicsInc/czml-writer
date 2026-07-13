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
public class TestPixelOffsetCesiumWriter extends TestCesiumInterpolatablePropertyWriter<PixelOffsetCesiumWriter> {
    @Test
    public final void writeCartesian2() {
        Rectangular expected = new Rectangular(10.0, 20.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    try (Using<PixelOffsetCesiumWriter> using$3 = new Using<PixelOffsetCesiumWriter>(interval.openPixelOffsetProperty())) {
                        final PixelOffsetCesiumWriter pixelOffset = using$3.resource;
                        pixelOffset.writeCartesian2(expected);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.PixelOffsetPropertyName, expected);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void writeReference() {
        final String expectedIdentifier = "someId";
        final String expectedPropertyName = "pixelOffset";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    try (Using<PixelOffsetCesiumWriter> using$3 = new Using<PixelOffsetCesiumWriter>(interval.openPixelOffsetProperty())) {
                        final PixelOffsetCesiumWriter pixelOffset = using$3.resource;
                        pixelOffset.writeReference(expectedIdentifier, expectedPropertyName);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, PixelOffsetCesiumWriter.ReferencePropertyName, expectedIdentifier + "#" + expectedPropertyName);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.PixelOffsetPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testDeleteProperty() {
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    try (Using<PixelOffsetCesiumWriter> using$3 = new Using<PixelOffsetCesiumWriter>(interval.openPixelOffsetProperty())) {
                        final PixelOffsetCesiumWriter pixelOffset = using$3.resource;
                        pixelOffset.writeDelete(expectedDelete);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, PixelOffsetCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.PixelOffsetPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PixelOffsetCesiumWriter> createPropertyWriter(String propertyName) {
        return new PixelOffsetCesiumWriter(propertyName);
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