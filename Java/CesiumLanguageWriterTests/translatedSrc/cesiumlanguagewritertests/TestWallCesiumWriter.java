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
public class TestWallCesiumWriter extends TestCesiumPropertyWriter<WallCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testGranularityProperty() {
        final double expectedGranularity = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeGranularityProperty(expectedGranularity);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.GranularityPropertyName, expectedGranularity);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testFillProperty() {
        final boolean expectedFill = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expectedFill);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.FillPropertyName, expectedFill);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineProperty() {
        final boolean expectedOutline = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expectedOutline);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.OutlinePropertyName, expectedOutline);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineColorProperty() {
        Color expectedColor = ColorHelper.fromArgb(255, 255, 0, 0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expectedColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.OutlineColorPropertyName, expectedColor);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineWidthProperty() {
        final double expectedOutlineWidth = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expectedOutlineWidth);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.OutlineWidthPropertyName, expectedOutlineWidth);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testShadowsProperty() {
        final CesiumShadowMode expectedShadows = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expectedShadows);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.ShadowsPropertyName, expectedShadows);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testDistanceDisplayConditionProperty() {
        Bounds expectedBounds = new Bounds(1234.0, 5678.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<WallCesiumWriter> using$1 = new Using<WallCesiumWriter>(packet.openWallProperty())) {
                final WallCesiumWriter wall = using$1.resource;
                try (Using<WallCesiumWriter> using$2 = new Using<WallCesiumWriter>(wall.openInterval())) {
                    final WallCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expectedBounds);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds);
        assertExpectedJson(PacketCesiumWriter.WallPropertyName, tempCollection$0);
    }

    @Test
    public final void testMaterialProperty() {
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
                            solidColor.writeColorProperty(Color.RED);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, SolidColorMaterialCesiumWriter.ColorPropertyName, Color.RED);
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.SolidColorPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, WallCesiumWriter.MaterialPropertyName, tempCollection$1);
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