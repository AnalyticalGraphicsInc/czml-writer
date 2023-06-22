package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConvertHelper;
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
public class TestPolylineDashMaterialCesiumWriter extends TestCesiumPropertyWriter<PolylineDashMaterialCesiumWriter> {
    @Test
    public final void testWritePolylineDashMaterial() {
        Color expectedColor = Color.RED;
        int expectedDashPattern = ConvertHelper.toInt32("0011001100110011", 2);
        Color expectedGapColor = Color.BLUE;
        final double expectedDashLength = 25.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(getPacket().openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineMaterialCesiumWriter> using$2 = new Using<PolylineMaterialCesiumWriter>(polyline.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$2.resource;
                    try (Using<PolylineDashMaterialCesiumWriter> using$3 = new Using<PolylineDashMaterialCesiumWriter>(material.openPolylineDashProperty())) {
                        final PolylineDashMaterialCesiumWriter polylineDashMaterial = using$3.resource;
                        polylineDashMaterial.writeColorProperty(expectedColor);
                        polylineDashMaterial.writeDashPatternProperty(expectedDashPattern);
                        polylineDashMaterial.writeGapColorProperty(expectedGapColor);
                        polylineDashMaterial.writeDashLengthProperty(expectedDashLength);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.ColorPropertyName, expectedColor);
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.DashPatternPropertyName, expectedDashPattern);
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.GapColorPropertyName, expectedGapColor);
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.DashLengthPropertyName, expectedDashLength);
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.PolylineDashPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PolylineDashMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineDashMaterialCesiumWriter(propertyName);
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