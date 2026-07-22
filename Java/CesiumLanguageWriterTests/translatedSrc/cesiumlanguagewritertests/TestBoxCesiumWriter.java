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
public class TestBoxCesiumWriter extends TestCesiumPropertyWriter<BoxCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testDimensions() {
        Cartesian expected = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    try (Using<BoxDimensionsCesiumWriter> using$3 = new Using<BoxDimensionsCesiumWriter>(interval.openDimensionsProperty())) {
                        final BoxDimensionsCesiumWriter dimensions = using$3.resource;
                        dimensions.writeCartesian(expected);
                    }
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.DimensionsPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testFill() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(BoxCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1.0, 123.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BoxCesiumWriter> using$1 = new Using<BoxCesiumWriter>(packet.openBoxProperty())) {
                final BoxCesiumWriter box = using$1.resource;
                try (Using<BoxCesiumWriter> using$2 = new Using<BoxCesiumWriter>(box.openInterval())) {
                    final BoxCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(BoxCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.BoxPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<BoxCesiumWriter> createPropertyWriter(String propertyName) {
        return new BoxCesiumWriter(propertyName);
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