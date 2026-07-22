package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
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
public class TestVectorCesiumWriter extends TestCesiumPropertyWriter<VectorCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<VectorCesiumWriter> using$1 = new Using<VectorCesiumWriter>(packet.openVectorProperty())) {
                final VectorCesiumWriter vector = using$1.resource;
                try (Using<VectorCesiumWriter> using$2 = new Using<VectorCesiumWriter>(vector.openInterval())) {
                    final VectorCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(VectorCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<VectorCesiumWriter> using$1 = new Using<VectorCesiumWriter>(packet.openVectorProperty())) {
                final VectorCesiumWriter vector = using$1.resource;
                try (Using<VectorCesiumWriter> using$2 = new Using<VectorCesiumWriter>(vector.openInterval())) {
                    final VectorCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expected);
                }
            }
        }
        assertPropertyJson(VectorCesiumWriter.ColorPropertyName, expected);
    }

    @Test
    public final void testDirection() {
        Cartesian expected = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<VectorCesiumWriter> using$1 = new Using<VectorCesiumWriter>(packet.openVectorProperty())) {
                final VectorCesiumWriter vector = using$1.resource;
                try (Using<VectorCesiumWriter> using$2 = new Using<VectorCesiumWriter>(vector.openInterval())) {
                    final VectorCesiumWriter interval = using$2.resource;
                    try (Using<DirectionCesiumWriter> using$3 = new Using<DirectionCesiumWriter>(interval.openDirectionProperty())) {
                        final DirectionCesiumWriter direction = using$3.resource;
                        direction.writeCartesian(expected);
                    }
                }
            }
        }
        assertPropertyJson(VectorCesiumWriter.DirectionPropertyName, expected);
    }

    @Test
    public final void testDirectionUnitSpherical() {
        UnitSpherical expected = new UnitSpherical(1.0, 2.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<VectorCesiumWriter> using$1 = new Using<VectorCesiumWriter>(packet.openVectorProperty())) {
                final VectorCesiumWriter vector = using$1.resource;
                try (Using<VectorCesiumWriter> using$2 = new Using<VectorCesiumWriter>(vector.openInterval())) {
                    final VectorCesiumWriter interval = using$2.resource;
                    try (Using<DirectionCesiumWriter> using$3 = new Using<DirectionCesiumWriter>(interval.openDirectionProperty())) {
                        final DirectionCesiumWriter direction = using$3.resource;
                        direction.writeUnitSpherical(expected);
                    }
                }
            }
        }
        assertPropertyJson(VectorCesiumWriter.DirectionPropertyName, expected);
    }

    @Test
    public final void testLength() {
        final double expected = 123.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<VectorCesiumWriter> using$1 = new Using<VectorCesiumWriter>(packet.openVectorProperty())) {
                final VectorCesiumWriter vector = using$1.resource;
                try (Using<VectorCesiumWriter> using$2 = new Using<VectorCesiumWriter>(vector.openInterval())) {
                    final VectorCesiumWriter interval = using$2.resource;
                    interval.writeLengthProperty(expected);
                }
            }
        }
        assertPropertyJson(VectorCesiumWriter.LengthPropertyName, expected);
    }

    @Test
    public final void testMinimumLengthInPixels() {
        final double expected = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<VectorCesiumWriter> using$1 = new Using<VectorCesiumWriter>(packet.openVectorProperty())) {
                final VectorCesiumWriter vector = using$1.resource;
                try (Using<VectorCesiumWriter> using$2 = new Using<VectorCesiumWriter>(vector.openInterval())) {
                    final VectorCesiumWriter interval = using$2.resource;
                    interval.writeMinimumLengthInPixelsProperty(expected);
                }
            }
        }
        assertPropertyJson(VectorCesiumWriter.MinimumLengthInPixelsPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.VectorPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<VectorCesiumWriter> createPropertyWriter(String propertyName) {
        return new VectorCesiumWriter(propertyName);
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