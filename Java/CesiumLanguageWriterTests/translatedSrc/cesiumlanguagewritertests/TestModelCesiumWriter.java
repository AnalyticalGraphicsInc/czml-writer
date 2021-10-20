package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.LinkedHashMap;
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
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testGltfProperty() {
        final String expectedGltf = "test.gltf";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeGltfProperty(expectedGltf, CesiumResourceBehavior.LINK_TO);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.GltfPropertyName, expectedGltf);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testSilhouetteColorProperty() {
        Color expectedSilhouetteColor = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeSilhouetteColorProperty(expectedSilhouetteColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.SilhouetteColorPropertyName, expectedSilhouetteColor);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testSilhouetteSizeProperty() {
        final double expectedSilhouetteSize = 0.75;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeSilhouetteSizeProperty(expectedSilhouetteSize);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.SilhouetteSizePropertyName, expectedSilhouetteSize);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorProperty() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expectedColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ColorPropertyName, expectedColor);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorBlendModeProperty() {
        final CesiumColorBlendMode expectedColorBlendMode = CesiumColorBlendMode.REPLACE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorBlendModeProperty(expectedColorBlendMode);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ColorBlendModePropertyName, CesiumFormattingHelper.colorBlendModeToString(expectedColorBlendMode));
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorBlendAmountProperty() {
        final double expectedColorBlendAmount = 0.75;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<ModelCesiumWriter> using$2 = new Using<ModelCesiumWriter>(model.openInterval())) {
                    final ModelCesiumWriter interval = using$2.resource;
                    interval.writeColorBlendAmountProperty(expectedColorBlendAmount);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ColorBlendAmountPropertyName, expectedColorBlendAmount);
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