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
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testGltfProperty() {
        final String expectedGltf = "test.gltf";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeGltfProperty(expectedGltf, CesiumResourceBehavior.LINK_TO);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.GltfPropertyName, expectedGltf);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testSilhouetteColorProperty() {
        Color expectedSilhouetteColor = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeSilhouetteColorProperty(expectedSilhouetteColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.SilhouetteColorPropertyName, expectedSilhouetteColor);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testSilhouetteSizeProperty() {
        final double expectedSilhouetteSize = 0.75;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeSilhouetteSizeProperty(expectedSilhouetteSize);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.SilhouetteSizePropertyName, expectedSilhouetteSize);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorProperty() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expectedColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ColorPropertyName, expectedColor);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorBlendModeProperty() {
        final CesiumColorBlendMode expectedColorBlendMode = CesiumColorBlendMode.REPLACE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorBlendModeProperty(expectedColorBlendMode);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ColorBlendModePropertyName, expectedColorBlendMode);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorBlendAmountProperty() {
        final double expectedColorBlendAmount = 0.75;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorBlendAmountProperty(expectedColorBlendAmount);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ColorBlendAmountPropertyName, expectedColorBlendAmount);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testScaleProperty() {
        final double expectedScale = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeScaleProperty(expectedScale);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ScalePropertyName, expectedScale);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testMinimumPixelSizeProperty() {
        final double expectedMinimumPixelSize = 16.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeMinimumPixelSizeProperty(expectedMinimumPixelSize);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.MinimumPixelSizePropertyName, expectedMinimumPixelSize);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testMaximumScaleProperty() {
        final double expectedMaximumScale = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeMaximumScaleProperty(expectedMaximumScale);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.MaximumScalePropertyName, expectedMaximumScale);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testIncrementallyLoadTexturesProperty() {
        final boolean expectedIncrementallyLoadTextures = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeIncrementallyLoadTexturesProperty(expectedIncrementallyLoadTextures);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.IncrementallyLoadTexturesPropertyName, expectedIncrementallyLoadTextures);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testRunAnimationsProperty() {
        final boolean expectedRunAnimations = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeRunAnimationsProperty(expectedRunAnimations);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.RunAnimationsPropertyName, expectedRunAnimations);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testShadowsProperty() {
        final CesiumShadowMode expectedShadows = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expectedShadows);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ShadowsPropertyName, expectedShadows);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testHeightReferenceProperty() {
        final CesiumHeightReference expectedHeightReference = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expectedHeightReference);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.HeightReferencePropertyName, expectedHeightReference);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testDistanceDisplayConditionProperty() {
        Bounds expectedBounds = new Bounds(1234.0, 5678.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expectedBounds);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds);
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