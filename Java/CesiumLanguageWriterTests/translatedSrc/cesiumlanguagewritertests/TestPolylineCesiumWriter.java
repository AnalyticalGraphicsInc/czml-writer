package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
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
public class TestPolylineCesiumWriter extends TestCesiumPropertyWriter<PolylineCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testPositions() {
        final PositionList tempCollection$0 = new PositionList();
        tempCollection$0.add(new Cartesian(1.0, 2.0, 3.0));
        tempCollection$0.add(new Cartesian(4.0, 5.0, 6.0));
        PositionList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writePositionsProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.PositionsPropertyName, expected);
    }

    @Test
    public final void testArcType() {
        final CesiumArcType expected = CesiumArcType.RHUMB;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeArcTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.ArcTypePropertyName, expected);
    }

    @Test
    public final void testWidth() {
        final double expected = 5.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.WidthPropertyName, expected);
    }

    @Test
    public final void testGranularity() {
        final double expected = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeGranularityProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.GranularityPropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    try (Using<PolylineMaterialCesiumWriter> using$3 = new Using<PolylineMaterialCesiumWriter>(interval.openMaterialProperty())) {
                        final PolylineMaterialCesiumWriter material = using$3.resource;
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
        assertPropertyJson(PolylineCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testFollowSurface() {
        final boolean expected = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeFollowSurfaceProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.FollowSurfacePropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDepthFailMaterial() {
        Color expectedColor = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    try (Using<PolylineMaterialCesiumWriter> using$3 = new Using<PolylineMaterialCesiumWriter>(interval.openDepthFailMaterialProperty())) {
                        final PolylineMaterialCesiumWriter material = using$3.resource;
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
        assertPropertyJson(PolylineCesiumWriter.DepthFailMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(10.0, 1234.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testClampToGround() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeClampToGroundProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.ClampToGroundPropertyName, expected);
    }

    @Test
    public final void testClassificationType() {
        final CesiumClassificationType expected = CesiumClassificationType.TERRAIN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeClassificationTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.ClassificationTypePropertyName, expected);
    }

    @Test
    public final void testZIndex() {
        final int expected = 5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineCesiumWriter> using$2 = new Using<PolylineCesiumWriter>(polyline.openInterval())) {
                    final PolylineCesiumWriter interval = using$2.resource;
                    interval.writeZIndexProperty(expected);
                }
            }
        }
        assertPropertyJson(PolylineCesiumWriter.ZIndexPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PolylineCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineCesiumWriter(propertyName);
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