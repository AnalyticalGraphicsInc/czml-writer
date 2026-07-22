package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.Collection;
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
public class TestFanCesiumWriter extends TestCesiumPropertyWriter<FanCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testDirections() {
        final SphericalList tempCollection$0 = new SphericalList();
        tempCollection$0.add(new Spherical(1.0, 2.0, 10.0));
        tempCollection$0.add(new Spherical(3.0, 4.0, 20.0));
        SphericalList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeDirectionsProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.DirectionsPropertyName, expected);
    }

    @Test
    public final void testRadius() {
        final double expected = 123.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.RadiusPropertyName, expected);
    }

    @Test
    public final void testPerDirectionRadius() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writePerDirectionRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.PerDirectionRadiusPropertyName, expected);
    }

    @Test
    public final void testFill() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(interval.openMaterialProperty())) {
                        final MaterialCesiumWriter material = using$3.resource;
                        try (Using<SolidColorMaterialCesiumWriter> using$4 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                            final SolidColorMaterialCesiumWriter solidColor = using$4.resource;
                            solidColor.writeColorProperty(expectedColor);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineMaterialCesiumWriter.SolidColorPropertyName, tempCollection$1);
        assertPropertyJson(FanCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testNumberOfRings() {
        final int expected = 3;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<FanCesiumWriter> using$1 = new Using<FanCesiumWriter>(packet.openFanProperty())) {
                final FanCesiumWriter fan = using$1.resource;
                try (Using<FanCesiumWriter> using$2 = new Using<FanCesiumWriter>(fan.openInterval())) {
                    final FanCesiumWriter interval = using$2.resource;
                    interval.writeNumberOfRingsProperty(expected);
                }
            }
        }
        assertPropertyJson(FanCesiumWriter.NumberOfRingsPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.FanPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<FanCesiumWriter> createPropertyWriter(String propertyName) {
        return new FanCesiumWriter(propertyName);
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