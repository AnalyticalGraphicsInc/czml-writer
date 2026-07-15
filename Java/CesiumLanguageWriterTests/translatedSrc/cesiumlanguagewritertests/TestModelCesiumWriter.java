package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
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
public class TestModelCesiumWriter extends TestCesiumPropertyWriter<ModelCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testGltf() {
        final String expected = "test.gltf";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeGltfProperty(expected, CesiumResourceBehavior.LINK_TO);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.GltfPropertyName, expected);
    }

    @Test
    public final void testSilhouetteColor() {
        Color expected = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeSilhouetteColorProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.SilhouetteColorPropertyName, expected);
    }

    @Test
    public final void testSilhouetteSize() {
        final double expected = 0.75;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeSilhouetteSizeProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.SilhouetteSizePropertyName, expected);
    }

    @Test
    public final void testColor() {
        Color expected = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.ColorPropertyName, expected);
    }

    @Test
    public final void testColorBlendMode() {
        final CesiumColorBlendMode expected = CesiumColorBlendMode.REPLACE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorBlendModeProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.ColorBlendModePropertyName, expected);
    }

    @Test
    public final void testColorBlendAmount() {
        final double expected = 0.75;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorBlendAmountProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.ColorBlendAmountPropertyName, expected);
    }

    @Test
    public final void testScale() {
        final double expected = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeScaleProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.ScalePropertyName, expected);
    }

    @Test
    public final void testMinimumPixelSize() {
        final double expected = 16.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeMinimumPixelSizeProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.MinimumPixelSizePropertyName, expected);
    }

    @Test
    public final void testMaximumScale() {
        final double expected = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeMaximumScaleProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.MaximumScalePropertyName, expected);
    }

    @Test
    public final void testIncrementallyLoadTextures() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeIncrementallyLoadTexturesProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.IncrementallyLoadTexturesPropertyName, expected);
    }

    @Test
    public final void testRunAnimations() {
        final boolean expected = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeRunAnimationsProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.RunAnimationsPropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1234.0, 5678.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(ModelCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    private final void assertPropertyJson(String propertyName, Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<ModelCesiumWriter> createPropertyWriter(String propertyName) {
        return new ModelCesiumWriter(propertyName);
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