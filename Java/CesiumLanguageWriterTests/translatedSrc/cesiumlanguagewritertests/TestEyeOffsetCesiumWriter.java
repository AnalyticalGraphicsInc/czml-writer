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
public class TestEyeOffsetCesiumWriter extends TestCesiumInterpolatablePropertyWriter<EyeOffsetCesiumWriter> {
    @Test
    public final void writeCartesian() {
        Cartesian expected = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    try (Using<EyeOffsetCesiumWriter> using$3 = new Using<EyeOffsetCesiumWriter>(interval.openEyeOffsetProperty())) {
                        final EyeOffsetCesiumWriter eyeOffset = using$3.resource;
                        eyeOffset.writeCartesian(expected);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.EyeOffsetPropertyName, expected);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void writeReference() {
        final String expectedIdentifier = "someId";
        final String expectedPropertyName = "eyeOffset";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    try (Using<EyeOffsetCesiumWriter> using$3 = new Using<EyeOffsetCesiumWriter>(interval.openEyeOffsetProperty())) {
                        final EyeOffsetCesiumWriter eyeOffset = using$3.resource;
                        eyeOffset.writeReference(expectedIdentifier, expectedPropertyName);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, EyeOffsetCesiumWriter.ReferencePropertyName, expectedIdentifier + "#" + expectedPropertyName);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.EyeOffsetPropertyName, tempCollection$1);
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
                    try (Using<EyeOffsetCesiumWriter> using$3 = new Using<EyeOffsetCesiumWriter>(interval.openEyeOffsetProperty())) {
                        final EyeOffsetCesiumWriter eyeOffset = using$3.resource;
                        eyeOffset.writeDelete(expectedDelete);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, EyeOffsetCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.EyeOffsetPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<EyeOffsetCesiumWriter> createPropertyWriter(String propertyName) {
        return new EyeOffsetCesiumWriter(propertyName);
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