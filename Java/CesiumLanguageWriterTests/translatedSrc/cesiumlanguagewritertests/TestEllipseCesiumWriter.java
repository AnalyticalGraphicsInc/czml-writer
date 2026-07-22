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
public class TestEllipseCesiumWriter extends TestCesiumPropertyWriter<EllipseCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testSemiMajorAxis() {
        final double expected = 124.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeSemiMajorAxisProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.SemiMajorAxisPropertyName, expected);
    }

    @Test
    public final void testSemiMinorAxis() {
        final double expected = 500.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeSemiMinorAxisProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.SemiMinorAxisPropertyName, expected);
    }

    @Test
    public final void testHeight() {
        final double expected = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.HeightPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testExtrudedHeight() {
        final double expected = 20.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.ExtrudedHeightPropertyName, expected);
    }

    @Test
    public final void testExtrudedHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
    }

    @Test
    public final void testRotation() {
        final double expected = 1.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeRotationProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.RotationPropertyName, expected);
    }

    @Test
    public final void testStRotation() {
        final double expected = 0.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeStRotationProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.StRotationPropertyName, expected);
    }

    @Test
    public final void testGranularity() {
        final double expected = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeGranularityProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.GranularityPropertyName, expected);
    }

    @Test
    public final void testFill() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(EllipseCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testNumberOfVerticalLines() {
        final int expected = 32;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeNumberOfVerticalLinesProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.NumberOfVerticalLinesPropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1.0, 123.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testClassificationType() {
        final CesiumClassificationType expected = CesiumClassificationType.BOTH;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeClassificationTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.ClassificationTypePropertyName, expected);
    }

    @Test
    public final void testZIndex() {
        final int expected = 5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<EllipseCesiumWriter> using$1 = new Using<EllipseCesiumWriter>(packet.openEllipseProperty())) {
                final EllipseCesiumWriter ellipse = using$1.resource;
                try (Using<EllipseCesiumWriter> using$2 = new Using<EllipseCesiumWriter>(ellipse.openInterval())) {
                    final EllipseCesiumWriter interval = using$2.resource;
                    interval.writeZIndexProperty(expected);
                }
            }
        }
        assertPropertyJson(EllipseCesiumWriter.ZIndexPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.EllipsePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<EllipseCesiumWriter> createPropertyWriter(String propertyName) {
        return new EllipseCesiumWriter(propertyName);
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