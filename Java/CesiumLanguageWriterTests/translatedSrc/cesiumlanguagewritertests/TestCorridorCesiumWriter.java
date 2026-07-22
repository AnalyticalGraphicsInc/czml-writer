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
public class TestCorridorCesiumWriter extends TestCesiumPropertyWriter<CorridorCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testPositions() {
        final PositionList tempCollection$0 = new PositionList();
        tempCollection$0.add(new Cartesian(1.0, 2.0, 3.0));
        tempCollection$0.add(new Cartesian(4.0, 5.0, 6.0));
        PositionList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writePositionsProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.PositionsPropertyName, expected);
    }

    @Test
    public final void testWidth() {
        final double expected = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.WidthPropertyName, expected);
    }

    @Test
    public final void testHeight() {
        final double expected = 100.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.HeightPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testExtrudedHeight() {
        final double expected = 200.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.ExtrudedHeightPropertyName, expected);
    }

    @Test
    public final void testExtrudedHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.RELATIVE_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
    }

    @Test
    public final void testCornerType() {
        final CesiumCornerType expected = CesiumCornerType.BEVELED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeCornerTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.CornerTypePropertyName, expected);
    }

    @Test
    public final void testGranularity() {
        final double expected = 0.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeGranularityProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.GranularityPropertyName, expected);
    }

    @Test
    public final void testFill() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(CorridorCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1.0, 123.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testClassificationType() {
        final CesiumClassificationType expected = CesiumClassificationType.TERRAIN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeClassificationTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.ClassificationTypePropertyName, expected);
    }

    @Test
    public final void testZIndex() {
        final int expected = 5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CorridorCesiumWriter> using$1 = new Using<CorridorCesiumWriter>(packet.openCorridorProperty())) {
                final CorridorCesiumWriter corridor = using$1.resource;
                try (Using<CorridorCesiumWriter> using$2 = new Using<CorridorCesiumWriter>(corridor.openInterval())) {
                    final CorridorCesiumWriter interval = using$2.resource;
                    interval.writeZIndexProperty(expected);
                }
            }
        }
        assertPropertyJson(CorridorCesiumWriter.ZIndexPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.CorridorPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<CorridorCesiumWriter> createPropertyWriter(String propertyName) {
        return new CorridorCesiumWriter(propertyName);
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