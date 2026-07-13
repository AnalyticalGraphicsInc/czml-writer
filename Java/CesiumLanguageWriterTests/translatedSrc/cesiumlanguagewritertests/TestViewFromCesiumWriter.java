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
public class TestViewFromCesiumWriter extends TestCesiumPropertyWriter<ViewFromCesiumWriter> {
    @Test
    public final void writeCartesian() {
        Cartesian expected = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ViewFromCesiumWriter> using$1 = new Using<ViewFromCesiumWriter>(packet.openViewFromProperty())) {
                final ViewFromCesiumWriter viewFrom = using$1.resource;
                viewFrom.writeCartesian(expected);
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.ViewFromPropertyName, expected);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void writeReference() {
        final String expectedIdentifier = "someId";
        final String expectedPropertyName = "viewFrom";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ViewFromCesiumWriter> using$1 = new Using<ViewFromCesiumWriter>(packet.openViewFromProperty())) {
                final ViewFromCesiumWriter viewFrom = using$1.resource;
                viewFrom.writeReference(expectedIdentifier, expectedPropertyName);
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ViewFromCesiumWriter.ReferencePropertyName, expectedIdentifier + "#" + expectedPropertyName);
        assertExpectedJson(PacketCesiumWriter.ViewFromPropertyName, tempCollection$0);
    }

    @Test
    public final void testDeleteProperty() {
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ViewFromCesiumWriter> using$1 = new Using<ViewFromCesiumWriter>(packet.openViewFromProperty())) {
                final ViewFromCesiumWriter viewFrom = using$1.resource;
                viewFrom.writeDelete(expectedDelete);
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ViewFromCesiumWriter.DeletePropertyName, expectedDelete);
        assertExpectedJson(PacketCesiumWriter.ViewFromPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<ViewFromCesiumWriter> createPropertyWriter(String propertyName) {
        return new ViewFromCesiumWriter(propertyName);
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