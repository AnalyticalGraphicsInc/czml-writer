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
public class TestPolylineGlowMaterialCesiumWriter extends TestCesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> {
    @Test
    public final void testWritePolylineGlowMaterial() {
        Color expectedColor = Color.RED;
        final double expectedGlowPower = 0.7;
        final double expectedTaperPower = 0.2;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(getPacket().openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineMaterialCesiumWriter> using$2 = new Using<PolylineMaterialCesiumWriter>(polyline.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$2.resource;
                    try (Using<PolylineGlowMaterialCesiumWriter> using$3 = new Using<PolylineGlowMaterialCesiumWriter>(material.openPolylineGlowProperty())) {
                        final PolylineGlowMaterialCesiumWriter polylineGlowMaterial = using$3.resource;
                        polylineGlowMaterial.writeColorProperty(expectedColor);
                        polylineGlowMaterial.writeGlowPowerProperty(expectedGlowPower);
                        polylineGlowMaterial.writeTaperPowerProperty(expectedTaperPower);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, PolylineGlowMaterialCesiumWriter.ColorPropertyName, expectedColor);
        MapHelper.add(tempCollection$2, PolylineGlowMaterialCesiumWriter.GlowPowerPropertyName, expectedGlowPower);
        MapHelper.add(tempCollection$2, PolylineGlowMaterialCesiumWriter.TaperPowerPropertyName, expectedTaperPower);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.PolylineGlowPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineGlowMaterialCesiumWriter(propertyName);
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