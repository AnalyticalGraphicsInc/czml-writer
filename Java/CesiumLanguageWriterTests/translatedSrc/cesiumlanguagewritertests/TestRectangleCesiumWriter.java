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
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testCoordinatesProperty() {
        CartographicExtent expectedCoordinates = new CartographicExtent(-1.0, -2.0, 3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeCoordinatesProperty(expectedCoordinates);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.CoordinatesPropertyName, expectedCoordinates);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testExtrudedHeightProperty() {
        final double expectedExtrudedHeight = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightProperty(expectedExtrudedHeight);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ExtrudedHeightPropertyName, expectedExtrudedHeight);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testExtrudedHeightReferenceProperty() {
        final CesiumHeightReference expectedExtrudedHeightReference = CesiumHeightReference.RELATIVE_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightReferenceProperty(expectedExtrudedHeightReference);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ExtrudedHeightReferencePropertyName, expectedExtrudedHeightReference);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testFillProperty() {
        final boolean expectedFill = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expectedFill);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.FillPropertyName, expectedFill);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineProperty() {
        final boolean expectedOutline = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expectedOutline);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.OutlinePropertyName, expectedOutline);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineColorProperty() {
        Color expectedOutlineColor = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expectedOutlineColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.OutlineColorPropertyName, expectedOutlineColor);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineWidthProperty() {
        final double expectedOutlineWidth = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expectedOutlineWidth);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.OutlineWidthPropertyName, expectedOutlineWidth);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testHeightProperty() {
        final double expectedHeight = 100.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeHeightProperty(expectedHeight);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.HeightPropertyName, expectedHeight);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testHeightReferenceProperty() {
        final CesiumHeightReference expectedHeightReference = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expectedHeightReference);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.HeightReferencePropertyName, expectedHeightReference);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testRotationProperty() {
        final double expectedRotation = 1.234;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeRotationProperty(expectedRotation);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.RotationPropertyName, expectedRotation);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testStRotationProperty() {
        final double expectedStRotation = 0.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeStRotationProperty(expectedStRotation);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.StRotationPropertyName, expectedStRotation);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testGranularityProperty() {
        final double expectedGranularity = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeGranularityProperty(expectedGranularity);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.GranularityPropertyName, expectedGranularity);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testMaterialProperty() {
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
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testShadowsProperty() {
        final CesiumShadowMode expectedShadows = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expectedShadows);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ShadowsPropertyName, expectedShadows);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testDistanceDisplayConditionProperty() {
        Bounds expectedBounds = new Bounds(1.0, 123.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expectedBounds);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testClassificationTypeProperty() {
        final CesiumClassificationType expectedClassificationType = CesiumClassificationType.TERRAIN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeClassificationTypeProperty(expectedClassificationType);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ClassificationTypePropertyName, expectedClassificationType);
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Test
    public final void testZIndexProperty() {
        final int expectedZIndex = 5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(packet.openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeZIndexProperty(expectedZIndex);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ZIndexPropertyName, expectedZIndex);
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