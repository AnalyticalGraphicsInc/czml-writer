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
public class TestWallCesiumWriter extends TestCesiumPropertyWriter<WallCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testPositions() {
        final PositionList tempCollection$0 = new PositionList();
        tempCollection$0.add(new Cartesian(1.0, 2.0, 3.0));
        tempCollection$0.add(new Cartesian(4.0, 5.0, 6.0));
        PositionList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writePositionsProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.PositionsPropertyName, expected);
    }

    @Test
    public final void testGranularity() {
        final double expected = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeGranularityProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.GranularityPropertyName, expected);
    }

    @Test
    public final void testMinimumHeights() {
        final DoubleList tempCollection$0 = new DoubleList();
        tempCollection$0.add(1.0);
        tempCollection$0.add(2.0);
        tempCollection$0.add(3.0);
        DoubleList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeMinimumHeightsProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.MinimumHeightsPropertyName, expected);
    }

    @Test
    public final void testMaximumHeights() {
        final DoubleList tempCollection$0 = new DoubleList();
        tempCollection$0.add(4.0);
        tempCollection$0.add(5.0);
        tempCollection$0.add(6.0);
        DoubleList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeMaximumHeightsProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.MaximumHeightsPropertyName, expected);
    }

    @Test
    public final void testFill() {
        final boolean expected = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(255, 255, 0, 0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1234.0, 5678.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(WallCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(WallCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    private final void assertPropertyJson(String propertyName, Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<WallCesiumWriter> createPropertyWriter(String propertyName) {
        return new WallCesiumWriter(propertyName);
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