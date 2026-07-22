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
public class TestRectangleCesiumWriter extends TestCesiumPropertyWriter<RectangleCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testCoordinates() {
        CartographicExtent expected = new CartographicExtent(-1.0, -2.0, 3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeCoordinatesProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.CoordinatesPropertyName, expected);
    }

    @Test
    public final void testExtrudedHeight() {
        final double expected = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.ExtrudedHeightPropertyName, expected);
    }

    @Test
    public final void testExtrudedHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.RELATIVE_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
    }

    @Test
    public final void testFill() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testHeight() {
        final double expected = 100.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.HeightPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testRotation() {
        final double expected = 1.234;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeRotationProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.RotationPropertyName, expected);
    }

    @Test
    public final void testStRotation() {
        final double expected = 0.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeStRotationProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.StRotationPropertyName, expected);
    }

    @Test
    public final void testGranularity() {
        final double expected = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeGranularityProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.GranularityPropertyName, expected);
    }

    @Test
    public final void testMaterialProperty() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(RectangleCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1.0, 123.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testClassificationType() {
        final CesiumClassificationType expected = CesiumClassificationType.TERRAIN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeClassificationTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.ClassificationTypePropertyName, expected);
    }

    @Test
    public final void testZIndex() {
        final int expected = 5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeZIndexProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangleCesiumWriter.ZIndexPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<RectangleCesiumWriter> createPropertyWriter(String propertyName) {
        return new RectangleCesiumWriter(propertyName);
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