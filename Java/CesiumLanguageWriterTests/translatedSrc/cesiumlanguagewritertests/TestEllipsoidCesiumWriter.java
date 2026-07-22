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
public class TestEllipsoidCesiumWriter extends TestCesiumPropertyWriter<EllipsoidCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testRadii() {
        Cartesian expected = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    try (Using<EllipsoidRadiiCesiumWriter> using$3 = new Using<EllipsoidRadiiCesiumWriter>(interval.openRadiiProperty())) {
                        final EllipsoidRadiiCesiumWriter radii = using$3.resource;
                        radii.writeCartesian(expected);
                    }
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.RadiiPropertyName, expected);
    }

    @Test
    public final void testInnerRadii() {
        Cartesian expected = new Cartesian(0.5, 1.0, 1.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    try (Using<EllipsoidRadiiCesiumWriter> using$3 = new Using<EllipsoidRadiiCesiumWriter>(interval.openInnerRadiiProperty())) {
                        final EllipsoidRadiiCesiumWriter radii = using$3.resource;
                        radii.writeCartesian(expected);
                    }
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.InnerRadiiPropertyName, expected);
    }

    @Test
    public final void testMinimumClock() {
        final double expected = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeMinimumClockProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.MinimumClockPropertyName, expected);
    }

    @Test
    public final void testMaximumClock() {
        final double expected = 1.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeMaximumClockProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.MaximumClockPropertyName, expected);
    }

    @Test
    public final void testMinimumCone() {
        final double expected = 0.2;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeMinimumConeProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.MinimumConePropertyName, expected);
    }

    @Test
    public final void testMaximumCone() {
        final double expected = 1.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeMaximumConeProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.MaximumConePropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testFill() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(EllipsoidCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testStackPartitions() {
        final int expected = 32;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeStackPartitionsProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.StackPartitionsPropertyName, expected);
    }

    @Test
    public final void testSlicePartitions() {
        final int expected = 32;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeSlicePartitionsProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.SlicePartitionsPropertyName, expected);
    }

    @Test
    public final void testSubdivisions() {
        final int expected = 64;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeSubdivisionsProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.SubdivisionsPropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1.0, 123.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipsoidCesiumWriter> using$1 = new Using<EllipsoidCesiumWriter>(packet.openEllipsoidProperty())) {
                final EllipsoidCesiumWriter ellipsoid = using$1.resource;
                try (Using<EllipsoidCesiumWriter> using$2 = new Using<EllipsoidCesiumWriter>(ellipsoid.openInterval())) {
                    final EllipsoidCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipsoidCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.EllipsoidPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<EllipsoidCesiumWriter> createPropertyWriter(String propertyName) {
        return new EllipsoidCesiumWriter(propertyName);
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